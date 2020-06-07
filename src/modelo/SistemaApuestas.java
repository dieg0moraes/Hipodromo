package modelo;

import exceptions.LoginException;
import exceptions.NewApuestaException;
import java.util.ArrayList;

public class SistemaApuestas {
    private ArrayList<Apuesta> apuestas;
    public SistemaApuestas(){
        this.apuestas = new ArrayList<Apuesta>();
    }    
    
    public boolean realizarApuesta(Carrera carrera, Participacion participacion, String username, String password, float monto) 
            throws NewApuestaException, LoginException{
        Fachada fachada = Fachada.getInstancia();
        UsuarioJugador usuario = (UsuarioJugador) fachada.loginJugador(password, username);
        Apuesta apuesta = new Apuesta(usuario, participacion, monto);
        if(apuesta.validar()){
            return this.apuestas.add(apuesta);            
        }
        return false;
    }
}
