package gui;

import gui.controllers.MenuAdminController;
import gui.controllers.intefaces.IMenu;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.Hipodromo;

public class UIMenuAdmin extends javax.swing.JFrame implements IMenu{

    private MenuAdminController controller;
    public UIMenuAdmin() {
        initComponents();
        this.controller = new MenuAdminController(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        dispose();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCarreras = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbHipodromos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCarreras.setText("Carreras");
        btnCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrerasActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(cbHipodromos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(cbHipodromos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCarreras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrerasActionPerformed
        Hipodromo h = (Hipodromo) cbHipodromos.getSelectedItem();        
        UICarreraMenu view = new UICarreraMenu(h);
        view.setVisible(true);       
    }//GEN-LAST:event_btnCarrerasActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarreras;
    private javax.swing.JComboBox cbHipodromos;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarDatos(ArrayList<Hipodromo> hipodromos) {
        DefaultComboBoxModel listaMostrar = new DefaultComboBoxModel();
        for (Hipodromo u: hipodromos){
            listaMostrar.addElement(u);
        }      
                
        this.cbHipodromos.setModel(listaMostrar);
    }
    
   
    
    

  

    
}

