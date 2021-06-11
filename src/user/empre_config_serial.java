/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Conexion_DB.*;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto
 */
public class empre_config_serial extends javax.swing.JDialog {

    /**
     * Creates new form empre
     */
    public empre_config_serial(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //  AWTUtilities.setWindowShape(this, forma);
        txtcod.setEnabled(false);
        txtcod.setVisible(false);
        cargar();
        guardar();
    }

    void cargar() {
        String mostrar = "SELECT * FROM serial";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txtcod.setText(rs.getString(1));
                txt_fecha.setText(rs.getString(2));
                txtdes.setSelectedItem(rs.getString(3));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(empre_config_serial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void guardar() {
        if (txt_fecha.getText().length() != 0) {

            btnguardar.setEnabled(false);
        } else {
            btnguardar.setEnabled(true);
            // txtcod.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        txt_fecha = new javax.swing.JFormattedTextField();
        txtdes = new jcomboper.SComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empresas");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Válido Hasta:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Situación:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });
        jPanel3.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, -1));

        btnguardar.setBackground(new java.awt.Color(0, 102, 153));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setMnemonic('g');
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 130, 40));

        btnactualizar.setBackground(new java.awt.Color(0, 102, 153));
        btnactualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizar.setMnemonic('a');
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 130, 40));

        try {
            txt_fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 30));

        txtdes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BLOQUEADO", "DESBLOQUEADO" }));
        txtdes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel3.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txt_fecha.getText().length() != 0) {
            String nom, des;
            String sql = "";
            nom = txt_fecha.getText();
            des = (String) txtdes.getSelectedItem();

            sql = "INSERT INTO serial (serial_fecha,serial_des) VALUES (?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1, nom);
                pst.setString(2, des);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");

                }

            } catch (SQLException ex) {
                Logger.getLogger(empre_config_serial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verife los campos estan vacios");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement("UPDATE serial SET serial_fecha='"
                    + txt_fecha.getText() + "',serial_des='"
                    + txtdes.getSelectedItem() + "' WHERE id_serial='" + txtcod.getText() + "'");
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (SQLException | HeadlessException e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodKeyTyped

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
            java.util.logging.Logger.getLogger(empre_config_serial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(empre_config_serial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(empre_config_serial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(empre_config_serial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                empre_config_serial dialog = new empre_config_serial(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField txt_fecha;
    private javax.swing.JTextField txtcod;
    private jcomboper.SComboBox txtdes;
    // End of variables declaration//GEN-END:variables

    void borrar() {

        String cod = "";
        cod = txtcod.getText();

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement("DELETE FROM serial WHERE id_serial='" + cod + "'");
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            JOptionPane.showMessageDialog(this, "Borrado");
        } catch (SQLException ex) {
            Logger.getLogger(empre_config_serial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Problema al borrar");
        }

    }
}
