

public class TestMyPolynomial {
public static void main(String[] args) {
	MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
	System.out.println(p1);
	System.out.println("Degree="+p1.getDegree());
	double[] coeffs = {1.2, 3.4, 5.6, 7.8};
	MyPolynomial p2 = new MyPolynomial(coeffs);
	System.out.println(p2);
	System.out.println("Degree="+p2.getDegree());
	System.out.println("Evaluate="+p2.evaluate(1));
	System.out.println(p1.add(p2));
	System.out.println(p1.multiply(p2));
}
}
