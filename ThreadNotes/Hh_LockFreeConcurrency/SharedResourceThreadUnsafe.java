package ThreadNotes.Hh_LockFreeConcurrency;

public class SharedResourceThreadUnsafe {
    private int count = 0;
    void increaseCount(){
        count++;
    }
    int getCount(){
        return count;
    }
}
