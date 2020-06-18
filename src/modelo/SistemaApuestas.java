package modelo;

import exceptions.LoginException;
import exceptions.NewApuestaException;
import java.util.ArrayList;
import java.util.Date;

public class SistemaApuestas {
    private ArrayList<Apuesta> apuestas;
    private Fachada fachada = Fachada.getInstancia();
    public SistemaApuestas(){
        this.apuestas = new ArrayList<Apuesta>();
    }    
    
    public boolean realizarApuesta(Apuesta apuesta) 
            throws NewApuestaException, LoginException{
        Fachada fachada = Fachada.getInstancia();
        UsuarioJugador usuario = apuesta.getJugador();
        usuario = fachada.loginJugador(usuario);
        if(apuesta.validar()){
            return this.apuestas.add(apuesta);            
        }
        return false;
    }
    
    public Apuesta getUltimaApuesta(String username, String password, Carrera carrera) 
            throws LoginException{
        UsuarioJugador user = new UsuarioJugador(username, password);
        UsuarioJugador usuario = fachada.loginJugador(user);
        Date maxDate = null;
        Apuesta apuesta = null;
        for(Apuesta apuesta : this.apuestas){
            if(carrera.apuestaPertence(apuesta)){
                if(maxDate.before(carrera.getDate())){
                    maxDate = carrera.getDate();
                    apuesta = apuesta;
                    break;
               }
            }
        }
    }
}
