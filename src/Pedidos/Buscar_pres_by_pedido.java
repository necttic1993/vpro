/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
 * @author user
 */
public class Buscar_pres_by_pedido extends javax.swing.JDialog {
    
    DefaultTableModel model;
    
    public Buscar_pres_by_pedido(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        cargar("");
        
        txt_bus.requestFocus();
        
    }
    
    public static String cod_pre = "";
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos_presupuesto = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_almacen_ventas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRESUPUESTO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos_presupuesto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos_presupuesto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProductos_presupuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProductos_presupuesto.setGridColor(new java.awt.Color(0, 102, 204));
        tbProductos_presupuesto.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbProductos_presupuesto.setShowVerticalLines(false);
        tbProductos_presupuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductos_presupuestoMouseClicked(evt);
            }
        });
        tbProductos_presupuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductos_presupuestoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProductos_presupuestoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbProductos_presupuesto);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1230, 500));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 18, 430, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 490, 32));

        lbl_almacen_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_ventas.setText("almacen");
        lbl_almacen_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbl_almacen_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductos_presupuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductos_presupuestoMouseClicked
        try {
            
            int fila = tbProductos_presupuesto.getSelectedRow();
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tbProductos_presupuesto.getValueAt(fila, 0).toString();
                
               /* Ventas_venta.lbl_cod_pre.setText(codins);
                Ventas_venta.lbl_control_tipo.setText("PRESUPUESTOS");
                Ventas_venta.btn_busca_pre.doClick();*/
                this.dispose();
                
            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tbProductos_presupuestoMouseClicked

    private void tbProductos_presupuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_presupuestoKeyReleased

    }//GEN-LAST:event_tbProductos_presupuestoKeyReleased

    private void tbProductos_presupuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_presupuestoKeyPressed
        char Tecla = evt.getKeyChar();
        
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {
            
            try {
                
                int fila = tbProductos_presupuesto.getSelectedRow();
                
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tbProductos_presupuesto.getValueAt(fila, 0).toString();
                  /*  
                    Ventas_venta.lbl_cod_pre.setText(codins);
                    Ventas_venta.lbl_control_tipo.setText("PEDIDOS");
                    Ventas_venta.btn_busca_pre.doClick();
                    this.dispose();*/
                    
                }
            } catch (HeadlessException | NumberFormatException e) {
            }
            
        }
        

    }//GEN-LAST:event_tbProductos_presupuestoKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();
        
        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        
          cargar(txt_bus.getText());

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        new Thread(new hilo_N()).start();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Buscar_pres_by_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar_pres_by_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar_pres_by_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar_pres_by_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Buscar_pres_by_pedido dialog = null;
                try {
                    dialog = new Buscar_pres_by_pedido(new javax.swing.JDialog(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Buscar_pres_by_pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_almacen_ventas;
    public static javax.swing.JTable tbProductos_presupuesto;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {
            
            String[] titulos = {"Nro Venta", "C??d. Cliente", "Cliente", "Condici??n", "N?? Cuotas", "Valor Total", "Estado  ", "Fecha", "Usuario", "Almac??n"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();
            
            String cons = "select * from presupuesto WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(12);
                registros[9] = rs.getString(13);
                
                model.addRow(registros);
            }
            tbProductos_presupuesto.setModel(model);
            
            tbProductos_presupuesto.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos_presupuesto.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos_presupuesto.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbProductos_presupuesto.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos_presupuesto.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos_presupuesto.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos_presupuesto.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos_presupuesto.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbProductos_presupuesto.getColumnModel().getColumn(8).setPreferredWidth(140);
            tbProductos_presupuesto.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);
            
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    void cargar_espe(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();
            String[] titulos = {"Nro Venta", "C??d. Cliente", "Cliente", "Condici??n", "N?? Cuotas", "Valor Total", "Estado", "Fecha", "Usuario", "Almac??n"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();
            
            String cons = "select * from presupuesto WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(12);
                registros[9] = rs.getString(13);
                
                model.addRow(registros);
            }
            tbProductos_presupuesto.setModel(model);
            
            tbProductos_presupuesto.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos_presupuesto.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos_presupuesto.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbProductos_presupuesto.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos_presupuesto.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos_presupuesto.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos_presupuesto.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos_presupuesto.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbProductos_presupuesto.getColumnModel().getColumn(8).setPreferredWidth(140);
            tbProductos_presupuesto.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);
            
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    void cargarUsu() {
        
        String user = lbl_usu_nom.getText();
        String mostrar = "select * from usuarios where usu='" + user + "' ";
        
        try {
            Connection cn = conectar.getInstance().getConnection();
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                
                lbl_almacen_ventas.setText(rs.getString(6));
                
            }
            conectar.getInstance().closeConnection(cn);
            
        } catch (SQLException ex) {
            Logger.getLogger(Buscar_pres_by_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void control_permisos() {
        
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargar("");
        } else {
            cargar_espe("");
        }
        
    }
    
}
