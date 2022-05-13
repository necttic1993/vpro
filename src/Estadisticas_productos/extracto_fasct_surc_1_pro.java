/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticas_productos;

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Productos.excell.ModeloExcel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
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
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class extracto_fasct_surc_1_pro extends javax.swing.JDialog {

    DefaultTableModel model;
    private static DefaultTableCellRenderer tcr;

    public extracto_fasct_surc_1_pro(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_razon_pro.setBackground(new java.awt.Color(69, 84, 92));

        }

    }

    ModeloExcel modeloE = new ModeloExcel();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_razon_pro = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_control = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_cant_pro = new javax.swing.JTextField();
        jd_fin = new org.jdesktop.swingx.JXDatePicker();
        jd_ini = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_valor_pro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_seq_cambio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_nom_cli_fact = new javax.swing.JTextField();
        txt_id_cli = new javax.swing.JTextField();
        btn_buscar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_valor_util = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Razón del Productos en  Fact. ");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_razon_pro.setBackground(new java.awt.Color(255, 255, 255));
        panel_razon_pro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/busqueda.png"))); // NOI18N
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panel_razon_pro.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 60, 40));

        tb_control.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_control.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_control.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tb_control.setShowHorizontalLines(false);
        tb_control.setShowVerticalLines(false);
        tb_control.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_controlMouseClicked(evt);
            }
        });
        tb_control.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_controlKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tb_control);

        panel_razon_pro.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1120, 460));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Fecha Final:");
        panel_razon_pro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 80, 30));

        txt_cant_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cant_pro.setText("0");
        txt_cant_pro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_cant_pro.setEnabled(false);
        panel_razon_pro.add(txt_cant_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 110, 30));
        panel_razon_pro.add(jd_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 110, 30));
        panel_razon_pro.add(jd_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 110, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad:");
        panel_razon_pro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, 70, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Cliente:");
        panel_razon_pro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        jButton2.setToolTipText("Imprimir Listado en Excell");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_razon_pro.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, 60, 40));

        txt_valor_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_pro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_pro.setText("0");
        txt_valor_pro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_pro.setEnabled(false);
        panel_razon_pro.add(txt_valor_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 150, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Total Valor Utilidad:");
        panel_razon_pro.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, 110, 30));

        txt_seq_cambio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_seq_cambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_seq_cambioKeyTyped(evt);
            }
        });
        panel_razon_pro.add(txt_seq_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 60, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Sequencia:");
        panel_razon_pro.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 70, 30));

        txt_nom_cli_fact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nom_cli_fact.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_fact.setEnabled(false);
        panel_razon_pro.add(txt_nom_cli_fact, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 370, 32));

        txt_id_cli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_id_cli.setText("0");
        txt_id_cli.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cli.setEnabled(false);
        txt_id_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_cliActionPerformed(evt);
            }
        });
        panel_razon_pro.add(txt_id_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 32));

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
        panel_razon_pro.add(btn_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 50, 32));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Fecha Inicio:");
        panel_razon_pro.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Total Valor:");
        panel_razon_pro.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 70, 30));

        txt_valor_util.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_util.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_util.setText("0");
        txt_valor_util.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_util.setEnabled(false);
        panel_razon_pro.add(txt_valor_util, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 150, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/pdf.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_razon_pro.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 60, 40));

        getContentPane().add(panel_razon_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) tb_control.getModel();
        int a = tb_control.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
        txt_cant_pro.setText("0");
        txt_valor_pro.setText("0");

        String id_cli = txt_id_cli.getText();
        String nro_seq = txt_seq_cambio.getText();
        java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());

        if (txt_seq_cambio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione nro de sequencia");
        } else {
            if (id_cli.equals("0")) {
                cargarDetalle(date1, date2, nro_seq);
                calcularUtil();
                calcularcantida();
                calcularGS();
                calcularTotalUtil();
                System.out.println("solo seq");

            } else {
                cargarDetalleCli(date1, date2, nro_seq, id_cli);
                calcularUtil();
                calcularcantida();
                calcularGS();
                calcularTotalUtil();
                System.out.println("seq + cliente");

            }

        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tb_controlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_controlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_controlMouseClicked

    private void tb_controlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_controlKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_controlKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (selecArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, tb_control) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_seq_cambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_seq_cambioKeyTyped
        int cant = 3;
        if (txt_seq_cambio.getText().length() >= cant) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_seq_cambioKeyTyped

    private void txt_id_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_cliActionPerformed

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed

        Clientes_fact_pro_ventas cli_search;
        cli_search = new Clientes_fact_pro_ventas(new javax.swing.JDialog(), true);
        cli_search.setVisible(true);

    }//GEN-LAST:event_btn_buscar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                Salida_fact_prod_1 ps;//
                List<Salida_fact_prod_1> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_control.getRowCount(); i++) { // Iterena cada fila de la tabla
                    ps = new Salida_fact_prod_1(tb_control.getValueAt(i, 0).toString(), tb_control.getValueAt(i, 1).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_control.getValueAt(i, 2).toString(), tb_control.getValueAt(i, 3).toString(), tb_control.getValueAt(i, 4).toString(), tb_control.getValueAt(i, 5).toString(), tb_control.getValueAt(i, 6).toString(), tb_control.getValueAt(i, 7).toString(), tb_control.getValueAt(i, 8).toString(), tb_control.getValueAt(i, 9).toString()
                    , tb_control.getValueAt(i, 10).toString(), tb_control.getValueAt(i, 11).toString(), tb_control.getValueAt(i, 12).toString(), tb_control.getValueAt(i, 13).toString(), tb_control.getValueAt(i, 14).toString(), tb_control.getValueAt(i, 15).toString(), tb_control.getValueAt(i, 16).toString(), tb_control.getValueAt(i, 17).toString(), tb_control.getValueAt(i, 18).toString());
                    lista.add(ps); //Agregamos el objeto empleado a la lista
                }

                try {

                    java.sql.Date fecha_ini = new java.sql.Date(jd_ini.getDate().getTime());
                    java.sql.Date fecha_fin = new java.sql.Date(jd_fin.getDate().getTime());
                    String items = txt_cant_pro.getText();
                    String valor = txt_valor_pro.getText();
                    String util = txt_valor_util.getText();
                    String idcli = txt_id_cli.getText();
                    String nomcli = txt_nom_cli_fact.getText();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini); 
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("items", items);
                    parametro.put("valor", valor);
                    parametro.put("util", util);
                    parametro.put("idcli", idcli);
                    parametro.put("nomcli", nomcli);

                    URL in = this.getClass().getResource("/Estadisticas_productos/utilidad_pro_fisc_1.jasper");
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                } catch (JRException ex) {
                    Logger.getLogger(Salidas_productos_cate.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                extracto_fasct_surc_1_pro dialog = new extracto_fasct_surc_1_pro(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_buscar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jd_fin;
    private org.jdesktop.swingx.JXDatePicker jd_ini;
    private javax.swing.JPanel panel_razon_pro;
    public static javax.swing.JTable tb_control;
    private javax.swing.JTextField txt_cant_pro;
    public static javax.swing.JTextField txt_id_cli;
    public static javax.swing.JTextField txt_nom_cli_fact;
    private static javax.swing.JTextField txt_seq_cambio;
    private javax.swing.JTextField txt_valor_pro;
    private javax.swing.JTextField txt_valor_util;
    // End of variables declaration//GEN-END:variables

    void cargarDetalle(Date fecha_ini, Date fecha_fin, String seq) {

        String mostrar = "SELECT c.cod_pro,c.des_pro,p.pro_des_espec,p.pro_color,p.pro_tama,v.cod_cli_ventas,v.nom_cli_ventas,v.nro_fact_ventas, c.num_bol, c.cant_pro, c.pre_unit, p.pro_pre_costo, c.pre_exentas,c.pre_5,v.total_ventas, c.pre_10, c.data,v.nro_estable_ventas  from ventas_facturacion_deta as c inner join ventas_facturacion as v on c.num_bol=v.num_bol inner join tienda_productos as p on c.cod_pro=p.pro_cod WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND  v.estado_fact <> 'ANULADA' AND v.nro_estable_ventas='" + seq + "' ORDER BY c.cod_pro ASC";
        String[] titulos = {"Id Producto", "Nombre del producto", "Descripcion", "Color", "Talle/Tama", "ID cliente", "Nombre del cliente", "N° Factura", "N° Ventas", "Cantidad", "Precio Unitario", "Costo Unitario", "Excentas", "IVA 5%", "Total factura", "IVA 10%", "Utilidad", "Fecha Entrada", "Sequencia"};
        String[] Registros = new String[19];
        model = new DefaultTableModel(null, titulos);

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
                Registros[7] = rs.getString(8);
                Registros[8] = rs.getString(9);
                Registros[9] = rs.getString(10);
                Registros[10] = rs.getString(11);
                Registros[11] = rs.getString(12);
                Registros[12] = rs.getString(13);
                Registros[13] = rs.getString(14);
                Registros[14] = rs.getString(15);
                Registros[15] = rs.getString(16);
                Registros[17] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(17));
                Registros[18] = rs.getString(18);
                model.addRow(Registros);
            }

            tb_control.setModel(model);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void cargarDetalleCli(Date fecha_ini, Date fecha_fin, String seq, String cliente) {

        String mostrar = "SELECT c.cod_pro,c.des_pro,p.pro_des_espec,p.pro_color,p.pro_tama,v.cod_cli_ventas,v.nom_cli_ventas,v.nro_fact_ventas, c.num_bol, c.cant_pro, c.pre_unit, p.pro_pre_costo, c.pre_exentas,c.pre_5,v.total_ventas, c.pre_10, c.data,v.nro_estable_ventas from ventas_facturacion_deta as c inner join ventas_facturacion as v on c.num_bol=v.num_bol inner join tienda_productos as p on c.cod_pro=p.pro_cod WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND  v.estado_fact <> 'ANULADA' AND v.cod_cli_ventas='" + cliente + "'  AND v.nro_estable_ventas='" + seq + "' ORDER BY c.cod_pro ASC";
        String[] titulos = {"Id Producto", "Nombre del producto", "Descripcion", "Color", "Talle/Tama", "ID cliente", "Nombre del cliente", "N° Factura", "N° Ventas", "Cantidad", "Precio Unitario", "Costo Unitario", "Excentas", "IVA 5%", "Total factura", "IVA 10%", "Utilidad", "Fecha Entrada", "Sequencia"};
        String[] Registros = new String[19];
        model = new DefaultTableModel(null, titulos);

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
                Registros[7] = rs.getString(8);
                Registros[8] = rs.getString(9);
                Registros[9] = rs.getString(10);
                Registros[10] = rs.getString(11);
                Registros[11] = rs.getString(12);
                Registros[12] = rs.getString(13);
                Registros[13] = rs.getString(14);
                Registros[14] = rs.getString(15);
                Registros[15] = rs.getString(16);
                Registros[17] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(17));
                Registros[18] = rs.getString(18);
                model.addRow(Registros);
            }

            tb_control.setModel(model);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_control.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(tb_control.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        //   lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));

    }

    public String MaskaraPrecioUnitarioEnteros(String ValorGuaranies) {
        DecimalFormat format = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String a = ValorViejo.replace(",", "");
        NumeroIntacto = Long.valueOf(a);
        NroFormatado = format.format(NumeroIntacto);
        String LuzParaMisOjos = NroFormatado;
        return LuzParaMisOjos;
    }

    public void calcularcantida() {

        String impt = "0", subtotalt = "0";

        for (int i = 0; i < tb_control.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_control.getValueAt(i, 9).toString().replaceAll("\\s", ""));

            impt = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalt = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalt).add(ingreso.TransformReales(impt)).toString());

            txt_cant_pro.setText(subtotalt);
        }

    }//FIN METODO

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_control.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_control.getValueAt(i, 15).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_valor_pro.setText(subtotal);

        }
    }//FIN METODO

    public void calcularTotalUtil() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_control.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_control.getValueAt(i, 16).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_valor_util.setText(subtotal);

        }
    }//FIN METODO

    //calcular utilidad
    public void calcularUtil() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_control.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_control.getValueAt(i, 10).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_control.getValueAt(i, 11).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.subtract(PulidoCant).toString());

            tb_control.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 16);

        }
    }
