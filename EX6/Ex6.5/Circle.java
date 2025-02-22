

public class Circle implements GeometricObject{
protected double radius;
public Circle(double radius) {
	this.radius = radius;
}
@Override
public String toString() {
	return "Circle3 [radius=" + radius + "]";
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
