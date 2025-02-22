

public class MyPolynomial {
private double[] coeffs;

public MyPolynomial(double... coeffs) {
	this.coeffs = coeffs;
}
public int getDegree()
{
	return coeffs.length-1;
}

public double evaluate(double x)
{   
	double result=0;
	for(int i=0;i<coeffs.length;i++)
	{
		result+=coeffs[i]*Math.pow(x, i);
	}
	return result;
}
public MyPolynomial add(MyPolynomial right)
{
	int maxDegree=Math.max(this.getDegree(), right.getDegree());
	double[] result= new double[maxDegree+1];
	for(int i=0;i<=maxDegree;i++)
	{
		double coeff1=(this.coeffs.length>i)?this.coeffs[i]:0;
		double coeff2=(right.coeffs.length>i)?right.coeffs[i]:0;
		result[i]=coeff1+coeff2;
	}
	return new MyPolynomial(result);
}
public MyPolynomial multiply(MyPolynomial another) {
    int newDegree = this.getDegree() + another.getDegree();
    double[] resultCoeffs = new double[newDegree + 1];
    for(int i=0;i<this.coeffs.length;i++)
    {
    	for(int j=0;j<another.coeffs.length;j++)
    	{
    		 resultCoeffs[i + j] += this.coeffs[i] * another.coeffs[j];
    	}
    	
    }
    return new MyPolynomial(resultCoeffs);
}
public String toString() {
    StringBuilder sb = new StringBuilder();
    int degree = getDegree();

    for (int i = degree; i >= 0; i--) {
        if (coeffs[i] == 0) continue;

        if (sb.length() > 0) {
            sb.append(coeffs[i] > 0 ? " + " : " - ");
        } else if (coeffs[i] < 0) {
            sb.append("-");
        }

        double absCoeff = Math.abs(coeffs[i]);
        if (absCoeff != 1 || i == 0) {
            sb.append(absCoeff);
        }

        if (i > 0) {
            sb.append("x");
            if (i > 1) {
                sb.append("^").append(i);
            }
        }
    }
    return sb.toString();
}

}
