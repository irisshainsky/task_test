import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCalculator {

    @Test
    public void testCalculator() {
        List<Point> points = generatePoints(2000);

        Instant beforeFirst = Instant.now();
        Calculator calculator = new Calculator();
        double[][] resultMatrix = calculator.calcDistances(points, 20);
        int len = resultMatrix.length;

        Instant afterFirst = Instant.now();

        NaiveTester naiveTester = new NaiveTester();
        double[][] expected = naiveTester.calcDistances(points);
        Instant end = Instant.now();

        System.out.println(Duration.between(beforeFirst, afterFirst).toMillis() +" "+ Duration.between(afterFirst, end).toMillis());

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
