package gui;

import javax.swing.JOptionPane;
import modelo.Hipodromo;

public class UIMenuAdmin extends javax.swing.JFrame {
    
    private Hipodromo hipodromo;

    public UIMenuAdmin() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }
    
    public void setHipodromo(Hipodromo hipodromo){
        this.hipodromo = hipodromo;
        this.setTitle(hipodromo.getNombre());
    }
    
    public Hipodromo getHipodromo(){
        return this.hipodromo;
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        dispose();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHipodromos = new javax.swing.JButton();
        btnCarreras = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHipodromos.setText("Hipodromos");
        btnHipodromos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHipodromosActionPerformed(evt);
            }
        });

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
                    .addComponent(btnHipodromos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnHipodromos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarreras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHipodromosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHipodromosActionPerformed
        UISelectHipodromo selectH = new UISelectHipodromo(this);
        selectH.setVisible(true);
    }//GEN-LAST:event_btnHipodromosActionPerformed

    private void btnCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrerasActionPerformed
        if(this.hipodromo != null){
            UICarreraMenu menu = new UICarreraMenu(this.hipodromo, this);
            menu.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un hipodromo primero");
        
        }
        
    }//GEN-LAST:event_btnCarrerasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarreras;
    private javax.swing.JButton btnHipodromos;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
