/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.compras_plazo;

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
public class Lista_compras_credito extends javax.swing.JDialog {

    DefaultTableModel model;

    public Lista_compras_credito(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

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

        txt_bus.requestFocus();
        //OpcionMenu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_pago_cred = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_pago_cred = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_pago_cred.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tb_pago_cred.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_pago_cred.setGridColor(new java.awt.Color(0, 102, 204));
        tb_pago_cred.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_pago_cred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pago_credMouseClicked(evt);
            }
        });
        tb_pago_cred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_pago_credKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_pago_credKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_pago_cred);

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_pago_credMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pago_credMouseClicked
        try {

            int fila = tb_pago_cred.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tb_pago_cred.getValueAt(fila, 0).toString();
                String id_cli = tb_pago_cred.getValueAt(fila, 1).toString();
                String nom_cli = tb_pago_cred.getValueAt(fila, 2).toString();
                String total = tb_pago_cred.getValueAt(fila, 7).toString();

                Pago_cred_compras.txt_nro_venta.setText(codins);

                Pago_cred_compras.id_cliente_cre.setText(id_cli);
                Pago_cred_compras.txt_nom_cli_cred.setText(nom_cli);
                Pago_cred_compras.txt_plazo_saldo.setText(total);
                Pago_cred_compras.txt_almacen.setText("0000001");
                ////////////////////////////////cargar tabla detalles///////////////////////////////////

                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_pago_credMouseClicked

    private void tb_pago_credKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_pago_credKeyReleased

    }//GEN-LAST:event_tb_pago_credKeyReleased

    private void tb_pago_credKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_pago_credKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_ENTER) {
            /*
             try {

             int fila = tb_pago_plazos.getSelectedRow();

             if (fila == -1) {
             JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
             } else {
             String codins = tb_pago_plazos.getValueAt(fila, 0).toString();

             pago_plazo_ventas.txt_nro_venta.setText(codins);
             pago_plazo_ventas.txt_id_venta.setText(codins);
             // Devolucion_Devoluciones.btncalcular.doClick();
             this.dispose();

             }
             } catch (HeadlessException | NumberFormatException e) {
             }*/
            try {

                int fila = tb_pago_cred.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_pago_cred.getValueAt(fila, 0).toString();
                    String id_cli = tb_pago_cred.getValueAt(fila, 1).toString();
                    String nom_cli = tb_pago_cred.getValueAt(fila, 2).toString();

                    String total = tb_pago_cred.getValueAt(fila, 7).toString();

                    Pago_cred_compras.txt_nro_venta.setText(codins);

                    Pago_cred_compras.id_cliente_cre.setText(id_cli);
                    Pago_cred_compras.txt_nom_cli_cred.setText(nom_cli);
                    Pago_cred_compras.txt_plazo_saldo.setText(total);
                    Pago_cred_compras.txt_almacen.setText("0000001");

                    ////////////////////////////////cargar tabla detalles///////////////////////////////////
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }


    }//GEN-LAST:event_tb_pago_credKeyPressed

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
        //16
        if (txt_alma_caja.getText().equals("0000016")) {
            cargar_16(txt_bus.getText());
        }
        //18
        if (txt_alma_caja.getText().equals("0000018")) {
            cargar_18(txt_bus.getText());
        }
        if (txt_alma_caja.getText().equals("0000020")) {
            cargar_20(txt_bus.getText());
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
            java.util.logging.Logger.getLogger(Lista_compras_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_compras_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_compras_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_compras_credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Lista_compras_credito dialog = new Lista_compras_credito(new javax.swing.JDialog(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tb_pago_cred;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Compra Nro", "Cód. Cliente", "Cliente", "Condición", "Valor Total", "Estado de Ventas", "Fecha", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from compras WHERE CONCAT (cod_comp,nom_prov_comp) LIKE '%" + valor + "%' AND pago_comp='CRÉDITO' ORDER BY  cod_comp";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(8);
                registros[4] = rs.getString(10);
                registros[5] = rs.getString(13);
                registros[6] = rs.getString(6);
                registros[7] = rs.getString(16);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(120);

            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_2(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_2 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_3(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_3 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_4(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_4 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_5(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_5 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_6(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_6 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_7(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_7 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_8(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_8 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_9(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_9 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_10(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_10 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_11(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_11 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_12(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_12 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_13(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_13 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_14(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_14 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_15(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_15 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_16(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_16 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_17(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_17 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_18(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_18 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_19(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_19 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_20(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_20 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_21(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_21 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_22(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_22 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_23(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_23 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_24(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_24 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_25(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_25 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_26(String valor) {
        try {

            String[] titulos = {"Nro Venta", "Cód. Cliente", "Cliente", "Condición", "N° Cuotas", "Valor Total", "Estado de Ventas", "Fecha", "Almacén", "Saldo Pendiente"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from ventas_26 WHERE CONCAT (num_bol,nom_cli_ventas) LIKE '%" + valor + "%' AND forma_pag_ventas='CRÉDITO' ORDER BY num_bol DESC";
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
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(13);
                registros[9] = rs.getString(18);

                model.addRow(registros);
            }
            tb_pago_cred.setModel(model);

            ColorearFilas color = new ColorearFilas(6);
            tb_pago_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_pago_cred.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_pago_cred.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_pago_cred.getColumnModel().getColumn(0).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(1).setPreferredWidth(87);
            tb_pago_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_pago_cred.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_pago_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_pago_cred.getColumnModel().getColumn(7).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(8).setPreferredWidth(100);
            tb_pago_cred.getColumnModel().getColumn(9).setPreferredWidth(120);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
