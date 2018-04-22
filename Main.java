import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskExecutor taskExecutor = new TaskExecutor();
        Logger logger = new Logger();
        TaskGenerator taskGenerator = new TaskGenerator();
        BlockingQueue<Task> qIn = new LinkedBlockingQueue<>();
        ArrayDeque<Task> qOut = new ArrayDeque<>();
        TestBlock testBlock = new TestBlock();

        testBlock.testAll();

        Generator generator = new Generator(taskGenerator, 100, 100, qIn);
        Worker worker = new Worker(taskExecutor, 300, qIn, qOut);
        Printer printer = new Printer(logger,100, qOut);

        Thread threadGenerator = new Thread(generator);
        Thread threadExecutor1 = new Thread(worker);
        Thread threadExecutor2 = new Thread(worker);
        Thread threadExecutor3 = new Thread(worker);
        Thread threadLogger = new Thread(printer);

        threadGenerator.start();
        threadExecutor1.start();
        threadExecutor2.start();
        threadExecutor3.start();
        threadLogger.start();

        threadGenerator.join();
        while (!qIn.isEmpty()){
            Thread.sleep(1000);
        }
        worker.close();
        while (!qOut.isEmpty()){
            Thread.sleep(1000);
        }
        printer.close();
    }
}