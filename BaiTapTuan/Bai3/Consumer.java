
public class Consumer extends Thread{
    private int consumerID;
    private Buffer buffer;
    public Consumer(int consumerID,Buffer buffer)
    {
        this.consumerID=consumerID;
        this.buffer=buffer;
    }
    @Override
    public void run(){
        while(true){
        	buffer.removeProduct(consumerID);
        	 try {
                 sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
            
           
        }
    }

}
