package gui.controllers;

import gui.controllers.intefaces.IModificarTipoApuesta;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.TipoApuesta;
import modelo.Participacion;

public class ModificarTipoApuestaController{
    
    private IModificarTipoApuesta view;
    private Fachada fachada = Fachada.getInstancia();
    
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
        ArrayList<Participacion> participaciones = fachada.getParticipacionesModificables(carrera);
        view.cargarParticipaciones(participaciones);
        this.setCarrera(carrera);
    }
    
    public void setCarrera(Carrera carrera){
        this.carrera.quitar(this);
        this.carrera = carrera;     
    }
    
    public void setTipoApuesta(TipoApuesta tipo, Participacion participacion){
        participacion.setTipoParticipacion(tipo);
        
    }    
}
