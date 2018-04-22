import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlock {

    private void createTestTask(BlockingQueue<Task> qIn){
        Task tmpTask1 = new Task();
        Date currentDate = new Date();
        tmpTask1.setID(0);
        tmpTask1.setCity("Moscow");
        tmpTask1.setDate(currentDate);
        qIn.add(tmpTask1);

        Task tmpTask2 = new Task();
        tmpTask2.setID(1);
        tmpTask2.setCity("Novosibirsk");
        tmpTask2.setDate(currentDate);
        qIn.add(tmpTask2);

        Task tmpTask3 = new Task();
        tmpTask3.setID(2);
        tmpTask3.setCity("Irkutsk");
        tmpTask3.setDate(currentDate);
        qIn.add(tmpTask3);

        Task tmpTask4 = new Task();
        tmpTask4.setID(3);
        tmpTask4.setCity("Cheboksary");
        tmpTask4.setDate(currentDate);
        qIn.add(tmpTask4);

        Task tmpTask5 = new Task();
        tmpTask5.setID(4);
        tmpTask5.setCity("St.Petersburg");
        tmpTask5.setDate(currentDate);
        qIn.add(tmpTask5);

        Task tmpTask6 = new Task();
        tmpTask6.setID(5);
        tmpTask6.setCity("Latvia");
        tmpTask6.setDate(currentDate);
        qIn.add(tmpTask6);
    }

    private void testWriteTask(BlockingQueue<Task> qIn){
        System.out.println("Testing the creating of written tasks");
        createTestTask(qIn);
        for (Task item: qIn) {
            if (item.getID() == 0)
                if ("Moscow".equals(item.getCity()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == false");

            if (item.getID() == 1)
                if ("Novosibirsk".equals(item.getCity()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == false");

            if (item.getID() == 2)
                if ("Irkutsk".equals(item.getCity()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == false");

            if (item.getID() == 3)
                if ("Cheboksary".equals(item.getCity()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == false");

            if (item.getID() == 4)
                if ("St.Petersburg".equals(item.getCity()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == false");

            if (item.getID() == 5)
                if ("Latvia".equals(item.getCity()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == false");
        }
    }

    private void createTestArr(TaskGenerator taskGenerator) {
        ArrayList<String> arr = taskGenerator.getArr();
        arr.add("Moscow");
        arr.add("Novosibirsk");
        arr.add("Irkutsk");
        arr.add("Cheboksary");
        arr.add("St.Petersburg");
        arr.add("Latvia");
    }

    private void testWriteArr(TaskGenerator taskGenerator) {
        System.out.println("Testing the creating of written array of cities");
        createTestArr(taskGenerator);
        ArrayList tmp = taskGenerator.getArr();
        if (tmp == null) {
            System.out.println("Array was not created");
            return;
        }
        if ("Moscow".equals(tmp.get(0)))
            System.out.println(tmp.get(0) + " == true");
        else
            System.out.println(tmp.get(0) + " == false");

        if ("Novosibirsk".equals(tmp.get(1)))
            System.out.println(tmp.get(1) + " == true");
        else
            System.out.println(tmp.get(1) + " == false");

        if ("Irkutsk".equals(tmp.get(2)))
            System.out.println(tmp.get(2) + " == true");
        else
            System.out.println(tmp.get(2) + " == false");

        if ("Cheboksary".equals(tmp.get(3)))
            System.out.println(tmp.get(3) + " == true");
        else
            System.out.println(tmp.get(3) + " == false");

        if ("St.Petersburg".equals(tmp.get(4)))
            System.out.println(tmp.get(4) + " == true");
        else
            System.out.println(tmp.get(4) + " == false");

        if ("Latvia".equals(tmp.get(5)))
            System.out.println(tmp.get(5) + " == true");
        else
            System.out.println(tmp.get(5) + " == false");
    }

    private void createTestHashMap(TaskExecutor taskExecutor) {
        Map<String, String> hashMap = taskExecutor.getHashMap();
        hashMap.put("Moscow", "+12");
        hashMap.put("Novosibirsk", "-5");
        hashMap.put("Irkutsk", "0");
        hashMap.put("Cheboksary", "+20");
        hashMap.put("St.Petersburg", "+5");
        hashMap.put("Latvia", "-1");
    }

    private void testWriteHashMap(TaskExecutor taskExecutor){
        System.out.println("Testing the creation of written hashmap");
        createTestHashMap(taskExecutor);
        Map<String, String> hashMap = taskExecutor.getHashMap();
        if ("+12".equals(hashMap.get("Moscow")))
            System.out.println("Moscow +12 == true");
        else
            System.out.println("Moscow +12 == false");

        if ("-5".equals(hashMap.get("Novosibirsk")))
            System.out.println("Novosibirsk -5 == true");
        else
            System.out.println("Novosibirsk -5 == false");

        if ("0".equals(hashMap.get("Irkutsk")))
            System.out.println("Irkutsk 0 == true");
        else
            System.out.println("Irkutsk 0 == false");

        if ("+20".equals(hashMap.get("Cheboksary")))
            System.out.println("Cheboksary +20 == true");
        else
            System.out.println("Cheboksary +20 == false");

        if ("+5".equals(hashMap.get("St.Petersburg")))
            System.out.println("St.Petersburg +5 == true");
        else
            System.out.println("St.Petersburg +5 == false");

        if ("-1".equals(hashMap.get("Latvia")))
            System.out.println("Latvia -1 == true");
        else
            System.out.println("Latvia -1 == false");
    }

    private void createExecuteTask(BlockingQueue<Task> qIn, ArrayDeque<Task> qOut) {
        Task tmpTask;
        tmpTask = qIn.poll();
        if ("Moscow".equals(tmpTask.getCity()))
            tmpTask.setWeather("+12");
        qOut.offer(tmpTask);

        tmpTask = qIn.poll();
        if ("Novosibirsk".equals(tmpTask.getCity()))
            tmpTask.setWeather("-5");
        qOut.offer(tmpTask);

        tmpTask = qIn.poll();
        if ("Irkutsk".equals(tmpTask.getCity()))
            tmpTask.setWeather("0");
        qOut.offer(tmpTask);

        tmpTask = qIn.poll();
        if ("Cheboksary".equals(tmpTask.getCity()))
            tmpTask.setWeather("+20");
        qOut.offer(tmpTask);

        tmpTask = qIn.poll();
        if ("St.Petersburg".equals(tmpTask.getCity()))
            tmpTask.setWeather("+5");
        qOut.offer(tmpTask);

        tmpTask = qIn.poll();
        if ("Latvia".equals(tmpTask.getCity()))
            tmpTask.setWeather("-1");
        qOut.offer(tmpTask);
    }

    private void testWriteExecuteTask(BlockingQueue<Task> qIn, ArrayDeque<Task> qOut) {
        System.out.println("Testing the execution of written tasks");
        createExecuteTask(qIn, qOut);
        testExecuteTask(qOut);
    }

    private void testExecuteTask(ArrayDeque<Task> qOut){
        for (Task item: qOut) {
            if ("Moscow".equals(item.getCity()))
                if ("+12".equals(item.getWeather()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == false");

            if ("Novosibirsk".equals(item.getCity()))
                if ("-5".equals(item.getWeather()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == false");

            if ("Irkutsk".equals(item.getCity()))
                if ("0".equals(item.getWeather()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == false");

            if ("Cheboksary".equals(item.getCity()))
                if ("+20".equals(item.getWeather()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == false");

            if ("St.Petersburg".equals(item.getCity()))
                if ("+5".equals(item.getWeather()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == false");

            if ("Latvia".equals(item.getCity()))
                if ("-1".equals(item.getWeather()))
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == true");
                else
                    System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " " + item.getWeather() + " == false");
        }
    }

    private void testGenerateArr(TaskGenerator taskGenerator) throws Exception {
        System.out.println("Testing the generating of array of cities");
        taskGenerator.createArrOfCity();
        ArrayList<String> tmp = taskGenerator.getArr();
        if (tmp == null) {
            System.out.println("Array was not created");
            return;
        }
        if ("Moscow".equals(tmp.get(0)))
            System.out.println(tmp.get(0) + " == true");
        else
            System.out.println(tmp.get(0) + " == false");

        if ("Novosibirsk".equals(tmp.get(1)))
            System.out.println(tmp.get(1) + " == true");
        else
            System.out.println(tmp.get(1) + " == false");

        if ("Irkutsk".equals(tmp.get(2)))
            System.out.println(tmp.get(2) + " == true");
        else
            System.out.println(tmp.get(2) + " == false");

        if ("Cheboksary".equals(tmp.get(3)))
            System.out.println(tmp.get(3) + " == true");
        else
            System.out.println(tmp.get(3) + " == false");

        if ("St.Petersburg".equals(tmp.get(4)))
            System.out.println(tmp.get(4) + " == true");
        else
            System.out.println(tmp.get(4) + " == false");

        if ("Latvia".equals(tmp.get(5)))
            System.out.println(tmp.get(5) + " == true");
        else
            System.out.println(tmp.get(5) + " == false");
    }

    private void testGenerateTask(TaskGenerator taskGenerator, int counter, BlockingQueue<Task> qIn) throws Exception {
        System.out.println("Testing the generating of tasks");
        taskGenerator.generateTask(50, qIn);
        for (Task item: qIn) {
            boolean isTruthCity = false;
            ArrayList<String> arr = taskGenerator.getArr();
            for (String city: arr) {
                if (item.getCity().equals(city))
                    isTruthCity = true;
            }
            if (item.getID() != counter)
                isTruthCity = false;
            counter++;
            if (item.getDate() == null)
                isTruthCity = false;
            if (item.getWeather() != null)
                isTruthCity = false;
            System.out.println(item.getID() + " " + item.getDate() + " " + item.getCity() + " == " + isTruthCity);
        }
    }

    private void testGenerateHashMap(TaskExecutor taskExecutor) throws FileNotFoundException {
        System.out.println("Testing the generating of hashmap");
        taskExecutor.createHashMapQueue();
        Map<String, String> hashMap = taskExecutor.getHashMap();
        if ("+12".equals(hashMap.get("Moscow")))
            System.out.println("Moscow +12 == true");
        else
            System.out.println("Moscow +12 == false");

        if ("-5".equals(hashMap.get("Novosibirsk")))
            System.out.println("Novosibirsk -5 == true");
        else
            System.out.println("Novosibirsk -5 == false");

        if ("0".equals(hashMap.get("Irkutsk")))
            System.out.println("Irkutsk 0 == true");
        else
            System.out.println("Irkutsk 0 == false");

        if ("+20".equals(hashMap.get("Cheboksary")))
            System.out.println("Cheboksary +20 == true");
        else
            System.out.println("Cheboksary +20 == false");

        if ("+5".equals(hashMap.get("St.Petersburg")))
            System.out.println("St.Petersburg +5 == true");
        else
            System.out.println("St.Petersburg +5 == false");

        if ("-1".equals(hashMap.get("Latvia")))
            System.out.println("Latvia -1 == true");
        else
            System.out.println("Latvia -1 == false");
    }

    private void testGenerateExecuteTask(TaskExecutor taskExecutor, BlockingQueue<Task> qIn, ArrayDeque<Task> qOut) throws FileNotFoundException {
        System.out.println("Testing the executing of generated tasks");
        while (!qIn.isEmpty())
            taskExecutor.executeTask(qIn, qOut);
        testExecuteTask(qOut);
    }

    private void testThread(TaskExecutor taskExecutor, BlockingQueue<Task> qIn, ArrayDeque<Task> qOut) throws Exception {
        System.out.println("Testing the threads");
        createTestTask(qIn);
        createTestHashMap(taskExecutor);
        Worker worker = new Worker(taskExecutor, 200, qIn, qOut);
        Thread threadExecutor1 = new Thread(worker);
        Thread threadExecutor2 = new Thread(worker);
        threadExecutor1.start();
        threadExecutor2.start();
        Thread.sleep(2000);
        testExecuteTask(qOut);
        worker.close();
    }

    public void testAll() throws Exception {
        int counter = 0;
        TaskExecutor taskExecutor = new TaskExecutor();
        TaskGenerator taskGenerator = new TaskGenerator();
        BlockingQueue<Task> qIn = new LinkedBlockingQueue<>();
        ArrayDeque<Task> qOut = new ArrayDeque<>();

        testWriteArr(taskGenerator);
        testWriteTask(qIn);
        testWriteHashMap(taskExecutor);
        testWriteExecuteTask(qIn, qOut);

        taskExecutor = new TaskExecutor();
        taskGenerator = new TaskGenerator();
        qIn = new LinkedBlockingQueue<>();
        qOut = new ArrayDeque<>();

        testGenerateArr(taskGenerator);
        testGenerateTask(taskGenerator, counter, qIn);
        testGenerateHashMap(taskExecutor);
        testGenerateExecuteTask(taskExecutor, qIn, qOut);

        taskExecutor = new TaskExecutor();
        taskGenerator = new TaskGenerator();
        qIn = new LinkedBlockingQueue<>();
        qOut = new ArrayDeque<>();

        testWriteArr(taskGenerator);
        testWriteTask(qIn);
        testGenerateHashMap(taskExecutor);
        testGenerateExecuteTask(taskExecutor, qIn, qOut);

        taskExecutor = new TaskExecutor();
        qIn = new LinkedBlockingQueue<>();
        qOut = new ArrayDeque<>();

        testThread(taskExecutor, qIn, qOut);

        System.out.println();
    }
}
