package ThreadNotes.Ll_ScheduledThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class B_ScheduledThreadpoolExecutor {
    public static void main(String[] args) {

        ScheduledExecutorService poolObj = Executors.newScheduledThreadPool(5);

        // Ignore it:
        // We have to keep the main thread alive till it's delay time over(like get or sleep method).
        // Otherwise, the main thread will be shut down.
        // Interview ans: "Although both schedule() and scheduleAtFixedRate() use the same pool, only periodic tasks like scheduleAtFixedRate() acquire and hold onto a worker thread immediately. The one-time schedule() task simply waits in the queue without occupying a thread until execution time. This distinction causes the JVM to stay alive in the periodic case, but not in the one-time case unless blocked by something like get() or sleep()."

        // Schedules a runnable or callable task after a fixed delay. Only one time task runs
//        Future<String> futureObj = poolObj.schedule(()->{
//            return "hello";
//        }, 2, TimeUnit.SECONDS);
//
//        try {
//            System.out.println(futureObj.get());
//        } catch (Exception e){}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Schedules a runnable task for repeated execution with fixed rate.
        // We can cancel the method to stop this repeated task.
        // Also lets say, thread1 this taking too much time to complete the task and the next task is ready to run, till the previous task not get completed, new task cannot be start (it will wait in queue)
//        Future<?> futureObj1 = poolObj.scheduleAtFixedRate(()->{
//            System.out.println("starting the task");
//
//            try{
//                Thread.sleep(6000);
//            }catch(Exception e){}
//
//            System.out.println("Completed the task");
//        }, 1, 3, TimeUnit.SECONDS);
//
//        try{
//            Thread.sleep(20000);
//            futureObj1.cancel(true);
//            System.out.println("It was cancelled");
//        }catch(Exception e){}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Schedules a runnable task for repeated execution with a fixed delay.
        // Means next task's delay counter starts only after previous one task completed.
        Future<?> futureObj2 = poolObj.scheduleWithFixedDelay(()->{
            System.out.println("starting the task");

            try{
                Thread.sleep(6000);
            }catch(Exception e){}

            System.out.println("Completed the task");
        }, 1, 3, TimeUnit.SECONDS);

        try{
            Thread.sleep(10000);
            futureObj2.cancel(true);
            System.out.println("It was cancelled");
        }catch(Exception e){}
    }
}
