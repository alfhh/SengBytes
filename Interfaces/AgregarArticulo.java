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
import controles.ControlAgregarArticulo; // Conection to the control

public class AltaAutor extends HttpServlet
{
    ControlAgregarArticulo controlU;
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
        out.println("<title>Agregar Articulo</title>");
        out.println("<style type=\"text/css\">");
        out.println("h1{text-align:center; background:#dddddd;color:#000000}");
        out.println("body{font-family:sans-serif, arial; font-weight:normal}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Adicion de un articulo a una publicacion</h1>");

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

        out.println("<form data-abide method=\"GET\" action=\"AgregarArticulo\">");
        out.println("<p> Id del Articulo <input required type=\"text\" name=\"idarticulo\" size=\"11\"></p>");
        out.println("<p> Id de la Publicacion <input required type=\"text\" name=\"idpublicacion\" size=\"11\"></p>");
        out.println("<p> Id del Juez <input required type=\"text\" name=\"idjuez\" size=\"11\"></p>");
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
   controlU = new ControlAgregarArticulo();

    // Strings from the GET method
    String idartstring = request.getParameter("idarticulo");
    int idart = Integer.parseInt(idartstring);

    flag = controlU.insert(idart);

    if(flag){
        out.println("<h1>Articulo agregado</h1>");
        out.println("<a href=\"/SengBytes\">Regresar..</a>");
    }

    out.println("<br><br><hr>" + new Date().toString() );
    out.println("</body>");
    out.println("</html>");
  }
	
}
			
			
			