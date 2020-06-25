package gui.controllers;

import exceptions.LoginException;
import gui.controllers.intefaces.ILogin;
import modelo.Fachada;
import modelo.UsuarioAdmin;
import modelo.UsuarioJugador;


public class LoginController {
        
    private ILogin view;
    private Fachada fachada;
    public LoginController(ILogin view){
        this.view = view;
        this.fachada = Fachada.getInstancia();
    }
    
    public void loginAdmin(UsuarioAdmin user){
        try {
            fachada.loginAdmin(user);
            this.view.successLogin();
        } catch (LoginException ex) {
            this.view.errorLogin(ex.getMessage());
        }
    }
    
    public void loginJugador(UsuarioJugador user){
        try {
            fachada.loginJugador(user);
            this.view.successLogin();
        } catch (LoginException ex) {
            this.view.errorLogin(ex.getMessage());
        }
    }
    
}
