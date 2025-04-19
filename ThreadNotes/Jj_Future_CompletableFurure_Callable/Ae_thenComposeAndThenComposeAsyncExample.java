package ThreadNotes.Jj_Future_CompletableFurure_Callable;

import java.util.concurrent.*;

public class Ae_thenComposeAndThenComposeAsyncExample {
    public static void main(String[] args) throws Exception{
        // thenCompose() and thenComposeAsync() both are used to chain asynchronous operations.
        // where the next step returns another CompletableFuture
        // Both are used to flatten nested CompletableFuture

            // Creating the thread pool
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            //// thenCompose()

            // Executes the next stage in the same thread that completed the previous future (if already complete or running on the same thread).
            // Useful when you want sequential async calls.
            // It flatten the 2 CompletableFuture into one CompletableFuture unlike thenApply().
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which runs supplyAsync: " + Thread.currentThread().getName());
                return "Hello ";
            }).thenCompose((String val)->{
                return CompletableFuture.supplyAsync(()->{
                    return val + "world ";
                });
            });

            System.out.println(asyncTask1.get());

            //  It tells the executor not to accept any new tasks, but it allows already submitted tasks to complete.
            poolExecutor.shutdown();
    }
}
