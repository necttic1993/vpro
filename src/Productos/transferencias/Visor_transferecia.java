/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.transferencias;

import Conexion_DB.conectar;
import Loggin_Principal.Principal;
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
        panel_conf_transfe.setVisible(false);
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            visor_trans.setBackground(new java.awt.Color(69, 84, 92));

        }
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
                lbl_tipo_transferencia.setText(rs.getString(13));

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
        visor_trans = new javax.swing.JPanel();
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
        lbl_tipo_transferencia = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btn_eliminar_trans = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel_conf_transfe = new javax.swing.JPanel();
        btn_descontar = new javax.swing.JButton();
        btn_origen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Transferencia");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        visor_trans.setBackground(new java.awt.Color(255, 255, 255));
        visor_trans.setForeground(new java.awt.Color(255, 255, 255));
        visor_trans.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText(" Nº:");
        visor_trans.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Usuario:");
        visor_trans.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 30));

        lbl_des.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        visor_trans.add(lbl_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 590, 30));

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
        visor_trans.add(btn_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 130, 50));

        lbl_status.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_status.setForeground(new java.awt.Color(0, 0, 204));
        visor_trans.add(lbl_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 180, 30));

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

        visor_trans.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 960, 300));

        lbl_alma_des.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_alma_des.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_alma_des.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        visor_trans.add(lbl_alma_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 460, 30));

        lbl_alma_ori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_alma_ori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        visor_trans.add(lbl_alma_ori, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 470, 30));

        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        visor_trans.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 190, 30));

        valot_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valot_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valot_total.setToolTipText("");
        valot_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        visor_trans.add(valot_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 150, 30));

        txt_fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        visor_trans.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 90, 30));

        txt_nro_transfe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        visor_trans.add(txt_nro_transfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Almacén Destino:");
        visor_trans.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Almacén Origen:");
        visor_trans.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        lbl_total_items.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_total_items.setForeground(new java.awt.Color(0, 102, 51));
        visor_trans.add(lbl_total_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, 70, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Descripción:");
        visor_trans.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 30));

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
        visor_trans.add(txt_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 190, 0));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Valor Total:");
        visor_trans.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 80, 30));

        lbl_alma_destino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_alma_destino.setForeground(new java.awt.Color(153, 0, 0));
        lbl_alma_destino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_alma_destino.setText("0000000");
        visor_trans.add(lbl_alma_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 80, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Total Items:");
        visor_trans.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 500, 80, 30));

        lbl_alma_origen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_alma_origen.setForeground(new java.awt.Color(0, 153, 51));
        lbl_alma_origen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_alma_origen.setText("0000000");
        visor_trans.add(lbl_alma_origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 80, 30));

        lbl_tipo_transferencia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_tipo_transferencia.setForeground(new java.awt.Color(153, 0, 0));
        visor_trans.add(lbl_tipo_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 50, 30));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Estado:");
        visor_trans.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 30));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("Fecha :");
        visor_trans.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, 30));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("V/T:");
        visor_trans.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 30, 30));

        btn_eliminar_trans.setBackground(new java.awt.Color(255, 255, 255));
        btn_eliminar_trans.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_eliminar_trans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btn_eliminar_trans.setText("Eliminar");
        btn_eliminar_trans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_transActionPerformed(evt);
            }
        });
        visor_trans.add(btn_eliminar_trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 130, 50));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        visor_trans.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 950, 170));

        panel_conf_transfe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_descontar.setText("destino");
        btn_descontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_descontarActionPerformed(evt);
            }
        });
        panel_conf_transfe.add(btn_descontar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        btn_origen.setText("origen");
        btn_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_origenActionPerformed(evt);
            }
        });
        panel_conf_transfe.add(btn_origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        visor_trans.add(panel_conf_transfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 270, 40));

        jPanel1.add(visor_trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

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

                btn_destino.setEnabled(false);
                if ((lbl_alma_destino.getText().equals("0000001"))) {
                    String capcod = "", capcan = "";
                    for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                        capcod = tb_visor_recep.getValueAt(i, 1).toString();
                        capcan = tb_visor_recep.getValueAt(i, 4).toString();
                        AumnetarStock(capcod, capcan);

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();

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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
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

                    }
                    actTrans();
                    JOptionPane.showMessageDialog(null, "Transferencia confirmada " + "" + lbl_alma_destino.getText());
                    Principal_transferencia.btn_cargar_trans.doClick();
                    this.dispose();
                }

            } else {

                JOptionPane.showMessageDialog(null, "Transferencia no autorizada,Verifique");

            }
        }

    }//GEN-LAST:event_btn_destinoActionPerformed

    private void btn_eliminar_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_transActionPerformed
        if (lbl_status.getText().equals("CONFIRMADA")) {
            JOptionPane.showMessageDialog(null, "Transferencia ya esta confirmada");
        } else {

            if (lbl_tipo_transferencia.getText().equals("V")) {

            } else if (lbl_tipo_transferencia.getText().equals("T")) {

                if (Principal_transferencia.lbl_ambiente_transfer.getText().equals("0")) {

                    if (JOptionPane.showConfirmDialog(rootPane, "Desea eliminar la transferencia" + ", ¿desea continuar?",
                            "Eliminar", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        btn_origen.doClick();
                        btn_descontar.doClick();
                        eliminarTansferencia();
                        JOptionPane.showMessageDialog(null, "Transferencia eliminada " + "" + lbl_alma_destino.getText());
                        Principal_transferencia.btn_cargar_trans.doClick();
                        this.dispose();
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Función no autorizada,Verifique");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Transferencia no definida");
            }
        }
    }//GEN-LAST:event_btn_eliminar_transActionPerformed

    private void btn_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_origenActionPerformed
        if ((lbl_alma_origen.getText().equals("0000001"))) {
            String capcod = "", capcan = "";
            //devolver el stock al origen
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock(capcod, capcan);

            }

        }

        if ((lbl_alma_origen.getText().equals("0000002"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_2(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000003"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_3(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000004"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_4(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000005"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_5(capcod, capcan);

            }

        }

        ///new deposito
        if ((lbl_alma_origen.getText().equals("0000006"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_6(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000007"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_7(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000008"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_8(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000009"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_9(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000010"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_10(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000011"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_11(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000012"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_12(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000013"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_13(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000014"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_14(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000015"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_15(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000016"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_16(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000017"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_17(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000018"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_18(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000019"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_19(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000020"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_20(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000021"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_21(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000022"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_22(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000023"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_23(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000024"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_24(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000025"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_25(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000026"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_26(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000027"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_27(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000028"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_28(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000029"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_29(capcod, capcan);

            }

        }

        if ((lbl_alma_origen.getText().equals("0000030"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_30(capcod, capcan);

            }

        }
        //news

        if ((lbl_alma_origen.getText().equals("0000031"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_31(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000032"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_32(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000033"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_33(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000034"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_34(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000035"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_35(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000036"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_36(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000037"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_37(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000038"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_38(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000039"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_39(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000040"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_40(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000041"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_41(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000042"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_42(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000043"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_43(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000044"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_44(capcod, capcan);

            }

        }
        if ((lbl_alma_origen.getText().equals("0000045"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                AumnetarStock_45(capcod, capcan);

            }

        }
    }//GEN-LAST:event_btn_origenActionPerformed

    private void btn_descontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_descontarActionPerformed
        /*   if ((lbl_alma_destino.getText().equals("0000001"))) {
         String capcod = "", capcan = "";
         //devolver el stock al origen
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock(capcod, capcan);

         }

         }

         if ((lbl_alma_destino.getText().equals("0000002"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_2(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000003"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_3(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000004"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_4(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000005"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_5(capcod, capcan);

         }

         }

         ///new deposito
         if ((lbl_alma_destino.getText().equals("0000006"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_6(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000007"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_7(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000008"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_8(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000009"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_9(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000010"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_10(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000011"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_11(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000012"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_12(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000013"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_13(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000014"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_14(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000015"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_15(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000016"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_16(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000017"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_17(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000018"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_18(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000019"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_19(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000020"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_20(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000021"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_21(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000022"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_22(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000023"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_23(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000024"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_24(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000025"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_25(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000026"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_26(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000027"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_27(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000028"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_28(capcod, capcan);

         }

         }
         if ((lbl_alma_destino.getText().equals("0000029"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_29(capcod, capcan);

         }

         }

         if ((lbl_alma_destino.getText().equals("0000030"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
         capcod = tb_visor_recep.getValueAt(i, 1).toString();
         capcan = tb_visor_recep.getValueAt(i, 4).toString();
         descontarStock_30(capcod, capcan);

         }

         }*/
    }//GEN-LAST:event_btn_descontarActionPerformed

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
    private javax.swing.JButton btn_descontar;
    private javax.swing.JButton btn_destino;
    private javax.swing.JButton btn_eliminar_trans;
    private javax.swing.JButton btn_origen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_alma_des;
    private javax.swing.JLabel lbl_alma_destino;
    private javax.swing.JLabel lbl_alma_ori;
    private javax.swing.JLabel lbl_alma_origen;
    private javax.swing.JLabel lbl_des;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_tipo_transferencia;
    private javax.swing.JLabel lbl_total_items;
    private javax.swing.JPanel panel_conf_transfe;
    public static javax.swing.JTable tb_visor_recep;
    private javax.swing.JLabel txt_fecha;
    public static javax.swing.JLabel txt_nro_transfe;
    private javax.swing.JTextField txt_salir;
    private javax.swing.JLabel txt_usuario;
    private javax.swing.JLabel valot_total;
    private javax.swing.JPanel visor_trans;
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
        String cap = "";
        String consul = "SELECT pro_cant FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_2(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_2 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_2='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_3(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_3 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_3='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_4(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_4 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_4='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_5(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_5 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_5='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_6(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_6 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_6='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_7(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_7 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_7='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_8(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_8 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_8='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_9(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_9 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_9='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_10(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_10 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_10='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_11(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_11 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_11='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_12(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_12 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_12='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_13(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_13 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_13='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_14(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_14 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_14='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_15(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_15 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_15='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_16(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_16 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_16='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_17(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_17 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_17='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_18(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_18 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_18='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_19(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_19 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_19='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_20(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_20 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_20='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_21(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_21 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_21='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_22(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_22 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_22='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_23(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_23 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_23='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_24(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_24 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_24='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_25(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_25 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_25='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_26(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_26 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_26='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_27(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_27 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_27='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_28(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_28 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_28='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_29(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_29 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_29='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_30(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_30 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_30='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    ///news
    void AumnetarStock_31(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_31 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_31='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_32(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_32 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_32='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_33(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_33 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_33='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_34(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_34 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_34='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_35(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_35 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_35='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_36(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_36 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_36='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_37(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_37 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_37='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_38(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_38 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_38='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_39(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_39 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_39='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_40(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_40 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_40='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_41(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_41 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_41'" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_42(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_42 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_42='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_43(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_43 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_43='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_44(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_44 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_44'" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

    void AumnetarStock_45(String codi, String can) {
        String cap = "";
        String consul = "SELECT pro_stock_45 FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(1);
            }
            ///suma el stock
            int desfinal = Integer.parseInt(cap) + Integer.parseInt(can);
            String modi = "UPDATE tienda_productos SET pro_stock_45='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
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

    ///descuenta  stock  a la tienda destino 
   /* void descontarStock(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException e) {
     }
     }

     void descontarStock_2(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_2='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_3(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_3='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_4(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_4='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_5(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_5='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     ///new deposito
     void descontarStock_6(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_6='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_7(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_7='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_8(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_8='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_9(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_9='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_10(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_10='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_11(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_11='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_12(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_12='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_13(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_13='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_14(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_14='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_15(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_15='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_16(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_16='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_17(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_17='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_18(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_18='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_19(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_19='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_20(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_20='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_21(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_21='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_22(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_22='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_23(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_23='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_24(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_24='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_25(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_25='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_26(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_26='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_27(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_27='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_28(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_28='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_29(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_29='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }

     void descontarStock_30(String codi, String can) {
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
     desfinal = Integer.parseInt(cap) - des;
     String modi = "UPDATE tienda_productos SET pro_stock_30='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     Connection cn = conectar.getInstance().getConnection();

     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     conectar.getInstance().closeConnection(cn);

     } catch (Exception e) {
     }
     }*/
    void eliminarTansferencia() {

        try {

            try {
                String cod = txt_nro_transfe.getText();
                String eliminarSQL = "DELETE FROM transf_stock WHERE cod_tran = '" + cod + "'";
                Connection cn = conectar.getInstance().getConnection();
                PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

}
