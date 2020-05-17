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
       
        StringBuffer sb = new StringBuffer();
        HttpSession session;
        session = request.getSession(false);
        
        Integer value = 1;
        if(session==null){
            session = request.getSession(); 
            session.setAttribute(name, value);
       }else{
            if((session.getAttribute(name))!= null){
               value = (Integer) session.getAttribute(name);
                value++;
                session.setAttribute(name, value);   
            }else{   
                session.setAttribute(name, value);  
            }           
       }
   
        Enumeration<String> attributes = session.getAttributeNames();
        if(attributes!=null){
          while(attributes.hasMoreElements()){
            String attribute = attributes.nextElement();
            sb.append("<h3>" + attribute +
            " : " + session.getAttribute(attribute)+
            "</h3>" );
            }      
        }
                
        out.println("<html>" +
            "<head><title> Greetings V5</title></head>" +
            "<body>"+
            "<h1>"+  name + "</h1>" +
            "<h2> Today is " +date+ "</h2>" +
            "<code> Session :" + session + "</code>"+
            "<br><code> New Session? :" + session.isNew() + "</code>"+
            "<br><code> Creation Time :" + new Date(session.getCreationTime()) + "</code>"+
            "<br><code> Last Accessed Time :" + new Date(session.getLastAccessedTime()) + "</code>"+
            "<br><code> Session Id :" + session.getId() + "</code>"+
            "<br><code> Is the request's session ID provided by the client is a cookie  :" + 
            request.isRequestedSessionIdFromCookie() + "</code>"+
            "<br><code> Is  the request's session ID provided by the client is a part of a URL  :" +
            request.isRequestedSessionIdFromURL() + "</code>"+
            sb +
            "</body>"+
            "</html>");
    }
}
 