package gui.controllers;

import exceptions.FinalizarCarreraException;
import gui.controllers.intefaces.IFinalizarCarrera;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Participacion;

public class FinalizarCarreraController{
    private Carrera carrera;
    private IFinalizarCarrera view;
    private Fachada fachada = Fachada.getInstancia();
    
    public FinalizarCarreraController(IFinalizarCarrera view, Hipodromo hipodromo){
        Carrera carrera;
        this.view = view;
        try {
            carrera = hipodromo.getLastCarreraCorrida();
            this.carrera = carrera;
            float monto = fachada.getMontoTotalApostado(carrera);
            this.view.cargarDatos(this.carrera, monto);
        } catch (FinalizarCarreraException ex) {
            this.view.mostrarError(ex.getMessage());
        }
        
    }
    
    public void cargarDatos(){
        float monto = fachada.getMontoTotalApostado(carrera);
        view.cargarDatos(this.carrera, monto);
    }
    
    public void detallesParticipacion(Participacion participacion){
        int numero = participacion.getNumero();
        float dividendo = participacion.getDividendo();
        String nombre = participacion.getNombreCaballo();
        float montoTotal = fachada.getMontoTotalApostado(this.carrera, participacion.getCaballo());
        view.cargarDetallesParticipacion(numero, dividendo, montoTotal, nombre);
    }
    
    public void finzalizarCarrera(Participacion participacion){
        this.fachada.finalizarCarrera(this.carrera,participacion);
    }
    
}
