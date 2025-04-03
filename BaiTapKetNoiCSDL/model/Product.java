package model;

public class Product {
private int productID;
private String name;
private String decription;
private double price;
private int stockquantity;
public Product(int productID, String name, String decription, double price, int stockquantity) {
	super();
	this.productID = productID;
	this.name = name;
	this.decription = decription;
	this.price = price;
	this.stockquantity = stockquantity;
}
public int getProductID() {
	return productID;
}
public void setProductID(int productID) {
	this.productID = productID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDecription() {
	return decription;
}
public void setDecription(String decription) {
	this.decription = decription;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getStockquantity() {
	return stockquantity;
}
public void setStockquantity(int stockquantity) {
	this.stockquantity = stockquantity;
}

}
