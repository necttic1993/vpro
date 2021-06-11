//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_surcusal_ven_usus;
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

public class ventas_anteriores_usuarios extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public ventas_anteriores_usuarios(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_total_gs_usu.setDisabledTextColor(Color.black);
        lbl_almacen_usu.setText(Principal.lbl_usu_almacen.getText());

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";
    public static String cod_usu = "";

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
        txt_total_gs_usu = new javax.swing.JTextField();
        chk_plazo = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jd_fin_lucro_usu = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro_usu = new org.jdesktop.swingx.JXDatePicker();
        txt_nom_user = new javax.swing.JTextField();
        txt_id_user = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        lbl_almacen_usu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Ventas");
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 970, 400));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 70, 50));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Fecha Final:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Usuario:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Total :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 50, 30));

        txt_total_gs_usu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_total_gs_usu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs_usu.setEnabled(false);
        txt_total_gs_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gs_usuActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 200, 30));

        chk_plazo.setBackground(new java.awt.Color(255, 255, 255));
        chk_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_plazo.setText("INCLUIR  CRÉDITO/E-C");
        chk_plazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_plazoActionPerformed(evt);
            }
        });
        jPanel3.add(chk_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 160, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 70, 50));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));
        jPanel3.add(jd_fin_lucro_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));
        jPanel3.add(jd_ini_lucro_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

        txt_nom_user.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_nom_user.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_user.setEnabled(false);
        jPanel3.add(txt_nom_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 310, 30));

        txt_id_user.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_id_user.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_user.setEnabled(false);
        jPanel3.add(txt_id_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 60, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/agregando-boton-cuadrado-negro-simbolo-de-interfaz.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 32, 32));

        lbl_almacen_usu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_usu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_usu.setText("almacen");
        lbl_almacen_usu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_usu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_usuMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_almacen_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
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
        String user = txt_nom_user.getText();
        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_usu.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_usu.getDate().getTime());

        if (lbl_almacen_usu.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(null, "Selecione un Almacén/sucursal válido");
        } else {

            if (lbl_almacen_usu.getText().equals("0000001")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar(date1, date2, user);
                    calcularGS();
                }
            }

            if (lbl_almacen_usu.getText().equals("0000002")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_2(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_2(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000003")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_3(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_3(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000004")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_4(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_4(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000005")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_5(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_5(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000006")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_6(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_6(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000007")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_7(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_7(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000008")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_8(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_8(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000009")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_9(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_9(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000010")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_10(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_10(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000011")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_11(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_11(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000012")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_12(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_12(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000013")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_13(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_13(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000014")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_14(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_14(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000015")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_15(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_15(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000016")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_16(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_16(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000017")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_17(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_17(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000018")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_18(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_18(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000019")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_19(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_19(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000020")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_20(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_20(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000021")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_21(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_21(date1, date2, user);
                    calcularGS();
                }
            }

            if (lbl_almacen_usu.getText().equals("0000022")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_22(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_22(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000023")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_23(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_23(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000024")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_24(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_24(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000025")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_25(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_25(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000026")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_26(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_26(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000027")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_27(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_27(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000028")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_28(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_28(date1, date2, user);
                    calcularGS();
                }
            }

            if (lbl_almacen_usu.getText().equals("0000029")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_29(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_29(date1, date2, user);
                    calcularGS();
                }
            }
            if (lbl_almacen_usu.getText().equals("0000030")) {
                if (chk_plazo.isSelected()) {
                    txt_total_gs_usu.setText("0");
                    cargarC_30(date1, date2, user);
                    calcularGS();
                } else {
                    txt_total_gs_usu.setText("0");
                    cargar_30(date1, date2, user);
                    calcularGS();
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gs_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gs_usuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gs_usuActionPerformed

    private void chk_plazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_plazoActionPerformed


    }//GEN-LAST:event_chk_plazoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                Ventas_users cl;// Instaciamos la clase empleado
                List<Ventas_users> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_ventas.getRowCount(); i++) { // Iterena cada fila de la tabla
                    cl = new Ventas_users(tb_ventas.getValueAt(i, 0).toString(), tb_ventas.getValueAt(i, 1).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_ventas.getValueAt(i, 2).toString(), tb_ventas.getValueAt(i, 3).toString(), tb_ventas.getValueAt(i, 4).toString());
                    lista.add(cl); //Agregamos el objeto empleado a la lista
                }

                try {

                    java.sql.Date fecha_ini = new java.sql.Date(jd_ini_lucro_usu.getDate().getTime());
                    java.sql.Date fecha_fin = new java.sql.Date(jd_fin_lucro_usu.getDate().getTime());
                    String total = txt_total_gs_usu.getText();
                    String users = txt_nom_user.getText();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("fecha_ini", fecha_ini);
                    parametro.put("fecha_fin", fecha_fin);
                    parametro.put("total", total);
                    parametro.put("users", users);

                    URL in = this.getClass().getResource("/Impresiones/Lista_ventas_users_all.jasper");
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cod_usu = lbl_almacen_usu.getText();
        Usuarios_ventas_all uv;
        uv = new Usuarios_ventas_all(new javax.swing.JDialog(), true);
        uv.setVisible(true);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void lbl_almacen_usuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_usuMouseClicked
        if (lbl_almacen_usu.getText().equals("TODOS")) {
            Seleccion_surcusal_ven_usus rp;
            rp = new Seleccion_surcusal_ven_usus(new javax.swing.JDialog(), true);
            rp.setVisible(true);
        } else {

        }


    }//GEN-LAST:event_lbl_almacen_usuMouseClicked
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
            java.util.logging.Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ventas_anteriores_usuarios dialog = new ventas_anteriores_usuarios(new javax.swing.JDialog(), true);
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
    private javax.swing.JCheckBox chk_plazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static org.jdesktop.swingx.JXDatePicker jd_fin_lucro_usu;
    public static org.jdesktop.swingx.JXDatePicker jd_ini_lucro_usu;
    public static javax.swing.JLabel lbl_almacen_usu;
    public static javax.swing.JTable tb_ventas;
    public static javax.swing.JTextField txt_id_user;
    public static javax.swing.JTextField txt_nom_user;
    public static javax.swing.JTextField txt_total_gs_usu;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs_usu.setText(subtotal);

        }
    }

    ///2
    void cargar_2(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_2 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_2(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_2 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //3
    void cargar_3(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_3 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_3(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_3 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //4
    void cargar_4(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_4 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_4(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_4 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //5
    void cargar_5(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_5 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_5(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_5 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //6
    void cargar_6(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_6 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_6(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_6 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //7
    void cargar_7(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_7 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));
                Registros[5] = rs.getString("user_ventas");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(242);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_7(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_7 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //8
    void cargar_8(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_8 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_8(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_8 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //9
    void cargar_9(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_9 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_9(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_9 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //10
    void cargar_10(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_10 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_10(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_10 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //11
    void cargar_11(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_11 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_11(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_11 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //12
    void cargar_12(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_12 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_12(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_12 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //13
    void cargar_13(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_13 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_13(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_13 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //14
    void cargar_14(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_14 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_14(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_14 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //15
    void cargar_15(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_15 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_15(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_15 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //16
    void cargar_16(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_16 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_16(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_16 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //17
    void cargar_17(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_17 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_17(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_17 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //18
    void cargar_18(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_18 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_18(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_18 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //19
    void cargar_19(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_19 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_19(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_9 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///20
    void cargar_20(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_20 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_20(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_20 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //21
    void cargar_21(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_21 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_21(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_21 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //22
    void cargar_22(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_22 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_22(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_22 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //23
    void cargar_23(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_23 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_23(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_23 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //24
    void cargar_24(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_24 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_24(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_24 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //25
    void cargar_25(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_25 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_25(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_25 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //26

    void cargar_26(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_26 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_26(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_26 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //27
    void cargar_27(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_27 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_27(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_27 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //28
    void cargar_28(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_28 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_28(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_28 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //29
    void cargar_29(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_29 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_29(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_29 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //30
    void cargar_30(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM ventas_30 WHERE forma_pag_ventas = 'CONTADO' AND fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + user + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC_30(Date fecha_ini, Date fecha_fin, String users) {
        String mostrar = "SELECT * FROM ventas_30 WHERE  fecha_ventas BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND user_ventas='" + users + "'";
        String[] titulos = {"N° Venta", "Cliente", "Condición", " Valor Total", "Fecha de Venta"};
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
                Registros[4] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_ventas"));

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_anteriores_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
