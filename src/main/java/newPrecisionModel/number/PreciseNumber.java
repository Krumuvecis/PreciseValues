package newPrecisionModel.number;

import newPrecisionModel.errorModel.NumberError;

import java.math.BigDecimal;

//TODO: add javadoc
public class PreciseNumber {

    public BigDecimal value;

    public NumberError error;

    public PreciseNumber(BigDecimal value, NumberError error) {
        this.value = value;
        this.error = error;
    }
}