package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent(name = "payFailStep")
public class PayFailStep extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.debug("process pay fail");
    }

}
