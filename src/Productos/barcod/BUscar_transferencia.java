/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.barcod;

import Clases.Colorear_Transfe;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class BUscar_transferencia extends javax.swing.JDialog {

    DefaultTableModel model;

    public BUscar_transferencia(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_transferencia.setBackground(new java.awt.Color(69, 84, 92));

        }
        cargar("");
        txt_bus.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_transferencia = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_trans = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_ambiente_transfer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRANSFERENCIAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_transferencia.setBackground(new java.awt.Color(255, 255, 255));
        panel_transferencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_trans = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_trans.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_trans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_trans.setGridColor(new java.awt.Color(0, 102, 204));
        tb_trans.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_transMouseClicked(evt);
            }
        });
        tb_trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_transKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_transKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_trans);

        panel_transferencia.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1030, 460));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(null);
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        panel_transferencia.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 22, 380, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_transferencia.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 32));

        lbl_ambiente_transfer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        panel_transferencia.add(lbl_ambiente_transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 80, 30));

        getContentPane().add(panel_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_transMouseClicked
        try {

            int fila = tb_trans.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tb_trans.getValueAt(fila, 0).toString();
                String nom = tb_trans.getValueAt(fila, 2).toString();

                pro_codbar_lote.txt_id.setText(codins);
                pro_codbar_lote.txt_nom.setText(nom);
                pro_codbar_lote.btn_recargar.doClick();
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_transMouseClicked

    private void tb_transKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_transKeyReleased

    }//GEN-LAST:event_tb_transKeyReleased

    private void tb_transKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_transKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_tb_transKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

        cargar(txt_bus.getText());


    }//GEN-LAST:event_txt_busKeyReleased

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
            java.util.logging.Logger.getLogger(BUscar_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BUscar_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BUscar_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BUscar_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BUscar_transferencia dialog = new BUscar_transferencia(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lbl_ambiente_transfer;
    private javax.swing.JPanel panel_transferencia;
    public static javax.swing.JTable tb_trans;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Transf.", "Almacén Origen", "Almacém Destino", "Descripción", "Items", "Fecha", "Situación"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from transf_stock WHERE CONCAT (cod_tran,id_alma_des,nom_alma_des) LIKE '%" + valor + "%' ORDER BY cod_tran DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(5);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(7);
                registros[5] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(9));
                registros[6] = rs.getString(12);

                model.addRow(registros);
            }
            tb_trans.setModel(model);

            Colorear_Transfe color = new Colorear_Transfe(6);
            tb_trans.getColumnModel().getColumn(0).setCellRenderer(color);
            tb_trans.getColumnModel().getColumn(2).setCellRenderer(color);

            tb_trans.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_trans.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_trans.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_trans.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_trans.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_trans.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_trans.getColumnModel().getColumn(6).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
