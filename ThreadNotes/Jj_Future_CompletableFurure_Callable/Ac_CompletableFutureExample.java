package ThreadNotes.Jj_Future_CompletableFurure_Callable;

import java.util.concurrent.*;

public class Ac_CompletableFutureExample {
    public static void main(String[] args) {
        try{
            // It is an advanced version of future, provides additional capabilities like chaining.
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
                // This is the task which need to be completed by thread.
                return "task completed";
            }, poolExecutor);// Passing the custom executor

            System.out.println(asyncTask1.get());

        } catch (Exception e) {
        }
    }
}
