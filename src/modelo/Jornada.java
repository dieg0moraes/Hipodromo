package modelo;

import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;

public class Jornada {
    private Date date;
    private ArrayList<Carrera> carreras;
    private int carreraNextId = 0;
    
    public Jornada(Date date){
        this.date = date;
        this.carreras = new ArrayList<Carrera>();
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public boolean agregarCarrera(Carrera carrera) 
            throws NewCarreraException, NewParticipacionException{
        
        if(carrera.validar() && existeCarreraConNombre(carrera))
            throw new NewCarreraException("Ya exist carrera con el nombre:" + carrera.getNombre());

        this.asignarIdCarrera(carrera);
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
    
    
}
