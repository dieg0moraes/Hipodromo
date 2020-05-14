package obligatorio2020;
import modelo.Fachada;
import modelo.Hipodromo;

public class Datos {
    public static void carga(){
        Fachada fachada = Fachada.getInstancia();
        Hipodromo h1 = new Hipodromo("Municipal", "Calle falsa 123");
        Hipodromo h2 = new Hipodromo("Maronas", "Otra falsa 321");
        
        fachada.agregarHipodromo(h1);
        fachada.agregarHipodromo(h2);
        
    }
}
