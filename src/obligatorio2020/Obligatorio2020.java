package obligatorio2020;
import exceptions.NewCarreraException;
import gui.UILanding;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Obligatorio2020 {

    public static void main(String[] args) {
        UILanding main = new UILanding();
        try {
            Datos.carga();
        } catch (NewCarreraException ex) {
            Logger.getLogger(Obligatorio2020.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.setVisible(true);
    }
    
}
