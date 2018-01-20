import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TasksSplitter {

    public static List<Queue<Task>> splitList(List<Task> tasks, Integer numberOfBuckets) {
        Integer chunckSize = tasks.size()/numberOfBuckets;
        int remainder = (numberOfBuckets % tasks.size());

        List<Queue<Task>> bucketList = new ArrayList<Queue<Task>>(numberOfBuckets);

        Integer numberOfAllocatedPoints = 0;

        for(int i=1;i<=numberOfBuckets;i++) {
            int numberOfTasksForThisBucket = i<remainder? chunckSize+1 : chunckSize;
            Queue<Task> currentTasks = new LinkedList<Task>(tasks.subList(numberOfAllocatedPoints,numberOfTasksForThisBucket));
            bucketList.add(i-1,currentTasks);
        }
        return bucketList;
    }
}
