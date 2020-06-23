package modelo;

import java.util.ArrayList;
import persistencia.Persistencia;
import persistencia.data_mappers.CaballoDataMapper;

public class SistemaCaballos {
    private ArrayList<Caballo> caballos;    
    
    public SistemaCaballos(){
        this.caballos = new ArrayList<Caballo>();
    }
    
    public Caballo buscarCaballoById(int oid){
        for(Caballo c : this.caballos){
            if(c.getOid() == oid)
                return c;
        }
        return null;
    }
    
    public void cargarCaballos(){
        CaballoDataMapper mapper = new CaballoDataMapper();
        ArrayList<Caballo> caballos = Persistencia.getInstancia().obtenerTodos(mapper);
        for(Caballo c : caballos){
            this.caballos.add(c);
        }
    }
    
    public ArrayList<Caballo> getCaballosDisponibles(Carrera carrera){
        Fachada fachada = Fachada.getInstancia();
        ArrayList<Caballo> ret = new ArrayList<Caballo>();
        for(Caballo c : this.caballos){
            if(!fachada.siCorreCaballo(c, carrera.getDate())){
                ret.add(c);
            }
        }     
        return ret;
    }
    
    public boolean agregarCaballo(Caballo caballo){
        if(!existeCaballo(caballo)){
            return this.caballos.add(caballo);
        }
        return false;
    }
    
    public boolean existeCaballo(Caballo caballo){
        for(Caballo c : this.caballos){
            if(c.getNombre().equals(caballo.getNombre()))
                return true;
        }
        return false;
    }
}
