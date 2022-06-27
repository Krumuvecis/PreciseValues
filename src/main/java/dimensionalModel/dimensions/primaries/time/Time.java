package dimensionalModel.dimensions.primaries.time;

import dimensionalModel.dimensions.primaries.AbstractPrimaryDimension;
import dimensionalModel.dimensions.primaries.time.units.Second;

//TODO: add javadoc
public class Time extends AbstractPrimaryDimension {
    public Time() {
        super("time", new Second());
    }
}