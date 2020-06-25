package gui.controllers;

import gui.controllers.intefaces.IMonitor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.Participacion;
import modelo.SistemaApuestas;
import observer.Observable;
import observer.Observador;


public class MonitorController implements Observador{
    private Hipodromo hipodromo;
    private IMonitor view;
    private Carrera carrera;
    private Fachada fachada = Fachada.getInstancia();
    
    public MonitorController(IMonitor view, Hipodromo hipodromo) {
        this.view = view;
        this.hipodromo = hipodromo;
        this.hipodromo.agregar(this);
        ArrayList<Carrera> list = this.hipodromo.getCarreras();
        cargarDatos(list);
        
    }
    
    public void cargarDatos(ArrayList<Carrera> list){
        for(Carrera c : list){
            c.agregar(this);
        }
        view.cargarCarreras(list);
    }
    
    public void filtrarPorFechas(String dateStr){
        Date date = null; 
        if(dateStr != null && !dateStr.isEmpty()){
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                ArrayList<Carrera> carreras = this.hipodromo.getCarreras(date);
                this.cargarDatos(carreras);
            } catch (ParseException ex) {
                this.view.showError("dd/MM/yyy - Formatee la fecha correctamente");
            }
        }else date = new Date();       
        
    }
    
   public void seleccionarCarrera(Carrera carrera){
        this.carrera = carrera;
        ArrayList<String> model = new ArrayList<String>();
        for(Participacion participacion : carrera.getParticipaciones()){
            boolean esGanador = carrera.isGanador(participacion.getCaballo());
            String string = formatearStringListaCaballos(participacion, esGanador);
            model.add(string);
        }
        float totalApostado = fachada.getMontoTotalApostado(carrera);
        float totalPagado = fachada.getMontoTotalPagado(carrera);
        view.cargarCarrera(carrera, totalApostado, totalPagado);
        view.cargarCaballos(model);
        if(carrera.isFinalizada())
            view.cargarGanadores(fachada.getGanadores(carrera));
        
        
    }
    
    private String formatearStringListaCaballos(Participacion participacion, boolean ganador){
        String string = participacion.getNombreCaballo() + " " + participacion.getNumero() + " " + participacion.getDividendo();
        if(ganador)
            string += "** GANADOR **";
        return string;
    }

    public void cargarParticipacion(Participacion participacion){
        boolean caballoEsGanador = false;
        if(this.carrera.isFinalizada());
            caballoEsGanador = this.carrera.isGanador(participacion.getCaballo());
        
        
    }
    @Override
    public void actualizar(Object event, Observable origen) {
        if(event.equals(Carrera.Events.GANADOR_ASIGNADO) || event.equals(SistemaApuestas.Events.NUEVA_APUESTA) || event.equals(Carrera.Events.NUEVA_PARTICIPACION) ||
                event.equals(Carrera.Events.PARTICIPACION_ELIMINADA) || event.equals(Carrera.Events.STATUS_CARRERA)){
            this.seleccionarCarrera((Carrera)origen);
        }
        if(event.equals(Jornada.Eventos.NUEVA_CARRERA_ACTUAL) || event.equals(Jornada.Eventos.NUEVA_CARRERA_AGREGADA)){
            this.view.cargarCarreras(this.hipodromo.getCarreras());
        }
        
    }    
}
