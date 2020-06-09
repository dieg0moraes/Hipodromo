package gui;

import javax.swing.JOptionPane;
import modelo.UsuarioAdmin;

public class UILoginAdmin extends UILogin{
        
    @Override
    public void login(){
        String password = new String(getTxtPassword().getPassword());
        String username = getTxtUser().getText();
        
        UsuarioAdmin user = new UsuarioAdmin(username, password);
        controller.loginAdmin(user);
    }

    @Override
    public void successLogin() {
        UIMenuAdmin view = new UIMenuAdmin();
        view.setVisible(true);
    }

    @Override
    public void errorLogin(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Login Error", JOptionPane.ERROR_MESSAGE);
    }


   
}
