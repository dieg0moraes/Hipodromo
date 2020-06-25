package gui.controllers;

import modelo.Hipodromo;

public class SessionManager {
    private Hipodromo hipodromo;
    
    public SessionManager(Hipodromo hipodromo){
        this.hipodromo = hipodromo;
    }
    
    public Hipodromo getHipodromo(){
        return this.hipodromo;
    }
    
    
}
