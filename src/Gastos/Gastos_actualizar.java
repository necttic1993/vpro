/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos;

import Clases.machusculas;
import Conexion_DB.conectar;
import static Gastos.Principapl_gastos.cod_gastos_actu;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_mone_def;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto
 */
public class Gastos_actualizar extends javax.swing.JDialog {

    long OL;

    int longitudBytes;
    String ruta = null;
    DefaultTableModel model;
    public static String cod_gastos_deta = "";

    public Gastos_actualizar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(807, 260);
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_edit_egresos.setBackground(new java.awt.Color(69, 84, 92));

        }
        txtcod.requestFocus();
        txt_provee.setDisabledTextColor(Color.black);
        txt_hist.setDisabledTextColor(Color.black);
        txtnom.setDocument(new machusculas());
        BuscarProductoEditarA(cod_gastos_actu);
        BuscarProvee(txt_id_prov_actu.getText());
        BuscarHistorico(txt_id_class_actu.getText());
        btn_re.setVisible(false);
        cargar(cod_gastos_actu);

    }

    void limpiar() {
        txtcod.setText("");
        txt_timbrado.setText("");
        jd_emision.setDate(null);
        txtnom.setText("");
        txt_provee.setText("");
        jd_entrada.setDate(null);
        txt_hist.setText("");
        txt_monto.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_edit_egresos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_provee = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_hist = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_timbrado = new javax.swing.JTextField();
        txt_id_gas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jd_entrada = new org.jdesktop.swingx.JXDatePicker();
        jd_emision = new org.jdesktop.swingx.JXDatePicker();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_detalles = new javax.swing.JTable();
        btn_re = new javax.swing.JButton();
        txt_id_prov_actu = new javax.swing.JTextField();
        txt_id_class_actu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Egresos");
        setResizable(false);

        panel_edit_egresos.setBackground(new java.awt.Color(255, 255, 255));
        panel_edit_egresos.setPreferredSize(new java.awt.Dimension(798, 529));
        panel_edit_egresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Concepto:");
        panel_edit_egresos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 70, 30));

        txtnom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });
        panel_edit_egresos.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 450, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Proveedor:");
        panel_edit_egresos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        txt_provee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_provee.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_provee.setEnabled(false);
        txt_provee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_proveeKeyTyped(evt);
            }
        });
        panel_edit_egresos.add(txt_provee, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 330, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText(" N° de Nota:");
        panel_edit_egresos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 30));

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });
        panel_edit_egresos.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 220, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Clasificación:");
        panel_edit_egresos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

        txt_hist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_hist.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hist.setEnabled(false);
        txt_hist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_histKeyTyped(evt);
            }
        });
        panel_edit_egresos.add(txt_hist, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 290, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Fecha Emisión:");
        panel_edit_egresos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Fecha Entrada:");
        panel_edit_egresos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 90, 30));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnguardar.setMnemonic('g');
        btnguardar.setText("Actualizar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        panel_edit_egresos.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 140, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Monto:");
        panel_edit_egresos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 50, 30));

        txt_monto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_montoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoKeyTyped(evt);
            }
        });
        panel_edit_egresos.add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 160, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_edit_egresos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_edit_egresos.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Timbrado N°:");
        panel_edit_egresos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 90, 30));

        txt_timbrado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_timbrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timbradoActionPerformed(evt);
            }
        });
        txt_timbrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_timbradoKeyTyped(evt);
            }
        });
        panel_edit_egresos.add(txt_timbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 140, 30));

        txt_id_gas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_id_gas.setEnabled(false);
        panel_edit_egresos.add(txt_id_gas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText(" Egreso N°:");
        panel_edit_egresos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 30));
        panel_edit_egresos.add(jd_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 110, 30));
        panel_edit_egresos.add(jd_emision, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 120, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/histo.png"))); // NOI18N
        jButton4.setText("Detalles");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel_edit_egresos.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 130, 40));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/arriba.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_edit_egresos.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 70, 40));

        tb_detalles.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Precio Unitario", "Unidad", "Precio Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_detalles.setGridColor(new java.awt.Color(255, 255, 255));
        tb_detalles.setRowHeight(22);
        tb_detalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_detallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_detalles);

        panel_edit_egresos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 760, 210));

        btn_re.setBackground(new java.awt.Color(255, 255, 255));
        btn_re.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_re.setMnemonic('c');
        btn_re.setToolTipText("Calcular ALT+C");
        btn_re.setBorder(new javax.swing.border.MatteBorder(null));
        btn_re.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_re.setFocusable(false);
        btn_re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reActionPerformed(evt);
            }
        });
        panel_edit_egresos.add(btn_re, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 40, 20));

        txt_id_prov_actu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_id_prov_actu.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_prov_actu.setEnabled(false);
        panel_edit_egresos.add(txt_id_prov_actu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 90, 30));

        txt_id_class_actu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_id_class_actu.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_class_actu.setEnabled(false);
        panel_edit_egresos.add(txt_id_class_actu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_edit_egresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_edit_egresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txt_monto.getText().length() != 0) {

            Date date = jd_emision.getDate();
            long d = date.getTime();
            java.sql.Date fecha_emi = new java.sql.Date(d);

            Date date2 = jd_entrada.getDate();
            long d2 = date2.getTime();
            java.sql.Date fecha_entra = new java.sql.Date(d2);

            try {
                String id = txt_id_gas.getText();
                String nro = txtcod.getText();
                String timbrado = txt_timbrado.getText();
                String concep = txtnom.getText();
                String prov = txt_id_prov_actu.getText();
                String hist = txt_id_class_actu.getText();
                String monto = txt_monto.getText();

                String sql = "UPDATE gastos SET gas_num = '" + nro
                        + "',gas_timbra ='" + timbrado
                        + "',gas_fecha_emi ='" + fecha_emi
                        + "',gas_des ='" + concep
                        + "',gas_provee ='" + prov
                        + "',gas_fecha_entra = '" + fecha_entra
                        + "',gas_histo = '" + hist
                        + "',gas_monto ='" + monto
                        + "' WHERE gas_id = '" + id + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();
                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    JOptionPane.showMessageDialog(null, "Actualizado");
                    limpiar();

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "Verife los campos estan vacios");
        }

        Principapl_gastos.btn_cargar_datos.doClick();
        this.dispose();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped

    }//GEN-LAST:event_txtnomKeyTyped

    private void txt_proveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_proveeKeyTyped

    }//GEN-LAST:event_txt_proveeKeyTyped

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodKeyTyped

    private void txt_histKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_histKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_histKeyTyped

    private void txt_montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_montoKeyTyped

    private void txt_timbradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timbradoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timbradoKeyTyped

    private void txt_timbradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timbradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timbradoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        provee_gastos_act clipre;
        clipre = new provee_gastos_act(new javax.swing.JDialog(), true);
        clipre.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        historicos_gastos_act gast;
        gast = new historicos_gastos_act(new javax.swing.JDialog(), true);
        gast.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

    private void txt_montoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyReleased
        ActivatedYourLife(txt_monto, evt);
    }//GEN-LAST:event_txt_montoKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setSize(807, 550);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setSize(807, 260);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb_detallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_detallesMouseClicked

        int filaModi = tb_detalles.getSelectedRow();
        cod_gastos_deta = (String) tb_detalles.getValueAt(filaModi, 0);
        detalle_edit mrp;
        mrp = new detalle_edit(new javax.swing.JDialog(), true);
        mrp.setVisible(true);


    }//GEN-LAST:event_tb_detallesMouseClicked

    private void btn_reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reActionPerformed
        cargar(txt_id_gas.getText());
        calcular();


    }//GEN-LAST:event_btn_reActionPerformed

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
            java.util.logging.Logger.getLogger(Gastos_actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gastos_actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gastos_actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gastos_actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Gastos_actualizar dialog = new Gastos_actualizar(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_re;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_emision;
    private org.jdesktop.swingx.JXDatePicker jd_entrada;
    private javax.swing.JPanel panel_edit_egresos;
    public static javax.swing.JTable tb_detalles;
    public static javax.swing.JTextField txt_hist;
    public static javax.swing.JTextField txt_id_class_actu;
    private javax.swing.JTextField txt_id_gas;
    public static javax.swing.JTextField txt_id_prov_actu;
    private javax.swing.JTextField txt_monto;
    public static javax.swing.JTextField txt_provee;
    private javax.swing.JTextField txt_timbrado;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables

    void BuscarProductoEditarA(String cod) {

        try {

            String codi = "", id = "", timbrado = "", emi = "", nom = "", prov = "", entra = "", hist = "", pre = "";
            Connection cn = conectar.getInstance().getConnection();
            String cons = "select * from gastos WHERE gas_id='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                id = rs.getString(1);
                codi = rs.getString(2);
                timbrado = rs.getString(3);
                emi = rs.getString(4);
                nom = rs.getString(5);
                prov = rs.getString(6);
                entra = rs.getString(7);
                hist = rs.getString(8);
                pre = rs.getString(9);

            }
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date dateValue = null;
            dateValue = date.parse(emi);
            jd_emision.setDate(dateValue);

            Date dateValue2 = null;
            dateValue2 = date.parse(entra);
            jd_entrada.setDate(dateValue2);

            txt_id_gas.setText(id);
            txtcod.setText(codi);
            txt_timbrado.setText(timbrado);
            txtnom.setText(nom);
            txt_id_prov_actu.setText(prov);
            txt_id_class_actu.setText(hist);
            txt_monto.setText(pre);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Gastos_actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void BuscarProvee(String cod) {

        try {

            String des = "", id = "";
            Connection cn = conectar.getInstance().getConnection();
            String cons = "select * from tienda_proveedores WHERE prov_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                id = rs.getString(1);
                des = rs.getString(2);

            }

            txt_provee.setText(des);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarHistorico(String cod) {

        try {

            String des = "", id = "";
            Connection cn = conectar.getInstance().getConnection();
            String cons = "select * from historicos WHERE cod_his='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                id = rs.getString(1);
                des = rs.getString(2);

            }

            txt_hist.setText(des);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public String ActivatedYourLife(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_monto.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_monto.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_monto.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO

    public String MaskaraEnteros(String ValorGuaranies) {
        //<editor-fold defaultstate="collapsed" desc="IF">        
        ValorGuaranies = ValorGuaranies.replaceAll("\\s", "").replaceAll("\\D", "");
        if (ValorGuaranies.contains(".")) {
            BigDecimal Rounder = new BigDecimal(ValorGuaranies);
            Rounder = Rounder.setScale(0, BigDecimal.ROUND_HALF_UP);
            ValorGuaranies = Rounder.toString();
            if (ValorGuaranies.contains(".")) {
                ValorGuaranies = ValorGuaranies.substring(0, ValorGuaranies.indexOf("."));
            }
        }// FIN IF
        //</editor-fold>        
        DecimalFormat Formato = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String Puro = ValorViejo.replace(",", "");
        NumeroIntacto = Long.parseLong(Puro);
        NroFormatado = Formato.format(NumeroIntacto);
        String ReadyToExhibit = NroFormatado;
        ReadyToExhibit = ReadyToExhibit.replace(".", ",");
        return ReadyToExhibit;
    }// FIN METODO

    public void calcular() {

        String imp = "0", subtotal = "0";

        for (int i = 0; i < tb_detalles.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_detalles.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_monto.setText(subtotal);

        }
    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM gastos_detalles WHERE  id_gastos='" + valor + "'";
        String[] titulos = {"N° Seq.", "Id Egreso", "Descripción", "Precio Unitario", "Cantidad", "Precio Total"};
        String[] Registros = new String[7];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("id_seque");
                Registros[1] = rs.getString("id_gastos");
                Registros[2] = rs.getString("des_deta_gas");
                Registros[3] = rs.getString("pre_unit");
                Registros[4] = rs.getString("cant");
                Registros[5] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_detalles.setModel(model);

            tb_detalles.getColumnModel().getColumn(0).setPreferredWidth(90);
            tb_detalles.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_detalles.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_detalles.getColumnModel().getColumn(3).setPreferredWidth(130);
            tb_detalles.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_detalles.getColumnModel().getColumn(5).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Gastos_actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
