package modelo;

import exceptions.AbrirCarreraException;
import exceptions.FinalizarCarreraException;
import exceptions.CarreraException;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import observer.Observable;

public class Hipodromo extends Observable{
    private String nombre;
    private String direccion;
    private int oid;
    private ArrayList<Jornada> jornadas;
    
    public Hipodromo(String nombre, String direccion){
        this.jornadas = new ArrayList<Jornada>();
        this.nombre = nombre;
        this.direccion = direccion;
    }

    
    public Hipodromo(){
        this.jornadas = new ArrayList<Jornada>();   
    }

    public boolean carreraPertence(Carrera carrera) {
        for(Jornada j : this.jornadas){
            if(j.getCarrearById(carrera.getOid()) != null)
                return true;
        }
        return false;
    }
    
    public enum Events{
        CARRERA_AGREGADA, CARRERA_ABIERTA
    }
    
    public Participacion buscarParticipacionById(int oid){
        for(Jornada j :this.jornadas){
            Participacion p = j.buscarParticipacionById(oid);
            if(p != null)
                return p;
            
        }
        return null;
    }
    
    public int getOid(){
        return oid;
    }
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public ArrayList<Jornada> getJornadas(){
        return this.jornadas;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public boolean agregarCarrera(Carrera carrera) 
            throws NewCarreraException, NewParticipacionException{
        Jornada jornada = this.getJornada(carrera.getDate());        
        boolean ret = jornada.agregarCarrera(carrera);
        this.notificar(Events.CARRERA_AGREGADA);
        return ret;
    }
    
    public Carrera getNextCarrera() throws AbrirCarreraException{
        Jornada jornada = getCurrentJornada();
        return jornada.getNextCarrera();
    }
    
    public Carrera crearCarrera(Date date, String nombre) 
            throws NewCarreraException {
        return this.getJornada(date).crearCarrera(nombre);
    }
    
    public Jornada getJornada(Date date){
        for(Jornada j : this.jornadas){
            if(sameDay(date, j.getDate())){
                return j;
            }
        }
        Jornada jornada = new Jornada(date);
        this.jornadas.add(jornada);
        return jornada;
    }
    
    public Jornada getCurrentJornada(){
        Date today = new Date();
        for(Jornada j : this.jornadas){
            if(sameDay(today, j.getDate())){   
                return j;
            }              
        }
        Jornada jornada = new Jornada(new Date());
        this.jornadas.add(jornada);
        return jornada;
    }
    
    private boolean sameDay(Date date1, Date date2){
        
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                  cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return sameDay;
    }
    
    public boolean siCorreCaballo(Caballo caballo, Date date) {
        boolean corre = false;
        Jornada j = this.getJornada(date);
        if(j.siCorreCaballo(caballo)){
                corre = true;
        }                
        return corre;
    } 
    
    public Carrera getCarreraAbierta() 
            throws CarreraException{
        Jornada jornada = getCurrentJornada();
        return jornada.getCarreraActual();
    }
    
    public void abrirCarrera(Carrera carrera) throws AbrirCarreraException{
        Jornada jornada = this.getCurrentJornada();
        jornada.abrirCarrera(carrera);
    }
    
    public Carrera getLastCarreraCorrida() throws FinalizarCarreraException{
        Jornada jornada = this.getCurrentJornada();
        return jornada.getLastCarreraCorrida();
    }
    
    public ArrayList<Carrera> getCarreras(){
        Jornada jornada = this.getCurrentJornada();
        return jornada.getCarreras();
    }
    
    public ArrayList<Carrera> getCarreras(Date date){
        Jornada jornada = this.getJornada(date);
        return jornada.getCarreras();
    }
    
    public ArrayList<Carrera> getTodayCarrerasParticipacionesModificables(){
        Jornada jornada = this.getCurrentJornada();
        ArrayList<Carrera> carreras = new ArrayList<Carrera>();
        for(Carrera carrera : jornada.getCarreras()){
            if(carrera.isModificable())
                carreras.add(carrera);
        }
        return carreras;
    }
        
    @Override
    public String toString(){
        return this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hipodromo other = (Hipodromo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return true;
    }
}