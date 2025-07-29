package cn.netbuffer.liteflow.demo.component;

import com.yomahub.liteflow.aop.ICmpAroundAspect;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.flow.element.Chain;
import com.yomahub.liteflow.slot.Slot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GlobalLFCmpAspect implements ICmpAroundAspect {

    @Override
    public void beforeProcess(NodeComponent nodeComponent) {
        //before business
        Slot slot = nodeComponent.getSlot();
        Chain chain = slot.getCurrentChainInstance(nodeComponent.getCurrChainId());
        String tag = nodeComponent.getTag();
        Object contextBean = nodeComponent.getFirstContextBean();
        log.debug("before process chain={},node={},tag={}", nodeComponent.getCurrChainId(), nodeComponent.getNodeId(), tag);
        log.debug("contextBean={}", contextBean);
    }

    @Override
    public void afterProcess(NodeComponent nodeComponent) {
        //after business
        log.debug("after process chain={},node={}", nodeComponent.getCurrChainId(), nodeComponent.getNodeId());
    }

    @Override
    public void onSuccess(NodeComponent nodeComponent) {
        log.debug("onSuccess chain={},node={}", nodeComponent.getCurrChainId(), nodeComponent.getNodeId());
    }

    @Override
    public void onError(NodeComponent nodeComponent, Exception e) {
        // Log the error message with the current chain ID and node ID
        log.error("onError chain={},node={}", nodeComponent.getCurrChainId(), nodeComponent.getNodeId());
    }

}
