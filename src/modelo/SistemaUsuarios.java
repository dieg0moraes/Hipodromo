package modelo;

import exceptions.LoginException;
import java.util.ArrayList;
import persistencia.Persistencia;
import persistencia.data_mappers.UsuarioAdministradorDataMapper;
import persistencia.data_mappers.UsuarioJugadorDataMapper;

public class SistemaUsuarios {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Usuario> usuariosAdmin;
    
    public SistemaUsuarios(){
        this.usuarios = new ArrayList<Usuario>();
        this.usuariosAdmin = new ArrayList<Usuario>();
    }
    
    public Usuario login(ArrayList<Usuario> usuariosList, 
            Usuario log){
        Usuario ret = null;     
        for(Usuario user : usuariosList){
            if(user.login(log.getPassword(), log.getUsername())){
                ret = user;
                break;                
            }
        }               
        return ret;
    }
    
    public UsuarioAdmin loginAdmin(Usuario log) 
            throws LoginException{
        Usuario user = login(usuariosAdmin, log);
        if(user == null)
            throw new LoginException("Acceso denegado");
            
        return  (UsuarioAdmin)user;
    }
    
    public UsuarioJugador loginJugador(Usuario log) 
            throws LoginException{
        Usuario user = login(usuarios, log);
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
    
    public UsuarioJugador buscarJugadorById(int oid){
        for(Usuario u : this.usuarios){
            if(u.getOid() == oid)
                return (UsuarioJugador)u;
        }
        return null;
    }
    
    public void cargarUsuarios(){
       this.cargarUsuariosAdmin();
       this.cargarUsuariosJugador();        
    }
    
    private void cargarUsuariosJugador(){
        UsuarioJugadorDataMapper mapper = new UsuarioJugadorDataMapper();
        ArrayList<UsuarioJugador> lista = Persistencia.getInstancia().obtenerTodos(mapper);
        for(UsuarioJugador u : lista){
            this.usuarios.add(u);
        }   
    }
    
    private void cargarUsuariosAdmin(){
        UsuarioAdministradorDataMapper mapper = new UsuarioAdministradorDataMapper();
        ArrayList<UsuarioAdmin> lista = Persistencia.getInstancia().obtenerTodos(mapper);
        for(UsuarioAdmin u : lista){
            this.usuariosAdmin.add(u);
        }
    }
}
