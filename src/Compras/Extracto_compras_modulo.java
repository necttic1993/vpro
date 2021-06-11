//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Compras;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Administrativo.*;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.lbl_usu_nom;

import java.awt.Color;
import java.io.FileInputStream;
import java.math.BigDecimal;
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
//</editor-fold>

public class Extracto_compras_modulo extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Extracto_compras_modulo(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // cargarIN();
        txt_total_gs.setDisabledTextColor(Color.black);
        cargarCli();
   

    }// FIN CONSTRUCTOR
    //</editor-fold>
    public static String cod_ventas = "";

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    void cargarCli() {
        String mostrar = "SELECT * FROM tienda_proveedores  ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_provee.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Extracto_compras_modulo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void limpiar() {

        txt_total_gs.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_compras.getModel();
        int a = tb_compras.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_compras = new javax.swing.JTable();
        txt_total_gs = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jd_fin_lucro = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro = new org.jdesktop.swingx.JXDatePicker();
        cb_provee = new org.jdesktop.swingx.JXComboBox();
        cb_proceso = new org.jdesktop.swingx.JXComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Extratos de Compras");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_compras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_compras.setGridColor(new java.awt.Color(0, 204, 255));
        tb_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_comprasMouseClicked(evt);
            }
        });
        tb_compras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_comprasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_compras);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1030, 360));

        txt_total_gs.setBackground(new java.awt.Color(240, 240, 240));
        txt_total_gs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_total_gs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total_gs.setEnabled(false);
        txt_total_gs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gsActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 230, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Total :");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 450, 50, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Fecha Final:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 90, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/liste.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 60, 45));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Proveedor:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Proceso:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 70, 30));
        jPanel3.add(jd_fin_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 150, 30));
        jPanel3.add(jd_ini_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 150, 30));

        cb_provee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));
        cb_provee.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_provee, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 400, 30));

        cb_proceso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FINALIZADA", "CONFIRMADA" }));
        cb_proceso.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel3.add(cb_proceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_comprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_comprasMouseClicked
        /*    int filaMod = tb_ventas.getSelectedRow();
         cod_ventas = (String) tb_ventas.getValueAt(filaMod, 0);

         visor_ventas visor;
         visor = new visor_ventas(new javax.swing.JDialog(), true);
         visor.setVisible(true);
         */
    }//GEN-LAST:event_tb_comprasMouseClicked

    private void tb_comprasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_comprasKeyReleased

    }//GEN-LAST:event_tb_comprasKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cb_provee.getSelectedItem().equals("TODOS")) {
            java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
            java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
            String proces = (String) cb_proceso.getSelectedItem();
            cargarTodos(date1, date2, proces);
            txt_total_gs.setText("0");
            calcularGS();
        } else {

            java.sql.Date date1 = new java.sql.Date(jd_ini_lucro.getDate().getTime());
            java.sql.Date date2 = new java.sql.Date(jd_fin_lucro.getDate().getTime());
            String prov = (String) cb_provee.getSelectedItem();
            String proces = (String) cb_proceso.getSelectedItem();
            cargarPlazo(date1, date2, prov, proces);
            txt_total_gs.setText("0");
            calcularGS();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_total_gsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gsActionPerformed
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
            java.util.logging.Logger.getLogger(Extracto_compras_modulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Extracto_compras_modulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Extracto_compras_modulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Extracto_compras_modulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Extracto_compras_modulo dialog = new Extracto_compras_modulo(new javax.swing.JDialog(), true);
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
    private org.jdesktop.swingx.JXComboBox cb_proceso;
    private org.jdesktop.swingx.JXComboBox cb_provee;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro;
    public static javax.swing.JTable tb_compras;
    public static javax.swing.JTextField txt_total_gs;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargarPlazo(Date fecha_ini, Date fecha_fin, String prove, String proceso) {
        String mostrar = "SELECT * FROM compras where nom_prov_comp='" + prove + "'  AND estado_comp='" + proceso + "'  AND fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_entrada DESC";
        String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_comp");
                Registros[1] = rs.getString("nom_prov_comp");
                Registros[2] = rs.getString("nro_comp");
                Registros[3] = rs.getString("valor_comp");
                Registros[4] = rs.getString("fecha_entra_comp");
                Registros[5] = rs.getString("user_comp");

                model.addRow(Registros);
            }
            tb_compras.setModel(model);

            tb_compras.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_compras.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_compras.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_compras.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_compras.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_compras.getColumnModel().getColumn(5).setPreferredWidth(193);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Extracto_compras_modulo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTodos(Date fecha_ini, Date fecha_fin, String proceso) {
        String mostrar = "SELECT * FROM compras WHERE   estado_comp='" + proceso + "' AND fecha_entrada BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY fecha_entrada DESC";
        String[] titulos = {"N° Compra", "Proveedor", "Nro de Nota", "Valor Total", "Fecha Entrada", "Usuario"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_comp");
                Registros[1] = rs.getString("nom_prov_comp");
                Registros[2] = rs.getString("nro_comp");
                Registros[3] = rs.getString("valor_comp");
                Registros[4] = rs.getString("fecha_entra_comp");
                Registros[5] = rs.getString("user_comp");

                model.addRow(Registros);
            }
            tb_compras.setModel(model);

            tb_compras.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_compras.getColumnModel().getColumn(1).setPreferredWidth(330);
            tb_compras.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_compras.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_compras.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_compras.getColumnModel().getColumn(5).setPreferredWidth(193);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Extracto_compras_modulo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_compras.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_compras.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_total_gs.setText(subtotal);

        }
    }//FIN METODO

    //</editor-fold>
}//FIN CLASE
