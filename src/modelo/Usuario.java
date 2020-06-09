package modelo;

import java.util.Objects;

public class Usuario {
    
    private String nombre;
    private String apellido;
    private String password;
    private String username;
    
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }    
    
    public void setNombreCompleto(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        
    }
    public String getNombreCompleto(){
        return nombre + " " +apellido;
    }
    
    public boolean login(String password, String username){
        return password.equals(this.password) && username.equals(this.username);        
    }
        
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.apellido);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.username);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    
    

    
}
