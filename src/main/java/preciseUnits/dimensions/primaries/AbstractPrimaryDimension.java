package preciseUnits.dimensions.primaries;

import preciseUnits.AbstractUnit;
import preciseUnits.dimensions.AbstractDimension;

import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public abstract class AbstractPrimaryDimension extends AbstractDimension {

    public final AbstractUnit baseUnit;

    public AbstractPrimaryDimension(@NotNull String name,
                                    @NotNull AbstractUnit baseUnit) {
        super(name);
        this.baseUnit = baseUnit;
    }
}