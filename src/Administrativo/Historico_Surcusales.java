/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrativo;

import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_almacen;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Historico_Surcusales extends javax.swing.JDialog {

    DefaultTableModel model;

    public Historico_Surcusales(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_bus.setDocument(new machusculas());
        txt_bus.requestFocus();
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargar("");
        } else {
            cargar_espec("");
        }

        OpcionMenu();
        btn_cargar_datos.setVisible(false);
    }

    public static String cod_his_actu = "";
     public static String alma_his_actu = "";

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();
        // JMenuItem menu_addpro = new JMenuItem("Agregar Producto", new ImageIcon(getClass().getResource("/Iconos_1/escritura.png")));
        JMenuItem menu_modPro = new JMenuItem("Modificar Histórico", new ImageIcon(getClass().getResource("/Iconos_1/recargar.png")));
        JMenuItem menu_eliminar_Pro = new JMenuItem("Eliminar Egreso", new ImageIcon(getClass().getResource("/Iconos_1/basura.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {

            int filaMod = tb_hist.getSelectedRow();
            if (filaMod == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaModi = tb_hist.getSelectedRow();
                cod_his_actu = (String) tb_hist.getValueAt(filaModi, 0);
                alma_his_actu= (String) tb_hist.getValueAt(filaModi, 3);
                Surcusales_historico_actu rp;
                rp = new Surcusales_historico_actu(new javax.swing.JDialog(), true);
                rp.setVisible(true);
            }

        });

        menu_eliminar_Pro.addActionListener((ActionEvent e) -> {

            int filaMod = tb_hist.getSelectedRow();

            if (filaMod == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
                        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    // borrarGastos();
                }

            }

        });

        menu_opcion.add(menu_modPro);
        //  menu_opcion.add(menu_eliminar_Pro);
        tb_hist.setComponentPopupMenu(menu_opcion);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_hist = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Históricos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/anadir-nuevo-documento.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 60, 40));

        tb_hist = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_hist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_hist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_hist.setRequestFocusEnabled(false);
        tb_hist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_histMouseClicked(evt);
            }
        });
        tb_hist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_histKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_histKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_histKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_hist);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 860, 480));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busActionPerformed(evt);
            }
        });
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 3, 370, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Surcusales_historico_registro marc;
        marc = new Surcusales_historico_registro(new javax.swing.JDialog(), true);
        marc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_histMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_histMouseClicked

    }//GEN-LAST:event_tb_histMouseClicked

    private void tb_histKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_histKeyPressed


    }//GEN-LAST:event_tb_histKeyPressed

    private void tb_histKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_histKeyReleased

    }//GEN-LAST:event_tb_histKeyReleased

    private void tb_histKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_histKeyTyped

    }//GEN-LAST:event_tb_histKeyTyped

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
     
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
 if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargar(txt_bus.getText());
        } else {
            cargar_espec(txt_bus.getText());
        }
    }//GEN-LAST:event_txt_busKeyReleased

    private void btn_cargar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_datosActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargar("");
        } else {
            cargar_espec("");
        }
    }//GEN-LAST:event_btn_cargar_datosActionPerformed

    private void txt_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busActionPerformed

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
            java.util.logging.Logger.getLogger(Historico_Surcusales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historico_Surcusales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historico_Surcusales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historico_Surcusales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Historico_Surcusales dialog = new Historico_Surcusales(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_cargar_datos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tb_hist;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Código", "Descripción", "Tipo", "Almacén", "Clasificacion"};
            String[] registros = new String[5];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from historicos_surc WHERE CONCAT (des_his) LIKE '%" + valor + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);

                model.addRow(registros);
            }
            tb_hist.setModel(model);
            tb_hist.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_hist.getColumnModel().getColumn(1).setPreferredWidth(400);
            tb_hist.getColumnModel().getColumn(2).setPreferredWidth(83);
            tb_hist.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_hist.getColumnModel().getColumn(4).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_espec(String valor) {
        try {
            String almacen = lbl_usu_almacen.getText();
            String[] titulos = {"Código", "Descripción", "Tipo", "Almacén", "Clasificacion"};
            String[] registros = new String[5];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from historicos_surc WHERE CONCAT (des_his) LIKE '%" + valor + "%' and surc_his='" + almacen + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);

                model.addRow(registros);
            }
            tb_hist.setModel(model);
            tb_hist.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_hist.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_hist.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_hist.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_hist.getColumnModel().getColumn(4).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
