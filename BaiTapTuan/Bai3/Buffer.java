
import java.util.ArrayList;

public class Buffer{
    private int capacity;
    private ArrayList<Integer>products= new ArrayList<>();
    public Buffer(int capacity)
    {
  
        this.capacity=capacity;
    }
    public int getSize()
    {
        return products.size();
    }
    public synchronized void addProduct(int product,int producerID) throws InterruptedException
    {     
        while(products.size()>=this.capacity)
        {
        	wait();
        }
    	System.out.println("Producer "+producerID+ " added product "+product);
          products.add(product);
          System.out.println("Inventory quantity: "+getSize());
          notify();
          
    }
    public synchronized void removeProduct(int consumerID)
    {
    	while(products.size()<=0) {      
        	try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}      	
        }  
        System.out.println("Consumer "+consumerID+" taken product "+products.get(0));
        products.remove(products.get(0));
        System.out.println("Inventory quantity: "+getSize());
        notify();
        
    }
    public int getCapacity() {
        return capacity;
    }
}
