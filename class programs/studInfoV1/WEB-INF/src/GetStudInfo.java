import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class GetStudInfo extends HttpServlet{
    
    public void doGet(HttpServletRequest request, 
                        HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String rollNumber = request.getParameter("rollNo");
        StringTokenizer strTok = new StringTokenizer(rollNumber, "-");
        
        //create an array to collect all the components of a roll number
        int[] rNoComps = new int[4];
        int i = 0;
        
        String dept = "";
        // split the string form of roll number into separate tokens
        // convert the tokens to integers and store them in the int array
        while(strTok.hasMoreTokens()){
            rNoComps[i] = Integer.parseInt(strTok.nextToken());
            i++;
        }
          // the third element of the array represents the department
       switch(rNoComps[2]){
            case 736:
                dept = "Mechanical Engineering";
                break;
            case 737:
                dept = "Information Technology";
                break;
            case 733:
                dept = "Computer Science and Engineering";
                break;
            case 732:
                dept = "Civil Engineering";
                break;
            case 735:
                dept = "Electronics and Communications";
                break;
            case 734:
                dept = "Electrical and Electronics";
                break;
            default :
                dept = "Wrong input";
        }
        
        out.println("<html>" +
                    "<head><title>V1:Department Information </title></head>" +
                    "<body>"+
                    "<h1>The Roll Number  " + rollNumber + " belongs to "
                    + dept + " Department </h1>" + 
                    "</body>"+
                    "</html>");
    }
}
 