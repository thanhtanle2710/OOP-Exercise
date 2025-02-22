

public class TestMovablePoint {
public static void main(String[] args) {
	MovablePoint m1= new MovablePoint(2, 3, 6,6);
	System.out.println(m1);
	m1.moveDown();
	m1.moveRight();
	System.out.println(m1);
}
}
