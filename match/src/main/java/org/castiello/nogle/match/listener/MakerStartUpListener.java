package org.castiello.nogle.match.listener;

import org.castiello.nogle.match.Application;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MakerStartUpListener {

	@EventListener(ApplicationReadyEvent.class)
	public void queryMarketInfos() {
		log.info("Query Market Info");
	}

	@EventListener(ApplicationReadyEvent.class)
	public void queryIndexPrice() {
		log.info("Query Market Info");
	}

	@EventListener(ApplicationReadyEvent.class)
	public void queryMakerOrders() {
		log.info("Query Market Info");
	}

	@EventListener(ApplicationReadyEvent.class)
	public void queryMakerPosition() {
		log.info("Query Market Info");
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		log.info("Query Market Info");
	}
}
