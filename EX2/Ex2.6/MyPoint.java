

public class MyPoint {
private int x=0;
private int y=0;
public MyPoint() {
	
}
public MyPoint(int x, int y) {
	this.x = x;
	this.y = y;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public void setXY(int x,int y)
{
	setX(x);
	setY(y);
}
public int [] getXY()
{   
	int []getxy= {x,y};
	return getxy;
}
@Override
public String toString() {
	return "(x=" + x + ", y=" + y + ")";
}
public double distance(int x,int y)
{
	int deltaX=this.x-x;
	int deltaY=this.y-y;
	return Math.sqrt(deltaX*deltaX)+Math.sqrt(deltaY*deltaY);
}
public double distance(MyPoint another)
{
	int deltaX=this.x-another.getX();
	int deltaY=this.y-another.getY();
	return Math.sqrt(deltaX*deltaX)+Math.sqrt(deltaY*deltaY);
}
public double distance()
{
	return Math.sqrt(x*x)+Math.sqrt(y*y);
}


}
