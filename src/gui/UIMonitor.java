package gui;

import gui.controllers.MonitorController;
import gui.controllers.intefaces.IMonitor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participacion;
import modelo.UsuarioJugador;
import obligatorio2020.Utils;

public class UIMonitor extends javax.swing.JFrame implements IMonitor{
    private MonitorController controller;
    
    public UIMonitor(Hipodromo hipodromo) {
        initComponents();
        this.controller = new MonitorController(this, hipodromo);
        this.controller.cargarDatos();
        this.lstCaballos = new JList(new DefaultListModel());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCarreras = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroCarrera = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMontoTotalApostado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMontoTotalPagado = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstGanadores = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstCaballos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar");

        txtFecha.setText(" ");

        lstCarreras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstCarrerasMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstCarrerasMouseReleased(evt);
            }
        });
        lstCarreras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCarrerasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCarreras);

        jLabel1.setText("Numero de carrera:");

        jLabel2.setText("Nombre:");

        txtNumeroCarrera.setText("numero");

        txtNombre.setText("nombre");

        jLabel3.setText("Estado:");

        txtEstado.setText("estado");

        jLabel4.setText("Monto total apostado: ");

        txtMontoTotalApostado.setText("total");

        jLabel5.setText("Monto total pagado: ");

        txtMontoTotalPagado.setText("total pago");

        jScrollPane3.setViewportView(lstGanadores);

        jLabel6.setText("GANADORES");

        jLabel7.setText("CABALLOS");

        jLabel8.setText("CARRERAS");

        jScrollPane4.setViewportView(lstCaballos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel6)
                                .addGap(764, 789, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumeroCarrera))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoTotalApostado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoTotalPagado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumeroCarrera))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMontoTotalApostado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMontoTotalPagado)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCarrerasMouseClicked
        
    }//GEN-LAST:event_lstCarrerasMouseClicked

    private void lstCarrerasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCarrerasValueChanged
        
    }//GEN-LAST:event_lstCarrerasValueChanged

    private void lstCarrerasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCarrerasMouseReleased
        Carrera carrera = this.lstCarreras.getSelectedValue();
        this.controller.seleccionarCarrera(carrera);
    }//GEN-LAST:event_lstCarrerasMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList lstCaballos;
    private javax.swing.JList<Carrera> lstCarreras;
    private javax.swing.JList lstGanadores;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JLabel txtMontoTotalApostado;
    private javax.swing.JLabel txtMontoTotalPagado;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNumeroCarrera;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarCarreras(ArrayList<Carrera> carreras) {
        Utils.fillJList(lstCarreras, carreras);
    }
    
    @Override
    public void cargarCaballos(ArrayList<String> participaciones){
        Utils.fillJList(lstCaballos, participaciones);
    }
    
    
    
    @Override
    public void cargarGanadores(ArrayList<UsuarioJugador> jugadores){
        Utils.fillJList(lstGanadores, jugadores);       
    }
    

    @Override
    public Carrera getSelectedCarrera() {
        return this.lstCarreras.getSelectedValue();
    }

    @Override
    public void cargarCarrera(Carrera carrera) {
        this.txtEstado.setText(carrera.getStatus().toString());
        this.txtFecha.setText(carrera.getDate().toString());
        this.txtMontoTotalApostado.setText(carrera.getMontoTotalApostado() +"");
        this.txtMontoTotalPagado.setText(carrera.getMontoTotalPagado()+"");
        this.txtNombre.setText(carrera.getNombre());
        this.txtNumeroCarrera.setText(carrera.getNumero()+"");
    }
}
