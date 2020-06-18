package gui.controllers;

import exceptions.CarreraException;
import gui.controllers.intefaces.ICerrarApuestas;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participacion;
import observer.Observable;
import observer.Observador;

public class CerrarApuestasController implements Observador{
    private ICerrarApuestas view;
    private Carrera carrera;
    private Hipodromo hipodromo;
    
    
    public CerrarApuestasController(ICerrarApuestas view, Hipodromo hipodromo){
        this.view = view;
        Carrera carrera;
        try {
            carrera = hipodromo.getCarreraAbierta();
            this.carrera = carrera;
            this.hipodromo = hipodromo;
            this.carrera.agregar(this);
            this.cargarDatos();
        } catch (CarreraException ex) {
            this.view.error(ex.getMessage());
        }
        
    }
    
    public void cargarDatos(){
        ArrayList<String> detalles = new ArrayList<String>();
        for(Participacion p : carrera.getParticipaciones()){
            Caballo c = p.getCaballo();
            float totalApostado = carrera.getMontoTotalApostado(c);
            String detalle = generarStringDetalles(c, p.getDividendo(), p.getNumero(), totalApostado);
            detalles.add(detalle);
        }
        view.cargarDatos(detalles, carrera);    
    }

    public void cerrarApuestas(){
        carrera.cerrarApuestas();        
    }
    
    @Override
    public void actualizar(Object event, Observable origen) {
        if(event.equals(Carrera.Events.STATUS_CARRERA)){
            this.cargarDatos();
        }
    }
    
    public String generarStringDetalles(Caballo caballo, float dividendo, int numero, float montoTotal){
        return caballo.getNombre() + "- Dividendo: " + dividendo + "-> Numero:" + numero + " Monto total " + montoTotal;
    }
    
}
