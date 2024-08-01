package sample;

import java.io.IOException;
import java.io.PrintWriter;


public class Servlet extends GenericServlet 
{
 public void service(ServletRequest req, ServletResponse res)throws ServletException,IOException 
{
	String name = req.getParameter("n");

	PrintWriter out = res.getWriter();
	out.print("<h1>Welcome Home" + name + "</h1>");
 }

}



