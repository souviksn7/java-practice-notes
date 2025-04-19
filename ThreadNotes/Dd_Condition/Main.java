package ThreadNotes.Dd_Condition;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        // When we are using custom locks, we have to use await() and signal() instead of wait() and notify() which we use in monitor lock.
        // if signal() is used, any arbitrary thread will be notified. If signalall() is used, all threads will be notified.
        ReentrantLock lock = new ReentrantLock();
        SharedResource resource1 = new SharedResource(lock);
        Thread thread1 = new Thread(()->{
            for(int i=0;i<2;i++){
                resource1.produce();
            }
        });

//        SharedResource resource2 = new SharedResource(lock);
        Thread thread2 = new Thread(()->{
            for(int i=0;i<2;i++){
                resource1.consume();
            }
        });

        thread1.start();
        thread2.start();
    }
}
