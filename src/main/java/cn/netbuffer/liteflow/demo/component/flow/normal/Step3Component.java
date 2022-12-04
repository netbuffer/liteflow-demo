package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

@Slf4j
@LiteflowComponent(name = "step3")
public class Step3Component extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.debug("step3 process");
        DefaultContext context = this.getContextBean(DefaultContext.class);
        context.setData("step3", RandomStringUtils.random(10, true, true));
    }

}
