

public class Container {
private int x1;
private int y1;
private int x2;
private int y2;
public Container(int x1, int y1, int width, int heigth) {
	super();
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = this.x1+width-1;
	this.y2 = this.x2+heigth-1;
}
public int getX() {
	return x1;
}
public int getY() {
	return y1;
}
public int getWidth()
{
	return x2-x1+1;
}
public int getHeight()
{
	return y2-y1+1;
}
@Override
public String toString() {
	return "Container [(" + x1 + "," + y1 + ", (" + x2 + "," + y2 + ")]";
}
public boolean collidesWith(Ball ball) {
	   if (ball.getX() - ball.getRadius() <= this.x1 ||
	       ball.getX() + ball.getRadius() >= this.x2) {
	      ball.reflectHorizontal();
	      return true;
	   }else if(ball.getY() - ball.getRadius() <= this.y1 ||
		       ball.getY() + ball.getRadius() >= this.y2)
	   {
		    
			      ball.reflectVertical();
			      return true;
	   }
	   
	   return false;
}
}
