/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Conexion_DB.conectar;
import static Ventas.Principal_ventas.cod_ventas;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Visor_ventas extends javax.swing.JDialog {

    DefaultTableModel model;

    public Visor_ventas(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // visor_recepcion   visor = new visor_recepcion(new javax.swing.JDialog(), true);
        // txtcod.setText(cod);

        cargar(cod_ventas);
        cargarTxt(cod_ventas);

    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM ventas_detalles WHERE  num_bol='" + valor + "'";
        String[] titulos = {"N°", "Id Producto", "Descripción", "Precio Unitario", "Cantidad", "En Kg", "Precio Venta"};
        String[] Registros = new String[7];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("num_bol");
                Registros[1] = rs.getString("cod_pro");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("pre_unit");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("cant_kg");
                Registros[6] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_visor_recep.setModel(model);

            tb_visor_recep.getColumnModel().getColumn(0).setPreferredWidth(93);
            tb_visor_recep.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_visor_recep.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_visor_recep.getColumnModel().getColumn(3).setPreferredWidth(130);
            tb_visor_recep.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_visor_recep.getColumnModel().getColumn(5).setPreferredWidth(80);
            tb_visor_recep.getColumnModel().getColumn(6).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM ventas as v inner join tienda_clientes as c on v.cod_cli_ventas=c.cli_cod WHERE  num_bol='" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_venta.setText(rs.getString(1));
                cliente.setText(rs.getString(3));
                forma_pago.setText(rs.getString(4));
                dias_plazo.setText(rs.getString(5));
                valot_total.setText(rs.getString(6));
                txt_fecha.setText(rs.getString(10));
                txt_usuario.setText(rs.getString(12));
                lbl_sucursal_id.setText(rs.getString(13));
                lbl_des_ventas.setText(rs.getString(20));
                lbl_status_ventas.setText(rs.getString(9));
                lbl_cli_sucursal.setText(rs.getString(35));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel28 = new javax.swing.JLabel();
        lbl_status_ventas = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        dias_plazo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_visor_recep = new javax.swing.JTable();
        forma_pago = new javax.swing.JLabel();
        cliente = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        valot_total = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        txt_nro_venta = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_des_ventas = new javax.swing.JLabel();
        btn_elimina = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lbl_sucursal_id = new javax.swing.JLabel();
        txt_salir = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_cli_sucursal = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Ventas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("Estado:");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 50, 30));

        lbl_status_ventas.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        getContentPane().add(lbl_status_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Venta Nº:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Usuario:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 30));

        dias_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(dias_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 70, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Fecha :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 30));

        tb_visor_recep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_visor_recep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_visor_recep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_visor_recepMouseClicked(evt);
            }
        });
        tb_visor_recep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_visor_recepKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_visor_recep);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 890, 290));

        forma_pago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        forma_pago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        forma_pago.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 90, 30));

        cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 380, 30));

        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 190, 30));

        valot_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valot_total.setForeground(new java.awt.Color(204, 51, 0));
        valot_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valot_total.setToolTipText("");
        valot_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(valot_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 150, 30));

        txt_fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 90, 30));

        txt_nro_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nro_venta.setForeground(new java.awt.Color(204, 51, 0));
        jPanel2.add(txt_nro_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Cond. de  Pago:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 110, 30));

        lbl_des_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_des_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 510, 30));

        btn_elimina.setBackground(new java.awt.Color(255, 255, 255));
        btn_elimina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_elimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btn_elimina.setText("Anular");
        btn_elimina.setToolTipText("Anular Ventas");
        btn_elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_elimina, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 120, 50));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Valor Total:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 80, 30));

        lbl_sucursal_id.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_sucursal_id.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(lbl_sucursal_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 100, 30));

        txt_salir.setBorder(null);
        txt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salirActionPerformed(evt);
            }
        });
        txt_salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_salirKeyPressed(evt);
            }
        });
        jPanel2.add(txt_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 190, 0));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("N° Cuotas:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 90, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Almacén-Sucursal:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 140, 30));

        lbl_cli_sucursal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_cli_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 60, 30));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("Descripción:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 880, 130));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("Cliente:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 30));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Sucursal:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 60, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_visor_recepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_visor_recepKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepKeyReleased

    private void tb_visor_recepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_visor_recepMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepMouseClicked

    private void btn_eliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminaActionPerformed

        String verificar = lbl_status_ventas.getText();
        String status = ("CONFIRMADA");
        if (verificar.equals(status)) {
            JOptionPane.showMessageDialog(null, "La nota ya fue confirmada en caja");
        } else {

            if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
                    "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                eliminarVentas();
                limpiar();
                Principal_ventas.btn_cargar_datos.doClick();
                this.dispose();

            }
        }
    }//GEN-LAST:event_btn_eliminaActionPerformed

    private void txt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salirActionPerformed

    private void txt_salirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_salirKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txt_salirKeyPressed

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
            java.util.logging.Logger.getLogger(Visor_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visor_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visor_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visor_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Visor_ventas dialog = new Visor_ventas(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_elimina;
    private javax.swing.JLabel cliente;
    private javax.swing.JLabel dias_plazo;
    private javax.swing.JLabel forma_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cli_sucursal;
    private javax.swing.JLabel lbl_des_ventas;
    private javax.swing.JLabel lbl_status_ventas;
    private javax.swing.JLabel lbl_sucursal_id;
    public static javax.swing.JTable tb_visor_recep;
    private javax.swing.JLabel txt_fecha;
    public static javax.swing.JLabel txt_nro_venta;
    private javax.swing.JTextField txt_salir;
    private javax.swing.JLabel txt_usuario;
    private javax.swing.JLabel valot_total;
    // End of variables declaration//GEN-END:variables

    void eliminarVentas() {

        String verificar = lbl_status_ventas.getText();
        String status = ("DEVUELTO");
        if (verificar.equals(status)) {
            JOptionPane.showMessageDialog(null, "Nota cuenta con devoluvión");
        } else {
            String cod = txt_nro_venta.getText();
            String eliminarSQL = "DELETE FROM ventas WHERE num_bol = '" + cod + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                String capcod = "", capcan = "";
                for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                    capcod = tb_visor_recep.getValueAt(i, 1).toString();
                    capcan = tb_visor_recep.getValueAt(i, 4).toString();
                    devolverstock(capcod, capcan);
                }
                JOptionPane.showMessageDialog(null, "Borrado");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    void eliminarVentasSinStock() {

        String cod = txt_nro_venta.getText();
        String eliminarSQL = "DELETE FROM ventas  WHERE num_bol = '" + cod + "' ";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                devolverSeparacion(capcod, capcan);
            }
            JOptionPane.showMessageDialog(null, "Borrado");

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void devolverstock(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(5);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + des;
        String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void devolverSeparacion(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(23);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_alma='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void limpiar() {
        txt_nro_venta.setText("");
        txt_usuario.setText("");
        cliente.setText("");
        forma_pago.setText("");
        dias_plazo.setText("");
        txt_fecha.setText("");
        valot_total.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_visor_recep.getModel();
        int a = tb_visor_recep.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

}
