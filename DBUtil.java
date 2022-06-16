package dbutil;

import java.sql.*;

public class DBUtil {

	public static Connection getConnection()
	{	try {
		Class.forName("com.mysql.jdbc.Driver");
		} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		Connection conn = null;
		try 
		{
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","root","");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
