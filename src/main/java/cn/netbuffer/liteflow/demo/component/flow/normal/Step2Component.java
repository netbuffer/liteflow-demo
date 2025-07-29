package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
@LiteflowComponent(name = "step2")
public class Step2Component extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.debug("step2 process");
        Boolean randomError = RandomUtils.nextBoolean();
        log.debug("randomError={}", randomError);
        String errorMessage = "random error occur";
        if (randomError) {
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        DefaultContext context = this.getContextBean(DefaultContext.class);
        context.setData("step2", RandomStringUtils.random(10, true, true));
    }

    /**
     * 组件内逻辑运行出错是否继续往下执行下一个组件
     * @return
     */
    @Override
    public boolean isContinueOnError() {
        return false;
    }

    @Override
    public void onSuccess() throws Exception {
        DefaultContext context = this.getContextBean(DefaultContext.class);
        log.debug("step2 onSuccess callback");
    }

    @Override
    public void onError(Exception e) throws Exception {
        DefaultContext context = this.getContextBean(DefaultContext.class);
        log.debug("step2 onError callback");
    }

}
