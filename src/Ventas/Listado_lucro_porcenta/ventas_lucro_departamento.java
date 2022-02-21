//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Ventas.Listado_lucro_porcenta;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Administrativo.*;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_surcu_lucro;
import Productos.items.Departamentos_List_Lucro;
import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;
//</editor-fold>

public class ventas_lucro_departamento extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;

    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public ventas_lucro_departamento(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
         if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_1.setBackground(new java.awt.Color(69, 84, 92));
            panel_3.setBackground(new java.awt.Color(69, 84, 92));
            panel_4.setBackground(new java.awt.Color(69, 84, 92));
            panel_5.setBackground(new java.awt.Color(69, 84, 92));
            panel_6.setBackground(new java.awt.Color(69, 84, 92));
            panel_2.setBackground(new java.awt.Color(69, 84, 92));
            
            

        }
        
      //  lbl_almacen_pedidos.setText(Principal.lbl_usu_almacen.getText());
        txt_lucro_ventas.setDisabledTextColor(Color.black);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tb_calculos = new javax.swing.JTabbedPane();
        panel_1 = new javax.swing.JPanel();
        txt_nom_cli_lucro = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_nom_usu_lucro = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jd_ini_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        jLabel18 = new javax.swing.JLabel();
        jd_fin_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        txt_id_cli_lucro = new javax.swing.JTextField();
        txt_id_usu_lucro = new javax.swing.JTextField();
        btn_cliente = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btn_usu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_id_dep_salidas = new javax.swing.JTextField();
        txt_nom_dep_salidas = new javax.swing.JTextField();
        btn_list_depa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel_2 = new javax.swing.JPanel();
        txt_lucro_ventas = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_lucro_total_por = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas_1 = new javax.swing.JTable();
        txt_total_items_1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_valor_ventas_1 = new javax.swing.JTextField();
        lbl_almacen_pedidos = new javax.swing.JLabel();
        panel_3 = new javax.swing.JPanel();
        txt_lucro_ventas_2 = new javax.swing.JTextField();
        txt_lucro_total_por_2 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_ventas_2 = new javax.swing.JTable();
        txt_total_items_2 = new javax.swing.JTextField();
        txt_valor_ventas_2 = new javax.swing.JTextField();
        lbl_almacen_pedidos1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        panel_4 = new javax.swing.JPanel();
        txt_lucro_ventas_3 = new javax.swing.JTextField();
        txt_lucro_total_por_3 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tb_ventas_3 = new javax.swing.JTable();
        txt_total_items_3 = new javax.swing.JTextField();
        txt_valor_ventas_3 = new javax.swing.JTextField();
        lbl_almacen_pedidos2 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        panel_5 = new javax.swing.JPanel();
        lbl_almacen_pedidos3 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tb_ventas_4 = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txt_lucro_total_por_4 = new javax.swing.JTextField();
        txt_lucro_ventas_4 = new javax.swing.JTextField();
        txt_valor_ventas_4 = new javax.swing.JTextField();
        txt_total_items_4 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        panel_6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        txt_lucro_por_monto = new javax.swing.JTextField();
        txt_lucro_gral_por = new javax.swing.JTextField();
        txt_total_items_geral = new javax.swing.JTextField();
        txt_valor_total_gral = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_calculos.setBackground(new java.awt.Color(255, 255, 255));
        tb_calculos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tb_calculos.setOpaque(true);

        panel_1.setBackground(new java.awt.Color(255, 255, 255));
        panel_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nom_cli_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cli_lucro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_cli_lucro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_lucro.setEnabled(false);
        panel_1.add(txt_nom_cli_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 370, 30));

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setText("Usuario/Vend.:");
        panel_1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 110, 30));

        txt_nom_usu_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_usu_lucro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_usu_lucro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_usu_lucro.setEnabled(false);
        panel_1.add(txt_nom_usu_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 370, 30));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setText("Cliente:");
        panel_1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 100, 30));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setText("Fecha Inicio:");
        panel_1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 90, 30));
        panel_1.add(jd_ini_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 140, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Fecha Final:");
        panel_1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 90, 30));
        panel_1.add(jd_fin_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 140, 30));

        txt_id_cli_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_cli_lucro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_cli_lucro.setText("0");
        txt_id_cli_lucro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cli_lucro.setEnabled(false);
        txt_id_cli_lucro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_id_cli_lucroMouseClicked(evt);
            }
        });
        panel_1.add(txt_id_cli_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 80, 30));

        txt_id_usu_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_usu_lucro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_usu_lucro.setText("0");
        txt_id_usu_lucro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_usu_lucro.setEnabled(false);
        panel_1.add(txt_id_usu_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 80, 30));

        btn_cliente.setBackground(new java.awt.Color(255, 255, 255));
        btn_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clienteActionPerformed(evt);
            }
        });
        panel_1.add(btn_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 60, 30));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        panel_1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, 80, 40));

        btn_usu.setBackground(new java.awt.Color(255, 255, 255));
        btn_usu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_usu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuActionPerformed(evt);
            }
        });
        panel_1.add(btn_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 60, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Departamento:");
        panel_1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 110, 30));

        txt_id_dep_salidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_dep_salidas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_dep_salidas.setText("0");
        txt_id_dep_salidas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_dep_salidas.setEnabled(false);
        txt_id_dep_salidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_id_dep_salidasMouseClicked(evt);
            }
        });
        panel_1.add(txt_id_dep_salidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 80, 30));

        txt_nom_dep_salidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_dep_salidas.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_dep_salidas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_dep_salidas.setEnabled(false);
        panel_1.add(txt_nom_dep_salidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 370, 30));

        btn_list_depa.setBackground(new java.awt.Color(255, 255, 255));
        btn_list_depa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_list_depa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_list_depa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_list_depaActionPerformed(evt);
            }
        });
        panel_1.add(btn_list_depa, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 60, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/barriendo.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 80, 40));

        tb_calculos.addTab("Parametros", panel_1);

        panel_2.setBackground(new java.awt.Color(255, 255, 255));
        panel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_lucro_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_lucro_ventas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_ventas.setText("0");
        txt_lucro_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_ventas.setEnabled(false);
        panel_2.add(txt_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 510, 190, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Lucro %:");
        panel_2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 90, 30));

        txt_lucro_total_por.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_lucro_total_por.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_total_por.setText("0");
        txt_lucro_total_por.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_lucro_total_por.setEnabled(false);
        panel_2.add(txt_lucro_total_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 540, 190, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Lucro #:");
        panel_2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 510, 80, 30));

        tb_ventas_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_ventas_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_ventas_1);

        panel_2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1280, 450));

        txt_total_items_1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_items_1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_items_1.setText("0");
        txt_total_items_1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_items_1.setEnabled(false);
        panel_2.add(txt_total_items_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 170, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setText("Total ventas:");
        panel_2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 110, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("Total items:");
        panel_2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 110, 30));

        txt_valor_ventas_1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_ventas_1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_ventas_1.setText("0");
        txt_valor_ventas_1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_ventas_1.setEnabled(false);
        panel_2.add(txt_valor_ventas_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 170, 30));

        lbl_almacen_pedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos.setText("0000001");
        lbl_almacen_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_2.add(lbl_almacen_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        tb_calculos.addTab("Principal", panel_2);

        panel_3.setBackground(new java.awt.Color(255, 255, 255));
        panel_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_lucro_ventas_2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_lucro_ventas_2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_ventas_2.setText("0");
        txt_lucro_ventas_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_ventas_2.setEnabled(false);
        panel_3.add(txt_lucro_ventas_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 510, 190, 30));

        txt_lucro_total_por_2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_lucro_total_por_2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_total_por_2.setText("0");
        txt_lucro_total_por_2.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_lucro_total_por_2.setEnabled(false);
        panel_3.add(txt_lucro_total_por_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 540, 190, 30));

        tb_ventas_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_ventas_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tb_ventas_2);

        panel_3.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1280, 450));

        txt_total_items_2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_items_2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_items_2.setText("0");
        txt_total_items_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_items_2.setEnabled(false);
        panel_3.add(txt_total_items_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 170, 30));

        txt_valor_ventas_2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_ventas_2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_ventas_2.setText("0");
        txt_valor_ventas_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_ventas_2.setEnabled(false);
        panel_3.add(txt_valor_ventas_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 170, 30));

        lbl_almacen_pedidos1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_pedidos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos1.setText("0000002");
        lbl_almacen_pedidos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_3.add(lbl_almacen_pedidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("Total ventas:");
        panel_3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 110, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setText("Total items:");
        panel_3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 110, 30));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("Lucro %:");
        panel_3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 90, 30));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setText("Lucro #:");
        panel_3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 510, 80, 30));

        tb_calculos.addTab("Sucursal 2", panel_3);

        panel_4.setBackground(new java.awt.Color(255, 255, 255));
        panel_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_lucro_ventas_3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_lucro_ventas_3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_ventas_3.setText("0");
        txt_lucro_ventas_3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_ventas_3.setEnabled(false);
        panel_4.add(txt_lucro_ventas_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 510, 190, 30));

        txt_lucro_total_por_3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_lucro_total_por_3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_total_por_3.setText("0");
        txt_lucro_total_por_3.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_lucro_total_por_3.setEnabled(false);
        panel_4.add(txt_lucro_total_por_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 540, 190, 30));

        tb_ventas_3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_ventas_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(tb_ventas_3);

        panel_4.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1280, 450));

        txt_total_items_3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_items_3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_items_3.setText("0");
        txt_total_items_3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_items_3.setEnabled(false);
        panel_4.add(txt_total_items_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 170, 30));

        txt_valor_ventas_3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_ventas_3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_ventas_3.setText("0");
        txt_valor_ventas_3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_ventas_3.setEnabled(false);
        panel_4.add(txt_valor_ventas_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 170, 30));

        lbl_almacen_pedidos2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_pedidos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos2.setText("0000003");
        lbl_almacen_pedidos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_4.add(lbl_almacen_pedidos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setText("Total ventas:");
        panel_4.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 110, 30));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setText("Total items:");
        panel_4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 110, 30));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setText("Lucro %:");
        panel_4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 90, 30));

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setText("Lucro #:");
        panel_4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 510, 80, 30));

        tb_calculos.addTab("Sucursal 3", panel_4);

        panel_5.setBackground(new java.awt.Color(255, 255, 255));
        panel_5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_almacen_pedidos3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_pedidos3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos3.setText("0000004");
        lbl_almacen_pedidos3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_5.add(lbl_almacen_pedidos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        tb_ventas_4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_ventas_4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane13.setViewportView(tb_ventas_4);

        panel_5.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1280, 450));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel46.setText("Lucro #:");
        panel_5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 510, 80, 30));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setText("Lucro %:");
        panel_5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 90, 30));

        txt_lucro_total_por_4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_lucro_total_por_4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_total_por_4.setText("0");
        txt_lucro_total_por_4.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_lucro_total_por_4.setEnabled(false);
        panel_5.add(txt_lucro_total_por_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 540, 190, 30));

        txt_lucro_ventas_4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_lucro_ventas_4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_ventas_4.setText("0");
        txt_lucro_ventas_4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_ventas_4.setEnabled(false);
        panel_5.add(txt_lucro_ventas_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 510, 190, 30));

        txt_valor_ventas_4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_ventas_4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_ventas_4.setText("0");
        txt_valor_ventas_4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_ventas_4.setEnabled(false);
        panel_5.add(txt_valor_ventas_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 170, 30));

        txt_total_items_4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_items_4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_items_4.setText("0");
        txt_total_items_4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_items_4.setEnabled(false);
        panel_5.add(txt_total_items_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 170, 30));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setText("Total items:");
        panel_5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 110, 30));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setText("Total ventas:");
        panel_5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 110, 30));

        tb_calculos.addTab("Sucursal 4", panel_5);

        panel_6.setBackground(new java.awt.Color(255, 255, 255));
        panel_6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panel_6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 100, 40));

        txt_lucro_por_monto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_lucro_por_monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_por_monto.setText("0");
        txt_lucro_por_monto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_por_monto.setEnabled(false);
        panel_6.add(txt_lucro_por_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 190, 30));

        txt_lucro_gral_por.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_lucro_gral_por.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_gral_por.setText("0");
        txt_lucro_gral_por.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_lucro_gral_por.setEnabled(false);
        panel_6.add(txt_lucro_gral_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 190, 30));

        txt_total_items_geral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_items_geral.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_items_geral.setText("0");
        txt_total_items_geral.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_items_geral.setEnabled(false);
        panel_6.add(txt_total_items_geral, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 170, 30));

        txt_valor_total_gral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_total_gral.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_total_gral.setText("0");
        txt_valor_total_gral.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_total_gral.setEnabled(false);
        panel_6.add(txt_valor_total_gral, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 170, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setText("Total ventas Gral:");
        panel_6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 130, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setText("Total items Gral:");
        panel_6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 130, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Lucro %Gral:");
        panel_6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 100, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setText("Lucro # Gral:");
        panel_6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 90, 30));

        tb_calculos.addTab("Resumen General", panel_6);

        jPanel1.add(tb_calculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 620));
        tb_calculos.getAccessibleContext().setAccessibleName("Principal");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
        String id_cli = txt_id_cli_lucro.getText();
        String id_usu = txt_id_usu_lucro.getText();
        String id_dep = txt_id_dep_salidas.getText();
        String var = "0";
