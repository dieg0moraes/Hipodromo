package modelo;
public class UsuarioJugador extends Usuario{
    private float saldo;
    
    public UsuarioJugador(String nombre, String password) {
        super(nombre, password);
    }
    
    public boolean tieneSaldo(float monto){
        return saldo >= monto;
    }
    
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    
}
