package gui;

import exceptions.LoginException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Fachada;
import modelo.Usuario;



public class UILoginAdmin extends UILogin{
    private Fachada fachada = Fachada.getInstancia();
    private UIMenuAdmin menu = new UIMenuAdmin();
    
    @Override
    public void login(){
        String password = new String(getTxtPassword().getPassword());
        String username = getTxtUser().getText();
        try {
            this.fachada.loginAdmin(password, username);
            this.menu.setVisible(true);
            this.dispose();
        } catch (LoginException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }

}
