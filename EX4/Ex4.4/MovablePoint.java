

public class MovablePoint extends Point {
private float xSpeed;
private float ySpeed;
public MovablePoint(float x, float y,float xSpeed, float ySpeed) {
	super(x,y);
	this.xSpeed = xSpeed;
	this.ySpeed = ySpeed;
}
public MovablePoint(float xSpeed, float ySpeed) {
	super();
	this.xSpeed = xSpeed;
	this.ySpeed = ySpeed;
}
public MovablePoint() {
	super();
	this.xSpeed = 0.0f;
	this.ySpeed = 0.0f;
}
public float getxSpeed() {
	return xSpeed;
}
public void setxSpeed(float xSpeed) {
	this.xSpeed = xSpeed;
}
public float getySpeed() {
	return ySpeed;
}
public void setySpeed(float ySpeed) {
	this.ySpeed = ySpeed;
}
public float[] getSpeed() {
	float[] result = new float[2];
	result[0]=this.xSpeed;
	result[1]=this.ySpeed;
	return result;	
}
public void setSpeed(float xSpeed,float ySpeed) {
	this.xSpeed=xSpeed;
	this.ySpeed = ySpeed;
}
@Override
public String toString() {
	return super.toString()+",speed=("+this.xSpeed+","+this.ySpeed+")";
}
public MovablePoint move()
{
	setX(getX()+this.xSpeed);
	setY(getY()+this.ySpeed);
	return this;
	
	
}
}
