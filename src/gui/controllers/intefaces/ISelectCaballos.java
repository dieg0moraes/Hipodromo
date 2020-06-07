package gui.controllers.intefaces;

import java.util.ArrayList;
import modelo.Caballo;
import modelo.Carrera;

public interface ISelectCaballos {
    public void actualizarListas(ArrayList<Caballo> disponibles, ArrayList<Caballo> seleccionados);
    public void cargarDatos(Carrera carrera);
    public void error(String mensaje);
    public void success(String mensaje);
}