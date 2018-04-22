import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class TaskExecutor {
    private Map<String, String> hashMap = new HashMap<>();
    private boolean isHashMapCreate = false;

    public void createHashMapQueue() throws FileNotFoundException {
        FileReader fr = new FileReader("src/CityList.txt");
        Scanner scan = new Scanner(fr);
        while (scan.hasNext())
            hashMap.put(scan.next(), scan.next());
        scan.close();
        isHashMapCreate = true;
    }

    public void executeTask(BlockingQueue<Task> qIn, ArrayDeque<Task> qOut) throws FileNotFoundException{
        Task tmpTask;

        if (!isHashMapCreate)
            synchronized (hashMap) {
                if (!isHashMapCreate)
                    createHashMapQueue();
            }

        if (!qIn.isEmpty()) {
            synchronized (qIn) {
                if (!qIn.isEmpty()) {
                    tmpTask = qIn.poll();
                    tmpTask.setWeather(hashMap.get(tmpTask.getCity()));
                    synchronized (qOut) {
                        qOut.offer(tmpTask);
                    }
                }
            }
        }
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }
}
