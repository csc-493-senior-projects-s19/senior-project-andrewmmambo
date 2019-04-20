package attendB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class editattendanceDao {
	public static int delete(String studentid,String studentname){
		int status=0;
		try{
			Connection con=DB.getConnection();
			
			status=updateattend(studentid);
			
			if(status>0){
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
			
			PreparedStatement ps=con.prepareStatement("select present,absent from editattend where studentid=?");
			ps.setString(1,studentid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				present=rs.getInt("present");
				absent=rs.getInt("absent");
			}
			
			if(absent>0){
			PreparedStatement ps2=con.prepareStatement("update editattend set present=?,present=? where studentid=?");
			ps2.setInt(1,present+1);
			ps2.setInt(2,absent-1);
			ps2.setString(3,studentid);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
