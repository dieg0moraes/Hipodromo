package gui;

import javax.swing.JOptionPane;
import modelo.Fachada;
import modelo.Usuario;

public class UILoginAdmin extends UILogin{
    private Fachada fachada = Fachada.getInstancia();
    
    @Override
    public void login(){
        String password = new String(getTxtPassword().getPassword());
        String username = getTxtUser().getText();
        
        Usuario user = this.fachada.loginAdmin(password, username);
        
        if(user!=null){
            
        }
        else{
            JOptionPane.showMessageDialog(this,"Login Incorrecto");
        }
    }

}
