package modelo;

import exceptions.LoginException;
import java.util.ArrayList;

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
        for(Usuario user : usuariosList){
            if(user.login(password, username)){
                ret = user;
                break;                
            }
        }               
        return ret;
    }
    
    public Usuario loginAdmin(String password, String username) 
            throws LoginException{
        Usuario user = login(usuariosAdmin, password, username);
        if(user == null)
            throw new LoginException("Acceso denegado");
            
        return  (UsuarioAdmin)user;
    }
    
    public Usuario loginJugador(String password, String username) 
            throws LoginException{
        Usuario user = login(usuarios, password, username);
        if(user == null)
            throw new LoginException("Los datos no son correctos");
        return (UsuarioJugador)user;
    }
    
    public boolean agregarUsuario(UsuarioJugador usuario){
        return this.usuarios.add(usuario);
    }    
    
    public boolean agregarUsuario(UsuarioAdmin usuario){
        return this.usuariosAdmin.add(usuario);
    }
}
