package controles;
import entidades.Suscriptor;
import entidades.Author;

public class ControlAltaAutor
{
    Author aut;
    Suscriptor sus;

    public ControlAltaAutor() {
        sus = new Suscriptor();
        aut = new Author();
    }

   /**
    * Method that returns a boolean depending on the output
    * of the insertion to the DB.
    */
    public boolean insert(int idsuscriptor) {

            aut.create(idsuscriptor);
            return true;
    }

}