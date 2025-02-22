
public class Account {
private String id;
private String name;
private int balance;
public Account(String id, String name) {
	super();
	this.id = id;
	this.name = name;
	
}
public Account(String id, String name, int balance) {
	super();
	this.id = id;
	this.name = name;
	this.balance = balance;
}
public String getID() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public void credit(int amount)
{
	 this.balance=this.balance+amount;
}
public void debit(int amount)
{
	if(amount<=this.balance)
		 this.balance=this.balance-amount;
	else
		System.out.println("Amount exceeded balance");
}
public void transferTo(Account another ,int amount)
{
	if(amount<=this.balance)
	{
		this.balance=this.balance-amount;
		another.balance=another.balance+amount;
	}
	else
	{
		System.out.println("Amount exceeded balance");
	}
}
@Override
public String toString() {
	return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
}

}
