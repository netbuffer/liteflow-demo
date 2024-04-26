package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

@Slf4j
@LiteflowComponent(name = "持久化规则引擎计算值到数据库层", value = "pvnc")
public class PersistenceValueNodeComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.debug("persistence value to db");
        String chainId = this.getChainId();
        DefaultContext context = this.getContextBean(DefaultContext.class);
        this.getRequestData();
        Map<String, Object> out = context.getData("out");
        for (Map.Entry<String, Object> entry : out.entrySet()) {
            log.debug("Key: " + entry.getKey() + ", Value: " + entry.getValue() + ", Value Type: " + entry.getValue().getClass().getName());
        }
        log.debug("get lf chain[{}] out[{}] data={}", chainId, out.getClass().getSimpleName(), out);
    }

}
