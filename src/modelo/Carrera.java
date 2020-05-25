package modelo;
import exceptions.NewCarreraException;
import java.util.ArrayList;
import java.util.Date;
public class Carrera {
    
    private String nombre;
    private Date date;
    private int numero;
    private ArrayList<Participacion> participaciones;

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
    
    
    private boolean validarFecha(){
        return this.date.after(new Date()) || this.date.equals(this.date);
    }  
        
    private boolean validarNombre(){
        return !this.nombre.isEmpty();
    }
    
    public boolean validar() throws NewCarreraException{
        if(!validarNombre())
            throw new NewCarreraException("Nombre invalido");
        if(!validarFecha())
            throw new NewCarreraException("Fecha invalida");
            
        return validarNombre() && validarFecha();
    }
    
    public boolean siCorreCaballo(Caballo caballo){
        for(Participacion p : this.participaciones)
            if(p.getCaballo().equals(caballo))
                return true;
            
        return false;
    }
    
    public boolean agregarParticipacion(Participacion participacion){
        if(participacion.validar())
            return this.participaciones.add(participacion);
        return false
    }
    
    public ArrayList<Caballo> getCaballos(){
        ArrayList<Caballo> caballos = new ArrayList<Caballo>();
        for(Participacion p : this.participaciones){
            caballos.add(p.getCaballo());
        }
        return caballos;
    }
    
    
}
