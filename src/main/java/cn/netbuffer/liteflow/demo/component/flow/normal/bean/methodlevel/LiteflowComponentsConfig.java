package cn.netbuffer.liteflow.demo.component.flow.normal.bean.methodlevel;

import com.alibaba.fastjson2.JSONObject;
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
        JSONObject data = bindCmp.getCmpData(JSONObject.class);
        log.debug("get hello component config data={} key[name]={}", data, data.getString("name"));
        log.debug("get hello component tag={}", bindCmp.getTag());
    }

}
