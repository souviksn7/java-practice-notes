package ThreadNotes.Ff_StampedLock;

public class Main {
    public static void main(String[] args) {
        // Support Read/Write Lock functionality like ReadWriteLock
        // Support Optimistic Lock functionality too.
        // Optimistic Locking is a concurrency control mechanism used to prevent conflicts when multiple transactions or threads try to update the same record in a database simultaneously. It assumes that conflicts are rare and allows transactions to proceed without locking the data until the final update. If a conflict is detected at the time of update, the transaction is rolled back.

        SharedResource resource = new SharedResource();
        Thread thread1 = new Thread(()->{
           resource.produce();
        });

        Thread thread2 = new Thread(()->{
           resource.consume();
        });

        thread1.start();
        thread2.start();
    }
}
