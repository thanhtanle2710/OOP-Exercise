
public class TestPrint {
public static void main(String[] args) {
	SharePrint sp1= new SharePrint(100);
	PrintEvenNumbers p1= new PrintEvenNumbers(sp1);
	PrintOddNumbers p2= new PrintOddNumbers(sp1);
	p1.start();
	p2.start();
	
}
}
