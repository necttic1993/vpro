/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Clases.Clase_Literal;
import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_fecha_principal;
import static Loggin_Principal.Principal.lbl_usu_almacen;
import static Loggin_Principal.Principal.lbl_usu_nom;
import static Loggin_Principal.Principal.txt_act_vuelto;
import static Loggin_Principal.Principal.txt_simbolo;
import static Ventas.Principal_ventas.lbl_almacen_ventas;
import Ventas.pago_caja_rapida.Forma_pago_gral_rap;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author user
 */
public class Ventas_venta extends javax.swing.JDialog {

    /**
     * Creates new form facturacion
     *
     * @param parent
     */
    public Ventas_venta(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_info.setBackground(new java.awt.Color(26, 53, 91));
            panel_info_all.setBackground(new java.awt.Color(26, 53, 91));
            panel_total_2.setBackground(new java.awt.Color(26, 53, 91));
            panel_total.setBackground(new java.awt.Color(26, 53, 91));
            txttotal.setForeground(new java.awt.Color(219, 219, 219));
        } else {
        }
        // Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 20, 20);
        //  AWTUtilities.setWindowShape(this, forma);
        codigos();
        cargar();
        cargarConfig();
        cargarCuenta();
        CajaR();
        btncalcular.setVisible(false);
        lbl_caja_rap.setText(Principal.lbl_usu_caj_rap.getText());
        txt_cli_nom.setDisabledTextColor(Color.black);
        lbl_fecha_VISOR.setText(lbl_fecha_principal.getText());
        tb_factura.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_factura.getColumnModel().getColumn(1).setPreferredWidth(323);
        tb_factura.getColumnModel().getColumn(2).setPreferredWidth(120);
        tb_factura.getColumnModel().getColumn(3).setPreferredWidth(75);
        tb_factura.getColumnModel().getColumn(4).setPreferredWidth(75);
        tb_factura.getColumnModel().getColumn(5).setPreferredWidth(120);

