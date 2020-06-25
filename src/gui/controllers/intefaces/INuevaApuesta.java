package gui.controllers.intefaces;

import modelo.Carrera;

public interface INuevaApuesta {
    public void loadCarrera(Carrera carrera);
    public void showError(String mensaje);
    public void success(String mensaje);

    public void showSuccess(String mensaje);
    
}
