//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_surcu_lucro;
import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;
//</editor-fold>

public class ventas_lucro_total extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public ventas_lucro_total(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbl_almacen_pedidos.setText(Principal.lbl_usu_almacen.getText());
        tb_lista_tablas.setVisible(false);
        txt_lucro_ventas.setDisabledTextColor(Color.black);
        txt_total_ventas.setDisabledTextColor(Color.black);

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
        txt_lucro_ventas = new javax.swing.JTextField();
        tb_lista_tablas = new javax.swing.JPanel();
        lbl_intermedio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_ventas_plazo = new javax.swing.JTable();
        lbl_total_parcial = new javax.swing.JLabel();
        lbl_subtotal_neto = new javax.swing.JLabel();
        txt_lucro_compra = new javax.swing.JTextField();
        txt_total_ventas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jd_fin_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro_ventas = new org.jdesktop.swingx.JXDatePicker();
        lbl_almacen_pedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumen Gral");
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
        jLabel16.setText("Fecha Final:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 90, 30));

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

        txt_lucro_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_lucro_ventas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_ventas.setText("0");
        txt_lucro_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_ventas.setEnabled(false);
        jPanel3.add(txt_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 440, 190, 30));

        tb_lista_tablas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_intermedio.setText("0");
        tb_lista_tablas.add(lbl_intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 20));

        tb_ventas_plazo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_ventas_plazo);

        tb_lista_tablas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 20));

        lbl_total_parcial.setText("0");
        tb_lista_tablas.add(lbl_total_parcial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 20, -1));

        lbl_subtotal_neto.setText("0");
        tb_lista_tablas.add(lbl_subtotal_neto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 30, -1));

        txt_lucro_compra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_lucro_compra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_lucro_compra.setText("0");
        txt_lucro_compra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_lucro_compra.setEnabled(false);
        tb_lista_tablas.add(txt_lucro_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 70, 30));

        txt_total_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total_ventas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_ventas.setText("0");
        txt_total_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_ventas.setEnabled(false);
        tb_lista_tablas.add(txt_total_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 70, 30));

        jPanel3.add(tb_lista_tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 310, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Total Lucro Ventas:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 140, 30));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1110, 370));

        jd_fin_lucro_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jd_fin_lucro_ventasActionPerformed(evt);
            }
        });
        jPanel3.add(jd_fin_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 140, 30));
        jPanel3.add(jd_ini_lucro_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

        lbl_almacen_pedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos.setText("0000000");
        lbl_almacen_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_pedidosMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_almacen_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 110, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventasKeyReleased

    }//GEN-LAST:event_tb_ventasKeyReleased

    private void tb_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventasMouseClicked
        /*int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_ventasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (lbl_almacen_pedidos.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Surcusal/Almacen válido");
        } else {

            if (Principal.lbl_model_lucro.getText().equals("1")) {
                if (lbl_almacen_pedidos.getText().equals("0000001")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_totales_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000002")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_2();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000003")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_3();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (lbl_almacen_pedidos.getText().equals("0000004")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_4();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000005")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_5();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000006")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_6();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000007")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_7();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000008")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_8();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000009")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_9();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000010")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_10();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000011")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_11();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000012")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_12();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000013")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_13();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000014")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_14();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000015")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_15();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000016")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_16();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000017")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_17();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000018")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_18();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000019")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_19();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000020")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_20();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000021")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_21();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000022")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_22();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000023")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_23();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000024")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_24();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000025")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_25();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000026")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_26();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000027")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_27();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000028")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_28();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000029")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_29();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000030")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_30();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                if (lbl_almacen_pedidos.getText().equals("0000001")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_totales_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000002")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_2_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000003")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_3_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (lbl_almacen_pedidos.getText().equals("0000004")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_4_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000005")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_5_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000006")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_6_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000007")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_7_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000008")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_8_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000009")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_9_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000010")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_10_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000011")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_11_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000012")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_12_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000013")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_13_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000014")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_14_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000015")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_15_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000016")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_16_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000017")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_17_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000018")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_18_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000019")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_19_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000020")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_20_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000021")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_21_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000022")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_22_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000023")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_23_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000024")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_24_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000025")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_25_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000026")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_26_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000027")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_27_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000028")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_28_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000029")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_29_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (lbl_almacen_pedidos.getText().equals("0000030")) {
                    try {
                        Reportes reporte = new Reportes();
                        reporte.Ventas_lucro_30_b();
                    } catch (JRException | SQLException ex) {
                        Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
        if (lbl_almacen_pedidos.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Surcusal/Almacen válido");
        } else {
            if (Principal.lbl_model_lucro.getText().equals("1")) {

                if (lbl_almacen_pedidos.getText().equals("0000001")) {
                    cargar(date1, date2);
                    inicio();
                    calcularVentasCompras();
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000002")) {
                    //-1
                    cargar2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000003")) {
                    //-1
                    cargar3(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000004")) {
                    //-1
                    cargar4(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000005")) {
                    //-1
                    cargar5(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000006")) {
                    //-1
                    cargar6(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000007")) {
                    //-1
                    cargar7(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000008")) {
                    //-1
                    cargar8(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000009")) {
                    //-1
                    cargar9(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000010")) {
                    //-1
                    cargar10(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000011")) {
                    //-1
                    cargar11(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000012")) {
                    //-1
                    cargar12(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000013")) {
                    //-1
                    cargar13(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000014")) {
                    //-1
                    cargar14(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000015")) {
                    //-1
                    cargar15(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000016")) {
                    //-1
                    cargar16(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000017")) {
                    //-1
                    cargar17(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000018")) {
                    //-1
                    cargar18(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000019")) {
                    //-1
                    cargar19(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000020")) {
                    //-1
                    cargar20(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000021")) {
                    //-1
                    cargar21(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000022")) {
                    //-1
                    cargar22(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000023")) {
                    //-1
                    cargar23(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000024")) {
                    //-1
                    cargar24(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000025")) {
                    //-1
                    cargar25(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000026")) {
                    //-1
                    cargar26(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000027")) {
                    //-1
                    cargar27(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000028")) {
                    //-1
                    cargar28(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000029")) {
                    //-1
                    cargar29(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000030")) {
                    //-1
                    cargar30(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }

            } else {

                if (lbl_almacen_pedidos.getText().equals("0000001")) {
                    cargar_2(date1, date2);
                    inicio();
                    calcularVentasCompras();
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000002")) {
                    //-1
                    cargar2_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000003")) {
                    //-1
                    cargar3_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000004")) {
                    //-1
                    cargar4_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000005")) {
                    //-1
                    cargar5_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000006")) {
                    //-1
                    cargar6_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000007")) {
                    //-1
                    cargar7_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000008")) {
                    //-1
                    cargar8_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000009")) {
                    //-1
                    cargar9_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000010")) {
                    //-1
                    cargar10_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000011")) {
                    //-1
                    cargar11_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000012")) {
                    //-1
                    cargar12_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000013")) {
                    //-1
                    cargar13_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000014")) {
                    //-1
                    cargar14_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000015")) {
                    //-1
                    cargar15_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000016")) {
                    //-1
                    cargar16_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000017")) {
                    //-1
                    cargar17_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000018")) {
                    //-1
                    cargar18(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000019")) {
                    //-1
                    cargar19_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000020")) {
                    //-1
                    cargar20_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000021")) {
                    //-1
                    cargar21_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000022")) {
                    //-1
                    cargar22_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000023")) {
                    //-1
                    cargar23_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000024")) {
                    //-1
                    cargar24_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000025")) {
                    //-1
                    cargar25_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000026")) {
                    //-1
                    cargar26_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000027")) {
                    //-1
                    cargar27_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000028")) {
                    //-1
                    cargar28_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000029")) {
                    //-1
                    cargar29_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
                if (lbl_almacen_pedidos.getText().equals("0000030")) {
                    //-1
                    cargar30_2(date1, date2);
                    //-2
                    inicio();
                    //-3
                    calcularVentasCompras();
                    //-4
                    lista_ventas();
                    Total_compras();
                    TotalVentasMenosCompras();

                }
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jd_fin_lucro_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jd_fin_lucro_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jd_fin_lucro_ventasActionPerformed

    private void lbl_almacen_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_pedidosMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_surcu_lucro sl;
            sl = new Seleccion_surcu_lucro(new javax.swing.JDialog(), true);
            sl.setVisible(true);

        }
    }//GEN-LAST:event_lbl_almacen_pedidosMouseClicked
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
            java.util.logging.Logger.getLogger(ventas_lucro_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas_lucro_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventas_lucro_total dialog = new ventas_lucro_total(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static org.jdesktop.swingx.JXDatePicker jd_fin_lucro_ventas;
    public static org.jdesktop.swingx.JXDatePicker jd_ini_lucro_ventas;
    public static javax.swing.JLabel lbl_almacen_pedidos;
    private javax.swing.JLabel lbl_intermedio;
    private javax.swing.JLabel lbl_subtotal_neto;
    private javax.swing.JLabel lbl_total_parcial;
    private javax.swing.JPanel tb_lista_tablas;
    public static javax.swing.JTable tb_ventas;
    private javax.swing.JTable tb_ventas_plazo;
    public static javax.swing.JTextField txt_lucro_compra;
    public static javax.swing.JTextField txt_lucro_ventas;
    public static javax.swing.JTextField txt_total_ventas;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    ///////////////////////cargar datos///////////////////////////////////
    void cargar(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta,v.forma_pag_ventas FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////2
    void cargar2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //3
    void cargar3(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///4
    void cargar4(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///5
    void cargar5(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_5 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_5 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///6
    void cargar6(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_6 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_6 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///7
    void cargar7(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_7 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_7 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///8
    void cargar8(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_8 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_8 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///9
    void cargar9(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_9 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_9 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///10
    void cargar10(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_10 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_10 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///11
    void cargar11(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_11 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_11 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///12
    void cargar12(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_12 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_12 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///13
    void cargar13(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_13 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_13 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///14
    void cargar14(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///15
    void cargar15(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_15 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_15 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///16
    void cargar16(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_16 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_16 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///17
    void cargar17(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_17 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_17 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///18
    void cargar18(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_18 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_18 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///19
    void cargar19(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_19 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_19 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///20
    void cargar20(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_20 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_20 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///21
    void cargar21(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_21 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_21 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///22
    void cargar22(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_22 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_22 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///23
    void cargar23(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_23 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_23 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///24
    void cargar24(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_24 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_24 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///25
    void cargar25(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_25 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_25 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///26
    void cargar26(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_26 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_26 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///27
    void cargar27(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_27 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_27 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///28
    void cargar28(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_28 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_28 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///29
    void cargar29(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_29 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_29 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///30
    void cargar30(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_b,d.pre_venta FROM ventas_detalles_30 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_30 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
                Registros[5] = rs.getString("pro_pre_b");
                Registros[6] = rs.getString("pre_unit");
                Registros[8] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void inicio() {
        txt_total_ventas.setText("0");
        txt_lucro_compra.setText("0");
        txt_lucro_ventas.setText("0");

    }

    public void lista_ventas() {

        String impv = "0", subtotalv = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 8).toString().replaceAll("\\s", ""));

            impv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalv).add(ingreso.TransformReales(impv)).toString());

            txt_total_ventas.setText(subtotalv);

        }
    }

    public void Total_compras() {

        String impc = "0", subtotalc = "0", totalc = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 7).toString().replaceAll("\\s", ""));

            impc = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalc = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalc).add(ingreso.TransformReales(impc)).toString());

            txt_lucro_compra.setText(subtotalc);

        }
    }

    ////////calcula precio compra - precio ventas en la tabla///////////////////////
    public void calcularVentasCompras() {

        String imp = "0", subtotal = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_ventas.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_ventas.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);

        }
    }

/////////diferencia total compra - ventas
    public void TotalVentasMenosCompras() {

        String totalCuentaDa = "0";
        BigDecimal VentaTotal = ingreso.TransformReales(txt_total_ventas.getText());
        BigDecimal ValorCompra = ingreso.TransformReales(txt_lucro_compra.getText());
        totalCuentaDa = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(VentaTotal.subtract(ValorCompra).toString());
        txt_lucro_ventas.setText(totalCuentaDa);

    }
/////sumar debitos egresos-devoluciones

    ///////////////////////lucro modelo 2/////////////////////////////////////////////
    void cargar_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta,v.forma_pag_ventas FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////2
    void cargar2_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_2 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_2 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //3
    void cargar3_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///4
    void cargar4_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_4 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_4 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///5
    void cargar5_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_5 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_5 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///6
    void cargar6_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_6 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_6 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///7
    void cargar7_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_7 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_7 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///8
    void cargar8_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_8 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_8 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///9
    void cargar9_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_9 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_9 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///10
    void cargar10_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_10 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_10 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///11
    void cargar11_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_11 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_11 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///12
    void cargar12_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_12 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_12 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///13
    void cargar13_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_13 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_13 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///14
    void cargar14_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_3 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_3 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///15
    void cargar15_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_15 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_15 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///16
    void cargar16_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_16 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_16 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///17
    void cargar17_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_17 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_17 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///18
    void cargar18_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_18 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_18 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///19
    void cargar19_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_19 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_19 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///20
    void cargar20_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_20 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_20 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///21
    void cargar21_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_21 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_21 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///22
    void cargar22_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_22 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_22 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///23
    void cargar23_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_23 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_23 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///24
    void cargar24_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_24 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_24 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///25
    void cargar25_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_25 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_25 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///26
    void cargar26_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_26 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_26 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///27
    void cargar27_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_27 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_27 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///28
    void cargar28_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_28 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_28 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///29
    void cargar29_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_29 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_29 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///30
    void cargar30_2(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT d.num_bol , d.data , d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta FROM ventas_detalles_30 AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas_30 AS v ON d.num_bol=v.num_bol WHERE d.data BETWEEN  '" + fecha_ini + "' AND '" + fecha_fin + "'  AND v.estado_ventas='CONFIRMADA' ORDER BY d.data ASC";
        String[] titulos = {"N° Venta", "Fecha Salida", "Producto", "Id Producto", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);
        // System.out.println(mostrar);
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
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(348);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(72);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(ventas_lucro_total.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
