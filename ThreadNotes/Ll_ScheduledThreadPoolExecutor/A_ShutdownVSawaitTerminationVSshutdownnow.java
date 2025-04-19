package ThreadNotes.Ll_ScheduledThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A_ShutdownVSawaitTerminationVSshutdownnow {
    public static void main(String[] args) {
        ExecutorService poolObj = Executors.newFixedThreadPool(5);
        poolObj.submit(()->{
            try{
                Thread.sleep(5000);
            }catch(Exception e){
            }
            // Shutdown do not impact the already submitted task
            System.out.println("Thread going to start it's work: " + Thread.currentThread().getName());
        });

//        poolObj.shutdown();
//        System.out.println("Main thread unblocked and finished processing: " + Thread.currentThread().getName());

///////// Will give error as new tak is getting submitted after shutdown() method is called
//        poolObj.submit(()->{
//            System.out.println("Submitting new task after shutdown");
//        });

///////// Usage of awaitTermination
///////// It will return true only if shutdown method is called and all the tasks have been finished it's work
//        try{
//            boolean isExecutorTerminated = poolObj.awaitTermination(3, TimeUnit.SECONDS);
//            System.out.println("Main thread, isExecutorTerminated: " + isExecutorTerminated);
//        }catch(Exception e){
//
//        }

///////// Usage of shutdownnow()
///////// It interrupts the actively executing tasks. Haults the process of tasks which is waiting. Return the list of task which awaiting execution
        poolObj.shutdownNow();

        System.out.println("Main thread is completed");
    }
}
