package gui.controllers.intefaces;

import java.util.ArrayList;
import modelo.Carrera;

public interface ICerrarApuestas {
    public void cargarDatos(ArrayList<String> detalles, Carrera carrera, float montoTotal);
    public void error(String mensaje);
    public void success(String mensaje);
}
