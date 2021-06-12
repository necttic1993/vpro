/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Clases.machusculas;
import Conexion_DB.conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto
 */
public class Add_user extends javax.swing.JDialog {

    DefaultTableModel model;

    Statement sent;

    public Add_user(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cargargrupo();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_usu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        cb_tipo = new org.jdesktop.swingx.JXComboBox();
        cb_cat = new org.jdesktop.swingx.JXComboBox();
        jLabel8 = new javax.swing.JLabel();
        txt_por_venta = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Usuarios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_usu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuActionPerformed(evt);
            }
        });
        jPanel1.add(txt_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 420, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Grupo :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 30));

        btn_agregar.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_agregar.setMnemonic('a');
        btn_agregar.setText("Agregar");
        btn_agregar.setToolTipText("Agregar");
        btn_agregar.setBorderPainted(false);
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 130, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("(Lucro %):");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 30));

        txt_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 220, 30));

        cb_tipo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 220, 30));

        cb_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cb_cat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 100, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Sin Stock:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, 30));

        txt_por_venta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_por_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_por_ventaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_por_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 40, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Clasificación:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, 30));

        txt_pre_c.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 40, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Panel de precio bloq:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Precio B:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, 30));

        txt_pre_a.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 40, 30));

        txt_pre_b.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 40, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Minimo:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, 30));

        txt_vende_sin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_vende_sin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 40, 30));

        cb_caja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        cb_caja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(cb_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 80, -1));

        lbl_pass_word.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_pass_word.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(lbl_pass_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 70, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Caja Rápida:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
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

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        if (txt_pass.getText().length() != 0) {
            String usu, pass, tipo, clas, alma, caja, por, a, b, c, ss, venta_rap;
            String sql = "";

            usu = txt_usu.getText();
            pass = txt_pass.getText();
            tipo = cb_tipo.getSelectedItem().toString();
            clas = cb_cat.getSelectedItem().toString();
            alma = ("0");
            caja = ("0");
            por = txt_por_venta.getText();
            a = txt_pre_a.getText();
            b = txt_pre_b.getText();
            c = txt_pre_c.getText();
            ss = txt_vende_sin.getText();
            venta_rap = cb_caja.getSelectedItem().toString();

            sql = "INSERT INTO usuarios (usu,password,tipo_usu,class,alma_surc,usu_cuenta,por_ventas,pre_a,pre_b,pre_c,pre_post,caja_rap) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1, usu);
                pst.setString(2, pass);
                pst.setString(3, tipo);
                pst.setString(4, clas);
                pst.setString(5, alma);
                pst.setString(6, caja);
                pst.setString(7, por);
                pst.setString(8, a);
                pst.setString(9, b);
                pst.setString(10, c);
                pst.setString(11, ss);
                pst.setString(12, venta_rap);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario Guardado con Exito ");
                    limpiar();
                }

            } catch (SQLException ex) {

                if (ex.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "¡El usuario ya existe!", "Verificar Codigo",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Logger.getLogger(Add_user.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos ");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_por_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_por_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_por_ventaActionPerformed

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
            java.util.logging.Logger.getLogger(Add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Add_user dialog = new Add_user(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_agregar;
    private jcomboper.SComboBox cb_caja;
    private org.jdesktop.swingx.JXComboBox cb_cat;
    private org.jdesktop.swingx.JXComboBox cb_tipo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_pass_word;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_por_venta;
    private javax.swing.JTextField txt_pre_a;
    private javax.swing.JTextField txt_pre_b;
    private javax.swing.JTextField txt_pre_c;
    private javax.swing.JTextField txt_usu;
    private javax.swing.JTextField txt_vende_sin;
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
            Logger.getLogger(Add_user.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
