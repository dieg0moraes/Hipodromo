package gui.controllers.intefaces;

import java.util.ArrayList;
import modelo.Carrera;
import modelo.UsuarioJugador;

public interface IMonitor {
    public void cargarCarreras(ArrayList<Carrera> carreras);
    public Carrera getSelectedCarrera();
    public void cargarCaballos(ArrayList<String> participaciones);
    public void cargarGanadores(ArrayList<UsuarioJugador> jugadores);
    public void cargarCarrera(Carrera carrera, float totalApostado, float totalPagado);
}