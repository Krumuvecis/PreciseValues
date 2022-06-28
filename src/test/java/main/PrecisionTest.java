package main;

import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;
import preciseValues.preciseNumber.PreciseNumber;
import preciseValues.lists.UndefinedPrecisionPrimitiveList;
import preciseValues.lists.CommonPrecisionPrimitiveList;
import preciseValues.lists.PrecisionList;
import preciseValues.lists.WeightedPrecisionList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

//TODO: finish this and add javadoc
public class PrecisionTest {
    static UndefinedPrecisionPrimitiveList undefinedPrecisionPrimitiveList;
    static CommonPrecisionPrimitiveList commonPrecisionPrimitiveList;
    static PrecisionList precisionList;
    static WeightedPrecisionList weightedPrecisionList;

    /**
     * The main method.
     * Launch this and watch magic happen.
     *
     * @param args args
     */
    public static void main(String[] args) {
        initializeLists();
        output();
    }

    private static void initializeLists() {
        NumberError commonError = getCommonError();
        preparePrimitiveLists(commonError);
        preparePreciseLists(commonError);
    }

    private static NumberError getCommonError() {
        return new NumberError(ErrorType.ABSOLUTE, new BigDecimal("0.5"));
    }

    private static void preparePrimitiveLists(NumberError commonError) {
        ArrayList<Double> primitivesList = getPrimitivesList();
        undefinedPrecisionPrimitiveList =
                new UndefinedPrecisionPrimitiveList(primitivesList);
        commonPrecisionPrimitiveList =
                new CommonPrecisionPrimitiveList(commonError, primitivesList);
    }

    private static ArrayList<Double> getPrimitivesList() {
        return new ArrayList<>() {{
            add(5.1);
            add(5.2);
            add(5.3);
            add(5.4);
            add(5.5);
        }};
    }

    private static void preparePreciseLists(NumberError commonError) {
        precisionList = new PrecisionList(new ArrayList<>() {{
            add(new PreciseNumber(new BigDecimal("5.1"), commonError));
            add(new PreciseNumber(new BigDecimal("5.2"), commonError));
            add(new PreciseNumber(new BigDecimal("5.3"), commonError));
            add(new PreciseNumber(new BigDecimal("5.4"), commonError));
            add(new PreciseNumber(new BigDecimal("5.5"), commonError));
        }});

        weightedPrecisionList = new WeightedPrecisionList(new HashMap<>() {{
            put(new PreciseNumber(new BigDecimal("5.1"), commonError), 1);
            put(new PreciseNumber(new BigDecimal("5.2"), commonError), 1);
            put(new PreciseNumber(new BigDecimal("5.3"), commonError), 1);
            put(new PreciseNumber(new BigDecimal("5.4"), commonError), 1);
            put(new PreciseNumber(new BigDecimal("5.5"), commonError), 1);
        }});
    }

    private static void output() {
        sectionSeparator();
        printLine("Testing UndefinedPrecisionPrimitiveList");
        printLine("Average : " + undefinedPrecisionPrimitiveList.getAverage());
        //printLine("Absolute error : " + undefinedPrecisionPrimitiveList.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + undefinedPrecisionPrimitiveList.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        printLine("Testing CommonPrecisionPrimitiveList");
        printLine("Average : " + commonPrecisionPrimitiveList.getAverage());
        //printLine("Absolute error : " + commonPrecisionPrimitiveList.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + commonPrecisionPrimitiveList.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        printLine("Testing PrecisionList");
        printLine("Average : " + precisionList.getAverage());
        //printLine("Absolute error : " + precisionList.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + precisionList.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        printLine("Testing WeightedPrecisionList");
        //printLine("Average : " + weightedPrecisionList.getAverage());
        //printLine("Absolute error : " + weightedPrecisionList.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + weightedPrecisionList.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");
    }

    private static void printLine(String line) {
        System.out.println(line);
    }

    private static void sectionSeparator() {
        String separator = "------------";
        printLine(separator);
    }
}