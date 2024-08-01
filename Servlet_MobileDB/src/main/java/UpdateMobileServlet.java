import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateMobile")
public class UpdateMobileServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int mobileid=Integer.parseInt(req.getParameter("mobileid"));
		Connection conn=null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobiledb", "root", "root");
			 
			 PreparedStatement pst=conn.prepareStatement("select * from mobile where mobileid=?");
			 pst.setInt(1, mobileid);
			 
			 ResultSet rs=pst.executeQuery();
			 
			 req.setAttribute("resultset", rs);
			 RequestDispatcher rd=req.getRequestDispatcher("UpdateMobile.jsp");
			 rd.forward(req, resp);
					
			 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	

	}

}
