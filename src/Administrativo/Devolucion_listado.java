//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import report.Reportes;
//</editor-fold>

public class Devolucion_listado extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Devolucion_listado(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarUsu();
        txt_total_gs.setDisabledTextColor(Color.black);

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    void cargarUsu() {
        String mostrar = "SELECT * FROM tienda_clientes  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_users.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Devolucion_listado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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
        txt_total_gs = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cb_users = new javax.swing.JComboBox();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Devoluciones");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_ventas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 970, 410));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 70, 50));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Fecha Final:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, -1, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Cliente:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Total :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 60, 30));

        txt_total_gs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_total_gs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs.setEnabled(false);
        txt_total_gs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gsActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 180, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 70, 50));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        cb_users.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_users.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));
        jPanel3.add(cb_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 370, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 140, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
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
        String user = (String) cb_users.getSelectedItem();
        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());

        if (cb_users.getSelectedItem().equals("TODOS")) {
            cargarC(date1, date2);
            calcularGS();
        } else {
            cargar(date1, date2, user);
            calcularGS();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ////////////////pendiente/////////////////////////
     /*   if (cb_users.getSelectedItem().equals("TODOS")) {

         try {
         Reportes reporte = new Reportes();
         reporte.Listar_ventas();
         } catch (JRException | SQLException ex) {
         }


         } else {
         try {
         Reportes reporte = new Reportes();
         reporte.Listar_ventasP();
         } catch (JRException | SQLException ex) {
         Logger.getLogger(Devolucion_listado.class.getName()).log(Level.SEVERE, null, ex);
         }

         }*/
        JOptionPane.showMessageDialog(null, "En construcción");
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(Devolucion_listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Devolucion_listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Devolucion_listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Devolucion_listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Devolucion_listado dialog = new Devolucion_listado(new javax.swing.JDialog(), true);
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
    private javax.swing.JComboBox cb_users;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JTable tb_ventas;
    public static javax.swing.JTextField txt_total_gs;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String user) {
        String mostrar = "SELECT * FROM devoluciones WHERE fecha_dev BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' AND nom_cli_dev='" + user + "'";
        String[] titulos = {"Nota N° ", "Cliente", "Nota de venta N°", " Valor Total", "Fecha de Ingreso", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_dev");
                Registros[1] = rs.getString("nom_cli_dev");
                Registros[2] = rs.getString("cod_venta_dev");
                Registros[3] = rs.getString("total_dev");
                Registros[4] = rs.getString("fecha_dev");
                Registros[5] = rs.getString("user_dev");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(130);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(242);
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
        }

    }

    void cargarC(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM devoluciones WHERE  fecha_dev BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' where estado_dev=CONFIRMADA";
        String[] titulos = {"Nota N° ", "Cliente", "Nota de venta N°", " Valor Total", "Fecha de Ingreso", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_dev");
                Registros[1] = rs.getString("nom_cli_dev");
                Registros[2] = rs.getString("cod_venta_dev");
                Registros[3] = rs.getString("total_dev");
                Registros[4] = rs.getString("fecha_dev");
                Registros[5] = rs.getString("user_dev");

                model.addRow(Registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(130);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(242);
            conectar.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Devolucion_listado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs.setText(subtotal);

        }
    }//FIN METODO

    //</editor-fold>
}//FIN CLASE
