package org.castiello.nogle.match.setting.vo;

import java.util.concurrent.ThreadLocalRandom;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EngineConnectionConfigVo {

	private MatchServerType matchServerType;

	private String serverConnectionString;

	private final long poolId;

	public EngineConnectionConfigVo() {
		this.poolId = Math.abs(ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, Long.MAX_VALUE));
	}

	public static enum MatchServerNode {
		SPOT,
		FUTURES,
		TRADESERVER,
	}

	public static enum MatchServerType {
		TRADE,
		QUERY,
		TRADEFILLS,
	}
}
