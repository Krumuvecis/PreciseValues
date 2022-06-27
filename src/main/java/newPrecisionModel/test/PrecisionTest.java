package newPrecisionModel.test;

import newPrecisionModel.errorModel.ErrorType;
import newPrecisionModel.errorModel.NumberError;
import newPrecisionModel.number.PreciseNumber;
import newPrecisionModel.lists.PrecisionList;
import newPrecisionModel.lists.CommonPrecisionPrimitiveList;
import newPrecisionModel.lists.UndefinedPrecisionPrimitiveList;

import java.math.BigDecimal;
import java.util.ArrayList;

//TODO: finish this and add javadoc
public class PrecisionTest {

    /**
     * The main method.
     * Launch this and watch magic happen.
     *
     * @param args args
     */
    public static void main(String[] args) {
        System.out.println("testing precise numbers");
        PreciseNumberTest preciseNumberTest = new PreciseNumberTest();
    }

    static class PreciseNumberTest {
        PrecisionList precisionList;
        CommonPrecisionPrimitiveList commonPrecisionPrimitiveList;
        UndefinedPrecisionPrimitiveList undefinedPrecisionPrimitiveList;

        public PreciseNumberTest() {
            NumberError commonError = new NumberError(
                    ErrorType.ABSOLUTE,
                    new BigDecimal("0.5"));
            precisionList = new PrecisionList(new ArrayList<>() {{
                add(new PreciseNumber(
                        new BigDecimal("5.1"),
                        commonError));
                add(new PreciseNumber(
                        new BigDecimal("5.2"),
                        commonError));
                add(new PreciseNumber(
                        new BigDecimal("5.3"),
                        commonError));
                add(new PreciseNumber(
                        new BigDecimal("5.4"),
                        commonError));
                add(new PreciseNumber(
                        new BigDecimal("5.5"),
                        commonError));
            }});

            ArrayList<Double> primitivesList = new ArrayList<>() {{
                add(5.1);
                add(5.2);
                add(5.3);
                add(5.4);
                add(5.5);
            }};

            commonPrecisionPrimitiveList = new CommonPrecisionPrimitiveList(
                    commonError,
                    primitivesList);

            undefinedPrecisionPrimitiveList = new UndefinedPrecisionPrimitiveList(
                    primitivesList
            );
        }
    }
}