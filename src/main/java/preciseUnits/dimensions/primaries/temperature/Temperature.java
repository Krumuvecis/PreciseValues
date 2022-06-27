package preciseUnits.dimensions.primaries.temperature;

import preciseUnits.dimensions.primaries.AbstractPrimaryDimension;
import preciseUnits.dimensions.primaries.temperature.units.Kelvin;

//TODO: add javadoc
public class Temperature extends AbstractPrimaryDimension {
    public Temperature() {
        super("temperature", new Kelvin());
    }
}