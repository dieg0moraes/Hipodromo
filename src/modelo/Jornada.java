package modelo;

import exceptions.AbrirCarreraException;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Jornada extends Observable{
    private Date date;
    private ArrayList<Carrera> carreras;
    private int carreraNextId = 0;
    private Carrera carreraActual;    
    
    public Jornada(Date date){
        this.date = date;
        this.carreras = new ArrayList<Carrera>();
    }
    
    public enum Events{
        CARRERA_ABIERTA
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public int getNextCarreraId(){
        return this.carreraNextId;
    }
 
    
    public boolean agregarCarrera(Carrera carrera) 
            throws NewCarreraException, NewParticipacionException{
        if(carrera.validar() && existeCarreraConNombre(carrera))
            throw new NewCarreraException("Ya exist carrera con el nombre:" + carrera.getNombre());
        return this.carreras.add(carrera);
    }
    
    public Carrera getCarrearById(int id){
        for(Carrera c : this.carreras){
            if(id == c.getNumero())
                return c;
        }
        return null;
    }
    
    private void asignarIdCarrera(Carrera carrera){        
        carrera.setNumero(this.carreraNextId);
        this.carreraNextId++;
    }
    
    public boolean existeCarreraConNombre(Carrera carrera){
        for(Carrera c : this.carreras)
            if(c.getNombre().equals(carrera.getNombre()))
                return true;
            return false;
    }
    
    public boolean siCorreCaballo(Caballo caballo){
        for(Carrera c : this.carreras)
            if(c.siCorreCaballo(caballo))
                return true;
        
        return false;
    }
    public Carrera crearCarrera(String nombre) 
            throws NewCarreraException {
        Carrera c = new Carrera(nombre, this.date);
        if(c.validarFecha() && c.validarNombre()){
            asignarIdCarrera(c);
            return c;
        }    
        return null;
        
    }
    private Carrera getPrimeraCarrera(){
        int min = Integer.MAX_VALUE;
        Carrera ret = null;
        for(Carrera c : this.carreras){
            if(c.getNumero() < min){
                min = c.getNumero();
                ret = c;
            }
        }
        return ret;
    }
    

    public Carrera getNextCarrera() throws AbrirCarreraException {
        for(Carrera c : this.carreras){
            if(!c.seCorrio()){
                if(this.carreraActual == null){
                    this.carreraActual = c;
                    return c;
                }                    
                else if(this.carreraActual.seCorrio()){
                    this.carreraActual = c;
                    return c;
                }
            } 
        }
        throw new AbrirCarreraException("No hay carreras para abrir");
    }   
    
    public Carrera getCarreraActual() 
            throws NullPointerException{
        if(this.carreraActual == null)
            throw new NullPointerException("No hay carrera abiertas");
        return this.carreraActual;
    }
    
    public void abrirCarrera(Carrera carrera) throws AbrirCarreraException{
        for(Carrera c : this.carreras){
            if(c.equals(carrera)){
                c.abrirCarrera();
                this.notificar(Events.CARRERA_ABIERTA);
                this.carreraActual = c;
                break;
            }
        }
    }
    
    public ArrayList<Carrera> getCarreras(){
        return this.carreras;
    }
}
