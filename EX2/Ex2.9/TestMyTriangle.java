

public class TestMyTriangle {
public static void main(String[] args) {
	MyPoint p1= new MyPoint(2, 3);
	MyPoint p2= new MyPoint(4, 5);
	MyPoint p3= new MyPoint(6, 7);
	MyTriangle t1= new MyTriangle(p1, p2,p3);
	System.out.println(t1.getPerimeter());
	System.out.println(t1.getType());
}

}
