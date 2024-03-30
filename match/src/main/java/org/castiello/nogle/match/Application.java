package org.castiello.nogle.match;

import java.util.ArrayList;
import java.util.List;

import org.castiello.nogle.match.client.MatchEngineAgent;
import org.castiello.nogle.match.setting.vo.EngineConnectionConfigVo.MatchServerNode;
import org.castiello.nogle.match.setting.vo.MatchEngineSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.btse.match.common.MarketInfo;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
@EnableAutoConfiguration
public class Application {

	// -Dpath=/Users/castiello.tsai/WorkSpace/Nogle/GitLab
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		System.setProperty("path", "/Users/castiello.tsai/WorkSpace/Nogle/GitLab");
		ApplicationContext context = SpringApplication.run(Application.class, args);
		MatchEngineSettings engineConfig = context.getBean(MatchEngineSettings.class);
		log.info("matchEngineConfigObjectMap:{}", engineConfig.getMatchEngineConfigObjectMap());
		MatchEngineAgent engineAgent = context.getBean(MatchEngineAgent.class);
		try {
			engineAgent.getBtseClient(MatchServerNode.SPOT);
			while (true) {
				Thread.currentThread().sleep(5 * 1000);
				engineAgent.registClassSubscrible(MarketInfo[].class, (p) -> {
					if (p instanceof MarketInfo[]) {
						List<MarketInfo> disableMarketList = new ArrayList<>();
						List<MarketInfo> enableMarketList = new ArrayList<>();
						for (MarketInfo infoVo : ((MarketInfo[]) p)) {
							if (!infoVo.isActive()) {
								disableMarketList.add(infoVo);
							} else {
								enableMarketList.add(infoVo);
							}
						}
						log.info("{} Active MarketInfo: {}", enableMarketList.size(), enableMarketList);
						log.info("{} Inactive MarketInfo: {}", disableMarketList.size(), disableMarketList);
					}
				});
				MarketInfo info = new MarketInfo();
				info.setPoolID(engineAgent.getBtseClient(MatchServerNode.SPOT).getQueryPool().getPoolID());
				engineAgent.getBtseClient(MatchServerNode.SPOT).sendQuery(info);
				info.setPoolID(engineAgent.getBtseClient(MatchServerNode.FUTURES).getQueryPool().getPoolID());
				engineAgent.getBtseClient(MatchServerNode.FUTURES).sendQuery(info);
			}
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
	}

}
