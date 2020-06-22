package modelo;

import exceptions.LoginException;
import exceptions.NewApuestaException;
import java.util.ArrayList;
import java.util.Date;

public class SistemaApuestas {
    private ArrayList<Apuesta> apuestas;
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
        Fachada fachada = Fachada.getInstancia();
        UsuarioJugador usuario = fachada.loginJugador(user);
        Date maxDate = null;
        Apuesta apuesta = null;
        for(Apuesta ap : this.apuestas){
            if(carrera.apuestaPertence(ap)){
                if(maxDate.before(carrera.getDate())){
                    maxDate = carrera.getDate();
                    apuesta = ap;
                    break;
               }
            }
        }
        return apuesta;
    }
}
