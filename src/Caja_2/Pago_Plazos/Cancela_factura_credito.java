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
import static Caja_2.Pago_Plazos.Recibo_cancela_fact.serie;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import java.awt.Color;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cancela_factura_credito extends javax.swing.JDialog {

    DefaultTableModel model;
    DefaultTableModel model_deta;
    DefaultTableModel model_fact;

    public Cancela_factura_credito(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        panel_config.setVisible(false);
        txt_almacen.setText(Caja_caja.txt_alma_caja.getText());
        txt_total_saldo.setDisabledTextColor(Color.red);

        cargarPago(serie);
        cargarFacturas(serie);
        cargarPagos(serie);

        tb_detalles.getColumnModel().getColumn(0).setPreferredWidth(100);
        tb_detalles.getColumnModel().getColumn(1).setPreferredWidth(80);
        tb_detalles.getColumnModel().getColumn(2).setPreferredWidth(80);
        tb_detalles.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txt_nom_cli_cred = new javax.swing.JTextField();
        lbl_serie_pago = new javax.swing.JLabel();
        id_cliente_cre = new javax.swing.JTextField();
        txt_almacen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_config = new javax.swing.JPanel();
        btncalcular = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_detalles = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        lbl_lote_fact_canc = new javax.swing.JLabel();
        txt_nro_recibo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_facturas = new javax.swing.JTable();
        txt_total_saldo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setText("Detalle de cheques:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 140, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 102, 153));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 900, 10));

        txt_nom_cli_cred.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nom_cli_cred.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_cred.setEnabled(false);
        jPanel2.add(txt_nom_cli_cred, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 500, 32));

        lbl_serie_pago.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_serie_pago.setForeground(new java.awt.Color(153, 0, 0));
        lbl_serie_pago.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lbl_serie_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 230, 30));

        id_cliente_cre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        id_cliente_cre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        id_cliente_cre.setEnabled(false);
        jPanel2.add(id_cliente_cre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 32));

        txt_almacen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_almacen.setDisabledTextColor(new java.awt.Color(0, 102, 0));
        txt_almacen.setEnabled(false);
        jPanel2.add(txt_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 120, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel7.setText("Cliente:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setText("Recibo N°:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 70, 30));

        panel_config.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncalcular.setBackground(new java.awt.Color(255, 255, 255));
        btncalcular.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btncalcular.setMnemonic('c');
        btncalcular.setToolTipText("Calcular ALT+C");
        btncalcular.setBorder(new javax.swing.border.MatteBorder(null));
        btncalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncalcular.setFocusable(false);
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        panel_config.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 20));

        jPanel2.add(panel_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 110, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setText("Surcusal:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 80, 30));

        tb_detalles.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Banco", "Número", "Fecha", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_detalles.setGridColor(new java.awt.Color(255, 255, 255));
        tb_detalles.setRowHeight(22);
        tb_detalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_detallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_detalles);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 430, 180));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton2.setText("Confirmar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, 130, 50));

        lbl_lote_fact_canc.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbl_lote_fact_canc.setText("0");
        jPanel2.add(lbl_lote_fact_canc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 50, 30));

        txt_nro_recibo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_nro_recibo.setText("0");
        txt_nro_recibo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nro_recibo.setEnabled(false);
        txt_nro_recibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nro_reciboKeyReleased(evt);
            }
        });
        jPanel2.add(txt_nro_recibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 120, 30));

        tb_facturas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_facturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Factura", "Fecha", "Importe", "Saldo", "Nro Venta", "Lote"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_facturas.setGridColor(new java.awt.Color(255, 255, 255));
        tb_facturas.setRowHeight(22);
        tb_facturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_facturasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_facturas);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 130, -1, 180));

        txt_total_saldo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_total_saldo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_saldo.setText("0");
        txt_total_saldo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_saldo.setEnabled(false);
        txt_total_saldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_saldoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_total_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 160, 32));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel8.setText("Total pagado: ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 110, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setText("Facturas:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setText("Serie N°:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setText("Lote de Factura:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String capcod = "", capcan = "", nv = "";
        for (int i = 0; i < Cancela_factura_credito.tb_facturas.getRowCount(); i++) {
            BigDecimal importe = ingreso.TransformReales(tb_facturas.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal saldo = ingreso.TransformReales(tb_facturas.getValueAt(i, 3).toString().replaceAll("\\s", ""));
            capcan = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(importe.add(saldo).toString());
            nv = Cancela_factura_credito.tb_facturas.getValueAt(i, 4).toString();
            
            actEstadoVentas(nv, capcan);
            actpagosStatus(capcod, capcan, nv);

        }
        eliminarNota();
        cargar_Caja();
        JOptionPane.showMessageDialog(null, "Operación exitosa!");
        this.dispose();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void tb_detallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_detallesMouseClicked


    }//GEN-LAST:event_tb_detallesMouseClicked

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed

        calcularfacturas();
    }//GEN-LAST:event_btncalcularActionPerformed

    private void tb_facturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_facturasMouseClicked


    }//GEN-LAST:event_tb_facturasMouseClicked

    private void txt_total_saldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_saldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_saldoActionPerformed

    private void txt_nro_reciboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_reciboKeyReleased

    }//GEN-LAST:event_txt_nro_reciboKeyReleased

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
            java.util.logging.Logger.getLogger(Cancela_factura_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cancela_factura_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cancela_factura_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cancela_factura_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                Cancela_factura_credito dialog = new Cancela_factura_credito(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btncalcular;
    public static javax.swing.JTextField id_cliente_cre;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbl_lote_fact_canc;
    public static javax.swing.JLabel lbl_serie_pago;
    private javax.swing.JPanel panel_config;
    public static javax.swing.JTable tb_detalles;
    public static javax.swing.JTable tb_facturas;
    public static javax.swing.JTextField txt_almacen;
    public static javax.swing.JTextField txt_nom_cli_cred;
    private javax.swing.JTextField txt_nro_recibo;
    public static javax.swing.JTextField txt_total_saldo;
    // End of variables declaration//GEN-END:variables

    public void cargarPago(String valor) {
        String mostrar = "SELECT * FROM pago_credito WHERE  nro_pago= '" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                id_cliente_cre.setText(rs.getString(3));
                txt_nom_cli_cred.setText(rs.getString(4));
                lbl_serie_pago.setText(rs.getString(1));
                txt_nro_recibo.setText(rs.getString(22));
                txt_almacen.setText(rs.getString(12));
                txt_total_saldo.setText(rs.getString(11));
                lbl_lote_fact_canc.setText(rs.getString(23));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarPagos(String valor) {
        String mostrar = "SELECT * FROM pago_credito_detalle WHERE nro_pago= '" + valor + "'";
        String[] titulos = {"Banco", "Nro Doc.", "Fecha", "Importe"};
        String[] Registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(3);
                Registros[1] = rs.getString(4);
                Registros[2] = rs.getString(5);
                Registros[3] = rs.getString(6);
                Registros[3] = rs.getString(6);

                modelo.addRow(Registros);
            }
            tb_detalles.setModel(modelo);

            tb_detalles.getColumnModel().getColumn(0).setPreferredWidth(120);
            tb_detalles.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_detalles.getColumnModel().getColumn(2).setPreferredWidth(110);
            tb_detalles.getColumnModel().getColumn(3).setPreferredWidth(110);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarFacturas(String valor) {
        String mostrar = "SELECT * FROM pago_credito_factura WHERE nro_recibo='" + valor + "'";
        String[] titulos = {"Nro Factura", "Fecha", "Importe", "Saldo ant.", "Nro Venta","Lote"};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(2);
                Registros[1] = rs.getString(3);
                Registros[2] = rs.getString(4);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(7);
                Registros[5] = rs.getString(10);

                modelf.addRow(Registros);
            }
            tb_facturas.setModel(modelf);

            tb_facturas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_facturas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_facturas.getColumnModel().getColumn(2).setPreferredWidth(110);
            tb_facturas.getColumnModel().getColumn(3).setPreferredWidth(110);
            tb_facturas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_facturas.getColumnModel().getColumn(5).setPreferredWidth(50);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void eliminarNota() {

        String cod = lbl_serie_pago.getText();
        String lote = lbl_lote_fact_canc.getText();
        String eliminarSQL = "DELETE FROM pago_credito WHERE nro_pago = '" + cod + "' and lote_fact='" + lote + "' ";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void cargar_Caja() {

        String nro_recibo = txt_nro_recibo.getText();
        String id_cliente = id_cliente_cre.getText();
        String fact = lbl_serie_pago.getText();
        String valor = txt_total_saldo.getText();

        txt_nro_docu.setText(nro_recibo);
        txt_des_caja.setText("Cancelamiento de Recibo segun Serie N°:" + fact + " /" + " Id cliente:" + id_cliente);
        lbl_total_gs.setText(valor);
        Caja_caja.btn_calcular.doClick();
        //  Caja_caja.btn_confirmar.doClick();

    }

    public void calcularTotal() {

    }

    void actEstadoVentas(String cod, String monto) {
        if (txt_almacen.getText().equals("0000001")) {
            try {

                String sql = "UPDATE ventas_facturacion SET saldo_cred = '" + monto
                        + "' WHERE num_bol = '" + cod + "' ";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (HeadlessException e) {
            }
        }

        //2
        if (txt_almacen.getText().equals("0000002")) {
            try {

                String sql = "UPDATE ventas_facturacion_surc_2 SET saldo_cred = '" + monto
                        + "' WHERE num_bol = '" + cod + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (HeadlessException e) {
            }
        }

    }

    void actpagosStatus(String nro, String saldo, String nv) {

        if (txt_almacen.getText().equals("0000001")) {
            try {
                String es = ("ACTIVO");
                String Status = ("FINALIZADA");
                String sql = "UPDATE ventas_facturacion SET estado_fact = '" + es
                        + "' WHERE num_bol = '" + nv + "'";
                String sql_ventas = "UPDATE ventas SET estado_ventas = '" + Status
                        + "' WHERE num_bol = '" + nv + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    PreparedStatement pst2 = cn.prepareStatement(sql_ventas);
                    pst.executeUpdate();
                    pst2.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (HeadlessException e) {
            }
        }

        //2
        if (txt_almacen.getText().equals("0000002")) {
            try {
                String es = ("ACTIVO");
                String Status = ("FINALIZADA");
                String sql = "UPDATE ventas_facturacion_surc_2 SET estado_fact = '" + es
                        + "' WHERE num_bol = '" + nv + "'";
                String sql_ventas = "UPDATE ventas_2 SET estado_ventas = '" + Status
                        + "' WHERE num_bol = '" + nv + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    PreparedStatement pst2 = cn.prepareStatement(sql_ventas);
                    pst.executeUpdate();
                    pst2.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (HeadlessException e) {
            }
        }

        ///////////no configurado
    }

    public void calcularfacturas() {

        ///
        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_facturas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_facturas.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_total_saldo.setText(subtotal);
        }
    }

}
