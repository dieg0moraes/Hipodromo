package gui.controllers;

import exceptions.LoginException;
import exceptions.NewApuestaException;
import gui.controllers.intefaces.INuevaApuesta;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;

public class NuevaApuestaController {    
    private INuevaApuesta view;
    private Fachada fachada;
    
    public NuevaApuestaController(INuevaApuesta view, Hipodromo hipodromo){
        this.view = view;
        this.fachada = Fachada.getInstancia();
        this.loadView(hipodromo.getCarreraAbierta());
    }
    
    private void loadView(Carrera carrera){
        this.view.loadCarrera(carrera);
    }
   
    public void apostar(Apuesta apuesta){
        try {
            this.fachada.realizarApuesta(apuesta);
        } catch (NewApuestaException ex) {
            this.view.showError(ex.getMessage());
        } catch (LoginException ex) {
            this.view.showError(ex.getMessage());
        }
        
    }
        
    
}
