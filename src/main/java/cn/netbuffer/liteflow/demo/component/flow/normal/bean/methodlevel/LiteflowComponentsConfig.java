package cn.netbuffer.liteflow.demo.component.flow.normal.bean.methodlevel;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import com.yomahub.liteflow.enums.NodeTypeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent
public class LiteflowComponentsConfig {

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "hello", nodeType = NodeTypeEnum.COMMON)
    public void processHello(NodeComponent bindCmp) {
        log.debug("process hello component based method");
    }

}
