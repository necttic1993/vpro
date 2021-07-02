package Loggin_Principal;

import Administrativo.Caja_Class_historicos;
import Administrativo.Cuentas_recibir.Cuentas_recibir;
import Administrativo.Cuentas_recibir.Cuentas_recibir_ventas;
import Administrativo.Devolucion_listado;
import Administrativo.Historico_Surcusales;
import Administrativo.Recibos.Principal_recibos;
import Administrativo.Ventas_report_all;
import Administrativo.bancos.Bancos;
import Administrativo.cambios;
import Administrativo.extracto_compras;
import Administrativo.mov_geral;
import Administrativo.mov_geral_espe;
import Administrativo.ventas_anteriores_tarjeta;
import Administrativo.ventas_anteriores_usuarios;
import Administrativo.ventas_lucro_total;
import Administrativo.ventas_lucro_users;
import Caja_2.Caja_caja;
import Caja_2.Pago_Plazos.Listado_bancos_recibos;
import Caja_2.Pago_Plazos.Principal_recibo_fisc;
import Caja_2.Transferencia_dinero.trans_dinero_caja;
import Clientes.Plataforma_clientes;
import Compras.Principal_compras;
import Conexion_DB.Ajuste_stock_manual;
import Conexion_DB.Copia;
import Conexion_DB.conectar;
import Conexion_DB.config_fiscal_surcu;
import Cuentas.Cuentas_Principal;
import Devoluciones.Fiscal_1.Principal_Devol_surc_fiscal;
import Devoluciones.Fiscal_2.Principal_Devol_surc_2;
import Devoluciones.Fiscal_24.Principal_Devol_surc_24;
import Devoluciones.Principal_devoluciones;
import Devoluciones.Surc_18.Principal_devoluciones_18;
import Devoluciones.Surc_24.Principal_devoluciones_24;
import Devoluciones.Surc_franco.Principal_devoluciones_franco;
import Estadisticas_productos.Listado_marcas_pro;
import Estadisticas_productos.Pro_con_stock;
import Estadisticas_productos.Productos_CP;
import Estadisticas_productos.Salidas_productos_cate;
import Estadisticas_productos.control_ventas_stock;
import Estadisticas_productos.stock_minimo;
import Gastos.Principapl_gastos;
import Listado_fiscales.Libro_nota_cre_lista;
import Listado_fiscales.Libro_nota_cre_lista_surc_2;
import Listado_fiscales.Libro_recibo_fisc;
import static Loggin_Principal.NECTTIC.cod;
import static Loggin_Principal.NECTTIC.mode;
import OS.Principapl_OS;
import Pedidos.Principal_Pedidos;
import Presupuesto.Principal_presupuesto;
import Presupuesto.Surc_franco.Principal_presupuesto_franco;
//import Presupuesto.Principal_presupuestos;
import Productos.Almaccen_Principal;
import Productos.Categorias_Espec_Principal;
import Productos.Categorias_Principal;
import Productos.Colores_Principal;
import Productos.Departamentos_Principal;
import Productos.Marcas_Principal;
import Productos.Productos;
import Productos.Sub_Categorias_Principal;
import Productos.Tama_Principal;
import Productos.barcod.pro_codbar;
import Productos.fabrica.Principal_fabrica;
import Productos.transferencias.Principal_transferencia;
import Proveedores.Plataforma_proveedor;
import Ventas.Exportacion.Principal_factura_expo;
import Ventas.Fact_surc_10.Principal_ventas_surc_10;
import Ventas.Fact_surc_11.Principal_ventas_surc_11;
import Ventas.Fact_surc_14.Principal_ventas_facturas_14;
import Ventas.Fact_surc_16.Principal_ventas_facturas_16;
import Ventas.Fact_surc_18.Principal_ventas_facturas_18;
import Ventas.Fact_surc_19.Principal_ventas_surc_19;
import Ventas.Fact_surc_2.Principal_ventas_surc_2;
import Ventas.Fact_surc_21.Principal_ventas_facturas_21;
import Ventas.Fact_surc_22.Principal_ventas_surc_22;
import Ventas.Fact_surc_23.Principal_ventas_facturas_23;
import Ventas.Fact_surc_24.Principal_ventas_facturas_24;
import Ventas.Fact_surc_26.Principal_ventas_facturas_26;
import Ventas.Fact_surc_27.Principal_ventas_facturas_27;
import Ventas.Fact_surc_3.Principal_ventas_surc_3;
import Ventas.Fact_surc_4.Principal_ventas_facturas_4;
import Ventas.Fact_surc_6.Principal_ventas_facturas_6;
import Ventas.Fact_surc_8.Principal_ventas_facturas_8;
import Ventas.Fact_surc_9.Principal_ventas_facturas_9;
import Ventas.Facturas.Principal_ventas_facturas;
import Ventas.Listado_lucro_porcenta.ventas_lucro_departamento;
import Ventas.Principal_ventas;
import Ventas.libro_ventas.Libro_ventas_lista;
import Ventas.libro_ventas.Libro_ventas_lista_surc_2;
import Ventas.libro_ventas.Libro_ventas_lista_surc_26;
import Ventas_10.Principal_ventas_10;
import Ventas_11.Principal_ventas_11;
import Ventas_12.Principal_ventas_12;
import Ventas_13.Principal_ventas_13;
import Ventas_14.Principal_ventas_14;
import Ventas_15.Principal_ventas_15;
import Ventas_17.Principal_ventas_17;
import Ventas_18.Principal_ventas_18;
import Ventas_19.Principal_ventas_19;
import Ventas_2.Principal_ventas_2;
import Ventas_20.Principal_ventas_20;
import Ventas_21.Principal_ventas_21;
import Ventas_22.Principal_ventas_22;
import Ventas_23.Principal_ventas_23;
import Ventas_24.Principal_ventas_24;
import Ventas_25.Principal_ventas_25;
import Ventas_26.Principal_ventas_26;
import Ventas_27.Principal_ventas_27;
import Ventas_28.Principal_ventas_28;
import Ventas_3.Principal_ventas_3;
import Ventas_4.Principal_ventas_4;
import Ventas_5.Principal_ventas_5;
import Ventas_6.Principal_ventas_6;
import Ventas_7.Principal_ventas_7;
import Ventas_8.Principal_ventas_8;
import Ventas_9.Principal_ventas_9;
import backup.SendEmail;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import user.empre_config_serial;
import user.user;
import ventas_16.Principal_ventas_16;

public class Principal extends javax.swing.JFrame {

    private Dimension dim;

    public Principal() throws IOException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        lbl_mode_dark.setText(mode);
        if (mode.equals("oscuro")) {
            panel_principal.setBackground(new java.awt.Color(8, 52, 74)); 
            
        } 

        menu_serv.setVisible(false);
        lbl_notifi_pedidos.setVisible(false);
        menu_licencia.setVisible(false);
        lbl_mode_dark.setText(mode);
        actualiza();
        //  fecha();
        panel_config_gral.setVisible(false);
        //  cargar();
        cargarUsu(cod);
        controlFecha();
        //licencia();
        cargarConfig();
        permisos_users(lbl_tipo.getText());
        OpcionMenu();
        //cargar_Agenda();
        configuracion();
        //nooo serial();
        control_version();
        HORA_SERVIDOR();

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Iconos_1/necttic_ico.jpg"));

