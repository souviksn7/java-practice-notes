package ThreadNotes.Aa_Synchronized;

public class Main {
    public static void main(String[] args) {
        // Here we are putting monitor lock on the resource object. Each thread is using different resource objects.
        // That's why both can access resource object simultaneously. If both thread use same resource object, then only one thread can use resource object at a time.

        SharedResource resource1 = new SharedResource();
        Thread thread1 = new Thread(()->{
            resource1.produce();
        });

        SharedResource resource2 = new SharedResource();
        Thread thread2 = new Thread(()->{
            resource2.produce();
        });

        thread1.start();
        thread2.start();
    }
}
