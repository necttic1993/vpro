/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Clases.machusculas;
import static Clientes.Plataforma_clientes.cod_cliente;

import Conexion_DB.conectar;
import java.awt.HeadlessException;
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
public class Actualiza_clientes extends javax.swing.JDialog {

    DefaultTableModel model;

    public Actualiza_clientes(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        txtcod.setDocument(new machusculas());
        txtnom.setDocument(new machusculas());
        txt_razon.setDocument(new machusculas());
        txtdir.setDocument(new machusculas());
        txtemail.setDocument(new machusculas());
        txtruc.setDocument(new machusculas());
        txttel.setDocument(new machusculas());
        txt_dias_plazos.setDocument(new machusculas());
        txtcod.setEnabled(false);
        cb_status.setSelectedItem("");
        cargarDatos(cod_cliente);

    }

    void limpiar() {
        txtcod.setText("");
        txtnom.setText("");
        txt_razon.setText("");
        txtdir.setText("");
        txtemail.setText("");
        txtruc.setText("");
        txttel.setText("");
        txt_dias_plazos.setText("");
        txt_cli_registro.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtcod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtruc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_razon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_dias_plazos = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        cb_tipo = new org.jdesktop.swingx.JXComboBox();
        cb_status = new org.jdesktop.swingx.JXComboBox();
        jLabel14 = new javax.swing.JLabel();
        txt_cli_registro = new javax.swing.JTextField();
        cb_cli_pais = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cb_contro_surc = new javax.swing.JComboBox<String>();
        jLabel16 = new javax.swing.JLabel();
        lbl_tipo_cli = new javax.swing.JLabel();
        lbl_sucursal = new javax.swing.JLabel();
        lbl_nac_cli = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Clientes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel3.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 112, 28));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Código:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Contacto:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 30));

        txttel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txttel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelKeyTyped(evt);
            }
        });
        jPanel3.add(txttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 200, 28));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        txtnom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnomKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });
        jPanel3.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 400, 28));

        txtruc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrucKeyTyped(evt);
            }
        });
        jPanel3.add(txtruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 180, 28));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("RUC/C.I/RG:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, 30));

        txtemail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel3.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 440, 28));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Direccion:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, 30));

        txtdir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel3.add(txtdir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 340, 28));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Email:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 50, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Razón Social:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        txt_razon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_razon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_razonKeyTyped(evt);
            }
        });
        jPanel3.add(txt_razon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 430, 28));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Status:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 50, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Nro Registro:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        txt_dias_plazos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_dias_plazos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dias_plazosKeyTyped(evt);
            }
        });
        jPanel3.add(txt_dias_plazos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 50, 28));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/modificar.png"))); // NOI18N
        btnguardar.setMnemonic('g');
        btnguardar.setText("Actualizar");
        btnguardar.setBorder(null);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 140, 50));

        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MINORISTAS", "MAYORISTAS", "SUBDISTRIBUIDOR", "DISTRIBUIDOR" }));
        cb_tipo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 120, 30));

        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cb_status.setToolTipText("");
        cb_status.setDoubleBuffered(true);
        cb_status.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 100, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Crédito/Días:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 100, 30));

        txt_cli_registro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel3.add(txt_cli_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, 28));

        cb_cli_pais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_cli_pais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PY", "EX" }));
        jPanel3.add(cb_cli_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 60, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Nac.:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 40, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Sucursal:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 60, 30));

        cb_contro_surc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_contro_surc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        jPanel3.add(cb_contro_surc, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 70, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Tipos de Clientes:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 130, -1, 30));

        lbl_tipo_cli.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_tipo_cli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbl_tipo_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 110, 30));

        lbl_sucursal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_sucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbl_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 60, 30));

        lbl_nac_cli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_nac_cli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbl_nac_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 40, 30));

        lbl_status.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbl_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 70, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("*");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 20, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("*");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 139, 20, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("*");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 20, 20));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("*");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 20, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 270));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txttelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyTyped

    }//GEN-LAST:event_txttelKeyTyped

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomKeyTyped

    private void txtrucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrucKeyTyped

    private void txt_razonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_razonKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_razonKeyTyped

    private void txt_dias_plazosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dias_plazosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dias_plazosKeyTyped

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txtdir.getText().length() != 0 && txtnom.getText().length() != 0 && txttel.getText().length() != 0) {

            String sql = "UPDATE tienda_clientes SET cli_nombre = '" + txtnom.getText()
                    + "',cli_ruc ='" + txtruc.getText()
                    + "',cli_razon ='" + txt_razon.getText()
                    + "',cli_contacto ='" + txttel.getText()
                    + "',cli_email = '" + txtemail.getText()
                    + "',cli_dir = '" + txtdir.getText()
                    + "',cli_tipo ='" + cb_tipo.getSelectedItem().toString()
                    + "',cli_dias_cre ='" + txt_dias_plazos.getText()
                    + "',cli_status ='" + cb_status.getSelectedItem().toString()
                    + "',nro_registro ='" + txt_cli_registro.getText()
                    + "',cli_pais ='" + cb_cli_pais.getSelectedItem().toString()
                    + "',cli_surc ='" + cb_contro_surc.getSelectedItem().toString()
                    + "' WHERE cli_cod = '" + txtcod.getText() + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                //  cn.commit();
                JOptionPane.showMessageDialog(null, "Actualizado");
                limpiar();
                this.dispose();
            } catch (SQLException | HeadlessException e) {
                Logger.getLogger(Add_clientes.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verife los camposobligatorios esten completadas");
        }
        Plataforma_clientes.btn_cargar_datos.doClick();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyReleased
        String Razon = txtnom.getText();
        txt_razon.setText(Razon);
    }//GEN-LAST:event_txtnomKeyReleased

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Plataforma_clientes dialog = new Plataforma_clientes(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox cb_cli_pais;
    private javax.swing.JComboBox<String> cb_contro_surc;
    private org.jdesktop.swingx.JXComboBox cb_status;
    private org.jdesktop.swingx.JXComboBox cb_tipo;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_nac_cli;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_sucursal;
    private javax.swing.JLabel lbl_tipo_cli;
    private javax.swing.JTextField txt_cli_registro;
    private javax.swing.JTextField txt_dias_plazos;
    private javax.swing.JTextField txt_razon;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtruc;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables

    void cargarDatos(String cod) {

        try {

            String codi = "", nom = "", ruc = "", razon = "", contacto = "", email = "", dir = "", tipo = "";
            String registro = "", dias_cre = "", cli_status = "", cli_pais = "", surc = "";
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_clientes WHERE cli_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                codi = rs.getString(1);
                nom = rs.getString(2);
                ruc = rs.getString(3);
                razon = rs.getString(4);
                contacto = rs.getString(5);
                email = rs.getString(6);
                dir = rs.getString(7);
                tipo = rs.getString(8);
                // limite_cre = rs.getString(9);
                dias_cre = rs.getString(10);
                cli_status = rs.getString(11);
                registro = rs.getString(12);
                cli_pais = rs.getString(14);
                surc = rs.getString(15);

            }

            txtcod.setText(codi);
            txtnom.setText(nom);
            txtruc.setText(ruc);
            txt_razon.setText(razon);
            txttel.setText(contacto);
            txtemail.setText(email);
            txtdir.setText(dir);
            lbl_tipo_cli.setText(tipo);
            txt_dias_plazos.setText(dias_cre);
            lbl_status.setText(cli_status);
            txt_cli_registro.setText(registro);
            lbl_nac_cli.setText(cli_pais);
            lbl_sucursal.setText(surc);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

}
