package preciseUnits.dimensions.primaries.luminousIntensity;

import preciseUnits.dimensions.primaries.AbstractPrimaryDimension;
import preciseUnits.dimensions.primaries.luminousIntensity.units.Candela;

//TODO: add javadoc
public class LuminousIntensity extends AbstractPrimaryDimension {
    public LuminousIntensity() {
        super("luminous intensity", new Candela());
    }
}