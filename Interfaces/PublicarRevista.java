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
import controles.ControlPublicarRevista; // Conection to the control

public class AltaAutor extends HttpServlet
{
    ControlPublicarRevista controlU;
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
        out.println("<title>Publicar Revista</title>");
        out.println("<style type=\"text/css\">");
        out.println("h1{text-align:center; background:#dddddd;color:#000000}");
        out.println("body{font-family:sans-serif, arial; font-weight:normal}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Publicacion de una revista</h1>");

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

        out.println("<form data-abide method=\"GET\" action=\"PublicarRevista\">");
        out.println("<p> Id del Revista <input required type=\"text\" name=\"idjuez\" size=\"11\"></p>");
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
   controlU = new ControlPublicarRevista();

    // Strings from the GET method
    String idrevstring = request.getParameter("idrevista");
    int idrev = Integer.parseInt(idrevstring);

    flag = controlU.insert(idrev);

    if(flag){
        out.println("<h1>Revista publicada</h1>");
        out.println("<a href=\"/SengBytes\">Regresar..</a>");
    }

    out.println("<br><br><hr>" + new Date().toString() );
    out.println("</body>");
    out.println("</html>");
  }
	
}