package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Hipodromo {
    private String nombre;
    private String direccion;
    private ArrayList<Carrera> carreras;
    
    public Hipodromo(String nombre, String direccion){
        this.carreras = new ArrayList<Carrera>();
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
