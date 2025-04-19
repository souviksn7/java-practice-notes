package ThreadNotes.Ii_ThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // ThreadPoolExecutor is a flexible and powerful class in the java.util.concurrent package that provides a mechanism to execute tasks using a pool of threads.
        // It implements the ExecutorService interface and allows you to manage how many threads run concurrently, how tasks are queued, and how idle threads are handled.

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(3), new CustomThreadFactory(),
                new CustomRejectedHandler());
        poolExecutor.allowCoreThreadTimeOut(true);

        for(int i=1;i<=7;i++){
            poolExecutor.submit(()->{
                try{
                    Thread.sleep(2000);
                    System.out.println("Thread name: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        poolExecutor.shutdown();
    }
}

class CustomRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //logging
        System.out.println("Task denied: " + r.toString());
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        return th;
    }
}


