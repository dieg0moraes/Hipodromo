package modelo;

import exceptions.LoginException;
import exceptions.NewApuestaException;
import java.util.ArrayList;
import observer.Observable;
import persistencia.Persistencia;
import persistencia.data_mappers.ApuestaDataMapper;
import persistencia.data_mappers.TipoApuestaDataMapper;

public class SistemaApuestas extends Observable{
    private ArrayList<Apuesta> apuestas;
    private ArrayList<TipoApuesta> tiposApuesta;
    
    public SistemaApuestas(){
        this.apuestas = new ArrayList<Apuesta>();
        this.tiposApuesta = new ArrayList<TipoApuesta>();
    }   
    
    public enum Events{
        NUEVA_APUESTA
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
        UsuarioJugador user = fachada.loginJugador(apuesta.getJugador());
        apuesta.setJugador(user);
        if(apuesta.validar()){
            user.decrementarSaldo(apuesta.getDecremento());
            user.addApuesta(apuesta);            
            return this.apuestas.add(apuesta);            
        }
        return false;
    } 
    
    public Apuesta getUltimaApuesta(String username, String password) 
            throws LoginException{
        UsuarioJugador user = new UsuarioJugador(username, password);
        Fachada fachada = Fachada.getInstancia();
        user = fachada.loginJugador(user);
        
        return user.getLastApuesta();
    }
    
    public ArrayList<Apuesta> getApuestasDeCarrera(Carrera carrera){
        ArrayList<Apuesta> retorno = new ArrayList<Apuesta>();
        for(Apuesta a : this.apuestas){
            if(a.getCarrera().equals(carrera))
                retorno.add(a);
        }
        return retorno;
    } 
    
        public boolean apuestaPertence(Apuesta apuesta, Carrera carrera){
        boolean ret = false;
        for(Apuesta a : this.getApuestasDeCarrera(carrera)){
            if(a.equals(apuesta)){
                return true;
            }
        }
        return ret;
    }
    
     public void pagar(Carrera carrera){
        for(Apuesta a : this.getApuestasDeCarrera(carrera)){            
            if(a.apostoACaballo(carrera.getGanador())){
                a.getJugador().aumentarSaldo(a.getMontoGanado());
            }
                     
        }
    }
     
     public ArrayList<UsuarioJugador> getGanadores(Carrera carrera){
        ArrayList<UsuarioJugador> ganadores = new ArrayList<UsuarioJugador>();
        if(carrera.isFinalizada()){
            for(Apuesta apuesta : this.getApuestasDeCarrera(carrera)){
                if(apuesta.apostoACaballo(carrera.getGanador()) && !ganadores.contains(apuesta.getJugador()))
                    ganadores.add(apuesta.getJugador());
            }
        }
        return ganadores;
    }
    
    public boolean isGanador(UsuarioJugador jugador, Carrera carrera){
        for(Apuesta apuesta : this.getApuestasDeCarrera(carrera))
            if(apuesta.apostoACaballo(carrera.getGanador()))
                return true;
        return false;
    }
    
    
    public ArrayList<Participacion> getParticipacionesConApuestas(){
        ArrayList<Participacion> ret = new ArrayList<Participacion>();
        for(Apuesta a : this.apuestas){
            Participacion p = a.getParticipacion();
            if(!ret.contains(p)){
                ret.add(p);
            }
        }
        return ret;
    }
    
    public boolean isModificable(Participacion participacion, Carrera carrera){
        for(Apuesta p : this.getApuestasDeCarrera(carrera)){
            if(p.getParticipacion().equals(participacion)) {
                return false;
            }  
        }
        return true;   
    }
    
    public float getMontoTotalApostado(Carrera carrera){
        float total = 0;
        for(Apuesta a : this.getApuestasDeCarrera(carrera)){
            total += a.getMonto();
        }
        return total;
    }
        
    public float getMontoTotalApostado(Caballo caballo){
        float total = 0;
        for(Apuesta a : this.getApuestasDeUnCaballo(caballo)){
            total += a.getMonto();
        }
        return total;        
    }
    
    public ArrayList<Apuesta> getApuestasDeUnCaballo(Caballo caballo){
        ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
        for(Apuesta a : this.apuestas){
            if(a.getCaballo().equals(caballo))
                apuestas.add(a);
        }
        return apuestas;
    }
    
    public float getMontoTotalPagado(Carrera carrera){
        float total = 0;
        if(carrera.isFinalizada()){
            for(Apuesta c : this.getApuestasDeCarrera(carrera)){
                if(carrera.esGanador(c.getCaballo())){
                    total += c.getMontoGanado();
                }
            }
        }        
        return total;
    }
    public ArrayList<Participacion> getParticipacionesModificables(Carrera carrera){
        ArrayList<Participacion> ret = new ArrayList<Participacion>();
        for(Participacion p : carrera.getParticipaciones()){
            if(isModificable(p, carrera))
                ret.add(p);
        }
        return ret;
    }
        
    public void addApuesta(Apuesta apuesta){
        this.apuestas.add(apuesta);
        this.notificar(Events.NUEVA_APUESTA);
    }

    public float getMontoTotalApostado(Carrera carrera, Caballo caballo) {
        float monto = 0;
        for(Apuesta a : this.getApuestasDeCarrera(carrera)){
            if(a.getCaballo().equals(caballo))
                monto += a.getMonto();
        }
        return monto;
    }
    
    
    
    
}