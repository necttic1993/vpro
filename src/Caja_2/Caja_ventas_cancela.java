/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2;

import static Caja_2.Caja_caja.txt_alma_caja;
import Clases.ColorearFilas;
import Clases.ColorearTipoPago;
import Conexion_DB.conectar;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Caja_ventas_cancela extends javax.swing.JDialog {

    DefaultTableModel model;

    public Caja_ventas_cancela(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        txt_bus.requestFocus();
        lbl_almacen_ventas.setText(txt_alma_caja.getText());

        if (lbl_almacen_ventas.getText().equals("0000001")) {
            cargar("");
        }
        if (lbl_almacen_ventas.getText().equals("0000002")) {
            cargar_2("");
        }
        if (lbl_almacen_ventas.getText().equals("0000003")) {
            cargar_3("");
        }
        if (lbl_almacen_ventas.getText().equals("0000004")) {
            cargar_4("");
        }
        if (lbl_almacen_ventas.getText().equals("0000005")) {
            cargar_5("");
        }
        if (lbl_almacen_ventas.getText().equals("0000006")) {
            cargar_6("");
        }
        if (lbl_almacen_ventas.getText().equals("0000007")) {
            cargar_7("");
        }
        if (lbl_almacen_ventas.getText().equals("0000008")) {
            cargar_8("");
        }
        if (lbl_almacen_ventas.getText().equals("0000009")) {
            cargar_9("");
        }
        if (lbl_almacen_ventas.getText().equals("0000010")) {
            cargar_10("");
        }
        if (lbl_almacen_ventas.getText().equals("0000011")) {
            cargar_11("");
        }
        if (lbl_almacen_ventas.getText().equals("0000012")) {
            cargar_12("");
        }
        if (lbl_almacen_ventas.getText().equals("0000013")) {
            cargar_13("");
        }
        if (lbl_almacen_ventas.getText().equals("0000014")) {
            cargar_14("");
        }
        if (lbl_almacen_ventas.getText().equals("0000015")) {
            cargar_15("");
        }
        if (lbl_almacen_ventas.getText().equals("0000016")) {
            cargar_16("");
        }
        if (lbl_almacen_ventas.getText().equals("0000017")) {
            cargar_17("");
        }
        if (lbl_almacen_ventas.getText().equals("0000018")) {
            cargar_18("");
        }
        if (lbl_almacen_ventas.getText().equals("0000019")) {
            cargar_19("");
        }
        if (lbl_almacen_ventas.getText().equals("0000020")) {
            cargar_20("");
        }
        if (lbl_almacen_ventas.getText().equals("0000021")) {
            cargar_21("");
        }

        if (lbl_almacen_ventas.getText().equals("0000022")) {
            cargar_22("");
        }

        if (lbl_almacen_ventas.getText().equals("0000023")) {
            cargar_23("");
        }
        if (lbl_almacen_ventas.getText().equals("0000024")) {
            cargar_24("");
        }

        if (lbl_almacen_ventas.getText().equals("0000025")) {
            cargar_25("");
        }
        if (lbl_almacen_ventas.getText().equals("0000026")) {
            cargar_26("");
        }
    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_ventas = "";
    public static String cod_imprimir = "";
    public static String cod_ver_canc = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_almacen_ventas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProductos.setGridColor(new java.awt.Color(0, 102, 204));
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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1220, 510));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busActionPerformed(evt);
            }
        });
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 420, 32));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 35));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        lbl_almacen_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbl_almacen_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        try {

            int fila = tbProductos.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tbProductos.getValueAt(fila, 0).toString();
                String desins = ("CANC. VENTA NOTA N°" + tbProductos.getValueAt(fila, 0).toString());
                String preins = tbProductos.getValueAt(fila, 5).toString();

                Caja_caja.txt_nro_docu.setText(codins);
                Caja_caja.txt_des_caja.setText(desins);
                Caja_caja.lbl_total_gs.setText(preins);
                Caja_caja.btn_calcular.doClick();
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void tbProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyReleased

    }//GEN-LAST:event_tbProductosKeyReleased

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_SPACE) {

            int filaMod = tbProductos.getSelectedRow();
            cod_ver_canc = (String) tbProductos.getValueAt(filaMod, 0);

            Visor_ventas_caja_canc visor;
            visor = new Visor_ventas_caja_canc(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }

        if (Tecla == KeyEvent.VK_ENTER) {
            try {

                int fila = tbProductos.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tbProductos.getValueAt(fila, 0).toString();
                    String desins = ("CANC. VENTA NOTA N°" + tbProductos.getValueAt(fila, 0).toString());
                    String preins = tbProductos.getValueAt(fila, 5).toString();

                    Caja_caja.txt_nro_docu.setText(codins);
                    Caja_caja.txt_des_caja.setText(desins);
                    Caja_caja.lbl_total_gs.setText(preins);
                    Caja_caja.btn_calcular.doClick();
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        if (lbl_almacen_ventas.getText().equals("TODOS") || lbl_almacen_ventas.getText().equals("0000001")) {
            cargar(txt_bus.getText());
        }
        //2
        if (lbl_almacen_ventas.getText().equals("0000002")) {
            cargar_2(txt_bus.getText());
        }
        //16
        if (lbl_almacen_ventas.getText().equals("0000016")) {
            cargar_16(txt_bus.getText());
        }
        //18
        if (lbl_almacen_ventas.getText().equals("0000018")) {
            cargar_18(txt_bus.getText());
        }
        if (lbl_almacen_ventas.getText().equals("0000020")) {
            cargar_20(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000003")) {
            cargar_3(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000004")) {
            cargar_4(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000005")) {
            cargar_5(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000011")) {
            cargar_11(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000015")) {
            cargar_15(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000019")) {
            cargar_19(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000022")) {
            cargar_22(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000023")) {
            cargar_23(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000024")) {
            cargar_24(txt_bus.getText());
        }
    }//GEN-LAST:event_txt_busKeyReleased

    private void txt_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busActionPerformed

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
            java.util.logging.Logger.getLogger(Caja_ventas_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja_ventas_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja_ventas_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja_ventas_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Caja_ventas_cancela dialog = new Caja_ventas_cancela(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_almacen_ventas;
    public static javax.swing.JTable tbProductos;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_2(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_2 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_3(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_3 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_4(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_4 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_5(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_5 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_6(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_6 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_7(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_7 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_8(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_8 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_9(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_9 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_10(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_10 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_11(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_11 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_12(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_12 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_13(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_13 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_14(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_14 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_15(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_15 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_16(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_16 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_17(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_17 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_18(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_18 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_19(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_19 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_20(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_20 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_21(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_21 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_22(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_22 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_23(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_23 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_24(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_24 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_25(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_25 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_26(String valor) {
        try {
            String almacen = lbl_almacen_ventas.getText();

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Forma de Pago", "Días Plazos", "Valor Total", "Estado de Ventas", "Fecha", "Usuario"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_26 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%'  AND estado_ventas = 'CONFIRMADA' AND forma_pag_ventas='CONTADO' AND almacen_ventas='" + almacen + "' ORDER BY num_bol DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(11);
                registros[8] = rs.getString(12);

                model.addRow(registros);
            }
            tbProductos.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tbProductos.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tbProductos.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tbProductos.getColumnModel().getColumn(0).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(1).setPreferredWidth(87);
            tbProductos.getColumnModel().getColumn(2).setPreferredWidth(340);
            tbProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbProductos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbProductos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbProductos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