        return retValue;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_usu_nom = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_tipo = new javax.swing.JLabel();
        lbl_empresa = new javax.swing.JLabel();
        lbl_img_empre = new javax.swing.JLabel();
        panel_config_gral = new javax.swing.JPanel();
        txt_simbolo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_compra_fiscal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_usu_almacen = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_class = new javax.swing.JLabel();
        lbl_fecha_hoy = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_fecha_principal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_des_serial = new javax.swing.JLabel();
        lbl_licencia = new javax.swing.JLabel();
        lbl_control_minimo = new javax.swing.JLabel();
        txt_hora_act = new javax.swing.JLabel();
        txt_modelo_ventas = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_dir_backup = new javax.swing.JLabel();
        txt_act_vuelto = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_fecha_backup = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        lbl_mone_def = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_serie_empre = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_pre_c = new javax.swing.JLabel();
        lbl_panel_pre_usu = new javax.swing.JLabel();
        lbl_pre_b = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_cuenta_user = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_ventas_usu_ss = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbl_año_actual = new javax.swing.JLabel();
        lbl_dia_actual = new javax.swing.JLabel();
        lbl_mes_actual = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_usu_caj_rap = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbl_mod_factura = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lbl_id_empre = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_model_ticket = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbl_periodo_fiscal = new javax.swing.JLabel();
        lbl_model_lucro = new javax.swing.JLabel();
        lbl_id_user = new javax.swing.JLabel();
        lbl_mode_dark = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        LBL_HORA_SERVER = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lbl_hora_server = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lbl_lote_activa = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lbl_version = new javax.swing.JLabel();
        version_alerta = new javax.swing.JLabel();
        botton_config = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_nro_sucursal = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_notifi_pedidos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_inicio = new javax.swing.JMenu();
        menu_config = new javax.swing.JMenuItem();
        menu_licencia = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_copia = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menu_producto = new javax.swing.JMenu();
        menu_productos = new javax.swing.JMenuItem();
        menu_departa = new javax.swing.JMenuItem();
        menu_categ = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menu_sub_cat = new javax.swing.JMenuItem();
        menu_cat_espec = new javax.swing.JMenuItem();
        menu_colores = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        menu_logistica = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        menu_clientes = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        menu_proveedor = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        menu_usuario = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menu_ventas = new javax.swing.JMenuItem();
        menu_compras = new javax.swing.JMenuItem();
        menu_devolucion = new javax.swing.JMenuItem();
        menu_presupuesto = new javax.swing.JMenuItem();
        menu_egreso = new javax.swing.JMenuItem();
        menu_pedidos = new javax.swing.JMenuItem();
        menu_recibos = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menu_caja = new javax.swing.JMenuItem();
        menu_listado_mov = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        menu_historicos = new javax.swing.JMenuItem();
        menu_cuentas = new javax.swing.JMenuItem();
        menu_bancos = new javax.swing.JMenuItem();
        menu_cambios = new javax.swing.JMenuItem();
        menu_transferencia = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        menu_esta_stock = new javax.swing.JMenu();
        menu_razon_pro = new javax.swing.JMenuItem();
        menu_list_dto = new javax.swing.JMenuItem();
        menu_list_fisico = new javax.swing.JMenuItem();
        menu_list_cp = new javax.swing.JMenuItem();
        menu_esta_ventas = new javax.swing.JMenu();
        menu_list_venta = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        menu_lucro = new javax.swing.JMenuItem();
        menu_venta_usu = new javax.swing.JMenuItem();
        menu_lucro_user = new javax.swing.JMenuItem();
        menu_salida_stock = new javax.swing.JMenuItem();
        menu_lucro_pro = new javax.swing.JMenuItem();
        menu_esta_compras = new javax.swing.JMenu();
        menu_list_compras = new javax.swing.JMenuItem();
        menu_esta_devoluciones = new javax.swing.JMenu();
        menu_list_devol = new javax.swing.JMenuItem();
        menu_serv = new javax.swing.JMenu();
        menu_os_prin = new javax.swing.JMenu();
        menu_os_prin_os = new javax.swing.JMenuItem();
        menu_facturas_prin = new javax.swing.JMenu();
        menu_facturas = new javax.swing.JMenuItem();
        menu_recibo_fisc = new javax.swing.JMenuItem();
        menu_nota_cre = new javax.swing.JMenuItem();
        menu_reporte_fiscal = new javax.swing.JMenu();
        menu_venta_estad = new javax.swing.JMenuItem();
        menu_libro_compras = new javax.swing.JMenuItem();
        menu_libro_compras1 = new javax.swing.JMenuItem();
        menu_libro_compras2 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        menu_surcusales = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        menu_venta_lucro = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("NECTTIC ");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1250, 700));
        setModalExclusionType(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));
        panel_principal.setMaximumSize(new java.awt.Dimension(2147483646, 2147483646));
        panel_principal.setMinimumSize(new java.awt.Dimension(1250, 700));
        panel_principal.setPreferredSize(new java.awt.Dimension(2147483646, 2147483646));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shield.png"))); // NOI18N
        panel_principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 40, 40));

        lbl_usu_nom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_usu_nom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_usu_nom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_principal.add(lbl_usu_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 350, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/gear.png"))); // NOI18N
        panel_principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 40, 40));

        lbl_tipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_tipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_tipo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_principal.add(lbl_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 330, 40));

        lbl_empresa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_empresa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel_principal.add(lbl_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 490, 40));
        panel_principal.add(lbl_img_empre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 60));

        panel_config_gral.setBackground(new java.awt.Color(255, 255, 255));
        panel_config_gral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        panel_config_gral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_simbolo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_simbolo.setText("simbolo");
        panel_config_gral.add(txt_simbolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Serial estado:");
        panel_config_gral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Modelo ID:");
        panel_config_gral.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        txt_compra_fiscal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_compra_fiscal.setText("compra_fiscal");
        panel_config_gral.add(txt_compra_fiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 80, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CONFIGURACIONES DEL SISTEMA NECTTIC ");
        panel_config_gral.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 270, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("HORA_SERVER:");
        panel_config_gral.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        lbl_usu_almacen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_usu_almacen.setText("usu-alma");
        panel_config_gral.add(lbl_usu_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 60, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Fecha MySQl:");
        panel_config_gral.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Almacen:");
        panel_config_gral.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        lbl_class.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_class.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_class.setText("classs");
        panel_config_gral.add(lbl_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 50, 20));

        lbl_fecha_hoy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_fecha_hoy.setText("FECHAHOY");
        panel_config_gral.add(lbl_fecha_hoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 110, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Clas.User:");
        panel_config_gral.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        lbl_fecha_principal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_fecha_principal.setText("feecha");
        panel_config_gral.add(lbl_fecha_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 90, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Licencia Hasta:");
        panel_config_gral.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 20));

        lbl_des_serial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_des_serial.setText("des_serial");
        panel_config_gral.add(lbl_des_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 100, 20));

        lbl_licencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_licencia.setText("fecha_licencia");
        panel_config_gral.add(lbl_licencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 150, 20));

        lbl_control_minimo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_control_minimo.setText("min");
        panel_config_gral.add(lbl_control_minimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 134, 50, -1));

        txt_hora_act.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_hora_act.setText("Hora Actual:");
        panel_config_gral.add(txt_hora_act, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, 20));

        txt_modelo_ventas.setText("Mod.V");
        panel_config_gral.add(txt_modelo_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 60, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Mod. Tickect:");
        panel_config_gral.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Control Min:");
        panel_config_gral.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Regimen:");
        panel_config_gral.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        txt_dir_backup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_dir_backup.setText("backup");
        panel_config_gral.add(txt_dir_backup, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 130, 20));

        txt_act_vuelto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_act_vuelto.setText("vuelto");
        panel_config_gral.add(txt_act_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Fecha Actual:");
        panel_config_gral.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 20));

        txt_fecha_backup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fecha_backup.setText("fecha");
        panel_config_gral.add(txt_fecha_backup, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 100, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Compra Fiscal:");
        panel_config_gral.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 204));
        panel_config_gral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 22, 690, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Fecha bkp:");
        panel_config_gral.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 20));

        lbl_mone_def.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_mone_def.setText("moneda");
        panel_config_gral.add(lbl_mone_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 100, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora Actual:");
        panel_config_gral.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Moneda:");
        panel_config_gral.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Moneda S:");
        panel_config_gral.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));

        lbl_serie_empre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_serie_empre.setText("IVA");
        panel_config_gral.add(lbl_serie_empre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 50, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Precio Bloq:");
        panel_config_gral.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Precio b:");
        panel_config_gral.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, 20));

        lbl_pre_c.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_pre_c.setText("minimo");
        panel_config_gral.add(lbl_pre_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 70, 20));

        lbl_panel_pre_usu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_panel_pre_usu.setText("precio_a");
        panel_config_gral.add(lbl_panel_pre_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 60, 20));

        lbl_pre_b.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_pre_b.setText("pre_b");
        panel_config_gral.add(lbl_pre_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 70, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Precio c:");
        panel_config_gral.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Id Empresa:");
        panel_config_gral.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, 20));

        lbl_cuenta_user.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_cuenta_user.setText("cuenta");
        panel_config_gral.add(lbl_cuenta_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 80, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Cuentas nro:");
        panel_config_gral.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, 20));

        lbl_ventas_usu_ss.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_ventas_usu_ss.setText("sin stock");
        panel_config_gral.add(lbl_ventas_usu_ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 210, 50, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Sin Stock:");
        panel_config_gral.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("DIA:");
        panel_config_gral.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("MES:");
        panel_config_gral.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, 20));

        lbl_año_actual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_año_actual.setText("00");
        panel_config_gral.add(lbl_año_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 90, 20));

        lbl_dia_actual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_dia_actual.setText("00");
        panel_config_gral.add(lbl_dia_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 90, 20));

        lbl_mes_actual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_mes_actual.setText("00");
        panel_config_gral.add(lbl_mes_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 90, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Serie Nro:");
        panel_config_gral.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 20));

        lbl_usu_caj_rap.setText("--");
        panel_config_gral.add(lbl_usu_caj_rap, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 290, 40, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Caja Rap:");
        panel_config_gral.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));

        lbl_mod_factura.setText("000");
        panel_config_gral.add(lbl_mod_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 60, 20));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Modelo de Factura:");
        panel_config_gral.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 20));

        lbl_id_empre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_id_empre.setText("0");
        panel_config_gral.add(lbl_id_empre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 50, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("M. Ventas:");
        panel_config_gral.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, 20));

        txt_model_ticket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_model_ticket.setText("tickte");
        panel_config_gral.add(txt_model_ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 40, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("AÑO:");
        panel_config_gral.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, 20));

        lbl_periodo_fiscal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_periodo_fiscal.setText("0000");
        panel_config_gral.add(lbl_periodo_fiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, 20));

        lbl_model_lucro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_model_lucro.setText("0");
        panel_config_gral.add(lbl_model_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 40, 20));

        lbl_id_user.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_id_user.setText("0");
        panel_config_gral.add(lbl_id_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 50, 20));

        lbl_mode_dark.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_mode_dark.setText("Mode");
        panel_config_gral.add(lbl_mode_dark, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 80, 20));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("periodo_fiscal:");
        panel_config_gral.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, 20));

        LBL_HORA_SERVER.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LBL_HORA_SERVER.setForeground(new java.awt.Color(255, 0, 0));
        LBL_HORA_SERVER.setText("000000");
        panel_config_gral.add(LBL_HORA_SERVER, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, 20));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Tipo lucro:");
        panel_config_gral.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, 20));

        lbl_hora_server.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_hora_server.setText("0");
        panel_config_gral.add(lbl_hora_server, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 60, 20));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("id user:");
        panel_config_gral.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, 20));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("HORA_SERVER:");
        panel_config_gral.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 20));

        lbl_lote_activa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_lote_activa.setText("N");
        panel_config_gral.add(lbl_lote_activa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 30, 20));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Mode:");
        panel_config_gral.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, 20));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("Lote facturas:");
        panel_config_gral.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 20));

        panel_principal.add(panel_config_gral, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 690, 340));

        lbl_version.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_version.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_version.setText("4.3.9");
        panel_principal.add(lbl_version, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 206, 50, 40));

        version_alerta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        version_alerta.setText("Aviso de versión");
        panel_principal.add(version_alerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 250, 30));

        botton_config.setBackground(new java.awt.Color(255, 255, 255));
        botton_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/abacus.png"))); // NOI18N
        botton_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botton_configActionPerformed(evt);
            }
        });
        panel_principal.add(botton_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shopper.png"))); // NOI18N
        panel_principal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 40));

        txt_nro_sucursal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        panel_principal.add(txt_nro_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 80, 30));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/version.png"))); // NOI18N
        panel_principal.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_notifi_pedidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_notifi_pedidos.setForeground(new java.awt.Color(204, 0, 0));
        lbl_notifi_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/bullhorn.png"))); // NOI18N
        lbl_notifi_pedidos.setText("  NUEVO PEDIDO AGREGADO O PEDIDOS EN ESPERA");
        panel_principal.add(lbl_notifi_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 360, 30));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 2500, 2001));

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 204));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1168, 40));

        menu_inicio.setBackground(new java.awt.Color(255, 255, 255));
        menu_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/menu.png"))); // NOI18N
        menu_inicio.setMnemonic('i');
        menu_inicio.setText("Inicio       ");
        menu_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_inicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menu_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_inicioActionPerformed(evt);
            }
        });

        menu_config.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/gear.png"))); // NOI18N
        menu_config.setText("Configuraciones");
        menu_config.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_configActionPerformed(evt);
            }
        });
        menu_inicio.add(menu_config);

        menu_licencia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_licencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/gear.png"))); // NOI18N
        menu_licencia.setText("Conf. de Licencia");
        menu_licencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_licencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_licenciaActionPerformed(evt);
            }
        });
        menu_inicio.add(menu_licencia);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_HOME, 0));
        jMenuItem1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shield.png"))); // NOI18N
        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_inicio.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/login.png"))); // NOI18N
        jMenuItem2.setText("Salir del Sistema");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_inicio.add(jMenuItem2);

        menu_copia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_END, 0));
        menu_copia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/clud.png"))); // NOI18N
        menu_copia.setText("Backup");
        menu_copia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_copia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_copiaActionPerformed(evt);
            }
        });
        menu_inicio.add(menu_copia);

        jMenuBar1.add(menu_inicio);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/diagrama-de-flujo.png"))); // NOI18N
        jMenu1.setText("Datos       ");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menu_producto.setBackground(new java.awt.Color(255, 255, 255));
        menu_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        menu_producto.setText("Stock");
        menu_producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menu_productos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menu_productos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        menu_productos.setText("-Productos");
        menu_productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_productosActionPerformed(evt);
            }
        });
        menu_producto.add(menu_productos);

        menu_departa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_departa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        menu_departa.setText("-Departamentos          ");
        menu_departa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_departa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_departaActionPerformed(evt);
            }
        });
        menu_producto.add(menu_departa);

        menu_categ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_categ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        menu_categ.setText("-Categorías");
        menu_categ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_categ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_categActionPerformed(evt);
            }
        });
        menu_producto.add(menu_categ);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ajust.png"))); // NOI18N
        jMenu4.setText("-Items");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        menu_sub_cat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_sub_cat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        menu_sub_cat.setText("-Sub Categorías");
        menu_sub_cat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_sub_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sub_catActionPerformed(evt);
            }
        });
        jMenu4.add(menu_sub_cat);

        menu_cat_espec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        menu_cat_espec.setText("-Categoría Específicas");
        menu_cat_espec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_cat_espec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cat_especActionPerformed(evt);
            }
        });
        jMenu4.add(menu_cat_espec);

        menu_colores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_colores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        menu_colores.setText("-Colores");
        menu_colores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_colores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_coloresActionPerformed(evt);
            }
        });
        jMenu4.add(menu_colores);

        jMenuItem8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        jMenuItem8.setText("-Marcas");
        jMenuItem8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        jMenuItem20.setText("-Tamaño");
        jMenuItem20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem20);

        menu_producto.add(jMenu4);

        jMenu1.add(menu_producto);

        menu_logistica.setBackground(new java.awt.Color(255, 255, 255));
        menu_logistica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/logist.png"))); // NOI18N
        menu_logistica.setText("Logística");
        menu_logistica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_logistica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shopper.png"))); // NOI18N
        jMenuItem12.setText("-Almacenes       ");
        jMenuItem12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        menu_logistica.add(jMenuItem12);

        jMenuItem14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/transfer.png"))); // NOI18N
        jMenuItem14.setText("-Transferencias de Stock");
        jMenuItem14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        menu_logistica.add(jMenuItem14);

        jMenuItem7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/scan.png"))); // NOI18N
        jMenuItem7.setText("Etiquetas");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menu_logistica.add(jMenuItem7);

        jMenuItem3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ajust.png"))); // NOI18N
        jMenuItem3.setText("Ajustes de Stock");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_logistica.add(jMenuItem3);

        jMenuItem16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/factory.png"))); // NOI18N
        jMenuItem16.setText("Producción ");
        jMenuItem16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        menu_logistica.add(jMenuItem16);

        jMenu1.add(menu_logistica);

        menu_clientes.setBackground(new java.awt.Color(255, 255, 255));
        menu_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/teamwork.png"))); // NOI18N
        menu_clientes.setText("Clientes");
        menu_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_clientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/teamwork.png"))); // NOI18N
        jMenuItem11.setText("-Clientes               ");
        jMenuItem11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menu_clientes.add(jMenuItem11);

        jMenu1.add(menu_clientes);

        menu_proveedor.setBackground(new java.awt.Color(255, 255, 255));
        menu_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/translation.png"))); // NOI18N
        menu_proveedor.setText("Proveedores");
        menu_proveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_proveedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/translation.png"))); // NOI18N
        jMenuItem17.setText("-Proveedores      ");
        jMenuItem17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        menu_proveedor.add(jMenuItem17);

        jMenu1.add(menu_proveedor);

        menu_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shield.png"))); // NOI18N
        menu_usuario.setText("Conf. usuarios");
        menu_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_usuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shield.png"))); // NOI18N
        jMenuItem21.setText("-Usuarios           ");
        jMenuItem21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        menu_usuario.add(jMenuItem21);

        jMenu1.add(menu_usuario);

        jMenuBar1.add(jMenu1);

        jMenu7.setBackground(new java.awt.Color(255, 255, 255));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/red.png"))); // NOI18N
        jMenu7.setText("Movimientos       ");
        jMenu7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menu_ventas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menu_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ventas.png"))); // NOI18N
        menu_ventas.setText("Ventas                       ");
        menu_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ventasActionPerformed(evt);
            }
        });
        jMenu7.add(menu_ventas);

        menu_compras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menu_compras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/add.png"))); // NOI18N
        menu_compras.setText("Compras");
        menu_compras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_comprasActionPerformed(evt);
            }
        });
        jMenu7.add(menu_compras);

        menu_devolucion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        menu_devolucion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_devolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cash.png"))); // NOI18N
        menu_devolucion.setText("Devoluciones");
        menu_devolucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_devolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_devolucionActionPerformed(evt);
            }
        });
        jMenu7.add(menu_devolucion);

        menu_presupuesto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        menu_presupuesto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_presupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/chart.png"))); // NOI18N
        menu_presupuesto.setText("Presupuestos");
        menu_presupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_presupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_presupuestoActionPerformed(evt);
            }
        });
        jMenu7.add(menu_presupuesto);

        menu_egreso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        menu_egreso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_egreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/strategy.png"))); // NOI18N
        menu_egreso.setText("Egresos");
        menu_egreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_egreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_egresoActionPerformed(evt);
            }
        });
        jMenu7.add(menu_egreso);

        menu_pedidos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        menu_pedidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/timer.png"))); // NOI18N
        menu_pedidos.setText("Pedidos");
        menu_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_pedidosActionPerformed(evt);
            }
        });
        jMenu7.add(menu_pedidos);

        menu_recibos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_recibos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agreement.png"))); // NOI18N
        menu_recibos.setText("Recibos");
        menu_recibos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_recibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_recibosActionPerformed(evt);
            }
        });
        jMenu7.add(menu_recibos);

        jMenuBar1.add(jMenu7);

        jMenu8.setBackground(new java.awt.Color(255, 255, 255));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/bank.png"))); // NOI18N
        jMenu8.setText("Financiero         ");
        jMenu8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menu_caja.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        menu_caja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/caja.png"))); // NOI18N
        menu_caja.setText("Caja                    ");
        menu_caja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cajaActionPerformed(evt);
            }
        });
        jMenu8.add(menu_caja);

        menu_listado_mov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/movimineto.png"))); // NOI18N
        menu_listado_mov.setText("Listado de Movimentación");
        menu_listado_mov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_listado_mov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/movimineto.png"))); // NOI18N
        jMenuItem24.setText("-Movimientos de Caja  Gral ");
        jMenuItem24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        menu_listado_mov.add(jMenuItem24);

        jMenuItem35.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/movimineto.png"))); // NOI18N
        jMenuItem35.setText("-Listado por Cuenta");
        jMenuItem35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        menu_listado_mov.add(jMenuItem35);

        jMenuItem15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/movimineto.png"))); // NOI18N
        jMenuItem15.setText("-Clasificación por históricos");
        jMenuItem15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        menu_listado_mov.add(jMenuItem15);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cash.png"))); // NOI18N
        jMenu5.setText("-Cuentas a Recibir");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cash.png"))); // NOI18N
        jMenuItem23.setText("-Ventas");
        jMenuItem23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem23);

        jMenuItem25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cash.png"))); // NOI18N
        jMenuItem25.setText("-Facturación          ");
        jMenuItem25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem25);

        menu_listado_mov.add(jMenu5);

        jMenu8.add(menu_listado_mov);

        menu_historicos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_historicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/histo.png"))); // NOI18N
        menu_historicos.setText("Históricos");
        menu_historicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_historicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_historicosActionPerformed(evt);
            }
        });
        jMenu8.add(menu_historicos);

        menu_cuentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cuentas.png"))); // NOI18N
        menu_cuentas.setText("Cuentas");
        menu_cuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cuentasActionPerformed(evt);
            }
        });
        jMenu8.add(menu_cuentas);

        menu_bancos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_bancos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/banco.png"))); // NOI18N
        menu_bancos.setText("Bancos");
        menu_bancos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_bancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_bancosActionPerformed(evt);
            }
        });
        jMenu8.add(menu_bancos);

        menu_cambios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cambios.png"))); // NOI18N
        menu_cambios.setText("Cambios");
        menu_cambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cambiosActionPerformed(evt);
            }
        });
        jMenu8.add(menu_cambios);

        menu_transferencia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_transferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/diner.png"))); // NOI18N
        menu_transferencia.setText("Transferencia de Dinero");
        menu_transferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_transferenciaActionPerformed(evt);
            }
        });
        jMenu8.add(menu_transferencia);

        jMenuBar1.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jMenu9.setText("Estadísticas      ");
        jMenu9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menu_esta_stock.setBackground(new java.awt.Color(255, 255, 255));
        menu_esta_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        menu_esta_stock.setText("Stock                       ");
        menu_esta_stock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_esta_stock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        menu_razon_pro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_razon_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_razon_pro.setText("-Razón del Producto");
        menu_razon_pro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_razon_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_razon_proActionPerformed(evt);
            }
        });
        menu_esta_stock.add(menu_razon_pro);

        menu_list_dto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_list_dto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_list_dto.setText("-Listado por Dptos-Categorías");
        menu_list_dto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_list_dto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_list_dtoActionPerformed(evt);
            }
        });
        menu_esta_stock.add(menu_list_dto);

        menu_list_fisico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_list_fisico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_list_fisico.setText("-Listado Físico");
        menu_list_fisico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_list_fisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_list_fisicoActionPerformed(evt);
            }
        });
        menu_esta_stock.add(menu_list_fisico);

        menu_list_cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_list_cp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_list_cp.setText("-Listado CP de Stock ");
        menu_list_cp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_list_cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_list_cpActionPerformed(evt);
            }
        });
        menu_esta_stock.add(menu_list_cp);

        jMenu9.add(menu_esta_stock);

        menu_esta_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        menu_esta_ventas.setText("Ventas");
        menu_esta_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_esta_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        menu_list_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_list_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_list_venta.setText("-Extracto de ventas p/ Clientes");
        menu_list_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_list_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_list_ventaActionPerformed(evt);
            }
        });
        menu_esta_ventas.add(menu_list_venta);

        jMenuItem13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        jMenuItem13.setText("-Extracto de ventas Gral");
        jMenuItem13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        menu_esta_ventas.add(jMenuItem13);

        menu_lucro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_lucro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/movimineto.png"))); // NOI18N
        menu_lucro.setText("-Lucro por Ventas");
        menu_lucro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_lucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_lucroActionPerformed(evt);
            }
        });
        menu_esta_ventas.add(menu_lucro);

        menu_venta_usu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_venta_usu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_venta_usu.setText("-Ventas por Usuario");
        menu_venta_usu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_venta_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_venta_usuActionPerformed(evt);
            }
        });
        menu_esta_ventas.add(menu_venta_usu);

        menu_lucro_user.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_lucro_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_lucro_user.setText("-Lucro por Usuario");
        menu_lucro_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_lucro_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_lucro_userActionPerformed(evt);
            }
        });
        menu_esta_ventas.add(menu_lucro_user);

        menu_salida_stock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_salida_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_salida_stock.setText("-Listado ventas/Stock");
        menu_salida_stock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_salida_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_salida_stockActionPerformed(evt);
            }
        });
        menu_esta_ventas.add(menu_salida_stock);

        menu_lucro_pro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_lucro_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_lucro_pro.setText("-Listado Lucro/Dep.");
        menu_lucro_pro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_lucro_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_lucro_proActionPerformed(evt);
            }
        });
        menu_esta_ventas.add(menu_lucro_pro);

        jMenu9.add(menu_esta_ventas);

        menu_esta_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        menu_esta_compras.setText("Compras");
        menu_esta_compras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_esta_compras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        menu_list_compras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_list_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_list_compras.setText("-Extracto de Compras");
        menu_list_compras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_list_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_list_comprasActionPerformed(evt);
            }
        });
        menu_esta_compras.add(menu_list_compras);

        jMenu9.add(menu_esta_compras);

        menu_esta_devoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        menu_esta_devoluciones.setText("Devoluciones");
        menu_esta_devoluciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_esta_devoluciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        menu_list_devol.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_list_devol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_list_devol.setText("-Extracto de Devoluciones");
        menu_list_devol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_list_devol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_list_devolActionPerformed(evt);
            }
        });
        menu_esta_devoluciones.add(menu_list_devol);

        jMenu9.add(menu_esta_devoluciones);

        jMenuBar1.add(jMenu9);

        menu_serv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/service.png"))); // NOI18N
        menu_serv.setText("Servicios O.S      ");
        menu_serv.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menu_os_prin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/service.png"))); // NOI18N
        menu_os_prin.setText("Ordenes de Servicios");
        menu_os_prin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_os_prin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        menu_os_prin_os.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_os_prin_os.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/repair.png"))); // NOI18N
        menu_os_prin_os.setText("Asistencia                       ");
        menu_os_prin_os.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_os_prin_os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_os_prin_osActionPerformed(evt);
            }
        });
        menu_os_prin.add(menu_os_prin_os);

        menu_serv.add(menu_os_prin);

        jMenuBar1.add(menu_serv);

        menu_facturas_prin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/contacts.png"))); // NOI18N
        menu_facturas_prin.setText("Facturación      ");
        menu_facturas_prin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menu_facturas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_facturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ventas.png"))); // NOI18N
        menu_facturas.setText("Facturas                          ");
        menu_facturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_facturasActionPerformed(evt);
            }
        });
        menu_facturas_prin.add(menu_facturas);

        menu_recibo_fisc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_recibo_fisc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agreement.png"))); // NOI18N
        menu_recibo_fisc.setText("Recibos");
        menu_recibo_fisc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_recibo_fisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_recibo_fiscActionPerformed(evt);
            }
        });
        menu_facturas_prin.add(menu_recibo_fisc);

        menu_nota_cre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_nota_cre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/cash.png"))); // NOI18N
        menu_nota_cre.setText("Nota de Crédito Dev");
        menu_nota_cre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_nota_cre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nota_creActionPerformed(evt);
            }
        });
        menu_facturas_prin.add(menu_nota_cre);

        menu_reporte_fiscal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        menu_reporte_fiscal.setText("Reportes");
        menu_reporte_fiscal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_reporte_fiscal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        menu_venta_estad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_venta_estad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_venta_estad.setText("-Libro de Ventas");
        menu_venta_estad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_venta_estad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_venta_estadActionPerformed(evt);
            }
        });
        menu_reporte_fiscal.add(menu_venta_estad);

        menu_libro_compras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_libro_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_libro_compras.setText("-Libro de Compras");
        menu_libro_compras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_libro_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_libro_comprasActionPerformed(evt);
            }
        });
        menu_reporte_fiscal.add(menu_libro_compras);

        menu_libro_compras1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_libro_compras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_libro_compras1.setText("-Nota de Crédito Dev");
        menu_libro_compras1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_libro_compras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_libro_compras1ActionPerformed(evt);
            }
        });
        menu_reporte_fiscal.add(menu_libro_compras1);

        menu_libro_compras2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_libro_compras2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        menu_libro_compras2.setText("-Recibos");
        menu_libro_compras2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_libro_compras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_libro_compras2ActionPerformed(evt);
            }
        });
        menu_reporte_fiscal.add(menu_libro_compras2);

        jMenuItem22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        jMenuItem22.setText("-Cheques");
        jMenuItem22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        menu_reporte_fiscal.add(jMenuItem22);

        menu_facturas_prin.add(menu_reporte_fiscal);

        jMenuBar1.add(menu_facturas_prin);

        menu_surcusales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_png/png/map.png"))); // NOI18N
        menu_surcusales.setText("Sucursales         ");
        menu_surcusales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/group.png"))); // NOI18N
        jMenuItem6.setText("Transferencias de Stock");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menu_surcusales.add(jMenuItem6);

        jMenuItem10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/histo.png"))); // NOI18N
        jMenuItem10.setText("Históricos");
        jMenuItem10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menu_surcusales.add(jMenuItem10);

        jMenuItem18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ajust.png"))); // NOI18N
        jMenuItem18.setText("Ajustes de Stock");
        jMenuItem18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        menu_surcusales.add(jMenuItem18);

        jMenuItem9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        jMenuItem9.setText("Relatorios Financieros");
        jMenuItem9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menu_surcusales.add(jMenuItem9);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jMenu6.setText("Relatorios de Ventas");
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/chart.png"))); // NOI18N
        jMenuItem28.setText("-Ventas p/ Clientes");
        jMenuItem28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem28);

        jMenuItem4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jMenuItem4.setText("-Ventas Gral");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jMenuItem29.setText("-Ventas p/ Usuarios");
        jMenuItem29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem29);

        menu_venta_lucro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_venta_lucro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/movimineto.png"))); // NOI18N
        menu_venta_lucro.setText("-Lucro por Ventas");
        menu_venta_lucro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_venta_lucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_venta_lucroActionPerformed(evt);
            }
        });
        jMenu6.add(menu_venta_lucro);

        menu_surcusales.add(jMenu6);

        jMenuItem5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        jMenuItem5.setText("Relatorios de Stock");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menu_surcusales.add(jMenuItem5);

        jMenuItem26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/report.png"))); // NOI18N
        jMenuItem26.setText("-Listado por Dep-Cat-Marca");
        jMenuItem26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        menu_surcusales.add(jMenuItem26);

        jMenuBar1.add(menu_surcusales);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/barco-de-carga.png"))); // NOI18N
        jMenu2.setText("MIE                       ");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ventas.png"))); // NOI18N
        jMenuItem19.setText("Factura de Exportación");
        jMenuItem19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void menu_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_inicioActionPerformed
