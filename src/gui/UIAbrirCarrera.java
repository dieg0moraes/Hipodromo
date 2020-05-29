package gui;

import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import obligatorio2020.Utils;

public class UIAbrirCarrera extends javax.swing.JFrame {
    Fachada fachada = Fachada.getInstancia();
    Hipodromo hipodromo;
    
    public UIAbrirCarrera(Hipodromo hipodromo) {
        initComponents();
        this.hipodromo = hipodromo;
        actualizar();
    }
    
    private void actualizar(){
       Carrera carrera = hipodromo.getNextCarrera();
       Utils.fillJList(lstParticipantes, carrera.getCaballos());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreCarrera.setText("Nombre carrera");

        jLabel1.setText("Numero de carrera: ");

        txtNumeroCarrera.setText("Numero");

        jScrollPane1.setViewportView(lstParticipantes);

        btnAbrir.setText("Abrir carrera");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAbrir)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstParticipantes;
    private javax.swing.JLabel txtNombreCarrera;
    private javax.swing.JLabel txtNumeroCarrera;
    // End of variables declaration//GEN-END:variables
}
