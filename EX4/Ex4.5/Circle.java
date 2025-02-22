

public class Circle extends Shape{
	private double radius;
	public Circle() {
		this.radius =1.0;
	}
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public Circle(String color, boolean filled,double radius) {
		super(color,filled);
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getArea()
	{
		return this.radius*this.radius*Math.PI;
	}
	public double getCircumference()
	{
	    return this.radius*2*Math.PI;

	}
	public String toString()
	{
		return "Circle["+super.toString()+",radius="+this.radius+"]";
				
	}
}
