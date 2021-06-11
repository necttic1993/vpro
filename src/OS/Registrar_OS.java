/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS;

import Clases.GenerarNumero;
import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_mone_def;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author Roberto
 */
public class Registrar_OS extends javax.swing.JDialog {

    long OL;

    int longitudBytes;
    String ruta = null;

    public Registrar_OS(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_serie.requestFocus();
        txt_cliente.setDisabledTextColor(Color.black);
        txt_pro.setDisabledTextColor(Color.black);
        txt_id_pro.setDisabledTextColor(Color.black);
        txt_id_cli.setDisabledTextColor(Color.black);
        txt_defecto.setDocument(new machusculas());
        txt_status.setDocument(new machusculas());
        txt_piezas.setDocument(new machusculas());
        txt_decri.setDocument(new machusculas());
        txt_id_cli.setDocument(new machusculas());
        codigos();
    }

    void limpiar() {
        txt_serie.setText("");
        txt_defecto.setText("");
        txt_id_cli.setText("");
        txt_cliente.setText("");
        txt_pro.setText("");
        txt_id_pro.setText("");
        txt_status.setText("");
        txt_decri.setText("");
        txt_defecto.setText("");
        txt_piezas.setText("");
        txt_pre.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txt_id_cli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_serie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_pro = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        txt_id_pro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_defecto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_id_os = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_status = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_piezas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_decri = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_pre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asistencia");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_cli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_cli.setEnabled(false);
        txt_id_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_id_cliKeyTyped(evt);
            }
        });
        jPanel3.add(txt_id_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 100, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Cliente:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 30));

        txt_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_cliente.setEnabled(false);
        txt_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_clienteKeyTyped(evt);
            }
        });
        jPanel3.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 400, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("O.S  N°:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, 30));

        txt_serie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serieActionPerformed(evt);
            }
        });
        txt_serie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_serieKeyTyped(evt);
            }
        });
        jPanel3.add(txt_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 280, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Producto:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, 30));

        txt_pro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_pro.setEnabled(false);
        txt_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_proKeyTyped(evt);
            }
        });
        jPanel3.add(txt_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 400, 30));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnguardar.setMnemonic('g');
        btnguardar.setText("Grabar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 130, 40));

        txt_id_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_pro.setEnabled(false);
        txt_id_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_id_proKeyTyped(evt);
            }
        });
        jPanel3.add(txt_id_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 100, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 50, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 50, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Defecto:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));

        txt_defecto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_defecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_defectoActionPerformed(evt);
            }
        });
        txt_defecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_defectoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_defecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 550, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Serie N°:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 30));

        txt_id_os.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_id_os.setEnabled(false);
        jPanel3.add(txt_id_os, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 160, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Estado:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, 30));

        txt_status.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_statusActionPerformed(evt);
            }
        });
        txt_status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_statusKeyTyped(evt);
            }
        });
        jPanel3.add(txt_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 550, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Piezas:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, 30));

        txt_piezas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_piezas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_piezasActionPerformed(evt);
            }
        });
        txt_piezas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_piezasKeyTyped(evt);
            }
        });
        jPanel3.add(txt_piezas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 550, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Valor O.S:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 80, 30));

        txt_decri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_decri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_decriActionPerformed(evt);
            }
        });
        txt_decri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_decriKeyTyped(evt);
            }
        });
        jPanel3.add(txt_decri, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 550, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Descripción:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 80, 30));

        txt_pre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pre.setText("0");
        txt_pre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_preKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_preKeyReleased(evt);
            }
        });
        jPanel3.add(txt_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txt_id_pro.getText().length() != 0) {

            String sql = "";
            String id = txt_id_os.getText();
            String serie = txt_serie.getText();
            String id_cli = txt_id_cli.getText();
            String cli = txt_cliente.getText();
            String id_pro = txt_id_pro.getText();
            String pro = txt_pro.getText();
            String defect = txt_defecto.getText();
            String esta = txt_status.getText();
            String pieza = txt_piezas.getText();
            String decri = txt_decri.getText();
            String fecha_emi = Principal.lbl_fecha_hoy.getText();
            String valor = txt_pre.getText();

            sql = "INSERT INTO os (os_nro,os_serie,fecha_entra,os_id_cli,os_cli,os_id_pro,os_pro,os_defec,os_esta,os_pieza,os_des,os_valor_refe) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, serie);
                pst.setString(3, fecha_emi);
                pst.setString(4, id_cli);
                pst.setString(5, cli);
                pst.setString(6, id_pro);
                pst.setString(7, pro);
                pst.setString(8, defect);
                pst.setString(9, esta);
                pst.setString(10, pieza);
                pst.setString(11, decri);
                pst.setString(12, valor);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                    if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                            "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        String os_nro = txt_id_os.getText();
                        Reportes reporte = new Reportes();
                        try {
                            reporte.os(os_nro);

                        } catch (SQLException | JRException ex) {
                            Logger.getLogger(Principapl_OS.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    limpiar();
                    codigos();
                }

                txt_serie.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(Registrar_OS.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verife los campos estan vacios");
        }
        Principapl_OS.btn_cargar_datos.doClick();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txt_id_cliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_cliKeyTyped

    }//GEN-LAST:event_txt_id_cliKeyTyped

    private void txt_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteKeyTyped

    }//GEN-LAST:event_txt_clienteKeyTyped

    private void txt_serieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serieKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serieKeyTyped

    private void txt_proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_proKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_proKeyTyped

    private void txt_id_proKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_proKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_proKeyTyped

    private void txt_defectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_defectoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_defectoKeyTyped

    private void txt_defectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_defectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_defectoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Clientes_os clipre;
        clipre = new Clientes_os(new javax.swing.JDialog(), true);
        clipre.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Productos_os gast;
        gast = new Productos_os(new javax.swing.JDialog(), true);
        gast.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serieActionPerformed

    private void txt_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_statusActionPerformed

    private void txt_statusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_statusKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_statusKeyTyped

    private void txt_piezasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_piezasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_piezasActionPerformed

    private void txt_piezasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_piezasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_piezasKeyTyped

    private void txt_decriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_decriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_decriActionPerformed

    private void txt_decriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_decriKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_decriKeyTyped

    private void txt_preKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_txt_preKeyPressed

    private void txt_preKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preKeyReleased
        ActivatedYourLife(txt_pre, evt);

    }//GEN-LAST:event_txt_preKeyReleased

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
            java.util.logging.Logger.getLogger(Registrar_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Registrar_OS dialog = new Registrar_OS(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_decri;
    private javax.swing.JTextField txt_defecto;
    public static javax.swing.JTextField txt_id_cli;
    private javax.swing.JTextField txt_id_os;
    public static javax.swing.JTextField txt_id_pro;
    private javax.swing.JTextField txt_piezas;
    private javax.swing.JTextField txt_pre;
    public static javax.swing.JTextField txt_pro;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextField txt_status;
    // End of variables declaration//GEN-END:variables

    void codigos() {

        String c = "";
        String SQL = "select max(os_nro) from os";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txt_id_os.setText("0000001");
            } else {
                int j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                txt_id_os.setText(gen.serie());

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Registrar_OS.class
                    .getName()).log(Level.SEVERE, null, ex);
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
                    this.txt_pre.setText(
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
            String Texting = txt_pre.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre.setText(Integrated);
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
}
