
package gui;

import javax.swing.JOptionPane;
import modelo.Fachada;
import modelo.Usuario;

public class UILoginJugadores extends UILogin{
    private Fachada fachada = Fachada.getInstancia();
    
    public void login(){
        /*
        String password = new String(getTxtPassword().getPassword());
        String username = getTxtUser().getText();
        
        Usuario user = this.fachada.loginJugador(password, username);
        
        if(user!=null){
            
        }
        else{
            JOptionPane.showMessageDialog(this,"Login Incorrecto");
        }*/
    }    
}
