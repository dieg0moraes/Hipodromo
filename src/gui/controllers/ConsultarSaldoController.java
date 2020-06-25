package gui.controllers;

import exceptions.CarreraException;
import exceptions.LoginException;
import gui.controllers.intefaces.IConsultarSaldo;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Participacion;
import modelo.UsuarioJugador;
import observer.Observable;
import observer.Observador;

public class ConsultarSaldoController implements Observador{
    private IConsultarSaldo view;
    private Carrera carrera;
    private Fachada fachada = Fachada.getInstancia();
    
    public ConsultarSaldoController(IConsultarSaldo view, Hipodromo hipodromo){
        this.view = view;
        try {
            this.carrera = hipodromo.getCarreraAbierta();
            this.carrera.agregar(this);
        } catch (CarreraException ex) {
            this.view.showError(ex.getMessage());
        }
    }
    
    public void cargarDatos(){
        if(this.carrera != null){
            view.cargarCarrera(this.carrera);
            this.cargarCaballos();
        }
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
        try {
            Apuesta apuesta = fachada.getUltimaApuesta(username, password);
            
            UsuarioJugador  user = fachada.loginJugador(new UsuarioJugador(username, password));
            if(apuesta == null){
                view.showError("No hay apuestas para mostrar");
            }
            else{
                Hipodromo h = fachada.getHipodromoDeCarrera(apuesta.getCarrera());
                view.mostrarHipodromo(h);
                view.mostrarApuesta(apuesta);
                view.mostrarSaldo(user.getSaldo(), apuesta.getMontoGanado(), apuesta.getMonto());
            }
        } catch (LoginException ex) {
            this.view.showError(ex.getMessage());
        }
        
       
        
    }

    @Override
    public void actualizar(Object event, Observable origen) {
        
    }
    
}
