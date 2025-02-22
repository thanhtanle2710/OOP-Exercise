

public class Rectangle implements GeometricObject{
private double width;
private double length;
	public Rectangle(double width, double length) {
	this.width = width;
	this.length = length;
}
	@Override
	public String toString() {
		return "Rectangle2 [width=" + width + ", length=" + length + "]";
	}
	@Override
	public double getArea() {
		return this.width*this.length;
	}

	@Override
	public double getPerimeter() {
		return (this.width+this.length)*2;
	}

}
