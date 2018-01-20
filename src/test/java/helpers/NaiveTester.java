package helpers;

import distance.Point;
import distance.Task;

import java.util.List;
import java.util.stream.Collectors;

public class NaiveTester {
    public double[][] calcDistances(List<Point> points) {
        List<Task> tasks = TaskGenerator.generateTasks(points);
        double[][] resultsMatrix = new double[points.size()][points.size()];

        tasks.forEach(task -> {
                    double result = task.calculateDistance();
                    resultsMatrix[task.getFirstIndex()][task.getSecondIndex()] = result;
                    resultsMatrix[task.getSecondIndex()][task.getFirstIndex()] = result;
                    resultsMatrix[task.getFirstIndex()][task.getFirstIndex()] = 0;
                    resultsMatrix[task.getSecondIndex()][task.getSecondIndex()] = 0;
                });
        return resultsMatrix;
    }
}
