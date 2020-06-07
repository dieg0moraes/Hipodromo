package modelo;

import exceptions.LoginException;
import exceptions.NewApuestaException;
import java.util.ArrayList;

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
}
