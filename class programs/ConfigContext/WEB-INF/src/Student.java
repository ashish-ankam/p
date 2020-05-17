import javax.servlet.ServletException; 
import javax.servlet.http.*; 
import java.io.*; 
  
public class Student extends HttpServlet { 
  
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
        throws ServletException, IOException 
    { 
  
        String email 
            = getServletConfig() 
                  .getInitParameter("Email"); 
        String website 
            = getServletContext() 
                  .getInitParameter("Website-name"); 
        PrintWriter out = response.getWriter(); 
        out.println("<html>" +
                    "<head><title> Servlet Config</title></head>" +
                    "<body>"+
                    "<h1> Welcome to " + website +".. contact us at " + 
                    email+ "</h1>" + 
                    "</body>"+
                    "</html>"); 
    } 
} 