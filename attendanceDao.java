package attendB;

import java.sql.*;
public class attendanceDao {
	
public static boolean checkstudentid(String studentid){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
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
		
		PreparedStatement ps=con.prepareStatement("select present,absent from editattend where studentid=?");
		ps.setString(1,studentid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			present=rs.getInt("present");
			absent=rs.getInt("absent");
		}
		
		if(present>0){
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
