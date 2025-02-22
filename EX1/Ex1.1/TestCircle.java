
public class TestCircle {
public static void main(String[] args) {
	Circle c1=new Circle();
    System.out.println(c1);
    System.out.printf("Area= %.2f%n",c1.getArea());
    System.out.printf("Circumference=%.2f%n",c1.getCircumference());
    Circle c2= new Circle(15,"Yellow");
    System.out.println(c2);
    System.out.println("Radius= "+c2.getRadius()+" ,Color= "+c2.getColor());
    System.out.printf("Area=%.2f%n",c2.getArea());
    System.out.printf("Circumference=%.2f%n",c2.getCircumference());
}
}
