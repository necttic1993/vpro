/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.transferencias;

import Clases.GenerarNumero;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import static Productos.transferencias.Principal_transferencia.btn_cargar_trans;
import java.awt.Color;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
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

/**
 *
 * @author User
 */
public class trans_dep_pro extends javax.swing.JDialog {

    /**
     * Creates new form trans_dinero_caja
     */
    public trans_dep_pro(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        codigos();
        nro_alma_ori.setDisabledTextColor(Color.red);
        nro_alma_des.setDisabledTextColor(Color.black);
        nombre_cuneta_ori.setDisabledTextColor(Color.red);
        nom_cuenta_des.setDisabledTextColor(Color.black);
        panel_calculo.setVisible(false);
        tb_trans_stock.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_trans_stock.getColumnModel().getColumn(1).setPreferredWidth(323);
        tb_trans_stock.getColumnModel().getColumn(2).setPreferredWidth(120);
        tb_trans_stock.getColumnModel().getColumn(3).setPreferredWidth(75);
        tb_trans_stock.getColumnModel().getColumn(4).setPreferredWidth(120);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre_cuneta_ori = new javax.swing.JTextField();
        nom_cuenta_des = new javax.swing.JTextField();
        nro_alma_des = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nro_alma_ori = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_stock_nro = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        panel_calculo = new javax.swing.JPanel();
        btncalcular = new javax.swing.JButton();
        btn_origen = new javax.swing.JButton();
        btn_destino = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_cod_ventas = new javax.swing.JTextField();
        lbl_status_trans = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_trans_stock = new javax.swing.JTable();
        btn_buscaar_items = new javax.swing.JButton();
        txt_descrip = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_monto_trans_gs = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_cod_trans = new javax.swing.JTextField();
        bnt_busca_ventas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferencia de Stock");
        setLocation(new java.awt.Point(300, 100));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Cantidad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 64, 32));

        nombre_cuneta_ori.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nombre_cuneta_ori.setEnabled(false);
        jPanel1.add(nombre_cuneta_ori, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 490, 32));

        nom_cuenta_des.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nom_cuenta_des.setEnabled(false);
        nom_cuenta_des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_cuenta_desActionPerformed(evt);
            }
        });
        jPanel1.add(nom_cuenta_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 74, 490, 32));

        nro_alma_des.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nro_alma_des.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nro_alma_des.setEnabled(false);
        jPanel1.add(nro_alma_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 74, 110, 32));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Nro Transferencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, 32));

        nro_alma_ori.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nro_alma_ori.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nro_alma_ori.setEnabled(false);
        jPanel1.add(nro_alma_ori, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 110, 32));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 75, 50, 32));

        txt_stock_nro.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_stock_nro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_stock_nro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_stock_nro.setEnabled(false);
        txt_stock_nro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stock_nroKeyReleased(evt);
            }
        });
        jPanel1.add(txt_stock_nro, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 100, 32));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/transfer.png"))); // NOI18N
        jButton2.setText("Ok");
        jButton2.setToolTipText("Transferir");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, 45));

        panel_calculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncalcular.setBackground(new java.awt.Color(255, 255, 255));
        btncalcular.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btncalcular.setMnemonic('c');
        btncalcular.setToolTipText("Calcular ALT+C");
        btncalcular.setBorder(new javax.swing.border.MatteBorder(null));
        btncalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncalcular.setFocusable(false);
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        panel_calculo.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 40, 20));

        btn_origen.setText("origen");
        btn_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_origenActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        btn_destino.setText("destino");
        btn_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_destinoActionPerformed(evt);
            }
        });
        panel_calculo.add(btn_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

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
        panel_calculo.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 50, 20));

        txt_cod_ventas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_ventasActionPerformed(evt);
            }
        });
        txt_cod_ventas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_ventasKeyPressed(evt);
            }
        });
        panel_calculo.add(txt_cod_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 90, -1));

        lbl_status_trans.setText("status");
        panel_calculo.add(lbl_status_trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 50, 20));

        jPanel1.add(panel_calculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 270, 80));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 50, 32));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Almacén Destino:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 74, -1, 32));

        tb_trans_stock = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_trans_stock.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_trans_stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio Unitario", "Cantidad", "Subtotal"
            }
        ));
        tb_trans_stock.setGridColor(new java.awt.Color(255, 255, 255));
        tb_trans_stock.setRowHeight(22);
        tb_trans_stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_trans_stockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_trans_stock);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 780, 300));

        btn_buscaar_items.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscaar_items.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_buscaar_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        btn_buscaar_items.setMnemonic('a');
        btn_buscaar_items.setToolTipText("Stock");
        btn_buscaar_items.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscaar_items.setFocusable(false);
        btn_buscaar_items.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_buscaar_items.setVerifyInputWhenFocusTarget(false);
        btn_buscaar_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaar_itemsActionPerformed(evt);
            }
        });
        btn_buscaar_items.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_buscaar_itemsKeyPressed(evt);
            }
        });
        jPanel1.add(btn_buscaar_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 100, 45));

        txt_descrip.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_descrip.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_descrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descripKeyReleased(evt);
            }
        });
        jPanel1.add(txt_descrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 460, 32));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Descripción:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 90, 32));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Total :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 50, 32));

        txt_monto_trans_gs.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_monto_trans_gs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_monto_trans_gs.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_monto_trans_gs.setEnabled(false);
        txt_monto_trans_gs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_monto_trans_gsKeyReleased(evt);
            }
        });
        jPanel1.add(txt_monto_trans_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 200, 32));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Almacén Origen:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 32));

        txt_cod_trans.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_cod_trans.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_cod_trans.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_cod_trans.setEnabled(false);
        jPanel1.add(txt_cod_trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 140, 32));

        bnt_busca_ventas.setBackground(new java.awt.Color(255, 255, 255));
        bnt_busca_ventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bnt_busca_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/tienda-online.png"))); // NOI18N
        bnt_busca_ventas.setToolTipText("Ventas");
        bnt_busca_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnt_busca_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_busca_ventasActionPerformed(evt);
            }
        });
        jPanel1.add(bnt_busca_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 100, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        almacen_destino transdes;
        transdes = new almacen_destino(new javax.swing.JDialog(), true);
        transdes.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_stock_nroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stock_nroKeyReleased

    }//GEN-LAST:event_txt_stock_nroKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if ((txt_stock_nro.getText().equals("")) || (nro_alma_ori.getText().equals("")) || (nro_alma_des.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Verifiqe los datos");

        } else {

            Mensaje_transferencia transmen;
            transmen = new Mensaje_transferencia(new javax.swing.JDialog(), true);
            transmen.setVisible(true);

            if (JOptionPane.showConfirmDialog(rootPane, "Destino de transferencia" + ": " + nom_cuenta_des.getText() + ", ¿Desea continuar?",
                    "Transferencias", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                btn_origen.doClick();
                btn_destino.doClick();
                transfe();

                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                    if (printService.length > 0)//si existen impresoras
                    {
                        //se elige la impresora
                        PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                                "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                        if (impresora != null) //Si se selecciono una impresora
                        {
                            try {
                                String cod = txt_cod_trans.getText();

                                Map parametro = new HashMap();
                                parametro.clear();
                                parametro.put("codigo", cod);
                                Connection cn = conectar.getInstance().getConnection();

                                URL in = this.getClass().getResource("/Productos/transferencias/trans_imprime.jasper");

                                JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                                JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                                JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                                jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                                jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);

                                jrprintServiceExporter.exportReport();
                                conectar.getInstance().closeConnection(cn);

                            } catch (JRException ex) {

                            } catch (SQLException ex) {
                                Logger.getLogger(trans_dep_pro.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }

                }
                limpiar();
                codigos();
                JOptionPane.showMessageDialog(null, "Transferencia exitosa");
                btn_cargar_trans.doClick();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        almacen_origen transOri;
        transOri = new almacen_origen(new javax.swing.JDialog(), true);
        transOri.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nom_cuenta_desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_cuenta_desActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_cuenta_desActionPerformed

    private void btn_buscaar_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaar_itemsActionPerformed
        lbl_status_trans.setText("stock");
        bnt_busca_ventas.setEnabled(false);
        if (nro_alma_des.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Agregue ID de destino");
        } else {
            String cod_1 = nro_alma_ori.getText();
            String veri = nro_alma_des.getText();
            if (cod_1.equals(veri)) {
                JOptionPane.showMessageDialog(null, "Verifique el Id a transferir");
            } else {

                Productos_transfe rpt;
                rpt = new Productos_transfe(new javax.swing.JDialog(), true);
                rpt.setVisible(true);
            }
        }
    }//GEN-LAST:event_btn_buscaar_itemsActionPerformed

    private void btn_buscaar_itemsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_buscaar_itemsKeyPressed

    }//GEN-LAST:event_btn_buscaar_itemsKeyPressed

    private void txt_descripKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripKeyReleased

    private void txt_monto_trans_gsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_monto_trans_gsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_monto_trans_gsKeyReleased

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        calcular();
        calcularCantidadPro();

    }//GEN-LAST:event_btncalcularActionPerformed

    private void btn_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_destinoActionPerformed
        /*
         if ((nro_alma_des.getText().equals("0000001"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
         capcod = tb_trans_stock.getValueAt(i, 0).toString();
         capcan = tb_trans_stock.getValueAt(i, 3).toString();
         AumnetarStock(capcod, capcan);
         }

         }
         if ((nro_alma_des.getText().equals("0000002"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
         capcod = tb_trans_stock.getValueAt(i, 0).toString();
         capcan = tb_trans_stock.getValueAt(i, 3).toString();
         AumnetarStock_2(capcod, capcan);
         }

         }
         if ((nro_alma_des.getText().equals("0000003"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
         capcod = tb_trans_stock.getValueAt(i, 0).toString();
         capcan = tb_trans_stock.getValueAt(i, 3).toString();
         AumnetarStock_3(capcod, capcan);
         }

         }
         if ((nro_alma_des.getText().equals("0000004"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
         capcod = tb_trans_stock.getValueAt(i, 0).toString();
         capcan = tb_trans_stock.getValueAt(i, 3).toString();
         AumnetarStock_4(capcod, capcan);
         }

         }
         if ((nro_alma_des.getText().equals("0000005"))) {
         String capcod = "", capcan = "";
         for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
         capcod = tb_trans_stock.getValueAt(i, 0).toString();
         capcan = tb_trans_stock.getValueAt(i, 3).toString();
         AumnetarStock_5(capcod, capcan);
         }

         }*/

    }//GEN-LAST:event_btn_destinoActionPerformed

    private void btn_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_origenActionPerformed

        if ((nro_alma_ori.getText().equals("0000001"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                if (lbl_status_trans.getText().equals("stock")) {
                    descontarStock(capcod, capcan);
                }

                if (lbl_status_trans.getText().equals("ventas")) {
                   // descontarStock(capcod, capcan);
                    //devolverSeparacion(capcod, capcan);
                }
            }

        }
        if ((nro_alma_ori.getText().equals("0000002"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_2(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000003"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_3(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000004"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_4(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000005"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_5(capcod, capcan);
            }

        }

        //new deposito
        if ((nro_alma_ori.getText().equals("0000006"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_6(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000007"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_7(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000008"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_8(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000009"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_9(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000010"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_10(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000011"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_11(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000012"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_12(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000013"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_13(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000014"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_14(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000015"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_15(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000016"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_16(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000017"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_17(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000018"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_18(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000019"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_19(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000020"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_20(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000021"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_21(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000022"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_22(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000023"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_23(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000024"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_24(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000025"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_25(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000026"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_26(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000027"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_27(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000028"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_28(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000029"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_29(capcod, capcan);
            }

        }
        if ((nro_alma_ori.getText().equals("0000030"))) {
            String capcod = "", capcan = "";
            for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
                capcod = tb_trans_stock.getValueAt(i, 0).toString();
                capcan = tb_trans_stock.getValueAt(i, 3).toString();
                descontarStock_30(capcod, capcan);
            }

        }
    }//GEN-LAST:event_btn_origenActionPerformed

    private void bnt_busca_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_busca_ventasActionPerformed
        lbl_status_trans.setText("ventas");
        btn_buscaar_items.setEnabled(false);

        if (nro_alma_des.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Agregue ID de destino");
        } else {

            String cod_1 = nro_alma_ori.getText();
            String veri = nro_alma_des.getText();
            if (cod_1.equals(veri)) {
                JOptionPane.showMessageDialog(null, "Verifique el Id a transferir");
            } else {

                Ventas_transferencias vt;
                vt = new Ventas_transferencias(new javax.swing.JDialog(), true);
                vt.setVisible(true);
            }
        }
    }//GEN-LAST:event_bnt_busca_ventasActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        cargar(txt_cod_ventas.getText());
        btncalcular.doClick();
        // ch_contado.doClick();
        // ch_credito.setSelected(false);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_cod_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_ventasActionPerformed

    private void txt_cod_ventasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_ventasKeyPressed

    }//GEN-LAST:event_txt_cod_ventasKeyPressed

    private void tb_trans_stockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_trans_stockMouseClicked
        if (JOptionPane.showConfirmDialog(rootPane, "Excluir, ¿desea continuar?",
                "Items", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tb_trans_stock.getModel();
            int fila = tb_trans_stock.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);

            }
            btncalcular.doClick();

        }
    }//GEN-LAST:event_tb_trans_stockMouseClicked

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
            java.util.logging.Logger.getLogger(trans_dep_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trans_dep_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trans_dep_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trans_dep_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                trans_dep_pro dialog = new trans_dep_pro(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton bnt_busca_ventas;
    public static javax.swing.JButton btn_buscaar_items;
    public static javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_destino;
    private javax.swing.JButton btn_origen;
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_status_trans;
    public static javax.swing.JTextField nom_cuenta_des;
    public static javax.swing.JTextField nombre_cuneta_ori;
    public static javax.swing.JTextField nro_alma_des;
    public static javax.swing.JTextField nro_alma_ori;
    private javax.swing.JPanel panel_calculo;
    public static javax.swing.JTable tb_trans_stock;
    private javax.swing.JTextField txt_cod_trans;
    public static javax.swing.JTextField txt_cod_ventas;
    public static javax.swing.JTextField txt_descrip;
    private javax.swing.JTextField txt_monto_trans_gs;
    private javax.swing.JTextField txt_stock_nro;
    // End of variables declaration//GEN-END:variables

//////////almacen origen
    void descontarStock(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(5);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
        }
    }

    void devolverSeparacion(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(23);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_alma='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
        }
    }

    void descontarStock_2(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(25);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_2='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_3(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(26);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_3='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_4(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(27);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_4='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_5(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(28);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_5='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    ///new deposito
    void descontarStock_6(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(29);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_6='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_7(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(30);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_7='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_8(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(31);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_8='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_9(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(32);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_9='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_10(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(33);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_10='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_11(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(34);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_11='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_12(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(35);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_12='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_13(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(36);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_13='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_14(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(37);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_14='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_15(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(38);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_15='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_16(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(39);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_16='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_17(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(40);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_17='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_18(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(41);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_18='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_19(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(42);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_19='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_20(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(43);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_20='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_21(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(44);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_21='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_22(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(45);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_22='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_23(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(46);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_23='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_24(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(47);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_24='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_25(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(48);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_25='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_26(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(49);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_26='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_27(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(50);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_27='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_28(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(51);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_28='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_29(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(52);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_29='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void descontarStock_30(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(53);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_stock_30='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

//////////almacen destino
    /* void AumnetarStock(String codi, String can) {
     int des = Integer.parseInt(can);
     String cap = "";
     int desfinal;
     String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
     try {
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(consul);
     while (rs.next()) {
     cap = rs.getString(5);//pendiente a modificacion
     }

     } catch (Exception e) {
     }
     desfinal = Integer.parseInt(cap) + des;
     String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     } catch (Exception e) {
     }
     }

     void AumnetarStock_2(String codi, String can) {
     int des = Integer.parseInt(can);
     String cap = "";
     int desfinal;
     String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
     try {
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(consul);
     while (rs.next()) {
     cap = rs.getString(25);//pendiente a modificacion
     }

     } catch (Exception e) {
     }
     desfinal = Integer.parseInt(cap) + des;
     String modi = "UPDATE tienda_productos SET pro_stock_2='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     } catch (Exception e) {
     }
     }

     void AumnetarStock_3(String codi, String can) {
     int des = Integer.parseInt(can);
     String cap = "";
     int desfinal;
     String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
     try {
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(consul);
     while (rs.next()) {
     cap = rs.getString(26);//pendiente a modificacion
     }

     } catch (Exception e) {
     }
     desfinal = Integer.parseInt(cap) + des;
     String modi = "UPDATE tienda_productos SET pro_stock_3='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     } catch (Exception e) {
     }
     }

     void AumnetarStock_4(String codi, String can) {
     int des = Integer.parseInt(can);
     String cap = "";
     int desfinal;
     String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
     try {
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(consul);
     while (rs.next()) {
     cap = rs.getString(27);//pendiente a modificacion
     }

     } catch (Exception e) {
     }
     desfinal = Integer.parseInt(cap) + des;
     String modi = "UPDATE tienda_productos SET pro_stock_4='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     } catch (Exception e) {
     }
     }

     void AumnetarStock_5(String codi, String can) {
     int des = Integer.parseInt(can);
     String cap = "";
     int desfinal;
     String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
     try {
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(consul);
     while (rs.next()) {
     cap = rs.getString(28);//pendiente a modificacion
     }

     } catch (Exception e) {
     }
     desfinal = Integer.parseInt(cap) + des;
     String modi = "UPDATE tienda_productos SET pro_stock_5='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
     try {
     PreparedStatement pst = cn.prepareStatement(modi);
     pst.executeUpdate();
     } catch (Exception e) {
     }
     }*/
    void limpiar() {
        nro_alma_ori.setText("");
        nombre_cuneta_ori.setText("");
        nro_alma_des.setText("");
        nom_cuenta_des.setText("");
        txt_stock_nro.setText("");
        txt_descrip.setText("");
        txt_monto_trans_gs.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_trans_stock.getModel();
        int a = tb_trans_stock.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    void GuardarTRansferencia() {

        String InsertarSQL = "INSERT INTO transfe_cuentas (nro_cuenta_origen,nro_cuenta_destino,monto_trans,usu_ope,data) VALUES (?,?,?,?,?)";
        String nro_origen = nro_alma_ori.getText();
        String nro_destino = nro_alma_des.getText();
        String monto = txt_stock_nro.getText();//cambiar en db
        String usuario = lbl_usu_nom.getText();
        String data = Principal.lbl_fecha_hoy.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, nro_origen);
            pst.setString(2, nro_destino);
            pst.setString(3, monto);
            pst.setString(4, usuario);
            pst.setString(5, data);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                //JOptionPane.showMessageDialog(null, "Transferencia realizado con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(trans_dep_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcular() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_trans_stock.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_trans_stock.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_trans_stock.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 4);
            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            txt_monto_trans_gs.setText(total);

        }
    }//FIN METODO public vo

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_trans_stock.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(tb_trans_stock.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        txt_stock_nro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));

    }

    public String MaskaraPrecioUnitarioEnteros(String ValorGuaranies) {
        DecimalFormat format = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String a = ValorViejo.replace(",", "");
        NumeroIntacto = Long.valueOf(a).longValue();
        NroFormatado = format.format(NumeroIntacto);
        String LuzParaMisOjos = NroFormatado;
        return LuzParaMisOjos;
    }

    void codigos() {

        String c = "";
        String SQL = "select max(cod_tran) from transf_stock";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txt_cod_trans.setText("0000001");
            } else {
                int j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                txt_cod_trans.setText(gen.serie());

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(trans_dep_pro.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void transfe() {
        codigos();
        String InsertarSQL = "INSERT INTO transf_stock (cod_tran,id_alma_ori,nom_alma_ori,id_alma_des,nom_alma_des,des_tran,cant_pro,total_costo_tran,fecha_dia_tran,fecha_entrada,user_comp,estado_tran) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        String numtran = txt_cod_trans.getText();
        String id_alma_ori = nro_alma_ori.getText();
        String des_alma_ori = nombre_cuneta_ori.getText();//cambiar en db
        String id_alma_des = nro_alma_des.getText();
        String des_alma_des = nom_cuenta_des.getText();
        String des_tran = txt_descrip.getText();
        String cant = txt_stock_nro.getText();
        String tota_costo = txt_monto_trans_gs.getText();
        String fecha_dia = Principal.txt_fecha_backup.getText();
        String fecha = Principal.lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String estado = ("PENDIENTE");//cambiar en db

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numtran);
            pst.setString(2, id_alma_ori);
            pst.setString(3, des_alma_ori);
            pst.setString(4, id_alma_des);
            pst.setString(5, des_alma_des);
            pst.setString(6, des_tran);
            pst.setString(7, cant);
            pst.setString(8, tota_costo);
            pst.setString(9, fecha_dia);
            pst.setString(10, fecha);
            pst.setString(11, user);
            pst.setString(12, estado);
            int n = pst.executeUpdate();
            if (n > 0) {
                conectar.getInstance().closeConnection(cn);
                detalle_ticket();
                // JOptionPane.showMessageDialog(null, "Venta realizada con éxito");
                actualizaVentas();
            }

        } catch (SQLException ex) {
            Logger.getLogger(trans_dep_pro.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void detalle_ticket() {
        for (int i = 0; i < tb_trans_stock.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO transf_detalles (num_transf,cod_pro,des_pro,cant_pro,pre_unit,pre_venta,data) VALUES (?,?,?,?,?,?,?)";
            String numbol = txt_cod_trans.getText();
            String codpro = tb_trans_stock.getValueAt(i, 0).toString();
            String despro = tb_trans_stock.getValueAt(i, 1).toString();
            String cantpro = tb_trans_stock.getValueAt(i, 3).toString();
            String preunit = tb_trans_stock.getValueAt(i, 2).toString();
            String importe = tb_trans_stock.getValueAt(i, 4).toString();
            String fecha_det_con = Principal.lbl_fecha_hoy.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, numbol);
                pst.setString(2, codpro);
                pst.setString(3, despro);
                pst.setString(4, cantpro);
                pst.setString(5, preunit);
                pst.setString(6, importe);
                pst.setString(7, fecha_det_con);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(trans_dep_pro.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cargar(String valor) {
        String mostrar = "SELECT d.num_bol ,d.cod_pro ,d.des_pro,d.pre_venta, d.pre_unit ,d.cant_pro, p.pro_iva, p.pro_pre_a FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod  INNER JOIN ventas AS v ON d.num_bol=v.num_bol  WHERE v.num_bol='" + valor + "'";
        String[] titulos = {"Código", "Descripción", "Precio Unitario", "Cantidad", "Subtotal"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("cod_pro");
                Registros[1] = rs.getString("des_pro");
                Registros[2] = rs.getString("pre_unit");
                Registros[3] = rs.getString("cant_pro");
                Registros[4] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_trans_stock.setModel(model);

            tb_trans_stock.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_trans_stock.getColumnModel().getColumn(1).setPreferredWidth(323);
            tb_trans_stock.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_trans_stock.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_trans_stock.getColumnModel().getColumn(4).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(trans_dep_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void actualizaVentas() {
        try {
            String id = txt_cod_ventas.getText();
            String des = ("PROCESADA");
            String sql = "UPDATE ventas SET status_log = '" + des
                    + "' WHERE num_bol = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }
}
