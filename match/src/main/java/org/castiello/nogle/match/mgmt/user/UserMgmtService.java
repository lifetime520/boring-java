package org.castiello.nogle.match.mgmt.user;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.castiello.nogle.match.aspect.jpa.UserJpaSaveEventAspect;
import org.castiello.nogle.match.po.MarketDataPo;
import org.castiello.nogle.match.po.User;
import org.castiello.nogle.match.repos.MarketDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class UserMgmtService {

	Map<String, List<MarketDataPo>> userMarketMap = new ConcurrentHashMap<>();

	@Autowired
	private UserJpaSaveEventAspect userJpaSaveEventAspect;
	@Autowired
	private MarketDataRepository marketDataRepository;

	@PostConstruct
	private void init() {
		userJpaSaveEventAspect.subscriber(User.class, (message) -> {
			User user = (User) message;
			userStatusMgmt(user);
		});
	}

	private void userStatusMgmt(User user) {
		if (user == null) return;
		
		log.info("[MN:userStatusMgmt] before updated; user:{}, userMarketMap:{}", user, userMarketMap);
		if (!user.isActive() && userMarketMap.containsKey(user.getUsername())) {
			userMarketMap.remove(user.getUsername());
		} else if (user.isActive() && !userMarketMap.containsKey(user.getUsername())) {
			userMarketMap.put(user.getUsername(), marketDataRepository.findAll());
		}
		log.info("[MN:userStatusMgmt] after updated; user:{}, userMarketMap:{}", user, userMarketMap);
	}
}
