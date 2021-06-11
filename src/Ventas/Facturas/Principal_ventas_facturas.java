/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Facturas;

import Clases.Nro_nul_facturas;
import Clases.sequencia_factura;
import Clases.status_factura_lote;
import Clases.staus_factura;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import Ventas.recibos.Recibos_factura_recibos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author user
 */
public class Principal_ventas_facturas extends javax.swing.JDialog {

    DefaultTableModel model;

    public Principal_ventas_facturas(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbl_cod_nulos.setVisible(false);
        cargar("");
        codigos();
        txt_bus.requestFocus();
        OpcionMenu();
        btn_cargar_datos.setVisible(false);
    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_ventas_factura = "";
    public static String cod_ventas_recibos = "";
    public static String cod_imprimir = "";
    public static String cod_lote = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();
        lbl_cod_nulos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturación");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProductos.setGridColor(new java.awt.Color(0, 102, 204));
        tbProductos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbProductos.setShowVerticalLines(false);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProductosKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbProductos);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1220, 500));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Agregar");
        jButton1.setToolTipText("Nueva factura");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 130, 50));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 19, 320, 23));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 370, 32));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 30));

        lbl_cod_nulos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_cod_nulos.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cod_nulos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cod_nulos.setText("0000001");
        lbl_cod_nulos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cod_nulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked

    }//GEN-LAST:event_tbProductosMouseClicked

    private void tbProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyReleased

    }//GEN-LAST:event_tbProductosKeyReleased

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }


    }//GEN-LAST:event_tbProductosKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Facturas_facturas ff = null;
        ff = new Facturas_facturas(new javax.swing.JDialog(), true);
        ff.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

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
            java.util.logging.Logger.getLogger(Principal_ventas_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_ventas_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_ventas_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_ventas_facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Principal_ventas_facturas dialog = new Principal_ventas_facturas(new javax.swing.JDialog(), true);
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
    public static javax.swing.JLabel lbl_cod_nulos;
    public static javax.swing.JTable tbProductos;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            Connection cn = conectar.getInstance().getConnection();
            String[] titulos = {"Factura Nro", "Seq. Nro", "Cód Cliente", "Cliente/Razón Social", "Valor Total", "Fecha Emisión", "Usuario", "Moneda", "Venta Nro", "Estado", "Lote"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

            String cons = "select * from ventas_facturacion  WHERE CONCAT (nro_fact_ventas,cod_cli_ventas,nom_cli_ventas) LIKE '%" + valor + "%' ORDER BY nro_fact_ventas DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(14);
                registros[1] = rs.getString(13);
                registros[2] = rs.getString(2);
                registros[3] = rs.getString(3);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(22);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(23);
                registros[8] = rs.getString(1);
                registros[9] = rs.getString(25);
                registros[10] = rs.getString(35);

                model.addRow(registros);
            }
            tbProductos.setModel(model);
            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(250);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(9).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(10).setPreferredWidth(50);

            sequencia_factura color = new sequencia_factura(1);
            tbProductos.getColumnModel().getColumn(1).setCellRenderer(color);

            staus_factura estado = new staus_factura(9);
            tbProductos.getColumnModel().getColumn(9).setCellRenderer(estado);

            status_factura_lote lote = new status_factura_lote(10);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(lote);
            tbProductos.getColumnModel().getColumn(10).setCellRenderer(lote);

            conectar.getInstance().closeConnection(cn);
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void codigos() {

        String c = "";
        String SQL = "select max(id_nulos) from ventas_facturacion";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                lbl_cod_nulos.setText("01");
            } else {
                int j = Integer.parseInt(c);
                Nro_nul_facturas gen = new Nro_nul_facturas();
                gen.generar(j);
                lbl_cod_nulos.setText(gen.serie());

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {

            Logger.getLogger(Principal_ventas_facturas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cancFactura() {
        codigos();
        try {

            int filasel = tbProductos.getSelectedRow();
            String cod = (String) tbProductos.getValueAt(filasel, 8);
            String lote = (String) tbProductos.getValueAt(filasel, 10);
            String id_nulo = lbl_cod_nulos.getText();
            String des = ("ANULADA");

            String sql = "UPDATE ventas_facturacion SET estado_fact = '" + des
                    + "',num_bol ='" + id_nulo
                    + "',id_nulos ='" + id_nulo
                    + "' WHERE num_bol = '" + cod + "' and lote_fact='" + lote + "' ";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void eliminarProducto() {

        int filasel = tbProductos.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                if (JOptionPane.showConfirmDialog(rootPane, "Anular Factura de venta" + ", ¿desea continuar?",
                        "Anular", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    String cod = (String) tbProductos.getValueAt(filasel, 0);
                    String eliminarSQL = "DELETE FROM ventas_facturacion WHERE nro_fact_ventas = '" + cod + "'";

                    try {
                        Connection cn = conectar.getInstance().getConnection();
                        PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                        pst.executeUpdate();
                        conectar.getInstance().closeConnection(cn);
                        JOptionPane.showMessageDialog(null, "Factura de venta cancelada");
                        cargar("");

                    } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        } catch (Exception e) {
        }

    }

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();

        JMenuItem menu_ver_nota = new JMenuItem("Visualizar Factura de venta", new ImageIcon(getClass().getResource("/icon_4/histo.png")));
        JMenuItem menu_modPro = new JMenuItem("Re-Imprimir Factura de venta", new ImageIcon(getClass().getResource("/icon_4/print.png")));
        JMenuItem menu_Recibos = new JMenuItem("Visualizar Recibos ", new ImageIcon(getClass().getResource("/icon_4/cash.png")));
        JMenuItem menu_DelPro = new JMenuItem("Cancelar Factura de venta", new ImageIcon(getClass().getResource("/icon_4/eliminar.png")));

        menu_ver_nota.addActionListener((ActionEvent e) -> {
            int filaMod = tbProductos.getSelectedRow();
            cod_ventas_factura = (String) tbProductos.getValueAt(filaMod, 8);

            Facturas_vista visor;
            visor = new Facturas_vista(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        });

        menu_DelPro.addActionListener((ActionEvent e) -> {
            //  eliminarProducto();

            cancFactura();
            btn_cargar_datos.doClick();

        });

        menu_Recibos.addActionListener((ActionEvent e) -> {

            int filaMod = tbProductos.getSelectedRow();
            cod_ventas_recibos = (String) tbProductos.getValueAt(filaMod, 0);
            cod_lote = (String) tbProductos.getValueAt(filaMod, 10);
            Recibos_factura_recibos visor_reci;
            visor_reci = new Recibos_factura_recibos(new javax.swing.JDialog(), true);
            visor_reci.setVisible(true);
        });
        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbProductos.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaMode = tbProductos.getSelectedRow();
                String cod_venta = (String) tbProductos.getValueAt(filaMode, 8);

                if (Principal.lbl_mod_factura.getText().equals("1")) {
                    Reportes reporte = new Reportes();
                    try {
                        reporte.factPrimero(cod_venta);
                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Facturas_facturas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (Principal.lbl_mod_factura.getText().equals("2")) {

                    Reportes reporte = new Reportes();
                    try {
                        reporte.factAll(cod_venta);
                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Facturas_facturas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (Principal.lbl_mod_factura.getText().equals("3")) {

                    Reportes reporte = new Reportes();
                    try {
                        reporte.factA4(cod_venta);
                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Facturas_facturas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (Principal.lbl_mod_factura.getText().equals("4")) {

                    Reportes reporte = new Reportes();
                    try {
                        reporte.factKyrios(cod_venta);
                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Facturas_facturas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                if (Principal.lbl_mod_factura.getText().equals("5")) {

                    Reportes reporte = new Reportes();
                    try {
                        reporte.factGabaon(cod_venta);
                    } catch (SQLException | JRException ex) {
                        Logger.getLogger(Facturas_facturas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });
        menu_opcion.add(menu_ver_nota);
        menu_opcion.add(menu_modPro);
        menu_opcion.add(menu_Recibos);
        menu_opcion.add(menu_DelPro);

        tbProductos.setComponentPopupMenu(menu_opcion);

    }
}
