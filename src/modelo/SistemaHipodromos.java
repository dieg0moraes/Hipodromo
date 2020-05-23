package modelo;

import exceptions.NewCarreraException;
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
    
    public boolean agregarCarrera(Carrera carrera, Hipodromo hipodromo) throws NewCarreraException{
        if(this.existeHipodromo(hipodromo))            
            return hipodromo.agregarCarrera(carrera);
        return false;
    
    }
    
    public boolean existeHipodromo(Hipodromo hipodromo){
        
        for(Hipodromo h : this.hipodromos){
            System.out.println("hipodromo loop");
            if(h.equals(hipodromo)){
                return true;
            }
        }
        return false;
    }
}
