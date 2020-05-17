import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class GreetServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, 
                        HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String name = request.getParameter("aName");
        Date date = new Date();
        out.println("<html>" +
                    "<head><title> Greetings..</title></head>" +
                    "<body>"+
                    "<h1> Welcome " + name +".. today is " + 
                    date+ "</h1>" + 
                    "</body>"+
                    "</html>");
    }
}
 