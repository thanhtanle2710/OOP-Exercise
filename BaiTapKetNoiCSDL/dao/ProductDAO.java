package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Customer;
import model.Product;

public class ProductDAO {
	public boolean insert(Product t)
	{
		Connection con= null;
		try {
			con=JDBCUtil.getConnection();
			String sql="INSERT INTO products"+
			           " VALUES(?,?,?,?,?)";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1,t.getProductID() );
			pst.setString(2, t.getName());
			pst.setString(3,t.getDecription());
			pst.setDouble(4,t.getPrice());
			pst.setInt(5, t.getStockquantity());
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
	public static ProductDAO getInstance() {
		// TODO Auto-generated method stub
		return new ProductDAO();
	}

	public ArrayList<Product> selectAll() {
		ArrayList<Product> listProduct= new ArrayList<Product>();
		Connection con= null;
		try {
			con=JDBCUtil.getConnection();
			String sql= "SELECT * FROM products ";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				int id= rs.getInt(1);
				String name= rs.getString(2);
				String decription= rs.getString(3);
				double price=rs.getDouble(4);
				int stockquantity=rs.getInt(5);			
			Product product= new Product(id, name, decription, price, stockquantity);
			listProduct.add(product);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeConnection(con);
		}
		return listProduct;
		
	}
}
