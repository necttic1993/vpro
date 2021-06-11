/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Clases.ColorearCuotas;
import static Compras.Principal_compras.cod_compras_ver_plazo;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class pago_plazo_ver_compras extends javax.swing.JDialog {

    DefaultTableModel model;
    DefaultTableModel model_deta;

    public pago_plazo_ver_compras(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbl_id_venta.setText(cod_compras_ver_plazo);
        cargar_detalle_pago(cod_compras_ver_plazo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_id_venta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_detalle_pago = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saldo de compras a plazo");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_id_venta.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbl_id_venta.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbl_id_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, 20));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 760, 390));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setText("Historial nota N°:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(pago_plazo_ver_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pago_plazo_ver_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pago_plazo_ver_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pago_plazo_ver_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pago_plazo_ver_compras dialog = new pago_plazo_ver_compras(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lbl_id_venta;
    private javax.swing.JTable tb_detalle_pago;
    // End of variables declaration//GEN-END:variables

    void cargar_detalle_pago(String valor) {

        try {
            String[] titulos = {"Oper. N° ", "N° ventas", "Descripción", "Monto", "Situacion", "Fecha Vto.", "Fecha Canc."};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from detalle_cuotas_compras WHERE nro_ventas = '" + valor + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(7);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);

                model.addRow(registros);
            }
            tb_detalle_pago.setModel(model);

            ColorearCuotas color = new ColorearCuotas(4);
            tb_detalle_pago.getColumnModel().getColumn(0).setCellRenderer(color);
            tb_detalle_pago.getColumnModel().getColumn(1).setCellRenderer(color);

            tb_detalle_pago.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_detalle_pago.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_detalle_pago.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
