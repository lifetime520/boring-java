package org.castiello.nogle.match.listener;

import org.castiello.nogle.match.client.MatchEngineAgent;
import org.castiello.nogle.match.po.MarketDataPo;
import org.castiello.nogle.match.repos.MarketDataRepository;
import org.castiello.nogle.match.setting.vo.EngineConnectionConfigVo.MatchServerNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.btse.match.common.MarketInfo;

import lombok.extern.log4j.Log4j2;

/**
 * ApplicationFailedEvent：该事件为spring boot启动失败时的操作
 * ApplicationPreparedEvent：上下文context准备时触发
 * ApplicationReadyEvent：上下文已经准备完毕的时候触发
 * ApplicationStartedEvent：spring boot 启动监听类
 * SpringApplicationEvent：获取SpringApplication
 * ApplicationEnvironmentPreparedEvent：环境事先准备
 * @author castiello.tsai
 *
 */
@Log4j2
@Component
public class MakerStartUpListener {

	@Autowired
	private MatchEngineAgent engineAgent;
	@Autowired
	private MarketDataRepository marketDataRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void doMakerInitialize() {
		log.info("Query Market Info");
		log.info("Query Index/Marked Price Info");
		log.info("Query Market Order");
		log.info("Query Market Position");
		log.info("Query Wallet");
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doApplicationReadyEvent() {
		try {
			engineAgent.registClassSubscrible(MarketInfo[].class, (p) -> {
				if (p instanceof MarketInfo[]) {
					for (MarketInfo infoVo : ((MarketInfo[]) p)) {
						MarketDataPo po = marketDataRepository.findByName(infoVo.getName());
						if (po == null) {
							po = new MarketDataPo();
							po.setMarketInfo(infoVo);
						} else {
							po.updateMarketInfo(infoVo);
						}
						marketDataRepository.save(po);
					}
				}
			});
			MarketInfo info = new MarketInfo();
			info.setPoolID(engineAgent.getBtseClient(MatchServerNode.SPOT).getQueryPool().getPoolID());
			engineAgent.getBtseClient(MatchServerNode.SPOT).sendQuery(info);
			info.setPoolID(engineAgent.getBtseClient(MatchServerNode.FUTURES).getQueryPool().getPoolID());
			engineAgent.getBtseClient(MatchServerNode.FUTURES).sendQuery(info);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		log.info("doApplicationReadyEvent");
	}

	@EventListener(ApplicationPreparedEvent.class)
	public void doApplicationPreparedEvent() {
		log.info("doApplicationPreparedEvent");
	}

	@EventListener(ApplicationStartedEvent.class)
	public void doApplicationStartedEvent() {
		log.info("doApplicationStartedEvent");
	}

	@EventListener(SpringApplicationEvent.class)
	public void doSpringApplicationEvent() {
		log.info("doSpringApplicationEvent");
	}

	@EventListener(ApplicationEnvironmentPreparedEvent.class)
	public void doApplicationEnvironmentPreparedEvent() {
		log.info("doApplicationEnvironmentPreparedEvent");
	}

	@EventListener(ApplicationFailedEvent.class)
	public void doApplicationFailedEvent() {
		log.info("doApplicationFailedEvent");
	}
}
