package entidades;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;


public class Lector extends HttpServlet {
    Connection          conn = null;
    Statement           st = null;
    ResultSet           rs = null;
    ResultSetMetaData   rmd = null;
    String              query = null;
    PrintWriter out;


    public Lector(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException ie){  
        } catch (ClassNotFoundException nf){ 
        } catch (IllegalAccessException iae){
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                "SengBytes?user=root&password=r00t");
            st = conn.createStatement();
        } catch (SQLException sq1){
        }
    }// End createConnection()

    public void create() {

        try {
                st = conn.createStatement();
        query = "SELECT * FROM articulo" ;
        rs = st.executeQuery(query);
        
        while(rs.next()){
            out.println("--------------------");
            String str2 = rs.getString("IdAutor");
            out.println("ID del autor = " +str2 + "<br>");
            String str3 = rs.getString("IdRevista");
            out.println("ID de la revista = " +str3 + "<br>");
            String str4 = rs.getString("Contenido");
            out.println("Contenido: " + "<br>" +str4 + "<br><br>");
        }
        } catch (SQLException sq1){}
          
    }//end create()

}