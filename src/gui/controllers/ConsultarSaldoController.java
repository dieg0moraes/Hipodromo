package gui.controllers;

import exceptions.CarreraException;
import gui.controllers.intefaces.IConsultarSaldo;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Participacion;

public class ConsultarSaldoController {
    private IConsultarSaldo view;
    private Carrera carrera = null;
    private Fachada fachada = Fachada.getInstancia();
    
    public ConsultarSaldoController(IConsultarSaldo view, Hipodromo hipodromo){
        this.view = view;
        try {
            this.carrera = hipodromo.getCarreraAbierta();
        } catch (CarreraException ex) {
            this.view.showError(ex.getMessage());
        }
    }
    
    public void cargarDatos(){
        view.cargarCarrera(this.carrera);
        this.cargarCaballos();
    }
    
    public void cargarCaballos(){
        ArrayList<String> model = new ArrayList<String>();
        for(Participacion participacion : carrera.getParticipaciones()){
            boolean esGanador = carrera.isGanador(participacion.getCaballo());
            String string = formatearStringListaCaballos(participacion, esGanador);
            model.add(string);
        }
        this.view.cargarCaballos(model);
    }
    
     private String formatearStringListaCaballos(Participacion participacion, boolean ganador){
        String string = participacion.getNombreCaballo() + " " + participacion.getNumero() + " " + participacion.getDividendo();
        if(ganador)
            string.concat("** GANADOR **");
        return string;
    }
     
    public void consultarUltimaApuesta(String username, String password){
        Apuesta apuesta = fachada.getUltimaApuesta(username, password, this.carrera);
        view.mostrarApuesta(apuesta);
        
    }
    
}