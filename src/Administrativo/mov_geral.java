//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import java.awt.Color;
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

public class mov_geral extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public mov_geral(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //cargarIN();
        txt_total_gs_ingreso.setDisabledTextColor(Color.black);
        txt_total_gs_egreso.setDisabledTextColor(Color.black);
      

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    public void calcularSaldoGs() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        BigDecimal PrecGS = ingreso.TransformReales(txt_total_gs_ingreso.getText().replaceAll("\\s", ""));
        BigDecimal EgreGS = ingreso.TransformReales(txt_total_gs_egreso.getText().replaceAll("\\s", ""));

        imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PrecGS.subtract(EgreGS).toString());

        valor_gs.setText(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_total_gs_egreso = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_total_gs_ingreso = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        valor_gs = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();
        txt_his_caja_mov = new javax.swing.JTextField();
        txt_id_his_mov = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Movimiento Gral.");
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1220, 400));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Fecha Inicio:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 5, 70, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Fecha Final:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 90, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setText("Egresos=");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, -1, 30));

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
        jPanel3.add(txt_total_gs_egreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 240, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Ingresos=");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, -1, 30));

        txt_total_gs_ingreso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_gs_ingreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs_ingreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_total_gs_ingreso.setEnabled(false);
        txt_total_gs_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gs_ingresoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 240, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setText("Saldo :");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(916, 530, 60, 30));

        valor_gs.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        valor_gs.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(valor_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, 240, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, 240, 10));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Hist??rico:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 70, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton3.setToolTipText("Imprimir Mov. Gral.");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 5, 70, 40));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 50, 32));

        txt_his_caja_mov.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_his_caja_mov.setText("TODOS");
        txt_his_caja_mov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_his_caja_mov.setEnabled(false);
        jPanel3.add(txt_his_caja_mov, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 350, 32));

        txt_id_his_mov.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_his_mov.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_his_mov.setText("0");
        txt_id_his_mov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_his_mov.setEnabled(false);
        txt_id_his_mov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_his_movActionPerformed(evt);
            }
        });
        txt_id_his_mov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_his_movKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_id_his_movKeyReleased(evt);
            }
        });
        jPanel3.add(txt_id_his_mov, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 70, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventasMouseClicked

    }//GEN-LAST:event_tb_ventasMouseClicked

    private void tb_ventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventasKeyReleased

    }//GEN-LAST:event_tb_ventasKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if ((txt_id_his_mov.getText().equals("0"))) {
            java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
            java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
            cargarSh(date1, date2);
            inicio();
            calcularGS();
            calcularGSEgreso();
            calcularSaldoGs();

        } else {
            java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
            java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
            String his = txt_id_his_mov.getText();
            cargar(date1, date2, his);
            inicio();
            calcularGS();
            calcularGSEgreso();
            calcularSaldoGs();

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gs_egresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gs_egresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gs_egresoActionPerformed

    private void txt_total_gs_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gs_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gs_ingresoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if ((txt_id_his_mov.getText().equals("0"))) {

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
                        String egre_gs = txt_total_gs_egreso.getText();
                        String saldo_gs = valor_gs.getText();
                        String user = Principal.lbl_usu_nom.getText();
                        String his = txt_his_caja_mov.getText();

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("ingre_gs", ingre_gs);
                        parametro.put("egre_gs", egre_gs);
                        parametro.put("saldo_gs", saldo_gs);
                        parametro.put("user", user);
                        parametro.put("hist", his);

                        URL in = this.getClass().getResource("/Impresiones/mov_gral_sin_hist.jasper");
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
                        Logger.getLogger(mov_geral.class.getName()).log(Level.SEVERE, null, ex);
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
                        String egre_gs = txt_total_gs_egreso.getText();
                        String saldo_gs = valor_gs.getText();
                        String user = Principal.lbl_usu_nom.getText();
                        String his = txt_his_caja_mov.getText();

                        Map parametro = new HashMap();
                        parametro.clear();
                        parametro.put("fecha_ini", fecha_ini);
                        parametro.put("fecha_fin", fecha_fin);
                        parametro.put("ingre_gs", ingre_gs);
                        parametro.put("egre_gs", egre_gs);
                        parametro.put("saldo_gs", saldo_gs);
                        parametro.put("user", user);
                        parametro.put("hist", his);

                        URL in = this.getClass().getResource("/Impresiones/mov_gral.jasper");

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
                        Logger.getLogger(mov_geral.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            Surcusal_historicos_movimiento shg;
            shg = new Surcusal_historicos_movimiento(new javax.swing.JDialog(), true);
            shg.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_id_his_movActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_his_movActionPerformed
    
    }//GEN-LAST:event_txt_id_his_movActionPerformed

    private void txt_id_his_movKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_his_movKeyPressed
  
    }//GEN-LAST:event_txt_id_his_movKeyPressed

    private void txt_id_his_movKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_his_movKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_his_movKeyReleased
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
            java.util.logging.Logger.getLogger(mov_geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mov_geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mov_geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mov_geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                mov_geral dialog = new mov_geral(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel14;
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
    public static javax.swing.JTextField txt_his_caja_mov;
    public static javax.swing.JTextField txt_id_his_mov;
    public static javax.swing.JTextField txt_total_gs_egreso;
    public static javax.swing.JTextField txt_total_gs_ingreso;
    private javax.swing.JLabel valor_gs;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String his) {
        String mostrar = "SELECT * FROM caja  WHERE moneda2_caja_in = '" + his + "'  AND fecha_caja BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_caja_control DESC";
        String[] titulos = {"Descripci??n", "Hist??rico", "Ingreso Gs", "Egreso Gs", "Fecha de Oper.", "Usuario", "Cuenta"};
        String[] Registros = new String[11];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("des_caja");
                Registros[1] = rs.getString("moneda2_caja_in");
                Registros[2] = rs.getString("moneda1_caja_in");
                Registros[3] = rs.getString("moneda1_caja_eg");
                Registros[4] = rs.getString("fecha_caja");
                Registros[5] = rs.getString("user");
                Registros[6] = rs.getString("cuenta_nom");

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

        } catch (SQLException ex) {
            Logger.getLogger(mov_geral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSh(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM caja  WHERE  fecha_caja BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "'  ORDER BY fecha_caja_control DESC";
        String[] titulos = {"Descripci??n", "Hist??rico", "Ingreso Gs", "Egreso Gs", "Fecha de Oper.", "Usuario", "Cuenta"};
        String[] Registros = new String[11];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("des_caja");
                Registros[1] = rs.getString("moneda2_caja_in");
                Registros[2] = rs.getString("moneda1_caja_in");
                Registros[3] = rs.getString("moneda1_caja_eg");
                Registros[4] = rs.getString("fecha_caja");
                Registros[5] = rs.getString("user");
                Registros[6] = rs.getString("cuenta_nom");
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

        } catch (SQLException ex) {
            Logger.getLogger(mov_geral.class.getName()).log(Level.SEVERE, null, ex);
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
    }//FIN METODO

    //</editor-fold>
    void inicio() {
        txt_total_gs_ingreso.setText("0");
        txt_total_gs_egreso.setText("0");
        valor_gs.setText("0");

    }
}//FIN CLASE
