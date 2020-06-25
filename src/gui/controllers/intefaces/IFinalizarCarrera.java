package gui.controllers.intefaces;

import modelo.Carrera;

public interface IFinalizarCarrera {
    public void cargarDatos(Carrera carrera, float monto);  
    public void cargarDetallesParticipacion(int numero, float dividendo, float montoTotal, String nombreCaballo);
    public void mostrarError(String error);
}
