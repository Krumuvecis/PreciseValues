package preciseUnits.unitConversion;

import preciseUnits.AbstractUnit;

//TODO: add javadoc
public interface ConversionInterface {
    static long divide(long dividend, int divisor) {
        return dividend / divisor;
    }

    static double divide(double dividend, int divisor) {
        return dividend / divisor;
    }

    static long multiply(long multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }

    static double multiply(double multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }

    long convert(long value, AbstractUnit sourceUnits, AbstractUnit targetUnits);
    double convert(double value, AbstractUnit sourceUnits, AbstractUnit targetUnits);
}