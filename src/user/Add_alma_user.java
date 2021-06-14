/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Add_alma_user extends javax.swing.JDialog {

    public Add_alma_user(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tb_usu_alma.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_usu_alma.getColumnModel().getColumn(1).setPreferredWidth(120);
        tb_usu_alma.getColumnModel().getColumn(1).setPreferredWidth(120);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_id_pro = new javax.swing.JTextField();
        txt_id_usuario = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_des_pro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_usu_alma = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("scanner");
        setLocation(new java.awt.Point(500, 200));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id_pro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_id_pro.setEnabled(false);
        jPanel1.add(txt_id_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 30));

        txt_id_usuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_id_usuario.setForeground(new java.awt.Color(153, 51, 0));
        txt_id_usuario.setFocusable(false);
        jPanel1.add(txt_id_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 90, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Descripción");
        jLabel24.setFocusable(false);
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 80, 20));

        txt_des_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_des_pro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_des_pro.setEnabled(false);
        jPanel1.add(txt_des_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 370, 30));

        /*tb_usu_alma = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };*/
        tb_usu_alma.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_usu_alma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "ID Usuario", "ID Almacén"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_usu_alma.setGridColor(new java.awt.Color(255, 255, 255));
        tb_usu_alma.setRowHeight(22);
        tb_usu_alma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_usu_almaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_usu_alma);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 590, 330));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/ok.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 50, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 50, 30));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("ID Alamcén");
        jLabel28.setFocusable(false);
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("ID Usuario:");
        jLabel29.setFocusable(false);
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_usu_almaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_usu_almaKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
        }
    }//GEN-LAST:event_tb_usu_almaKeyPressed

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
            java.util.logging.Logger.getLogger(Add_alma_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_alma_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_alma_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_alma_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Add_alma_user dialog = new Add_alma_user(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tb_usu_alma;
    private javax.swing.JTextField txt_des_pro;
    private javax.swing.JTextField txt_id_pro;
    private javax.swing.JLabel txt_id_usuario;
    // End of variables declaration//GEN-END:variables

    void agregaritems() {

        DefaultTableModel tabladet = (DefaultTableModel) tb_usu_alma.getModel();
        String[] dato = new String[5];
        int c = 0;
        int j = 0;
        String id = txt_id_pro.getText();
        String des = txt_des_pro.getText();
        String id_cli = txt_id_usuario.getText();

        if (c == 0) {
            dato[0] = id;
            dato[1] = id_cli;
            dato[2] = des;

            tabladet.addRow(dato);

            tb_usu_alma.setModel(tabladet);

        }

        txt_id_pro.setText("");
        txt_des_pro.setText("");

    }

}
