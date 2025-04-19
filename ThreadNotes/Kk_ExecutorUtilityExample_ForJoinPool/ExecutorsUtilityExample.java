package ThreadNotes.Kk_ExecutorUtilityExample_ForJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ExecutorsUtilityExample {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> futureObj = pool.submit(new ComputeSumTask(1, 100));
        try{
            System.out.println(futureObj.get());
        }catch(Exception e){

        }
    }
}

class ComputeSumTask extends RecursiveTask<Integer> {
    int start;
    int end;
    public ComputeSumTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start <= 4){
            int totalSum = 0;
            for(int i=start; i<=end ;i++){
                totalSum+=i;
            }
            return totalSum;
        }else{
            //Split the task
            int mid = (start+end)/2;
            ComputeSumTask leftTask = new ComputeSumTask(start, mid);
            ComputeSumTask rightTask = new ComputeSumTask(mid+1, end);

            //Fork sub-tasks for parallel execution
            leftTask.fork();
            rightTask.fork();

            //Combine the results of subtasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //Combine the results
            return leftResult+rightResult;
        }
    }
}
