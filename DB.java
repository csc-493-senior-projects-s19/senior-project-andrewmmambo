// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019

package attendB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	@SuppressWarnings("unused")
	public static Connection getConnection() throws Exception{
		try{
			
			// these is the method that allows the web application to connect with the mysql database
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/attendancedb?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "Chitandam7/";
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connected to database");// gives output if connection is succesfull
			return con;
		}catch(Exception e){System.out.println(e);}
		return null;
	}

}
