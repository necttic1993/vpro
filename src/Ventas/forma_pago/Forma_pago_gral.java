/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.forma_pago;

import static Caja_2.Caja_caja.id_doc_nro;
import static Caja_2.Caja_caja.id_nro_cuenta;
import static Caja_2.Caja_caja.sucursal;
import static Caja_2.Caja_caja.total_doc;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_fecha_principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Forma_pago_gral extends javax.swing.JDialog {

    public Forma_pago_gral(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desing();
        btn_calc.setVisible(false);
        lbl_nro_doc.setText(id_doc_nro);
        lbl_nro_cuenta.setText(id_nro_cuenta);
        lbl_total_gs.setText(total_doc);
        lbl_usu_sucursal.setText(sucursal);

    }

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_forma_pago = new org.jdesktop.swingx.JXComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pagos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_confirma_pago = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lbl_total_gs = new javax.swing.JLabel();
        lbl_total_rec = new javax.swing.JLabel();
        txt_resta_total = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_calc = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lbl_nro_cuenta = new javax.swing.JLabel();
        lbl_usu_sucursal = new javax.swing.JLabel();
        lbl_nro_doc = new javax.swing.JLabel();
        btn_excluir = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagos");
        setIconImage(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_forma_pago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR:", "EFECTIVO", "CHEQUE", "TJ CRÉDITO", "TJ DÉBITO", "GIROS", "TRANSFERENCIAS BANCARIAS", "DEPÓSITOS BANCARIOS", "NOTA DE CRÉDITO" }));
        cb_forma_pago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_forma_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_forma_pagoActionPerformed(evt);
            }
        });
        jPanel1.add(cb_forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 310, 31));

        tb_pagos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_pagos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_pagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Doc.", "Tipo de pago", "Pago contextual", "Clasificación ", "Valor "
            }
        ));
        tb_pagos.setGridColor(new java.awt.Color(255, 255, 255));
        tb_pagos.setRequestFocusEnabled(false);
        tb_pagos.setRowHeight(22);
        jScrollPane1.setViewportView(tb_pagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1060, 330));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/buscar.png"))); // NOI18N
        jButton1.setMnemonic('v');
        jButton1.setToolTipText("Ver listado de Mov. de caja");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 12, 50, 33));

        btn_confirma_pago.setBackground(new java.awt.Color(255, 255, 255));
        btn_confirma_pago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_confirma_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_confirma_pago.setText("Grabar");
        btn_confirma_pago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confirma_pago.setBorderPainted(false);
        btn_confirma_pago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirma_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirma_pagoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_confirma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 450, 120, 50));

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total a Pagar:");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        lbl_total_gs.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_total_gs.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total_gs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total_gs.setText("0");
        jPanel3.add(lbl_total_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 150, 40));

        lbl_total_rec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_total_rec.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total_rec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total_rec.setText("0");
        jPanel3.add(lbl_total_rec, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 170, 40));

        txt_resta_total.setBackground(new java.awt.Color(255, 255, 255));
        txt_resta_total.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_resta_total.setForeground(new java.awt.Color(255, 255, 255));
        txt_resta_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_resta_total.setText("0");
        jPanel3.add(txt_resta_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 190, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Saldo:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 60, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total recibidos:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 120, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1060, 40));

        btn_calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcActionPerformed(evt);
            }
        });
        jPanel1.add(btn_calc, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, -1, 40));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("N° Cuenta:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 80, 30));

        lbl_nro_cuenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_nro_cuenta.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_nro_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 90, 30));

        lbl_usu_sucursal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_usu_sucursal.setText("0000000");
        jPanel1.add(lbl_usu_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 140, 30));

        lbl_nro_doc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_nro_doc.setForeground(new java.awt.Color(204, 0, 0));
        lbl_nro_doc.setText("0");
        jPanel1.add(lbl_nro_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 110, 30));

        btn_excluir.setBackground(new java.awt.Color(255, 255, 255));
        btn_excluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btn_excluir.setMnemonic('e');
        btn_excluir.setToolTipText("Remover pagos agregados");
        btn_excluir.setBorder(null);
        btn_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 60, 45));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("N° Documento:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 110, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setText("Sucursal/Almacén:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirma_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirma_pagoActionPerformed

        int fila = tb_pagos.getSelectedRow();
        if (fila < 0) {
            saved();
            JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una forma de pago válido");
        }
    }//GEN-LAST:event_btn_confirma_pagoActionPerformed

    private void cb_forma_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_forma_pagoActionPerformed
        /*  if ((cb_forma_pago.getSelectedItem().equals("EFECTIVO"))) {
         txt_entra_efect.setEnabled(true);
         txt_entra_tarjeta.setEnabled(false);
         txt_nro_voucher.setEnabled(false);
         txt_entra_tarjeta.setText("0");
         ch_debito.setEnabled(false);
         ch_credito.setEnabled(false);
         txt_nro_cheque.setEnabled(false);
         txt_monto_cheque.setEnabled(false);
         btn_add_banco.setEnabled(false);
         ch_credito.setSelected(false);
         ch_debito.setSelected(false);
         btn_confirma_pago.setBackground(Color.red);
         }
         if ((cb_forma_pago.getSelectedItem().equals("TARJETA"))) {
         txt_entra_efect.setEnabled(false);
         txt_entra_tarjeta.setEnabled(true);
         txt_nro_voucher.setEnabled(true);
         txt_entra_efect.setText("0");
         ch_debito.setEnabled(true);
         ch_credito.setEnabled(true);
         txt_nro_cheque.setEnabled(false);
         txt_monto_cheque.setEnabled(false);
         btn_add_banco.setEnabled(false);
         JOptionPane.showMessageDialog(null, "Seleccione tipo de trajeta");
         btn_confirma_pago.setBackground(Color.red);
         }
         if ((cb_forma_pago.getSelectedItem().equals("MIXTO"))) {
         txt_entra_efect.setEnabled(true);
         txt_entra_tarjeta.setEnabled(true);
         txt_nro_voucher.setEnabled(true);
         txt_entra_tarjeta.setText("0");
         txt_entra_efect.setText("0");
         ch_debito.setEnabled(true);
         ch_credito.setEnabled(true);
         txt_nro_cheque.setEnabled(false);
         txt_monto_cheque.setEnabled(false);
         btn_add_banco.setEnabled(false);
         JOptionPane.showMessageDialog(null, "Seleccione tipo de trajeta");
         btn_confirma_pago.setBackground(Color.red);
         }
         if ((cb_forma_pago.getSelectedItem().equals("CHEQUE"))) {
         txt_entra_efect.setEnabled(false);
         txt_entra_tarjeta.setEnabled(false);
         txt_nro_voucher.setEnabled(false);
         txt_entra_tarjeta.setText("0");
         ch_debito.setEnabled(false);
         ch_credito.setEnabled(false);
         txt_nro_cheque.setEnabled(true);
         txt_monto_cheque.setEnabled(true);
         btn_add_banco.setEnabled(true);
         ch_credito.setSelected(false);
         ch_debito.setSelected(false);
         btn_confirma_pago.setBackground(Color.red);
         }*/
    }//GEN-LAST:event_cb_forma_pagoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((cb_forma_pago.getSelectedItem().equals("SELECCIONAR:"))) {
            JOptionPane.showMessageDialog(null, ("Seleccione una Opción"));
        }

        if ((cb_forma_pago.getSelectedItem().equals("EFECTIVO"))) {
            Modulo_efectivo ME;
            ME = new Modulo_efectivo(new javax.swing.JDialog(), true);
            ME.setVisible(true);
        }
        if ((cb_forma_pago.getSelectedItem().equals("CHEQUE"))) {
            Modulo_cheque MCH;
            MCH = new Modulo_cheque(new javax.swing.JDialog(), true);
            MCH.setVisible(true);
        }
        if ((cb_forma_pago.getSelectedItem().equals("TJ CRÉDITO"))) {
            Modulo_TJCRED MTJC;
            MTJC = new Modulo_TJCRED(new javax.swing.JDialog(), true);
            MTJC.setVisible(true);
        }
        if ((cb_forma_pago.getSelectedItem().equals("TJ DÉBITO"))) {
            Modulo_DEBTJ MTJD;
            MTJD = new Modulo_DEBTJ(new javax.swing.JDialog(), true);
            MTJD.setVisible(true);
        }
        if ((cb_forma_pago.getSelectedItem().equals("GIROS"))) {
            Modulo_Giros MG;
            MG = new Modulo_Giros(new javax.swing.JDialog(), true);
            MG.setVisible(true);
        }
        if ((cb_forma_pago.getSelectedItem().equals("TRANSFERENCIAS BANCARIAS"))) {
            Modulo_tRANSb MTB;
            MTB = new Modulo_tRANSb(new javax.swing.JDialog(), true);
            MTB.setVisible(true);
        }
        if ((cb_forma_pago.getSelectedItem().equals("DEPÓSITOS BANCARIOS"))) {
            Modulo_DepB MDB;
            MDB = new Modulo_DepB(new javax.swing.JDialog(), true);
            MDB.setVisible(true);
        }
       


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcActionPerformed

        calcular_rec();
        calcular_diferencia();
    }//GEN-LAST:event_btn_calcActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tb_pagos.getModel();
        int fila = tb_pagos.getSelectedRow();
        if (fila >= 0) {
            model.removeRow(fila);
            calcular_rec();
            calcular_diferencia();
        }
        if (fila == 0) {
            lbl_total_rec.setText("0");
            calcular_rec();
            calcular_diferencia();
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

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
            java.util.logging.Logger.getLogger(Forma_pago_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forma_pago_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forma_pago_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forma_pago_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Forma_pago_gral dialog = new Forma_pago_gral(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_calc;
    private javax.swing.JButton btn_confirma_pago;
    private javax.swing.JButton btn_excluir;
    private org.jdesktop.swingx.JXComboBox cb_forma_pago;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_nro_cuenta;
    private javax.swing.JLabel lbl_nro_doc;
    public static javax.swing.JLabel lbl_total_gs;
    private javax.swing.JLabel lbl_total_rec;
    private javax.swing.JLabel lbl_usu_sucursal;
    public static javax.swing.JTable tb_pagos;
    private javax.swing.JLabel txt_resta_total;
    // End of variables declaration//GEN-END:variables

    void desing() {

        tb_pagos.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_pagos.getColumnModel().getColumn(1).setPreferredWidth(130);
        tb_pagos.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb_pagos.getColumnModel().getColumn(3).setPreferredWidth(100);
        tb_pagos.getColumnModel().getColumn(4).setPreferredWidth(100);

    }

    public void calcular_rec() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_pagos.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_pagos.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            lbl_total_rec.setText(subtotal);

        }
    }

    public void calcular_diferencia() {

        String totalpor = "0";
        BigDecimal Precio_efec = ingreso.TransformReales(lbl_total_rec.getText());
        BigDecimal total = ingreso.TransformReales(lbl_total_gs.getText());
        totalpor = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(Precio_efec.subtract(total).toString());

        txt_resta_total.setText(totalpor);

    }

    public void saved() {

        // byte[] imagen = cam.getBytes();
        for (int i = 0; i < tb_pagos.getRowCount(); i++) {
            String sql = "";
            String nro_doc = tb_pagos.getValueAt(i, 0).toString();
            String tipo_pago = tb_pagos.getValueAt(i, 1).toString();
            String pago_cont = tb_pagos.getValueAt(i, 2).toString();
            String clas = tb_pagos.getValueAt(i, 3).toString();
            String monto = tb_pagos.getValueAt(i, 4).toString();
            String fecha_det_con = lbl_fecha_hoy.getText();
            String fecha_vista = lbl_fecha_principal.getText();
            String user = lbl_usu_nom.getText();
            String nro_doc_pag = lbl_nro_doc.getText();
            String nro_cuenta_pag = lbl_nro_cuenta.getText();
            String almacen = lbl_usu_sucursal.getText();

            sql = "INSERT INTO forma_pago (nro_doc,tipo_pago,pago_cont,clas,monto,fecha_det_con,fecha_vista,user,nro_doc_pag,nro_cuenta_pag,pago_surc) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, nro_doc);
                pst.setString(2, tipo_pago);
                pst.setString(3, pago_cont);
                pst.setString(4, clas);
                pst.setString(5, monto);
                pst.setString(6, fecha_det_con);
                pst.setString(7, fecha_vista);
                pst.setString(8, user);
                pst.setString(9, nro_doc_pag);
                pst.setString(10, nro_cuenta_pag);
                pst.setString(11, almacen);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {

                    this.dispose();

                }

            } catch (SQLException ex) {

                Logger.getLogger(Forma_pago_gral.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
