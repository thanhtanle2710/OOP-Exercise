

import java.util.Date;

public class Visit {
private Customer customer;
private Date date;
private double serviceExpense;
private double productExpense;
public Visit( String name,Date date) {
	
	this.customer= new Customer(name);
	this.date = date;
	
}
public String getName()
{
	return this.customer.getName();
}
public double getServiceExpense() {
	return serviceExpense;
}
public void setServiceExpense(double serviceExpense) {
	this.serviceExpense = serviceExpense;
}
public double getProductExpense() {
	return productExpense;
}
public void setProductExpense(double productExpense) {
	this.productExpense = productExpense;
}
@Override
public String toString() {
	return "Visit [customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense + ", productExpense="
			+ productExpense + "]";
}
public double getTotalExpense() {
	return serviceExpense+productExpense;
}


}
