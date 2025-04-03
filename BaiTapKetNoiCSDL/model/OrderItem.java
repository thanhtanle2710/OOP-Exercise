package model;

public class OrderItem {
private int OrderItemID;
private int OrderID;
private int ProductID;
private int quantity;
private double uprice;
public OrderItem(int orderItemID, int orderID, int productID, int quantity, double uprice) {
	super();
	OrderItemID = orderItemID;
	OrderID = orderID;
	ProductID = productID;
	this.quantity = quantity;
	this.uprice = uprice;
}
public int getOrderItemID() {
	return OrderItemID;
}
public void setOrderItemID(int orderItemID) {
	OrderItemID = orderItemID;
}
public int getOrderID() {
	return OrderID;
}
public void setOrderID(int orderID) {
	OrderID = orderID;
}
public int getProductID() {
	return ProductID;
}
public void setProductID(int productID) {
	ProductID = productID;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getUprice() {
	return uprice;
}
public void setUprice(double uprice) {
	this.uprice = uprice;
}

}
