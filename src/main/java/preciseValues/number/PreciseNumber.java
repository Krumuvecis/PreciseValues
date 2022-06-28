package preciseValues.number;

import preciseValues.errorModel.NumberError;

import java.util.Objects;
import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class PreciseNumber {
    private static final BigDecimal UNDEFINED_VALUE = BigDecimal.ZERO;
    private static final NumberError UNDEFINED_ERROR = new NumberError();

    private BigDecimal value;
    private NumberError error;

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

    public @NotNull BigDecimal getValue() {
        return value;
    }

    public @NotNull NumberError getError() {
        return error;
    }
}