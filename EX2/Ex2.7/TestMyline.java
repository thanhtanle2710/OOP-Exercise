

public class TestMyline {
public static void main(String[] args) {
	MyPoint begin=new MyPoint(2, 3);
	MyPoint end=new MyPoint(3,4);
	MyLine myline=new MyLine(begin, end);
	System.out.println("x="+myline.getBeginXY()[0]+",y="+myline.getBeginXY()[1]);

	System.out.println("x="+myline.getEndXY()[0]+",y="+myline.getEndXY()[1]);
	System.out.println(myline.getLength());
	System.out.printf("%.2f%n",myline.getGradient());
}
}
