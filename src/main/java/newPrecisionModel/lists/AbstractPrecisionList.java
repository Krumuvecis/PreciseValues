package newPrecisionModel.lists;

import newPrecisionModel.errorModel.ErrorType;
import newPrecisionModel.errorModel.NumberError;
import newPrecisionModel.number.PreciseNumber;

import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
abstract class AbstractPrecisionList implements PrecisionListInterface {
    @Override
    public final PreciseNumber getAverage(@Nullable ErrorType errorType) {
        return new PreciseNumber(getAverage(), getError(errorType));
    }

    @Override
    public final BigDecimal getAverage() {
        BigDecimal undefinedMemberSum = BigDecimal.ZERO;
        BigDecimal memberSum = Objects.requireNonNullElse(getMemberSum(), undefinedMemberSum);

        BigDecimal result;
        try {
            result = memberSum.divide(new BigDecimal(getMemberCount()), RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            System.err.println("BigDecimal - trying to divide by zero or insufficient scaling.");
            result = memberSum; // Returns sum in such case.
        }
        return result;
    }

    public abstract int getMemberCount();

    public abstract @NotNull BigDecimal getMemberSum();

    @Override
    public final @NotNull NumberError getError(@Nullable ErrorType errorType) {
        return switch (Objects.requireNonNullElse(errorType, ErrorType.UNDEFINED)) {
            case ABSOLUTE -> getAbsoluteError();
            case RELATIVE -> getRelativeError();
            default -> new NumberError();
        };
    }

    public abstract @NotNull NumberError getAbsoluteError();

    public abstract @NotNull NumberError getRelativeError();
}