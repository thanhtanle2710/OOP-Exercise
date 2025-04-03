package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;



public class JDBCUtil {
 public static Connection getConnection()
 {
	 Connection c =null;
	 try {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		String url="jdbc:sqlserver://DESKTOP-822Q5G2:1433;databaseName=OrderManagement;user=sa;password=tan123456;encrypt=true;trustServerCertificate=true;";
		c=DriverManager.getConnection(url);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	 return c;
 }
 public static void closeConnection(Connection c)
 {
	 try {
		if(c!=null)
		{
			c.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
