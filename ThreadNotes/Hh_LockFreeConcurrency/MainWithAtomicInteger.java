package ThreadNotes.Hh_LockFreeConcurrency;

public class MainWithAtomicInteger {
    public static void main(String[] args) {
        SharedResourceWithAtomicInteger resource = new SharedResourceWithAtomicInteger();
        Thread thread1 = new Thread(()->{
            for(int i=0;i<4000;i++){
                resource.increaseCount();
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i=0;i<4000;i++){
                resource.increaseCount();
            }
        });
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(resource.getCount());
    }
}
