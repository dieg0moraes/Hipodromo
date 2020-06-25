package obligatorio2020;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Participacion;

public class Datos {
    public static void carga() throws NewCarreraException{
        Fachada fachada = Fachada.getInstancia();
        fachada.cargarUsuarios();        
        fachada.cargarCaballos();
        fachada.cargarTipoApuestas();
        fachada.cargarParticipaciones();
        fachada.cargarApuestas();
        fachada.cargarCarreras();
        fachada.cargarJornadas();
        fachada.cargarHipodromos();
        
        Hipodromo h = fachada.getHipodromoByName("Maronas");
        
        Caballo c1 = fachada.buscarCaballosById(9);
        Caballo c2 = fachada.buscarCaballosById(10);
        Caballo c3 = fachada.buscarCaballosById(11);
        Caballo c4 = fachada.buscarCaballosById(12);
               
        
        Participacion p1 = new Participacion(c1, 1, 1.1f);
        Participacion p2 = new Participacion(c2, 2, 1.2f);
        
        Participacion p3 = new Participacion(c3, 2, 1.3f);
        Participacion p4 = new Participacion(c4, 3, 1.5f);
        
        Carrera c;
        Carrera ca1;
        try {
            c = fachada.crearCarrera(new Date(), "Carrera 0", h);
            c.agregarParticipacion(p1);
            c.agregarParticipacion(p2);
            h.agregarCarrera(c);
            
            ca1 = fachada.crearCarrera(new Date(), "Carrera 1", h);
            ca1.agregarParticipacion(p3);
            ca1.agregarParticipacion(p4);
            h.agregarCarrera(ca1);
        } catch (NewParticipacionException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
              
        /*
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
        fachada.agregarUsuarioAdmin(ad);
        
        UsuarioJugador aj = new UsuarioJugador("user", "user");
        fachada.agregarUsuarioJugador(aj);
        
        Participacion p1 = new Participacion(c1, 1, 1.1f);
        Participacion p2 = new Participacion(c2, 2, 1.2f);
        
        Participacion p3 = new Participacion(c3, 2, 1.3f);
        Participacion p4 = new Participacion(c4, 3, 1.5f);
        
        Carrera c;
        Carrera ca1 = null;
        try {
            c = fachada.crearCarrera(new Date(), "Carrera 0", h1);
            c.agregarParticipacion(p1);
            c.agregarParticipacion(p2);
            h1.agregarCarrera(c);
            
            ca1 = fachada.crearCarrera(new Date(), "Carrera 1", h1);
            ca1.agregarParticipacion(p3);
            ca1.agregarParticipacion(p4);
            h1.agregarCarrera(ca1);
        } catch (NewParticipacionException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        aj.setSaldo(10000);
        Apuesta a = new Apuesta(aj, p1, 10);
        
        try {
            fachada.realizarApuesta(a);
        } catch (NewApuestaException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LoginException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        */
        System.out.println("Loaded data");
        
        
    }
}
