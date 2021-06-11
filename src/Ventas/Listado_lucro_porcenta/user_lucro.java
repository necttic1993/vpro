/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Listado_lucro_porcenta;

import Ventas.*;
import Clientes.Add_clientes;
import Conexion_DB.conectar;
import java.awt.event.KeyEvent;
import java.sql.Connection;
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
public class user_lucro extends javax.swing.JDialog {

    DefaultTableModel model;

    public user_lucro(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtbus.requestFocus();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        cargar("");
    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM usuarios WHERE CONCAT(usu,usu_cod) LIKE '%" + valor + "%'";
        String[] titulos = {"Código", "Nombre", "Grupo de Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("usu_cod");
                Registros[1] = rs.getString("usu");
                Registros[2] = rs.getString("tipo_usu");

                model.addRow(Registros);
            }
            tbclientes.setModel(model);
            tbclientes.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbclientes.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbclientes.getColumnModel().getColumn(2).setPreferredWidth(200);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(user_lucro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtbus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        btn_agregarcli = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Clientes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtbus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusActionPerformed(evt);
            }
        });
        txtbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbusKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusKeyReleased(evt);
            }
        });
        jPanel1.add(txtbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 400, 30));

        tbclientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbclientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbclientesMouseClicked(evt);
            }
        });
        tbclientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbclientesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbclientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 460));

        btn_agregarcli.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregarcli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_agregarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/anadir-nuevo-documento.png"))); // NOI18N
        btn_agregarcli.setMnemonic('a');
        btn_agregarcli.setFocusable(false);
        btn_agregarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarcliActionPerformed(evt);
            }
        });
        btn_agregarcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_agregarcliKeyPressed(evt);
            }
        });
        jPanel1.add(btn_agregarcli, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 60, 40));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel2.setFocusable(false);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusActionPerformed

    private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
        // TODO add your handling code here:
        cargar(txtbus.getText());
    }//GEN-LAST:event_txtbusKeyReleased

    private void tbclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbclientesMouseClicked
        String nom = "", dp = "", dir = "", cod = "", tipo = "";
        int fila = tbclientes.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            } else {
                cod = (String) tbclientes.getValueAt(fila, 0);
                nom = (String) tbclientes.getValueAt(fila, 1);

                ventas_lucro_departamento.txt_id_usu_lucro.setText(cod);
                ventas_lucro_departamento.txt_nom_usu_lucro.setText(nom);

                this.dispose();
                Ventas_venta.btn_buscaar_items.doClick();

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbclientesMouseClicked

    private void tbclientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbclientesKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            String nom = "", dp = "", dir = "", cod = "", tipo = "";
            int fila = tbclientes.getSelectedRow();
            try {
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

                } else {
                    cod = (String) tbclientes.getValueAt(fila, 0);
                    nom = (String) tbclientes.getValueAt(fila, 1);

                    ventas_lucro_departamento.txt_id_usu_lucro.setText(cod);
                    ventas_lucro_departamento.txt_nom_usu_lucro.setText(nom);

                    this.dispose();
                    Ventas_venta.btn_buscaar_items.doClick();

                }
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_tbclientesKeyPressed

    private void btn_agregarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarcliActionPerformed
        Add_clientes addc;
        addc = new Add_clientes(new javax.swing.JDialog(), true);
        addc.setVisible(true);
    }//GEN-LAST:event_btn_agregarcliActionPerformed

    private void txtbusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txtbusKeyPressed

    private void btn_agregarcliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_agregarcliKeyPressed

    }//GEN-LAST:event_btn_agregarcliKeyPressed

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
            java.util.logging.Logger.getLogger(user_lucro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_lucro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_lucro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_lucro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                user_lucro dialog = new user_lucro(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_agregarcli;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables

}
