package cn.netbuffer.liteflow.demo.component;

import cn.netbuffer.liteflow.demo.pojo.DataDTO;
import com.yomahub.liteflow.script.annotation.ScriptBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ScriptBean("pdc")
public class PersistenceDataComponent {

    public boolean persistence(DataDTO dataDTO) {
        log.debug("persistence dataDTO={}", dataDTO);
        //persistence to database/redis/elasticsearch
        boolean result = RandomUtils.nextBoolean();
        log.debug("persistence result={}", result);
        return result;
    }

}
