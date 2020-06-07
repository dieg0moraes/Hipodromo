package gui.controllers.intefaces;

import modelo.Carrera;

public interface IAbrirCarrera {
    public void cargarDatos(Carrera carrera);
    public void error(String mensaje);
    public void success(String mensaje);
}

