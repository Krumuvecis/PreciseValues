package newPrecisionModel.test;

import newPrecisionModel.lists.PrecisionList;
import newPrecisionModel.lists.CommonPrecisionPrimitiveList;
import newPrecisionModel.lists.UndefinedPrecisionPrimitiveList;

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
            //init here
        }
    }
}