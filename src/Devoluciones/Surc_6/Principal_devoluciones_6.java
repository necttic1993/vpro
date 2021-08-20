/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devoluciones.Surc_6;

import Devoluciones.Surc_6.*;
import Clases.ColorearFilas_devoluciones;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author user
 */
public class Principal_devoluciones_6 extends javax.swing.JDialog {

    DefaultTableModel model;

    public Principal_devoluciones_6(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
        txt_bus.requestFocus();
        OpcionMenu();
        btn_cargar_datos.setVisible(false);
    }

    public static String cod_devol_surc_6 = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos_dev = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEVOLUCIONES");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos_dev = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos_dev.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProductos_dev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProductos_dev.setGridColor(new java.awt.Color(0, 102, 204));
        tbProductos_dev.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbProductos_dev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductos_devMouseClicked(evt);
            }
        });
        tbProductos_dev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductos_devKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProductos_devKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbProductos_dev);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1240, 510));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 130, 50));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(null);
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 22, 380, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 32));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductos_devMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductos_devMouseClicked

    }//GEN-LAST:event_tbProductos_devMouseClicked

    private void tbProductos_devKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_devKeyReleased

    }//GEN-LAST:event_tbProductos_devKeyReleased

    private void tbProductos_devKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_devKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {

            int filaMod = tbProductos_dev.getSelectedRow();
            cod_devol_surc_6 = (String) tbProductos_dev.getValueAt(filaMod, 0);

            Visor_devoluciones_6 visor;
            visor = new Visor_devoluciones_6(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }
    }//GEN-LAST:event_tbProductos_devKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Devolucion_Devoluciones_6 dv;
        dv = new Devolucion_Devoluciones_6(new javax.swing.JDialog(), true);
        dv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

    private void btn_cargar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_datosActionPerformed
        cargar("");
    }//GEN-LAST:event_btn_cargar_datosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal_devoluciones_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_devoluciones_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_devoluciones_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_devoluciones_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal_devoluciones_6 dialog = new Principal_devoluciones_6(new javax.swing.JDialog(), true);
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
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tbProductos_dev;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_6 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);

                model.addRow(registros);
            }
            tbProductos_dev.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tbProductos_dev.getColumnModel().getColumn(0).setCellRenderer(color);

            tbProductos_dev.getColumnModel().getColumn(0).setPreferredWidth(92);
            tbProductos_dev.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbProductos_dev.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbProductos_dev.getColumnModel().getColumn(3).setPreferredWidth(400);
            tbProductos_dev.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos_dev.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos_dev.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();

        JMenuItem menu_modPro = new JMenuItem("Re-Imprimir Devoluciones", new ImageIcon(getClass().getResource("/icon_4/print.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbProductos_dev.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                int filaMod = tbProductos_dev.getSelectedRow();
                String cod_devo = (String) tbProductos_dev.getValueAt(filaMod, 0);

                Reportes reporte = new Reportes();
                try {
                    reporte.devoluciones_surc_6(cod_devo);

                } catch (SQLException | JRException ex) {
                    Logger.getLogger(Principal_devoluciones_6.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        menu_opcion.add(menu_modPro);
        tbProductos_dev.setComponentPopupMenu(menu_opcion);

    }

}
