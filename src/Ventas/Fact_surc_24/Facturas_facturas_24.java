/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Fact_surc_24;

import Clases.Clase_Literal;

import Clases.GenerarNumero;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.lbl_año_actual;
import static Loggin_Principal.Principal.lbl_dia_actual;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_fecha_principal;
import static Loggin_Principal.Principal.lbl_mes_actual;
import static Loggin_Principal.Principal.lbl_usu_nom;
import static Loggin_Principal.Principal.txt_simbolo;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class Facturas_facturas_24 extends javax.swing.JDialog {

    /**
     * Creates new form facturacion
     *
     * @param parent
     */
    public Facturas_facturas_24(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cargarConfig();
        codigos();
        btncalcular.setVisible(false);
        txt_forma_pago.setVisible(false);
        lbl_sub_total.setVisible(false);
        lbl_literal_pro.setVisible(false);
        lbl_literal.setVisible(false);
        btn_buscar_24.setVisible(false);
        ch_contado.doClick();
        txt_cli_nom.setDisabledTextColor(Color.black);
        txt_forma_pago.setDisabledTextColor(Color.black);
        txt_forma_pago.setDisabledTextColor(Color.black);
        lbl_fecha_VISOR.setText(lbl_fecha_principal.getText());
        tb_factura.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_factura.getColumnModel().getColumn(1).setPreferredWidth(300);
        tb_factura.getColumnModel().getColumn(2).setPreferredWidth(50);
        tb_factura.getColumnModel().getColumn(3).setPreferredWidth(75);
        tb_factura.getColumnModel().getColumn(4).setPreferredWidth(110);
        tb_factura.getColumnModel().getColumn(5).setPreferredWidth(110);
        tb_factura.getColumnModel().getColumn(6).setPreferredWidth(110);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_factura = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txt_cod_cli = new javax.swing.JTextField();
        txt_cli_nom = new javax.swing.JTextField();
        txt_cod = new javax.swing.JTextField();
        txt_forma_pago = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btn_buscar_24 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_sequencia = new javax.swing.JTextField();
        lbl_cod = new javax.swing.JTextField();
        ch_credito = new javax.swing.JCheckBox();
        ch_contado = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_fecha_VISOR = new javax.swing.JLabel();
        btncalcular = new javax.swing.JButton();
        btneli = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_10 = new javax.swing.JLabel();
        lbl_exentos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblcanpro = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        lbl_literal_pro = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_iva_10_por = new javax.swing.JLabel();
        lbl_total_monto_iva = new javax.swing.JLabel();
        txt_esta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_timbrado = new javax.swing.JTextField();
        lbl_sub_total = new javax.swing.JLabel();
        lbl_literal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_factura.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "IVA % ", "Cantidad", "Precio Unitario", "Exentas", "IVA 10%"
            }
        ));
        tb_factura.setGridColor(new java.awt.Color(255, 255, 255));
        tb_factura.setRowHeight(22);
        tb_factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_facturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_factura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1030, 300));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Nombre del Cliente :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        txt_cod_cli.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod_cli.setDisabledTextColor(new java.awt.Color(0, 0, 0));
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
        jPanel1.add(txt_cod_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, 30));

        txt_cli_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cli_nom.setEnabled(false);
        txt_cli_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_nomActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cli_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 370, 30));

        txt_cod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod.setDisabledTextColor(new java.awt.Color(153, 0, 0));
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
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 140, 32));

        txt_forma_pago.setEnabled(false);
        jPanel1.add(txt_forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, 80, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Cond. de Vta:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 90, 30));

        btn_buscar_24.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar_24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar_24.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar_24.setToolTipText("");
        btn_buscar_24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_24ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 50, 32));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 50, 32));

        txt_sequencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_sequencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sequencia.setText("001");
        txt_sequencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_sequencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_sequencia.setEnabled(false);
        txt_sequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sequenciaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_sequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 50, 30));

        lbl_cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbl_cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_cod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_codActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 120, 30));

        ch_credito.setBackground(new java.awt.Color(255, 255, 255));
        ch_credito.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_credito.setText("Crédito");
        ch_credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_creditoActionPerformed(evt);
            }
        });
        jPanel1.add(ch_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, -1, 30));

        ch_contado.setBackground(new java.awt.Color(255, 255, 255));
        ch_contado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_contado.setText("Contado");
        ch_contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_contadoActionPerformed(evt);
            }
        });
        jPanel1.add(ch_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Fecha :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 50, 30));

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel25.setText("SUB-TOTALES:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 110, 30));

        lbl_fecha_VISOR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_fecha_VISOR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_fecha_VISOR.setText("Nro");
        jPanel1.add(lbl_fecha_VISOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 80, 30));

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
        jPanel1.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 40, 20));

        btneli.setBackground(new java.awt.Color(255, 255, 255));
        btneli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btneli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btneli.setMnemonic('e');
        btneli.setToolTipText("Remover Productos ALT+E");
        btneli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });
        jPanel1.add(btneli, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 100, 60, 40));

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
        jPanel1.add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 150, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbl_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_10.setText("0");
        jPanel2.add(lbl_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 8, 140, 30));

        lbl_exentos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbl_exentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_exentos.setText("0");
        jPanel2.add(lbl_exentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 140, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Items:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, 30));

        lblcanpro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcanpro.setText("0");
        jPanel2.add(lblcanpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 80, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1030, 45));

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL GS:");

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 490, 270, 30));

        lbl_literal_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_literal_pro.setText("Son:");
        jPanel1.add(lbl_literal_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 40, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("IVA 10%:");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 1, 60, 30));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("TOTAL IVA:");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 87, 30));

        lbl_iva_10_por.setBackground(new java.awt.Color(102, 102, 102));
        lbl_iva_10_por.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbl_iva_10_por.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_iva_10_por.setText("0");
        jPanel5.add(lbl_iva_10_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 150, 30));

        lbl_total_monto_iva.setBackground(new java.awt.Color(102, 102, 102));
        lbl_total_monto_iva.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbl_total_monto_iva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total_monto_iva.setText("0");
        jPanel5.add(lbl_total_monto_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 150, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 330, 70));

        txt_esta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_esta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_esta.setText("003");
        txt_esta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_esta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_esta.setEnabled(false);
        jPanel1.add(txt_esta, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 50, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("N°:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, -1, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Timbrado N°:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 100, 30));

        txt_timbrado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_timbrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_timbrado.setText("14870462");
        txt_timbrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_timbrado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_timbrado.setEnabled(false);
        txt_timbrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timbradoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_timbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 100, 30));
        jPanel1.add(lbl_sub_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, 170, 20));

        lbl_literal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_literal.setText("gs");
        jPanel1.add(lbl_literal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 180, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Número de Venta :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 420, 10));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACTURACIÓN");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 170, 30));

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        calcular();
        calcularCantidadPro();
        calcularExentos();

        calcular10();
        calcularLucro();
        literal();
        calcular_porciento10();

        calcularTotalIva();

    }//GEN-LAST:event_btncalcularActionPerformed

    private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tb_factura.getModel();
        int fila = tb_factura.getSelectedRow();
        if (fila >= 0) {
            model.removeRow(fila);
            btncalcular.doClick();

        } else {

            JOptionPane.showMessageDialog(null, "Tabla vacia o no seleccione ninguna fila");
        }
        if (fila == 0) {
            lbl_exentos.setText("0");

            lbl_10.setText("0");
            lbl_iva_10_por.setText("0");
            lbl_total_monto_iva.setText("0");
            lblcanpro.setText("0");;
            txttotal.setText("0");
        }

    }//GEN-LAST:event_btneliActionPerformed

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed

        if ((txt_cod.getText().equals("")) || (txttotal.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
        } else {
            // codigos();
            factura_ventas();
            lmpiarTxt();

            DefaultTableModel modelo = (DefaultTableModel) tb_factura.getModel();
            int a = tb_factura.getRowCount() - 1;
            int i;
            for (i = a; i >= 0; i--) {
                modelo.removeRow(i);
            }
            codigos();
            // cargarConfig();

        }

        txt_cod.requestFocus();
        Principal_ventas_facturas_24.btn_cargar_datos.doClick();
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

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
            Principal_ventas_facturas_24.txt_bus.requestFocus();
        }
    }//GEN-LAST:event_txt_codKeyPressed

    private void tb_facturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_facturaKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

            btncalcular.doClick();
            JOptionPane.showMessageDialog(null, "Recalculando");
        }

    }//GEN-LAST:event_tb_facturaKeyPressed

    private void btn_buscar_24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_24ActionPerformed

        try {
            cargar(txt_cod.getText());
            cargarTxt(txt_cod.getText());
            btncalcular.doClick();
            if (txt_forma_pago.getText().equals("CONTADO")) {
                ch_con = "X";
                ch_cre = "";
                ch_credito.setSelected(false);
                ch_contado.setSelected(true);
            } else {
                ch_con = "";
                ch_cre = "X";
                ch_credito.setSelected(true);
                ch_contado.setSelected(false);
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_btn_buscar_24ActionPerformed

    private void txt_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Lista_ventas_facturar_24 lisvf;
        lisvf = new Lista_ventas_facturar_24(new javax.swing.JDialog(), true);
        lisvf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ch_contadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_contadoActionPerformed
        ch_con = "X";
        ch_cre = "";
        ch_credito.setSelected(false);
    }//GEN-LAST:event_ch_contadoActionPerformed

    private void txt_sequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sequenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sequenciaActionPerformed

    private void lbl_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_codActionPerformed

    private void txt_timbradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timbradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timbradoActionPerformed

    private void ch_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_creditoActionPerformed
        ch_cre = "X";
        ch_con = "";
        ch_contado.setSelected(false);
    }//GEN-LAST:event_ch_creditoActionPerformed

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
            java.util.logging.Logger.getLogger(Facturas_facturas_24.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Facturas_facturas_24 dialog = new Facturas_facturas_24(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_buscar_24;
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnven;
    private javax.swing.JCheckBox ch_contado;
    private javax.swing.JCheckBox ch_credito;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_10;
    public static javax.swing.JTextField lbl_cod;
    private javax.swing.JLabel lbl_exentos;
    private javax.swing.JLabel lbl_fecha_VISOR;
    private javax.swing.JLabel lbl_iva_10_por;
    private javax.swing.JLabel lbl_literal;
    private javax.swing.JLabel lbl_literal_pro;
    private javax.swing.JLabel lbl_sub_total;
    private javax.swing.JLabel lbl_total_monto_iva;
    public static javax.swing.JLabel lblcanpro;
    public static javax.swing.JTable tb_factura;
    public static javax.swing.JTextField txt_cli_nom;
    public static javax.swing.JTextField txt_cod;
    public static javax.swing.JTextField txt_cod_cli;
    private javax.swing.JTextField txt_esta;
    private javax.swing.JTextField txt_forma_pago;
    private javax.swing.JTextField txt_sequencia;
    private javax.swing.JTextField txt_timbrado;
    public static javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public void calcular() {

        String imp = "0", subtotal = "0", cero = "0";

        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_factura.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_factura.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            String iva_por = tb_factura.getValueAt(i, 2).toString().replaceAll("\\s", "");

            switch (iva_por) {
                case "0":
                    tb_factura.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 5);
                    tb_factura.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(cero)), i, 6);

                    break;
                default:
                    tb_factura.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 6);
                    tb_factura.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(cero)), i, 5);
                    break;
            }

            // total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());
            // txttotal.setText(total);
        }
    }

    public void calcularSubTotal() {

    }

    void factura_ventas() {

        String InsertarSQL = "INSERT INTO ventas_facturacion_surc_24 (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_efectivo,forma_pag_credito,total_ventas,fecha_ventas,user_ventas,cant_ventas,letras_ventas,nro_seq_ventas,nro_estable_ventas,nro_fact_ventas,nro_timbra_ventas,fact_sub_exe,fact_sub_5,fact_sub_10,total_iva_5,total_iva_10,total_iva,data_vista,simb_moneda,form_pag_lit,dia_lit,mes_lit,years_lit,saldo_cred) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String num_bol = txt_cod.getText();
        String id_cli = txt_cod_cli.getText();
        String des_cli = txt_cli_nom.getText();
        String condi_efect = ch_con;
        String condi_cre = ch_cre;
        String total_nota = txttotal.getText();
        String data = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String items = lblcanpro.getText();
        String literal = lbl_literal.getText() + ".-#####";
        String seq = txt_sequencia.getText();
        String establec = txt_esta.getText();
        String nro_factura = lbl_cod.getText();
        String timbrado = txt_timbrado.getText();
        String sub_exe = lbl_exentos.getText();
        String sub_5 = ("0");
        String sub_10 = lbl_10.getText();
        String iva_5 = ("0");
        String iva_10 = lbl_iva_10_por.getText();
        String total_iva = lbl_total_monto_iva.getText();
        String fecha = lbl_fecha_VISOR.getText();
        String simb_mon = txt_simbolo.getText();
        String cond = txt_forma_pago.getText();
        //fecha//
        String dia = lbl_dia_actual.getText();
        String mes = lbl_mes_actual.getText();
        String years = lbl_año_actual.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, num_bol);
            pst.setString(2, id_cli);
            pst.setString(3, des_cli);
            pst.setString(4, condi_efect);
            pst.setString(5, condi_cre);
            pst.setString(6, total_nota);
            pst.setString(7, data);
            pst.setString(8, user);
            pst.setString(9, items);
            pst.setString(10, literal);
            pst.setString(11, seq);
            pst.setString(12, establec);
            pst.setString(13, nro_factura);
            pst.setString(14, timbrado);
            pst.setString(15, sub_exe);
            pst.setString(16, sub_5);
            pst.setString(17, sub_10);
            pst.setString(18, iva_5);
            pst.setString(19, iva_10);
            pst.setString(20, total_iva);
            pst.setString(21, fecha);
            pst.setString(22, simb_mon);
            pst.setString(23, cond);
            pst.setString(24, dia);
            pst.setString(25, mes);
            pst.setString(26, years);
            pst.setString(27, total_nota);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);
            if (n > 0) {
                detalle_factura();
                JOptionPane.showMessageDialog(null, "Factura de venta realizada con éxito");
                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir Factura de venta" + ": " + txt_sequencia.getText() + "-" + txt_esta.getText() + "-" + lbl_cod.getText() + ", ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    String cod = txt_cod.getText();
                    Reportes reporte = new Reportes();
                    try {
                        reporte.fact_surc_24(cod);
                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }

                     /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }

                     /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }

                     /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }

                     /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }

                     /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }

                     /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }

                     /*   String cod = lbl_cod.getText();
                     Reportes reporte = new Reportes();
                     try {
                     reporte.factKyrios(cod);
                     } catch (SQLException | JRException ex) {
                     Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     */
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Facturas_facturas_24.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nota de venta ya fue facturado");
        }

    }

    void detalle_factura() {
        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO ventas_facturacion_deta_surc_24 (num_bol,cod_pro,des_pro,iva_por,cant_pro,pre_unit,pre_exentas,pre_5,pre_10,data) VALUES (?,?,?,?,?,?,?,?,?,?)";
            String num_bol = txt_cod.getText();
            String cod_pro = tb_factura.getValueAt(i, 0).toString();
            String des_pro = tb_factura.getValueAt(i, 1).toString();
            String por_iva = tb_factura.getValueAt(i, 2).toString();
            String cantidad = tb_factura.getValueAt(i, 3).toString();
            String pre_unit = tb_factura.getValueAt(i, 4).toString();
            String pre_exe = tb_factura.getValueAt(i, 5).toString();
            String pre_5 = ("0");
            String pre_10 = tb_factura.getValueAt(i, 6).toString();
            String fecha_det_con = lbl_fecha_hoy.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, num_bol);
                pst.setString(2, cod_pro);
                pst.setString(3, des_pro);
                pst.setString(4, por_iva);
                pst.setString(5, cantidad);
                pst.setString(6, pre_unit);
                pst.setString(7, pre_exe);
                pst.setString(8, pre_5);
                pst.setString(9, pre_10);
                pst.setString(10, fecha_det_con);

                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);
            } catch (SQLException ex) {
                Logger.getLogger(Facturas_facturas_24.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void codigos() {

        String c = "";
        String SQL = "select max(nro_fact_ventas) from ventas_facturacion_surc_24 where nro_timbra_ventas='" + txt_timbrado.getText() + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                Facturas_facturas_24.lbl_cod.setText("0000001");
            } else {
                int j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                Facturas_facturas_24.lbl_cod.setText(gen.serie());

            }
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Facturas_facturas_24.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_factura.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Facturas_facturas_24.tb_factura.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));

    }

    public void calcularExentos() {

        String impca = "0", subtotalca = "0", totalca = "0";

        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_factura.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            impca = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalca = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalca).add(ingreso.TransformReales(impca)).toString());

            lbl_exentos.setText(subtotalca);

        }

    }

    public void calcular10() {

        String impca = "0", subtotalca = "0";

        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_factura.getValueAt(i, 6).toString().replaceAll("\\s", ""));

            impca = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalca = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalca).add(ingreso.TransformReales(impca)).toString());

            lbl_10.setText(subtotalca);

        }

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
        String mostrar = "SELECT d.num_bol ,d.cod_pro ,d.des_pro,d.pre_venta, d.pre_unit ,d.cant_pro, p.pro_iva, p.pro_pre_a FROM ventas_detalles_24 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod  INNER JOIN ventas_24 AS v ON d.num_bol=v.num_bol  WHERE v.num_bol='" + valor + "'";
        String[] titulos = {"Código", "Descripción", " %", "Cantidad", "Precio Unitario", "Exentas", "IVA 10%"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("cod_pro");
                Registros[1] = rs.getString("des_pro");
                Registros[2] = rs.getString("pro_iva");
                Registros[3] = rs.getString("cant_pro");
                Registros[4] = rs.getString("pre_unit");

                model.addRow(Registros);
            }
            tb_factura.setModel(model);

            tb_factura.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_factura.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_factura.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_factura.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_factura.getColumnModel().getColumn(4).setPreferredWidth(110);
            tb_factura.getColumnModel().getColumn(5).setPreferredWidth(110);
            tb_factura.getColumnModel().getColumn(6).setPreferredWidth(110);

            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM ventas_24 WHERE CONCAT(num_bol) LIKE '%" + valor + "%'";

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_cod_cli.setText(rs.getString(2));
                txt_cli_nom.setText(rs.getString(3));
                txt_forma_pago.setText(rs.getString(4));
                //txt_da.setText(rs.getString(6));
                if (txt_forma_pago.getText().equals("E-COMMERCE")) {
                    txt_forma_pago.setText("CONTADO");
                }

            }
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarConfig() {
        String mostrar = "SELECT * FROM almacenes_facturas";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                txt_timbrado.setText(rs.getString("nro_timbra_24"));
                txt_sequencia.setText(rs.getString("nro_esta_24"));
                txt_esta.setText(rs.getString("nro_seq_24"));

            }
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Facturas_facturas_24.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularLucro() {

        String totalsub = "0", net = "0";
        BigDecimal VentaTotal = ingreso.TransformReales(lbl_exentos.getText().replaceAll("\\s", ""));
        BigDecimal ValorCompra = ingreso.TransformReales("0");
        totalsub = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(VentaTotal.add(ValorCompra).toString());
        lbl_sub_total.setText(totalsub);
        BigDecimal valor_total = ingreso.TransformReales(lbl_sub_total.getText().replaceAll("\\s", ""));
        BigDecimal valor_ultimo = ingreso.TransformReales(lbl_10.getText().replaceAll("\\s", ""));
        net = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_ultimo.add(valor_total).toString());
        txttotal.setText(net);

    }

    void literal() {

        String emi = txttotal.getText();
        String emi1 = emi.replaceAll(",", "");
        lbl_literal_pro.setText(emi1);
        try {
            Clase_Literal NumLetra = new Clase_Literal();
            String numero = lbl_literal_pro.getText();
            lbl_literal.setText(NumLetra.Convertir(numero, true));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void calcular_porciento10() {

        String totalCuentaD = "0";
        BigDecimal Precio_Compra = ingreso.TransformReales(lbl_10.getText());
        BigDecimal ganacia = ingreso.TransformReales("11");
        totalCuentaD = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(Precio_Compra.divide(ganacia, 0, RoundingMode.HALF_UP).toString());

        lbl_iva_10_por.setText(totalCuentaD);

    }

    public void calcularTotalIva() {

        String totalsub = "0", net = "0";
        BigDecimal IVA5 = ingreso.TransformReales("0");
        BigDecimal IVA10 = ingreso.TransformReales(lbl_iva_10_por.getText().replaceAll("\\s", ""));
        totalsub = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(IVA5.add(IVA10).toString());
        lbl_total_monto_iva.setText(totalsub);

    }

    void lmpiarTxt() {

        txt_cod.setText("");
        lbl_cod.setText("");
        txt_cod_cli.setText("");
        txt_cli_nom.setText("");
        lbl_exentos.setText("0");
        lbl_10.setText("0");
        lbl_iva_10_por.setText("0");
        lbl_total_monto_iva.setText("0");
        lblcanpro.setText("0");;
        txttotal.setText("0");
        lbl_literal.setText("");

    }
    private String ch_con;
    private String ch_cre;
}
