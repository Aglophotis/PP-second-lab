import java.util.ArrayDeque;

public class Logger {
    public void printExecuteTask(ArrayDeque<Task> qTask) {
        Task task;
        synchronized (qTask) {
            task = qTask.poll();
        }
        if (task != null) {
            System.out.println(task.getID() + " " + task.getDate() + " " + task.getCity() + " " + task.getWeather());
        }
    }
}
