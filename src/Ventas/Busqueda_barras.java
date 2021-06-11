/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Conexion_DB.conectar;
import java.awt.event.KeyEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Busqueda_barras extends javax.swing.JDialog {

    public Busqueda_barras(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txt_cod_barras = new javax.swing.JTextField();
        txt_id_pro = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_des_pro = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_stock_actual = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_cantidad_pro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("scanner");
        setLocation(new java.awt.Point(500, 200));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/scan.png"))); // NOI18N
        jLabel23.setFocusable(false);
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, -1));

        txt_cod_barras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cod_barras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_barrasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cod_barrasKeyReleased(evt);
            }
        });
        jPanel1.add(txt_cod_barras, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 230, 35));

        txt_id_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_pro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_id_pro.setEnabled(false);
        jPanel1.add(txt_id_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 120, 35));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Código");
        jLabel27.setFocusable(false);
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 80, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Descripción");
        jLabel24.setFocusable(false);
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 80, 20));

        txt_des_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_des_pro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_des_pro.setEnabled(false);
        jPanel1.add(txt_des_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 390, 35));

        txt_precio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_precio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_precio.setEnabled(false);
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 120, 35));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Precio");
        jLabel25.setFocusable(false);
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 80, 20));

        txt_stock_actual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_stock_actual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_stock_actual.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_stock_actual.setEnabled(false);
        jPanel1.add(txt_stock_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 50, 35));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Stock");
        jLabel26.setFocusable(false);
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 50, 20));

        txt_cantidad_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cantidad_pro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantidad_proKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cantidad_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 50, 35));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Cant.");
        jLabel20.setFocusable(false);
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 50, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_barrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_barrasKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

            String barras = txt_cod_barras.getText();
            cargar_pro(barras);

            txt_cantidad_pro.requestFocus();
        }
        if (Tecla == KeyEvent.VK_ESCAPE) {

            this.dispose();
        }

    }//GEN-LAST:event_txt_cod_barrasKeyPressed

    private void txt_cantidad_proKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_proKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            agregaritems();
        }
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_id_pro.setText("");
            txt_des_pro.setText("");
            txt_stock_actual.setText("");
            txt_precio.setText("");
            txt_cantidad_pro.setText("");
            txt_cod_barras.requestFocus();
            txt_cod_barras.setText("");
        }
    }//GEN-LAST:event_txt_cantidad_proKeyPressed

    private void txt_cod_barrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_barrasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_barrasKeyReleased

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
            java.util.logging.Logger.getLogger(Busqueda_barras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda_barras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda_barras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda_barras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Busqueda_barras dialog = new Busqueda_barras(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_cantidad_pro;
    public static javax.swing.JTextField txt_cod_barras;
    private javax.swing.JTextField txt_des_pro;
    private javax.swing.JTextField txt_id_pro;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_stock_actual;
    // End of variables declaration//GEN-END:variables

    String comparar(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(5);
                // System.out.println("stock");
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Busqueda_barras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargar_pro(String Cod) {
        String mostrar = "SELECT * FROM tienda_productos where pro_cod_barra='" + Cod + "' or pro_cod='" + Cod + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_id_pro.setText(rs.getString(1));
                txt_des_pro.setText(rs.getString(3));
                txt_stock_actual.setText(rs.getString(5));
                txt_precio.setText(rs.getString(7));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {

        }

    }

    void agregaritems() {

        DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
        String[] dato = new String[5];
        int c = 0;
        int j = 0;
        String id = txt_id_pro.getText();
        String des = txt_des_pro.getText();
        String cant = txt_cantidad_pro.getText();
        String pre = txt_precio.getText();
        String kg = ("0");
        String stckActual = txt_stock_actual.getText();
        int canting = Integer.parseInt(cant);
        int comp = Integer.parseInt(stckActual);
        if (canting > comp) {
            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
            txt_cantidad_pro.requestFocus();
            txt_cantidad_pro.setText("");

        } else {
            for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
                Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
                int existe = Integer.parseInt(Ventas_venta.tb_factura.getValueAt(i, 3).toString());
                if (id.equals(com)) {

                    int totalcante = existe + canting;
                    Ventas_venta.tb_factura.setValueAt(totalcante, i, 3);
                    if (totalcante > comp) {
                        JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");

                    }
                    j = i;
                    Ventas_venta.btncalcular.doClick();
                    c = c + 1;
                    //  JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");

                }
            }
            if (c == 0) {
                dato[0] = id;
                dato[1] = des;
                dato[2] = pre;
                dato[3] = cant;
                dato[4] = kg;

                tabladet.addRow(dato);

                Ventas_venta.tb_factura.setModel(tabladet);

                Ventas_venta.btncalcular.doClick();

            }

            txt_id_pro.setText("");
            txt_des_pro.setText("");
            txt_stock_actual.setText("");
            txt_precio.setText("");
            txt_cantidad_pro.setText("");
            txt_cod_barras.requestFocus();
            txt_cod_barras.setText("");

        }

        /* for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         int existe = Integer.parseInt(Ventas_venta.tb_factura.getValueAt(i, 3).toString());

         if (id.equals(com)) {
         int canting = Integer.parseInt(cant);
         int totalcante = existe + canting;
         int comp = Integer.parseInt(stckActual);

         if (totalcante > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cod_barras.requestFocus();
         } else {

         j = i;
         Ventas_venta.tb_factura.setValueAt(totalcante, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         //JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);
         Ventas_venta.tb_factura.setModel(tabladet);
         Ventas_venta.btncalcular.doClick();

         }
         }
         }

         }*/
    }
}
