package dimensionalModel.dimensions.primaries.temperature;

import dimensionalModel.dimensions.primaries.AbstractPrimaryDimension;
import dimensionalModel.dimensions.primaries.temperature.units.Kelvin;

//TODO: add javadoc
public class Temperature extends AbstractPrimaryDimension {
    public Temperature() {
        super("temperature", new Kelvin());
    }
}