package modelo;

import exceptions.AbrirCarreraException;
import exceptions.LoginException;
import exceptions.NewApuestaException;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;

public class Fachada {
    private static Fachada instancia;
    private SistemaUsuarios sistemaUsuarios;
    private SistemaHipodromos sistemaHipodromos;
    private SistemaCaballos sistemaCaballos;
    private SistemaApuestas sistemaApuestas;
    
    private Fachada(){
        this.sistemaUsuarios = new SistemaUsuarios();
        this.sistemaHipodromos = new SistemaHipodromos();
        this.sistemaCaballos = new SistemaCaballos();
        this.sistemaApuestas = new SistemaApuestas();
    }
    
    public enum Eventos{
        
    }    
    
        
    public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    public UsuarioAdmin loginAdmin(UsuarioAdmin user) 
            throws LoginException{
        return sistemaUsuarios.loginAdmin(user);
    }
    
    public UsuarioJugador loginJugador(UsuarioJugador usuario) 
            throws LoginException{
        return sistemaUsuarios.loginJugador(usuario);
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
    
    public Carrera getNextCarrera(Hipodromo hipodromo) throws AbrirCarreraException{
        return this.sistemaHipodromos.getNextCarrera(hipodromo);
    }
    
    public Carrera crearCarrera(Date date, String nombre, Hipodromo hipodromo) 
            throws NewCarreraException, NewParticipacionException{
        return this.sistemaHipodromos.crearCarrera(date, nombre, hipodromo);
    }

    public boolean realizarApuesta(Apuesta apuesta) 
            throws NewApuestaException, LoginException{
        return this.sistemaApuestas.realizarApuesta(apuesta);
    }
    
    
    
    
       
}
