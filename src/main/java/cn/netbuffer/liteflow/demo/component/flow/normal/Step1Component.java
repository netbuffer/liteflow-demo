package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.alibaba.fastjson2.JSONObject;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
@LiteflowComponent(name = "step1")
public class Step1Component extends NodeComponent {

    @Override
    public boolean isAccess() {
        Boolean isAccess = RandomUtils.nextBoolean();
        log.debug("step1 isAccess return {}", isAccess);
        return isAccess;
    }

    @Override
    public void process() throws Exception {
        JSONObject param = this.getRequestData();
        String tag = this.getTag();
        Long currChainRuntimeId = this.getCurrChainRuntimeId();
        log.debug("step1 process args={} chain={} tag={} currChainRuntimeId={}", param, this.getChainId(), tag, currChainRuntimeId);
    }

}
