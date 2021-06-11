/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Clases.GenerarNumero;
import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
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
public class Agenda_diaria extends javax.swing.JDialog {

    DefaultTableModel model;

    public Agenda_diaria(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_des.setDocument(new machusculas());
        txt_nom.setDocument(new machusculas());
        txt_cod.setVisible(false);
        lbl_fecha.setText(fechaact());
        lbl_fecha.setVisible(false);
        lbl_dia_agenda.setText(Principal.lbl_fecha_principal.getText());

        cargar();
        codigos();
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
        txt_des = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_cap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        lbl_dia_agenda = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_agenda = new javax.swing.JTable();
        lbl_fecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notificaciones");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_des.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 580, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/ok.png"))); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 110, 40));

        txt_cap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_cap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_capActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cap, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 190, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Temática:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        txt_cod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 80, -1));

        txt_nom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 340, -1));

        lbl_dia_agenda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_dia_agenda.setText("05/05/2019");
        jPanel1.add(lbl_dia_agenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 110, 50));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Mensaje:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        tb_agenda = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_agenda.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_agenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_agenda.setRequestFocusEnabled(false);
        tb_agenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_agendaMouseClicked(evt);
            }
        });
        tb_agenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_agendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_agendaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_agendaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_agenda);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 970, 380));

        lbl_fecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_fecha.setForeground(new java.awt.Color(102, 102, 102));
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_fecha.setText("Nro");
        jPanel1.add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 40, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loggin_Principal/calendario.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 70, 50));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Asunto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "";
        String cod = txt_cod.getText();
        String nom = txt_nom.getText();
        String des = txt_des.getText();
        String cap = txt_cap.getText();
        String user = Principal.lbl_usu_nom.getText();
        String fecha_age = lbl_fecha.getText();

        sql = "INSERT INTO agenda_diaria (age_cod,age_asu,age_men,age_tem,age_usu,fecha_age) VALUES (?,?,?,?,?,?)";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cod);
            pst.setString(2, nom);
            pst.setString(3, des);
            pst.setString(4, cap);
            pst.setString(5, user);
            pst.setString(6, fecha_age);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Mensaje enviado ");
                txt_cod.setText("");
                txt_nom.setText("");
                txt_des.setText("");
                txt_cap.setText("");
                cargar();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Agenda_diaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        codigos();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_capActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_capActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_capActionPerformed

    private void tb_agendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_agendaMouseClicked

    }//GEN-LAST:event_tb_agendaMouseClicked

    private void tb_agendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_agendaKeyPressed

    }//GEN-LAST:event_tb_agendaKeyPressed

    private void tb_agendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_agendaKeyReleased

    }//GEN-LAST:event_tb_agendaKeyReleased

    private void tb_agendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_agendaKeyTyped

    }//GEN-LAST:event_tb_agendaKeyTyped

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
            java.util.logging.Logger.getLogger(Agenda_diaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda_diaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda_diaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda_diaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agenda_diaria dialog = new Agenda_diaria(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_dia_agenda;
    public static javax.swing.JLabel lbl_fecha;
    public static javax.swing.JTable tb_agenda;
    private javax.swing.JTextField txt_cap;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_des;
    private javax.swing.JTextField txt_nom;
    // End of variables declaration//GEN-END:variables
;

    void codigos() {

        String c = "";
        String SQL = "select max(age_cod) from agenda_diaria";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txt_cod.setText("00000001");
            } else {
                int j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                txt_cod.setText(gen.serie());
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Agenda_diaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar() {
        try {
            String data = lbl_fecha.getText();
            String[] titulos = {"Asunto", "Mensaje", "Temática", "Usuario"};
            String[] registros = new String[4];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from agenda_diaria WHERE fecha_age = '" + data + "' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(2);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(4);
                registros[3] = rs.getString(5);

                model.addRow(registros);
            }
            tb_agenda.setModel(model);
            tb_agenda.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_agenda.getColumnModel().getColumn(1).setPreferredWidth(450);
            tb_agenda.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_agenda.getColumnModel().getColumn(3).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Agenda_diaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
