/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticas_productos;

import Clases.machusculas;
import Conexion_DB.conectar;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
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
public class Productos_control extends javax.swing.JDialog {

    DefaultTableModel tabla;
    FileInputStream fis;
    int longitudBytes;

    public Productos_control(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        cargarlistaproductos("");
        txtprod.setDocument(new machusculas());
        txtprod.requestFocus();

    }

    String comparar(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(6);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargarlistaproductos(String dato) {
        String[] Titulo = {"Codigo", "Descripcion", "Especificación"};
        tabla = new DefaultTableModel(null, Titulo);
        String[] Registro = new String[5];
        String mostrar = "SELECT * FROM tienda_productos WHERE CONCAT (pro_cod,'',pro_des) LIKE '%" + dato + "%'";
        Statement st;
        try {
            Connection cn = conectar.getInstance().getConnection();

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registro[0] = rs.getString("pro_cod");
                Registro[1] = rs.getString("pro_des");
                Registro[2] = rs.getString("pro_des_espec");

                tabla.addRow(Registro);
            }
            tbprod.setModel(tabla);

            int TF = tbprod.getRowCount();
            tbprod.getColumnModel().getColumn(0).setPreferredWidth(93);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(350);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(380);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtprod = new javax.swing.JTextField();
        bus = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbprod = new javax.swing.JTable();
        btncan = new javax.swing.JButton();
        btncan1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Productos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtprod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });
        jPanel1.add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 350, 32));

        bus.setMnemonic('w');
        bus.setText("...");
        bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busActionPerformed(evt);
            }
        });
        jPanel1.add(bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 0, 30));

        btnsalir.setMnemonic('s');
        btnsalir.setText("..");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 0, -1));

        tbprod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprod.setRequestFocusEnabled(false);
        tbprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbprodMouseClicked(evt);
            }
        });
        tbprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbprodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbprodKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbprod);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 420));

        btncan.setMnemonic('c');
        btncan.setContentAreaFilled(false);
        btncan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanActionPerformed(evt);
            }
        });
        jPanel1.add(btncan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 110, 10));

        btncan1.setMnemonic('a');
        btncan1.setContentAreaFilled(false);
        btncan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncan1ActionPerformed(evt);
            }
        });
        jPanel1.add(btncan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 110, 10));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
        // TODO add your handling code here:
        cargarlistaproductos(txtprod.getText());
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {

            this.dispose();
        }
        {
        }
    }//GEN-LAST:event_txtprodKeyReleased

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
        txtprod.requestFocus();
        txtprod.setText("");
        cargarlistaproductos("");
    }//GEN-LAST:event_busActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

    }//GEN-LAST:event_btnsalirActionPerformed

    private void tbprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprodMouseClicked
        String cod = "", nom = "";
        int fila = tbprod.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            } else {
                cod = (String) tbprod.getValueAt(fila, 0);
                nom = (String) tbprod.getValueAt(fila, 1);

                control_ventas_stock.txt_cod_pro.setText(cod);
                control_ventas_stock.lbl_des_pro.setText(nom);

            }

            this.dispose();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tbprodMouseClicked

    private void tbprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            String cod = "", nom = "";
            int fila = tbprod.getSelectedRow();
            try {
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

                } else {
                    cod = (String) tbprod.getValueAt(fila, 0);
                    nom = (String) tbprod.getValueAt(fila, 1);

                    control_ventas_stock.txt_cod_pro.setText(cod);
                    control_ventas_stock.lbl_des_pro.setText(nom);

                }

                this.dispose();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_tbprodKeyPressed

    private void tbprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyReleased

    }//GEN-LAST:event_tbprodKeyReleased

    private void tbprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyTyped

    }//GEN-LAST:event_tbprodKeyTyped

    private void btncanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanActionPerformed
        /*  try {
         DefaultTableModel tabladet = (DefaultTableModel) lanza_producto.tbdetbolpre.getModel();
         String[] dato = new String[5];

         int fila = tbprod.getSelectedRow();

         if (fila == -1) {
         JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
         } else {
         String codins = tbprod.getValueAt(fila, 0).toString();
         String desins = tbprod.getValueAt(fila, 1).toString();
         String preins = tbprod.getValueAt(fila, 2).toString();
         int c = 0;
         int j = 0;
         String cant = JOptionPane.showInputDialog("ingrese cantidad");
         if ((cant.equals("")) || (cant.equals("0"))) {
         JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
         } else {
         int canting = Integer.parseInt(cant);
         int comp = Integer.parseInt(comparar(codins));
         if (canting > comp) {
         JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
         } else {
         for (int i = 0; i < lanza_producto.tbdetbolpre.getRowCount(); i++) {
         Object com = lanza_producto.tbdetbolpre.getValueAt(i, 0);
         if (codins.equals(com)) {
         j = i;
         lanza_producto.tbdetbolpre.setValueAt(cant, i, 3);
         c = c + 1;

         }

         }
         if (c == 0) {

         dato[0] = codins;
         dato[1] = desins;
         dato[2] = preins;
         dato[3] = cant;

         tabladet.addRow(dato);

         lanza_producto.tbdetbolpre.setModel(tabladet);
         tbprod.getColumnModel().getColumn(0).setPreferredWidth(40);
         tbprod.getColumnModel().getColumn(1).setPreferredWidth(180);

         }
         }

         }

         }
         } catch (HeadlessException | NumberFormatException e) {
         }*/
    }//GEN-LAST:event_btncanActionPerformed

    private void btncan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncan1ActionPerformed
        txtprod.requestFocus();
        txtprod.setText("");
        cargarlistaproductos("");
    }//GEN-LAST:event_btncan1ActionPerformed

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
            java.util.logging.Logger.getLogger(Productos_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_control dialog = new Productos_control(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btncan;
    private javax.swing.JButton btncan1;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton bus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbprod;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables

}
