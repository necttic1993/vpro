/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import Clases.Colorear_status_pro;
import Clases.Stock_minimo_pedidos;
import Clases.Stock_minimo_pro;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
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
public class Productos extends javax.swing.JDialog {

    DefaultTableModel model;

    public Productos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);

        initComponents();
        OpcionMenu();
        cargarUsu();
        actualiza();
        txt_bus.requestFocus();
        lbl_stock_minimo.setVisible(false);
        //lbl_select_alma.setVisible(false);

        if (lbl_select_alma.getText().equals("TODOS")) {
            cargar("");

        }
        if (lbl_select_alma.getText().equals("0000001")) {
            cargar("");

        }

        if (lbl_select_alma.getText().equals("0000002")) {
            cargar_2("");

        }
        if (lbl_select_alma.getText().equals("0000003")) {
            cargar_3("");

        }
        if (lbl_select_alma.getText().equals("0000004")) {
            cargar_4("");

        }
        if (lbl_select_alma.getText().equals("0000005")) {
            cargar_5("");

        }
        //new deposito
        if (lbl_select_alma.getText().equals("0000006")) {
            cargar_6("");

        }

        if (lbl_select_alma.getText().equals("0000007")) {
            cargar_7("");

        }
        if (lbl_select_alma.getText().equals("0000008")) {
            cargar_8("");

        }
        if (lbl_select_alma.getText().equals("0000009")) {
            cargar_9("");

        }
        if (lbl_select_alma.getText().equals("0000010")) {
            cargar_10("");

        }
        if (lbl_select_alma.getText().equals("0000011")) {
            cargar_11("");

        }
        if (lbl_select_alma.getText().equals("0000012")) {
            cargar_12("");

        }
        if (lbl_select_alma.getText().equals("0000013")) {
            cargar_13("");

        }
        if (lbl_select_alma.getText().equals("0000014")) {
            cargar_14("");

        }
        if (lbl_select_alma.getText().equals("0000015")) {
            cargar_15("");

        }
        if (lbl_select_alma.getText().equals("0000016")) {
            cargar_16("");

        }
        if (lbl_select_alma.getText().equals("0000017")) {
            cargar_17("");

        }
        if (lbl_select_alma.getText().equals("0000018")) {
            cargar_18("");

        }
        if (lbl_select_alma.getText().equals("0000019")) {
            cargar_19("");

        }
        if (lbl_select_alma.getText().equals("0000020")) {
            cargar_20("");

        }
        if (lbl_select_alma.getText().equals("0000021")) {
            cargar_21("");

        }
        if (lbl_select_alma.getText().equals("0000022")) {
            cargar_22("");

        }
        if (lbl_select_alma.getText().equals("0000023")) {
            cargar_23("");

        }
        if (lbl_select_alma.getText().equals("0000024")) {
            cargar_24("");

        }
        if (lbl_select_alma.getText().equals("0000025")) {
            cargar_25("");

        }
        if (lbl_select_alma.getText().equals("0000026")) {
            cargar_26("");

        }
        if (lbl_select_alma.getText().equals("0000027")) {
            cargar_27("");

        }
        if (lbl_select_alma.getText().equals("0000028")) {
            cargar_28("");

        }
        if (lbl_select_alma.getText().equals("0000029")) {
            cargar_29("");

        }
        if (lbl_select_alma.getText().equals("0000030")) {
            cargar_30("");

        }

    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_pro_gral = "";

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();
        // JMenuItem menu_addpro = new JMenuItem("Agregar Producto", new ImageIcon(getClass().getResource("/Iconos_1/escritura.png")));
        JMenuItem menu_modPro = new JMenuItem("Modificar Producto", new ImageIcon(getClass().getResource("/icon_4/modificar.png")));
        JMenuItem menu_verPro = new JMenuItem("Detallles del Producto", new ImageIcon(getClass().getResource("/icon_4/scan.png")));
        JMenuItem menu_eliminar_Pro = new JMenuItem("Eliminar Producto", new ImageIcon(getClass().getResource("/icon_4/eliminar.png")));
        JMenuItem menu_excell = new JMenuItem("Exportar a Excell", new ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbProductos.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaMod = Productos.tbProductos.getSelectedRow();
                cod_pro_mod = (String) tbProductos.getValueAt(filaMod, 0);
                Actual_Productos rp;
                rp = new Actual_Productos(new javax.swing.JDialog(), true);
                rp.setVisible(true);
            }
        });

        menu_verPro.addActionListener((ActionEvent e) -> {
            int filasel = tbProductos.getSelectedRow();

            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaModelo = Productos.tbProductos.getSelectedRow();
                cod_imagen = (String) tbProductos.getValueAt(filaModelo, 0);

                DetallesProductos dp;
                dp = new DetallesProductos(new javax.swing.JDialog(), true);
                dp.setVisible(true);
            }
        });

        menu_eliminar_Pro.addActionListener((ActionEvent e) -> {

            int filasel = tbProductos.getSelectedRow();

            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                String cant = JOptionPane.showInputDialog("Ingrese Credencial");
                String seña = ("sistema123");
                if ((cant.equals("")) || (cant.equals("0"))) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar un credencial válido");
                } else {
                    if (!cant.equals(seña)) {
                        JOptionPane.showMessageDialog(this, "Ud. no cuenta con autorizacion");
                    } else {

                        if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
                                "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            eliminarProducto();
                        }

                    }
                }
            }
        });
        menu_excell.addActionListener((ActionEvent e) -> {

            Exporta_excell ex;
            ex = new Exporta_excell(new javax.swing.JDialog(), true);
            ex.setVisible(true);

        });

        menu_opcion.add(menu_modPro);
        menu_opcion.add(menu_eliminar_Pro);
        menu_opcion.add(menu_verPro);
        menu_opcion.add(menu_excell);
        tbProductos.setComponentPopupMenu(menu_opcion);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_stock_minimo = new javax.swing.JLabel();
        lbl_select_alma = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");
        setMinimumSize(new java.awt.Dimension(1205, 580));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1208, 590));
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
        tbProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbProductos.setGridColor(new java.awt.Color(0, 153, 153));
        tbProductos.setSelectionBackground(new java.awt.Color(0, 153, 153));
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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1240, 520));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 120, 40));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 16, 490, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 550, 32));

        lbl_stock_minimo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel1.add(lbl_stock_minimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 70, 30));

        lbl_select_alma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_select_alma.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_select_alma, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 170, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Sin stock");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, -1, 20));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 20, 20));

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 20, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Stock referente N°:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Producto Inactivo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, -1, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Stock Minimo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, 20));

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 20, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked

    }//GEN-LAST:event_tbProductosMouseClicked

    private void tbProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyReleased
        //   scanner();

    }//GEN-LAST:event_tbProductosKeyReleased

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
        }
        if (Tecla == KeyEvent.VK_SPACE) {


            /* DetallesProductos dp;
             dp = new DetallesProductos(new javax.swing.JDialog(), true);
             dp.setVisible(true);*/
            if (Principal.txt_simbolo.getText().equals("Gs")) {
                int filaMod = Productos.tbProductos.getSelectedRow();
                cod_pro = (String) Productos.tbProductos.getValueAt(filaMod, 0);
                costos_monedas_vistas cm;
                cm = new costos_monedas_vistas(new javax.swing.JDialog(), true);
                cm.setVisible(true);
            }

        }
        if (Tecla == KeyEvent.VK_ENTER) {
            int filaMod = Productos.tbProductos.getSelectedRow();
            cod_pro_gral = (String) Productos.tbProductos.getValueAt(filaMod, 0);
            DetallesPro_gral dg;
            dg = new DetallesPro_gral(new javax.swing.JDialog(), true);
            dg.setVisible(true);
        }

        if (Tecla == KeyEvent.VK_END) {
            /* int filaMod = Productos.tbProductos.getSelectedRow();
             cod_pro_gral = (String) Productos.tbProductos.getValueAt(filaMod, 0);
             DetallesPro_gral dg;
             dg = new DetallesPro_gral(new javax.swing.JDialog(), true);
             dg.setVisible(true);*/
            JOptionPane.showMessageDialog(null, "comando f12");
        }

    }//GEN-LAST:event_tbProductosKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }


    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        if (lbl_select_alma.getText().equals("TODOS")) {
            cargar(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000001")) {
            cargar(txt_bus.getText());

        }

        if (lbl_select_alma.getText().equals("0000002")) {
            cargar_2(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000003")) {
            cargar_3(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000004")) {
            cargar_4(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000005")) {
            cargar_5(txt_bus.getText());

        }
        ////nuevos depositos
        if (lbl_select_alma.getText().equals("0000006")) {
            cargar_6(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000007")) {
            cargar_7(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000008")) {
            cargar_8(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000009")) {
            cargar_9(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000010")) {
            cargar_10(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000011")) {
            cargar_11(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000012")) {
            cargar_12(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000013")) {
            cargar_13(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000014")) {
            cargar_14(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000015")) {
            cargar_15(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000016")) {
            cargar_16(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000017")) {
            cargar_17(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000018")) {
            cargar_18(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000019")) {
            cargar_19(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000020")) {
            cargar_20(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000021")) {
            cargar_21(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000022")) {
            cargar_22(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000023")) {
            cargar_23(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000024")) {
            cargar_24(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000025")) {
            cargar_25(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000026")) {
            cargar_26(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000027")) {
            cargar_27(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000028")) {
            cargar_28(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000029")) {
            cargar_29(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000030")) {
            cargar_30(txt_bus.getText());

        }
    }//GEN-LAST:event_txt_busKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        new Thread(new hilo()).start();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistrarProductos rp;
        rp = new RegistrarProductos(new javax.swing.JDialog(), true);
        rp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Productos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos dialog = new Productos(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_select_alma;
    private javax.swing.JLabel lbl_stock_minimo;
    public static javax.swing.JTable tbProductos;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "En Separación", "Stock Min.", "Status"};
            String[] registros = new String[8];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(23);
                registros[6] = rs.getString(22);
                registros[7] = rs.getString(24);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            Colorear_status_pro col_pro = new Colorear_status_pro(7);
            Stock_minimo_pedidos pedido = new Stock_minimo_pedidos(5);

            tbProductos.getColumnModel().getColumn(0).setCellRenderer(col_pro);
            tbProductos.getColumnModel().getColumn(1).setCellRenderer(col_pro);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(5).setCellRenderer(pedido);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(240);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(90);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(50);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(50);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_2(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(25);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_3(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(26);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_4(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(27);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_5(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(28);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }
/////nuevos depositos

    void cargar_6(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(29);
                registros[5] = rs.getString(22);
                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_7(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(30);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_8(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(31);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_9(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(32);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_10(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(33);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_11(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(34);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_12(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(35);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_13(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(36);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_14(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(37);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);
            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_15(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(38);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_16(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(39);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_17(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(40);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_18(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(41);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);;
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_19(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(42);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_20(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(43);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_21(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(44);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_22(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(45);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_23(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(46);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);;
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_24(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(47);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_25(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(48);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_26(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(49);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_27(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(50);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_28(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(51);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_29(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(52);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);;
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void cargar_30(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(53);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    void eliminarProducto() {

        int filasel = tbProductos.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                String cod = (String) tbProductos.getValueAt(filasel, 0);
                String eliminarSQL = "DELETE FROM tienda_productos WHERE pro_cod = '" + cod + "'";
                String eliminarSQL2 = "DELETE FROM imag_productos WHERE imag_cod = '" + cod + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                    PreparedStatement pst2 = cn.prepareStatement(eliminarSQL2);
                    pst.executeUpdate();
                    pst2.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    JOptionPane.showMessageDialog(null, "Borrado");
                    cargar("");

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }

    }

    void abrir_archivos() {
        /* if (java.awt.Desktop.isDesktopSupported()) {
         java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
         if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                
         try {
         java.net.URI uri;
         uri = new java.net.URI("http://localhost/center/login.php/");
         desktop.browse(uri);
         } catch (URISyntaxException | IOException e) {
         }
         }
         }*/

        Desktop desktop;
        //  String fileLocal = ("src/Productos/index.html");

        File file = new File("index.html");//declaro un Objeto File que apunte a mi archivo html
        if (Desktop.isDesktopSupported()) {// si éste Host soporta esta API 
            desktop = Desktop.getDesktop();//objtengo una instancia del Desktop(Escritorio)de mi host 
            try {

                desktop.open(file);//abro el archivo con el programa predeterminado
            } catch (IOException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lo lamento,no se puede abrir el archivo; ésta Maquina no soporta la API Desktop");
        }
        /* 
         try {
         String fileLocal = ("src/Productos/index.html");
         File path = new File(fileLocal);
         Runtime.getRuntime().exec("cmd /c start " + fileLocal);

         } catch (IOException ex) {
         Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }

    void cargarUsu() {

        String user = lbl_usu_nom.getText();
        String mostrar = "select * from usuarios where usu='" + user + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_select_alma.setText(rs.getString(6));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualiza() {

        Timer timer = new Timer();
        TimerTask tesk = new TimerTask() {
            int Cont = 0;

            @Override
            public void run() {
                cargar("");
            }
        };
        timer.schedule(tesk, 500, 270000);
    }
}
