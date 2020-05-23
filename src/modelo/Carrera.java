package modelo;
import exceptions.NewCarreraException;
import java.util.Date;
public class Carrera {
    private String nombre;
    private Date date;
    private int numero;

    public Carrera(){
        
    }
    public Carrera(String nombre, Date date){
        this.nombre = nombre;
        this.date = date;
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
    
    public Date getDate(){
        return this.date;
    }
    
}
