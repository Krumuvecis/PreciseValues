package dimensionalModel.dimensions.primaries.luminousIntensity;

import dimensionalModel.dimensions.primaries.AbstractPrimaryDimension;
import dimensionalModel.dimensions.primaries.luminousIntensity.units.Candela;

//TODO: add javadoc
public class LuminousIntensity extends AbstractPrimaryDimension {
    public LuminousIntensity() {
        super("luminous intensity", new Candela());
    }
}