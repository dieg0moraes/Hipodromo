package gui;

import gui.controllers.FinalizarCarreraController;
import gui.controllers.intefaces.IFinalizarCarrera;
import javax.swing.JOptionPane;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participacion;
import obligatorio2020.Utils;

public class UIFinalizarCarrera extends javax.swing.JFrame implements IFinalizarCarrera{
    
    private FinalizarCarreraController controller;
    
    public UIFinalizarCarrera(Hipodromo hipodromo) {
        initComponents();
        this.controller = new FinalizarCarreraController(this, hipodromo);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipaciones = new javax.swing.JList();
        btnFinalizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombreCaballo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroCaballo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDividendo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMontoCabllo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre: ");

        txtNombre.setText("nombre");

        jLabel2.setText("Numero:");

        txtNumero.setText("numero");

        jLabel3.setText("Monto total jugado:");

        txtMonto.setText("monto");

        lstParticipaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstParticipacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstParticipaciones);

        btnFinalizar.setText("Seleccionar ganador y finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre Caballo:");

        txtNombreCaballo.setText("nombreCaballo");

        jLabel5.setText("Numero:");

        txtNumeroCaballo.setText("numero");

        jLabel6.setText("Dividendo:");

        txtDividendo.setText("dividendo");

        jLabel7.setText("Monto total: ");

        txtMontoCabllo.setText("monto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumero))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreCaballo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumeroCaballo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDividendo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoCabllo)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombreCaballo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNumeroCaballo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDividendo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMontoCabllo))))
                .addGap(18, 18, 18)
                .addComponent(btnFinalizar)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstParticipacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstParticipacionesMouseClicked
        Participacion p = (Participacion) lstParticipaciones.getSelectedValue();
        controller.detallesParticipacion(p);
    }//GEN-LAST:event_lstParticipacionesMouseClicked

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        Participacion participacion = (Participacion)lstParticipaciones.getSelectedValue();
        controller.finzalizarCarrera(participacion);
    }//GEN-LAST:event_btnFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstParticipaciones;
    private javax.swing.JLabel txtDividendo;
    private javax.swing.JLabel txtMonto;
    private javax.swing.JLabel txtMontoCabllo;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombreCaballo;
    private javax.swing.JLabel txtNumero;
    private javax.swing.JLabel txtNumeroCaballo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarDatos(Carrera carrera) {
        this.txtMonto.setText(carrera.getMontoTotalApostado() +"");
        this.txtNombre.setText(carrera.getNombre());
        this.txtNumero.setText(carrera.getNumero()+"");
        Utils.fillJList(lstParticipaciones, carrera.getParticipaciones());
        
    }
    @Override
    public void cargarDetallesParticipacion(int numero, float dividendo, float montoTotal, String nombreCaballo){
        this.txtNumeroCaballo.setText(numero + "");
        this.txtNombreCaballo.setText(nombreCaballo);
        this.txtDividendo.setText(dividendo + "");
        this.txtMontoCabllo.setText(montoTotal + "");
    }
    
    public void mostrarError(String error){
        JOptionPane.showMessageDialog(this, error);
    }
    
    
}
