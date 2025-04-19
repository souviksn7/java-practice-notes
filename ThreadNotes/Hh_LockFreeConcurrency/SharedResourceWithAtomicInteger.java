package ThreadNotes.Hh_LockFreeConcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResourceWithAtomicInteger {
    private AtomicInteger count = new AtomicInteger(0);

    void increaseCount(){
        count.incrementAndGet();
    }
    public int getCount(){
        return count.get();
    }
}
