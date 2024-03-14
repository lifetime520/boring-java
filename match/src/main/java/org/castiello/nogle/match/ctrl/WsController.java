package org.castiello.nogle.match.ctrl;

import org.castiello.nogle.match.vo.GreetingVo;
import org.castiello.nogle.match.vo.HelloMessageVo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class WsController {
	
//	private SimpMessagingTemplate SimpMessagingTemplate = new SimpMessagingTemplate(null);

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public GreetingVo greeting(HelloMessageVo msgVo) throws Exception {
		Thread.sleep(1000); // simulated delay
		log.info("[MN:greeting]");
		return new GreetingVo(msgVo.getName());
	}

}
