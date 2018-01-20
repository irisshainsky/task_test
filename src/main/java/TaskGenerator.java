import java.util.ArrayList;
import java.util.List;

public class TaskGenerator {
    public static List<Task> generateTasks(List<Point> points) {
        Integer numberOfCalculations = (points.size()*(points.size()-1))/2;
        List<Task> tasks = new ArrayList<Task>(numberOfCalculations);
        for (int i=0; i<points.size()-1;i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Task task = new Task();
                task.setPoint1(points.get(i));
                task.setPoint2(points.get(j));
                task.setFirstIndex(i);
                task.setSecondIndex(j);
                tasks.add(task);
            }
        }
        return tasks;
    }
}
