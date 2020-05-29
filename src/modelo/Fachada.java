package modelo;

import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;

public class Fachada {
    private static Fachada instancia;
    private SistemaUsuarios sistemaUsuarios;
    private SistemaHipodromos sistemaHipodromos;
    private SistemaCaballos sistemaCaballos;
    
    private Fachada(){
        this.sistemaUsuarios = new SistemaUsuarios();
        this.sistemaHipodromos = new SistemaHipodromos();
        this.sistemaCaballos = new SistemaCaballos();
    }
        
    public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    public Usuario loginAdmin(String password, String username){
        return sistemaUsuarios.loginAdmin(password, username);
    }
    
    public Usuario loginJugador(String password, String username){
        return sistemaUsuarios.loginJugador(password, username);
    }
    
    public boolean agregarUsuarioJugador(UsuarioJugador usuario){
        return sistemaUsuarios.agregarUsuario(usuario);
    }
    
    public boolean agregarUsuarioAdmin(UsuarioAdmin usuario){
        return sistemaUsuarios.agregarUsuario(usuario);
    }
    
    public boolean agregarHipodromo(Hipodromo hipodromo){
        return this.sistemaHipodromos.agregarHipodromo(hipodromo);
    }
    
    public ArrayList<Hipodromo> getHipodromos(){
        return this.sistemaHipodromos.getHipodromos();
    }
    
    public Hipodromo getHipodromoByName(String nombre){
        return sistemaHipodromos.getHipodromoByName(nombre);
    }
    
    public boolean agregarCarrera(Carrera carrera, Hipodromo hipodromo) 
            throws NewCarreraException, NewParticipacionException{
        return this.sistemaHipodromos.agregarCarrera(carrera, hipodromo);
    }
    
    public ArrayList<Caballo> getCaballosDisponibles(Carrera carrera){
        return this.sistemaCaballos.getCaballosDisponibles(carrera);
    }
    
    public boolean agregarCaballo(Caballo caballo){
        return this.sistemaCaballos.agregarCaballo(caballo);
    }
    
    public boolean siCorreCaballo(Caballo caballo, Date date){
        return this.sistemaHipodromos.siCorreCaballo(caballo, date);
    } 

    public Jornada getJornadaDe(Hipodromo hipodromo, Date date) {
        return sistemaHipodromos.getJornadaDe(hipodromo, date);
    }
    
    public Carrera crearCarrera(Date date, String nombre, Hipodromo hipodromo) 
            throws NewCarreraException, NewParticipacionException{
        return this.sistemaHipodromos.crearCarrera(date, nombre, hipodromo);
    }
    
}
