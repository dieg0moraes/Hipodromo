package modelo;

import java.util.ArrayList;

public class UsuarioJugador extends Usuario{
    private float saldo;
    private Apuesta lastApuesta;
    
    private ArrayList<Apuesta> apuestas;
    
    
    
    public UsuarioJugador(){
         this.apuestas = new ArrayList<Apuesta>();
    }
    
    public UsuarioJugador(String nombre, String password) {
        super(nombre, password);
        this.apuestas = new ArrayList<Apuesta>();
    }
    
    public void addApuesta(Apuesta apuesta){
        this.apuestas.add(apuesta);
        this.setLastApuesta(apuesta);
    }
    
    public void setLastApuesta(Apuesta apuesta){
        this.lastApuesta = apuesta;
    }
    
    public Apuesta getLastApuesta(){
        return this.lastApuesta;
    }    
    public boolean tieneSaldo(float monto){
        return saldo >= monto;
    }
    
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    
    public void aumentarSaldo(float monto){
        this.saldo += monto;
    }
    
    public void decrementarSaldo(float monto){
        this.saldo -= monto;
    }
}
