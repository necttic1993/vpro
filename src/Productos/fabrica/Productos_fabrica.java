/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.fabrica;

import Clases.Stock_minimo;
import Clases.machusculas;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto
 */
public class Productos_fabrica extends javax.swing.JDialog {

    DefaultTableModel tabla;
    FileInputStream fis;
    int longitudBytes;
    DefaultTableModel model;

    public Productos_fabrica(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);
        txtprod.setDocument(new machusculas());
        txtprod.requestFocus();
        cargarStock("");

    }

    public static String cod_pro_fabrica = "";

    String comparar(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(5);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargar(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Unidad de Medida", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(10);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
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
        tb_prod_trans = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Productos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtprod.setBorder(null);
        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });
        jPanel1.add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 13, 360, 23));

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

        tb_prod_trans = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_prod_trans.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_prod_trans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_prod_trans.setRequestFocusEnabled(false);
        tb_prod_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_prod_transMouseClicked(evt);
            }
        });
        tb_prod_trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_prod_transKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_prod_transKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_prod_transKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_prod_trans);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1100, 470));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased

        cargar(txtprod.getText());


    }//GEN-LAST:event_txtprodKeyReleased

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
        txtprod.requestFocus();
        txtprod.setText("");

    }//GEN-LAST:event_busActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tb_prod_transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_prod_transMouseClicked

        /*  try {
         DefaultTableModel tabladet = (DefaultTableModel) fabrica_stock.tb_trans_stock.getModel();
         String[] dato = new String[5];

         int fila = tb_prod_trans.getSelectedRow();

         if (fila == -1) {
         JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
         } else {
         String codins = tb_prod_trans.getValueAt(fila, 0).toString();
         String desins = tb_prod_trans.getValueAt(fila, 2).toString();
         String preins = tb_prod_trans.getValueAt(fila, 5).toString();
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
         for (int i = 0; i < fabrica_stock.tb_trans_stock.getRowCount(); i++) {
         Object com = fabrica_stock.tb_trans_stock.getValueAt(i, 0);
         if (codins.equals(com)) {
         j = i;
         fabrica_stock.tb_trans_stock.setValueAt(cant, i, 3);
         c = c + 1;

         }

         }
         if (c == 0) {

         dato[0] = codins;
         dato[1] = desins;
         dato[2] = preins;
         dato[3] = cant;

         tabladet.addRow(dato);

         fabrica_stock.tb_trans_stock.setModel(tabladet);

         }
         }
         fabrica_stock.btncalcular.doClick();

         }

         }
         } catch (HeadlessException | NumberFormatException e) {
         }*/
        int filaModi = tb_prod_trans.getSelectedRow();
        cod_pro_fabrica = (String) tb_prod_trans.getValueAt(filaModi, 0);
        Panel_precios_fabrica ppd;
        ppd = new Panel_precios_fabrica(new javax.swing.JDialog(), true);
        ppd.setVisible(true);

    }//GEN-LAST:event_tb_prod_transMouseClicked

    private void tb_prod_transKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prod_transKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {

            this.txtprod.requestFocus();

        }
    }//GEN-LAST:event_tb_prod_transKeyPressed

    private void tb_prod_transKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prod_transKeyReleased

    }//GEN-LAST:event_tb_prod_transKeyReleased

    private void tb_prod_transKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prod_transKeyTyped

    }//GEN-LAST:event_tb_prod_transKeyTyped

    private void txtprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txtprodKeyPressed

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
            java.util.logging.Logger.getLogger(Productos_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Productos_fabrica dialog = new Productos_fabrica(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton bus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tb_prod_trans;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables

    void cargarStock(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Unidad de Medida", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(10);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(350);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
