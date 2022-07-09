/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion_DB;

import Clases.machusculas;
import Productos.excell.Excell_pro;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class config_fiscal_surcu extends javax.swing.JDialog {

    FileInputStream fis;
    int longitudBytes;

    DefaultTableModel model;

    public config_fiscal_surcu(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        txtcod.setEnabled(false);
        txtcod.setVisible(false);
        txt_compra_fiscal.setDocument(new machusculas());
        txt_venta_fiscal.setDocument(new machusculas());
        txt_venta_min.setDocument(new machusculas());
        txt_act_vuelto.setDocument(new machusculas());
        txt_panel_pre_usu.setDocument(new machusculas());
        cargar();
        guardar();

    }

    public static String cod_cuenta_actu = "";

    void cargar() throws IOException {
        String mostrar = "SELECT * FROM empresas";
        ImageIcon foto;
        InputStream is;

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txtcod.setText(rs.getString(1));
                txtnom.setText(rs.getString(2));
                txtdes.setText(rs.getString(3));
                is = rs.getBinaryStream(4);
                cb_model_caja.setSelectedItem(rs.getString(5));
                txt_nro_cuentas.setText(rs.getString(6));
                txt_nom_cuenta.setText(rs.getString(7));
                cb_mod_ticket.setSelectedItem(rs.getString(8));
                cb_tipo_lucro.setSelectedItem(rs.getString(9));
                txt_factura.setText(rs.getString(10));
                txt_timbra.setText(rs.getString(11));
                txt_estable.setText(rs.getString(12));
                txt_seque.setText(rs.getString(13));
                txt_compra_fiscal.setText(rs.getString(14));
                txt_venta_fiscal.setText(rs.getString(15));
                txt_serie.setText(rs.getString(16));
                txt_venta_min.setText(rs.getString(17));
                cb_tipo_ventas.setSelectedItem(rs.getString(18));

                txt_dir_empre.setText(rs.getString(19));
                cb_id_codigo.setSelectedItem(rs.getString(20));
                txt_fecha_inicial.setText(rs.getString(21));
                txt_fecha_final.setText(rs.getString(22));
                txt_act_vuelto.setText(rs.getString(23));
                cb_moneda.setSelectedItem(rs.getString(24));
                cb_tipo_simbolo.setSelectedItem(rs.getString(25));
                txt_panel_pre_usu.setText(rs.getString(26));

                //surc_2//
                txt_fecha_inicial_2.setText(rs.getString(28));
                txt_fecha_fin_2.setText(rs.getString(29));
                txt_nro_timbra_surc_2.setText(rs.getString(30));
                txt_nro_fact_surc_2.setText(rs.getString(31));
                txt_seq_surc_2.setText(rs.getString(32));
                txt_lote_surc_2.setText(rs.getString(33));
                txt_timbra_devol.setText(rs.getString(50));
                //cp
                cb_modelo_cp.setSelectedItem(rs.getString(52));
                //expo
                txt_nro_fact_expo.setText(rs.getString(53));
                txt_nro_timbrado_expo.setText(rs.getString(54));
                txt_nro_seq_expo.setText(rs.getString(55));
                txt_nro_estable_expo.setText(rs.getString(56));
                txt_hab_lote_fact.setText(rs.getString(57));
                cb_tipo_nota_credito.setSelectedItem(rs.getString(58));
                if (is == null) {
                    System.out.println("imagen vacia");
                } else {
                    BufferedImage bi = ImageIO.read(is);
                    foto = new ImageIcon(bi);
                    Image img = foto.getImage();
                    Image newimg = img.getScaledInstance(240, 160, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(newimg);
                    lbl_ima1.setIcon(newicon);
                }
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(config_fiscal_surcu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void guardar() {
        if (txtdes.getText().length() != 0) {

            btnguardar.setEnabled(false);
        } else {
            btnguardar.setEnabled(true);
            // txtcod.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtdes = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_dir_empre = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();
        lbl_ima1 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_nom_cuenta = new javax.swing.JTextField();
        cb_id_codigo = new javax.swing.JComboBox();
        txt_nro_cuentas = new javax.swing.JTextField();
        txt_act_vuelto = new javax.swing.JTextField();
        cb_moneda = new javax.swing.JComboBox();
        cb_tipo_simbolo = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cb_model_caja = new jcomboper.SComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_fecha_inicial = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_fecha_final = new javax.swing.JFormattedTextField();
        txt_factura = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_timbra = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_seque = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_estable = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_venta_fiscal = new javax.swing.JTextField();
        txt_venta_min = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_serie = new javax.swing.JTextField();
        txt_compra_fiscal = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_panel_pre_usu = new javax.swing.JTextField();
        cb_tipo_ventas = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        cb_mod_ticket = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        txt_timbra_devol = new javax.swing.JTextField();
        cb_tipo_lucro = new javax.swing.JComboBox();
        jPanel31 = new javax.swing.JPanel();
        txt_nro_estable_expo = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txt_nro_fact_expo = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txt_nro_timbrado_expo = new javax.swing.JTextField();
        txt_nro_seq_expo = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel169 = new javax.swing.JLabel();
        txt_hab_lote_fact = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        cb_modelo_cp = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        cb_tipo_nota_credito = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txt_fecha_inicial_2 = new javax.swing.JFormattedTextField();
        txt_nro_timbra_surc_2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txt_seq_surc_2 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txt_lote_surc_2 = new javax.swing.JTextField();
        txt_nro_fact_surc_2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txt_fecha_fin_2 = new javax.swing.JFormattedTextField();
        jLabel69 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuentas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTabbedPane1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Configuracion Sucursal Nro 1");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setText("Empresa:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        txtnom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });
        jPanel1.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 390, 30));

        txtdes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdesKeyTyped(evt);
            }
        });
        jPanel1.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 390, 30));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setText("Descripción:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 30));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel23.setText("Dirección:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 30));

        txt_dir_empre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_dir_empre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 390, 30));

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, -1));

        lbl_ima1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(lbl_ima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 240, 160));

        btnguardar.setBackground(new java.awt.Color(0, 102, 153));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setMnemonic('g');
        btnguardar.setText("Guardar");
        btnguardar.setToolTipText("");
        btnguardar.setActionCommand("");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 130, 40));

        btnactualizar.setBackground(new java.awt.Color(0, 102, 153));
        btnactualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizar.setMnemonic('a');
        btnactualizar.setText("Reset");
        btnactualizar.setToolTipText("");
        btnactualizar.setActionCommand("");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 130, 40));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/imagen.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 130, 40));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setText("Stock Física:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 90, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJUSTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 90, 30));

        txt_nom_cuenta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cuenta.setEnabled(false);
        jPanel1.add(txt_nom_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 330, 30));

        cb_id_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cb_id_codigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        jPanel1.add(cb_id_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 50, 30));

        txt_nro_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nro_cuentasActionPerformed(evt);
            }
        });
        txt_nro_cuentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nro_cuentasKeyPressed(evt);
            }
        });
        jPanel1.add(txt_nro_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 50, 30));

        txt_act_vuelto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_act_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 50, 30));

        cb_moneda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_moneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Guaraníes", "Extranjero" }));
        jPanel1.add(cb_moneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 180, 30));

        cb_tipo_simbolo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_tipo_simbolo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gs", "US$", "RS$" }));
        jPanel1.add(cb_tipo_simbolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 80, 30));

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel25.setText("Nota de cred. en:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 110, 30));

        cb_model_caja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_model_caja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(cb_model_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 80, -1));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel26.setText("Simbolo:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 90, 30));

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel27.setText("Monedas:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 90, 30));

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel28.setText("Rgimen Tur:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 90, 30));

        jLabel29.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel29.setText("Modelo ID:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, 30));

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel30.setText("Caja Cuenta:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, 30));

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel31.setText("Vigencia desde:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 110, 30));

        try {
            txt_fecha_inicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_inicial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_fecha_inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 90, 30));

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel32.setText("hasta:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 50, 30));

        try {
            txt_fecha_final.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_final.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_fecha_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 100, 30));

        txt_factura.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 100, 30));

        jLabel33.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel33.setText("Nro. Fact.:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 70, 30));

        txt_timbra.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_timbra, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 120, 30));

        jLabel34.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel34.setText("Timbrado:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 90, 30));

        jLabel35.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel35.setText("Sequencia:");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 90, 30));

        txt_seque.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_seque, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 70, 30));

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel36.setText("Lote-Establ.:");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 80, 30));

        txt_estable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_estable, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 70, 30));

        jLabel37.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel37.setText("Lucro tipo:");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 70, 30));

        jLabel38.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel38.setText("Hora Server");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 90, 30));

        txt_venta_fiscal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_venta_fiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 70, 30));

        txt_venta_min.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_venta_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 50, 30));

        jLabel39.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel39.setText("Venta Mínimo:");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 90, 30));

        txt_serie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serieActionPerformed(evt);
            }
        });
        jPanel1.add(txt_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 80, 30));

        txt_compra_fiscal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_compra_fiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 40, 30));

        jLabel40.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel40.setText("Mod. Tick:");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 70, 30));

        jLabel41.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel41.setText("Compra Fiscal:");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 110, 30));

        jLabel42.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel42.setText("Lote Factura:");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 90, 30));

        jLabel44.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel44.setText("Timbrado NC:");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 30));

        txt_panel_pre_usu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_panel_pre_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 40, 30));

        cb_tipo_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_tipo_ventas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Normal-barras", "Fiscal", "Fiscal-etiqueta" }));
        jPanel1.add(cb_tipo_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 260, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton3.setText("AJUSTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 140, 50));

        cb_mod_ticket.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_mod_ticket.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        jPanel1.add(cb_mod_ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 70, 30));

        jLabel68.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel68.setText("Precio Usu:");
        jPanel1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, 30));

        txt_timbra_devol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_timbra_devol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 100, 30));

        cb_tipo_lucro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_tipo_lucro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        jPanel1.add(cb_tipo_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 70, 30));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EXPORTACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nro_estable_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_estable_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 60, 30));

        jLabel43.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel43.setText("Establecimiento:");
        jPanel31.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 30));

        jLabel72.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel72.setText("Nro. Fact.:");
        jPanel31.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jLabel73.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel73.setText("Timbrado:");
        jPanel31.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        txt_nro_fact_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_fact_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 160, 30));

        jLabel77.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel77.setText("Sequencia:");
        jPanel31.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        txt_nro_timbrado_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_timbrado_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, 30));

        txt_nro_seq_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_seq_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 60, 30));

        jPanel1.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 360, 130));

        jLabel70.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel70.setText("Mod.Ventas:");
        jPanel1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 90, -1));

        jLabel169.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel169.setText("Serie Nro:");
        jPanel1.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, 30));

        txt_hab_lote_fact.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_hab_lote_fact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 40, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shopper.png"))); // NOI18N
        jButton5.setText("SUCURSALES");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 160, 50));

        jLabel51.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel51.setText("Modelo de Factura:");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 130, 30));

        cb_modelo_cp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cb_modelo_cp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2" }));
        jPanel1.add(cb_modelo_cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 80, 30));

        jLabel52.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel52.setText("Modelo CP:");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 90, 30));

        cb_tipo_nota_credito.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_tipo_nota_credito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NV", "NF" }));
        jPanel1.add(cb_tipo_nota_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 80, 30));

        jTabbedPane1.addTab("Surc. 1", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Configuracion Sucursal Nro 2");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel45.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel45.setText("Desde:");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 30));

        try {
            txt_fecha_inicial_2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_inicial_2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(txt_fecha_inicial_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 100, 30));
        jPanel2.add(txt_nro_timbra_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel46.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel46.setText("Timbrado:");
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel47.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel47.setText("Sequencia:");
        jPanel2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel2.add(txt_seq_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel48.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel48.setText("Lote-Establ.:");
        jPanel2.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel2.add(txt_lote_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));
        jPanel2.add(txt_nro_fact_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel49.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel49.setText("Nro. Fact.:");
        jPanel2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));

        jLabel50.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel50.setText("hasta:");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 40, 30));

        try {
            txt_fecha_fin_2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_fin_2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(txt_fecha_fin_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 100, 30));

        jLabel69.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel69.setText("Timbrado NC:");
        jPanel2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, 30));

        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 160, 30));

        jTabbedPane1.addTab("Surc. 2", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel2); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Excell_pro pg;
        pg = new Excell_pro(new javax.swing.JDialog(), true);
        pg.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update_empre();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serieActionPerformed

    private void txt_nro_cuentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_cuentasKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

            Cuentas_config ccc;
            ccc = new Cuentas_config(new javax.swing.JDialog(), true);
            ccc.setVisible(true);

        }
    }//GEN-LAST:event_txt_nro_cuentasKeyPressed

    private void txt_nro_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nro_cuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nro_cuentasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ajuste_stock_manual ecv;
        ecv = new Ajuste_stock_manual(new javax.swing.JDialog(), true);
        ecv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lbl_ima1.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbl_ima1.getWidth(), lbl_ima1.getHeight(), Image.SCALE_DEFAULT);
                    lbl_ima1.setIcon(new ImageIcon(icono));
                    lbl_ima1.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement("DELETE FROM empresas  WHERE id_empre='" + txtcod.getText() + "'");

            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            lbl_ima1.setIcon(null);
            JOptionPane.showMessageDialog(null, "Reseteado");
        } catch (SQLException | HeadlessException e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtnom.getText().length() != 0) {
            String nom, des;
            String sql = "";
            nom = txtnom.getText();
            des = txtdes.getText();

            sql = "INSERT INTO empresas (emp_nom,emp_des,emp_imag) VALUES (?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1, nom);
                pst.setString(2, des);
                pst.setBinaryStream(3, fis, longitudBytes);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                    txtcod.setText("");
                    txtnom.setText("");
                    txtdes.setText("");
                    lbl_ima1.setIcon(null);
                }

            } catch (SQLException ex) {
                Logger.getLogger(config_fiscal_surcu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verife los campos estan vacios");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodKeyTyped

    private void txtdesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyTyped

    }//GEN-LAST:event_txtdesKeyTyped

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped

    }//GEN-LAST:event_txtnomKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            config_sucursales cs;
            cs = new config_sucursales(new javax.swing.JDialog(), true);
            cs.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(config_fiscal_surcu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    config_fiscal_surcu dialog = new config_fiscal_surcu(new javax.swing.JDialog(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(config_fiscal_surcu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox cb_id_codigo;
    private javax.swing.JComboBox cb_mod_ticket;
    private jcomboper.SComboBox cb_model_caja;
    private javax.swing.JComboBox cb_modelo_cp;
    private javax.swing.JComboBox cb_moneda;
    private javax.swing.JComboBox cb_tipo_lucro;
    private javax.swing.JComboBox cb_tipo_nota_credito;
    private javax.swing.JComboBox cb_tipo_simbolo;
    private javax.swing.JComboBox cb_tipo_ventas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_ima1;
    private javax.swing.JTextField txt_act_vuelto;
    private javax.swing.JTextField txt_compra_fiscal;
    private javax.swing.JTextField txt_dir_empre;
    private javax.swing.JTextField txt_estable;
    private javax.swing.JTextField txt_factura;
    private javax.swing.JFormattedTextField txt_fecha_fin_2;
    private javax.swing.JFormattedTextField txt_fecha_final;
    private javax.swing.JFormattedTextField txt_fecha_inicial;
    private javax.swing.JFormattedTextField txt_fecha_inicial_2;
    private javax.swing.JTextField txt_hab_lote_fact;
    private javax.swing.JTextField txt_lote_surc_2;
    public static javax.swing.JTextField txt_nom_cuenta;
    public static javax.swing.JTextField txt_nro_cuentas;
    private javax.swing.JTextField txt_nro_estable_expo;
    private javax.swing.JTextField txt_nro_fact_expo;
    private javax.swing.JTextField txt_nro_fact_surc_2;
    private javax.swing.JTextField txt_nro_seq_expo;
    private javax.swing.JTextField txt_nro_timbra_surc_2;
    private javax.swing.JTextField txt_nro_timbrado_expo;
    private javax.swing.JTextField txt_panel_pre_usu;
    private javax.swing.JTextField txt_seq_surc_2;
    private javax.swing.JTextField txt_seque;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextField txt_timbra;
    private javax.swing.JTextField txt_timbra_devol;
    public static javax.swing.JTextField txt_venta_fiscal;
    private javax.swing.JTextField txt_venta_min;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables

    void update_empre() {

        try {

            String id = txtcod.getText();
            String empre = txtnom.getText();
            String des = txtdes.getText();
            String model_fact = (String) cb_model_caja.getSelectedItem();
            String nro_cuenta = txt_nro_cuentas.getText();
            String nom_cuenta = txt_nom_cuenta.getText();
            String cred = (String) cb_mod_ticket.getSelectedItem();
            String debi = (String) cb_tipo_lucro.getSelectedItem();
            String fac = txt_factura.getText();
            String timbra = txt_timbra.getText();
            String esta = txt_estable.getText();
            String seque = txt_seque.getText();
            String comp_fiscal = txt_compra_fiscal.getText();
            String venta_fiscal = txt_venta_fiscal.getText();
            String iva_cant = txt_serie.getText();
            String venta_min = txt_venta_min.getText();
            String tipo_ventas = (String) cb_tipo_ventas.getSelectedItem();
            String direc = txt_dir_empre.getText();
            String backup = (String) cb_id_codigo.getSelectedItem();
            String desde = txt_fecha_inicial.getText();
            String hasta = txt_fecha_final.getText();
            String vuelto = txt_act_vuelto.getText();
            String moneda = (String) cb_moneda.getSelectedItem();
            String simbolo = (String) cb_tipo_simbolo.getSelectedItem();
            String pre_usu = txt_panel_pre_usu.getText();
            ////surc 2//////
            String init_surc_2 = txt_fecha_inicial_2.getText();
            String fin_surc_2 = txt_fecha_fin_2.getText();
            String timbra_surc_2 = txt_nro_timbra_surc_2.getText();
            String nro_fact_surc_2 = txt_nro_fact_surc_2.getText();
            String seq_surc_2 = txt_seq_surc_2.getText();
            String lote_surc_2 = txt_lote_surc_2.getText();
            String timbra_devol_central = txt_timbra_devol.getText();

            String nro_fact_expo = txt_nro_fact_expo.getText();
            String nro_timbra_expo = txt_nro_timbrado_expo.getText();
            String nro_seq_expo = txt_nro_seq_expo.getText();
            String nro_estable_expo = txt_nro_estable_expo.getText();
            ///lote
            String hab_lote = txt_hab_lote_fact.getText();
            //cp
            String modelo_cp = cb_modelo_cp.getSelectedItem().toString();
            //nota de credito select
            String nota_credito_cliente = cb_tipo_nota_credito.getSelectedItem().toString();

            String sql = "UPDATE empresas SET emp_nom = '" + empre
                    + "',emp_des ='" + des
                    + "',caja_ra ='" + model_fact
                    + "',nro_cta ='" + nro_cuenta
                    + "',nom_cta ='" + nom_cuenta
                    + "',tarje_cre ='" + cred
                    + "',tarje_deb ='" + debi
                    + "',nro_fact ='" + fac
                    + "',nro_timbra ='" + timbra
                    + "',nro_estable ='" + esta
                    + "',nro_sequencia ='" + seque
                    + "',compra_fiscal ='" + comp_fiscal
                    + "',venta_fiscal ='" + venta_fiscal
                    + "',iva_por ='" + iva_cant
                    + "',venta_min ='" + venta_min
                    + "',tipo_ventas ='" + tipo_ventas
                    + "',dir_empre ='" + direc
                    + "',dir_backup ='" + backup
                    + "',fecha_desde ='" + desde
                    + "',fecha_hasta ='" + hasta
                    + "',activa_vuelto ='" + vuelto
                    + "',mon_default ='" + moneda
                    + "',mon_tipo ='" + simbolo
                    + "',control_pre_usu ='" + pre_usu
                    //surc_2///
                    + "',fecha_init_surc_2 ='" + init_surc_2
                    + "',fecha_fin_surc_2 ='" + fin_surc_2
                    + "',timbra_surc_2 ='" + timbra_surc_2
                    + "',nro_fact_surc_2 ='" + nro_fact_surc_2
                    + "',seq_surc_2 ='" + seq_surc_2
                    + "',lote_surc_2 ='" + lote_surc_2
                    + "',timbra_devol_central ='" + timbra_devol_central
                    + "',nro_fact_expo ='" + nro_fact_expo
                    + "',nro_timbrado_expo ='" + nro_timbra_expo
                    + "',nro_seq_expo ='" + nro_seq_expo
                    + "',nro_estable_expo ='" + nro_estable_expo
                    + "',activa_lote ='" + hab_lote
                    + "',timbra_24 ='" + modelo_cp
                    + "',model_nota_cred ='" + nota_credito_cliente
                    + "' WHERE id_empre = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }
}
