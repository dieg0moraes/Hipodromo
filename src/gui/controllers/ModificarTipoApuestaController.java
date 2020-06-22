package gui.controllers;

import gui.controllers.intefaces.IModificarTipoApuesta;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.TipoApuesta;
import modelo.Participacion;
import observer.Observable;
import observer.Observador;

public class ModificarTipoApuestaController implements Observador{
    private IModificarTipoApuesta view;
    private Carrera carrera;
    public ModificarTipoApuestaController(IModificarTipoApuesta view, Hipodromo hipodromo){
        this.view = view;
        this.cargarDatos(hipodromo);
    }
    
    public void cargarDatos(Hipodromo hipodromo){
        ArrayList<Carrera> carreras = hipodromo.getTodayCarrerasParticipacionesModificables();
        view.cargarCarreras(carreras);
        
    
    }
    
    public void cambiarCarreraSeleccionada(Carrera carrera){
        ArrayList<Participacion> participaciones = carrera.getParticipacionesModificables();
        view.cargarParticipaciones(participaciones);
        this.setCarrera(carrera);
    }
    
    public void setCarrera(Carrera carrera){
        this.carrera.quitar(this);
        this.carrera = carrera;
        this.carrera.agregar(this);        
    }
    
    public void setTipoApuesta(TipoApuesta tipo, Participacion participacion){
        participacion.setTipoParticipacion(tipo);
        
    }

    @Override
    public void actualizar(Object event, Observable origen) {
        
    }
    
}
