package newPrecisionModel;

import java.util.List;
import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class PrecisionTest {

    /**
     * The main method.
     * Launch this and watch magic happen.
     *
     * @param args args
     */
    public static void main(String[] args) {
        System.out.println("testing precise numbers");
        PreciseNumberTest preciseNumberTest = new PreciseNumberTest();
    }

    /**
     * An enum for all possible error types.
     */
    public enum ErrorType {
        UNDEFINED,
        ABSOLUTE,
        RELATIVE
    }

    //TODO: add javadoc
    public static class NumberError {
        private static final BigDecimal
                UNDEFINED_ERROR_VALUE = new BigDecimal(0),
                NON_NULL_AVERAGE_VALUE = new BigDecimal(0),
                NON_ZERO_AVERAGE_VALUE = new BigDecimal(1); // this has to be an infinitely small number; 1 for simplicity

        private final ErrorType errorType;
        private final BigDecimal error;

        @SuppressWarnings("unused")
        public NumberError() {
            this(null, null);
        }

        public NumberError(@Nullable ErrorType errorType, @Nullable BigDecimal errorValue) {
            this.errorType = Objects.requireNonNullElse(errorType, ErrorType.UNDEFINED);
            this.error = Objects.requireNonNullElse(errorValue, UNDEFINED_ERROR_VALUE);
        }

        /**
         * Gets the type of the error.
         * (This method is intended for use in output)
         *
         * @return Error type.
         */
        @SuppressWarnings("unused")
        public final ErrorType getErrorType() {
            return errorType;
        }

        /**
         * Gets the absolute value component of the error.
         * (This method is intended for use in output)
         *
         * @return Error value.
         */
        @SuppressWarnings("unused")
        public final BigDecimal getErrorValue() {
            return error;
        }

        //TODO: add javadoc
        public final BigDecimal getError(@Nullable ErrorType errorType, @Nullable BigDecimal averageValue) {
            return switch (Objects.requireNonNullElse(errorType, ErrorType.UNDEFINED)) {
                case ABSOLUTE -> getAbsoluteError(averageValue);
                case RELATIVE -> getRelativeError(averageValue);
                default -> UNDEFINED_ERROR_VALUE;
            };
        }

        private BigDecimal getAbsoluteError(@Nullable BigDecimal averageValue) {
            return switch (errorType) {
                case ABSOLUTE -> error;
                case RELATIVE -> getAbsoluteFromRelative(
                        error,
                        Objects.requireNonNullElse(averageValue, NON_NULL_AVERAGE_VALUE));
                default -> UNDEFINED_ERROR_VALUE;
            };
        }

        private static BigDecimal getAbsoluteFromRelative(@NotNull BigDecimal errorValue,
                                                          @NotNull BigDecimal averageValue) {
            return averageValue.multiply(errorValue);
        }

        private BigDecimal getRelativeError(@Nullable BigDecimal averageValue) {
            return switch (errorType) {
                case ABSOLUTE -> getRelativeFromAbsolute(
                        error,
                        Objects.requireNonNullElse(averageValue, NON_NULL_AVERAGE_VALUE));
                case RELATIVE -> error;
                default -> UNDEFINED_ERROR_VALUE;
            };
        }

        private static BigDecimal getRelativeFromAbsolute(@NotNull BigDecimal errorValue,
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

    static class PreciseNumber {
        BigDecimal value;
        NumberError error;

        PreciseNumber(BigDecimal value, NumberError error) {
            this.value = value;
            this.error = error;
        }
    }

    interface PrecisionListInterface {

    }

    static class UndefinedPrecisionPrimitiveList implements PrecisionListInterface {
        List<Double> members;

        UndefinedPrecisionPrimitiveList() {

        }
    }

    static class CommonPrecisionPrimitiveList implements PrecisionListInterface {
        NumberError commonPrecision;
        List<Double> members;

        CommonPrecisionPrimitiveList() {

        }
    }

    static class PrecisionList implements PrecisionListInterface {
        List<PreciseNumber> members;

        PrecisionList() {

        }
    }

    static class PreciseNumberTest {
        List<PreciseNumber> precisionList;
        CommonPrecisionPrimitiveList commonPrecisionPrimitiveList;
        UndefinedPrecisionPrimitiveList undefinedPrecisionPrimitiveList;

        public PreciseNumberTest() {

        }
    }
}