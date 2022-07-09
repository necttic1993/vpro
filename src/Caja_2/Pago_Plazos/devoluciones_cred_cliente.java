/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.Pago_Plazos;

import static Caja_2.Caja_caja.txt_alma_caja;
import static Caja_2.Pago_Plazos.Agregar_nota_cred_ventas.cod_cli_cre_ventas;
import Clases.ColorearFilas_devoluciones;
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
public class devoluciones_cred_cliente extends javax.swing.JDialog {

    DefaultTableModel model;

    public devoluciones_cred_cliente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbl_id_cli.setText(cod_cli_cre_ventas);
        control();
        txt_bus.requestFocus();

    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_devolucion_caja = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_devolucion_cred = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_id_cli = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEVOLUCIONES");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_devolucion_cred = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_devolucion_cred.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_devolucion_cred.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_devolucion_cred.setGridColor(new java.awt.Color(0, 102, 204));
        tb_devolucion_cred.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_devolucion_cred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_devolucion_credMouseClicked(evt);
            }
        });
        tb_devolucion_cred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_devolucion_credKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_devolucion_credKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_devolucion_cred);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1220, 510));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 380, 32));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 35));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Id Cliente:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 100, 30));

        lbl_id_cli.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(lbl_id_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_devolucion_credMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_devolucion_credMouseClicked
        try {

            int fila = tb_devolucion_cred.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String nro_dev = tb_devolucion_cred.getValueAt(fila, 0).toString();
                String valor = tb_devolucion_cred.getValueAt(fila, 5).toString();
                String saldo = tb_devolucion_cred.getValueAt(fila, 7).toString();

                Agregar_nota_cred_ventas.txt_nro_dev.setText(nro_dev);
                Agregar_nota_cred_ventas.txt_monto_dev.setText(valor);
                Agregar_nota_cred_ventas.txt_plazo_saldo_dev.setText(saldo);

                ////////////////////////////////cargar tabla detalles///////////////////////////////////
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_devolucion_credMouseClicked

    private void tb_devolucion_credKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_devolucion_credKeyReleased

    }//GEN-LAST:event_tb_devolucion_credKeyReleased

    private void tb_devolucion_credKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_devolucion_credKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_SPACE) {

            int filaMod = tb_devolucion_cred.getSelectedRow();
            cod_devolucion_caja = (String) tb_devolucion_cred.getValueAt(filaMod, 0);

        }
        if (Tecla == KeyEvent.VK_ENTER) {
            try {

                int fila = tb_devolucion_cred.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String nro_dev = tb_devolucion_cred.getValueAt(fila, 0).toString();
                    String valor = tb_devolucion_cred.getValueAt(fila, 5).toString();
                    String saldo = tb_devolucion_cred.getValueAt(fila, 7).toString();

                    Agregar_nota_cred_ventas.txt_nro_dev.setText(nro_dev);
                    Agregar_nota_cred_ventas.txt_monto_dev.setText(valor);
                    Agregar_nota_cred_ventas.txt_plazo_saldo_dev.setText(saldo);
                    ////////////////////////////////cargar tabla detalles///////////////////////////////////
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }


    }//GEN-LAST:event_tb_devolucion_credKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("TODOS")) {
            cargar(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000001")) {
            cargar(txt_bus.getText());
        }

        //2
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000002")) {
            cargar_surc_2(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000003")) {
            cargar_surc_3(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000004")) {
            cargar_surc_4(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000005")) {
            cargar_surc_5(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000006")) {
            cargar_surc_6(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000007")) {
            cargar_surc_7(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000008")) {
            cargar_surc_8(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000009")) {
            cargar_surc_9(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000010")) {
            cargar_surc_10(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000011")) {
            cargar_surc_11(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000012")) {
            cargar_surc_12(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000013")) {
            cargar_surc_13(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000014")) {
            cargar_surc_14(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000015")) {
            cargar_surc_15(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000016")) {
            cargar_surc_16(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000017")) {
            cargar_surc_17(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000018")) {
            cargar_surc_18(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000019")) {
            cargar_surc_19(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000020")) {
            cargar_surc_20(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000021")) {
            cargar_surc_21(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000022")) {
            cargar_surc_22(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000023")) {
            cargar_surc_23(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000024")) {
            cargar_surc_24(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000025")) {
            cargar_surc_25(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000026")) {
            cargar_surc_26(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000027")) {
            cargar_surc_27(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000028")) {
            cargar_surc_28(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000029")) {
            cargar_surc_29(txt_bus.getText());
        }
        if (Caja_2.Caja_caja.txt_alma_caja.getText().equals("0000030")) {
            cargar_surc_30(txt_bus.getText());
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
            java.util.logging.Logger.getLogger(devoluciones_cred_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(devoluciones_cred_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(devoluciones_cred_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(devoluciones_cred_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                devoluciones_cred_cliente dialog = new devoluciones_cred_cliente(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_id_cli;
    public static javax.swing.JTable tb_devolucion_cred;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_2(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_2 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_3(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_3 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_4(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_4 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_5(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_5 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_6(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_6 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_7(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_7 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_8(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_8 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_9(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_9 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_10(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_10 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_11(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_11 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_12(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_12 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_13(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_13 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_14(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_14 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_15(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_15 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_16(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_16 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_17(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_17 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_18(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_18 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_19(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_19 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_20(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_20 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_21(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_21 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_22(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_22 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_23(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_23 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_24(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_24 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_25(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_25 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_26(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_26 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_27(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_27 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_28(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_28 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_29(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_29 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_30(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado", "Saldo"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_30 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='FINALIZADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(11);
                registros[7] = rs.getString(13);

                model.addRow(registros);
            }
            tb_devolucion_cred.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion_cred.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion_cred.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion_cred.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion_cred.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion_cred.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion_cred.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion_cred.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion_cred.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_devolucion_cred.getColumnModel().getColumn(7).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void control() {

        if (txt_alma_caja.getText().equals("0000001")) {
            cargar("");
        }

        //2
        if (txt_alma_caja.getText().equals("0000002")) {
            cargar_surc_2("");
        }

        if (txt_alma_caja.getText().equals("0000003")) {
            cargar_surc_3("");
        }
        if (txt_alma_caja.getText().equals("0000004")) {
            cargar_surc_4("");
        }
        if (txt_alma_caja.getText().equals("0000005")) {
            cargar_surc_5("");
        }
        if (txt_alma_caja.getText().equals("0000006")) {
            cargar_surc_6("");
        }
        if (txt_alma_caja.getText().equals("0000007")) {
            cargar_surc_7("");
        }
        if (txt_alma_caja.getText().equals("0000008")) {
            cargar_surc_8("");
        }
        if (txt_alma_caja.getText().equals("0000009")) {
            cargar_surc_9("");
        }
        if (txt_alma_caja.getText().equals("0000010")) {
            cargar_surc_10("");
        }
        if (txt_alma_caja.getText().equals("0000011")) {
            cargar_surc_11("");
        }
        if (txt_alma_caja.getText().equals("0000012")) {
            cargar_surc_12("");
        }
        if (txt_alma_caja.getText().equals("0000013")) {
            cargar_surc_13("");
        }
        if (txt_alma_caja.getText().equals("0000014")) {
            cargar_surc_14("");
        }
        if (txt_alma_caja.getText().equals("0000015")) {
            cargar_surc_15("");
        }
        if (txt_alma_caja.getText().equals("0000016")) {
            cargar_surc_16("");
        }
        if (txt_alma_caja.getText().equals("0000017")) {
            cargar_surc_17("");
        }
        if (txt_alma_caja.getText().equals("0000018")) {
            cargar_surc_18("");
        }
        if (txt_alma_caja.getText().equals("0000019")) {
            cargar_surc_19("");
        }
        if (txt_alma_caja.getText().equals("0000020")) {
            cargar_surc_20("");
        }
        if (txt_alma_caja.getText().equals("0000021")) {
            cargar_surc_21("");
        }
        if (txt_alma_caja.getText().equals("0000022")) {
            cargar_surc_22("");
        }
        if (txt_alma_caja.getText().equals("0000023")) {
            cargar_surc_23("");
        }
        if (txt_alma_caja.getText().equals("0000024")) {
            cargar_surc_24("");
        }
        if (txt_alma_caja.getText().equals("0000025")) {
            cargar_surc_25("");
        }
        if (txt_alma_caja.getText().equals("0000026")) {
            cargar_surc_26("");
        }
        if (txt_alma_caja.getText().equals("0000027")) {
            cargar_surc_27("");
        }
        if (txt_alma_caja.getText().equals("0000028")) {
            cargar_surc_28("");
        }
        if (txt_alma_caja.getText().equals("0000029")) {
            cargar_surc_29("");
        }
        if (txt_alma_caja.getText().equals("0000030")) {
            cargar_surc_30("");
        }
    }

}
