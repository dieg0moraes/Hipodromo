package obligatorio2020;
import modelo.Caballo;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.UsuarioAdmin;

public class Datos {
    public static void carga(){
        Fachada fachada = Fachada.getInstancia();
        Hipodromo h1 = new Hipodromo("Municipal", "Calle falsa 123");
        Hipodromo h2 = new Hipodromo("Maronas", "Otra falsa 321");
        
        Caballo c1 = new Caballo("Bucéfalo", "Encargado uno");
        Caballo c2 = new Caballo("Rocinante", "Encargado uno");
        Caballo c3 = new Caballo("Babieca", "Encargado uno");
        Caballo c4 = new Caballo("El caballo de Troya", "Encargado uno");
        Caballo c5 = new Caballo("Seabiscuit", "Encargado dos");
        Caballo c6 = new Caballo("Tiro al Blanco", "Encargado dos");
        Caballo c7 = new Caballo("Pegaso", "Encargado dos");
        Caballo c8 = new Caballo("Siete Leguas", "Encargado dos");
        
        fachada.agregarHipodromo(h1);
        fachada.agregarHipodromo(h2);
        
        fachada.agregarCaballo(c1);
        fachada.agregarCaballo(c2);
        fachada.agregarCaballo(c3);
        fachada.agregarCaballo(c4);
        fachada.agregarCaballo(c5);
        fachada.agregarCaballo(c6);
        fachada.agregarCaballo(c7);
        fachada.agregarCaballo(c8);
        
        UsuarioAdmin ad = new UsuarioAdmin("admin", "admin");
        boolean a = fachada.agregarUsuarioAdmin(ad);
        System.out.println("Loaded data");
        
        
    }
}
