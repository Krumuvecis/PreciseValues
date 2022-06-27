package newPrecisionModel.lists;

import newPrecisionModel.errorModel.NumberError;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class CommonPrecisionPrimitiveList extends AbstractPrimitivePrecisionList {
    public NumberError commonPrecision;

    public CommonPrecisionPrimitiveList(@Nullable List<Double> members) {
        super(members);
    }

    @Override
    public @NotNull NumberError getAbsoluteError() {
        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "CommonPrecisionPrimitiveList.getAbsoluteError() returns null, where annotated as not-null!");
        return null;
    }

    @Override
    public @NotNull NumberError getRelativeError() {
        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "CommonPrecisionPrimitiveList.getRelativeError() returns null, where annotated as not-null!");
        return null;
    }
}