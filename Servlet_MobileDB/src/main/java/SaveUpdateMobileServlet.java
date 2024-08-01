import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/saveUpdateMobile")
public class SaveUpdateMobileServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		int mobileid=Integer.parseInt(req.getParameter("mobileid"));
		String mobilemodel=req.getParameter("mobilemodel");
		String mobilebrand=req.getParameter("mobilebrand");
		int mobileprice=Integer.parseInt(req.getParameter("mobileprice"));
		
		Connection conn=null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobiledb", "root", "root");
			 
			 PreparedStatement pst=conn.prepareStatement("update mobile set mobilemodel=?,mobilebrand=?,mobileprice=? where mobileid=?");
			 pst.setString(1, mobilemodel);
			 pst.setString(2, mobilebrand);
			 pst.setInt(3, mobileprice);
			 pst.setInt(4, mobileid);
			 
			 pst.executeUpdate();
			 
			 resp.sendRedirect("DisplayMobile");
			 
			
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
