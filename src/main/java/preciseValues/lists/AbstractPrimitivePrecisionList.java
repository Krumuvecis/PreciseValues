package preciseValues.lists;

import preciseValues.errorModel.NumberError;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public abstract class AbstractPrimitivePrecisionList extends AbstractPrecisionList {
    boolean calculated;
    public List<IntermediaryMember> members;

    public AbstractPrimitivePrecisionList(@Nullable List<Double> members) {
        calculated = false;
        setMembers(Objects.requireNonNullElse(members, new ArrayList<>()));
    }

    private void setMembers(@NotNull List<Double> members) {
        this.members = new ArrayList<>();
        for (double member : members) {
            this.members.add(new IntermediaryMember(member));
        }
    }

    //prevents further overriding
    @Override
    public final @NotNull BigDecimal getAverage() {
        return super.getAverage();
    }

    @Override
    public final int getMemberCount() {
        return members.size();
    }

    @Override
    public final @NotNull BigDecimal getMemberSum() {
        BigDecimal sum = new BigDecimal(0);
        for (IntermediaryMember member : members) {
            sum = sum.add(member.getValue());
        }
        return sum;
    }

    /*
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
    */

    /*
    private BigDecimal getSumOfSquaredOffsets(BigDecimal average,
                                              List<IntermediaryMember> intermediaryMembers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (IntermediaryMember intermediaryMember : intermediaryMembers) {
            sum = sum.add(intermediaryMember.offsetSquared(average));
        }
        return sum;
    }
    */

    @Override
    public abstract @NotNull NumberError getAbsoluteError();

    @Override
    public abstract @NotNull NumberError getRelativeError();
}