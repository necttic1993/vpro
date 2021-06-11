/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proveedores;

import Clientes.*;
import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
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
public class Add_proveedor extends javax.swing.JDialog {

    DefaultTableModel model;

    public Add_proveedor(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        codigos();
        txtcod.setEnabled(false);
        txtnom.setDocument(new machusculas());
        txtdir.setDocument(new machusculas());
        txt_telefono.setDocument(new machusculas());
        txt_razon_social.setDocument(new machusculas());
        txt_contactos.setDocument(new machusculas());

    }

    void limpiar() {

        txt_contactos.setText("");
        txt_razon_social.setText("");

        txtnom.setText("");
        txtdir.setText("");
        txtemail.setText("");
        txtruc.setText("");
        txt_telefono.setText("");
        cb_tipo.setSelectedItem(" ");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtcod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtruc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_razon_social = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_contactos = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_tipo = new org.jdesktop.swingx.JXComboBox();
        cb_status = new org.jdesktop.swingx.JXComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Proveedores");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 112, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Código:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Teléfono:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 56, 30));

        txt_telefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 200, -1));

        txtnom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });
        jPanel3.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 320, -1));

        txtruc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrucKeyTyped(evt);
            }
        });
        jPanel3.add(txtruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 200, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("RUC/C.I/RG:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, 30));

        txtemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 360, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Dirección:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 30));

        txtdir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtdir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 320, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Email:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 55, 30));

        txt_razon_social.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_razon_social.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_razon_socialKeyTyped(evt);
            }
        });
        jPanel3.add(txt_razon_social, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 420, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Status:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 50, 30));

        txt_contactos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contactos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactosKeyTyped(evt);
            }
        });
        jPanel3.add(txt_contactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 410, -1));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnguardar.setMnemonic('g');
        btnguardar.setText("Agregar");
        btnguardar.setBorder(null);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 120, 50));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Contacto:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Proveedor:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 67, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Razón Social:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Clasificación:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 80, 30));

        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COMPRAS/MERCADERÍAS", "INSUMO/SERVICIOS" }));
        cb_tipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 210, 30));

        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cb_status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 120, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 270));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped

    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomKeyTyped

    private void txtrucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrucKeyTyped

    private void txt_razon_socialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_razon_socialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_razon_socialKeyTyped

    private void txt_contactosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactosKeyTyped

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:

        if (txtdir.getText().length() != 0) {
            // byte[] imagen = cam.getBytes();
            String sql = "";
            String cod = txtcod.getText();
            String nom = txtnom.getText();
            String ruc = txtruc.getText();
            String razon = txt_razon_social.getText();
            String contact = txt_telefono.getText();
            String email = txtemail.getText();
            String direccion = txtdir.getText();
            String tipo_pro = cb_tipo.getSelectedItem().toString();
            String contacto = txt_contactos.getText();
            String status = cb_status.getSelectedItem().toString();

            sql = "INSERT INTO tienda_proveedores (prov_cod,prov_nom,prov_ruc,prov_razon,prov_tel,prov_email,prov_dir,prov_clas,prov_cont,prov_status) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, cod);
                pst.setString(2, nom);
                pst.setString(3, ruc);
                pst.setString(4, razon);
                pst.setString(5, contact);
                pst.setString(6, email);
                pst.setString(7, direccion);
                pst.setString(8, tipo_pro);
                pst.setString(9, contacto);
                pst.setString(10, status);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                    codigos();
                    limpiar();

                }

            } catch (SQLException ex) {
                Logger.getLogger(Add_proveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verife los campos estan vacios o imagen es null");
        }

        Plataforma_proveedor.btn_cargar_datos.doClick();
    }//GEN-LAST:event_btnguardarActionPerformed

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
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Plataforma_clientes dialog = new Plataforma_clientes(new javax.swing.JDialog(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private org.jdesktop.swingx.JXComboBox cb_status;
    private org.jdesktop.swingx.JXComboBox cb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_contactos;
    private javax.swing.JTextField txt_razon_social;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtruc;
    // End of variables declaration//GEN-END:variables

    void codigos() {

        String c = "";
        String SQL = "select max(prov_cod) from tienda_proveedores";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txtcod.setText("0000001");
            } else {
                int j = Integer.parseInt(c);
                if (Principal.txt_dir_backup.getText().equals("1")) {
                    GenerarNumero gen = new GenerarNumero();
                    gen.generar(j);
                    txtcod.setText(gen.serie());

                } else {
                    Generar_Num_Pro gen = new Generar_Num_Pro();
                    gen.generar(j);
                    txtcod.setText(gen.serie());
                }
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Add_proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
