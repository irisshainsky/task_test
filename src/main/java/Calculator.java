import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Calculator {

    public double[][] calcDistances(List<Point> points,Integer threadNum) {
        if(threadNum<=0 || threadNum==null) {
            throw new RuntimeException("ThreadNum parameter should be a poisitive integer >= 1");
        }

        if(points.size()<=0 || points==null) {
            throw new RuntimeException("point list can't be empty or null");
        }

        Integer numberOfCalculations = (points.size()*(points.size()-1))/2;
        threadNum = Math.min(threadNum,numberOfCalculations);

        final CountDownLatch latch = new CountDownLatch(threadNum);

        List<Task> tasks = TaskGenerator.generateTasks(points);
        List<Queue<Task>> buckets = TasksSplitter.splitList(tasks,threadNum);
        Queue<Result> resultQueue = new ConcurrentLinkedQueue<Result>();

        for (int i = 0; i < threadNum; i++) {
            DistanceExecuter runnable = new DistanceExecuter(buckets.get(i),resultQueue, latch);
            Thread newThread = new Thread(runnable);
            newThread.setDaemon(true);
            newThread.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double[][] resultsMatrix = new double[points.size()][points.size()];
        while(!resultQueue.isEmpty()) {
            Result currentRes = resultQueue.poll();
            resultsMatrix[currentRes.getFirstIndex()][currentRes.getSecondIndex()] = currentRes.getReuslt();
            resultsMatrix[currentRes.getSecondIndex()][currentRes.getFirstIndex()] = currentRes.getReuslt();
            resultsMatrix[currentRes.getFirstIndex()][currentRes.getFirstIndex()] = 0;
            resultsMatrix[currentRes.getSecondIndex()][currentRes.getSecondIndex()] = 0;
        }
        return resultsMatrix;
    }
 }
