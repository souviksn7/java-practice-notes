package ThreadNotes.Jj_Future_CompletableFurure_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Ab_CallableExample {
    public static void main(String[] args) {
        // Callable represents the task which need to be executed just like Runnable
        // But diff is -
        // 1. Runnable don't have any return type.
        // 2. Callable has the capability to return it's value
        // 3. Callable can throw a checked exception

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // Usecase1
        Future<?> futureObj1 = poolExecutor.submit(()->{
            System.out.println("Task 1 with runnable");
        });

        try{
            Object object = futureObj1.get();
            System.out.println(object == null);
        } catch (Exception e) {
        }

        // Usecase2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj = poolExecutor.submit(()->{
            System.out.println("Task 2 with runnable");
            output.add(10);
        }, output);

        try{
            List<Integer> outputFromObj2 = futureObj.get();
            System.out.println(outputFromObj2.get(0));
        } catch (Exception e) {
        }

        // Usecase3
        Future<List<Integer>> futureObj3 = poolExecutor.submit(()->{
           System.out.println("Task 3 with callable");
           List<Integer> listObj = new ArrayList<>();
            listObj.add(20);
           return listObj;
        });

        try{
            List<Integer> outputFromObj3 = futureObj3.get();
            System.out.println(outputFromObj3.get(0));
        } catch (Exception e) {
        }

        // It tells the executor not to accept any new tasks, but it allows already submitted tasks to complete.
        poolExecutor.shutdown();
    }
}
