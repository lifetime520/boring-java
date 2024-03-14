package org.castiello.nogle.match.setting.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.castiello.nogle.match.setting.vo.EngineConnectionConfigVo.MatchServerNode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "btse")
@Getter
@Setter
public class MatchEngineSettings {

    private final Map<MatchServerNode, List<EngineConnectionConfigVo>> matchEngineConfigObjectMap = new HashMap<>();

}
