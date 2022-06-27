package dimensionalModel.dimensions.primaries.amount;

import dimensionalModel.dimensions.primaries.AbstractPrimaryDimension;
import dimensionalModel.dimensions.primaries.amount.units.Mole;

//TODO: add javadoc
public class Amount extends AbstractPrimaryDimension {
    public Amount() {
        super("amount", new Mole());
    }
}