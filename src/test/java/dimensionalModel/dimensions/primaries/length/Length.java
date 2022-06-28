package dimensionalModel.dimensions.primaries.length;

import dimensionalModel.dimensions.primaries.AbstractPrimaryDimension;
import dimensionalModel.dimensions.primaries.length.units.Meter;

//TODO: add javadoc
public class Length extends AbstractPrimaryDimension {
    public Length() {
        super("length", new Meter());
    }
}