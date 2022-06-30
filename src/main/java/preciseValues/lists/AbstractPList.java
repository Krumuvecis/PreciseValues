package preciseValues.lists;

import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;
import preciseValues.pNumber.PNumber;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public abstract class AbstractPList implements PListInterface {

    public List<PListMember> startingList, resultList;
    public boolean calculated;

    private BigDecimal average;
    private BigDecimal standardDeviation;

    //TODO: add javadoc
    AbstractPList(@Nullable List<PListMember> members) {
        calculated = false;
        startingList = List.copyOf(Objects.requireNonNullElse(members, new ArrayList<>()));
    }

    //TODO: finish this and add javadoc
    @Override
    public void calculate(BigDecimal probability) {
        resultList = List.copyOf(startingList);
        setAverage();
        setOffsets();
        setStandardDeviation();
        //TODO: get discrepancies
        //TODO: repeat
        calculated = true;
    }

    //TODO: add javadoc
    public final int getStartingMemberCount() {
        return startingList.size();
    }

    //TODO: add javadoc
    @Override
    public final int getMemberCount() {
        return resultList.size();
    }

    //TODO: add javadoc
    public void setAverage() {
        this.average = getMemberSum().divide(
                new BigDecimal(getMemberCount()),
                RoundingMode.HALF_UP);
    }

    private @NotNull BigDecimal getMemberSum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (PListMember member : resultList) {
            sum = sum.add(member.getValue().getValue());
        }
        return sum;
    }

    private void setOffsets() {
        BigDecimal average = getAverage();
        for (PListMember member : resultList) {
            member.setOffsets(average);
        }
    }

    private void setStandardDeviation() {
        //TODO: finish this
        this.standardDeviation = null;
    }

    //TODO: add javadoc
    @SuppressWarnings("unused")
    public final @NotNull BigDecimal getStandardDeviation() {
        return standardDeviation;
    }

    //TODO: add javadoc
    @Override
    public final @NotNull BigDecimal getAverage() {
        return average;
    }

    //TODO: add javadoc
    @Override
    public final @NotNull NumberError getError(@Nullable ErrorType errorType) {
        return switch(Objects.requireNonNullElse(errorType, ErrorType.UNDEFINED)) {
            case ABSOLUTE -> getAbsoluteError();
            case RELATIVE -> getRelativeError();
            default -> NumberError.NON_NULL_ERROR;
        };
    }

    //TODO: add javadoc
    public abstract @NotNull NumberError getAbsoluteError();

    //TODO: add javadoc
    public abstract @NotNull NumberError getRelativeError();

    //TODO: add javadoc
    @Override
    public final @NotNull PNumber getAverage(@Nullable ErrorType errorType) {
        return new PNumber(getAverage(), getError(errorType));
    }
}