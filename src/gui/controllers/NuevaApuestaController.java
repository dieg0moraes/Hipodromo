package gui.controllers;

import exceptions.CarreraException;
import exceptions.LoginException;
import exceptions.NewApuestaException;
import gui.controllers.intefaces.INuevaApuesta;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.SistemaApuestas;
import observer.Observable;
import observer.Observador;

public class NuevaApuestaController implements Observador{    
    private INuevaApuesta view;
    private Fachada fachada;
    private Carrera carrera;
    private Hipodromo hipodromo;
    
    public NuevaApuestaController(INuevaApuesta view, Hipodromo hipodromo){
        this.view = view;
        this.fachada = Fachada.getInstancia();
        try{
            this.hipodromo = hipodromo;
            hipodromo.getCurrentJornada().agregar(this);
            Carrera carrera = hipodromo.getCarreraAbierta();       
            Fachada.getInstancia().getSistemaApuestas().agregar(this);
            this.carrera = carrera;
            this.carrera.agregar(this);
            this.loadView(carrera);
        }catch(CarreraException ex){
            view.showError(ex.getMessage());
        }
    }
    
    private void loadView(Carrera carrera){
        if(this.carrera != null && !this.carrera.equals(carrera)){
            this.carrera.quitar(this);
            this.carrera = carrera;        
            this.carrera.agregar(this);
        }       
            
        this.view.loadCarrera(this.carrera);
    }
   
    public void apostar(Apuesta apuesta){
        try {
            if(!this.carrera.estaCerrada()){
                apuesta.setCarrera(this.carrera);
                this.fachada.realizarApuesta(apuesta);
                this.view.showSuccess("Apuesta realizada");
            }
                
        } catch (NewApuestaException | LoginException ex) {
            this.view.showError(ex.getMessage());
        }        
    }

    @Override
    public void actualizar(Object event, Observable origen) {
        if(event.equals(Carrera.Events.GANADOR_ASIGNADO) || event.equals(SistemaApuestas.Events.NUEVA_APUESTA) || event.equals(Carrera.Events.NUEVA_PARTICIPACION) ||
                event.equals(Carrera.Events.PARTICIPACION_ELIMINADA) || event.equals(Carrera.Events.STATUS_CARRERA)){
            this.view.loadCarrera(this.carrera);
        }
        
        if(event.equals(Jornada.Eventos.NUEVA_CARRERA_ACTUAL)){
            try {
                Carrera carrera = this.hipodromo.getCarreraAbierta();
                this.view.loadCarrera(this.carrera);
            } catch (CarreraException ex) {
                view.showError(ex.getMessage());
            }
            
        }
    }

}
