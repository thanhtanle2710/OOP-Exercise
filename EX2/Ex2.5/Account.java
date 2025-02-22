

public class Account {
private int id;
private Customer customer;
private double balance=0;
public Account(int id, Customer customer, double balance) {
	this.id = id;
	this.customer = customer;
	this.balance = balance;
}
public Account(int id, Customer customer) {
	this.id = id;
	this.customer = customer;
}
public int getId() {
	return id;
}
public Customer getCustomer() {
	return customer;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getCustomerName()
{
	return customer.getName();
}
public String toString()
{
	return customer.toString()+" balance=$"+balance;
}
public void deposit(double Amount)
{   
	balance+=Amount;
}
public void withdraw(double Amount)
{   
	if(balance>=Amount)
	{
		balance-=Amount;
	}
	else
	{
		System.out.println("amount withdrawn exceeds the current balance!");
	}
	
}



}
