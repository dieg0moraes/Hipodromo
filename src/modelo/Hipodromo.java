package modelo;

import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Hipodromo {
    private String nombre;
    private String direccion;
    private ArrayList<Jornada> jornadas;
    
    public Hipodromo(String nombre, String direccion){
        this.jornadas = new ArrayList<Jornada>();
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public boolean agregarCarrera(Carrera carrera) 
            throws NewCarreraException, NewParticipacionException{
        Jornada jornada = this.getJornada(carrera.getDate());        
        return jornada.agregarCarrera(carrera);
        
    }
    
    public Carrera getNextCarrera(){
        Jornada jornada = getCurrentJornada();

        return jornada.getCurrenteCarrera();
    }
    
    public Carrera crearCarrera(Date date, String nombre) 
            throws NewCarreraException, NewParticipacionException {
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
    
    
    @Override
    public String toString(){
        return this.nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.direccion);
        return hash;
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