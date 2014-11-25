package controles;
import entidades.Lector;


public class ControlVerArticulo
{
 
    Lector lec;

    public ControlVerArticulo() {
        lec = new Lector();
        
    }

   /**
    * Method that returns a boolean depending on the output
    * of the insertion to the DB.
    */
    public boolean insert() {

            lec.create();
            return true;
    }

}