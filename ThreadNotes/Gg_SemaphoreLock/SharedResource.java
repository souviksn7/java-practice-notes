package ThreadNotes.Gg_SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {
    Semaphore lock = new Semaphore(2);
    public void produce(){
        try{
            System.out.println("Available permits before acquiring: " + lock.availablePermits());
            lock.acquire();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.release();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
            System.out.println("Available permits after releasing: " + lock.availablePermits());
        }
    }
}
