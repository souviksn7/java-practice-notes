package ThreadNotes.Jj_Future_CompletableFurure_Callable;

import java.util.concurrent.*;

public class Ad_ThenApplyAndThenApplyAsyncExample {
    public static void main(String[] args) throws Exception{
        // thenApply and thenApplyAsync apply a function to the result of previous Async Computation
        // Return a new Completable object
        // It’s used when the function returns a plain value (not a future).
        // Use When: You want to transform the result of the previous stage into a new value.

            // Creating the thread pool
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            //// thenApply method:

            // 1. It's a synchronous execution
            // 2. Means, it uses the same thread which completed the previous async task

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
                // This is the task which need to be completed by thread.
                return "Concept and ";
            }, poolExecutor).thenApply((String val)->{
                // Functionally which can work on the previous Async operation
                // It uses the same thread which completed the previous Async task. No new thread is created.
                return val + "Coding";
            });

            System.out.println(asyncTask1.get());

// -----------------------------------------------------------------------------------------------------------------

            //// thenApplyAsync method:

            // It's an Async execution. Means it uses different thread(from 'fork-join' pool, if we don't provide the executor in the method), to complete the function
            // If multiple 'thenApplyAsync' is used without chaining, ordering cannot be guaranteed, they will run concurrently. If it's in chaining, ordering is guaranteed.
            // but a new thread is not guaranteed
            // There's no obligation to run on a new thread — just a different execution path.
            // If the scheduler found the same thread it will reuse it.

            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which runs supplyAsync: " + Thread.currentThread().getName());
                return "Concept and ";
            }).thenApplyAsync((String val)->{
                System.out.println("Thread name which runs thenApplyAsync: " + Thread.currentThread().getName());
                return val + "Coding";
            });

            System.out.println("Thread name for after CF: " + Thread.currentThread().getName());

            System.out.println(asyncTask2.get());

// -------------------------------------------------------------------------------------------------------------

            //// Example without chaining of Completable Future

            // Here, I am not chaining task1, task2 and task3. So ordering cannot be guaranteed
            CompletableFuture<String> task1 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which adds 'Concept and ': " + Thread.currentThread().getName());
                return "Concept and ";
            });

            CompletableFuture<String> task2 = task1.thenApplyAsync((String val)->{
                try{
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread name which adds 'Coding': " + Thread.currentThread().getName());
                return val + "Coding ";
            });

            CompletableFuture<String> task3 = task1.thenApplyAsync((String val)->{
                System.out.println("Thread name which adds 'on Youtube': " + Thread.currentThread().getName());
                return val + "on Youtube ";
            });

            System.out.println("Hello " + task2.get());

// ---------------------------------------------------------------------------------------------------------------------------

            //// Example of thenApply() when it returns nested Completable Future which does not flatten the Completable Future
            // It is not recommended. Use thenCompose() instead.

            CompletableFuture<CompletableFuture<String>> nested = fetchUser()
                    .thenApply((String user)-> {
                        return fetchUserProfile(user);
                    }
            );

            // using get() fn twice because it was not flatten by thenApply. To avoid it, use thenCompose()
            System.out.println(nested.get().get());

            //  It tells the executor not to accept any new tasks, but it allows already submitted tasks to complete.
            poolExecutor.shutdown();
    }
    //// Example of thenApply() when it returns nested Completable Future which does not flatten the Completable Future
    // It is not recommended. Use thenCompose() instead.

    static CompletableFuture<String> fetchUser() {
        return CompletableFuture.supplyAsync(() -> "Souvik");
    }

    static CompletableFuture<String> fetchUserProfile(String user) {
        return CompletableFuture.supplyAsync(() -> "Profile of " + user);
    }
}

