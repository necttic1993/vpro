/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.Stock_almacenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Loadinf extends javax.swing.JDialog {

    private Timer t;
    private final ActionListener al;
    int x = 0;

    public Loadinf(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        al = (ActionEvent e) -> {
            x = x + 1;
            cp_copy.setValue(x);
            if (cp_copy.getValue() == 1) {
                lbl_progreso.setText("Preparando consulta...");
            }
            if (cp_copy.getValue() == 10) {
                lbl_progreso.setText("Generando reporte.");
            }
            if (cp_copy.getValue() == 15) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 20) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 25) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 30) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 35) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 40) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 45) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 50) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 55) {
                lbl_progreso.setText("Generando reporte...");
            }
            if (cp_copy.getValue() == 60) {
                lbl_progreso.setText("Generando reporte.");
            }
            if (cp_copy.getValue() == 65) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 70) {
                lbl_progreso.setText("Generando reporte...");
            }
            if (cp_copy.getValue() == 75) {
                lbl_progreso.setText("Generando reporte.");
            }
            if (cp_copy.getValue() == 80) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 85) {
                lbl_progreso.setText("Generando reporte..");
            }
            if (cp_copy.getValue() == 90) {
                lbl_progreso.setText("Preparando vista...");
            }
            if (cp_copy.getValue() == 92) {
                lbl_progreso.setText("Abriendo reporte.");
            }
         
            if (cp_copy.getValue() == 100) {
                dispose();
            }
        };
        t = new Timer(50, al);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_progreso = new javax.swing.JLabel();
        cp_copy = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_progreso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(lbl_progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 160, 40));
        jPanel1.add(cp_copy, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 440, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Loadinf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loadinf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loadinf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loadinf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Loadinf dialog = new Loadinf(new javax.swing.JDialog(), true);
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
    private javax.swing.JProgressBar cp_copy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_progreso;
    // End of variables declaration//GEN-END:variables
}
