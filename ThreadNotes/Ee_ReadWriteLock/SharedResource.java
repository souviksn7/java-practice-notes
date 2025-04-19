package ThreadNotes.Ee_ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {
    public void produce(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }
}
