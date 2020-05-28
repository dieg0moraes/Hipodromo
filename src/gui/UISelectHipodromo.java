package gui;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.Fachada;
import modelo.Hipodromo;
import obligatorio2020.Utils;

public class UISelectHipodromo extends javax.swing.JFrame {
    private UIMenuAdmin menuAdmin;
    public UISelectHipodromo(UIMenuAdmin u) {
        initComponents();
        this.menuAdmin = u;
        Utils.fillJList(lstHipodromos, Fachada.getInstancia().getHipodromos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstHipodromos = new javax.swing.JList();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(lstHipodromos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 30, 330, 220);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(130, 260, 140, 31);

        setBounds(0, 0, 416, 349);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Hipodromo h = (Hipodromo)lstHipodromos.getSelectedValue();
        this.menuAdmin.setHipodromo(h);
    }//GEN-LAST:event_btnActualizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstHipodromos;
    // End of variables declaration//GEN-END:variables

  
}
