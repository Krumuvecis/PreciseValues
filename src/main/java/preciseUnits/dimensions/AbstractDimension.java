package preciseUnits.dimensions;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractDimension {
    public final String name;

    public AbstractDimension(@NotNull String name) {
        this.name = name;
    }
}