//todos
        if (id_cli.equals(var) && id_usu.equals(var) && id_dep.equals(var)) {
            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA'  ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  ORDER BY d.data ASC";
            limpiar_calculo();
            cargar2(sql2);
            cargar3(sql3);
            cargar4(sql4);
            cargar(sql);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
/////////////////////////
            sumar_ventas_1();
            sumar_stock_1();
            sumar_ventas_2();
            sumar_stock_2();
            sumar_ventas_3();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();
            ////////////////////////
            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();
//solo cliente
        } else if (!id_cli.equals(var) && id_usu.equals(var) && id_dep.equals(var)) {
            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA' AND v.cod_cli_ventas='" + id_cli + "'  ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' AND v.cod_cli_ventas='" + id_cli + "'  ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' AND v.cod_cli_ventas='" + id_cli + "'  ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' AND v.cod_cli_ventas='" + id_cli + "'  ORDER BY d.data ASC";
            limpiar_calculo();
            cargar_cliente(sql);
            cargar2_cliente(sql2);
            cargar3_cliente(sql3);
            cargar4(sql4);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
            /////////////
            sumar_ventas_1();
            sumar_ventas_2();
            sumar_ventas_3();
            sumar_stock_1();
            sumar_stock_2();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();

            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();
//cliente y usuario
        } else if (!id_cli.equals(var) && !id_usu.equals(var) && id_dep.equals(var)) {
            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND v.cod_cli_ventas='" + id_cli + "'  ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' AND v.vac_ventas='" + id_usu + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            limpiar_calculo();
            cargar_user(sql);
            cargar2_user(sql2);
            cargar3_user(sql3);
            cargar4(sql4);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
            /////////////
            sumar_ventas_1();
            sumar_ventas_2();
            sumar_ventas_3();
            sumar_stock_1();
            sumar_stock_2();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();

            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();
            // clientes, usuarios y departamento
        } else if (!id_cli.equals(var) && !id_usu.equals(var) && !id_dep.equals(var)) {
            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            limpiar_calculo();
            cargar_user(sql);
            cargar2_user(sql2);
            cargar3_user(sql3);
            cargar4(sql4);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
            /////////////
            sumar_ventas_1();
            sumar_ventas_2();
            sumar_ventas_3();
            sumar_stock_1();
            sumar_stock_2();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();

            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();
        } ////solo usuario
        else if (id_cli.equals(var) && !id_usu.equals(var) && id_dep.equals(var)) {

            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' AND v.vac_ventas='" + id_usu + "' ORDER BY d.data ASC";
            limpiar_calculo();
            cargar_user(sql);
            cargar2_user(sql2);
            cargar3_user(sql3);
            cargar4(sql4);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
            /////////////
            sumar_ventas_1();
            sumar_ventas_2();
            sumar_ventas_3();
            sumar_stock_1();
            sumar_stock_2();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();

            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();
            //usuario y departamento
        } else if (id_cli.equals(var) && !id_usu.equals(var) && !id_dep.equals(var)) {
            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "'  ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "'   ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "'   ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND v.vac_ventas='" + id_usu + "' AND dp.cod_dep='" + id_dep + "'  ORDER BY d.data ASC";
            limpiar_calculo();
            cargar_user(sql);
            cargar2_user(sql2);
            cargar3_user(sql3);
            cargar4(sql4);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
            /////////////
            sumar_ventas_1();
            sumar_ventas_2();
            sumar_ventas_3();
            sumar_stock_1();
            sumar_stock_2();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();

            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();
//solo departamento
        } else if (id_cli.equals(var) && id_usu.equals(var) && !id_dep.equals(var)) {
            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA'   AND dp.cod_dep='" + id_dep + "'  ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'   AND dp.cod_dep='" + id_dep + "'  ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'   AND dp.cod_dep='" + id_dep + "'  ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'   AND dp.cod_dep='" + id_dep + "' ORDER BY d.data ASC";
            limpiar_calculo();
            cargar_user(sql);
            cargar2_user(sql2);
            cargar3_user(sql3);
            cargar4(sql4);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
            /////////////
            sumar_ventas_1();
            sumar_ventas_2();
            sumar_ventas_3();
            sumar_stock_1();
            sumar_stock_2();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();

            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();

            //cliente y departamento
        } else if (!id_cli.equals(var) && id_usu.equals(var) && !id_dep.equals(var)) {
            String sql = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA'   AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql2 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'   AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql3 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'   AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            String sql4 = " SELECT d.num_bol , d.data , d.cod_pro ,d.des_pro,d.cant_pro, d.pre_venta,dp.por_dos,dp.por_uno FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN depar_productos AS dp  ON dp.cod_dep =p.pro_depa INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol  WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA'  AND dp.cod_dep='" + id_dep + "' AND v.cod_cli_ventas='" + id_cli + "' ORDER BY d.data ASC";
            limpiar_calculo();
            cargar_user(sql);
            cargar2_user(sql2);
            cargar3_user(sql3);
            cargar4(sql4);
            calcular_tabla();
            calcular_tabla_por();
            calcular_tabla2();
            calcular_tabla2_por();
            calcular_tabla3();
            calcular_tabla3_por();
            calcular_tabla4();
            calcular_tabla4_por();
            /////////////
            sumar_ventas_1();
            sumar_ventas_2();
            sumar_ventas_3();
            sumar_stock_1();
            sumar_stock_2();
            sumar_stock_3();
            sumar_ventas_4();
            sumar_stock_4();

            TotalVentas();
            TotalItems();
            TotalLucroCantidad();
            TotalLucroPor();
        }


    }//GEN-LAST:event_jButton10ActionPerformed

    private void btn_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuActionPerformed
        user_lucro ul;
        ul = new user_lucro(new javax.swing.JDialog(), true);
        ul.setVisible(true);
    }//GEN-LAST:event_btn_usuActionPerformed

    private void btn_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clienteActionPerformed
        Clientes_Lucro cl;
        cl = new Clientes_Lucro(new javax.swing.JDialog(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_btn_clienteActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_id_dep_salidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_id_dep_salidasMouseClicked
        txt_id_dep_salidas.setText("0");
        txt_nom_dep_salidas.setText("");

    }//GEN-LAST:event_txt_id_dep_salidasMouseClicked

    private void btn_list_depaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_list_depaActionPerformed

        Departamentos_List_Lucro dlm;
        dlm = new Departamentos_List_Lucro(new javax.swing.JDialog(), true);
        dlm.setVisible(true);
    }//GEN-LAST:event_btn_list_depaActionPerformed

    private void txt_id_cli_lucroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_id_cli_lucroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_cli_lucroMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed
    //<editor-fold defaultstate="collapsed" desc="METODOS PRINCIPAL">

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
            java.util.logging.Logger.getLogger(ventas_lucro_departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ventas_lucro_departamento dialog = new ventas_lucro_departamento(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }// FIN METODO PRINCIPAL
    //</editor-fold>   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cliente;
    private javax.swing.JButton btn_list_depa;
    private javax.swing.JButton btn_usu;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane8;
    public static org.jdesktop.swingx.JXDatePicker jd_fin_lucro_ventas;
    public static org.jdesktop.swingx.JXDatePicker jd_ini_lucro_ventas;
    private javax.swing.JLabel lbl_almacen_pedidos;
    public static javax.swing.JLabel lbl_almacen_pedidos1;
    public static javax.swing.JLabel lbl_almacen_pedidos2;
    public static javax.swing.JLabel lbl_almacen_pedidos3;
    private javax.swing.JPanel panel_1;
    private javax.swing.JPanel panel_2;
    private javax.swing.JPanel panel_3;
    private javax.swing.JPanel panel_4;
    private javax.swing.JPanel panel_5;
    private javax.swing.JPanel panel_6;
    private javax.swing.JTabbedPane tb_calculos;
    public static javax.swing.JTable tb_ventas_1;
    public static javax.swing.JTable tb_ventas_2;
    public static javax.swing.JTable tb_ventas_3;
    public static javax.swing.JTable tb_ventas_4;
    public static javax.swing.JTextField txt_id_cli_lucro;
    public static javax.swing.JTextField txt_id_dep_salidas;
    public static javax.swing.JTextField txt_id_usu_lucro;
    public static javax.swing.JTextField txt_lucro_gral_por;
    public static javax.swing.JTextField txt_lucro_por_monto;
    public static javax.swing.JTextField txt_lucro_total_por;
    public static javax.swing.JTextField txt_lucro_total_por_2;
    public static javax.swing.JTextField txt_lucro_total_por_3;
    public static javax.swing.JTextField txt_lucro_total_por_4;
    public static javax.swing.JTextField txt_lucro_ventas;
    public static javax.swing.JTextField txt_lucro_ventas_2;
    public static javax.swing.JTextField txt_lucro_ventas_3;
    public static javax.swing.JTextField txt_lucro_ventas_4;
    public static javax.swing.JTextField txt_nom_cli_lucro;
    public static javax.swing.JTextField txt_nom_dep_salidas;
    public static javax.swing.JTextField txt_nom_usu_lucro;
    public static javax.swing.JTextField txt_total_items_1;
    public static javax.swing.JTextField txt_total_items_2;
    public static javax.swing.JTextField txt_total_items_3;
    public static javax.swing.JTextField txt_total_items_4;
    public static javax.swing.JTextField txt_total_items_geral;
    public static javax.swing.JTextField txt_valor_total_gral;
    public static javax.swing.JTextField txt_valor_ventas_1;
    public static javax.swing.JTextField txt_valor_ventas_2;
    public static javax.swing.JTextField txt_valor_ventas_3;
    public static javax.swing.JTextField txt_valor_ventas_4;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    ///////////////////////cargar datos///////////////////////////////////
    void cargar(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_1.setModel(model);

            tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(80);
            tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////2
    void cargar2(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_2.setModel(model);

            tb_ventas_2.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas_2.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_2.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_ventas_2.getColumnModel().getColumn(3).setPreferredWidth(80);
            tb_ventas_2.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_ventas_2.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //3
    void cargar3(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_3.setModel(model);

            tb_ventas_3.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas_3.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_3.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_ventas_3.getColumnModel().getColumn(3).setPreferredWidth(80);
            tb_ventas_3.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_ventas_3.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar4(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_4.setModel(model);

            tb_ventas_4.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas_4.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_4.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_ventas_4.getColumnModel().getColumn(3).setPreferredWidth(80);
            tb_ventas_4.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_ventas_4.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_4.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_4.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_ventas_4.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_ventas_4.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////////////////////solo clientes////////////////////////////////////////
    void cargar_cliente(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_1.setModel(model);

            tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////2
    void cargar2_cliente(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_2.setModel(model);

            tb_ventas_2.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_2.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_2.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_2.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_2.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_2.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //3
    void cargar3_cliente(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_3.setModel(model);

            tb_ventas_3.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_3.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_3.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_3.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_3.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_3.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////////////////////////solo usuario/////////////////////////////////////////
    void cargar_user(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_1.setModel(model);

            tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////2
    void cargar2_user(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_2.setModel(model);

            tb_ventas_2.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_2.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_2.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_2.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_2.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_2.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_2.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //3
    void cargar3_user(String sql) {

        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Venta", "Valor Lucro", "Lucro Equival.", "Valor Lucro %", "Lucro % Equival."};
        String[] Registros = new String[10];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("data");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("cod_pro");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");
                Registros[6] = rs.getString("por_uno");
                Registros[8] = rs.getString("por_dos");

                model.addRow(Registros);
            }
            tb_ventas_3.setModel(model);

            tb_ventas_3.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_3.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_3.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_3.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_3.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_3.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_3.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //**********************************limite de almacen ******************************************
    /*
     void cargar4(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///5
     void cargar5(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_5 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_5 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///6
     void cargar6(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_6 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_6 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///7
     void cargar7(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_7 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_7 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///8
     void cargar8(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_8 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_8 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///9
     void cargar9(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_9 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_9 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///10
     void cargar10(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_10 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_10 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///11
     void cargar11(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_11 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_11 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///12
     void cargar12(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_12 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_12 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///13
     void cargar13(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_13 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_13 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///14
     void cargar14(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///15
     void cargar15(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_15 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_15 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///16
     void cargar16(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_16 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_16 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///17
     void cargar17(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_17 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_17 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///18
     void cargar18(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_18 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_18 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///19
     void cargar19(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_19 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_19 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///20
     void cargar20(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_20 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_20 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///21
     void cargar21(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_21 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_21 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///22
     void cargar22(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_22 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_22 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///23
     void cargar23(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_23 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_23 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///24
     void cargar24(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_24 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_24 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///25
     void cargar25(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_25 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_25 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///26
     void cargar26(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_26 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_26 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///27
     void cargar27(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_27 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_27 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///28
     void cargar28(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_28 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_28 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///29
     void cargar29(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_29 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_29 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     ///30
     void cargar30(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_30 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_30 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
     String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);
     // System.out.println(mostrar);
     try {
     Connection cn = conectar.getInstance().getConnection();

     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("num_bol");
     Registros[1] = rs.getString("data");
     Registros[2] = rs.getString("des_pro");
     Registros[3] = rs.getString("cod_pro");
     Registros[4] = rs.getString("cant_pro");
     Registros[5] = rs.getString("pro_pre_b");
     Registros[6] = rs.getString("pre_unit");
     Registros[8] = rs.getString("pre_venta");

     model.addRow(Registros);
     }
     tb_ventas_1.setModel(model);

     tb_ventas_1.getColumnModel().getColumn(0).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(1).setPreferredWidth(80);
     tb_ventas_1.getColumnModel().getColumn(2).setPreferredWidth(348);
     tb_ventas_1.getColumnModel().getColumn(3).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(4).setPreferredWidth(72);
     tb_ventas_1.getColumnModel().getColumn(5).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(6).setPreferredWidth(100);
     tb_ventas_1.getColumnModel().getColumn(7).setPreferredWidth(100);
     conectar.getInstance().closeConnection(cn);

     } catch (SQLException ex) {
     Logger.getLogger(ventas_lucro_departamento.class.getName()).log(Level.SEVERE, null, ex);
     }

     }*/
    void inicio() {

        txt_valor_ventas_1.setText("0");
        txt_total_items_1.setText("0");
        txt_lucro_ventas.setText("0");
        txt_lucro_total_por.setText("0");

    }

    //////////////////////sucursal 1/////////////////////////////////////////
    public void sumar_ventas_1() {

        String impcad = "0", subtotalcad = "0", totalcad = "0";

        for (int i = 0; i < tb_ventas_1.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            impcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcad).add(ingreso.TransformReales(impcad)).toString());

            txt_valor_ventas_1.setText(subtotalcad);

        }
    }

    public void sumar_stock_1() {

        String impcae = "0", subtotalcae = "0", totalcae = "0";

        for (int i = 0; i < tb_ventas_1.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            impcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcae).add(ingreso.TransformReales(impcae)).toString());

            txt_total_items_1.setText(subtotalcae);

        }
    }

    //////////////////////sucursal 2/////////////////////////////////////////
    public void sumar_ventas_2() {

        String impcad = "0", subtotalcad = "0", totalcad = "0";

        for (int i = 0; i < tb_ventas_2.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_2.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            impcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcad).add(ingreso.TransformReales(impcad)).toString());

            txt_valor_ventas_2.setText(subtotalcad);

        }
    }

    public void sumar_stock_2() {

        String impcae = "0", subtotalcae = "0", totalcae = "0";

        for (int i = 0; i < tb_ventas_2.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_2.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            impcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcae).add(ingreso.TransformReales(impcae)).toString());

            txt_total_items_2.setText(subtotalcae);

        }
    }

    //////////////////////sucursal 3/////////////////////////////////////////
    public void sumar_ventas_3() {

        String impcad = "0", subtotalcad = "0", totalcad = "0";

        for (int i = 0; i < tb_ventas_3.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_3.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            impcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcad).add(ingreso.TransformReales(impcad)).toString());

            txt_valor_ventas_3.setText(subtotalcad);

        }
    }

    public void sumar_stock_3() {

        String impcae = "0", subtotalcae = "0", totalcae = "0";

        for (int i = 0; i < tb_ventas_3.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_3.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            impcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcae).add(ingreso.TransformReales(impcae)).toString());

            txt_total_items_3.setText(subtotalcae);

        }
    }

    public void sumar_stock_4() {

        String impcae = "0", subtotalcae = "0", totalcae = "0";

        for (int i = 0; i < tb_ventas_4.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_4.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            impcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcae = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcae).add(ingreso.TransformReales(impcae)).toString());

            txt_total_items_4.setText(subtotalcae);

        }
    }

    public void sumar_ventas_4() {

        String impcad = "0", subtotalcad = "0", totalcad = "0";

        for (int i = 0; i < tb_ventas_4.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_4.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            impcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalcad = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalcad).add(ingreso.TransformReales(impcad)).toString());

            txt_valor_ventas_4.setText(subtotalcad);

        }
    }

    ////////calculo % sucursales///////////////////////
    public void calcularVentasCompras() {

        String imp = "0", subtotal = "0";

        for (int i = 0; i < tb_ventas_1.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_ventas_1.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);

        }
    }
