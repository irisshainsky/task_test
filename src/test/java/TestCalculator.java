import distance.Point;
import helpers.AssertMultiDimentionalDoubleArray;
import helpers.NaiveTester;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCalculator {

    @Test
    public void testCalculator() {
        List<Point> points = generatePoints(1000);

        Calculator calculator = new Calculator();
        double[][] resultMatrix = calculator.calcDistances(points, 10);
        int len = resultMatrix.length;

        NaiveTester naiveTester = new NaiveTester();
        double[][] expected = naiveTester.calcDistances(points);

        AssertMultiDimentionalDoubleArray.assertArrayEquals(expected, resultMatrix);
    }

    private List<Point> generatePoints(int numberOfPoints) {
        int[] xStream = new Random().ints(numberOfPoints, 0, numberOfPoints ).limit(numberOfPoints).toArray();
        int[] yStream = new Random().ints(numberOfPoints, 0, numberOfPoints).limit(numberOfPoints).toArray();


        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numberOfPoints; i++) {
            points.add(new Point(xStream[i], yStream[i]));
        }
        return points;
    }

}
