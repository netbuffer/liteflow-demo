package cn.netbuffer.liteflow.demo.service;

import com.yomahub.liteflow.script.annotation.ScriptMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessService {

    @ScriptMethod("bizLogic")
    public int logic1(String data) {
        log.debug("logic1 method receive data={}", data);
        return RandomUtils.nextInt();
    }

    @ScriptMethod("bizLogic")
    public boolean logic2(String data) {
        log.debug("logic2 method receive data={}", data);
        return RandomUtils.nextBoolean();
    }

}
