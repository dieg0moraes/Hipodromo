package modelo;

import java.util.Objects;

public class Caballo {
    private String nombre;
    private String responsable;
    private int oid;

    public Caballo(String nombre, String responsable){
        this.nombre = nombre;
        this.responsable = responsable;
    }
    
    public Caballo(){
        
    }

    public int getOid(){
        return this.oid;
    }

    public void setOid(int oid){
        this.oid = oid;
    }    

    public String getNombre(){
        return this.nombre;
    }
    
    public void setResponsable(String responsable){
        this.responsable = responsable;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Caballo: " + nombre;
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
        final Caballo other = (Caballo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }

        return true;
    }



}
