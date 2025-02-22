

public class MyLine {
private MyPoint begin;
private MyPoint end;
public MyLine(MyPoint begin, MyPoint end) {
	this.begin = begin;
	this.end = end;
}
public MyLine(int x1,int y1,int x2,int y2) {
	begin.setX(x1);
	begin.setY(y1);
	end.setX(x2);
	end.setY(y2);
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
	return begin.distance(end);
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
