package cn.netbuffer.liteflow.demo;

import com.yomahub.liteflow.builder.el.LiteFlowChainELBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LiteflowDemoApplicationTest {

    @Test
    public void init() {
        log.info("init");
    }

    @Test
    public void testEL() {
        String el = "SWITCH(paySwitchStep).to(paySuccessStep, payFailStep)";
        boolean isValid = LiteFlowChainELBuilder.validate(el);
        log.debug("test el[{}] isValid={}", el, isValid);
    }

}
