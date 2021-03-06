/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticas_productos;

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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

public class extracto_compras_productos extends javax.swing.JDialog {

    DefaultTableModel model;
    private static DefaultTableCellRenderer tcr;

    public extracto_compras_productos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_razon_pro.setBackground(new java.awt.Color(69, 84, 92));

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_razon_pro = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_control = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_cant_pro = new javax.swing.JTextField();
        jd_fin = new org.jdesktop.swingx.JXDatePicker();
        jd_ini = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ch_suma_stock = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_valor_pro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Raz??n del Producto en Compras");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_razon_pro.setBackground(new java.awt.Color(255, 255, 255));
        panel_razon_pro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/busqueda.png"))); // NOI18N
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panel_razon_pro.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 60, 40));

        tb_control.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_control.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_control.setShowHorizontalLines(false);
        tb_control.setShowVerticalLines(false);
        tb_control.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_controlMouseClicked(evt);
            }
        });
        tb_control.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_controlKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tb_control);

        panel_razon_pro.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1120, 490));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Fecha Final:");
        panel_razon_pro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 80, 30));

        txt_cant_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cant_pro.setText("0");
        txt_cant_pro.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_cant_pro.setEnabled(false);
        panel_razon_pro.add(txt_cant_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 110, 30));
        panel_razon_pro.add(jd_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 140, 30));
        panel_razon_pro.add(jd_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 140, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad:");
        panel_razon_pro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, 70, 30));

        jPanel6.setBackground(new java.awt.Color(204, 0, 51));

        ch_suma_stock.setBackground(new java.awt.Color(204, 0, 51));
        ch_suma_stock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ch_suma_stock.setForeground(new java.awt.Color(255, 255, 255));
        ch_suma_stock.setText("Suma total del producto");
        ch_suma_stock.setContentAreaFilled(false);
        jPanel6.add(ch_suma_stock);

        panel_razon_pro.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 220, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Fecha Inicio:");
        panel_razon_pro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        jButton2.setToolTipText("Imprimir Listado en Excell");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_razon_pro.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 60, 40));

        txt_valor_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_pro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valor_pro.setText("0");
        txt_valor_pro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_pro.setEnabled(false);
        panel_razon_pro.add(txt_valor_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 150, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Total Valor:");
        panel_razon_pro.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 70, 30));

        getContentPane().add(panel_razon_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) tb_control.getModel();
        int a = tb_control.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
        txt_cant_pro.setText("0");
        txt_valor_pro.setText("0");

        java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
        java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());

        cargarCompras(date1, date2);
        calcularcantida();
        calcularGS();

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tb_controlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_controlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_controlMouseClicked

    private void tb_controlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_controlKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_controlKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            java.sql.Date date1 = new java.sql.Date(jd_ini.getDate().getTime());
            java.sql.Date date2 = new java.sql.Date(jd_fin.getDate().getTime());
            String total_items = txt_cant_pro.getText();
            String total = txt_valor_pro.getText();
            if (ch_suma_stock.isSelected()) {
                libro_compras_pro_group(date1, date2, total, total_items);
            } else {
                libro_compras_pro(date1, date2, total, total_items);
                
            }

            
        } catch (IOException ex) {
            Logger.getLogger(extracto_compras_productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(extracto_compras_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(extracto_compras_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(extracto_compras_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(extracto_compras_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                extracto_compras_productos dialog = new extracto_compras_productos(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_buscar;
    private javax.swing.JCheckBox ch_suma_stock;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jd_fin;
    private org.jdesktop.swingx.JXDatePicker jd_ini;
    private javax.swing.JPanel panel_razon_pro;
    public static javax.swing.JTable tb_control;
    private javax.swing.JTextField txt_cant_pro;
    private javax.swing.JTextField txt_valor_pro;
    // End of variables declaration//GEN-END:variables

    void cargarCompras(Date fecha_ini, Date fecha_fin) {

        if (ch_suma_stock.isSelected()) {
            String mostrar = "SELECT c.cod_pro,c.des_pro, c.cod_comp, sum(c.cant_pro), sum(REPLACE(c.pre_unit,',','')), sum(REPLACE(c.pre_venta,',','')),c.data FROM compras_detalles AS c WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' group by c.cod_pro ORDER BY c.cod_pro ASC ";
            String[] titulos = {"Id Producto", "Descripcion", "N?? Compras", "Cantidad", "Precio unitario", "Subtotal", "Fecha Entrada"};
            String[] Registros = new String[13];
            model = new DefaultTableModel(null, titulos);

            try {
                Connection cn = conectar.getInstance().getConnection();

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(mostrar);
                while (rs.next()) {
                    Registros[0] = rs.getString(1);
                    Registros[1] = rs.getString(2);
                    Registros[2] = ("0");
                    Registros[3] = rs.getString(4);
                    Registros[4] = ("0");
                    Registros[5] = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(rs.getString(6));
                    Registros[6] = "00/00/0000";

                    model.addRow(Registros);
                }
                tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.CENTER);
                tb_control.setModel(model);
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(extracto_compras_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String mostrar = "SELECT c.cod_pro,c.des_pro, c.cod_comp, c.cant_pro, c.pre_unit, c.pre_venta, c.data FROM compras_detalles AS c WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY c.cod_pro ASC";
            String[] titulos = {"Id Producto", "Descripcion", "N?? Compras", "Cantidad", "Precio Compras", "Subtotal", "Fecha Entrada"};
            String[] Registros = new String[13];
            model = new DefaultTableModel(null, titulos);

            try {
                Connection cn = conectar.getInstance().getConnection();

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(mostrar);
                while (rs.next()) {
                    Registros[0] = rs.getString(1);
                    Registros[1] = rs.getString(2);
                    Registros[2] = rs.getString(3);
                    Registros[3] = rs.getString(4);
                    Registros[4] = rs.getString(5);
                    Registros[5] = rs.getString(6);
                    Registros[6] = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(7));
                    model.addRow(Registros);
                }
                tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.CENTER);
                tb_control.setModel(model);
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(extracto_compras_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_control.getRowCount();
        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(tb_control.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        //   lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));

    }

    public String MaskaraPrecioUnitarioEnteros(String ValorGuaranies) {
        DecimalFormat format = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String a = ValorViejo.replace(",", "");
        NumeroIntacto = Long.valueOf(a);
        NroFormatado = format.format(NumeroIntacto);
        String LuzParaMisOjos = NroFormatado;
        return LuzParaMisOjos;
    }

    public void calcularcantida() {

        String impt = "0", subtotalt = "0";

        for (int i = 0; i < tb_control.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_control.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            impt = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalt = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalt).add(ingreso.TransformReales(impt)).toString());

            txt_cant_pro.setText(subtotalt);
        }

    }//FIN METODO

    public void calcularGS() {

        String imp = "0", subtotal = "0", total = "0";

        for (int i = 0; i < tb_control.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_control.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            txt_valor_pro.setText(subtotal);

        }
    }//FIN METODO

    public static void libro_compras_pro(Date fecha_ini, Date fecha_fin, String total, String items) throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Listado de Productos en compras");

        try {

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

            ///titulo
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
            celdaTitulo.setCellValue("Listado de Productos en compras");

            //////
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));

            String[] cabecera = new String[]{"Id Producto", "Nombre del prodcuto", "N?? Compras", "Cantidad", "Precio Compras", "Subtotal"};

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

            ps = cn.prepareStatement("SELECT c.cod_pro,c.des_pro, c.cod_comp, c.cant_pro, c.pre_unit, c.pre_venta FROM compras_detalles AS c WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' ORDER BY c.cod_pro ASC");
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

            Row totales = sheet.createRow(numFilaDatos + 1);
            Cell celdaTotal = totales.createCell(4);
            celdaTotal.setCellStyle(totalEstilo);
            celdaTotal.setCellValue("Total Valor: " + total);

            Row totales_iva = sheet.createRow(numFilaDatos + 2);
            Cell celdaTotalIva = totales_iva.createCell(4);
            celdaTotalIva.setCellStyle(totalIvaEstilo);
            celdaTotalIva.setCellValue("Total de cantidades: " + items);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Listado de Productos en compras " + " en fecha" + Principal.txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(extracto_compras_productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "El archivo esta abierto en otra anterior");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(extracto_compras_productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la conexion con el servidor");
        }

    }
    
     public static void libro_compras_pro_group(Date fecha_ini, Date fecha_fin, String total, String items) throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Listado de Productos en compras");

        try {

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

            ///titulo
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
            celdaTitulo.setCellValue("Listado de Productos en compras");

            //////
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));

            String[] cabecera = new String[]{"Id Producto", "Nombre del prodcuto", "N?? Compras", "Cantidad", "Precio Compras", "Subtotal"};

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

            ps = cn.prepareStatement("SELECT c.cod_pro,c.des_pro, c.cod_comp, sum(c.cant_pro), c.pre_unit, sum(REPLACE(c.pre_venta,',','')) FROM compras_detalles AS c WHERE  c.data BETWEEN '" + fecha_ini + "' AND '" + fecha_fin + "' group by c.cod_pro ORDER BY c.cod_pro ASC ");
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

            Row totales = sheet.createRow(numFilaDatos + 1);
            Cell celdaTotal = totales.createCell(4);
            celdaTotal.setCellStyle(totalEstilo);
            celdaTotal.setCellValue("Total Valor: " + total);

            Row totales_iva = sheet.createRow(numFilaDatos + 2);
            Cell celdaTotalIva = totales_iva.createCell(4);
            celdaTotalIva.setCellStyle(totalIvaEstilo);
            celdaTotalIva.setCellValue("Total de cantidades: " + items);

            sheet.setZoom(100);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Listado de Productos en compras " + " en fecha" + Principal.txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(extracto_compras_productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "El archivo esta abierto en otra anterior");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(extracto_compras_productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la conexion con el servidor");
        }

    }
}
