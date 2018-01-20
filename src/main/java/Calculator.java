import distance.BucketGenerator;
import distance.DistanceExecuter;
import distance.Point;
import distance.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Calculator {

    /**
     * main method: splits all points calculations into buckets and then submit each bucket to a thread for it to calculate,
     * the result matrix is updated in each thread although this is not thread safe since only one thread will handle a certain calculation
     * so there is no situation where more than one thread will update a certain value (beside the distance(point<x,x>) which is always 0)
     * @param points
     * @param threadNum
     * @return
     */

    public double[][] calcDistances(List<Point> points, Integer threadNum) {
        if(threadNum<=0 || threadNum==null) {
            throw new RuntimeException("ThreadNum parameter should be a poisitive integer >= 1");
        }

        if(points.size()<=0 || points==null) {
            throw new RuntimeException("point list can't be empty or null");
        }

        Integer numberOfCalculations = (points.size()*(points.size()-1))/2;
        threadNum = Math.min(threadNum,numberOfCalculations);

        final CountDownLatch latch = new CountDownLatch(threadNum);

        List<Queue<Task>> buckets = BucketGenerator.generateTasks(points,threadNum);

        double[][] resultsMatrix = new double[points.size()][points.size()];

        ExecutorService threads = Executors.newFixedThreadPool(threadNum);

        List<DistanceExecuter> callables = new LinkedList<>();
        for (int i = 0; i < threadNum; i++) {
            DistanceExecuter callable = new DistanceExecuter(buckets.get(i),resultsMatrix);
            callables.add(callable);
        }

        try {
            threads.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultsMatrix;
    }
 }
