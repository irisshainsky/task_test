import java.util.List;
import java.util.stream.Collectors;

public class NaiveTester {
    public double[][] calcDistances(List<Point> points) {
        List<Task> tasks = TaskGenerator.generateTasks(points);
        double[][] resultsMatrix = new double[points.size()][points.size()];

        tasks.stream()
                .map(task -> (task.calculateDistance()))
                .collect(Collectors.toList()).stream()
                .forEach(currentRes -> {
                    resultsMatrix[currentRes.getFirstIndex()][currentRes.getSecondIndex()] = currentRes.getReuslt();
                    resultsMatrix[currentRes.getSecondIndex()][currentRes.getFirstIndex()] = currentRes.getReuslt();
                    resultsMatrix[currentRes.getFirstIndex()][currentRes.getFirstIndex()] = 0;
                    resultsMatrix[currentRes.getSecondIndex()][currentRes.getSecondIndex()] = 0;

                });
        return resultsMatrix;
    }
}
