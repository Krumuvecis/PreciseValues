package preciseValues.lists;

import preciseValues.errorModel.NumberError;
import preciseValues.preciseNumber.PreciseNumber;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class WeightedPrecisionList extends AbstractPrecisionList {
    public Map<PreciseNumber, Integer> members;

    public WeightedPrecisionList(@Nullable HashMap<PreciseNumber, Integer> members) {
        this.members = Objects.requireNonNullElse(members, new HashMap<>());
    }

    @Override
    public final @NotNull BigDecimal getAverage() {
        //TODO: finish this
        return null;
    }

    @Override
    public final int getMemberCount() {
        return members.size();
    }

    @Override
    public final @NotNull BigDecimal getMemberSum() {
        BigDecimal sum = new BigDecimal(0);
        for (PreciseNumber member : members.keySet()) {
            sum = sum.add(member.getValue());
        }
        return sum;
    }

    @Override
    public @NotNull NumberError getAbsoluteError() {
        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "PrecisionList.getAbsoluteError() returns null, where annotated as not-null!");
        return null;
    }

    @Override
    public @NotNull NumberError getRelativeError() {
        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "PrecisionList.getRelativeError() returns null, where annotated as not-null!");
        return null;
    }
}