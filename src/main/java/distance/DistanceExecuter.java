package distance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;

public class DistanceExecuter implements Callable<Void> {

    private Queue<Task> taskQueue;
    private final double[][] resultsMatrix;

    public DistanceExecuter(Queue<Task> tasks, double[][] resultMatrix) {
            this.taskQueue = tasks;
            this.resultsMatrix = resultMatrix;
     }

    @Override
    public Void call() {
        int counter = 0;
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.poll();
            double result = currentTask.calculateDistance();
            resultsMatrix[currentTask.getFirstIndex()][currentTask.getSecondIndex()] = result;
            resultsMatrix[currentTask.getSecondIndex()][currentTask.getFirstIndex()] = result;
            resultsMatrix[currentTask.getFirstIndex()][currentTask.getFirstIndex()] = 0;
            resultsMatrix[currentTask.getSecondIndex()][currentTask.getSecondIndex()] = 0;
        }
        return null;
    }
}