package entidades;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;


public class Article extends HttpServlet {
    Connection          conn = null;
    Statement           st = null;
    ResultSet           rs = null;
    ResultSetMetaData   rmd = null;
    String              query = null;

    public Article(){
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

    public void create(int idAutor, int idRevista, String contenido){
        try {

            query = "INSERT INTO sengbytes.articulo (Publicado, IdAutor, IdRevista, Contenido)"
                +"VALUES (1, "+idAutor+", "+idRevista+", '"+contenido+"')";
            System.out.println(query);
            st.executeUpdate(query);
       }catch (SQLException e) {
        System.out.println("Ex: " + e);
       }
          
    }//end create()

}