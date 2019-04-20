package attendB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/attendancedb?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "Chitandam7/";
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connected to database");
			return con;
		}catch(Exception e){System.out.println(e);}
		return null;
	}

}
