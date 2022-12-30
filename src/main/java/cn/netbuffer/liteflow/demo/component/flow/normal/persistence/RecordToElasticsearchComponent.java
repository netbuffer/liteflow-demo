package cn.netbuffer.liteflow.demo.component.flow.normal.persistence;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import java.util.concurrent.TimeUnit;

@Slf4j
@LiteflowComponent(name = "recordToElasticsearchComponent")
public class RecordToElasticsearchComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.debug("start exec process for elasticsearch");
        log.debug("write to elasticsearch");
        TimeUnit.SECONDS.sleep(RandomUtils.nextInt(3, 10));
        log.debug("end exec process for elasticsearch");
    }

}