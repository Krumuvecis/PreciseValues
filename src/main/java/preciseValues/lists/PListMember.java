package preciseValues.lists;

import preciseValues.errorModel.NumberError;
import preciseValues.pNumber.PNumber;

import java.util.Objects;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class PListMember {
    private static final PNumber NON_NULL_P_NUMBER = new PNumber(null, null);

    private final PNumber value;
    private final int weight;

    private BigDecimal offset, offsetSquared; // delta and delta squared
    private boolean discrepancy;

    //for lists with undefined precision
    public PListMember(double value) {
        this(value, NumberError.NON_NULL_ERROR);
    }

    //for lists with commonly defined precision
    public PListMember(double value, @Nullable NumberError commonError) {
        this(new PNumber(
                new BigDecimal(String.valueOf(value)),
                Objects.requireNonNullElse(commonError, NumberError.NON_NULL_ERROR)));
    }

    //for lists with individually defined precision
    public PListMember(@Nullable PNumber value) {
        this(value, 1);
    }

    //for weighted lists
    public PListMember(@Nullable PNumber value, int weight) {
        this.value = Objects.requireNonNullElse(value, NON_NULL_P_NUMBER);
        this.weight = weight;
    }

    public @NotNull PNumber getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
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

    private void setOffset(@NotNull BigDecimal average) {
        this.offset = value.getValue().subtract(
                average,
                new MathContext(average.precision()));
    }

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
                               @NotNull BigDecimal studentCoefficient) {
        this.discrepancy = (this.offset.abs()).divide(
                standardDeviation,
                RoundingMode.HALF_UP
        ).compareTo(studentCoefficient) > 0;
    }

    //TODO: add javadoc
    public boolean getDiscrepancy() {
        return discrepancy;
    }
}