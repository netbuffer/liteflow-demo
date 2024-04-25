package cn.netbuffer.liteflow.demo.utils;

import java.math.BigDecimal;
import java.util.Arrays;

public class AviatorFunctionUtil {

    public static final BigDecimal getMiddleValue(BigDecimal number1, BigDecimal number2, BigDecimal number3) {
        BigDecimal[] array = {number1, number2, number3};
        Arrays.sort(array);
        int midIndex = array.length / 2;
        return array[midIndex];
    }

}
