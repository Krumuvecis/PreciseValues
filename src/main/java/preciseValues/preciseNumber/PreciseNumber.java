package preciseValues.preciseNumber;

import preciseValues.errorModel.NumberError;

import java.util.Objects;
import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * TODO: finish this javadoc
 */
public class PreciseNumber {
    private static final BigDecimal UNDEFINED_VALUE = BigDecimal.ZERO;
    private static final NumberError UNDEFINED_ERROR = new NumberError();

    private BigDecimal value;
    private NumberError error;

    /**
     * Creates a new PreciseNumber object.
     *
     * @param value Value part of the number.
     * @param error Error part of the number.
     */
    public PreciseNumber(@Nullable BigDecimal value, @Nullable NumberError error) {
        setValue(value);
        setError(error);
    }

    private void setValue(@Nullable BigDecimal value) {
        this.value = Objects.requireNonNullElse(value, UNDEFINED_VALUE);
    }

    private void setError(@Nullable NumberError error) {
        this.error = Objects.requireNonNullElse(error, UNDEFINED_ERROR);
    }

    /**
     * Gets the value part of the number.
     *
     * @return Value part of the number.
     */
    public @NotNull BigDecimal getValue() {
        return value;
    }

    /**
     * Gets the error part of the number.
     *
     * @return Error part of the number.
     */
    public @NotNull NumberError getError() {
        return error;
    }
}