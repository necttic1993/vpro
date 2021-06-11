/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import Conexion_DB.conectar;
import static Productos.Actual_Productos.cod_pro_actu;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Update_ima extends javax.swing.JDialog {

    long OL;
    FileInputStream fis;
    FileInputStream fis2;
    FileInputStream fis3;
    FileInputStream fis4;
    FileInputStream fis5;

    int longitudBytes;
    int longitudBytes2;
    int longitudBytes3;
    int longitudBytes4;
    int longitudBytes5;

    public Update_ima(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtcod.setEnabled(false);
        BuscarProducto(cod_pro_actu);
        txtcod.setText(cod_pro_actu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_ima1 = new javax.swing.JLabel();
        lbl_ima2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        lbl_ima3 = new javax.swing.JLabel();
        lbl_ima4 = new javax.swing.JLabel();
        lbl_ima5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Imagen");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ima1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        lbl_ima1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ima1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ima1MouseClicked(evt);
            }
        });
        jPanel1.add(lbl_ima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 280));

        lbl_ima2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        lbl_ima2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ima2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ima2MouseClicked(evt);
            }
        });
        jPanel1.add(lbl_ima2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 320, 280));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 540, 130, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Código del Producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, -1, 30));

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 150, 30));

        lbl_ima3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        lbl_ima3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ima3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ima3MouseClicked(evt);
            }
        });
        jPanel1.add(lbl_ima3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 320, 280));

        lbl_ima4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        lbl_ima4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ima4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ima4MouseClicked(evt);
            }
        });
        jPanel1.add(lbl_ima4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 320, 280));

        lbl_ima5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        lbl_ima5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ima5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ima5MouseClicked(evt);
            }
        });
        jPanel1.add(lbl_ima5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 320, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 590));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Se modificará el registro, ¿desea continuar?",
                "Modificar Imagen", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            eliminarProducto();

            String sql = "";
            String cod = txtcod.getText();

            sql = "INSERT INTO imag_productos (imag_cod,imag_foto1,imag_foto2,imag_foto3,imag_foto4,imag_foto5) VALUES (?,?,?,?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, cod);
                pst.setBinaryStream(2, fis, longitudBytes);
                pst.setBinaryStream(3, fis2, longitudBytes2);
                pst.setBinaryStream(4, fis3, longitudBytes3);
                pst.setBinaryStream(5, fis4, longitudBytes4);
                pst.setBinaryStream(6, fis5, longitudBytes5);

                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Imágenes Guardados ");
                    lbl_ima1.setIcon(null);
                    lbl_ima2.setIcon(null);
                    lbl_ima3.setIcon(null);
                    lbl_ima4.setIcon(null);
                    lbl_ima5.setIcon(null);

                }
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(Update_ima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lbl_ima2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ima2MouseClicked
        lbl_ima2.setIcon(null);
        JFileChooser j2 = new JFileChooser();
        j2.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado2 = j2.showOpenDialog(null);
        if (estado2 == JFileChooser.APPROVE_OPTION) {
            try {
                fis2 = new FileInputStream(j2.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes2 = (int) j2.getSelectedFile().length();
                try {
                    Image icono2 = ImageIO.read(j2.getSelectedFile()).getScaledInstance(lbl_ima2.getWidth(), lbl_ima2.getHeight(), Image.SCALE_DEFAULT);
                    lbl_ima2.setIcon(new ImageIcon(icono2));
                    lbl_ima2.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_lbl_ima2MouseClicked

    private void lbl_ima1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ima1MouseClicked
        lbl_ima1.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbl_ima1.getWidth(), lbl_ima1.getHeight(), Image.SCALE_DEFAULT);
                    lbl_ima1.setIcon(new ImageIcon(icono));
                    lbl_ima1.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_lbl_ima1MouseClicked

    private void lbl_ima3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ima3MouseClicked
        lbl_ima3.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis3 = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes3 = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbl_ima3.getWidth(), lbl_ima3.getHeight(), Image.SCALE_DEFAULT);
                    lbl_ima3.setIcon(new ImageIcon(icono));
                    lbl_ima3.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_lbl_ima3MouseClicked

    private void lbl_ima4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ima4MouseClicked
        lbl_ima4.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis4 = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes4 = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbl_ima4.getWidth(), lbl_ima4.getHeight(), Image.SCALE_DEFAULT);
                    lbl_ima4.setIcon(new ImageIcon(icono));
                    lbl_ima4.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_lbl_ima4MouseClicked

    private void lbl_ima5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ima5MouseClicked
        lbl_ima5.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis5 = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes5 = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbl_ima5.getWidth(), lbl_ima5.getHeight(), Image.SCALE_DEFAULT);
                    lbl_ima5.setIcon(new ImageIcon(icono));
                    lbl_ima5.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_lbl_ima5MouseClicked

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
            java.util.logging.Logger.getLogger(Update_ima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_ima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_ima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_ima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Update_ima dialog = new Update_ima(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_ima1;
    private javax.swing.JLabel lbl_ima2;
    private javax.swing.JLabel lbl_ima3;
    private javax.swing.JLabel lbl_ima4;
    private javax.swing.JLabel lbl_ima5;
    private javax.swing.JTextField txtcod;
    // End of variables declaration//GEN-END:variables

    void eliminarProducto() {

        String cod = txtcod.getText();
        String eliminarSQL = "DELETE FROM imag_productos WHERE imag_cod = '" + cod + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(eliminarSQL);

            pst.executeUpdate();
            // JOptionPane.showMessageDialog(null, "Borrado");
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
                    Image newimg = img.getScaledInstance(340, 240, java.awt.Image.SCALE_SMOOTH);
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

}
