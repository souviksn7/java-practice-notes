package ThreadNotes.Mm_ThreadLocalExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    public static void main(String str[]){
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();
        ExecutorService poolObj = Executors.newFixedThreadPool(5);

        poolObj.submit(()->{
           // setting something related to task 1.
           threadLocalObj.set("Related to task1: " + Thread.currentThread().getName());

           // My work completed, now clean up

           threadLocalObj.remove();
        });


        for(int i=0;i<15;i++){
            // If I had not cleaned up threadLocalObj, it would get the previous task's data.
            // So we must clean up threadLocal after using it.
            poolObj.submit(()->{
                System.out.println(threadLocalObj.get());
            });
        }
    }
}
