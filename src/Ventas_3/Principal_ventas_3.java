/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas_3;

import Clases.ColorearFilas;
import Clases.ColorearTipoPago;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import static Loggin_Principal.Principal.txt_modelo_ventas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Principal_ventas_3 extends javax.swing.JDialog {
    
    DefaultTableModel model;
    
    public Principal_ventas_3(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        boton();
        cargarUsu();
        control_permisos();
        OpcionMenu();
        txt_bus.requestFocus();
        btn_cargar_datos.setVisible(false);
        actualiza();
        //  new Thread(new hilo_N()).start();

    }
    
    public static String cod_pro_3 = "";
    public static String cod_imagen_3 = "";
    public static String cod_pro_mod_3 = "";
    public static String cod_ventas_3 = "";
    public static String cod_imprimir_3 = "";
    public static String cod_ver_ventas_plazo_3 = "";
    public static String cod_ver_ventas_cli_3 = "";
    public static String cod_ver_ventas_cli_factura_3 = "";
    public static String cod_ver_alma_3 = "";
    public static String cod_id_venta_3 = "";
    public static String cod_id_venta_print_3 = "";
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos_3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();
        lbl_almacen_ventas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTAS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos_3 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos_3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProductos_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProductos_3.setGridColor(new java.awt.Color(0, 102, 204));
        tbProductos_3.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbProductos_3.setShowVerticalLines(false);
        tbProductos_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductos_3MouseClicked(evt);
            }
        });
        tbProductos_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductos_3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProductos_3KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbProductos_3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1230, 500));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 120, 50));

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

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, 30));

        lbl_almacen_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_ventas.setText("almacen");
        lbl_almacen_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbl_almacen_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductos_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductos_3MouseClicked

    }//GEN-LAST:event_tbProductos_3MouseClicked

    private void tbProductos_3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_3KeyReleased

    }//GEN-LAST:event_tbProductos_3KeyReleased

    private void tbProductos_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_3KeyPressed
        char Tecla = evt.getKeyChar();
        
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {
            
            int filaMod = tbProductos_3.getSelectedRow();
            cod_ventas_3 = (String) tbProductos_3.getValueAt(filaMod, 0);
            
            Visor_ventas_3 visor;
            visor = new Visor_ventas_3(new javax.swing.JDialog(), true);
            visor.setVisible(true);
            
        }
        if (Tecla == KeyEvent.VK_SPACE) {
            int filaMod = tbProductos_3.getSelectedRow();
            String verificar = (String) tbProductos_3.getValueAt(filaMod, 3);
            String status = ("CONTADO");
            String status_tar = ("TARJETA");
            if (verificar.equals(status) || verificar.equals(status_tar)) {
                JOptionPane.showMessageDialog(null, "Comando solo para ventas a crédito!");
            } else {
                
                int filaMod_ver = tbProductos_3.getSelectedRow();
                cod_ver_ventas_plazo_3 = (String) tbProductos_3.getValueAt(filaMod_ver, 0);
                int filaMod_cli = tbProductos_3.getSelectedRow();
                cod_ver_ventas_cli_3 = (String) tbProductos_3.getValueAt(filaMod_cli, 1);
                int filaMod_alma = tbProductos_3.getSelectedRow();
                cod_ver_alma_3 = (String) tbProductos_3.getValueAt(filaMod_alma, 9);
                /*     pago_plazo_ver_ventas_11 visor_ver;
                 visor_ver = new pago_plazo_ver_ventas_11(new javax.swing.JDialog(), true);
                 visor_ver.setVisible(true);*/
                
            }
        }
    }//GEN-LAST:event_tbProductos_3KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txt_modelo_ventas.getText().equals("Normal")) {
            
            try {
                Ventas_venta_3 vv = null;
                vv = new Ventas_venta_3(new javax.swing.JDialog(), true);
                vv.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Principal_ventas_3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }/*
         if (txt_modelo_ventas.getText().equals("Normal-barras")) {

         try {
         Ventas_venta_barras vvb = null;
         vvb = new Ventas_venta_barras(new javax.swing.JDialog(), true);
         vvb.setVisible(true);

         } catch (IOException ex) {
         Logger.getLogger(Principal_ventas_20.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         if (txt_modelo_ventas.getText().equals("Fiscal")) {

         try {
         Ventas_venta_fiscal vvf = null;
         vvf = new Ventas_venta_fiscal(new javax.swing.JDialog(), true);
         vvf.setVisible(true);
         } catch (IOException ex) {
         Logger.getLogger(Principal_ventas_20.class.getName()).log(Level.SEVERE, null, ex);
         }

         }
         if (txt_modelo_ventas.getText().equals("Fiscal-etiqueta")) {

         try {
         Ventas_venta_fiscal_barras vvfb = null;
         vvfb = new Ventas_venta_fiscal_barras(new javax.swing.JDialog(), true);
         vvfb.setVisible(true);
         } catch (IOException ex) {
         Logger.getLogger(Principal_ventas_20.class.getName()).log(Level.SEVERE, null, ex);
         }

         }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();
        
        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btn_cargar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_datosActionPerformed
        control_permisos();
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
            java.util.logging.Logger.getLogger(Principal_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_ventas_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal_ventas_3 dialog = null;
                try {
                    dialog = new Principal_ventas_3(new javax.swing.JDialog(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Principal_ventas_3.class.getName()).log(Level.SEVERE, null, ex);
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
    public static javax.swing.JButton btn_cargar_datos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lbl_almacen_ventas;
    public static javax.swing.JTable tbProductos_3;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {
            
            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Usuario", "Almacén"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();
            
            String cons = "select * from ventas_3 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' ORDER BY num_bol DESC";
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
                registros[7] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(10));
                registros[8] = rs.getString(12);
                registros[9] = rs.getString(13);
                
                model.addRow(registros);
            }
            tbProductos_3.setModel(model);
            
            ColorearFilas color = new ColorearFilas(6);
            tbProductos_3.getColumnModel().getColumn(0).setCellRenderer(color);
            
            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos_3.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos_3.getColumnModel().getColumn(4).setCellRenderer(colorear);
            
            tbProductos_3.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos_3.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos_3.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbProductos_3.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos_3.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos_3.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos_3.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos_3.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbProductos_3.getColumnModel().getColumn(8).setPreferredWidth(140);
            tbProductos_3.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);
            
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    void eliminarProducto() {
        
        int filasel = tbProductos_3.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                
                String cod = (String) tbProductos_3.getValueAt(filasel, 0);
                String eliminarSQL = "DELETE FROM ventas_facturacion WHERE num_bol = '" + cod + "'";
                String eliminarSQL2 = "DELETE FROM ventas_facturacion_deta WHERE num_bol = '" + cod + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();
                    
                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                    PreparedStatement pst2 = cn.prepareStatement(eliminarSQL2);
                    pst.executeUpdate();
                    pst2.executeUpdate();
                    conectar.getInstance().closeConnection(cn);
                    
                    JOptionPane.showMessageDialog(null, "Borrado");
                    
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }
        
    }
    
    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();
        
        JMenuItem menu_modPro = new JMenuItem("Re-Imprimir Nota", new ImageIcon(getClass().getResource("/icon_4/print.png")));
        JMenuItem menu_eliminar_Pro = new JMenuItem("Modificar Nota", new ImageIcon(getClass().getResource("/icon_4/modificar.png")));
        
        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbProductos_3.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                
                int filaMod = tbProductos_3.getSelectedRow();
                cod_id_venta_print_3 = (String) tbProductos_3.getValueAt(filaMod, 0);
                
                Printers_ventas_3 est;
                est = new Printers_ventas_3(new javax.swing.JDialog(), true);
                est.setVisible(true);
                
            }
        });
        menu_eliminar_Pro.addActionListener((ActionEvent e) -> {
            int filaMod = tbProductos_3.getSelectedRow();
            if (filaMod == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                
                String verificar = (String) tbProductos_3.getValueAt(filaMod, 6);
                String status = ("CONFIRMADA");
                if (verificar.equals(status)) {
                    JOptionPane.showMessageDialog(null, "La nota ya fue confirmada en caja");
                } else {
                    cod_id_venta_3 = (String) tbProductos_3.getValueAt(filaMod, 0);
                    /*   Ventas_venta_11_mod visorBusca;
                     visorBusca = new Ventas_venta_11_mod(new javax.swing.JDialog(), true);
                     visorBusca.setVisible(true);*/
                }
            }
            
        });
        
        menu_opcion.add(menu_modPro);
        // menu_opcion.add(menu_eliminar_Pro);

        tbProductos_3.setComponentPopupMenu(menu_opcion);
        
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
            Logger.getLogger(Principal_ventas_3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void control_permisos() {
          if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            lbl_almacen_ventas.setText("0000003");
            cargar("");
        } else {
            cargar("");
        }
    }
    
    void boton() {
        
    }
    
    public void actualiza() {
        
        Timer timer = new Timer();
        TimerTask tesk = new TimerTask() {
            int Cont = 0;
            
            @Override
            public void run() {
                control_permisos();
            }
        };
        timer.schedule(tesk, 500, 180000);
    }
    
}
