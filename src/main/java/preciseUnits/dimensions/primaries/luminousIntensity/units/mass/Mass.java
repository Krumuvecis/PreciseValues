package preciseUnits.dimensions.primaries.luminousIntensity.units.mass;

import preciseUnits.dimensions.primaries.AbstractPrimaryDimension;
import preciseUnits.dimensions.primaries.luminousIntensity.units.mass.units.Kilogram;

//TODO: add javadoc
public class Mass extends AbstractPrimaryDimension {
    public Mass() {
        super("mass", new Kilogram());
    }
}