        txt_des_ventas.setDocument(new machusculas());
        chk_contado.setSelected(true);
        lbl_plazos_dias.setVisible(false);
        txt_dias_plazo.setVisible(false);
        lbl_literal_pro.setVisible(false);
        lbl_literal.setVisible(false);
        btn_mone.setVisible(false);
        // lbl_nro_cuenta.setVisible(false);
        // lbl_nom_cuenta.setVisible(false);
        panel_calculo.setVisible(false);
        pn_amortizacion.setVisible(false);
        btn_calc_amortizacion.setVisible(false);
        lbl_total_amort.setVisible(false);
        lbl_sur_nombre.setVisible(false);
        lbl_default_id.setVisible(false);
        lbl_tipo_venta.setText("CONTADO");
        txt_usu_ventas.setText(lbl_usu_nom.getText());
        lbl_sur_nombre.setText(lbl_usu_almacen.getText());

    }

    public static String cod_alamacen_user = "";

    void CajaR() {

        if (Principal.lbl_usu_caj_rap.getText().equals("SI")) {
            btn_cajaR.setVisible(true);
            btnven.setVisible(false);

        } else {
            btn_cajaR.setVisible(false);
            btnven.setVisible(true);
        }

    }

    public static String nro_nota_plazo = "";
    public static String tota_ventas = "";
    public static String id_venta_pago_ventas_normal = "";
    public static String id_nro_cuentas = "";
    public static String total_ventas_normal = "";

    public static String id_doc_nro_ventas = "";
    public static String id_nro_cuenta_ventas = "";
    public static String total_doc_ventas = "";
    public static String id_doc_ventas = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_info_all = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_factura = new javax.swing.JTable();
        lbl_cod = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chk_contado = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        txt_cod_cli = new javax.swing.JTextField();
        txt_cli_nom = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btn_buscaar_items = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_usu_ventas = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbl_fecha_VISOR = new javax.swing.JTextField();
        chk_plazo = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        btn_buscaar_presupuesto = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txt_des_ventas = new javax.swing.JTextField();
        chk_ecommerce = new javax.swing.JCheckBox();
        txt_class_cli_ventas = new javax.swing.JTextField();
        lbl_plazos_dias1 = new javax.swing.JLabel();
        panel_total = new javax.swing.JPanel();
        txttotal = new javax.swing.JLabel();
        lbl_cambio_conver_3 = new javax.swing.JLabel();
        panel_total_2 = new javax.swing.JPanel();
        lbl_cambio_real = new javax.swing.JLabel();
        lbl_cambio_dolar = new javax.swing.JLabel();
        lbl_cambio_conver_1 = new javax.swing.JLabel();
        lbl_cambio_conver_2 = new javax.swing.JLabel();
        btneli = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txt_tipo_surc = new javax.swing.JTextField();
        panel_info = new javax.swing.JPanel();
        btn_cajaR = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbl_caja_rap = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblcanpro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_calculo = new javax.swing.JPanel();
        lbl_saldo_cuenta = new javax.swing.JLabel();
        lbl_saldo_actual = new javax.swing.JLabel();
        btn_busca_pre = new javax.swing.JButton();
        lbl_cod_pre = new javax.swing.JLabel();
        btn_calc_pre = new javax.swing.JButton();
        lbl_default_id = new javax.swing.JLabel();
        lbl_nro_cuenta = new javax.swing.JLabel();
        lbl_nom_cuenta = new javax.swing.JLabel();
        lbl_sur_nombre = new javax.swing.JLabel();
        lbl_total_amort = new javax.swing.JLabel();
        lbl_literal_pro = new javax.swing.JLabel();
        lbl_literal = new javax.swing.JLabel();
        btn_busca_pedidos = new javax.swing.JButton();
        btn_calc_pedidos = new javax.swing.JButton();
        lbl_cod_pedidos = new javax.swing.JLabel();
        id_ventas_modif = new javax.swing.JLabel();
        btn_calc_modif = new javax.swing.JButton();
        btn_busca_modif = new javax.swing.JButton();
        btn_mone = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btn_calc_amortizacion = new javax.swing.JButton();
        lbl_cant_produ = new javax.swing.JLabel();
        pn_amortizacion = new javax.swing.JPanel();
        lbl_valor_amortz = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        txt_dias_plazo = new javax.swing.JTextField();
        lbl_plazos_dias = new javax.swing.JLabel();
        pn_tipo_venta = new javax.swing.JPanel();
        lbl_tipo_venta = new javax.swing.JLabel();
        btnven = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_r = new javax.swing.JLabel();
        lbl_cambio_mon_2 = new javax.swing.JLabel();
        lbl_dolar = new javax.swing.JLabel();
        lbl_cambio_mon_1 = new javax.swing.JLabel();
        btn_busqueda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VENTAS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_info_all.setBackground(new java.awt.Color(255, 255, 255));
        panel_info_all.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        /*tb_factura = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };*/
        tb_factura.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio Unitario", "Unidad", "Kg", "Precio Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_factura.setGridColor(new java.awt.Color(255, 255, 255));
        tb_factura.setRowHeight(22);
        tb_factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_facturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_factura);

        panel_info_all.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 800, 320));

        lbl_cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cod.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cod.setText("0000001");
        lbl_cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_info_all.add(lbl_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 110, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Nro de Venta:");
        panel_info_all.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 10, 90, 30));

        chk_contado.setBackground(new java.awt.Color(255, 255, 255));
        chk_contado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_contado.setText("CONTADO");
        chk_contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_contadoActionPerformed(evt);
            }
        });
        panel_info_all.add(chk_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Sucursal:");
        jLabel16.setFocusable(false);
        panel_info_all.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 70, 30));

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
        panel_info_all.add(txt_cod_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 8, 90, 32));

        txt_cli_nom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_cli_nom.setEnabled(false);
        txt_cli_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_nomActionPerformed(evt);
            }
        });
        panel_info_all.add(txt_cli_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 8, 330, 32));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Descripción:");
        panel_info_all.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 30));

        btn_buscaar_items.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscaar_items.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscaar_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        btn_buscaar_items.setMnemonic('a');
        btn_buscaar_items.setToolTipText("Seleccionar stock");
        btn_buscaar_items.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscaar_items.setFocusable(false);
        btn_buscaar_items.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_buscaar_items.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_buscaar_items.setVerifyInputWhenFocusTarget(false);
        btn_buscaar_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaar_itemsActionPerformed(evt);
            }
        });
        btn_buscaar_items.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_buscaar_itemsKeyPressed(evt);
            }
        });
        panel_info_all.add(btn_buscaar_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 70, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Nombre del Cliente :");
        panel_info_all.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, 32));

        txt_usu_ventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_usu_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_usu_ventas.setEnabled(false);
        txt_usu_ventas.setFocusable(false);
        panel_info_all.add(txt_usu_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 240, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Usuario Ventas:");
        jLabel18.setFocusable(false);
        panel_info_all.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));

        lbl_fecha_VISOR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_fecha_VISOR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_fecha_VISOR.setEnabled(false);
        lbl_fecha_VISOR.setFocusable(false);
        panel_info_all.add(lbl_fecha_VISOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 100, 30));

        chk_plazo.setBackground(new java.awt.Color(255, 255, 255));
        chk_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_plazo.setText("CRÉDITO");
        chk_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_plazoActionPerformed(evt);
            }
        });
        panel_info_all.add(chk_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 90, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_info_all.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 8, 42, 32));

        btn_buscaar_presupuesto.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscaar_presupuesto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscaar_presupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/tienda-online.png"))); // NOI18N
        btn_buscaar_presupuesto.setMnemonic('a');
        btn_buscaar_presupuesto.setToolTipText("Subir ventas-pedidos");
        btn_buscaar_presupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscaar_presupuesto.setFocusable(false);
        btn_buscaar_presupuesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_buscaar_presupuesto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_buscaar_presupuesto.setVerifyInputWhenFocusTarget(false);
        btn_buscaar_presupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaar_presupuestoActionPerformed(evt);
            }
        });
        btn_buscaar_presupuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_buscaar_presupuestoKeyPressed(evt);
            }
        });
        panel_info_all.add(btn_buscaar_presupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 70, 45));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Condición de pago :");
        panel_info_all.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        txt_des_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_des_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_des_ventasActionPerformed(evt);
            }
        });
        panel_info_all.add(txt_des_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 460, 30));

        chk_ecommerce.setBackground(new java.awt.Color(255, 255, 255));
        chk_ecommerce.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_ecommerce.setText("E-COMMERCE");
        chk_ecommerce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_ecommerceActionPerformed(evt);
            }
        });
        panel_info_all.add(chk_ecommerce, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 110, 30));

        txt_class_cli_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_class_cli_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        txt_class_cli_ventas.setEnabled(false);
        panel_info_all.add(txt_class_cli_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 150, 30));

        lbl_plazos_dias1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plazos_dias1.setText("Clasif.");
        panel_info_all.add(lbl_plazos_dias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 40, 30));

        panel_total.setBackground(new java.awt.Color(255, 255, 255));
        panel_total.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        panel_total.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttotal.setBackground(new java.awt.Color(102, 102, 102));
        txttotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txttotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txttotal.setText("0");
        txttotal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txttotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txttotal.setVerifyInputWhenFocusTarget(false);
        txttotal.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panel_total.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 190, 30));

        lbl_cambio_conver_3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_conver_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/paraguay.png"))); // NOI18N
        lbl_cambio_conver_3.setText("GS.:");
        panel_total.add(lbl_cambio_conver_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        panel_info_all.add(panel_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 310, 80));

        panel_total_2.setBackground(new java.awt.Color(255, 255, 255));
        panel_total_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cotizaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        panel_total_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cambio_real.setBackground(new java.awt.Color(102, 102, 102));
        lbl_cambio_real.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_real.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cambio_real.setText("0");
        lbl_cambio_real.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel_total_2.add(lbl_cambio_real, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, 30));

        lbl_cambio_dolar.setBackground(new java.awt.Color(102, 102, 102));
        lbl_cambio_dolar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_dolar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cambio_dolar.setText("0");
        lbl_cambio_dolar.setAutoscrolls(true);
        lbl_cambio_dolar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel_total_2.add(lbl_cambio_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 170, 30));

        lbl_cambio_conver_1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_conver_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"))); // NOI18N
        lbl_cambio_conver_1.setText("RS$:");
        panel_total_2.add(lbl_cambio_conver_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        lbl_cambio_conver_2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_conver_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"))); // NOI18N
        lbl_cambio_conver_2.setText("US$:");
        panel_total_2.add(lbl_cambio_conver_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 30, -1, 30));

        panel_info_all.add(panel_total_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 470, 80));

        btneli.setBackground(new java.awt.Color(255, 255, 255));
        btneli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btneli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btneli.setMnemonic('e');
        btneli.setToolTipText("Remover items");
        btneli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneli.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btneli.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });
        panel_info_all.add(btneli, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 70, 45));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Fecha Emisión:");
        jLabel22.setFocusable(false);
        panel_info_all.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 100, 30));

        txt_tipo_surc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_tipo_surc.setDisabledTextColor(new java.awt.Color(204, 0, 51));
        txt_tipo_surc.setEnabled(false);
        panel_info_all.add(txt_tipo_surc, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 50, 30));

        getContentPane().add(panel_info_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 550));

        panel_info.setBackground(new java.awt.Color(255, 255, 255));
        panel_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cajaR.setBackground(new java.awt.Color(255, 255, 255));
        btn_cajaR.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btn_cajaR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_cajaR.setMnemonic('g');
        btn_cajaR.setText("Grabar");
        btn_cajaR.setHideActionText(true);
        btn_cajaR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cajaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cajaRActionPerformed(evt);
            }
        });
        panel_info.add(btn_cajaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 425, 130, 50));

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_caja_rap.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_caja_rap.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_caja_rap, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 40, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Caja Rápida:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 28));

        panel_info.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 160, -1));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        lblcanpro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcanpro.setForeground(new java.awt.Color(255, 255, 255));
        lblcanpro.setText("0");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Items:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblcanpro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblcanpro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panel_info.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 150, 30));

        panel_calculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_saldo_cuenta.setText("0");
        panel_calculo.add(lbl_saldo_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, -1));

        lbl_saldo_actual.setText("saldo_actual");
        panel_calculo.add(lbl_saldo_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, -1));

        btn_busca_pre.setText("busca");
        btn_busca_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busca_preActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_busca_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        lbl_cod_pre.setText("id_pre");
        panel_calculo.add(lbl_cod_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 60, 20));

        btn_calc_pre.setText("calcP");
        btn_calc_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calc_preActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_calc_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 60, -1));

        lbl_default_id.setText("lbl_default");
        panel_calculo.add(lbl_default_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lbl_nro_cuenta.setText("nro cuenta");
        panel_calculo.add(lbl_nro_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 30));

        lbl_nom_cuenta.setText("cuenta");
        panel_calculo.add(lbl_nom_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        lbl_sur_nombre.setText("alma");
        panel_calculo.add(lbl_sur_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 30, 20));

        lbl_total_amort.setText("amort_total");
        panel_calculo.add(lbl_total_amort, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 20));

        lbl_literal_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_literal_pro.setText("Son:");
        panel_calculo.add(lbl_literal_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 20, -1));

        lbl_literal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_literal.setText("gs");
        panel_calculo.add(lbl_literal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 30, 20));

        btn_busca_pedidos.setText("BuscaPedi");
        btn_busca_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busca_pedidosActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_busca_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 60, -1));

        btn_calc_pedidos.setText("calcPedi");
        btn_calc_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calc_pedidosActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_calc_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 60, -1));

        lbl_cod_pedidos.setText("id_pedido");
        panel_calculo.add(lbl_cod_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 80, 20));

        id_ventas_modif.setText("id_venta_mod");
        panel_calculo.add(id_ventas_modif, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        btn_calc_modif.setText("calc_ventas");
        btn_calc_modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calc_modifActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_calc_modif, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        btn_busca_modif.setText("busca_vent");
        btn_busca_modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busca_modifActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_busca_modif, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        btn_mone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moneActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_mone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 50, 20));

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
        panel_calculo.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 40, 20));

        btn_calc_amortizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calc_amortizacionActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_calc_amortizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 50, 20));

        lbl_cant_produ.setText("count");
        panel_calculo.add(lbl_cant_produ, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        panel_info.add(panel_calculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 320, 140));

        pn_amortizacion.setBackground(new java.awt.Color(0, 102, 0));
        pn_amortizacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_valor_amortz.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_valor_amortz.setForeground(new java.awt.Color(255, 255, 255));
        lbl_valor_amortz.setText("0");
        pn_amortizacion.add(lbl_valor_amortz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 28));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Amortización:");
        pn_amortizacion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 28));

        panel_info.add(pn_amortizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 210, 30));

        btn_salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_salir.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
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
        panel_info.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 485, 130, 50));

        txt_dias_plazo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_dias_plazo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dias_plazo.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_dias_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dias_plazoActionPerformed(evt);
            }
        });
        panel_info.add(txt_dias_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 50, 30));

        lbl_plazos_dias.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plazos_dias.setText("N° Cuotas:");
        panel_info.add(lbl_plazos_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 60, 30));

        pn_tipo_venta.setBackground(new java.awt.Color(0, 0, 255));
        pn_tipo_venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tipo_venta.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_tipo_venta.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipo_venta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tipo_venta.setText("CONTADO");
        pn_tipo_venta.add(lbl_tipo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));

        panel_info.add(pn_tipo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 330, -1));

        btnven.setBackground(new java.awt.Color(255, 255, 255));
        btnven.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnven.setText("Grabar");
        btnven.setToolTipText("");
        btnven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnven.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnven.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });
        panel_info.add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 485, 130, 50));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Informaciones:");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel20.setFocusable(false);
        panel_info.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/dollar.png"))); // NOI18N
        jLabel2.setText("   Cotización:");
        panel_info.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        lbl_r.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_r.setText("1,365");
        panel_info.add(lbl_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 70, 30));

        lbl_cambio_mon_2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_mon_2.setForeground(new java.awt.Color(0, 0, 102));
        lbl_cambio_mon_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"))); // NOI18N
        lbl_cambio_mon_2.setText("=");
        panel_info.add(lbl_cambio_mon_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 30));

        lbl_dolar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_dolar.setForeground(new java.awt.Color(0, 0, 102));
        lbl_dolar.setText("5,780");
        panel_info.add(lbl_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 60, 30));

        lbl_cambio_mon_1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_mon_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"))); // NOI18N
        lbl_cambio_mon_1.setText("=");
        panel_info.add(lbl_cambio_mon_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        btn_busqueda.setBackground(new java.awt.Color(255, 255, 255));
        btn_busqueda.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btn_busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/lector-de-codigo-de-barras.png"))); // NOI18N
        btn_busqueda.setMnemonic('L');
        btn_busqueda.setText("Lector");
        btn_busqueda.setToolTipText("Codigo de barras");
        btn_busqueda.setBorder(null);
        btn_busqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_busqueda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busquedaActionPerformed(evt);
            }
        });
        btn_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_busquedaKeyReleased(evt);
            }
        });
        panel_info.add(btn_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 425, 130, 50));

        getContentPane().add(panel_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 340, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
        for (int i = 0; i < tb_factura.getRowCount(); i++) {

            DefaultTableModel model = (DefaultTableModel) tb_factura.getModel();
            int fila = tb_factura.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);
                calcular();
                calcularMoneda();
                calcularCantidadPro();

            }
            if (fila == 0) {
                lbl_cambio_dolar.setText("0");
                txttotal.setText("0");
                lbl_cambio_real.setText("0");
            }
            calcular();
            calcularMoneda();
            calcularCantidadPro();
        }
    }//GEN-LAST:event_btneliActionPerformed

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed

        if (chk_contado.isSelected()) {

            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals("")) || (txt_cli_nom.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {
                btnven.setEnabled(false);

                ticket();

                // caja();
                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    if (Principal.txt_model_ticket.getText().equals("1")) {
                        id_doc_ventas = Ventas_venta.lbl_cod.getText();
                        Printers_ventas_modulo est;
                        est = new Printers_ventas_modulo(new javax.swing.JDialog(), true);
                        est.setVisible(true);
                    }

                    if (Principal.txt_model_ticket.getText().equals("2")) {
                        Reportes reporte = new Reportes();
                        try {
                            String moneda = Principal.txt_simbolo.getText();
                            reporte.recepM2(Ventas_venta.lbl_cod.getText(), moneda);

                        } catch (SQLException | JRException ex) {
                            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                lbl_cambio_dolar.setText("");
                lbl_cambio_real.setText("");
                txttotal.setText("");

                DefaultTableModel modelo = (DefaultTableModel) tb_factura.getModel();
                int a = tb_factura.getRowCount() - 1;
                int i;
                for (i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                codigos();
                txt_cod_cli.setText("");
                txt_cli_nom.setText("");
                lblcanpro.setText("0");
                lbl_cambio_dolar.setText("0");
                txttotal.setText("0");
                lbl_cambio_real.setText("0");
                chk_plazo.setSelected(false);
                chk_ecommerce.setSelected(false);
                lbl_plazos_dias.setVisible(false);

                txt_dias_plazo.setVisible(false);
                lbl_tipo_venta.setText("CONTADO");
                pn_tipo_venta.setBackground(Color.blue);
                pn_amortizacion.setVisible(false);
                lbl_valor_amortz.setText("0");
                txt_tipo_surc.setText("");
                txt_class_cli_ventas.setText("");
                btnven.setEnabled(true);

            }
        }

        if (chk_plazo.isSelected()) {

            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals("")) || (txt_cli_nom.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {
                btnven.setEnabled(false);

                ticket_plazo();

                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Reportes reporte = new Reportes();
                    try {
                        String moneda = Principal.txt_simbolo.getText();
                        reporte.recep(Ventas_venta.lbl_cod.getText(), moneda);

                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lbl_cambio_real.setText("");
                txttotal.setText("");

                DefaultTableModel modelo = (DefaultTableModel) tb_factura.getModel();
                int a = tb_factura.getRowCount() - 1;
                int i;
                for (i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                codigos();
                txt_cod_cli.setText("");
                txt_cli_nom.setText("");
                lblcanpro.setText("0");
                lbl_cambio_dolar.setText("");
                chk_contado.setSelected(true);
                chk_plazo.setSelected(false);
                chk_ecommerce.setSelected(false);
                lbl_plazos_dias.setVisible(false);

                txt_dias_plazo.setText("");
                txt_dias_plazo.setVisible(false);
                lbl_tipo_venta.setText("CONTADO");
                pn_tipo_venta.setBackground(Color.blue);
                pn_amortizacion.setVisible(false);
                lbl_valor_amortz.setText("0");
                txt_tipo_surc.setText("");
                txt_class_cli_ventas.setText("");
                btnven.setEnabled(true);

            }
        }
        if (chk_ecommerce.isSelected()) {
            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals("")) || (txt_cli_nom.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {
                btnven.setEnabled(false);

                ticket_ecommerce();

                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Reportes reporte = new Reportes();
                    try {
                        String moneda = Principal.txt_simbolo.getText();
                        reporte.recep(Ventas_venta.lbl_cod.getText(), moneda);

                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lbl_cambio_real.setText("");
                txttotal.setText("");

                DefaultTableModel modelo = (DefaultTableModel) tb_factura.getModel();
                int a = tb_factura.getRowCount() - 1;
                int i;
                for (i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                codigos();
                txt_cod_cli.setText("");
                txt_cli_nom.setText("");
                lblcanpro.setText("0");
                lbl_cambio_dolar.setText("");
                chk_contado.setSelected(true);
                chk_plazo.setSelected(false);
                chk_ecommerce.setSelected(false);
                lbl_plazos_dias.setVisible(false);

                txt_dias_plazo.setText("");
                txt_dias_plazo.setVisible(false);
                lbl_tipo_venta.setText("CONTADO");
                pn_tipo_venta.setBackground(Color.blue);
                pn_amortizacion.setVisible(false);
                lbl_valor_amortz.setText("0");
                txt_tipo_surc.setText("");
                txt_class_cli_ventas.setText("");
                btnven.setEnabled(true);

            }
        }

        txt_cod_cli.requestFocus();
        Principal_ventas.btn_cargar_datos.doClick();
    }//GEN-LAST:event_btnvenActionPerformed

    private void txt_cli_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_nomActionPerformed

    private void txt_cod_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_cliKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            Clientes_ventas cv;
            cv = new Clientes_ventas(new javax.swing.JDialog(), true);
            cv.setVisible(true);

        }


    }//GEN-LAST:event_txt_cod_cliKeyPressed

    private void txt_cod_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_cliActionPerformed

    private void chk_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_plazoActionPerformed
        chk_contado.setSelected(false);
        chk_ecommerce.setSelected(false);
        TiposPagos();
        lbl_tipo_venta.setText("CRÉDITO");
        pn_tipo_venta.setBackground(Color.red);
        pn_amortizacion.setVisible(true);
        lbl_valor_amortz.setText("0");
    }//GEN-LAST:event_chk_plazoActionPerformed

    private void chk_contadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_contadoActionPerformed
        chk_plazo.setSelected(false);
        lbl_plazos_dias.setVisible(false);
        txt_dias_plazo.setVisible(false);
        chk_ecommerce.setSelected(false);

        txt_dias_plazo.setText("");
        lbl_tipo_venta.setText("CONTADO");
        pn_tipo_venta.setBackground(Color.blue);
        pn_amortizacion.setVisible(false);
        lbl_valor_amortz.setText("0");

    }//GEN-LAST:event_chk_contadoActionPerformed

    private void txt_dias_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dias_plazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dias_plazoActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed

        contarFilas();
        calcular();
        calcularMoneda();
        calcularCantidadPro();
        calcularCaja();
        literal();


    }//GEN-LAST:event_btncalcularActionPerformed

    private void btn_buscaar_itemsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_buscaar_itemsKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_cod_cli.requestFocus();
        }
    }//GEN-LAST:event_btn_buscaar_itemsKeyPressed

    private void btn_buscaar_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaar_itemsActionPerformed
        if (lbl_sur_nombre.getText().equals("TODOS")) {
            Almacen_select_ventas as;
            as = new Almacen_select_ventas(new javax.swing.JDialog(), true);
            as.setVisible(true);
        } else {
            String def = lbl_sur_nombre.getText();
            lbl_default_id.setText(def);
            Productos_ventas vrp;
            vrp = new Productos_ventas(new javax.swing.JDialog(), true);
            vrp.setVisible(true);

        }
    }//GEN-LAST:event_btn_buscaar_itemsActionPerformed

    private void btn_moneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moneActionPerformed
        calcularSubtotal();
        calcularMoneda();
        calcularCantidadPro();
        literal();
    }//GEN-LAST:event_btn_moneActionPerformed

    private void btn_cajaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cajaRActionPerformed
        if (chk_contado.isSelected()) {

            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals("")) || (txt_cli_nom.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {

                ticketCR();

                caja();
                actCuenta();
                cobrar();

                String capcod = "", capcan = "";
                for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
                    capcod = Ventas_venta.tb_factura.getValueAt(i, 0).toString();
                    capcan = Ventas_venta.tb_factura.getValueAt(i, 3).toString();

                    descontarstock(capcod, capcan);

                }

                if (txt_act_vuelto.getText().equals("S")) {
                    id_nro_cuentas = lbl_nro_cuenta.getText();
                    id_venta_pago_ventas_normal = (String) lbl_cod.getText();
                    total_ventas_normal = txttotal.getText();

                }

                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    if (Principal.txt_model_ticket.getText().equals("1")) {
                        Reportes reporte = new Reportes();
                        try {
                            String moneda = Principal.txt_simbolo.getText();
                            reporte.recep(Ventas_venta.lbl_cod.getText(), moneda);

                        } catch (SQLException | JRException ex) {
                            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (Principal.txt_model_ticket.getText().equals("2")) {
                        Reportes reporte = new Reportes();
                        try {
                            String moneda = Principal.txt_simbolo.getText();
                            reporte.recepM2(Ventas_venta.lbl_cod.getText(), moneda);

                        } catch (SQLException | JRException ex) {
                            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                lbl_cambio_dolar.setText("");
                lbl_cambio_real.setText("");
                txttotal.setText("");

                DefaultTableModel modelo = (DefaultTableModel) tb_factura.getModel();
                int a = tb_factura.getRowCount() - 1;
                int i;
                for (i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                codigos();
                txt_cod_cli.setText("");
                txt_cli_nom.setText("");
                lblcanpro.setText("0");
                lbl_cambio_dolar.setText("0");
                txttotal.setText("0");
                lbl_cambio_real.setText("0");
                chk_plazo.setSelected(false);
                lbl_plazos_dias.setVisible(false);

                txt_dias_plazo.setVisible(false);
                lbl_tipo_venta.setText("CONTADO");
                pn_tipo_venta.setBackground(Color.blue);
                pn_amortizacion.setVisible(false);
                lbl_valor_amortz.setText("0");
                txt_tipo_surc.setText("");
                txt_class_cli_ventas.setText("");
            }
        }

        if (chk_plazo.isSelected()) {

            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals("")) || (txt_cli_nom.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {

                ticket_plazoCR();

                caja();
                actCuenta();
                cobrar();
                if (Principal.lbl_usu_caj_rap.getText().equals("SI")) {
                    id_nro_cuentas = lbl_nro_cuenta.getText();
                    id_venta_pago_ventas_normal = (String) lbl_cod.getText();
                    total_ventas_normal = txttotal.getText();

                }

                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Reportes reporte = new Reportes();
                    try {
                        String moneda = Principal.txt_simbolo.getText();
                        reporte.recep(Ventas_venta.lbl_cod.getText(), moneda);

                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lbl_cambio_real.setText("");
                txttotal.setText("");

                DefaultTableModel modelo = (DefaultTableModel) tb_factura.getModel();
                int a = tb_factura.getRowCount() - 1;
                int i;
                for (i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                codigos();
                txt_cod_cli.setText("");
                txt_cli_nom.setText("");
                lblcanpro.setText("0");
                lbl_cambio_dolar.setText("");
                chk_contado.setSelected(true);
                chk_plazo.setSelected(false);
                lbl_plazos_dias.setVisible(false);

                txt_dias_plazo.setText("");
                txt_dias_plazo.setVisible(false);
                lbl_tipo_venta.setText("CONTADO");
                pn_tipo_venta.setBackground(Color.blue);
                pn_amortizacion.setVisible(false);
                lbl_valor_amortz.setText("0");
                txt_tipo_surc.setText("");
                txt_class_cli_ventas.setText("");

            }
        }

        txt_cod_cli.requestFocus();
        Principal_ventas.btn_cargar_datos.doClick();
    }//GEN-LAST:event_btn_cajaRActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Clientes_ventas cv;
        cv = new Clientes_ventas(new javax.swing.JDialog(), true);
        cv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_calc_amortizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calc_amortizacionActionPerformed
        calcular_amorti();
        calcularMoneda();
        calcularCaja();
        literal();
    }//GEN-LAST:event_btn_calc_amortizacionActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir de ventas?",
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //    new Thread(new hilo()).start();

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void btn_buscaar_presupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaar_presupuestoActionPerformed

        Select_pedi_presupuesto bpp;
        bpp = new Select_pedi_presupuesto(new javax.swing.JDialog(), true);
        bpp.setVisible(true);

    }//GEN-LAST:event_btn_buscaar_presupuestoActionPerformed

    private void btn_buscaar_presupuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_buscaar_presupuestoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscaar_presupuestoKeyPressed

    private void btn_busca_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busca_preActionPerformed
        cargar(lbl_cod_pre.getText());
        cargarTxt(lbl_cod_pre.getText());
        btn_calc_pre.doClick();
    }//GEN-LAST:event_btn_busca_preActionPerformed

    private void btn_calc_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calc_preActionPerformed
        calcular_pre();
        calcularMoneda();
        calcularCantidadPro();
        calcularCaja();
        literal();

        for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
            String capcod = Ventas_venta.tb_factura.getValueAt(i, 0).toString();
            int cap = 0;

            String separa = "";
            String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + capcod + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(consul);
                while (rs.next()) {
                    cap = rs.getInt(5);//pendiente a modificacion
                    //separa = rs.getString(23);
                }
                conectar.getInstance().closeConnection(cn);

            } catch (Exception e) {
            }

            tb_factura.setValueAt(String.valueOf(cap), i, 6);

        }
    }//GEN-LAST:event_btn_calc_preActionPerformed

    private void btn_busca_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busca_pedidosActionPerformed
        cargarPedidos(lbl_cod_pedidos.getText());
        cargarTxtPedidos(lbl_cod_pedidos.getText());
        btn_calc_pedidos.doClick();
    }//GEN-LAST:event_btn_busca_pedidosActionPerformed

    private void btn_calc_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calc_pedidosActionPerformed
        calcular_pre();
        calcularMoneda();
        calcularCantidadPro();
        calcularCaja();
        literal();

        for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
            String capcod = Ventas_venta.tb_factura.getValueAt(i, 0).toString();
            // String cap = "";
            int cap = 0;

            String separa = "";
            String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + capcod + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(consul);
                while (rs.next()) {
                    cap = rs.getInt(5);//pendiente a modificacion
                    //separa = rs.getString(23);
                }
                conectar.getInstance().closeConnection(cn);

            } catch (Exception e) {
            }
            tb_factura.setValueAt(String.valueOf(cap), i, 6);

        }
    }//GEN-LAST:event_btn_calc_pedidosActionPerformed

    private void txt_des_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_des_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_des_ventasActionPerformed

    private void chk_ecommerceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_ecommerceActionPerformed
        chk_plazo.setSelected(false);
        lbl_plazos_dias.setVisible(false);
        txt_dias_plazo.setVisible(false);
        chk_contado.setSelected(false);

        txt_dias_plazo.setText("");
        lbl_tipo_venta.setText("E-COMMERCE");
        lbl_tipo_venta.setForeground(Color.black);
        pn_tipo_venta.setBackground(Color.CYAN);
        pn_amortizacion.setVisible(false);
        lbl_valor_amortz.setText("0");

    }//GEN-LAST:event_chk_ecommerceActionPerformed

    private void btn_busca_modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busca_modifActionPerformed
        cargarVentas(id_ventas_modif.getText());
        cargarTxtVEntas(id_ventas_modif.getText());
        btn_calc_modif.doClick();

    }//GEN-LAST:event_btn_busca_modifActionPerformed

    private void btn_calc_modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calc_modifActionPerformed
        calcular_pre();
        calcularMoneda();
        calcularCantidadPro();
        calcularCaja();
        literal();

    }//GEN-LAST:event_btn_calc_modifActionPerformed

    private void tb_facturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_facturaKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

            btncalcular.doClick();
            JOptionPane.showMessageDialog(null, "Recalculando");
        }

    }//GEN-LAST:event_tb_facturaKeyPressed

    private void btn_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busquedaActionPerformed
        Busqueda_barras bas;
        bas = new Busqueda_barras(new javax.swing.JDialog(), true);
        bas.setVisible(true);
    }//GEN-LAST:event_btn_busquedaActionPerformed

    private void btn_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_busquedaKeyReleased

    }//GEN-LAST:event_btn_busquedaKeyReleased

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
            java.util.logging.Logger.getLogger(Ventas_venta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventas_venta dialog = null;

                    dialog = new Ventas_venta(new javax.swing.JDialog(), true);

                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir del sistema?",
                                    "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                System.exit(0);
                            }
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_busca_modif;
    public static javax.swing.JButton btn_busca_pedidos;
    public static javax.swing.JButton btn_busca_pre;
    public static javax.swing.JButton btn_buscaar_items;
    public static javax.swing.JButton btn_buscaar_presupuesto;
    private javax.swing.JButton btn_busqueda;
    private javax.swing.JButton btn_cajaR;
    public static javax.swing.JButton btn_calc_amortizacion;
    private javax.swing.JButton btn_calc_modif;
    public static javax.swing.JButton btn_calc_pedidos;
    public static javax.swing.JButton btn_calc_pre;
    public static javax.swing.JButton btn_mone;
    private javax.swing.JButton btn_salir;
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnven;
    private javax.swing.JCheckBox chk_contado;
    private javax.swing.JCheckBox chk_ecommerce;
    private javax.swing.JCheckBox chk_plazo;
    public static javax.swing.JLabel id_ventas_modif;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_caja_rap;
    private javax.swing.JLabel lbl_cambio_conver_1;
    private javax.swing.JLabel lbl_cambio_conver_2;
    private javax.swing.JLabel lbl_cambio_conver_3;
    public static javax.swing.JLabel lbl_cambio_dolar;
    private javax.swing.JLabel lbl_cambio_mon_1;
    private javax.swing.JLabel lbl_cambio_mon_2;
    public static javax.swing.JLabel lbl_cambio_real;
    public static javax.swing.JLabel lbl_cant_produ;
    public static javax.swing.JLabel lbl_cod;
    public static javax.swing.JLabel lbl_cod_pedidos;
    public static javax.swing.JLabel lbl_cod_pre;
    public static javax.swing.JLabel lbl_default_id;
    private javax.swing.JLabel lbl_dolar;
    private javax.swing.JTextField lbl_fecha_VISOR;
    private javax.swing.JLabel lbl_literal;
    private javax.swing.JLabel lbl_literal_pro;
    private javax.swing.JLabel lbl_nom_cuenta;
    private javax.swing.JLabel lbl_nro_cuenta;
    private javax.swing.JLabel lbl_plazos_dias;
    private javax.swing.JLabel lbl_plazos_dias1;
    private javax.swing.JLabel lbl_r;
    private javax.swing.JLabel lbl_saldo_actual;
    private javax.swing.JLabel lbl_saldo_cuenta;
    private javax.swing.JLabel lbl_sur_nombre;
    private javax.swing.JLabel lbl_tipo_venta;
    private javax.swing.JLabel lbl_total_amort;
    public static javax.swing.JLabel lbl_valor_amortz;
    public static javax.swing.JLabel lblcanpro;
    private javax.swing.JPanel panel_calculo;
    private javax.swing.JPanel panel_info;
    public static javax.swing.JPanel panel_info_all;
    private javax.swing.JPanel panel_total;
    private javax.swing.JPanel panel_total_2;
    private javax.swing.JPanel pn_amortizacion;
    private javax.swing.JPanel pn_tipo_venta;
    public static javax.swing.JTable tb_factura;
    public static javax.swing.JTextField txt_class_cli_ventas;
    public static javax.swing.JTextField txt_cli_nom;
    public static javax.swing.JTextField txt_cod_cli;
    private javax.swing.JTextField txt_des_ventas;
    public static javax.swing.JTextField txt_dias_plazo;
    public static javax.swing.JTextField txt_tipo_surc;
    private javax.swing.JTextField txt_usu_ventas;
    public static javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables

    public void calcular() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_factura.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_factura.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_factura.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 5);

            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            txttotal.setText(total);
            lbl_total_amort.setText(total);

        }
    }

    public void calcularMoneda() {

        String real = "0", dolar = "0";

        BigDecimal ValorGuaranies = ingreso.TransformReales(txttotal.getText().replaceAll("\\s", ""));
        BigDecimal ValorGuaranies2 = ingreso.TransformReales(txttotal.getText().replaceAll("\\s", ""));
        BigDecimal ValorDolar = ingreso.TransformReales(lbl_dolar.getText().replaceAll("\\s", ""));
        BigDecimal ValorReal = ingreso.TransformReales(lbl_r.getText().replaceAll("\\s", ""));

        if (Principal.txt_simbolo.getText().equals("Gs")) {
            real = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies.divide(ValorReal, 2, RoundingMode.HALF_UP).toString());
            dolar = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies2.divide(ValorDolar, 2, RoundingMode.HALF_UP).toString());
            lbl_cambio_real.setText(real);
            lbl_cambio_dolar.setText(dolar);
        }

        if (Principal.txt_simbolo.getText().equals("US$")) {
            String reale = "0", guaranies = "0";
            int decimalPlace = 2;
            int decimalguaranies = 0;
            BigDecimal rr = ValorGuaranies.multiply(ValorReal);
            rr = rr.setScale(decimalPlace, BigDecimal.ROUND_UP);
            String rc = String.valueOf(rr);
            reale = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(rc);
            lbl_cambio_real.setText(reale);
            ///////guarani/////////////////
            BigDecimal rg = ValorGuaranies2.multiply(ValorDolar);
            rg = rg.setScale(decimalguaranies, BigDecimal.ROUND_UP);
            String rcg = String.valueOf(rg);
            guaranies = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(rcg);
            lbl_cambio_dolar.setText(guaranies);
        }

    }

    void descontarstock(String codi, String can) {
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

        } catch (Exception e) {
        }
    }

    ///////reserva el producto en separacion
    void AumentarstockPedido(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(23);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_alma='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void ticket() {
        codigos();
        String InsertarSQL = "INSERT INTO ventas (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas,ventas_des) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_contado.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("FINALIZADA");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_almacen_ventas.getText();
        String literal = lbl_literal.getText();
        String id_user = Principal.lbl_id_user.getText();
        String describe = txt_des_ventas.getText();
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, cod_cli);
            pst.setString(3, nom_cli);
            pst.setString(4, formapag);
            pst.setString(5, dias_pla);
            pst.setString(6, total_ventas);
            pst.setString(7, total_real);
            pst.setString(8, total_dolar);
            pst.setString(9, estado);
            pst.setString(10, fecha);
            pst.setString(11, user);
            pst.setString(12, almacen);
            pst.setString(13, cantidad);
            pst.setString(14, literal);
            pst.setString(15, id_user);
            pst.setString(16, describe);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_ticket();

                String capcod = "", capcan = "";
                for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
                    capcod = Ventas_venta.tb_factura.getValueAt(i, 0).toString();
                    capcan = Ventas_venta.tb_factura.getValueAt(i, 3).toString();
                    System.out.println("Ventas stock");
                    descontarstock(capcod, capcan);

                }

                JOptionPane.showMessageDialog(null, "Venta realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ticket_ecommerce() {
        codigos();
        String InsertarSQL = "INSERT INTO ventas (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas,ventas_des) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_ecommerce.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("FINALIZADA");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_almacen_ventas.getText();
        String literal = lbl_literal.getText();
        String id_user = Principal.lbl_id_user.getText();
        String describe = txt_des_ventas.getText();
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, cod_cli);
            pst.setString(3, nom_cli);
            pst.setString(4, formapag);
            pst.setString(5, dias_pla);
            pst.setString(6, total_ventas);
            pst.setString(7, total_real);
            pst.setString(8, total_dolar);
            pst.setString(9, estado);
            pst.setString(10, fecha);
            pst.setString(11, user);
            pst.setString(12, almacen);
            pst.setString(13, cantidad);
            pst.setString(14, literal);
            pst.setString(15, id_user);
            pst.setString(16, describe);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_ticket();
                String capcod = "", capcan = "";
                for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
                    capcod = Ventas_venta.tb_factura.getValueAt(i, 0).toString();
                    capcan = Ventas_venta.tb_factura.getValueAt(i, 3).toString();

                    descontarstock(capcod, capcan);

                }

                JOptionPane.showMessageDialog(null, "Venta realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ticket_plazo() {
        codigos();
        String InsertarSQL = "INSERT INTO ventas (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas,monto_cred,ventas_des) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_plazo.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("FINALIZADA");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_almacen_ventas.getText();
        String literal = lbl_literal.getText();
        String id_user = Principal.lbl_id_user.getText();
        String monto_cred = txttotal.getText();
        String describe = txt_des_ventas.getText();
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, cod_cli);
            pst.setString(3, nom_cli);
            pst.setString(4, formapag);
            pst.setString(5, dias_pla);
            pst.setString(6, total_ventas);
            pst.setString(7, total_real);
            pst.setString(8, total_dolar);
            pst.setString(9, estado);
            pst.setString(10, fecha);
            pst.setString(11, user);
            pst.setString(12, almacen);
            pst.setString(13, cantidad);
            pst.setString(14, literal);
            pst.setString(15, id_user);
            pst.setString(16, monto_cred);
            pst.setString(17, describe);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_ticket();

                String capcod = "", capcan = "";
                for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
                    capcod = Ventas_venta.tb_factura.getValueAt(i, 0).toString();
                    capcan = Ventas_venta.tb_factura.getValueAt(i, 3).toString();

                    descontarstock(capcod, capcan);
                }

                JOptionPane.showMessageDialog(null, "Venta realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void detalle_ticket() {
        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO ventas_detalles (num_bol,cod_pro,des_pro,cant_pro,pre_unit,cant_kg,pre_venta,data) VALUES (?,?,?,?,?,?,?,?)";
            String numbol = lbl_cod.getText();
            String codpro = tb_factura.getValueAt(i, 0).toString();
            String despro = tb_factura.getValueAt(i, 1).toString();
            String cantpro = tb_factura.getValueAt(i, 3).toString();
            String cantkg = tb_factura.getValueAt(i, 4).toString();
            String preunit = tb_factura.getValueAt(i, 2).toString();
            String importe = tb_factura.getValueAt(i, 5).toString();
            String fecha_det_con = lbl_fecha_hoy.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, numbol);
                pst.setString(2, codpro);
                pst.setString(3, despro);
                pst.setString(4, cantpro);
                pst.setString(5, preunit);
                pst.setString(6, cantkg);
                pst.setString(7, importe);
                pst.setString(8, fecha_det_con);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(Ventas_venta.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    ////////////////////////////////////////CAJA RAPIDA////////////////////////////////////////////////
    void ticketCR() {
        codigos();
        String InsertarSQL = "INSERT INTO ventas (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas,ventas_des) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_contado.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("CONFIRMADA");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_default_id.getText();
        String literal = lbl_literal.getText();
        String id_user = Principal.lbl_id_user.getText();
        String describe = txt_des_ventas.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, cod_cli);
            pst.setString(3, nom_cli);
            pst.setString(4, formapag);
            pst.setString(5, dias_pla);
            pst.setString(6, total_ventas);
            pst.setString(7, total_real);
            pst.setString(8, total_dolar);
            pst.setString(9, estado);
            pst.setString(10, fecha);
            pst.setString(11, user);
            pst.setString(12, almacen);
            pst.setString(13, cantidad);
            pst.setString(14, literal);
            pst.setString(15, id_user);
            pst.setString(16, describe);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_ticket();
                JOptionPane.showMessageDialog(null, "Venta realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ticket_ecommerceR() {

        String InsertarSQL = "INSERT INTO ventas (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_ecommerce.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("FINALIZADA");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_almacen_ventas.getText();
        String literal = lbl_literal.getText();
        String id_user = Principal.lbl_id_user.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, cod_cli);
            pst.setString(3, nom_cli);
            pst.setString(4, formapag);
            pst.setString(5, dias_pla);
            pst.setString(6, total_ventas);
            pst.setString(7, total_real);
            pst.setString(8, total_dolar);
            pst.setString(9, estado);
            pst.setString(10, fecha);
            pst.setString(11, user);
            pst.setString(12, almacen);
            pst.setString(13, cantidad);
            pst.setString(14, literal);
            pst.setString(15, id_user);
            conectar.getInstance().closeConnection(cn);

            int n = pst.executeUpdate();
            if (n > 0) {
                detalle_ticket();
                JOptionPane.showMessageDialog(null, "Venta realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ticket_plazoCR() {
        codigos();
        String InsertarSQL = "INSERT INTO ventas (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas,ventas_des) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_plazo.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("FINALIZADA");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_default_id.getText();
        String literal = lbl_literal.getText();
        String id_user = Principal.lbl_id_user.getText();
        String describe = txt_des_ventas.getText();
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, cod_cli);
            pst.setString(3, nom_cli);
            pst.setString(4, formapag);
            pst.setString(5, dias_pla);
            pst.setString(6, total_ventas);
            pst.setString(7, total_real);
            pst.setString(8, total_dolar);
            pst.setString(9, estado);
            pst.setString(10, fecha);
            pst.setString(11, user);
            pst.setString(12, almacen);
            pst.setString(13, cantidad);
            pst.setString(14, literal);
            pst.setString(15, id_user);
            pst.setString(16, describe);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {

                detalle_ticket();
                String capcod = "", capcan = "";
                for (int i = 0; i < Ventas_venta.tb_factura.getRowCount(); i++) {
                    capcod = Ventas_venta.tb_factura.getValueAt(i, 0).toString();
                    capcan = Ventas_venta.tb_factura.getValueAt(i, 3).toString();

                    descontarstock(capcod, capcan);

                }

                JOptionPane.showMessageDialog(null, "Venta realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    public static String fechaactS() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);

    }

    void codigos() {

        String c = "";
        String SQL = "select max(num_bol) from ventas";

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
            Logger.getLogger(Ventas_venta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_factura.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Ventas_venta.tb_factura.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));

    }

    public void calcularSubtotal() {

        int Acumulador = 0;
        int TF = tb_factura.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Ventas_venta.tb_factura.getValueAt(i, 5).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        txttotal.setText(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(Acumulador)));

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
            lbl_plazos_dias.setVisible(true);
            txt_dias_plazo.setVisible(true);

        }
    }

    void caja() {

        String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo,cuenta_nro,cuenta_nom) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String descaja = ("EN CONCEPTO DE VENTA:NOTA N°" + lbl_cod.getText());
        String total_gs = txttotal.getText();
        String his = ("VENTAS");
        String egreso_gs = ("0");
        String egreso_rs = ("0");
        String fecha_caja = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String moneda = txt_simbolo.getText();
        String tipo_caja = ("C");
        String cuenta_nro = lbl_nro_cuenta.getText();
        String cuenta = lbl_nom_cuenta.getText();
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, descaja);
            pst.setString(2, total_gs);
            pst.setString(3, his);
            pst.setString(4, egreso_gs);
            pst.setString(5, egreso_rs);
            pst.setString(6, fecha_caja);
            pst.setString(7, user);
            pst.setString(8, moneda);
            pst.setString(9, tipo_caja);
            pst.setString(10, cuenta_nro);
            pst.setString(11, cuenta);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                //JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    void cargarConfig() throws IOException {
        String mostrar = "SELECT * FROM empresas";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                //lbl_empresa.setText(rs.getString(2));
                lbl_nro_cuenta.setText(rs.getString(6));
                lbl_nom_cuenta.setText(rs.getString(7));
                // lbl_caja_rap.setText(rs.getString(5));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarCuenta() throws IOException {
        String id = lbl_nro_cuenta.getText();
        String mostrar = "SELECT saldo_cuenta FROM cuentas where nro_cuentas ='" + id + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                //lbl_saldo_cuenta.setText(rs.getString(4));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularCaja() {

        String totalCuenta = "0";
        BigDecimal ValorTotal = ingreso.TransformReales(txttotal.getText().replaceAll("\\s", ""));
        BigDecimal ValorCuenta = ingreso.TransformReales(lbl_saldo_cuenta.getText().replaceAll("\\s", ""));
        totalCuenta = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorTotal.add(ValorCuenta).toString());
        lbl_saldo_actual.setText(totalCuenta);

    }

    public void calcular_amorti() {

        String totalCuenta = "0";
        BigDecimal ValorTotal = ingreso.TransformReales(lbl_total_amort.getText().replaceAll("\\s", ""));
        BigDecimal ValorCuenta = ingreso.TransformReales(lbl_valor_amortz.getText().replaceAll("\\s", ""));
        totalCuenta = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorTotal.add(ValorCuenta).toString());
        txttotal.setText(totalCuenta);

    }

    void actCuenta() {

        try {
            String id = lbl_nro_cuenta.getText();
            String saldo = lbl_saldo_actual.getText();

            String sql = "UPDATE cuentas SET saldo_cuenta = '" + saldo
                    + "' WHERE nro_cuentas = '" + id + "'";
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

    ////////////buscar presupuesto///////////////////////////////
    public void cargar(String valor) {
        String mostrar = "SELECT * FROM presupuesto_detalles WHERE CONCAT(num_bol) LIKE '%" + valor + "%'";
        String[] titulos = {"Id Producto", "Descripción", "Precio Unitario", "Unidad", "Kg", "Precio Venta", "Stock"};
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
                Registros[4] = rs.getString("cant_kg");
                Registros[5] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_factura.setModel(model);

            tb_factura.getColumnModel().getColumn(0).setPreferredWidth(90);
            tb_factura.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_factura.getColumnModel().getColumn(2).setPreferredWidth(130);
            tb_factura.getColumnModel().getColumn(3).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(4).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(5).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM presupuesto WHERE CONCAT(num_bol) LIKE '%" + valor + "%'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_cod_cli.setText(rs.getString(2));
                txt_cli_nom.setText(rs.getString(3));
                txt_dias_plazo.setText(rs.getString(5));
                lbl_default_id.setText(rs.getString(13));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////buscar pedidos
    public void cargarPedidos(String valor) {
        String mostrar = "SELECT * FROM pedidos_detalles WHERE CONCAT(num_pedi) LIKE '%" + valor + "%'";
        String[] titulos = {"Id Producto", "Descripción", "Precio Unitario", "Unidad", "Kg", "Precio Venta", "Stock"};
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
                Registros[4] = rs.getString("cant_kg");
                Registros[5] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_factura.setModel(model);

            tb_factura.getColumnModel().getColumn(0).setPreferredWidth(90);
            tb_factura.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_factura.getColumnModel().getColumn(2).setPreferredWidth(130);
            tb_factura.getColumnModel().getColumn(3).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(4).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(5).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTxtPedidos(String valor) {
        String mostrar = "SELECT * FROM pedidos WHERE CONCAT(num_pedi) LIKE '%" + valor + "%'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                txt_dias_plazo.setText(rs.getString(5));
                lbl_default_id.setText(rs.getString(13));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////buscar ventas_mofid///////////////////////////////
    public void cargarVentas(String valor) {
        String mostrar = "SELECT * FROM ventas_detalles WHERE CONCAT(num_bol) LIKE '%" + valor + "%'";
        String[] titulos = {"Id Producto", "Descripción", "Precio Unitario", "Unidad", "Kg", "Precio Venta"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("id_ven_deta");
                Registros[1] = rs.getString("des_pro");
                Registros[2] = rs.getString("pre_unit");
                Registros[3] = rs.getString("cant_pro");
                Registros[4] = rs.getString("cant_kg");
                Registros[5] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_factura.setModel(model);

            tb_factura.getColumnModel().getColumn(0).setPreferredWidth(90);
            tb_factura.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_factura.getColumnModel().getColumn(2).setPreferredWidth(130);
            tb_factura.getColumnModel().getColumn(3).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(4).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(5).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTxtVEntas(String valor) {
        String mostrar = "SELECT * FROM ventas WHERE CONCAT(num_bol) LIKE '%" + valor + "%'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_cod_cli.setText(rs.getString(2));
                txt_cli_nom.setText(rs.getString(3));
                txt_dias_plazo.setText(rs.getString(5));
                lbl_default_id.setText(rs.getString(13));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcular_pre() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_factura.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_factura.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            txttotal.setText(total);
            lbl_total_amort.setText(total);

        }
    }

    void cargar() {
        String mostrar = "SELECT * FROM cotizaciones ORDER BY cot_fecha ASC";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                if (Principal.txt_simbolo.getText().equals("Gs")) {
                    lbl_r.setText(rs.getString(3));
                    lbl_dolar.setText(rs.getString(5));
                }
                if (Principal.txt_simbolo.getText().equals("US$")) {
                    lbl_r.setText(rs.getString(3));
                    lbl_dolar.setText(rs.getString(2));
                }
            }
            conectar.getInstance().closeConnection(cn);
            cargarCambiosConf();

        } catch (SQLException ex) {
            Logger.getLogger(Ventas_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Consultastock(String codi) {

        String cap = "";
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

        /*desfinal = Integer.parseInt(cap) - des;
         String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
         try {
         PreparedStatement pst = cn.prepareStatement(modi);
         pst.executeUpdate();
         } catch (Exception e) {
         }*/
    }

    void cobrar() {
        id_doc_nro_ventas = lbl_cod.getText();
        id_nro_cuenta_ventas = lbl_nro_cuenta.getText();
        total_doc_ventas = txttotal.getText();

        Forma_pago_gral_rap fvv = null;
        fvv = new Forma_pago_gral_rap(new javax.swing.JDialog(), true);
        fvv.setVisible(true);

    }

    void contarFilas() {
        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            lbl_cant_produ.setText(i + "");
        }

    }

    void cargarCambiosConf() {

        if (Principal.txt_simbolo.getText().equals("Gs")) {

            Icon Imagenes = new ImageIcon(getClass().getResource("/Iconos_1/paraguay.png"));
            lbl_cambio_conver_3.setIcon(Imagenes);
            Icon Imagenes2 = new ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"));
            lbl_cambio_conver_1.setIcon(Imagenes2);
            lbl_cambio_mon_1.setIcon(Imagenes2);
            Icon Imagenes3 = new ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"));
            lbl_cambio_conver_2.setIcon(Imagenes3);
            lbl_cambio_mon_2.setIcon(Imagenes3);
            lbl_cambio_conver_3.setText("GS:");
            lbl_cambio_conver_2.setText("US$:");
            lbl_cambio_conver_1.setText("RS$:");
        }
        if (Principal.txt_simbolo.getText().equals("US$")) {
            Icon Imagenes = new ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"));
            lbl_cambio_conver_3.setIcon(Imagenes);
            Icon Imagenes2 = new ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"));
            lbl_cambio_conver_1.setIcon(Imagenes2);
            lbl_cambio_mon_1.setIcon(Imagenes2);
            Icon Imagenes3 = new ImageIcon(getClass().getResource("/Iconos_1/paraguay.png"));
            lbl_cambio_conver_2.setIcon(Imagenes3);
            lbl_cambio_mon_2.setIcon(Imagenes3);
            lbl_cambio_conver_3.setText("US$:");
            lbl_cambio_conver_2.setText("GS:");
            lbl_cambio_conver_1.setText("RS$:");
        }

    }

}
