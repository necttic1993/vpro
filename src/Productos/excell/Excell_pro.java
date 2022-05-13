/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.excell;

import Clases.Stock_minimo;
import Clases.Stock_minimo_pro;
import Conexion_DB.conectar;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Excell_pro extends javax.swing.JDialog {

    DefaultTableModel model;

    public Excell_pro(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);

        initComponents();
        cargarUsu();

        txt_bus.requestFocus();

        lbl_stock_minimo.setVisible(false);
 
            cargar("");

     

    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_pro_gral = "";

    private class hilo implements Runnable {

        @Override
        public void run() {
            while (true) {
                btnExportar.doClick();

                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Excell_pro.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }

    }

    ModeloExcel modeloE = new ModeloExcel();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion = 0;

    public void AgregarFiltro() {
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_stock_minimo = new javax.swing.JLabel();
        lbl_select_alma = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");
        setMinimumSize(new java.awt.Dimension(1205, 580));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1208, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbProductos.setGridColor(new java.awt.Color(0, 153, 153));
        tbProductos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProductosKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbProductos);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1240, 530));

        btnImportar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        btnImportar.setMnemonic('a');
        btnImportar.setText("Importar");
        btnImportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportar.setFocusable(false);
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 130, 40));

        btnExportar.setBackground(new java.awt.Color(255, 255, 255));
        btnExportar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.setToolTipText("Actualizar  stock");
        btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportar.setFocusable(false);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 130, 40));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 16, 490, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 550, 32));

        lbl_stock_minimo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel1.add(lbl_stock_minimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 70, 30));

        lbl_select_alma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_select_alma.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_select_alma, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 170, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Stock referente N°:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 590, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked

    }//GEN-LAST:event_tbProductosMouseClicked

    private void tbProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyReleased
        //   scanner();

    }//GEN-LAST:event_tbProductosKeyReleased

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
        }
        if (Tecla == KeyEvent.VK_SPACE) {
            int filaMod = Excell_pro.tbProductos.getSelectedRow();
            cod_pro = (String) Excell_pro.tbProductos.getValueAt(filaMod, 0);

        }
        if (Tecla == KeyEvent.VK_ENTER) {
            int filaMod = Excell_pro.tbProductos.getSelectedRow();
            cod_pro_gral = (String) Excell_pro.tbProductos.getValueAt(filaMod, 0);

        }

    }//GEN-LAST:event_tbProductosKeyPressed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed

        if (selecArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, tbProductos) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }

    }//GEN-LAST:event_btnExportarActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }


    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        if (lbl_select_alma.getText().equals("TODOS")) {
            cargar(txt_bus.getText());

        }
        if (lbl_select_alma.getText().equals("0000001")) {
            cargar(txt_bus.getText());

        }

    
    }//GEN-LAST:event_txt_busKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        new Thread(new hilo()).start();
    }//GEN-LAST:event_formWindowOpened

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        contAccion++;
        if (contAccion == 1) {
            AgregarFiltro();
        }

        if (selecArchivo.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null,
                        modeloE.Importar(archivo, tbProductos) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1),
                        "IMPORTAR EXCEL", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }

    }//GEN-LAST:event_btnImportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pro();
        JOptionPane.showMessageDialog(null, "Guardado");

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Excell_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Excell_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Excell_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Excell_pro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Excell_pro dialog = new Excell_pro(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btnExportar;
    public static javax.swing.JButton btnImportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_select_alma;
    private javax.swing.JLabel lbl_stock_minimo;
    public static javax.swing.JTable tbProductos;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    // PoolConecction pc = new PoolConecction();
    // java.sql.Connection ct = null;
    void cargar(String valor) {

        try {
            // ct = pc.dataSource.getConnection();
            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificiones", "Cantidad", "Stock Mínimo"};
            String[] registros = new String[6];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE CONCAT (pro_cod,pro_des,pro_cod_barra) LIKE '%" + valor + "%' ORDER BY pro_cod DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(22);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 5);
            // tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(2).setCellRenderer(color);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(color);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(83);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(330);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());

        }

    }

   

    void cargarUsu() {

        String user = lbl_usu_nom.getText();
        String mostrar = "select * from usuarios where usu='" + user + "' ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_select_alma.setText(rs.getString(6));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Excell_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void pro() {

        for (int i = 0; i < tbProductos.getRowCount(); i++) {
            String sql = "INSERT INTO tienda_productos (pro_cod,pro_cod_barra,pro_des,pro_depa,pro_cat,pro_pre_costo,pro_pre_a,pro_cant,pro_mini,pro_iva) VALUES (?,?,?,?,?,?,?,?,?,?)";

            String codpro = tbProductos.getValueAt(i, 0).toString();
            String barra = tbProductos.getValueAt(i, 0).toString();
            String despro = tbProductos.getValueAt(i, 1).toString();
            String depar = tbProductos.getValueAt(i, 2).toString();
            String cat = tbProductos.getValueAt(i, 3).toString();
            String costo = tbProductos.getValueAt(i, 4).toString();
            String pre_venta = tbProductos.getValueAt(i, 5).toString();
            String cant = tbProductos.getValueAt(i, 6).toString();
            String mini = tbProductos.getValueAt(i, 7).toString();
            String iva = tbProductos.getValueAt(i, 8).toString();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, codpro);
                pst.setString(2, barra);
                pst.setString(3, despro);
                pst.setString(4, depar);
                pst.setString(5, cat);
                pst.setString(6, costo);
                pst.setString(7, pre_venta);
                pst.setString(8, cant);
                pst.setString(9, mini);
                pst.setString(10, iva);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                //  Logger.getLogger(Excell_pro.class
                // .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
