package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Customer;
import model.Order;

public class CustomerDAO {

public boolean insert(Customer t)
{
	Connection con= null;
	try {
		con=JDBCUtil.getConnection();
		String sql="INSERT INTO customers"+
		           " VALUES(?,?,?,?)";
		PreparedStatement pst= con.prepareStatement(sql);
		pst.setInt(1,t.getId() );
		pst.setString(2, t.getName());
		pst.setString(3,t.getEmail());
		pst.setString(4, t.getAddress());
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
public static CustomerDAO getInstance() {
	// TODO Auto-generated method stub
	return new CustomerDAO();
}

public ArrayList<Customer> selectAll() {
	ArrayList<Customer> listCustomer= new ArrayList<Customer>();
	Connection con= null;
	try {
		con=JDBCUtil.getConnection();
		String sql= "SELECT * FROM customers ";
		PreparedStatement pst= con.prepareStatement(sql);
		ResultSet rs= pst.executeQuery();
		while(rs.next())
		{
			int id= rs.getInt(1);
			String name= rs.getString(2);
			String email= rs.getString(3);
			String address=rs.getString(4);
			
			
			Customer customer= new Customer(id, name, email, address);
			listCustomer.add(customer);
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		JDBCUtil.closeConnection(con);
	}
	return listCustomer;
	
}
}