///////////////////////////////////calcular all lucro///////////////////////

    public void TotalVentas() {

        String totalCuentaDa = "0";
        BigDecimal valor_1 = ingreso.TransformReales(txt_valor_ventas_1.getText());
        BigDecimal valor_2 = ingreso.TransformReales(txt_valor_ventas_2.getText());
        BigDecimal valor_3 = ingreso.TransformReales(txt_valor_ventas_3.getText());
        BigDecimal valor_4 = ingreso.TransformReales(txt_valor_ventas_4.getText());
        totalCuentaDa = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_1.add(valor_2).add(valor_3).add(valor_4).toString());
        txt_valor_total_gral.setText(totalCuentaDa);

    }

    public void TotalItems() {
        String net = "0";

        BigDecimal valor_1 = ingreso.TransformReales(txt_total_items_1.getText());
        BigDecimal valor_2 = ingreso.TransformReales(txt_total_items_2.getText());
        BigDecimal valor_3 = ingreso.TransformReales(txt_total_items_3.getText());
        BigDecimal valor_4 = ingreso.TransformReales(txt_total_items_4.getText());
        net = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_1.add(valor_2).add(valor_3).add(valor_4).toString());
        txt_total_items_geral.setText(net);

    }

    public void TotalLucroCantidad() {
        String total = "0";

        BigDecimal valor_1 = ingreso.TransformReales(txt_lucro_ventas.getText());
        BigDecimal valor_2 = ingreso.TransformReales(txt_lucro_ventas_2.getText());
        BigDecimal valor_3 = ingreso.TransformReales(txt_lucro_ventas_3.getText());
        BigDecimal valor_4 = ingreso.TransformReales(txt_lucro_ventas_4.getText());
        total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_1.add(valor_2).add(valor_3).add(valor_4).toString());
        txt_lucro_por_monto.setText(total);

    }

    public void TotalLucroPor() {
        String total = "0";

        BigDecimal valor_1 = ingreso.TransformReales(txt_lucro_total_por.getText());
        BigDecimal valor_2 = ingreso.TransformReales(txt_lucro_total_por_2.getText());
        BigDecimal valor_3 = ingreso.TransformReales(txt_lucro_total_por_3.getText());
        BigDecimal valor_4 = ingreso.TransformReales(txt_lucro_total_por_4.getText());
        total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_1.add(valor_2).add(valor_3).add(valor_4).toString());
        txt_lucro_gral_por.setText(total);

    }

    ////////////calculo tabla uno
    public void calcular_tabla() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_1.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 6).toString().replaceAll("\\s", ""));
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).toString());
            tb_ventas_1.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_ventas.setText(subtotal);

        }
    }
    ////////////calculo tabla dos

    public void calcular_tabla2() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_2.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_2.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_2.getValueAt(i, 6).toString().replaceAll("\\s", ""));
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).toString());
            tb_ventas_2.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_ventas_2.setText(subtotal);
        }
    }
    ////////////calculo tabla tres

    public void calcular_tabla3() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_3.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_3.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_3.getValueAt(i, 6).toString().replaceAll("\\s", ""));
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).toString());
            tb_ventas_3.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_ventas_3.setText(subtotal);
        }
    }

    public void calcular_tabla4() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_4.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_4.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_4.getValueAt(i, 6).toString().replaceAll("\\s", ""));
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).toString());
            tb_ventas_4.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_ventas_4.setText(subtotal);
        }
    }

    /////////////////porcentaje tsbla
    ////////////calculo tabla uno
    public void calcular_tabla_por() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_1.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 5).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_1.getValueAt(i, 8).toString().replaceAll("\\s", ""));
            if (Principal.txt_simbolo.getText().equals("Gs")) {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP).toString());
            } else {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 2, RoundingMode.HALF_UP).toString());
            }
            tb_ventas_1.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 9);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_total_por.setText(subtotal);

        }
    }
    ////////////calculo tabla dos

    public void calcular_tabla2_por() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_2.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_2.getValueAt(i, 5).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_2.getValueAt(i, 8).toString().replaceAll("\\s", ""));
            if (Principal.txt_simbolo.getText().equals("Gs")) {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP).toString());
            } else {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 2, RoundingMode.HALF_UP).toString());
            }
            tb_ventas_2.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 9);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_total_por_2.setText(subtotal);
        }
    }
    ////////////calculo tabla tres

    public void calcular_tabla3_por() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_3.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_3.getValueAt(i, 5).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_3.getValueAt(i, 8).toString().replaceAll("\\s", ""));
            if (Principal.txt_simbolo.getText().equals("Gs")) {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP).toString());
            } else {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 2, RoundingMode.HALF_UP).toString());
            }
            tb_ventas_3.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 9);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_total_por_3.setText(subtotal);
        }
    }

    public void calcular_tabla4_por() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_ventas_4.getRowCount(); i++) {
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_4.getValueAt(i, 5).toString().replaceAll("\\s", ""));
            BigDecimal PulidoPor = ingreso.TransformReales(tb_ventas_4.getValueAt(i, 8).toString().replaceAll("\\s", ""));
            if (Principal.txt_simbolo.getText().equals("Gs")) {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP).toString());
            } else {
                imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoCant.multiply(PulidoPor).divide(ONE_HUNDRED, 2, RoundingMode.HALF_UP).toString());
            }
            tb_ventas_4.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 9);
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            txt_lucro_total_por_4.setText(subtotal);
        }
    }

    void limpiar() {

        txt_id_cli_lucro.setText("0");
        txt_id_usu_lucro.setText("0");
        txt_nom_cli_lucro.setText("");
        txt_nom_usu_lucro.setText("");
        txt_id_dep_salidas.setText("0");
        txt_nom_dep_salidas.setText("");

    }

    void limpiar_calculo() {
        txt_valor_ventas_1.setText("0");
        txt_total_items_1.setText("0");
        txt_lucro_ventas.setText("0");
        txt_lucro_total_por.setText("0");

        txt_valor_ventas_2.setText("0");
        txt_total_items_2.setText("0");
        txt_lucro_ventas_2.setText("0");
        txt_lucro_total_por_2.setText("0");

        txt_valor_ventas_3.setText("0");
        txt_total_items_3.setText("0");
        txt_lucro_ventas_3.setText("0");
        txt_lucro_total_por_3.setText("0");

    }
}
