package ThreadNotes.Ff_StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();
    public void produce(){
        Long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic lock");
            a = 11;
            Thread.sleep(4000);
            if(lock.validate(stamp)){
                System.out.println("Updated a value successfully");
            }else{
                System.out.println("Rollback of work");
                a = 10;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void consume(){
        long stamp = lock.writeLock();
        System.out.println("Lock acquired by: " + Thread.currentThread().getName());

        System.out.println("Performing work");
        a = 9;

        lock.unlockWrite(stamp);
        System.out.println("Write lock released by: " + Thread.currentThread().getName());
    }
}
