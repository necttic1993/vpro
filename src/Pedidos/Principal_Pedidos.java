/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

import Clases.Colorear_Pedidos;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import Loggin_Principal.Seleccion_alma_pedidos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Principal_Pedidos extends javax.swing.JDialog {

    DefaultTableModel model;

    public Principal_Pedidos(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        cargarUsu();
        control_permisos();
        OpcionMenu();
        actualiza();
        txt_bus.requestFocus();
        btn_cargar_datos.setVisible(false);

    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_pedidos = "";
    public static String cod_imprimir = "";
    public static String cod_ver_ventas_plazo = "";
    public static String cod_ver_ventas_cli = "";
    public static String cod_ver_ventas_cli_factura = "";
    public static String cod_ped_status = "";
    public static String cod_ped_imprimir = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos_pedido = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();
        lbl_almacen_pedidos = new javax.swing.JLabel();
        lbl_ambiente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PEDIDOS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos_pedido = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos_pedido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProductos_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProductos_pedido.setGridColor(new java.awt.Color(0, 102, 204));
        tbProductos_pedido.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbProductos_pedido.setShowVerticalLines(false);
        tbProductos_pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductos_pedidoMouseClicked(evt);
            }
        });
        tbProductos_pedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductos_pedidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProductos_pedidoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbProductos_pedido);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1280, 520));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 140, 50));

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
        jPanel1.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, -1, 30));

        lbl_almacen_pedidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_almacen_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos.setText("Almacen");
        lbl_almacen_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_pedidosMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_almacen_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 110, 40));

        lbl_ambiente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(lbl_ambiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 80, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Ambiente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductos_pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductos_pedidoMouseClicked


    }//GEN-LAST:event_tbProductos_pedidoMouseClicked

    private void tbProductos_pedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_pedidoKeyReleased

    }//GEN-LAST:event_tbProductos_pedidoKeyReleased

    private void tbProductos_pedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductos_pedidoKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {

            int filaMod = tbProductos_pedido.getSelectedRow();
            cod_pedidos = (String) tbProductos_pedido.getValueAt(filaMod, 0);

            Visor_pedidos visor;
            visor = new Visor_pedidos(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }


    }//GEN-LAST:event_tbProductos_pedidoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Pedidos_pedidos pp = null;
        try {
            pp = new Pedidos_pedidos(new javax.swing.JDialog(), true);
        } catch (IOException ex) {
            Logger.getLogger(Principal_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        pp.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

          if (lbl_ambiente.getText().equals("0")) {
            cargar(txt_bus.getText());
        } else {
            cargar_espe(txt_bus.getText());
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // new Thread(new hilo_N()).start();
    }//GEN-LAST:event_formWindowOpened

    private void btn_cargar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_datosActionPerformed
        control_permisos();
    }//GEN-LAST:event_btn_cargar_datosActionPerformed

    private void lbl_almacen_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_pedidosMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            Seleccion_alma_pedidos aped;
            aped = new Seleccion_alma_pedidos(new javax.swing.JDialog(), true);
            aped.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_lbl_almacen_pedidosMouseClicked

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
            java.util.logging.Logger.getLogger(Principal_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Principal_Pedidos dialog = null;
                try {
                    dialog = new Principal_Pedidos(new javax.swing.JDialog(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Principal_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lbl_almacen_pedidos;
    private javax.swing.JLabel lbl_ambiente;
    public static javax.swing.JTable tbProductos_pedido;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Pedido", "Cód. Proveedor", "Proveedor", "Condición", "N° Cuotas", "Valor Total", "Estado  ", "Fecha", "Usuario", "Almacén", "O.P."};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from pedidos WHERE CONCAT (num_pedi,nom_provee) LIKE '%" + valor + "%'  ORDER BY num_pedi DESC LIMIT 300";
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
                registros[10] = rs.getString(17);

                model.addRow(registros);
            }
            tbProductos_pedido.setModel(model);

            Colorear_Pedidos color = new Colorear_Pedidos(6);
            tbProductos_pedido.getColumnModel().getColumn(0).setCellRenderer(color);

            tbProductos_pedido.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbProductos_pedido.getColumnModel().getColumn(1).setPreferredWidth(95);
            tbProductos_pedido.getColumnModel().getColumn(2).setPreferredWidth(290);
            tbProductos_pedido.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos_pedido.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos_pedido.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(8).setPreferredWidth(140);
            tbProductos_pedido.getColumnModel().getColumn(9).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(10).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_espe(String valor) {
        try {
            String almacen = lbl_almacen_pedidos.getText();
            String[] titulos = {"Nro Pedido", "Id Proveedor", "Proveedor", "Condición", "N° Cuotas", "Valor Total", "Estado  ", "Fecha", "Usuario", "Almacén", "O.P."};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from pedidos WHERE CONCAT (num_pedi,nom_provee) LIKE '%" + valor + "%' AND almacen_pedi='" + almacen + "'  ORDER BY num_pedi DESC LIMIT 300";
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
                registros[10] = rs.getString(17);

                model.addRow(registros);
            }
            tbProductos_pedido.setModel(model);

            Colorear_Pedidos color = new Colorear_Pedidos(6);
            tbProductos_pedido.getColumnModel().getColumn(0).setCellRenderer(color);

            tbProductos_pedido.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbProductos_pedido.getColumnModel().getColumn(1).setPreferredWidth(95);
            tbProductos_pedido.getColumnModel().getColumn(2).setPreferredWidth(290);
            tbProductos_pedido.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos_pedido.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos_pedido.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(8).setPreferredWidth(140);
            tbProductos_pedido.getColumnModel().getColumn(9).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(10).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void eliminarProducto() {

        int filasel = tbProductos_pedido.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                String cod = (String) tbProductos_pedido.getValueAt(filasel, 0);
                String eliminarSQL = "DELETE FROM pedidos WHERE num_pedi = '" + cod + "'";

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);

                    pst.executeUpdate();
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
        JMenuItem menu_eliminar_Pro = new JMenuItem("Status de Pedido", new ImageIcon(getClass().getResource("/icon_4/modificar.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbProductos_pedido.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaMod = tbProductos_pedido.getSelectedRow();
                cod_ped_imprimir = (String) tbProductos_pedido.getValueAt(filaMod, 0);
                Printers_Pedidos est;
                est = new Printers_Pedidos(new javax.swing.JDialog(), true);
                est.setVisible(true);
            }

        });
        menu_eliminar_Pro.addActionListener((ActionEvent e) -> {

            int filasel = tbProductos_pedido.getSelectedRow();

            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaModi = tbProductos_pedido.getSelectedRow();
                cod_ped_status = (String) tbProductos_pedido.getValueAt(filaModi, 0);
                Status_Pedidos rp;
                rp = new Status_Pedidos(new javax.swing.JDialog(), true);
                rp.setVisible(true);
            }
        });

        menu_opcion.add(menu_modPro);
        menu_opcion.add(menu_eliminar_Pro);

        tbProductos_pedido.setComponentPopupMenu(menu_opcion);

    }

    void cargarUsu() {

        String user = Principal.lbl_id_user.getText();
        String mostrar = "select * from usuarios where usu_cod='" + user + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_almacen_pedidos.setText(rs.getString(6));
                lbl_ambiente.setText(rs.getString(14));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Principal_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void control_permisos() {

        if (lbl_ambiente.getText().equals("0")) {
            cargar("");
        } else {
            cargar_espe("");
        }
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
        timer.schedule(tesk, 5000, 180000);
    }

}
