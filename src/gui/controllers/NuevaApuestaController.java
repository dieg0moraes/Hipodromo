package gui.controllers;

import exceptions.CarreraException;
import exceptions.LoginException;
import exceptions.NewApuestaException;
import gui.controllers.intefaces.INuevaApuesta;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import observer.Observable;
import observer.Observador;

public class NuevaApuestaController implements Observador{    
    private INuevaApuesta view;
    private Fachada fachada;
    private Carrera carrera;
    
    public NuevaApuestaController(INuevaApuesta view, Hipodromo hipodromo){
        this.view = view;
        this.fachada = Fachada.getInstancia();
        try{
            this.loadView(hipodromo.getCarreraAbierta());
        }catch(CarreraException ex){
            view.showError(ex.getMessage());
        }
    }
    
    private void loadView(Carrera carrera){
        this.carrera = carrera;
        carrera.agregar(this);
        this.view.loadCarrera(carrera);
    }
   
    public void apostar(Apuesta apuesta){
        try {
            this.fachada.realizarApuesta(apuesta);
        } catch (NewApuestaException | LoginException ex) {
            this.view.showError(ex.getMessage());
        }
        
    }

    @Override
    public void actualizar(Object event, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}
