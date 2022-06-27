package newPrecisionModel.lists;

import newPrecisionModel.errorModel.NumberError;
import newPrecisionModel.number.PreciseNumber;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class PrecisionList extends AbstractPrecisionList {
    public List<PreciseNumber> members;

    public PrecisionList(@Nullable ArrayList<PreciseNumber> members) {
        this.members = Objects.requireNonNullElse(members, new ArrayList<>());
    }

    @Override
    public final int getMemberCount() {
        return members.size();
    }

    @Override
    public final @NotNull BigDecimal getMemberSum() {
        BigDecimal sum = new BigDecimal(0);

        for (PreciseNumber member : members) {
            sum = sum.add(member.getValue());
        }
        return sum;
    }

    @Override
    public @NotNull NumberError getAbsoluteError() {
        //TODO: finish this
        return null;
    }

    @Override
    public @NotNull NumberError getRelativeError() {
        //TODO: finish this
        return null;
    }
}