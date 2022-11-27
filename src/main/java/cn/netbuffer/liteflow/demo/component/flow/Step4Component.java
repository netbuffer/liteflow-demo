package cn.netbuffer.liteflow.demo.component.flow;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent(name = "step4")
public class Step4Component extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.debug("step4 process");
    }

}
