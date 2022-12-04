package cn.netbuffer.liteflow.demo.component.flow.select;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
@LiteflowComponent("paySwitchStep")
public class PaySwitchComponent extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        Boolean payStatus = RandomUtils.nextBoolean();
        log.debug("pay status={}", payStatus);
        String returnStep;
        if (payStatus) {
            returnStep = "paySuccessStep";
        } else {
            returnStep = "payFailStep";
        }
        log.debug("select component={}", returnStep);
        return returnStep;
    }

}
