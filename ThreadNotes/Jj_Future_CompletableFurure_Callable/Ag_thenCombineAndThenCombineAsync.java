package ThreadNotes.Jj_Future_CompletableFurure_Callable;

import java.util.concurrent.CompletableFuture;

public class Ag_thenCombineAndThenCombineAsync {
    public static void main(String[] args) throws Exception{
        //// thenCombine() and thenCombineAsync()

        // These methods are used when you want to combine the results of two independent CompletableFutures and produce a single result.

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("cf1 done by thread: " + Thread.currentThread().getName());
            return "Hello ";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("cf2 done by thread: " + Thread.currentThread().getName());
            return "World ";
        });

        CompletableFuture<String> combinedResult = cf1.thenCombine(cf2, (result1, result2)->{
            System.out.println("Combination done by thread: " + Thread.currentThread().getName());
            return result1+result2;
        });

        System.out.println(combinedResult.get());
    }
}
