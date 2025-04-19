package ThreadNotes.Jj_Future_CompletableFurure_Callable;

import java.util.concurrent.*;

public class Aa_FutureExample {
    public static void main(String[] args) {
        // The Future Interface represents the result of an asynchronous computation in java.
        // It provides methods to check if computation is complete, wait etc. It can retrieve the result once it's available

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = poolExecutor.submit(()->{
            try{
                Thread.sleep(7000);
            } catch (Exception e) {
            }
            System.out.println("This is the task which thread will create");
        });

        // Caller is checking the status of the thread it created
        System.out.println("Checking if the task is done or not: " + futureObj.isDone());

        // Caller is checking if the task is completed. And waits for 2 seconds.
        try{
            futureObj.get(2, TimeUnit.SECONDS);
        }catch(TimeoutException e){
            System.out.println("Timeout Exception happened");
        }catch (Exception e) {
        }

        // Caller is waiting until the task is completed.
        try{
            futureObj.get();
        }catch (Exception e) {
        }

        System.out.println("Is done: " + futureObj.isDone());
        System.out.println("Is cancelled: " + futureObj.isCancelled());

        // It tells the executor not to accept any new tasks, but it allows already submitted tasks to complete.
        poolExecutor.shutdown();
    }
}
