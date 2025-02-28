


public class Producer extends Thread {
    private int producerID;
    private Buffer buffer;
    public Producer(int producerID,Buffer buffer){
        this.producerID=producerID;
        this.buffer=buffer;
    }
    @Override
    public void run(){
        
        while(true){  
               try {
				buffer.addProduct((int)(Math.random()*100), producerID);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

