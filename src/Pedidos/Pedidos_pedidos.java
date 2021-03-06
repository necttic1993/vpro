/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

import Clases.Clase_Literal;
import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_usu_almacen;
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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class Pedidos_pedidos extends javax.swing.JDialog {

    /**
     * Creates new form facturacion
     *
     * @param parent
     */
    public Pedidos_pedidos(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        panel_config_presupuesto.setVisible(false);
        codigos();
        control_proveedores();
        cargar();
        server();
        btncalcular.setVisible(false);
        
        txt_cli_nom.setDisabledTextColor(Color.black);
        tb_pedidos.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_pedidos.getColumnModel().getColumn(1).setPreferredWidth(323);
        tb_pedidos.getColumnModel().getColumn(2).setPreferredWidth(120);
        tb_pedidos.getColumnModel().getColumn(3).setPreferredWidth(75);
        tb_pedidos.getColumnModel().getColumn(4).setPreferredWidth(75);
        tb_pedidos.getColumnModel().getColumn(5).setPreferredWidth(120);
        txt_op_pedidos.setDocument(new machusculas());
        chk_contado.setSelected(true);
        lbl_plazos_dias.setVisible(false);
        txt_dias_plazo.setVisible(false);
        lbl_literal_pro.setVisible(false);
        lbl_literal.setVisible(false);
        btn_mone.setVisible(false);
        btn_calc_amortizacion.setVisible(false);
        lbl_sur_nombre.setVisible(false);
        lbl_default_id.setVisible(false);
        lbl_cant_produ_pedido.setVisible(false);
        lbl_tipo_venta.setText("CONTADO");
        txt_usu_ventas.setText(lbl_usu_nom.getText());
        lbl_sur_nombre.setText(lbl_usu_almacen.getText());
        
        if (Principal_Pedidos.lbl_ambiente.getText().equals("0")) {
            btn_buscar_presupuesto.setVisible(true);
        } else {
            btn_buscar_presupuesto.setVisible(false);
        }
        
    }
    
    public static String cod_alamacen_user = "";

    /* public static String nro_nota_plazo = "";
     public static String tota_ventas = "";
     public static String id_venta_pago_ventas_normal = "";
     public static String id_nro_cuentas = "";
     public static String total_ventas_normal = "";*/
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
//
            cargarCambiosConf();
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos_pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pedidos = new javax.swing.JTable();
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
        lbl_plazos_dias = new javax.swing.JLabel();
        txt_dias_plazo = new javax.swing.JTextField();
        btn_provee = new javax.swing.JButton();
        lbl_plazos_dias1 = new javax.swing.JLabel();
        txt_op_pedidos = new javax.swing.JTextField();
        btn_excluir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lbl_cambio_real = new javax.swing.JLabel();
        lbl_cambio_dolar = new javax.swing.JLabel();
        lbl_cambio_conver_1 = new javax.swing.JLabel();
        lbl_cambio_conver_2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txttotal = new javax.swing.JLabel();
        lbl_cambio_conver_3 = new javax.swing.JLabel();
        btn_buscar_presupuesto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblcanpro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        pn_tipo_venta = new javax.swing.JPanel();
        lbl_tipo_venta = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_cambio_mon_1 = new javax.swing.JLabel();
        lbl_r = new javax.swing.JLabel();
        lbl_cambio_mon_2 = new javax.swing.JLabel();
        lbl_dolar = new javax.swing.JLabel();
        lbl_default_id = new javax.swing.JLabel();
        lbl_cant_produ_pedido = new javax.swing.JLabel();
        lbl_sur_nombre = new javax.swing.JLabel();
        btn_calc_amortizacion = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btn_mone = new javax.swing.JButton();
        lbl_literal_pro = new javax.swing.JLabel();
        lbl_literal = new javax.swing.JLabel();
        panel_config_presupuesto = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PEDIDOS");
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

        tb_pedidos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_pedidos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C??digo", "Descripci??n", "Precio Unitario", "Unidad", "Kg", "Precio Total"
            }
        ));
        tb_pedidos.setGridColor(new java.awt.Color(255, 255, 255));
        tb_pedidos.setRowHeight(22);
        jScrollPane1.setViewportView(tb_pedidos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 800, 350));

        lbl_cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cod.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cod.setText("0000001");
        lbl_cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 110, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Nro Pedido:");
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
        jLabel16.setText("Fecha Emisi??n:");
        jLabel16.setFocusable(false);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 100, 30));

        txt_cod_cli.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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
        jPanel1.add(txt_cod_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 32));

        txt_cli_nom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_cli_nom.setEnabled(false);
        txt_cli_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_nomActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cli_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 370, 32));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Condici??n de pago :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

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
        jPanel1.add(btn_buscaar_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, -1, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Proveedor :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, 32));

        txt_usu_ventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_usu_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_usu_ventas.setEnabled(false);
        txt_usu_ventas.setFocusable(false);
        jPanel1.add(txt_usu_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 280, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Solicitado por:");
        jLabel18.setFocusable(false);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));

        lbl_fecha_VISOR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_fecha_VISOR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_fecha_VISOR.setEnabled(false);
        lbl_fecha_VISOR.setFocusable(false);
        lbl_fecha_VISOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_fecha_VISORActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_fecha_VISOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 100, 30));

        chk_plazo.setBackground(new java.awt.Color(255, 255, 255));
        chk_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_plazo.setText("CR??DITO");
        chk_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_plazoActionPerformed(evt);
            }
        });
        jPanel1.add(chk_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 90, 30));

        lbl_plazos_dias.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plazos_dias.setText("N?? Cuotas:");
        jPanel1.add(lbl_plazos_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 70, 30));

        txt_dias_plazo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_dias_plazo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dias_plazo.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_dias_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dias_plazoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_dias_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 80, 30));

        btn_provee.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_provee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/agregando-boton-cuadrado-negro-simbolo-de-interfaz.png"))); // NOI18N
        btn_provee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_provee.setFocusable(false);
        btn_provee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_provee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proveeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_provee, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 8, 32, 32));

        lbl_plazos_dias1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plazos_dias1.setText("OP:");
        jPanel1.add(lbl_plazos_dias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 30, 30));

        txt_op_pedidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_op_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 100, 30));

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
        jPanel1.add(btn_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 60, 45));

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

        btn_buscar_presupuesto.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar_presupuesto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar_presupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/timer.png"))); // NOI18N
        btn_buscar_presupuesto.setMnemonic('a');
        btn_buscar_presupuesto.setToolTipText("Subir ventas-pedidos");
        btn_buscar_presupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar_presupuesto.setFocusable(false);
        btn_buscar_presupuesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_buscar_presupuesto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_buscar_presupuesto.setVerifyInputWhenFocusTarget(false);
        btn_buscar_presupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_presupuestoActionPerformed(evt);
            }
        });
        btn_buscar_presupuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_buscar_presupuestoKeyPressed(evt);
            }
        });
        jPanel1.add(btn_buscar_presupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 60, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 550));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addComponent(lblcanpro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblcanpro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 30));

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
        jPanel3.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 130, 45));

        btnven.setBackground(new java.awt.Color(255, 255, 255));
        btnven.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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
        jPanel3.add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 45));

        pn_tipo_venta.setBackground(new java.awt.Color(0, 153, 204));
        pn_tipo_venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tipo_venta.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_tipo_venta.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipo_venta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tipo_venta.setText("CONTADO");
        pn_tipo_venta.add(lbl_tipo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 250, 30));

        jPanel3.add(pn_tipo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 330, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Informaciones:");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel20.setFocusable(false);
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/dollar.png"))); // NOI18N
        jLabel2.setText("   Cotizaci??n:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        lbl_cambio_mon_1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_mon_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"))); // NOI18N
        lbl_cambio_mon_1.setText("=");
        jPanel3.add(lbl_cambio_mon_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        lbl_r.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_r.setText("1,365");
        jPanel3.add(lbl_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 70, 30));

        lbl_cambio_mon_2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cambio_mon_2.setForeground(new java.awt.Color(0, 0, 102));
        lbl_cambio_mon_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"))); // NOI18N
        lbl_cambio_mon_2.setText("=");
        jPanel3.add(lbl_cambio_mon_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 30));

        lbl_dolar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_dolar.setForeground(new java.awt.Color(0, 0, 102));
        lbl_dolar.setText("5,780");
        jPanel3.add(lbl_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 60, 30));

        lbl_default_id.setText("lbl_default");
        jPanel3.add(lbl_default_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        lbl_cant_produ_pedido.setText("count");
        jPanel3.add(lbl_cant_produ_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 80, 20));

        lbl_sur_nombre.setText("alma");
        jPanel3.add(lbl_sur_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 30, 20));

        btn_calc_amortizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calc_amortizacionActionPerformed(evt);
            }
        });
        jPanel3.add(btn_calc_amortizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 50, 20));

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
        jPanel3.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 40, 20));

        btn_mone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moneActionPerformed(evt);
            }
        });
        jPanel3.add(btn_mone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 50, 20));

        lbl_literal_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_literal_pro.setText("Son:");
        jPanel3.add(lbl_literal_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 20, -1));

        lbl_literal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_literal.setText("gs");
        jPanel3.add(lbl_literal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 30, 20));

        javax.swing.GroupLayout panel_config_presupuestoLayout = new javax.swing.GroupLayout(panel_config_presupuesto);
        panel_config_presupuesto.setLayout(panel_config_presupuestoLayout);
        panel_config_presupuestoLayout.setHorizontalGroup(
            panel_config_presupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        panel_config_presupuestoLayout.setVerticalGroup(
            panel_config_presupuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(panel_config_presupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 260, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 350, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed
        
        if (chk_contado.isSelected()) {
            
            if ((txt_cli_nom.getText().equals("")) || (txttotal.getText().equals("0")) || txt_cod_cli.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {
                
                ticket();

                // caja();
                PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    //se elige la impresora
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                            "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {
                        try {
                            Connection cn = conectar.getInstance().getConnection();
                            
                            String cod = lbl_cod.getText();
                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("codigo", cod);
                            
                            URL in = this.getClass().getResource("/Pedidos/impresiones/Nota_pedidos.jasper");
                            
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
                            Logger.getLogger(Pedidos_pedidos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                
                lbl_cambio_dolar.setText("");
                lbl_cambio_real.setText("");
                txttotal.setText("");
                
                DefaultTableModel modelo = (DefaultTableModel) tb_pedidos.getModel();
                int a = tb_pedidos.getRowCount() - 1;
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
                txt_op_pedidos.setText("");
                txt_dias_plazo.setVisible(false);
                lbl_tipo_venta.setText("CONTADO");
                pn_tipo_venta.setBackground(Color.blue);
                
            }
        }
        
        if (chk_plazo.isSelected()) {
            
            if ((lbl_cod.getText().equals("")) || (txttotal.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
            } else {
                
                ticket_plazo();
                
                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ??desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                    if (printService.length > 0)//si existen impresoras
                    {
                        //se elige la impresora
                        PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                                "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                        if (impresora != null) //Si se selecciono una impresora
                        {
                            try {
                                Connection cn = conectar.getInstance().getConnection();
                                
                                String cod = lbl_cod.getText();
                                Map parametro = new HashMap();
                                parametro.clear();
                                parametro.put("codigo", cod);
                                
                                URL in = this.getClass().getResource("/Pedidos/impresiones/Nota_pedidos.jasper");
                                
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
                                Logger.getLogger(Pedidos_pedidos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                    }
                    
                }
                lbl_cambio_real.setText("");
                txttotal.setText("");
                
                DefaultTableModel modelo = (DefaultTableModel) tb_pedidos.getModel();
                int a = tb_pedidos.getRowCount() - 1;
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
                txt_op_pedidos.setText("");
                txt_dias_plazo.setText("");
                txt_dias_plazo.setVisible(false);
                lbl_tipo_venta.setText("CONTADO");
                pn_tipo_venta.setBackground(Color.blue);
                
            }
        }
        
        txt_cod_cli.requestFocus();
        Principal_Pedidos.btn_cargar_datos.doClick();
    }//GEN-LAST:event_btnvenActionPerformed

    private void txt_cli_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_nomActionPerformed

    private void txt_cod_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_cliKeyPressed
        char Tecla = evt.getKeyChar();
        
        if (Tecla == KeyEvent.VK_ENTER) {
            Proveedor_pedidos cv;
            cv = new Proveedor_pedidos(new javax.swing.JDialog(), true);
            cv.setVisible(true);
            
        }
        
        if (Tecla == KeyEvent.VK_ESCAPE) {
            if (JOptionPane.showConfirmDialog(null, "??Desea realmente salir ?",
                    "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.dispose();
                Pedidos.Principal_Pedidos.txt_bus.requestFocus();
                Pedidos.Principal_Pedidos.txt_bus.setText("");
            }
            
        }
    }//GEN-LAST:event_txt_cod_cliKeyPressed

    private void txt_cod_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_cliActionPerformed

    private void chk_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_plazoActionPerformed
        chk_contado.setSelected(false);
        TiposPagos();
        lbl_tipo_venta.setText("CR??DITO");
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

    private void txt_dias_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dias_plazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dias_plazoActionPerformed

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
            Almacen_select_pedidos as;
            as = new Almacen_select_pedidos(new javax.swing.JDialog(), true);
            as.setVisible(true);
        } else {
            String def = lbl_sur_nombre.getText();
            lbl_default_id.setText(def);
            Pedidos_pro rp;
            rp = new Pedidos_pro(new javax.swing.JDialog(), true);
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
        DefaultTableModel model = (DefaultTableModel) tb_pedidos.getModel();
        int fila = tb_pedidos.getSelectedRow();
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
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_proveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proveeActionPerformed
        /*        Proveedor_pedidos cv;
         cv = new Proveedor_pedidos(new javax.swing.JDialog(), true);
         cv.setVisible(true);*/
        Clientes_Pedidos cvp;
        cvp = new Clientes_Pedidos(new javax.swing.JDialog(), true);
        cvp.setVisible(true);
    }//GEN-LAST:event_btn_proveeActionPerformed

    private void btn_calc_amortizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calc_amortizacionActionPerformed
        
        calcularMoneda();
        literal();
    }//GEN-LAST:event_btn_calc_amortizacionActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        
        if (JOptionPane.showConfirmDialog(null, "??Desea realmente salir?",
                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //  new Thread(new hilo()).interrupt();
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

    private void lbl_fecha_VISORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_fecha_VISORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_fecha_VISORActionPerformed

    private void btn_buscar_presupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_presupuestoActionPerformed
        
        try {
            Buscar_pres_by_pedido bp;
            bp = new Buscar_pres_by_pedido(new javax.swing.JDialog(), true);
            bp.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Pedidos_pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_buscar_presupuestoActionPerformed

    private void btn_buscar_presupuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_buscar_presupuestoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscar_presupuestoKeyPressed

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
            java.util.logging.Logger.getLogger(Pedidos_pedidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pedidos_pedidos dialog = null;
                    
                    dialog = new Pedidos_pedidos(new javax.swing.JDialog(), true);
                    
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            if (JOptionPane.showConfirmDialog(null, "??Desea realmente salir del sistema?",
                                    "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                System.exit(0);
                            }
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Pedidos_pedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_buscaar_items;
    public static javax.swing.JButton btn_buscar_presupuesto;
    public static javax.swing.JButton btn_calc_amortizacion;
    private javax.swing.JButton btn_excluir;
    public static javax.swing.JButton btn_mone;
    private javax.swing.JButton btn_provee;
    private javax.swing.JButton btn_salir;
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton btnven;
    private javax.swing.JCheckBox chk_contado;
    private javax.swing.JCheckBox chk_plazo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    public static javax.swing.JLabel lbl_cant_produ_pedido;
    public static javax.swing.JLabel lbl_cod;
    public static javax.swing.JLabel lbl_default_id;
    private javax.swing.JLabel lbl_dolar;
    private javax.swing.JTextField lbl_fecha_VISOR;
    private javax.swing.JLabel lbl_literal;
    private javax.swing.JLabel lbl_literal_pro;
    private javax.swing.JLabel lbl_plazos_dias;
    private javax.swing.JLabel lbl_plazos_dias1;
    private javax.swing.JLabel lbl_r;
    private javax.swing.JLabel lbl_sur_nombre;
    private javax.swing.JLabel lbl_tipo_venta;
    public static javax.swing.JLabel lblcanpro;
    private javax.swing.JPanel panel_config_presupuesto;
    private javax.swing.JPanel pn_tipo_venta;
    public static javax.swing.JTable tb_pedidos;
    public static javax.swing.JTextField txt_cli_nom;
    public static javax.swing.JTextField txt_cod_cli;
    public static javax.swing.JTextField txt_dias_plazo;
    private javax.swing.JTextField txt_op_pedidos;
    private javax.swing.JTextField txt_usu_ventas;
    public static javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables

    public void calcular() {
        
        String imp = "0", subtotal = "0", iva = "0", total = "0";
        
        for (int i = 0; i < tb_pedidos.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_pedidos.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_pedidos.getValueAt(i, 3).toString().replaceAll("\\s", ""));
            
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            
            tb_pedidos.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 5);
            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());
            
            txttotal.setText(total);
            
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
        String InsertarSQL = "INSERT INTO pedidos (num_pedi,cod_provee,nom_provee,forma_pag_pedi,dias_plazo_pedi,total_pedi,total_real,total_dolar,estado_pedi,fecha_pedi,user_pedi,almacen_pedi,cant_pedi,letras_pedi,vac_ventas) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_contado.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("En Espera");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_default_id.getText();
        String literal = lbl_literal.getText();
        String valor_amort = txt_op_pedidos.getText();
        
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
            pst.setString(15, valor_amort);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);
            
            if (n > 0) {
                detalle_ticket();
                JOptionPane.showMessageDialog(null, "Nota realizada con ??xito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos_pedidos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void ticket_plazo() {
        codigos();
        String InsertarSQL = "INSERT INTO pedidos (num_pedi,cod_provee,nom_provee,forma_pag_pedi,dias_plazo_pedi,total_pedi,total_real,total_dolar,estado_pedi,fecha_pedi,user_pedi,almacen_pedi,cant_pedi,letras_pedi,vac_ventas) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String formapag = chk_plazo.getText();
        String dias_pla = txt_dias_plazo.getText();
        String total_ventas = txttotal.getText();
        String total_real = lbl_cambio_real.getText();
        String total_dolar = lbl_cambio_dolar.getText();
        String estado = ("En Espera");
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String cantidad = lblcanpro.getText();//cambiar en db
        String almacen = lbl_default_id.getText();
        String literal = lbl_literal.getText();
        String valor_amort = txt_op_pedidos.getText();
        
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
            pst.setString(15, valor_amort);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);
            
            if (n > 0) {
                detalle_ticket();
                JOptionPane.showMessageDialog(null, "Nota realizada con ??xito");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos_pedidos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void detalle_ticket() {
        for (int i = 0; i < tb_pedidos.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO pedidos_detalles (num_pedi,cod_pro,des_pro,cant_pro,pre_unit,cant_kg,pre_venta,data) VALUES (?,?,?,?,?,?,?,?)";
            String numbol = lbl_cod.getText();
            String codpro = tb_pedidos.getValueAt(i, 0).toString();
            String despro = tb_pedidos.getValueAt(i, 1).toString();
            String cantpro = tb_pedidos.getValueAt(i, 3).toString();
            String cantkg = tb_pedidos.getValueAt(i, 4).toString();
            String preunit = tb_pedidos.getValueAt(i, 2).toString();
            String importe = tb_pedidos.getValueAt(i, 5).toString();
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
                
            } catch (SQLException ex) {
                Logger.getLogger(Pedidos_pedidos.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    void codigos() {
        
        String c = "";
        String SQL = "select max(num_pedi) from pedidos";
        
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
            Logger.getLogger(Pedidos_pedidos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void server() {
        
        String c = "";
        String SQL = "select now()";
        
        try {
            Connection cn = conectar.getInstance().getConnection();
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                //  c = rs.getString(1);
                lbl_fecha_VISOR.setText(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(1)));
            }
            
            conectar.getInstance().closeConnection(cn);
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos_pedidos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void calcularCantidadPro() {
        
        int Acumulador = 0;
        int TF = tb_pedidos.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Pedidos_pedidos.tb_pedidos.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));
        
    }
    
    public void calcularSubtotal() {
        
        int Acumulador = 0;
        int TF = tb_pedidos.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(Pedidos_pedidos.tb_pedidos.getValueAt(i, 5).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
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
    
    class hilo implements Runnable {
        
        @Override
        public void run() {
            while (true) {
                JOptionPane.showMessageDialog(null, "TAREAS ACTUALIZADAS....");
                codigos();
                
                try {
                    Thread.sleep(120000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pedidos_pedidos.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        }
        
    }
    
    void control_proveedores() {
        
        String verificar = Principal_Pedidos.lbl_almacen_pedidos.getText();
        
        if (verificar.equals("TODOS") || verificar.equals("0000001")) {
            btn_provee.setEnabled(true);
        } else {
            btn_provee.setEnabled(false);
            txt_cod_cli.setEnabled(false);
            txt_cod_cli.setText("0000001");
            txt_cli_nom.setText("KYRIOS CENTRAL FABRICA");
        }
        
    }
    
    void contarFilas() {
        for (int i = 0; i < tb_pedidos.getRowCount(); i++) {
            lbl_cant_produ_pedido.setText(i + "");
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
