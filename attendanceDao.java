// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019


package attendB;

import java.sql.*;

// a class that sends queries, interacts with the class attendance and the class faculty success
public class attendanceDao {
	
public static boolean checkstudentid(String studentid){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		// a query that selects all the records in the table ediattend
		PreparedStatement ps=con.prepareStatement("select * from editattend where studentid=?");
		ps.setString(1,studentid);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(String studentid,String studentname,String date,String course){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		status=updateattend(studentid);
		
		if(status>0){
			// a query that inserts student details in to a table
		PreparedStatement ps=con.prepareStatement("insert into attendance(studentid,studentname,date, course) values(?,?,?,?)");
		ps.setString(1,studentid);
		ps.setString(2,studentname);
		ps.setString(3,date);
		ps.setString(4,course);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updateattend(String studentid){
	int status=0;
	int present=0,absent=0;
	try{
		Connection con=DB.getConnection();
		//a query that allows attendance to be selected as present or absent.
		PreparedStatement ps=con.prepareStatement("select present,absent from editattend where studentid=?");
		ps.setString(1,studentid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			present=rs.getInt("present");
			absent=rs.getInt("absent");
		}
		
		if(present>0){
			// a query that updates the attendance details in the tables.
		PreparedStatement ps2=con.prepareStatement("update editattend set present=?,absent=? where studentid=?");
		ps2.setInt(1,present-1);
		ps2.setInt(2,absent+1);
		ps2.setString(3,studentid);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
