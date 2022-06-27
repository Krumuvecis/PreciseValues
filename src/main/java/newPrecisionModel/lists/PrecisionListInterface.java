package newPrecisionModel.lists;

import newPrecisionModel.errorModel.ErrorType;
import newPrecisionModel.errorModel.NumberError;
import newPrecisionModel.number.PreciseNumber;

import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
interface PrecisionListInterface {
    PreciseNumber getAverage(@Nullable ErrorType errorType);
    BigDecimal getAverage();
    @NotNull NumberError getError(@Nullable ErrorType errorType);
}