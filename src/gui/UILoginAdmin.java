package gui;

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
        
        Usuario user = this.fachada.loginAdmin(password, username);
        if(user != null){
            this.menu.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Login Incorrecto");
        }
    }

}
