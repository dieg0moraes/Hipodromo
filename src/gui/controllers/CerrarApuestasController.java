package gui.controllers;

import exceptions.CarreraException;
import gui.controllers.intefaces.ICerrarApuestas;
import java.util.ArrayList;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Participacion;

public class CerrarApuestasController{
    private ICerrarApuestas view;
    private Carrera carrera;
    private Hipodromo hipodromo;
    private Fachada fachada = Fachada.getInstancia();
    
    
    public CerrarApuestasController(ICerrarApuestas view, Hipodromo hipodromo){
        this.view = view;
        Carrera carrera;
        try {
            carrera = hipodromo.getCarreraAbierta();
            this.carrera = carrera;
            this.hipodromo = hipodromo;
            this.cargarDatos();
        } catch (CarreraException ex) {
            this.view.error(ex.getMessage());
        }
        
    }
    
    public void cargarDatos(){
        ArrayList<String> detalles = new ArrayList<String>();
        for(Participacion p : carrera.getParticipaciones()){
            Caballo c = p.getCaballo();
            float totalApostado = fachada.getMontoTotalApostado(this.carrera, c);
            String detalle = generarStringDetalles(c, p.getDividendo(), p.getNumero(), totalApostado);
            detalles.add(detalle);
        }
        float monto = fachada.getMontoTotalApostado(carrera);
        view.cargarDatos(detalles, carrera, monto);    
    }

    public void cerrarApuestas(){
        carrera.cerrarApuestas();   
        this.view.success("Apuestas cerradas");
    }
    
    public String generarStringDetalles(Caballo caballo, float dividendo, int numero, float montoTotal){
        return caballo.getNombre() + "- Dividendo: " + dividendo + "-> Numero:" + numero + " Monto total " + montoTotal;
    }
    
}
