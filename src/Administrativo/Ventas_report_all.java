//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_lista_ventas;
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

public class Ventas_report_all extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Ventas_report_all(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // cargarIN();
        lbl_almacen_ventas.setText(Principal.lbl_usu_almacen.getText());
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
        jLabel21 = new javax.swing.JLabel();
        cb_condicion_pago = new org.jdesktop.swingx.JXComboBox();
        cb_estado = new org.jdesktop.swingx.JXComboBox();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();
        txt_id_cli_ventas = new javax.swing.JTextField();
        txt_nom_cli_ventas = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        lbl_almacen_ventas = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1030, 330));

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
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 60, 45));

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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 60, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Clientes:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Proceso:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 30));

        cb_condicion_pago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "CONTADO", "CRÉDITO" }));
        cb_condicion_pago.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_condicion_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 140, 30));

        cb_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "FINALIZADA", "CONFIRMADA" }));
        cb_estado.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, 30));
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

        lbl_almacen_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_ventas.setText("TODOS");
        lbl_almacen_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_ventasMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_almacen_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 60));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Cond. de Pago:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 110, 30));

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
        String cliente = txt_id_cli_ventas.getText();
        String estado = (String) cb_estado.getSelectedItem();
        String condi = (String) cb_condicion_pago.getSelectedItem();
        String var = "TODOS";
        String cli = "";
/////////////////////////////////////////////////////////////////////////////
        if (cliente.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione un cliente antes de listar");
        } else {
            if (lbl_almacen_ventas.getText().equals("TODOS")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'   union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'   union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'    union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' ";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' ";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas from ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "' union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  union select num_bol,nom_cli_ventas,forma_pag_ventas,total_ventas,fecha_ventas,user_ventas  from ventas_5  where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'";
                    report(mostrar);
                }
            }

            if (lbl_almacen_ventas.getText().equals("0000001")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }

            if (lbl_almacen_ventas.getText().equals("0000002")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(var) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_2 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000003")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_3 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000004")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_4 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000005")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_5 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000006")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_6 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000007")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_7 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_7 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_7 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_7 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_7 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000008")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_8 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000009")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_9 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000010")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_10 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000011")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_11 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000012")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_12 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000013")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_13 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000014")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_14 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000015")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(var) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_15 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000016")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_16 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_16 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_16 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_16 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_16 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_16 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000017")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_17 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000018")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_18 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000019")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_19 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000020")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_20 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000021")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_21 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000022")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_22 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000023")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_23 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000024")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_24 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000025")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_25 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000026")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_26 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000027")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_27 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000028")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_28 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000029")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_29 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
            if (lbl_almacen_ventas.getText().equals("0000030")) {
                if (cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";

                    report(mostrar);

                } else if (!cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' and cod_cli_ventas='" + cliente + "' AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } ////segundo casos
                else if (cliente.equals(cli) && !estado.equals(var) && condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && !estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "'  AND estado_ventas='" + estado + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);

                } else if (cliente.equals(cli) && estado.equals(var) && !condi.equals(var)) {
                    String mostrar = "SELECT * FROM ventas_30 where   fecha_ventas BETWEEN '" + date1 + "' AND '" + date2 + "' AND forma_pag_ventas='" + condi + "'  ORDER BY fecha_ventas DESC";
                    report(mostrar);
                }
            }
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

                Ventas_list vl;// Instaciamos la clase empleado
                List<Ventas_list> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_compras.getRowCount(); i++) { // Iterena cada fila de la tabla
                    vl = new Ventas_list(tb_compras.getValueAt(i, 0).toString(), tb_compras.getValueAt(i, 1).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_compras.getValueAt(i, 2).toString(), tb_compras.getValueAt(i, 3).toString(), tb_compras.getValueAt(i, 4).toString(), tb_compras.getValueAt(i, 5).toString());
                    lista.add(vl); //Agregamos el objeto empleado a la lista
                }

                try {

                    java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                    java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                    String cli = txt_nom_cli_ventas.getText();
                    String estado = (String) cb_estado.getSelectedItem();
                    String pago = (String) cb_condicion_pago.getSelectedItem();
                    String total = txt_total_gs.getText();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini);
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("cli", cli);
                    parametro.put("estado", estado);
                    parametro.put("pago", pago);
                    parametro.put("total", total);

                    URL in = this.getClass().getResource("/Impresiones/Ventas_lista_all.jasper");
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                } catch (JRException ex) {
                    Logger.getLogger(Ventas_report_all.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        // JOptionPane.showMessageDialog(null, "En construcción");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Clientes_report_ventas cl;
        cl = new Clientes_report_ventas(new javax.swing.JDialog(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void lbl_almacen_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_ventasMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_lista_ventas sl;
            sl = new Seleccion_lista_ventas(new javax.swing.JDialog(), true);
            sl.setVisible(true);

        }
    }//GEN-LAST:event_lbl_almacen_ventasMouseClicked
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
            java.util.logging.Logger.getLogger(Ventas_report_all.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_report_all.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_report_all.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_report_all.class
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
                Ventas_report_all dialog = new Ventas_report_all(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JLabel lbl_almacen_ventas;
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
            Logger.getLogger(Ventas_report_all.class
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
