//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_lista_ventas;
import Loggin_Principal.Seleccion_ventas_detallado;
import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
//</editor-fold>

public class Ventas_clientes_detalles extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Ventas_clientes_detalles(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // cargarIN();
        lbl_almacen_ventas_detalles.setText(Principal.lbl_usu_almacen.getText());
        txt_total_gs.setDisabledTextColor(Color.black);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    void limpiar() {

        txt_total_gs.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_compras.getModel();
        int a = tb_compras.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_compras = new javax.swing.JTable();
        txt_total_gs = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();
        txt_id_cli_ventas = new javax.swing.JTextField();
        txt_nom_cli_ventas = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        lbl_almacen_ventas_detalles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Extratos de Ventas");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_compras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
        tb_compras.setGridColor(new java.awt.Color(0, 204, 255));
        tb_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_comprasMouseClicked(evt);
            }
        });
        tb_compras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_comprasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_compras);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1030, 360));

        txt_total_gs.setBackground(new java.awt.Color(240, 240, 240));
        txt_total_gs.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_total_gs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs.setEnabled(false);
        txt_total_gs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gsActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 230, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Total :");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 450, 50, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Fecha Final:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 90, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 60, 45));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setToolTipText("Imprimir extracto de venta");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 60, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Clientes:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 150, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 150, 30));

        txt_id_cli_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_cli_ventas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_cli_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cli_ventas.setEnabled(false);
        jPanel3.add(txt_id_cli_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 110, 30));

        txt_nom_cli_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cli_ventas.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_cli_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_ventas.setEnabled(false);
        jPanel3.add(txt_nom_cli_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 380, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 60, 30));

        lbl_almacen_ventas_detalles.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_ventas_detalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_ventas_detalles.setText("TODOS");
        lbl_almacen_ventas_detalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_ventas_detalles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_ventas_detalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_ventas_detallesMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_almacen_ventas_detalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 110, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_comprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_comprasMouseClicked
        /*    int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_comprasMouseClicked

    private void tb_comprasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_comprasKeyReleased

    }//GEN-LAST:event_tb_comprasKeyReleased

    private void txt_total_gsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //<editor-fold defaultstate="collapsed" desc="Almacen 1">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000001")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 2">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000002")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_2.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 3">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000003")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_3.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 4">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000004")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_4.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 5">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000005")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_5.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 6">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000006")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_6.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 7">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000007")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_7.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 8">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000008")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_8.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 9">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000009")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_9.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 10">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000010")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_10.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 11">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000011")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_11.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 12">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000012")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_12.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 13">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000013")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_13.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 14">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000014")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_14.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 15">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000015")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_15.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 16">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000016")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_16.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 17">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000017")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_17.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 18">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000018")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_18.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 19">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000019")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_19.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 20">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000020")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_20.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 21">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000021")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_21.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 22">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000022")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_22.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 23">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000023")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_23.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 24">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000024")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_24.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 25">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000025")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_25.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 26">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000026")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_26.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 27">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000027")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_27.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 28">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000028")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_28.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 29">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000029")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_29.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 30">   
        if (lbl_almacen_ventas_detalles.getText().equals("0000030")) {

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

                        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                        String ingre_gs = txt_total_gs.getText();
                        String id_cli = txt_id_cli_ventas.getText();

                        URL in = this.getClass().getResource("/Ventas/ventas_detallado_clientes/Listado_ventas_detallado_30.jasper");

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("saldo_gs", ingre_gs);
                        parametro.put("cli", id_cli);
                        parametro.put("SUBREPORT_DIR", "Ventas/ventas_detallado_clientes/");
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
                        Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } //</editor-fold>
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Clientes_report_detalles cl;
        cl = new Clientes_report_detalles(new javax.swing.JDialog(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void lbl_almacen_ventas_detallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_ventas_detallesMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_ventas_detallado sl;
            sl = new Seleccion_ventas_detallado(new javax.swing.JDialog(), true);
            sl.setVisible(true);

        }
    }//GEN-LAST:event_lbl_almacen_ventas_detallesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
        String cliente = txt_id_cli_ventas.getText();
        String cli = "";
        /////////////////////////////////////////////////////////////////////////////
        if (cliente.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione un cliente antes de listar");
        } else {
            if (lbl_almacen_ventas_detalles.getText().equals("TODOS")) {

                String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ";

                report(mostrar);

            }

            if (lbl_almacen_ventas_detalles.getText().equals("0000001")) {

                String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ";

                report(mostrar);

            }

            if (lbl_almacen_ventas_detalles.getText().equals("0000002")) {

                String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000003")) {

                String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000004")) {

                String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000005")) {

                String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000006")) {

                String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000007")) {

                String mostrar = "SELECT * FROM ventas_7 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000008")) {

                String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000009")) {

                String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000010")) {

                String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000011")) {

                String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000012")) {

                String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000013")) {

                String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000014")) {

                String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000015")) {

                String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000016")) {

                String mostrar = "SELECT * FROM ventas_16 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000017")) {

                String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000018")) {

                String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000019")) {

                String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000020")) {

                String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000021")) {

                String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000022")) {

                String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000023")) {

                String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000024")) {

                String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000025")) {

                String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000026")) {

                String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000027")) {

                String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000028")) {

                String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000029")) {

                String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
            if (lbl_almacen_ventas_detalles.getText().equals("0000030")) {

                String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                report(mostrar);

            }
        }
        // String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' OR nom_prov_comp='" + prove + "' AND pago_comp='" + condi + "'  AND estado_comp='" + proceso + "' ORDER BY fecha_entrada DESC";
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas_clientes_detalles.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_clientes_detalles.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_clientes_detalles.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_clientes_detalles.class
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
                Ventas_clientes_detalles dialog = new Ventas_clientes_detalles(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JLabel lbl_almacen_ventas_detalles;
    public static javax.swing.JTable tb_compras;
    public static javax.swing.JTextField txt_id_cli_ventas;
    public static javax.swing.JTextField txt_nom_cli_ventas;
    public static javax.swing.JTextField txt_total_gs;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void report(String sql) {

        String[] titulos = {"N° de Ventas", "Clientes", "Condición de Pago", "Valor Total", "Fecha Salida", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas")); //Registros[4] = rs.getString("fecha_control_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_compras.setModel(model);

            tb_compras.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_compras.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_compras.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_compras.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_compras.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_compras.getColumnModel().getColumn(5).setPreferredWidth(193);
            calcularGS();
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Ventas_clientes_detalles.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
     void cargarTodosPlazo(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT * FROM compras WHERE pago_comp='PLAZO' AND fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_entrada DESC";
     String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);

     try {
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("cod_comp");
     Registros[1] = rs.getString("nom_prov_comp");
     Registros[2] = rs.getString("nro_comp");
     Registros[3] = rs.getString("valor_comp");
     Registros[4] = rs.getString("fecha_entra_comp");
     Registros[5] = rs.getString("user_comp");

     model.addRow(Registros);
     }
     tb_compras.setModel(model);

     tb_compras.getColumnModel().getColumn(0).setPreferredWidth(100);
     tb_compras.getColumnModel().getColumn(1).setPreferredWidth(330);
     tb_compras.getColumnModel().getColumn(2).setPreferredWidth(150);
     tb_compras.getColumnModel().getColumn(3).setPreferredWidth(100);
     tb_compras.getColumnModel().getColumn(4).setPreferredWidth(150);
     tb_compras.getColumnModel().getColumn(5).setPreferredWidth(193);

     } catch (SQLException ex) {
     Logger.getLogger(Ventas_report_all.class
     .getName()).log(Level.SEVERE, null, ex);
     }

     }

     void cargarTodos(Date fecha_ini, Date fecha_fin) {
     String mostrar = "SELECT * FROM compras WHERE  fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_entrada DESC";
     String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
     String[] Registros = new String[9];
     model = new DefaultTableModel(null, titulos);

     try {
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(mostrar);
     while (rs.next()) {
     Registros[0] = rs.getString("cod_comp");
     Registros[1] = rs.getString("nom_prov_comp");
     Registros[2] = rs.getString("nro_comp");
     Registros[3] = rs.getString("valor_comp");
     Registros[4] = rs.getString("fecha_entra_comp");
     Registros[5] = rs.getString("user_comp");

     model.addRow(Registros);
     }
     tb_compras.setModel(model);

     tb_compras.getColumnModel().getColumn(0).setPreferredWidth(100);
     tb_compras.getColumnModel().getColumn(1).setPreferredWidth(330);
     tb_compras.getColumnModel().getColumn(2).setPreferredWidth(150);
     tb_compras.getColumnModel().getColumn(3).setPreferredWidth(100);
     tb_compras.getColumnModel().getColumn(4).setPreferredWidth(150);
     tb_compras.getColumnModel().getColumn(5).setPreferredWidth(193);

     } catch (SQLException ex) {
     Logger.getLogger(Ventas_report_all.class
     .getName()).log(Level.SEVERE, null, ex);
     }

     }*/
    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_compras.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_compras.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs.setText(subtotal);

        }
    }//FIN METODO

    //</editor-fold>
}//FIN CLASE
