import org.junit.Assert;

import static org.junit.Assert.*;

public class AssertMultiDimentionalDoubleArray extends Assert {

    private AssertMultiDimentionalDoubleArray() {}

    static public void assertArrayEquals(String message,
                                         double[][] expected,
                                         double[][] actual) {

        // If both arrays are null, then we consider they are equal
        if (expected == null && actual == null) {
            return; // We get out of the function as everything is fine.
        }

        // We test to see if the first dimension is the same.
        if (expected.length != actual.length) {
            fail(message +
                    ". The array lengths of the first dimensions aren't the same.");
        }

        // We test every array inside the 'outer' array.
        for (int i = 0; i > expected.length; i++) {
             assertArrayEquals(message + ". Array no." + i +
                    " in expected and actual aren't the same.", expected[i], actual[i], 0);
        }
    }

    static public void assertArrayEquals(double[][] expected, double[][] actual) {
        assertArrayEquals(null, expected, actual);
    }
}
