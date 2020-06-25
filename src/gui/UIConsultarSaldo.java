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
    
    public UIConsultarSaldo(Hipodromo hipodromo) {
        initComponents();
        this.controller = new ConsultarSaldoController(this, hipodromo);
        this.controller.cargarDatos();
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
        jLabel11 = new javax.swing.JLabel();
        txtMontoGanado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMontoApostado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHipodromo = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreCarrera = new javax.swing.JLabel();
        txtNumeroCarrera = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreCaballo = new javax.swing.JLabel();
        txtNumeroCaballo = new javax.swing.JLabel();
        txtDividendoCaballo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JLabel();

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

        jLabel11.setText("Ganado");

        txtMontoGanado.setText("won");

        jLabel10.setText("Apostado");

        txtMontoApostado.setText("monto");

        jLabel6.setText("Saldo");

        jLabel7.setText("Hipodromo");

        txtHipodromo.setText("hipo");

        txtFecha.setText("fehca");

        jLabel8.setText("Carrera ");

        txtNombreCarrera.setText("nombre");

        txtNumeroCarrera.setText("numero");

        jLabel9.setText("Caballo");

        txtNombreCaballo.setText("name");

        txtNumeroCaballo.setText("number");

        txtDividendoCaballo.setText("dividendo");

        txtSaldo.setText("Saldo");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSaldo))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNombreCaballo)
                                            .addGap(29, 29, 29)
                                            .addComponent(txtNumeroCaballo))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombreCarrera)
                                            .addGap(41, 41, 41)
                                            .addComponent(txtNumeroCarrera)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHipodromo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(txtDividendoCaballo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFecha)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword)
                            .addComponent(btnConsultar)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(24, 24, 24)
                        .addComponent(txtMontoGanado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMontoApostado)))
                .addGap(49, 49, 49))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConsultar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 198, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtSaldo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtHipodromo)
                                    .addComponent(txtFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtNumeroCarrera)
                                    .addComponent(txtNombreCarrera))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtNombreCaballo)
                                    .addComponent(txtNumeroCaballo)
                                    .addComponent(txtDividendoCaballo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtMontoApostado)
                                        .addComponent(txtMontoGanado))
                                    .addComponent(jLabel11))
                                .addGap(27, 27, 27))))))
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
        this.txtDividendoCaballo.setText(apuesta.getDividendo() +"");
        this.txtNumeroCaballo.setText(apuesta.getNumeroCaballo()+"");
        this.txtNombreCaballo.setText(apuesta.getNombreCaballo());
        
        this.txtNumeroCarrera.setText(apuesta.getNumeroCarrera()+"");
        this.txtNombreCarrera.setText(apuesta.getNombreCarrera());
         
        this.txtFecha.setText(apuesta.getFechaCarrera().toString());
        
    }
    
    @Override
    public void mostrarHipodromo(Hipodromo hipodromo){
        this.txtHipodromo.setText(hipodromo.getNombre());
    }
    
    @Override 
    public void mostrarSaldo(float saldo, float montoGanado, float montoApostado){
        this.txtSaldo.setText(saldo +"");
        this.txtMontoApostado.setText(montoApostado + "");
        this.txtMontoGanado.setText(montoGanado + "");
    }
}
