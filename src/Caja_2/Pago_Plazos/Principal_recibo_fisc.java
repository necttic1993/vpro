/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.Pago_Plazos;

import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import Loggin_Principal.Seleccion_fiscal_recibos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author user
 */
public class Principal_recibo_fisc extends javax.swing.JDialog {

    DefaultTableModel model;

    public Principal_recibo_fisc(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        btn_actua_recibo.setVisible(false);
        cargarUsu();
        control_permisos();
        OpcionMenu();
        actualiza();
        txt_bus.requestFocus();

    }

    public static String cod_recibos = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos_pedido = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_almacen_pedidos = new javax.swing.JLabel();
        btn_actua_recibo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECIBOS");
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

        lbl_almacen_pedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_pedidos.setText("0000000");
        lbl_almacen_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_pedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_pedidosMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_almacen_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 110, 40));

        btn_actua_recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actua_reciboActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actua_recibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 70, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 580));

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
            cod_recibos = (String) tbProductos_pedido.getValueAt(filaMod, 0);

            /*   Visor_pedidos visor;
             visor = new Visor_pedidos(new javax.swing.JDialog(), true);
             visor.setVisible(true);*/
        }


    }//GEN-LAST:event_tbProductos_pedidoKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

      

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
  if (lbl_almacen_pedidos.getText().equals("TODOS")) {
            cargar(txt_bus.getText());
        } else {
            cargar_espe(txt_bus.getText());
        }
    }//GEN-LAST:event_txt_busKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // new Thread(new hilo_N()).start();
    }//GEN-LAST:event_formWindowOpened

    private void lbl_almacen_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_pedidosMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_fiscal_recibos evs;
            evs = new Seleccion_fiscal_recibos(new javax.swing.JDialog(), true);
            evs.setVisible(true);

        }
    }//GEN-LAST:event_lbl_almacen_pedidosMouseClicked

    private void btn_actua_reciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actua_reciboActionPerformed
        cargar_espe("");
    }//GEN-LAST:event_btn_actua_reciboActionPerformed

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
            java.util.logging.Logger.getLogger(Principal_recibo_fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_recibo_fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_recibo_fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_recibo_fisc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Principal_recibo_fisc dialog = null;
                try {
                    dialog = new Principal_recibo_fisc(new javax.swing.JDialog(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Principal_recibo_fisc.class.getName()).log(Level.SEVERE, null, ex);
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
    public static javax.swing.JButton btn_actua_recibo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lbl_almacen_pedidos;
    public static javax.swing.JTable tbProductos_pedido;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {
            String almacen = lbl_almacen_pedidos.getText();
            String[] titulos = {"Serie Pago", "Cód. Cliente", "Cliente", "Nro Recibo", "Valor del Importe", "N° Cuenta", "Fecha", "Usuario", "Almacén"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from pago_credito WHERE CONCAT (nro_recibo,nom_cli) LIKE '%" + valor + "%' AND surcusal='" + almacen + "' ORDER BY data_control DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(22);
                registros[4] = rs.getString(11);
                registros[5] = rs.getString(19);
                registros[6] = rs.getString(18);
                registros[7] = rs.getString(20);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos_pedido.setModel(model);

            tbProductos_pedido.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(1).setPreferredWidth(95);
            tbProductos_pedido.getColumnModel().getColumn(2).setPreferredWidth(290);
            tbProductos_pedido.getColumnModel().getColumn(3).setPreferredWidth(110);
            tbProductos_pedido.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbProductos_pedido.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbProductos_pedido.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(7).setPreferredWidth(140);
            tbProductos_pedido.getColumnModel().getColumn(8).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_espe(String valor) {
        try {
            String almacen = lbl_almacen_pedidos.getText();
            String[] titulos = {"Serie Pago", "Cód. Cliente", "Cliente", "Nro Recibo", "Valor del Importe", "N° Cuenta", "Fecha", "Usuario", "Almacén"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from pago_credito WHERE CONCAT (nro_recibo,nom_cli) LIKE '%" + valor + "%' AND surcusal='" + almacen + "' ORDER BY data_control DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(22);
                registros[4] = rs.getString(11);
                registros[5] = rs.getString(19);
                registros[6] = rs.getString(18);
                registros[7] = rs.getString(20);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos_pedido.setModel(model);

            tbProductos_pedido.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(1).setPreferredWidth(95);
            tbProductos_pedido.getColumnModel().getColumn(2).setPreferredWidth(290);
            tbProductos_pedido.getColumnModel().getColumn(3).setPreferredWidth(110);
            tbProductos_pedido.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbProductos_pedido.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbProductos_pedido.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbProductos_pedido.getColumnModel().getColumn(7).setPreferredWidth(140);
            tbProductos_pedido.getColumnModel().getColumn(8).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void listar() {

        int filasel = tbProductos_pedido.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                int filaMod = tbProductos_pedido.getSelectedRow();
                cod_recibos = (String) tbProductos_pedido.getValueAt(filaMod, 0);
///vista_recibos
                Vista_factura_credito visor;
                visor = new Vista_factura_credito(new javax.swing.JDialog(), true);
                visor.setVisible(true);
            }
        } catch (Exception e) {
        }

    }

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();

        JMenuItem menu_modPro = new JMenuItem("Re-Imprimir Nota", new ImageIcon(getClass().getResource("/icon_4/print.png")));
        JMenuItem menu_eliminar_Pro = new JMenuItem("Ver Nota", new ImageIcon(getClass().getResource("/icon_4/histo.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbProductos_pedido.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                if (JOptionPane.showConfirmDialog(rootPane, "Imprimir comprobante, ¿desea continuar?",
                        "Imprimir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    if (Principal_recibo_fisc.lbl_almacen_pedidos.getText().equals("0000001")) {

                        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                        if (printService.length > 0)//si existen impresoras
                        {
                            //se elige la impresora
                            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                            if (impresora != null) //Si se selecciono una impresora
                            {

                                try {

                                    int filaMod = tbProductos_pedido.getSelectedRow();
                                    String nro = (String) tbProductos_pedido.getValueAt(filaMod, 0);
                                    Connection cn = conectar.getInstance().getConnection();

                                    URL in = this.getClass().getResource("/Caja_2/Pago_Plazos/Recibo_principal_factura.jasper");

                                    System.out.println(in);
                                    Map parametro = new HashMap();
                                    parametro.clear();
                                    parametro.put("serienro", nro);
                                    parametro.put("SUBREPORT_DIR", "Caja_2/Pago_Plazos/");
                                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
                                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                                    jrprintServiceExporter.exportReport();
                                    conectar.getInstance().closeConnection(cn);

                                } catch (JRException ex) {

                                } catch (SQLException ex) {
                                    Logger.getLogger(Principal_recibo_fisc.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }

                    if (Principal_recibo_fisc.lbl_almacen_pedidos.getText().equals("0000002")) {

                        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                        if (printService.length > 0)//si existen impresoras
                        {
                            //se elige la impresora
                            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                            if (impresora != null) //Si se selecciono una impresora
                            {

                                try {

                                    int filaMod = tbProductos_pedido.getSelectedRow();
                                    String nro = (String) tbProductos_pedido.getValueAt(filaMod, 0);
                                    Connection cn = conectar.getInstance().getConnection();

                                    URL in = this.getClass().getResource("/Caja_2/Pago_Plazos/recibo_principal.jasper");
                                    Map parametro = new HashMap();
                                    parametro.clear();
                                    parametro.put("serienro", nro);
                                    parametro.put("SUBREPORT_DIR", "Caja_2/Pago_Plazos/");
                                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
                                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                                    jrprintServiceExporter.exportReport();
                                    conectar.getInstance().closeConnection(cn);

                                } catch (JRException ex) {

                                } catch (SQLException ex) {
                                    Logger.getLogger(Principal_recibo_fisc.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            }

        });
        menu_eliminar_Pro.addActionListener((ActionEvent e) -> {

            int filasel = tbProductos_pedido.getSelectedRow();

            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                listar();
            }
        });

        menu_opcion.add(menu_modPro);
        menu_opcion.add(menu_eliminar_Pro);
        tbProductos_pedido.setComponentPopupMenu(menu_opcion);

    }

    void cargarUsu() {

        String user = lbl_usu_nom.getText();
        String mostrar = "select * from usuarios where usu='" + user + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_almacen_pedidos.setText(rs.getString(6));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Principal_recibo_fisc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void control_permisos() {

        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
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
        timer.schedule(tesk, 500, 270000);
    }

}
