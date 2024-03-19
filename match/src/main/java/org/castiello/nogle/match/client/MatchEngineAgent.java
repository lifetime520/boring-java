package org.castiello.nogle.match.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.castiello.nogle.match.setting.vo.EngineConnectionConfigVo;
import org.castiello.nogle.match.setting.vo.EngineConnectionConfigVo.MatchServerNode;
import org.castiello.nogle.match.setting.vo.EngineConnectionConfigVo.MatchServerType;
import org.castiello.nogle.match.setting.vo.MatchEngineSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.btse.match.client.BTSEClient;
import com.btse.match.common.CustomResponseHandler;
import com.btse.match.common.LargePacket;
import com.btse.match.common.MarketInfo;
import com.btse.match.common.Notification;
import com.btse.match.common.OrderPacket;
import com.btse.match.common.Packet;
import com.btse.match.common.QueryResponse;
import com.btse.match.general.BTSEConstants;
import com.btse.match.general.helper.QueryResponseHelper;
import com.btse.match.thread.ScalingThreadPoolExecutor;
import com.btse.match.util.Utils;
import com.esotericsoftware.kryonet.Connection;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class MatchEngineAgent {

	private final int minThreads = 2;
	private final int maxThreads = 6;
	private final int timeout = 3000;
	private ScalingThreadPoolExecutor agentExecutor = new ScalingThreadPoolExecutor("agentExecutor", minThreads, maxThreads, 60, TimeUnit.SECONDS);

	private final Map<MatchServerNode, BTSEClient> clientMap = new HashMap<>();
	private final Map<Long, Object> monitor = new ConcurrentHashMap<>();
	protected final Map<Long, Consumer<Object>> requestSubscribleMap = new ConcurrentHashMap<>();
	protected final Map<Class<?>, Map<Long, Consumer<Object>>> classSubscribleMap = new ConcurrentHashMap<>();
	protected final Supplier<Long> trackingGen = () -> Utils.getRandomLong(Integer.MAX_VALUE + 1, 0x3fffffffffffffffL);

	@Autowired
	MatchEngineSettings matchEngineSettings;

	public MatchEngineAgent() {}

	@PostConstruct
	public void setMatchEngineSettings() {
		log.info("[MN:setMatchEngineSettings] {}", JSON.toJSONString(matchEngineSettings));
		matchEngineSettings.getMatchEngineConfigObjectMap().entrySet().forEach(e -> {
			this.registMatchEngineClient(e.getKey(), e.getValue());
		});
	}

	public BTSEClient getBtseClient(MatchServerNode node) {
		return clientMap.get(node);
	}

	public synchronized void registMatchEngineClient(MatchServerNode matchServerNode, List<EngineConnectionConfigVo> connectionConfigList) {
		BTSEClient client = null;
		synchronized (clientMap) {
			if (this.clientMap.containsKey(matchServerNode))
				return;
			client = this.clientMap.computeIfAbsent(matchServerNode, k -> new BTSEClient());
		}

		log.info("[MN:registMatchEngineClient] {} {}", JSON.toJSONString(matchServerNode), JSON.toJSONString(connectionConfigList));
		switch (matchServerNode) {
		case SPOT:
		case FUTURES:
			for (EngineConnectionConfigVo config : connectionConfigList) {
				if (config.getMatchServerType() == MatchServerType.QUERY)
					client.registerQueryClient(matchServerNode.name() + "-Query", config.getPoolId(), config.getServerConnectionString(), new QueryResponseHandler(), false);
				else if (config.getMatchServerType() == MatchServerType.TRADE)
					client.registerTradeClient(matchServerNode.name() + "-Trade", config.getPoolId(), config.getServerConnectionString(), new TradeResponseHandler(), false);
			}
			client.setPacketMonitor((ConcurrentHashMap<Long, Object>) monitor);

			Thread monitorThread = new Thread() {
				public void run() {
					while (true) {
						checkTimeoutQueries(monitor);
						try {
							sleep(timeout);
						} catch (InterruptedException e) {
						}
					}
				}
			};
			monitorThread.start();
			clientMap.put(matchServerNode, client);
			break;
		case TRADESERVER:
			break;
		default:
			log.info("[MN:registMatchEngineClient][default] {}", JSON.toJSONString(matchServerNode), JSON.toJSONString(connectionConfigList));

		}
	}

	private void checkTimeoutQueries(Map<Long, Object> map) {
		long currentTime = System.currentTimeMillis();
		for (Iterator<Entry<Long, Object>> it = map.entrySet().iterator(); it.hasNext(); ) {
			Map.Entry<Long, Object> entry = (Map.Entry<Long, Object>) it.next();
			Packet p = (Packet) entry.getValue();
			if (currentTime - p.getPacketTimestamp() > timeout) {
				if (entry.getValue() instanceof OrderPacket && ((OrderPacket) entry.getValue()).getUsername() != null) {
					log.info("NO_REPLY " + JSON.toJSONString(entry.getValue()));
				}
				it.remove();
				if (requestSubscribleMap.remove(p.getPacketID()) != null) {
					log.info("[UnSubscrible] remove disposableSubscrible by packetId: {}", p.getPacketID());
				}
			}
		}
	}

	/**
	 * 長期事件，類別註冊
	 * @param <T>
	 * @param clazz
	 * @param consumer
	 */
	public <T> Long registClassSubscrible(Class<T> clazz, Consumer<Object> consumer) {
		final Long subscribleKey = trackingGen.get();
		classSubscribleMap.compute(clazz, (k ,v) -> v == null ? new ConcurrentHashMap<>() : v).put(subscribleKey, consumer);
		return subscribleKey;
	}

	/**
	 * 一次性事件
	 * @param trackingId
	 * @param consumer
	 */
	public void registRequestSubscrible(Packet pkg, Consumer<Object> consumer) {
		requestSubscribleMap.put(pkg.getId(), consumer);
	}

	private void eventSubscribleExcutor(Object object) {
		if (object instanceof Packet) {
			Consumer<Object> consumer = requestSubscribleMap.remove(((Packet) object).getPacketID());
			if (consumer != null) {
				consumer.accept(object);
			}
		}
		Map<Long, Consumer<Object>> classConsumer = null;
		if ((classConsumer = classSubscribleMap.get(object.getClass())) != null) {
			classConsumer.values().forEach(innerConsumer -> {
				Runnable r = () -> {
					try {
						innerConsumer.accept(object);
					}catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				};
				agentExecutor.execute(r);
			});
		}
	}


	protected boolean removeMonitor(Object networkObj) {
		if (networkObj instanceof Packet) {
			Packet p = (Packet) networkObj;
			return this.monitor.remove(p.getPacketID()) != null;
		}
		return false;
	}


	class TradeResponseHandler extends MakerResponseHandler {

		@Override
		public void execute(Connection connection, Object object) {
			try {

				Runnable task = () -> {
					if (removeMonitor(object)) {
						processTracingNetworkObject(object);
					}
					eventSubscribleExcutor(object);
				};
				executor.execute(task);
//				taskExecutor.execute(() -> processEventSubscrible(object));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	class QueryResponseHandler extends MakerResponseHandler {

		@Override
		public void execute(Connection connection, Object object) {
			try {
				Runnable task = () -> {
					if (removeMonitor(object)) {
						processTracingNetworkObject(object);
					}
					eventSubscribleExcutor(object);
				};
				executor.execute(task);
//				queryExecutor.execute(() -> processEventSubscrible(object));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class MakerResponseHandler extends CustomResponseHandler {
		protected ScalingThreadPoolExecutor executor = new ScalingThreadPoolExecutor("ResponseExecutor", minThreads, maxThreads, 60, TimeUnit.SECONDS);

		@Override
		public void execute(Connection arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void forward(Connection arg0, LargePacket arg1) {
			// TODO Auto-generated method stub
			
		}

		protected void processTracingNetworkObject(Object object) {
			if (object instanceof Packet) {
//				System.out.println(object.getClass() + " " + JSON.toJSONString(object));
				if (object instanceof Notification) {
					processNotification((Notification) object);
				} else if (object instanceof QueryResponse) {
					processQueryResponse((QueryResponse) object);
				}
//				else if (object instanceof UserPacket) {
//					UserPacket userPacket = (UserPacket) object;
//					processUserQuery(userPacket);
//				}
				else if (object instanceof MarketInfo) {
					MarketInfo userPacket = (MarketInfo) object;
					log.info("[MARKET] UPDATE " + JSON.toJSON(userPacket));
//				} else if (object instanceof OTCOrder) {
//					processOTCOrder((OTCOrder) object);
				} else
					log.info(object.getClass().getName() + " - " + JSON.toJSON(object));
			}
		}

		public void processNotification(Notification notification) {
			if (notification.getUsername() != null)
				log.info("N: " + notification.getUsername() + " " + BTSEConstants.lookup(notification.getStatus()) + " " + notification.getPacketID() + " " + JSON.toJSON(notification));
		}

		protected void processQueryResponse(QueryResponse response) {
			if (response.getQueryType() == BTSEConstants.QUERY_GET_ALL_POSITIONS_ORDERS || response.getQueryType() == BTSEConstants.QUERY_GET_ORDERS || response.getQueryType() == BTSEConstants.QUERY_GET_ORDERS_STATUS || response.getQueryType() == BTSEConstants.ADM_QUERY || response.getQueryType() == BTSEConstants.ADM_QUERY_NON_SYSTEM_SUM || response.getQueryType() == BTSEConstants.QUERY_GET_ORDERS_WITH_LIMIT || response.getQueryType() == BTSEConstants.QUERY_GET_ORDERS_STATUS_BY_ORDERIDS || response.getQueryType() == BTSEConstants.QUERY_GET_ORDERS_STATUS_BY_CLORDERIDS || response.getQueryType() == BTSEConstants.QUERY_GET_TWAP_ORDERS || response.getQueryType() == BTSEConstants.QUERY_GET_TWAP_ALL_MARKET_ORDERS || response.getQueryType() == BTSEConstants.QUERY_GET_POSITIONS) {
				ArrayList<OrderPacket> list = QueryResponseHelper.getOrderList(response);
				for (OrderPacket p : list) {
					if (p.isFuture() && p.getOrderType() == BTSEConstants.TYPE_FUTURES_POSITION)
						log.info("POSITION: " + p.getPositionId() + " - " + p.getUsername() + " " + BTSEConstants.lookup(p.getOrderMode()) + " mode:" + p.getPositionMode() + " contracts:" + p.getTotalContracts() + " entryPrice:" + p.getEntryPrice() + " markPrice: " + p.getMarkedPrice() + " liqPrice:" + p.getLiquidationPrice() + " bankPrice:" + p.getBankruptcyPrice() + " maintenanceMargin:" + p.getTotalMaintenanceMargin() + " leverage:" + p.getIsolatedLeverage() + " fees:" + p.getTotalFees() + " unrealizedPnL:" + p.getUnrealizedProfitLoss() + " liqInProgress:" + p.isLiquidationInProgress() + " ADLscore " + p.getAdlScoreBucket());
					else if (p.isFuture() && p.isOtoPendingSecondaryOrder())
						log.info("PENDING: " + p.getUsername() + " VIEW:" + response.getAssetName() + " " + BTSEConstants.lookup(p.getOrderMode()) + " quote:" + p.getQuoteCurrency() + " " + p.getPrice() + " size:" + p.getAmount() + " market:" + p.getMarketName() + " value " + p.getCurrentOrderValueUserCurrency() + " rate:" + p.getExchangeRate() + " isTrigger " + p.isTriggerOrder() + " TP: " + p.getTriggerOriginalPrice() + "(" + p.getTriggerPrice() + ")" + "  stop/take profit: " + p.getTriggerOrderType() + " oco:" + p.getOcoLimitOrderID() + " " + JSON.toJSON(p));
					else
						log.info("OPEN: " + p.getUsername() + " VIEW:" + response.getAssetName() + " " + BTSEConstants.lookup(p.getOrderMode()) + " " + p.getPositionId() + " quote:" + p.getQuoteCurrency() + " " + p.getPrice() + " size:" + p.getAmount() + " market:" + p.getMarketName() + " positionId:" + p.getPositionId() + " positionMode:" + p.getPositionMode()  + " value " + p.getCurrentOrderValueUserCurrency() + " rate:" + p.getExchangeRate() + " isTrigger " + p.isTriggerOrder() + " TP: " + p.getTriggerOriginalPrice() + "(" + p.getTriggerPrice() + ")" + "  stop/take profit: " + p.getTriggerOrderType() + " oco:" + p.getOcoLimitOrderID() + " " + JSON.toJSON(p));
				}
			} else if (response.getQueryType() == BTSEConstants.QUERY_FUTURES_MARGIN) {
				for (QueryResponse r : response.getResponses())
					if (r.getPositions() != null)
						for (OrderPacket p : r.getPositions()) {
							log.info("POSITION: " + p.getPositionId() + " - " + p.getUsername() + " " + BTSEConstants.lookup(p.getOrderMode()) + " mode:" + p.getPositionMode() + " contracts:" + p.getTotalContracts() + " entryPrice:" + p.getEntryPrice() + " markPrice: " + p.getMarkedPrice() + " liqPrice:" + p.getLiquidationPrice() + " bankPrice:" + p.getBankruptcyPrice() + " maintenanceMargin:" + p.getTotalMaintenanceMargin() + " leverage:" + p.getIsolatedLeverage() + " fees:" + p.getTotalFees() + " unrealizedPnL:" + p.getUnrealizedProfitLoss() + " liqInProgress:" + p.isLiquidationInProgress() + " ADLscore " + p.getAdlScoreBucket());
						}
			} else {
				log.info("R: " + response.getUsername() + " " + BTSEConstants.lookup(response.getQueryType()) + ((response.getQueryType() == BTSEConstants.QUERY_WALLET) ? "-" + response.getActiveWalletName() : " ") + JSON.toJSON(response));
				if (response.getQueryType() != BTSEConstants.QUERY_MARKET_PRICES && response.getQueryType() != BTSEConstants.QUERY_FUTURES_STATS)
					;
			}
		}
	}
}
