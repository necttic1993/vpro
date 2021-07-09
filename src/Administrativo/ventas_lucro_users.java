//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Administrativo.Lucro_user.Lucro_list;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_surcu_user_lucro;
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
import report.Reportes;
//</editor-fold>

public class ventas_lucro_users extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public ventas_lucro_users(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarUsu();
        lbl_almacen_lucro.setText(Principal.lbl_usu_almacen.getText());
        txt_total_compras_lucro.setVisible(false);

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
        txt_total_generales = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas_lucro = new javax.swing.JTable();
        jd_fin_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        jLabel17 = new javax.swing.JLabel();
        cb_users = new org.jdesktop.swingx.JXComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        txt_total_compras_lucro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_total_ventas_lucro = new javax.swing.JTextField();
        lbl_almacen_lucro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 7, 70, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Usuario:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 80, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Fecha Inicio:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 7, 70, 40));

        txt_total_generales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_generales.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_generales.setText("0");
        txt_total_generales.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_generales.setEnabled(false);
        jPanel3.add(txt_total_generales, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 190, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Total Lucro Ventas:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 520, 140, 30));

        tb_ventas_lucro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_ventas_lucro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_ventas_lucro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ventas_lucroMouseClicked(evt);
            }
        });
        tb_ventas_lucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_ventas_lucroKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ventas_lucro);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1110, 430));

        jd_fin_lucro_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jd_fin_lucro_ventasActionPerformed(evt);
            }
        });
        jPanel3.add(jd_fin_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 120, 30));
        jPanel3.add(jd_ini_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 120, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Fecha Final:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 90, 30));

        cb_users.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 290, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 190, 0));

        txt_total_compras_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_compras_lucro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_compras_lucro.setText("0");
        txt_total_compras_lucro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_compras_lucro.setEnabled(false);
        txt_total_compras_lucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_compras_lucroActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_compras_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 190, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Total Ventas:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 140, 30));

        txt_total_ventas_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_ventas_lucro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_ventas_lucro.setText("0");
        txt_total_ventas_lucro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_ventas_lucro.setEnabled(false);
        jPanel3.add(txt_total_ventas_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 490, 190, 30));

        lbl_almacen_lucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_lucro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_lucro.setText("0000000");
        lbl_almacen_lucro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_lucro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_lucro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_lucroMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_almacen_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 110, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ventas_lucroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventas_lucroKeyReleased

    }//GEN-LAST:event_tb_ventas_lucroKeyReleased

    private void tb_ventas_lucroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventas_lucroMouseClicked
        /*int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_ventas_lucroMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                Lucro_list cl;// Instaciamos la clase empleado
                List<Lucro_list> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_ventas_lucro.getRowCount(); i++) { // Iterena cada fila de la tabla
                    cl = new Lucro_list(tb_ventas_lucro.getValueAt(i, 0).toString(), tb_ventas_lucro.getValueAt(i, 1).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_ventas_lucro.getValueAt(i, 2).toString(), tb_ventas_lucro.getValueAt(i, 3).toString(), tb_ventas_lucro.getValueAt(i, 4).toString(), tb_ventas_lucro.getValueAt(i, 5).toString(), tb_ventas_lucro.getValueAt(i, 6).toString(), tb_ventas_lucro.getValueAt(i, 7).toString(), tb_ventas_lucro.getValueAt(i, 8).toString());
                    lista.add(cl); //Agregamos el objeto empleado a la lista
                }

                try {

                    java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_ventas = txt_total_ventas_lucro.getText();
                    String total_lucro = txt_total_generales.getText();
                    String user = (String) cb_users.getSelectedItem();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini);
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("total_lucro", total_ventas);
                    parametro.put("total_lucro_neto", total_lucro);
                    parametro.put("user", user);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_user/ventas_lucro_1.jasper");
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

        ///////
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (lbl_almacen_lucro.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Surcusal/Almacen válido");
        } else {

            if (lbl_almacen_lucro.getText().equals("0000001")) {
                String user = (String) cb_users.getSelectedItem();
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());

                cargar(date1, date2, user);
                calcular();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_lucro.getText().equals("0000002")) {
                String user = (String) cb_users.getSelectedItem();
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());

                cargar_2(date1, date2, user);
                calcular();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_lucro.getText().equals("0000003")) {
                String user = (String) cb_users.getSelectedItem();
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());

                cargar_3(date1, date2, user);
                calcular();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jd_fin_lucro_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jd_fin_lucro_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jd_fin_lucro_ventasActionPerformed

    private void txt_total_compras_lucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_compras_lucroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_compras_lucroActionPerformed

    private void lbl_almacen_lucroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_lucroMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_surcu_user_lucro sl;
            sl = new Seleccion_surcu_user_lucro(new javax.swing.JDialog(), true);
            sl.setVisible(true);

        }
    }//GEN-LAST:event_lbl_almacen_lucroMouseClicked
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
            java.util.logging.Logger.getLogger(ventas_lucro_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ventas_lucro_users dialog = new ventas_lucro_users(new javax.swing.JDialog(), true);
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
    public static org.jdesktop.swingx.JXComboBox cb_users;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static org.jdesktop.swingx.JXDatePicker jd_fin_lucro_ventas;
    public static org.jdesktop.swingx.JXDatePicker jd_ini_lucro_ventas;
    public static javax.swing.JLabel lbl_almacen_lucro;
    public static javax.swing.JTable tb_ventas_lucro;
    public static javax.swing.JTextField txt_total_compras_lucro;
    public static javax.swing.JTextField txt_total_generales;
    public static javax.swing.JTextField txt_total_ventas_lucro;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String User) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta,v.forma_pag_ventas,v.user_ventas FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA' AND v.user_ventas ='" + User + "' ORDER BY d.data ASC";
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
            tb_ventas_lucro.setModel(model);

            tb_ventas_lucro.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_lucro.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_lucro.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_lucro.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_lucro.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar_2(Date fecha_ini, Date fecha_fin, String User) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta,v.forma_pag_ventas,v.user_ventas FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA' AND v.user_ventas ='" + User + "' ORDER BY d.data ASC";
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
            tb_ventas_lucro.setModel(model);

            tb_ventas_lucro.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_lucro.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_lucro.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_lucro.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_lucro.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar_3(Date fecha_ini, Date fecha_fin, String User) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta,v.forma_pag_ventas,v.user_ventas FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA' AND v.user_ventas ='" + User + "' ORDER BY d.data ASC";
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
            tb_ventas_lucro.setModel(model);

            tb_ventas_lucro.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas_lucro.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas_lucro.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas_lucro.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas_lucro.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas_lucro.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarUsu() {
        String mostrar = "SELECT * FROM usuarios  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_users.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcular() {

        String imp = "0", subtotal = "0";

        for (int i = 0; i < tb_ventas_lucro.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_lucro.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas_lucro.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_ventas_lucro.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);

        }
    }

    //////////////////calculo de totales/////////////////////
    public void lista_ventas_totales() {

        String impv = "0", subtotales = "0";

        for (int i = 0; i < tb_ventas_lucro.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_lucro.getValueAt(i, 8).toString().replaceAll("\\s", ""));

            impv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotales = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotales).add(ingreso.TransformReales(impv)).toString());

            txt_total_ventas_lucro.setText(subtotales);

        }
    }

    public void lista_compras_totales() {

        String impc = "0", subtotales = "0", totales = "0";

        for (int i = 0; i < tb_ventas_lucro.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas_lucro.getValueAt(i, 7).toString().replaceAll("\\s", ""));

            impc = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotales = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotales).add(ingreso.TransformReales(impc)).toString());

            txt_total_compras_lucro.setText(subtotales);

        }
    }

    public void lista_neto_generales() {
        String net = "0";
        //////////////////////////////////////////segundo calculo
        BigDecimal valor_total = ingreso.TransformReales(txt_total_ventas_lucro.getText());
        BigDecimal valor_ultimo = ingreso.TransformReales(txt_total_compras_lucro.getText());
        net = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_total.subtract(valor_ultimo).toString());
        txt_total_generales.setText(net);

    }

}//FIN CLASE
