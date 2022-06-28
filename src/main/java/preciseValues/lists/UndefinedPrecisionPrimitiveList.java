package preciseValues.lists;

import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class UndefinedPrecisionPrimitiveList extends AbstractPrimitivePrecisionList {
    public UndefinedPrecisionPrimitiveList(@Nullable List<Double> members) {
        super(members);
    }

    @Override
    public final @NotNull NumberError getAbsoluteError() {
        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "UndefinedPrecisionPrimitiveList.getAbsoluteError() returns null, where annotated as not-null!");
        return null;
    }

    @Override
    public final @NotNull NumberError getRelativeError() {
        ErrorType errorType = ErrorType.RELATIVE;
        return new NumberError(
                errorType,
                getAbsoluteError().getError(errorType, getAverage()));
    }
}