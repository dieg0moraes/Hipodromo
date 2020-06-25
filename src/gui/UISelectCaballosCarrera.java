package gui;

import gui.controllers.SelectCaballosController;
import gui.controllers.intefaces.ISelectCaballos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Hipodromo;
import obligatorio2020.Utils;

public class UISelectCaballosCarrera extends javax.swing.JFrame implements ISelectCaballos{
    private SelectCaballosController controller;

    public UISelectCaballosCarrera(Carrera carrera, Hipodromo hipodromo) {
        super();
        initComponents();
        this.controller = new SelectCaballosController(this, carrera, hipodromo);
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

        txtNumero = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txtInfoFechaCarrera = new javax.swing.JLabel();
        txtDividendo = new javax.swing.JTextField();
        txtInfoNumeroCarrera = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipantes = new javax.swing.JList();
        btnAgregarACarrera = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDisponibles = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmarCarrera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Dividendo");

        txtInfoFechaCarrera.setText("Info fecha");

        txtDividendo.setText("1.0");
        txtDividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDividendoActionPerformed(evt);
            }
        });

        txtInfoNumeroCarrera.setText("Info numero");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstParticipantes);

        btnAgregarACarrera.setText("Agregar");
        btnAgregarACarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarACarreraActionPerformed(evt);
            }
        });

        jLabel1.setText("Caballos Participantes");

        jScrollPane2.setViewportView(lstDisponibles);

        jLabel2.setText("Caballos Disponibles");

        jLabel3.setText("Numero");

        btnConfirmarCarrera.setText("Confirmar");
        btnConfirmarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarACarrera)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirmarCarrera))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtInfoFechaCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtInfoNumeroCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtInfoFechaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInfoNumeroCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(btnAgregarACarrera))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnConfirmarCarrera))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDividendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDividendoActionPerformed
        
    }//GEN-LAST:event_txtDividendoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Caballo caballo = (Caballo)lstParticipantes.getSelectedValue();
        this.controller.eliminarCaballoParticipante(caballo);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarACarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarACarreraActionPerformed
        Caballo caballo = (Caballo)lstDisponibles.getSelectedValue();
        int numero = (int)txtNumero.getValue();
        float dividendo = Float.parseFloat(txtDividendo.getText());
        controller.agregarCaballo(caballo, numero, dividendo);
    }//GEN-LAST:event_btnAgregarACarreraActionPerformed

    private void btnConfirmarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCarreraActionPerformed
        this.controller.confirmarCarrera();        
    }//GEN-LAST:event_btnConfirmarCarreraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarACarrera;
    private javax.swing.JButton btnConfirmarCarrera;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstDisponibles;
    private javax.swing.JList lstParticipantes;
    private javax.swing.JTextField txtDividendo;
    private javax.swing.JLabel txtInfoFechaCarrera;
    private javax.swing.JLabel txtInfoNumeroCarrera;
    private javax.swing.JSpinner txtNumero;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void actualizarListas(ArrayList<Caballo> disponibles, ArrayList<Caballo> seleccionados) {
        Utils.fillJList(lstDisponibles, disponibles);
        Utils.fillJList(lstParticipantes, seleccionados);
    }

    @Override
    public void cargarDatos(Carrera carrera) {
        this.txtInfoFechaCarrera.setText(carrera.getDate().toString());
        this.txtInfoNumeroCarrera.setText(carrera.getNumero() +"");
    }

    @Override
    public void error(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void success(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
