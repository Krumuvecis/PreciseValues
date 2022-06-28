package preciseValues.lists;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: finish this
 */
public class IntermediaryMember {
    private BigDecimal value, offset, offsetSquared;
    private boolean discrepancy;

    public IntermediaryMember(double value) {
        setValue(value);
    }

    private void setValue(double value) {
        this.value = new BigDecimal(String.valueOf(value));
    }

    //TODO: add javadoc
    public @NotNull BigDecimal getValue() {
        return value;
    }

    /**
     * Call this to calculate offsets.
     * TODO: finish this javadoc
     *
     * @param average Average value for reference.
     */
    public void setOffsets(@NotNull BigDecimal average) {
        setOffset(average);
        setOffsetSquared();
    }

    //delta
    private void setOffset(@NotNull BigDecimal average) {
        this.offset = value.subtract(
                average,
                new MathContext(average.precision()));
    }

    //delta squared
    private void setOffsetSquared() {
        int power = 2;
        offsetSquared = offset.pow(
                power,
                new MathContext(power * offset.precision()));
    }

    //TODO: add javadoc
    public @NotNull BigDecimal getOffsetSquared() {
        return offsetSquared;
    }

    //TODO: add javadoc
    public void setDiscrepancy(@NotNull BigDecimal standardDeviation,
                               @NotNull BigDecimal coefficient) {
        this.discrepancy = (this.offset.abs()).divide(
                standardDeviation,
                RoundingMode.HALF_UP
        ).compareTo(coefficient) > 0;
    }

    //TODO: add javadoc
    public boolean getDiscrepancy() {
        return discrepancy;
    }
}