/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2;

import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Cuentas_listar_caja extends javax.swing.JDialog {

    DefaultTableModel model;

    public Cuentas_listar_caja(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_bus.setDocument(new machusculas());
        txt_bus.requestFocus();
        cargar("");

    }

    public static String cod_cuenta_actu = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_cuentas = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuentas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_cuentas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_cuentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_cuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_cuentas.setRequestFocusEnabled(false);
        tb_cuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cuentasMouseClicked(evt);
            }
        });
        tb_cuentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_cuentasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_cuentasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_cuentasKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_cuentas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 740, 390));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 370, 32));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_cuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cuentasMouseClicked
        String tipo = "", des = "", id = "", saldo = "", nac = "";
        int fila = tb_cuentas.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            } else {
                id = (String) tb_cuentas.getValueAt(fila, 0);
                des = (String) tb_cuentas.getValueAt(fila, 1);
                saldo = (String) tb_cuentas.getValueAt(fila, 3);

                Caja_caja.txt_nro_his.setText(id);
                Caja_caja.txt_nom_cuenta.setText(des);
                Caja_caja.valor_gs_caja.setText(saldo);
                //   Caja_caja.txt_id_his.requestFocus();
                this.dispose();

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tb_cuentasMouseClicked

    private void tb_cuentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_cuentasKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            String tipo = "", des = "", id = "", saldo = "", nac = "";
            int fila = tb_cuentas.getSelectedRow();
            try {
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

                } else {
                    id = (String) tb_cuentas.getValueAt(fila, 0);
                    des = (String) tb_cuentas.getValueAt(fila, 1);
                    saldo = (String) tb_cuentas.getValueAt(fila, 3);

                    Caja_caja.txt_nro_his.setText(id);
                    Caja_caja.txt_nom_cuenta.setText(des);
                    Caja_caja.valor_gs_caja.setText(saldo);

                    this.dispose();
                    // Caja_caja.txt_des.requestFocus();

                }
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_tb_cuentasKeyPressed

    private void tb_cuentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_cuentasKeyReleased

    }//GEN-LAST:event_tb_cuentasKeyReleased

    private void tb_cuentasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_cuentasKeyTyped

    }//GEN-LAST:event_tb_cuentasKeyTyped

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

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
            java.util.logging.Logger.getLogger(Cuentas_listar_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuentas_listar_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuentas_listar_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuentas_listar_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cuentas_listar_caja dialog = new Cuentas_listar_caja(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tb_cuentas;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Cta. N°", "Nombre de la cuenta", "Descripción", "Saldo"};
            String[] registros = new String[4];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();
            String id_us = Principal.lbl_id_user.getText();
            String cons = "select u.cod_cuenta,c.nom_cuenta,c.des_cuenta,c.saldo_cuenta from usu_cuenta as u inner join cuentas as c on c.nro_cuentas=u.cod_cuenta WHERE CONCAT (nom_cuenta) LIKE '%" + valor + "%' and u.cod_usu='" + id_us + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);

                model.addRow(registros);
            }
            tb_cuentas.setModel(model);
            tb_cuentas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_cuentas.getColumnModel().getColumn(1).setPreferredWidth(260);
            tb_cuentas.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_cuentas.getColumnModel().getColumn(3).setPreferredWidth(103);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
