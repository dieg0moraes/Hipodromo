package gui.controllers.intefaces;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Carrera;


public interface IConsultarSaldo {
    public void showError(String mensaje);
    public void cargarCarrera(Carrera carrera);
    public void cargarCaballos(ArrayList<String> caballos);
    public void mostrarApuesta(Apuesta apuesta);
    
    
}
