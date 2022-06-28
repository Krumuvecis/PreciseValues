package preciseValues.lists;

import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class UndefinedPrecisionPrimitiveList extends AbstractPrimitivePrecisionList {

    public UndefinedPrecisionPrimitiveList(@Nullable List<Double> members) {
        super(members);
    }

    static class IntermediaryMember {
        final double value;

        IntermediaryMember(double value) {
            this.value = value;
        }

        //delta
        BigDecimal offset(BigDecimal average) {
            return (new BigDecimal(value)).subtract(
                    average,
                    new MathContext(average.precision()));
        }

        //delta squared
        BigDecimal offsetSquared(BigDecimal average) {
            int power = 2;
            return offset(average).pow(
                    power,
                    new MathContext(power * (average.precision())));
        }

        boolean determineDiscrepancy(BigDecimal average,
                                     BigDecimal standardDeviation,
                                     BigDecimal coefficient) {
            return (offset(average).abs()).divide(
                    standardDeviation,
                    RoundingMode.HALF_UP
            ).compareTo(coefficient) > 0;
        }
    }

    @Override
    public final @NotNull NumberError getAbsoluteError() {
        List<IntermediaryMember> intermediaryMembers = initializeIntermediaryMembers();

        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "UndefinedPrecisionPrimitiveList.getAbsoluteError() returns null, where annotated as not-null!");
        return null;
    }

    private List<IntermediaryMember> initializeIntermediaryMembers() {
        List<IntermediaryMember> intermediaryMembers = new ArrayList<>();
        for (double member : members) {
            intermediaryMembers.add(new IntermediaryMember(member));
        }
        return intermediaryMembers;
    }

    private BigDecimal getStandardDeviation(BigDecimal average,
                                            List<IntermediaryMember> intermediaryMembers) {
        BigDecimal sumOfSquaredOffsets = getSumOfSquaredOffsets(average, intermediaryMembers);

        int memberCount = getMemberCount(); // N
        int divisor;
        if (memberCount > 1) {
            divisor = memberCount - 1; // N - 1
        } else {
            divisor = 1;
        }

        return (sumOfSquaredOffsets.divide(
                new BigDecimal(divisor),
                RoundingMode.HALF_UP)
        ).sqrt(new MathContext(
                sumOfSquaredOffsets.precision() / 2,
                RoundingMode.HALF_UP));
    }

    private BigDecimal getSumOfSquaredOffsets(BigDecimal average,
                                              List<IntermediaryMember> intermediaryMembers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (IntermediaryMember intermediaryMember : intermediaryMembers) {
            sum = sum.add(intermediaryMember.offsetSquared(average));
        }
        return sum;
    }

    @Override
    public final @NotNull NumberError getRelativeError() {
        return new NumberError(
                ErrorType.RELATIVE,
                getAbsoluteError().getError(ErrorType.RELATIVE, getAverage()));
    }
}