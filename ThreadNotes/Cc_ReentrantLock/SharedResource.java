package ThreadNotes.Cc_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {


    public void produce(ReentrantLock lock){
        try{
            lock.lock();
            // System.out.println() is not thread-safe, meaning multiple threads might interleave while printing, causing unexpected output where both "Lock acquired" and "Lock released" appear to print at the same time.
            //By wrapping System.out.println() inside synchronized (System.out), we ensured that only one thread at a time can execute print statements.
            synchronized (System.out) {
                System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            }
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            // System.out.println() is not thread-safe, meaning multiple threads might interleave while printing, causing unexpected output where both "Lock acquired" and "Lock released" appear to print at the same time.
            //By wrapping System.out.println() inside synchronized (System.out), we ensured that only one thread at a time can execute print statements.
            synchronized (System.out) {
                System.out.println("Lock released by: " + Thread.currentThread().getName());
            }
        }
    }
}
