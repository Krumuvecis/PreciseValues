package preciseValues.errorModel;

import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * TODO: finish this javadoc
 */
public class NumberError {
    private static final BigDecimal
            UNDEFINED_ERROR_VALUE = new BigDecimal(0),
            NON_NULL_AVERAGE_VALUE = new BigDecimal(0);

    private final ErrorType errorType;
    private final BigDecimal errorValue;

    /**
     * Creates a blank NumberError object.
     * (Intended for cases where the error is not defined)
     */
    public NumberError() {
        this(null, null);
    }

    /**
     * Creates a new NumberError object.
     *
     * @param errorType     Type of the error.
     * @param errorValue    Value of the error.
     */
    public NumberError(@Nullable ErrorType errorType, @Nullable BigDecimal errorValue) {
        this.errorType = Objects.requireNonNullElse(errorType, ErrorType.UNDEFINED);
        this.errorValue = Objects.requireNonNullElse(errorValue, UNDEFINED_ERROR_VALUE);
    }

    /**
     * Gets the type of the error.
     * (This method is intended for use in output)
     *
     * @return Error type.
     */
    @SuppressWarnings("unused")
    public final @NotNull ErrorType getErrorType() {
        return errorType;
    }

    /**
     * Gets the absolute value component of the error.
     * (This method is intended for use in output)
     *
     * @return Error value.
     */
    @SuppressWarnings("unused")
    public final @NotNull BigDecimal getErrorValue() {
        return errorValue;
    }

    /**
     * TODO: finish this javadoc
     *
     * @param errorType     Type of error to return.
     * @param averageValue  Average value for reference.
     *
     * @return Value of the error.
     */
    public final @NotNull BigDecimal getError(
            @Nullable ErrorType errorType,
            @Nullable BigDecimal averageValue) {
        return switch (Objects.requireNonNullElse(errorType, ErrorType.UNDEFINED)) {
            case ABSOLUTE -> getAbsoluteError(averageValue);
            case RELATIVE -> getRelativeError(averageValue);
            default -> UNDEFINED_ERROR_VALUE;
        };
    }

    private @NotNull BigDecimal getAbsoluteError(@Nullable BigDecimal averageValue) {
        return switch (errorType) {
            case ABSOLUTE -> errorValue;
            case RELATIVE -> getAbsoluteFromRelative(
                    errorValue,
                    Objects.requireNonNullElse(averageValue, NON_NULL_AVERAGE_VALUE));
            default -> UNDEFINED_ERROR_VALUE;
        };
    }

    private static @NotNull BigDecimal getAbsoluteFromRelative(
            @NotNull BigDecimal errorValue,
            @NotNull BigDecimal averageValue) {
        return averageValue.multiply(errorValue);
    }

    private @NotNull BigDecimal getRelativeError(@Nullable BigDecimal averageValue) {
        return switch (errorType) {
            case ABSOLUTE -> getRelativeFromAbsolute(
                    errorValue,
                    Objects.requireNonNullElse(averageValue, NON_NULL_AVERAGE_VALUE));
            case RELATIVE -> errorValue;
            default -> UNDEFINED_ERROR_VALUE;
        };
    }

    private static @NotNull BigDecimal getRelativeFromAbsolute(
            @NotNull BigDecimal errorValue,
            @NotNull BigDecimal averageValue) {
        BigDecimal result;
        try {
            result = errorValue.divide(averageValue, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            System.err.println("BigDecimal - trying to divide by zero or insufficient scaling.");
            result = UNDEFINED_ERROR_VALUE;
        }
        return result;
    }
}