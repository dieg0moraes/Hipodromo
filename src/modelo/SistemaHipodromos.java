package modelo;

import exceptions.AbrirCarreraException;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class SistemaHipodromos {
    
    private ArrayList<Hipodromo> hipodromos;
    
    public SistemaHipodromos(){
        this.hipodromos = new ArrayList<Hipodromo>();
    }
    
    public boolean agregarHipodromo(Hipodromo hipodromo){
        return this.hipodromos.add(hipodromo);
    }
    
    public ArrayList<Hipodromo> getHipodromos(){
        return this.hipodromos;
    }
    
    public Hipodromo getHipodromoByName(String name){
        Hipodromo ret = null;  
        Iterator<Hipodromo> iterator = hipodromos.iterator(); 
     
        while(iterator.hasNext() && ret == null){
            Hipodromo hipodromo = iterator.next();
            if(hipodromo.getNombre() == name){
                ret = hipodromo;
            }                
        }
        return ret;
    } 
    
    public boolean agregarCarrera(Carrera carrera, Hipodromo hipodromo) 
            throws NewCarreraException, NewParticipacionException{
        if(this.existeHipodromo(hipodromo))            
            return hipodromo.agregarCarrera(carrera);
        return false;
    
    }
    
    public boolean existeHipodromo(Hipodromo hipodromo){
        for(Hipodromo h : this.hipodromos){
            if(h.equals(hipodromo)){
                return true;
            }
        }
        return false;
    }

    public boolean siCorreCaballo(Caballo caballo, Date date) {
        for(Hipodromo h : this.hipodromos)
            if(h.siCorreCaballo(caballo, date))
                return true;
            
        return false;
    }

    public Jornada getJornadaDe(Hipodromo hipodromo, Date date) {
        Hipodromo h = this.getHipodromoByName(hipodromo.getNombre());
        return h.getJornada(date);
    }

    public Carrera crearCarrera(Date date, String nombre, Hipodromo hipodromo) 
            throws NewCarreraException, NewParticipacionException {
        Hipodromo h = this.getHipodromoByName(hipodromo.getNombre());
        return h.crearCarrera(date, nombre);
    }
    
    public Carrera getNextCarrera(Hipodromo hipodromo) throws AbrirCarreraException{
        return hipodromo.getNextCarrera();
    }
    
    
   
}