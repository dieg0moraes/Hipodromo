package modelo;

import java.util.Objects;

public class Caballo {
    private String nombre;
    private String responsable;
    
    public Caballo(String nombre, String responsable){
        this.nombre = nombre;
        this.responsable = responsable;
    }
    
    public String getNombre(){
        return this.nombre;
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
        if (!Objects.equals(this.responsable, other.responsable)) {
            return false;
        }
        return true;
    }
    
    
    
}
