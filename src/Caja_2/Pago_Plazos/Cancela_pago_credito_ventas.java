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
import static Caja_2.Pago_Plazos.Cancela_pago_cred.cod_nota_cred_pago;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cancela_pago_credito_ventas extends javax.swing.JDialog {

    DefaultTableModel model;
    DefaultTableModel model_deta;
    String bool_ventas = "0";

    public Cancela_pago_credito_ventas(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //lbl_serie_pago.setText(cod_nota_cred_pago);
        btncalcular.setVisible(false);
        lbl_monto_cred.setVisible(false);
        cargarPago(cod_nota_cred_pago);

        if (txt_almacen.getText().equals("0000001")) {
            cargarDev(cod_nota_cred_pago);
            cargarSaldoVenta();
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000002")) {
            cargarDev_2(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000003")) {
            cargarDev_3(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000004")) {
            cargarDev_4(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000005")) {
            cargarDev_5(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000006")) {
            cargarDev_6(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000007")) {
            cargarDev_7(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000008")) {
            cargarDev_8(cod_nota_cred_pago);
        }
        if (txt_almacen.getText().equals("0000009")) {
            cargarDev_9(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000010")) {
            cargarDev_10(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000011")) {
            cargarDev_11(cod_nota_cred_pago);
        }
        if (txt_almacen.getText().equals("0000012")) {
            cargarDev_12(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000013")) {
            cargarDev_13(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000014")) {
            cargarDev_14(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000015")) {
            cargarDev_15(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000016")) {
            cargarDev_16(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000017")) {
            cargarDev_17(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000018")) {
            cargarDev_18(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000019")) {
            cargarDev_19(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000020")) {
            cargarDev_20(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000021")) {
            cargarDev_21(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000022")) {
            cargarDev_22(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000023")) {
            cargarDev_23(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000024")) {
            cargarDev_24(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000025")) {
            cargarDev_25(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000026")) {
            cargarDev_26(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000027")) {
            cargarDev_27(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000028")) {
            cargarDev_28(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000029")) {
            cargarDev_29(cod_nota_cred_pago);
            btncalcular.doClick();
        }
        if (txt_almacen.getText().equals("0000030")) {
            cargarDev_30(cod_nota_cred_pago);
            btncalcular.doClick();
        }

    }

    public static String es = ("FINALIZADA");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txt_nro_venta = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txt_nom_cli_cred = new javax.swing.JTextField();
        txt_venta_cre_saldo = new javax.swing.JTextField();
        lbl_serie_pago = new javax.swing.JLabel();
        id_cliente_cre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_almacen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_nota_cred_ventas = new javax.swing.JTable();
        txt_monto_credito = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_import_total = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        txt_cred_entrada_caja = new javax.swing.JTextField();
        btncalcular = new javax.swing.JButton();
        lbl_monto_cred = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nro_venta.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_nro_venta.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_nro_venta.setEnabled(false);
        txt_nro_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nro_ventaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nro_ventaKeyReleased(evt);
            }
        });
        jPanel2.add(txt_nro_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 32));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        jButton2.setText("Grabar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 120, 40));

        jSeparator2.setForeground(new java.awt.Color(0, 102, 153));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 680, 10));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Venta N°:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        txt_nom_cli_cred.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cli_cred.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_cred.setEnabled(false);
        jPanel2.add(txt_nom_cli_cred, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 500, 32));

        txt_venta_cre_saldo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_venta_cre_saldo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_venta_cre_saldo.setText("0");
        txt_venta_cre_saldo.setDisabledTextColor(new java.awt.Color(153, 0, 51));
        txt_venta_cre_saldo.setEnabled(false);
        jPanel2.add(txt_venta_cre_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 170, 32));

        lbl_serie_pago.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_serie_pago.setForeground(new java.awt.Color(0, 102, 0));
        lbl_serie_pago.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lbl_serie_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 250, 30));

        id_cliente_cre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        id_cliente_cre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        id_cliente_cre.setEnabled(false);
        jPanel2.add(id_cliente_cre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 32));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Crédito Actual:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 150, 30));

        txt_almacen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_almacen.setDisabledTextColor(new java.awt.Color(0, 102, 0));
        txt_almacen.setEnabled(false);
        jPanel2.add(txt_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 150, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Cliente:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Serie N°:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 70, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Surcusal:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 80, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Nota de Crédito");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 30));

        tb_nota_cred_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nro Devol", "Importe", "Saldo Cred.", "Saldo Dev"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_nota_cred_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nota_cred_ventasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_nota_cred_ventas);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 680, 190));

        txt_monto_credito.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_monto_credito.setForeground(new java.awt.Color(204, 0, 51));
        txt_monto_credito.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_monto_credito.setText("0");
        jPanel2.add(txt_monto_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 140, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel18.setText("Total NC:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 120, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel17.setText("Importe Total:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 90, 30));

        lbl_import_total.setBackground(new java.awt.Color(153, 0, 51));
        lbl_import_total.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_import_total.setForeground(new java.awt.Color(204, 0, 51));
        lbl_import_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_import_total.setText("0");
        jPanel2.add(lbl_import_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 140, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 153));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 250, 10));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 51));
        jLabel22.setText("Entrada en caja >>>");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 150, 30));

        txt_cred_entrada_caja.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_cred_entrada_caja.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_cred_entrada_caja.setText("0");
        txt_cred_entrada_caja.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_cred_entrada_caja.setEnabled(false);
        jPanel2.add(txt_cred_entrada_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 170, 30));

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
        jPanel2.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 30, 20));
        jPanel2.add(lbl_monto_cred, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 350, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if ((txt_nro_venta.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "La descripción o el monto no fueron agregados");

        } else {

            if (JOptionPane.showConfirmDialog(rootPane, "Cancelar comprobante, ¿desea continuar?",
                    "Pagos", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

              
                ///eliminar nota
                eliminarNota();
                  //actualiza saldo devolciones

                for (int i = 0; i < tb_nota_cred_ventas.getRowCount(); i++) {
                    String cod = "", scred = "";
                    cod = tb_nota_cred_ventas.getValueAt(i, 1).toString();
                    scred = tb_nota_cred_ventas.getValueAt(i, 4).toString();

                    actEstadoDevo(cod, scred);
                    eliminar_detalle_devo(cod);
                }
                
                  //actuliza el saldo en ventas
                actEstadoVentas();
                //carga detales en caja
                cargar_Caja();
                JOptionPane.showMessageDialog(null, "Operación exitosa!");

            }

            this.dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_nro_ventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_ventaKeyReleased
        String codigo = txt_nro_venta.getText();

    }//GEN-LAST:event_txt_nro_ventaKeyReleased

    private void txt_nro_ventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_ventaKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            if (txt_nro_venta.getText().length() != 0) {

            } else {

            }
        }
        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txt_nro_ventaKeyPressed

    private void tb_nota_cred_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nota_cred_ventasMouseClicked

    }//GEN-LAST:event_tb_nota_cred_ventasMouseClicked

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        calcular();
        calcularCreditos();
        calcular_entrada_caja();
        calcular_monot_credito();
    }//GEN-LAST:event_btncalcularActionPerformed

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
            java.util.logging.Logger.getLogger(Cancela_pago_credito_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cancela_pago_credito_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cancela_pago_credito_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cancela_pago_credito_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cancela_pago_credito_ventas dialog = new Cancela_pago_credito_ventas(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_import_total;
    private javax.swing.JLabel lbl_monto_cred;
    public static javax.swing.JLabel lbl_serie_pago;
    public static javax.swing.JTable tb_nota_cred_ventas;
    public static javax.swing.JTextField txt_almacen;
    private javax.swing.JTextField txt_cred_entrada_caja;
    private javax.swing.JLabel txt_monto_credito;
    public static javax.swing.JTextField txt_nom_cli_cred;
    public static javax.swing.JTextField txt_nro_venta;
    public static javax.swing.JTextField txt_venta_cre_saldo;
    // End of variables declaration//GEN-END:variables

    public void calcular() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_nota_cred_ventas.getRowCount(); i++) {
            BigDecimal PulidoMonto = ingreso.TransformReales(tb_nota_cred_ventas.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoSActual = ingreso.TransformReales(tb_nota_cred_ventas.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoMonto.add(PulidoSActual).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            tb_nota_cred_ventas.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 4);

            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());
            /*
             txttotal.setText(total);
             lbl_total_amort.setText(total);*/

        }
    }

    void cargar_Caja() {

        String nro_venta = txt_nro_venta.getText();
        String valor = txt_cred_entrada_caja.getText();

        txt_nro_docu.setText(nro_venta);
        txt_des_caja.setText("PAGO PARCIAL DE LA NOTA N°:" + nro_venta);
        lbl_total_gs.setText(valor);
        Caja_caja.btn_calcular.doClick();
        //  Caja_caja.btn_confirmar.doClick();

    }

    public void calcularCreditos() {

        ///
        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_nota_cred_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_nota_cred_ventas.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_monto_credito.setText(subtotal);
        }
    }

    public void calcular_entrada_caja() {

        String totalpor = "0";
        BigDecimal Precio_efec = ingreso.TransformReales(lbl_import_total.getText());
        BigDecimal precio_cheque = ingreso.TransformReales(txt_monto_credito.getText());
        totalpor = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(Precio_efec.subtract(precio_cheque).toString());
        txt_cred_entrada_caja.setText(totalpor);

    }

    public void calcular_monot_credito() {

        String totalpor = "0";
        BigDecimal credito_actual = ingreso.TransformReales(txt_venta_cre_saldo.getText());
        BigDecimal credito_vuelve = ingreso.TransformReales(lbl_import_total.getText());
        totalpor = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(credito_actual.add(credito_vuelve).toString());
        lbl_monto_cred.setText(totalpor);

    }

    ///cargar datos del recibo 
    public void cargarPago(String valor) {
        String mostrar = "SELECT * FROM pago_credito_comun WHERE  seire= '" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_venta.setText(rs.getString(2));
                id_cliente_cre.setText(rs.getString(3));
                txt_nom_cli_cred.setText(rs.getString(4));
                lbl_import_total.setText(rs.getString(5));
                txt_almacen.setText(rs.getString(7));
                lbl_serie_pago.setText(rs.getString(12));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //eliminar nota
    void eliminarNota() {

        String cod = lbl_serie_pago.getText();
        String eliminarSQL = "DELETE FROM pago_credito_comun WHERE seire = '" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //eliminar detalle_devo
    void eliminar_detalle_devo(String cod) {

        String eliminarSQL = "DELETE FROM pago_cred_ventas_devo WHERE id_devo_comun = '" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    ///actualizaciones
    void actEstadoVentas() {
        if (txt_almacen.getText().equals("0000001")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    //  JOptionPane.showMessageDialog(null, "Actualizado");
                    conectar.getInstance().closeConnection(cn);

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }
        }

        //2
        if (txt_almacen.getText().equals("0000002")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_2 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000003")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_3 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000004")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_4 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000005")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_5 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000006")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_6 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000007")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_7 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000008")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_8 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000009")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_9 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000010")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_10 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000011")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_11 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000012")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_12 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000013")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_13 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000014")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_14 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000015")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_15 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000016")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_16 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000017")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_17 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000018")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_18 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000019")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_19 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000020")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_20 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000021")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_21 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000022")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_22 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000023")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_23 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000024")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_24 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000025")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_25 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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
        if (txt_almacen.getText().equals("0000026")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_26 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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

        if (txt_almacen.getText().equals("0000027")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_27 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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

        if (txt_almacen.getText().equals("0000028")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_28 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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

        if (txt_almacen.getText().equals("0000029")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_29 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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

        if (txt_almacen.getText().equals("0000030")) {
            try {
                String monto = lbl_monto_cred.getText();
                String nro = txt_nro_venta.getText();

                String sql = "UPDATE ventas_30 SET monto_cred = '" + monto
                        + "',bool_recibo ='" + bool_ventas
                        + "',estado_ventas ='" + es
                        + "' WHERE num_bol = '" + nro + "'";
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

    //actualiza saldo devoluciones
    void actEstadoDevo(String cod, String monto) {
        if (txt_almacen.getText().equals("0000001")) {
            try {

                String sql = "UPDATE devoluciones SET saldo_devol = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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

                String sql = "UPDATE devoluciones_surc_2 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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

        if (txt_almacen.getText().equals("0000003")) {
            try {

                String sql = "UPDATE devoluciones_surc_3 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000004")) {
            try {

                String sql = "UPDATE devoluciones_surc_4 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000005")) {
            try {

                String sql = "UPDATE devoluciones_surc_5 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000006")) {
            try {

                String sql = "UPDATE devoluciones_surc_6 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000007")) {
            try {

                String sql = "UPDATE devoluciones_surc_7 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000008")) {
            try {

                String sql = "UPDATE devoluciones_surc_8 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000009")) {
            try {

                String sql = "UPDATE devoluciones_surc_9 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000010")) {
            try {

                String sql = "UPDATE devoluciones_surc_10 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000011")) {
            try {

                String sql = "UPDATE devoluciones_surc_11 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000012")) {
            try {

                String sql = "UPDATE devoluciones_surc_12 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000013")) {
            try {

                String sql = "UPDATE devoluciones_surc_13 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000014")) {
            try {

                String sql = "UPDATE devoluciones_surc_14 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000015")) {
            try {

                String sql = "UPDATE devoluciones_surc_15 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000016")) {
            try {

                String sql = "UPDATE devoluciones_surc_16 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000017")) {
            try {

                String sql = "UPDATE devoluciones_surc_17 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000018")) {
            try {

                String sql = "UPDATE devoluciones_surc_18 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000019")) {
            try {

                String sql = "UPDATE devoluciones_surc_19 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000020")) {
            try {

                String sql = "UPDATE devoluciones_surc_20 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000021")) {
            try {

                String sql = "UPDATE devoluciones_surc_21 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000022")) {
            try {

                String sql = "UPDATE devoluciones_surc_22 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000023")) {
            try {

                String sql = "UPDATE devoluciones_surc_23 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000024")) {
            try {

                String sql = "UPDATE devoluciones_surc_24 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000025")) {
            try {

                String sql = "UPDATE devoluciones_surc_25 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000026")) {
            try {

                String sql = "UPDATE devoluciones_surc_26 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000027")) {
            try {

                String sql = "UPDATE devoluciones_surc_27 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000028")) {
            try {

                String sql = "UPDATE devoluciones_surc_28 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000029")) {
            try {

                String sql = "UPDATE devoluciones_surc_29 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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
        if (txt_almacen.getText().equals("0000030")) {
            try {

                String sql = "UPDATE devoluciones_surc_30 SET saldo_cred = '" + monto
                        + "' WHERE cod_dev = '" + cod + "'";
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

    //cargar saldo restante de devoluciones
    //00000001
    public void cargarDev(String valor) {
        String mostrar = "SELECT p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("entrooo");
    }

    //00000001
    public void cargarDev_2(String valor) {
        String mostrar = "SELECT p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_2 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_3(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_3 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_4(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_4 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_5(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_5 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_6(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_6 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //00000001
    public void cargarDev_7(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_7 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_8(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_8 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_9(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_9 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //00000001
    public void cargarDev_10(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_10 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_11(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_11 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_12(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_12 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_13(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_13 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_14(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_14 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_15(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_15 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_16(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_16 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_17(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_17 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_18(String valor) {
        String mostrar = "SELECT p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_18 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(150);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_19(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_19 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_20(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_20 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    //00000001

    public void cargarDev_21(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_21 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_22(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_22 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_23(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_23 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_24(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_24 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_25(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_25 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_26(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_26 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_27(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_27 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_28(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_28 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    //00000001

    public void cargarDev_29(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_29 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //00000001
    public void cargarDev_30(String valor) {
        String mostrar = "SELECT  p.id_devo_comun,p.nro_nota_dev,p.monto_importe,(select d.saldo_devol from devoluciones_surc_30 as d where d.cod_dev=p.nro_nota_dev) as saldo FROM pago_cred_ventas_devo as p  WHERE p.nro_nota_rec='" + valor + "'";
        String[] titulos = {"ID", "Nro Devol", "Importe", "Saldo Créd.", "Saldo Dev."};
        String[] Registros = new String[9];
        DefaultTableModel modelf = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);

                modelf.addRow(Registros);
            }
            tb_nota_cred_ventas.setModel(modelf);

            tb_nota_cred_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_nota_cred_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_nota_cred_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///1

    public void cargarSaldoVenta() {
        String mostrar = "SELECT monto_cred FROM ventas WHERE  num_bol= '" + txt_nro_venta.getText() + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_venta_cre_saldo.setText(rs.getString(1));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Cancela_factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
