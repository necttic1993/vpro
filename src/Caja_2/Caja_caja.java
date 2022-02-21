/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2;

import Caja_2.O.S.Caja_OS;
import Caja_2.O.S.Caja_OS_cancela;
import Caja_2.Pago_Plazos.Cancela_pago_cred;
import Caja_2.Pago_Plazos.Recibo_cancela_fact;
import Caja_2.Pago_Plazos.tipo_recibo;
import Caja_2.compras.Compras_caja;
import Caja_2.compras.Compras_caja_cancela;
import Caja_2.compras_plazo.Cancela_Compra_cred;
import Caja_2.compras_plazo.Pago_cred_compras;
import Caja_2.devoluciones.devoluciones_caja;
import Caja_2.devoluciones.devoluciones_caja_cancela;
import Caja_2.egresos.caja_gastos;
import Caja_2.egresos.caja_gastos_cancela;
import Clases.machusculas;
import Clientes.credito_cliente;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_fecha_principal;
import static Loggin_Principal.Principal.lbl_mone_def;
import static Loggin_Principal.Principal.lbl_usu_nom;
import static Loggin_Principal.Principal.txt_simbolo;
import Ventas.forma_pago.Forma_pago_gral;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author User
 */
public class Caja_caja extends javax.swing.JDialog {

    DefaultTableModel model;
    private String forma;

    public Caja_caja(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setSize(999, 500);
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_caja.setBackground(new java.awt.Color(69, 84, 92));

        }
        txt_nom_cuenta.setDisabledTextColor(Color.blue);
        txt_his_caja.setDisabledTextColor(Color.blue);
        txt_his_tipo.setDisabledTextColor(Color.blue);
        btn_calcular.setVisible(false);
        //lbl_calculo.setVisible(false);
        lbl_monto.setVisible(false);
        txtl_monto_caja.setVisible(false);
        panel_forma_pago.setVisible(false);
        txt_des_caja.setDocument(new machusculas());
        cargarConfig();
        cargarUsu();
        control_caja();
        panel_tablas.setVisible(false);
        txt_nro_docu.setEnabled(false);
        txt_des_caja.setEnabled(false);
        panel_calculo.setVisible(false);

