package gui.controllers;

import java.util.ArrayList;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import gui.controllers.intefaces.ISelectCaballos;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Participacion;
import observer.Observable;
import observer.Observador;

public class SelectCaballosController implements Observador {
    private ISelectCaballos view;
    private Carrera carrera;
    private Hipodromo hipodromo;
    private Fachada fachada = Fachada.getInstancia();
    
    public SelectCaballosController(ISelectCaballos view, Carrera carrera, Hipodromo hipodromo){
        this.view = view;
        this.carrera = carrera;
        this.carrera.agregar(this);
        this.hipodromo = hipodromo;
        this.hipodromo.agregar(this);
        this.cargarDatos();
    }
    
    public void cargarDatos(){
        this.view.cargarDatos(this.carrera);
        ArrayList<Caballo> caballos = fachada.getCaballosDisponibles(carrera);
        this.view.actualizarListas(caballos, carrera.getCaballos());
    }
    
    public void agregarCaballo(Caballo caballo, int numero, float dividendo){
        try {
            Participacion participacion = new Participacion(caballo, numero, dividendo);
            carrera.agregarParticipacion(participacion); 
            this.cargarDatos();
        } catch (NewParticipacionException ex) {
            this.view.error(ex.getMessage());
        } 
    }
    
    public void eliminarCaballoParticipante(Caballo caballo){
        this.carrera.eliminarCaballoParticipante(caballo);
    }
    
    public void confirmarCarrera(){
        try{
            this.fachada.agregarCarrera(carrera, hipodromo);
            this.view.success("Carrera agregada");
        } catch (NewCarreraException | NewParticipacionException ex) {
            this.view.error(ex.getMessage());
        }
    }    

    @Override
    public void actualizar(Object event, Observable origen) {
        if(event.equals(Carrera.Events.NUEVA_PARTICIPACION) | event.equals(Carrera.Events.PARTICIPACION_ELIMINADA)){
            this.cargarDatos();
        }else if(event.equals(Hipodromo.Events.CARRERA_AGREGADA)){
            this.cargarDatos();
        }
    }
   
    
    
}
