

public class TestResizableCircle {
public static void main(String[] args) {
	ResizableCircle r1 = new ResizableCircle(3);
	System.out.println(r1);
	System.out.println(r1.getArea());
	r1.resize(50);
	System.out.println(r1);
}
}
