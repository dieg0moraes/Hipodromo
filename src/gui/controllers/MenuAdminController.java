package gui.controllers;

import gui.controllers.intefaces.IMenu;
public class MenuAdminController extends MenuController{  
    
    public MenuAdminController(IMenu view){
        super(view);
        this.cargarDatos();
        
    }       
}
