package org.castiello.nogle.match.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloMessageVo {

	private String name;

	public HelloMessageVo(String name) {
		this.name = name;
	}
}
