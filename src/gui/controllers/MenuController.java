package gui.controllers;

import gui.controllers.intefaces.IMenu;
import java.util.ArrayList;
import modelo.Fachada;
import modelo.Hipodromo;

public abstract class MenuController {
    private Fachada fachada = Fachada.getInstancia();  
    private IMenu view;
    
    public MenuController(IMenu view){
        this.view = view;
    }
    
    public void cargarDatos(){
        ArrayList<Hipodromo> hipodromos = this.fachada.getHipodromos();
        this.view.cargarDatos(hipodromos);
        
    }   
    
}
