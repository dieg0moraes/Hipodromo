package gui.controllers;

import exceptions.FinalizarCarreraException;
import gui.controllers.intefaces.IFinalizarCarrera;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participacion;

public class FinalizarCarreraController{
    private Carrera carrera;
    private IFinalizarCarrera view;
    
    public FinalizarCarreraController(IFinalizarCarrera view, Hipodromo hipodromo){
        Carrera carrera;
        try {
            carrera = hipodromo.getLastCarreraCorrida();
            this.carrera = carrera;
            this.view = view;
            this.view.cargarDatos(carrera);
        } catch (FinalizarCarreraException ex) {
            this.view.mostrarError(ex.getMessage());
        }
        
    }
    
    public void cargarDatos(){
        view.cargarDatos(this.carrera);
    }
    
    public void detallesParticipacion(Participacion participacion){
        int numero = participacion.getNumero();
        float dividendo = participacion.getDividendo();
        String nombre = participacion.getNombreCaballo();
        float montoTotal = carrera.getMontoTotalApostado(participacion.getCaballo());
        view.cargarDetallesParticipacion(numero, dividendo, montoTotal, nombre);
    }
    
    public void finzalizarCarrera(Participacion participacion){
        this.carrera.finalizarCarrera(participacion);
    }
    
}
