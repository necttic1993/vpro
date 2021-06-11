/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticas_productos;

import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.txt_fecha_backup;
import Productos.items.Categorias_List_stock;
import Productos.items.Departamentos_List_stock;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Roberto
 */
public class stock_minimo extends javax.swing.JDialog {

    DefaultTableModel tabla;
    FileInputStream fis;
    int longitudBytes;
    DefaultTableModel model;

    public stock_minimo(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        //cargar("");
        txtprod.setDocument(new machusculas());

        txt_tama.setEnabled(false);
        txtprod.requestFocus();
        txt_tama.setDocument(new machusculas());

    }

    public static String cod_pro_ventas = "";
    public static String cod_pro_dep = "";
    public static String cod_pro_cat = "";
    public static String cod_pro_mini = "";

    void cargar(String valor, String cat, String departa) {
        try {
            Connection cn = conectar.getInstance().getConnection();

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

            String cons = " select * from tienda_productos WHERE pro_cant <= '" + valor + "' AND pro_depa = '" + departa + "'AND pro_cat ='" + cat + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tbprod.setModel(model);
            tbprod.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(148);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(340);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_tama(String valor, String cat, String departa, String Tam) {
        try {
            Connection cn = conectar.getInstance().getConnection();

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "T/M"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

            String cons = " select * from tienda_productos WHERE pro_cant <= '" + valor + "' AND pro_depa = '" + departa + "'AND pro_cat ='" + cat + "' AND pro_tama ='" + Tam + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(15);

                model.addRow(registros);
            }
            tbprod.setModel(model);
            tbprod.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(148);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(340);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(75);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtprod = new javax.swing.JTextField();
        bus = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbprod = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_catalogo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ch_ventas = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txt_tama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_cant_pro = new javax.swing.JTextField();
        txt_id_dep_stock = new javax.swing.JTextField();
        txt_id_cate_stock = new javax.swing.JTextField();
        txt_nom_dep_stock = new javax.swing.JTextField();
        txt_nom_cate_stock = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Productos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtprod.setText("999");
        txtprod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });
        jPanel1.add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 30));

        bus.setMnemonic('w');
        bus.setText("...");
        bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busActionPerformed(evt);
            }
        });
        jPanel1.add(bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 0, 30));

        btnsalir.setMnemonic('s');
        btnsalir.setText("..");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 0, -1));

        tbprod = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbprod.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprod.setRequestFocusEnabled(false);
        tbprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbprodMouseClicked(evt);
            }
        });
        tbprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbprodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbprodKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbprod);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 990, 430));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setToolTipText("Consultar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 60, 60));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("T/M:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Categoría:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Departamento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        btn_catalogo.setBackground(new java.awt.Color(255, 255, 255));
        btn_catalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/foto.png"))); // NOI18N
        btn_catalogo.setToolTipText("Ver catálogo");
        btn_catalogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_catalogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_catalogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_catalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_catalogoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_catalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 70, 60));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        jButton2.setToolTipText("Imprimir Listado en Excell");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 70, 60));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        jButton3.setToolTipText("Imprimir Listado");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 70, 60));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ch_ventas.setBackground(new java.awt.Color(255, 255, 255));
        ch_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_ventas.setForeground(new java.awt.Color(255, 255, 255));
        ch_ventas.setText("Incluir T/M");
        ch_ventas.setContentAreaFilled(false);
        ch_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_ventasActionPerformed(evt);
            }
        });
        jPanel2.add(ch_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 120, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Stock menor a :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        txt_tama.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tama.setText("0");
        jPanel1.add(txt_tama, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 90, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 70, 30));

        txt_cant_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cant_pro.setText("0");
        txt_cant_pro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_cant_pro.setEnabled(false);
        jPanel1.add(txt_cant_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 550, 130, 30));

        txt_id_dep_stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_dep_stock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_dep_stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_dep_stock.setEnabled(false);
        jPanel1.add(txt_id_dep_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 90, 30));

        txt_id_cate_stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_cate_stock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_cate_stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cate_stock.setEnabled(false);
        jPanel1.add(txt_id_cate_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 90, 30));

        txt_nom_dep_stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_dep_stock.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_dep_stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_dep_stock.setEnabled(false);
        jPanel1.add(txt_nom_dep_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 370, 30));

        txt_nom_cate_stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cate_stock.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_cate_stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cate_stock.setEnabled(false);
        jPanel1.add(txt_nom_cate_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 370, 30));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 60, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
        // TODO add your handling code here:
        //  cargar(txtprod.getText());
    }//GEN-LAST:event_txtprodKeyReleased

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
        txtprod.requestFocus();
        txtprod.setText("");

    }//GEN-LAST:event_busActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tbprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprodMouseClicked

    }//GEN-LAST:event_tbprodMouseClicked

    private void tbprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyPressed

    }//GEN-LAST:event_tbprodKeyPressed

    private void tbprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyReleased

    }//GEN-LAST:event_tbprodKeyReleased

    private void tbprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyTyped

    }//GEN-LAST:event_tbprodKeyTyped

    private void txtprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
        if (Tecla == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_txtprodKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cod = txtprod.getText();
        String cat = txt_id_cate_stock.getText();
        String departa = txt_id_dep_stock.getText();
        String tam = txt_tama.getText();

        if (ch_ventas.isSelected()) {
            cargar_tama(cod, cat, departa, tam);
            calcularcantida();
        } else {
            cargar(cod, cat, departa);
            calcularcantida();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_catalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_catalogoActionPerformed
        if (ch_ventas.isSelected()) {

        } else {
            try {
                Connection cn = conectar.getInstance().getConnection();
                String cat = txt_id_cate_stock.getText();
                String departa = txt_id_dep_stock.getText();

                Map parametro = new HashMap();
                parametro.clear();
                parametro.put("depar", departa);
                parametro.put("cat", cat);

                URL in = this.getClass().getResource("/Impresiones/catalogo.jasper");
                JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
                JasperViewer ver = new JasperViewer(print, false);
                ver.setTitle("Productos");
                ver.setVisible(true);
                conectar.getInstance().closeConnection(cn);

            } catch (JRException ex) {

            } catch (SQLException ex) {
                Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.dispose();
    }//GEN-LAST:event_btn_catalogoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*   if (ch_ventas.isSelected()) {
         try {
         reporteProd_t();
         } catch (IOException ex) {
         Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
         }
         } else {
         try {
         reporteProd();
         } catch (IOException ex) {
         Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
         }
         }

         this.dispose();*/

        String cat = txt_id_cate_stock.getText();
        String departa = txt_id_dep_stock.getText();
        String min = txtprod.getText();

        cod_pro_dep = departa;
        cod_pro_cat = cat;
        cod_pro_mini = min;
        Exporta_excell_precios_dep dp;
        dp = new Exporta_excell_precios_dep(new javax.swing.JDialog(), true);
        dp.setVisible(true);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (ch_ventas.isSelected()) {
            try {

                String cat = txt_id_cate_stock.getText();
                String departa = txt_id_dep_stock.getText();
                String min = txtprod.getText();
                String tama = txt_tama.getText();
                Connection cn = conectar.getInstance().getConnection();

                Map parametro = new HashMap();
                parametro.clear();
                parametro.put("depa", departa);
                parametro.put("cate", cat);
                parametro.put("minimo", min);
                parametro.put("tm", tama);

                URL in = this.getClass().getResource("/Impresiones/Listado_stock_cat_depa_tm.jasper");
                JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
                JasperViewer ver = new JasperViewer(print, false);
                ver.setTitle("Listado Departamentos-Categorías-T/M");
                ver.setVisible(true);
                conectar.getInstance().closeConnection(cn);

            } catch (JRException ex) {

            } catch (SQLException ex) {
                Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Connection cn = conectar.getInstance().getConnection();

                String cat = txt_id_cate_stock.getText();
                String departa = txt_id_dep_stock.getText();
                String min = txtprod.getText();

                Map parametro = new HashMap();
                parametro.clear();
                parametro.put("depa", departa);
                parametro.put("cate", cat);
                parametro.put("minimo", min);

                URL in = this.getClass().getResource("/Impresiones/Listado_stock_cat_depa.jasper");
                JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
                JasperViewer ver = new JasperViewer(print, false);
                ver.setTitle("Listado Departamentos-Categorías");
                ver.setVisible(true);
                conectar.getInstance().closeConnection(cn);

            } catch (JRException ex) {

            } catch (SQLException ex) {
                Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ch_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_ventasActionPerformed
        txt_tama.setEnabled(true);
        btn_catalogo.setEnabled(false);
    }//GEN-LAST:event_ch_ventasActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        Categorias_List_stock cl;
        cl = new Categorias_List_stock(new javax.swing.JDialog(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        Departamentos_List_stock dl;
        dl = new Departamentos_List_stock(new javax.swing.JDialog(), true);
        dl.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(stock_minimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock_minimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock_minimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock_minimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                stock_minimo dialog = new stock_minimo(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_catalogo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton bus;
    private javax.swing.JCheckBox ch_ventas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tbprod;
    private javax.swing.JTextField txt_cant_pro;
    public static javax.swing.JTextField txt_id_cate_stock;
    public static javax.swing.JTextField txt_id_dep_stock;
    public static javax.swing.JTextField txt_nom_cate_stock;
    public static javax.swing.JTextField txt_nom_dep_stock;
    public static javax.swing.JTextField txt_tama;
    public static javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables

    public static void reporteProd() throws IOException {
        String cat = txt_id_cate_stock.getText();
        String departa = txt_id_dep_stock.getText();
        String minimo = txtprod.getText();

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Productos");

        try {
           // InputStream is = new FileInputStream("Iconos_1\\loog_multi.png");
            // byte[] bytes = IOUtils.toByteArray(is);
            // int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            // is.close();

            //  CreationHelper help = book.getCreationHelper();
            // Drawing draw = sheet.createDrawingPatriarch();
            // ClientAnchor anchor = help.createClientAnchor();
            //anchor.setCol1(0);
            // anchor.setRow1(1);
            // Picture pict = draw.createPicture(anchor, imgIndex);
            // pict.resize(1, 3);
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 12);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Productos Departamentos-Categorías");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));

            String[] cabecera = new String[]{"Código", "Código de Barras", "Nombre", "Descripción", "Cantidad", "Departamento"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 10);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement ps;
            ResultSet rs;

            int numFilaDatos = 6;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            Connection cn = conectar.getInstance().getConnection();

            ps = cn.prepareStatement("SELECT pro_cod, pro_cod_barra, pro_des, pro_des_espec,pro_cant,pro_depa FROM tienda_productos WHERE pro_cant <='" + minimo + "' AND pro_depa='" + departa + "' AND pro_cat='" + cat + "'");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                /* Cell celdaImporte = filaDatos.createCell(4);
                 celdaImporte.setCellStyle(datosEstilo);
                 celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));*/
                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Reporte_Productos__Departamento_Categoria" + txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void reporteProd_t() throws IOException {
        String cat = txt_id_cate_stock.getText();
        String departa = txt_id_dep_stock.getText();
        String minimo = txtprod.getText();
        String tama = txt_tama.getText();

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Productos");

        try {
           // InputStream is = new FileInputStream("Iconos_1\\loog_multi.png");
            // byte[] bytes = IOUtils.toByteArray(is);
            // int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            // is.close();

            //  CreationHelper help = book.getCreationHelper();
            // Drawing draw = sheet.createDrawingPatriarch();
            // ClientAnchor anchor = help.createClientAnchor();
            //anchor.setCol1(0);
            // anchor.setRow1(1);
            // Picture pict = draw.createPicture(anchor, imgIndex);
            // pict.resize(1, 3);
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 12);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Productos Departamentos-Categorías-T/M");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));

            String[] cabecera = new String[]{"Código", "Código de Barras", "Nombre", "Descripción", "Cantidad", "Departamento", "T/M"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 10);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement ps;
            ResultSet rs;

            int numFilaDatos = 7;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            Connection cn = conectar.getInstance().getConnection();

            ps = cn.prepareStatement("SELECT pro_cod, pro_cod_barra, pro_des, pro_des_espec,pro_cant,pro_depa,pro_tama FROM tienda_productos WHERE pro_cant <='" + minimo + "' AND pro_depa='" + departa + "' AND pro_cat='" + cat + "'AND pro_tama ='" + tama + "'");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                /* Cell celdaImporte = filaDatos.createCell(4);
                 celdaImporte.setCellStyle(datosEstilo);
                 celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));*/
                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Reporte_Productos__Departamento_Categoria_Tamaño" + txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(stock_minimo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularcantida() {

        String impt = "0", subtotalt = "0";

        for (int i = 0; i < tbprod.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tbprod.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            impt = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalt = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalt).add(ingreso.TransformReales(impt)).toString());

            txt_cant_pro.setText(subtotalt);
        }

    }//FIN METODO
}
