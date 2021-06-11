/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.devoluciones;

import Caja_2.Caja_caja;
import static Caja_2.Caja_caja.txt_alma_caja;
import Clases.ColorearFilas_devoluciones;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
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
public class devoluciones_caja_cancela extends javax.swing.JDialog {

    DefaultTableModel model;

    public devoluciones_caja_cancela(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        control();
        txt_bus.requestFocus();

    }

    public static String cod_pro = "";
    public static String cod_imagen = "";
    public static String cod_pro_mod = "";
    public static String cod_devolucion_caja_cancela = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_devolucion = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CANCELAR DEVOLUCIONES");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_devolucion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_devolucion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_devolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_devolucion.setGridColor(new java.awt.Color(0, 102, 204));
        tb_devolucion.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_devolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_devolucionMouseClicked(evt);
            }
        });
        tb_devolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_devolucionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_devolucionKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_devolucion);

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 370, 32));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 35));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_devolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_devolucionMouseClicked
        try {

            int fila = tb_devolucion.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tb_devolucion.getValueAt(fila, 0).toString();
                String desins = ("CANC. NOTA DE DEV. NOTA N°" + tb_devolucion.getValueAt(fila, 0).toString());
                String preins = tb_devolucion.getValueAt(fila, 5).toString();

                Caja_caja.txt_nro_docu.setText(codins);
                Caja_caja.txt_des_caja.setText(desins);
                Caja_caja.lbl_total_gs.setText(preins);
                Caja_caja.btn_calcular.doClick();
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_devolucionMouseClicked

    private void tb_devolucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_devolucionKeyReleased

    }//GEN-LAST:event_tb_devolucionKeyReleased

    private void tb_devolucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_devolucionKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_SPACE) {

            int filaMod = tb_devolucion.getSelectedRow();
            cod_devolucion_caja_cancela = (String) tb_devolucion.getValueAt(filaMod, 0);

            Visor_devoluciones_caja visor;
            visor = new Visor_devoluciones_caja(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }
        if (Tecla == KeyEvent.VK_ENTER) {

            try {

                int fila = tb_devolucion.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_devolucion.getValueAt(fila, 0).toString();
                    String desins = ("CANC. NOTA DE DEV. NOTA N°" + tb_devolucion.getValueAt(fila, 0).toString());
                    String preins = tb_devolucion.getValueAt(fila, 5).toString();

                    Caja_caja.txt_nro_docu.setText(codins);
                    Caja_caja.txt_des_caja.setText(desins);
                    Caja_caja.lbl_total_gs.setText(preins);
                    Caja_caja.btn_calcular.doClick();
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }


    }//GEN-LAST:event_tb_devolucionKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargar(txt_bus.getText());
        }
        if (Principal.lbl_usu_almacen.getText().equals("0000001")) {
            cargar(txt_bus.getText());
        }

        //2
        if (Principal.lbl_usu_almacen.getText().equals("0000002")) {
            cargar_surc_2(txt_bus.getText());
        }

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

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
            java.util.logging.Logger.getLogger(devoluciones_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(devoluciones_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(devoluciones_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(devoluciones_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                devoluciones_caja_cancela dialog = new devoluciones_caja_cancela(new javax.swing.JDialog(), true);
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
    public static javax.swing.JTable tb_devolucion;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_2(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_2 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    
       void cargar_surc_3(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_3 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_4(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_4 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_5(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_5 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_6(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_6 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_7(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_7 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_8(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_8 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_9(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_9 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_10(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_10 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_11(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_11 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_12(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_12 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_13(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_13 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_14(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_14 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_15(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_15 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_16(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_16 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_17(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_17 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_18(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_18 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_19(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_19 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_20(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_20 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    
    void cargar_surc_21(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_21 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_22(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_22 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_23(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_23 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_24(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_24 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_25(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_25 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_26(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_26 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_27(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_27 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_28(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_28 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_29(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_29 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_surc_30(String valor) {
        try {

            String[] titulos = {"Nro Devol.", "Venta Nro", "Nombre del Cliente", "Descripción", "Total Items", "Valor Total", "Estado"};
            String[] registros = new String[9];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from devoluciones_surc_30 WHERE CONCAT (cod_dev,nom_cli_dev) LIKE '%" + valor + "%' AND estado_dev='CONFIRMADA'";
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

                model.addRow(registros);
            }
            tb_devolucion.setModel(model);

            ColorearFilas_devoluciones color = new ColorearFilas_devoluciones(6);
            tb_devolucion.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_devolucion.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_devolucion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_devolucion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_devolucion.getColumnModel().getColumn(3).setPreferredWidth(400);
            tb_devolucion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_devolucion.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_devolucion.getColumnModel().getColumn(6).setPreferredWidth(150);
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
