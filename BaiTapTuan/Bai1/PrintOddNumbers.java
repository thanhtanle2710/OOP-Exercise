
public class PrintOddNumbers extends Thread {
private SharePrint shareprint;
public PrintOddNumbers(SharePrint shareprint) {
	this.shareprint=shareprint;
}
public void run() {
    shareprint.PrintOddNumbers();
	
}

}
