package modelo;

import exceptions.NewApuestaException;
import java.util.Objects;

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
    
    public String getNombreCarrera(){
        return this.participacion.getNombreCarrera();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Apuesta other = (Apuesta) obj;
        if (!Objects.equals(this.jugador, other.jugador)) {
            return false;
        }
        if (!Objects.equals(this.participacion, other.participacion)) {
            return false;
        }
        return true;
    }
    
    
    
    
}