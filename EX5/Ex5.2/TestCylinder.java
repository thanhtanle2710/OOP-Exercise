

public class TestCylinder {
public static void main(String[] args) {
	Circle c1= new Circle(3,"red");
	Cylinder cld= new Cylinder(c1, 5);
	System.out.println(cld);
}
}
