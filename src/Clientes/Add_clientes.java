/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto
 */
public class Add_clientes extends javax.swing.JDialog {

    DefaultTableModel model;

    public Add_clientes(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        codigos();
        //txtcod.setEnabled(false);
        lbl_ruc.setVisible(false);
        txtnom.setDocument(new machusculas());
        txtdir.setDocument(new machusculas());
        txt_contacto.setDocument(new machusculas());
        txt_razon_social.setDocument(new machusculas());

    }

    void limpiar() {
        txt_dias_cre.setText("");
        txt_razon_social.setText("");

        txtnom.setText("");
        txtdir.setText("");
        txtemail.setText("");
        txtruc.setText("");
        txt_contacto.setText("");
        // cb_tipo.setSelectedItem(" ");
        txt_cli_registro.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtcod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_contacto = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtruc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_razon_social = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txt_dias_cre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_tipo = new org.jdesktop.swingx.JXComboBox();
        cb_status = new org.jdesktop.swingx.JXComboBox();
        lbl_ruc = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_cli_registro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cb_cli_pais = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cb_contro_surc = new javax.swing.JComboBox<String>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_id_ciudad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Clientes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcod.setEnabled(false);
        jPanel3.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 112, 28));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Código:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Contacto:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 30));

        txt_contacto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 210, 28));

        txtnom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnomKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });
        jPanel3.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 320, 28));

        txtruc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrucKeyTyped(evt);
            }
        });
        jPanel3.add(txtruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 180, 28));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Ciudad:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 70, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Tipos de Clientes:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 120, 30));

        txtemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 350, 28));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("*");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 20, 20));

        txtdir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtdir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 340, 28));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Email:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 55, 30));

        txt_razon_social.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_razon_social.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_razon_socialKeyTyped(evt);
            }
        });
        jPanel3.add(txt_razon_social, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 430, 28));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnguardar.setMnemonic('g');
        btnguardar.setText("Agregar");
        btnguardar.setBorder(null);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 120, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Crédito/Días:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 100, 30));

        txt_dias_cre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_dias_cre.setText("0");
        txt_dias_cre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dias_creKeyTyped(evt);
            }
        });
        jPanel3.add(txt_dias_cre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 50, 28));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Razón Social:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MINORISTAS", "MAYORISTAS", "SUBDISTRIBUIDOR", "DISTRIBUIDOR" }));
        cb_tipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 150, 30));

        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cb_status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 120, 30));
        jPanel3.add(lbl_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 100, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Nro Registro:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        txt_cli_registro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cli_registro.setText("0");
        jPanel3.add(txt_cli_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 150, 28));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Status:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 50, 30));

        cb_cli_pais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_cli_pais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PY", "EX" }));
        jPanel3.add(cb_cli_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 70, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Nac.:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 50, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("RUC/C.I/RG:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, 30));

        cb_contro_surc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_contro_surc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        jPanel3.add(cb_contro_surc, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 60, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Direccion:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("*");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 20, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("*");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 20, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("*");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 20, 20));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Sucursal:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 70, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("*");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 139, 20, 20));

        txt_id_ciudad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_id_ciudad.setText("0");
        txt_id_ciudad.setDisabledTextColor(new java.awt.Color(153, 0, 0));
        txt_id_ciudad.setEnabled(false);
        jPanel3.add(txt_id_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 90, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/busqueda.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 270));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactoKeyTyped

    }//GEN-LAST:event_txt_contactoKeyTyped

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomKeyTyped

    private void txtrucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrucKeyTyped

    private void txt_razon_socialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_razon_socialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_razon_socialKeyTyped

    private void txt_dias_creKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dias_creKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dias_creKeyTyped

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtruc.getText() == null ? lbl_ruc.getText() == null : txtruc.getText().equals(lbl_ruc.getText())) {
            JOptionPane.showMessageDialog(null, "Nro de RUC/CI  ya existe");
        } else {
            if (txtdir.getText().length() != 0 && txtnom.getText().length() != 0 && txt_contacto.getText().length() != 0 && txt_id_ciudad.getText().length() != 0) {
                // byte[] imagen = cam.getBytes();
                codigos();
                String sql = "";
                String cod = txtcod.getText();
                String nom = txtnom.getText();
                String ruc = txtruc.getText();
                String razon = txt_razon_social.getText();
                String contact = txt_contacto.getText();
                String email = txtemail.getText();
                String direccion = txtdir.getText();
                String tipo_cli = cb_tipo.getSelectedItem().toString();
                String lim_cre = ("0");
                String dias_cre = txt_dias_cre.getText();
                String status = cb_status.getSelectedItem().toString();
                String registro = txt_cli_registro.getText();
                String pais = cb_cli_pais.getSelectedItem().toString();
                String surc = cb_contro_surc.getSelectedItem().toString();
                String ciudad = txt_id_ciudad.getText();

                sql = "INSERT INTO tienda_clientes (cli_cod,cli_nombre,cli_ruc,cli_razon,cli_contacto,cli_email,cli_dir,cli_tipo,cli_lim_cre,cli_dias_cre,cli_status,nro_registro,cli_pais,cli_surc,cli_ciudad) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                    pst.setString(8, tipo_cli);
                    pst.setString(9, lim_cre);
                    pst.setString(10, dias_cre);
                    pst.setString(11, status);
                    pst.setString(12, registro);
                    pst.setString(13, pais);
                    pst.setString(14, surc);
                    pst.setString(15, ciudad);
                    int n = pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    if (n > 0) {

                        JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                        codigos();
                        limpiar();
                        this.dispose();

                    }

                } catch (SQLException ex) {

                    Logger.getLogger(Add_clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verife los camposobligatorios esten completadas");
            }
            Plataforma_clientes.btn_cargar_datos.doClick();
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyReleased
        String Razon = txtnom.getText();
        txt_razon_social.setText(Razon);
    }//GEN-LAST:event_txtnomKeyReleased

    private void txtrucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyReleased
        conRuc(txtruc.getText());
    }//GEN-LAST:event_txtrucKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ciudad_clientes ac;
        ac = new ciudad_clientes(new javax.swing.JDialog(), true);
        ac.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox cb_cli_pais;
    private javax.swing.JComboBox<String> cb_contro_surc;
    private org.jdesktop.swingx.JXComboBox cb_status;
    private org.jdesktop.swingx.JXComboBox cb_tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_ruc;
    private javax.swing.JTextField txt_cli_registro;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JTextField txt_dias_cre;
    public static javax.swing.JTextField txt_id_ciudad;
    private javax.swing.JTextField txt_razon_social;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtruc;
    // End of variables declaration//GEN-END:variables

    void codigos() {

        String c = "";
        String SQL = "select max(cli_cod) from tienda_clientes";

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
            Logger.getLogger(Add_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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

    void conRuc(String valor) {

        String mostrar = "SELECT * FROM tienda_clientes WHERE cli_ruc = '" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_ruc.setText(rs.getString(3));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Add_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
