/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.fabrica;

import Conexion_DB.conectar;
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
public class Principal_fabrica extends javax.swing.JDialog {

    DefaultTableModel model;

    public Principal_fabrica(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cargar("");

        txt_bus.requestFocus();
        btn_cargar_trans.setVisible(false);
        // OpcionMenu();

    }

    public static String cod_fa_detalle = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_trans = new javax.swing.JTable();
        btn_transfe = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_trans = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produccion");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1240, 510));

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
        jPanel1.add(btn_transfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 120, 45));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 22, 380, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 32));

        btn_cargar_trans.setText("cargar");
        btn_cargar_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_transActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 580));

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
            cod_fa_detalle = (String) tb_trans.getValueAt(filaMod, 0);

            Visor_fabrica visor;
            visor = new Visor_fabrica(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }
    }//GEN-LAST:event_tb_transKeyPressed

    private void btn_transfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transfeActionPerformed
        fabrica_stock fs;
        fs = new fabrica_stock(new javax.swing.JDialog(), true);
        fs.setVisible(true);
    }//GEN-LAST:event_btn_transfeActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

        cargar(txt_bus.getText());


    }//GEN-LAST:event_txt_busKeyReleased

    private void btn_cargar_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_transActionPerformed

        cargar("");

    }//GEN-LAST:event_btn_cargar_transActionPerformed

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
            java.util.logging.Logger.getLogger(Principal_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Principal_fabrica dialog = new Principal_fabrica(new javax.swing.JDialog(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tb_trans;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    public void cargar(String valor) {
        String mostrar = "SELECT * FROM fabrica_stock  WHERE CONCAT (nro_serie,des_fa) LIKE '%" + valor + "%'";
        String[] titulos = {"Nro serie", "Descripción", "Fecha Ingreso", "Usuario", "Id Producto", "Cantidad"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("nro_serie");
                Registros[1] = rs.getString("des_fa");
                Registros[2] = rs.getString("data_vista_fa");
                Registros[3] = rs.getString("user_fa");
                Registros[4] = rs.getString("id_pro_fa");
                Registros[5] = rs.getString("cant_pro_fa");

                model.addRow(Registros);
            }
            tb_trans.setModel(model);

            tb_trans.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_trans.getColumnModel().getColumn(1).setPreferredWidth(320);
            tb_trans.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_trans.getColumnModel().getColumn(3).setPreferredWidth(120);
            tb_trans.getColumnModel().getColumn(4).setPreferredWidth(70);
            tb_trans.getColumnModel().getColumn(5).setPreferredWidth(70);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(fabrica_stock.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();

        JMenuItem menu_modPro = new JMenuItem("Re-Imprimir Nota"
                + "", new ImageIcon(getClass().getResource("/icon_4/print.png")));

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

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("codigo", cod);
                            //parametro.put("total_gs", gs);
                            //  parametro.put("total_rs", rs);
                            Connection cn = conectar.getInstance().getConnection();

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
                            Logger.getLogger(Principal_fabrica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        });

        menu_opcion.add(menu_modPro);
        tb_trans.setComponentPopupMenu(menu_opcion);

    }

}
