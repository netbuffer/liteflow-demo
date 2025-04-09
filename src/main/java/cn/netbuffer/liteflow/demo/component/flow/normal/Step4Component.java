package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent(name = "step4")
public class Step4Component extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.debug("step4 process");
        DefaultContext context = this.getContextBean(DefaultContext.class);
        String step2Data = context.getData("step2");
        String step3Data = context.getData("step3");
        String tag = this.getTag();
        log.debug("get step2 data={} / step3 data={} tag={}", step2Data, step3Data, tag);
    }

}
