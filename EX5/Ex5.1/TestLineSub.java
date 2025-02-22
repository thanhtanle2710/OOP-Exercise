

public class TestLineSub {
public static void main(String[] args) {

    Point p1 = new Point(2, 3);
    Point p2 = new Point(6,18);
	LineSub l1= new LineSub(p1, p2);
	System.out.println(l1);
	System.out.println(l1.getLength());
	System.out.println(l1.getGradient());
}
}
