import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*; 
  
public class InsertData extends HttpServlet {

  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
        try { 
  
				//step1 load the driver class 
				Class.forName("oracle.jdbc.driver.OracleDriver");    
  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","divya","vasavi");  
  
				// Create a SQL query to insert data into table 
				PreparedStatement st = con .prepareStatement("insert into student values(?, ?, ?, ?, ?)"); 
	  
				st.setString(1, request.getParameter("id"));
				st.setString(2, request.getParameter("fname"));
				st.setString(3, request.getParameter("lname"));
				st.setString(4, request.getParameter("dob"));				
				st.setFloat(5, Float.valueOf(request.getParameter("marks"))); 
	  
  
				// Execute the insert command using executeUpdate() 
				st.executeUpdate(); 
	  
				// Close all the connections 
				st.close(); 
				con.close(); 
	  
				// Get a writer pointer  
				// to display the successful result 
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><b>Successfully Inserted"
							+ "</b></body></html>"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 