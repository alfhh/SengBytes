package controles;
//import entidades.Suscriptor;
import entidades.Article;

public class ControlPublicarArticulo
{
    Author aut;
    Article art;
    //Revista re;

    public ControlNuevoArticulo() {
        aut = new Author();
        art = new Article();
    }

   /**
    * Method that returns a boolean depending on the output
    * of the insertion to the DB.
    */
    public boolean insert(int idAutor, int idRevista, String contenido) {

            art.create(idAutor, idRevista, contenido);
            return true;
    }

}