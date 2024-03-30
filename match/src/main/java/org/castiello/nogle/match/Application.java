package org.castiello.nogle.match;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
@EnableAutoConfiguration
public class Application {

	// -Dpath=/Users/castiello.tsai/WorkSpace/Nogle/GitLab
	public static void main(String[] args) {
		System.setProperty("path", "/Users/castiello.tsai/WorkSpace/Nogle/GitLab");
		ApplicationContext context = SpringApplication.run(Application.class, args);
		log.info("applicationName:{} Ready.", context.getApplicationName());
	}
}
