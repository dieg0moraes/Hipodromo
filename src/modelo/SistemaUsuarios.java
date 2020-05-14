package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class SistemaUsuarios {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Usuario> usuariosAdmin;
    
    public SistemaUsuarios(){
        this.usuarios = new ArrayList<Usuario>();
        this.usuariosAdmin = new ArrayList<Usuario>();
    }
    
    public Usuario login(ArrayList<Usuario> usuariosList, 
            String password, String username){
        Usuario ret = null;       
        boolean found = false;
        Iterator<Usuario> iterator = usuariosList.iterator();
        
        while(iterator.hasNext() && !found){
            Usuario user = iterator.next();
            if(user.login(password, username)){
                found = true;
                ret = user;
            }                
        }
        return ret;
    }
    
    public Usuario loginAdmin(String password, String username){
        Usuario user = login(usuariosAdmin, password, username);
        return user == null ? user : (UsuarioAdmin)user;
    }
    
    public Usuario loginJugador(String password, String username){
        Usuario user = login(usuarios, password, username);
        return user == null ? user : (UsuarioJugador)user;
    }
    
    public boolean agregarUsuario(UsuarioJugador usuario){
        return this.usuarios.add(usuario);
    }    
    
    public boolean agregarUsuario(UsuarioAdmin usuario){
        return this.usuariosAdmin.add(usuario);
    }
}
