//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Ventas.Facturas;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Administrativo.*;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;
//</editor-fold>

public class ventas_fact_list extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public ventas_fact_list(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        txt_total_gs_usu.setDisabledTextColor(Color.black);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_total_gs_usu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txt_nom_cli_fact = new javax.swing.JTextField();
        txt_id_cli = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jd_fin_lucro_usu = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro_usu = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Facturas de Ventas");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_ventas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ventasMouseClicked(evt);
            }
        });
        tb_ventas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_ventasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ventas);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1100, 420));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/liste.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 70, 50));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Fecha Final:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Seleccionar:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 32));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Total :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 50, 30));

        txt_total_gs_usu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_total_gs_usu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs_usu.setEnabled(false);
        txt_total_gs_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gs_usuActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 220, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/print_1.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 70, 50));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        txt_nom_cli_fact.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_nom_cli_fact.setText("TODOS");
        txt_nom_cli_fact.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_fact.setEnabled(false);
        jPanel3.add(txt_nom_cli_fact, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 370, 32));

        txt_id_cli.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_id_cli.setText("0");
        txt_id_cli.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cli.setEnabled(false);
        txt_id_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_cliActionPerformed(evt);
            }
        });
        jPanel3.add(txt_id_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 90, 32));

        btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_buscar.setToolTipText("");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 50, 32));
        jPanel3.add(jd_fin_lucro_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));
        jPanel3.add(jd_ini_lucro_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ventasMouseClicked
        /*int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_ventasMouseClicked

    private void tb_ventasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ventasKeyReleased

    }//GEN-LAST:event_tb_ventasKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String cli = txt_id_cli.getText();
        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_usu.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_usu.getDate().getTime());

        if (txt_id_cli.getText().equals("0")) {
            cargarC(date1, date2);
            calcularGS();
        } else {
            cargar(date1, date2, cli);
            calcularGS();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gs_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gs_usuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gs_usuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txt_id_cli.getText().equals("0")) {

            try {
                Reportes reporte = new Reportes();
                reporte.Listar_ventas();
            } catch (JRException | SQLException ex) {
                Logger.getLogger(ventas_fact_list.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                Reportes reporte = new Reportes();
                reporte.Listar_ventasP();
            } catch (JRException | SQLException ex) {
                Logger.getLogger(ventas_fact_list.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Clientes_fact_list cli_search;
        cli_search = new Clientes_fact_list(new javax.swing.JDialog(), true);
        cli_search.setVisible(true);

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_id_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_cliActionPerformed
    //<editor-fold defaultstate="collapsed" desc="METODOS PRINCIPAL">

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
            java.util.logging.Logger.getLogger(ventas_fact_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas_fact_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas_fact_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas_fact_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventas_fact_list dialog = new ventas_fact_list(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }// FIN METODO PRINCIPAL
    //</editor-fold>   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro_usu;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro_usu;
    public static javax.swing.JTable tb_ventas;
    public static javax.swing.JTextField txt_id_cli;
    public static javax.swing.JTextField txt_nom_cli_fact;
    public static javax.swing.JTextField txt_total_gs_usu;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM factura_ventas WHERE fact_id_cli='" + user + "' AND fact_data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "'";
        String[] titulos = {"ID", "Venta Nro", "Factura Nro", "Timbrado", "Fecha Emisión", "Id Cliente", "Cliente/Razón Social", "Valor Total", "Usuario"};
        String[] registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn =  conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                registros[0] = rs.getString(19);
                registros[1] = rs.getString(1);
                registros[2] = rs.getString(2);
                registros[3] = rs.getString(3);
                registros[4] = rs.getString(4);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(7);
                registros[7] = rs.getString(15);
                registros[8] = rs.getString(18);

                model.addRow(registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(180);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(110);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(8).setPreferredWidth(200);

            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(ventas_fact_list.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM factura_ventas WHERE  fact_data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "'";
        String[] titulos = {"ID", "Venta Nro", "Factura Nro", "Timbrado", "Fecha Emisión", "Id Cliente", "Cliente/Razón Social", "Valor Total", "Usuario"};
        String[] registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn =  conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                registros[0] = rs.getString(19);
                registros[1] = rs.getString(1);
                registros[2] = rs.getString(2);
                registros[3] = rs.getString(3);
                registros[4] = rs.getString(4);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(7);
                registros[7] = rs.getString(15);
                registros[8] = rs.getString(18);

                model.addRow(registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(180);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(110);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(80);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(8).setPreferredWidth(200);

            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(ventas_fact_list.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 7).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs_usu.setText(subtotal);

        }
    }//FIN METODO

    //</editor-fold>
}//FIN CLASE
