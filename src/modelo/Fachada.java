package modelo;

import exceptions.NewCarreraException;
import java.util.ArrayList;

public class Fachada {
    private static Fachada instancia;
    private SistemaUsuarios sistemaUsuarios;
    private SistemaHipodromos sistemaHipodromos;
    
    private Fachada(){
        this.sistemaUsuarios = new SistemaUsuarios();
        this.sistemaHipodromos = new SistemaHipodromos();
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
    
    public boolean agregarCarrera(Carrera carrera, Hipodromo hipodromo) throws NewCarreraException{
        return this.sistemaHipodromos.agregarCarrera(carrera, hipodromo);
    }
    
}
