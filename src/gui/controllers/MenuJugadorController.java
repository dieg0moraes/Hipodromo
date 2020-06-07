package gui.controllers;

import gui.controllers.intefaces.IMenu;
import modelo.Hipodromo;

public class MenuJugadorController {
    private IMenu view;
    private Hipodromo hipodromo;
    
    public MenuJugadorController(IMenu view){
        this.view = view;
    }
    
    public Hipodromo getHipodromo(){
        return this.hipodromo;
    }
    
}
