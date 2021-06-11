//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_cuenta_user;
import static Loggin_Principal.Principal.lbl_usu_almacen;
import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class Caja_Class_historicos extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Caja_Class_historicos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //cargarIN();
        txt_total_gs_ingreso.setDisabledTextColor(Color.black);

        if (lbl_usu_almacen.getText().equals("TODOS")) {
            cb_cuenta.setEnabled(true);
            cargarCuenta();

        } else {
            cb_cuenta.setEnabled(false);
            String cuenta = lbl_cuenta_user.getText();
            cb_cuenta.addItem(cuenta);

        }

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        cb_his = new org.jdesktop.swingx.JXComboBox();
        cb_cuenta = new org.jdesktop.swingx.JXComboBox();
        txt_total_gs_ingreso = new javax.swing.JTextField();
        txt_total_gs_egreso = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        valor_gs = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Movimiento por Clasificacion");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tb_ventas.setToolTipText("Movimiento Gral.");
        tb_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1060, 400));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Fecha Inicio:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Cuenta:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 60, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 60, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setToolTipText("Imprimir Mov. Gral.");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 60, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Fecha Final:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Clasificación de Históricos:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 160, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));

        cb_his.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        cb_his.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_his, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 100, 30));

        cb_cuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));
        cb_cuenta.setToolTipText("");
        cb_cuenta.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 80, 30));

        txt_total_gs_ingreso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_gs_ingreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs_ingreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_total_gs_ingreso.setEnabled(false);
        txt_total_gs_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gs_ingresoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 240, 30));

        txt_total_gs_egreso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_gs_egreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs_egreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_total_gs_egreso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_gs_egreso.setEnabled(false);
        txt_total_gs_egreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gs_egresoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs_egreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 240, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setText("Egresos=");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, -1, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Ingresos=");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, -1, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setText("Saldo :");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 60, 30));

        valor_gs.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        valor_gs.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(valor_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, 240, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, 240, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1082, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventasMouseClicked

    }//GEN-LAST:event_tb_ventasMouseClicked

    private void tb_ventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventasKeyReleased

    }//GEN-LAST:event_tb_ventasKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
        String cont = (String) cb_cuenta.getSelectedItem();
        String his = (String) cb_his.getSelectedItem();
        String var = "TODOS";
        //todos
        if (cont.equals(var) && his.equals(var)) {
            String sql = "SELECT * FROM caja as c inner join historicos_surc as h on c.moneda2_caja_in=h.cod_his where   fecha_caja BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_caja_control DESC";
            inicio();
            cargar(sql);

        } else if (!cont.equals(var) && his.equals(var)) {
            String sql = "SELECT * FROM caja as c inner join historicos_surc as h on c.moneda2_caja_in=h.cod_his where   fecha_caja BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "'  and c.cuenta_nro='" + cont + "' ORDER BY fecha_caja_control DESC";
            inicio();
            cargar(sql);

        } else if (cont.equals(var) && !his.equals(var)) {
            String sql = "SELECT * FROM caja as c inner join historicos_surc as h on c.moneda2_caja_in=h.cod_his where   fecha_caja BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' and  h.class_his='" + his + "' ORDER BY fecha_caja_control DESC";
            inicio();
            cargar(sql);

        } else {

            String sql = "SELECT * FROM caja as c inner join historicos_surc as h on c.moneda2_caja_in=h.cod_his where   fecha_caja BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' and  h.class_his='" + his + "'  and c.cuenta_nro='" + cont + "' ORDER BY fecha_caja_control DESC";
            inicio();
            cargar(sql);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((cb_his.getSelectedItem().equals("TODOS"))) {

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
                        String ingre_gs = txt_total_gs_ingreso.getText();
                        String user = Principal.lbl_usu_nom.getText();
                       String his = (String) cb_his.getSelectedItem();
                        String cta = (String) cb_cuenta.getSelectedItem();

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("ingre_gs", ingre_gs);

                        parametro.put("user", user);
                        parametro.put("hist", his);
                        parametro.put("cuenta", cta);

                        URL in = this.getClass().getResource("/Impresiones/caja_class_historico_todos.jasper");
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
                        Logger.getLogger(Caja_Class_historicos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } else {
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
                        String ingre_gs = txt_total_gs_ingreso.getText();

                        String user = Principal.lbl_usu_nom.getText();
                        String his = (String) cb_his.getSelectedItem();
                        String cta = (String) cb_cuenta.getSelectedItem();

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("ingre_gs", ingre_gs);

                        parametro.put("user", user);
                        parametro.put("hist", his);
                        parametro.put("cuenta", cta);

                        URL in = this.getClass().getResource("/Impresiones/caja_class_historico.jasper");
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
                        Logger.getLogger(Caja_Class_historicos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_total_gs_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gs_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gs_ingresoActionPerformed

    private void txt_total_gs_egresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gs_egresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gs_egresoActionPerformed
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
            java.util.logging.Logger.getLogger(Caja_Class_historicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja_Class_historicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja_Class_historicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja_Class_historicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Caja_Class_historicos dialog = new Caja_Class_historicos(new javax.swing.JDialog(), true);
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
    private org.jdesktop.swingx.JXComboBox cb_cuenta;
    private org.jdesktop.swingx.JXComboBox cb_his;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JTable tb_ventas;
    public static javax.swing.JTextField txt_total_gs_egreso;
    public static javax.swing.JTextField txt_total_gs_ingreso;
    private javax.swing.JLabel valor_gs;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(String sql) {

        String[] titulos = {"Descripción", "Histórico", "Ingreso Gs", "Egreso Gs", "Fecha de Oper.", "Usuario", "Cuenta"};
        String[] Registros = new String[11];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Registros[0] = rs.getString(2);
                Registros[1] = rs.getString(15);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(7);//colocar frecha
                Registros[5] = rs.getString(9);
                Registros[6] = rs.getString(13);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(355);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(245);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(110);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(130);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(170);
            conectar.getInstance().closeConnection(cn);
            calcularGS();
            calcularGSEgreso();
            calcularSaldoGs();
        } catch (SQLException ex) {
            Logger.getLogger(Caja_Class_historicos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

    void cargarCuenta() {

        String mostrar = "SELECT * FROM cuentas  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_cuenta.addItem(rs.getString(1));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(extracto_plazos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 2).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs_ingreso.setText(subtotal);

        }
    }//FIN METODO

    public void calcularGSEgreso() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs_egreso.setText(subtotal);

        }
    }

    public void calcularSaldoGs() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        BigDecimal PrecGS = ingreso.TransformReales(txt_total_gs_ingreso.getText().replaceAll("\\s", ""));
        BigDecimal EgreGS = ingreso.TransformReales(txt_total_gs_egreso.getText().replaceAll("\\s", ""));

        imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PrecGS.subtract(EgreGS).toString());

        valor_gs.setText(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)));

    }

    void inicio() {
        txt_total_gs_ingreso.setText("0");

    }

    //</editor-fold>
}//FIN CLASE
