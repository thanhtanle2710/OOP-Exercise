

public class Player {
private int number;
private float x;
private float y;
private float z=0.0f;
public Player(int number, float x, float y) {
	this.number = number;
	this.x = x;
	this.y = y;

}
public void move(float xDisp,float yDisp)
{
	this.x+=xDisp;
	this.y=yDisp;
}
public void jump(float zDisp)
{
	this.z+=zDisp;
}
public boolean near(Ball ball)
{
	float dx = this.x - ball.getX();
    float dy = this.y - ball.getY();
    float dz = this.z - ball.getZ();
    double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
    return distance < 8;
}
public void kick(Ball ball)
{
	 if (near(ball)) {
	        float newX = ball.getX() + 10; 
	        float newY = ball.getY() + 5;  
	        float newZ = ball.getZ() + 2; 
	        
	        ball.setXYZ(newX, newY, newZ);
	    }

}
@Override
public String toString() {
	return "Player [number=" + number + ", x=" + x + ", y=" + y + "]";
}

}
