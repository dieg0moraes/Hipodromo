package gui;


import modelo.Hipodromo;

public class UICarreraMenu extends javax.swing.JFrame {
    private Hipodromo hipodromo;

    public UICarreraMenu(Hipodromo hipodromo) {
        initComponents();
        this.hipodromo = hipodromo;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnCerrarApuestas = new javax.swing.JButton();
        btnFinalizarApuestas = new javax.swing.JButton();
        btnMonitorear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnCerrarApuestas.setText("Cerrar apuestas");
        btnCerrarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarApuestasActionPerformed(evt);
            }
        });

        btnFinalizarApuestas.setText("Finalizar carrera");

        btnMonitorear.setText("Monitorear");
        btnMonitorear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMonitorear)
                    .addComponent(btnFinalizarApuestas)
                    .addComponent(btnCerrarApuestas)
                    .addComponent(btnAbrir)
                    .addComponent(btnCrear))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarApuestas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizarApuestas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMonitorear)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        UINewCarrera carrera = new UINewCarrera(this.hipodromo);
        carrera.setVisible(true);
       
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        UIAbrirCarrera view = new UIAbrirCarrera(this.hipodromo);
        view.setVisible(true);
        
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCerrarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarApuestasActionPerformed
        UICerrarApuestas view = new UICerrarApuestas(this.hipodromo);
        view.setVisible(true);
    }//GEN-LAST:event_btnCerrarApuestasActionPerformed

    private void btnMonitorearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorearActionPerformed
        UIMonitor view = new UIMonitor(this.hipodromo);
        view.setVisible(true);
    }//GEN-LAST:event_btnMonitorearActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.dispose();
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCerrarApuestas;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnFinalizarApuestas;
    private javax.swing.JButton btnMonitorear;
    // End of variables declaration//GEN-END:variables
}
