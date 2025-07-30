package cn.netbuffer.liteflow.demo.component.flow.normal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.TimeUnit;

@Slf4j
@LiteflowComponent(name = "sleepComponent")
public class SleepComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        int sleep = RandomUtils.nextInt(1, 3);
        TimeUnit.SECONDS.sleep(sleep);
        log.debug("sleepComponent sleep {} seconds", sleep);
    }

}