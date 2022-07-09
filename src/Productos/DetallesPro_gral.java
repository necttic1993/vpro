/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import Conexion_DB.conectar;
import static Productos.Productos.cod_pro_gral;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DetallesPro_gral extends javax.swing.JDialog {

    public DetallesPro_gral(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BuscarProductoDes(cod_pro_gral);
        cargarImage();

    }

    void BuscarProductoDes(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {

                lbl_des.setText(rs.getString(3));
                lbl_des_pro.setText(rs.getString(4));
                 //precios
                lbl_precio_a.setText(rs.getString(7));
                lbl_precioi_b.setText(rs.getString(8));
                lbl_departa.setText(rs.getString(17));
                lbl_cat.setText(rs.getString(18));
                lbl_sub_cat.setText(rs.getString(19));
                lbl_cat_esp.setText(rs.getString(20));
                lbl_marca.setText(rs.getString(21));
                lbl_color.setText(rs.getString(14));
                lbl_tc.setText(rs.getString(15));
                lblb_url_image.setText(rs.getString(62));

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
        lbl_ima_pro = new javax.swing.JLabel();
        txt_focus = new javax.swing.JTextField();
        lbl_tc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_precioi_b = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_des = new javax.swing.JLabel();
        lbl_departa = new javax.swing.JLabel();
        lbl_cat = new javax.swing.JLabel();
        lbl_sub_cat = new javax.swing.JLabel();
        lbl_cat_esp = new javax.swing.JLabel();
        lbl_marca = new javax.swing.JLabel();
        lbl_precio_a = new javax.swing.JLabel();
        lbl_color = new javax.swing.JLabel();
        lbl_des_pro = new javax.swing.JLabel();
        lblb_url_image = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ima_pro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_ima_pro.setForeground(new java.awt.Color(102, 102, 102));
        lbl_ima_pro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ima_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/ajust.png"))); // NOI18N
        lbl_ima_pro.setText("NO HAY IMAGEN DISPONIBLE");
        jPanel1.add(lbl_ima_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 400, 400));

        txt_focus.setBorder(null);
        txt_focus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_focusKeyPressed(evt);
            }
        });
        jPanel1.add(txt_focus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 0));

        lbl_tc.setBackground(new java.awt.Color(255, 255, 255));
        lbl_tc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_tc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_tc.setToolTipText("");
        lbl_tc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_tc.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_tc.setOpaque(true);
        jPanel1.add(lbl_tc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 140, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Descripción:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Departamento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Categoría:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Sub-Categoría:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Categoría Espec:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Marca:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 60, 30));

        lbl_precioi_b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_precioi_b.setText("0");
        jPanel1.add(lbl_precioi_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 210, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Color:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 60, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Tamaño/Calce:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 30));

        lbl_des.setBackground(new java.awt.Color(255, 255, 255));
        lbl_des.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_des.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_des.setToolTipText("");
        lbl_des.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_des.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_des.setOpaque(true);
        jPanel1.add(lbl_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 510, 30));

        lbl_departa.setBackground(new java.awt.Color(255, 255, 255));
        lbl_departa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_departa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_departa.setToolTipText("");
        lbl_departa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_departa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_departa.setOpaque(true);
        jPanel1.add(lbl_departa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 450, 30));

        lbl_cat.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_cat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_cat.setToolTipText("");
        lbl_cat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_cat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_cat.setOpaque(true);
        jPanel1.add(lbl_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 490, 30));

        lbl_sub_cat.setBackground(new java.awt.Color(255, 255, 255));
        lbl_sub_cat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_sub_cat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_sub_cat.setToolTipText("");
        lbl_sub_cat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_sub_cat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_sub_cat.setOpaque(true);
        jPanel1.add(lbl_sub_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 450, 30));

        lbl_cat_esp.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cat_esp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_cat_esp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_cat_esp.setToolTipText("");
        lbl_cat_esp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_cat_esp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_cat_esp.setOpaque(true);
        jPanel1.add(lbl_cat_esp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 430, 30));

        lbl_marca.setBackground(new java.awt.Color(255, 255, 255));
        lbl_marca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_marca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_marca.setToolTipText("");
        lbl_marca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_marca.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_marca.setOpaque(true);
        jPanel1.add(lbl_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 200, 30));

        lbl_precio_a.setBackground(new java.awt.Color(255, 255, 255));
        lbl_precio_a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_precio_a.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_precio_a.setText("0");
        lbl_precio_a.setToolTipText("");
        lbl_precio_a.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_precio_a.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_precio_a.setOpaque(true);
        jPanel1.add(lbl_precio_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 170, 30));

        lbl_color.setBackground(new java.awt.Color(255, 255, 255));
        lbl_color.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_color.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_color.setToolTipText("");
        lbl_color.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_color.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_color.setOpaque(true);
        jPanel1.add(lbl_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 250, 30));

        lbl_des_pro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_des_pro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_des_pro.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_des_pro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_des_pro.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(lbl_des_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 580, 60));

        lblb_url_image.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblb_url_image.setForeground(new java.awt.Color(0, 102, 51));
        lblb_url_image.setText("https://");
        jPanel1.add(lblb_url_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 930, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 580, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 580, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 580, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 580, 10));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 580, 10));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 580, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 580, 10));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 580, 10));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 580, 10));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Nombre:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("URL:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 40, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Precio A:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 70, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Precio B:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 70, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 460));

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
            java.util.logging.Logger.getLogger(DetallesPro_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesPro_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesPro_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesPro_gral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallesPro_gral dialog = new DetallesPro_gral(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbl_cat;
    private javax.swing.JLabel lbl_cat_esp;
    private javax.swing.JLabel lbl_color;
    private javax.swing.JLabel lbl_departa;
    private javax.swing.JLabel lbl_des;
    private javax.swing.JLabel lbl_des_pro;
    private javax.swing.JLabel lbl_ima_pro;
    private javax.swing.JLabel lbl_marca;
    private javax.swing.JLabel lbl_precio_a;
    private javax.swing.JLabel lbl_precioi_b;
    private javax.swing.JLabel lbl_sub_cat;
    private javax.swing.JLabel lbl_tc;
    private javax.swing.JLabel lblb_url_image;
    private javax.swing.JTextField txt_focus;
    // End of variables declaration//GEN-END:variables

    void cargarImage() {
        try {
            Image image = null;
            URL url;
            url = new URL(lblb_url_image.getText());
            image = ImageIO.read(url).getScaledInstance(lbl_ima_pro.getWidth(), lbl_ima_pro.getHeight(), Image.SCALE_SMOOTH);
            lbl_ima_pro.setIcon(new ImageIcon(image));
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "No se puedo cargar la imagen o el producto no cuenta con imagenes");
            Logger.getLogger(DetallesPro_gral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DetallesPro_gral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
