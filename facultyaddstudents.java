// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019

package attendB;

import java.sql.Connection;
import java.sql.PreparedStatement;

// this class allows new users to be added to the database
public class facultyaddstudents {
public static int save(String studentid,String studentname,String date,String course,int present){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
	//interacts with the database and allows a new student to be added to the student table
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
