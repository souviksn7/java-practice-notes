package ThreadNotes.Aa_Synchronized;

public class SharedResource {
    public synchronized void produce(){
        try {
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock released by: " + Thread.currentThread().getName());
    }
}