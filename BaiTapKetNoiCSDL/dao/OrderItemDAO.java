package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Order;
import model.OrderItem;

public class OrderItemDAO {
	public boolean insert(OrderItem t)
	{
		Connection con= null;
		try {
			con=JDBCUtil.getConnection();
			String sql="INSERT INTO order_items"+
			           " VALUES(?,?,?,?,?)";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1,t.getOrderItemID() );
			pst.setInt(2, t.getOrderID());
			pst.setInt(3,t.getProductID());
			pst.setInt(4, t.getQuantity());
			pst.setDouble(5,t.getUprice());
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

	public static OrderItemDAO getInstance() {
		// TODO Auto-generated method stub
		return new OrderItemDAO();
	}

	public ArrayList<OrderItem> selectAll() {
		ArrayList<OrderItem> listOrderItem= new ArrayList<OrderItem>();
		Connection con= null;
		try {
			con=JDBCUtil.getConnection();
			String sql= "SELECT * FROM order_items ";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				int orderItemid= rs.getInt(1);
				int orderid= rs.getInt(2);
				int productID=rs.getInt(3);
				int quantity=rs.getInt(4);
				double uprice=rs.getDouble(5);
				
				
				OrderItem orderItem= new OrderItem(orderItemid, orderid, productID, quantity, uprice);
				listOrderItem.add(orderItem);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeConnection(con);
		}
		return listOrderItem;
		
	}
	
}
