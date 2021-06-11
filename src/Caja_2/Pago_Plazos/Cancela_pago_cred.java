/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.Pago_Plazos;

import Caja_2.Caja_caja;
import static Caja_2.Caja_caja.lbl_total_gs;
import static Caja_2.Caja_caja.txt_des_caja;
import static Caja_2.Caja_caja.txt_nro_docu;
import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Cancela_pago_cred extends javax.swing.JDialog {

    DefaultTableModel model;
    DefaultTableModel model_deta;

    public Cancela_pago_cred(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        lbl_almacen_ventas.setText(Caja_caja.txt_alma_caja.getText());
        txt_bus.setDocument(new machusculas());

        cargar("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_detalle_pago = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        lbl_almacen_ventas = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cancelar");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 950, 360));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 120, 40));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 280, 30));

        lbl_almacen_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_ventas.setText("almacen");
        lbl_almacen_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbl_almacen_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 120, 50));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Nro de Recibo/Cliente:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filasel = tb_detalle_pago.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione algun dato");
        } else {
            if (JOptionPane.showConfirmDialog(rootPane, "Cancelar comprobante, ¿desea continuar?",
                    "Pagos", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                actEstadoVentas();
                cargar_Caja();
                eliminarNota();
                cargar("");
                JOptionPane.showMessageDialog(null, "Datos confirmados");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

        cargar(txt_bus.getText());

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
            java.util.logging.Logger.getLogger(Cancela_pago_cred.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cancela_pago_cred.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cancela_pago_cred.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cancela_pago_cred.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cancela_pago_cred dialog = new Cancela_pago_cred(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_almacen_ventas;
    private javax.swing.JTable tb_detalle_pago;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {

        try {
            String alma = lbl_almacen_ventas.getText();
            String[] titulos = {"N° Recibo", "Cliente", "Monto Pagado", " Pendiente", "Ult. Pago", "N° Serie", "Venta N°"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from pago_credito_comun WHERE CONCAT (id_pago,nom_cliente) LIKE '%" + valor + "%'   AND id_surcusal='" + alma + "' ORDER BY id_pago DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {

                registros[0] = rs.getString(1);
                registros[1] = rs.getString(4);
                registros[2] = rs.getString(5);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(9);
                registros[5] = rs.getString(12);
                registros[6] = rs.getString(2);

                model.addRow(registros);
            }
            tb_detalle_pago.setModel(model);

            tb_detalle_pago.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(1).setPreferredWidth(250);
            tb_detalle_pago.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(5).setPreferredWidth(200);
            tb_detalle_pago.getColumnModel().getColumn(6).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void cargar_Caja() {
        int nro_rec = tb_detalle_pago.getSelectedRow();

        String nro_recibo = (String) tb_detalle_pago.getValueAt(nro_rec, 0);
        String valor_pago = (String) tb_detalle_pago.getValueAt(nro_rec, 2);
        String serie = (String) tb_detalle_pago.getValueAt(nro_rec, 5);
        txt_nro_docu.setText(nro_recibo);
        txt_des_caja.setText("CANC. RECIBO N°:" + nro_recibo + "  " + "SERIE N°:" + serie);
        lbl_total_gs.setText(valor_pago);
        Caja_caja.btn_calcular.doClick();
        //  Caja_caja.btn_confirmar.doClick();

    }

    void eliminarNota() {

        int filasel = tb_detalle_pago.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                String cod = (String) tb_detalle_pago.getValueAt(filasel, 0);
                String eliminarSQL = "DELETE FROM pago_credito_comun WHERE id_pago = '" + cod + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    // JOptionPane.showMessageDialog(null, "Borrado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }

    }

    void actEstadoVentas() {
        int nro_recibo = tb_detalle_pago.getSelectedRow();
        String nro_recibe = (String) tb_detalle_pago.getValueAt(nro_recibo, 6);
        String valor_pago = (String) tb_detalle_pago.getValueAt(nro_recibo, 2);
        String saldo = (String) tb_detalle_pago.getValueAt(nro_recibo, 3);
        String valor_saldo = "0";
        BigDecimal pago_realizado = ingreso.TransformReales(valor_pago);
        BigDecimal sumar_desc = ingreso.TransformReales(saldo);
        valor_saldo = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(pago_realizado.add(sumar_desc).toString());

        if (lbl_almacen_ventas.getText().equals("0000001")) {
            try {

                String sql = "UPDATE ventas SET monto_cred = '" + valor_saldo
                        + "' WHERE num_bol = '" + nro_recibe + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }
        }

        //2
        if (lbl_almacen_ventas.getText().equals("0000002")) {
            try {

                String sql = "UPDATE ventas_2 SET monto_cred = '" + valor_saldo
                        + "' WHERE num_bol = '" + nro_recibe + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }
        }
//16
        if (lbl_almacen_ventas.getText().equals("0000016")) {
            try {

                String sql = "UPDATE ventas_16 SET monto_cred = '" + valor_saldo
                        + "' WHERE num_bol = '" + nro_recibe + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }
        }
        //18
        if (lbl_almacen_ventas.getText().equals("0000018")) {
            try {

                String sql = "UPDATE ventas_18 SET monto_cred = '" + valor_saldo
                        + "' WHERE num_bol = '" + nro_recibe + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000020")) {
            try {

                String sql = "UPDATE ventas_20 SET monto_cred = '" + valor_saldo
                        + "' WHERE num_bol = '" + nro_recibe + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }
        }
    }

}
