package preciseUnits.dimensions.secondaries;

import preciseUnits.dimensions.AbstractDimension;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractSecondaryDimension extends AbstractDimension {
    public AbstractSecondaryDimension(@NotNull String name) {
        super(name);
    }
}