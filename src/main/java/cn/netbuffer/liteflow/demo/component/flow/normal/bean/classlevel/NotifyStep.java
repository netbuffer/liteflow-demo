package cn.netbuffer.liteflow.demo.component.flow.normal.bean.classlevel;

import com.yomahub.liteflow.annotation.LiteflowCmpDefine;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import com.yomahub.liteflow.slot.Slot;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowCmpDefine
@LiteflowComponent("notifyStep")
public class NotifyStep {

    @LiteflowMethod(LiteFlowMethodEnum.PROCESS)
    public void process(NodeComponent bindCmp) {
        log.debug("process execute bindCmp={}", bindCmp);
        log.debug("notify step execute");
    }

    @LiteflowMethod(LiteFlowMethodEnum.IS_ACCESS)
    public boolean isAccess(NodeComponent bindCmp) {
        log.debug("isAccess execute");
        return true;
    }

    @LiteflowMethod(LiteFlowMethodEnum.BEFORE_PROCESS)
    public void beforeProcess(String nodeId, Slot slot) {
        log.debug("beforeProcess execute nodeId={} slot={}", nodeId, slot);
    }

    @LiteflowMethod(LiteFlowMethodEnum.AFTER_PROCESS)
    public void afterProcess(String nodeId, Slot slot) {
        log.debug("afterProcess execute nodeId={} slot={}", nodeId, slot);
    }

    @LiteflowMethod(LiteFlowMethodEnum.ON_SUCCESS)
    public void onSuccess(NodeComponent bindCmp) {
        log.debug("onSuccess execute");
    }

    @LiteflowMethod(LiteFlowMethodEnum.ON_ERROR)
    public void onError(NodeComponent bindCmp) {
        log.debug("onError execute");
    }

    @LiteflowMethod(LiteFlowMethodEnum.IS_END)
    public boolean isEnd(NodeComponent bindCmp) {
        log.debug("isEnd execute");
        return false;
    }

}