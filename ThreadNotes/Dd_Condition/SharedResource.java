package ThreadNotes.Dd_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    ReentrantLock lock;
    Condition condition;
    Boolean isAvailable = false;
    public SharedResource(ReentrantLock lock){
        this.lock = lock;
        condition = lock.newCondition();
    }
    public void produce(){
        try{
            lock.lock();
            synchronized (System.out){
                System.out.println("Producer Lock acquired by: " + Thread.currentThread().getName());
            }
            if(isAvailable){
                // Already available. Thread has to wait for it to consume
                synchronized (System.out){
                    System.out.println("Producer thread is waiting: " + Thread.currentThread().getName());
                }
                condition.await();
            }
            isAvailable = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            synchronized (System.out){
                System.out.println("Producer lock released by: " + Thread.currentThread().getName());
            }
        }
    }

    public void consume(){
        try{
            Thread.sleep(2000);
            lock.lock();
            synchronized (System.out){
                System.out.println("Consumer Lock acquired by: " + Thread.currentThread().getName());
            }

            if(!isAvailable){
                // Already available. Thread has to wait for it to produce
                synchronized (System.out){
                    System.out.println("Consumer thread is waiting: " + Thread.currentThread().getName());
                }
                condition.await();
            }
            isAvailable = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            synchronized (System.out){
                System.out.println("Consumer lock released by: " + Thread.currentThread().getName());
            }
        }
    }
}
