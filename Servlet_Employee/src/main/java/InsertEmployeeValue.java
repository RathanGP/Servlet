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
@WebServlet("/addRecord")
public class InsertEmployeeValue extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int employeeId=Integer.parseInt(req.getParameter("employeeId"));
		String employeeName=req.getParameter("employeeName");
		String employeeEmail=req.getParameter("employeeEmail");
		int employeeSal=Integer.parseInt(req.getParameter("employeeSal"));
		
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb", "root", "root");
			
			PreparedStatement pst=conn.prepareStatement("insert into employee values(?,?,?,?)");
			pst.setInt(1, employeeId);
			pst.setString(2, employeeName);
			pst.setString(3, employeeEmail);
			pst.setInt(4, employeeSal);
			
			pst.execute();
			
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


