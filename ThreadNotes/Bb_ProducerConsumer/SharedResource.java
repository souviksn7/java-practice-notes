package ThreadNotes.Bb_ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    int maxSize;
    Queue<Integer> que;
    public SharedResource(int maxSize){
        this.maxSize = maxSize;
        que = new LinkedList<>();
    }

    public synchronized void produceItem(int item) throws Exception{
        while(que.size() == maxSize){
            System.out.println("Buffer is full, producer is waiting for consumer");
            wait();
        }
        que.add(item);
        System.out.println("Item produced: "+ item);
        notifyAll(); //notifies all other threads(who are using this resource) that this synchronised block's work is over and monitor-lock is released now
    }

    public synchronized void consumeItem() throws Exception{
        while(que.isEmpty()){
            System.out.println("Buffer is empty, consumer is waiting for producer");
            wait(); //notifies all other threads(who are using this resource) that this synchronised block's is going to waiting state and monitor-lock is released now
        }
        int item = que.poll();
        System.out.println("Item consumed: "+ item);
        notifyAll();
    }
}
