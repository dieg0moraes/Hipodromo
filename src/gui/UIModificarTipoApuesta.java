package gui;

import gui.controllers.ModificarTipoApuestaController;
import gui.controllers.intefaces.IModificarTipoApuesta;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participacion;
import modelo.TipoApuestaCuadruple;
import modelo.TipoApuestaSimple;
import modelo.TipoApuestaTriple;
import obligatorio2020.Utils;

public class UIModificarTipoApuesta extends javax.swing.JFrame implements IModificarTipoApuesta{
    private ModificarTipoApuestaController controller;

    public UIModificarTipoApuesta(Hipodromo hipodromo) {
        initComponents();
        this.controller = new ModificarTipoApuestaController(this, hipodromo);
        this.btnTipos.add(rbSimple);
        this.btnTipos.add(rbTriple);
        this.btnTipos.add(rbCuadruple);
        cbCarreras.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Carrera carrera = (Carrera)cbCarreras.getSelectedItem();
                    cambiarCarreraSeleccionada(carrera);
                }
            }
        });
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

        btnTipos = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipaciones = new javax.swing.JList();
        rbSimple = new javax.swing.JRadioButton();
        rbTriple = new javax.swing.JRadioButton();
        rbCuadruple = new javax.swing.JRadioButton();
        cbCarreras = new javax.swing.JComboBox();
        btnCambiarTIpoApuesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(lstParticipaciones);

        rbSimple.setText("Apuesta simple");

        rbTriple.setText("Apuesta Triple");

        rbCuadruple.setText("Apuesta Cuadruple");

        btnCambiarTIpoApuesta.setText("Cambiar tipo de apuesta");
        btnCambiarTIpoApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTIpoApuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbSimple)
                            .addComponent(rbTriple)
                            .addComponent(rbCuadruple)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnCambiarTIpoApuesta)))
                        .addGap(125, 125, 125))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(cbCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbSimple)
                .addGap(26, 26, 26)
                .addComponent(rbTriple)
                .addGap(28, 28, 28)
                .addComponent(rbCuadruple)
                .addGap(63, 63, 63)
                .addComponent(btnCambiarTIpoApuesta)
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarTIpoApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTIpoApuestaActionPerformed
        Participacion participacion = (Participacion)lstParticipaciones.getSelectedValue();
        if(rbSimple.isSelected()){
            controller.setTipoApuesta(new TipoApuestaSimple(), participacion);
        }else if (rbTriple.isSelected()){
            controller.setTipoApuesta(new TipoApuestaTriple(), participacion);
        }else if(rbCuadruple.isSelected()){
            controller.setTipoApuesta(new TipoApuestaCuadruple(), participacion);
        }
    }//GEN-LAST:event_btnCambiarTIpoApuestaActionPerformed
    
    public void cambiarCarreraSeleccionada(Carrera carrera){
        controller.cambiarCarreraSeleccionada(carrera);
    }
    
    public void cargarCarreras(ArrayList<Carrera> carreras){
        DefaultComboBoxModel listaMostrar = new DefaultComboBoxModel();
        for (Carrera u: carreras){
            listaMostrar.addElement(u);
        }         
        this.cbCarreras.setModel(listaMostrar);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarTIpoApuesta;
    private javax.swing.ButtonGroup btnTipos;
    private javax.swing.JComboBox cbCarreras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstParticipaciones;
    private javax.swing.JRadioButton rbCuadruple;
    private javax.swing.JRadioButton rbSimple;
    private javax.swing.JRadioButton rbTriple;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarParticipaciones(ArrayList<Participacion> participaciones) {
        Utils.fillJList(lstParticipaciones, participaciones);
    }

    @Override
    public void success(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
   
    
}

