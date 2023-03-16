import java.util.concurrent.CountDownLatch;

public class CountDownDemo {
    public static void main(String[] args) throws InterruptedException {
        int noOfThreads = 2;
        CountDownLatch latch = new CountDownLatch(noOfThreads);
        //latch.await();

        for(int i = 0; i < noOfThreads; i++) {
            new Thread(new WorkerClass(latch)).start();
        }

        latch.await();
        System.out.println("All Threads are finished working");


    }
}
