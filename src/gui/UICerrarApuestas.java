
package gui;

import gui.controllers.CerrarApuestasController;
import gui.controllers.intefaces.ICerrarApuestas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Carrera;
import modelo.Hipodromo;
import obligatorio2020.Utils;

public class UICerrarApuestas extends javax.swing.JFrame implements ICerrarApuestas{
    private Carrera carrera;
    private CerrarApuestasController controller;
    
    public UICerrarApuestas(Hipodromo hipodromo) {
        initComponents();
        this.controller = new CerrarApuestasController(this, hipodromo);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumeroCarrera = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCaballos = new javax.swing.JList();
        btnCerrarApuestas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero de carrera");

        txtNumeroCarrera.setText("numero");

        jLabel2.setText("Nombre:");

        txtNombre.setText("nombre");

        jLabel3.setText("Monto total apostado: ");

        txtMontoTotal.setText("monto");

        jScrollPane1.setViewportView(lstCaballos);

        btnCerrarApuestas.setText("Cerrar apuestas");
        btnCerrarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarApuestasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroCarrera))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnCerrarApuestas)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroCarrera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMontoTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnCerrarApuestas)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarApuestasActionPerformed
        controller.cerrarApuestas();
    }//GEN-LAST:event_btnCerrarApuestasActionPerformed

    @Override
    public void cargarDatos(ArrayList<String> detalles, Carrera carrera, float totalApostado) {
        Utils.fillJList(lstCaballos, detalles);
        this.carrera = carrera;
        this.txtMontoTotal.setText(totalApostado+ "");
        this.txtNombre.setText(carrera.getNombre());
        this.txtNumeroCarrera.setText(carrera.getNumero() +"");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarApuestas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstCaballos;
    private javax.swing.JLabel txtMontoTotal;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNumeroCarrera;
    // End of variables declaration//GEN-END:variables

    @Override
    public void error(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
