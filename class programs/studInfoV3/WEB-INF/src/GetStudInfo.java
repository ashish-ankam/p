import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetStudInfo extends HttpServlet{
    
    public void doGet(HttpServletRequest request, 
                        HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        String rollNumber = request.getParameter("rollNo");
       
        StudInfo sInfo = new StudInfo(rollNumber);
        String dept = sInfo.getDepartment();
        
        request.setAttribute("department", dept);
        RequestDispatcher rd = request.getRequestDispatcher("displayDeptInfo.do");
        rd.forward(request, response);
  
    }
}
 