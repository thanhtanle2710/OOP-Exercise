

public class Line {
private Point begin;
private Point end;
public Line(Point begin, Point end) {
	this.begin = begin;
	this.end = end;
}
public Line(int beginX, int beginY, int endX, int endY) {
	begin=new Point(beginX, beginY);
	end=new Point(endX, endY);
}
public Point getBegin()
{
	return new Point(getBeginX(), getBeginY());
}
public Point getEnd()
{
	return new Point(getEndX(), getEndY());
}
public void setBegin(int beginX, int beginY)
{
	begin.setXY(beginX, beginY);
}
public void setEnd(int endX, int endY)
{
	end.setXY(endX, endY);
}
public int getBeginX() {
	return begin.getX();
}
public void setBeginX(int x) {
	begin.setX(x);
}
public int getEndX() {
	return end.getX();
}
public void setEndX(int x) {
	end.setX(x);
}
public int getBeginY() {
	return begin.getY();
}
public void setBeginY(int y) {
	begin.setY(y);
}
public int getEndY() {
	return end.getY();
}
public void setEndY(int y) {
	end.setY(y);
}
public int[] getBeginXY()
{
	int []getbeginXY= {getBeginX(),getBeginY()};
	return getbeginXY;
}
public void setBeginXY(int x,int y)
{
	setBeginX(x);
	setBeginY(y);
}
public int[] getEndXY()
{
	int []getendXY= {getEndX(),getEndY()};
	return getendXY;
}
public void setEndXY(int x,int y)
{
	setEndX(x);
	setEndY(y);
}
public double getLength()
{  
	int xDiff=this.getBeginX()-this.getEndX();
	int yDiff=this.getBeginY()-this.getEndY();
	return  Math.sqrt(xDiff*xDiff + yDiff*yDiff);
}
public double getGradient()
{
	return Math.atan2( getBeginY()-getEndY(),getBeginX()-getEndX());
}
@Override
public String toString() {
	return "MyLine [begin=" + begin + ", end=" + end + "]";
}


}
