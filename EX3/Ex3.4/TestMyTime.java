

public class TestMyTime {
public static void main(String[] args) {
	MyTime t1= new MyTime();
	t1.setTime(00, 00, 00);
	System.out.println(t1);
	t1.previousHour();
	System.out.println(t1);
}
}
