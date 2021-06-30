/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.lbl_class;
import static Loggin_Principal.Principal.lbl_mone_def;
import static Loggin_Principal.Principal.lbl_pre_b;
import static Loggin_Principal.Principal.lbl_pre_c;
import Productos.costos_monedas;
import static Ventas.Productos_ventas.cod_pro_ventas;
import static Ventas.Productos_ventas.lbl_surcusal_id;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Precio_modelo_dos extends javax.swing.JDialog {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public Precio_modelo_dos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_porcento.setVisible(false);
        if (lbl_surcusal_id.getText().equals("TODOS")) {
            BuscarProductoEditar(cod_pro_ventas);
            calcular_porciento();
            calcular_SaldoO();
            calcularStockTotal();
        }
        if (lbl_surcusal_id.getText().equals("0000001")) {
            BuscarProductoEditar(cod_pro_ventas);
            calcular_porciento();
            calcular_SaldoO();
            calcularStockTotal();
        }
        /* if (lbl_surcusal_id.getText().equals("0000002")) {
         BuscarProductoEditar_2(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000003")) {
         BuscarProductoEditar_3(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000004")) {
         BuscarProductoEditar_4(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000005")) {
         BuscarProductoEditar_5(cod_pro_ventas);

         }

         ///
         if (lbl_surcusal_id.getText().equals("0000006")) {
         BuscarProductoEditar_6(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000007")) {
         BuscarProductoEditar_7(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000008")) {
         BuscarProductoEditar_8(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000009")) {
         BuscarProductoEditar_9(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000010")) {
         BuscarProductoEditar_10(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000011")) {
         BuscarProductoEditar_11(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000012")) {
         BuscarProductoEditar_12(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000013")) {
         BuscarProductoEditar_13(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000014")) {
         BuscarProductoEditar_14(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000015")) {
         BuscarProductoEditar_15(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000016")) {
         BuscarProductoEditar_16(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000017")) {
         BuscarProductoEditar_17(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000018")) {
         BuscarProductoEditar_18(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000019")) {
         BuscarProductoEditar_19(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000020")) {
         BuscarProductoEditar_20(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000021")) {
         BuscarProductoEditar_21(cod_pro_ventas);

         }

         if (lbl_surcusal_id.getText().equals("0000022")) {
         BuscarProductoEditar_22(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000023")) {
         BuscarProductoEditar_23(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000024")) {
         BuscarProductoEditar_24(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000025")) {
         BuscarProductoEditar_25(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000026")) {
         BuscarProductoEditar_26(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000027")) {
         BuscarProductoEditar_27(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000028")) {
         BuscarProductoEditar_28(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000029")) {
         BuscarProductoEditar_29(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000030")) {
         BuscarProductoEditar_30(cod_pro_ventas);

         }*/
        txt_cod.setDisabledTextColor(Color.blue);
        txt_pro.setDisabledTextColor(Color.blue);

        txt_pre.requestFocus();
        // txt_pre_ata.setVisible(false);

    }

    public static String cod_pro_mol = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_stock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_pre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_pro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        btn_agregar_item = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_pre_ata = new javax.swing.JCheckBox();
        txt_pre_a = new javax.swing.JCheckBox();
        lbl_precio_b = new javax.swing.JCheckBox();
        txt_descuento = new javax.swing.JTextField();
        txt_porcento = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_stock_separado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_stock_disponible = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_pre_d = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_stock.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_stock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_stock.setText("0");
        txt_stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_stock.setEnabled(false);
        jPanel1.add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 60, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        txt_pre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_pre.setEnabled(false);
        txt_pre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_preKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_preKeyReleased(evt);
            }
        });
        jPanel1.add(txt_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 150, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Desc. %:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 60, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        txt_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pro.setEnabled(false);
        jPanel1.add(txt_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 540, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Mínimo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Código:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        txt_cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cod.setEnabled(false);
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 150, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("P. Unitario:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        txt_cant.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 80, 30));

        btn_agregar_item.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregar_item.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_agregar_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_agregar_item.setText("Agregar");
        btn_agregar_item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_itemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 120, 50));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/money.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 50, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Precio venta:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Precio B*:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, 30));

        txt_pre_ata.setBackground(new java.awt.Color(255, 255, 255));
        txt_pre_ata.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pre_ata.setText("0");
        txt_pre_ata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pre_ataActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pre_ata, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 100, 30));

        txt_pre_a.setBackground(new java.awt.Color(255, 255, 255));
        txt_pre_a.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pre_a.setText("0");
        txt_pre_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pre_aActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pre_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 100, 30));

        lbl_precio_b.setBackground(new java.awt.Color(255, 255, 255));
        lbl_precio_b.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_precio_b.setText("0");
        lbl_precio_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_precio_bActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_precio_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 90, 30));

        txt_descuento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_descuento.setForeground(new java.awt.Color(204, 0, 0));
        txt_descuento.setText("0");
        txt_descuento.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_descuento.setEnabled(false);
        jPanel1.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 50, 30));
        jPanel1.add(txt_porcento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 80, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Stock Disponible:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 100, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("EnSepración:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 80, 30));

        lbl_stock_separado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_stock_separado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_stock_separado.setText("0");
        lbl_stock_separado.setDisabledTextColor(new java.awt.Color(204, 0, 51));
        lbl_stock_separado.setEnabled(false);
        jPanel1.add(lbl_stock_separado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 50, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Stock Total:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 70, 30));

        txt_stock_disponible.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_stock_disponible.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_stock_disponible.setText("0");
        txt_stock_disponible.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_stock_disponible.setEnabled(false);
        jPanel1.add(txt_stock_disponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 90, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Precio D:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));

        txt_pre_d.setBackground(new java.awt.Color(255, 255, 255));
        txt_pre_d.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pre_d.setText("0");
        txt_pre_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pre_dActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pre_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 260));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_preKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

            txt_cant.requestFocus();

        }
    }//GEN-LAST:event_txt_preKeyPressed

    private void txt_cantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantKeyPressed

        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            btn_agregar_item.doClick();

        }

    }//GEN-LAST:event_txt_cantKeyPressed

    private void txt_preKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preKeyReleased
        ActivatedYourLife(txt_pre, evt);


    }//GEN-LAST:event_txt_preKeyReleased

    private void btn_agregar_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_itemActionPerformed

        if (lbl_surcusal_id.getText().equals("0000001") || lbl_surcusal_id.getText().equals("TODOS")) {

            DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
            String[] dato = new String[5];
            int c = 0;
            int j = 0;
            String id = txt_cod.getText();
            String des = txt_pro.getText();
            String cant = txt_cant.getText();
            String pre = txt_pre.getText();
            String txt_separa = txt_stock_disponible.getText().replaceAll(",", "");;
            String kg = ("0");

            int canting = Integer.parseInt(cant);
            int comp = Integer.parseInt(txt_separa);

            if (canting > comp) {
                JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                txt_cant.requestFocus();
            } else {
                for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
                    Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
                    if (id.equals(com)) {
                        j = i;
                        Ventas_venta.tb_factura.setValueAt(cant, i, 3);
                        Ventas_venta.btncalcular.doClick();
                        c = c + 1;

                        JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
                        this.dispose();
                    }
                }
                if (c == 0) {
                    dato[0] = id;
                    dato[1] = des;
                    dato[2] = pre;
                    dato[3] = cant;
                    dato[4] = kg;

                    tabladet.addRow(dato);

                    Ventas_venta.tb_factura.setModel(tabladet);

                    Ventas_venta.btncalcular.doClick();
                    this.dispose();
                }

            }
        }

        /*    if (lbl_surcusal_id.getText().equals("0000002")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_2(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000003")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_3(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000004")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_4(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }
         }
         if (lbl_surcusal_id.getText().equals("0000005")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_5(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         ////new deposito
         if (lbl_surcusal_id.getText().equals("0000006")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_6(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000007")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_7(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000008")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_8(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000009")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_9(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000010")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_10(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000011")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_11(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000012")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_12(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000013")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_13(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000014")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_14(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000015")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_15(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000016")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_16(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000017")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_17(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000018")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_18(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000019")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_19(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000020")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_20(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000021")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_21(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000022")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_22(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000023")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_23(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000024")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_24(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000025")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_25(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000026")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_26(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000027")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_27(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000028")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_28(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000029")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_29(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }

         if (lbl_surcusal_id.getText().equals("0000030")) {

         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta.tb_factura.getModel();
         String[] dato = new String[5];
         int c = 0;
         int j = 0;
         String id = txt_cod.getText();
         String des = txt_pro.getText();
         String cant = txt_cant.getText();
         String pre = txt_pre.getText();
         String kg = ("0");

         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar_30(id));

         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         txt_cant.requestFocus();
         } else {
         for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta.tb_factura.getValueAt(i, 0);
         if (id.equals(com)) {
         j = i;
         Ventas_venta.tb_factura.setValueAt(cant, i, 3);
         Ventas_venta.btncalcular.doClick();
         c = c + 1;

         JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
         this.dispose();
         }
         }
         if (c == 0) {
         dato[0] = id;
         dato[1] = des;
         dato[2] = pre;
         dato[3] = cant;
         dato[4] = kg;

         tabladet.addRow(dato);

         Ventas_venta.tb_factura.setModel(tabladet);

         Ventas_venta.btncalcular.doClick();
         this.dispose();
         }

         }

         }*/

    }//GEN-LAST:event_btn_agregar_itemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (lbl_class.getText().equals("10")) {
            cod_pro_mol = txt_cod.getText();
            costos_monedas cm;
            cm = new costos_monedas(new javax.swing.JDialog(), true);
            cm.setVisible(true);
        } else {

            JOptionPane.showMessageDialog(null, "No tiene autorización");

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_pre_ataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pre_ataActionPerformed
        txt_pre.setText(txt_pre_ata.getText());
        txt_pre_a.setSelected(false);
        lbl_precio_b.setSelected(false);
        txt_pre_d.setSelected(false);
    }//GEN-LAST:event_txt_pre_ataActionPerformed

    private void txt_pre_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pre_aActionPerformed
        txt_pre.setText(txt_pre_a.getText());
        txt_pre_ata.setSelected(false);
        lbl_precio_b.setSelected(false);
        txt_pre_d.setSelected(false);
    }//GEN-LAST:event_txt_pre_aActionPerformed

    private void lbl_precio_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_precio_bActionPerformed
        txt_pre.setText(lbl_precio_b.getText());
        txt_pre_ata.setSelected(false);
        txt_pre_a.setSelected(false);
        txt_pre_d.setSelected(false);
    }//GEN-LAST:event_lbl_precio_bActionPerformed

    private void txt_pre_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pre_dActionPerformed
        txt_pre.setText(txt_pre_d.getText());
        txt_pre_ata.setSelected(false);
        txt_pre_a.setSelected(false);
        lbl_precio_b.setSelected(false);
    }//GEN-LAST:event_txt_pre_dActionPerformed

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
            java.util.logging.Logger.getLogger(Precio_modelo_dos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Precio_modelo_dos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Precio_modelo_dos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Precio_modelo_dos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Precio_modelo_dos dialog = new Precio_modelo_dos(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_agregar_item;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox lbl_precio_b;
    private javax.swing.JTextField lbl_stock_separado;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JLabel txt_porcento;
    private javax.swing.JTextField txt_pre;
    private javax.swing.JCheckBox txt_pre_a;
    private javax.swing.JCheckBox txt_pre_ata;
    private javax.swing.JCheckBox txt_pre_d;
    private javax.swing.JTextField txt_pro;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_stock_disponible;
    // End of variables declaration//GEN-END:variables

    void BuscarProductoEditar(String cod) {

        try {

            String stock_separado = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "", desc = "", pre_d = "";
            Connection cn = conectar.getInstance().getConnection();

            String sql = "select p.pro_cod,p.pro_des,p.pro_pre_a,p.pro_pre_b,p.pro_pre_atacado,p.pro_alma,p.pro_pre_d, p.pro_cant, d.descto_dep from tienda_productos as p inner join depar_productos as d on p.pro_depa=d.cod_dep where p.pro_cod='" + cod + "'";
            //String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                des = rs.getString("pro_des");
                codi = rs.getString("pro_cod");
                stock = rs.getString("pro_cant");
                pre_a = rs.getString("pro_pre_a");
                pre_b = rs.getString("pro_pre_b");
                pre_ataca = rs.getString("pro_pre_atacado");
                desc = rs.getString("descto_dep");
                stock_separado = rs.getString("pro_alma");
                pre_d = rs.getString("pro_pre_d");

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
           // txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            txt_descuento.setText(desc);
            lbl_stock_separado.setText(stock_separado);
            
            if (Ventas_venta.txt_class_cli_ventas.getText().equals("MAYORISTAS")) {
                txt_pre.setText(pre_b);
            } else if (Ventas_venta.txt_class_cli_ventas.getText().equals("SUBDISTRIBUIDOR")) {
                txt_pre.setText(pre_ataca);
            } else if (Ventas_venta.txt_class_cli_ventas.getText().equals("DISTRIBUIDOR")) {
                txt_pre.setText(pre_d);
            } else if (Ventas_venta.txt_class_cli_ventas.getText().equals("MINORISTAS")) {
                txt_pre.setText(pre_a);
            }
            
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
                txt_pre_d.setText(pre_d);
            } else {
                txt_pre_ata.setVisible(false);
                txt_pre_d.setVisible(false);
            }

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    String comparar(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(5);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void BuscarProductoEditar_2(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(25);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    String comparar_2(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(25);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void BuscarProductoEditar_3(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(26);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    String comparar_3(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(26);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void BuscarProductoEditar_4(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(27);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    String comparar_4(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(27);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void BuscarProductoEditar_5(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(28);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    String comparar_5(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(28);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    ////
    void BuscarProductoEditar_6(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(29);//
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_7(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(30);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_8(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(31);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_9(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(32);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_10(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(33);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_11(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(34);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_12(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(35);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_13(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(36);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_14(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(37);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_15(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(38);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_16(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(39);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_17(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(40);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_18(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(41);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_19(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(42);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_20(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(43);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            };

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_21(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(44);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_22(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(45);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_23(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(46);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_24(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(47);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_25(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(48);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_26(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(49);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_27(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(50);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_28(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(51);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_29(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(52);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoEditar_30(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_compra = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                des = rs.getString(3);
                codi = rs.getString(1);
                stock = rs.getString(53);
                pre_compra = rs.getString(6);
                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_stock.setText(stock);
            if (lbl_pre_b.getText().equals("S")) {
                lbl_precio_b.setText(pre_b);
            } else {
                lbl_precio_b.setVisible(false);
            }

            if (lbl_pre_c.getText().equals("S")) {
                txt_pre_ata.setText(pre_ataca);
            } else {
                txt_pre_ata.setVisible(false);
            }
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    ///
    String comparar_6(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(29);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_7(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(30);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_8(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(31);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_9(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(32);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_10(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(33);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_11(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(34);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_12(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(35);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_13(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(36);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_14(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(37);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_15(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(38);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_16(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(39);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_17(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(40);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_18(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(41);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_19(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(42);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_20(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(43);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_21(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(44);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_22(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(45);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_23(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(46);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_24(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(47);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_25(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(48);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_26(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(49);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_27(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(50);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_28(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(51);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_29(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(52);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_30(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(53);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_ventas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

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
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
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
                    this.txt_pre.setText(
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
            String Texting = txt_pre.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre.setText(Integrated);
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

    public void control_mini_venta() {

        // totalpre = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(pre_venta.add(pre_minimo).toString());
        //  lbl_total_monto_iva.setText(totalsub);
    }

    public void calcular_porciento() {

        String totalCuentaD = "0";
        BigDecimal Precio_Compra = ingreso.TransformReales(txt_pre.getText());
        BigDecimal ganacia = ingreso.TransformReales(txt_descuento.getText());
        totalCuentaD = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(Precio_Compra.multiply(ganacia).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP).toString());

        txt_porcento.setText(totalCuentaD);

    }

    public void calcular_SaldoO() {

        String totalCuentaD = "0";
        BigDecimal ValorTotal = ingreso.TransformReales(txt_pre.getText());
        BigDecimal ValorGanancia = ingreso.TransformReales(txt_porcento.getText());
        totalCuentaD = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorTotal.subtract(ValorGanancia).toString());

        txt_pre.setText(totalCuentaD);

    }

    public void calcularStockTotal() {

        String stockTotal = txt_stock.getText();
        String stockSeparado = lbl_stock_separado.getText();

        int actual = Integer.parseInt(stockTotal);
        int separa = Integer.parseInt(stockSeparado);
        int total = actual - separa;

        String disponible = String.valueOf(total);

        txt_stock_disponible.setText(disponible);

    }

}
