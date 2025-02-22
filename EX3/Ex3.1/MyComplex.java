

public class MyComplex {
private double real=0.0;
private double imag=0.0;
public MyComplex() {
}
public MyComplex(double real, double imag) {
	this.real = real;
	this.imag = imag;
}
public double getReal() {
	return real;
}
public void setReal(double real) {
	this.real = real;
}
public double getImag() {
	return imag;
}
public void setImag(double imag) {
	this.imag = imag;
}
public void setValue(double real, double imag)
{
	setReal(real);
	setImag(imag);
}
@Override
public String toString() {
	return "("+real+"+"+imag+"i)";
}
public boolean isReal()
{
	if(imag==0)
	{
		return true;
	}
	return false;
}
public boolean isImaginary()
{
	if(real==0)
	{
		return true;
	}
	return false;
}
public boolean equals(double real,double image)
{
	return (this.real==real)&&(this.imag==image);
}
public boolean equals(MyComplex another)
{
	return (this.real==another.real)&&(this.imag==another.imag);
}
public double magnitude()
{
	return Math.sqrt(real*real+imag*imag);
}
public MyComplex addInto(MyComplex right)
{   
	real+=right.real;
	imag+=right.imag;
	return this;
}
public MyComplex addNew(MyComplex right)
{   
	real+=right.real;
	imag+=right.imag;
	return new MyComplex(real, imag);
}


}
