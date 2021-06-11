/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS;

import Conexion_DB.conectar;
import static OS.Principapl_OS.cod_deta_os;
import static Productos.Productos.cod_pro_gral;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class Detalles_OS extends javax.swing.JDialog {

    /**
     * Creates new form DetallesProductos
     */
    public Detalles_OS(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BuscarProductoDes(cod_deta_os);

    }

    void BuscarProductoDes(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from os WHERE os_nro='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                lbl_os_nro.setText(rs.getString(1));
                lbl_os_serie.setText(rs.getString(2));
                lbl_fecha_entra.setText(rs.getString(3));
                lbl_cliente.setText(rs.getString(5));
                lbl_productos.setText(rs.getString(7));
                lbl_defectos.setText(rs.getString(10));
                lbl_estado.setText(rs.getString(11));
                lbl_des.setText(rs.getString(12));
                lbl_piezas.setText(rs.getString(13));
                lbl_detalles.setText(rs.getString(14));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_focus = new javax.swing.JTextField();
        lbl_detalles = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_os_nro = new javax.swing.JLabel();
        lbl_os_serie = new javax.swing.JLabel();
        lbl_fecha_entra = new javax.swing.JLabel();
        lbl_cliente = new javax.swing.JLabel();
        lbl_productos = new javax.swing.JLabel();
        lbl_defectos = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        lbl_des = new javax.swing.JLabel();
        lbl_piezas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_focus.setBorder(null);
        txt_focus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_focusKeyPressed(evt);
            }
        });
        jPanel1.add(txt_focus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 0));

        lbl_detalles.setBackground(new java.awt.Color(255, 255, 255));
        lbl_detalles.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_detalles.setForeground(new java.awt.Color(0, 102, 102));
        lbl_detalles.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_detalles.setToolTipText("");
        lbl_detalles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_detalles.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_detalles.setOpaque(true);
        jPanel1.add(lbl_detalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 520, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Piezas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 80, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("O.S Nro.:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Serie Nro.:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de Entrada:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Cliente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 60, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Producto/Pieza:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Defecto Reclamado:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Estado(condición):");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 140, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Descripción:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Detalles:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 140, 30));

        lbl_os_nro.setBackground(new java.awt.Color(255, 255, 255));
        lbl_os_nro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_os_nro.setForeground(new java.awt.Color(255, 0, 0));
        lbl_os_nro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_os_nro.setToolTipText("");
        lbl_os_nro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_os_nro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_os_nro.setOpaque(true);
        jPanel1.add(lbl_os_nro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 180, 30));

        lbl_os_serie.setBackground(new java.awt.Color(255, 255, 255));
        lbl_os_serie.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_os_serie.setForeground(new java.awt.Color(0, 102, 102));
        lbl_os_serie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_os_serie.setToolTipText("");
        lbl_os_serie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_os_serie.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_os_serie.setOpaque(true);
        jPanel1.add(lbl_os_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 440, 30));

        lbl_fecha_entra.setBackground(new java.awt.Color(255, 255, 255));
        lbl_fecha_entra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_fecha_entra.setForeground(new java.awt.Color(0, 102, 102));
        lbl_fecha_entra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_fecha_entra.setToolTipText("");
        lbl_fecha_entra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_fecha_entra.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_fecha_entra.setOpaque(true);
        jPanel1.add(lbl_fecha_entra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 120, 30));

        lbl_cliente.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_cliente.setForeground(new java.awt.Color(0, 102, 102));
        lbl_cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_cliente.setToolTipText("");
        lbl_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_cliente.setOpaque(true);
        jPanel1.add(lbl_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 500, 30));

        lbl_productos.setBackground(new java.awt.Color(255, 255, 255));
        lbl_productos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_productos.setForeground(new java.awt.Color(0, 102, 102));
        lbl_productos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_productos.setToolTipText("");
        lbl_productos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_productos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_productos.setOpaque(true);
        jPanel1.add(lbl_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 460, 30));

        lbl_defectos.setBackground(new java.awt.Color(255, 255, 255));
        lbl_defectos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_defectos.setForeground(new java.awt.Color(0, 102, 102));
        lbl_defectos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_defectos.setToolTipText("");
        lbl_defectos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_defectos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_defectos.setOpaque(true);
        jPanel1.add(lbl_defectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 440, 30));

        lbl_estado.setBackground(new java.awt.Color(255, 255, 255));
        lbl_estado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_estado.setForeground(new java.awt.Color(0, 102, 102));
        lbl_estado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_estado.setToolTipText("");
        lbl_estado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_estado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_estado.setOpaque(true);
        jPanel1.add(lbl_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 440, 30));

        lbl_des.setBackground(new java.awt.Color(255, 255, 255));
        lbl_des.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_des.setForeground(new java.awt.Color(0, 102, 102));
        lbl_des.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_des.setToolTipText("");
        lbl_des.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_des.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_des.setOpaque(true);
        jPanel1.add(lbl_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 510, 30));

        lbl_piezas.setBackground(new java.awt.Color(255, 255, 255));
        lbl_piezas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_piezas.setForeground(new java.awt.Color(0, 102, 102));
        lbl_piezas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_piezas.setToolTipText("");
        lbl_piezas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_piezas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_piezas.setOpaque(true);
        jPanel1.add(lbl_piezas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 480, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_focusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_focusKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txt_focusKeyPressed

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
            java.util.logging.Logger.getLogger(Detalles_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalles_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalles_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalles_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detalles_OS dialog = new Detalles_OS(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_defectos;
    private javax.swing.JLabel lbl_des;
    private javax.swing.JLabel lbl_detalles;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_fecha_entra;
    private javax.swing.JLabel lbl_os_nro;
    private javax.swing.JLabel lbl_os_serie;
    private javax.swing.JLabel lbl_piezas;
    private javax.swing.JLabel lbl_productos;
    private javax.swing.JTextField txt_focus;
    // End of variables declaration//GEN-END:variables

}
