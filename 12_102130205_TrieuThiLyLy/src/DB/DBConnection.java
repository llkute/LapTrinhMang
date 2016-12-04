package DB;

import java.sql.*;

public class DBConnection {
	public static Connection CreateConnection() {
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/baithicuoiky?useUnicode=true&characterEncoding=UTF-8";
		String user="root";
		String password="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, user, password);
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}