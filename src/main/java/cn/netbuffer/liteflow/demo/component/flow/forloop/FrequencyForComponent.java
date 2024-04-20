package cn.netbuffer.liteflow.demo.component.flow.forloop;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeForComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
@LiteflowComponent("frequencyForComponent")
public class FrequencyForComponent extends NodeForComponent {
    @Override
    public int processFor() throws Exception {
        int frequency = RandomUtils.nextInt(1, 10);
        log.debug("frequency={}", frequency);
        return frequency;
    }
}
