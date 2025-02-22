

public class LineSub extends Point {
private Point end;
public LineSub (int beginX, int beginY, int endX, int endY) {
    super(beginX, beginY);             
    this.end = new Point(endX, endY);  
 }
public LineSub (Point begin, Point end) {  
    super(begin.getX(), begin.getY());      
    this.end = end;
 }
public String toString() {
	return "MyLine [begin=" + super.toString() + ", end=" + end + "]";
}
public Point getBegin() { 
	return new Point(super.getX(), super.getY());
}
public Point getEnd() { 
	return new Point(end.getX(),end.getY());
}
public void setBegin(int beginX, int beginY) { 
super.setXY(beginX,beginY);
}
public void setEnd(int endX, int endY) { 
end.setXY(endX, endY);
}
public int getBeginX()
{
	return super.getX();
}
public int getBeginY() { 
	return super.getY();
}
public int getEndX() { 
	return end.getX();
}
public int getEndY() {
	return end.getY();
}
public void setBeginX(int beginX) {
	super.setX(beginX);
}
public void setBeginY(int beginY) { 
	super.setY(beginY);
}
public void setBeginXY(int beginX,int beginY) {
	super.setXY(beginX, beginY);
}
public void setEndX(int endX) { 
	end.setX(endX);
}
public void setEndY(int endY) { 
	end.setY(endY);
}
public void setEndXY(int endX,int endY) { 
	end.setXY(endX, endY);
}
public double getLength() { 
	int xDiff=this.getBeginX()-this.getEndX();
	int yDiff=this.getBeginY()-this.getEndY();
	return  Math.sqrt(xDiff*xDiff + yDiff*yDiff);
 }
public double getGradient()
{
	return Math.atan2( getBeginY()-getEndY(),getBeginX()-getEndX());
}


}
