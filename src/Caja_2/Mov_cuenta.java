/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2;

import static Caja_2.Caja_caja.txt_nom_cuenta;
import static Caja_2.Caja_caja.txt_nro_his;
import Conexion_DB.conectar;
import static Loggin_Principal.Principal.lbl_fecha_principal;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Mov_cuenta extends javax.swing.JDialog {

    DefaultTableModel model;
    int KeyCodeGlobal = 0, Consumio = 0;
    public String Rizon = "", BienFormatado2, Preview2 = "";

    public Mov_cuenta(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cargarIngreso();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_ingreso = new javax.swing.JTable();
        lbl_cuenta_nom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_cuenta_visor = new javax.swing.JLabel();
        jd_ini_caja = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mov. caja por cuenta");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_ingreso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_ingreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_ingreso.setToolTipText("CAJA");
        tb_ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb_ingreso.setRowSelectionAllowed(false);
        tb_ingreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ingresoMouseClicked(evt);
            }
        });
        tb_ingreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_ingresoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_ingresoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_ingreso);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1190, 470));

        lbl_cuenta_nom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_cuenta_nom.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_cuenta_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 330, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Cuenta N°:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 80, 20));

        lbl_cuenta_visor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cuenta_visor.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_cuenta_visor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 30, 20));

        jd_ini_caja.setBackground(new java.awt.Color(255, 255, 255));
        jd_ini_caja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jd_ini_caja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jd_ini_cajaKeyPressed(evt);
            }
        });
        jPanel1.add(jd_ini_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 5, 140, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("En Fecha:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 100, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/chart.png"))); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ingresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ingresoMouseClicked

    }//GEN-LAST:event_tb_ingresoMouseClicked

    private void tb_ingresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ingresoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_ingresoKeyReleased

    private void tb_ingresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ingresoKeyPressed


    }//GEN-LAST:event_tb_ingresoKeyPressed

    private void jd_ini_cajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jd_ini_cajaKeyPressed

    }//GEN-LAST:event_jd_ini_cajaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarMovFecha();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Mov_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mov_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mov_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mov_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mov_cuenta dialog = new Mov_cuenta(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jd_ini_caja;
    private javax.swing.JLabel lbl_cuenta_nom;
    private javax.swing.JLabel lbl_cuenta_visor;
    public static javax.swing.JTable tb_ingreso;
    // End of variables declaration//GEN-END:variables

    void cargarIngreso() {

        try {
            String data = lbl_fecha_principal.getText();
            String cuenta = txt_nro_his.getText();
            String cuenta_nom = txt_nom_cuenta.getText();
            lbl_cuenta_visor.setText(cuenta);
            lbl_cuenta_nom.setText(cuenta_nom);
            String[] titulos = {"Descripción", "Histórico", "Crédito Gs", "Débito Gs", "Usuario", "Fecha Entrada"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from caja WHERE  fecha_caja='" + data + "' AND cuenta_nro= '" + cuenta + "'ORDER BY fecha_caja_control DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(2);
                registros[1] = rs.getString(4);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(9);
                registros[5] = rs.getString(8);

                model.addRow(registros);
            }
            tb_ingreso.setModel(model);
            tb_ingreso.getColumnModel().getColumn(0).setPreferredWidth(360);
            tb_ingreso.getColumnModel().getColumn(1).setPreferredWidth(320);
            tb_ingreso.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ingreso.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ingreso.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ingreso.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarMovFecha() {

        try {
            String data = lbl_fecha_principal.getText();
            String cuenta = txt_nro_his.getText();
            String cuenta_nom = txt_nom_cuenta.getText();
            lbl_cuenta_visor.setText(cuenta);
            lbl_cuenta_nom.setText(cuenta_nom);
            java.sql.Date date = new java.sql.Date(jd_ini_caja.getDate().getTime());

            String[] titulos = {"Descripción", "Histórico", "Crédito Gs", "Débito Gs", "Usuario", "Fecha Entrada"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from caja WHERE   cuenta_nro= '" + cuenta + "' AND fecha_caja='" + date + "' ORDER BY fecha_caja_control DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(2);
                registros[1] = rs.getString(4);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(9);
                registros[5] = rs.getString(8);

                model.addRow(registros);
            }
            tb_ingreso.setModel(model);
            tb_ingreso.getColumnModel().getColumn(0).setPreferredWidth(360);
            tb_ingreso.getColumnModel().getColumn(1).setPreferredWidth(320);
            tb_ingreso.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ingreso.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ingreso.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ingreso.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
