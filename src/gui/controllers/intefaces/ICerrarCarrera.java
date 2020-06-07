package gui.controllers.intefaces;

import modelo.Carrera;

public interface ICerrarCarrera {
    public void cargarDatos(Carrera carrera);
    public void error(String mensaje);
    public void success(String mensaje);
    
}
