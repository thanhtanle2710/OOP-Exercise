package model;

import java.sql.Date;

public class Order {
private int OrderID;
private int CustomerID;
private Date date;
private double amount;
public Order(int orderID, int customerID, Date date, double amount) {
	super();
	OrderID = orderID;
	CustomerID = customerID;
	this.date = date;
	this.amount = amount;
}
public int getOrderID() {
	return OrderID;
}
public void setOrderID(int orderID) {
	OrderID = orderID;
}
public int getCustomerID() {
	return CustomerID;
}
public void setCustomerID(int customerID) {
	CustomerID = customerID;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

}
