// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019

package attendB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// this class allows queries to be sent and modfications being made to the attendance records.
public class editattendanceDao {
	public static int delete(String studentid,String studentname){
		int status=0;
		try{
			Connection con=DB.getConnection();
			
			status=updateattend(studentid);
			
			if(status>0){
				//a query that deletes the attendance record from the attendance table
			PreparedStatement ps=con.prepareStatement("delete from attendance where studentid=? and studentname=?");
			ps.setString(1,studentid);
			ps.setString(2,studentname);
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
			// a query that allows the attendance record to be selected
			PreparedStatement ps=con.prepareStatement("select present,absent from editattend where studentid=?");
			ps.setString(1,studentid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				present=rs.getInt("present");// retrieves the number of presents in the records
				absent=rs.getInt("absent"); // retrieves the number of absences in the records
			}
			
			if(absent>0){
				
				// a query that allows the attendance record to be modified
			PreparedStatement ps2=con.prepareStatement("update editattend set present=?,absent=? where studentid=?");
			ps2.setInt(1,present+1); //alter the number of presents in the records
			ps2.setInt(2,absent-1); // alter the number of absences in the records
			ps2.setString(3,studentid);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
