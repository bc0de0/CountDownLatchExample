import java.util.concurrent.CountDownLatch;

public class WorkerClass implements Runnable{
    private CountDownLatch latch;

    public WorkerClass(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public void run() {
        System.out.println("Current Thread is: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " has finished its task");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}
