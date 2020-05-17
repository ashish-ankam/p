import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class WelcomeServlet extends HttpServlet 
{
		public void doGet( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
		{
				response.setContentType( "text/html" );  // content type
				PrintWriter output;
				output = response.getWriter();
				StringBuffer buf = new StringBuffer();
				buf.append( "<HTML><HEAD><TITLE>\n" );
				buf.append( "A Simple Servlet Example\n" );
				buf.append( "</TITLE></HEAD><BODY>\n" );
				buf.append( "<H1>Welcome to Servlets!</H1>\n" );
				buf.append( "</BODY></HTML>" );
				output.println( buf.toString() );
				output.close();    
		}
}
