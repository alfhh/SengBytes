package controles;
import entidades.Author;
import entidades.Judge;

public class ControlAltaJuez
{
 
    Author aut;
    Judge jud;

    public ControlAltaJuez() {
        aut = new Author();
        jud = new Judge();
    }

   /**
    * Method that returns a boolean depending on the output
    * of the insertion to the DB.
    */
    public boolean insert(int idautor) {

            jud.create(idautor);
            return true;
    }

}