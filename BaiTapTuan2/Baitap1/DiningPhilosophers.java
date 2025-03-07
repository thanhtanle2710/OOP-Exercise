
public class DiningPhilosophers {
public static void main(String[] args) {
	final Philosopher []philosophers= new Philosopher[5];
	Object []dua = new Object[philosophers.length];
	for(int i=0;i<dua.length;i++)
	{
		dua[i]=new Object();
	}
	for (int i = 0; i < philosophers.length; i++) {
        Object duaTrai = dua[i];
        Object duaPhai = dua[(i + 1) % dua.length];

        if (i == philosophers.length - 1) {
            
            
            philosophers[i] = new Philosopher(duaPhai, duaTrai); 
        } else {
            philosophers[i] = new Philosopher(duaTrai,duaPhai);
        }
        
        Thread t 
          = new Thread(philosophers[i], "Philosopher " + (i + 1));
        t.start();
    }
}
}
