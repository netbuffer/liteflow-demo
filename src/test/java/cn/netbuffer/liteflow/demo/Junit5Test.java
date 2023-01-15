package cn.netbuffer.liteflow.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@DisplayName("Junit5框架测试")
public class Junit5Test {

    @DisplayName("测试@DisplayName注解")
    @Test
    public void testDisplayName() {
        log.debug("@DisplayName");
    }

    @BeforeEach
    public void testBeforeEach() {
        log.debug("BeforeEach");
    }

    @BeforeAll
    public static void testBeforeAll() {
        log.debug("BeforeAll");
    }

    @AfterEach
    public void testAfterEach() {
        log.debug("AfterEach");
    }

    @AfterAll
    public static void testAfterAll() {
        log.debug("AfterAll");
    }

    @Test
    @Tag("someTag")
    public void testTag() {
        log.debug("test Tag");
    }

    @Test
    @Disabled
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void testTimeout() {
        log.debug("test Timeout");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}