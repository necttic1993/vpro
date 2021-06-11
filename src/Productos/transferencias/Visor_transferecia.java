/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.transferencias;

import Conexion_DB.conectar;
import static Loggin_Principal.Principal.lbl_usu_almacen;
import static Productos.transferencias.Principal_transferencia.cod_trans_detalle;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Visor_transferecia extends javax.swing.JDialog {

    DefaultTableModel model;

    public Visor_transferecia(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // visor_recepcion   visor = new visor_recepcion(new javax.swing.JDialog(), true);
        // txtcod.setText(cod);

        cargar(cod_trans_detalle);
        cargarTxt(cod_trans_detalle);

    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM transf_detalles WHERE  num_transf='" + valor + "'";
        String[] titulos = {"N°", "Id Producto", "Descripción", "Precio Unitario", "Cantidad", "Precio Venta"};
        String[] Registros = new String[7];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(4);
                Registros[5] = rs.getString(6);

                model.addRow(Registros);
            }
            tb_visor_recep.setModel(model);

            tb_visor_recep.getColumnModel().getColumn(0).setPreferredWidth(93);
            tb_visor_recep.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_visor_recep.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_visor_recep.getColumnModel().getColumn(3).setPreferredWidth(130);
            tb_visor_recep.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_visor_recep.getColumnModel().getColumn(5).setPreferredWidth(130);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_transferecia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM transf_stock WHERE  cod_tran='" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_transfe.setText(rs.getString(1));
                lbl_alma_origen.setText(rs.getString(2));
                lbl_alma_ori.setText(rs.getString(3));
                lbl_alma_destino.setText(rs.getString(4));
                lbl_alma_des.setText(rs.getString(5));
                lbl_des.setText(rs.getString(6));
                valot_total.setText(rs.getString(8));
                txt_fecha.setText(rs.getString(9));
                txt_usuario.setText(rs.getString(11));
                lbl_total_items.setText(rs.getString(7));
                lbl_status.setText(rs.getString(12));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Visor_transferecia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_des = new javax.swing.JLabel();
        btn_destino = new javax.swing.JButton();
        lbl_status = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_visor_recep = new javax.swing.JTable();
        lbl_alma_des = new javax.swing.JLabel();
        lbl_alma_ori = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        valot_total = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        txt_nro_transfe = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_total_items = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_salir = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lbl_alma_destino = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_alma_origen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Transferencia");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText(" Nº:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Usuario:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 30));

        lbl_des.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 630, 30));

        btn_destino.setBackground(new java.awt.Color(255, 255, 255));
        btn_destino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_destino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_png/png/cambio.png"))); // NOI18N
        btn_destino.setText("Confirmar");
        btn_destino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_destinoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 130, 50));

        lbl_status.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_status.setForeground(new java.awt.Color(0, 0, 204));
        jPanel2.add(lbl_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 180, 30));

        tb_visor_recep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_visor_recep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_visor_recep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_visor_recepMouseClicked(evt);
            }
        });
        tb_visor_recep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_visor_recepKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_visor_recep);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 890, 250));

        lbl_alma_des.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_alma_des.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_alma_des.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lbl_alma_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 460, 30));

        lbl_alma_ori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_alma_ori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(lbl_alma_ori, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 470, 30));

        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 190, 30));

        valot_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valot_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valot_total.setToolTipText("");
        valot_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(valot_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 150, 30));

        txt_fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 90, 30));

        txt_nro_transfe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_nro_transfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Almacén Destino:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Almacén Origen:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        lbl_total_items.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_total_items.setForeground(new java.awt.Color(0, 102, 51));
        jPanel2.add(lbl_total_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 70, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Descripción:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 30));

        txt_salir.setBorder(null);
        txt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salirActionPerformed(evt);
            }
        });
        txt_salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_salirKeyPressed(evt);
            }
        });
        jPanel2.add(txt_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 190, 0));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Valor Total:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 80, 30));

        lbl_alma_destino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_alma_destino.setForeground(new java.awt.Color(153, 0, 0));
        lbl_alma_destino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_alma_destino.setText("0000000");
        jPanel2.add(lbl_alma_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 80, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Total Items:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 80, 30));

        lbl_alma_origen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_alma_origen.setForeground(new java.awt.Color(0, 153, 51));
        lbl_alma_origen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_alma_origen.setText("0000000");
        jPanel2.add(lbl_alma_origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 80, 30));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 880, 170));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Fecha :");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, 30));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Estado:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_visor_recepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_visor_recepKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepKeyReleased

    private void tb_visor_recepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_visor_recepMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepMouseClicked

    private void txt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salirActionPerformed

    private void txt_salirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_salirKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txt_salirKeyPressed

    private void btn_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_destinoActionPerformed
        if (lbl_status.getText().equals("CONFIRMADA")) {
            JOptionPane.showMessageDialog(null, "Transferencia ya esta confirmada");
        } else {
            if (lbl_usu_almacen.getText().equals(lbl_alma_destino.getText()) || lbl_usu_almacen.getText().equals("TODOS")) {

                if ((lbl_alma_destino.getText().equals("0000001"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }

                if ((lbl_alma_destino.getText().equals("0000002"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_2(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000003"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_3(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000004"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_4(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000005"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_5(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }

                ///new deposito
                if ((lbl_alma_destino.getText().equals("0000006"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_6(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000007"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_7(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000008"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_8(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000009"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_9(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000010"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_10(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000011"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_11(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000012"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_12(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000013"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_13(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000014"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_14(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000015"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_15(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000016"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_16(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000017"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_17(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000018"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_18(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000019"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_19(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000020"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_20(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000021"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_21(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000022"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_22(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000023"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_23(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000024"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_24(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000025"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_25(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000026"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_26(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000027"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_27(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000028"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_28(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }
                if ((lbl_alma_destino.getText().equals("0000029"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_29(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }

                if ((lbl_alma_destino.getText().equals("0000030"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock_30(capcod, capcan);
                        actTrans();

                    }
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }

            } else {

                JOptionPane.showMessageDialog(null, "Transferencia no autorizada,Verifique");

            }
        }

    }//GEN-LAST:event_btn_destinoActionPerformed

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
            java.util.logging.Logger.getLogger(Visor_transferecia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visor_transferecia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visor_transferecia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visor_transferecia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Visor_transferecia dialog = new Visor_transferecia(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_destino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_alma_des;
    private javax.swing.JLabel lbl_alma_destino;
    private javax.swing.JLabel lbl_alma_ori;
    private javax.swing.JLabel lbl_alma_origen;
    private javax.swing.JLabel lbl_des;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_total_items;
    public static javax.swing.JTable tb_visor_recep;
    private javax.swing.JLabel txt_fecha;
    public static javax.swing.JLabel txt_nro_transfe;
    private javax.swing.JTextField txt_salir;
    private javax.swing.JLabel txt_usuario;
    private javax.swing.JLabel valot_total;
    // End of variables declaration//GEN-END:variables

    void eliminarPre() {

        String cod = txt_nro_transfe.getText();
        String eliminarSQL = "DELETE FROM * WHERE num_bol = '" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            JOptionPane.showMessageDialog(null, "Borrado");

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void limpiar() {
        txt_nro_transfe.setText("");
        txt_usuario.setText("");
        lbl_alma_ori.setText("");
        lbl_alma_des.setText("");
        lbl_des.setText("");
        txt_fecha.setText("");
        valot_total.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_visor_recep.getModel();
        int a = tb_visor_recep.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    void AumnetarStock(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(5);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_2(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(25);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_2='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_3(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(26);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_3='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_4(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(27);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_4='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_5(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(28);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_5='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_6(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(29);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_6='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_7(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(30);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_7='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_8(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(31);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_8='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_9(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(32);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_9='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_10(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(33);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_10='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_11(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(34);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_11='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_12(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(35);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_12='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_13(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(36);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_13='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_14(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(37);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_14='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_15(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(38);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_15='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_16(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(39);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_16='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_17(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(40);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_17='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_18(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(41);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_18='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_19(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(42);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_19='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_20(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(43);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_20='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_21(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(44);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_21='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_22(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(45);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_22='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_23(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(46);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_23='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_24(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(47);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_24='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_25(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(48);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_25='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_26(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(49);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_26='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_27(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(50);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_27='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_28(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(51);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_28='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_29(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(52);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_29='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void AumnetarStock_30(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(53);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_stock_30='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void actTrans() {

        try {
            String id = txt_nro_transfe.getText();
            String saldo = ("CONFIRMADA");

            String sql = "UPDATE transf_stock SET estado_tran = '" + saldo
                    + "' WHERE cod_tran = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                // JOptionPane.showMessageDialog(null, "Actualizado");
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

}
