/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Clases.machusculas;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static user.user.id_user;

/**
 *
 * @author Roberto
 */
public class Update_user extends javax.swing.JDialog {

    DefaultTableModel model;

    Statement sent;
    public static String id_user_cuentas = "";

    public Update_user(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        txtcod.setText(id_user);

        txt_usu.setDocument(new machusculas());
        txt_por_venta.setDocument(new machusculas());
        txt_pre_a.setDocument(new machusculas());
        txt_vende_sin.setDocument(new machusculas());
        txt_pre_b.setDocument(new machusculas());
        txt_pre_c.setDocument(new machusculas());
        txt_cod_cuentas.setDocument(new machusculas());
        cargargrupo();
        cargarDatos(id_user);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_usu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        txtcod = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        cb_tipo = new org.jdesktop.swingx.JXComboBox();
        cb_cat = new org.jdesktop.swingx.JXComboBox();
        jLabel8 = new javax.swing.JLabel();
        txt_por_venta = new javax.swing.JTextField();
        btn_grupos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_pre_c = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_pre_a = new javax.swing.JTextField();
        txt_pre_b = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_vende_sin = new javax.swing.JTextField();
        cb_caja = new jcomboper.SComboBox();
        lbl_pass_word = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_grupos1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cb_almacen = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txt_cod_cuentas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_ambiente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Usuarios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_usu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuActionPerformed(evt);
            }
        });
        jPanel1.add(txt_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 420, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Grupo :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Cuenta:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 60, 30));

        btnactualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnactualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/modificar.png"))); // NOI18N
        btnactualizar.setMnemonic('a');
        btnactualizar.setText("Actualizar");
        btnactualizar.setBorderPainted(false);
        btnactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnactualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 150, 40));

        txtcod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtcod.setDisabledTextColor(new java.awt.Color(153, 0, 0));
        txtcod.setEnabled(false);
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 30));

        txt_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 220, 30));

        cb_tipo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 220, 30));

        cb_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cb_cat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 110, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Sin Stock:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, 30));

        txt_por_venta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_por_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_por_ventaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_por_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 40, 30));

        btn_grupos.setBackground(new java.awt.Color(255, 255, 255));
        btn_grupos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_grupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/bank.png"))); // NOI18N
        btn_grupos.setText("Cuentas");
        btn_grupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_grupos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_grupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gruposActionPerformed(evt);
            }
        });
        jPanel1.add(btn_grupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 150, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Alamacen:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 80, 30));

        txt_pre_c.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 40, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Precio bloq:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Precio B:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, 30));

        txt_pre_a.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 40, 30));

        txt_pre_b.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 40, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Amb.:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 40, 30));

        txt_vende_sin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_vende_sin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 40, 30));

        cb_caja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        cb_caja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(cb_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 60, -1));

        lbl_pass_word.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_pass_word.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(lbl_pass_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 50, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Caja Rápida:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("(Lucro %):");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, 30));

        btn_grupos1.setBackground(new java.awt.Color(255, 255, 255));
        btn_grupos1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_grupos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shopper.png"))); // NOI18N
        btn_grupos1.setText("Almacenes");
        btn_grupos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_grupos1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_grupos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grupos1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_grupos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 150, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Usuario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Clasificación:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, 30));

        cb_almacen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_almacen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "0000001", "0000002", "0000003", "0000004", "0000005", "0000006", "0000007", "0000008", "0000009", "0000010", "0000011", "0000012", "0000013", "0000014", "0000015", "0000016", "0000017", "0000018", "0000019", "0000020", "0000021", "0000022", "0000023", "0000024", "0000025", "0000026", "0000027", "0000028", "0000029", "0000030" }));
        jPanel1.add(cb_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 110, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Id Usuario:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 30));

        txt_cod_cuentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(txt_cod_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 110, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Min:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 30, 30));

        txt_ambiente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(txt_ambiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 160, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuActionPerformed
        // TODO add your handling code here:
        txt_usu.transferFocus();
    }//GEN-LAST:event_txt_usuActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        if (txt_pass.getText().length() != 0) {
            String sql = "UPDATE usuarios SET usu ='" + txt_usu.getText()
                    + "',password ='" + txt_pass.getText()
                    + "',tipo_usu ='" + cb_tipo.getSelectedItem()
                    + "',class ='" + cb_cat.getSelectedItem()
                    + "',alma_surc ='" + cb_almacen.getSelectedItem()
                    + "',usu_cuenta ='" + txt_cod_cuentas.getText()
                    + "',por_ventas ='" + txt_por_venta.getText()
                    + "',pre_a ='" + txt_pre_a.getText()
                    + "',pre_b ='" + txt_pre_b.getText()
                    + "',pre_c ='" + txt_pre_c.getText()
                    + "',pre_post ='" + txt_vende_sin.getText()
                    + "',caja_rap ='" + cb_caja.getSelectedItem()
                    + "',user_local ='" + txt_ambiente.getText()
                    + "' WHERE usu_cod = '" + txtcod.getText() + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado");
                limpiar();
                this.dispose();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Confirme Contraseña ");
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txt_por_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_por_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_por_ventaActionPerformed

    private void btn_gruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gruposActionPerformed

        id_user_cuentas = txtcod.getText();
        Add_cuentas_user ac;
        ac = new Add_cuentas_user(new javax.swing.JDialog(), true);
        ac.setVisible(true);
    }//GEN-LAST:event_btn_gruposActionPerformed

    private void btn_grupos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grupos1ActionPerformed

        id_user_cuentas = txtcod.getText();
        Add_alma_user aa;
        aa = new Add_alma_user(new javax.swing.JDialog(), true);
        aa.setVisible(true);
    }//GEN-LAST:event_btn_grupos1ActionPerformed

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
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Update_user dialog = new Update_user(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_grupos;
    private javax.swing.JButton btn_grupos1;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JComboBox cb_almacen;
    private jcomboper.SComboBox cb_caja;
    private org.jdesktop.swingx.JXComboBox cb_cat;
    private org.jdesktop.swingx.JXComboBox cb_tipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_pass_word;
    private javax.swing.JTextField txt_ambiente;
    private javax.swing.JTextField txt_cod_cuentas;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_por_venta;
    private javax.swing.JTextField txt_pre_a;
    private javax.swing.JTextField txt_pre_b;
    private javax.swing.JTextField txt_pre_c;
    private javax.swing.JTextField txt_usu;
    private javax.swing.JTextField txt_vende_sin;
    private javax.swing.JTextField txtcod;
    // End of variables declaration//GEN-END:variables

    void cargargrupo() {
        String mostrar = "SELECT * FROM user_permisos where id_perm >1 ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_tipo.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Update_user.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarDatos(String cod) {

        try {
            String nom = "", clas = "", grupo = "", caja_rap = "", precio_bloq = "", sin_stock = "", lucro = "", precio_b = "", minimo = "", cuentas = "", almacen = "", ambiente = "";
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from usuarios WHERE usu_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                nom = rs.getString(2);
                clas = rs.getString(5);
                grupo = rs.getString(4);
                almacen = rs.getString(6);
                cuentas = rs.getString(7);
                caja_rap = rs.getString(13);
                precio_bloq = rs.getString(9);
                sin_stock = rs.getString(12);
                lucro = rs.getString(8);
                precio_b = rs.getString(10);
                minimo = rs.getString(11);
                ambiente = rs.getString(14);

            }

            txt_usu.setText(nom);
            cb_cat.setSelectedItem(clas);
            cb_tipo.setSelectedItem(grupo);
            cb_caja.setSelectedItem(caja_rap);
            txt_pre_a.setText(precio_bloq);
            txt_vende_sin.setText(sin_stock);
            txt_por_venta.setText(lucro);
            txt_pre_b.setText(precio_b);
            txt_pre_c.setText(minimo);
            cb_almacen.setSelectedItem(almacen);
            txt_cod_cuentas.setText(cuentas);
            txt_ambiente.setText(ambiente);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void limpiar() {
        txt_por_venta.setText("");
        txt_usu.setText("");
        txt_pass.setText("");
        txt_pre_a.setText("");
        txt_pre_b.setText("");
        txt_pre_c.setText("");
        txt_vende_sin.setText("");
    }

}
