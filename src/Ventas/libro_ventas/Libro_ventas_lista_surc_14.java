//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Ventas.libro_ventas;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import report.Reportes;
//</editor-fold>

public class Libro_ventas_lista_surc_14 extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Libro_ventas_lista_surc_14(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        panel_precios.setVisible(false);

        txt_valor_iva.setDisabledTextColor(Color.black);

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
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txt_nom_cli_fact = new javax.swing.JTextField();
        txt_id_cli = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jd_fin_lucro_usu = new org.jdesktop.swingx.JXDatePicker();
        jd_ini_lucro_usu = new org.jdesktop.swingx.JXDatePicker();
        jButton3 = new javax.swing.JButton();
        panel_precios = new javax.swing.JPanel();
        txt_exentos = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_seq_cambio = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_valor_libro = new javax.swing.JTextField();
        txt_valor_iva = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Facturas de Ventas");
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1190, 440));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 70, 50));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Seleccionar:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 32));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 70, 50));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha Inicio:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        txt_nom_cli_fact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nom_cli_fact.setText("TODOS");
        txt_nom_cli_fact.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cli_fact.setEnabled(false);
        jPanel3.add(txt_nom_cli_fact, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 370, 32));

        txt_id_cli.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_id_cli.setText("0");
        txt_id_cli.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_cli.setEnabled(false);
        txt_id_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_cliActionPerformed(evt);
            }
        });
        jPanel3.add(txt_id_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 32));

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
        jPanel3.add(jd_fin_lucro_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 120, 30));
        jPanel3.add(jd_ini_lucro_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 130, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        jButton3.setToolTipText("Imprimir Listado en Excell");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, -1, 50));

        panel_precios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_exentos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_exentos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_exentos.setText("0");
        txt_exentos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_exentos.setEnabled(false);
        panel_precios.add(txt_exentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 40, 30));

        jPanel3.add(panel_precios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 300, 40));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 50, 32));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Fecha Final:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 80, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Sequencia:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 70, 30));

        txt_seq_cambio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_seq_cambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_seq_cambioKeyTyped(evt);
            }
        });
        jPanel3.add(txt_seq_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 60, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Total Valor:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, 70, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Total IVA:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 70, 30));

        txt_valor_libro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_libro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_libro.setText("0");
        txt_valor_libro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_libro.setEnabled(false);
        jPanel3.add(txt_valor_libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 530, 150, 30));

        txt_valor_iva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_iva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_iva.setText("0");
        txt_valor_iva.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_iva.setEnabled(false);
        txt_valor_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valor_ivaActionPerformed(evt);
            }
        });
        jPanel3.add(txt_valor_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
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
        String nro_seq = txt_seq_cambio.getText();
        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_usu.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_usu.getDate().getTime());
        if (txt_seq_cambio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione nro de sequencia");
        } else {
            if (txt_id_cli.getText().equals("0")) {
                cargarC(date1, date2, nro_seq);
                calcularGS();
                calculartotal();
                calcularEx();
            } else {
                cargar(date1, date2, cli, nro_seq);
                calcularGS();
                calculartotal();
                calcularEx();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_valor_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valor_ivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valor_ivaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txt_id_cli.getText().equals("0")) {

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Clientes_libro_ventas_14 cli_search;
        cli_search = new Clientes_libro_ventas_14(new javax.swing.JDialog(), true);
        cli_search.setVisible(true);

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_id_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_cliActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     String nro_seq = txt_seq_cambio.getText();
        String cli = txt_id_cli.getText();
        String total = txt_valor_libro.getText();
         String total_iva = txt_valor_iva.getText();
        
        java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_usu.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_usu.getDate().getTime());

        if (txt_id_cli.getText().equals("0")) {
            try {

                libro_todos(date1, date2, nro_seq, total, total_iva);
            } catch (IOException ex) {
                Logger.getLogger(Libro_ventas_lista.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                libro_clientes(date1, date2, cli, nro_seq, total,total_iva);
            } catch (IOException ex) {
                Logger.getLogger(Libro_ventas_lista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txt_id_cli.setText("0");
        txt_nom_cli_fact.setText("TODOS");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_seq_cambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_seq_cambioKeyTyped
        int cant = 3;
        if (txt_seq_cambio.getText().length() >= cant) {
            evt.consume();
        }

    }//GEN-LAST:event_txt_seq_cambioKeyTyped
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
            java.util.logging.Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                Libro_ventas_lista_surc_14 dialog = new Libro_ventas_lista_surc_14(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fin_lucro_usu;
    private org.jdesktop.swingx.JXDatePicker jd_ini_lucro_usu;
    private javax.swing.JPanel panel_precios;
    public static javax.swing.JTable tb_ventas;
    private javax.swing.JTextField txt_exentos;
    public static javax.swing.JTextField txt_id_cli;
    public static javax.swing.JTextField txt_nom_cli_fact;
    private static javax.swing.JTextField txt_seq_cambio;
    public static javax.swing.JTextField txt_valor_iva;
    private javax.swing.JTextField txt_valor_libro;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

    void cargar(Date fecha_ini, Date fecha_fin, String user, String seq) {
        String mostrar = "SELECT v.`cod_cli_ventas` ,v.`data_vista` ,c.`cli_cod` ,c.`cli_ruc` ,c.`cli_razon`,v.`nro_estable_ventas` ,v.`nro_seq_ventas`,v.`nro_fact_ventas` ,v.`total_ventas` ,v.`fact_sub_exe`,v.`total_iva_5`,v.`total_iva_10`,v.`total_iva` ,v.`form_pag_lit` FROM ventas_facturacion_surc_14 as v INNER JOIN   tienda_clientes as c ON  v.`cod_cli_ventas`=c.`cli_cod` WHERE v.fecha_ventas between '" + fecha_ini + "' AND '" + fecha_fin + "' and c.`cli_cod` = '" + user + "' AND v.nro_estable_ventas='" + seq + "' AND estado_fact <> 'ANULADA'";
        String[] titulos = {"Fecha Emisión", "Documento", "Contado/ Crédito", "Razón Social/Nombres", "RUC", "Totales", "IVA 5%", "IVA 10%", "Excentas", "Total IVA"};
        String[] registros = new String[30];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                registros[0] = rs.getString(2);
                registros[1] = rs.getString(7) + "-" + rs.getString(6) + "-" + rs.getString(8);
                registros[2] = rs.getString(14);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(4);
                registros[5] = rs.getString(9);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(12);
                registros[8] = rs.getString(10);
                registros[9] = rs.getString(13);

                model.addRow(registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC(Date fecha_ini, Date fecha_fin, String seq) {
        String mostrar = "SELECT v.`cod_cli_ventas` ,v.`data_vista` ,c.`cli_cod` ,c.`cli_ruc` ,c.`cli_razon`,v.`nro_estable_ventas` ,v.`nro_seq_ventas`,v.`nro_fact_ventas` ,v.`total_ventas` ,v.`fact_sub_exe`,v.`total_iva_5`,v.`total_iva_10`,v.`total_iva` ,v.`form_pag_lit` FROM ventas_facturacion_surc_14 as v INNER JOIN   tienda_clientes as c ON  v.`cod_cli_ventas`=c.`cli_cod` WHERE v.fecha_ventas between '" + fecha_ini + "' AND '" + fecha_fin + "' AND v.nro_estable_ventas='" + seq + "' AND estado_fact <> 'ANULADA'";
        String[] titulos = {"Fecha Emisión", "Documento", "Contado/ Crédito", "Razón Social/Nombres", "RUC", "Totales", "IVA 5%", "IVA 10%", "Excentas", "Total IVA"};
        String[] registros = new String[30];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                registros[0] = rs.getString(2);
                registros[1] = rs.getString(7) + "-" + rs.getString(6) + "-" + rs.getString(8);
                registros[2] = rs.getString(14);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(4);
                registros[5] = rs.getString(9);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(12);
                registros[8] = rs.getString(10);
                registros[9] = rs.getString(13);

                model.addRow(registros);
            }
            tb_ventas.setModel(model);

            tb_ventas.getColumnModel().getColumn(0).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(3).setPreferredWidth(300);
            tb_ventas.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_ventas.getColumnModel().getColumn(5).setPreferredWidth(120);
            tb_ventas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_ventas.getColumnModel().getColumn(9).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 9).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_valor_iva.setText(subtotal);

        }
    }//FIN METODO

    public void calculartotal() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_valor_libro.setText(subtotal);

        }
    }//FIN METODO

    public void calcularEx() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_ventas.getValueAt(i, 8).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_exentos.setText(subtotal);

        }
    }//FIN METODO

    public static void libro_todos(Date fecha_ini, Date fecha_fin, String seq, String total, String iva) throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Libro de Ventas");

        try {
     // InputStream is = new FileInputStream("Iconos_1\\loog_multi.png");
            // byte[] bytes = IOUtils.toByteArray(is);
            // int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            // is.close();

            //  CreationHelper help = book.getCreationHelper();
            // Drawing draw = sheet.createDrawingPatriarch();
            // ClientAnchor anchor = help.createClientAnchor();
            //anchor.setCol1(0);
            // anchor.setRow1(1);
            // Picture pict = draw.createPicture(anchor, imgIndex);
            // pict.resize(1, 3);
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 12);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Libo de Ventas");

            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));

            String[] cabecera = new String[]{"Fecha Emisión", "Documento", "Contado/ Crédito", "Razón Social/Nombres", "RUC", "Totales", "IVA 5%", "IVA 10%", "Exentas", "Total IVA"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 10);
            headerStyle.setFont(font);
            
                   //estilo total
            CellStyle totalEstilo = book.createCellStyle();
            totalEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotal = book.createFont();
            fuenteTotal.setFontName("Arial");
            fuenteTotal.setBold(true);
            fuenteTotal.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotal.setFontHeightInPoints((short) 10);
            totalEstilo.setFont(fuenteTotal);

            
              //estilo total iva
            CellStyle totalIvaEstilo = book.createCellStyle();
            totalIvaEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalIvaEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalIvaEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalIvaEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotalIva = book.createFont();
            fuenteTotalIva.setFontName("Arial");
            fuenteTotalIva.setBold(true);
            fuenteTotalIva.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotalIva.setFontHeightInPoints((short) 10);
            totalIvaEstilo.setFont(fuenteTotalIva);
            

            Row filaEncabezados = sheet.createRow(3);  //desde donde empieza los titulos

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement ps;
            ResultSet rs;

            int numFilaDatos = 4; //desde donde empiezan los datos

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            Connection cn = conectar.getInstance().getConnection();

            ps = cn.prepareStatement("SELECT v.`data_vista`,v.`nro_fact_ventas` ,v.`form_pag_lit`  ,c.`cli_razon`,c.`cli_ruc`  ,v.`total_ventas` ,v.`total_iva_5`,v.`total_iva_10`,v.`fact_sub_exe`,v.`total_iva`  FROM ventas_facturacion_surc_14 as v INNER JOIN   tienda_clientes as c ON  v.`cod_cli_ventas`=c.`cli_cod` WHERE v.fecha_ventas between '" + fecha_ini + "' AND '" + fecha_fin + "' AND v.nro_estable_ventas='" + seq + "' AND estado_fact <> 'ANULADA'");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            
            Row totales = sheet.createRow(numFilaDatos + 1);
            Cell celdaTotal = totales.createCell(7);
            celdaTotal.setCellStyle(totalEstilo);
            celdaTotal.setCellValue("Total Valor: " + total);
            
            Row totales_iva = sheet.createRow(numFilaDatos + 2);
            Cell celdaTotalIva = totales_iva.createCell(7);
            celdaTotalIva.setCellStyle(totalIvaEstilo);
            celdaTotalIva.setCellValue("Total IVA: " + iva);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Libro de Ventas Nro 14 con seq nro " + txt_seq_cambio.getText() + " en fecha" + Principal.txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void libro_clientes(Date fecha_ini, Date fecha_fin, String cli, String seq, String total, String iva) throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Libro de Ventas");

        try {
     // InputStream is = new FileInputStream("Iconos_1\\loog_multi.png");
            // byte[] bytes = IOUtils.toByteArray(is);
            // int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            // is.close();

            //  CreationHelper help = book.getCreationHelper();
            // Drawing draw = sheet.createDrawingPatriarch();
            // ClientAnchor anchor = help.createClientAnchor();
            //anchor.setCol1(0);
            // anchor.setRow1(1);
            // Picture pict = draw.createPicture(anchor, imgIndex);
            // pict.resize(1, 3);
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 12);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Libo de Ventas");
            
                   //estilo total
            CellStyle totalEstilo = book.createCellStyle();
            totalEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotal = book.createFont();
            fuenteTotal.setFontName("Arial");
            fuenteTotal.setBold(true);
            fuenteTotal.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotal.setFontHeightInPoints((short) 10);
            totalEstilo.setFont(fuenteTotal);

            
              //estilo total iva
            CellStyle totalIvaEstilo = book.createCellStyle();
            totalIvaEstilo.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            totalIvaEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            totalIvaEstilo.setAlignment(HorizontalAlignment.LEFT);
            totalIvaEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTotalIva = book.createFont();
            fuenteTotalIva.setFontName("Arial");
            fuenteTotalIva.setBold(true);
            fuenteTotalIva.setColor(IndexedColors.BLACK.getIndex());
            fuenteTotalIva.setFontHeightInPoints((short) 10);
            totalIvaEstilo.setFont(fuenteTotalIva);
            

            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));

            String[] cabecera = new String[]{"Fecha Emisión", "Documento", "Contado/ Crédito", "Razón Social/Nombres", "RUC", "Totales", "IVA 5%", "IVA 10%", "Exentas", "Total IVA"};

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 10);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(3);  //desde donde empieza los titulos

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement ps;
            ResultSet rs;

            int numFilaDatos = 4; //desde donde empiezan los datos

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            Connection cn = conectar.getInstance().getConnection();

            ps = cn.prepareStatement("SELECT v.`data_vista`,v.`nro_fact_ventas` ,v.`form_pag_lit`  ,c.`cli_razon`,c.`cli_ruc`  ,v.`total_ventas` ,v.`total_iva_5`,v.`total_iva_10`,v.`fact_sub_exe`,v.`total_iva` FROM ventas_facturacion_surc_14 as v INNER JOIN   tienda_clientes as c ON  v.`cod_cli_ventas`=c.`cli_cod` WHERE v.fecha_ventas between '" + fecha_ini + "' AND '" + fecha_fin + "' and c.`cli_cod` = '" + cli + "' AND v.nro_estable_ventas='" + seq + "' AND estado_fact <> 'ANULADA'");
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            Row totales = sheet.createRow(numFilaDatos + 1);
            Cell celdaTotal = totales.createCell(7);
            celdaTotal.setCellStyle(totalEstilo);
            celdaTotal.setCellValue("Total Valor: " + total);
            
            Row totales_iva = sheet.createRow(numFilaDatos + 2);
            Cell celdaTotalIva = totales_iva.createCell(7);
            celdaTotalIva.setCellStyle(totalIvaEstilo);
            celdaTotalIva.setCellValue("Total IVA: " + iva);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Libro de Ventas Nro 14 con seq nro" + txt_seq_cambio.getText() + " en fecha" + Principal.txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Libro_ventas_lista_surc_14.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}//FIN CLASE
