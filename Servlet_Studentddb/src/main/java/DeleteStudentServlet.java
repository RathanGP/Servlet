import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeleteStudentServlet extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{// TODO Auto-generated method stub
	
		int studentId=Integer.parseInt(req.getParameter("studentId"));
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_studentdb", "root", "root");
			
			PreparedStatement pst=conn.prepareStatement("delete from student where studentId=?");
			pst.setInt(1,studentId);
			
			int row=pst.executeUpdate();
		
			PrintWriter out=res.getWriter();
//			out.println("Data deleted successfully");
			
			if(row>0)
			{
				out.print("<h1>"+row+"Value deleted successfully</h1>");
			}
			else
				out.print("<h1>"+row+"Value not deleted</h1>");
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
	


