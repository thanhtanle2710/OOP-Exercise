package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import dao.CustomerDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Product;

public class OrderManagementView extends JFrame
{
	Controller ac= new Controller(this);
   private Font button_font;
public CardLayout cardlayoutTable;
public JPanel table_panel;
public JPanel customer_panel;
public JPanel order_panel;
public JPanel order_item_panel;
public JPanel product_panel;
public CardLayout cardLayoutform;
public JPanel form_panel;
private Font tableheader_font;
private JTable orderTable;
private JPanel order_form_panel;
public JTextField orderID_field;
public JTextField customerID_field;
public JComboBox<Integer> dayBox1;
public JComboBox<Integer> monthBox1;
public JComboBox<Integer> yearBox1;
public JButton search_button;
public JTextField search_field;
private JButton add_button;
private JTable OrderItemTable;
private JPanel order_item_form_panel;
public JTextField OrderItemID_field;
public JTextField OrderID2_Field;
public JTextField quantity_Field;
public JTextField priceField;
public JTextField productIDField;
private JTable CustomerTable;
private JPanel customer_form_panel;
public JTextField CustomerID_field;
public JTextField name_Field;
public JTextField emailfield;
public JTextField address_Field;
public JButton reset_button;
private JTable ProductTable;
private JPanel product_form_panel;
public JTextField ProductID_field1;
public JTextField Name_Product_Field;
public JTextField DecriptionField;
public JTextField Price_Product_Field;
public JTextField StockQuantityField;

public OrderManagementView(){
	   this.init();
   }

private void init() {
	this.setTitle("Order Management");
	this.setSize(1270,550);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setResizable(false);
	button_font= new Font("Arial", Font.BOLD, 17);
	JPanel toolbar_panel= new JPanel();
	JToolBar toolbar= new JToolBar(JToolBar.VERTICAL);
	toolbar.setLayout(new GridLayout(4,1,10,20));
	JButton product_button= new JButton("PRODUCTS");
	product_button.setFont(button_font);
	product_button.addActionListener(ac);
	JButton customer_button= new JButton("CUSTOMERS");
	customer_button.setPreferredSize(new Dimension(20, 50));
	customer_button.setFont(button_font);
    customer_button.addActionListener(ac);
	JButton order_button= new JButton("ORDERS");
	 order_button.setFont(button_font);
	 order_button.addActionListener(ac);
	JButton order_item_button= new JButton("ORDER_ITEMS");
	order_item_button.setFont(button_font);
	order_item_button.addActionListener(ac);
	toolbar.add(product_button);
	toolbar.add(customer_button);
	toolbar.add(order_button);
	toolbar.add(order_item_button);
	
	toolbar_panel.add(toolbar);
	JPanel main_panel= new JPanel();
	main_panel.setLayout(null);
	 cardlayoutTable= new CardLayout();
	  table_panel = new JPanel(cardlayoutTable);
	 //
	customer_panel= new JPanel();
	customer_panel.setBackground(new Color(255, 250, 205));
	 order_panel= new JPanel();
	 order_panel.setBackground(Color.CYAN);
	 order_item_panel= new JPanel();
	 order_item_panel.setBackground(new Color(255, 240, 245));
	product_panel= new JPanel();
	product_panel.setBackground(new Color(144, 238, 144));
	table_panel.add(product_panel,"Product");
	table_panel.add(customer_panel,"Customer");
	table_panel.add(order_panel,"Order");
	table_panel.add(order_item_panel,"Order_Item");
	
	table_panel.setBackground(Color.PINK);
	main_panel.add(table_panel);
	table_panel.setBounds(0, 0, 780, 512);
	cardLayoutform = new CardLayout();
	 form_panel= new JPanel(cardLayoutform);
	form_panel.setBackground(Color.CYAN);
	main_panel.add(form_panel);
	form_panel.setBounds(780, 80, 320, 300);
	//
JSplitPane spl= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolbar_panel,main_panel);
	
//	JSplitPane spl= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolbar_panel, info_panel);
	spl.setOneTouchExpandable(true);
	spl.setDividerLocation(155);
	Dimension minimum= new Dimension(100, 50);
	toolbar_panel.setMinimumSize(minimum);
	main_panel.setMinimumSize(minimum);
	 tableheader_font= new Font("Arial", Font.BOLD, 16);
	 //product
	  String []columnsNameProduct= {"ProductID","Name","Decription","Price","StockQuantity"};
		DefaultTableModel modelProduct= new DefaultTableModel(columnsNameProduct,0);
		ProductTable= new JTable(modelProduct);	
		ProductTable.getTableHeader().setFont(tableheader_font);
		JScrollPane ProductScrollPane= new JScrollPane(ProductTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		product_panel.setLayout(null); 
		ProductScrollPane.setBounds(10, 70, 760, 400); 
		Border ProductBorer = BorderFactory.createLineBorder(Color.BLUE, 3);
		TitledBorder titleBorderProduct= BorderFactory.createTitledBorder(ProductBorer," Product Table ");
		ProductScrollPane.setBorder(titleBorderProduct);
		product_panel.add(ProductScrollPane);
		product_form_panel= new JPanel();
		product_form_panel.setLayout(null);
		 
		for (Product p : ProductDAO.getInstance().selectAll()) {
			modelProduct.addRow(new Object[]{
		    p.getProductID(),p.getName(),p.getDecription(),p.getPrice(),p.getStockquantity()
		  
		    });
		}
	    JLabel ProductID_label= new JLabel("ProductID:");
	    ProductID_label.setFont(tableheader_font);
	    ProductID_label.setBounds(10, 0, 100, 50);
	    
	    product_form_panel.add(ProductID_label);
	    ProductID_field1= new JTextField(50);
	    ProductID_field1.setFont(tableheader_font);
	    ProductID_field1.setBounds(120, 15, 150,25);
	    product_form_panel.add(ProductID_field1);
	    JLabel name= new JLabel("Name:");
	    name.setFont(tableheader_font);
	    name.setBounds(10, 35, 110, 50);
	    product_form_panel.add(name);
	    Name_Product_Field= new JTextField(50);
	    Name_Product_Field.setFont(tableheader_font);
	    Name_Product_Field.setBounds(120, 50, 150,25);
	    //OrderID2_Field.getDocument().addDocumentListener(ac);
	    product_form_panel.add(Name_Product_Field);
	    //
	 
	    //
	    JLabel Decription= new JLabel("Decription:");
	    Decription.setFont(tableheader_font);
	    Decription.setBounds(10, 70, 110, 50);
	    product_form_panel.add(Decription);
	    DecriptionField= new JTextField();
	    DecriptionField.setFont(tableheader_font); 
	    DecriptionField.setBounds(120, 80,150,25);
	    product_form_panel.add(DecriptionField);
	    //
	    JLabel Price_Label= new JLabel("Price:");
	    Price_Label.setFont(tableheader_font);
	    Price_Label.setBounds(10, 100, 100, 50);
	    product_form_panel.add(Price_Label);
	    Price_Product_Field= new JTextField(50);
	    Price_Product_Field.setFont(tableheader_font);
	    Price_Product_Field.setBounds(120, 115, 150,25);
	     
	     product_form_panel.add(Price_Product_Field);
	    
	     JLabel StockQuantity_Label= new JLabel("StockQuantity:");
	     StockQuantity_Label.setFont(tableheader_font);
	     StockQuantity_Label.setBounds(10, 140, 100, 50);
	     product_form_panel.add(StockQuantity_Label);
	     StockQuantityField= new JTextField(50);
	     StockQuantityField.setFont(tableheader_font);
	     StockQuantityField.setBounds(120, 155, 150,25);
	      product_form_panel.add(StockQuantityField);
	     //
	    form_panel.add(product_form_panel,"Product Form");
	 //customer
	 String []columnsNameCustomer= {"CustomerID","Name","Email","Address"};
		DefaultTableModel modelCustomer= new DefaultTableModel(columnsNameCustomer,0);
		CustomerTable= new JTable(modelCustomer);
//		enrollmentTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		CustomerTable.getTableHeader().setFont(tableheader_font);
		//OrderItemTable.addMouseListener(ac);
//		for (Payment p : PaymentDAO.getInstance().selectAll()) {
//		    modelPayment.addRow(new Object[]{
//		        p.getPaymentID(),p.getEnrollmentID(),p.getTuitionFee(),p.getAmountPaid(),formatSqlDate(p.getDate()),p.getStatus(),p.getDetails()
//		    });
//		}
		 
		for (Customer c : CustomerDAO.getInstance().selectAll()) {
			modelCustomer.addRow(new Object[]{
		       c.getId(),c.getName(),c.getEmail(),c.getAddress()
		  
		    });
		}
		JScrollPane CustomerScrollPane= new JScrollPane(CustomerTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		customer_panel.setLayout(null); 
		CustomerScrollPane.setBounds(10, 70, 760, 400); 
		Border CustomerBorer = BorderFactory.createLineBorder(Color.BLUE, 3);
		TitledBorder titleBorderCustomer= BorderFactory.createTitledBorder(CustomerBorer," Customer Table ");
		
		CustomerScrollPane.setBorder(titleBorderCustomer);
		customer_panel.add(CustomerScrollPane);
		customer_form_panel= new JPanel();
		customer_form_panel.setLayout(null);
	    JLabel CustomerID_label= new JLabel("CustomerID:");
	    CustomerID_label.setFont(tableheader_font);
	    CustomerID_label.setBounds(10, 0, 100, 50);
	    
	    customer_form_panel.add(CustomerID_label);
	    CustomerID_field= new JTextField(50);
	    CustomerID_field.setFont(tableheader_font);
	    CustomerID_field.setBounds(120, 15, 150,25);
	    customer_form_panel.add(CustomerID_field);
	    JLabel nameProduct= new JLabel("Name:");
	    nameProduct.setFont(tableheader_font);
	    nameProduct.setBounds(10, 35, 110, 50);
	    customer_form_panel.add(nameProduct);
	    name_Field= new JTextField(50);
	    name_Field.setFont(tableheader_font);
	    name_Field.setBounds(120, 50, 150,25);
	    //OrderID2_Field.getDocument().addDocumentListener(ac);
	    customer_form_panel.add(name_Field);
	    //
	 
	    //
	    JLabel email= new JLabel("Email:");
	    email.setFont(tableheader_font);
	    email.setBounds(10, 70, 110, 50);
	    customer_form_panel.add(email);
	    emailfield= new JTextField();
	    emailfield.setFont(tableheader_font); 
	    emailfield.setBounds(120, 80,150,25);
	    customer_form_panel.add(emailfield);
	    //
	    JLabel address= new JLabel("Address:");
	    address.setFont(tableheader_font);
	    address.setBounds(10, 100, 100, 50);
	    customer_form_panel.add(address);
	     address_Field= new JTextField(50);
	     address_Field.setFont(tableheader_font);
	     address_Field.setBounds(120, 115, 150,25);
	     
	     customer_form_panel.add(address_Field);
	     form_panel.add(customer_form_panel,"Customer Form");
	    
	     
	 //
	//order
	String []columnsNameOrder= {"OrderID","CustomerID","OrderDate","OrderTotalAmount"};
	DefaultTableModel modelOrder= new DefaultTableModel(columnsNameOrder,0);
	 orderTable= new JTable(modelOrder);
	 orderTable.getTableHeader().setFont(tableheader_font);
	 for (Order o : OrderDAO.getInstance().selectAll()) {
		    modelOrder.addRow(new Object[]{
		        o.getOrderID(),
		        o.getCustomerID(),
		        formatSqlDate(o.getDate()),
		        o.getAmount()
		        
		      
		        
		    });
		}
	 //orderTable.addMouseListener(ac);
//	for(Student sv: StudentDAO.getInstance().selectAll())
//	{
//		modelStudent.addRow(new Object[] { sv.getStudentId(),
//		        sv.getFullname(),
//		        formatSqlDate(sv.getDOB()),
//		        sv.getEmail(),
//		        sv.getPhonenumber(),
//		        });
//	}
	
	JScrollPane orderScrollPane= new JScrollPane(orderTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	order_panel.setLayout(null); 
    orderScrollPane.setBounds(10, 70, 760, 400); 
	Border orderBorer = BorderFactory.createLineBorder(Color.BLUE, 3);
	TitledBorder titleBorderOrder= BorderFactory.createTitledBorder(orderBorer," Order Table ");
	
	orderScrollPane.setBorder(titleBorderOrder);
	order_panel.add(orderScrollPane);
    order_form_panel= new JPanel();
    order_form_panel.setLayout(null);
    JLabel orderID_label= new JLabel("OrderID:");
    orderID_label.setFont(tableheader_font);
    orderID_label.setBounds(10, 0, 100, 50);
    order_form_panel.add(orderID_label);
    orderID_field= new JTextField(50);
    		//
   
    //
    orderID_field.setFont(tableheader_font);
    orderID_field.setBounds(130, 15, 150,25);
    order_form_panel.add(orderID_field);
    JLabel customer_label= new JLabel("CustomerID:");
    customer_label.setFont(tableheader_font);
    customer_label.setBounds(10, 35, 100, 50);
    order_form_panel.add(customer_label);
    customerID_field= new JTextField(50);
    customerID_field.setFont(tableheader_font);
    customerID_field.setBounds(130, 50, 150,25);
    order_form_panel.add(customerID_field);
    JLabel dob_label= new JLabel("Date:");
    dob_label.setFont(tableheader_font);
    dob_label.setBounds(10, 70, 100, 50);
    order_form_panel.add(dob_label);
    Integer dayItem1[]= new Integer[31];
    for(int i=0;i<31;i++)
    {
    	dayItem1[i]=i+1;
    }
   dayBox1= new JComboBox<Integer>(dayItem1);
    dayBox1.setBounds(130, 85, 40, 25);
    order_form_panel.add(dayBox1);
    //dayBox1.addActionListener(ac);
    Integer monthItem1[]=new Integer [12];
    for(int i=0;i<12;i++)
    {
    	monthItem1[i]=i+1;
    }
    monthBox1= new JComboBox<Integer>(monthItem1);
    monthBox1.setBounds(180, 85, 40, 25);
    order_form_panel.add(monthBox1);
    //monthBox1.addActionListener(ac);
    Integer yearItem1[]=new Integer [26];
    for(int i=2000;i<2026;i++)
    {
    	yearItem1[i-2000]=i;
    }
     yearBox1= new JComboBox<Integer>(yearItem1);
    yearBox1.setBounds(230, 85, 55, 25);
    order_form_panel.add(yearBox1);
    //yearBox1.addActionListener(ac);
  
     
    
    form_panel.add(order_form_panel,"Order Form");

	JLabel label_search= new JLabel("Search: ");
	  label_search.setFont(tableheader_font);
	  label_search.setBounds(820, 20,100, 50);
	  main_panel.add(label_search);
	  search_button = new JButton();
	  
	  search_button.setBounds(1012, 36, 25, 25);
	  main_panel.add(search_button);
	 search_button.addActionListener(ac);
	   search_field= new JTextField(50);
	  search_field.setFont(tableheader_font);
	  search_field.setBounds(880,38,130,22);
	  main_panel.add(search_field);
	     add_button= new JButton("ADD");
	    add_button.setFont(button_font);
	    add_button.setBounds(840,380, 90, 30);
	    main_panel.add(add_button);
	    add_button.addActionListener(ac);
//	    add_button.addActionListener(ac);
//	     delete_button= new JButton("DELETE");
//	    delete_button.setFont(button_font);
//	    delete_button.setBounds(883,380, 105, 30);
//	    main_panel.add(delete_button);
//	    delete_button.addActionListener(ac);
//	     edit_button= new JButton("EDIT");
//	    edit_button.setFont(button_font);
//	    edit_button.setBounds(990,380, 90, 30);
//	    main_panel.add(edit_button);
//	    edit_button.addActionListener(ac);
	     reset_button= new JButton("RESET");
	    reset_button.setFont(button_font);
	    reset_button.setBounds(950,380, 110, 30);
	    reset_button.setBackground(Color.PINK);
	    reset_button.addActionListener(ac);
	    main_panel.add(reset_button);
	//
	    String []columnsNameOrderItem= {"OrderItemID","OrderID","ProductID","Quantity","Uprice"};
		DefaultTableModel modelOrderItem= new DefaultTableModel(columnsNameOrderItem,0);
		OrderItemTable= new JTable(modelOrderItem);
//		enrollmentTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		OrderItemTable.getTableHeader().setFont(tableheader_font);
		//OrderItemTable.addMouseListener(ac);
//		for (Payment p : PaymentDAO.getInstance().selectAll()) {
//		    modelPayment.addRow(new Object[]{
//		        p.getPaymentID(),p.getEnrollmentID(),p.getTuitionFee(),p.getAmountPaid(),formatSqlDate(p.getDate()),p.getStatus(),p.getDetails()
//		    });
//		}
		 
		for (OrderItem o : OrderItemDAO.getInstance().selectAll()) {
			modelOrderItem.addRow(new Object[]{
		    o.getOrderItemID(),o.getOrderID(),o.getProductID(),o.getQuantity(),o.getUprice()
		  
		    });
		}
		JScrollPane OrderItemScrollPane= new JScrollPane(OrderItemTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		order_item_panel.setLayout(null); 
		OrderItemScrollPane.setBounds(10, 70, 760, 400); 
		Border OrderItemBorer = BorderFactory.createLineBorder(Color.BLUE, 3);
		TitledBorder titleBorderOrderItem= BorderFactory.createTitledBorder(OrderItemBorer," Order Item Table ");
		
		OrderItemScrollPane.setBorder(titleBorderOrderItem);
		order_item_panel.add(OrderItemScrollPane);
		order_item_form_panel= new JPanel();
		order_item_form_panel.setLayout(null);
	    JLabel OrderItemID_label= new JLabel("OrderItemID:");
	    OrderItemID_label.setFont(tableheader_font);
	    OrderItemID_label.setBounds(10, 0, 100, 50);
	    
	    order_item_form_panel.add(OrderItemID_label);
	    OrderItemID_field= new JTextField(50);
	    OrderItemID_field.setFont(tableheader_font);
	    OrderItemID_field.setBounds(120, 15, 150,25);
	    order_item_form_panel.add(OrderItemID_field);
	    JLabel OrderID2= new JLabel("OrderID:");
	    OrderID2.setFont(tableheader_font);
	    OrderID2.setBounds(10, 35, 110, 50);
	    order_item_form_panel.add(OrderID2);
	    OrderID2_Field= new JTextField(50);
	    OrderID2_Field.setFont(tableheader_font);
	    OrderID2_Field.setBounds(120, 50, 150,25);
	    //OrderID2_Field.getDocument().addDocumentListener(ac);
	    order_item_form_panel.add(OrderID2_Field);
	    //
	 
	    //
	    JLabel productID2= new JLabel("ProductID:");
	    productID2.setFont(tableheader_font);
	    productID2.setBounds(10, 70, 110, 50);
	    order_item_form_panel.add(productID2);
	    productIDField= new JTextField();
	    productIDField.setFont(tableheader_font); 
	    productIDField.setBounds(120, 80,150,25);
	    order_item_form_panel.add(productIDField);
	    //
	    JLabel quantity_Label= new JLabel("Quantity:");
	    quantity_Label.setFont(tableheader_font);
	    quantity_Label.setBounds(10, 100, 100, 50);
	    order_item_form_panel.add(quantity_Label);
	     quantity_Field= new JTextField(50);
	     quantity_Field.setFont(tableheader_font);
	     quantity_Field.setBounds(120, 115, 150,25);
	     
	     order_item_form_panel.add(quantity_Field);
	    
	     JLabel price_Label= new JLabel("Price:");
	     price_Label.setFont(tableheader_font);
	     price_Label.setBounds(10, 170, 100, 50);
	     order_item_form_panel.add(price_Label);
	      priceField= new JTextField(50);
	      priceField.setFont(tableheader_font);
	      priceField.setBounds(120, 185, 150,25);
	      order_item_form_panel.add(priceField);
	     //
	    form_panel.add(order_item_form_panel,"Order Item Form");
	    //
	  
	 //
	    this.add(spl);
	this.setVisible(true);
}
public void capnhatbangOrder()
{
	DefaultTableModel modelOrder = (DefaultTableModel) this.orderTable.getModel();
	modelOrder.setRowCount(0); 


	ArrayList<Order> orders = OrderDAO.getInstance().selectAll();
	for (Order o : orders) {
	    modelOrder.addRow(new Object[]{
	        o.getOrderID(),
	        o.getCustomerID(),
	        formatSqlDate(o.getDate()),
	        o.getAmount()
	        
	      
	        
	    });
	}
}


	public static String formatSqlDate(Date sqlDate) {
	    if (sqlDate == null) {
	        return ""; 
	    }
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    return formatter.format(sqlDate);
	}

	public void capnhatbangCustomer() {
		DefaultTableModel modelCustomer = (DefaultTableModel) this.CustomerTable.getModel();
		modelCustomer.setRowCount(0); 


		ArrayList<Customer> customers = CustomerDAO.getInstance().selectAll();
		for (Customer c : customers) {
			modelCustomer.addRow(new Object[]{
		       c.getId(),c.getName(),c.getEmail(),c.getAddress()
		  
		    });
		}
		
	}

	public void showOrderSelected(int id) {
		DefaultTableModel modelOrder = (DefaultTableModel) this.orderTable.getModel();
		modelOrder.setRowCount(0); 
		ArrayList<Order> orders = OrderDAO.getInstance().Search(id);
		for (Order o : orders) {
		    modelOrder.addRow(new Object[]{
		        o.getOrderID(),
		        o.getCustomerID(),
		        formatSqlDate(o.getDate()),
		        o.getAmount()     
		    });
		}
	}

	public void capnhatbangProduct() {
		DefaultTableModel modelProduct = (DefaultTableModel) this.ProductTable.getModel();
		modelProduct.setRowCount(0); 
		ArrayList<Product> products = ProductDAO.getInstance().selectAll();
		for (Product p : products) {
			modelProduct.addRow(new Object[]{
		    p.getProductID(),p.getName(),p.getDecription(),p.getPrice(),p.getStockquantity()
		  
		    });
		}
		
	}

	public void capnhatbangOrderItem() {
		DefaultTableModel modelOrderItem = (DefaultTableModel) this.OrderItemTable.getModel();
		modelOrderItem.setRowCount(0); 
		ArrayList<OrderItem> OrderItems = OrderItemDAO.getInstance().selectAll();
		for (OrderItem o : OrderItems) {
			modelOrderItem.addRow(new Object[]{
		    o.getOrderItemID(),o.getOrderID(),o.getProductID(),o.getQuantity(),o.getUprice()
		  
		    });
		}
		
	}


}
