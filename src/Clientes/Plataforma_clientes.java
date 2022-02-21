/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Conexion_DB.conectar;
import static Loggin_Principal.Principal.lbl_fecha_principal;
import static Loggin_Principal.Principal.txt_fecha_backup;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import report.Reportes;

/**
 *
 * @author Roberto
 */
public class Plataforma_clientes extends javax.swing.JDialog {

    DefaultTableModel model;

    public Plataforma_clientes(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
        txt_bus.requestFocus();
        OpcionMenu();
        btn_cargar_datos.setVisible(false);
    }

    public static String cod_cliente = "";

    void cargar(String valor) {
        String mostrar = "SELECT * FROM tienda_clientes WHERE CONCAT(cli_cod,cli_nombre,cli_ruc) LIKE '%" + valor + "%'";
        String[] titulos = {"Código", "Nombre", "Razón Social", "RUC", "Contacto", "Dirección", "Status", "Saldo"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            //  cn.commit();
            while (rs.next()) {
                Registros[0] = rs.getString("cli_cod");
                Registros[1] = rs.getString("cli_nombre");
                Registros[2] = rs.getString("cli_razon");
                Registros[3] = rs.getString("cli_ruc");
                Registros[4] = rs.getString("cli_contacto");
                Registros[5] = rs.getString("cli_dir");
                Registros[6] = rs.getString("cli_status");
                Registros[7] = rs.getString("cli_lim_cre");
                model.addRow(Registros);
            }
            tbclientes.setModel(model);
            tbclientes.getColumnModel().getColumn(0).setPreferredWidth(62);
            tbclientes.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbclientes.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbclientes.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbclientes.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbclientes.getColumnModel().getColumn(5).setPreferredWidth(250);
            tbclientes.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbclientes.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Plataforma_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Clientes");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbclientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbclientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.setGridColor(new java.awt.Color(255, 255, 255));
        tbclientes.setRowHeight(18);
        tbclientes.setSelectionBackground(new java.awt.Color(0, 102, 204));
        tbclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbclientesMouseClicked(evt);
            }
        });
        tbclientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbclientesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbclientesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbclientes);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1210, 510));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 130, 50));

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
        jPanel3.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, 320, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/filtros.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 370, 32));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbclientesMouseClicked

    }//GEN-LAST:event_tbclientesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Add_clientes ac;
        ac = new Add_clientes(new javax.swing.JDialog(), true);
        ac.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbclientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbclientesKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
        }
    }//GEN-LAST:event_tbclientesKeyPressed

    private void tbclientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbclientesKeyReleased
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
        }
    }//GEN-LAST:event_tbclientesKeyReleased

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        cargar(txt_bus.getText());
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
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plataforma_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Plataforma_clientes dialog = new Plataforma_clientes(new javax.swing.JDialog(), true);
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbclientes;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();

        JMenuItem menu_modPro = new JMenuItem("Modificar Cliente", new ImageIcon(getClass().getResource("/icon_4/modificar.png")));
        JMenuItem menu_excell = new JMenuItem("Exportar a Excell", new ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png")));
        JMenuItem menu_listar = new JMenuItem("Listado de Clientes", new ImageIcon(getClass().getResource("/icon_4/report.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {
            int filasel = tbclientes.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaMod = tbclientes.getSelectedRow();
                cod_cliente = (String) tbclientes.getValueAt(filaMod, 0);
                Actualiza_clientes ac;
                ac = new Actualiza_clientes(new javax.swing.JDialog(), true);
                ac.setVisible(true);
            }
        });
        menu_excell.addActionListener((ActionEvent e) -> {

            try {
                reporteCli();
            } catch (IOException ex) {
                Logger.getLogger(Plataforma_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        menu_listar.addActionListener((ActionEvent e) -> {

            try {
                Reportes reporte = new Reportes();
                reporte.ReporteClientes();
                this.dispose();
            } catch (JRException | SQLException ex) {
                Logger.getLogger(Plataforma_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        menu_opcion.add(menu_modPro);
        menu_opcion.add(menu_excell);
        menu_opcion.add(menu_listar);
        tbclientes.setComponentPopupMenu(menu_opcion);

    }

    /////////////////////////////////excell/////////////////////////////////////////////////
    public static void reporteCli() throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Clientes");

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
            celdaTitulo.setCellValue("Reporte de Clientes");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));

            String[] cabecera = new String[]{"Código", "Nombre", "RUC/C.I", "Razón Social", "Contacto", "Dirección"};

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
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement ps;
            ResultSet rs;

            int numFilaDatos = 6;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            ps = cn.prepareStatement("SELECT cli_cod, cli_nombre, cli_ruc, cli_razon,cli_contacto,cli_dir FROM tienda_clientes");
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

                /* Cell celdaImporte = filaDatos.createCell(4);
                 celdaImporte.setCellStyle(datosEstilo);
                 celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));*/
                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);

            sheet.setZoom(120);

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Informes\\Reporte_Clientes_" + txt_fecha_backup.getText() + ".xlsx")) {
                book.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Datos guardados en C:Informes");
            conectar.getInstance().closeConnection(cn);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Plataforma_clientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Plataforma_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void rsToTxt() {

        ResultSet rs;
        StringBuffer strBuf = null;
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement stm = cn.createStatement();
            rs = stm.executeQuery("Select * from tienda_clientes");
            strBuf = new StringBuffer();
            FileWriter fw = new FileWriter(new File("D:\\Prueba.txt"));
            String data_row = "";
            while (rs.next()) {
                data_row = "\n";
                data_row += rs.getLong("cli_cod");
                data_row += "," + rs.getString("cli_nombre").trim();
                data_row += "," + rs.getString("cli_razon").trim();
                fw.write(data_row);
            }
            fw.close();
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

}
