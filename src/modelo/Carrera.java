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
    private Status status;
    private int oid = 0;
    
    private ArrayList<Participacion> participaciones;    
    private Caballo ganador = null;
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public int getOid(){
        return this.oid;
    }  
    
    public void setNombre(String nombre){
        this.nombre = nombre;       
    }
    
    public void setDate(Date date){
        this.date = date;
    }

    public void addParticipacion(Participacion p) {
        boolean has = false;
        for(Participacion pa : this.participaciones){
            if(pa.getOid() == p.getOid())
            {
                has = true;
                break;
            }
            
        }
        if(!has)
            this.participaciones.add(p);
    }
   
    public enum Events{
        NUEVA_PARTICIPACION, STATUS_CARRERA, PARTICIPACION_ELIMINADA, GANADOR_ASIGNADO
    }
    
    public enum Status{
        DEFINIDA, ABIERTA, CERRADA, FINALIZADA
    }

    public Carrera(){
        this.participaciones = new ArrayList<Participacion>(); 
        this.setStatus(Status.DEFINIDA);
        this.oid = 0;
    }
    
    public Carrera(String nombre, Date date){
        this.nombre = nombre;
        this.date = date;
        this.participaciones = new ArrayList<Participacion>();
        this.setStatus(Status.DEFINIDA);
        this.oid = 0;
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
    
    public boolean isGanador(Caballo caballo){
        if(this.ganador == null) return false;
        return this.ganador.equals(caballo);
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
        if(participacion.validar() && !this.siCorreCaballo(c)){            
            if(!this.numeroIsRegistrado(participacion.getNumero())){
                ret = this.participaciones.add(participacion);
                this.notificar(Events.NUEVA_PARTICIPACION);
                return ret;
            }else throw new NewParticipacionException("Numero de caballo inválido");
        }   
        return ret;   
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
        return this.ganador != null;
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
    
    public boolean isModificable(){
        return this.status == Status.DEFINIDA || this.status == Status.ABIERTA;
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
    
    public boolean esGanador(Caballo caballo){
        if(this.ganador == null) return false;
        return this.ganador.equals(caballo);
    }    
    
    public Participacion buscarParticipacionById(int oid){
        for(Participacion p : this.participaciones){
            if(p.getOid() == oid)
                return p;
        }
        return null;
    }
    
    public boolean estaCerrada(){
        return this.status.equals(Status.CERRADA);
    }
    
    private void setGanador(Caballo caballo){
        this.ganador = caballo;
        
    } 
    
    public void finalizarCarrera(Participacion participacion){
        this.setGanador(participacion.getCaballo());
        this.setStatus(Status.FINALIZADA);
    }
    
   
    
    

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", numero=" + numero + ", status=" + status + '}';
    }
    
}
