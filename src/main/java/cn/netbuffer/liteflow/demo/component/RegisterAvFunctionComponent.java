package cn.netbuffer.liteflow.demo.component;

import cn.netbuffer.liteflow.demo.script.aviator.func.GetMiddleValueFunction;
import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Slf4j
@Component
public class RegisterAvFunctionComponent implements CommandLineRunner {

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) {
        log.debug("register aviator function");
        AviatorEvaluator.addFunction(applicationContext.getBean(GetMiddleValueFunction.class));
    }

}