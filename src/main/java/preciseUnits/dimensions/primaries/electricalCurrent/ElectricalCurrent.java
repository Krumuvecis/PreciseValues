package preciseUnits.dimensions.primaries.electricalCurrent;

import preciseUnits.dimensions.primaries.AbstractPrimaryDimension;
import preciseUnits.dimensions.primaries.electricalCurrent.units.Ampere;

//TODO: add javadoc
public class ElectricalCurrent extends AbstractPrimaryDimension {
    public ElectricalCurrent() {
        super("electrical current", new Ampere());
    }
}