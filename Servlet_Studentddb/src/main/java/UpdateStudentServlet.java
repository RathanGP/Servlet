import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateStudentServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		String studentEmail=req.getParameter("studentEmail");
		int studentMarks=Integer.parseInt(req.getParameter("studentMarks"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_studentdb", "root", "root");
			
			PreparedStatement pst=conn.prepareStatement("update student set studentEmail=?,studentMarks=? where studentId=?");
			
			pst.setString(1, studentEmail);
			pst.setInt(2, studentMarks);
			pst.setInt(3, studentId);
			
			int row=pst.executeUpdate();
		
			PrintWriter out=res.getWriter();
			
			if(row>0)
			{
				out.print("<h1>"+row+"Value updated successfully</h1>");
			}
			else
				out.print("<h1>"+row+"Value not updated</h1>");
			
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
