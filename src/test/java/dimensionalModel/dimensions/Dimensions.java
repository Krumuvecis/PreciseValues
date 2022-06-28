package dimensionalModel.dimensions;

import dimensionalModel.dimensions.primaries.*;
import dimensionalModel.dimensions.primaries.amount.Amount;
import dimensionalModel.dimensions.primaries.electricalCurrent.ElectricalCurrent;
import dimensionalModel.dimensions.primaries.length.Length;
import dimensionalModel.dimensions.primaries.luminousIntensity.LuminousIntensity;
import dimensionalModel.dimensions.primaries.luminousIntensity.units.mass.Mass;
import dimensionalModel.dimensions.primaries.temperature.Temperature;
import dimensionalModel.dimensions.primaries.time.Time;

import java.util.Map;
import java.util.HashMap;

//TODO: finish this and add javadoc
public class Dimensions {
    static Map<PrimaryDimensionType, AbstractPrimaryDimension> primaryDimensions;

    //TODO: define secondaries here

    static {
        primaryDimensions = new HashMap<>() {{
            put(PrimaryDimensionType.MASS, new Mass());
            put(PrimaryDimensionType.LENGTH, new Length());
            put(PrimaryDimensionType.TIME, new Time());
            put(PrimaryDimensionType.TEMPERATURE, new Temperature());
            put(PrimaryDimensionType.ELECTRICAL_CURRENT, new ElectricalCurrent());
            put(PrimaryDimensionType.LUMINOUS_INTENSITY, new LuminousIntensity());
            put(PrimaryDimensionType.AMOUNT, new Amount());
        }};

        //TODO: init secondaries here
    }
}