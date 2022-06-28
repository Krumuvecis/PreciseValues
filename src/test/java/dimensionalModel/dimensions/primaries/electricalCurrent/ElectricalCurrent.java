package dimensionalModel.dimensions.primaries.electricalCurrent;

import dimensionalModel.dimensions.primaries.AbstractPrimaryDimension;
import dimensionalModel.dimensions.primaries.electricalCurrent.units.Ampere;

//TODO: add javadoc
public class ElectricalCurrent extends AbstractPrimaryDimension {
    public ElectricalCurrent() {
        super("electrical current", new Ampere());
    }
}