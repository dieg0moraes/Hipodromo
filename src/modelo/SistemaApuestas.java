package modelo;

import exceptions.LoginException;
import exceptions.NewApuestaException;
import java.util.ArrayList;
import java.util.Date;
import persistencia.Persistencia;
import persistencia.data_mappers.ApuestaDataMapper;
import persistencia.data_mappers.TipoApuestaDataMapper;

public class SistemaApuestas {
    private ArrayList<Apuesta> apuestas;
    private ArrayList<TipoApuesta> tiposApuesta;
    
    public SistemaApuestas(){
        this.apuestas = new ArrayList<Apuesta>();
        this.tiposApuesta = new ArrayList<TipoApuesta>();
    }    
    
    public void cargarApuestas(){
        ApuestaDataMapper mapper = new ApuestaDataMapper();
        ArrayList<Apuesta> lista = Persistencia.getInstancia().obtenerTodos(mapper);
        for(Apuesta a : lista){
            this.apuestas.add(a);
        }
    }
    
    public void cargarTipoApuestas(){
        TipoApuestaDataMapper mapper = new TipoApuestaDataMapper();
        ArrayList<TipoApuesta> list = Persistencia.getInstancia().obtenerTodos(mapper);
        for(TipoApuesta t : list){
            this.tiposApuesta.add(t);
        }
    }
    
    public Apuesta buscarApuestaById(int oid){
        for(Apuesta a : this.apuestas){
            if(a.getOid() == oid)
                return a;
        }
        return null;
    }  
    
    public TipoApuesta buscarTipoApuestaById(int oid){
       for(TipoApuesta a : this.tiposApuesta){
           if(a.getOid() == oid)
               return a;
       } 
       return null;
    }
    
    
    
    public boolean realizarApuesta(Apuesta apuesta) 
            throws NewApuestaException, LoginException{
        Fachada fachada = Fachada.getInstancia();
        UsuarioJugador usuario = apuesta.getJugador();
        usuario = fachada.loginJugador(usuario);
        if(apuesta.validar()){
            return this.apuestas.add(apuesta);            
        }
        return false;
    } 
    
    public Apuesta getUltimaApuesta(String username, String password, Carrera carrera) 
            throws LoginException{
        UsuarioJugador user = new UsuarioJugador(username, password);
        Fachada fachada = Fachada.getInstancia();
        UsuarioJugador usuario = fachada.loginJugador(user);
        Date maxDate = null;
        Apuesta apuesta = null;
        for(Apuesta ap : this.apuestas){
            if(carrera.apuestaPertence(ap)){
                if(maxDate.before(carrera.getDate())){
                    maxDate = carrera.getDate();
                    apuesta = ap;
                    break;
               }
            }
        }
        return apuesta;
    }
}
