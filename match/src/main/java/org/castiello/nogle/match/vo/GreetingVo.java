package org.castiello.nogle.match.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingVo {

	private String content;

	public GreetingVo(String content) {
		this.content = "ECHO:" + content;
	}
}
