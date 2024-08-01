import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updateDetails")
public class UpdateEmployeeDetails extends HttpServlet
{
	@Override
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
			
			PreparedStatement statement = conn.prepareStatement("update employee set employeeName=?,employeeEmail=?,employeeSalary=? where employeeId=?");
			statement.setInt(4, employeeId);
			statement.setString(1, employeeName);
			statement.setString(2, employeeEmail);
			statement.setInt(3, employeeSalary);
			statement.executeUpdate();
			
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


