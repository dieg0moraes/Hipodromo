package obligatorio2020;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Utils {
    
    public static void fillJList(JList jList, ArrayList array){
        DefaultListModel listaMostrar = new DefaultListModel();
        for (Object u: array){
            listaMostrar.addElement(u);
        }   
        jList.setModel(listaMostrar);       
    }
    
}
