/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Facturas;

import Devoluciones.*;
import Clases.ColorearFilas;
import Clases.ColorearTipoPago;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Lista_ventas_facturar extends javax.swing.JDialog {

    DefaultTableModel model;

    public Lista_ventas_facturar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
        txt_bus.requestFocus();
        //OpcionMenu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_can_dev = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ch_todos = new javax.swing.JCheckBox();
        ch_contado = new javax.swing.JCheckBox();
        ch_credito = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_can_dev = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_can_dev.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_can_dev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_can_dev.setGridColor(new java.awt.Color(0, 102, 204));
        tb_can_dev.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_can_dev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_can_devMouseClicked(evt);
            }
        });
        tb_can_dev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_can_devKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_can_devKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_can_dev);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1220, 520));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 400, 32));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 35));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        ch_todos.setBackground(new java.awt.Color(255, 255, 255));
        ch_todos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_todos.setText("Todos");
        ch_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_todosActionPerformed(evt);
            }
        });
        jPanel1.add(ch_todos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, 30));

        ch_contado.setBackground(new java.awt.Color(255, 255, 255));
        ch_contado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_contado.setText("Contado");
        ch_contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_contadoActionPerformed(evt);
            }
        });
        jPanel1.add(ch_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, 30));

        ch_credito.setBackground(new java.awt.Color(255, 255, 255));
        ch_credito.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_credito.setText("Crédito");
        ch_credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_creditoActionPerformed(evt);
            }
        });
        jPanel1.add(ch_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Filtrar por:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_can_devMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_can_devMouseClicked
        try {

            int fila = tb_can_dev.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tb_can_dev.getValueAt(fila, 0).toString();

                Facturas_facturas.txt_cod.setText(codins);
                // Devolucion_Devoluciones.btncalcular.doClick();
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_can_devMouseClicked

    private void tb_can_devKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_can_devKeyReleased

    }//GEN-LAST:event_tb_can_devKeyReleased

    private void tb_can_devKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_can_devKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {

            try {

                int fila = tb_can_dev.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_can_dev.getValueAt(fila, 0).toString();

                    Facturas_facturas.txt_cod.setText(codins);
                    // Devolucion_Devoluciones.btncalcular.doClick();
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }


    }//GEN-LAST:event_tb_can_devKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

        if (txt_bus.getText() == null) {

        } else {
            cargar(txt_bus.getText());
        }

    }//GEN-LAST:event_txt_busKeyReleased

    private void ch_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_todosActionPerformed
       ch_todos.setSelected(true);
        ch_credito.setSelected(false);
        ch_contado.setSelected(false);
    }//GEN-LAST:event_ch_todosActionPerformed

    private void ch_contadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_contadoActionPerformed
        ch_todos.setSelected(false);
        ch_credito.setSelected(false);
        ch_contado.setSelected(true);
    }//GEN-LAST:event_ch_contadoActionPerformed

    private void ch_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_creditoActionPerformed
        ch_todos.setSelected(false);
        ch_credito.setSelected(true);
        ch_contado.setSelected(false);
    }//GEN-LAST:event_ch_creditoActionPerformed

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
            java.util.logging.Logger.getLogger(Lista_ventas_facturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_ventas_facturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_ventas_facturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_ventas_facturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lista_ventas_facturar dialog = new Lista_ventas_facturar(new javax.swing.JDialog(), true);
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
    private javax.swing.JCheckBox ch_contado;
    private javax.swing.JCheckBox ch_credito;
    private javax.swing.JCheckBox ch_todos;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tb_can_dev;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {
            Connection cn = conectar.getInstance().getConnection();
            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

            String cons = "select * from ventas WHERE CONCAT (num_bol) LIKE '%" + valor + "%'  ORDER BY num_bol DESC ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tb_can_dev.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_can_dev.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_can_dev.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_can_dev.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_can_dev.getColumnModel().getColumn(2).setPreferredWidth(340);
            tb_can_dev.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_can_dev.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_can_dev.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_can_dev.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_can_dev.getColumnModel().getColumn(7).setPreferredWidth(150);
            tb_can_dev.getColumnModel().getColumn(8).setPreferredWidth(150);

            conectar.getInstance().closeConnection(cn);
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
