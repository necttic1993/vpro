//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;

import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_surcusal_free;
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
//</editor-fold>

public class ventas_anteriores_tarjeta extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public ventas_anteriores_tarjeta(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pn_config.setVisible(false);
        txt_total_gs.setDisabledTextColor(Color.black);
        ch_todos.setSelected(true);
        cb_situ_ventas.setEnabled(false);

        cargarUsu();

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
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_total_gs = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_total_ventas = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_total_dev = new javax.swing.JTextField();
        pn_config = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_devo = new javax.swing.JTable();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        cb_situ_ventas = new org.jdesktop.swingx.JXComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ch_todos = new javax.swing.JCheckBox();
        ch_situacion = new javax.swing.JCheckBox();
        lbl_almacen_ventas = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar situación de ventas");
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 980, 370));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 47, 70, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel14.setText("Filtrar por:");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 980, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Total Gral. :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 100, 30));

        txt_total_gs.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_total_gs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs.setText("0");
        txt_total_gs.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_gs.setEnabled(false);
        txt_total_gs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gsActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 210, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Fecha Final:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 90, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Valor Devoluciones :");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 160, 30));

        txt_total_ventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_total_ventas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_ventas.setText("0");
        txt_total_ventas.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_total_ventas.setEnabled(false);
        jPanel3.add(txt_total_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 190, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Valor Ventas :");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 100, 30));

        txt_total_dev.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_total_dev.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_dev.setText("0");
        txt_total_dev.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_dev.setEnabled(false);
        jPanel3.add(txt_total_dev, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 200, 30));

        pn_config.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_devo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tb_devo);

        pn_config.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));

        jPanel3.add(pn_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 180, 70));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 140, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 140, 30));

        cb_situ_ventas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONFIRMADA", "FINALIZADA" }));
        cb_situ_ventas.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_situ_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 130, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setText("Situación:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 80, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, 30));

        ch_todos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ch_todos.setText("Todos.");
        ch_todos.setContentAreaFilled(false);
        ch_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_todosActionPerformed(evt);
            }
        });
        jPanel3.add(ch_todos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, 30));

        ch_situacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ch_situacion.setText("Situación.");
        ch_situacion.setContentAreaFilled(false);
        ch_situacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_situacionActionPerformed(evt);
            }
        });
        jPanel3.add(ch_situacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 30));

        lbl_almacen_ventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_almacen_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_ventas.setText("0000000");
        lbl_almacen_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_ventasMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_almacen_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 43, 130, 40));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 47, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
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
        if (lbl_almacen_ventas.getText().equals("0000000")) {
            JOptionPane.showMessageDialog(null, "Seleccione un almacén válido");
        }
        if (lbl_almacen_ventas.getText().equals("0000001")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos(date1, date2);
                calcularGS();
                cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ(date1, date2, alma, situ);
                calcularGS();
                cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        //surcusal 2
        if (lbl_almacen_ventas.getText().equals("0000002")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_2(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_2(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000003")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_3(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_3(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000004")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_4(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_4(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000005")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_5(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_5(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000006")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_6(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_6(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        if (lbl_almacen_ventas.getText().equals("0000007")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_7(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_7(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000008")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_8(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_8(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000009")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_9(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_9(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000010")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_10(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_10(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        //11
        if (lbl_almacen_ventas.getText().equals("0000011")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_11(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_11(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000012")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_12(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_12(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000013")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_13(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_13(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        if (lbl_almacen_ventas.getText().equals("0000014")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_14(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_14(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        //15
        if (lbl_almacen_ventas.getText().equals("0000015")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_15(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_15(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
//surcusal 16
        if (lbl_almacen_ventas.getText().equals("0000016")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_16(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_16(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        if (lbl_almacen_ventas.getText().equals("0000017")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_17(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_17(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        //SUCURSAL 18
        if (lbl_almacen_ventas.getText().equals("0000018")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_18(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_18(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000019")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_19(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_19(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000020")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_20(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_20(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000021")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_21(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_21(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        //22
        if (lbl_almacen_ventas.getText().equals("0000022")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_22(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_22(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        if (lbl_almacen_ventas.getText().equals("0000023")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_23(date1, date2);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_23(date1, date2, alma, situ);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        if (lbl_almacen_ventas.getText().equals("0000024")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_24(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_24(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }

        if (lbl_almacen_ventas.getText().equals("0000025")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_25(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_25(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000026")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_26(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_26(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000027")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_27(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_27(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000028")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_28(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_28(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000029")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_29(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_29(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
        if (lbl_almacen_ventas.getText().equals("0000030")) {
            if (ch_todos.isSelected()) {

                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                cargarTodos_30(date1, date2);
                calcularGS();
                //  cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }

            if (ch_situacion.isSelected()) {
                java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                String alma = lbl_almacen_ventas.getText();
                String situ = (String) cb_situ_ventas.getSelectedItem();
                cargarSurc_situ_30(date1, date2, alma, situ);
                calcularGS();
                // cargarDev(date1, date2);
                calcularDev();
                calcularTotal();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gsActionPerformed

    private void ch_situacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_situacionActionPerformed

        ch_todos.setSelected(false);
        cb_situ_ventas.setEnabled(true);

    }//GEN-LAST:event_ch_situacionActionPerformed

    private void ch_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_todosActionPerformed

        ch_situacion.setSelected(false);
        cb_situ_ventas.setEnabled(false);

    }//GEN-LAST:event_ch_todosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //<editor-fold defaultstate="collapsed" desc="Almacen 1">   
        if (lbl_almacen_ventas.getText().equals("0000001")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        } //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 2">   

        if (lbl_almacen_ventas.getText().equals("0000002")) {
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_2.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_2.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 3">   
        if (lbl_almacen_ventas.getText().equals("0000003")) {
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_3.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_3.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 4">   
        if (lbl_almacen_ventas.getText().equals("0000004")) {
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_4.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_4.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 5">   
        if (lbl_almacen_ventas.getText().equals("0000005")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_5.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_5.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 6">   
        if (lbl_almacen_ventas.getText().equals("0000006")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_6.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_6.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 7">   
        if (lbl_almacen_ventas.getText().equals("0000007")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_7.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_7.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 8">   
        if (lbl_almacen_ventas.getText().equals("0000008")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_8.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_8.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 9">   
        if (lbl_almacen_ventas.getText().equals("0000009")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_9.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_9.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 10">   
        if (lbl_almacen_ventas.getText().equals("0000010")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_10.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_10.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 11">   
        if (lbl_almacen_ventas.getText().equals("0000011")) {
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_11.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();
                            Connection cn = conectar.getInstance().getConnection();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_11.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 12">   
        if (lbl_almacen_ventas.getText().equals("0000012")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_12.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_12.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 13">   
        if (lbl_almacen_ventas.getText().equals("0000013")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_13.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_13.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 14">   
        if (lbl_almacen_ventas.getText().equals("0000014")) {
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_14.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();
                            Connection cn = conectar.getInstance().getConnection();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_14.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 15">   
        if (lbl_almacen_ventas.getText().equals("0000015")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_15.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_15.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 16">    
        if (lbl_almacen_ventas.getText().equals("0000016")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_16.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_16.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 17">   
        if (lbl_almacen_ventas.getText().equals("0000017")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_17.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_17.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 18">   
        if (lbl_almacen_ventas.getText().equals("0000018")) {
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_18.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_18.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 19">   
        if (lbl_almacen_ventas.getText().equals("0000019")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_19.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_19.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 20">   
        if (lbl_almacen_ventas.getText().equals("0000020")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_20.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_20.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 21">   
        if (lbl_almacen_ventas.getText().equals("0000021")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_21.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_21.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 22">   
        if (lbl_almacen_ventas.getText().equals("0000022")) {
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_22.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();
                            Connection cn = conectar.getInstance().getConnection();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_22.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 23">   
        if (lbl_almacen_ventas.getText().equals("0000023")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_23.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_23.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 24">   
        if (lbl_almacen_ventas.getText().equals("0000024")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_24.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_24.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 25">   
        if (lbl_almacen_ventas.getText().equals("0000025")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_25.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_25.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 26">   
        if (lbl_almacen_ventas.getText().equals("0000026")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_26.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_26.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Almacen 27">   
        if (lbl_almacen_ventas.getText().equals("0000027")) {
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();

                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_27.jasper");

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
                            Connection cn = conectar.getInstance().getConnection();

                            java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro.getDate().getTime());
                            java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro.getDate().getTime());
                            String ingre_gs = txt_total_ventas.getText();
                            String situacion = (String) cb_situ_ventas.getSelectedItem();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("fecha_ini", fecha_ini);
                            parametro.put("fecha_fin", fecha_fin);
                            parametro.put("saldo_gs", ingre_gs);
                            parametro.put("prove", situacion);
                            parametro.put("SUBREPORT_DIR", "Ventas/ventas_imp_surc/");
                            URL in = this.getClass().getResource("/Ventas/ventas_imp_surc/Listado_ventas_espec_27.jasper");
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
                            Logger.getLogger(ventas_anteriores_tarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        //</editor-fold>
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lbl_almacen_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_ventasMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            Seleccion_surcusal_free evs;
            evs = new Seleccion_surcusal_free(new javax.swing.JDialog(), true);
            evs.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No cuenta con premiso para otras sucursales/Almacenes");
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
            java.util.logging.Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventas_anteriores_tarjeta dialog = new ventas_anteriores_tarjeta(new javax.swing.JDialog(), true);
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
    private org.jdesktop.swingx.JXComboBox cb_situ_ventas;
    private javax.swing.JCheckBox ch_situacion;
    private javax.swing.JCheckBox ch_todos;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JLabel lbl_almacen_ventas;
    private javax.swing.JPanel pn_config;
    private javax.swing.JTable tb_devo;
    public static javax.swing.JTable tb_ventas;
    private javax.swing.JTextField txt_total_dev;
    public static javax.swing.JTextField txt_total_gs;
    private javax.swing.JTextField txt_total_ventas;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

/////almacen 1
    void cargarSurc_situ(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //2
    void cargarSurc_situ_2(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_2 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_2 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
//16

    void cargarSurc_situ_16(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_16 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_16(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_16 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //18
    void cargarSurc_situ_18(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_18 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_18(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_18 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
////almacen 20

    void cargarSurc_situ_20(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_20 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_20(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_20 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //11
    void cargarSurc_situ_11(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_11 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_11(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_11 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //11
    void cargarSurc_situ_14(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_14 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_14(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_14 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //22
    void cargarSurc_situ_22(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_22 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_22(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_22 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //15
    void cargarSurc_situ_15(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_15 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_15(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_15 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //19
    void cargarSurc_situ_19(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_19 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_19(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_19 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///03
    void cargarTodos_3(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_3 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_3(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_3 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////04
    void cargarTodos_4(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_4 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_4(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_4 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////05
    void cargarTodos_5(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_5 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_5(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_5 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////23
    void cargarTodos_23(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_23 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_23(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_23 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////24
    void cargarTodos_24(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_24 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_24(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_24 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////17
    void cargarTodos_17(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_17 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_17(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_17 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////
    void cargarTodos_6(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_6 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_6(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_6 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_25(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_25 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_25(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_25 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_7(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_7 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_7(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_7 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_8(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_8 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_8(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_8 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_9(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_9 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_9(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_9 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_10(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_10 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_10(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_10 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_12(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_12 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_12(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_12 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_13(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_13 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_13(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_13 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_21(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_21 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_21(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_21 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_26(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_26 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_26(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_26 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_27(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_27 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_27(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_27 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_28(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_28 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_28(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_28 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_29(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_29 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_29(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_29 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos_30(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM ventas_30 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_ventas NOT IN ('DEVUELTO') ";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarSurc_situ_30(Date fecha_ini, Date fecha_fin, String alma, String situ) {
        String mostrar = "SELECT * FROM ventas_30 WHERE   fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND almacen_ventas='" + alma + "' AND estado_ventas='" + situ + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("nom_cli_ventas");
                Registros[2] = rs.getString("forma_pag_ventas");
                Registros[3] = rs.getString("total_ventas");
                Registros[4] = rs.getString("fecha_ventas");
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

///////////////////////////////////////////////////////////////////////////////////////////
    void cargarDev(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM devoluciones WHERE   fecha_dev BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND estado_dev='CONFIRMADA' ";
        String[] titulos = {"N° devol", " Valor Total", "situacion"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_dev");
                Registros[1] = rs.getString("total_dev");
                Registros[2] = rs.getString("estado_dev");

                model.addRow(Registros);
            }
            tb_devo.setModel(model);

            tb_devo.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_devo.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_devo.getColumnModel().getColumn(2).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs.setText(subtotal);

        }
    }

    public void calcularDev() {

        String impd = "0", subtotald = "0", totald = "0";

        for (int i = 0; i < tb_devo.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_devo.getValueAt(i, 1).toString().replaceAll("\\s", ""));

            impd = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotald = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotald).add(ingreso.TransformReales(impd)).toString());

            txt_total_dev.setText(subtotald);

        }
    }

    public void calcularTotal() {

        String net = "0";
        BigDecimal valor_total = ingreso.TransformReales(txt_total_dev.getText());
        BigDecimal valor_ultimo = ingreso.TransformReales(txt_total_gs.getText());
        net = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_ultimo.subtract(valor_total).toString());
        txt_total_ventas.setText(net);

    }

    void cargarUsu() {

        String user = Principal.lbl_id_user.getText();
        String mostrar = "select * from usuarios where usu_cod='" + user + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_almacen_ventas.setText(rs.getString(6));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_tarjeta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void inicio() {

        txt_total_dev.setText("0");
        txt_total_gs.setText("0");
        txt_total_ventas.setText("0");

    }
}//FIN CLASE
