package ThreadNotes.Ee_ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    // ReadLock: More than 1 thread can acquire the read lock
    // WriteLock: Only 1 thread can acquire the write lock.
    // When to use it?: When your read are very high compared to your write request. Like 1000 times read and 10 times write

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();

        SharedResource resource1 = new SharedResource();
        Thread thread1 = new Thread(()->{
            resource1.produce(lock);
        });

        SharedResource resource2 = new SharedResource();
        Thread thread2 = new Thread(()->{
            resource2.produce(lock);
        });

        SharedResource resource3 = new SharedResource();
        Thread thread3 = new Thread(()->{
            resource3.consume(lock);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
