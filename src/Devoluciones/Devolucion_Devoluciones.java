/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devoluciones;

import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author user
 */
public class Devolucion_Devoluciones extends javax.swing.JDialog {

    /**
     * Creates new form facturacion
     *
     * @param parent
     */
    public Devolucion_Devoluciones(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        codigos();
        btn_buscar.setVisible(false);
        btncalcular.setVisible(false);
        txt_cli_nom.setDisabledTextColor(Color.black);
        txt_des.setDocument(new machusculas());
        ch_generar_stock.setSelected(true);
        tb_factura_dev.getColumnModel().getColumn(0).setPreferredWidth(90);
        tb_factura_dev.getColumnModel().getColumn(1).setPreferredWidth(330);
        tb_factura_dev.getColumnModel().getColumn(2).setPreferredWidth(130);
        tb_factura_dev.getColumnModel().getColumn(3).setPreferredWidth(83);
        tb_factura_dev.getColumnModel().getColumn(4).setPreferredWidth(130);

    }

    public static String cod_pro_mod_dev = "";
    public static String cant_pro_mod_dev = "";
    public static String stock_actual_mod_dev = "";
    public static String stock_pre_mod_dev = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_factura_dev = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_cod_cli = new javax.swing.JTextField();
        txt_cli_nom = new javax.swing.JTextField();
        txt_cod = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lbl_cod = new javax.swing.JLabel();
        txt_des = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblcanpro = new javax.swing.JLabel();
        btneli = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ch_generar_stock = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Devolución de Ventas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_factura_dev = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_factura_dev.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_factura_dev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio Unitario", "Cantidad", "Precio Total"
            }
        ));
        tb_factura_dev.setGridColor(new java.awt.Color(255, 255, 255));
        tb_factura_dev.setRowHeight(22);
        tb_factura_dev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_factura_devKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_factura_dev);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 910, 320));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Número de Venta :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Nombre del Cliente :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Descripción:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        txt_cod_cli.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod_cli.setEnabled(false);
        txt_cod_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_cliActionPerformed(evt);
            }
        });
        txt_cod_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_cliKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cod_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 90, 30));

        txt_cli_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cli_nom.setEnabled(false);
        txt_cli_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_nomActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cli_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 480, 30));

        txt_cod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_cod.setEnabled(false);
        txt_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codActionPerformed(evt);
            }
        });
        txt_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 9, 140, 32));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("N° Doc:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 10, 50, 30));

        lbl_cod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_cod.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cod.setText("0000001");
        lbl_cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 120, 30));
        jPanel1.add(txt_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 430, 30));

        btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 50, 32));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 9, 50, 32));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Items:");

        lblcanpro.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblcanpro.setForeground(new java.awt.Color(255, 255, 255));
        lblcanpro.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblcanpro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblcanpro, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 130, 40));

        btneli.setBackground(new java.awt.Color(255, 255, 255));
        btneli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btneli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btneli.setMnemonic('e');
        btneli.setToolTipText("Remover Productos ALT+E");
        btneli.setBorder(null);
        btneli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });
        jPanel1.add(btneli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 60, 40));

        btncalcular.setBackground(new java.awt.Color(255, 255, 255));
        btncalcular.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btncalcular.setMnemonic('c');
        btncalcular.setToolTipText("Calcular ALT+C");
        btncalcular.setBorder(new javax.swing.border.MatteBorder(null));
        btncalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        jPanel1.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 40, 20));

        btnven.setBackground(new java.awt.Color(255, 255, 255));
        btnven.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnven.setMnemonic('g');
        btnven.setText("Grabar");
        btnven.setToolTipText("Grabar  ALT+G");
        btnven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });
        jPanel1.add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 130, 50));

        btn_salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_salir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/login.png"))); // NOI18N
        btn_salir.setMnemonic('s');
        btn_salir.setText("Salir");
        btn_salir.setToolTipText("Salir");
        btn_salir.setBorder(null);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        btn_salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_salirKeyReleased(evt);
            }
        });
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 130, 50));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ajust.png"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, 60, 40));

        ch_generar_stock.setBackground(new java.awt.Color(0, 0, 153));
        ch_generar_stock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_generar_stock.setForeground(new java.awt.Color(255, 255, 255));
        ch_generar_stock.setText("Devolver Stock ");
        ch_generar_stock.setContentAreaFilled(false);
        ch_generar_stock.setOpaque(true);
        ch_generar_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_generar_stockActionPerformed(evt);
            }
        });
        jPanel1.add(ch_generar_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 130, 30));

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL :");

        txttotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttotal.setText("0");
        txttotal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txttotal.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 270, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/lapiz_editar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 60, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        calcular();
        // calcularMoneda();
        calcularCantidadPro();

    }//GEN-LAST:event_btncalcularActionPerformed

    private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
        for (int i = 0; i < Devolucion_Devoluciones.tb_factura_dev.getRowCount(); i++) {
            DefaultTableModel model = (DefaultTableModel) tb_factura_dev.getModel();
            int fila = tb_factura_dev.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);
                btncalcular.doClick();
                System.out.println("1");
            }
            if (fila == 0) {

                txttotal.setText("0");

            }
            btncalcular.doClick();

        }

    }//GEN-LAST:event_btneliActionPerformed

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed

        if ((txt_cod.getText().equals("")) || (txttotal.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
        } else {
            btnven.setEnabled(false);

            devolucion();

            DefaultTableModel modelo = (DefaultTableModel) tb_factura_dev.getModel();
            int a = tb_factura_dev.getRowCount() - 1;
            int i;
            for (i = a; i >= 0; i--) {
                modelo.removeRow(i);
            }
            codigos();
            txt_cod_cli.setText("");
            txt_cli_nom.setText("");
            lblcanpro.setText("0");
            txttotal.setText("0");
            txt_cod.setText("");
            txt_des.setText("");
        }

        txt_cod.requestFocus();
        Principal_devoluciones.btn_cargar_datos.doClick();
        btnven.setEnabled(true);
    }//GEN-LAST:event_btnvenActionPerformed

    private void txt_cod_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_cliActionPerformed

    private void txt_cli_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_nomActionPerformed

    private void txt_cod_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_cliKeyPressed

    }//GEN-LAST:event_txt_cod_cliKeyPressed

    private void txt_codKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            if (txt_cod.getText().length() != 0) {
                btn_buscar.doClick();
            } else {
                Lista_ventas_canc lisv;
                lisv = new Lista_ventas_canc(new javax.swing.JDialog(), true);
                lisv.setVisible(true);

            }
        }
        if (Tecla == KeyEvent.VK_ESCAPE) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir?",
                    "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.dispose();
                Principal_devoluciones.txt_bus.requestFocus();
            }

        }
    }//GEN-LAST:event_txt_codKeyPressed

    private void tb_factura_devKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_factura_devKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

            btncalcular.doClick();
            JOptionPane.showMessageDialog(null, "Recalculando");
        }

    }//GEN-LAST:event_tb_factura_devKeyPressed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        cargar(txt_cod.getText());
        cargarTxt(txt_cod.getText());
        btncalcular.doClick();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txt_cod.setText("");
        txt_cod_cli.setText("");
        txt_cli_nom.setText("");
        Selec_mode_dev_comun lisv;
        lisv = new Selec_mode_dev_comun(new javax.swing.JDialog(), true);
        lisv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_salirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_salirKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {

            btn_salir.doClick();

        }
    }//GEN-LAST:event_btn_salirKeyReleased

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir?",
                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btn_salirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Productos_Dev_comun prod;
        prod = new Productos_Dev_comun(new javax.swing.JDialog(), true);
        prod.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ch_generar_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_generar_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_generar_stockActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filasel = tb_factura_dev.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro válido");
        } else {

            int filaModi = tb_factura_dev.getSelectedRow();
            cod_pro_mod_dev = (String) tb_factura_dev.getValueAt(filaModi, 0);
            stock_pre_mod_dev = (String) tb_factura_dev.getValueAt(filaModi, 2);
            cant_pro_mod_dev = (String) tb_factura_dev.getValueAt(filaModi, 3);
            stock_actual_mod_dev = (String) tb_factura_dev.getValueAt(filaModi, 4);

            Ajuste_nota_cantidad_devol an;
            an = new Ajuste_nota_cantidad_devol(new javax.swing.JDialog(), true);
            an.setVisible(true);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Devolucion_Devoluciones.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Devolucion_Devoluciones dialog = new Devolucion_Devoluciones(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_salir;
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnven;
    public static javax.swing.JCheckBox ch_generar_stock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbl_cod;
    public static javax.swing.JLabel lblcanpro;
    public static javax.swing.JTable tb_factura_dev;
    public static javax.swing.JTextField txt_cli_nom;
    public static javax.swing.JTextField txt_cod;
    public static javax.swing.JTextField txt_cod_cli;
    private javax.swing.JTextField txt_des;
    public static javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables

    public void calcular() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_factura_dev.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_factura_dev.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_factura_dev.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            // iva = ingreso.TransformReales(subtotal).divide(ingreso.TransformReales("11"), 2, RoundingMode.HALF_UP).toString();
            //   txt_nac.setText(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(iva)));
            tb_factura_dev.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 4);
            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            txttotal.setText(total);

            // txTSubtotal.setText(subtotal);
        }
    }//FIN METODO public vo

    void ajustartarstock(String codi, String can) {
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

    void devolucion() {
        codigos();
        String InsertarSQL = "INSERT INTO devoluciones (cod_dev,cod_venta_dev,cod_cli_dev,nom_cli_dev,des_dev,items_dev,total_dev,fecha_dev,user_dev,estado_dev,saldo_devol) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String num_dev = lbl_cod.getText();
        String num_vent = txt_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();
        String des_dev = txt_des.getText();
        String items = lblcanpro.getText();
        String total_dev = txttotal.getText();
        String fecha = Principal.lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String estado = ("FINALIZADA");
        String saldo_dev = txttotal.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, num_dev);
            pst.setString(2, num_vent);
            pst.setString(3, cod_cli);
            pst.setString(4, nom_cli);
            pst.setString(5, des_dev);
            pst.setString(6, items);
            pst.setString(7, total_dev);
            pst.setString(8, fecha);
            pst.setString(9, user);
            pst.setString(10, estado);
            pst.setString(11, saldo_dev);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_devo();
                actEstadoVentas();

                String capcod = "", capcan = "";
                for (int i = 0; i < Devolucion_Devoluciones.tb_factura_dev.getRowCount(); i++) {
                    capcod = Devolucion_Devoluciones.tb_factura_dev.getValueAt(i, 0).toString();
                    capcan = Devolucion_Devoluciones.tb_factura_dev.getValueAt(i, 3).toString();
                    ajustartarstock(capcod, capcan);

                }
                JOptionPane.showMessageDialog(null, "Operación realizada con éxito");
                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    String cod_devo = lbl_cod.getText();

                    Reportes reporte = new Reportes();
                    try {
                        reporte.devoluciones(cod_devo);

                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Devolucion_Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Devolucion_Devoluciones.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void detalle_devo() {
        for (int i = 0; i < tb_factura_dev.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO devoluciones_detalles (cod_dev,cod_pro,des_pro,cant_pro,pre_unit,pre_venta,data) VALUES (?,?,?,?,?,?,?)";
            String numbol = lbl_cod.getText();
            String codpro = tb_factura_dev.getValueAt(i, 0).toString();
            String despro = tb_factura_dev.getValueAt(i, 1).toString();
            String cantpro = tb_factura_dev.getValueAt(i, 3).toString();
            String preunit = tb_factura_dev.getValueAt(i, 2).toString();
            String importe = tb_factura_dev.getValueAt(i, 4).toString();
            String fecha = Principal.lbl_fecha_hoy.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, numbol);
                pst.setString(2, codpro);
                pst.setString(3, despro);
                pst.setString(4, cantpro);
                pst.setString(5, preunit);
                pst.setString(6, importe);
                pst.setString(7, fecha);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(Devolucion_Devoluciones.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void codigos() {

        String c = "";
        String SQL = "select max(cod_dev) from devoluciones";

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                lbl_cod.setText("0000001");
            } else {
                int j = Integer.parseInt(c);
                if (Principal.txt_dir_backup.getText().equals("1")) {
                    GenerarNumero gen = new GenerarNumero();
                    gen.generar(j);
                    lbl_cod.setText(gen.serie());

                } else {
                    Generar_Num_Pro gen = new Generar_Num_Pro();
                    gen.generar(j);
                    lbl_cod.setText(gen.serie());
                }
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Devolucion_Devoluciones.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_factura_dev.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Devolucion_Devoluciones.tb_factura_dev.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));

    }

    public String MaskaraPrecioUnitarioEnteros(String ValorGuaranies) {
        DecimalFormat format = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String a = ValorViejo.replace(",", "");
        NumeroIntacto = Long.valueOf(a).longValue();
        NroFormatado = format.format(NumeroIntacto);
        String LuzParaMisOjos = NroFormatado;
        return LuzParaMisOjos;
    }

    public void cargar(String valor) {
        String mostrar = "SELECT * FROM ventas_detalles WHERE CONCAT(num_bol) LIKE '%" + valor + "%'";
        String[] titulos = {"Id Producto", "Descripción", "Precio Unitario", "Cantidad", "Precio Venta"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("cod_pro");
                Registros[1] = rs.getString("des_pro");
                Registros[2] = rs.getString("pre_unit");
                Registros[3] = rs.getString("cant_pro");
                Registros[4] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_factura_dev.setModel(model);

            tb_factura_dev.getColumnModel().getColumn(0).setPreferredWidth(90);
            tb_factura_dev.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_factura_dev.getColumnModel().getColumn(2).setPreferredWidth(130);
            tb_factura_dev.getColumnModel().getColumn(3).setPreferredWidth(83);
            tb_factura_dev.getColumnModel().getColumn(4).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Devolucion_Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM ventas WHERE num_bol= '" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_cod_cli.setText(rs.getString(2));
                txt_cli_nom.setText(rs.getString(3));
                //txt_da.setText(rs.getString(6));
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Devolucion_Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void actEstadoVentas() {

        try {
            String es = ("DEVUELTO");
            String nro = txt_cod.getText();

            String sql = "UPDATE ventas SET estado_ventas = '" + es
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

    //no esta en uso
    void controlCredito() {
        String credito = "";
        String cliente = txt_cod_cli.getText();
        String consul = "SELECT sum(REPLACE(v.monto_cred,',','')) FROM necttic.ventas as v where v.cod_cli_ventas='" + cliente + "' and v.monto_cred <> 0;";
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                credito = rs.getString(1);
            }
            ///suma 

            BigDecimal creditoCli = ingreso.TransformReales(credito.replaceAll("\\s", ""));
            BigDecimal nontoCredito = ingreso.TransformReales(txttotal.getText().replaceAll("\\s", ""));

            String monto_total_credito = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(creditoCli.add(nontoCredito).toString());

            String modi = "UPDATE tienda_clientes SET cli_lim_cre='0' WHERE cli_cod='0000001';";
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | NumberFormatException e) {
            System.out.println("error" + e);
        }
    }

}
