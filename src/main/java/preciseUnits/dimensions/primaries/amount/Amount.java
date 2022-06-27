package preciseUnits.dimensions.primaries.amount;

import preciseUnits.dimensions.primaries.AbstractPrimaryDimension;
import preciseUnits.dimensions.primaries.amount.units.Mole;

//TODO: add javadoc
public class Amount extends AbstractPrimaryDimension {
    public Amount() {
        super("amount", new Mole());
    }
}