package controles;
import entidades.Suscriptor;

public class ControlAltaUsuario
{
 
    Suscriptor sus;

    public ControlAltaUsuario() {
        sus = new Suscriptor();
    }

   /**
    * Method that returns a boolean depending on the output
    * of the insertion to the DB.
    */
    public boolean insert(String nom, String lastn, String address,
                            String tarjeta, String suscrip, String mail,
                            String passwd) {

            sus.create(nom, lastn, address, tarjeta, suscrip, mail, passwd);
            return true;
    }

}