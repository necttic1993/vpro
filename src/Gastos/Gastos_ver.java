/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos;

import Clases.machusculas;
import Conexion_DB.conectar;
import static Gastos.Principapl_gastos.cod_gastos_actu;
import Loggin_Principal.Principal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto
 */
public class Gastos_ver extends javax.swing.JDialog {

    long OL;

    int longitudBytes;
    String ruta = null;
    DefaultTableModel model;
    public static String cod_gastos_deta = "";

    public Gastos_ver(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(807, 260);
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_ver_egresos.setBackground(new java.awt.Color(69, 84, 92));

        }
        txt_provee.setDisabledTextColor(Color.black);
        txt_hist.setDisabledTextColor(Color.black);
        txtnom.setDocument(new machusculas());
        BuscarProductoEditarA(cod_gastos_actu);
        cargar(cod_gastos_actu);
        BuscarProvee(txt_id_prov_actu.getText());
        BuscarHistorico(txt_id_class_actu.getText());

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

        panel_ver_egresos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
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
        txt_id_class_actu = new javax.swing.JTextField();
        txt_id_prov_actu = new javax.swing.JTextField();
        txt_provee = new javax.swing.JTextField();
        txt_hist = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Egresos");
        setResizable(false);

        panel_ver_egresos.setBackground(new java.awt.Color(255, 255, 255));
        panel_ver_egresos.setPreferredSize(new java.awt.Dimension(798, 529));
        panel_ver_egresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Concepto:");
        panel_ver_egresos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 70, 30));

        txtnom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnom.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtnom.setEnabled(false);
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });
        panel_ver_egresos.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 400, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Proveedor:");
        panel_ver_egresos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText(" N° de Nota:");
        panel_ver_egresos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 30));

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcod.setEnabled(false);
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
        panel_ver_egresos.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 180, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Clasificación:");
        panel_ver_egresos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Fecha Emisión:");
        panel_ver_egresos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Fecha Entrada:");
        panel_ver_egresos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 90, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Monto:");
        panel_ver_egresos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 50, 30));

        txt_monto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_monto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_monto.setEnabled(false);
        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_montoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoKeyTyped(evt);
            }
        });
        panel_ver_egresos.add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 180, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Timbrado N°:");
        panel_ver_egresos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, 30));

        txt_timbrado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_timbrado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_timbrado.setEnabled(false);
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
        panel_ver_egresos.add(txt_timbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 140, 30));

        txt_id_gas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_id_gas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_gas.setEnabled(false);
        panel_ver_egresos.add(txt_id_gas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 120, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText(" Egreso N°:");
        panel_ver_egresos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 30));

        jd_entrada.setEnabled(false);
        panel_ver_egresos.add(jd_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 140, 30));

        jd_emision.setEnabled(false);
        panel_ver_egresos.add(jd_emision, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, 30));

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
        panel_ver_egresos.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 130, 40));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/arriba.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_ver_egresos.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 70, 40));

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

        panel_ver_egresos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 760, 210));

        txt_id_class_actu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_id_class_actu.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_class_actu.setEnabled(false);
        panel_ver_egresos.add(txt_id_class_actu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 90, 30));

        txt_id_prov_actu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_id_prov_actu.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_prov_actu.setEnabled(false);
        panel_ver_egresos.add(txt_id_prov_actu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 90, 30));

        txt_provee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_provee.setEnabled(false);
        txt_provee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_proveeKeyTyped(evt);
            }
        });
        panel_ver_egresos.add(txt_provee, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 330, 30));

        txt_hist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_hist.setEnabled(false);
        txt_hist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_histKeyTyped(evt);
            }
        });
        panel_ver_egresos.add(txt_hist, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 330, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_ver_egresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_ver_egresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped

    }//GEN-LAST:event_txtnomKeyTyped

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodKeyTyped

    private void txt_montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_montoKeyTyped

    private void txt_timbradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timbradoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timbradoKeyTyped

    private void txt_timbradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timbradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timbradoActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

    private void txt_montoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyReleased

    }//GEN-LAST:event_txt_montoKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setSize(807, 550);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setSize(807, 260);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb_detallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_detallesMouseClicked


    }//GEN-LAST:event_tb_detallesMouseClicked

    private void txt_proveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_proveeKeyTyped

    }//GEN-LAST:event_txt_proveeKeyTyped

    private void txt_histKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_histKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_histKeyTyped

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
            java.util.logging.Logger.getLogger(Gastos_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gastos_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gastos_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gastos_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gastos_ver dialog = new Gastos_ver(new javax.swing.JDialog(), true);
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
    private javax.swing.JPanel panel_ver_egresos;
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
            Logger.getLogger(Gastos_ver.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Gastos_ver.class.getName()).log(Level.SEVERE, null, ex);
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

}
