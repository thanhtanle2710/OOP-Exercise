
public class SharePrint {
private int count=0;
private int N;
public SharePrint(int N) {
	this.N=N;
}
public synchronized void PrintEvenNumbers()
{
	while(count<=N)
	{
		while(count%2!=0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Even number "+count);
		count++;
		notify();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
public synchronized void PrintOddNumbers()
{
	while(count<=N)
	{
		while(count%2==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Odd number "+count);
		count++;
		notify();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
}
