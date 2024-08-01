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

@WebServlet("/addMobile")
public class AddMobileServlet extends HttpServlet
{
	@Override
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
			 
			 PreparedStatement pst=conn.prepareStatement("insert into mobile values(?,?,?,?)");
			 pst.setInt(1, mobileid);
			 pst.setString(2, mobilemodel);
			 pst.setString(3, mobilebrand);
			 pst.setInt(4, mobileprice);
			 
			 pst.execute();
			 
			 resp.sendRedirect("index.jsp");
			 
			
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
