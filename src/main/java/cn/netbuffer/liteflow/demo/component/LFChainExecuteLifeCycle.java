package cn.netbuffer.liteflow.demo.component;

import com.yomahub.liteflow.lifecycle.PostProcessChainExecuteLifeCycle;
import com.yomahub.liteflow.slot.Slot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 每执行一次Chain会调用一次以下方法
 */
@Slf4j
@Component
public class LFChainExecuteLifeCycle implements PostProcessChainExecuteLifeCycle {

    @Override
    public void postProcessBeforeChainExecute(String chainId, Slot slot) {
        //do something
        log.debug("postProcessBeforeChainExecute for chainId:{}", chainId);
    }

    @Override
    public void postProcessAfterChainExecute(String chainId, Slot slot) {
        //do something
        Object response = slot.getResponseData();
        if (response == null) {
            response = new Object();
        }
        log.debug("postProcessAfterChainExecute for chainId:{} response ", chainId, response.getClass().getSimpleName());
    }

}
