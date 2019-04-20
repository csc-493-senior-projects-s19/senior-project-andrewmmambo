package attendB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class facultyaddstudents {
public static int save(String studentid,String studentname,String date,String course,int present){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into editattend(studentid,studentname,date,course,present) values(?,?,?,?,?)");
		ps.setString(1,studentid);
		ps.setString(2,studentname);
		ps.setString(3,date);
		ps.setString(4,course);
		ps.setInt(5,present);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
