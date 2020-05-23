package obligatorio2020;
import gui.UILanding;

public class Obligatorio2020 {

    public static void main(String[] args) {
        UILanding main = new UILanding();
        Datos.carga();
        main.setVisible(true);
    }
    
}
