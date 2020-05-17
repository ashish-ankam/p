import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DisplayOutput extends HttpServlet{
    
    public void doGet(HttpServletRequest request, 
                        HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String rollNumber = request.getParameter("rollNo");
        String dept = request.getAttribute("department").toString();
                
        out.println("<html>" +
                    "<head><title>V4: Department Information</title></head>" +
                    "<body>"+
                    "<h1>The Roll Number  " + rollNumber + " belongs to "
                    + dept + " Department </h1>" + 
                    "</body>"+
                    "</html>");
    }
}
 