package preciseValues.lists;

import preciseValues.errorModel.NumberError;

import java.util.List;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public class CommonPrecisionPrimitiveList extends AbstractPrimitivePrecisionList {
    public NumberError commonPrecision;

    public CommonPrecisionPrimitiveList(@Nullable NumberError precision,
                                        @Nullable List<Double> members) {
        super(members);
        this.commonPrecision = Objects.requireNonNullElse(precision, new NumberError());
    }

    @Override
    public final @NotNull NumberError getAbsoluteError() {
        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "CommonPrecisionPrimitiveList.getAbsoluteError() returns null, where annotated as not-null!");
        return null;
    }

    @Override
    public final @NotNull NumberError getRelativeError() {
        //TODO: finish this
        System.err.println("Unfinished functionality:" + "\n"
                + "CommonPrecisionPrimitiveList.getRelativeError() returns null, where annotated as not-null!");
        return null;
    }
}