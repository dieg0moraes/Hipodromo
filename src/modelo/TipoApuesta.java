package modelo;

public class TipoApuesta {
    private int oid;
    private String tipo;
    
    public TipoApuesta(){
        
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public int getOid(){
        return this.oid;
    }
    
    public void ganoApuesta(float dividendo, UsuarioJugador usuario, Apuesta apuesta, Carrera carrera){
        
    }
    public void perdioApuesta(float dividendo, UsuarioJugador usuario, Apuesta apuesta, Carrera carrera){
        
    }
    
}
