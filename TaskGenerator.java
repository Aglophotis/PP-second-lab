import java.io.FileReader;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class TaskGenerator {

    private int counter = 0;
    private ArrayList<String> arr = new ArrayList<>();
    private boolean isArrCreate = false;
    private Random rnd = new Random(System.currentTimeMillis());

    public void generateTask(int quantity, BlockingQueue<Task> qIn) throws Exception {
        synchronized (qIn) {
            for (int i = 0; i < quantity; i++) {
                Date currentDate = new Date();
                Task tmpTask = new Task(counter++, currentDate, randomCity());
                qIn.add(tmpTask);
            }
        }
    }

    private String randomCity() throws Exception {
        if (!isArrCreate){
            createArrOfCity();
            isArrCreate = true;
        }
        return arr.get(rnd.nextInt(arr.size()));
    }

    public void createArrOfCity() throws Exception{
        FileReader fr = new FileReader("src/CityList.txt");
        Scanner scan = new Scanner(fr);
        while(scan.hasNext()){
            arr.add(scan.next());
            scan.next();
        }
        scan.close();
        isArrCreate = true;
    }

    public ArrayList<String> getArr() {
        return arr;
    }
}