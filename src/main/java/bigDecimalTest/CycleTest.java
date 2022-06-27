package bigDecimalTest;

import java.math.BigDecimal;

public class CycleTest {
    private static BigDecimal myNum1, myNum2;

    public static void main(String[] args) {
        myNum1 = new BigDecimal(0);
        myNum2 = new BigDecimal(1);
        while(true) {
            cycle();
        }
    }

    private static void cycle() {
        System.out.println("" + myNum1);
        myNum1 = myNum1.add(myNum2);
    }
}
