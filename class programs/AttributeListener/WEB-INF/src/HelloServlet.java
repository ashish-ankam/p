import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
 
public class HelloServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<b><i>Adding, replace and removing</i> the request Attributes.</b></br> </br> </br> </br>");
		out.println("<b>Please look at the Tomcat Server Window for more details</b>");

		//Setting Request Attributes to be shared between multiple servlets
		request.setAttribute("Name", request.getParameter("username"));
		request.setAttribute("City", request.getParameter("cityname"));

		//Replace the attribute Name with a new value
		request.setAttribute("Name", "Vasavi");

		//Removing the attribute Name by giving it a null value
		request.setAttribute("Name", null);
		
		//Removing the attribute City 
		request.removeAttribute("City");
	}
}