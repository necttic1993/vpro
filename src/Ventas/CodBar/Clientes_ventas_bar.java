/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.CodBar;

import Clientes.Add_clientes;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
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
public class Clientes_ventas_bar extends javax.swing.JDialog {

    DefaultTableModel model;

    public Clientes_ventas_bar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtbus.requestFocus();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        cargar("");
    }

    void cargar(String valor) {
        String mostrar = "SELECT cli_cod,cli_nombre,cli_razon,cli_ruc,cli_contacto,cli_tipo,cli_surc FROM tienda_clientes WHERE CONCAT(cli_nombre,cli_ruc) LIKE '%" + valor + "%'";
        String[] titulos = {"Código", "Nombre", "Razón Social", "RUC", "Contacto", "Tipo", "Sucursal"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cli_cod");
                Registros[1] = rs.getString("cli_nombre");
                Registros[2] = rs.getString("cli_razon");
                Registros[3] = rs.getString("cli_ruc");
                Registros[4] = rs.getString("cli_contacto");
                Registros[5] = rs.getString("cli_tipo");
                Registros[6] = rs.getString("cli_surc");
                model.addRow(Registros);
            }
            tbclientes.setModel(model);
            tbclientes.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbclientes.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbclientes.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbclientes.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbclientes.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbclientes.getColumnModel().getColumn(5).setPreferredWidth(250);
            tbclientes.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Clientes_ventas_bar.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 910, 470));

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
        jPanel1.add(btn_agregarcli, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 60, 40));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setText("Enter = Saleccionar");
        jLabel31.setFocusable(false);
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 150, 30));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel30.setFocusable(false);
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("ATAJOS:");
        jLabel32.setFocusable(false);
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 70, 30));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setText("Alt+A = Agregar");
        jLabel33.setFocusable(false);
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        String nom = "", dp = "", surc = "", cod = "", tipo = "";
        int fila = tbclientes.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            } else {
                cod = (String) tbclientes.getValueAt(fila, 0);
                nom = (String) tbclientes.getValueAt(fila, 1);
                dp = (String) tbclientes.getValueAt(fila, 3);
                tipo = (String) tbclientes.getValueAt(fila, 5);
                surc = (String) tbclientes.getValueAt(fila, 6);

                Ventas_venta_bar.txt_cod_cli.setText(cod);
                Ventas_venta_bar.txt_cli_nom.setText(nom);
                Ventas_venta_bar.txt_class_cli_ventas.setText(tipo);
                Ventas_venta_bar.txt_tipo_surc.setText(surc);
                // Ventas_venta.txt_dias_plazo.setText(dp);

                this.dispose();
                Ventas_venta_bar.txt_cod_barras.requestFocus();

            }
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_tbclientesMouseClicked

    private void tbclientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbclientesKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            String nom = "", dp = "", dir = "", cod = "", tipo = "", surc = "";
            int fila = tbclientes.getSelectedRow();
            try {
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

                } else {
                    cod = (String) tbclientes.getValueAt(fila, 0);
                    nom = (String) tbclientes.getValueAt(fila, 1);
                    dp = (String) tbclientes.getValueAt(fila, 3);
                    tipo = (String) tbclientes.getValueAt(fila, 5);
                    surc = (String) tbclientes.getValueAt(fila, 6);

                    Ventas_venta_bar.txt_cod_cli.setText(cod);
                    Ventas_venta_bar.txt_cli_nom.setText(nom);
                    Ventas_venta_bar.txt_class_cli_ventas.setText(tipo);
                    Ventas_venta_bar.txt_tipo_surc.setText(surc);
                    // Ventas_venta.txt_dias_plazo.setText(dp);

                    this.dispose();
                    Ventas_venta_bar.txt_cod_barras.requestFocus();

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
            java.util.logging.Logger.getLogger(Clientes_ventas_bar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes_ventas_bar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes_ventas_bar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes_ventas_bar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Clientes_ventas_bar dialog = new Clientes_ventas_bar(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables

}
