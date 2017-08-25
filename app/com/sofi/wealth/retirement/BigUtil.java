package com.sofi.wealth.retirement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.function.Function;

public final class BigUtil {
    
    private static final int SCALE_CALC = 8;
    private static final int SCALE_MONEY = 2;
    
    private static final Function<BigDecimal, BigDecimal> setScaleMoneyFunction = (bd) -> bd.setScale(SCALE_MONEY, RoundingMode.HALF_EVEN);
    private static final Function<BigDecimal, BigDecimal> setScaleCalcFunction = (bd) -> bd.setScale(SCALE_CALC, RoundingMode.HALF_EVEN);

    private BigUtil() {}

    /**
     * Using compareTo(), compares BigDecimal b1 to BigDecimal b2 and returns true if they are equal without regard to scale.
     *
     * @param b1 First BigDecimal to compare
     * @param b2 Second BigDecimal to compare
     * @return true if b1 has the same value as b2
     */
    public static boolean equals(BigDecimal b1, BigDecimal b2) {
        return (b1 == b2) ||
                (b1 != null && b2 != null && roundCalc(b1).compareTo(roundCalc(b2)) == 0);
    }
    
    public static boolean isZero(BigDecimal b) {
        return equals(BigDecimal.ZERO, b);
    }

    public static BigDecimal roundMoney(BigDecimal number) {
        return Optional.ofNullable(number)
                .map(setScaleMoneyFunction)
                .orElse(null);
    }
    
    public static BigDecimal roundCalc(BigDecimal number) {
        return Optional.ofNullable(number)
                        .map(setScaleCalcFunction)
                        .orElse(null);
    }
}
