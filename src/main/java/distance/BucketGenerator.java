package distance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BucketGenerator {
    /**
     * Generates buckets with all the tasks for calculations, number of tasks is (n*(n-1))/2 , this method splits the tasks in an even manner
     * so each bucket can have up to (((n*(n-1))/2 )/numberOfBuckets)+1
     * @param points
     * @param numberOfBuckets
     * @return
     */
    public static List<Queue<Task>> generateTasks(List<Point> points, Integer numberOfBuckets) {
        Integer numberOfCalculations = (points.size()*(points.size()-1))/2;

        List<Queue<Task>> bucketList = new ArrayList<Queue<Task>>(numberOfBuckets);
        for(int i=0; i<numberOfBuckets ; i++) {
            bucketList.add(i,new LinkedList<>());
        }

        Integer counter = 0;
        for (int i=0; i<points.size()-1;i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Task task = new Task();
                task.setPoint1(points.get(i));
                task.setPoint2(points.get(j));
                task.setFirstIndex(i);
                task.setSecondIndex(j);

                Integer chunck = counter%numberOfBuckets;
                bucketList.get(chunck).add(task);
                counter++;

            }
        }
        return bucketList;
    }
}