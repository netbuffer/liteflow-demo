package cn.netbuffer.liteflow.demo.component.flow.bool;

import com.yomahub.liteflow.core.NodeBooleanComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component("decisionBooleanComponent")
public class DecisionBooleanComponent extends NodeBooleanComponent {
    @Override
    public boolean processBoolean() throws Exception {
        boolean bool = RandomUtils.nextBoolean();
        log.debug("decisionBooleanComponent processBoolean return {}", bool);
        return bool;
    }
}