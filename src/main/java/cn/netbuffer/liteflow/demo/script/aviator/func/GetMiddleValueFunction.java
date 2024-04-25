package cn.netbuffer.liteflow.demo.script.aviator.func;

import cn.netbuffer.liteflow.demo.utils.AviatorFunctionUtil;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@Component
public class GetMiddleValueFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        Number number1 = FunctionUtils.getNumberValue(arg1, env);
        Number number2 = FunctionUtils.getNumberValue(arg1, env);
        Number number3 = FunctionUtils.getNumberValue(arg1, env);
        return AviatorDecimal.valueOf(AviatorFunctionUtil.getMiddleValue(new BigDecimal(number1.doubleValue()),
                new BigDecimal(number2.doubleValue()), new BigDecimal(number3.doubleValue())));
    }

    @Override
    public String getName() {
        return "getMiddleValue";
    }

}