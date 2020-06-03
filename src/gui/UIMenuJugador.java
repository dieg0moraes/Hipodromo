package gui;

import modelo.Hipodromo;

public class UIMenuJugador extends javax.swing.JFrame {
    private Hipodromo hipodromo; 

    
    public UIMenuJugador() {
        initComponents();
    }
    
    public void setHipodromo(Hipodromo hipodromo){
        this.hipodromo = hipodromo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnElegirHipodromo = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnElegirHipodromo.setText("Seleccionar Hipodromo");
        btnElegirHipodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirHipodromoActionPerformed(evt);
            }
        });

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
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(btnElegirHipodromo)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(btnApostar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnElegirHipodromo)
                .addGap(18, 18, 18)
                .addComponent(btnApostar)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirHipodromoActionPerformed
        UISelectHipodromo select = new UISelectHipodromo(this);
        select.setVisible(true);
    }//GEN-LAST:event_btnElegirHipodromoActionPerformed

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        if(hipodromo != null){
            UINuevaApuesta apuesta = new UINuevaApuesta(this.hipodromo);
            apuesta.setVisible(true);    
        }
        
    }//GEN-LAST:event_btnApostarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnElegirHipodromo;
    // End of variables declaration//GEN-END:variables
}
