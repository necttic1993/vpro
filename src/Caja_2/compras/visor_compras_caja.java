/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.compras;

import static Caja_2.compras.Compras_caja.cod_compras_caja;
import static Caja_2.compras.Compras_caja_cancela.cod_compras_caja_cancela;
import Conexion_DB.conectar;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class visor_compras_caja extends javax.swing.JDialog {

    DefaultTableModel model;

    public visor_compras_caja(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // visor_recepcion   visor = new visor_recepcion(new javax.swing.JDialog(), true);
        // txtcod.setText(cod);

        cargar(cod_compras_caja_cancela);
        cargarTxt(cod_compras_caja_cancela);
        cargar(cod_compras_caja);
        cargarTxt(cod_compras_caja);
     

    }

    public void cargar(String valor) {
        String mostrar = "SELECT * FROM detalle_compras WHERE CONCAT(cod_comp) LIKE '%" + valor + "%'";
        String[] titulos = {"N°", "Id Producto", "Descripción", "Precio Unitario", "Cantidad", "Precio Venta"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_comp");
                Registros[1] = rs.getString("cod_pro");
                Registros[2] = rs.getString("des_pro");
                Registros[3] = rs.getString("pre_unit");
                Registros[4] = rs.getString("cant_pro");
                Registros[5] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_visor_recep.setModel(model);

            tb_visor_recep.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_visor_recep.getColumnModel().getColumn(1).setPreferredWidth(103);
            tb_visor_recep.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_visor_recep.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_visor_recep.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_visor_recep.getColumnModel().getColumn(5).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(visor_compras_caja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM compras WHERE CONCAT(cod_comp) LIKE '%" + valor + "%'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_compras.setText(rs.getString(1));
                proveedor.setText(rs.getString(3));
                lbl_nro_compra.setText(rs.getString(4));
                lbl_fecha_emi.setText(rs.getString(5));
                lbl_fecha_entra.setText(rs.getString(7));
                forma_pago.setText(rs.getString(8));
                dias_plazo.setText(rs.getString(9));
                valot_total.setText(rs.getString(10));
                txt_fecha.setText(rs.getString(11));
                txt_usuario.setText(rs.getString(12));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(visor_compras_caja.class.getName()).log(Level.SEVERE, null, ex);
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
        lbl_nro_compra = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        dias_plazo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_visor_recep = new javax.swing.JTable();
        forma_pago = new javax.swing.JLabel();
        proveedor = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        txt_nro_compras = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_salir = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        lbl_fecha_entra = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbl_fecha_emi = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        valot_total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Compras");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nro_compra.setBackground(new java.awt.Color(204, 51, 0));
        lbl_nro_compra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_nro_compra.setForeground(new java.awt.Color(204, 51, 0));
        jPanel2.add(lbl_nro_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 190, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Usuario:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 30));

        dias_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(dias_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 50, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Fecha :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 10, 60, 30));

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 890, 320));

        forma_pago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        forma_pago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        forma_pago.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 90, 30));

        proveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        proveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 370, 30));

        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, 30));

        txt_fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 90, 30));

        txt_nro_compras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nro_compras.setForeground(new java.awt.Color(204, 51, 0));
        jPanel2.add(txt_nro_compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 120, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Fecha de Entrada:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 130, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Proveedor:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("N° Cuotas:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 90, 30));

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

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Cond. de Pago:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 120, 30));

        lbl_fecha_entra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_fecha_entra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 100, 30));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("Fecha de Emisión:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 130, 30));

        lbl_fecha_emi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_fecha_emi, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 90, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Compra Nº:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Nº de Nota:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 90, 30));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 880, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Valot Total:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 80, 30));

        valot_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valot_total.setForeground(new java.awt.Color(204, 51, 0));
        valot_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valot_total.setToolTipText("");
        valot_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(valot_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_visor_recepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_visor_recepKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepKeyReleased

    private void tb_visor_recepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_visor_recepMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepMouseClicked

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
            java.util.logging.Logger.getLogger(visor_compras_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visor_compras_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visor_compras_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visor_compras_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                visor_compras_caja dialog = new visor_compras_caja(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel dias_plazo;
    private javax.swing.JLabel forma_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_fecha_emi;
    private javax.swing.JLabel lbl_fecha_entra;
    private javax.swing.JLabel lbl_nro_compra;
    private javax.swing.JLabel proveedor;
    public static javax.swing.JTable tb_visor_recep;
    private javax.swing.JLabel txt_fecha;
    public static javax.swing.JLabel txt_nro_compras;
    private javax.swing.JTextField txt_salir;
    private javax.swing.JLabel txt_usuario;
    private javax.swing.JLabel valot_total;
    // End of variables declaration//GEN-END:variables

}
