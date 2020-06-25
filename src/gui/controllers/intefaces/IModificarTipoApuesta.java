package gui.controllers.intefaces;

import java.util.ArrayList;
import modelo.Carrera;
import modelo.Participacion;

public interface IModificarTipoApuesta {
    public void cargarCarreras(ArrayList<Carrera> carreras);
    public void cargarParticipaciones(ArrayList<Participacion> participaciones);

    public void success(String tipo_de_apuesta_cambiada);
    
}
