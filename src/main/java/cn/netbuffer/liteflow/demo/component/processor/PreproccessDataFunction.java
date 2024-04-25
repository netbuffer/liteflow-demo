package cn.netbuffer.liteflow.demo.component.processor;

import cn.netbuffer.liteflow.demo.utils.AviatorFunctionUtil;
import com.yomahub.liteflow.script.annotation.ScriptBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Slf4j
@Component
@ScriptBean(name = "preproccess")
public class PreproccessDataFunction {

    @PostConstruct
    public void init(){
        log.debug("init preproccess data function");
    }

    public BigDecimal getMiddleValue(BigDecimal number1, BigDecimal number2, BigDecimal number3) {
        return AviatorFunctionUtil.getMiddleValue(number1, number2, number3);
    }

}
