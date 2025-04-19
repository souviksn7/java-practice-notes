package ThreadNotes.Jj_Future_CompletableFurure_Callable;

import java.util.concurrent.CompletableFuture;

public class Af_theAcceptAndThenAcceptAsync {
    public static void main(String[] args) throws Exception{
        //// theAccept and theAcceptAsync
        // Generally end stage, in the chain of Async operation. Consumes the result of a previous stage.
        // Does NOT return a new value (returns CompletableFuture<Void>)
        // Is typically used when you want to perform a side-effect (e.g., printing/logging/saving the result), but don't need to pass the result further down the chain.

            CompletableFuture<Void> asyncTask1 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which runs supplyAsync: " + Thread.currentThread().getName());
                return "Hello world";
            }).thenAccept((String value)->{
                System.out.println("All stages completed of: " + value);
            });
    }
}
