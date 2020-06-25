package modelo;

import exceptions.AbrirCarreraException;
import exceptions.FinalizarCarreraException;
import exceptions.CarreraException;
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
    private int oid;
      
    public Jornada(Date date){
        this.date = date;
        this.carreras = new ArrayList<Carrera>();
    }

    public Jornada() {
        this.carreras = new ArrayList<Carrera>();
    }
    
     public enum Eventos{
        NUEVA_CARRERA_ACTUAL, NUEVA_CARRERA_AGREGADA
    }
    
    
    public Participacion buscarParticipacionById(int oid){
        for(Carrera c : this.carreras){
            Participacion p = c.buscarParticipacionById(oid);
            if(p != null)
                return p;
            
        }
        return null;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public int getOid(){
        return this.oid;
    }
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public void setSiguienteCarrera(int carrera){
        this.carreraNextId = carrera;
    }
    
    public void setCarreraActual(Carrera carrera){
        this.carreraActual = carrera;
        this.notificar(Eventos.NUEVA_CARRERA_ACTUAL);
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
        if(this.carreras !=null){
            for(Carrera c : this.carreras){
                if(id == c.getOid())
                    return c;
            }            
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

    public Carrera getNextCarrera() throws AbrirCarreraException {
        for(Carrera c : this.carreras){
            if(!c.seCorrio()){
                if(this.carreraActual == null){
                    this.setCarreraActual(c);
                    return c;
                }                    
                else if(this.carreraActual.seCorrio()){
                    this.setCarreraActual(c);
                    return c;
                }
            } 
        }
        throw new AbrirCarreraException("No hay carreras para abrir");
    }   
    
    public Carrera getCarreraActual() 
            throws CarreraException{
        if(this.carreraActual == null)
            throw new CarreraException("No hay carrera abiertas");
        return this.carreraActual;
    }
    
    public void abrirCarrera(Carrera carrera) throws AbrirCarreraException{
        for(Carrera c : this.carreras){
            if(c.equals(carrera)){
                c.abrirCarrera();                
                this.setCarreraActual(c);
                break;
            }
        }
    }
        
    public Carrera getLastCarreraCorrida() throws FinalizarCarreraException{
        for(Carrera c : this.carreras){
            if(c.estaCerrada())
                return c;
        }
        throw new FinalizarCarreraException("No hay carreras para finalizar");
    }     
    public ArrayList<Carrera> getCarreras(){
        return this.carreras;
            
    }
}
