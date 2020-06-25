package modelo;

import exceptions.NewApuestaException;
import java.util.Date;
import java.util.Objects;

public class Apuesta {
    private UsuarioJugador jugador;
    private Participacion participacion;
    private float monto;
    private int oid;
    private Carrera carrera;
    
    public Apuesta(UsuarioJugador jugador, Participacion participacion, float monto){
        this.jugador = jugador;
        this.participacion = participacion;
        this.monto = monto;
        this.oid = 0;
    }

    public Apuesta() {
        this.oid = 0; 
    }
    
    public int getOid(){
        return this.oid;
    }
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public boolean esDeJugador(UsuarioJugador user){
        return this.equals(user);
    }   
    
    public void setParticipacion(Participacion participacion){
        this.participacion = participacion;
    }
    
    public Participacion getParticipacion(){
        return this.participacion;
    }
    
    public float getMonto(){
        return this.monto;
    } 
    
    public UsuarioJugador getJugador(){
        return this.jugador;
    }
    
    public boolean validar() 
            throws NewApuestaException{
        return this.validarMonto() && this.usuarioTieneSaldo() & this.carrera.isAbierta();
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
    
    public void setMonto(float monto){
        this.monto = monto;
    }
    
    public float getDecremento(){
        return this.participacion.getDecremento(this, this.carrera);
    }
    
    public float getMontoGanado(){
        return this.participacion.getMontoGanado(this, this.carrera);
    }
    
    public float getDividendo(){
        return this.participacion.getDividendo();
    }

    
    public Carrera getCarrera(){
        return this.carrera;
    }
    
    public void setCarrera(Carrera carrera){
        this.carrera = carrera;
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

    public void setJugador(UsuarioJugador user) {
        this.jugador = user;
    }

    public String getNombreCaballo() {
        return this.participacion.getNombreCaballo();
    }

    public String getNombreCarrera() {
        return this.carrera.getNombre();
    }

    public Date getFechaCarrera() {
        return this.carrera.getDate();
    }

    public int getNumeroCaballo() {
        return this.participacion.getNumero();
    }

    public int getNumeroCarrera() {
        return this.carrera.getNumero();
    }
}