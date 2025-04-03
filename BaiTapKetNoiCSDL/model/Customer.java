package model;

public class Customer {
private int Customerid;
private String name;
private String email;
private String address;
public Customer(int Customerid, String name, String email, String address) {
	super();
	this.Customerid = Customerid;
	this.name = name;
	this.email = email;
	this.address = address;
}
public int getId() {
	return this.Customerid;
}
public void setId(int  Customerid) {
	this.Customerid = Customerid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
