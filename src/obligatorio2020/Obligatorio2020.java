package obligatorio2020;
import exceptions.NewCarreraException;
import gui.UILanding;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.BaseDatos;

public class Obligatorio2020 {

    public static void main(String[] args) {
        UILanding main = new UILanding();
        BaseDatos bd = BaseDatos.getInstancia();
        try {
            String url = "jdbc:mysql://localhost:3306/hipodromo";
            bd.conectar("com.mysql.jdbc.Driver",url, "root", "rootroot");
            Datos.carga();
            bd.desconectar();
        
        } catch (NewCarreraException ex) {
            Logger.getLogger(Obligatorio2020.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.setVisible(true);
    }
    
}
