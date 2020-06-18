package modelo;
import exceptions.AbrirCarreraException;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Carrera extends Observable{
    
    private String nombre;
    private Date date;
    private int numero;
    private ArrayList<Participacion> participaciones;
    private Status status;
    private Caballo ganador = null;
    private ArrayList<Apuesta> apuestas;
    
    
    public enum Events{
        NUEVA_PARTICIPACION, STATUS_CARRERA, PARTICIPACION_ELIMINADA, NUEVA_APUESTA
    }
    
    public enum Status{
        ABIERTA, CERRADA, FINALIZADA, DEFINIDA
    }

    public Carrera(){
        this.participaciones = new ArrayList<Participacion>(); 
        this.apuestas = new ArrayList<Apuesta>();
        this.setStatus(Status.DEFINIDA);
    }
    
    public Carrera(String nombre, Date date){
        this.nombre = nombre;
        this.date = date;
        this.participaciones = new ArrayList<Participacion>();
        this.apuestas = new ArrayList<Apuesta>();
        this.setStatus(Status.DEFINIDA);
    }
    
    public ArrayList<Participacion> getParticipaciones(){
        return this.participaciones;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public boolean validarFecha() throws NewCarreraException{
        if(this.date.after(new Date()) || this.date.equals(this.date))
            return true;
        throw new NewCarreraException("Fecha invalida");
    }  
        
    public boolean validarNombre() throws NewCarreraException{
        if(this.nombre.isEmpty())
            throw new NewCarreraException("Nombre invalido");
        return true;
    }
    
    public boolean validar() 
            throws NewCarreraException, NewParticipacionException{
        if(validarNombre() && validarFecha() && validarParticipaciones())
            return true;
        return false;
    }
    
    public boolean siCorreCaballo(Caballo caballo){
        for(Participacion p : this.participaciones)
            if(p.getCaballo().equals(caballo))
                return true;
            
        return false;
    }
    
    private boolean numeroIsRegistrado(int numero){
        boolean ret = false;
        for(Participacion p : this.participaciones){
            if(p.getNumero() == numero){
                ret = true;
                break;
            }
        }
        
        return ret;
    }
    
    public boolean agregarParticipacion(Participacion participacion) 
            throws NewParticipacionException{
        boolean ret = false;
        Caballo c = participacion.getCaballo();
        try{
            if(participacion.validar() && !this.siCorreCaballo(c))
                if(!this.numeroIsRegistrado(participacion.getNumero())){
                    ret = this.participaciones.add(participacion);
                }else throw new NewParticipacionException("Numero de caballo inválido");
                
        }catch(NewParticipacionException e){
            throw e;
        }
        if(ret) 
            this.notificar(Events.NUEVA_PARTICIPACION);
        return ret;        
    }
    
    public float getMontoTotalApostado(){
        float total = 0;
        for(Apuesta a : this.apuestas){
            total += a.getMonto();
        }
        return total;
    }
        
    public float getMontoTotalApostado(Caballo caballo){
        float total = 0;
        for(Apuesta a : this.getApuestasDeUnCaballo(caballo)){
            total += a.getMonto();
        }
        return total;        
    }
    
    public ArrayList<Apuesta> getApuestasDeUnCaballo(Caballo caballo){
        ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
        for(Apuesta a : this.apuestas){
            if(a.getCaballo().equals(caballo))
                apuestas.add(a);
        }
        return apuestas;
    }
    
    private boolean validarParticipaciones() 
            throws NewParticipacionException{
        if(this.participaciones.size() >= 2)
            return true;    
        throw new NewParticipacionException("Debe seleccionar al menos 2 caballos participantes");
        
    }
    
    public ArrayList<Caballo> getCaballos(){
        ArrayList<Caballo> caballos = new ArrayList<Caballo>();
        for(Participacion p : this.participaciones){
            caballos.add(p.getCaballo());
        }
        return caballos;
    }
    
    public boolean tieneGanador(){
        return this.ganador == null;
    }
    
    public boolean seCorrio(){
        return this.status == Status.FINALIZADA && this.tieneGanador();
    }
    
    public void abrirCarrera() throws AbrirCarreraException{
        if(Status.ABIERTA != this.status)
            this.setStatus(Status.ABIERTA);
        else throw new AbrirCarreraException("No hay carreras para abrir");
    }
    
    public void setStatus(Status status){
        this.status = status;
        this.notificar(Events.STATUS_CARRERA);
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public Caballo getGanador(){
        return this.ganador;
    } 
    
     public boolean isAbierta() {
        return this.status == Status.ABIERTA;
    }
    
    public void cerrarApuestas(){
        this.setStatus(Status.CERRADA);         
    }
     
    public void eliminarCaballoParticipante(Caballo caballo){
        for(Participacion p : this.participaciones){
            if(p.tieneCaballo(caballo)){
                this.participaciones.remove(p);            
                this.notificar(Events.PARTICIPACION_ELIMINADA);
                break;
            }                
        }
    }
    
    public boolean isFinalizada(){
        return this.status.equals(Status.FINALIZADA) && this.ganador != null;
    }
    
    public ArrayList<UsuarioJugador> getGanadores(){
        ArrayList<UsuarioJugador> ganadores = new ArrayList<UsuarioJugador>();
        if(this.isFinalizada()){
            for(Apuesta apuesta : this.apuestas){
                if(apuesta.apostoACaballo(this.ganador))
                    ganadores.add(apuesta.getJugador());
            }
        }
        return ganadores;
    }
    
    public boolean isGanador(UsuarioJugador jugador){
        for(Apuesta apuesta : this.apuestas)
            if(apuesta.apostoACaballo(this.ganador))
                return true;
        return false;
    }
    
    public boolean isGanador(Caballo caballo){
        if(this.ganador == null) return false;
        return this.ganador.equals(caballo);
    }
    
    public float getMontoTotalPagado(){
        float total = 0;
        
        return total;
    }
    
    

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", numero=" + numero + ", status=" + status + '}';
    }
    
    
    
    
    
}
