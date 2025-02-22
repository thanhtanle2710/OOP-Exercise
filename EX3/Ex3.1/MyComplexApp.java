

import java.util.ArrayList;
import java.util.Scanner;

public class MyComplexApp {
public static void main(String[] args) {
	ArrayList<MyComplex> mycomplex= new ArrayList<MyComplex>();
	Scanner sc= new Scanner(System.in);
	for(int i=0;i<2;i++)
	{
		System.out.println("Enter complex number " +(i+1)+ "(real and imaginary part): ");
		double real=sc.nextDouble();
		double imag=sc.nextDouble();
		mycomplex.add(new MyComplex(real, imag));
	}
	for(int i=0;i<2;i++)
	{
		System.out.println("Number "+(i+1)+" is:"+mycomplex.get(i).toString());
		System.out.println(mycomplex.get(i).toString()+" is "+mycomplex.get(i).isReal()+" a pure real number");
		System.out.println(mycomplex.get(i).toString()+" is "+mycomplex.get(i).isImaginary()+" a pure Imaginary number");
	}
	System.out.println(mycomplex.get(0).toString()+"is "+mycomplex.get(0).equals(mycomplex.get(1))+" equal to "+mycomplex.get(1).toString());
	System.out.println(mycomplex.get(0).toString()+"+"+mycomplex.get(1).toString()+"="+mycomplex.get(0).addNew(mycomplex.get(1)));
}
}
