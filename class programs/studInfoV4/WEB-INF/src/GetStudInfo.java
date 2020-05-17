import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetStudInfo extends HttpServlet{
    
    public void doGet(HttpServletRequest request, 
                        HttpServletResponse response) throws IOException, ServletException{
        String rollNumber = request.getParameter("rollNo");
       
        StudInfo sInfo = new StudInfo(rollNumber);
        String dept = sInfo.getDepartment();
        if(dept.equals("Wrong input")){
            response.sendRedirect("index.html");
        }else{
            request.setAttribute("department", dept);
            RequestDispatcher rd = request.getRequestDispatcher("displayDeptInfo.do");
            rd.forward(request, response);
        }
    }
}
 