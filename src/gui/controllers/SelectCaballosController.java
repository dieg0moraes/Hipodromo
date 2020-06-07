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

public class SelectCaballosController {
    private ISelectCaballos view;
    private Carrera carrera;
    private Hipodromo hipodromo;
    private Fachada fachada = Fachada.getInstancia();
    
    public SelectCaballosController(ISelectCaballos view, Carrera carrera, Hipodromo hipodromo){
        this.view = view;
        this.carrera = carrera;
        this.hipodromo = hipodromo;
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
    
    public void confirmarCarrera(){
        try{
            this.fachada.agregarCarrera(carrera, hipodromo);
            this.view.success("Carrera agregada");
        } catch (NewCarreraException | NewParticipacionException ex) {
            this.view.error(ex.getMessage());
        }
    }    
   
    
    
}
