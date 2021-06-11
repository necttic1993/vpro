/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS;

import Conexion_DB.conectar;
import static Loggin_Principal.Principal.lbl_usu_nom;
import static OS.Principapl_OS.cod_deta_os;
import static OS.Principapl_OS.tb_os;
import static Ventas.Principal_ventas.cod_ventas;
import static Ventas.Principal_ventas.tbProductos;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Visor_OS extends javax.swing.JDialog {

    DefaultTableModel model;

    public Visor_OS(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // visor_recepcion   visor = new visor_recepcion(new javax.swing.JDialog(), true);
        // txtcod.setText(cod);

        cargar(cod_deta_os);
        cargarTxt(cod_deta_os);

    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM detalle_os WHERE  num_bol='" + valor + "'";
        String[] titulos = {"N°", "Id Producto", "Descripción", "Precio Unitario", "Cantidad", "Precio Venta"};
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
                Registros[5] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_visor_recep.setModel(model);

            tb_visor_recep.getColumnModel().getColumn(0).setPreferredWidth(93);
            tb_visor_recep.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_visor_recep.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_visor_recep.getColumnModel().getColumn(3).setPreferredWidth(130);
            tb_visor_recep.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_visor_recep.getColumnModel().getColumn(5).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_OS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM os WHERE  os_nro='" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_venta.setText(rs.getString(1));
                cliente.setText(rs.getString(5));
                valot_total.setText(rs.getString(9));
                txt_fecha.setText(rs.getString(3));
                valot_stock.setText(rs.getString(16));
                valot_tec.setText(rs.getString(15));
                txt_servicios.setText(rs.getString(14));
                txt_tec_des.setText(rs.getString(18));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_OS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_visor_recep = new javax.swing.JTable();
        cliente = new javax.swing.JLabel();
        valot_total = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        txt_nro_venta = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_servicios = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_tec_des = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_salir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        valot_stock = new javax.swing.JLabel();
        valot_tec = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta O.S");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("O.S Nº:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Técnico:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 30));

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 890, 270));

        cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 390, 30));

        valot_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valot_total.setForeground(new java.awt.Color(204, 51, 0));
        valot_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valot_total.setToolTipText("");
        valot_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(valot_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 150, 30));

        txt_fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 120, 30));

        txt_nro_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nro_venta.setForeground(new java.awt.Color(204, 51, 0));
        jPanel2.add(txt_nro_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 130, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Servicos:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 30));

        txt_servicios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 650, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/close.png"))); // NOI18N
        jButton1.setText("Anular");
        jButton1.setToolTipText("Anular Ventas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 120, 40));

        txt_tec_des.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_tec_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 410, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Valor Técnico:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 100, 30));

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

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 880, 140));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Valor Total:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 80, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Valor Stock:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 30));

        valot_stock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valot_stock.setForeground(new java.awt.Color(204, 51, 0));
        valot_stock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valot_stock.setToolTipText("");
        valot_stock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(valot_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 150, 30));

        valot_tec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valot_tec.setForeground(new java.awt.Color(204, 51, 0));
        valot_tec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valot_tec.setToolTipText("");
        valot_tec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(valot_tec, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 150, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Cliente:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Fecha :");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int filaMod = tb_os.getSelectedRow();
        String verificar = (String) tb_os.getValueAt(filaMod, 5);
        String status = ("PAGADO");
        String entregad = ("ENTREGADO");
        if (verificar.equals(status) || verificar.equals(entregad)) {
            JOptionPane.showMessageDialog(null, "La nota ya fue confirmada en caja o entegado");
        } else {

            if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
                    "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                eliminarVentas();
                limpiar();
                Principapl_OS.btn_cargar_datos.doClick();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Visor_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visor_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visor_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visor_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Visor_OS dialog = new Visor_OS(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tb_visor_recep;
    private javax.swing.JLabel txt_fecha;
    public static javax.swing.JLabel txt_nro_venta;
    private javax.swing.JTextField txt_salir;
    private javax.swing.JLabel txt_servicios;
    private javax.swing.JLabel txt_tec_des;
    private javax.swing.JLabel valot_stock;
    private javax.swing.JLabel valot_tec;
    private javax.swing.JLabel valot_total;
    // End of variables declaration//GEN-END:variables

    void eliminarVentas() {

        String cod = txt_nro_venta.getText();
        String eliminarSQL = "DELETE FROM os WHERE os_nro = '" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            JOptionPane.showMessageDialog(null, "Borrado");

            String capcod = "", capcan = "";
            for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
                capcod = tb_visor_recep.getValueAt(i, 1).toString();
                capcan = tb_visor_recep.getValueAt(i, 4).toString();
                devolverstock(capcod, capcan);
                eliminarDetalle();
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void eliminarDetalle() {

        String cod = txt_nro_venta.getText();
        String eliminarSQL = "DELETE FROM detalle_os WHERE num_bol = '" + cod + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

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

    void limpiar() {
        txt_nro_venta.setText("");
        cliente.setText("");
        txt_fecha.setText("");
        valot_total.setText("");
        valot_stock.setText("");
        valot_tec.setText("");
        txt_servicios.setText("");
        txt_tec_des.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tb_visor_recep.getModel();
        int a = tb_visor_recep.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

}
