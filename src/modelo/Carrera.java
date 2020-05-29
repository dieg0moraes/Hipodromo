package modelo;
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
    
    public enum Events{
        NUEVA_PARTICIPACION
    }
    
    public enum Status{
        ABIERTA, CERRADA, FINALIZADA
    }

    public Carrera(){
        this.participaciones = new ArrayList<Participacion>();        
    }
    
    public Carrera(String nombre, Date date){
        this.nombre = nombre;
        this.date = date;
        this.participaciones = new ArrayList<Participacion>();
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
    
    
}
