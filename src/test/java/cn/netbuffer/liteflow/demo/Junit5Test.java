import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

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

    @RepeatedTest(name = "testRepeatedTest", value = 3)
    public void testRepeatedTest() {
        log.debug("nextBoolean={}", RandomUtils.nextBoolean());
    }

    @Test
    public void testAssert() {
        Assertions.assertEquals(1, 1, "1!=1");
        Assertions.assertSame(new Object(), new Object(), "object not same");
        Assertions.assertTrue(true, "value not true");
    }

    @ParameterizedTest
    @DisplayName("参数化测试@ValueSource")
    @ValueSource(strings = {"a", "b", "c"})
    public void testValueSource(String key) {
        log.debug("key={}", key);
    }

    @ParameterizedTest
    @DisplayName("参数化测试@MethodSource")
    @MethodSource(value = {"keyProvider"})
    public void testMethodSource(String key) {
        log.debug("key={}", key);
    }

    static Stream<String> keyProvider() {
        return Stream.of("a", "b", "c");
    }

}