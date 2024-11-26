package listTest;

import preciseValues.errorModel.ErrorType;
import preciseValues.errorModel.NumberError;
import preciseValues.pNumber.PNumber;
import preciseValues.lists.PList;

import java.util.ArrayList;
import java.math.BigDecimal;

//TODO: finish this and add javadoc
public class Main {
    static PList list1, list2, list3, list4; //see doc.md for numbering explanation

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
        list1 = new PList(primitivesList);
        list1 = new PList(commonError, primitivesList);
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
        list3 = new PList(new ArrayList<>() {{
            add(new PNumber(new BigDecimal("5.1"), commonError));
            add(new PNumber(new BigDecimal("5.2"), commonError));
            add(new PNumber(new BigDecimal("5.3"), commonError));
            add(new PNumber(new BigDecimal("5.4"), commonError));
            add(new PNumber(new BigDecimal("5.5"), commonError));
        }});

        /*
        list4 = new PList(new HashMap<>() {{
            put(new PNumber(new BigDecimal("5.1"), commonError), 1);
            put(new PNumber(new BigDecimal("5.2"), commonError), 1);
            put(new PNumber(new BigDecimal("5.3"), commonError), 1);
            put(new PNumber(new BigDecimal("5.4"), commonError), 1);
            put(new PNumber(new BigDecimal("5.5"), commonError), 1);
        }});*/
    }

    private static void output() {
        sectionSeparator();
        printLine("Testing a PList of doubles with undefined precision.");
        //printLine("Average : " + list1.getAverage());
        //printLine("Absolute error : " + list1.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + list1.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        printLine("Testing a PList of doubles with common precision.");
        //printLine("Average : " + list2.getAverage());
        //printLine("Absolute error : " + list2.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + list2.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        printLine("Testing a PList with individually defined precision.");
        //printLine("Average : " + list3.getAverage());
        //printLine("Absolute error : " + list3.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + list3.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");

        sectionSeparator();
        //printLine("Testing a weighted PList.");
        //printLine("Average : " + list4.getAverage());
        //printLine("Absolute error : " + list4.getAverage(ErrorType.ABSOLUTE).getError().getErrorValue());
        //printLine("Relative error : " + list4.getAverage(ErrorType.RELATIVE).getError().getErrorValue() + " %");
    }

    private static void printLine(String line) {
        System.out.println(line);
    }

    private static void sectionSeparator() {
        String separator = "------------";
        printLine(separator);
    }
}