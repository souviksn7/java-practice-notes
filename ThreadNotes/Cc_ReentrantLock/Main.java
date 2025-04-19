package ThreadNotes.Cc_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        // Here locking does not depend on objects like synchronized method. It depends on the lock we are passing through method or resource object.
        // If we have a requirement that we can have different objects but still we have to allow only one thread into the critical section,
        // Then we will use ReentrantLock.


        ReentrantLock lock  = new ReentrantLock();
        SharedResource resource1 = new SharedResource();
        Thread thread1 = new Thread(()->{
            resource1.produce(lock);
        });

        SharedResource resource2 = new SharedResource();
        Thread thread2 = new Thread(()->{
            resource2.produce(lock);
        });

        thread1.start();
        thread2.start();
    }
}
