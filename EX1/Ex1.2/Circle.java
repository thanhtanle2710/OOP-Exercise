
public class Circle {
private double radius;
public Circle() {
	this.radius =1.0;
	
}
public Circle(double radius) {
	this.radius = radius;
	
}
public double getRadius() {
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}


public String toString()
{
	return "Circle[radius="+this.radius+"]";
}
public double getArea()
{
	return this.radius*this.radius*Math.PI;
}
public double getCircumference()
{
    return this.radius*2*Math.PI;

}
}

