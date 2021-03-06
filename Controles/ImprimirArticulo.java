package controles;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.util.Date;

public class ImprimirArticulo extends HttpServlet
{
	Connection          conn = null;
    Statement           st = null;
    ResultSet           rs = null;
    ResultSetMetaData   rmd = null;
    String              query = null;

    /** Initializes the servlet. */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    private void createConnection(PrintWriter out){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            out.println("Driver Registration Successful<br>");
        } catch (InstantiationException ie){
            out.println("class instantiation exception: " + ie);
        } catch (ClassNotFoundException nf){
            out.println("class not found exception: " + nf);
        } catch (IllegalAccessException iae){
            out.println("illegal access exception: " + iae);
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                "SengBytes?user=root&password=r00t");
            out.println("Connection Successful<br>");
        } catch (SQLException sq1){
            out.println("Caught SQL exception "+sq1);
        }
    }// End createConnection()

    private void runQuery(PrintWriter out) throws SQLException {
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
    }//end runQuery()

    /** Destroys the servlet. */
    public void destroy() {    }

    /** Processes requests for both HTTP GET and POST methods.*/
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Conection Example</title>");
        out.println("<style type=\"text/css\">");
        out.println("h1{text-align:center; background:#dddddd;color:#000000}");
        out.println("body{font-family:sans-serif, arial; font-weight:normal}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Test Database Connectivity</h1>");
        createConnection( out );
        try {
           runQuery(out);
        }catch (SQLException sqe){
           out.println("Caught SQLException from runQuery(): " + sqe);
        }
        out.println("<br><br><hr>" + new Date().toString() );
        out.println("</body>");
        out.println("</html>");
        out.close();
    } //end processRequest()

    /** Handles the HTTP GET method. */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        processRequest(req, resp);
    } //end doGet()

    /** Handles the HTTP POST method. */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, java.io.IOException {
        processRequest(req, resp);
    } //end doPost()

    /** Returns a short description of the servlet. */
    public String getServletInfo() {
        return "Short description";
    } //end getServletInfo()
	
}
			
			
			