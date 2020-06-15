package modelo;

import exceptions.AbrirCarreraException;
import exceptions.FinalizarCarreraException;
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
    private ArrayList<Jornada> jornadas;
    
    public Hipodromo(String nombre, String direccion){
        this.jornadas = new ArrayList<Jornada>();
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Carrera getCarreraAFinalizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum Events{
        CARRERA_AGREGADA, CARRERA_ABIERTA
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
    
    private Jornada getCurrentJornada(){
        Date today = new Date();
        for(Jornada j : this.jornadas){
            if(sameDay(today, j.getDate())){   
                return j;
            }              
        }
        return null;
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
        for(Jornada j : this.jornadas){
            if(j.siCorreCaballo(caballo)){
                corre = true;
                break;
            }
        }        
        return corre;
    } 
    
    public Carrera getCarreraAbierta(){
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