//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Compras.libro_compras;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Ventas.Facturas.*;
import Administrativo.*;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_fecha_principal;
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

public class Libro_compras_lista extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public Libro_compras_lista(javax.swing.JDialog parent, boolean modal) {
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
        jButton3 = new javax.swing.JButton();

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1100, 420));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/liste.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 70, 50));

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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 70, 50));

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

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        jButton3.setToolTipText("Imprimir Listado en Excell");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, -1, 50));

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
                Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                Reportes reporte = new Reportes();
                reporte.Listar_ventasP();
            } catch (JRException | SQLException ex) {
                Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*    if (txt_id_cli.getText().equals("0")) {
         try {
         libro_todos();
         } catch (IOException ex) {
         Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
         }
         } else {
         try {
         libro_clientes();
         } catch (IOException ex) {
         Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
         }
         }*/

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
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
            java.util.logging.Logger.getLogger(Libro_compras_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libro_compras_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libro_compras_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libro_compras_lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Libro_compras_lista dialog = new Libro_compras_lista(new javax.swing.JDialog(), true);
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
            Connection cn = conectar.getInstance().getConnection();

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
            Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarC(Date fecha_ini, Date fecha_fin) {
        String mostrar = "SELECT * FROM factura_ventas WHERE  fact_data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "'";
        String[] titulos = {"ID", "Venta Nro", "Factura Nro", "Timbrado", "Fecha Emisión", "Id Cliente", "Cliente/Razón Social", "Valor Total", "Usuario"};
        String[] registros = new String[10];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

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
            Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
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

    /*  
     public static void  libro_todos() throws IOException {
       
        
     Workbook book = new XSSFWorkbook();
     Sheet sheet = book.createSheet("Libro de Compras");
        
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
     celdaTitulo.setCellValue("Libo de Compras");
            
     sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            
     String[] cabecera = new String[]{"Código", "Código de Barras", "Nombre", "Descripción", "Cantidad", "Departamento"};
            
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
            
     Row filaEncabezados = sheet.createRow(4);
            
     for (int i = 0; i < cabecera.length; i++) {
     Cell celdaEnzabezado = filaEncabezados.createCell(i);
     celdaEnzabezado.setCellStyle(headerStyle);
     celdaEnzabezado.setCellValue(cabecera[i]);
     }
     conectar cc = new conectar();
     Connection cn = cc.conexion();
            
     PreparedStatement ps;
     ResultSet rs;
            
     int numFilaDatos = 6;
            
     CellStyle datosEstilo = book.createCellStyle();
     datosEstilo.setBorderBottom(BorderStyle.THIN);
     datosEstilo.setBorderLeft(BorderStyle.THIN);
     datosEstilo.setBorderRight(BorderStyle.THIN);
     datosEstilo.setBorderBottom(BorderStyle.THIN);
            
     ps = cn.prepareStatement("SELECT pro_cod, pro_cod_barra, pro_des, pro_des_espec,pro_cant,pro_depa FROM tienda_productos WHERE pro_cant <='" + minimo + "' AND pro_depa='" + departa + "' AND pro_cat='" + cate + "'");
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
            
     sheet.setZoom(100);
            
     try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Libro de Ventas" + lbl_fecha.getText() + ".xlsx")) {
     book.write(fileOut);
     }
     JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            
     } catch (FileNotFoundException ex) {
     Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException | SQLException ex) {
     Logger.getLogger(Libro_compras_lista.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     }
    
     public static void  libro_clientes() throws IOException {
      
        
     Workbook book = new XSSFWorkbook();
     Sheet sheet = book.createSheet("Libro de Compras");
        
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
     celdaTitulo.setCellValue("Libro de Compras");
            
     sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            
     String[] cabecera = new String[]{"Código", "Código de Barras", "Nombre", "Descripción", "Cantidad", "Departamento", "T/M"};
            
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
            
     Row filaEncabezados = sheet.createRow(4);
            
     for (int i = 0; i < cabecera.length; i++) {
     Cell celdaEnzabezado = filaEncabezados.createCell(i);
     celdaEnzabezado.setCellStyle(headerStyle);
     celdaEnzabezado.setCellValue(cabecera[i]);
     }
     conectar cc = new conectar();
     Connection cn = cc.conexion();
            
     PreparedStatement ps;
     ResultSet rs;
            
     int numFilaDatos = 7;
            
     CellStyle datosEstilo = book.createCellStyle();
     datosEstilo.setBorderBottom(BorderStyle.THIN);
     datosEstilo.setBorderLeft(BorderStyle.THIN);
     datosEstilo.setBorderRight(BorderStyle.THIN);
     datosEstilo.setBorderBottom(BorderStyle.THIN);
            
     ps = cn.prepareStatement("SELECT pro_cod, pro_cod_barra, pro_des, pro_des_espec,pro_cant,pro_depa,pro_tama FROM tienda_productos WHERE pro_cant <='" + minimo + "' AND pro_depa='" + departa + "' AND pro_cat='" + cate + "'AND pro_tama ='" + tama + "'");
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
            
     sheet.setZoom(100);
            
     try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Libro de Ventas" + lbl_fecha.getText() + ".xlsx")) {
     book.write(fileOut);
     }
     JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            
     } catch (FileNotFoundException ex) {
     Logger.getLogger(libro_compras.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException | SQLException ex) {
     Logger.getLogger(libro_compras.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     }
    
    
     */
}//FIN CLASE
