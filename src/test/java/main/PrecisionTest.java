package main;

import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;
import preciseValues.number.PreciseNumber;
import preciseValues.lists.PrecisionList;
import preciseValues.lists.CommonPrecisionPrimitiveList;
import preciseValues.lists.UndefinedPrecisionPrimitiveList;

import java.math.BigDecimal;
import java.util.ArrayList;

//TODO: finish this and add javadoc
public class PrecisionTest {
    static PrecisionList precisionList;
    static CommonPrecisionPrimitiveList commonPrecisionPrimitiveList;
    static UndefinedPrecisionPrimitiveList undefinedPrecisionPrimitiveList;

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

    private static void output() {
        sectionSeparator();
        printLine("Testing PrecisionList");
        printLine("Average : " + precisionList.getAverage());
        //printLine("Absolute error : " + precisionList.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + precisionList.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        printLine("Testing CommonPrecisionPrimitiveList");
        printLine("Average : " + commonPrecisionPrimitiveList.getAverage());
        //printLine("Absolute error : " + commonPrecisionPrimitiveList.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + commonPrecisionPrimitiveList.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        printLine("Testing UndefinedPrecisionPrimitiveList");
        printLine("Average : " + undefinedPrecisionPrimitiveList.getAverage());
        //printLine("Absolute error : " + undefinedPrecisionPrimitiveList.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + undefinedPrecisionPrimitiveList.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");
    }

    private static void printLine(String line) {
        System.out.println(line);
    }

    private static void sectionSeparator() {
        String separator = "------------";
        printLine(separator);
    }
}