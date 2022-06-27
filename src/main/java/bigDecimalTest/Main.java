package bigDecimalTest;

import java.util.Objects;

import java.math.BigDecimal;
import java.math.MathContext;

import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class Main {
    private static final int SIGNIFICANT_DIGITS = 5;
    private static BigDecimal myNum1;

    public static void main(String[] args) {
        double value = (double) 10 / 3;
        myNum1 = new BigDecimal(value, new MathContext(SIGNIFICANT_DIGITS));
        output();
    }

    private static void output() {
        printLine("BigDecimal test.");
        printLine("myNum1 : " + myNum1);
        printLine("significant digits : " + SIGNIFICANT_DIGITS);
    }

    private static void printLine(@Nullable String line) {
        System.out.println(Objects.requireNonNullElse(line, ""));
    }
}