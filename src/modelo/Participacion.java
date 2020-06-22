package modelo;

import exceptions.NewParticipacionException;

public class Participacion {
    private Caballo caballo;
    private int numero;
    private float dividendo;
    private TipoApuesta tipoApuesta;
    private int oid;
    
    public Participacion(Caballo caballo, int numero, float dividendo){
        this.caballo = caballo;
        this.numero = numero;
        this.dividendo = dividendo;
        this.tipoApuesta = new TipoApuestaSimple();
    }
    
    public Participacion(){
        
    }
    
    public void setTipoApuesta(TipoApuesta tipo){
        this.tipoApuesta = tipo;
    }
    
    public void setDividendo(float dividendo){
        this.dividendo = dividendo;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public int getOid(){
        return this.oid;
    }
    
    public void setCaballo(Caballo caballo){
        this.caballo = caballo;
    }
    
    public Caballo getCaballo(){
        return this.caballo;
    }
    
    public boolean tieneCaballo(Caballo caballo){
        return this.caballo.equals(caballo);
    }
    
    public boolean validar() 
            throws NewParticipacionException{
        if(!validarDividendo())
            throw new NewParticipacionException("El dividendo debe ser mayor que uno");
        if(!validarNumero())
            throw new NewParticipacionException("Numero de caballo invalido");
        return true;
    }
    
    public String getNombreCaballo(){
        return caballo.getNombre();
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public float getDividendo(){
        return this.dividendo;
    }
    
    private boolean validarNumero(){
        return this.numero >= 1 && this.numero <= 9999;
    }
    
    private boolean validarDividendo(){
        System.out.println("Dividendo" + this.dividendo);
        return this.dividendo > 1.0f;
    }
    
    public String toString(){
        return this.caballo.getNombre() + " " + this.numero + " - Dividendo" +this.dividendo;
    }
    
    public void setTipoParticipacion(TipoApuesta tipo){
        this.tipoApuesta = tipo;
    }
    
}

