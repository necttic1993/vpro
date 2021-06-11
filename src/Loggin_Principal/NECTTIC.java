//<editor-fold defaultstate="collapsed" desc=" ZONA DE PAQUETE ">
package Loggin_Principal;

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" ZONA DE IMPORTACION ">
import Clases.machusculas;
import Conexion_DB.conectar;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import notifications.noti_backup;
import notifications.noti_login;

//</editor-fold>
public class NECTTIC extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    public static Principal ingreso;

    //</editor-fold>
    public NECTTIC() throws SocketException {

        initComponents();
        //  Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 20, 20);
        //AWTUtilities.setWindowShape(this, forma);
        txt_usu.requestFocus();
        // btn_acceder.setVisible(false);
        // ip();
        // mac();
        txt_usu.setDocument(new machusculas());

    }

    public static String cod = "";
    public static String mode = "";

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Iconos_1/necttic_ico.jpg"));

        return retValue;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        LBL_IP_COMPU = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_usu = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txt_pass = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbl_mac_compu = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chk_dark = new javax.swing.JCheckBox();
        btn_acceder = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESO AL SISTEMA");
        setBackground(new java.awt.Color(102, 255, 255));
        setForeground(new java.awt.Color(153, 255, 255));
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setLocation(new java.awt.Point(500, 300));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_salir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(153, 0, 0));
        btn_salir.setMnemonic('s');
        btn_salir.setText("x");
        btn_salir.setToolTipText("Salir");
        btn_salir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_salir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        btn_salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_salirKeyReleased(evt);
            }
        });
        jPanel4.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 30, 30));

        LBL_IP_COMPU.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        LBL_IP_COMPU.setForeground(new java.awt.Color(102, 102, 102));
        LBL_IP_COMPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(LBL_IP_COMPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 120, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shield.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 40, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/password.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 40, 30));

        txt_usu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_usu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usu.setBorder(null);
        txt_usu.setOpaque(false);
        txt_usu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usuMouseClicked(evt);
            }
        });
        txt_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuActionPerformed(evt);
            }
        });
        txt_usu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usuKeyReleased(evt);
            }
        });
        jPanel4.add(txt_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 230, 40));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator2.setToolTipText("");
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 230, 10));

        txt_pass.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setBorder(null);
        txt_pass.setOpaque(false);
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passKeyReleased(evt);
            }
        });
        jPanel4.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 230, 40));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setToolTipText("");
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 230, 10));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/necttic_ico.jpg"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 250, 210));

        lbl_mac_compu.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_mac_compu.setForeground(new java.awt.Color(102, 102, 102));
        lbl_mac_compu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lbl_mac_compu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 230, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/informacion.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, 40));

        jPanel2.setBackground(new java.awt.Color(0, 1, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 1, 78));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 1, 78));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 730, 7));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 730, 7));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 720, 3));

        jPanel3.setBackground(new java.awt.Color(0, 1, 78));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 1, 380));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/person.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 320, 170));

        jLabel6.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Iniciar Sesión");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 230, 40));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Necttic Software");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/noche.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 40, 40));

        chk_dark.setBackground(new java.awt.Color(255, 255, 255));
        chk_dark.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_dark.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        chk_dark.setBorderPainted(true);
        chk_dark.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chk_dark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_darkActionPerformed(evt);
            }
        });
        jPanel4.add(chk_dark, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 70, 40));

        btn_acceder.setBackground(new java.awt.Color(255, 255, 255));
        btn_acceder.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_acceder.setText("Ingresar");
        btn_acceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accederActionPerformed(evt);
            }
        });
        jPanel4.add(btn_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 210, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_salirKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {

            btn_salir.doClick();

        }
    }//GEN-LAST:event_btn_salirKeyReleased

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void txt_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyReleased

        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

            btn_acceder.doClick();

        }
    }//GEN-LAST:event_txt_passKeyReleased

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_usuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuKeyReleased
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

            txt_pass.requestFocus();

        }
    }//GEN-LAST:event_txt_usuKeyReleased

    private void txt_usuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {

            System.exit(0);

        }
    }//GEN-LAST:event_txt_usuKeyPressed

    private void txt_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuActionPerformed

    private void txt_usuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usuMouseClicked
        txt_usu.setText("");
    }//GEN-LAST:event_txt_usuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accederActionPerformed
        cod = txt_usu.getText();
        String usuario = txt_usu.getText();
        String pass = new String(txt_pass.getPassword());
        try {
            acceder(usuario, pass);
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_btn_accederActionPerformed

    private void btn_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cod = txt_usu.getText();
        String usuario = txt_usu.getText();
        String pass = new String(txt_pass.getPassword());
        try {
            acceder(usuario, pass);
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chk_darkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_darkActionPerformed
        // chk_dark.setSelected(false);
        dark = "oscuro";
        mode = dark;
        System.out.println(dark);

    }//GEN-LAST:event_chk_darkActionPerformed

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
            java.util.logging.Logger.getLogger(NECTTIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NECTTIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NECTTIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NECTTIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {
                    new NECTTIC().setVisible(true);
                } catch (SocketException ex) {
                    Logger.getLogger(NECTTIC.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBL_IP_COMPU;
    private javax.swing.JButton btn_acceder;
    private javax.swing.JButton btn_salir;
    private javax.swing.JCheckBox chk_dark;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_mac_compu;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_usu;
    // End of variables declaration//GEN-END:variables

    void acceder(String usuario, String pass) throws IOException {

        int result = 0;
        String sql = "SELECT * FROM usuarios WHERE usu_cod='" + usuario + "' && password='" + pass + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                result = 1;

                if (result == 1) {
                    conectar.getInstance().closeConnection(cn);
                    System.out.println("desconectar acceso");
                    this.setVisible(false);
                    ingreso = new Principal();
                    ingreso.setVisible(true);
                    ingreso.pack();
                    noti_backup logi = new noti_backup();
                    logi.setVisible(true);
                }

            } else {
                noti_login log = new noti_login();
                log.setVisible(true);

                AudioClip audio;
                audio = java.applet.Applet.newAudioClip(getClass().getResource("/Loggin_Principal/error.wav"));
                audio.play();
                conectar.getInstance().closeConnection(cn);
                System.out.println("desconectar acceso 2");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void ip() throws SocketException {

        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("IP Local :" + address.getHostAddress());
            //   LBL_IP_COMPU.setText(address.getHostAddress());
            // Aqui obtenemos la ip de la web del programador
   /*     String domain="www.lawebdelprogramador.com";
             InetAddress address2 = InetAddress.getByName(domain);
             byte IP[] = address2.getAddress();
             System.out.print("IP del dominio "+domain+" :");
             for (int index = 0; index < IP.length; index++)
             {
             if (index > 0)
             System.out.print(".");
             System.out.print(((int)IP[index])& 0xff);
             }*/
        } catch (Exception ex) {

        }

    }

    void mac() {

        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            LBL_IP_COMPU.setText("IP:" + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());
            lbl_mac_compu.setText("MAC:" + sb.toString());

        } catch (UnknownHostException | SocketException e) {
        }

    }

    private String dark;
}
