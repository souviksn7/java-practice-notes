package ThreadNotes.Gg_SemaphoreLock;

public class Main {
    // A Semaphore in Java is a synchronization mechanism that controls access to a shared resource by multiple threads.
    // It restricts the number of threads that can access a critical section at the same time.

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread thread1 = new Thread(()->{
           resource.produce();
        });

        Thread thread2 = new Thread(()->{
            resource.produce();
        });

        Thread thread3 = new Thread(()->{
            resource.produce();
        });

        Thread thread4 = new Thread(()->{
            resource.produce();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
