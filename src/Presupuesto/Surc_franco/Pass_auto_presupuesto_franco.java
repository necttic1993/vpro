/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presupuesto.Surc_franco;


import Conexion_DB.conectar;
import static Presupuesto.Surc_franco.Precio_modelo_dos_pre_franco.btn_agregar_item;


import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Pass_auto_presupuesto_franco extends javax.swing.JDialog {

    /**
     * Creates new form Departamentos
     */
    public Pass_auto_presupuesto_franco(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

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
        btn_ok_auto = new javax.swing.JButton();
        pass_auto_vent = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autorización");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ok_auto.setBackground(new java.awt.Color(255, 255, 255));
        btn_ok_auto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_ok_auto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_png/png/usuario (4).png"))); // NOI18N
        btn_ok_auto.setText("OK");
        btn_ok_auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok_autoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ok_auto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 100, 40));

        pass_auto_vent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pass_auto_vent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass_auto_ventKeyPressed(evt);
            }
        });
        jPanel1.add(pass_auto_vent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 110));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ok_autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok_autoActionPerformed
        String cod = pass_auto_vent.getText();
        String confirma = "auto123x";

        if (cod.equals(confirma)) {
            btn_agregar_item.doClick();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Id ingresado no corresponde!");
            pass_auto_vent.setText("");
        }
    }//GEN-LAST:event_btn_ok_autoActionPerformed

    private void pass_auto_ventKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_auto_ventKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            btn_ok_auto.doClick();

        }
    }//GEN-LAST:event_pass_auto_ventKeyPressed

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
            java.util.logging.Logger.getLogger(Pass_auto_presupuesto_franco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pass_auto_presupuesto_franco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pass_auto_presupuesto_franco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pass_auto_presupuesto_franco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pass_auto_presupuesto_franco dialog = new Pass_auto_presupuesto_franco(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_ok_auto;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPasswordField pass_auto_vent;
    // End of variables declaration//GEN-END:variables


}