        if (txt_alma_caja.getText().equals("TODOS") || txt_alma_caja.getText().equals("0000001")) {
            actualiza();
        }

    }

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    public static String id_doc_nro = "";
    public static String id_nro_cuenta = "";
    public static String total_doc = "";
    public static String sucursal = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_caja = new javax.swing.JPanel();
        txt_id_his = new javax.swing.JTextField();
        txt_his_caja = new javax.swing.JTextField();
        txt_his_tipo = new javax.swing.JTextField();
        txt_nom_cuenta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_nro_his = new javax.swing.JTextField();
        btn_confirmar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_total_gs = new javax.swing.JLabel();
        txt_des_caja = new javax.swing.JTextField();
        txt_nro_docu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtl_monto_caja = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        valor_gs_caja = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbl_info_devol = new javax.swing.JLabel();
        lbl_info_ventas = new javax.swing.JLabel();
        lbl_info_compras = new javax.swing.JLabel();
        lbl_info_egresos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        lbl_monto = new javax.swing.JLabel();
        lbl_empresa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_cuentas = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        panel_calculo = new javax.swing.JPanel();
        porcento_tar = new javax.swing.JLabel();
        total_porcento_tar = new javax.swing.JLabel();
        txt_calc_mixto = new javax.swing.JLabel();
        total_mixto = new javax.swing.JLabel();
        lbl_calc_info = new javax.swing.JLabel();
        panel_tablas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_compras = new javax.swing.JTable();
        status_forma = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_egresos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_devoluciones = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbl_valor_cre = new javax.swing.JLabel();
        lbl_valor_deb = new javax.swing.JLabel();
        lbl_almacen = new javax.swing.JLabel();
        lbl_caja = new javax.swing.JLabel();
        lbl_tempo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_calcular = new javax.swing.JButton();
        lbl_calculo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_alma_caja = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_sucursal = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        panel_forma_pago = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caja");
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(250, 10));
        setResizable(false);

        panel_caja.setBackground(new java.awt.Color(255, 255, 255));
        panel_caja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_his.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_his.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_his.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_his.setEnabled(false);
        txt_id_his.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_hisActionPerformed(evt);
            }
        });
        txt_id_his.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_hisKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_id_hisKeyReleased(evt);
            }
        });
        panel_caja.add(txt_id_his, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 145, 70, 32));

        txt_his_caja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_his_caja.setEnabled(false);
        panel_caja.add(txt_his_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 145, 320, 32));

        txt_his_tipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_his_tipo.setEnabled(false);
        panel_caja.add(txt_his_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 145, 70, 32));

        txt_nom_cuenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cuenta.setEnabled(false);
        panel_caja.add(txt_nom_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 440, 32));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/chart.png"))); // NOI18N
        jButton1.setMnemonic('v');
        jButton1.setText("Mov. caja");
        jButton1.setToolTipText("Ver listado de Mov. de caja");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_caja.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 150, 50));

        txt_nro_his.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nro_his.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nro_his.setToolTipText("Buscar Cuentas");
        txt_nro_his.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nro_his.setEnabled(false);
        txt_nro_his.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nro_hisActionPerformed(evt);
            }
        });
        txt_nro_his.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nro_hisKeyPressed(evt);
            }
        });
        panel_caja.add(txt_nro_his, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 70, 32));

        btn_confirmar.setBackground(new java.awt.Color(255, 255, 255));
        btn_confirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_confirmar.setMnemonic('c');
        btn_confirmar.setText("Confirmar  ");
        btn_confirmar.setToolTipText("Confirmar Operación");
        btn_confirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confirmar.setBorderPainted(false);
        btn_confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        panel_caja.add(btn_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 150, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("Total :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        lbl_total_gs.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_total_gs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total_gs.setText("0");
        jPanel3.add(lbl_total_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 190, 30));

        panel_caja.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 300, 50));

        txt_des_caja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_des_caja.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_des_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_des_cajaActionPerformed(evt);
            }
        });
        txt_des_caja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_des_cajaKeyPressed(evt);
            }
        });
        panel_caja.add(txt_des_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 530, 30));

        txt_nro_docu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nro_docu.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nro_docu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nro_docuKeyPressed(evt);
            }
        });
        panel_caja.add(txt_nro_docu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 160, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notifications/sensor.gif"))); // NOI18N
        jLabel14.setText("Procesando...");
        panel_caja.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 340, 90));

        txtl_monto_caja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtl_monto_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtl_monto_cajaActionPerformed(evt);
            }
        });
        txtl_monto_caja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtl_monto_cajaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtl_monto_cajaKeyReleased(evt);
            }
        });
        panel_caja.add(txtl_monto_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 190, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Descripción:");
        panel_caja.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        valor_gs_caja.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        valor_gs_caja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(valor_gs_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel26.setText("Saldo :");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        panel_caja.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 320, 50));

        jPanel8.setBackground(new java.awt.Color(0, 102, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_caja.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, -1, 30));

        lbl_info_devol.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_info_devol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_info_devol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cash.png"))); // NOI18N
        lbl_info_devol.setText("0");
        lbl_info_devol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        lbl_info_devol.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel_caja.add(lbl_info_devol, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 140, 70));

        lbl_info_ventas.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_info_ventas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_info_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ventas.png"))); // NOI18N
        lbl_info_ventas.setText("0");
        lbl_info_ventas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        lbl_info_ventas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel_caja.add(lbl_info_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 305, 140, 70));

        lbl_info_compras.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_info_compras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_info_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/add.png"))); // NOI18N
        lbl_info_compras.setText("0");
        lbl_info_compras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        lbl_info_compras.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel_caja.add(lbl_info_compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 305, 140, 70));

        lbl_info_egresos.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_info_egresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_info_egresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/strategy.png"))); // NOI18N
        lbl_info_egresos.setText("0");
        lbl_info_egresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        lbl_info_egresos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel_caja.add(lbl_info_egresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 140, 70));

        jSeparator2.setForeground(new java.awt.Color(0, 102, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel_caja.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 10, 440));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("CLICK PARA AGREGAR FORMA DE PAGO");
        panel_caja.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 290, 20));

        lbl_monto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_monto.setText("Monto :");
        panel_caja.add(lbl_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 60, 30));

        lbl_empresa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_empresa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel_caja.add(lbl_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 510, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Tipo:");
        panel_caja.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 145, -1, 32));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_caja.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 120, 48));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/agregando-boton-cuadrado-negro-simbolo-de-interfaz.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_caja.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 145, 32, 32));

        btn_cuentas.setBackground(new java.awt.Color(255, 255, 255));
        btn_cuentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cuentas.setForeground(new java.awt.Color(255, 255, 255));
        btn_cuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/agregando-boton-cuadrado-negro-simbolo-de-interfaz.png"))); // NOI18N
        btn_cuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cuentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cuentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuentasActionPerformed(evt);
            }
        });
        panel_caja.add(btn_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 32, 32));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 204));
        jSeparator3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panel_caja.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 320, 10));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Compras");
        panel_caja.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 140, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ventas ");
        panel_caja.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Egresos ");
        panel_caja.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 140, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Devoluciones");
        panel_caja.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 140, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 102, 204));
        jSeparator4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panel_caja.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 630, 10));

        panel_calculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        porcento_tar.setText("0");
        panel_calculo.add(porcento_tar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        total_porcento_tar.setText("0");
        panel_calculo.add(total_porcento_tar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 20, -1));

        txt_calc_mixto.setText("0");
        panel_calculo.add(txt_calc_mixto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        total_mixto.setText("0");
        panel_calculo.add(total_mixto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        lbl_calc_info.setText("0");
        panel_calculo.add(lbl_calc_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, -1));

        panel_caja.add(panel_calculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 100, 70));

        panel_tablas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_ventas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ventasMouseClicked(evt);
            }
        });
        tb_ventas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_ventasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ventas);

        panel_tablas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 20));

        jLabel2.setText("dev");
        panel_tablas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        tb_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_compras);

        panel_tablas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 50, 20));

        status_forma.setText("NO");
        panel_tablas.add(status_forma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 30, -1));

        tb_egresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tb_egresos);

        panel_tablas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 20));

        jLabel4.setText("compras");
        panel_tablas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        tb_devoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tb_devoluciones);

        panel_tablas.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 50, 20));

        jLabel5.setText("egresos");
        panel_tablas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lbl_valor_cre.setText("0");
        panel_tablas.add(lbl_valor_cre, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 90, 40, -1));

        lbl_valor_deb.setText("0");
        panel_tablas.add(lbl_valor_deb, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 50, -1));

        lbl_almacen.setText("empresa");
        panel_tablas.add(lbl_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        lbl_caja.setText("caja");
        panel_tablas.add(lbl_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        lbl_tempo.setText("tempo");
        panel_tablas.add(lbl_tempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 40, -1));

        jLabel6.setText("ventas");
        panel_tablas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });
        panel_tablas.add(btn_calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 40, 20));

        lbl_calculo.setText("0");
        panel_tablas.add(lbl_calculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 50, 20));

        panel_caja.add(panel_tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 170, 70));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/undra.png"))); // NOI18N
        jLabel1.setToolTipText("Agregar forma de pago");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 153), null, null));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panel_caja.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 300, 160));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/banco.png"))); // NOI18N
        jLabel11.setText("Las operaciones son por default en efectivo");
        panel_caja.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 340, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Pendientes:");
        panel_caja.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, -1, 20));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/diner.png"))); // NOI18N
        jButton4.setToolTipText("Listar Pagos");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel_caja.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 90, 45));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Cuenta N°:");
        panel_caja.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 32));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_alma_caja.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_alma_caja.setForeground(new java.awt.Color(0, 0, 204));
        txt_alma_caja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txt_alma_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 120, 32));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel23.setText("Sucursal:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 32));

        btn_sucursal.setBackground(new java.awt.Color(255, 255, 255));
        btn_sucursal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_sucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shopper.png"))); // NOI18N
        btn_sucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sucursal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_sucursal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sucursalActionPerformed(evt);
            }
        });
        jPanel2.add(btn_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 6, 40, 40));

        panel_caja.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 270, 50));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setText("EMPRESA:");
        panel_caja.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel22.setText("Sucursal:");
        panel_caja.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 32));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel24.setText("Forma de Pago:");
        panel_caja.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, 30));

        panel_forma_pago.setBackground(new java.awt.Color(153, 0, 0));
        panel_forma_pago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(204, 51, 0));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Forma de pago agregado a la nota !!!");
        panel_forma_pago.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 290, 40));

        panel_caja.add(panel_forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 300, 40));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Nota Nro.:");
        panel_caja.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 80, 30));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setText("Históricos:");
        panel_caja.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 145, 80, 32));

        getContentPane().add(panel_caja, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed

        if (txt_his_tipo.getText().equals("C")) {
            calcularC();
        }
        if (txt_his_tipo.getText().equals("D")) {
            calcularD();
        }
        if (txt_his_tipo.getText().equals("N")) {
            JOptionPane.showMessageDialog(this, "Valores Neutros");
        }

    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed

        this.setSize(999, 605);

        btn_confirmar.setBackground(Color.white);
        btn_confirmar.setEnabled(false);
        refresh_caja();
        btn_calcular.doClick();

////////////////////////////CREDITO//////////////////////////////
        String Ventas = txt_his_caja.getText();
        String canc_comp = txt_his_caja.getText();
        String canc_dev = txt_his_caja.getText();
        String canc_egre = txt_his_caja.getText();
        String os = txt_his_caja.getText();
        String credito_cliente = txt_his_caja.getText();
        String cancela_compra_cred = txt_his_caja.getText();
        /////////////////////////DEBITO///////////////////////////////////
        String can_ventas = txt_his_caja.getText();
        String compras = txt_his_caja.getText();
        String dev = txt_his_caja.getText();
        String egre = txt_his_caja.getText();
        String canc_os = txt_his_caja.getText();
        String canc_tarjeta = txt_his_caja.getText();
        String pago_compra_cred = txt_his_caja.getText();
        ///////////////////NEUTROS////////////////////////////////////////
        String conf_compras = txt_his_caja.getText();
        String conf_ventas = txt_his_caja.getText();
        ////////////////////////////////////////////CREDITO////////////////////////////////////
        if ((txt_nom_cuenta.getText().equals("")) && (txt_his_caja.getText().equals("")) && (txt_des_caja.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Cuenta o histórico no fueron agregados");
        } else {
            if ((txt_his_tipo.getText().equals("C"))) {

                if ((Ventas.equals("VENTAS")) || (cancela_compra_cred.equals("CANC. PAGO COMPRA CRED.")) || (credito_cliente.equals("CREDITO CTA CLIENTE")) || (os.equals("O.S")) || (canc_comp.equals("CANC. NOTA DE COMPRA")) || (canc_dev.equals("CANC. NOTA DE DEV.")) || (canc_egre.equals("CANC. NOTA DE EGRESO"))) {

                    if ((txt_his_caja.getText().contains("VENTAS"))) {

                        cajaCredito();
                        actCuenta();
                        if (status_forma.getText().equals("NO")) {
                            saved();
                        }
                        actEstadoVentas();
                        limpiar();

                    }

                    if ((txt_his_caja.getText().contains("CANC. NOTA DE COMPRA"))) {
                        cajaCredito();
                        actCuenta();
                        actEstadoComprasCanc();
                        limpiar();
                    }

                    if ((txt_his_caja.getText().contains("CANC. PAGO COMPRA CRED."))) {
                        cajaCredito();
                        actCuenta();
                        actEstadoComprasCanc();
                        limpiar();
                    }

                    if ((txt_his_caja.getText().contains("CANC. NOTA DE DEV."))) {
                        cajaCredito();
                        actCuenta();
                        actEstadoDevolucionCancela();
                        limpiar();
                    }

                    if ((txt_his_caja.getText().contains("CREDITO CTA CLIENTE"))) {
                        cajaCredito();
                        actCuenta();
                        actCreditoCli();
                        limpiar();
                    }
                    if ((txt_his_caja.getText().contains("CANC. NOTA DE EGRESO"))) {
                        cajaCredito();
                        actCuenta();
                        actEstadoEgresoCancela();
                        limpiar();
                    }
                    if ((txt_his_caja.getText().contains("O.S"))) {
                        cajaCredito();
                        actCuenta();
                        actEstadoOS();
                        if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                                "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            Reportes reporte = new Reportes();
                            try {
                                reporte.os_caja(Caja_caja.txt_nro_docu.getText());

                            } catch (SQLException | JRException ex) {
                                Logger.getLogger(Caja_caja.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        limpiar();
                    }

                } else {
                    cajaCredito();
                    actCuenta();
                    limpiar();
                }
            }

            ///////////////////////////////////DEBITO///////////////////////////////////////
            if ((txt_his_tipo.getText().equals("D"))) {
                String resultado = "0";
                BigDecimal saldoB = ingreso.TransformReales(valor_gs_caja.getText());
                BigDecimal totalB = ingreso.TransformReales(lbl_total_gs.getText());

                if (saldoB.compareTo(totalB) == 1) {
                    resultado = "1";
                    System.out.println("mayor");
                } else if (saldoB.compareTo(totalB) == 0) {
                    resultado = "0";
                    System.out.println("igual");

                } else {
                    resultado = "-1";
                    System.out.println("menor");
                }
                if (resultado.equals("-1")) {
                    JOptionPane.showMessageDialog(this, "Cuenta saldo insuficiente para la operación");
                    lbl_total_gs.setText("0");
                    txt_nro_docu.setText("");
                    txt_des_caja.setText("");
                    txtl_monto_caja.setText("");
                    btn_confirmar.setEnabled(true);

                } else {

                    if ((can_ventas.equals("CANC. NOTA DE VENTA")) || (pago_compra_cred.equals("PAGO DE COMPRAS A CREDITO")) || (canc_os.equals("CANC. ORDEN DE SERV.")) || (compras.equals("COMPRAS")) || (dev.equals("DEVOLUCIONES")) || (egre.equals("EGRESOS"))) {

                        if ((txt_his_caja.getText().contains("CANC. NOTA DE VENTA"))) {
                            cajaDebito();
                            actCuenta();
                            actEstadoVentasCanc();
                            eliminarFormaPago();
                            limpiar();
                        }
                        if ((txt_his_caja.getText().contains("COMPRAS"))) {
                            cajaDebito();
                            actCuenta();
                            actEstadoCompras();
                            limpiar();
                        }

                        if ((txt_his_caja.getText().contains("DEVOLUCIONES"))) {
                            cajaDebito();
                            actCuenta();
                            actEstadoDevolucion();
                            limpiar();
                        }

                        if ((txt_his_caja.getText().contains("EGRESOS"))) {
                            cajaDebito();
                            actCuenta();
                            actEstadoEgreso();
                            limpiar();
                        }

                        if ((txt_his_caja.getText().contains("CANC. ORDEN DE SERV."))) {
                            cajaDebito();
                            actCuenta();
                            actEstadoOSCanc();
                            limpiar();
                        }
                        if ((txt_his_caja.getText().contains("PAGO DE COMPRAS A CREDITO"))) {
                            cajaDebito();
                            actCuenta();
                            actEstadoCompras();
                            limpiar();
                        }

                    } else {
                        cajaDebito();
                        actCuenta();
                        limpiar();
                    }
                }
            }
            //////////////////////NEUTROS/////////////////////////////

            if ((txt_his_tipo.getText().equals("N"))) {
                if ((conf_ventas.equals("CONF. DE SALIDAS")) || (conf_compras.equals("AJUSTES DE ENTRADAS"))) {
                    if ((txt_his_caja.getText().equals("CONF. DE SALIDAS"))) {
                        cajaNeutro();
                        actEstadoVentas();
                        limpiar();
                    }
                    if ((txt_his_caja.getText().equals("AJUSTES DE ENTRADAS"))) {
                        cajaNeutro();
                        actEstadoCompras();
                        limpiar();
                    }

                }
            }
            this.setSize(999, 500);
        }
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void txt_nro_hisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_hisKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

        if (Tecla == KeyEvent.VK_ENTER) {

            if (txt_nro_his.getText().equals("")) {
                Cuentas_listar_caja clcaja;
                clcaja = new Cuentas_listar_caja(new javax.swing.JDialog(), true);
                clcaja.setVisible(true);
            } else {
                txt_id_his.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_nro_hisKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((txt_nom_cuenta.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta existente");
            txt_nro_his.requestFocus();
        } else {
            Mov_cuenta movcaja;
            movcaja = new Mov_cuenta(new javax.swing.JDialog(), true);
            movcaja.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_id_hisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_hisKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_nro_his.requestFocus();
            txt_id_his.setText("");
            txt_his_caja.setText("");
            txt_his_tipo.setText("");

        }
        if (Tecla == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_txt_id_hisKeyPressed

    private void txt_id_hisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_hisActionPerformed
        historicos_caja_2 hg;
        hg = new historicos_caja_2(new javax.swing.JDialog(), true);
        hg.setVisible(true);
    }//GEN-LAST:event_txt_id_hisActionPerformed

    private void txt_des_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_des_cajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_des_cajaActionPerformed

    private void txt_nro_hisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nro_hisActionPerformed
        Cuentas_listar_caja clcaja;
        clcaja = new Cuentas_listar_caja(new javax.swing.JDialog(), true);
        clcaja.setVisible(true);
    }//GEN-LAST:event_txt_nro_hisActionPerformed

    private void txt_nro_docuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_docuKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {

            txt_nro_docu.setText("");
            txtl_monto_caja.setText("");
            lbl_total_gs.setText("");

        }
    }//GEN-LAST:event_txt_nro_docuKeyPressed

    private void txt_des_cajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_des_cajaKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_nro_docu.requestFocus();
            txt_des_caja.setText("");
            txtl_monto_caja.setText("");

        }
    }//GEN-LAST:event_txt_des_cajaKeyPressed

    private void txtl_monto_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtl_monto_cajaActionPerformed

    }//GEN-LAST:event_txtl_monto_cajaActionPerformed

    private void txtl_monto_cajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtl_monto_cajaKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_nro_docu.requestFocus();
            txtl_monto_caja.setText("");
            lbl_total_gs.setText("");

        }

        /*  String monto = txtl_monto_caja.getText();
         lbl_total_gs.setText(monto);
         btn_calcular.doClick();*/
    }//GEN-LAST:event_txtl_monto_cajaKeyPressed

    private void txtl_monto_cajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtl_monto_cajaKeyReleased
        ActivatedYourLife(txtl_monto_caja, evt);
        String monto = txtl_monto_caja.getText();
        lbl_total_gs.setText(monto);
        btn_calcular.doClick();
    }//GEN-LAST:event_txtl_monto_cajaKeyReleased

    private void txt_id_hisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_hisKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_hisKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        btn_confirmar.setBackground(Color.red);
        String Ventas = txt_his_caja.getText();
        String canc_Ventas = txt_his_caja.getText();
        String pago = txt_his_caja.getText();
        String canc_compra = txt_his_caja.getText();
        String devo = txt_his_caja.getText();
        String canc_dev = txt_his_caja.getText();
        String egreso = txt_his_caja.getText();
        String canc_egre = txt_his_caja.getText();
        String os = txt_his_caja.getText();
        String canc_os = txt_his_caja.getText();
        String pago_plazo = txt_his_caja.getText();
        String pago_tarjeta = txt_his_caja.getText();
        String pago_rec_canc = txt_his_caja.getText();
        String ventas_A = txt_his_caja.getText();
        String compras_A = txt_his_caja.getText();
        String compras_P = txt_his_caja.getText();
        String cancela_rec_fact = txt_his_caja.getText();
        String cancela_compra_cred = txt_his_caja.getText();
        String pago_compra_cred = txt_his_caja.getText();

        if ((Ventas.equals("VENTAS")) || (Ventas.equals("CREDITO CTA CLIENTE")) || (pago_compra_cred.equals("PAGO A PROVEEDORES")) || (cancela_compra_cred.equals("CANC. PAGO COMPRA CRED.")) || (cancela_rec_fact.equals("CANC. REC. FISCAL")) || (compras_P.equals("CANC. NOTA DE COMPRA")) || (compras_A.equals("CONF. DE SALIDAS")) || (ventas_A.equals("AJUSTES DE ENTRADAS")) || (pago_rec_canc.equals("CANC. RECIBOS")) || (pago_tarjeta.equals("TARJETA(VTA)")) || (pago_plazo.equals("RECIBIMIENTO PARCIAL VTA. CRÉDITO")) || (canc_Ventas.equals("CANC. NOTA DE VENTA")) || (pago.equals("COMPRAS")) || (canc_compra.equals("CANC. NOTA DE COMPRA")) || (devo.equals("DEVOLUCIONES")) || (canc_dev.equals("CANC. NOTA DE DEV.")) || (egreso.equals("EGRESOS")) || (canc_egre.equals("CANC. NOTA DE EGRESO")) || (os.equals("O.S")) || (canc_os.equals("CANC. ORDEN DE SERV."))) {

            if ((txt_his_caja.getText().contains("VENTAS"))) {

                Caja_ventas_contado cv;
                cv = new Caja_ventas_contado(new javax.swing.JDialog(), true);
                cv.setVisible(true);
            }
            if ((txt_his_caja.getText().contains("CANC. NOTA DE VENTA"))) {

                Caja_ventas_cancela cvc;
                cvc = new Caja_ventas_cancela(new javax.swing.JDialog(), true);
                cvc.setVisible(true);
            }

            if ((txt_his_caja.getText().contains("COMPRAS"))) {

                Compras_caja comcaja;
                comcaja = new Compras_caja(new javax.swing.JDialog(), true);
                comcaja.setVisible(true);
            }

            if ((txt_his_caja.getText().contains("CANC. NOTA DE COMPRA"))) {

                Compras_caja_cancela comcaja;
                comcaja = new Compras_caja_cancela(new javax.swing.JDialog(), true);
                comcaja.setVisible(true);
            }
            if ((txt_his_caja.getText().contains("DEVOLUCIONES"))) {

                devoluciones_caja devcaja;
                devcaja = new devoluciones_caja(new javax.swing.JDialog(), true);
                devcaja.setVisible(true);
            }
            if ((txt_his_caja.getText().contains("CANC. NOTA DE DEV."))) {

                devoluciones_caja_cancela devcaja;
                devcaja = new devoluciones_caja_cancela(new javax.swing.JDialog(), true);
                devcaja.setVisible(true);
            }

            if ((txt_his_caja.getText().contains("EGRESOS"))) {
                caja_gastos egrecaja;
                egrecaja = new caja_gastos(new javax.swing.JDialog(), true);
                egrecaja.setVisible(true);
            }

            if ((txt_his_caja.getText().contains("CANC. NOTA DE EGRESO"))) {
                caja_gastos_cancela egrecaja;
                egrecaja = new caja_gastos_cancela(new javax.swing.JDialog(), true);
                egrecaja.setVisible(true);
            }

            if ((txt_his_caja.getText().contains("O.S"))) {
                Caja_OS oscaja;
                oscaja = new Caja_OS(new javax.swing.JDialog(), true);
                oscaja.setVisible(true);
            }

            if ((txt_his_caja.getText().contains("CANC. ORDEN DE SERV."))) {
                Caja_OS_cancela oscaja_can;
                oscaja_can = new Caja_OS_cancela(new javax.swing.JDialog(), true);
                oscaja_can.setVisible(true);
            }
            if ((txt_his_caja.getText().equals("RECIBIMIENTO PARCIAL VTA. CRÉDITO"))) {
                tipo_recibo tre;
                tre = new tipo_recibo(new javax.swing.JDialog(), true);
                tre.setVisible(true);

            }

            if ((txt_his_caja.getText().equals("CONF. DE SALIDAS"))) {
                JOptionPane.showMessageDialog(null, "Seleccionar únicamente nota a ser ajustada");
                Caja_ventas_contado cv;
                cv = new Caja_ventas_contado(new javax.swing.JDialog(), true);
                cv.setVisible(true);
            }

            if ((txt_his_caja.getText().equals("AJUSTES DE ENTRADAS"))) {

                JOptionPane.showMessageDialog(null, "Seleccionar únicamente nota a ser ajustada");
                Compras_caja comcaja;
                comcaja = new Compras_caja(new javax.swing.JDialog(), true);
                comcaja.setVisible(true);
            }

            if ((txt_his_caja.getText().equals("PAGO A PROVEEDORES"))) {
                Pago_cred_compras ppcom;
                ppcom = new Pago_cred_compras(new javax.swing.JDialog(), true);
                ppcom.setVisible(true);
            }

            if ((txt_his_caja.getText().equals("CANC. PAGO COMPRA CRED."))) {
                Cancela_Compra_cred cancc;
                cancc = new Cancela_Compra_cred(new javax.swing.JDialog(), true);
                cancc.setVisible(true);
            }
            if ((txt_his_caja.getText().equals("CREDITO CTA CLIENTE"))) {
                credito_cliente crecl;
                crecl = new credito_cliente(new javax.swing.JDialog(), true);
                crecl.setVisible(true);
            }
            if ((txt_his_caja.getText().equals("CANC. RECIBOS"))) {
                Cancela_pago_cred crc;
                crc = new Cancela_pago_cred(new javax.swing.JDialog(), true);
                crc.setVisible(true);
            }
            if ((txt_his_caja.getText().equals("CANC. REC. FISCAL"))) {
                Recibo_cancela_fact crf;
                crf = new Recibo_cancela_fact(new javax.swing.JDialog(), true);
                crf.setVisible(true);
            }
            lbl_monto.setVisible(false);
            txtl_monto_caja.setVisible(false);
        } else {
            if (txt_his_caja.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione un histórico válido");
            } else {

                txt_nro_docu.setEnabled(true);
                txt_des_caja.setEnabled(true);
                txtl_monto_caja.setEnabled(true);
                txt_nro_docu.setText("");
                txt_des_caja.setText("");
                lbl_total_gs.setText("0");
                txt_nro_docu.requestFocus();
                lbl_monto.setVisible(true);
                txtl_monto_caja.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuentasActionPerformed
        Cuentas_listar_caja clcaja;
        clcaja = new Cuentas_listar_caja(new javax.swing.JDialog(), true);
        clcaja.setVisible(true);
    }//GEN-LAST:event_btn_cuentasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txt_alma_caja.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(null, "Seleccione un Almacen/Surcusal");
        } else {

            Surcusal_historicos_caja shg;
            shg = new Surcusal_historicos_caja(new javax.swing.JDialog(), true);
            shg.setVisible(true);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventasMouseClicked
        /*int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_ventasMouseClicked

    private void tb_ventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventasKeyReleased

    }//GEN-LAST:event_tb_ventasKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        if (lbl_total_gs.getText().equals("0") || txt_alma_caja.getText().equals("TODOS") || txt_nro_his.getText().equals("") || txt_id_his.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Realice primero una operación válida");
        } else {
            id_doc_nro = txt_nro_docu.getText();
            id_nro_cuenta = txt_nro_his.getText();
            total_doc = lbl_total_gs.getText();
            sucursal = txt_alma_caja.getText();
            panel_forma_pago.setVisible(true);
            status_forma.setText("SI");
            Forma_pago_gral fvv = null;
            fvv = new Forma_pago_gral(new javax.swing.JDialog(), true);
            fvv.setVisible(true);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

         //   id_nro_cuenta = txt_nro_his.getText();
        //  sucursal = txt_alma_caja.getText();
        List_forma_pago_caja LFP;
        LFP = new List_forma_pago_caja(new javax.swing.JDialog(), true);
        LFP.setVisible(true);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sucursalActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            //limpiar();
            Caja_almacen_select am;
            am = new Caja_almacen_select(new javax.swing.JDialog(), true);
            am.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No cuenta con autorización");
        }
    }//GEN-LAST:event_btn_sucursalActionPerformed

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
            java.util.logging.Logger.getLogger(Caja_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Caja_caja dialog = new Caja_caja(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_calcular;
    public static javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_cuentas;
    private javax.swing.JButton btn_sucursal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_almacen;
    private javax.swing.JLabel lbl_caja;
    private javax.swing.JLabel lbl_calc_info;
    private javax.swing.JLabel lbl_calculo;
    private javax.swing.JLabel lbl_empresa;
    private javax.swing.JLabel lbl_info_compras;
    private javax.swing.JLabel lbl_info_devol;
    private javax.swing.JLabel lbl_info_egresos;
    private javax.swing.JLabel lbl_info_ventas;
    private javax.swing.JLabel lbl_monto;
    public static javax.swing.JLabel lbl_tempo;
    public static javax.swing.JLabel lbl_total_gs;
    private javax.swing.JLabel lbl_valor_cre;
    private javax.swing.JLabel lbl_valor_deb;
    private javax.swing.JPanel panel_caja;
    private javax.swing.JPanel panel_calculo;
    private javax.swing.JPanel panel_forma_pago;
    private javax.swing.JPanel panel_tablas;
    private javax.swing.JLabel porcento_tar;
    private javax.swing.JLabel status_forma;
    private javax.swing.JTable tb_compras;
    private javax.swing.JTable tb_devoluciones;
    private javax.swing.JTable tb_egresos;
    public static javax.swing.JTable tb_ventas;
    private javax.swing.JLabel total_mixto;
    private javax.swing.JLabel total_porcento_tar;
    public static javax.swing.JLabel txt_alma_caja;
    private javax.swing.JLabel txt_calc_mixto;
    public static javax.swing.JTextField txt_des_caja;
    public static javax.swing.JTextField txt_his_caja;
    public static javax.swing.JTextField txt_his_tipo;
    public static javax.swing.JTextField txt_id_his;
    public static javax.swing.JTextField txt_nom_cuenta;
    public static javax.swing.JTextField txt_nro_docu;
    public static javax.swing.JTextField txt_nro_his;
    private javax.swing.JTextField txtl_monto_caja;
    public static javax.swing.JLabel valor_gs_caja;
    // End of variables declaration//GEN-END:variables

    void cajaCredito() {
        if ((txt_his_tipo.getText().equals("C"))) {

            String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo,cuenta_nro,cuenta_nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            String descaja = txt_des_caja.getText();
            String total_gs = lbl_total_gs.getText();
            String his = txt_id_his.getText();
            String egreso_gs = ("0");
            String id_pago = ("0");
            String fecha_caja = lbl_fecha_hoy.getText();
            String user = lbl_usu_nom.getText();
            String moneda = txt_simbolo.getText();
            String tipo_caja = ("C");
            String nro_cuenta = txt_nro_his.getText();
            String nom_cuenta = txt_nom_cuenta.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, descaja);
                pst.setString(2, total_gs);
                pst.setString(3, his);
                pst.setString(4, egreso_gs);
                pst.setString(5, id_pago);
                pst.setString(6, fecha_caja);
                pst.setString(7, user);
                pst.setString(8, moneda);
                pst.setString(9, tipo_caja);
                pst.setString(10, nro_cuenta);
                pst.setString(11, nom_cuenta);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {

                    JOptionPane.showMessageDialog(null, "Confirmado");

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Por Favor contacte cpon el soporte de Necttic item: Caja");
            }
        }

    }

    void cajaDebito() {
        if ((txt_his_tipo.getText().equals("D"))) {

            String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo,cuenta_nro,cuenta_nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            String descaja = txt_des_caja.getText();
            String total_gs = ("0");
            String his = txt_id_his.getText();
            String egreso_gs = lbl_total_gs.getText();
            String id_pago = ("0");
            String fecha_caja = lbl_fecha_hoy.getText();
            String user = lbl_usu_nom.getText();
            String moneda = txt_simbolo.getText();
            String tipo_caja = ("D");
            String nro_cuenta = txt_nro_his.getText();
            String nom_cuenta = txt_nom_cuenta.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, descaja);
                pst.setString(2, total_gs);
                pst.setString(3, his);
                pst.setString(4, egreso_gs);
                pst.setString(5, id_pago);
                pst.setString(6, fecha_caja);
                pst.setString(7, user);
                pst.setString(8, moneda);
                pst.setString(9, tipo_caja);
                pst.setString(10, nro_cuenta);
                pst.setString(11, nom_cuenta);
                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {

                    JOptionPane.showMessageDialog(null, "Confirmado");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Caja_caja.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    void cajaNeutro() {
        if ((txt_his_tipo.getText().equals("N"))) {

            String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo,cuenta_nro,cuenta_nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            String descaja = txt_des_caja.getText();
            String total_gs = ("0");
            String his = txt_id_his.getText();
            String egreso_gs = ("0");
            String id_pago = ("0");
            String fecha_caja = lbl_fecha_hoy.getText();
            String user = lbl_usu_nom.getText();
            String moneda = txt_simbolo.getText();
            String tipo_caja = ("N");
            String nro_cuenta = txt_nro_his.getText();
            String nom_cuenta = txt_nom_cuenta.getText();

            try {

                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, descaja);
                pst.setString(2, total_gs);
                pst.setString(3, his);
                pst.setString(4, egreso_gs);
                pst.setString(5, id_pago);
                pst.setString(6, fecha_caja);
                pst.setString(7, user);
                pst.setString(8, moneda);
                pst.setString(9, tipo_caja);
                pst.setString(10, nro_cuenta);
                pst.setString(11, nom_cuenta);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {

                    JOptionPane.showMessageDialog(null, "Confirmado");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Caja_caja.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    void actCuenta() {

        try {
            String id = txt_nro_his.getText();
            String saldo = lbl_calculo.getText();

            String sql = "UPDATE cuentas SET saldo_cuenta = '" + saldo
                    + "' WHERE nro_cuentas = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                // JOptionPane.showMessageDialog(null, "Actualizado");
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    /////credito cliente
    void actCreditoCli() {

        try {
            String es = lbl_tempo.getText();
            String nro = txt_nro_docu.getText();

            String sql = "UPDATE tienda_clientes SET cli_lim_cre = '" + es
                    + "' WHERE cli_cod = '" + nro + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }
////////////////////VENTAS_CAJA////////////////////////////////

    void actEstadoVentas() {
        if (txt_alma_caja.getText().equals("0000001")) {
            try {
                String es = ("CONFIRMADA");
                String transf = ("AUTORIZADO");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas SET estado_ventas = '" + es
                        + "',status_log ='" + transf
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
        //2
        if (txt_alma_caja.getText().equals("0000002")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_2 SET estado_ventas = '" + es
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
        //3
        if (txt_alma_caja.getText().equals("0000003")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_3 SET estado_ventas = '" + es
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

        //4
        if (txt_alma_caja.getText().equals("0000004")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_4 SET estado_ventas = '" + es
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

        //5
        if (txt_alma_caja.getText().equals("0000005")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_5 SET estado_ventas = '" + es
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

        if (txt_alma_caja.getText().equals("0000006")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_6 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000007")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_7 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000008")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_8 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000009")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_9 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000010")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_10 SET estado_ventas = '" + es
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
        //11
        if (txt_alma_caja.getText().equals("0000011")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_11 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000012")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_12 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000013")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_13 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000014")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_14 SET estado_ventas = '" + es
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
        //15
        if (txt_alma_caja.getText().equals("0000015")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_15 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000016")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_16 SET estado_ventas = '" + es
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
        //17
        if (txt_alma_caja.getText().equals("0000017")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_17 SET estado_ventas = '" + es
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
        //18
        if (txt_alma_caja.getText().equals("0000018")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_18 SET estado_ventas = '" + es
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
        //19
        if (txt_alma_caja.getText().equals("0000019")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_19 SET estado_ventas = '" + es
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
        //20
        if (txt_alma_caja.getText().equals("0000020")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_20 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000021")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_21 SET estado_ventas = '" + es
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
        //22
        if (txt_alma_caja.getText().equals("0000022")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_22 SET estado_ventas = '" + es
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

        //23
        if (txt_alma_caja.getText().equals("0000023")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_23 SET estado_ventas = '" + es
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

        //23
        if (txt_alma_caja.getText().equals("0000024")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_24 SET estado_ventas = '" + es
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

        if (txt_alma_caja.getText().equals("0000025")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_25 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000026")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_26 SET estado_ventas = '" + es
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

        if (txt_alma_caja.getText().equals("0000027")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_27 SET estado_ventas = '" + es
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

        if (txt_alma_caja.getText().equals("0000028")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_28 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000029")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_29 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000030")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_30 SET estado_ventas = '" + es
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

    void actEstadoVentasCanc() {
        if (txt_alma_caja.getText().equals("0000001")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

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
        //2
        if (txt_alma_caja.getText().equals("0000002")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_2 SET estado_ventas = '" + es
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
        //3
        if (txt_alma_caja.getText().equals("0000003")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_3 SET estado_ventas = '" + es
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

        //4
        if (txt_alma_caja.getText().equals("0000004")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_4 SET estado_ventas = '" + es
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

        //5
        if (txt_alma_caja.getText().equals("0000005")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_5 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000006")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_6 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000007")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_7 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000008")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_8 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000009")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_9 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000010")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_10 SET estado_ventas = '" + es
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

        //11
        if (txt_alma_caja.getText().equals("0000011")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_11 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000012")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_12 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000013")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_13 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000014")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_14 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000015")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_15 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000016")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_16 SET estado_ventas = '" + es
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
        //17
        if (txt_alma_caja.getText().equals("0000017")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_17 SET estado_ventas = '" + es
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
        //18
        if (txt_alma_caja.getText().equals("0000018")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_18 SET estado_ventas = '" + es
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

        //19
        if (txt_alma_caja.getText().equals("0000019")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_19 SET estado_ventas = '" + es
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
        //20
        if (txt_alma_caja.getText().equals("0000020")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_20 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000021")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_21 SET estado_ventas = '" + es
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
        //22
        if (txt_alma_caja.getText().equals("0000022")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_22 SET estado_ventas = '" + es
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

        //22
        //23
        if (txt_alma_caja.getText().equals("0000023")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_23 SET estado_ventas = '" + es
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
        //24
        if (txt_alma_caja.getText().equals("0000024")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_24 SET estado_ventas = '" + es
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

        if (txt_alma_caja.getText().equals("0000025")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_25 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000026")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_26 SET estado_ventas = '" + es
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

        if (txt_alma_caja.getText().equals("0000027")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_27 SET estado_ventas = '" + es
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

        if (txt_alma_caja.getText().equals("0000028")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_28 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000029")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_29 SET estado_ventas = '" + es
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
        if (txt_alma_caja.getText().equals("0000030")) {

            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE ventas_30 SET estado_ventas = '" + es
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
///////////////////COMPRAS_CAJA/////////////////////////////////

    void actEstadoCompras() {

        try {
            String es = ("CONFIRMADA");
            String nro = txt_nro_docu.getText();

            String sql = "UPDATE compras SET estado_comp = '" + es
                    + "' WHERE cod_comp = '" + nro + "'";
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

    void actEstadoComprasCanc() {

        try {
            String es = ("FINALIZADA");
            String nro = txt_nro_docu.getText();

            String sql = "UPDATE compras SET estado_comp = '" + es
                    + "' WHERE cod_comp = '" + nro + "'";
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

    ///////////////////DEVOLUCIONES_CAJA////////////////////////
    void actEstadoDevolucion() {
        if (txt_alma_caja.getText().equals("0000001")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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

        //2
        if (txt_alma_caja.getText().equals("0000002")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_2 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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

        if (txt_alma_caja.getText().equals("0000003")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_3 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000004")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_4 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000005")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_5 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000006")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_6 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000007")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_7 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000008")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_8 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000009")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_9 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000010")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_10 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000011")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_11 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000012")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_12 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000013")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_13 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000014")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_14 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000015")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_15 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000016")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_16 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000018")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_18 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000019")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_19 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000020")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_20 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000021")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_21 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000022")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_22 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000023")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_23 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000024")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_24 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000025")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_25 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        if (txt_alma_caja.getText().equals("0000026")) {
            try {
                String es = ("CONFIRMADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_26 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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

    void actEstadoDevolucionCancela() {
        if (txt_alma_caja.getText().equals("0000001")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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

        //2
        if (txt_alma_caja.getText().equals("0000002")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_2 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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

        //2
        if (txt_alma_caja.getText().equals("0000003")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_3 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000004")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_4 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000005")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_5 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000006")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_6 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000007")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_7 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000008")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_8 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000009")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_9 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000010")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_10 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000011")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_11 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000012")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_12 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000013")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_13 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000014")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_14 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000015")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_15 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000016")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_16 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000017")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_17 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000018")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_18 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000019")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_19 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000020")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_20 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000021")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_21 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000022")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_22 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000023")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_23 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000024")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_24 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000025")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_25 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
        //2
        if (txt_alma_caja.getText().equals("0000026")) {
            try {
                String es = ("FINALIZADA");
                String nro = txt_nro_docu.getText();

                String sql = "UPDATE devoluciones_surc_26 SET estado_dev = '" + es
                        + "' WHERE cod_dev = '" + nro + "'";
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
/////////////////////////////////////////EGRESOS///////////////////////////////////////////

    void actEstadoEgreso() {

        try {
            String es = ("CONFIRMADA");
            String nro = txt_nro_docu.getText();

            String sql = "UPDATE gastos SET gas_situ = '" + es
                    + "' WHERE gas_id = '" + nro + "'";
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

    void actEstadoEgresoCancela() {

        try {
            String es = ("FINALIZADA");
            String nro = txt_nro_docu.getText();

            String sql = "UPDATE gastos SET gas_situ = '" + es
                    + "' WHERE gas_id = '" + nro + "'";
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

    ///////////////////////////////O.S/////////////////////////////////////
    void actEstadoOS() {

        try {
            String es = ("PAGADO");
            String nro = txt_nro_docu.getText();

            String sql = "UPDATE os SET os_status = '" + es
                    + "' WHERE os_nro = '" + nro + "'";
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

    void actEstadoOSCanc() {

        try {
            String es = ("ANULADO");
            String nro = txt_nro_docu.getText();

            String sql = "UPDATE os SET os_status = '" + es
                    + "' WHERE os_nro = '" + nro + "'";
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

    public void calcularD() {

        String totalCuentaD = "0";
        BigDecimal ValorTotal = ingreso.TransformReales(lbl_total_gs.getText());
        BigDecimal ValorCuenta = ingreso.TransformReales(valor_gs_caja.getText());
        totalCuentaD = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorCuenta.subtract(ValorTotal).toString());

        lbl_calculo.setText(totalCuentaD);

    }

    public void calcularC() {

        String totalCuenta = "0";
        BigDecimal ValorTotal = ingreso.TransformReales(lbl_total_gs.getText().replaceAll("\\s", ""));
        BigDecimal ValorCuenta = ingreso.TransformReales(valor_gs_caja.getText().replaceAll("\\s", ""));
        totalCuenta = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorTotal.add(ValorCuenta).toString());
        lbl_calculo.setText(totalCuenta);

    }

    void limpiar() {

        lbl_total_gs.setText("0");
        txt_nro_docu.setText("");
        txt_des_caja.setText("");
        txtl_monto_caja.setText("");
        status_forma.setText("NO");

        txt_nro_docu.setEnabled(false);
        txt_des_caja.setEnabled(false);
        txtl_monto_caja.setEnabled(false);
        btn_confirmar.setEnabled(true);
        panel_forma_pago.setVisible(false);
        String id_ca_cu = txt_nro_his.getText();
        cargar_caja_cuenta(id_ca_cu);

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
                    this.txtl_monto_caja.setText(
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
            String Texting = txtl_monto_caja.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txtl_monto_caja.setText(Integrated);
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

    void cargarConfig() {
        String mostrar = "SELECT * FROM empresas";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_empresa.setText(rs.getString(2));
                lbl_valor_cre.setText(rs.getString(8));
                lbl_valor_deb.setText(rs.getString(9));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Caja_caja.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////////////////////////////panel informacion//////////////////////////////////////
    void cargar() {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas WHERE  estado_ventas = 'FINALIZADA' AND forma_pag_ventas='CONTADO'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tb_ventas.setModel(model);
            for (int i = 0; i <= tb_ventas.getRowCount(); i++) {
                lbl_info_ventas.setText("" + i);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_compras() {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from compras WHERE  estado_comp = 'FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tb_compras.setModel(model);
            for (int i = 0; i <= tb_compras.getRowCount(); i++) {
                lbl_info_compras.setText("" + i);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_egresos() {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from gastos WHERE  gas_situ = 'FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);

                model.addRow(registros);
            }
            tb_egresos.setModel(model);
            for (int i = 0; i <= tb_egresos.getRowCount(); i++) {
                lbl_info_egresos.setText("" + i);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_devol() {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones WHERE  estado_dev = 'FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);

                model.addRow(registros);
            }
            tb_devoluciones.setModel(model);
            for (int i = 0; i <= tb_devoluciones.getRowCount(); i++) {
                lbl_info_devol.setText("" + i);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_caja_cuenta(String cod) {
        String mostrar = "SELECT * FROM cuentas WHERE nro_cuentas= '" + cod + "'  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                valor_gs_caja.setText(rs.getString(4));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Caja_caja.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarUsu() {

        String user = Principal.lbl_id_user.getText();
        String mostrar = "select * from usuarios where usu_cod='" + user + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_almacen.setText(rs.getString(6));
                lbl_caja.setText(rs.getString(7));
                txt_alma_caja.setText(rs.getString(6));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Caja_caja.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void control_caja() {

        if (lbl_caja.getText().equals("TODOS")) {

        } else {
            String def = lbl_caja.getText();

            String mostrar = "SELECT * FROM cuentas WHERE nro_cuentas= '" + def + "'  ";

            try {
                Connection cn = conectar.getInstance().getConnection();

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(mostrar);
                while (rs.next()) {
                    txt_nro_his.setText(rs.getString(1));
                    txt_nom_cuenta.setText(rs.getString(2));
                    valor_gs_caja.setText(rs.getString(4));

                }
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(Caja_caja.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

            btn_cuentas.setEnabled(false);

        }

    }

    void refresh_caja() {

        String def = lbl_caja.getText();

        String mostrar = "SELECT * FROM cuentas WHERE nro_cuentas= '" + def + "'  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_his.setText(rs.getString(1));
                txt_nom_cuenta.setText(rs.getString(2));
                valor_gs_caja.setText(rs.getString(4));
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Caja_caja.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualiza() {

        Timer timer = new Timer();
        TimerTask tesk = new TimerTask() {
            int Cont = 0;

            @Override
            public void run() {
                cargar();
                cargar_compras();
                cargar_egresos();
                cargar_devol();
                refresh_caja();

            }
        };
        timer.schedule(tesk, 500, 10000);
    }

    public void saved() {

        String sql = "";
        String nro_doc = ("1");
        String tipo_pago = ("EFECTIVO");
        String pago_cont = ("PARTICULAR");
        String clas = ("EFECTIVO");
        String monto = lbl_total_gs.getText();
        String fecha_det_con = lbl_fecha_hoy.getText();
        String fecha_vista = lbl_fecha_principal.getText();
        String user = lbl_usu_nom.getText();
        String nro_doc_pag = txt_nro_docu.getText();
        String nro_cuenta_pag = txt_nro_his.getText();
        String almacen = txt_alma_caja.getText();

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

            }

        } catch (SQLException ex) {

            Logger.getLogger(Forma_pago_gral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void eliminarFormaPago() {

        String nro_venta = txt_nro_docu.getText();
        String sucur = txt_alma_caja.getText();
        String eliminarSQL = "DELETE FROM forma_pago  WHERE nro_doc_pag = '" + nro_venta + "' AND pago_surc= '" + sucur + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
