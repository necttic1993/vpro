/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.transferencias;

import Clases.Colorear_Transfe;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_alma_transferencia;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
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
public class Principal_transferencia extends javax.swing.JDialog {

    DefaultTableModel model;

    public Principal_transferencia(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_transferencia.setBackground(new java.awt.Color(69, 84, 92));

        }
        cargarUsu();
        control_permisos();
        txt_bus.requestFocus();
        btn_cargar_trans.setVisible(false);
        OpcionMenu();

    }

    public static String cod_trans = "";
    public static String cod_trans_detalle = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_transferencia = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_trans = new javax.swing.JTable();
        btn_transfe = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_trans = new javax.swing.JButton();
        lbl_almacen_transferencia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_ambiente_transfer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRANSFERENCIAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_transferencia.setBackground(new java.awt.Color(255, 255, 255));
        panel_transferencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_trans = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_trans.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_trans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_trans.setGridColor(new java.awt.Color(0, 102, 204));
        tb_trans.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_transMouseClicked(evt);
            }
        });
        tb_trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_transKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_transKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_trans);

        panel_transferencia.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1240, 510));

        btn_transfe.setBackground(new java.awt.Color(255, 255, 255));
        btn_transfe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_transfe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_transfe.setMnemonic('a');
        btn_transfe.setText("Agregar");
        btn_transfe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_transfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transfeActionPerformed(evt);
            }
        });
        panel_transferencia.add(btn_transfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 140, 50));

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
        panel_transferencia.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 22, 380, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_transferencia.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 32));

        btn_cargar_trans.setText("cargar");
        btn_cargar_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_transActionPerformed(evt);
            }
        });
        panel_transferencia.add(btn_cargar_trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, 30));

        lbl_almacen_transferencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_almacen_transferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_transferencia.setText("almacen");
        lbl_almacen_transferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_transferencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_transferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_transferenciaMouseClicked(evt);
            }
        });
        panel_transferencia.add(lbl_almacen_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 130, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Ambiente:");
        panel_transferencia.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 80, 30));

        lbl_ambiente_transfer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        panel_transferencia.add(lbl_ambiente_transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 80, 30));

        getContentPane().add(panel_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_transMouseClicked

    }//GEN-LAST:event_tb_transMouseClicked

    private void tb_transKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_transKeyReleased

    }//GEN-LAST:event_tb_transKeyReleased

    private void tb_transKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_transKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {
            int filaMod = tb_trans.getSelectedRow();
            cod_trans_detalle = (String) tb_trans.getValueAt(filaMod, 0);

            Visor_transferecia visor;
            visor = new Visor_transferecia(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }
    }//GEN-LAST:event_tb_transKeyPressed

    private void btn_transfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transfeActionPerformed
        if (lbl_ambiente_transfer.getText().equals("0")) {
            trans_dep_pro trans;
            trans = new trans_dep_pro(new javax.swing.JDialog(), true);
            trans.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No tiene opción de transferencia");
        }


    }//GEN-LAST:event_btn_transfeActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        if (lbl_ambiente_transfer.getText().equals("0")) {
            cargar(txt_bus.getText());
        } else {
            cargar_espe(txt_bus.getText());
        }


    }//GEN-LAST:event_txt_busKeyReleased

    private void btn_cargar_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_transActionPerformed
        control_permisos();
    }//GEN-LAST:event_btn_cargar_transActionPerformed

    private void lbl_almacen_transferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_transferenciaMouseClicked

        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            Seleccion_alma_transferencia tped;
            tped = new Seleccion_alma_transferencia(new javax.swing.JDialog(), true);
            tped.setVisible(true);
        }
    }//GEN-LAST:event_lbl_almacen_transferenciaMouseClicked

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
            java.util.logging.Logger.getLogger(Principal_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Principal_transferencia dialog = new Principal_transferencia(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_cargar_trans;
    private javax.swing.JButton btn_transfe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lbl_almacen_transferencia;
    public static javax.swing.JLabel lbl_ambiente_transfer;
    private javax.swing.JPanel panel_transferencia;
    public static javax.swing.JTable tb_trans;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Transf.", "Almacén Origen", "Almacém Destino", "Descripción", "Items", "Valor Total", "Fecha", "Situación", "V/T"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from transf_stock WHERE CONCAT (cod_tran,id_alma_des,nom_alma_des) LIKE '%" + valor + "%' ORDER BY cod_tran DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(5);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(7);
                registros[5] = rs.getString(8);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(12);
                registros[8] = rs.getString(13);

                model.addRow(registros);
            }
            tb_trans.setModel(model);

            Colorear_Transfe color = new Colorear_Transfe(7);
            tb_trans.getColumnModel().getColumn(0).setCellRenderer(color);
            tb_trans.getColumnModel().getColumn(2).setCellRenderer(color);

            tb_trans.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_trans.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_trans.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_trans.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_trans.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_trans.getColumnModel().getColumn(5).setPreferredWidth(120);
            tb_trans.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_trans.getColumnModel().getColumn(7).setPreferredWidth(120);
            tb_trans.getColumnModel().getColumn(8).setPreferredWidth(50);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_espe(String valor) {
        try {
            String almacen = lbl_almacen_transferencia.getText();
            String[] titulos = {"Nro Transf.", "Almacén Origen", "Almacém Destino", "Descripción", "Items", "Valor Total", "Fecha", "Situación", "V/T"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from transf_stock WHERE CONCAT (cod_tran) LIKE '%" + valor + "%' AND id_alma_des='" + almacen + "' ORDER BY cod_tran DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(5);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(7);
                registros[5] = rs.getString(8);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(12);
                registros[8] = rs.getString(13);

                model.addRow(registros);
            }
            tb_trans.setModel(model);

            Colorear_Transfe color = new Colorear_Transfe(7);
            tb_trans.getColumnModel().getColumn(0).setCellRenderer(color);
            tb_trans.getColumnModel().getColumn(2).setCellRenderer(color);

            tb_trans.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_trans.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_trans.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_trans.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_trans.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_trans.getColumnModel().getColumn(5).setPreferredWidth(120);
            tb_trans.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_trans.getColumnModel().getColumn(7).setPreferredWidth(120);
            tb_trans.getColumnModel().getColumn(8).setPreferredWidth(50);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();

        JMenuItem menu_modPro = new JMenuItem("Re-Imprimir Nota", new ImageIcon(getClass().getResource("/icon_4/print.png")));
        JMenuItem menu_ver = new JMenuItem("Ver Nota de transferencia", new ImageIcon(getClass().getResource("/icon_4/histo.png")));

        menu_ver.addActionListener((ActionEvent e) -> {
            int filaMod = tb_trans.getSelectedRow();
            cod_trans_detalle = (String) tb_trans.getValueAt(filaMod, 0);

            Visor_transferecia visor;
            visor = new Visor_transferecia(new javax.swing.JDialog(), true);
            visor.setVisible(true);

        });

        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tb_trans.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {

                PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    //se elige la impresora
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                            "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {
                        try {
                            int filaMod = tb_trans.getSelectedRow();
                            String cod = (String) tb_trans.getValueAt(filaMod, 0);
                            Connection cn = conectar.getInstance().getConnection();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("codigo", cod);
                            //parametro.put("total_gs", gs);
                            //  parametro.put("total_rs", rs);

                            URL in = this.getClass().getResource("/Productos/transferencias/trans_imprime.jasper");

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
                            Logger.getLogger(Principal_transferencia.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        });
        menu_opcion.add(menu_ver);
        menu_opcion.add(menu_modPro);
        tb_trans.setComponentPopupMenu(menu_opcion);

    }

    void cargarUsu() {

        String user = Principal.lbl_id_user.getText();
        String mostrar = "select * from usuarios where usu_cod='" + user + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_almacen_transferencia.setText(rs.getString(6));
                lbl_ambiente_transfer.setText(rs.getString(14));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Principal_transferencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void control_permisos() {

        if (lbl_ambiente_transfer.getText().equals("0")) {
            cargar("");

        } else {
            cargar_espe("");
            btn_transfe.setEnabled(false);
        }
    }

}