////solo sequencia

    public static void libro_compras_pro(Date fecha_ini, Date fecha_fin, String total, String items, String seq) throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Listado de Productos en Facturas");

        try {

            CellStyle totalEstilo = book.createCellStyle();
            totalEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotal = book.createFont();
            fuenteTotal.setFontName("Arial");
            fuenteTotal.setBold(true);
            fuenteTotal.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotal.setFontHeightInPoints((short) 10);
            totalEstilo.setFont(fuenteTotal);

            //estilo total iva
            CellStyle totalIvaEstilo = book.createCellStyle();
            totalIvaEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalIvaEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalIvaEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalIvaEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotalIva = book.createFont();
            fuenteTotalIva.setFontName("Arial");
            fuenteTotalIva.setBold(true);
            fuenteTotalIva.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotalIva.setFontHeightInPoints((short) 10);
            totalIvaEstilo.setFont(fuenteTotalIva);

            ///titulo
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 12);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Listado de Productos en compras");

            //////
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));

            String[] cabecera = new String[]{"Id Producto", "Descripcion", "N° Factura", "Cantidad", "Precio unitario", "Excentas", "IVA 5%", "IVA 10%", "Fecha Entrada", "Sequencia"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 10);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(3);  //desde donde empieza los titulos

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement ps;
            ResultSet rs;

            int numFilaDatos = 4; //desde donde empiezan los datos

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            Connection cn = conectar.getInstance().getConnection();

            ps = cn.prepareStatement("SELECT c.cod_pro,c.des_pro, c.num_bol, c.cant_pro, c.pre_unit, c.pre_exentas,c.pre_5,c.pre_10, c.data,v.nro_estable_ventas  from ventas_facturacion_deta as c inner join ventas_facturacion as v on c.num_bol=v.num_bol WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND  v.estado_fact <> 'ANULADA' AND v.nro_estable_ventas='" + seq + "' ORDER BY c.cod_pro ASC");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);

            Row totales = sheet.createRow(numFilaDatos + 1);
            Cell celdaTotal = totales.createCell(6);
            celdaTotal.setCellStyle(totalEstilo);
            celdaTotal.setCellValue("Total Valor: " + total);

            Row totales_iva = sheet.createRow(numFilaDatos + 2);
            Cell celdaTotalIva = totales_iva.createCell(6);
            celdaTotalIva.setCellStyle(totalIvaEstilo);
            celdaTotalIva.setCellValue("Total de cantidades: " + items);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Listado de Productos en Facturas por sequencia " + " en fecha " + Principal.txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "El archivo esta abierto en otra anterior");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la conexion con el servidor");
        }

    }

    ///seq + cliente
    public static void libro_compras_pro_cli(Date fecha_ini, Date fecha_fin, String total, String items, String seq, String cliente) throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Listado de Productos en Facturas");

        try {

            CellStyle totalEstilo = book.createCellStyle();
            totalEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotal = book.createFont();
            fuenteTotal.setFontName("Arial");
            fuenteTotal.setBold(true);
            fuenteTotal.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotal.setFontHeightInPoints((short) 10);
            totalEstilo.setFont(fuenteTotal);

            //estilo total iva
            CellStyle totalIvaEstilo = book.createCellStyle();
            totalIvaEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalIvaEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalIvaEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalIvaEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotalIva = book.createFont();
            fuenteTotalIva.setFontName("Arial");
            fuenteTotalIva.setBold(true);
            fuenteTotalIva.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotalIva.setFontHeightInPoints((short) 10);
            totalIvaEstilo.setFont(fuenteTotalIva);

            ///titulo
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 12);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Listado de Productos en compras");

            //////
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));

            String[] cabecera = new String[]{"Id Producto", "Descripcion", "N° Factura", "Cantidad", "Precio unitario", "Excentas", "IVA 5%", "IVA 10%", "Fecha Entrada", "Sequencia"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 10);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(3);  //desde donde empieza los titulos

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement ps;
            ResultSet rs;

            int numFilaDatos = 4; //desde donde empiezan los datos

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            Connection cn = conectar.getInstance().getConnection();

            ps = cn.prepareStatement("SELECT c.cod_pro,c.des_pro, c.num_bol, c.cant_pro, c.pre_unit, c.pre_exentas,c.pre_5,c.pre_10, c.data,v.nro_estable_ventas from ventas_facturacion_deta as c inner join ventas_facturacion as v on c.num_bol=v.num_bol WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND  v.estado_fact <> 'ANULADA' AND cod_cli_ventas='" + cliente + "' AND v.nro_estable_ventas='" + seq + "' ORDER BY c.cod_pro ASC");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);

            Row totales = sheet.createRow(numFilaDatos + 1);
            Cell celdaTotal = totales.createCell(6);
            celdaTotal.setCellStyle(totalEstilo);
            celdaTotal.setCellValue("Total Valor: " + total);

            Row totales_iva = sheet.createRow(numFilaDatos + 2);
            Cell celdaTotalIva = totales_iva.createCell(6);
            celdaTotalIva.setCellStyle(totalIvaEstilo);
            celdaTotalIva.setCellValue("Total de cantidades: " + items);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Listado de Productos en Facturas por Cliente y sequencia " + " en fecha " + Principal.txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "El archivo esta abierto en otra anterior");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(extracto_fasct_surc_1_pro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la conexion con el servidor");
        }

    }

}
