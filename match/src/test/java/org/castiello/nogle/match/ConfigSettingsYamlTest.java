//package org.castiello.nogle.match;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.castiello.nogle.match.dto.EngineConnectionConfig.MatchServerNode;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//public class ConfigSettingsYamlTest {
//
//	@Autowired
//	private MatchEngineSettings matchEngineSettings;
//
//	@Test
//	public void whenYamlFileProvidedThenInjectSimpleMap() {
//		assertThat(matchEngineSettings.getMatchEngineConfigObjectMap())
//		  .containsOnlyKeys(MatchServerNode.SPOT, MatchServerNode.FUTURES, MatchServerNode.TRADESERVER);
//	}
//}
