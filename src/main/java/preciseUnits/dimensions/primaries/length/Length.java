package preciseUnits.dimensions.primaries.length;

import preciseUnits.dimensions.primaries.AbstractPrimaryDimension;
import preciseUnits.dimensions.primaries.length.units.Meter;

//TODO: add javadoc
public class Length extends AbstractPrimaryDimension {
    public Length() {
        super("length", new Meter());
    }
}