
public class PrintEvenNumbers extends Thread{
	private SharePrint shareprint;
	public PrintEvenNumbers(SharePrint shareprint) {
		this.shareprint=shareprint;
	}
@Override
public void run() {
    shareprint.PrintEvenNumbers();
	
}
}

