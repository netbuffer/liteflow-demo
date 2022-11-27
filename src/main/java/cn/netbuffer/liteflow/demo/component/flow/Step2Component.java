package cn.netbuffer.liteflow.demo.component.flow;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
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
    }

    @Override
    public boolean isContinueOnError() {
        return true;
    }

}
