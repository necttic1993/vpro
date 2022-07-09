/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.Produccion;

import Clases.GenerarNumero;
import Clases.Generar_Num_Pro;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Presupuesto_produccion extends javax.swing.JDialog {

    /**
     * Creates new form facturacion
     *
     * @param parent
     */
    DefaultTableModel model;

    public Presupuesto_produccion(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        codigos();
        btn_cargar_pedidos.setVisible(false);
        txt_cli_nom.setDisabledTextColor(Color.black);
        lbl_fecha_VISOR.setText(fechaactS());
        tb_prod_pedi.getColumnModel().getColumn(0).setPreferredWidth(120);
        tb_prod_pedi.getColumnModel().getColumn(1).setPreferredWidth(520);

        txt_usu_ventas.setText(lbl_usu_nom.getText());

    }

    public static String nro_pedido = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_prod_pedi = new javax.swing.JTable();
        lbl_cod = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_cod_cli = new javax.swing.JTextField();
        txt_cli_nom = new javax.swing.JTextField();
        btn_buscaar_items = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_usu_ventas = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbl_fecha_VISOR = new javax.swing.JTextField();
        txt_nro_pedido = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnven = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cb_prioridad = new javax.swing.JComboBox();
        txt_nro_op = new javax.swing.JTextField();
        btn_cargar_pedidos = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txt_des_prod = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jd_ini = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PRODUCCIÓN");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_prod_pedi = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_prod_pedi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_prod_pedi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción"
            }
        ));
        tb_prod_pedi.setGridColor(new java.awt.Color(255, 255, 255));
        tb_prod_pedi.setRowHeight(22);
        tb_prod_pedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_prod_pediMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_prod_pedi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 960, 340));

        lbl_cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cod.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cod.setText("0000001");
        lbl_cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 110, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Nro de Doc:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 80, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Nro Pedido:");
        jLabel16.setFocusable(false);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 80, 30));

        txt_cod_cli.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cod_cli.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_cod_cli.setEnabled(false);
        txt_cod_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_cliActionPerformed(evt);
            }
        });
        txt_cod_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_cliKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cod_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 32));

        txt_cli_nom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_cli_nom.setEnabled(false);
        txt_cli_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_nomActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cli_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 400, 32));

        btn_buscaar_items.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscaar_items.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscaar_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/timer.png"))); // NOI18N
        btn_buscaar_items.setMnemonic('a');
        btn_buscaar_items.setText("PEDIDOS");
        btn_buscaar_items.setToolTipText("ALT+A");
        btn_buscaar_items.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscaar_items.setFocusable(false);
        btn_buscaar_items.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_buscaar_items.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_buscaar_items.setVerifyInputWhenFocusTarget(false);
        btn_buscaar_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaar_itemsActionPerformed(evt);
            }
        });
        btn_buscaar_items.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_buscaar_itemsKeyPressed(evt);
            }
        });
        jPanel1.add(btn_buscaar_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 140, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Nro Cliente :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 32));

        txt_usu_ventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_usu_ventas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_usu_ventas.setEnabled(false);
        txt_usu_ventas.setFocusable(false);
        jPanel1.add(txt_usu_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 220, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Usuario Ventas:");
        jLabel18.setFocusable(false);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));

        lbl_fecha_VISOR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_fecha_VISOR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_fecha_VISOR.setEnabled(false);
        lbl_fecha_VISOR.setFocusable(false);
        jPanel1.add(lbl_fecha_VISOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 100, 30));

        txt_nro_pedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_nro_pedido.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        txt_nro_pedido.setEnabled(false);
        jPanel1.add(txt_nro_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 160, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Fecha:");
        jLabel21.setFocusable(false);
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 50, 30));

        btnven.setBackground(new java.awt.Color(255, 255, 255));
        btnven.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btnven.setText("Grabar");
        btnven.setToolTipText("");
        btnven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnven.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnven.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });
        jPanel1.add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 130, 45));

        btn_salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_salir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/login.png"))); // NOI18N
        btn_salir.setMnemonic('s');
        btn_salir.setText("Salir");
        btn_salir.setToolTipText("Salir");
        btn_salir.setBorder(null);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        btn_salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_salirKeyReleased(evt);
            }
        });
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 130, 45));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Fecha de Entrega:");
        jLabel19.setFocusable(false);
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 120, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Descripción:");
        jLabel20.setFocusable(false);
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));

        cb_prioridad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_prioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "URGENTE", "INTERMEDIO", "BAJO" }));
        jPanel1.add(cb_prioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 160, 30));

        txt_nro_op.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nro_op.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nro_op.setEnabled(false);
        jPanel1.add(txt_nro_op, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 100, 30));

        btn_cargar_pedidos.setText("cargar");
        btn_cargar_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_pedidosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, -1, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Nro O.P:");
        jLabel22.setFocusable(false);
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 60, 30));

        txt_des_prod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_des_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 490, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Prioridad:");
        jLabel23.setFocusable(false);
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 30));
        jPanel1.add(jd_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cli_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_nomActionPerformed

    private void txt_cod_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_cliKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir ?",
                    "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.dispose();

            }

        }
    }//GEN-LAST:event_txt_cod_cliKeyPressed

    private void txt_cod_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_cliActionPerformed

    private void btn_buscaar_itemsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_buscaar_itemsKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_cod_cli.requestFocus();
        }
    }//GEN-LAST:event_btn_buscaar_itemsKeyPressed

    private void btn_buscaar_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaar_itemsActionPerformed

        try {
            Notas_pedidos as;
            as = new Notas_pedidos(new javax.swing.JDialog(), true);
            as.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Presupuesto_produccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_buscaar_itemsActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //    new Thread(new hilo()).start();

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed

        if ((lbl_cod.getText().equals("")) || (txt_nro_pedido.getText().equals("")) || (txt_cod_cli.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
        } else {

            ticket();

            if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                    "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                // cod_print_presupuesto_modulo = lbl_cod.getText();
                //printers_pres est;
                // est = new printers_pres(new javax.swing.JDialog(), true);
                // est.setVisible(true);
            }

            DefaultTableModel modelo = (DefaultTableModel) tb_prod_pedi.getModel();
            int a = tb_prod_pedi.getRowCount() - 1;
            int i;
            for (i = a; i >= 0; i--) {
                modelo.removeRow(i);
            }
            codigos();

        }

        txt_cod_cli.requestFocus();
        Principal_produccion.btn_cargar_datos.doClick();
        this.dispose();

    }//GEN-LAST:event_btnvenActionPerformed

    private void btn_salirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_salirKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {

            btn_salir.doClick();

        }
    }//GEN-LAST:event_btn_salirKeyReleased

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir ?",
                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //  new Thread(new hilo()).interrupt();
            dispose();
        }

    }//GEN-LAST:event_btn_salirActionPerformed

    private void tb_prod_pediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_prod_pediMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_prod_pediMouseClicked

    private void btn_cargar_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_pedidosActionPerformed
        cargarTxt();
        cargar_detalle();
    }//GEN-LAST:event_btn_cargar_pedidosActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presupuesto_produccion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Presupuesto_produccion dialog = null;

                    dialog = new Presupuesto_produccion(new javax.swing.JDialog(), true);

                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir del sistema?",
                                    "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                System.exit(0);
                            }
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Presupuesto_produccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_buscaar_items;
    public static javax.swing.JButton btn_cargar_pedidos;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btnven;
    private javax.swing.JComboBox cb_prioridad;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_ini;
    public static javax.swing.JLabel lbl_cod;
    private javax.swing.JTextField lbl_fecha_VISOR;
    public static javax.swing.JTable tb_prod_pedi;
    public static javax.swing.JTextField txt_cli_nom;
    public static javax.swing.JTextField txt_cod_cli;
    private javax.swing.JTextField txt_des_prod;
    private javax.swing.JTextField txt_nro_op;
    public static javax.swing.JTextField txt_nro_pedido;
    private javax.swing.JTextField txt_usu_ventas;
    // End of variables declaration//GEN-END:variables

    void ticket() {
        codigos();
        String InsertarSQL = "INSERT INTO produccions (num_prod,cod_cli_prod,nom_cli_prods,estado_prod,priori_prod,nro_op_prod,descrip_prod,fecha_prod,user_prod,nro_pedido,fecha_entre) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String numbol = lbl_cod.getText();
        String cod_cli = txt_cod_cli.getText();
        String nom_cli = txt_cli_nom.getText();//cambiar en db
        String estado_prod = ("EN PROCESO");
        String prioridad = cb_prioridad.getSelectedItem().toString();
        String nro_op = txt_nro_op.getText();
        String descrip = txt_des_prod.getText();
        String fecha = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String pedido = txt_nro_pedido.getText();
        java.sql.Date date = new java.sql.Date(jd_ini.getDate().getTime());
        String fecha_data = String.valueOf(date);
        System.out.println(fecha_data);

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, cod_cli);
            pst.setString(3, nom_cli);
            pst.setString(4, estado_prod);
            pst.setString(5, prioridad);
            pst.setString(6, nro_op);
            pst.setString(7, descrip);
            pst.setString(8, fecha);
            pst.setString(9, user);
            pst.setString(10, pedido);
            pst.setString(11, fecha_data);
            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                detalle_ticket();
                actEstadoVentas();
                JOptionPane.showMessageDialog(null, "Nota realizada con éxito");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Presupuesto_produccion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void detalle_ticket() {
        for (int i = 0; i < tb_prod_pedi.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO produccions_detalles (num_prod,num_prod_op,cod_prod,des_prod,fecha_prod) VALUES (?,?,?,?,?)";
            String id_prod = lbl_cod.getText();
            String nro_serie_pro = txt_nro_op.getText() + txt_nro_pedido.getText();
            String codpro = tb_prod_pedi.getValueAt(i, 0).toString();
            String despro = tb_prod_pedi.getValueAt(i, 1).toString();
            String fecha_det_prod = lbl_fecha_hoy.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, id_prod);
                pst.setString(2, nro_serie_pro);
                pst.setString(3, codpro);
                pst.setString(4, despro);
                pst.setString(5, fecha_det_prod);

                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(Presupuesto_produccion.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    public static String fechaactS() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }

    void codigos() {

        String c = "";
        String SQL = "select max(num_prod) from produccions";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                lbl_cod.setText("0000001");
            } else {
                int j = Integer.parseInt(c);
                if (Principal.txt_dir_backup.getText().equals("1")) {
                    GenerarNumero gen = new GenerarNumero();
                    gen.generar(j);
                    lbl_cod.setText(gen.serie());

                } else {
                    Generar_Num_Pro gen = new Generar_Num_Pro();
                    gen.generar(j);
                    lbl_cod.setText(gen.serie());
                }
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Presupuesto_produccion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTxt() {
        String ped_id = txt_nro_pedido.getText();
        String mostrar = "SELECT cod_provee,nom_provee,vac_ventas FROM pedidos WHERE  num_pedi='" + ped_id + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_cod_cli.setText(rs.getString(1));
                txt_cli_nom.setText(rs.getString(2));
                txt_nro_op.setText(rs.getString(3));
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_produccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar_detalle() {
        String ped_id = txt_nro_pedido.getText();

        String mostrar = "SELECT * FROM pedidos_detalles WHERE  num_pedi='" + ped_id + "'";
        String[] titulos = {"Id Producto", "Descripción"};
        String[] Registros = new String[7];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString(2);
                Registros[1] = rs.getString(3);

                model.addRow(Registros);
            }
            tb_prod_pedi.setModel(model);

            tb_prod_pedi.getColumnModel().getColumn(0).setPreferredWidth(120);
            tb_prod_pedi.getColumnModel().getColumn(1).setPreferredWidth(520);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_produccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void actEstadoVentas() {

        try {

            String esta = ("Produccion");
            String nro = txt_nro_pedido.getText();

            String sql = "UPDATE pedidos SET estado_pedi = '" + esta
                    + "' WHERE num_pedi = '" + nro + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                //  JOptionPane.showMessageDialog(null, "Actualizado");
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

}
