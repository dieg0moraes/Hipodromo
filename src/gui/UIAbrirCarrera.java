package gui;
import gui.controllers.AbrirCarreraController;
import gui.controllers.intefaces.IAbrirCarrera;
import javax.swing.JOptionPane;
import modelo.Carrera;
import modelo.Hipodromo;
import obligatorio2020.Utils;

public class UIAbrirCarrera extends javax.swing.JFrame implements IAbrirCarrera{
    private AbrirCarreraController controller;
    
    public UIAbrirCarrera(Hipodromo hipodromo) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        this.controller = new AbrirCarreraController(this, hipodromo);
    } 

    @Override
    public void cargarDatos(Carrera c) {
        if(c != null){
            System.out.println(c);
            Utils.fillJList(lstParticipantes, c.getCaballos());
            this.txtNombreCarrera.setText(c.getNombre());
            this.txtNumeroCarrera.setText(c.getNumero()+"");   
            this.txtStatus.setText(c.getStatus().toString());
        }
    }
    
    @Override
    public void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreCarrera = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroCarrera = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipantes = new javax.swing.JList();
        btnAbrir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreCarrera.setText("Nombre carrera");

        jLabel1.setText("Numero de carrera: ");

        txtNumeroCarrera.setText("Numero");

        jScrollPane1.setViewportView(lstParticipantes);

        btnAbrir.setText("Abrir carrera");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jLabel2.setText("Status");

        txtStatus.setText("Numero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStatus))
                    .addComponent(btnAbrir)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroCarrera))
                    .addComponent(txtNombreCarrera))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtNombreCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroCarrera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAbrir)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        controller.abrirCarrera();
    }//GEN-LAST:event_btnAbrirActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.dispose();
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstParticipantes;
    private javax.swing.JLabel txtNombreCarrera;
    private javax.swing.JLabel txtNumeroCarrera;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables

    @Override
    public void success(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje);
    }
}
