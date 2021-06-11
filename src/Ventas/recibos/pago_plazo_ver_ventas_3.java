/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.recibos;

import Conexion_DB.conectar;
import static Ventas_3.Principal_ventas_3.cod_ver_alma_3;
import static Ventas_3.Principal_ventas_3.cod_ver_ventas_cli_3;
import static Ventas_3.Principal_ventas_3.cod_ver_ventas_plazo_3;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author User
 */
public class pago_plazo_ver_ventas_3 extends javax.swing.JDialog {

    DefaultTableModel model;
    DefaultTableModel model_deta;

    public pago_plazo_ver_ventas_3(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar(cod_ver_ventas_cli_3);
        // cargar(cod_ver_ventas_cli_2);
        lbl_id_cli.setText(cod_ver_ventas_cli_3);
        lbl_id_venta.setText(cod_ver_ventas_plazo_3);
        cargar_detalle_pago(cod_ver_ventas_plazo_3, cod_ver_alma_3);
        cargar_espe(cod_ver_ventas_plazo_3) ;
        //cargar_detalle_pago(cod_ver_ventas_plazo_2, cod_ver_alma_2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas_pend = new javax.swing.JTable();
        lbl_id_cli = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_detalle_pago = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lbl_id_venta = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saldo de ventas a crédito");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_ventas_pend = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_ventas_pend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_ventas_pend);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 250, 200));

        lbl_id_cli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_id_cli.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbl_id_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 90, 20));

        tb_detalle_pago = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_detalle_pago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_detalle_pago.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tb_detalle_pago);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 720, 140));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Pendientes del Cliente:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, -1, 20));

        tbProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProductos.setGridColor(new java.awt.Color(0, 102, 204));
        tbProductos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbProductos.setShowVerticalLines(false);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProductosKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbProductos);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1000, 190));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setText("Re-Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 40));

        lbl_id_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_id_venta.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_id_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Historial nota N°:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 740, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int filasel = tb_detalle_pago.getSelectedRow();

            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                try {
                    String cod = (String) tb_detalle_pago.getValueAt(filasel, 0);
                    Reportes reporte = new Reportes();
                    reporte.receb(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(pago_plazo_ver_ventas_3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(pago_plazo_ver_ventas_3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked

    }//GEN-LAST:event_tbProductosMouseClicked

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed

    }//GEN-LAST:event_tbProductosKeyPressed

    private void tbProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyReleased

    }//GEN-LAST:event_tbProductosKeyReleased

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
            java.util.logging.Logger.getLogger(pago_plazo_ver_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pago_plazo_ver_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pago_plazo_ver_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pago_plazo_ver_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pago_plazo_ver_ventas_3 dialog = new pago_plazo_ver_ventas_3(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_id_cli;
    public static javax.swing.JLabel lbl_id_venta;
    public static javax.swing.JTable tbProductos;
    private javax.swing.JTable tb_detalle_pago;
    private javax.swing.JTable tb_ventas_pend;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Saldo Pendiente"};
            String[] registros = new String[2];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_3 WHERE cod_cli_ventas= '" + valor + "' and estado_ventas='FINALIZADA' and forma_pag_ventas='CRÉDITO'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(18);

                model.addRow(registros);
            }
            tb_ventas_pend.setModel(model);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_detalle_pago(String valor, String alma) {

        try {

            String[] titulos = {"N° Serie", "Cliente", "Monto Pagado", " Pendiente", "Ult. Pago"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from pago_credito_comun WHERE  id_venta= '" + valor + "'   and id_surcusal='" + alma + "' ORDER BY id_pago DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {

                registros[0] = rs.getString(12);
                registros[1] = rs.getString(4);
                registros[2] = rs.getString(5);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(9);

                model.addRow(registros);
            }
            tb_detalle_pago.setModel(model);

            tb_detalle_pago.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_detalle_pago.getColumnModel().getColumn(1).setPreferredWidth(250);
            tb_detalle_pago.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(4).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void cargar_espe(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Valor Total", "Saldo pendiente", "Fecha", "Usuario", "Almacén"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_3 WHERE num_bol ='" + valor + "'  ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(18);
                registros[5] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(10));
                registros[6] = rs.getString(12);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(140);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
