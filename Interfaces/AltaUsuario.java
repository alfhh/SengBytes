package interfaces;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import controles.ControlAltaUsuario; // Conection to the control

public class AltaUsuario extends HttpServlet
{
    ControlAltaUsuario ca;
    HttpServletResponse respuesta;
    HttpServletRequest request;
    PrintWriter out;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();

    /** Initializes the servlet. */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /** Destroys the servlet. */
    public void destroy() {    }

    /** Handles the HTTP GET method. */
    public void doGet(HttpServletRequest req, 
                        HttpServletResponse resp) throws IOException {
    respuesta = resp;
    request = req;
    respuesta.setContentType("text/html");
    out = respuesta.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Nuevo Suscriptor</title>");
        out.println("<style type=\"text/css\">");
        out.println("h1{text-align:center; background:#dddddd;color:#000000}");
        out.println("body{font-family:sans-serif, arial; font-weight:normal}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Registro de nuevo Suscriptor</h1>");

    String check = req.getParameter("check");
    if (check == null) {
        loadForm();
    } else if (check.equals("validate")){
        validateData();
    }

  }

   /**
    * Method used to load the form the first time the page is loaded
    *
    */
  public void loadForm() {

        out.println("<form data-abide method=\"GET\" action=\"RegistrarUsuario\">");
        out.println("<p> Nombre <input required type=\"text\" name=\"nombre\" size=\"15\"></p>");
        out.println("<p> Apellido <input required type=\"text\" name=\"apellido\" size=\"15\"></p>");
        out.println("<p> Direccion <input  type=\"text\" name=\"direccion\" size=\"15\"></p>");
        out.println("<p> Tarjeta <input  type=\"text\" name=\"tarjeta\" size=\"15\"></p>");
        out.println("<p> Suscripcion <input required type=\"text\" name=\"suscripcion\" size=\"15\"></p>");
        out.println("<p> Mail <input required type=\"text\" name=\"mail\" size=\"15\"></p>");
        out.println("<p> Contrasena <input required type=\"text\" name=\"contrasena\" size=\"15\"></p>");
        out.println("<input type=\"hidden\" name=\"check\" value=\"validate\"/>");
        out.println("<input type=\"submit\" name=\"submit\" value=\"Submit\" />");
        out.println("</form>");
        out.println("<br><br><hr>" + new Date().toString() );
        out.println("</body>");
        out.println("</html>");
  }

   /**
    * Method used to validate the info sent by the user
    * The flag is used to know if the insertion was done
    */
  public void validateData() {
    boolean flag = false;
    ca = new ControlAltaUsuario();

    // Strings from the GET method
    String nom = request.getParameter("nombre");
    String lastn = request.getParameter("apellido");
    String address = request.getParameter("direccion");
    String tarjeta = request.getParameter("tarjeta");
    String suscripcion = request.getParameter("suscripcion");
    String mail = request.getParameter("mail");
    String passwd = request.getParameter("contrasena");

    flag = ca.insert(nom, lastn, address, tarjeta, suscripcion, mail, passwd);

    out.println("<br><br><hr>" + new Date().toString() );
    out.println("</body>");
    out.println("</html>");
  }
	
}
			
			
			