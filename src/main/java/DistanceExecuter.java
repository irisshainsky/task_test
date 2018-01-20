import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class DistanceExecuter implements Runnable {

    private Queue<Task> taskQueue;
    private Queue<Result> resultQueue;
    private final CountDownLatch latch;


    public DistanceExecuter(Queue<Task> tasks, Queue<Result> resultQueue, CountDownLatch latch) {
            this.taskQueue = tasks;
            this.latch = latch;
            this.resultQueue = resultQueue;
     }

    @Override
    public void run() {
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.poll();
            Result result = currentTask.calculateDistance();
            resultQueue.add(result);
        }
        latch.countDown();
    }
}