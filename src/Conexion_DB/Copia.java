/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion_DB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Copia extends javax.swing.JDialog {

   /* private Timer t;
    private final ActionListener al;
    int x = 0;*/

    public Copia(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
       
    
     /*   al = (ActionEvent e) -> {
            x = x + 1;
            cp_copy.setValue(x);
              if (cp_copy.getValue() == 1) {
                lbl_progreso.setText("COPIANDO...");
            }
            if (cp_copy.getValue() == 10) {
                lbl_progreso.setText("COPIANDO 10%.");
            }
            if (cp_copy.getValue() == 20) {
                lbl_progreso.setText("COPIANDO 20%..");
            }
            if (cp_copy.getValue() == 30) {
                lbl_progreso.setText("COPIANDO 30%...");
            }
            if (cp_copy.getValue() == 40) {
                lbl_progreso.setText("COPIANDO 40%.");
            }
            if (cp_copy.getValue() == 50) {
                lbl_progreso.setText("COPIANDO 50%..");
            }
            if (cp_copy.getValue() == 60) {
                lbl_progreso.setText("COPIANDO 60%...");
            }
            if (cp_copy.getValue() == 70) {
                lbl_progreso.setText("COPIANDO 70%.");
            }
            if (cp_copy.getValue() == 80) {
                lbl_progreso.setText("COPIANDO 80%..");
            }
            if (cp_copy.getValue() == 90) {
                lbl_progreso.setText("COPIANDO 90%...");
            }
             if (cp_copy.getValue() == 92) {
                lbl_progreso.setText("CERRANDO SISTEMA...");
            }
            if (cp_copy.getValue() == 100) {
                dispose();
            }
        };
        t = new Timer(50, al);
        t.start();*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Copia de seguridad realizado correctamente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 340, 50));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/check.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 70, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 150));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCustom1ActionPerformed

    }//GEN-LAST:event_rSButtonCustom1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.exit(0);
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
            java.util.logging.Logger.getLogger(Copia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Copia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Copia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Copia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Copia dialog = new Copia(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
