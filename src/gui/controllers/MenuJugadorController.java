package gui.controllers;

import gui.controllers.intefaces.IMenu;
import modelo.Fachada;
import modelo.Hipodromo;

public class MenuJugadorController {
    private IMenu view;
    private Hipodromo hipodromo;
    private Fachada fachada = Fachada.getInstancia();
    
    public MenuJugadorController(IMenu view){
        this.view = view;
        view.cargarDatos(fachada.getHipodromos());
    }
    
    public Hipodromo getHipodromo(){
        return this.hipodromo;
    }
    
}
