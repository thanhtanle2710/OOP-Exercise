

public class Test {
public static void main(String[] args) {
	MyIntStack m1= new MyIntStack(5);
	m1.pushLogic(1);
	m1.pushLogic(2);
	m1.pushLogic(5);
	m1.pushLogic(4);
	System.out.println(m1.pushLogic(9));
    System.out.println(m1.pop());
    m1.pushWithResize(10);
    System.out.println(m1.pop());
	
}
}
