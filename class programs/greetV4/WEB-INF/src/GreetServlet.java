import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class GreetServlet extends HttpServlet{
    
    public void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String name = request.getParameter("aName");
        Date date = new Date();
       // Cookie c1 = new Cookie(name, "one");
       // response.addCookie(c1);
        StringBuffer sb = new StringBuffer();
        Cookie[] cookies = request.getCookies();
        
        if(cookies!=null){
            for(Cookie c : cookies){
                if((c.getName()).equals(name)){
                    int value = Integer.parseInt(c.getValue());
                    value++;
                    c.setValue(value+"");
                    response.addCookie(c);
                }else{
                   response.addCookie(new Cookie(name, "1"));
                }
            }
            
            for(Cookie c : cookies){
                sb.append("<h3>" + c.getName() + ":" + c.getValue() + "</h3>");
            }
        }else{
            Cookie c = new Cookie(name, "1");
            response.addCookie(c);
        }

        out.println("<html>" +
                    "<head><title> Greetings V4</title></head>" +
                    "<body>"+
                    "<h1>"+  name + "</h1>" +
                    "<h2> Today is " +date+ "</h2>" +
                     "<code>" + sb + "</code>"+
                    "</body>"+
                    "</html>");
    }
}
 