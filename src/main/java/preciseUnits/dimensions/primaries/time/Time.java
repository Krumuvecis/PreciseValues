package preciseUnits.dimensions.primaries.time;

import preciseUnits.dimensions.primaries.AbstractPrimaryDimension;
import preciseUnits.dimensions.primaries.time.units.Second;

//TODO: add javadoc
public class Time extends AbstractPrimaryDimension {
    public Time() {
        super("time", new Second());
    }
}