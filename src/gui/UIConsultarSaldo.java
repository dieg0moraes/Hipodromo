package gui;

import gui.controllers.ConsultarSaldoController;
import gui.controllers.intefaces.IConsultarSaldo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Hipodromo;
import obligatorio2020.Utils;

public class UIConsultarSaldo extends javax.swing.JFrame implements IConsultarSaldo{
    private ConsultarSaldoController controller;
    private Carrera modelo;
    
    public UIConsultarSaldo(Hipodromo hipodromo) {
        initComponents();
        this.controller = new ConsultarSaldoController(this, hipodromo);
        this.controller.cargarDatos();
        this.frameDetalles.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCaballos = new javax.swing.JList<>();
        txtNumero = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        frameDetalles = new javax.swing.JInternalFrame();
        jLabel6 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHipodromo = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNumeroCarrera = new javax.swing.JLabel();
        txtNombreCarrera = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreCaballo = new javax.swing.JLabel();
        txtNumeroCaballo = new javax.swing.JLabel();
        txtDividendoCaballo = new javax.swing.JLabel();
        txtMontoApostado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMontoGanado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero");

        jLabel2.setText("Nombre");

        jLabel3.setText("Estado");

        jScrollPane1.setViewportView(lstCaballos);

        txtNumero.setText("numero");

        txtNombre.setText("nombre");

        txtEstado.setText("estado");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        frameDetalles.setVisible(true);

        jLabel6.setText("Saldo");

        jLabel7.setText("Hipodromo");

        txtHipodromo.setText("hipo");

        txtFecha.setText("fehca");

        jLabel8.setText("Carrera ");

        txtNumeroCarrera.setText("jLabel9");

        txtNombreCarrera.setText("jLabel9");

        jLabel9.setText("Caballo");

        txtNombreCaballo.setText("jLabel10");

        txtNumeroCaballo.setText("jLabel10");

        txtDividendoCaballo.setText("jLabel10");

        txtMontoApostado.setText("jLabel10");

        jLabel10.setText("Apostado");

        jLabel11.setText("Ganado");

        txtMontoGanado.setText("jLabel12");

        javax.swing.GroupLayout frameDetallesLayout = new javax.swing.GroupLayout(frameDetalles.getContentPane());
        frameDetalles.getContentPane().setLayout(frameDetallesLayout);
        frameDetallesLayout.setHorizontalGroup(
            frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameDetallesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameDetallesLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHipodromo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha))
                    .addGroup(frameDetallesLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frameDetallesLayout.createSequentialGroup()
                        .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(frameDetallesLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoApostado))
                            .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(frameDetallesLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombreCaballo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumeroCaballo))
                                .addGroup(frameDetallesLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombreCarrera)
                                    .addGap(41, 41, 41)
                                    .addComponent(txtNumeroCarrera))))
                        .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameDetallesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDividendoCaballo))
                            .addGroup(frameDetallesLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoGanado)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        frameDetallesLayout.setVerticalGroup(
            frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHipodromo)
                    .addComponent(txtFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumeroCarrera)
                    .addComponent(txtNombreCarrera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombreCaballo)
                    .addComponent(txtNumeroCaballo)
                    .addComponent(txtDividendoCaballo))
                .addGap(18, 18, 18)
                .addGroup(frameDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoApostado)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtMontoGanado))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword)
                            .addComponent(btnConsultar)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frameDetalles)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultar)
                        .addGap(18, 18, 18)
                        .addComponent(frameDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
       
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        this.controller.consultarUltimaApuesta(username, password);
    }//GEN-LAST:event_btnConsultarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JInternalFrame frameDetalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstCaballos;
    private javax.swing.JLabel txtDividendoCaballo;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtHipodromo;
    private javax.swing.JLabel txtMontoApostado;
    private javax.swing.JLabel txtMontoGanado;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombreCaballo;
    private javax.swing.JLabel txtNombreCarrera;
    private javax.swing.JLabel txtNumero;
    private javax.swing.JLabel txtNumeroCaballo;
    private javax.swing.JLabel txtNumeroCarrera;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void cargarCarrera(Carrera carrera) {
        this.txtEstado.setText(carrera.getStatus().toString());
        this.txtNombre.setText(carrera.getNombre());
        this.txtNumero.setText(carrera.getNumero() +"");   
    }

    @Override
    public void cargarCaballos(ArrayList<String> caballos) {
        Utils.fillJList(lstCaballos, caballos);
    }
    
    @Override 
    public void mostrarApuesta(Apuesta apuesta){
        this.txtNombreCarrera.setText(modelo.getNombre());
    }
}
