

public class TestMyCircle {
public static void main(String[] args) {
	MyPoint p1=new MyPoint(5, 5);
	MyCircle c1=new MyCircle(p1, 3);
	System.out.println(c1);
	System.out.println("Area="+c1.getArea());
	System.out.println("Circumference="+c1.getCircumference());
	MyPoint p2=new MyPoint(4, 4);
	MyCircle c2=new MyCircle(p2, 2);
	System.out.println("Distance="+c2.distance(c1));
}
}
