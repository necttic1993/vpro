//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package OS;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Administrativo.*;
import Clases.ColorearFilas_os;
import Clases.ColorearFilas_plazo;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
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
import net.sf.jasperreports.view.JasperViewer;
//</editor-fold>

public class listado_situacios extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public listado_situacios(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // cargarIN();
        txt_total_cantidad.setDisabledTextColor(Color.black);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    void limpiar() {

        txt_total_cantidad.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_os.getModel();
        int a = tb_os.getRowCount() - 1;
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
        tb_os = new javax.swing.JTable();
        txt_total_cantidad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cb_clientes2 = new org.jdesktop.swingx.JXComboBox();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de situaciones OS");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_os.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_os.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_os.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_osMouseClicked(evt);
            }
        });
        tb_os.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_osKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_os);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1030, 380));

        txt_total_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_total_cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_total_cantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_cantidad.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_total_cantidad.setEnabled(false);
        txt_total_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_cantidadActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 50, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Cantidad:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, -1, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Fecha Final:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Situación:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/liste.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 60, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/print_1.png"))); // NOI18N
        jButton1.setToolTipText("Imprimir extracto de venta");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 60, 40));

        cb_clientes2.setMaximumRowCount(9);
        cb_clientes2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR:", "RECEPCION", "TEST", "LABORATORIO", "REPARADO", "ENTREGADO", "PAGADO", "ANULADO", "SIN SOLUCION" }));
        cb_clientes2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_clientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 300, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 140, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_osMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_osMouseClicked
        /*    int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_osMouseClicked

    private void tb_osKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_osKeyReleased

    }//GEN-LAST:event_tb_osKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
        String status = (String) cb_clientes2.getSelectedItem();
        cargar(date1, date2, status);
        contar();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_cantidadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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
                    String sta = (String) cb_clientes2.getSelectedItem();
                    String cant = txt_total_cantidad.getText();
                    Connection cn = conectar.getInstance().getConnection();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini);
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("situacion", sta);
                    parametro.put("cant", cant);

                    URL in = this.getClass().getResource("/Impresiones/os_lista_status.jasper");

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
                    Logger.getLogger(listado_situacios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(listado_situacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listado_situacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listado_situacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listado_situacios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                listado_situacios dialog = new listado_situacios(new javax.swing.JDialog(), true);
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
    private org.jdesktop.swingx.JXComboBox cb_clientes2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JTable tb_os;
    public static javax.swing.JTextField txt_total_cantidad;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String sta) {
        String mostrar = "SELECT * FROM os WHERE os_status ='" + sta + "'  AND fecha_entra BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ";
        String[] titulos = {"O.S N°", "Serie N° ", "Fecha Entrada", "Cliente", "Producto", "Situación"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(2);
                Registros[2] = rs.getString(3);
                Registros[3] = rs.getString(5);
                Registros[4] = rs.getString(7);
                Registros[5] = rs.getString(8);

                model.addRow(Registros);
            }
            tb_os.setModel(model);

            ColorearFilas_os color = new ColorearFilas_os(5);

            tb_os.getColumnModel().getColumn(5).setCellRenderer(color);
            tb_os.getColumnModel().getColumn(0).setPreferredWidth(83);
            tb_os.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_os.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_os.getColumnModel().getColumn(3).setPreferredWidth(250);
            tb_os.getColumnModel().getColumn(4).setPreferredWidth(300);
            tb_os.getColumnModel().getColumn(5).setPreferredWidth(140);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(listado_situacios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void contar() {

        for (int i = 0; i <= tb_os.getRowCount(); i++) {
            txt_total_cantidad.setText("" + i);
        }

    }
}//FIN CLASE
