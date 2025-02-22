

public class Circle implements GeometricObject{
private double radius;
	public Circle(double radius) {
	this.radius = radius;
}
	@Override
	public String toString() {
		return "Circle2 [radius=" + radius + "]";
	}

	@Override
	public double getArea() {
		
		return Math.PI*this.radius*this.radius ;
	}

	@Override
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}

}
