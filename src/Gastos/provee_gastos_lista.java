/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos;

import Conexion_DB.conectar;
import Proveedores.Add_proveedor;

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
public class provee_gastos_lista extends javax.swing.JDialog {

    DefaultTableModel model;

    public provee_gastos_lista(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        // AWTUtilities.setWindowShape(this, forma);
        txtbus.requestFocus();
        btn_cargar_datos.setVisible(false);
        cargar("");

    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM tienda_proveedores WHERE CONCAT(prov_nom,prov_ruc,prov_razon) LIKE '%" + valor + "%'";
        String[] titulos = {"Código", "Nombres", "Razón Social ", "RUC", "Clasificación"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("prov_cod");
                Registros[1] = rs.getString("prov_nom");
                Registros[2] = rs.getString("prov_razon");
                Registros[3] = rs.getString("prov_ruc");
                Registros[4] = rs.getString("prov_clas");

                model.addRow(Registros);
            }
            tbprovee.setModel(model);
            tbprovee.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbprovee.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbprovee.getColumnModel().getColumn(2).setPreferredWidth(250);
            tbprovee.getColumnModel().getColumn(3).setPreferredWidth(120);
            tbprovee.getColumnModel().getColumn(4).setPreferredWidth(220);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(provee_gastos_lista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbprovee = new javax.swing.JTable();
        txtbus = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_cargar_datos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Proveedor");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbprovee.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbprovee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprovee.setGridColor(new java.awt.Color(255, 255, 255));
        tbprovee.setRowHeight(18);
        tbprovee.setSelectionBackground(new java.awt.Color(0, 102, 204));
        tbprovee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproveeMouseClicked(evt);
            }
        });
        tbprovee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbproveeKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbprovee);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 910, 410));

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
        jPanel3.add(txtbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 380, 32));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/anadir-nuevo-documento.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 70, 40));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.setFocusable(false);
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbproveeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproveeMouseClicked
        String cod = "", des = "", dir = "", ruc = "", nac = "";
        int fila = tbprovee.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            } else {
                des = (String) tbprovee.getValueAt(fila, 1);
                cod = (String) tbprovee.getValueAt(fila, 0);

                Egresoos_consulta.txt_provee_lista.setText(des);
                Egresoos_consulta.txt_id_prov_lista.setText(cod);

                this.dispose();

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tbproveeMouseClicked

    private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusActionPerformed

    private void txtbusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txtbusKeyPressed

    private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
        // TODO add your handling code here:
        cargar(txtbus.getText());
    }//GEN-LAST:event_txtbusKeyReleased

    private void tbproveeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbproveeKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            String cod = "", des = "", dir = "", ruc = "", nac = "";
            int fila = tbprovee.getSelectedRow();
            try {
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

                } else {
                    des = (String) tbprovee.getValueAt(fila, 1);
                    cod = (String) tbprovee.getValueAt(fila, 0);

                    Egresoos_consulta.txt_provee_lista.setText(des);
                    Egresoos_consulta.txt_id_prov_lista.setText(cod);

                    this.dispose();

                }
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_tbproveeKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Add_proveedor cate;
        cate = new Add_proveedor(new javax.swing.JDialog(), true);
        cate.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_cargar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_datosActionPerformed
        cargar("");
    }//GEN-LAST:event_btn_cargar_datosActionPerformed

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
            java.util.logging.Logger.getLogger(provee_gastos_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(provee_gastos_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(provee_gastos_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(provee_gastos_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                provee_gastos_lista dialog = new provee_gastos_lista(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_cargar_datos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbprovee;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables

}
