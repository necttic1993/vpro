//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_surcu_lucro_clientes;
import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

public class ventas_lucro_por_clientes extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public ventas_lucro_por_clientes(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);

        initComponents();
        lbl_almacen_pedidos.setText(Principal.lbl_usu_almacen.getText());
        tb_lista_tablas.setVisible(false);
        txt_lucro_ventas.setDisabledTextColor(Color.black);
        txt_total_ventas.setDisabledTextColor(Color.black);
        cb_tipo_cli.setEnabled(false);
        cb_status.setEnabled(false);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_lucro_ventas = new javax.swing.JTextField();
        tb_lista_tablas = new javax.swing.JPanel();
        lbl_intermedio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_ventas_plazo = new javax.swing.JTable();
        lbl_total_parcial = new javax.swing.JLabel();
        lbl_subtotal_neto = new javax.swing.JLabel();
        txt_lucro_compra = new javax.swing.JTextField();
        txt_total_ventas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jd_fin_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        lbl_almacen_pedidos = new javax.swing.JLabel();
        txt_id_cli_ventas = new javax.swing.JTextField();
        txt_nom_cli_ventas = new javax.swing.JTextField();
        btn_busca_clientes = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        ch_estado = new javax.swing.JCheckBox();
        ch_cliente = new javax.swing.JCheckBox();
        ch_tipocli = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cb_status = new org.jdesktop.swingx.JXComboBox();
        cb_tipo_cli = new org.jdesktop.swingx.JXComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumen Gral");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 70, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Fecha Final:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 90, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Estado de Notas:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 130, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, 70, 40));

        txt_lucro_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_lucro_ventas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_ventas.setText("0");
        txt_lucro_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_ventas.setEnabled(false);
        jPanel3.add(txt_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, 190, 30));

        tb_lista_tablas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_intermedio.setText("0");
        tb_lista_tablas.add(lbl_intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 20));

        tb_ventas_plazo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_ventas_plazo);

        tb_lista_tablas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 20));

        lbl_total_parcial.setText("0");
        tb_lista_tablas.add(lbl_total_parcial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 20, -1));

        lbl_subtotal_neto.setText("0");
        tb_lista_tablas.add(lbl_subtotal_neto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 30, -1));

        txt_lucro_compra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_lucro_compra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_compra.setText("0");
        txt_lucro_compra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_compra.setEnabled(false);
        tb_lista_tablas.add(txt_lucro_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 70, 30));

        txt_total_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_ventas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_ventas.setText("0");
        txt_total_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_ventas.setEnabled(false);
        tb_lista_tablas.add(txt_total_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 70, 30));

        jPanel3.add(tb_lista_tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 310, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Total Lucro Ventas:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 140, 30));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1110, 320));

        jd_fin_lucro_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jd_fin_lucro_ventasActionPerformed(evt);
            }
        });
        jPanel3.add(jd_fin_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 140, 30));
        jPanel3.add(jd_ini_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, 30));

        lbl_almacen_pedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos.setText("0000000");
        lbl_almacen_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_pedidosMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_almacen_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 110, 50));

        txt_id_cli_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_cli_ventas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_cli_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cli_ventas.setEnabled(false);
        jPanel3.add(txt_id_cli_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 110, 30));

        txt_nom_cli_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cli_ventas.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_cli_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_ventas.setEnabled(false);
        jPanel3.add(txt_nom_cli_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 380, 30));

        btn_busca_clientes.setBackground(new java.awt.Color(255, 255, 255));
        btn_busca_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_busca_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_busca_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busca_clientesActionPerformed(evt);
            }
        });
        jPanel3.add(btn_busca_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 60, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        ch_estado.setBackground(new java.awt.Color(255, 255, 255));
        ch_estado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_estado.setText("Estado Notas");
        ch_estado.setContentAreaFilled(false);
        ch_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_estadoActionPerformed(evt);
            }
        });
        jPanel3.add(ch_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, 30));

        ch_cliente.setBackground(new java.awt.Color(255, 255, 255));
        ch_cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_cliente.setSelected(true);
        ch_cliente.setText("Cliente");
        ch_cliente.setContentAreaFilled(false);
        ch_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_clienteActionPerformed(evt);
            }
        });
        jPanel3.add(ch_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, 30));

        ch_tipocli.setBackground(new java.awt.Color(255, 255, 255));
        ch_tipocli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_tipocli.setText("Tipo de cliente");
        ch_tipocli.setContentAreaFilled(false);
        ch_tipocli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_tipocliActionPerformed(evt);
            }
        });
        jPanel3.add(ch_tipocli, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel17.setText("Filtrar por:");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 35));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Clientes:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Tipo de Cli.:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));

        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODAS", "CONFIRMADA", "FINALIZADA" }));
        cb_status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 200, 30));

        cb_tipo_cli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MINORISTAS", "MAYORISTAS", "SUBDISTRIBUIDOR", "DISTRIBUIDOR" }));
        cb_tipo_cli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(cb_tipo_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventasKeyReleased

    }//GEN-LAST:event_tb_ventasKeyReleased

    private void tb_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventasMouseClicked
        /*int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_ventasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (lbl_almacen_pedidos.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Surcusal/Almacen válido");
        } else {
            PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
            if (printService.length > 0)//si existen impresoras
            {
                //se elige la impresora
                PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                        "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                if (impresora != null) //Si se selecciono una impresora
                {

                    Ventas_lucro_Clientes cl;// Instaciamos la clase empleado
                    List<Ventas_lucro_Clientes> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                    for (int i = 0; i < tb_ventas.getRowCount(); i++) { // Iterena cada fila de la tabla
                        cl = new Ventas_lucro_Clientes(tb_ventas.getValueAt(i, 0).toString(), tb_ventas.getValueAt(i, 3).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                                tb_ventas.getValueAt(i, 2).toString(), tb_ventas.getValueAt(i, 4).toString(), tb_ventas.getValueAt(i, 5).toString(), tb_ventas.getValueAt(i, 6).toString());
                        lista.add(cl); //Agregamos el objeto empleado a la lista
                    }

                    try {

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                        String cliente = txt_id_cli_ventas.getText()+" "+txt_nom_cli_ventas.getText();
                        String sucursal = lbl_almacen_pedidos.getText();
                        String total = txt_lucro_ventas.getText();

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("cliente", cliente);
                        parametro.put("sucursal", sucursal);
                        parametro.put("total", total);

                        URL in = this.getClass().getResource("/Impresiones/Lista_ventas_lucro_cli.jasper");
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                        JasperPrint print = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

                        JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                        jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                        //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                        jrprintServiceExporter.exportReport();
                    } catch (JRException ex) {
                        Logger.getLogger(extracto_compras.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
        String id = txt_id_cli_ventas.getText();
        String status = cb_status.getSelectedItem().toString();
        String tipo = cb_tipo_cli.getSelectedItem().toString();
        String sql = "";
        //selectores
        String selectores = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta,v.forma_pag_ventas, p.pro_pre_b ";
        //inner joins con cada almacen
        String inner = " FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_2 = " FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_3 = " FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_4 = " FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_5 = " FROM ventas_detalles_5 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_5 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_6 = " FROM ventas_detalles_6 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_6 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_7 = " FROM ventas_detalles_7 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_7 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_8 = " FROM ventas_detalles_8 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_8 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_9 = " FROM ventas_detalles_9 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_9 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_10 = " FROM ventas_detalles_10 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_10 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_11 = " FROM ventas_detalles_11 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_11 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_12 = " FROM ventas_detalles_12 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_12 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_13 = " FROM ventas_detalles_13 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_13 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_14 = " FROM ventas_detalles_14 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_14 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_15 = " FROM ventas_detalles_15 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_15 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_16 = " FROM ventas_detalles_16 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_16 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_17 = " FROM ventas_detalles_17 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_17 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_18 = " FROM ventas_detalles_18 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_18 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_19 = " FROM ventas_detalles_19 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_19 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_20 = " FROM ventas_detalles_20 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_20 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_21 = " FROM ventas_detalles_21 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_21 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_22 = " FROM ventas_detalles_22 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_22 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_23 = " FROM ventas_detalles_23 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_23 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_24 = " FROM ventas_detalles_24 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_24 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_25 = " FROM ventas_detalles_25 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_25 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_26 = " FROM ventas_detalles_26 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_26 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_27 = " FROM ventas_detalles_27 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_27 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_28 = " FROM ventas_detalles_28 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_28 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_29 = " FROM ventas_detalles_29 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_29 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        String inner_30 = " FROM ventas_detalles_30 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_30 AS v ON d.num_bol=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas ";
        //where fechas
        String where = " WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "' ";
        //casos de consulta
        //1-cliente
        String select_cliente = "AND v.cod_cli_ventas='" + id + "' ";
        //2-tipo de clientes
        String tipo_cliente = " AND c.cli_tipo='" + tipo + "' ";
        //3-estado de notas
        //3.1-
        String select_nota_total = " ";
        //3.2
        String select_nota_status = " AND v.estado_ventas='" + status + "' ";
        ///fin

        ///condicionales
        if (ch_cliente.isSelected()) {
            if (txt_id_cli_ventas.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Seleccione un cliente con id existente");
            } else {
                if (lbl_almacen_pedidos.getText().equals("0000001")) {
                    sql = selectores + inner + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000002")) {
                    sql = selectores + inner_2 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000003")) {
                    sql = selectores + inner_3 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000004")) {
                    sql = selectores + inner_4 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000005")) {
                    sql = selectores + inner_5 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000006")) {
                    sql = selectores + inner_6 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000007")) {
                    sql = selectores + inner_7 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000008")) {
                    sql = selectores + inner_8 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000009")) {
                    sql = selectores + inner_9 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000010")) {
                    sql = selectores + inner_10 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000011")) {
                    sql = selectores + inner_11 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000012")) {
                    sql = selectores + inner_12 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000013")) {
                    sql = selectores + inner_13 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000014")) {
                    sql = selectores + inner_14 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000015")) {
                    sql = selectores + inner_15 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000016")) {
                    sql = selectores + inner_16 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000017")) {
                    sql = selectores + inner_17 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000018")) {
                    sql = selectores + inner_18 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000019")) {
                    sql = selectores + inner_19 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000020")) {
                    sql = selectores + inner_20 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000021")) {
                    sql = selectores + inner_21 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000022")) {
                    sql = selectores + inner_22 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000023")) {
                    sql = selectores + inner_23 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000024")) {
                    sql = selectores + inner_24 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000025")) {
                    sql = selectores + inner_25 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000026")) {
                    sql = selectores + inner_26 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000027")) {
                    sql = selectores + inner_27 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000028")) {
                    sql = selectores + inner_28 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000029")) {
                    sql = selectores + inner_29 + where + select_cliente;
                }
                if (lbl_almacen_pedidos.getText().equals("0000030")) {
                    sql = selectores + inner_30 + where + select_cliente;
                }

            }

        }
        if (ch_tipocli.isSelected()) {

            if (lbl_almacen_pedidos.getText().equals("0000001")) {
                sql = selectores + inner + where + tipo_cliente;
            }
            if (lbl_almacen_pedidos.getText().equals("0000002")) {
                sql = selectores + inner_2 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000003")) {
                sql = selectores + inner_3 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000004")) {
                sql = selectores + inner_4 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000005")) {
                sql = selectores + inner_5 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000006")) {
                sql = selectores + inner_6 + where + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000007")) {
                sql = selectores + inner_7 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000008")) {
                sql = selectores + inner_8 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000009")) {
                sql = selectores + inner_9 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000010")) {
                sql = selectores + inner_10 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000011")) {
                sql = selectores + inner_11 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000012")) {
                sql = selectores + inner_12 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000013")) {
                sql = selectores + inner_13 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000014")) {
                sql = selectores + inner_14 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000015")) {
                sql = selectores + inner_15 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000016")) {
                sql = selectores + inner_16 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000017")) {
                sql = selectores + inner_17 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000018")) {
                sql = selectores + inner_18 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000019")) {
                sql = selectores + inner_19 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000020")) {
                sql = selectores + inner_20 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000021")) {
                sql = selectores + inner_21 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000022")) {
                sql = selectores + inner_22 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000023")) {
                sql = selectores + inner_23 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000024")) {
                sql = selectores + inner_24 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000025")) {
                sql = selectores + inner_25 + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000026")) {
                sql = selectores + inner_26 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000027")) {
                sql = selectores + inner_27 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000028")) {
                sql = selectores + inner_28 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000029")) {
                sql = selectores + inner_29 + where + tipo_cliente;
            }

            if (lbl_almacen_pedidos.getText().equals("0000030")) {
                sql = selectores + inner_30 + where + tipo_cliente;
            }

        }
        if (ch_estado.isSelected()) {
            String estado = cb_status.getSelectedItem().toString();
            if (estado.equals("TODAS")) {
                if (lbl_almacen_pedidos.getText().equals("0000001")) {
                    sql = selectores + inner + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000002")) {
                    sql = selectores + inner_2 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000003")) {
                    sql = selectores + inner_3 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000004")) {
                    sql = selectores + inner_4 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000005")) {
                    sql = selectores + inner_5 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000006")) {
                    sql = selectores + inner_6 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000007")) {
                    sql = selectores + inner_7 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000008")) {
                    sql = selectores + inner_8 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000009")) {
                    sql = selectores + inner_9 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000010")) {
                    sql = selectores + inner_10 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000011")) {
                    sql = selectores + inner_11 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000012")) {
                    sql = selectores + inner_12 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000013")) {
                    sql = selectores + inner_13 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000014")) {
                    sql = selectores + inner_14 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000015")) {
                    sql = selectores + inner_15 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000016")) {
                    sql = selectores + inner_16 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000017")) {
                    sql = selectores + inner_17 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000018")) {
                    sql = selectores + inner_18 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000019")) {
                    sql = selectores + inner_19 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000020")) {
                    sql = selectores + inner_20 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000021")) {
                    sql = selectores + inner_21 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000022")) {
                    sql = selectores + inner_22 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000023")) {
                    sql = selectores + inner_23 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000024")) {
                    sql = selectores + inner_24 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000025")) {
                    sql = selectores + inner_25 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000026")) {
                    sql = selectores + inner_26 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000027")) {
                    sql = selectores + inner_27 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000028")) {
                    sql = selectores + inner_28 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000029")) {
                    sql = selectores + inner_29 + where + select_nota_total;
                }
                if (lbl_almacen_pedidos.getText().equals("0000030")) {
                    sql = selectores + inner_30 + where + select_nota_total;
                }

            } else {
                if (lbl_almacen_pedidos.getText().equals("0000001")) {
                    sql = selectores + inner + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000002")) {
                    sql = selectores + inner_2 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000003")) {
                    sql = selectores + inner_3 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000004")) {
                    sql = selectores + inner_4 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000005")) {
                    sql = selectores + inner_5 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000006")) {
                    sql = selectores + inner_6 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000007")) {
                    sql = selectores + inner_7 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000008")) {
                    sql = selectores + inner_8 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000009")) {
                    sql = selectores + inner_9 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000010")) {
                    sql = selectores + inner_10 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000011")) {
                    sql = selectores + inner_11 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000012")) {
                    sql = selectores + inner_12 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000013")) {
                    sql = selectores + inner_13 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000014")) {
                    sql = selectores + inner_14 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000015")) {
                    sql = selectores + inner_15 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000016")) {
                    sql = selectores + inner_16 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000017")) {
                    sql = selectores + inner_17 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000018")) {
                    sql = selectores + inner_18 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000019")) {
                    sql = selectores + inner_19 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000020")) {
                    sql = selectores + inner_20 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000021")) {
                    sql = selectores + inner_21 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000022")) {
                    sql = selectores + inner_22 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000023")) {
                    sql = selectores + inner_23 + where + select_nota_status;
                }

                if (lbl_almacen_pedidos.getText().equals("0000024")) {
                    sql = selectores + inner_24 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000025")) {
                    sql = selectores + inner_25 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000026")) {
                    sql = selectores + inner_26 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000027")) {
                    sql = selectores + inner_27 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000028")) {
                    sql = selectores + inner_28 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000029")) {
                    sql = selectores + inner_29 + where + select_nota_status;
                }
                if (lbl_almacen_pedidos.getText().equals("0000030")) {
                    sql = selectores + inner_30 + where + select_nota_status;
                }
            }

        }
       
        //
        if (lbl_almacen_pedidos.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Surcusal/Almacen válido");
        } else {

            if (Principal.lbl_model_lucro.getText().equals("1")) {

                cargar_1(sql);
                inicio();
                calcularVentasCompras();
                lista_ventas();
                Total_compras();
                TotalVentasMenosCompras();

            } else {

                cargar_2(sql);
                inicio();
                calcularVentasCompras();
                lista_ventas();
                Total_compras();
                TotalVentasMenosCompras();

            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jd_fin_lucro_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jd_fin_lucro_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jd_fin_lucro_ventasActionPerformed

    private void lbl_almacen_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_pedidosMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_surcu_lucro_clientes sl;
            sl = new Seleccion_surcu_lucro_clientes(new javax.swing.JDialog(), true);
            sl.setVisible(true);

        }
    }//GEN-LAST:event_lbl_almacen_pedidosMouseClicked

    private void btn_busca_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busca_clientesActionPerformed
        Clientes_report_ventas_lucro_select cl;
        cl = new Clientes_report_ventas_lucro_select(new javax.swing.JDialog(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_btn_busca_clientesActionPerformed

    private void ch_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_clienteActionPerformed
        cb_tipo_cli.setEnabled(false);
        cb_status.setEnabled(false);

        ///
        ch_cliente.setSelected(true);
        ch_estado.setSelected(false);
        ch_tipocli.setSelected(false);
        //
        btn_busca_clientes.setEnabled(true);
    }//GEN-LAST:event_ch_clienteActionPerformed

    private void ch_tipocliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_tipocliActionPerformed
        cb_tipo_cli.setEnabled(true);
        cb_status.setEnabled(false);

        ///
        ch_cliente.setSelected(false);
        ch_estado.setSelected(false);
        ch_tipocli.setSelected(true);
        //
        btn_busca_clientes.setEnabled(false);
        //limpiar
        txt_id_cli_ventas.setText("");
        txt_nom_cli_ventas.setText("");
        //limpiar
        
        
    }//GEN-LAST:event_ch_tipocliActionPerformed

    private void ch_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_estadoActionPerformed
        cb_tipo_cli.setEnabled(false);
        cb_status.setEnabled(true);

        ///
        ch_cliente.setSelected(false);
        ch_estado.setSelected(true);
        ch_tipocli.setSelected(false);
        //
        btn_busca_clientes.setEnabled(false);
        txt_id_cli_ventas.setText("");
        txt_nom_cli_ventas.setText("");
    }//GEN-LAST:event_ch_estadoActionPerformed
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_por_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_por_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_por_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_por_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventas_lucro_por_clientes dialog = new ventas_lucro_por_clientes(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_busca_clientes;
    private org.jdesktop.swingx.JXComboBox cb_status;
    private org.jdesktop.swingx.JXComboBox cb_tipo_cli;
    private javax.swing.JCheckBox ch_cliente;
    private javax.swing.JCheckBox ch_estado;
    private javax.swing.JCheckBox ch_tipocli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static org.jdesktop.swingx.JXDatePicker jd_fin_lucro_ventas;
    public static org.jdesktop.swingx.JXDatePicker jd_ini_lucro_ventas;
    public static javax.swing.JLabel lbl_almacen_pedidos;
    private javax.swing.JLabel lbl_intermedio;
    private javax.swing.JLabel lbl_subtotal_neto;
    private javax.swing.JLabel lbl_total_parcial;
    private javax.swing.JPanel tb_lista_tablas;
    public static javax.swing.JTable tb_ventas;
    private javax.swing.JTable tb_ventas_plazo;
    public static javax.swing.JTextField txt_id_cli_ventas;
    public static javax.swing.JTextField txt_lucro_compra;
    public static javax.swing.JTextField txt_lucro_ventas;
    public static javax.swing.JTextField txt_nom_cli_ventas;
    public static javax.swing.JTextField txt_total_ventas;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void inicio() {
        txt_total_ventas.setText("0");
        txt_lucro_compra.setText("0");
        txt_lucro_ventas.setText("0");

    }

    public void lista_ventas() {

        String impv = "0", subtotalv = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 8).toString().replaceAll("\\s", ""));

            impv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalv).add(ingreso.TransformReales(impv)).toString());

            txt_total_ventas.setText(subtotalv);

        }
    }

    public void Total_compras() {

        String impc = "0", subtotalc = "0", totalc = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 7).toString().replaceAll("\\s", ""));

            impc = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalc = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalc).add(ingreso.TransformReales(impc)).toString());

            txt_lucro_compra.setText(subtotalc);

        }
    }

    ////////calcula precio compra - precio ventas en la tabla///////////////////////
    public void calcularVentasCompras() {

        String imp = "0", subtotal = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_ventas.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);

        }
    }

/////////diferencia total compra - ventas
    public void TotalVentasMenosCompras() {

        String totalCuentaDa = "0";
        BigDecimal VentaTotal = ingreso.TransformReales(txt_total_ventas.getText());
        BigDecimal ValorCompra = ingreso.TransformReales(txt_lucro_compra.getText());
        totalCuentaDa = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(VentaTotal.subtract(ValorCompra).toString());
        txt_lucro_ventas.setText(totalCuentaDa);

    }
/////lucro modelo 1

    void cargar_1(String sql) {

        String mostrar = sql;
        System.out.println(mostrar);
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_por_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////lucro modelo 2/////////////////////////////////////////////
    void cargar_2(String sql) {
        String mostrar = sql;
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

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
                Registros[5] = rs.getString("pro_pre_costo");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_por_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
