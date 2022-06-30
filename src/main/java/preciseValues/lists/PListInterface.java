package preciseValues.lists;

import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;
import preciseValues.pNumber.PNumber;

import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
//is this interface actually necessary?
interface PListInterface {
    void calculate(BigDecimal probability);
    int getMemberCount();
    @NotNull BigDecimal getAverage();
    @NotNull NumberError getError(@Nullable ErrorType errorType);
    @NotNull PNumber getAverage(@Nullable ErrorType errorType); //average + error
}