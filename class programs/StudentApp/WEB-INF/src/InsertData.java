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
				
				// Close the statement 
				st.close(); 
				
				// Get a writer pointer to display the successful result 
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><h3>Successfully Inserted</h3><br/>");
				out.println("<b>Querying table Data<b/>");
				Statement stmt = con.createStatement();  
				ResultSet rs = stmt.executeQuery("select * from student");  
				out.println("<table border=1>");  
				out.println("<tr><th>Rollno</th><th>FirstName</th><th>LastName</th><th>Dob</th><th>Marks</th><tr>");  
				while (rs.next()) 
				{  
					String rno = rs.getString("id");  
					String fname = rs.getString("fname"); 
					String lname = rs.getString("lname");
					String dob = rs.getString("dob");
					float marks = rs.getFloat("marks");   
					out.println("<tr><td>" + rno + "</td><td>" + fname + "</td><td>" + lname + "</td><td>" + dob + "</td><td>" + marks + "</td></tr>");   
				}  
				out.println("</table>");  
				out.println("</body></html>");  
				con.close();  
 
	            

        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 