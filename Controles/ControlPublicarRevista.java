package controles;
import entidades.Revista;


public class ControlPublicarRevista
{
 
    Revista rev;

    public ControlPublicarRevista() {
        rev = new Revista();
        
    }

   /**
    * Method that returns a boolean depending on the output
    * of the insertion to the DB.
    */
    public boolean insert() {

            rev.create();
            return true;
    }

}