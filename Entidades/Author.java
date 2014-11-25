package entidades;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;


public class Author extends HttpServlet {
    Connection          conn = null;
    Statement           st = null;
    ResultSet           rs = null;
    ResultSetMetaData   rmd = null;
    String              query = null;

    public Author(){
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

    public void create(int idsuscriptor){
        try {
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Date date = new Date();
			String ndate = "'"+(dateFormat.format(date)).toString()+"'";
                   
            query = "INSERT INTO sengbytes.autor (LDofP, IdSuscriptor)"
                +"VALUES ("+ndate+","+idsuscriptor+")";
            st.executeUpdate(query);
       }catch (SQLException e) {
        System.out.println("Ex: " + e);
       }
          
    }//end create()

}