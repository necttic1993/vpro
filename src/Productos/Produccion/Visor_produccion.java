/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.Produccion;

import Conexion_DB.conectar;
import static Productos.Produccion.Principal_produccion.cod_produccion;
import static Productos.Produccion.Principal_produccion.cod_serie;
import java.sql.Connection;
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
public class Visor_produccion extends javax.swing.JDialog {

    DefaultTableModel model;

    public Visor_produccion(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // visor_recepcion   visor = new visor_recepcion(new javax.swing.JDialog(), true);
        lbl_nro_pedido.setText(cod_produccion);
        lbl_serie.setText(cod_serie);
        // cargar(cod_produccion);
        // cargarTxt(cod_produccion);
    }
    public static String cod_prod_op = "";
    public static String cod_pro_sub = "";

    void cargar(String valor) {
        String mostrar = "SELECT * FROM presupuesto_detalles WHERE  num_bol='" + valor + "'";
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
            tb_visor_produccion.setModel(model);

            tb_visor_produccion.getColumnModel().getColumn(0).setPreferredWidth(93);
            tb_visor_produccion.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_visor_produccion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_visor_produccion.getColumnModel().getColumn(3).setPreferredWidth(130);
            tb_visor_produccion.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_visor_produccion.getColumnModel().getColumn(5).setPreferredWidth(80);
            tb_visor_produccion.getColumnModel().getColumn(6).setPreferredWidth(130);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_produccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM presupuesto WHERE  num_bol='" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                //   txt_nro_venta.setText(rs.getString(1));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_produccion.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_visor_produccion = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbl_serie = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_nro_pedido = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_visor_produccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_visor_produccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_visor_produccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_visor_produccionMouseClicked(evt);
            }
        });
        tb_visor_produccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_visor_produccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_visor_produccionKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_visor_produccion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1090, 450));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 60, 50));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/paquete.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 60, 50));

        lbl_serie.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_serie.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(lbl_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 140, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Nro Pedido:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 30));

        lbl_nro_pedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(lbl_nro_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 140, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 540, 120, 50));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/lapiz_editar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 60, 50));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Nro de Serie:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_visor_produccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_visor_produccionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_produccionKeyReleased

    private void tb_visor_produccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_visor_produccionMouseClicked
        int filaMod = tb_visor_produccion.getSelectedRow();
        cod_prod_op = (String) tb_visor_produccion.getValueAt(filaMod, 0);
        /*
         zona_produccion zona;
         zona = new zona_produccion(new javax.swing.JDialog(), true);
         zona.setVisible(true);*/
    }//GEN-LAST:event_tb_visor_produccionMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //id pedido
        //id serie
        agregar_pro_prod zp;
        zp = new agregar_pro_prod(new javax.swing.JDialog(), true);
        zp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb_visor_produccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_visor_produccionKeyPressed
        System.out.println("");
    }//GEN-LAST:event_tb_visor_produccionKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int filasel = tb_visor_produccion.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro válido");
        } else {

            int filaModi = tb_visor_produccion.getSelectedRow();
            cod_pro_sub = (String) tb_visor_produccion.getValueAt(filaModi, 0);


            /*   Ajuste_nota_cantidad an;
             an = new Ajuste_nota_cantidad(new javax.swing.JDialog(), true);
             an.setVisible(true);*/
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Visor_produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visor_produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visor_produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visor_produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Visor_produccion dialog = new Visor_produccion(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_nro_pedido;
    private javax.swing.JLabel lbl_serie;
    public static javax.swing.JTable tb_visor_produccion;
    // End of variables declaration//GEN-END:variables

}
