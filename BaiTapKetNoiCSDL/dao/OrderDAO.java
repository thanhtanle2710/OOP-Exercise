package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTable;

import database.JDBCUtil;
import model.Order;


public class OrderDAO {
public boolean insert(Order t)
{
	Connection con= null;
	try {
		con=JDBCUtil.getConnection();
		String sql="INSERT INTO orders"+
		           " VALUES(?,?,?,?)";
		PreparedStatement pst= con.prepareStatement(sql);
		pst.setInt(1,t.getOrderID() );
		pst.setInt(2, t.getCustomerID());
		pst.setDate(3,t.getDate());
		pst.setDouble(4, t.getAmount());
		int kq= pst.executeUpdate();
		if(kq>0)
		{
			System.out.println("success");
			return true;
		}
		
			
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		JDBCUtil.closeConnection(con);
	}
	return false;
}

public static OrderDAO getInstance() {
	// TODO Auto-generated method stub
	return new OrderDAO();
}

public ArrayList<Order> selectAll() {
	ArrayList<Order> listOrder= new ArrayList<Order>();
	Connection con= null;
	try {
		con=JDBCUtil.getConnection();
		String sql= "SELECT * FROM orders ";
		PreparedStatement pst= con.prepareStatement(sql);
		ResultSet rs= pst.executeQuery();
		while(rs.next())
		{
			int orderid= rs.getInt(1);
			int customerid= rs.getInt(2);
			Date date= rs.getDate(3);
			double amount=rs.getDouble(4);
			
			
			Order order= new Order(orderid, customerid, date, amount);
			listOrder.add(order);
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		JDBCUtil.closeConnection(con);
	}
	return listOrder;
	
}
public ArrayList<Order> Search(int id) {
	ArrayList<Order> listSearch= new ArrayList<Order>();
	Connection con= null;
	try {
		con=JDBCUtil.getConnection();
		String sql= "SELECT * FROM orders WHERE customerId =?";
		
		PreparedStatement pst= con.prepareStatement(sql);
		pst.setInt(1,id);
		ResultSet rs= pst.executeQuery();
		while(rs.next())
		{
			int orderID= rs.getInt("orderId");
			int customerID= rs.getInt("customerId");
			Date orderDate= rs.getDate("orderDate");
			Double orderAmount=rs.getDouble("orderTotalAmount");
			Order order= new Order(orderID, customerID, orderDate, orderAmount);
			listSearch.add(order);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		JDBCUtil.closeConnection(con);
	}
	return listSearch;
}

}
