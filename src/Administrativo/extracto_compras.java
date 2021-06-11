//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_usu_nom;

import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class extracto_compras extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public extracto_compras(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // cargarIN();
        txt_total_gs.setDisabledTextColor(Color.black);
        cargarCli();

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    void cargarCli() {
        String mostrar = "SELECT * FROM tienda_proveedores  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_provee.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(extracto_compras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void limpiar() {

        txt_total_gs.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_compras.getModel();
        int a = tb_compras.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    void caja() {

        String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo) VALUES (?,?,?,?,?,?,?,?,?)";
        String descaja = ("VENTAS A PLAZO: " + cb_provee.getSelectedItem());
        String total_gs = txt_total_gs.getText();
        String total_rs = ("VENTAS A PLAZO");
        String egreso_gs = ("0");
        String egreso_rs = ("0");
        String fecha_caja = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String moneda = ("Guaraníes");;
        String tipo_caja = ("C");
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, descaja);
            pst.setString(2, total_gs);
            pst.setString(3, total_rs);
            pst.setString(4, egreso_gs);
            pst.setString(5, egreso_rs);
            pst.setString(6, fecha_caja);
            pst.setString(7, user);
            pst.setString(8, moneda);
            pst.setString(9, tipo_caja);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Crédito en Guaraníes");
            }
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(extracto_compras.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cb_condicion_pago = new org.jdesktop.swingx.JXComboBox();
        cb_provee = new org.jdesktop.swingx.JXComboBox();
        cb_estado = new org.jdesktop.swingx.JXComboBox();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Extratos de Compras");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_compras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        txt_total_gs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 90, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 17, 60, 45));

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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 17, 60, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Proveedor:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Cond. de Pago:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 110, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Proceso:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 80, 30));

        cb_condicion_pago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "CONTADO", "CRÉDITO" }));
        cb_condicion_pago.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_condicion_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 140, 30));

        cb_provee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));
        cb_provee.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cb_provee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_proveeActionPerformed(evt);
            }
        });
        jPanel3.add(cb_provee, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 310, 30));

        cb_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "FINALIZADA", "CONFIRMADA" }));
        cb_estado.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 160, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
        String prov = (String) cb_provee.getSelectedItem();
        String estado = (String) cb_estado.getSelectedItem();
        String condi = (String) cb_condicion_pago.getSelectedItem();
        String var = "TODOS";
/////////////////////////////////////////////////////////////////////////////
        if (prov.equals(var) && estado.equals(var) && condi.equals(var)) {
            String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_entrada DESC";

            report(mostrar);

        } else if (!prov.equals(var) && estado.equals(var) && condi.equals(var)) {
            String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + date1 + "' AND '" + date2 + "' and nom_prov_comp='" + prov + "' ORDER BY fecha_entrada DESC";

            report(mostrar);

        } else if (!prov.equals(var) && !estado.equals(var) && condi.equals(var)) {
            String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + date1 + "' AND '" + date2 + "' and nom_prov_comp='" + prov + "' AND estado_comp='" + estado + "'  ORDER BY fecha_entrada DESC";

            report(mostrar);

        } else if (!prov.equals(var) && !estado.equals(var) && !condi.equals(var)) {
            String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + date1 + "' AND '" + date2 + "' and nom_prov_comp='" + prov + "' AND estado_comp='" + estado + "' AND pago_comp='" + condi + "'  ORDER BY fecha_entrada DESC";
            report(mostrar);

        } ////segundo casos
        else if (prov.equals(var) && !estado.equals(var) && condi.equals(var)) {
            String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_comp='" + estado + "'  ORDER BY fecha_entrada DESC";
            report(mostrar);

        } else if (prov.equals(var) && !estado.equals(var) && !condi.equals(var)) {
            String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_comp='" + estado + "' AND pago_comp='" + condi + "'  ORDER BY fecha_entrada DESC";
            report(mostrar);

        } else if (prov.equals(var) && estado.equals(var) && !condi.equals(var)) {
            String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + date1 + "' AND '" + date2 + "' AND pago_comp='" + condi + "'  ORDER BY fecha_entrada DESC";
            report(mostrar);
        }

        // String mostrar = "SELECT * FROM compras where   fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' OR nom_prov_comp='" + prove + "' AND pago_comp='" + condi + "'  AND estado_comp='" + proceso + "' ORDER BY fecha_entrada DESC";

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                Compras_list cl;// Instaciamos la clase empleado
                List<Compras_list> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_compras.getRowCount(); i++) { // Iterena cada fila de la tabla
                    cl = new Compras_list(tb_compras.getValueAt(i, 0).toString(), tb_compras.getValueAt(i, 1).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_compras.getValueAt(i, 2).toString(), tb_compras.getValueAt(i, 3).toString(), tb_compras.getValueAt(i, 4).toString(), tb_compras.getValueAt(i, 5).toString());
                    lista.add(cl); //Agregamos el objeto empleado a la lista
                }

                try {

                    java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                    java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                    String pro = (String) cb_provee.getSelectedItem();
                    String estado = (String) cb_estado.getSelectedItem();
                    String pago = (String) cb_condicion_pago.getSelectedItem();
                    String total = txt_total_gs.getText();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini);
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("pro", pro);
                    parametro.put("estado", estado);
                    parametro.put("pago", pago);
                    parametro.put("total", total);

                    URL in = this.getClass().getResource("/Compras/impresiones/Lista_compras_model.jasper");
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

        // JOptionPane.showMessageDialog(null, "En construcción");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_proveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_proveeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_proveeActionPerformed
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
            java.util.logging.Logger.getLogger(extracto_compras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(extracto_compras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(extracto_compras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(extracto_compras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                extracto_compras dialog = new extracto_compras(new javax.swing.JDialog(), true);
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
    private org.jdesktop.swingx.JXComboBox cb_condicion_pago;
    private org.jdesktop.swingx.JXComboBox cb_estado;
    private org.jdesktop.swingx.JXComboBox cb_provee;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JTable tb_compras;
    public static javax.swing.JTextField txt_total_gs;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargarProvTodos(Date fecha_ini, Date fecha_fin, String provv) {
        String mostrar = "SELECT * FROM compras WHERE pago_comp= 'CONTADO' AND nom_prov_comp ='" + provv + "'  AND fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_entrada DESC";
        String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

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
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(extracto_compras.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void report(String sql) {

        String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
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
            calcularGS();
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(extracto_compras.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodosPlazo(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM compras WHERE pago_comp='PLAZO' AND fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_entrada DESC";
        String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

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
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(extracto_compras.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM compras WHERE  fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_entrada DESC";
        String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();
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
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(extracto_compras.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

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
