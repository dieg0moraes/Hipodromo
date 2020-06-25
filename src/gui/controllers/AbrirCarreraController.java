 package gui.controllers;

import exceptions.AbrirCarreraException;
import gui.controllers.intefaces.IAbrirCarrera;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;

public class AbrirCarreraController {
    private IAbrirCarrera view;
    private Carrera carrera;
    private Fachada fachada = Fachada.getInstancia();
    
    public AbrirCarreraController(IAbrirCarrera view, Hipodromo hipodromo){
        this.view = view;
        Carrera carrera = null;
        try {
            carrera = this.fachada.getNextCarrera(hipodromo);
            this.carrera = carrera;  
            this.cargarDatos();

        } catch (AbrirCarreraException ex) {
            this.view.error(ex.getMessage());
        }
    }
    
    public void cargarDatos(){
        this.view.cargarDatos(carrera);
    }
    
    public void abrirCarrera()
    {
        try {
            this.carrera.abrirCarrera();
            this.view.success("Carrera abierta");
        } catch (AbrirCarreraException ex) {
            view.error(ex.getMessage());
        }
    }    
}
