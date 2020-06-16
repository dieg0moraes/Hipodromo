package modelo;

import exceptions.NewApuestaException;

public class Apuesta {
    private UsuarioJugador jugador;
    private Participacion participacion;
    private float monto;
    
    public Apuesta(UsuarioJugador jugador, Participacion participacion, float monto){
        this.jugador = jugador;
        this.participacion = participacion;
        this.monto = monto;
    }
    
    public void setParticipacion(Participacion participacio){
        this.participacion = participacion;
    }
    
    public float getMonto(){
        return this.monto;
    } 
    
    public UsuarioJugador getJugador(){
        return this.jugador;
    }
    
    public boolean validar() 
            throws NewApuestaException{
        return this.validarMonto() && this.usuarioTieneSaldo();
    }
    
    public boolean validarMonto() 
            throws NewApuestaException{
        if(this.monto < 1)
            throw new NewApuestaException("Monto invalido");
        return true;
    }
    
    public boolean usuarioTieneSaldo() 
            throws NewApuestaException{
        if(!this.jugador.tieneSaldo(monto))
            throw new NewApuestaException("Saldo insuficiente");
        return true;
    }
    
    public Caballo getCaballo(){
        return this.participacion.getCaballo();
    }
    
    public boolean apostoACaballo(Caballo caballo){
        return this.participacion.tieneCaballo(caballo);
    }
    
    
}