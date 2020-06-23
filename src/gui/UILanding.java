package gui;


public class UILanding extends javax.swing.JFrame {
    
    public UILanding() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdminLogin = new javax.swing.JButton();
        btnJugadoresLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdminLogin.setText("Login Admin");
        btnAdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });

        btnJugadoresLogin.setText("Apostar");
        btnJugadoresLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugadoresLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(btnAdminLogin)
                .addGap(49, 49, 49)
                .addComponent(btnJugadoresLogin)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJugadoresLogin)
                    .addComponent(btnAdminLogin))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoginActionPerformed
        UILoginAdmin view = new UILoginAdmin();
        view.setVisible(true);
    }//GEN-LAST:event_btnAdminLoginActionPerformed

    private void btnJugadoresLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugadoresLoginActionPerformed
        UIMenuJugador view = new UIMenuJugador();
        view.setVisible(true);
    }//GEN-LAST:event_btnJugadoresLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JButton btnJugadoresLogin;
    // End of variables declaration//GEN-END:variables
}
