

public class TestMovablePoint {
public static void main(String[] args) {
	Point p1= new MovablePoint(1, 2, 3, 4);
	System.out.println(p1);
	//move 
	((MovablePoint)p1).move();
	//After move
	System.out.println(p1);
}
}
