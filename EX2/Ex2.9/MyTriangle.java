
public class MyTriangle {
private MyPoint v1;
private MyPoint v2;
private MyPoint v3;
public MyTriangle(int x1,int y1,int x2,int y2,int x3,int y3 ) {
	v1.setX(x1);
	v1.setY(y1);
	v2.setX(x2);
	v2.setY(y2);
	v3.setX(x3);
	v3.setY(y3);
	
}
public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
	super();
	this.v1 = v1;
	this.v2 = v2;
	this.v3 = v3;
}
@Override
public String toString() {
	return "MyTriangle [v1=" + v1.toString() + ", v2=" + v2.toString() + ", v3=" + v3.toString() + "]";
}
public double getPerimeter()
{   
	double a=v1.distance(v2);
	double b=v1.distance(v3);
	double c=v2.distance(v3);
	return a+b+c;
}
public String getType()
{
	double a=v1.distance(v2);
	double b=v1.distance(v3);
	double c=v2.distance(v3);
	if(a==b&&b==c&&a==c)
	{
		return "Equilateral";
	}
	else if(a==b||b==c||a==c)
	{
		
			return "Isosceles";
		
	}
	else
	{
		return "Scalene";
	}
}




}
