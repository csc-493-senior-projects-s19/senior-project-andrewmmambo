package bereaattend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectDB{

public static void main(String[] args) throws Exception{
	getConnection();
	get();
}


	public static Connection getConnection() throws Exception{
		try {
			@SuppressWarnings("unused")
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/attendancedb?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "Chitandam7/";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("connected to database");
			return conn;
		}catch(Exception e) {System.out.println(e);}
		return null;
		
	}
	public static ArrayList<String> get()throws Exception{
 		try {
 			Connection con = getConnection();
 			PreparedStatement statement = con.prepareStatement("SELECT studentname, date, attendance FROM datascience");
 //			PreparedStatement statement = con.prepareStatement("SELECT * FROM attendancedb LIMIT 1");
 			ResultSet result = statement.executeQuery();
 			
 			ArrayList<String> array = new ArrayList<String>();
 			while(result.next()) {
 				System.out.println(result.getString("studentname"));
 				System.out.print("");
 				System.out.println(result.getString("date"));
 				System.out.println(result.getString("attendance"));
 				
 				array.add(result.getString("studentname"));
 				array.add(result.getString("date"));
 				array.add(result.getString("attendance"));	
 			}
 			System.out.println("ALL RECORDS HAVE BEEN SELECTED");
 			profview1.buildTableModel();
 			return array;
 		
 		}catch(Exception e) {System.out.println(e);}
 		return null;
 	}
	}
