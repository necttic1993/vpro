/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.Transferencia_dinero;

import Conexion_DB.conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ver_transferencias extends javax.swing.JDialog {

    DefaultTableModel model;

    public ver_transferencias(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    
    }

    void cargar(String valor) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_transferir = new javax.swing.JTable();
        jd_ini = new org.jdesktop.swingx.JXDatePicker();
        jLabel27 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jd_fin = new org.jdesktop.swingx.JXDatePicker();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(300, 310));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_transferir = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_transferir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_transferir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_transferir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_transferirMouseClicked(evt);
            }
        });
        tb_transferir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_transferirKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_transferir);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 890, 430));
        jPanel1.add(jd_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 140, 30));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Fecha Inicio:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Fecha Final:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 90, 30));
        jPanel1.add(jd_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 140, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 70, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_transferirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_transferirMouseClicked

    }//GEN-LAST:event_tb_transferirMouseClicked

    private void tb_transferirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_transferirKeyPressed

    }//GEN-LAST:event_tb_transferirKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        java.sql.Date fecha_ini = new java.sql.Date(jd_ini.getDate().getTime());
        java.sql.Date fecha_fin = new java.sql.Date(jd_fin.getDate().getTime());
        String mostrar = "SELECT * FROM transfe_cuentas WHERE  data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'";
        String[] titulos = {"Cuenta Origen N°", "Cuenta Destino N°", "Monto Transferido", "Usuario", "Fecha"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("nro_cuenta_origen");
                Registros[1] = rs.getString("nro_cuenta_destino");
                Registros[2] = rs.getString("monto_trans");
                Registros[3] = rs.getString("usu_ope");
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("data"));

                model.addRow(Registros);
            }
            tb_transferir.setModel(model);

            tb_transferir.getColumnModel().getColumn(0).setPreferredWidth(150);
            tb_transferir.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_transferir.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_transferir.getColumnModel().getColumn(3).setPreferredWidth(310);
            tb_transferir.getColumnModel().getColumn(4).setPreferredWidth(160);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ver_transferencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ver_transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ver_transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ver_transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ver_transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ver_transferencias dialog = new ver_transferencias(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static org.jdesktop.swingx.JXDatePicker jd_fin;
    public static org.jdesktop.swingx.JXDatePicker jd_ini;
    private javax.swing.JTable tb_transferir;
    // End of variables declaration//GEN-END:variables

}