// TODO add your handling code here:

}//GEN-LAST:event_menu_inicioActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
    NECTTIC principal = null;
    try {
        principal = new NECTTIC();
    } catch (SocketException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    principal.setVisible(true);
    principal.pack();
    this.setVisible(false);
}//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menu_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_productosActionPerformed
        Productos pro;
        pro = new Productos(new javax.swing.JDialog(), true);
        pro.setVisible(true);
    }//GEN-LAST:event_menu_productosActionPerformed

    private void menu_departaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_departaActionPerformed
        Departamentos_Principal dep;
        dep = new Departamentos_Principal(new javax.swing.JDialog(), true);
        dep.setVisible(true);
    }//GEN-LAST:event_menu_departaActionPerformed

    private void menu_categActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_categActionPerformed
        Categorias_Principal cat;
        cat = new Categorias_Principal(new javax.swing.JDialog(), true);
        cat.setVisible(true);
    }//GEN-LAST:event_menu_categActionPerformed

    private void menu_sub_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sub_catActionPerformed
        Sub_Categorias_Principal scat;
        scat = new Sub_Categorias_Principal(new javax.swing.JDialog(), true);
        scat.setVisible(true);
    }//GEN-LAST:event_menu_sub_catActionPerformed

    private void menu_coloresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_coloresActionPerformed
        Colores_Principal col;
        col = new Colores_Principal(new javax.swing.JDialog(), true);
        col.setVisible(true);
    }//GEN-LAST:event_menu_coloresActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Marcas_Principal marc;
        marc = new Marcas_Principal(new javax.swing.JDialog(), true);
        marc.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void menu_cat_especActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cat_especActionPerformed
        Categorias_Espec_Principal escat;
        escat = new Categorias_Espec_Principal(new javax.swing.JDialog(), true);
        escat.setVisible(true);
    }//GEN-LAST:event_menu_cat_especActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Plataforma_clientes ac;
        ac = new Plataforma_clientes(new javax.swing.JDialog(), true);
        ac.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Almaccen_Principal al;
        al = new Almaccen_Principal(new javax.swing.JDialog(), true);
        al.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        Principal_transferencia altrans;
        altrans = new Principal_transferencia(new javax.swing.JDialog(), true);
        altrans.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        Plataforma_proveedor pv;
        pv = new Plataforma_proveedor(new javax.swing.JDialog(), true);
        pv.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void menu_copiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_copiaActionPerformed
        try {

            EnviandoBDCorreo(GenerarBackupMySQL_ANTES());

        } catch (Exception e) {

            Process p = null;

            try {
                Runtime runtime = Runtime.getRuntime();

                p = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\mysqldump --password=canis --user=system --default-character-set=utf8 --extended-insert=false --hex-blob necttic -r " + "C:\\copia\\BK" + txt_fecha_backup.getText() + ".sql");
                //change the dbpass and dbname with your dbpass and dbname
                int processComplete = p.waitFor();

                if (processComplete == 0) {
                    Copia cpy;
                    cpy = new Copia(new javax.swing.JDialog(), true);
                    cpy.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(this, "Backup error!!");

                }

            } catch (IOException | InterruptedException | HeadlessException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        /*Process p = null;

         try {
         Runtime runtime = Runtime.getRuntime();
         p = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\mysqldump -usystem -pcanis --add-drop-database -B plataforma_necttic -r " + txt_dir_backup.getText() + "\\copia\\" + lbl_empresa.getText() + "_" + txt_fecha_backup.getText() + ".sql");
         //change the dbpass and dbname with your dbpass and dbname
         int processComplete = p.waitFor();

         if (processComplete == 0) {
         Copia cpy;
         cpy = new Copia(new javax.swing.JDialog(), true);
         cpy.setVisible(true);
         JOptionPane.showMessageDialog(this, "Backup creado con suceso!!");
         } else {
         JOptionPane.showMessageDialog(this, "Backup error!!");
         }

         } catch (HeadlessException | IOException | InterruptedException e) {
         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, e);
         }*/
        Copia cpy;
        cpy = new Copia(new javax.swing.JDialog(), true);
        cpy.setVisible(true);


    }//GEN-LAST:event_menu_copiaActionPerformed

    private void menu_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cajaActionPerformed
        Caja_caja ca;
        ca = new Caja_caja(new javax.swing.JDialog(), true);
        ca.setVisible(true);
    }//GEN-LAST:event_menu_cajaActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        user us;
        us = new user(new javax.swing.JDialog(), true);
        us.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void menu_razon_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_razon_proActionPerformed
        control_ventas_stock cv;
        cv = new control_ventas_stock(new javax.swing.JDialog(), true);
        cv.setVisible(true);
    }//GEN-LAST:event_menu_razon_proActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        mov_geral cv;
        cv = new mov_geral(new javax.swing.JDialog(), true);
        cv.setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void menu_cambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cambiosActionPerformed
        cambios cm;
        cm = new cambios(new javax.swing.JDialog(), true);
        cm.setVisible(true);
    }//GEN-LAST:event_menu_cambiosActionPerformed

    private void menu_list_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_list_ventaActionPerformed

        Seleccion_relatorio_ventas evs;
        evs = new Seleccion_relatorio_ventas(new javax.swing.JDialog(), true);
        evs.setVisible(true);


    }//GEN-LAST:event_menu_list_ventaActionPerformed

    private void menu_list_dtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_list_dtoActionPerformed
        stock_minimo sm;
        sm = new stock_minimo(new javax.swing.JDialog(), true);
        sm.setVisible(true);
    }//GEN-LAST:event_menu_list_dtoActionPerformed

    private void menu_historicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_historicosActionPerformed
        Historico_Surcusales pg;
        pg = new Historico_Surcusales(new javax.swing.JDialog(), true);
        pg.setVisible(true);
    }//GEN-LAST:event_menu_historicosActionPerformed

    private void menu_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_configActionPerformed
        try {
            config_fiscal_surcu ecv;
            ecv = new config_fiscal_surcu(new javax.swing.JDialog(), true);
            ecv.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_configActionPerformed

    private void menu_licenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_licenciaActionPerformed
        empre_config_serial ec;
        ec = new empre_config_serial(new javax.swing.JDialog(), true);
        ec.setVisible(true);
    }//GEN-LAST:event_menu_licenciaActionPerformed

    private void menu_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cuentasActionPerformed
        Cuentas_Principal cuentas;
        cuentas = new Cuentas_Principal(new javax.swing.JDialog(), true);
        cuentas.setVisible(true);
    }//GEN-LAST:event_menu_cuentasActionPerformed

    private void menu_venta_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_venta_usuActionPerformed
        ventas_anteriores_usuarios ventas_usu;
        ventas_usu = new ventas_anteriores_usuarios(new javax.swing.JDialog(), true);
        ventas_usu.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_menu_venta_usuActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        mov_geral_espe cve;
        cve = new mov_geral_espe(new javax.swing.JDialog(), true);
        cve.setVisible(true);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void menu_list_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_list_comprasActionPerformed
        extracto_compras ec;
        ec = new extracto_compras(new javax.swing.JDialog(), true);
        ec.setVisible(true);
    }//GEN-LAST:event_menu_list_comprasActionPerformed

    private void menu_list_devolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_list_devolActionPerformed
        Devolucion_listado ldev;
        ldev = new Devolucion_listado(new javax.swing.JDialog(), true);
        ldev.setVisible(true);
    }//GEN-LAST:event_menu_list_devolActionPerformed

    private void menu_venta_estadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_venta_estadActionPerformed

        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_surc_lv slv = new Seleccion_surc_lv(new javax.swing.JDialog(), true);
            slv.setVisible(true);

        } else {

            if (Principal.lbl_usu_almacen.getText().equals("0000001")) {

                Libro_ventas_lista li_venta;
                li_venta = new Libro_ventas_lista(new javax.swing.JDialog(), true);
                li_venta.setVisible(true);

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000002")) {
                Libro_ventas_lista_surc_2 li_venta_2;
                li_venta_2 = new Libro_ventas_lista_surc_2(new javax.swing.JDialog(), true);
                li_venta_2.setVisible(true);

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000026")) {
                Libro_ventas_lista_surc_26 li_venta_26;
                li_venta_26 = new Libro_ventas_lista_surc_26(new javax.swing.JDialog(), true);
                li_venta_26.setVisible(true);

            }
        }


    }//GEN-LAST:event_menu_venta_estadActionPerformed

    private void menu_transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_transferenciaActionPerformed
        trans_dinero_caja trans_caja;
        trans_caja = new trans_dinero_caja(new javax.swing.JDialog(), true);
        trans_caja.setVisible(true);
    }//GEN-LAST:event_menu_transferenciaActionPerformed

    private void menu_venta_lucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_venta_lucroActionPerformed
        String grado = lbl_class.getText();
        String nivel = ("5");

        int des = Integer.parseInt(grado);
        int nv = Integer.parseInt(nivel);
        if (des >= nv) {
            ventas_lucro_total lucro_ventas;
            lucro_ventas = new ventas_lucro_total(new javax.swing.JDialog(), true);
            lucro_ventas.setVisible(true);
        }
    }//GEN-LAST:event_menu_venta_lucroActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Salir del Sistema, ¿desea continuar?",
                "Salir del Sistema", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.out.println("Conexión cerrado");
            System.exit(0);

        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menu_list_fisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_list_fisicoActionPerformed
        Pro_con_stock cs;
        cs = new Pro_con_stock(new javax.swing.JDialog(), true);
        cs.setVisible(true);
    }//GEN-LAST:event_menu_list_fisicoActionPerformed

    private void menu_list_cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_list_cpActionPerformed

        Productos_CP rp;
        rp = new Productos_CP(new javax.swing.JDialog(), true);
        rp.setVisible(true);

    }//GEN-LAST:event_menu_list_cpActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        new Thread(new time()).start();
    }//GEN-LAST:event_formWindowOpened

    private void menu_facturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_facturasActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_fiscal_sucursales sa = new Seleccion_fiscal_sucursales(new javax.swing.JDialog(), true);
            sa.setVisible(true);

        } else {

            if (Principal.lbl_usu_almacen.getText().equals("0000001")) {

                Principal_ventas_facturas vf;
                vf = new Principal_ventas_facturas(new javax.swing.JDialog(), true);
                vf.setVisible(true);

            }

            //2
            if (Principal.lbl_usu_almacen.getText().equals("0000002")) {

                Principal_ventas_surc_2 vf2;
                vf2 = new Principal_ventas_surc_2(new javax.swing.JDialog(), true);
                vf2.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000003")) {

                Principal_ventas_surc_3 vf3;
                vf3 = new Principal_ventas_surc_3(new javax.swing.JDialog(), true);
                vf3.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000004")) {

                Principal_ventas_facturas_4 vf4;
                vf4 = new Principal_ventas_facturas_4(new javax.swing.JDialog(), true);
                vf4.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000008")) {

                Principal_ventas_facturas_8 vf8;
                vf8 = new Principal_ventas_facturas_8(new javax.swing.JDialog(), true);
                vf8.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000009")) {

                Principal_ventas_facturas_9 vf9;
                vf9 = new Principal_ventas_facturas_9(new javax.swing.JDialog(), true);
                vf9.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000010")) {

                Principal_ventas_surc_10 vf10;
                vf10 = new Principal_ventas_surc_10(new javax.swing.JDialog(), true);
                vf10.setVisible(true);

            }

            //11
            if (Principal.lbl_usu_almacen.getText().equals("0000011")) {

                Principal_ventas_surc_11 vf11;
                vf11 = new Principal_ventas_surc_11(new javax.swing.JDialog(), true);
                vf11.setVisible(true);

            }

            //santa rita
            if (Principal.lbl_usu_almacen.getText().equals("0000014")) {

                Principal_ventas_facturas_14 vf14;
                vf14 = new Principal_ventas_facturas_14(new javax.swing.JDialog(), true);
                vf14.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000016")) {

                Principal_ventas_facturas_16 vf16;
                vf16 = new Principal_ventas_facturas_16(new javax.swing.JDialog(), true);
                vf16.setVisible(true);

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000018")) {

                Principal_ventas_facturas_18 vf18;
                vf18 = new Principal_ventas_facturas_18(new javax.swing.JDialog(), true);
                vf18.setVisible(true);

            }
            //11

            if (Principal.lbl_usu_almacen.getText().equals("0000021")) {

                Principal_ventas_facturas_21 vf21;
                vf21 = new Principal_ventas_facturas_21(new javax.swing.JDialog(), true);
                vf21.setVisible(true);

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000022")) {

                Principal_ventas_surc_22 vf22;
                vf22 = new Principal_ventas_surc_22(new javax.swing.JDialog(), true);
                vf22.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000023")) {

                Principal_ventas_facturas_23 vf23;
                vf23 = new Principal_ventas_facturas_23(new javax.swing.JDialog(), true);
                vf23.setVisible(true);

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000024")) {

                Principal_ventas_facturas_24 vf24;
                vf24 = new Principal_ventas_facturas_24(new javax.swing.JDialog(), true);
                vf24.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000026")) {

                Principal_ventas_facturas_26 vf26;
                vf26 = new Principal_ventas_facturas_26(new javax.swing.JDialog(), true);
                vf26.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000019")) {

                Principal_ventas_surc_19 vf19;
                vf19 = new Principal_ventas_surc_19(new javax.swing.JDialog(), true);
                vf19.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000027")) {

                Principal_ventas_facturas_27 vf27;
                vf27 = new Principal_ventas_facturas_27(new javax.swing.JDialog(), true);
                vf27.setVisible(true);

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000006")) {

                Principal_ventas_facturas_6 vf6;
                vf6 = new Principal_ventas_facturas_6(new javax.swing.JDialog(), true);
                vf6.setVisible(true);

            }

        }

    }//GEN-LAST:event_menu_facturasActionPerformed

    private void menu_bancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_bancosActionPerformed
        Bancos ban;
        ban = new Bancos(new javax.swing.JDialog(), true);
        ban.setVisible(true);
    }//GEN-LAST:event_menu_bancosActionPerformed

    private void menu_lucro_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_lucro_userActionPerformed
        ventas_lucro_users lucr;
        lucr = new ventas_lucro_users(new javax.swing.JDialog(), true);
        lucr.setVisible(true);
    }//GEN-LAST:event_menu_lucro_userActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        pro_codbar codbar;
        codbar = new pro_codbar(new javax.swing.JDialog(), true);
        codbar.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String grado = lbl_class.getText();
        String nivel = ("5");

        int des = Integer.parseInt(grado);
        int nv = Integer.parseInt(nivel);
        if (des > nv) {
            Ajuste_stock_manual ecv;
            ecv = new Ajuste_stock_manual(new javax.swing.JDialog(), true);
            ecv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No cuenta con autorización");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Principal_transferencia altrans;
        altrans = new Principal_transferencia(new javax.swing.JDialog(), true);
        altrans.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Pro_con_stock cs;
        cs = new Pro_con_stock(new javax.swing.JDialog(), true);
        cs.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        ventas_anteriores_tarjeta evs;
        evs = new ventas_anteriores_tarjeta(new javax.swing.JDialog(), true);
        evs.setVisible(true);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        mov_geral_espe cve;
        cve = new mov_geral_espe(new javax.swing.JDialog(), true);
        cve.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Historico_Surcusales hs;
        hs = new Historico_Surcusales(new javax.swing.JDialog(), true);
        hs.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void menu_recibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_recibosActionPerformed
        Principal_recibos prec;
        prec = new Principal_recibos(new javax.swing.JDialog(), true);
        prec.setVisible(true);
        /*  Excell_pro xprec;
         xprec = new Excell_pro(new javax.swing.JDialog(), true);
         xprec.setVisible(true);*/
    }//GEN-LAST:event_menu_recibosActionPerformed

    private void menu_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_pedidosActionPerformed
        try {
            Principal_Pedidos pped;
            pped = new Principal_Pedidos(new javax.swing.JDialog(), true);
            pped.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_pedidosActionPerformed

    private void menu_egresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_egresoActionPerformed
        Principapl_gastos pg;
        pg = new Principapl_gastos(new javax.swing.JDialog(), true);
        pg.setVisible(true);
    }//GEN-LAST:event_menu_egresoActionPerformed

    private void menu_presupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_presupuestoActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_surcu_presupuesto sa = new Seleccion_surcu_presupuesto(new javax.swing.JDialog(), true);
            sa.setVisible(true);

        } else {

            if (Principal.lbl_usu_almacen.getText().equals("0000001")) {

                Principal_presupuesto pp = null;
                try {
                    pp = new Principal_presupuesto(new javax.swing.JDialog(), true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                pp.setVisible(true);

            }

            //2
            if (Principal.lbl_usu_almacen.getText().equals("0000002")) {

                try {
                    Principal_presupuesto_franco pf = new Principal_presupuesto_franco(new javax.swing.JDialog(), true);
                    pf.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000016")) {

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000018")) {

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000020")) {

            }

        }


    }//GEN-LAST:event_menu_presupuestoActionPerformed

    private void menu_devolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_devolucionActionPerformed

        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_devol_surc ds = new Seleccion_devol_surc(new javax.swing.JDialog(), true);
            ds.setVisible(true);

        } else {

            if (Principal.lbl_usu_almacen.getText().equals("0000001")) {

                Principal_devoluciones pv;
                pv = new Principal_devoluciones(new javax.swing.JDialog(), true);
                pv.setVisible(true);

            }

            //2
            if (Principal.lbl_usu_almacen.getText().equals("0000002")) {

                Principal_devoluciones_franco pvf;
                pvf = new Principal_devoluciones_franco(new javax.swing.JDialog(), true);
                pvf.setVisible(true);

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000016")) {

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000018")) {
                Principal_devoluciones_18 pv18;
                pv18 = new Principal_devoluciones_18(new javax.swing.JDialog(), true);
                pv18.setVisible(true);
            }
            if (Principal.lbl_usu_almacen.getText().equals("0000020")) {

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000024")) {
                Principal_devoluciones_24 pvf4;
                pvf4 = new Principal_devoluciones_24(new javax.swing.JDialog(), true);
                pvf4.setVisible(true);
            }

        }


    }//GEN-LAST:event_menu_devolucionActionPerformed

    private void menu_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_comprasActionPerformed
        Principal_compras pc;
        pc = new Principal_compras(new javax.swing.JDialog(), true);
        pc.setVisible(true);
    }//GEN-LAST:event_menu_comprasActionPerformed

    private void menu_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ventasActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_alma_ventas sa = new Seleccion_alma_ventas(new javax.swing.JDialog(), true);
            sa.setVisible(true);

        } else {

            if (Principal.lbl_usu_almacen.getText().equals("0000001")) {

                try {
                    Principal_ventas pv = new Principal_ventas(new javax.swing.JDialog(), true);
                    pv.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //2
            if (Principal.lbl_usu_almacen.getText().equals("0000002")) {

                try {
                    Principal_ventas_2 pv_2 = new Principal_ventas_2(new javax.swing.JDialog(), true);
                    pv_2.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //3
            if (Principal.lbl_usu_almacen.getText().equals("0000003")) {

                try {
                    Principal_ventas_3 pv_3 = new Principal_ventas_3(new javax.swing.JDialog(), true);
                    pv_3.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //4
            if (Principal.lbl_usu_almacen.getText().equals("0000004")) {

                try {
                    Principal_ventas_4 pv_4 = new Principal_ventas_4(new javax.swing.JDialog(), true);
                    pv_4.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //
            if (Principal.lbl_usu_almacen.getText().equals("0000005")) {

                try {
                    Principal_ventas_5 pv_5 = new Principal_ventas_5(new javax.swing.JDialog(), true);
                    pv_5.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //6
            if (Principal.lbl_usu_almacen.getText().equals("0000006")) {

                try {
                    Principal_ventas_6 pv_6 = new Principal_ventas_6(new javax.swing.JDialog(), true);
                    pv_6.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //07
            if (Principal.lbl_usu_almacen.getText().equals("0000007")) {

                try {
                    Principal_ventas_7 pv_7 = new Principal_ventas_7(new javax.swing.JDialog(), true);
                    pv_7.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //8
            if (Principal.lbl_usu_almacen.getText().equals("0000008")) {

                try {
                    Principal_ventas_8 pv_8 = new Principal_ventas_8(new javax.swing.JDialog(), true);
                    pv_8.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //9
            if (Principal.lbl_usu_almacen.getText().equals("0000009")) {

                try {
                    Principal_ventas_9 pv_9 = new Principal_ventas_9(new javax.swing.JDialog(), true);
                    pv_9.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //10
            if (Principal.lbl_usu_almacen.getText().equals("0000010")) {

                try {
                    Principal_ventas_10 pv_10 = new Principal_ventas_10(new javax.swing.JDialog(), true);
                    pv_10.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000011")) {

                try {
                    Principal_ventas_11 pv_11 = new Principal_ventas_11(new javax.swing.JDialog(), true);
                    pv_11.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //12
            if (Principal.lbl_usu_almacen.getText().equals("0000012")) {

                try {
                    Principal_ventas_12 pv_12 = new Principal_ventas_12(new javax.swing.JDialog(), true);
                    pv_12.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //13
            if (Principal.lbl_usu_almacen.getText().equals("0000013")) {

                try {
                    Principal_ventas_13 pv_13 = new Principal_ventas_13(new javax.swing.JDialog(), true);
                    pv_13.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //14
            if (Principal.lbl_usu_almacen.getText().equals("0000014")) {

                try {
                    Principal_ventas_14 pv_14 = new Principal_ventas_14(new javax.swing.JDialog(), true);
                    pv_14.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            //15
            if (Principal.lbl_usu_almacen.getText().equals("0000015")) {

                try {
                    Principal_ventas_15 pv_15 = new Principal_ventas_15(new javax.swing.JDialog(), true);
                    pv_15.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            //16
            if (Principal.lbl_usu_almacen.getText().equals("0000016")) {

                try {
                    Principal_ventas_16 pv = new Principal_ventas_16(new javax.swing.JDialog(), true);
                    pv.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //17
            if (Principal.lbl_usu_almacen.getText().equals("0000017")) {

                try {
                    Principal_ventas_17 pv_17 = new Principal_ventas_17(new javax.swing.JDialog(), true);
                    pv_17.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //18
            if (Principal.lbl_usu_almacen.getText().equals("0000018")) {

                try {
                    Principal_ventas_18 pv_18 = new Principal_ventas_18(new javax.swing.JDialog(), true);
                    pv_18.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //19
            if (Principal.lbl_usu_almacen.getText().equals("0000019")) {

                try {
                    Principal_ventas_19 pv_19 = new Principal_ventas_19(new javax.swing.JDialog(), true);
                    pv_19.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //20
            if (Principal.lbl_usu_almacen.getText().equals("0000020")) {

                try {
                    Principal_ventas_20 pv_20 = new Principal_ventas_20(new javax.swing.JDialog(), true);
                    pv_20.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //21
            if (Principal.lbl_usu_almacen.getText().equals("0000021")) {

                try {
                    Principal_ventas_21 pv_21 = new Principal_ventas_21(new javax.swing.JDialog(), true);
                    pv_21.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            //22
            if (Principal.lbl_usu_almacen.getText().equals("0000022")) {

                try {
                    Principal_ventas_22 pv_22 = new Principal_ventas_22(new javax.swing.JDialog(), true);
                    pv_22.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //23
            if (Principal.lbl_usu_almacen.getText().equals("0000023")) {

                try {
                    Principal_ventas_23 pv_23 = new Principal_ventas_23(new javax.swing.JDialog(), true);
                    pv_23.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            //24
            if (Principal.lbl_usu_almacen.getText().equals("0000024")) {

                try {
                    Principal_ventas_24 pv_24 = new Principal_ventas_24(new javax.swing.JDialog(), true);
                    pv_24.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            //25
            if (Principal.lbl_usu_almacen.getText().equals("0000025")) {

                try {
                    Principal_ventas_25 pv_25 = new Principal_ventas_25(new javax.swing.JDialog(), true);
                    pv_25.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000026")) {

                try {
                    Principal_ventas_26 pv_26 = new Principal_ventas_26(new javax.swing.JDialog(), true);
                    pv_26.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (Principal.lbl_usu_almacen.getText().equals("0000027")) {

                try {
                    Principal_ventas_27 pv_27 = new Principal_ventas_27(new javax.swing.JDialog(), true);
                    pv_27.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            
               if (Principal.lbl_usu_almacen.getText().equals("0000028")) {

                try {
                    Principal_ventas_28 pv_28 = new Principal_ventas_28(new javax.swing.JDialog(), true);
                    pv_28.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_menu_ventasActionPerformed

    private void menu_os_prin_osActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_os_prin_osActionPerformed
        Principapl_OS gr;
        gr = new Principapl_OS(new javax.swing.JDialog(), true);
        gr.setVisible(true);
    }//GEN-LAST:event_menu_os_prin_osActionPerformed

    private void menu_recibo_fiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_recibo_fiscActionPerformed

        try {
            Principal_recibo_fisc rf;
            rf = new Principal_recibo_fisc(new javax.swing.JDialog(), true);
            rf.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_menu_recibo_fiscActionPerformed

    private void menu_nota_creActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nota_creActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_devFiscall_sucursales sa = new Seleccion_devFiscall_sucursales(new javax.swing.JDialog(), true);
            sa.setVisible(true);

        } else {

            if (Principal.lbl_usu_almacen.getText().equals("0000001")) {

                Principal_Devol_surc_fiscal vf1;
                vf1 = new Principal_Devol_surc_fiscal(new javax.swing.JDialog(), true);
                vf1.setVisible(true);

            }

            //2
            if (Principal.lbl_usu_almacen.getText().equals("0000002")) {
                Principal_Devol_surc_2 df;
                df = new Principal_Devol_surc_2(new javax.swing.JDialog(), true);
                df.setVisible(true);// TODO add your handling code here:
            }

            //11
            if (Principal.lbl_usu_almacen.getText().equals("0000011")) {

            }

            //11
            if (Principal.lbl_usu_almacen.getText().equals("0000022")) {

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000023")) {

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000024")) {

                Principal_Devol_surc_24 vf24;
                vf24 = new Principal_Devol_surc_24(new javax.swing.JDialog(), true);
                vf24.setVisible(true);

            }
        }

    }//GEN-LAST:event_menu_nota_creActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        Principal_fabrica dfi;
        dfi = new Principal_fabrica(new javax.swing.JDialog(), true);
        dfi.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void menu_salida_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_salida_stockActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("0000001") || Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            String grado = lbl_class.getText();
            String nivel = ("5");

            int des = Integer.parseInt(grado);
            int nv = Integer.parseInt(nivel);
            if (des > nv) {
                Salidas_productos_cate ss;
                ss = new Salidas_productos_cate(new javax.swing.JDialog(), true);
                ss.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No cuenta con autorización");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Listado solo disponible para el establecimineto principal");
        }
    }//GEN-LAST:event_menu_salida_stockActionPerformed

    private void botton_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botton_configActionPerformed
        panel_config_gral.setVisible(true);
    }//GEN-LAST:event_botton_configActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        String grado = lbl_class.getText();
        String nivel = ("6");

        int des = Integer.parseInt(grado);
        int nv = Integer.parseInt(nivel);
        if (des > nv) {
            Ajuste_stock_manual ecv;
            ecv = new Ajuste_stock_manual(new javax.swing.JDialog(), true);
            ecv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No cuenta con autorización");
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed

        Principal_factura_expo expo;
        expo = new Principal_factura_expo(new javax.swing.JDialog(), true);
        expo.setVisible(true);

        /*
         if (java.awt.Desktop.isDesktopSupported()) {
         java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
         if (desktop.isSupported(Desktop.Action.BROWSE)) {
         try {
         java.net.URI uri = new java.net.URI("https://anydesk.com/es/downloads/windows");
         try {
         desktop.browse(uri);

         } catch (IOException ex) {
         Logger.getLogger(Categorias.class
         .getName()).log(Level.SEVERE, null, ex);
         }

         } catch (URISyntaxException ex) {
         Logger.getLogger(Principal.class
         .getName()).log(Level.SEVERE, null, ex);
         }
         }
         }
         */
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        Tama_Principal tama;
        tama = new Tama_Principal(new javax.swing.JDialog(), true);
        tama.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void menu_lucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_lucroActionPerformed
        String grado = lbl_class.getText();
        String nivel = ("6");

        int des = Integer.parseInt(grado);
        int nv = Integer.parseInt(nivel);
        if (des >= nv) {
            Seleccion_relatorio_lucro_cli lucro_ventas;
            lucro_ventas = new Seleccion_relatorio_lucro_cli(new javax.swing.JDialog(), true);
            lucro_ventas.setVisible(true);
        }
    }//GEN-LAST:event_menu_lucroActionPerformed

    private void menu_lucro_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_lucro_proActionPerformed
        ventas_lucro_departamento vld;
        vld = new ventas_lucro_departamento(new javax.swing.JDialog(), true);
        vld.setVisible(true);
    }//GEN-LAST:event_menu_lucro_proActionPerformed

    private void menu_libro_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_libro_comprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_libro_comprasActionPerformed

    private void menu_libro_compras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_libro_compras1ActionPerformed
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_surc_devol_list_fis snc = new Seleccion_surc_devol_list_fis(new javax.swing.JDialog(), true);
            snc.setVisible(true);

        } else {

            if (Principal.lbl_usu_almacen.getText().equals("0000001")) {

                Libro_nota_cre_lista lncf;
                lncf = new Libro_nota_cre_lista(new javax.swing.JDialog(), true);
                lncf.setVisible(true);

            }

            //2
            if (Principal.lbl_usu_almacen.getText().equals("0000002")) {
                Libro_nota_cre_lista_surc_2 lnc2;
                lnc2 = new Libro_nota_cre_lista_surc_2(new javax.swing.JDialog(), true);
                lnc2.setVisible(true);// TODO add your handling code here:
            }

            //11
            if (Principal.lbl_usu_almacen.getText().equals("0000011")) {

            }

            //11
            if (Principal.lbl_usu_almacen.getText().equals("0000022")) {

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000023")) {

            }

            if (Principal.lbl_usu_almacen.getText().equals("0000024")) {

            }
        }


    }//GEN-LAST:event_menu_libro_compras1ActionPerformed

    private void menu_libro_compras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_libro_compras2ActionPerformed
        Libro_recibo_fisc lrf;
        lrf = new Libro_recibo_fisc(new javax.swing.JDialog(), true);
        lrf.setVisible(true);
    }//GEN-LAST:event_menu_libro_compras2ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed

        Cuentas_recibir_ventas crv;
        crv = new Cuentas_recibir_ventas(new javax.swing.JDialog(), true);
        crv.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        Cuentas_recibir cr;
        cr = new Cuentas_recibir(new javax.swing.JDialog(), true);
        cr.setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        Listado_marcas_pro lmp;
        lmp = new Listado_marcas_pro(new javax.swing.JDialog(), true);
        lmp.setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        ventas_anteriores_usuarios ventas_usu;
        ventas_usu = new ventas_anteriores_usuarios(new javax.swing.JDialog(), true);
        ventas_usu.setVisible(true);

    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        Ventas_report_all va;
        va = new Ventas_report_all(new javax.swing.JDialog(), true);
        va.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        ventas_anteriores_tarjeta evs;
        evs = new ventas_anteriores_tarjeta(new javax.swing.JDialog(), true);
        evs.setVisible(true);

    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Caja_Class_historicos cch;
        cch = new Caja_Class_historicos(new javax.swing.JDialog(), true);
        cch.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        Listado_bancos_recibos lrb;
        lrb = new Listado_bancos_recibos(new javax.swing.JDialog(), true);
        lrb.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Principal().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBL_HORA_SERVER;
    private javax.swing.JButton botton_config;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lbl_año_actual;
    public static javax.swing.JLabel lbl_class;
    public static javax.swing.JLabel lbl_control_minimo;
    public static javax.swing.JLabel lbl_cuenta_user;
    private javax.swing.JLabel lbl_des_serial;
    public static javax.swing.JLabel lbl_dia_actual;
    public static javax.swing.JLabel lbl_empresa;
    public static javax.swing.JLabel lbl_fecha_hoy;
    public static javax.swing.JLabel lbl_fecha_principal;
    private javax.swing.JLabel lbl_hora_server;
    public static javax.swing.JLabel lbl_id_empre;
    public static javax.swing.JLabel lbl_id_user;
    private javax.swing.JLabel lbl_img_empre;
    private javax.swing.JLabel lbl_licencia;
    public static javax.swing.JLabel lbl_lote_activa;
    public static javax.swing.JLabel lbl_mes_actual;
    public static javax.swing.JLabel lbl_mod_factura;
    public static javax.swing.JLabel lbl_mode_dark;
    public static javax.swing.JLabel lbl_model_lucro;
    public static javax.swing.JLabel lbl_mone_def;
    private javax.swing.JLabel lbl_notifi_pedidos;
    public static javax.swing.JLabel lbl_panel_pre_usu;
    public static javax.swing.JLabel lbl_periodo_fiscal;
    public static javax.swing.JLabel lbl_pre_b;
    public static javax.swing.JLabel lbl_pre_c;
    public static javax.swing.JLabel lbl_serie_empre;
    public static javax.swing.JLabel lbl_tipo;
    public static javax.swing.JLabel lbl_usu_almacen;
    public static javax.swing.JLabel lbl_usu_caj_rap;
    public static javax.swing.JLabel lbl_usu_nom;
    public static javax.swing.JLabel lbl_ventas_usu_ss;
    private javax.swing.JLabel lbl_version;
    private javax.swing.JMenuItem menu_bancos;
    public static javax.swing.JMenuItem menu_caja;
    public static javax.swing.JMenuItem menu_cambios;
    private javax.swing.JMenuItem menu_cat_espec;
    private javax.swing.JMenuItem menu_categ;
    public static javax.swing.JMenu menu_clientes;
    private javax.swing.JMenuItem menu_colores;
    public static javax.swing.JMenuItem menu_compras;
    public static javax.swing.JMenuItem menu_config;
    public static javax.swing.JMenuItem menu_copia;
    public static javax.swing.JMenuItem menu_cuentas;
    private javax.swing.JMenuItem menu_departa;
    public static javax.swing.JMenuItem menu_devolucion;
    public static javax.swing.JMenuItem menu_egreso;
    public static javax.swing.JMenu menu_esta_compras;
    public static javax.swing.JMenu menu_esta_devoluciones;
    public static javax.swing.JMenu menu_esta_stock;
    public static javax.swing.JMenu menu_esta_ventas;
    private javax.swing.JMenuItem menu_facturas;
    private javax.swing.JMenu menu_facturas_prin;
    public static javax.swing.JMenuItem menu_historicos;
    public static javax.swing.JMenu menu_inicio;
    private javax.swing.JMenuItem menu_libro_compras;
    private javax.swing.JMenuItem menu_libro_compras1;
    private javax.swing.JMenuItem menu_libro_compras2;
    public static javax.swing.JMenuItem menu_licencia;
    private javax.swing.JMenuItem menu_list_compras;
    private javax.swing.JMenuItem menu_list_cp;
    private javax.swing.JMenuItem menu_list_devol;
    private javax.swing.JMenuItem menu_list_dto;
    private javax.swing.JMenuItem menu_list_fisico;
    private javax.swing.JMenuItem menu_list_venta;
    public static javax.swing.JMenu menu_listado_mov;
    public static javax.swing.JMenu menu_logistica;
    private javax.swing.JMenuItem menu_lucro;
    private javax.swing.JMenuItem menu_lucro_pro;
    private javax.swing.JMenuItem menu_lucro_user;
    private javax.swing.JMenuItem menu_nota_cre;
    private javax.swing.JMenu menu_os_prin;
    public static javax.swing.JMenuItem menu_os_prin_os;
    private javax.swing.JMenuItem menu_pedidos;
    public static javax.swing.JMenuItem menu_presupuesto;
    public static javax.swing.JMenu menu_producto;
    private javax.swing.JMenuItem menu_productos;
    public static javax.swing.JMenu menu_proveedor;
    private javax.swing.JMenuItem menu_razon_pro;
    private javax.swing.JMenuItem menu_recibo_fisc;
    private javax.swing.JMenuItem menu_recibos;
    private javax.swing.JMenu menu_reporte_fiscal;
    private javax.swing.JMenuItem menu_salida_stock;
    private javax.swing.JMenu menu_serv;
    private javax.swing.JMenuItem menu_sub_cat;
    private javax.swing.JMenu menu_surcusales;
    public static javax.swing.JMenuItem menu_transferencia;
    public static javax.swing.JMenu menu_usuario;
    private javax.swing.JMenuItem menu_venta_estad;
    private javax.swing.JMenuItem menu_venta_lucro;
    private javax.swing.JMenuItem menu_venta_usu;
    public static javax.swing.JMenuItem menu_ventas;
    public static javax.swing.JPanel panel_config_gral;
    private javax.swing.JPanel panel_principal;
    public static javax.swing.JLabel txt_act_vuelto;
    private javax.swing.JLabel txt_compra_fiscal;
    public static javax.swing.JLabel txt_dir_backup;
    public static javax.swing.JLabel txt_fecha_backup;
    public static javax.swing.JLabel txt_hora_act;
    public static javax.swing.JLabel txt_model_ticket;
    public static javax.swing.JLabel txt_modelo_ventas;
    private javax.swing.JLabel txt_nro_sucursal;
    public static javax.swing.JLabel txt_simbolo;
    private javax.swing.JLabel version_alerta;
    // End of variables declaration//GEN-END:variables

//<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">
    //<editor-fold defaultstate="collapsed" desc="EL ORO CU´I">
    public void ValidarCampoTexto_NoEspacioNoNumeroNoLetra(java.awt.event.KeyEvent Evento, int Signal) {
        //<editor-fold defaultstate="collapsed" desc=" ZONA DE VAR LOCAL ">        
        Character TeclaPresionada = Evento.getKeyChar();
        //</editor-fold>        
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (TeclaPresionada.toString().equals(".")) {
            //NOTHING...
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="NODO">
            if (Signal == 1) {
                //<editor-fold defaultstate="collapsed" desc=" DENEGA ACCESO DE NUMEROS Y ESPACIO EN BLANCO">
                //|| TeclaPresionada.isSpaceChar( TeclaPresionada )
                if (Character.isDigit(TeclaPresionada)) {
                    Evento.consume();
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            else {
                //<editor-fold defaultstate="collapsed" desc=" DENEGA ACCESO DE ESPACIO EN BLANCO Y DELETE BUTTON ">
                if ((Character.isSpaceChar(TeclaPresionada)
                        || TeclaPresionada == Evento.VK_DELETE
                        || Character.isLetter(TeclaPresionada))
                        && Signal != 7) {
                    Evento.consume();
                }// FIN IF
                //</editor-fold>
            }// FIN ELSE
            if (Signal == 7 && Character.isSpaceChar(TeclaPresionada)) {
                //<editor-fold defaultstate="collapsed" desc=" DENEGA ESPACIO EN BLANCO ">
                Evento.consume();
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
        }// FIN ELSE
        //</editor-fold>        
    }// FIN METODO        

    public BigDecimal TransformReales(String NumeroBruto) {
        //SEGURIDAD.-
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (NumeroBruto.replaceAll("\\s", "").isEmpty()) {
            NumeroBruto = "0";
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="IF">
        NumeroBruto = NumeroBruto.replaceAll("\\s", "");
        BigDecimal Convertido = new BigDecimal("0");
        if (NumeroBruto.contains(".")) {
            String ParteEntero = NumeroBruto.substring(0, NumeroBruto.indexOf("."));
            String ParteFracciones = NumeroBruto.substring(NumeroBruto.indexOf(".") + 1, NumeroBruto.length());
            //DETERMINAR CANTIDAD DE DECIMAS.-
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ParteFracciones.length() > 3) {
                ParteFracciones = ParteFracciones.substring(0, 3);
            }// FIN IF
            //</editor-fold>
            ParteEntero = ParteEntero.replaceAll("\\s", "").replaceAll("[^0-9]", "");
            String Unity = ParteEntero + "." + ParteFracciones;
            Convertido = new BigDecimal(Unity);
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            Convertido = new BigDecimal(NumeroBruto.replaceAll("[^0-9]", ""));
        }// FIN ELSE
        //</editor-fold>
        return Convertido;
    }// FIN 1º METODO    

    public String MaskareaRealesDado_String_Hibrid_MedidasMonedas(String ValorBruto) {
        String ReadyMasketed = "0";
        ValorBruto = ValorBruto.replaceAll("\\s", "");
        int Tot = ValorBruto.length();
        //<editor-fold defaultstate="collapsed" desc="IF">
        if ( //<editor-fold defaultstate="collapsed" desc="AVOIDING ZERO">
                (Tot == 0
                && ValorBruto.equals("0"))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING ,(COMA)">
                (Tot == 0
                && ValorBruto.equals(","))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING .(DECIMAL POINT, INCEPTION)">
                (Tot == 0
                && ValorBruto.equals(".")) //</editor-fold>        
                ) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ValorBruto.replaceAll("\\s", "").isEmpty() || ValorBruto.replaceAll("\\s", "").equals("-")) {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (ValorBruto.replaceAll("\\s", "").equals("-")) {
                    return "-";
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (!ValorBruto.replaceAll("\\s", "").contains(".")) {
                    ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
                }// FIN IF
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="ELSE">
                else {
                    String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                    String WholePartFormated = MaskaraEnteros(WholePart);
                    String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (FractionalPart.length() > 3) {
                        FractionalPart = FractionalPart.substring(0, 3);
                    }// FIN IF
                    //</editor-fold>
                    ReadyMasketed = WholePartFormated + "." + FractionalPart;
                }// FIN ELSE
                //</editor-fold>                    
            }// FIN ELSE
            //</editor-fold>        
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO        

    public String MaskareaRealesDado_String_ExclusiveMonedas(String ValorBruto) {
        String ReadyMasketed = "0";
        ValorBruto = ValorBruto.replaceAll("\\s", "");
        int Tot = ValorBruto.length();
        //<editor-fold defaultstate="collapsed" desc="IF">
        if ( //<editor-fold defaultstate="collapsed" desc="AVOIDING ZERO">
                (Tot == 0
                && ValorBruto.equals("0"))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING ,(COMA)">
                (Tot == 0
                && ValorBruto.equals(","))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING .(DECIMAL POINT, INCEPTION)">
                (Tot == 0
                && ValorBruto.equals(".")) //</editor-fold>        
                ) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ValorBruto.replaceAll("\\s", "").isEmpty() || ValorBruto.replaceAll("\\s", "").equals("-")) {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (ValorBruto.replaceAll("\\s", "").equals("-")) {
                    return "-";
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (!ValorBruto.replaceAll("\\s", "").contains(".")) {
                    ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
                }// FIN IF
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="ELSE">
                else {
                    String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                    String WholePartFormated = MaskaraEnteros(WholePart);
                    String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (FractionalPart.length() > 2) {
                        FractionalPart = FractionalPart.substring(0, 2);
                    }// FIN IF
                    else {
                        if (FractionalPart.length() < 2 && !FractionalPart.equals("0")) {
                            ReadyMasketed = WholePartFormated + "." + FractionalPart + "0";
                        }// FIN IF
                        else {
                            if (FractionalPart.length() == 2) {
                                ReadyMasketed = WholePartFormated + "." + FractionalPart;
                            }
                        }// FIN IF    
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="IF"                    //String PrimerDecimal = FractionalPart.substring(0, 1).replaceAll("\\s", "");
                    //if
                    //( 
                    //    PrimerDecimal.equals("0") 
                    //) 
                    //{
                    //    ReadyMasketed = WholePartFormated;
                    //}// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="ELSE">
                    //else 
                    //{
                    //ReadyMasketed = WholePartFormated+"."+FractionalPart;                        
                    //}// FIN ELSE
                    //</editor-fold>  
                }// FIN ELSE
                //</editor-fold>                    
            }// FIN ELSE
            //</editor-fold>        
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO             

    public String MaskareaRealesDado_String_ExclusiveMedidas(String ValorBruto) {
        String ReadyMasketed = "0";
        ValorBruto = ValorBruto.replaceAll("\\s", "");
        int Tot = ValorBruto.length();
        //<editor-fold defaultstate="collapsed" desc="IF">
        if ( //<editor-fold defaultstate="collapsed" desc="AVOIDING ZERO">
                (Tot == 0
                && ValorBruto.equals("0"))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING ,(COMA)">
                (Tot == 0
                && ValorBruto.equals(","))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING .(DECIMAL POINT, INCEPTION)">
                (Tot == 0
                && ValorBruto.equals(".")) //</editor-fold>        
                ) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ValorBruto.replaceAll("\\s", "").isEmpty() || ValorBruto.replaceAll("\\s", "").equals("-")) {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (ValorBruto.replaceAll("\\s", "").equals("-")) {
                    return "-";
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (!ValorBruto.replaceAll("\\s", "").contains(".")) {
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (ValorBruto.contains("E")) {
                        ReadyMasketed = "0";
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="ELSE">
                    else {
                        ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
                    }// FIN ELSE
                    //</editor-fold>                    
                }// FIN IF
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="ELSE">
                else {
                    String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                    String WholePartFormated = MaskaraEnteros(WholePart);
                    String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (FractionalPart.length() > 3) {
                        FractionalPart = FractionalPart.substring(0, 3);
                    }// FIN IF
                    //</editor-fold>
                    // DOS DECIMAL EXTRACT.-
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    int TotaDecimals = FractionalPart.length();
                    String PrimerDecimal = FractionalPart.substring(0, 1).replaceAll("\\s", "");
                    String SegDecimal = "";
                    if (TotaDecimals > 1 && TotaDecimals < 3) {
                        SegDecimal = FractionalPart.substring(1, 2).replaceAll("\\s", "");
                        //<editor-fold defaultstate="collapsed" desc="IF">
                        if (PrimerDecimal.equals("0")
                                && SegDecimal.equals("0")) {
                            ReadyMasketed = WholePartFormated;
                        }// FINIF 
                        //</editor-fold>                                
                        //<editor-fold defaultstate="collapsed" desc="ELSE">
                        else {
                            ReadyMasketed = WholePartFormated + "." + FractionalPart;
                        }// FIN ELSE
                        //</editor-fold>                                                 
                    }// FIN IF
                    //</editor-fold>                         
                    // UN DECIMAL EXTRACT.-
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (PrimerDecimal.equals("0")
                            && TotaDecimals < 2) {
                        ReadyMasketed = WholePartFormated;
                    }// FINIF 
                    //</editor-fold>                                
                    //<editor-fold defaultstate="collapsed" desc="ELSE">
                    else {
                        ReadyMasketed = WholePartFormated + "." + FractionalPart;
                    }// FIN ELSE
                    //</editor-fold>                       
                }// FIN ELSE
                //</editor-fold>                    
            }// FIN ELSE
            //</editor-fold>        
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO          

    public String MaskareaRealesDado_BigDecimal(BigDecimal ValorBruto) {
        String ReadyMasketed = "0";
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (ValorBruto.toString().replaceAll("\\s", "").length() == 1 && (ValorBruto.equals(".") || ValorBruto.equals(","))) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (!ValorBruto.toString().replaceAll("\\s", "").contains(".")) {
                ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                String WholePartFormated = MaskaraEnteros(WholePart);
                String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (FractionalPart.length() > 3) {
                    FractionalPart = FractionalPart.substring(0, 3);
                }// FIN IF
                //</editor-fold>
                ReadyMasketed = WholePartFormated + "." + FractionalPart;
            }// FIN ELSE
            //</editor-fold>            
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO    

    public String MaskareaRealesDadoCampoTexto(JFormattedTextField CampoSelected, java.awt.event.KeyEvent evt) {
        String DigitedText = CampoSelected.getText().replaceAll("\\s", "");
        String ReadyMasketed = "";
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (!DigitedText.contains(".")) {
            CampoSelected.setText(MaskaraEnteros(DigitedText));
            ReadyMasketed = MaskaraEnteros(DigitedText);
            CampoSelected.setCaretPosition(CampoSelected.getText().length());
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            String WholePart = DigitedText.substring(0, DigitedText.indexOf("."));
            String WholePartFormated = MaskaraEnteros(WholePart);
            String FractionalPart = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (FractionalPart.length() > 3) {
                FractionalPart = FractionalPart.substring(0, 3);
            }// FIN IF
            //</editor-fold>
            CampoSelected.setText(WholePartFormated + "." + FractionalPart);
            ReadyMasketed = WholePartFormated + "." + FractionalPart;
            CampoSelected.setCaretPosition(CampoSelected.getText().length());
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO

    public String MaskaraEnteros(String ValorGuaranies) {
        //<editor-fold defaultstate="collapsed" desc="IF">        
        ValorGuaranies = ValorGuaranies.replaceAll("\\s", "");
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
        NumeroIntacto = Long.valueOf(Puro).longValue();
        NroFormatado = Formato.format(NumeroIntacto);
        String ReadyToExhibit = NroFormatado;
        ReadyToExhibit = ReadyToExhibit.replace(".", ",");
        return ReadyToExhibit;
    }// FIN METODO
    //</editor-fold>    
    //</editor-fold>

    void cargarUsu(String cod) {

        String mostrar = "select * from usuarios WHERE usu_cod='" + cod + "'";
        lbl_id_user.setText(cod);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_usu_nom.setText(rs.getString(2));
                lbl_tipo.setText(rs.getString(4));
                lbl_class.setText(rs.getString(5));
                lbl_usu_almacen.setText(rs.getString(6));
                txt_nro_sucursal.setText(rs.getString(6));
                lbl_panel_pre_usu.setText(rs.getString(9));
                lbl_pre_b.setText(rs.getString(10));
                lbl_pre_c.setText(rs.getString(11));
                lbl_cuenta_user.setText(rs.getString(7));
                lbl_ventas_usu_ss.setText(rs.getString(12));
                lbl_usu_caj_rap.setText(rs.getString(13));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar() {
        String mostrar = "SELECT * FROM serial";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_licencia.setText(rs.getString(2));
                lbl_des_serial.setText(rs.getString(3));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(empre_config_serial.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void licencia() {

        /*  DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         LocalDate fecha = LocalDate.parse(lbl_licencia.getText(), date);
         LocalDate fechaD = LocalDate.now();
         Period periodo = Period.between(fecha, fechaD);
         String data = (periodo.getDays() + "-" + periodo.getMonths() + "-" + periodo.getYears());
         lbl_fecha_fin.setText(data);
         String limite = ("0-0-0");
         String fecha_hoy = lbl_fecha_principal.getText().replaceAll("/", "");
         String fecha_vence = lbl_licencia.getText().replaceAll("-", "");
         int pv = Integer.parseInt(fecha_hoy);
         int pm = Integer.parseInt(fecha_vence);

         if (pv > pm) {
         String serial = ("BLOQUEADO");
         int id = 1;

         try {
         PreparedStatement pst = cn.prepareStatement("UPDATE serial SET serial_des='"
         + serial + "' WHERE id_serial='" + id + "'");
         pst.executeUpdate();
         //JOptionPane.showMessageDialog(null, "Actualizado");
         } catch (SQLException | HeadlessException e) {
         System.out.print(e.getMessage());
         }
         }*/
    }

    void controlFecha() {

        String ver = lbl_des_serial.getText();
        String serial_control = ("BLOQUEADO");
        if ((ver.equals(serial_control))) {
            JOptionPane.showMessageDialog(this, "Licencia de uso vencida!! por favor contacte al Administrador");
            Pass_seriales pass;
            pass = new Pass_seriales(new javax.swing.JDialog(), true);
            pass.setVisible(true);
            String cant = Pass_seriales.pass_serial.getText();
            String seña = ("canis1993sistema");
            if ((cant.equals("")) || (cant.equals("0"))) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un credencial válido");
                System.exit(0);
            } else {
                if (!cant.equals(seña)) {
                    JOptionPane.showMessageDialog(this, "Ud. no cuenta con autorizacion de uso");
                    System.exit(0);
                } else {

                }
            }
        }
    }

    void cargarConfig() throws IOException {
        String mostrar = "SELECT * FROM empresas";
        ImageIcon foto;
        InputStream is;
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_empresa.setText(rs.getString(2));
                lbl_model_lucro.setText(rs.getString(9));
                txt_model_ticket.setText(rs.getString(8));
                lbl_hora_server.setText(rs.getString(15));
                txt_compra_fiscal.setText(rs.getString(14));
                lbl_control_minimo.setText(rs.getString(17));
                txt_modelo_ventas.setText(rs.getString(18));
                txt_dir_backup.setText(rs.getString(20));
                txt_act_vuelto.setText(rs.getString(23));
                lbl_mone_def.setText(rs.getString(24));
                txt_simbolo.setText(rs.getString(25));
                lbl_serie_empre.setText(rs.getString(16));
                lbl_mod_factura.setText(rs.getString(5));
                lbl_id_empre.setText(rs.getString(1));
                lbl_lote_activa.setText(rs.getString(57));
                is = rs.getBinaryStream(4);
                if (is == null) {
                    System.out.println("imagen vacia");
                } else {
                    
                    BufferedImage bi = ImageIO.read(is);
                    foto = new ImageIcon(bi);
                    Image img = foto.getImage();
                    Image newimg = img.getScaledInstance(80, 60, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(newimg);
                    lbl_img_empre.setIcon(newicon);

                }
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Caja_caja.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void permisos_users(String Gruop) {

        String m1 = "", m2 = "", m3 = "", m4 = "", m5 = "", m6 = "", m7 = "", m8 = "", m9 = "", m10 = "", m11 = "", m12 = "", m13 = "", m14 = "", m15 = "", m16 = "", m17 = "", m18 = "", m19 = "", m20 = "", m21 = "", m22 = "", m23 = "", m24 = "", m25 = "", m26 = "", m27 = "", m28 = "", m29 = "", m30 = "", m31 = "", m32 = "", m33 = "", m34 = "", m35 = "", m36 = "", m37 = "", m38 = "";
        String sql = "SELECT * FROM user_permisos WHERE user_grupo='" + Gruop + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                m1 = rs.getString(3);
                m2 = rs.getString(4);
                m3 = rs.getString(5);
                m4 = rs.getString(6);
                m5 = rs.getString(7);
                m6 = rs.getString(8);
                m7 = rs.getString(9);
                m8 = rs.getString(10);
                m9 = rs.getString(11);
                m10 = rs.getString(12);
                m11 = rs.getString(13);
                m12 = rs.getString(14);
                m13 = rs.getString(15);
                m14 = rs.getString(16);
                m15 = rs.getString(17);
                m16 = rs.getString(18);
                m17 = rs.getString(19);
                m18 = rs.getString(20);
                m19 = rs.getString(21);
                m20 = rs.getString(22);
                m21 = rs.getString(23);
                m22 = rs.getString(24);
                m23 = rs.getString(25);
                m24 = rs.getString(26);
                m25 = rs.getString(27);
                m26 = rs.getString(28);
                m27 = rs.getString(29);
                m28 = rs.getString(30);
                m29 = rs.getString(31);
                m30 = rs.getString(32);
                m31 = rs.getString(33);
                m32 = rs.getString(34);
                m33 = rs.getString(35);
                m34 = rs.getString(36);
                m35 = rs.getString(37);
                m36 = rs.getString(38);
                m37 = rs.getString(39);
                m38 = rs.getString(40);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Caja_caja.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (m1.equals("S")) {
            menu_config.setEnabled(true);
        } else {
            menu_config.setEnabled(false);
        }
        if (m2.equals("S")) {
            menu_reporte_fiscal.setEnabled(true);
        } else {
            menu_reporte_fiscal.setEnabled(false);
        }
        if (m3.equals("S")) {
            menu_copia.setEnabled(true);
        } else {
            menu_copia.setEnabled(false);
        }
        if (m4.equals("S")) {
            menu_producto.setEnabled(true);
        } else {
            menu_producto.setEnabled(false);
        }
        if (m5.equals("S")) {
            menu_logistica.setEnabled(true);
        } else {
            menu_logistica.setEnabled(false);
        }
        if (m6.equals("S")) {
            menu_clientes.setEnabled(true);
        } else {
            menu_clientes.setEnabled(false);
        }
        if (m7.equals("S")) {
            menu_proveedor.setEnabled(true);
        } else {
            menu_proveedor.setEnabled(false);
        }
        if (m8.equals("S")) {
            menu_usuario.setEnabled(true);
        } else {
            menu_usuario.setEnabled(false);
        }
        if (m9.equals("S")) {
            menu_ventas.setEnabled(true);
        } else {
            menu_ventas.setEnabled(false);
        }
        if (m10.equals("S")) {
            menu_compras.setEnabled(true);
        } else {
            menu_compras.setEnabled(false);
        }
        if (m11.equals("S")) {
            menu_devolucion.setEnabled(true);
        } else {
            menu_devolucion.setEnabled(false);
        }
        if (m12.equals("S")) {
            menu_presupuesto.setEnabled(true);
        } else {
            menu_presupuesto.setEnabled(false);
        }
        if (m13.equals("S")) {
            menu_egreso.setEnabled(true);
        } else {
            menu_egreso.setEnabled(false);
        }
        if (m14.equals("S")) {
            menu_caja.setEnabled(true);
        } else {
            menu_caja.setEnabled(false);
        }
        if (m15.equals("S")) {
            menu_listado_mov.setEnabled(true);
        } else {
            menu_listado_mov.setEnabled(false);
        }
        if (m16.equals("S")) {
            menu_historicos.setEnabled(true);
        } else {
            menu_historicos.setEnabled(false);
        }
        if (m17.equals("S")) {
            menu_cuentas.setEnabled(true);
        } else {
            menu_cuentas.setEnabled(false);
        }
        if (m18.equals("S")) {
            menu_cambios.setEnabled(true);
        } else {
            menu_cambios.setEnabled(false);
        }
        if (m19.equals("S")) {
            menu_transferencia.setEnabled(true);
        } else {
            menu_transferencia.setEnabled(false);
        }
        ///////////////////////////////////////////////
        if (m20.equals("S")) {
            menu_razon_pro.setEnabled(true);
        } else {
            menu_razon_pro.setEnabled(false);
        }
        if (m21.equals("S")) {
            menu_list_dto.setEnabled(true);
        } else {
            menu_list_dto.setEnabled(false);
        }
        if (m22.equals("S")) {
            menu_list_fisico.setEnabled(true);
        } else {
            menu_list_fisico.setEnabled(false);
        }
        if (m23.equals("S")) {
            menu_list_cp.setEnabled(true);
        } else {
            menu_list_cp.setEnabled(false);
        }
        if (m24.equals("S")) {
            menu_list_venta.setEnabled(true);
        } else {
            menu_list_venta.setEnabled(false);
        }
        if (m25.equals("S")) {
            menu_salida_stock.setEnabled(true);
        } else {
            menu_salida_stock.setEnabled(false);
        }
        if (m26.equals("S")) {
            menu_lucro_pro.setEnabled(true);
        } else {
            menu_lucro_pro.setEnabled(false);
        }
        if (m27.equals("S")) {
            menu_venta_usu.setEnabled(true);
        } else {
            menu_venta_usu.setEnabled(false);
        }
        if (m28.equals("S")) {
            menu_lucro_user.setEnabled(true);
        } else {
            menu_lucro_user.setEnabled(false);
        }
        if (m29.equals("S")) {
            menu_recibo_fisc.setEnabled(true);
        } else {
            menu_recibo_fisc.setEnabled(false);
        }
        if (m30.equals("S")) {
            menu_list_compras.setEnabled(true);
        } else {
            menu_list_compras.setEnabled(false);
        }
        if (m31.equals("S")) {
            menu_list_devol.setEnabled(true);
        } else {
            menu_list_devol.setEnabled(false);
        }
        if (m32.equals("S")) {
            menu_lucro.setEnabled(true);
        } else {
            menu_lucro.setEnabled(false);
        }
        if (m33.equals("S")) {
            menu_facturas.setEnabled(true);
        } else {
            menu_facturas.setEnabled(false);
        }
        if (m34.equals("S")) {
            menu_bancos.setEnabled(true);
        } else {
            menu_bancos.setEnabled(false);
        }
        if (m35.equals("S")) {
            menu_recibos.setEnabled(true);
        } else {
            menu_recibos.setEnabled(false);
        }
        if (m36.equals("S")) {
            menu_pedidos.setEnabled(true);
        } else {
            menu_pedidos.setEnabled(false);
        }
        if (m37.equals("S")) {
            menu_nota_cre.setEnabled(true);
        } else {
            menu_nota_cre.setEnabled(false);
        }
        if (m38.equals("S")) {
            menu_surcusales.setEnabled(true);
        } else {
            menu_surcusales.setEnabled(false);
        }
    }

    public void OpcionMenu() {
        if (Principal.lbl_class.getText().equals("8")) {

            JPopupMenu menu_opcion = new JPopupMenu();

            JMenuItem menu_modPro = new JMenuItem("Consultar productos", new ImageIcon(getClass().getResource("/iconos_cuadro/productos.png")));
            JMenuItem menu_cli = new JMenuItem("Consultar clientes", new ImageIcon(getClass().getResource("/iconos_cuadro/clientes.png")));
            JMenuItem menu_prov = new JMenuItem("Consultar proveedores", new ImageIcon(getClass().getResource("/iconos_cuadro/user.png")));
            JMenuItem menu_sesion = new JMenuItem("Cerrar sesión", new ImageIcon(getClass().getResource("/iconos_cuadro/cerrar_sesion.png")));

            menu_modPro.addActionListener((ActionEvent e) -> {
                /* Productos pro;
                 pro = new Productos(new javax.swing.JDialog(), true);
                 pro.setVisible(true);*/
            });
            menu_cli.addActionListener((ActionEvent e) -> {
                Plataforma_clientes ac;
                ac = new Plataforma_clientes(new javax.swing.JDialog(), true);
                ac.setVisible(true);
            });
            menu_prov.addActionListener((ActionEvent e) -> {
                Plataforma_proveedor pv;
                pv = new Plataforma_proveedor(new javax.swing.JDialog(), true);
                pv.setVisible(true);
            });
            menu_sesion.addActionListener((ActionEvent e) -> {
                NECTTIC principal = null;
                try {
                    principal = new NECTTIC();

                } catch (SocketException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                principal.setVisible(true);
                principal.pack();
                this.setVisible(false);
            });

            //  menu_opcion.add(menu_modPro);
            menu_opcion.add(menu_cli);
            menu_opcion.add(menu_prov);
            menu_opcion.add(menu_sesion);
            panel_principal.setComponentPopupMenu(menu_opcion);
        } else {
        }
    }

    void cargar_Agenda() {
        String data = lbl_fecha_hoy.getText();
        String mostrar = "SELECT COUNT(*) FROM agenda_diaria  WHERE fecha_age ='" + data + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                // lbl_notifica.setText(rs.getString(1));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(empre_config_serial.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar_notif_ped() {

        String mostrar = "SELECT COUNT(*) FROM pedidos  WHERE estado_pedi ='En Espera'";
        String notif = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                notif = (rs.getString(1));

            }
            conectar.getInstance().closeConnection(cn);
            int nro = Integer.parseInt(notif);

            if (nro > 0) {
                lbl_notifi_pedidos.setVisible(true);
                // Notif_pedidos notifP = new Notif_pedidos();
                // notifP.setVisible(true);

                AudioClip audio;
                audio = java.applet.Applet.newAudioClip(getClass().getResource("/Loggin_Principal/alerta.wav"));
                audio.play();
            } else {
                lbl_notifi_pedidos.setVisible(false);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private class time implements Runnable {

        @Override
        public void run() {
            while (true) {
                horario();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }

    }

    void configuracion() {
        if (lbl_tipo.getText().equals("SUPERVISOR")) {

            botton_config.setVisible(true);

        } else {
            botton_config.setVisible(false);

        }
    }

    void horario() {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        txt_hora_act.setText(dateFormat.format(date));
        // System.out.println("Hora actual: " + dateFormat.format(date));

    }
/// control de pedidos

    public void actualiza() {

        Timer timer = new Timer();
        TimerTask tesk = new TimerTask() {
            int Cont = 0;

            @Override
            public void run() {

                if (lbl_tipo.getText().equals("SUPERVISOR") || lbl_tipo.getText().equals("CONTROL INTERNO")) {
                    cargar_notif_ped();
                }

                //  conectar cc = new conectar();
                //  Connection cn = cc.conexion();
            }
        };
        timer.schedule(tesk, 1000, 30000);
    }

    ///////////////////copia de seguridad automatico
    public void EnviandoBDCorreo(String HoraActualString) {
        String[] DeOndaNomas = new String[1];

        SendEmail Clon_X7_ROBOT_MENSAJERO = new SendEmail(HoraActualString);

        Clon_X7_ROBOT_MENSAJERO.main(DeOndaNomas);

    }// FIN METODO      

    public String GenerarBackupMySQL_ANTES() {

        //<editor-fold defaultstate="collapsed" desc=" PROCESO DE FECHA ACTUAL ">
        Calendar c = Calendar.getInstance();

        String DiaPresente = String.valueOf(c.get(Calendar.DATE));

        String MesPresente = String.valueOf(c.get(Calendar.MONTH));

        int MesPresenteEntero = Integer.valueOf(MesPresente);

        MesPresenteEntero = MesPresenteEntero + 1;

        MesPresente = String.valueOf(MesPresenteEntero);

        String AñoPresente = String.valueOf(c.get(Calendar.YEAR));

        //<editor-fold defaultstate="collapsed" desc=" AREA 1 DE VARIABLE ">
        //<editor-fold defaultstate="collapsed" desc=" String ">
        String fecha;

        //</editor-fold>
        //</editor-fold>
        // CONCATENANDO.- DIA MES Y AÑO.-
        fecha = DiaPresente + "_" + MesPresente + "_" + AñoPresente;

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc=" PROCESO DE HORA ACTUAL ">
        Date HoraActual = new Date();
        String HoraActualString = HoraActual.getHours() + "_Hr" + "_" + HoraActual.getMinutes() + "_min" + "_" + HoraActual.getSeconds() + "_seg";

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc=" TRY ">
        try {
            Runtime runtime = Runtime.getRuntime();

            //<editor-fold defaultstate="collapsed" desc=" EL ENGRANAJE VALIOSO ">
            String BackupRuta = "C:\\copia\\ElNro_" + HoraActualString + ".sql";
            String RutaMySQLDump = "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\mysqldump --password=canis --user=system --default-character-set=utf8 --extended-insert=false --hex-blob necttic";    //modificar           

            //</editor-fold>
            File backupFile = new File(
                    BackupRuta
            //String.valueOf( "C:\\EMASYSTEM_FIDEL\\BD\\BACKUP_AUTOGENERADO" + UltimoContador + "_Fecha_" + fecha + ".sql" )

            );
            FileWriter fw = new FileWriter(backupFile);
            Process child = runtime.exec(RutaMySQLDump);
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);

            String line;

            //<editor-fold defaultstate="collapsed" desc=" WHILE ">
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }// FIN WHILE

            //</editor-fold>
            fw.close();
            irs.close();
            br.close();

        }// FIN TRY
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc=" CATCH ">
        catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:" + e.getMessage(), "Verificar", JOptionPane.ERROR_MESSAGE);

        }// FIN CATCH

        //</editor-fold>        
        return HoraActualString;
    }//

    void HORA_SERVIDOR() {

        String fecha_server = lbl_hora_server.getText();
        if (fecha_server.equals("N")) {

            LocalDate fecha = LocalDate.now();
            lbl_fecha_hoy.setText(fecha.toString());
            lbl_fecha_principal.setText(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            txt_fecha_backup.setText(fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
            lbl_dia_actual.setText(simpleDateFormat.format(date).toUpperCase());
            simpleDateFormat = new SimpleDateFormat("MMMM");
            lbl_mes_actual.setText(simpleDateFormat.format(date).toUpperCase());
            lbl_año_actual.setText(fecha.format(DateTimeFormatter.ofPattern("yy")));
            lbl_periodo_fiscal.setText(fecha.format(DateTimeFormatter.ofPattern("yyyy")));

        } else {
            String mostrar = "SELECT CURDATE() ";

            try {
                Connection cn = conectar.getInstance().getConnection();

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(mostrar);
                while (rs.next()) {
                    LBL_HORA_SERVER.setText(rs.getString(1));
                    lbl_fecha_hoy.setText(rs.getString(1));

                }
                String datas = lbl_fecha_hoy.getText();
                Date vista = new SimpleDateFormat("yyyy-MM-dd").parse(datas);

                SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
                lbl_fecha_principal.setText(formateadorFecha.format(vista));
                SimpleDateFormat formateadorFechaBackup = new SimpleDateFormat("dd-MM-yyyy");
                txt_fecha_backup.setText(formateadorFechaBackup.format(vista));

                System.out.println("Fecha server");
                //
                SimpleDateFormat dd = new SimpleDateFormat("dd");
                lbl_dia_actual.setText(dd.format(vista));
                SimpleDateFormat mmmm = new SimpleDateFormat("MMMM");
                lbl_mes_actual.setText(mmmm.format(vista));

                SimpleDateFormat yy = new SimpleDateFormat("YY");
                lbl_año_actual.setText(yy.format(vista));
                SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
                lbl_periodo_fiscal.setText(yyyy.format(vista));
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(empre_config_serial.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void fecha() {

    }

    void serial() {
        /*    LocalDate licencia = LocalDate.now();

         SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

         try {
         Date fechaDate = formato.parse(lbl_licencia.getText());
         if (fechaDate.equals(licencia)) {
         String serial = ("BLOQUEADO");
         int id = 1;

         try {
         PreparedStatement pst = cn.prepareStatement("UPDATE serial SET serial_des='"
         + serial + "' WHERE id_serial='" + id + "'");
         pst.executeUpdate();
                   
         } catch (SQLException | HeadlessException e) {
         System.out.print(e.getMessage());
         }

         } 
         } catch (ParseException ex) {
         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         }*/

    }

    void control_version() {
        String actual = lbl_version.getText();
        String ver = "";

        String consul = "SELECT * FROM empresas ";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                ver = rs.getString(27);//pendiente a modificacion
            }
            if (actual.equals(ver)) {
                version_alerta.setText("Versión Actualizada");
                version_alerta.setForeground(Color.GREEN);

            } else {
                version_alerta.setText("Actualice a la versión" + "-->" + ver);
                version_alerta.setForeground(Color.RED);
                Mensaje_Actualiza update;
                update = new Mensaje_Actualiza(new javax.swing.JDialog(), true);
                update.setVisible(true);

            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }

    }

}
