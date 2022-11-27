package cn.netbuffer.liteflow.demo.component.flow;

import com.alibaba.fastjson.JSONObject;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@LiteflowComponent(name = "step1")
public class Step1Component extends NodeComponent {

    @Override
    public void process() throws Exception {
        JSONObject param = this.getRequestData();
        log.debug("step1 process args={} chain={}", param, this.getChainId());
    }

}
