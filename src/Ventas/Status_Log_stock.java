/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Conexion_DB.conectar;
import static Ventas.Principal_ventas.cod_log_status;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Status_Log_stock extends javax.swing.JDialog {

    /**
     * Creates new form Departamentos
     */
    public Status_Log_stock(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_cod.setVisible(false);
        txt_cod.setText(cod_log_status);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txt_cod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_status = new org.jdesktop.swingx.JXComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Situación");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/modificar.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 70, 50));
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 20, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("SITUACIÓN:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AUTORIZADO", "NO AUTORIZADO" }));
        cb_status.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 430, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String id = txt_cod.getText();
            String des = (String) cb_status.getSelectedItem();

            String sql = "UPDATE ventas SET status_log = '" + des
                    + "' WHERE num_bol = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Situación actualizado");
                this.dispose();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }
        Principal_ventas.btn_cargar_datos.doClick();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

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
            java.util.logging.Logger.getLogger(Status_Log_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Status_Log_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Status_Log_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Status_Log_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Status_Log_stock dialog = new Status_Log_stock(new javax.swing.JDialog(), true);
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
    private org.jdesktop.swingx.JXComboBox cb_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_cod;
    // End of variables declaration//GEN-END:variables

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
