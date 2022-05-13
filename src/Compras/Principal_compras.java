/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Clases.ColorearFilas_estaComp;
import Clases.ColorearTipoPago;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Principal_compras extends javax.swing.JDialog {

    DefaultTableModel model;

    public Principal_compras(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
        OpcionMenu();
        txt_bus.requestFocus();

        btn_cargar_datos.setVisible(false);
    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_compras = "";
    public static String cod_compras_ver_plazo = "";

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("COMPRAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCompras = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbCompras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCompras.setGridColor(new java.awt.Color(0, 102, 204));
        tbCompras.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbComprasMouseClicked(evt);
            }
        });
        tbCompras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbComprasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbComprasKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbCompras);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1240, 500));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 130, 50));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 22, 320, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/filtros.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 480, 32));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbComprasMouseClicked

    }//GEN-LAST:event_tbComprasMouseClicked

    private void tbComprasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbComprasKeyReleased

    }//GEN-LAST:event_tbComprasKeyReleased

    private void tbComprasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbComprasKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {

            int filaMod = tbCompras.getSelectedRow();
            cod_compras = (String) tbCompras.getValueAt(filaMod, 0);

            visor_compras visor;
            visor = new visor_compras(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }
        if (Tecla == KeyEvent.VK_SPACE) {
            int filaMod = tbCompras.getSelectedRow();
            String verificar = (String) tbCompras.getValueAt(filaMod, 4);
            String status = ("CONTADO");
            String status_tar = ("TARJETA");
            if (verificar.equals(status) || verificar.equals(status_tar)) {
                JOptionPane.showMessageDialog(null, "Comando solo para ventas a plazo!");
            } else {

                int filaMod_ver = tbCompras.getSelectedRow();
                cod_compras_ver_plazo = (String) tbCompras.getValueAt(filaMod_ver, 0);

                pago_plazo_ver_compras visor_ver_c;
                visor_ver_c = new pago_plazo_ver_compras(new javax.swing.JDialog(), true);
                visor_ver_c.setVisible(true);

            }
        }
    }//GEN-LAST:event_tbComprasKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Compras_compras vv = null;
        try {
            vv = new Compras_compras(new javax.swing.JDialog(), true);
        } catch (IOException ex) {
            Logger.getLogger(Principal_compras.class.getName()).log(Level.SEVERE, null, ex);
        }
        vv.setVisible(true);
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
            java.util.logging.Logger.getLogger(Principal_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal_compras dialog = new Principal_compras(new javax.swing.JDialog(), true);
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
    public static javax.swing.JTable tbCompras;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Compras", "Cód.Proveedor", "Proveedor", "Nro Nota", "Cond. de Pago", "Fecha de Entrada", "Valor Total", "Estado"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
Connection cn =  conectar.getInstance().getConnection();

            String cons = "select * from compras WHERE CONCAT (nom_prov_comp) LIKE '%" + valor + "%' order by cod_comp desc LIMIT 100";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(8);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(10);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tbCompras.setModel(model);

            ColorearFilas_estaComp color = new ColorearFilas_estaComp(7);
            tbCompras.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(4);
            tbCompras.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbCompras.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbCompras.getColumnModel().getColumn(1).setPreferredWidth(105);
            tbCompras.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbCompras.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbCompras.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbCompras.getColumnModel().getColumn(5).setPreferredWidth(120);
            tbCompras.getColumnModel().getColumn(6).setPreferredWidth(107);
            tbCompras.getColumnModel().getColumn(7).setPreferredWidth(120);
conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    void actCompras() {
        int filaselect = tbCompras.getSelectedRow();
        String codigo = (String) tbCompras.getValueAt(filaselect, 0);
        String est = "CONFIRMADA";
        String sql = "UPDATE compras SET estado_comp ='" + est + "' WHERE cod_comp = '" + codigo + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            //JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ValidaLanza(String exp) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String consul = "SELECT * FROM compras WHERE  cod_comp='" + exp + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Nota ya Lanzado N°:" + exp, "Mensaje", JOptionPane.OK_CANCEL_OPTION);

            } else {

            }

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();

        JMenuItem menu_modPro = new JMenuItem("Re-Imprimir Nota", new ImageIcon(getClass().getResource("/icon_4/print.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbCompras.getSelectedRow();
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
                            int filaMod = tbCompras.getSelectedRow();
                            String cod = (String) tbCompras.getValueAt(filaMod, 0);

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("codigo", cod);
                            //parametro.put("total_gs", gs);
                            //  parametro.put("total_rs", rs);
                            Connection cn = conectar.getInstance().getConnection();

                            URL in = this.getClass().getResource("/Compras/impresiones/Nota_compras.jasper");

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
                            Logger.getLogger(Principal_compras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

        });

        menu_opcion.add(menu_modPro);

        tbCompras.setComponentPopupMenu(menu_opcion);

    }
}
