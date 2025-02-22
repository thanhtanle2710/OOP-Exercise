

public class TestPoint {
public static void main(String[] args) {
	Point2D p1= new Point3D(1, 2, 3);
	System.out.println(p1);
	System.out.println("x="+((Point3D) p1).getXYZ()[0]);
}
}
