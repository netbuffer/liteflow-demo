package cn.netbuffer.liteflow.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("Junit5框架测试")
public class Junit5Test {

    @DisplayName("测试@DisplayName注解")
    @Test
    public void testDisplayName() {
        log.debug("@DisplayName");
    }

}