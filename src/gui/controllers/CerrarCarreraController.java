package gui.controllers;

import exceptions.CarreraException;
import gui.controllers.intefaces.ICerrarCarrera;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carrera;
import modelo.Hipodromo;

public class CerrarCarreraController {
    private ICerrarCarrera view;
    private Hipodromo hipodromo;
    private Carrera carrera;
    
    public CerrarCarreraController(ICerrarCarrera view, Hipodromo hipodromo){
        this.view = view;
    }

    public void cargarDatos()
    {
        Carrera carrera;
        try {
            carrera = this.hipodromo.getCarreraAbierta();
            this.carrera = carrera;
            this.view.cargarDatos(carrera);
        } catch (CarreraException ex) {
            this.view.error(ex.getMessage());
        }
        
    }
    
    public void cerrarCarrera(){
        this.carrera.cerrarCarrera();
    }
    
}
