package modelo;

import exceptions.NewParticipacionException;

public class Participacion {
    private Caballo caballo;
    private int numero;
    private float dividendo;
    
    public Participacion(Caballo caballo, int numero, float dividendo){
        this.caballo = caballo;
        this.numero = numero;
        this.dividendo = dividendo;
    }
    
    public Caballo getCaballo(){
        return this.caballo;
    }
    
    public boolean validar() 
            throws NewParticipacionException{
        if(!validarDividendo())
            throw new NewParticipacionException("El dividendo debe ser mayor que uno");
        if(!validarNumero())
            throw new NewParticipacionException("Numero de caballo invalido");
        return true;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    private boolean validarNumero(){
        return this.numero >= 1 && this.numero <= 9999;
    }
    
    private boolean validarDividendo(){
        System.out.println("Dividendo" + this.dividendo);
        return this.dividendo > 1.0f;
    }
}
