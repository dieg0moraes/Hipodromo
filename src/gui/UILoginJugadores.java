
package gui;

import modelo.UsuarioJugador;



public class UILoginJugadores extends UILogin{
   
    public void login(){
        String password = new String(getTxtPassword().getPassword());
        String username = getTxtUser().getText(); 
        UsuarioJugador user = new UsuarioJugador(username, password);
        controller.loginJugador(user);
        
    }

    @Override
    public void successLogin() {
        UIMenuJugador view = new UIMenuJugador();
        view.setVisible(true);
    }


    @Override
    public void errorLogin(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}    