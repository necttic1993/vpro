//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Gastos;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
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
import net.sf.jasperreports.view.JasperViewer;
//</editor-fold>

public class Egresoos_consulta extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Egresoos_consulta(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_total_gs.setDisabledTextColor(Color.black);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_consulta = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_total_gs = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();
        jButton3 = new javax.swing.JButton();
        txt_id_prov_lista = new javax.swing.JTextField();
        txt_provee_lista = new javax.swing.JTextField();
        txt_hist_lista = new javax.swing.JTextField();
        txt_id_class_lista = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_buscar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Egresos");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_consulta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_consultaMouseClicked(evt);
            }
        });
        tb_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_consultaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_consulta);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 970, 370));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setToolTipText("Consultar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 70, 50));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Fecha Final:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Valor Total:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 90, 30));

        txt_total_gs.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txt_total_gs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs.setText("0");
        txt_total_gs.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_gs.setEnabled(false);
        txt_total_gs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gsActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 180, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Clasificación:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

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
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 70, 50));

        txt_id_prov_lista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_id_prov_lista.setText("0");
        txt_id_prov_lista.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_prov_lista.setEnabled(false);
        jPanel3.add(txt_id_prov_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 90, 30));

        txt_provee_lista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_provee_lista.setText("TODOS");
        txt_provee_lista.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_provee_lista.setEnabled(false);
        txt_provee_lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_provee_listaKeyTyped(evt);
            }
        });
        jPanel3.add(txt_provee_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 310, 30));

        txt_hist_lista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_hist_lista.setText("TODOS");
        txt_hist_lista.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hist_lista.setEnabled(false);
        txt_hist_lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hist_listaKeyTyped(evt);
            }
        });
        jPanel3.add(txt_hist_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 310, 30));

        txt_id_class_lista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_id_class_lista.setText("0");
        txt_id_class_lista.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_class_lista.setEnabled(false);
        jPanel3.add(txt_id_class_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 90, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Proveedor:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_buscar.setToolTipText("");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 50, 32));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 50, 32));

        btn_buscar1.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_buscar1.setToolTipText("");
        btn_buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 50, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_consultaMouseClicked
        /*int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_consultaMouseClicked

    private void tb_consultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_consultaKeyReleased

    }//GEN-LAST:event_tb_consultaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
        java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());

        String id_provee = txt_id_prov_lista.getText();
        String id_class = txt_id_class_lista.getText();
        String var = "0";

        if (id_provee.equals(var) && id_class.equals(var)) {
            //caso que todos esten en cero
            String mostrar = "SELECT * FROM gastos WHERE  gas_fecha_entra BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ";
            System.out.println(mostrar);
            report(mostrar);
        } else if (!id_provee.equals(var) && id_class.equals(var)) {
            //caso en que exista id del proveedor
            String mostrar = "SELECT * FROM gastos WHERE  gas_fecha_entra BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND gas_provee= '" + id_provee + "' ";
            System.out.println(mostrar);
            report(mostrar);

        } else if (!id_provee.equals(var) && !id_class.equals(var)) {
            //caso en que exista dos codigo de busca
            String mostrar = "SELECT * FROM gastos WHERE  gas_fecha_entra BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND gas_provee= '" + id_provee + "' AND gas_histo= '" + id_class + "'";
            System.out.println(mostrar);
            report(mostrar);

        } else if (id_provee.equals(var) && !id_class.equals(var)) {
            //caso  que exista solo id de historico

            String mostrar = "SELECT * FROM gastos WHERE  gas_fecha_entra BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND gas_histo= '" + id_class + "' ";
            System.out.println(mostrar);
            report(mostrar);
        } else {
            System.out.println("no se pudo listar");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                lista_gastos cl;// Instaciamos la clase empleado
                List<lista_gastos> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_consulta.getRowCount(); i++) { // Iterena cada fila de la tabla
                    cl = new lista_gastos(tb_consulta.getValueAt(i, 0).toString(), tb_consulta.getValueAt(i, 1).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_consulta.getValueAt(i, 2).toString(), tb_consulta.getValueAt(i, 3).toString(), tb_consulta.getValueAt(i, 4).toString(), tb_consulta.getValueAt(i, 5).toString());
                    lista.add(cl); //Agregamos el objeto empleado a la lista
                  
                }

                try {

                    java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                    java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());

                    String pro = txt_provee_lista.getText();
                    String clas = txt_hist_lista.getText();
                    String saldo_gs = txt_total_gs.getText();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini);
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("prove", pro);
                    parametro.put("class", clas);
                    parametro.put("saldo_gs", saldo_gs);
               

                    URL in = this.getClass().getResource("/Impresiones/gastos_report_espec.jasper");
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                } catch (JRException ex) {
                    Logger.getLogger(Egresoos_consulta.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        /* if (cb_users.getSelectedItem().equals("TODOS")) {

         PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
         if (printService.length > 0)//si existen impresoras
         {
         //se elige la impresora
         PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
         "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
         if (impresora != null) //Si se selecciono una impresora
         {

         try {

         java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
         java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
         String ingre_gs = txt_total_gs.getText();
         Connection cn = conectar.getInstance().getConnection();

         Map parametro = new HashMap();
         parametro.clear();
         parametro.put("fecha_ini", fecha_ini);
         parametro.put("fecha_fin", fecha_fin);
         parametro.put("saldo_gs", ingre_gs);
         parametro.put("SUBREPORT_DIR", "Impresiones/");

         URL in = this.getClass().getResource("/Impresiones/gastos_report.jasper");

         JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
         JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
         JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

         jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
         jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);

         jrprintServiceExporter.exportReport();
         conectar.getInstance().closeConnection(cn);

         } catch (JRException ex) {

         } catch (SQLException ex) {
         Logger.getLogger(Egresoos_consulta.class.getName()).log(Level.SEVERE, null, ex);
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

         java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
         java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
         String ingre_gs = txt_total_gs.getText();
         String prove = (String) cb_users.getSelectedItem();
         Connection cn = conectar.getInstance().getConnection();

         Map parametro = new HashMap();
         parametro.clear();
         parametro.put("fecha_ini", fecha_ini);
         parametro.put("fecha_fin", fecha_fin);
         parametro.put("saldo_gs", ingre_gs);
         parametro.put("prove", prove);

         URL in = this.getClass().getResource("/Impresiones/gastos_report_espec.jasper");
         /* JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
         JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
         JasperViewer ver = new JasperViewer(print, false);
         ver.setTitle("Egresos");
         ver.setVisible(true);*/

        /* JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
         JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
         JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
         jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
         jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService);
         jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
         jrprintServiceExporter.exportReport();*/
        /*
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
         Logger.getLogger(Egresoos_consulta.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         }
         }

         this.dispose();*/
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_provee_listaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_provee_listaKeyTyped

    }//GEN-LAST:event_txt_provee_listaKeyTyped

    private void txt_hist_listaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hist_listaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hist_listaKeyTyped

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        historicos_gastos_lista hle;
        hle = new historicos_gastos_lista(new javax.swing.JDialog(), true);
        hle.setVisible(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txt_id_prov_lista.setText("0");
        txt_provee_lista.setText("TODOS");
        txt_id_class_lista.setText("0");
        txt_hist_lista.setText("TODOS");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed
        provee_gastos_lista ple;
        ple = new provee_gastos_lista(new javax.swing.JDialog(), true);
        ple.setVisible(true);
    }//GEN-LAST:event_btn_buscar1ActionPerformed
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
            java.util.logging.Logger.getLogger(Egresoos_consulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Egresoos_consulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Egresoos_consulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Egresoos_consulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Egresoos_consulta dialog = new Egresoos_consulta(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_buscar1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JTable tb_consulta;
    public static javax.swing.JTextField txt_hist_lista;
    public static javax.swing.JTextField txt_id_class_lista;
    public static javax.swing.JTextField txt_id_prov_lista;
    public static javax.swing.JTextField txt_provee_lista;
    public static javax.swing.JTextField txt_total_gs;
    // End of variables declaration//GEN-END:variables

    void report(String sql) {

        String[] titulos = {"Egreso N°", "Descripción", "Estado", " Valor Total", "Fecha de Entrada", "N° Factura"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("gas_id");
                Registros[1] = rs.getString("gas_des");
                Registros[2] = rs.getString("gas_situ");
                Registros[3] = rs.getString("gas_monto");
                Registros[4] = rs.getString("data_vista");
                Registros[5] = rs.getString("gas_num");

                model.addRow(Registros);
            }
            tb_consulta.setModel(model);

            tb_consulta.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_consulta.getColumnModel().getColumn(1).setPreferredWidth(400);
            tb_consulta.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_consulta.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_consulta.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_consulta.getColumnModel().getColumn(5).setPreferredWidth(120);
            calcularGS();
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Egresoos_consulta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_consulta.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_consulta.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs.setText(subtotal);

        }
    }
}
