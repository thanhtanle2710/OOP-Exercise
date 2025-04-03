package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Product;
import view.OrderManagementView;

public class Controller implements ActionListener {
public OrderManagementView view;
public Controller(OrderManagementView view) {
	this.view=view;
}
	@Override
	public void actionPerformed(ActionEvent e) {
String src= e.getActionCommand();
		
		//switchtabel
		if(src.equals("CUSTOMERS"))
		{
			view.cardlayoutTable.show(view.table_panel, "Customer");
			view.cardLayoutform.show(view.form_panel,"Customer Form");
            
          
        
		}
		else if(src.equals("ORDERS"))
		{
			view.cardlayoutTable.show(view.table_panel, "Order");
			view.cardLayoutform.show(view.form_panel,"Order Form");
			
		}
		else if(src.equals("ORDER_ITEMS"))
		{
			view.cardlayoutTable.show(view.table_panel, "Order_Item");
			view.cardLayoutform.show(view.form_panel,"Order Item Form");
		}
		else if(src.equals("PRODUCTS"))
		{
			view.cardlayoutTable.show(view.table_panel, "Product");
			view.cardLayoutform.show(view.form_panel,"Product Form");
		}
		if(src.equals("ADD"))
		{   
			if(view.order_panel.isShowing())
			{
				
				int orderID=Integer.parseInt(view.orderID_field.getText());
				
				int dayDOB=(int) view.dayBox1.getSelectedItem();
				int monthDOB= (int) view.monthBox1.getSelectedItem();
				int yearDOB= (int) view.yearBox1.getSelectedItem();
				LocalDate ldDate= LocalDate.of(yearDOB, monthDOB, dayDOB);
				Date dateSQLDOB= Date.valueOf(ldDate);
				int customerID=Integer.parseInt(view.customerID_field.getText());
				
				OrderDAO.getInstance().insert(new Order(orderID, customerID, dateSQLDOB, 0));
				view.capnhatbangOrder();
			}
			else if(view.customer_panel.isShowing())
			{   
				
				
				int id=Integer.parseInt(view.CustomerID_field.getText());
				String name=view.name_Field.getText();
				String email=view.emailfield.getText();
				String address=view.address_Field.getText();
				CustomerDAO.getInstance().insert(new Customer(id, name, email, address));
				view.capnhatbangCustomer();
			}
			else if(view.product_panel.isShowing())
			{
				int id=Integer.parseInt(view.ProductID_field1.getText());
				String name=view.Name_Product_Field.getText();
				String dep=view.DecriptionField.getText();
				double price=Double.parseDouble(view.Price_Product_Field.getText());
				int stockquantity=Integer.parseInt(view.StockQuantityField.getText());
				ProductDAO.getInstance().insert(new Product(id, name, dep, price, stockquantity));
				view.capnhatbangProduct();
			}
			else if(view.order_item_panel.isShowing())
			{
				int orderItemID=Integer.parseInt(view.OrderItemID_field.getText());
				int orderID=Integer.parseInt(view.OrderID2_Field.getText());
				int productID=Integer.parseInt(view.productIDField.getText());
				int quantity=Integer.parseInt(view.quantity_Field.getText());
				double uprice=Double.parseDouble(view.priceField.getText());
				OrderItemDAO.getInstance().insert(new OrderItem(orderItemID, orderID, productID, quantity, uprice));
				view.capnhatbangOrderItem();
				
			}
		}
		else if(e.getSource()==view.search_button)
		{
			if(view.order_panel.isShowing())
			{
				int id= Integer.parseInt(view.search_field.getText());
				OrderDAO.getInstance().Search(id);
				view.showOrderSelected(id);
						
			}
		}
		else if(src.equals("RESET"))
		{
			if(view.order_panel.isShowing())
			{
				view.orderID_field.setText("");
				view.customerID_field.setText("");
				view.dayBox1.setSelectedIndex(0);
				view.monthBox1.setSelectedIndex(0);
				view.yearBox1.setSelectedIndex(0);
				
				view.capnhatbangOrder();
				
				
			}
			else if(view.product_panel.isShowing())
			{
				view.ProductID_field1.setText("");
				view.Name_Product_Field.setText("");
				view.DecriptionField.setText("");
				view.StockQuantityField.setText("");
				view.Price_Product_Field.setText("");
				view.capnhatbangProduct();
			}
			else if(view.order_item_panel.isShowing())
			{
				view.OrderItemID_field.setText("");
				view.OrderID2_Field.setText("");
				view.productIDField.setText("");
				view.quantity_Field.setText("");
				view.priceField.setText("");
				view.capnhatbangOrderItem();
			}
			else if(view.customer_panel.isShowing())
			{
				view.CustomerID_field.setText("");
				view.name_Field.setText("");
				view.emailfield.setText("");
				view.address_Field.setText("");
				view.capnhatbangCustomer();
			}
		}
	}
		
	

}
