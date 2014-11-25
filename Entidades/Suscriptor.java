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


public class Suscriptor extends HttpServlet {
    Connection          conn = null;
    Statement           st = null;
    ResultSet           rs = null;
    ResultSetMetaData   rmd = null;
    String              query = null;

    public Suscriptor(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException ie){  
        } catch (ClassNotFoundException nf){ 
        } catch (IllegalAccessException iae){
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                "SengBytes?user=root&password=r00t");
        } catch (SQLException sq1){
        }
    }// End createConnection()

    public void create(String nom, String lastn, String address,
                            String tarjeta, String suscrip, String mail,
                            String passwd){
        try {
            query = "INSERT INTO suscriptor (Nom, LastN, Address, Tarjeta, Suscription, Mail, Passwd, InicioSuscripcion, TiempoRestante)"
                +"VALUES ("+nom+", "+lastn+", "+address+", "+tarjeta+", "+suscrip+", "+mail+", "+passwd+")";
            st.executeUpdate(query);
       }catch (SQLException e) {}
    }//end create()

}