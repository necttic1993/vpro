/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos;

import Clases.ColorearGastos;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_hoy;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Principapl_gastos extends javax.swing.JDialog {

    DefaultTableModel model;
    long OL;
    FileInputStream fis;

    public Principapl_gastos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
          if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_egresos.setBackground(new java.awt.Color(69, 84, 92));
            
        }
        cargar("");
        OpcionMenu();
        btn_cargar_datos.setVisible(false);
    }
    public static String codPro = "";
    public static String cod_egre_actu = "";
    public static String cod_gastos_actu = "";

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();
        JMenuItem menu_print = new JMenuItem("Imprimir Comprobante", new ImageIcon(getClass().getResource("/icon_4/print.png")));
        JMenuItem menu_modPro = new JMenuItem("Modificar Egreso", new ImageIcon(getClass().getResource("/icon_4/modificar.png")));
        JMenuItem menu_eliminar_Pro = new JMenuItem("Eliminar Egreso", new ImageIcon(getClass().getResource("/icon_4/eliminar.png")));

        menu_print.addActionListener((ActionEvent e) -> {
            int filaModil = tb_gastos.getSelectedRow();
            if (filaModil == -1) {
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
                            int filaMod = tb_gastos.getSelectedRow();
                            String note = (String) tb_gastos.getValueAt(filaMod, 0);
                            Connection cn = conectar.getInstance().getConnection();

                            Map parametro = new HashMap();
                            parametro.clear();
                            parametro.put("codigo", note);
                            //parametro.put("total_gs", gs);
                            //  parametro.put("total_rs", rs);

                            URL in = this.getClass().getResource("/Gastos/print_gastos.jasper");

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
                            Logger.getLogger(Principapl_gastos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

        });
        menu_modPro.addActionListener((ActionEvent e) -> {
            int filaModil = tb_gastos.getSelectedRow();
            if (filaModil == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaMod = tb_gastos.getSelectedRow();
                String note = (String) tb_gastos.getValueAt(filaMod, 6);
                String et = "CONFIRMADA";
                if (et.equals(note)) {
                    JOptionPane.showMessageDialog(null, "Nota ya Confirmada");
                    txtbuscar.requestFocus();
                } else {

                    int filaModi = tb_gastos.getSelectedRow();
                    cod_gastos_actu = (String) tb_gastos.getValueAt(filaModi, 0);
                    Gastos_actualizar rp;
                    rp = new Gastos_actualizar(new javax.swing.JDialog(), true);
                    rp.setVisible(true);
                }
            }

        });

        menu_eliminar_Pro.addActionListener((ActionEvent e) -> {

            int filaMod = tb_gastos.getSelectedRow();
            String note = (String) tb_gastos.getValueAt(filaMod, 6);
            String et = "CONFIRMADA";
            if (filaMod == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                if (et.equals(note)) {
                    JOptionPane.showMessageDialog(null, "Nota ya Confirmada");
                    txtbuscar.requestFocus();
                } else {

                    if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
                            "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        borrarGastos();
                    }

                }

            }
        });
        menu_opcion.add(menu_print);
        menu_opcion.add(menu_modPro);
        menu_opcion.add(menu_eliminar_Pro);
        tb_gastos.setComponentPopupMenu(menu_opcion);

    }

    void cargar(String valor
    ) {
        try {

            String[] titulos = {"Egreso N°", "N° Factura", "N° Timbrado", "Concepto",  "Fecha Entrada", "Monto", "Situación"};
            String[] registros = new String[10];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();
            String cons = "select * from gastos WHERE CONCAT (gas_num,gas_des) LIKE '%" + valor + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(11);
                registros[5] = rs.getString(9);
                registros[6] = rs.getString(10);

                model.addRow(registros);
            }
            tb_gastos.setModel(model);

            ColorearGastos color = new ColorearGastos(6);
            tb_gastos.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_gastos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_gastos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_gastos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_gastos.getColumnModel().getColumn(3).setPreferredWidth(450);
            tb_gastos.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_gastos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_gastos.getColumnModel().getColumn(6).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_egresos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_gastos = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Egresos");
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_egresos.setBackground(new java.awt.Color(255, 255, 255));
        panel_egresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_gastos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_gastos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_gastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_gastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_gastosMouseClicked(evt);
            }
        });
        tb_gastos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_gastosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_gastosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_gastos);

        panel_egresos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1200, 540));

        txtbuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtbuscar.setToolTipText("Buscar Registros");
        txtbuscar.setBorder(null);
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        panel_egresos.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 22, 350, 25));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton3.setText("Agregar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_egresos.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 130, 50));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setText("Listar Egresos");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_egresos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 160, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_egresos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 420, 32));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        panel_egresos.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 30));

        getContentPane().add(panel_egresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_gastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_gastosMouseClicked
        /*        int filaMod = tb_gastos.getSelectedRow();
         cod_egre_actu = (String) tb_gastos.getValueAt(filaMod, 0);

         Gastos_actualizar vg;
         vg = new Gastos_actualizar(new javax.swing.JDialog(), true);
         vg.setVisible(true);*/
    }//GEN-LAST:event_tb_gastosMouseClicked

    private void tb_gastosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_gastosKeyReleased

    }//GEN-LAST:event_tb_gastosKeyReleased

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Gastos_registrar gr;
        gr = new Gastos_registrar(new javax.swing.JDialog(), true);
        gr.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb_gastosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_gastosKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            int filaModi = tb_gastos.getSelectedRow();
            cod_gastos_actu = (String) tb_gastos.getValueAt(filaModi, 0);
            Gastos_ver grp;
            grp = new Gastos_ver(new javax.swing.JDialog(), true);
            grp.setVisible(true);
        }

        /* if (Tecla == KeyEvent.VK_ESCAPE) {
         txtbuscar.requestFocus();

         }*/
    }//GEN-LAST:event_tb_gastosKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Egresoos_consulta ec;
        ec = new Egresoos_consulta(new javax.swing.JDialog(), true);
        ec.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principapl_gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principapl_gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principapl_gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principapl_gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principapl_gastos dialog = new Principapl_gastos(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_egresos;
    public static javax.swing.JTable tb_gastos;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    void actualGastos() {
        int filasel = tb_gastos.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                String nro = (String) tb_gastos.getValueAt(filasel, 0);
                String timbrado = (String) tb_gastos.getValueAt(filasel, 1);
                String fecha_emi = (String) tb_gastos.getValueAt(filasel, 2);
                String concep = (String) tb_gastos.getValueAt(filasel, 3);
                String prov = (String) tb_gastos.getValueAt(filasel, 4);
                String fecha_entra = (String) tb_gastos.getValueAt(filasel, 5);
                String hist = (String) tb_gastos.getValueAt(filasel, 6);
                String monto = (String) tb_gastos.getValueAt(filasel, 7);

                String sql = "UPDATE gastos SET gas_timbra = '" + timbrado
                        + "',gas_fecha_emi ='" + fecha_emi
                        + "',gas_des ='" + concep
                        + "',gas_provee ='" + prov
                        + "',gas_fecha_entra = '" + fecha_entra
                        + "',gas_histo = '" + hist
                        + "',gas_monto ='" + monto
                        + "' WHERE gas_num = '" + nro + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();
                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    JOptionPane.showMessageDialog(null, "Actualizado");
                    cargar("");

                    txtbuscar.requestFocus();
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }

    }

    void borrarGastos() {

        int filasel = tb_gastos.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                Connection cn = conectar.getInstance().getConnection();

                String cod = (String) tb_gastos.getValueAt(filasel, 0);
                String eliminarSQL = "DELETE FROM gastos WHERE gas_id = '" + cod + "'";
                String DetallesSQL = "DELETE FROM gastos_detalles WHERE id_gastos = '" + cod + "'";
                try {
                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                    PreparedStatement pstE = cn.prepareStatement(DetallesSQL);
                    pst.executeUpdate();
                    pstE.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    JOptionPane.showMessageDialog(null, "Borrado");
                    cargar("");

                    txtbuscar.requestFocus();
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }

    }

    void caja() {
        int i = tb_gastos.getSelectedRow();

        String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo) VALUES (?,?,?,?,?,?,?,?,?)";
        String descaja = ("EN CONCEPTO DE GASTOS N°" + tb_gastos.getValueAt(i, 0).toString());
        String total_gs = ("0");
        String his = ("PAGO A PROVEEDORES");
        String egreso_gs = tb_gastos.getValueAt(i, 8).toString();
        String egreso_rs = ("0");
        String fecha_caja = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String moneda = ("Guaraníes");
        String tipo_caja = ("D");
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, descaja);
            pst.setString(2, total_gs);
            pst.setString(3, his);
            pst.setString(4, egreso_gs);
            pst.setString(5, egreso_rs);
            pst.setString(6, fecha_caja);
            pst.setString(7, user);
            pst.setString(8, moneda);
            pst.setString(9, tipo_caja);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Nota Confirmada");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Principapl_gastos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void cajaC() {
        int i = tb_gastos.getSelectedRow();

        String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo) VALUES (?,?,?,?,?,?,?,?,?)";
        String descaja = ("Cancelamiento de Nota N°" + tb_gastos.getValueAt(i, 0).toString());
        String total_gs = tb_gastos.getValueAt(i, 8).toString();
        String his = ("CANC. PAGO A PROVEEDORES");
        String egreso_gs = ("0");
        String egreso_rs = ("0");
        String fecha_caja = lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String moneda = ("Guaraníes");
        String tipo_caja = ("C");
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, descaja);
            pst.setString(2, total_gs);
            pst.setString(3, his);
            pst.setString(4, egreso_gs);
            pst.setString(5, egreso_rs);
            pst.setString(6, fecha_caja);
            pst.setString(7, user);
            pst.setString(8, moneda);
            pst.setString(9, tipo_caja);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Nota Cancelada");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Principapl_gastos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void actCompras() {
        int filaselect = tb_gastos.getSelectedRow();
        String codigo = (String) tb_gastos.getValueAt(filaselect, 0);
        String est = "CONFIRMADA";
        String sql = "UPDATE gastos SET gas_situ ='" + est + "' WHERE gas_id = '" + codigo + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            // JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void actComprasC() {
        int filaselect = tb_gastos.getSelectedRow();
        String codigo = (String) tb_gastos.getValueAt(filaselect, 0);
        String est = "FINALIZADA";
        String sql = "UPDATE gastos SET gas_situ ='" + est + "' WHERE gas_id = '" + codigo + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            // JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
