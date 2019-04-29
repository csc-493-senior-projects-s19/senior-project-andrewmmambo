// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019

package attendB;

import java.sql.*;
//this class allows queries to be sent that make changes to student details
public class StudentDao {

	
	public static int save(String name,String password,String email){
		int status=0;
		try{
			Connection con=DB.getConnection();
			// this query allow student details to be added into the database
			PreparedStatement ps=con.prepareStatement("insert into students(name,password,email,address,studentid,courses) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			//this query allows a student record to be deleted from the attendance table
			PreparedStatement ps=con.prepareStatement("delete from attendance where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from students where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
