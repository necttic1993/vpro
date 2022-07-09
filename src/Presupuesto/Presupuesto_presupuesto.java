/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presupuesto;

import Clases.Clase_Literal;
import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_mone_def;
import static Loggin_Principal.Principal.lbl_usu_almacen;
import static Loggin_Principal.Principal.lbl_usu_nom;
import static Presupuesto.Principal_presupuesto.cod_modificacion;
import static Presupuesto.Principal_presupuesto.cod_nota_pre;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Presupuesto_presupuesto extends javax.swing.JDialog {

    /**
     * Creates new form facturacion
     *
     * @param parent
     */
    public Presupuesto_presupuesto(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();

        lbl_perm_edit.setText(cod_modificacion);
        if (cod_modificacion.equals("1")) {
            lbl_cod.setText(cod_nota_pre);
            cargarTxtVEntas(cod_nota_pre);
            cargarVentas(cod_nota_pre);
            Presupuesto_presupuesto.btncalcular.doClick();

        } else {
            codigos();
        }

        cargar();

        ttx_des_pre.setDocument(new machusculas());
        txt_ventas_op.setDocument(new machusculas());
        btncalcular.setVisible(false);
        lbl_cant_presu.setVisible(false);
        txt_cli_nom.setDisabledTextColor(Color.black);
        lbl_fecha_VISOR.setText(fechaactS());
        tb_factura.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_factura.getColumnModel().getColumn(1).setPreferredWidth(323);
        tb_factura.getColumnModel().getColumn(2).setPreferredWidth(120);
        tb_factura.getColumnModel().getColumn(3).setPreferredWidth(75);
        tb_factura.getColumnModel().getColumn(4).setPreferredWidth(75);
        tb_factura.getColumnModel().getColumn(5).setPreferredWidth(120);
        chk_contado.setSelected(true);
        lbl_plazos_dias.setVisible(false);
        txt_dias_plazo.setVisible(false);
        lbl_literal_pro.setVisible(false);
        lbl_literal.setVisible(false);
        btn_mone.setVisible(false);
        lbl_saldo_anticipo.setVisible(false);
        btn_calc_modify.setVisible(false);
        lbl_sur_nombre.setVisible(false);
        lbl_default_id.setVisible(false);
        lbl_tipo_venta.setText("CONTADO");
        txt_usu_ventas.setText(lbl_usu_nom.getText());
        lbl_sur_nombre.setText(lbl_usu_almacen.getText());

    }

    public static String cod_alamacen_user = "";

    public static String nro_nota_plazo = "";
    public static String tota_ventas = "";
    public static String id_venta_pago_ventas_normal = "";
    public static String id_nro_cuentas = "";
    public static String total_ventas_normal = "";
    public static String cod_print_presupuesto_modulo = "";
    ///modificar cantidad
    public static String cod_pro_mod_cant = "";
    public static String des_pro_mod_cant = "";
    public static String cant_pro_mod_cant = "";
    public static String precio_pro_mod_cant = "";
    public static String id_pro_mod_cant = "";

    ///
    String status_modify = "0";

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
                    lbl_dolar.setText(rs.getString(5));
                }
            }
            conectar.getInstance().closeConnection(cn);
            cargarCambiosConf();
        } catch (SQLException ex) {
            Logger.getLogger(Presupuesto_presupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        txt_class_cli = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btn_excluir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lbl_cambio_real = new javax.swing.JLabel();
        lbl_cambio_dolar = new javax.swing.JLabel();
        lbl_cambio_conver_1 = new javax.swing.JLabel();
        lbl_cambio_conver_2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txttotal = new javax.swing.JLabel();
        lbl_cambio_conver_3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_anticipo_cli = new javax.swing.JTextField();
        ttx_des_pre = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_cambio_mon_1 = new javax.swing.JLabel();
        lbl_r = new javax.swing.JLabel();
        lbl_cambio_mon_2 = new javax.swing.JLabel();
        lbl_dolar = new javax.swing.JLabel();
        pn_tipo_venta = new javax.swing.JPanel();
        lbl_tipo_venta = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblcanpro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_plazos_dias1 = new javax.swing.JLabel();
        lbl_plazos_dias = new javax.swing.JLabel();
        txt_dias_plazo = new javax.swing.JTextField();
        lbl_default_id = new javax.swing.JLabel();
        lbl_literal = new javax.swing.JLabel();
        btn_mone = new javax.swing.JButton();
        lbl_literal_pro = new javax.swing.JLabel();
        btncalcular = new javax.swing.JButton();
        btn_calc_modify = new javax.swing.JButton();
        lbl_cant_presu = new javax.swing.JLabel();
        lbl_sur_nombre = new javax.swing.JLabel();
        btnven = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        lbl_perm_edit = new javax.swing.JLabel();
        lbl_saldo_anticipo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_ventas_op = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PRESUPUESTO");
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_factura = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_factura.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio Unitario", "Unidad", "Kg", "Precio Total"
            }
        ));
        tb_factura.setGridColor(new java.awt.Color(255, 255, 255));
        tb_factura.setRowHeight(22);
        jScrollPane1.setViewportView(tb_factura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 800, 320));

        lbl_cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cod.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cod.setText("0000001");
        lbl_cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 110, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Nro de Nota:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 10, 90, 30));

        chk_contado.setBackground(new java.awt.Color(255, 255, 255));
        chk_contado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_contado.setText("CONTADO");
        chk_contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_contadoActionPerformed(evt);
            }
        });
        jPanel1.add(chk_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Clas. Cliente:");
        jLabel16.setFocusable(false);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 90, 30));

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
        jPanel1.add(txt_cod_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 8, 90, 32));

        txt_cli_nom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_cli_nom.setEnabled(false);
        txt_cli_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_nomActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cli_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 8, 330, 32));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Descripción:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 30));

        btn_buscaar_items.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscaar_items.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscaar_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        btn_buscaar_items.setMnemonic('a');
        btn_buscaar_items.setToolTipText("ALT+A");
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
        jPanel1.add(btn_buscaar_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 70, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Nombre del Cliente :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, 32));

        txt_usu_ventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_usu_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_usu_ventas.setEnabled(false);
        txt_usu_ventas.setFocusable(false);
        jPanel1.add(txt_usu_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 260, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Usuario Ventas:");
        jLabel18.setFocusable(false);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));

        lbl_fecha_VISOR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_fecha_VISOR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_fecha_VISOR.setEnabled(false);
        lbl_fecha_VISOR.setFocusable(false);
        jPanel1.add(lbl_fecha_VISOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 100, 30));

        chk_plazo.setBackground(new java.awt.Color(255, 255, 255));
        chk_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_plazo.setText("CRÉDITO");
        chk_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_plazoActionPerformed(evt);
            }
        });
        jPanel1.add(chk_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 90, 30));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 8, 40, 32));

        txt_class_cli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_class_cli.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        txt_class_cli.setEnabled(false);
        jPanel1.add(txt_class_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 140, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Fecha Emisión:");
        jLabel21.setFocusable(false);
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 100, 30));

        btn_excluir.setBackground(new java.awt.Color(255, 255, 255));
        btn_excluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btn_excluir.setMnemonic('e');
        btn_excluir.setToolTipText("Remover Productos ALT+E");
        btn_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_excluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_excluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 70, 45));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cotizaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cambio_real.setBackground(new java.awt.Color(102, 102, 102));
        lbl_cambio_real.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_real.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cambio_real.setText("0");
        lbl_cambio_real.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel6.add(lbl_cambio_real, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, 30));

        lbl_cambio_dolar.setBackground(new java.awt.Color(102, 102, 102));
        lbl_cambio_dolar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_dolar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cambio_dolar.setText("0");
        lbl_cambio_dolar.setAutoscrolls(true);
        lbl_cambio_dolar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel6.add(lbl_cambio_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 170, 30));

        lbl_cambio_conver_1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_conver_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"))); // NOI18N
        lbl_cambio_conver_1.setText("RS$:");
        jPanel6.add(lbl_cambio_conver_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        lbl_cambio_conver_2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_conver_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"))); // NOI18N
        lbl_cambio_conver_2.setText("US$:");
        jPanel6.add(lbl_cambio_conver_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 30, -1, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 470, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttotal.setBackground(new java.awt.Color(102, 102, 102));
        txttotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txttotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txttotal.setText("0");
        txttotal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txttotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txttotal.setVerifyInputWhenFocusTarget(false);
        txttotal.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel2.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 190, 30));

        lbl_cambio_conver_3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_conver_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/paraguay.png"))); // NOI18N
        lbl_cambio_conver_3.setText("GS.:");
        jPanel2.add(lbl_cambio_conver_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 310, 80));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Condición de pago :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/lapiz_editar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 70, 45));

        txt_anticipo_cli.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_anticipo_cli.setText("0");
        txt_anticipo_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_anticipo_cliKeyReleased(evt);
            }
        });
        jPanel1.add(txt_anticipo_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, 160, 30));

        ttx_des_pre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(ttx_des_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 470, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Informaciones:");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel20.setFocusable(false);
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 130, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/dollar.png"))); // NOI18N
        jLabel2.setText("   Cotización:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 160, 40));

        lbl_cambio_mon_1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_mon_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"))); // NOI18N
        lbl_cambio_mon_1.setText("=");
        jPanel1.add(lbl_cambio_mon_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, -1, 30));

        lbl_r.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_r.setText("1,365");
        jPanel1.add(lbl_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 70, 30));

        lbl_cambio_mon_2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_mon_2.setForeground(new java.awt.Color(0, 0, 102));
        lbl_cambio_mon_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"))); // NOI18N
        lbl_cambio_mon_2.setText("=");
        jPanel1.add(lbl_cambio_mon_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, -1, 30));

        lbl_dolar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_dolar.setForeground(new java.awt.Color(0, 0, 102));
        lbl_dolar.setText("5,780");
        jPanel1.add(lbl_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, 60, 30));

        pn_tipo_venta.setBackground(new java.awt.Color(0, 153, 204));
        pn_tipo_venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tipo_venta.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_tipo_venta.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipo_venta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tipo_venta.setText("CONTADO");
        pn_tipo_venta.add(lbl_tipo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 30));

        jPanel1.add(pn_tipo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 290, -1));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        lblcanpro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcanpro.setForeground(new java.awt.Color(255, 255, 255));
        lblcanpro.setText("0");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
                .addComponent(lblcanpro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblcanpro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, -1, 30));

        lbl_plazos_dias1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plazos_dias1.setText("Anticipo del cliente:");
        jPanel1.add(lbl_plazos_dias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 110, 30));

        lbl_plazos_dias.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plazos_dias.setText("N° Cuotas:");
        jPanel1.add(lbl_plazos_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 70, 30));

        txt_dias_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_dias_plazo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dias_plazo.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_dias_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dias_plazoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_dias_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 160, 80, 30));

        lbl_default_id.setText("lbl_default");
        jPanel1.add(lbl_default_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, -1, -1));

        lbl_literal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_literal.setText("gs");
        jPanel1.add(lbl_literal, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, 30, 20));

        btn_mone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moneActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mone, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 50, 20));

        lbl_literal_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_literal_pro.setText("Son:");
        jPanel1.add(lbl_literal_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 20, -1));

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
        jPanel1.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 320, 40, 20));

        btn_calc_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calc_modifyActionPerformed(evt);
            }
        });
        jPanel1.add(btn_calc_modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, 50, 20));

        lbl_cant_presu.setText("count");
        jPanel1.add(lbl_cant_presu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, -1, -1));

        lbl_sur_nombre.setText("alma");
        jPanel1.add(lbl_sur_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 320, 30, 20));

        btnven.setBackground(new java.awt.Color(255, 255, 255));
        btnven.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnven.setText("Grabar");
        btnven.setToolTipText("");
        btnven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnven.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });
        jPanel1.add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 130, 45));

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
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 490, 130, 45));

        lbl_perm_edit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_perm_edit.setText("0");
        lbl_perm_edit.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lbl_perm_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 60, 30));

        lbl_saldo_anticipo.setText("0");
        jPanel1.add(lbl_saldo_anticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, 30, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Nro OP:");
        jLabel23.setFocusable(false);
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 50, 30));

        txt_ventas_op.setBackground(new java.awt.Color(255, 255, 0));
        txt_ventas_op.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_ventas_op, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cli_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_nomActionPerformed

    private void txt_cod_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_cliKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            Clientes_presupuesto cv;
            cv = new Clientes_presupuesto(new javax.swing.JDialog(), true);
            cv.setVisible(true);

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir ?",
                    "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.dispose();
                Presupuesto.Principal_presupuesto.txt_bus.requestFocus();
                Presupuesto.Principal_presupuesto.txt_bus.setText("");
            }

        }
    }//GEN-LAST:event_txt_cod_cliKeyPressed

    private void txt_cod_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_cliActionPerformed

    private void chk_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_plazoActionPerformed
        chk_contado.setSelected(false);
        TiposPagos();
        lbl_tipo_venta.setText("CRÉDITO");
        pn_tipo_venta.setBackground(Color.red);

    }//GEN-LAST:event_chk_plazoActionPerformed

    private void chk_contadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_contadoActionPerformed
        chk_plazo.setSelected(false);
        lbl_plazos_dias.setVisible(false);
        txt_dias_plazo.setVisible(false);

        txt_dias_plazo.setText("");
        lbl_tipo_venta.setText("CONTADO");
        pn_tipo_venta.setBackground(Color.blue);


    }//GEN-LAST:event_chk_contadoActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        contarFilas();
        calcular();
        calcularMoneda();
        calcularCantidadPro();
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
            Almacen_select_presupuesto as;
            as = new Almacen_select_presupuesto(new javax.swing.JDialog(), true);
            as.setVisible(true);
        } else {
            String def = lbl_sur_nombre.getText();
            lbl_default_id.setText(def);
            Productos_presupuesto rp;
            rp = new Productos_presupuesto(new javax.swing.JDialog(), true);
            rp.setVisible(true);

        }
    }//GEN-LAST:event_btn_buscaar_itemsActionPerformed

    private void btn_moneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moneActionPerformed
        calcularSubtotal();
        calcularMoneda();
        calcularCantidadPro();
        literal();
    }//GEN-LAST:event_btn_moneActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // TODO add your handling code here:

        if (lbl_perm_edit.getText().equals("1")) {
            try {

                DefaultTableModel model = (DefaultTableModel) tb_factura.getModel();
                int fila = tb_factura.getSelectedRow();
                String id_prod = (String) tb_factura.getValueAt(fila, 0);
                ///emliminar
                if (fila >= 0) {
                    Connection cn = conectar.getInstance().getConnection();
                    String eliminarSQL = "DELETE FROM presupuesto_detalles WHERE id_pre_det = '" + id_prod + "'";
                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);
                    JOptionPane.showMessageDialog(null, "OK");
///
                    model.removeRow(fila);
                    calcular();
                    calcularMoneda();
                    calcularCantidadPro();

                } else {

                    JOptionPane.showMessageDialog(null, "Tabla vacia o no seleccione ninguna fila");
                }
                if (fila < 0) {
                    lbl_cambio_dolar.setText("");
                    txttotal.setText("");
                    lbl_cambio_real.setText("");
                }

            } catch (SQLException | HeadlessException e) {
                // JOptionPane.showMessageDialog(null, e);
            }
        } else {

            DefaultTableModel model = (DefaultTableModel) tb_factura.getModel();
            int fila = tb_factura.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);
                calcular();
                calcularMoneda();
                calcularCantidadPro();

            } else {

                JOptionPane.showMessageDialog(null, "Tabla vacia o no seleccione ninguna fila");
            }
            if (fila < 0) {
                lbl_cambio_dolar.setText("");
                txttotal.setText("");
                lbl_cambio_real.setText("");
            }
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Clientes_presupuesto cv;
        cv = new Clientes_presupuesto(new javax.swing.JDialog(), true);
        cv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //    new Thread(new hilo()).start();

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void txt_dias_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dias_plazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dias_plazoActionPerformed

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed

        if (chk_contado.isSelected()) {

            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals("")) || (txt_cod_cli.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {
                if (lbl_perm_edit.getText().equals("1")) {
                    actualizarContado();
                    status_modify = "1";
                    Principal_presupuesto.btn_cargar_datos.doClick();
                    this.dispose();

                } else {
                    ticket();
                }

                // caja();
                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    cod_print_presupuesto_modulo = lbl_cod.getText();
                    printers_pres est;
                    est = new printers_pres(new javax.swing.JDialog(), true);
                    est.setVisible(true);
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

            }
        }

        if (chk_plazo.isSelected()) {

            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {
                if (lbl_perm_edit.getText().equals("1")) {
                    actualizarPlazo();
                    status_modify = "1";
                    Principal_presupuesto.btn_cargar_datos.doClick();
                    this.dispose();
                } else {
                    ticket_plazo();
                }
                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    printers_pres est;
                    est = new printers_pres(new javax.swing.JDialog(), true);
                    est.setVisible(true);
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

            }
        }

        txt_cod_cli.requestFocus();
        Principal_presupuesto.btn_cargar_datos.doClick();
    }//GEN-LAST:event_btnvenActionPerformed

    private void btn_salirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_salirKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {

            btn_salir.doClick();

        }
    }//GEN-LAST:event_btn_salirKeyReleased

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir ?",
                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //  new Thread(new hilo()).interrupt();
            if (lbl_perm_edit.getText().equals("1")) {
                if (status_modify.equals("0")) {
                    JOptionPane.showMessageDialog(null, "La nota no de fue guardada, por favor finalice la operación");
                } else {
                    dispose();
                }

            } else {
                dispose();
            }

        }

    }//GEN-LAST:event_btn_salirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filasel = tb_factura.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro válido");
        } else {

            int filaModi = tb_factura.getSelectedRow();

            if (lbl_perm_edit.getText().equals("1")) {
                id_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 6);
                cod_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 0);
                des_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 1);
                cant_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 3);
                precio_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 2);
                Ajuste_cantidad an;
                an = new Ajuste_cantidad(new javax.swing.JDialog(), true);
                an.setVisible(true);
            } else {
                cod_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 0);
                des_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 1);
                cant_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 3);
                precio_pro_mod_cant = (String) tb_factura.getValueAt(filaModi, 2);
                Ajuste_cantidad an;
                an = new Ajuste_cantidad(new javax.swing.JDialog(), true);
                an.setVisible(true);

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_anticipo_cliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anticipo_cliKeyReleased
        ActivatedYourLife(txt_anticipo_cli, evt);
        calcularAnticipo();
    }//GEN-LAST:event_txt_anticipo_cliKeyReleased

    private void btn_calc_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calc_modifyActionPerformed
        cargarVentas(cod_nota_pre);
        Presupuesto_presupuesto.btncalcular.doClick();

    }//GEN-LAST:event_btn_calc_modifyActionPerformed

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
            java.util.logging.Logger.getLogger(Presupuesto_presupuesto.class
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
                try {
                    Presupuesto_presupuesto dialog = null;

                    dialog = new Presupuesto_presupuesto(new javax.swing.JDialog(), true);

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
                    Logger.getLogger(Presupuesto_presupuesto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_buscaar_items;
    public static javax.swing.JButton btn_calc_modify;
    private javax.swing.JButton btn_excluir;
    public static javax.swing.JButton btn_mone;
    private javax.swing.JButton btn_salir;
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton btnven;
    private javax.swing.JCheckBox chk_contado;
    private javax.swing.JCheckBox chk_plazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cambio_conver_1;
    private javax.swing.JLabel lbl_cambio_conver_2;
    private javax.swing.JLabel lbl_cambio_conver_3;
    public static javax.swing.JLabel lbl_cambio_dolar;
    private javax.swing.JLabel lbl_cambio_mon_1;
    private javax.swing.JLabel lbl_cambio_mon_2;
    public static javax.swing.JLabel lbl_cambio_real;
    public static javax.swing.JLabel lbl_cant_presu;
    public static javax.swing.JLabel lbl_cod;
    public static javax.swing.JLabel lbl_default_id;
    private javax.swing.JLabel lbl_dolar;
    private javax.swing.JTextField lbl_fecha_VISOR;
    private javax.swing.JLabel lbl_literal;
    private javax.swing.JLabel lbl_literal_pro;
    public static javax.swing.JLabel lbl_perm_edit;
    private javax.swing.JLabel lbl_plazos_dias;
    private javax.swing.JLabel lbl_plazos_dias1;
    private javax.swing.JLabel lbl_r;
    private javax.swing.JLabel lbl_saldo_anticipo;
    private javax.swing.JLabel lbl_sur_nombre;
    private javax.swing.JLabel lbl_tipo_venta;
    public static javax.swing.JLabel lblcanpro;
    private javax.swing.JPanel pn_tipo_venta;
    public static javax.swing.JTable tb_factura;
    private javax.swing.JTextField ttx_des_pre;
    private javax.swing.JTextField txt_anticipo_cli;
    public static javax.swing.JTextField txt_class_cli;
    public static javax.swing.JTextField txt_cli_nom;
    public static javax.swing.JTextField txt_cod_cli;
    public static javax.swing.JTextField txt_dias_plazo;
    private javax.swing.JTextField txt_usu_ventas;
    private javax.swing.JTextField txt_ventas_op;
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
            lbl_saldo_anticipo.setText(total);

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

    }//FIN METODO public vo

    void ticket() {
        codigos();
        String InsertarSQL = "INSERT INTO presupuesto (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas,anticip_cliente,pre_saldo_antic,nro_fact_ventas) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_contado.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("EMITIDO");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_default_id.getText();
        String literal = lbl_literal.getText();
        String desc = ttx_des_pre.getText();
        String anticipo = txt_anticipo_cli.getText();
        ////
        String saldo_anticipo = lbl_saldo_anticipo.getText();
        String nro_op = txt_ventas_op.getText();

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
            pst.setString(15, desc);
            pst.setString(16, anticipo);
            pst.setString(17, saldo_anticipo);
            pst.setString(18, nro_op);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_ticket();
                JOptionPane.showMessageDialog(null, "Nota realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Presupuesto_presupuesto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ticket_plazo() {
        codigos();
        String InsertarSQL = "INSERT INTO presupuesto (num_bol,cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,total_ventas,total_real,total_dolar,estado_ventas,fecha_ventas,user_ventas,almacen_ventas,cant_ventas,letras_ventas,vac_ventas,anticip_cliente,pre_saldo_antic,nro_fact_ventas) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_plazo.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("EMITIDO");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_default_id.getText();
        String literal = lbl_literal.getText();
        String desc = ttx_des_pre.getText();
        String anticipo = txt_anticipo_cli.getText();
        ////
        String saldo_anticipo = lbl_saldo_anticipo.getText();
        String nro_op = txt_ventas_op.getText();

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
            pst.setString(15, desc);
            pst.setString(16, anticipo);
            pst.setString(17, saldo_anticipo);
            pst.setString(18, nro_op);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_ticket();
                JOptionPane.showMessageDialog(null, "Nota realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Presupuesto_presupuesto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void detalle_ticket() {
        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO presupuesto_detalles (num_bol,cod_pro,des_pro,cant_pro,pre_unit,cant_kg,pre_venta,data) VALUES (?,?,?,?,?,?,?,?)";
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
                Logger.getLogger(Presupuesto_presupuesto.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
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
        String SQL = "select max(num_bol) from presupuesto";

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
            Logger.getLogger(Presupuesto_presupuesto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_factura.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Presupuesto_presupuesto.tb_factura.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));

    }

    public void calcularSubtotal() {

        int Acumulador = 0;
        int TF = tb_factura.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Presupuesto_presupuesto.tb_factura.getValueAt(i, 5).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
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

    void contarFilas() {
        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            lbl_cant_presu.setText(i + "");
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
                    this.txt_anticipo_cli.setText(
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
            String Texting = txt_anticipo_cli.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_anticipo_cli.setText(Integrated);
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

    ///CARGAR DETALLES PARA MODIFICAR
    public void cargarVentas(String valor) {
        String mostrar = "SELECT cod_pro,des_pro,pre_unit,cant_pro,cant_kg,pre_venta,id_pre_det FROM presupuesto_detalles WHERE num_bol= '" + valor + "'";
        String[] titulos = {"Id Producto", "Descripción", "Precio Unitario", "Unidad", "Kg", "Precio Venta", "Id "};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);
                Registros[4] = rs.getString(5);
                Registros[5] = rs.getString(6);
                Registros[6] = rs.getString(7);

                model.addRow(Registros);
            }
            tb_factura.setModel(model);

            tb_factura.getColumnModel().getColumn(0).setPreferredWidth(90);
            tb_factura.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_factura.getColumnModel().getColumn(2).setPreferredWidth(130);
            tb_factura.getColumnModel().getColumn(3).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(4).setPreferredWidth(83);
            tb_factura.getColumnModel().getColumn(5).setPreferredWidth(130);
            tb_factura.getColumnModel().getColumn(6).setPreferredWidth(50);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Presupuesto_presupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTxtVEntas(String valor) {
        String mostrar = "SELECT cod_cli_ventas,nom_cli_ventas,forma_pag_ventas,dias_plazo_ventas,user_ventas FROM presupuesto  WHERE num_bol= '" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_cod_cli.setText(rs.getString(1));
                txt_cli_nom.setText(rs.getString(2));
                String tipo = rs.getString(3);
                txt_dias_plazo.setText(rs.getString(4));
                txt_usu_ventas.setText(rs.getString(5));

                if (tipo.equals("CONTADO")) {
                    chk_plazo.setSelected(false);
                    lbl_plazos_dias.setVisible(false);
                    txt_dias_plazo.setVisible(false);
                    chk_contado.setSelected(true);
                    txt_dias_plazo.setText("");
                    lbl_tipo_venta.setText("CONTADO");
                    lbl_tipo_venta.setForeground(Color.white);
                    pn_tipo_venta.setBackground(Color.blue);

                }
                if (tipo.equals("CRÉDITO")) {
                    chk_contado.setSelected(false);
                    chk_plazo.setSelected(true);
                    TiposPagos();
                    lbl_tipo_venta.setText("CRÉDITO");
                    pn_tipo_venta.setBackground(Color.red);

                }

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Presupuesto_presupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularAnticipo() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_factura.getRowCount(); i++) {
            BigDecimal total_pre = ingreso.TransformReales(txttotal.getText().replaceAll("\\s", ""));
            BigDecimal anticipo = ingreso.TransformReales(txt_anticipo_cli.getText().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(total_pre.subtract(anticipo).toString());

            lbl_saldo_anticipo.setText(imp);

        }
    }

    ///actulizacion de resgitro de presupuesto
    void actualizarContado() {
        try {

            String numbol = lbl_cod.getText();
            String cod_cli = txt_cod_cli.getText();
            String nom_cli = txt_cli_nom.getText();//cambiar en db
            String formapag = chk_contado.getText();
            String dias_pla = txt_dias_plazo.getText();
            String total_ventas = txttotal.getText();
            String total_real = lbl_cambio_real.getText();
            String total_dolar = lbl_cambio_dolar.getText();
            String estado = ("EMITIDO");
            String fecha = lbl_fecha_hoy.getText();
            String user = lbl_usu_nom.getText();
            String cantidad = lblcanpro.getText();//cambiar en db
            String almacen = lbl_default_id.getText();
            String literal = lbl_literal.getText();
            String desc = ttx_des_pre.getText();
            String anticipo = txt_anticipo_cli.getText();
            ////
            String saldo_anticipo = lbl_saldo_anticipo.getText();
            String nro_op = txt_ventas_op.getText();

            String sql = "UPDATE presupuesto SET cod_cli_ventas = '" + cod_cli
                    + "',nom_cli_ventas ='" + nom_cli
                    + "',forma_pag_ventas ='" + formapag
                    + "',dias_plazo_ventas ='" + dias_pla
                    + "',total_ventas ='" + total_ventas
                    + "',total_real ='" + total_real
                    + "',total_dolar ='" + total_dolar
                    + "',estado_ventas ='" + estado
                    + "',fecha_ventas ='" + fecha
                    + "',user_ventas ='" + user
                    + "',almacen_ventas ='" + almacen
                    + "',cant_ventas ='" + cantidad
                    + "',letras_ventas ='" + literal
                    + "',vac_ventas ='" + desc
                    + "',anticip_cliente ='" + anticipo
                    + "',pre_saldo_antic ='" + saldo_anticipo
                    + "',nro_fact_ventas ='" + nro_op
                    + "' WHERE num_bol = '" + numbol + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Nota Actualizado");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void actualizarPlazo() {
        try {

            String numbol = lbl_cod.getText();
            String cod_cli = txt_cod_cli.getText();
            String nom_cli = txt_cli_nom.getText();//cambiar en db
            String formapag = chk_contado.getText();
            String dias_pla = txt_dias_plazo.getText();
            String total_ventas = txttotal.getText();
            String total_real = lbl_cambio_real.getText();
            String total_dolar = lbl_cambio_dolar.getText();
            String estado = ("EMITIDO");
            String fecha = lbl_fecha_hoy.getText();
            String user = lbl_usu_nom.getText();
            String cantidad = lblcanpro.getText();//cambiar en db
            String almacen = lbl_default_id.getText();
            String literal = lbl_literal.getText();
            String desc = ttx_des_pre.getText();
            String anticipo = txt_anticipo_cli.getText();
            ////
            String saldo_anticipo = lbl_saldo_anticipo.getText();
            String nro_op = txt_ventas_op.getText();

            String sql = "UPDATE presupuesto SET cod_cli_ventas = '" + cod_cli
                    + "',nom_cli_ventas ='" + nom_cli
                    + "',forma_pag_ventas ='" + formapag
                    + "',dias_plazo_ventas ='" + dias_pla
                    + "',total_ventas ='" + total_ventas
                    + "',total_real ='" + total_real
                    + "',total_dolar ='" + total_dolar
                    + "',estado_ventas ='" + estado
                    + "',fecha_ventas ='" + fecha
                    + "',user_ventas ='" + user
                    + "',almacen_ventas ='" + almacen
                    + "',cant_ventas ='" + cantidad
                    + "',letras_ventas ='" + literal
                    + "',vac_ventas ='" + desc
                    + "',anticip_cliente ='" + anticipo
                    + "',pre_saldo_antic ='" + saldo_anticipo
                    + "',nro_fact_ventas ='" + nro_op
                    + "' WHERE num_bol = '" + numbol + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Nota Actualizado");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

}
