package modelo;

import exceptions.AbrirCarreraException;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import persistencia.Persistencia;
import persistencia.data_mappers.CarreraDataMapper;
import persistencia.data_mappers.HipodromoDataMapper;
import persistencia.data_mappers.JornadaDataMapper;
import persistencia.data_mappers.ParticipacionDataMapper;

public class SistemaHipodromos {
    
    private ArrayList<Hipodromo> hipodromos;
    private ArrayList<Participacion> participaciones;
    private ArrayList<Carrera> carreras;
    private ArrayList<Jornada> jornadas;
    
    public SistemaHipodromos(){
        this.hipodromos = new ArrayList<Hipodromo>();
        this.participaciones = new ArrayList<Participacion>();
        this.carreras = new ArrayList<Carrera>();
        this.jornadas = new ArrayList<Jornada>();
    }
    
    public Participacion buscarParticipacionById(int oid){
        for(Participacion p: this.participaciones){
            if(p.getOid() == oid)
                return p;
        }   
        return null;
    }
    
    public Carrera buscarCarreraById(int oid){
        for(Carrera c : this.carreras){
            if(c.getOid() == oid)
                return c;                        
        }
        return null;
    }
    
    public Jornada buscarJornadaById(int oid){
        for(Jornada j : this.jornadas){
            if(j.getOid() == oid)
                return j;
        }
        return null;
    }
  
    public void cargarHipodromos(){
        HipodromoDataMapper mapper = new HipodromoDataMapper(); 
        ArrayList<Hipodromo> lista = Persistencia.getInstancia().obtenerTodos(mapper);
        for(Hipodromo h : lista){
            this.hipodromos.add(h);
        }
    }
    
    public void cargarParticipaciones(){
        ParticipacionDataMapper mapper = new ParticipacionDataMapper();
        ArrayList<Participacion> list = Persistencia.getInstancia().obtenerTodos(mapper);
        for(Participacion p : list){
            participaciones.add(p);
        }
        
    }
    
    public void cargarCarreras(){
        CarreraDataMapper mapper = new CarreraDataMapper();
        ArrayList<Carrera> lista = Persistencia.getInstancia().obtenerTodos(mapper);
        for(Carrera c : lista){
            this.carreras.add(c);
        }
    }
    
    public void cargarJornadas(){
        JornadaDataMapper mapper = new JornadaDataMapper();
        ArrayList<Jornada> list = Persistencia.getInstancia().obtenerTodos(mapper);
        for(Jornada j : list){
            this.jornadas.add(j);
        }
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
        if(this.existeHipodromo(hipodromo)){
            Persistencia persistentencia = Persistencia.getInstancia();
            CarreraDataMapper mapper = new CarreraDataMapper(carrera, hipodromo.getOid());
            
            return hipodromo.agregarCarrera(carrera);
            
        }            
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