package preciseUnits.unitConversion;

import java.util.Objects;

import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class ConversionMetadata {
    public enum ConversionType {
        NO_CHANGE,
        DIVIDE,
        MULTIPLY
    }

    private static final ConversionType
            DEFAULT_CONVERSION_TYPE = ConversionType.NO_CHANGE;
    private static final int DEFAULT_COEFFICIENT = 1;

    private final ConversionType conversionType;
    private int coefficient;

    @SuppressWarnings("unused")
    public ConversionMetadata() {
        this(DEFAULT_CONVERSION_TYPE);
    }

    public ConversionMetadata(@Nullable ConversionType conversionType) {
        this(conversionType, DEFAULT_COEFFICIENT);
    }

    public ConversionMetadata(@Nullable ConversionType conversionType,
                              int coefficient) {
        this.conversionType = Objects.requireNonNullElse(conversionType, DEFAULT_CONVERSION_TYPE);
        if (coefficient != 0) {
            this.coefficient = coefficient;
        }
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public int getCoefficient() {
        return coefficient;
    }
}