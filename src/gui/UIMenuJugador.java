package gui;

import gui.controllers.MenuJugadorController;
import gui.controllers.intefaces.IMenu;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.Hipodromo;

public class UIMenuJugador extends javax.swing.JFrame implements IMenu{
    private MenuJugadorController controller;
       
    
    public UIMenuJugador() {
        initComponents();
        this.controller = new MenuJugadorController(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnApostar = new javax.swing.JButton();
        cbHipodromos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbHipodromos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApostar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(cbHipodromos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnApostar)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        Hipodromo h = (Hipodromo) cbHipodromos.getSelectedItem();
        UINuevaApuesta view = new UINuevaApuesta(h);
        view.setVisible(true);
        
    }//GEN-LAST:event_btnApostarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JComboBox cbHipodromos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarDatos(ArrayList<Hipodromo> hipodromos) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Hipodromo h : hipodromos){
            model.addElement(h);
        }
        this.cbHipodromos.setModel(model);
    }
}
