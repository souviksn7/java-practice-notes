package ThreadNotes.Bb_ProducerConsumer;

public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(5);

        Thread producerThread = new Thread(()->{
            try{
                for(int i=1;i<=11;i++){
                    sharedResource.produceItem(i);
//                    Thread.sleep(1000);
                }
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(()->{
            try{
                for(int i=1;i<=11;i++){
                    sharedResource.consumeItem();
//                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        consumerThread.start();
        producerThread.start();

    }
}
