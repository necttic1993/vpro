//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Caja_2;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Seleccion_alma_froma_pago;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
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
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
//</editor-fold>

public class List_forma_pago_caja extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public List_forma_pago_caja(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //cargarPro();
        ch_todos.setSelected(true);
        cb_forma_pago.setEnabled(false);
        btn_buscar.setEnabled(false);
        ch_clientes.setSelected(false);
        btn_foma_cliente.setEnabled(false);
        btn_cuentas.setEnabled(false);
    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        lbl_nro_cuenta_forma = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jd_fin = new org.jdesktop.swingx.JXDatePicker();
        jd_ini = new org.jdesktop.swingx.JXDatePicker();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_total_ventas_lucro = new javax.swing.JTextField();
        ch_clientes = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        cb_forma_pago = new org.jdesktop.swingx.JXComboBox();
        lbl_nro_sucursal = new javax.swing.JLabel();
        ch_situacion = new javax.swing.JCheckBox();
        ch_todos = new javax.swing.JCheckBox();
        ch_descrip = new javax.swing.JCheckBox();
        ch_cuentas = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_provee_forma = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txt_id_cli_ventas = new javax.swing.JTextField();
        txt_nom_cli_ventas = new javax.swing.JTextField();
        btn_foma_cliente = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btn_cuentas = new javax.swing.JButton();

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
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 70, 40));

        lbl_nro_cuenta_forma.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nro_cuenta_forma.setForeground(new java.awt.Color(204, 0, 0));
        lbl_nro_cuenta_forma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nro_cuenta_forma.setText("0");
        lbl_nro_cuenta_forma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.add(lbl_nro_cuenta_forma, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 100, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Desde:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 70, 40));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1060, 360));

        jd_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jd_finActionPerformed(evt);
            }
        });
        jPanel3.add(jd_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 130, 30));
        jPanel3.add(jd_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 140, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Hasta:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 50, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Total General:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, 120, 30));

        txt_total_ventas_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_ventas_lucro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_ventas_lucro.setText("0");
        txt_total_ventas_lucro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_ventas_lucro.setEnabled(false);
        jPanel3.add(txt_total_ventas_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 520, 190, 30));

        ch_clientes.setBackground(new java.awt.Color(255, 255, 255));
        ch_clientes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ch_clientes.setText("Clientes");
        ch_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_clientesActionPerformed(evt);
            }
        });
        jPanel3.add(ch_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 140, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Cliente:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 90, 30));

        cb_forma_pago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EFECTIVO", "CHEQUE", "TJ  CRÉDITO", "TJ DÉBITO", "GIROS", "TRANSFERENCIAS BANCARIAS", "DEPÓSITOS BANCARIOS" }));
        cb_forma_pago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_forma_pago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_forma_pagoItemStateChanged(evt);
            }
        });
        cb_forma_pago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_forma_pagoMouseClicked(evt);
            }
        });
        cb_forma_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_forma_pagoActionPerformed(evt);
            }
        });
        jPanel3.add(cb_forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 250, 30));

        lbl_nro_sucursal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_nro_sucursal.setForeground(new java.awt.Color(51, 153, 0));
        lbl_nro_sucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nro_sucursal.setText("0000000");
        lbl_nro_sucursal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.add(lbl_nro_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 100, 30));

        ch_situacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ch_situacion.setText("Forma de Pago");
        ch_situacion.setContentAreaFilled(false);
        ch_situacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_situacionActionPerformed(evt);
            }
        });
        jPanel3.add(ch_situacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 30));

        ch_todos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ch_todos.setText("Todos");
        ch_todos.setContentAreaFilled(false);
        ch_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_todosActionPerformed(evt);
            }
        });
        jPanel3.add(ch_todos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, 30));

        ch_descrip.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ch_descrip.setText("Proveedores");
        ch_descrip.setContentAreaFilled(false);
        ch_descrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_descripActionPerformed(evt);
            }
        });
        jPanel3.add(ch_descrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 30));

        ch_cuentas.setBackground(new java.awt.Color(255, 255, 255));
        ch_cuentas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ch_cuentas.setText("Cuentas");
        ch_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_cuentasActionPerformed(evt);
            }
        });
        jPanel3.add(ch_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 140, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Forma de Pago:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 120, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel15.setText("Filtrar por:");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 1050, 40));

        txt_provee_forma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_provee_forma.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_provee_forma.setEnabled(false);
        jPanel3.add(txt_provee_forma, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 390, 30));

        btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 60, 32));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Proveedor:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        txt_id_cli_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_cli_ventas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_id_cli_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cli_ventas.setEnabled(false);
        jPanel3.add(txt_id_cli_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 80, 30));

        txt_nom_cli_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom_cli_ventas.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_cli_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_ventas.setEnabled(false);
        jPanel3.add(txt_nom_cli_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 310, 30));

        btn_foma_cliente.setBackground(new java.awt.Color(255, 255, 255));
        btn_foma_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_foma_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_foma_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_foma_clienteActionPerformed(evt);
            }
        });
        jPanel3.add(btn_foma_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 60, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Cuenta N°:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 80, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Sucursal N°:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 100, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 60, 30));

        btn_cuentas.setBackground(new java.awt.Color(255, 255, 255));
        btn_cuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_cuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuentasActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
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

        if (lbl_nro_sucursal.getText().equals("0000000")) {
            JOptionPane.showMessageDialog(null, "Selecione un sucursal/Almacen");
        } else {

            if (ch_todos.isSelected()) {
                PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    //se elige la impresora
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                            "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {

                        try {

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin.getDate().getTime());
                            String cuenta = lbl_nro_cuenta_forma.getText();
                            String total = txt_total_ventas_lucro.getText();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fechaIni", fecha_ini);
                            parametro.put("fechaFin", fecha_fin);
                            parametro.put("total", total);
                            parametro.put("cuenta", cuenta);

                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Caja_2/Listar_forma_pago.jasper");
                            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                            JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                            jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                            jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                            //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                            jrprintServiceExporter.exportReport();
                            conectar.getInstance().closeConnection(cn);

                        } catch (JRException ex) {
                            Logger.getLogger(List_forma_pago_caja.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
            if (ch_situacion.isSelected()) {
                PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    //se elige la impresora
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                            "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {

                        try {

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin.getDate().getTime());
                            String cuenta = lbl_nro_cuenta_forma.getText();
                            String total = txt_total_ventas_lucro.getText();
                            String situ = (String) cb_forma_pago.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fechaIni", fecha_ini);
                            parametro.put("fechaFin", fecha_fin);
                            parametro.put("total", total);
                            parametro.put("cuenta", cuenta);
                            parametro.put("situ", situ);
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Caja_2/Listar_forma_pago_situ.jasper");
                            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                            JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                            jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                            jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                            //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                            jrprintServiceExporter.exportReport();
                            conectar.getInstance().closeConnection(cn);

                        } catch (JRException ex) {
                            Logger.getLogger(List_forma_pago_caja.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

            if (ch_descrip.isSelected()) {
                PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    //se elige la impresora
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                            "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {

                        try {

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin.getDate().getTime());
                            String cuenta = lbl_nro_cuenta_forma.getText();
                            String total = txt_total_ventas_lucro.getText();
                            String provee = txt_provee_forma.getText();
                            String situ = (String) cb_forma_pago.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fechaIni", fecha_ini);
                            parametro.put("fechaFin", fecha_fin);
                            parametro.put("total", total);
                            parametro.put("cuenta", cuenta);
                            parametro.put("provee", provee);
                            parametro.put("situ", situ);
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Caja_2/Listar_forma_pago_provee.jasper");
                            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                            JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                            jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                            jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                            //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                            jrprintServiceExporter.exportReport();
                            conectar.getInstance().closeConnection(cn);

                        } catch (JRException ex) {
                            Logger.getLogger(List_forma_pago_caja.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

            if (ch_clientes.isSelected()) {

                PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    //se elige la impresora
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                            "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {

                        try {

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin.getDate().getTime());
                            ///
                            String cuenta = lbl_nro_cuenta_forma.getText();
                            String total = txt_total_ventas_lucro.getText();
                            String sucursal = lbl_nro_sucursal.getText();
                            String clientes = txt_id_cli_ventas.getText();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fechaIni", fecha_ini);
                            parametro.put("fechaFin", fecha_fin);
                            parametro.put("total", total);
                            parametro.put("cuenta", cuenta);
                            parametro.put("sucursal", sucursal);
                            parametro.put("clientes", clientes);
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Caja_2/Listar_forma_pago_clientes.jasper");
                            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                            JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                            jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                            jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                            //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                            jrprintServiceExporter.exportReport();
                            conectar.getInstance().closeConnection(cn);

                        } catch (JRException ex) {
                            Logger.getLogger(List_forma_pago_caja.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

            if (ch_cuentas.isSelected()) {
                  PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    //se elige la impresora
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                            "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {

                        try {

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin.getDate().getTime());
                            ///
                            String cuenta = lbl_nro_cuenta_forma.getText();
                            String total = txt_total_ventas_lucro.getText();
                            String sucursal = lbl_nro_sucursal.getText();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fechaIni", fecha_ini);
                            parametro.put("fechaFin", fecha_fin);
                            parametro.put("total", total);
                            parametro.put("cuenta", cuenta);
                            parametro.put("sucursal", sucursal);
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Caja_2/Listar_forma_pago_cuentas.jasper");
                            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                            JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                            jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                            jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                            //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                            jrprintServiceExporter.exportReport();
                            conectar.getInstance().closeConnection(cn);

                        } catch (JRException ex) {
                            Logger.getLogger(List_forma_pago_caja.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (lbl_nro_sucursal.getText().equals("0000000")) {
            JOptionPane.showMessageDialog(null, "Selecione un sucursal/Almacen");
        } else {
            if (ch_todos.isSelected()) {
                String sucursal = lbl_nro_sucursal.getText();
                java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());
                cargar(date1, date2, sucursal);
                calcular();
            }
            if (ch_situacion.isSelected()) {

                String situacion = (String) cb_forma_pago.getSelectedItem();
                String sucursales = lbl_nro_sucursal.getText();
                java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());
                cargarSitu(date1, date2, situacion, sucursales);
                calcular();
            }

            if (ch_descrip.isSelected()) {

                String cuenta = lbl_nro_cuenta_forma.getText();
                String provee = txt_provee_forma.getText();
                String sucursales = lbl_nro_sucursal.getText();
                String situacion = (String) cb_forma_pago.getSelectedItem();
                java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());
                cargarAll(date1, date2, situacion, provee, sucursales);
                calcular();
            }

            if (ch_clientes.isSelected()) {
                if (txt_id_cli_ventas.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente válido");
                } else {

                    String clientes = txt_id_cli_ventas.getText();
                    String sucursales = lbl_nro_sucursal.getText();
                    String cuenta = lbl_nro_cuenta_forma.getText();
                    java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());
                    cargar_clientes(date1, date2, sucursales, clientes);
                    calcular();
                }

            }

            if (ch_cuentas.isSelected()) {
                String cuenta = lbl_nro_cuenta_forma.getText();
                String sucursales = lbl_nro_sucursal.getText();
                java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());
                cargarCuenta(date1, date2, sucursales, cuenta);
                calcular();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jd_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jd_finActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jd_finActionPerformed

    private void cb_forma_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_forma_pagoActionPerformed


    }//GEN-LAST:event_cb_forma_pagoActionPerformed

    private void ch_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_todosActionPerformed

        ch_descrip.setSelected(false);
        ch_situacion.setSelected(false);
        cb_forma_pago.setEnabled(false);
        ch_cuentas.setSelected(false);
        ch_clientes.setSelected(false);
        ////
        btn_buscar.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_foma_cliente.setEnabled(false);


    }//GEN-LAST:event_ch_todosActionPerformed

    private void ch_situacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_situacionActionPerformed
        ch_todos.setSelected(false);
        ch_descrip.setSelected(false);
        ch_situacion.setSelected(true);
        cb_forma_pago.setEnabled(true);
        ch_cuentas.setSelected(false);
        ch_clientes.setSelected(false);
        ////
        btn_buscar.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_foma_cliente.setEnabled(false);


    }//GEN-LAST:event_ch_situacionActionPerformed

    private void ch_descripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_descripActionPerformed
        ch_todos.setSelected(false);
        ch_descrip.setSelected(true);
        ch_situacion.setSelected(false);
        cb_forma_pago.setEnabled(true);
        ch_cuentas.setSelected(false);
        ch_clientes.setSelected(false);
        ////
        btn_buscar.setEnabled(true);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_foma_cliente.setEnabled(false);

    }//GEN-LAST:event_ch_descripActionPerformed

    private void cb_forma_pagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_forma_pagoItemStateChanged

    }//GEN-LAST:event_cb_forma_pagoItemStateChanged

    private void cb_forma_pagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_forma_pagoMouseClicked

    }//GEN-LAST:event_cb_forma_pagoMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        if (cb_forma_pago.getSelectedItem().equals("EFECTIVO")) {
            txt_provee_forma.setText("PARTICULAR");
        }
        if (cb_forma_pago.getSelectedItem().equals("CHEQUE")) {
            Lista_bancos_forma bf;
            bf = new Lista_bancos_forma(new javax.swing.JDialog(), true);
            bf.setVisible(true);
        }
        if (cb_forma_pago.getSelectedItem().equals("TJ CRÉDITO")) {
            txt_provee_forma.setText("TARJETA");
        }
        if (cb_forma_pago.getSelectedItem().equals("TJ DÉBITO")) {
            txt_provee_forma.setText("TARJETA");
        }
        if (cb_forma_pago.getSelectedItem().equals("GIROS")) {
            Proveedor_List_Forma pf;
            pf = new Proveedor_List_Forma(new javax.swing.JDialog(), true);
            pf.setVisible(true);
        }
        if (cb_forma_pago.getSelectedItem().equals("TRANSFERENCIAS BANCARIAS")) {
            Lista_bancos_forma bf;
            bf = new Lista_bancos_forma(new javax.swing.JDialog(), true);
            bf.setVisible(true);
        }
        if (cb_forma_pago.getSelectedItem().equals("DEPÓSITOS BANCARIOS")) {
            Lista_bancos_forma bf;
            bf = new Lista_bancos_forma(new javax.swing.JDialog(), true);
            bf.setVisible(true);
        }


    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_foma_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_foma_clienteActionPerformed
        Clientes_report_froma_pago cl;
        cl = new Clientes_report_froma_pago(new javax.swing.JDialog(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_btn_foma_clienteActionPerformed

    private void ch_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_clientesActionPerformed
        ch_todos.setSelected(false);
        ch_descrip.setSelected(false);
        ch_situacion.setSelected(false);
        cb_forma_pago.setEnabled(false);
        ch_cuentas.setSelected(false);
        ch_clientes.setSelected(true);
        ////
        btn_buscar.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_foma_cliente.setEnabled(true);
    }//GEN-LAST:event_ch_clientesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Seleccion_alma_froma_pago sla;
        sla = new Seleccion_alma_froma_pago(new javax.swing.JDialog(), true);
        sla.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ch_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_cuentasActionPerformed
        ch_todos.setSelected(false);
        ch_descrip.setSelected(false);
        ch_situacion.setSelected(false);
        cb_forma_pago.setEnabled(false);
        ch_cuentas.setSelected(true);
        ch_clientes.setSelected(false);
        ////
        btn_buscar.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(false);
        btn_cuentas.setEnabled(true);
        btn_foma_cliente.setEnabled(false);
    }//GEN-LAST:event_ch_cuentasActionPerformed

    private void btn_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuentasActionPerformed

        Cuentas_forma_pago cla;
        cla = new Cuentas_forma_pago(new javax.swing.JDialog(), true);
        cla.setVisible(true);
    }//GEN-LAST:event_btn_cuentasActionPerformed
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
            java.util.logging.Logger.getLogger(List_forma_pago_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_forma_pago_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_forma_pago_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_forma_pago_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                List_forma_pago_caja dialog = new List_forma_pago_caja(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cuentas;
    private javax.swing.JButton btn_foma_cliente;
    private org.jdesktop.swingx.JXComboBox cb_forma_pago;
    private javax.swing.JCheckBox ch_clientes;
    private javax.swing.JCheckBox ch_cuentas;
    private javax.swing.JCheckBox ch_descrip;
    private javax.swing.JCheckBox ch_situacion;
    private javax.swing.JCheckBox ch_todos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static org.jdesktop.swingx.JXDatePicker jd_fin;
    public static org.jdesktop.swingx.JXDatePicker jd_ini;
    public static javax.swing.JLabel lbl_nro_cuenta_forma;
    public static javax.swing.JLabel lbl_nro_sucursal;
    public static javax.swing.JTable tb_ventas;
    public static javax.swing.JTextField txt_id_cli_ventas;
    public static javax.swing.JTextField txt_nom_cli_ventas;
    public static javax.swing.JTextField txt_provee_forma;
    public static javax.swing.JTextField txt_total_ventas_lucro;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String almacen) {
        String mostrar = "SELECT * FROM forma_pago WHERE fecha_det_con BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'   AND pago_surc='" + almacen + "'  ORDER BY fecha_det_con ASC";
        String[] titulos = {"N° Doc.", "Forma de Pago", "Proveedor", "Clasificación", "Monto", " Fecha Entrada", "Usuario", "Nro Oper."};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(2);
                Registros[1] = rs.getString(3);
                Registros[2] = rs.getString(4);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(6);
                Registros[5] = rs.getString(8);
                Registros[6] = rs.getString(9);
                Registros[7] = rs.getString(10);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSitu(Date fecha_ini, Date fecha_fin, String Situacion, String almacen) {
        String mostrar = "SELECT * FROM forma_pago WHERE fecha_det_con BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'     AND tipo_pago ='" + Situacion + "' AND pago_surc='" + almacen + "' ORDER BY fecha_det_con ASC";
        String[] titulos = {"N° Doc.", "Forma de Pago", "Proveedor", "Clasificación", "Monto", " Fecha Entrada", "Usuario", "Nro Oper."};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(2);
                Registros[1] = rs.getString(3);
                Registros[2] = rs.getString(4);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(6);
                Registros[5] = rs.getString(8);
                Registros[6] = rs.getString(9);
                Registros[7] = rs.getString(10);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar_clientes(Date fecha_ini, Date fecha_fin, String sucursal, String clientes) {
        String sql = "SELECT f.nro_doc,f.tipo_pago,f.pago_cont,f.clas,f.monto,f.fecha_vista,f.user,f.nro_doc_pag FROM forma_pago as  f inner join  ventas as v on f.nro_doc_pag=v.num_bol inner join tienda_clientes as c on c.cli_cod=v.cod_cli_ventas where  fecha_det_con BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "' and c.cli_cod='" + clientes + "' and f.pago_surc='" + sucursal + "'  ORDER BY fecha_det_con ASC";
        String[] titulos = {"N° Doc.", "Forma de Pago", "Proveedor", "Clasificación", "Monto", " Fecha Entrada", "Usuario", "Nro Oper."};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(4);
                Registros[4] = rs.getString(5);
                Registros[5] = rs.getString(6);
                Registros[6] = rs.getString(7);
                Registros[7] = rs.getString(8);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarAll(Date fecha_ini, Date fecha_fin, String Situacion, String provee, String almacen) {
        String mostrar = "SELECT * FROM forma_pago WHERE fecha_det_con BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'   AND tipo_pago ='" + Situacion + "' AND pago_cont ='" + provee + "' AND pago_surc='" + almacen + "' ORDER BY fecha_det_con ASC";
        String[] titulos = {"N° Doc.", "Forma de Pago", "Proveedor", "Clasificación", "Monto", " Fecha Entrada", "Usuario", "Nro Oper."};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(2);
                Registros[1] = rs.getString(3);
                Registros[2] = rs.getString(4);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(6);
                Registros[5] = rs.getString(8);
                Registros[6] = rs.getString(9);
                Registros[7] = rs.getString(10);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarCuenta(Date fecha_ini, Date fecha_fin, String cuenta, String almacen) {
        String mostrar = "SELECT * FROM forma_pago WHERE fecha_det_con BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'   AND nro_cuenta_pag ='" + cuenta + "'   AND pago_surc='" + almacen + "' ORDER BY fecha_det_con ASC";
        String[] titulos = {"N° Doc.", "Forma de Pago", "Proveedor", "Clasificación", "Monto", " Fecha Entrada", "Usuario", "Nro Oper."};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(2);
                Registros[1] = rs.getString(3);
                Registros[2] = rs.getString(4);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(6);
                Registros[5] = rs.getString(8);
                Registros[6] = rs.getString(9);
                Registros[7] = rs.getString(10);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(List_forma_pago_caja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////////calculo de totales/////////////////////
    public void calcular() {

        String impv = "0", subtotales = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            impv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotales = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotales).add(ingreso.TransformReales(impv)).toString());

            txt_total_ventas_lucro.setText(subtotales);

        }
    }

}//FIN CLASE
