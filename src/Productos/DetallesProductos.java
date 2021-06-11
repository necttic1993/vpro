/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import static Compras.Productos_compras.cod_pro_compras;
import Conexion_DB.conectar;
import static Productos.Productos.cod_imagen;
import static Productos.Productos.cod_pro;
import static Ventas.Productos_ventas.cod_pro_ventas;
import static Ventas.Productos_ventas.cod_pro_ventas_des;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class DetallesProductos extends javax.swing.JDialog {

    /**
     * Creates new form DetallesProductos
     */
    public DetallesProductos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BuscarProducto(cod_imagen);
        BuscarProductoDes(cod_imagen);

        BuscarProducto(cod_pro_ventas);
        BuscarProductoDes(cod_pro_ventas);

        BuscarProducto(cod_pro_compras);
        BuscarProductoDes(cod_pro_compras);
        BuscarProducto(cod_pro_ventas_des);
        BuscarProductoDes(cod_pro_ventas_des);
        BuscarProducto(cod_pro);
        BuscarProductoDes(cod_pro);
    }

    void BuscarProducto(String cod) {
        ImageIcon foto;
        InputStream is;
        ImageIcon foto2;
        InputStream is2;
        ImageIcon foto3;
        InputStream is3;
        ImageIcon foto4;
        InputStream is4;
        ImageIcon foto5;
        InputStream is5;

        try {
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from imag_productos WHERE imag_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {

                is = rs.getBinaryStream(2);
                is2 = rs.getBinaryStream(3);
                is3 = rs.getBinaryStream(4);
                is4 = rs.getBinaryStream(5);
                is5 = rs.getBinaryStream(6);

                if (is == null) {
                    System.out.println("imagen vacia");
                } else {
                    BufferedImage bi = ImageIO.read(is);
                    foto = new ImageIcon(bi);
                    Image img = foto.getImage();
                    Image newimg = img.getScaledInstance(330, 490, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(newimg);
                    lbl_ima1.setIcon(newicon);
                }
                if (is2 == null) {
                    System.out.println("imagen vacia2");
                } else {
                    BufferedImage bi2 = ImageIO.read(is2);
                    foto2 = new ImageIcon(bi2);
                    Image img2 = foto2.getImage();
                    Image newimg2 = img2.getScaledInstance(340, 240, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon2 = new ImageIcon(newimg2);
                    lbl_ima2.setIcon(newicon2);

                }
                if (is3 == null) {
                    System.out.println("imagen vacia3");
                } else {
                    BufferedImage bi3 = ImageIO.read(is3);
                    foto3 = new ImageIcon(bi3);
                    Image img3 = foto3.getImage();
                    Image newimg3 = img3.getScaledInstance(340, 240, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon3 = new ImageIcon(newimg3);
                    lbl_ima3.setIcon(newicon3);

                }
                if (is4 == null) {
                    System.out.println("imagen vacia4");
                } else {

                    BufferedImage bi4 = ImageIO.read(is4);
                    foto4 = new ImageIcon(bi4);
                    Image img4 = foto4.getImage();
                    Image newimg4 = img4.getScaledInstance(340, 240, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon4 = new ImageIcon(newimg4);
                    lbl_ima4.setIcon(newicon4);
                }
                if (is5 == null) {
                    System.out.println("imagen vacia5");
                } else {

                    BufferedImage bi5 = ImageIO.read(is5);
                    foto5 = new ImageIcon(bi5);
                    Image img5 = foto5.getImage();
                    Image newimg5 = img5.getScaledInstance(340, 240, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon5 = new ImageIcon(newimg5);
                    lbl_ima5.setIcon(newicon5);
                }

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarProductoDes(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                lbl_des.setText(rs.getString(4));

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
        lbl_ima1 = new javax.swing.JLabel();
        lbl_ima2 = new javax.swing.JLabel();
        txt_focus = new javax.swing.JTextField();
        lbl_des = new javax.swing.JLabel();
        lbl_ima3 = new javax.swing.JLabel();
        lbl_ima4 = new javax.swing.JLabel();
        lbl_ima5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ima1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(lbl_ima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 490));

        lbl_ima2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(lbl_ima2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 340, 240));

        txt_focus.setBorder(null);
        txt_focus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_focusKeyPressed(evt);
            }
        });
        jPanel1.add(txt_focus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 0));

        lbl_des.setBackground(new java.awt.Color(255, 255, 255));
        lbl_des.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_des.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_des.setToolTipText("");
        lbl_des.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_des.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_des.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_des.setOpaque(true);
        jPanel1.add(lbl_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 830, 30));

        lbl_ima3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(lbl_ima3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 340, 240));

        lbl_ima4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(lbl_ima4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 340, 240));

        lbl_ima5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(lbl_ima5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 340, 240));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 550));

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
            java.util.logging.Logger.getLogger(DetallesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallesProductos dialog = new DetallesProductos(new javax.swing.JDialog(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_des;
    private javax.swing.JLabel lbl_ima1;
    private javax.swing.JLabel lbl_ima2;
    private javax.swing.JLabel lbl_ima3;
    private javax.swing.JLabel lbl_ima4;
    private javax.swing.JLabel lbl_ima5;
    private javax.swing.JTextField txt_focus;
    // End of variables declaration//GEN-END:variables

}
