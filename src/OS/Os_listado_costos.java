//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package OS;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Administrativo.os;
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
import report.Reportes;
//</editor-fold>

public class Os_listado_costos extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Os_listado_costos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar_tec();
        txt_total_os.setDisabledTextColor(Color.black);
        txt_total_stock.setDisabledTextColor(Color.black);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_total_os = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_total_stock = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fecha_fin_data = new org.jdesktop.swingx.JXDatePicker();
        fecha_ini_data = new org.jdesktop.swingx.JXDatePicker();
        cb_tipo_tec = new org.jdesktop.swingx.JXComboBox();
        jLabel21 = new javax.swing.JLabel();
        txt_total_tec = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadísticas OS");
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 940, 420));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/liste.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 70, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Técnico:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Fecha Inicio:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Total O.S:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 70, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/print_1.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 70, 40));

        txt_total_os.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_os.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_os.setEnabled(false);
        jPanel3.add(txt_total_os, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 190, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Servicios:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 90, 30));

        txt_total_stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_stock.setEnabled(false);
        jPanel3.add(txt_total_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 190, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Fecha Final:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 30));
        jPanel3.add(fecha_fin_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));
        jPanel3.add(fecha_ini_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

        cb_tipo_tec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));
        cb_tipo_tec.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_tipo_tec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 230, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Total Stock:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 90, 30));

        txt_total_tec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_tec.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_tec.setEnabled(false);
        jPanel3.add(txt_total_tec, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventasMouseClicked
        /*int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_ventasMouseClicked

    private void tb_ventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventasKeyReleased

    }//GEN-LAST:event_tb_ventasKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        java.sql.Date date1 = new java.sql.Date(fecha_ini_data.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(fecha_fin_data.getDate().getTime());
        String tec = (String) cb_tipo_tec.getSelectedItem();
        if ((cb_tipo_tec.getSelectedItem().equals("TODOS"))) {
            cargar(date1, date2);
            lista_stock();
            lista_tec();
            lista_total_os();

        } else {
            cargarTipo(date1, date2, tec);
            lista_stock();
            lista_tec();
            lista_total_os();

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                os os;// Instaciamos la clase empleado
                List<os> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_ventas.getRowCount(); i++) { // Iterena cada fila de la tabla
                    os = new os(tb_ventas.getValueAt(i, 0).toString(), tb_ventas.getValueAt(i, 1).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_ventas.getValueAt(i, 2).toString(), tb_ventas.getValueAt(i, 3).toString(), tb_ventas.getValueAt(i, 4).toString(), tb_ventas.getValueAt(i, 5).toString());
                    lista.add(os); //Agregamos el objeto empleado a la lista
                }

                try {

                    java.sql.Date fecha_ini = new java.sql.Date(fecha_ini_data.getDate().getTime());
                    java.sql.Date fecha_fin = new java.sql.Date(fecha_fin_data.getDate().getTime());
                    String totalStock = txt_total_stock.getText();
                    String serv = txt_total_tec.getText();
                    String totales = txt_total_os.getText();
                    String tecnico = (String) cb_tipo_tec.getSelectedItem();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini);
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("ts", totalStock);
                    parametro.put("serv", serv);
                    parametro.put("total", totales);
                    parametro.put("tec", tecnico);

                    URL in = this.getClass().getResource("/OS/Lista_costos.jasper");
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                } catch (JRException ex) {
                    Logger.getLogger(Os_listado_costos.class
                            .getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Os_listado_costos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Os_listado_costos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Os_listado_costos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Os_listado_costos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Os_listado_costos dialog = new Os_listado_costos(new javax.swing.JDialog(), true);
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
    public static org.jdesktop.swingx.JXComboBox cb_tipo_tec;
    public static org.jdesktop.swingx.JXDatePicker fecha_fin_data;
    public static org.jdesktop.swingx.JXDatePicker fecha_ini_data;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tb_ventas;
    public static javax.swing.JTextField txt_total_os;
    public static javax.swing.JTextField txt_total_stock;
    private javax.swing.JTextField txt_total_tec;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM os  WHERE  fecha_entra BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "'";
        String[] titulos = {"Nro O.S", "Técnico", "Valor Stock", "Valor Técnico", "Valor total O.S", "Fecha "};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(18);
                Registros[2] = rs.getString(16);
                Registros[3] = rs.getString(15);
                Registros[4] = rs.getString(9);
                Registros[5] = rs.getString(3);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Os_listado_costos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTipo(Date fecha_ini, Date fecha_fin, String tipo) {
        String mostrar = "SELECT * FROM os  WHERE fecha_entra BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "' AND os_des_tec= '" + tipo + "'";
        String[] titulos = {"Nro O.S", "Técnico", "Valor Stock", "Valor Técnico", "Valor total O.S", "Fecha "};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(1);
                Registros[1] = rs.getString(18);
                Registros[2] = rs.getString(16);
                Registros[3] = rs.getString(15);
                Registros[4] = rs.getString(9);
                Registros[5] = rs.getString(3);

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Os_listado_costos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void lista_stock() {

        String impv = "0", subtotalv = "0", totalv = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 2).toString().replaceAll("\\s", ""));

            impv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalv).add(ingreso.TransformReales(impv)).toString());

            txt_total_stock.setText(subtotalv);

        }
    }

    public void lista_tec() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_tec.setText(subtotal);

        }
    }

    public void lista_total_os() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 4).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_os.setText(subtotal);

        }
    }

    void cargar_tec() {
        String mostrar = "SELECT * FROM usuarios ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_tipo_tec.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Os_listado_costos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}//FIN CLASE
