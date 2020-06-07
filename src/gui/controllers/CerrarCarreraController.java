package gui.controllers;

import gui.controllers.intefaces.ICerrarCarrera;
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
        Carrera carrera = this.hipodromo.getCarreraAbierta();
        this.carrera = carrera;
        this.view.cargarDatos(carrera);
    }
    
    public void cerrarCarrera(){
        this.carrera.cerrarCarrera();
    }
    
}
