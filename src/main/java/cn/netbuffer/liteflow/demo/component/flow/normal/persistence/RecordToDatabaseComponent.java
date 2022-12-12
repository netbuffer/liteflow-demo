package cn.netbuffer.liteflow.demo.component.flow.normal.persistence;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
@LiteflowComponent(name = "recordToDatabaseComponent")
public class RecordToDatabaseComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        boolean isSuccess = RandomUtils.nextBoolean();
        if (!isSuccess) {
            log.debug("process error");
            throw new RuntimeException("record to database occurred error");
        }
        log.debug("process success");
    }

}
