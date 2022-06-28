package dimensionalModel.dimensions.primaries.luminousIntensity.units.mass;

import dimensionalModel.dimensions.primaries.AbstractPrimaryDimension;
import dimensionalModel.dimensions.primaries.luminousIntensity.units.mass.units.Kilogram;

//TODO: add javadoc
public class Mass extends AbstractPrimaryDimension {
    public Mass() {
        super("mass", new Kilogram());
    }
}