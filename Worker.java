import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;

class Worker implements Runnable {
    private TaskExecutor taskExecutor;
    private int sleepTime;
    private boolean isThreadActive = true;
    BlockingQueue<Task> qIn;
    ArrayDeque<Task> qOut;

    public Worker(TaskExecutor taskExecutor, int sleepTime, BlockingQueue<Task> qIn, ArrayDeque<Task> qOut) {
        this.taskExecutor = taskExecutor;
        this.sleepTime = sleepTime;
        this.qIn = qIn;
        this.qOut = qOut;
    }

    @Override
    public void run() {
        while (isThreadActive) {
            try {
                Thread.sleep(sleepTime);
                taskExecutor.executeTask(qIn, qOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        isThreadActive = false;
    }
}