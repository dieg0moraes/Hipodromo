package gui.controllers;

import gui.controllers.intefaces.IMonitor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participacion;
import observer.Observable;
import observer.Observador;


public class MonitorController implements Observador{
    private Hipodromo hipodromo;
    private IMonitor view;
    private Carrera carrera;
    
    public MonitorController(IMonitor view, Hipodromo hipodromo) {
        this.view = view;
        this.hipodromo = hipodromo;
        this.hipodromo.agregar(this);
    }
    
    public void cargarDatos(){
        view.cargarCarreras(this.hipodromo.getCarreras());

    }
    
    public void seleccionarCarrera(Carrera carrera){
        this.carrera = carrera;
        ArrayList<String> model = new ArrayList<String>();
        for(Participacion participacion : carrera.getParticipaciones()){
            boolean esGanador = carrera.isGanador(participacion.getCaballo());
            String string = formatearStringListaCaballos(participacion, esGanador);
            model.add(string);
        }
        view.cargarCarrera(carrera);
        view.cargarCaballos(model);
        if(carrera.isFinalizada())
            view.cargarGanadores(carrera.getGanadores());
        
        
    }
    
    private String formatearStringListaCaballos(Participacion participacion, boolean ganador){
        String string = participacion.getNombreCaballo() + " " + participacion.getNumero() + " " + participacion.getDividendo();
        if(ganador)
            string.concat("** GANADOR **");
        return string;
    }

    public void cargarParticipacion(Participacion participacion){
        boolean caballoEsGanador = false;
        if(this.carrera.isFinalizada());
            caballoEsGanador = this.carrera.isGanador(participacion.getCaballo());
        
        
    }
    @Override
    public void actualizar(Object event, Observable origen) {
        
    }
    
}
