/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.Pago_Plazos;

import static Caja_2.Caja_caja.txt_alma_caja;
import static Caja_2.Pago_Plazos.Agregar_nota_credito.cod_cli_cre;
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
public class Lista_devolucion_fis extends javax.swing.JDialog {

    DefaultTableModel model;

    public Lista_devolucion_fis(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbl_id_cli.setText(cod_cli_cre);
        if (txt_alma_caja.getText().equals("0000001")) {
            cargar("");
        }
        if (txt_alma_caja.getText().equals("0000002")) {
            cargar_2("");
        }

        if (txt_alma_caja.getText().equals("0000003")) {
            cargar_3("");
        }
        if (txt_alma_caja.getText().equals("0000004")) {
            cargar_4("");
        }
        if (txt_alma_caja.getText().equals("0000005")) {
            cargar_5("");
        }
        if (txt_alma_caja.getText().equals("0000006")) {
            cargar_6("");
        }
        if (txt_alma_caja.getText().equals("0000007")) {
            cargar_7("");
        }
        if (txt_alma_caja.getText().equals("0000008")) {
            cargar_8("");
        }
        if (txt_alma_caja.getText().equals("0000009")) {
            cargar_9("");
        }
        if (txt_alma_caja.getText().equals("0000010")) {
            cargar_10("");
        }
        if (txt_alma_caja.getText().equals("0000011")) {
            cargar_11("");
        }
        if (txt_alma_caja.getText().equals("0000012")) {
            cargar_12("");
        }
        if (txt_alma_caja.getText().equals("0000013")) {
            cargar_13("");
        }
        if (txt_alma_caja.getText().equals("0000014")) {
            cargar_14("");
        }
        if (txt_alma_caja.getText().equals("0000015")) {
            cargar_15("");
        }
        if (txt_alma_caja.getText().equals("0000016")) {
            cargar_16("");
        }
        if (txt_alma_caja.getText().equals("0000017")) {
            cargar_17("");
        }
        if (txt_alma_caja.getText().equals("0000018")) {
            cargar_18("");
        }
        if (txt_alma_caja.getText().equals("0000019")) {
            cargar_19("");
        }
        if (txt_alma_caja.getText().equals("0000020")) {
            cargar_20("");
        }
        if (txt_alma_caja.getText().equals("0000021")) {
            cargar_21("");
        }
        if (txt_alma_caja.getText().equals("0000022")) {
            cargar_22("");
        }
        if (txt_alma_caja.getText().equals("0000023")) {
            cargar_23("");
        }
        if (txt_alma_caja.getText().equals("0000024")) {
            cargar_24("");
        }
        if (txt_alma_caja.getText().equals("0000025")) {
            cargar_25("");
        }
        if (txt_alma_caja.getText().equals("0000026")) {
            cargar_26("");
        }
        if (txt_alma_caja.getText().equals("0000027")) {
            cargar_27("");
        }
        if (txt_alma_caja.getText().equals("0000028")) {
            cargar_28("");
        }
        if (txt_alma_caja.getText().equals("0000029")) {
            cargar_29("");
        }
        if (txt_alma_caja.getText().equals("0000030")) {
            cargar_30("");
        }

        txt_bus.requestFocus();
        //OpcionMenu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_notacred = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_id_cli = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_notacred = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_notacred.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tb_notacred.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_notacred.setGridColor(new java.awt.Color(0, 102, 204));
        tb_notacred.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_notacred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_notacredMouseClicked(evt);
            }
        });
        tb_notacred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_notacredKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_notacredKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_notacred);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1090, 490));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 340, 30));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 390, 40));

        lbl_id_cli.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(lbl_id_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 120, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Id Cliente:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_notacredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_notacredMouseClicked
        try {

            int fila = tb_notacred.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String nro_dev = tb_notacred.getValueAt(fila, 0).toString();
                String valor = tb_notacred.getValueAt(fila, 3).toString();
                String saldo = tb_notacred.getValueAt(fila, 5).toString();
                String nro_fact = tb_notacred.getValueAt(fila, 6).toString();

                Agregar_nota_credito.txt_nro_dev.setText(nro_dev);
                Agregar_nota_credito.txt_monto_dev.setText(valor);
                Agregar_nota_credito.txt_plazo_saldo_dev.setText(saldo);
                Agregar_nota_credito.txt_nro_venta_dev.setText(nro_fact);

                ////////////////////////////////cargar tabla detalles///////////////////////////////////
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_notacredMouseClicked

    private void tb_notacredKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_notacredKeyReleased

    }//GEN-LAST:event_tb_notacredKeyReleased

    private void tb_notacredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_notacredKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {

            try {

                int fila = tb_notacred.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {

                    String nro_dev = tb_notacred.getValueAt(fila, 0).toString();
                    String valor = tb_notacred.getValueAt(fila, 3).toString();
                    String saldo = tb_notacred.getValueAt(fila, 5).toString();
                    String nro_fact = tb_notacred.getValueAt(fila, 6).toString();

                    Agregar_nota_credito.txt_nro_dev.setText(nro_dev);
                    Agregar_nota_credito.txt_monto_dev.setText(valor);
                    Agregar_nota_credito.txt_plazo_saldo_dev.setText(saldo);
                    Agregar_nota_credito.txt_nro_venta_dev.setText(nro_fact);

                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }

        }


    }//GEN-LAST:event_tb_notacredKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

        if (txt_alma_caja.getText().equals("TODOS") || txt_alma_caja.getText().equals("0000001")) {
            cargar(txt_bus.getText());
        }
        //2
        if (txt_alma_caja.getText().equals("0000002")) {
            cargar_2(txt_bus.getText());
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
        if (txt_alma_caja.getText().equals("0000006")) {
            cargar_6(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000007")) {
            cargar_7(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000008")) {
            cargar_8(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000009")) {
            cargar_9(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000010")) {
            cargar_10(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000011")) {
            cargar_11(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000012")) {
            cargar_12(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000013")) {
            cargar_13(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000014")) {
            cargar_14(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000015")) {
            cargar_15(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000016")) {
            cargar_16(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000017")) {
            cargar_17(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000018")) {
            cargar_18(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000019")) {
            cargar_19(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000020")) {
            cargar_20(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000021")) {
            cargar_21(txt_bus.getText());
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
        if (txt_alma_caja.getText().equals("0000025")) {
            cargar_25(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000026")) {
            cargar_26(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000027")) {
            cargar_27(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000028")) {
            cargar_28(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000029")) {
            cargar_29(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000030")) {
            cargar_30(txt_bus.getText());
        }

    }//GEN-LAST:event_txt_busKeyReleased

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
            java.util.logging.Logger.getLogger(Lista_devolucion_fis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_devolucion_fis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_devolucion_fis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_devolucion_fis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lista_devolucion_fis dialog = new Lista_devolucion_fis(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_id_cli;
    public static javax.swing.JTable tb_notacred;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_fiscal  WHERE CONCAT (num_bol,cod_cli_ventas,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_2(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_2  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_3(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_3  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_4(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_4  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_5(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_5  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_6(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_6  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_7(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_7  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_8(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_8  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_9(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_9  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_10(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_10  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_11(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_11  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_12(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_12  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_13(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_13 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_14(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_14  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_15(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_15  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_16(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_16  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_17(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_17  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_18(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_18  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_19(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_19  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_20(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_20  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_21(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_21  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_22(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_22  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_23(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_23  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_24(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_24  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_25(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_25  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_26(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_26  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_27(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_27  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_28(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_28  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_29(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_29  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_30(String valor) {
        try {

            String[] titulos = {"Nota Nro", "C??d Cliente", "Cliente/Raz??n Social", "Valor Total", "Fecha Emisi??n", "Saldo", "Factura Nro"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devolucion_facturacion_surc_30  WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND cod_cli_ventas='" + lbl_id_cli.getText() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(22);
                registros[5] = rs.getString(30);
                registros[6] = rs.getString(29);

                model.addRow(registros);
            }
            tb_notacred.setModel(model);
            tb_notacred.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_notacred.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_notacred.getColumnModel().getColumn(2).setPreferredWidth(250);
            tb_notacred.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_notacred.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_notacred.getColumnModel().getColumn(6).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
