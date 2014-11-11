import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class login extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
	{
		String name , pass;
		name = req.getParameter("txtuname");
		pass = req.getParameter("txtpass");
		
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
		
		try
		{	
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:sbb"); //NAME OF DATA SOURCE
			Statement stmt = con.createStatement();
			stmt.executeUpdate(" insert into login(uname,password) values('"+name+"','"+pass+"')");
			pw.println(" Data Inserted Biach !"); //NAME OF THE TABLE WITH THE COLUMN NAMES
			con.close();
		}
		
		catch( ClassNotFoundException e)
		{
			pw.println(" Class not found " +e);
		}
		
		catch(Exception e)
		{
			pw.println(" Insertion Failed ! ^_^ !" +e);
		}		
	
	}
	
}
			
			
			