package gui.controllers;

import exceptions.AbrirCarreraException;
import gui.controllers.intefaces.IAbrirCarrera;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import observer.Observable;
import observer.Observador;

public class AbrirCarreraController implements Observador{
    private IAbrirCarrera view;
    private Carrera carrera;
    private Hipodromo hipodromo;
    private Fachada fachada = Fachada.getInstancia();
    
    public AbrirCarreraController(IAbrirCarrera view, Hipodromo hipodromo){
        this.view = view;
        Carrera carrera = null;
        try {
            carrera = this.fachada.getNextCarrera(hipodromo);
            this.carrera = carrera;   
            this.carrera.agregar(this);
            this.hipodromo = hipodromo;
            this.cargarDatos();
        } catch (AbrirCarreraException ex) {
            this.view.error(ex.getMessage());
        }
    }
    
    public void cargarDatos(){
        this.view.cargarDatos(carrera);
    }
    
    public void abrirCarrera(){
        try {
            this.hipodromo.abrirCarrera(this.carrera);
            this.view.success("Carrera abierta");
        } catch (AbrirCarreraException ex){
            view.error(ex.getMessage());
        }
    }    

    @Override
    public void actualizar(Object event, Observable origen) {
        if(event.equals(Carrera.Events.NUEVA_PARTICIPACION) | event.equals(Carrera.Events.PARTICIPACION_ELIMINADA)
                | event.equals(Carrera.Events.STATUS_CARRERA))
            this.view.cargarDatos(carrera);
    }
}
