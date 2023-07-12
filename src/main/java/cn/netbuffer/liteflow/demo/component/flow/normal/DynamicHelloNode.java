package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicHelloNode extends NodeComponent {

    public DynamicHelloNode() {
        log.debug("build DynamicHelloNode");
    }

    @Override
    public void process() throws Exception {
        log.debug("dynamic hello node execute");
    }

}
