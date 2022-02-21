/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_fecha_principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author user
 */
public class Compras_compras extends javax.swing.JDialog {

    public static String nro_nota_plazo__compras = "";
    public static String total_compras = "";
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(2);

    public Compras_compras(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        codigos();
        cargarConfig();
        btncalcular.setVisible(false);
        txt_nom_prov.setDisabledTextColor(Color.black);
        tb_compras.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_compras.getColumnModel().getColumn(1).setPreferredWidth(290);
        tb_compras.getColumnModel().getColumn(2).setPreferredWidth(110);
        tb_compras.getColumnModel().getColumn(3).setPreferredWidth(110);
        tb_compras.getColumnModel().getColumn(4).setPreferredWidth(50);
        tb_compras.getColumnModel().getColumn(5).setPreferredWidth(110);
        tb_compras.getColumnModel().getColumn(6).setPreferredWidth(110);
        tb_compras.getColumnModel().getColumn(7).setPreferredWidth(110);
        tb_compras.getColumnModel().getColumn(8).setPreferredWidth(63);
        tb_compras.getColumnModel().getColumn(9).setPreferredWidth(110);
        chk_contado.setSelected(true);
        lbl_fecha_VISOR.setText(lbl_fecha_principal.getText());
        // btn_buscaar_items.doClick();

        lbl_compra_fis.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_cod = new javax.swing.JLabel();
        btn_buscaar_items = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btncalcular = new javax.swing.JButton();
        chk_contado = new javax.swing.JCheckBox();
        chk_plazo = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_cod_prov = new javax.swing.JTextField();
        txt_nom_prov = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_nro_comp = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_fecha_emi = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_fecha_VISOR = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_compras = new javax.swing.JTable();
        txt_valor_comp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblcanpro = new javax.swing.JLabel();
        btneli = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        lbl_compra_fis = new javax.swing.JLabel();
        txt_timbrado = new javax.swing.JTextField();
        btn_salir = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        cb_documento = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("COMPRAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cod.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_cod.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cod.setText("0000001");
        lbl_cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 110, 30));

