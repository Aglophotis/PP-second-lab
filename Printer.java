import java.util.ArrayDeque;

class Printer implements Runnable {

    private Logger logger;
    private ArrayDeque<Task> qOut;
    private int sleepTime;
    private boolean isThreadActive = true;

    public Printer(Logger logger, int sleepTime, ArrayDeque<Task> qOut) {
        this.logger = logger;
        this.qOut = qOut;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while (isThreadActive) {
            try {
                Thread.sleep(sleepTime);
                logger.printExecuteTask(qOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        isThreadActive = false;
    }
}
