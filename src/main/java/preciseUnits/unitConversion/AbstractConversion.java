package preciseUnits.unitConversion;

import org.jetbrains.annotations.NotNull;
import preciseUnits.AbstractUnit;

//TODO: add javadoc
public abstract class AbstractConversion implements ConversionInterface {

    public AbstractConversion() {}

    @Override
    public long convert(long value,
                        @NotNull AbstractUnit sourceUnits,
                        @NotNull AbstractUnit targetUnits) {
        ConversionMetadata conversionMetadata = getConversionMetadata(sourceUnits, targetUnits);
        return 0;
    }

    @Override
    public double convert(double value,
                          @NotNull AbstractUnit sourceUnits,
                          @NotNull AbstractUnit targetUnits) {
        ConversionMetadata conversionMetadata = getConversionMetadata(sourceUnits, targetUnits);
        return 0;
    }

    public abstract ConversionMetadata getConversionMetadata(
            @NotNull AbstractUnit sourceUnits,
            @NotNull AbstractUnit targetUnits);
}