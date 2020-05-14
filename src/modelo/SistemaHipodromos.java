package modelo;

import java.util.ArrayList;

public class SistemaHipodromos {
    
    private ArrayList<Hipodromo> hipodromos;
    
    public SistemaHipodromos(){
        this.hipodromos = new ArrayList<Hipodromo>();
    }
    
    public boolean agregarHipodromo(Hipodromo hipodromo){
        return this.hipodromos.add(hipodromo);
    }
}
