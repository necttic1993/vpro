/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.fabrica;

import Conexion_DB.conectar;
import static Productos.fabrica.Principal_fabrica.cod_fa_detalle;
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
public class Visor_fabrica extends javax.swing.JDialog {

    DefaultTableModel model;

    public Visor_fabrica(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // visor_recepcion   visor = new visor_recepcion(new javax.swing.JDialog(), true);
        // txtcod.setText(cod);

        cargar(cod_fa_detalle);
        cargarTxt(cod_fa_detalle);

    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM fabrica_stok_detalles WHERE  nro_fa='" + valor + "'";
        String[] titulos = {"N° Serie", "Id Producto", "Descripción", "Precio Unitario", "Cantidad", "Precio Venta"};
        String[] Registros = new String[7];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("nro_fa");
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
            Logger.getLogger(Visor_fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM fabrica_stock WHERE  nro_serie='" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_serie.setText(rs.getString(1));
                txt_fecha.setText(rs.getString(3));
                txt_usuario.setText(rs.getString(5));
                lbl_des_ventas.setText(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_fabrica.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_visor_recep = new javax.swing.JTable();
        txt_usuario = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        txt_nro_serie = new javax.swing.JLabel();
        lbl_des_ventas = new javax.swing.JLabel();
        txt_salir = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Ventas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Serie Nº:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Usuario:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Fecha :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 890, 330));

        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 190, 30));

        txt_fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 90, 30));

        txt_nro_serie.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nro_serie.setForeground(new java.awt.Color(204, 51, 0));
        jPanel2.add(txt_nro_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 30));

        lbl_des_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_des_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 680, 30));

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

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("Descripción:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 880, 130));

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
            java.util.logging.Logger.getLogger(Visor_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visor_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visor_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visor_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Visor_fabrica dialog = new Visor_fabrica(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_des_ventas;
    public static javax.swing.JTable tb_visor_recep;
    private javax.swing.JLabel txt_fecha;
    public static javax.swing.JLabel txt_nro_serie;
    private javax.swing.JTextField txt_salir;
    private javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables

}
