package newPrecisionModel.lists;

import newPrecisionModel.errorModel.NumberError;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class UndefinedPrecisionPrimitiveList extends AbstractPrimitivePrecisionList {

    public UndefinedPrecisionPrimitiveList(@Nullable List<Double> members) {
        super(members);
    }

    @Override
    public @NotNull NumberError getAbsoluteError() {
        return null;
    }

    @Override
    public @NotNull NumberError getRelativeError() {
        return null;
    }
}