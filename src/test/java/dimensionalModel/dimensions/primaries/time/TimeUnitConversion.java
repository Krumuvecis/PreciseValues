package dimensionalModel.dimensions.primaries.time;

import dimensionalModel.AbstractUnit;
import dimensionalModel.dimensions.primaries.time.units.*;
import dimensionalModel.unitConversion.AbstractConversion;
import dimensionalModel.unitConversion.ConversionMetadata;

import org.jetbrains.annotations.NotNull;

public class TimeUnitConversion extends AbstractConversion {
    public TimeUnitConversion() {
        super();
    }

    @Override
    public ConversionMetadata getConversionMetadata(@NotNull AbstractUnit sourceUnits,
                                                    @NotNull AbstractUnit targetUnits) {
        if (sourceUnits instanceof Second) {
            if (targetUnits instanceof Minute) {
                return new ConversionMetadata(
                        ConversionMetadata.ConversionType.DIVIDE,
                        60);
            } else if (targetUnits instanceof Hour) {
                return new ConversionMetadata(
                        ConversionMetadata.ConversionType.DIVIDE,
                        60 * 60);
            } else {
                return new ConversionMetadata();
            }
        } else if (sourceUnits instanceof Minute) {
            if (targetUnits instanceof Hour) {
                return new ConversionMetadata(
                        ConversionMetadata.ConversionType.DIVIDE,
                        60);
            } else if (targetUnits instanceof Second) {
                return new ConversionMetadata(
                        ConversionMetadata.ConversionType.MULTIPLY,
                        60);
            } else {
                return new ConversionMetadata();
            }
        } else if (sourceUnits instanceof Hour) {
            if (targetUnits instanceof Second) {
                return new ConversionMetadata(
                        ConversionMetadata.ConversionType.MULTIPLY,
                        60 * 60);
            } else if (targetUnits instanceof Minute) {
                return new ConversionMetadata(
                        ConversionMetadata.ConversionType.MULTIPLY,
                        60);
            } else {
                return new ConversionMetadata();
            }
        }
        return new ConversionMetadata();
    }
}