        btn_buscaar_items.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscaar_items.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscaar_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        btn_buscaar_items.setMnemonic('a');
        btn_buscaar_items.setToolTipText("ALT+A");
        btn_buscaar_items.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscaar_items.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_buscaar_items.setVerifyInputWhenFocusTarget(false);
        btn_buscaar_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaar_itemsActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscaar_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 60, 50));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("N°:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 30, 30));

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
        jPanel1.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 40, 20));

        chk_contado.setBackground(new java.awt.Color(255, 255, 255));
        chk_contado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_contado.setText("CONTADO");
        chk_contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_contadoActionPerformed(evt);
            }
        });
        jPanel1.add(chk_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 90, 30));

        chk_plazo.setBackground(new java.awt.Color(255, 255, 255));
        chk_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_plazo.setText("CRÉDITO");
        chk_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_plazoActionPerformed(evt);
            }
        });
        jPanel1.add(chk_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 80, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Timbrado:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 70, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Cond. de pago :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, 30));

        txt_cod_prov.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod_prov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_cod_prov.setEnabled(false);
        txt_cod_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_provActionPerformed(evt);
            }
        });
        txt_cod_prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_provKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cod_prov, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 9, 90, 32));

        txt_nom_prov.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_nom_prov.setEnabled(false);
        txt_nom_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nom_provActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nom_prov, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 9, 430, 32));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Nombre Proveedor :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, 130, 32));

        txt_nro_comp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nro_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nro_compActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nro_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 180, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Tipo Documento:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        try {
            txt_fecha_emi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_emi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_fecha_emi, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 90, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Fecha Emisión:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Fecha Entrada:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, -1, 30));

        try {
            lbl_fecha_VISOR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        lbl_fecha_VISOR.setText("");
        lbl_fecha_VISOR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_fecha_VISOR.setEnabled(false);
        lbl_fecha_VISOR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(lbl_fecha_VISOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 90, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("Valor :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 50, 32));

        tb_compras = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_compras.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio Venta", "Precio B*", "IVA %", "Precio Mínimo", "Precio D*", "Precio Compra", "Cantidad", "Precio Total"
            }
        ));
        tb_compras.setGridColor(new java.awt.Color(255, 255, 255));
        tb_compras.setRowHeight(22);
        tb_compras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_comprasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_compras);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1150, 380));

        txt_valor_comp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_valor_comp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_comp.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_comp.setEnabled(false);
        txt_valor_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valor_compActionPerformed(evt);
            }
        });
        txt_valor_comp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valor_compKeyReleased(evt);
            }
        });
        jPanel1.add(txt_valor_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 190, 32));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 8, 50, 32));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Items:");

        lblcanpro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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
                .addComponent(lblcanpro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcanpro))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, 130, 30));

        btneli.setBackground(new java.awt.Color(255, 255, 255));
        btneli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btneli.setMnemonic('e');
        btneli.setToolTipText("Remover Productos ALT+E");
        btneli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });
        jPanel1.add(btneli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 60, 50));

        btnven.setBackground(new java.awt.Color(255, 255, 255));
        btnven.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        jPanel1.add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 540, 140, 50));

        lbl_compra_fis.setText("compra_fiscal");
        lbl_compra_fis.setFocusable(false);
        jPanel1.add(lbl_compra_fis, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 80, 30));

        txt_timbrado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_timbrado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_timbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 160, 30));

        btn_salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 140, 50));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Nro.  Nota  Compra:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        cb_documento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_documento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nota Interna", "Factura", "Boleta ", "Nota de Compra" }));
        jPanel1.add(cb_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 180, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Verifique el monto total o datos de la compra, ¿desea continuar?",
                "Verificar", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            if (chk_contado.isSelected()) {

                if ((txt_cod_prov.getText().equals("")) || (txt_valor_comp.getText().equals(""))) {
                    JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
                } else {
                    btnven.setEnabled(false);
                    btn_salir.setEnabled(false);
                    btneli.setEnabled(false);

                    compras();

                    DefaultTableModel modelo = (DefaultTableModel) tb_compras.getModel();
                    int a = tb_compras.getRowCount() - 1;
                    int i;
                    for (i = a; i >= 0; i--) {
                        modelo.removeRow(i);
                    }
                    codigos();
                    btnven.setEnabled(true);
                    btn_salir.setEnabled(true);
                    btneli.setEnabled(true);
                    txt_cod_prov.setText("");
                    txt_nom_prov.setText("");
                    lblcanpro.setText("0");
                    txt_nro_comp.setText("");
                    txt_fecha_emi.setText("");
                    txt_valor_comp.setText("");
                    txt_timbrado.setText("");
                    chk_contado.setSelected(true);
                    chk_plazo.setSelected(false);

                }
            }

            if (chk_plazo.isSelected()) {

                if ((txt_cod_prov.getText().equals("")) || (txt_valor_comp.getText().equals("")) || (txt_nom_prov.getText().equals(""))) {
                    JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
                } else {
                    btnven.setEnabled(false);
                    btn_salir.setEnabled(false);
                    btneli.setEnabled(false);

                    compra_plazo();

                    DefaultTableModel modelo = (DefaultTableModel) tb_compras.getModel();
                    int a = tb_compras.getRowCount() - 1;
                    int i;
                    for (i = a; i >= 0; i--) {
                        modelo.removeRow(i);
                    }
                    codigos();
                    btnven.setEnabled(true);
                    btn_salir.setEnabled(true);
                    btneli.setEnabled(true);
                    txt_cod_prov.setText("");
                    txt_nom_prov.setText("");
                    lblcanpro.setText("0");
                    txt_nro_comp.setText("");
                    txt_fecha_emi.setText("");
                    txt_valor_comp.setText("");
                    txt_timbrado.setText("");
                    chk_contado.setSelected(true);
                    chk_plazo.setSelected(false);

                }
            }

            txt_cod_prov.requestFocus();
            Principal_compras.btn_cargar_datos.doClick();
            btnven.setEnabled(true);
        }
    }//GEN-LAST:event_btnvenActionPerformed

    private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
        for (int i = 0; i < tb_compras.getRowCount(); i++) {

            DefaultTableModel model = (DefaultTableModel) tb_compras.getModel();
            int fila = tb_compras.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);
                calcular();
                calcularCantidadPro();

            }
            if (fila < 0) {
                txt_valor_comp.setText("0");

            }
            calcular();
            calcularCantidadPro();
        }
    }//GEN-LAST:event_btneliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Clientes_compras cv;
        cv = new Clientes_compras(new javax.swing.JDialog(), true);
        cv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_valor_compKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valor_compKeyReleased
        ActivatedYourLife(txt_valor_comp, evt);
    }//GEN-LAST:event_txt_valor_compKeyReleased

    private void txt_valor_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valor_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valor_compActionPerformed

    private void tb_comprasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_comprasKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_tb_comprasKeyPressed

    private void txt_nro_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nro_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nro_compActionPerformed

    private void txt_nom_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nom_provActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nom_provActionPerformed

    private void txt_cod_provKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_provKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            Clientes_compras cv;
            cv = new Clientes_compras(new javax.swing.JDialog(), true);
            cv.setVisible(true);

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir de compras?",
                    "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.dispose();
                Compras.Principal_compras.txt_bus.requestFocus();
                Compras.Principal_compras.txt_bus.setText("");
            }

        }
    }//GEN-LAST:event_txt_cod_provKeyPressed

    private void txt_cod_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_provActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_provActionPerformed

    private void chk_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_plazoActionPerformed
        chk_contado.setSelected(false);
        TiposPagos();

    }//GEN-LAST:event_chk_plazoActionPerformed

    private void chk_contadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_contadoActionPerformed
        chk_plazo.setSelected(false);

    }//GEN-LAST:event_chk_contadoActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        calcular();
        calcularCantidadPro();
    }//GEN-LAST:event_btncalcularActionPerformed

    private void btn_buscaar_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaar_itemsActionPerformed

        Productos_compras rp;
        rp = new Productos_compras(new javax.swing.JDialog(), true);
        rp.setVisible(true);

    }//GEN-LAST:event_btn_buscaar_itemsActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir de compras?",
                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_salirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_salirKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {

            btn_salir.doClick();

        }
    }//GEN-LAST:event_btn_salirKeyReleased

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
            java.util.logging.Logger.getLogger(Compras_compras.class
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
                Compras_compras dialog = null;
                try {
                    dialog = new Compras_compras(new javax.swing.JDialog(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Compras_compras.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    public static javax.swing.JButton btn_buscaar_items;
    private javax.swing.JButton btn_salir;
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnven;
    private javax.swing.JComboBox cb_documento;
    private javax.swing.JCheckBox chk_contado;
    private javax.swing.JCheckBox chk_plazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbl_cod;
    public static javax.swing.JLabel lbl_compra_fis;
    private javax.swing.JFormattedTextField lbl_fecha_VISOR;
    public static javax.swing.JLabel lblcanpro;
    public static javax.swing.JTable tb_compras;
    public static javax.swing.JTextField txt_cod_prov;
    private javax.swing.JFormattedTextField txt_fecha_emi;
    public static javax.swing.JTextField txt_nom_prov;
    private javax.swing.JTextField txt_nro_comp;
    private javax.swing.JTextField txt_timbrado;
    private javax.swing.JTextField txt_valor_comp;
    // End of variables declaration//GEN-END:variables

    public void calcular() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_compras.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_compras.getValueAt(i, 7).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_compras.getValueAt(i, 8).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            // iva = ingreso.TransformReales(subtotal).divide(ingreso.TransformReales("11"), 2, RoundingMode.HALF_UP).toString();
            //   txt_nac.setText(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(iva)));
            tb_compras.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 9);
            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            txt_valor_comp.setText(total);

            // txTSubtotal.setText(subtotal);
        }
    }//FIN METODO public vo

    void ajustarstock(String cod, String pre_venta, String pre_iva, String por_iva, String pre_mini, String pre_d, String pre_compra, String cant) throws SQLException {
        int des = Integer.parseInt(cant);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(5);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;

        String modi = "UPDATE tienda_productos SET pro_cant = '" + desfinal + "', pro_pre_a='" + pre_venta + "', pro_pre_b='" + pre_iva + "', pro_iva='" + por_iva + "', pro_pre_atacado='" + pre_mini + "',pro_pre_d='" + pre_mini + "', pro_pre_costo='" + pre_compra + "' WHERE pro_cod = '" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void CostoMedio(String cod, String costo) throws SQLException {
        String total = "";
        String cap = "";
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(13);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
        }

        BigDecimal medio = ingreso.TransformReales(cap);
        BigDecimal actual = ingreso.TransformReales(costo);
        if (cap.equals("") || cap.equals("0")) {
            String precio_compra = costo;
            String modi = "UPDATE tienda_productos SET pro_peso = '" + precio_compra + "' WHERE pro_cod = '" + cod + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(modi);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException e) {
            }
            System.out.println("solo costo");
        } else {
            if (Principal.txt_simbolo.getText().equals("Gs")) {
                total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(medio.add(actual).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP).toString());
            } else {
                total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(medio.add(actual).divide(ONE_HUNDRED, 2, RoundingMode.HALF_UP).toString());
            }

            String modi = "UPDATE tienda_productos SET pro_peso = '" + total + "' WHERE pro_cod = '" + cod + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(modi);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);
                System.out.println("costo medio");
            } catch (SQLException e) {
            }

        }

    }

    void compras() {
        codigos();
        String InsertarSQL = "INSERT INTO compras (cod_comp,cod_prov_comp,nom_prov_comp,nro_comp,fecha_emi_comp,alma_comp,fecha_entra_comp,pago_comp,dias_comp,valor_comp,fecha_entrada,user_comp,estado_comp,tipo_docu) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numcomp = lbl_cod.getText();
        String cod_prov = txt_cod_prov.getText();
        String nom_prov = txt_nom_prov.getText();
        String nro_comp = txt_nro_comp.getText();
        String fecha_emi = txt_fecha_emi.getText();
        String timbra = txt_timbrado.getText();
        String fecha_entra = lbl_fecha_VISOR.getText();
        String formapag = chk_contado.getText();
        String dias_pla = ("0");
        String total_ventas = txt_valor_comp.getText();
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String estado = ("FINALIZADA");
        String docu = (String) cb_documento.getSelectedItem();
        ///modificacion 29/11/2019
        String credito = txt_valor_comp.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numcomp);
            pst.setString(2, cod_prov);
            pst.setString(3, nom_prov);
            pst.setString(4, nro_comp);
            pst.setString(5, fecha_emi);
            pst.setString(6, timbra);
            pst.setString(7, fecha_entra);
            pst.setString(8, formapag);
            pst.setString(9, dias_pla);
            pst.setString(10, total_ventas);
            pst.setString(11, fecha);
            pst.setString(12, user);
            pst.setString(13, estado);
            pst.setString(14, docu);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_compra();
                try {

                    String cod_pro = "", pre_venta = "", pre_iva = "", porce_iva = "", pre_minimo = "", pre_compra = "", cantidad = "", pre_d = "";
                    for (int i = 0; i < Compras_compras.tb_compras.getRowCount(); i++) {

                        cod_pro = Compras_compras.tb_compras.getValueAt(i, 0).toString();
                        pre_venta = Compras_compras.tb_compras.getValueAt(i, 2).toString();
                        pre_iva = Compras_compras.tb_compras.getValueAt(i, 3).toString();
                        porce_iva = Compras_compras.tb_compras.getValueAt(i, 4).toString();
                        pre_minimo = Compras_compras.tb_compras.getValueAt(i, 5).toString();
                        pre_d = Compras_compras.tb_compras.getValueAt(i, 6).toString();
                        pre_compra = Compras_compras.tb_compras.getValueAt(i, 7).toString();
                        cantidad = Compras_compras.tb_compras.getValueAt(i, 8).toString();

                        ajustarstock(cod_pro, pre_venta, pre_iva, porce_iva, pre_minimo, pre_d, pre_compra, cantidad);
                        CostoMedio(cod_pro, pre_compra);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }

                JOptionPane.showMessageDialog(null, "Compra realizada con éxito");
                imprimir();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Compras_compras.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void imprimir() {

        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {

                    String cod = lbl_cod.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("codigo", cod);
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Compras/impresiones/Nota_compras.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                } catch (SQLException ex) {
                    Logger.getLogger(Compras_compras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    void compra_plazo() {
        codigos();
        String InsertarSQL = "INSERT INTO compras (cod_comp,cod_prov_comp,nom_prov_comp,nro_comp,fecha_emi_comp,alma_comp,fecha_entra_comp,pago_comp,dias_comp,valor_comp,fecha_entrada,user_comp,estado_comp,tipo_docu,monto_cred) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numcomp = lbl_cod.getText();
        String cod_prov = txt_cod_prov.getText();
        String nom_prov = txt_nom_prov.getText();
        String nro_comp = txt_nro_comp.getText();
        String fecha_emi = txt_fecha_emi.getText();
        String timbra = txt_timbrado.getText();
        String fecha_entra = lbl_fecha_VISOR.getText();
        String formapag = chk_plazo.getText();
        String dias_pla = ("0");
        String total_ventas = txt_valor_comp.getText();
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String estado = ("FINALIZADA");
        String docu = (String) cb_documento.getSelectedItem();
        ///modificacion 29/11/2019
        String credito = txt_valor_comp.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numcomp);
            pst.setString(2, cod_prov);
            pst.setString(3, nom_prov);
            pst.setString(4, nro_comp);
            pst.setString(5, fecha_emi);
            pst.setString(6, timbra);
            pst.setString(7, fecha_entra);
            pst.setString(8, formapag);
            pst.setString(9, dias_pla);
            pst.setString(10, total_ventas);
            pst.setString(11, fecha);
            pst.setString(12, user);
            pst.setString(13, estado);
            pst.setString(14, docu);
            pst.setString(15, credito);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_compra();
                String cod_pro = "", pre_venta = "", pre_iva = "", porce_iva = "", pre_minimo = "", pre_compra = "", cantidad = "", pre_d = "";
                for (int i = 0; i < Compras_compras.tb_compras.getRowCount(); i++) {

                    cod_pro = Compras_compras.tb_compras.getValueAt(i, 0).toString();
                    pre_venta = Compras_compras.tb_compras.getValueAt(i, 2).toString();
                    pre_iva = Compras_compras.tb_compras.getValueAt(i, 3).toString();
                    porce_iva = Compras_compras.tb_compras.getValueAt(i, 4).toString();
                    pre_minimo = Compras_compras.tb_compras.getValueAt(i, 5).toString();
                    pre_d = Compras_compras.tb_compras.getValueAt(i, 6).toString();
                    pre_compra = Compras_compras.tb_compras.getValueAt(i, 7).toString();
                    cantidad = Compras_compras.tb_compras.getValueAt(i, 8).toString();

                    try {
                        ajustarstock(cod_pro, pre_venta, pre_iva, porce_iva, pre_minimo, pre_d, pre_compra, cantidad);
                        CostoMedio(cod_pro, pre_compra);

                    } catch (SQLException ex) {
                        Logger.getLogger(Compras_compras.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Compra realizada con éxito");
                imprimir();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Compras_compras.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    void detalle_compra() {
        for (int i = 0; i < tb_compras.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO compras_detalles (cod_comp,cod_pro,des_pro,cant_pro,pre_unit,pre_venta,data) VALUES (?,?,?,?,?,?,?)";
            String numcomp = lbl_cod.getText();
            String codpro = tb_compras.getValueAt(i, 0).toString();
            String despro = tb_compras.getValueAt(i, 1).toString();
            String cantpro = tb_compras.getValueAt(i, 8).toString();
            String preunit = tb_compras.getValueAt(i, 7).toString();
            String importe = tb_compras.getValueAt(i, 9).toString();
            String fecha_det_con = lbl_fecha_hoy.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, numcomp);
                pst.setString(2, codpro);
                pst.setString(3, despro);
                pst.setString(4, cantpro);
                pst.setString(5, preunit);
                pst.setString(6, importe);
                pst.setString(7, fecha_det_con);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(Compras_compras.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void codigos() {

        String c = "";
        String SQL = "select max(cod_comp) from compras";

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
            Logger.getLogger(Compras_compras.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_compras.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Compras_compras.tb_compras.getValueAt(i, 8).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
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

    void TiposPagos() {

        if (chk_plazo.isSelected()) {

        }
    }

    public String ActivatedYourLife(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = Principal.lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_valor_comp.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_valor_comp.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_valor_comp.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String MaskaraEnteros(String ValorGuaranies) {
        //<editor-fold defaultstate="collapsed" desc="IF">        
        ValorGuaranies = ValorGuaranies.replaceAll("\\s", "").replaceAll("\\D", "");
        if (ValorGuaranies.contains(".")) {
            BigDecimal Rounder = new BigDecimal(ValorGuaranies);
            Rounder = Rounder.setScale(0, BigDecimal.ROUND_HALF_UP);
            ValorGuaranies = Rounder.toString();
            if (ValorGuaranies.contains(".")) {
                ValorGuaranies = ValorGuaranies.substring(0, ValorGuaranies.indexOf("."));
            }
        }// FIN IF
        //</editor-fold>        
        DecimalFormat Formato = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String Puro = ValorViejo.replace(",", "");
        NumeroIntacto = Long.parseLong(Puro);
        NroFormatado = Formato.format(NumeroIntacto);
        String ReadyToExhibit = NroFormatado;
        ReadyToExhibit = ReadyToExhibit.replace(".", ",");
        return ReadyToExhibit;
    }// FIN METODO

    void cargarConfig() throws IOException {
        String mostrar = "SELECT * FROM empresas";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_compra_fis.setText(rs.getString(14));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Compras_compras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
