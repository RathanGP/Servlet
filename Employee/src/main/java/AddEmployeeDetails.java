import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addDetail")
public class AddEmployeeDetails extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int employeeId=Integer.parseInt(req.getParameter("employeeId"));
		String employeeName=req.getParameter("employeeName");
		String employeeEmail=req.getParameter("employeeEmail");
		int employeeSalary=Integer.parseInt(req.getParameter("employeeSalary"));
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb", "root","root");
			
			PreparedStatement statement = conn.prepareStatement("insert into employee values(?,?,?,?)");
			statement.setInt(1, employeeId);
			statement.setString(2, employeeName);
			statement.setString(3, employeeEmail);
			statement.setInt(4, employeeSalary);
			statement.execute();
			
			resp.sendRedirect("index.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
