package gui.controllers.intefaces;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Hipodromo;


public interface IConsultarSaldo {
    public void showError(String mensaje);
    public void cargarCarrera(Carrera carrera);
    public void cargarCaballos(ArrayList<String> caballos);
    public void mostrarApuesta(Apuesta apuesta);
    public void mostrarHipodromo(Hipodromo hipodromo);
    public void mostrarSaldo(float saldo, float montoGanado, float montoApostado);
    
    
}
