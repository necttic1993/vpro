/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class permisos_user extends javax.swing.JDialog {

    DefaultTableModel model;

    Statement sent;

    public permisos_user(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_cod_id.setVisible(false);
        cargar("");
        cargargrupo();
        panel_invi.setVisible(false);

    }

    void cargar(String tipo) {
        String[] titulos = {"m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10", "m11", "m12", "m13", "m14", "m15", "m16", "m17", "m18", "m19", "id", "m20", "m21", "m22", "m23", "m24", "m25", "m26", "m27", "m28", "m29", "m30", "m31", "m32", "m33", "m34", "m35", "m36", "m37", "m38"};
        String[] registros = new String[39];

        String sql = "SELECT * FROM user_permisos where user_grupo='" + tipo + "'";

        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString(3);
                registros[1] = rs.getString(4);
                registros[2] = rs.getString(5);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(7);
                registros[5] = rs.getString(8);
                registros[6] = rs.getString(9);
                registros[7] = rs.getString(10);
                registros[8] = rs.getString(11);
                registros[9] = rs.getString(12);
                registros[10] = rs.getString(13);
                registros[11] = rs.getString(14);
                registros[12] = rs.getString(15);
                registros[13] = rs.getString(16);
                registros[14] = rs.getString(17);
                registros[15] = rs.getString(18);
                registros[16] = rs.getString(19);
                registros[17] = rs.getString(20);
                registros[18] = rs.getString(21);
                registros[19] = rs.getString(1);
                registros[20] = rs.getString(22);
                registros[21] = rs.getString(23);
                registros[22] = rs.getString(24);
                registros[23] = rs.getString(25);
                registros[24] = rs.getString(26);
                registros[25] = rs.getString(27);
                registros[26] = rs.getString(28);
                registros[27] = rs.getString(29);
                registros[28] = rs.getString(30);
                registros[29] = rs.getString(31);
                registros[30] = rs.getString(32);
                registros[31] = rs.getString(33);
                registros[32] = rs.getString(34);
                registros[33] = rs.getString(35);
                registros[34] = rs.getString(36);
                registros[35] = rs.getString(37);
                registros[36] = rs.getString(38);
                registros[37] = rs.getString(39);
                registros[38] = rs.getString(40);

                model.addRow(registros);

            }
            tb_permisos.setModel(model);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        m3_si = new javax.swing.JCheckBox();
        m3_no = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        m4_si = new javax.swing.JCheckBox();
        m4_no = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        menu_logistica = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        menu_cat_espec = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        m5_si = new javax.swing.JCheckBox();
        m5_no = new javax.swing.JCheckBox();
        m6_si = new javax.swing.JCheckBox();
        m6_no = new javax.swing.JCheckBox();
        m7_si = new javax.swing.JCheckBox();
        m7_no = new javax.swing.JCheckBox();
        m8_si = new javax.swing.JCheckBox();
        m8_no = new javax.swing.JCheckBox();
        m14_si = new javax.swing.JCheckBox();
        m14_no = new javax.swing.JCheckBox();
        m10_si = new javax.swing.JCheckBox();
        m10_no = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        m11_si = new javax.swing.JCheckBox();
        m11_no = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        m12_si = new javax.swing.JCheckBox();
        m12_no = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        m13_si = new javax.swing.JCheckBox();
        m13_no = new javax.swing.JCheckBox();
        menu_cat_espec1 = new javax.swing.JLabel();
        m9_si = new javax.swing.JCheckBox();
        m9_no = new javax.swing.JCheckBox();
        menu_cat_espec2 = new javax.swing.JLabel();
        m15_si = new javax.swing.JCheckBox();
        m15_no = new javax.swing.JCheckBox();
        menu_cat_espec3 = new javax.swing.JLabel();
        m16_si = new javax.swing.JCheckBox();
        m16_no = new javax.swing.JCheckBox();
        menu_cat_espec4 = new javax.swing.JLabel();
        m17_si = new javax.swing.JCheckBox();
        m17_no = new javax.swing.JCheckBox();
        menu_cat_espec5 = new javax.swing.JLabel();
        m18_si = new javax.swing.JCheckBox();
        m18_no = new javax.swing.JCheckBox();
        menu_cat_espec6 = new javax.swing.JLabel();
        m19_si = new javax.swing.JCheckBox();
        m19_no = new javax.swing.JCheckBox();
        menu_cat_espec7 = new javax.swing.JLabel();
        m20_si = new javax.swing.JCheckBox();
        m20_no = new javax.swing.JCheckBox();
        txt_cod_id = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        panel_invi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_permisos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        menu_cat_espec8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        menu_cat_espec9 = new javax.swing.JLabel();
        menu_cat_espec10 = new javax.swing.JLabel();
        m21_si = new javax.swing.JCheckBox();
        m21_no = new javax.swing.JCheckBox();
        menu_cat_espec11 = new javax.swing.JLabel();
        m22_si = new javax.swing.JCheckBox();
        m22_no = new javax.swing.JCheckBox();
        menu_cat_espec12 = new javax.swing.JLabel();
        m23_si = new javax.swing.JCheckBox();
        m23_no = new javax.swing.JCheckBox();
        m32_si = new javax.swing.JCheckBox();
        m32_no = new javax.swing.JCheckBox();
        menu_cat_espec13 = new javax.swing.JLabel();
        menu_cat_espec14 = new javax.swing.JLabel();
        m24_si = new javax.swing.JCheckBox();
        m24_no = new javax.swing.JCheckBox();
        m25_no = new javax.swing.JCheckBox();
        m25_si = new javax.swing.JCheckBox();
        menu_cat_espec15 = new javax.swing.JLabel();
        menu_cat_espec16 = new javax.swing.JLabel();
        m26_si = new javax.swing.JCheckBox();
        m26_no = new javax.swing.JCheckBox();
        m27_no = new javax.swing.JCheckBox();
        m27_si = new javax.swing.JCheckBox();
        menu_cat_espec17 = new javax.swing.JLabel();
        menu_cat_espec18 = new javax.swing.JLabel();
        m28_si = new javax.swing.JCheckBox();
        m28_no = new javax.swing.JCheckBox();
        m29_no = new javax.swing.JCheckBox();
        m29_si = new javax.swing.JCheckBox();
        menu_cat_espec19 = new javax.swing.JLabel();
        menu_cat_espec20 = new javax.swing.JLabel();
        menu_cat_espec21 = new javax.swing.JLabel();
        m30_si = new javax.swing.JCheckBox();
        m30_no = new javax.swing.JCheckBox();
        menu_cat_espec22 = new javax.swing.JLabel();
        menu_cat_espec23 = new javax.swing.JLabel();
        m31_si = new javax.swing.JCheckBox();
        m31_no = new javax.swing.JCheckBox();
        menu_cat_espec24 = new javax.swing.JLabel();
        m33_si = new javax.swing.JCheckBox();
        m33_no = new javax.swing.JCheckBox();
        cb_grupo_usu = new org.jdesktop.swingx.JXComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        menu_cat_espec25 = new javax.swing.JLabel();
        menu_cat_espec26 = new javax.swing.JLabel();
        m34_si = new javax.swing.JCheckBox();
        m34_no = new javax.swing.JCheckBox();
        m35_si = new javax.swing.JCheckBox();
        m35_no = new javax.swing.JCheckBox();
        m36_no = new javax.swing.JCheckBox();
        m36_si = new javax.swing.JCheckBox();
        m37_si = new javax.swing.JCheckBox();
        m37_no = new javax.swing.JCheckBox();
        menu_cat_espec27 = new javax.swing.JLabel();
        m38_si = new javax.swing.JCheckBox();
        m38_no = new javax.swing.JCheckBox();
        menu_cat_espec28 = new javax.swing.JLabel();
        menu_cat_espec29 = new javax.swing.JLabel();
        m2_no = new javax.swing.JCheckBox();
        m2_si = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Control de accesos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("-Backup");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        m3_si.setBackground(new java.awt.Color(255, 255, 255));
        m3_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m3_si.setText("SI");
        m3_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m3_siActionPerformed(evt);
            }
        });
        jPanel1.add(m3_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, 20));

        m3_no.setBackground(new java.awt.Color(255, 255, 255));
        m3_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m3_no.setText("NO");
        m3_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m3_noActionPerformed(evt);
            }
        });
        jPanel1.add(m3_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 40, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("-Usuarios");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 110, 20));

        m4_si.setBackground(new java.awt.Color(255, 255, 255));
        m4_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m4_si.setText("SI");
        m4_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m4_siActionPerformed(evt);
            }
        });
        jPanel1.add(m4_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 20));

        m4_no.setBackground(new java.awt.Color(255, 255, 255));
        m4_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m4_no.setText("NO");
        m4_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m4_noActionPerformed(evt);
            }
        });
        jPanel1.add(m4_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Update");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 110, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1090, 10));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/town.png"))); // NOI18N
        jLabel8.setText("DATOS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("-Productos");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 20));

        menu_logistica.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_logistica.setText("-Logística");
        jPanel1.add(menu_logistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, 20));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("-Clientes");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("-Proveedores");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 20));

        menu_cat_espec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec.setText("-Caja");
        jPanel1.add(menu_cat_espec, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 110, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 102));
        jLabel19.setText("-Compras");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 110, 20));

        m5_si.setBackground(new java.awt.Color(255, 255, 255));
        m5_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m5_si.setText("SI");
        m5_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m5_siActionPerformed(evt);
            }
        });
        jPanel1.add(m5_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, 20));

        m5_no.setBackground(new java.awt.Color(255, 255, 255));
        m5_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m5_no.setText("NO");
        m5_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m5_noActionPerformed(evt);
            }
        });
        jPanel1.add(m5_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, 20));

        m6_si.setBackground(new java.awt.Color(255, 255, 255));
        m6_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m6_si.setText("SI");
        m6_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m6_siActionPerformed(evt);
            }
        });
        jPanel1.add(m6_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, 20));

        m6_no.setBackground(new java.awt.Color(255, 255, 255));
        m6_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m6_no.setText("NO");
        m6_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m6_noActionPerformed(evt);
            }
        });
        jPanel1.add(m6_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, 20));

        m7_si.setBackground(new java.awt.Color(255, 255, 255));
        m7_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m7_si.setText("SI");
        m7_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m7_siActionPerformed(evt);
            }
        });
        jPanel1.add(m7_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 20));

        m7_no.setBackground(new java.awt.Color(255, 255, 255));
        m7_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m7_no.setText("NO");
        m7_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m7_noActionPerformed(evt);
            }
        });
        jPanel1.add(m7_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, 20));

        m8_si.setBackground(new java.awt.Color(255, 255, 255));
        m8_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m8_si.setText("SI");
        m8_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m8_siActionPerformed(evt);
            }
        });
        jPanel1.add(m8_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 20));

        m8_no.setBackground(new java.awt.Color(255, 255, 255));
        m8_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m8_no.setText("NO");
        m8_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m8_noActionPerformed(evt);
            }
        });
        jPanel1.add(m8_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, 20));

        m14_si.setBackground(new java.awt.Color(255, 255, 255));
        m14_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m14_si.setForeground(new java.awt.Color(0, 153, 0));
        m14_si.setText("SI");
        m14_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m14_siActionPerformed(evt);
            }
        });
        jPanel1.add(m14_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, 20));

        m14_no.setBackground(new java.awt.Color(255, 255, 255));
        m14_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m14_no.setForeground(new java.awt.Color(0, 153, 0));
        m14_no.setText("NO");
        m14_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m14_noActionPerformed(evt);
            }
        });
        jPanel1.add(m14_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, 20));

        m10_si.setBackground(new java.awt.Color(255, 255, 255));
        m10_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m10_si.setForeground(new java.awt.Color(0, 51, 102));
        m10_si.setText("SI");
        m10_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m10_siActionPerformed(evt);
            }
        });
        jPanel1.add(m10_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 20));

        m10_no.setBackground(new java.awt.Color(255, 255, 255));
        m10_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m10_no.setForeground(new java.awt.Color(0, 51, 102));
        m10_no.setText("NO");
        m10_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m10_noActionPerformed(evt);
            }
        });
        jPanel1.add(m10_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/orden.png"))); // NOI18N
        jLabel9.setText("MOVIMIENTOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 180, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/bank.png"))); // NOI18N
        jLabel10.setText("FINANCIERO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 150, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jLabel11.setText("ESTADÍSTICAS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 200, 40));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 102));
        jLabel20.setText("-Devoluciones");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 110, 20));

        m11_si.setBackground(new java.awt.Color(255, 255, 255));
        m11_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m11_si.setForeground(new java.awt.Color(0, 51, 102));
        m11_si.setText("SI");
        m11_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m11_siActionPerformed(evt);
            }
        });
        jPanel1.add(m11_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, 20));

        m11_no.setBackground(new java.awt.Color(255, 255, 255));
        m11_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m11_no.setForeground(new java.awt.Color(0, 51, 102));
        m11_no.setText("NO");
        m11_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m11_noActionPerformed(evt);
            }
        });
        jPanel1.add(m11_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, 20));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 102));
        jLabel21.setText("-Presupuestos");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 110, 20));

        m12_si.setBackground(new java.awt.Color(255, 255, 255));
        m12_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m12_si.setForeground(new java.awt.Color(0, 51, 102));
        m12_si.setText("SI");
        m12_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m12_siActionPerformed(evt);
            }
        });
        jPanel1.add(m12_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, 20));

        m12_no.setBackground(new java.awt.Color(255, 255, 255));
        m12_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m12_no.setForeground(new java.awt.Color(0, 51, 102));
        m12_no.setText("NO");
        m12_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m12_noActionPerformed(evt);
            }
        });
        jPanel1.add(m12_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 102));
        jLabel22.setText("-Recibos");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 110, 20));

        m13_si.setBackground(new java.awt.Color(255, 255, 255));
        m13_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m13_si.setForeground(new java.awt.Color(0, 51, 102));
        m13_si.setText("SI");
        m13_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m13_siActionPerformed(evt);
            }
        });
        jPanel1.add(m13_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, 20));

        m13_no.setBackground(new java.awt.Color(255, 255, 255));
        m13_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m13_no.setForeground(new java.awt.Color(0, 51, 102));
        m13_no.setText("NO");
        m13_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m13_noActionPerformed(evt);
            }
        });
        jPanel1.add(m13_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, 20));

        menu_cat_espec1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec1.setForeground(new java.awt.Color(0, 51, 102));
        menu_cat_espec1.setText("-Ventas");
        jPanel1.add(menu_cat_espec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 110, 20));

        m9_si.setBackground(new java.awt.Color(255, 255, 255));
        m9_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m9_si.setForeground(new java.awt.Color(0, 51, 102));
        m9_si.setText("SI");
        m9_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m9_siActionPerformed(evt);
            }
        });
        jPanel1.add(m9_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, 20));

        m9_no.setBackground(new java.awt.Color(255, 255, 255));
        m9_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m9_no.setForeground(new java.awt.Color(0, 51, 102));
        m9_no.setText("NO");
        m9_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m9_noActionPerformed(evt);
            }
        });
        jPanel1.add(m9_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, 20));

        menu_cat_espec2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec2.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec2.setText("-List. Mov.");
        jPanel1.add(menu_cat_espec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 110, 20));

        m15_si.setBackground(new java.awt.Color(255, 255, 255));
        m15_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m15_si.setForeground(new java.awt.Color(0, 153, 0));
        m15_si.setText("SI");
        m15_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m15_siActionPerformed(evt);
            }
        });
        jPanel1.add(m15_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, 20));

        m15_no.setBackground(new java.awt.Color(255, 255, 255));
        m15_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m15_no.setForeground(new java.awt.Color(0, 153, 0));
        m15_no.setText("NO");
        m15_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m15_noActionPerformed(evt);
            }
        });
        jPanel1.add(m15_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, 20));

        menu_cat_espec3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec3.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec3.setText("-Históricos");
        jPanel1.add(menu_cat_espec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 110, 20));

        m16_si.setBackground(new java.awt.Color(255, 255, 255));
        m16_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m16_si.setForeground(new java.awt.Color(0, 153, 0));
        m16_si.setText("SI");
        m16_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m16_siActionPerformed(evt);
            }
        });
        jPanel1.add(m16_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, 20));

        m16_no.setBackground(new java.awt.Color(255, 255, 255));
        m16_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m16_no.setForeground(new java.awt.Color(0, 153, 0));
        m16_no.setText("NO");
        m16_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m16_noActionPerformed(evt);
            }
        });
        jPanel1.add(m16_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 20));

        menu_cat_espec4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec4.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec4.setText("-Cuentas");
        jPanel1.add(menu_cat_espec4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 110, 20));

        m17_si.setBackground(new java.awt.Color(255, 255, 255));
        m17_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m17_si.setForeground(new java.awt.Color(0, 153, 0));
        m17_si.setText("SI");
        m17_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m17_siActionPerformed(evt);
            }
        });
        jPanel1.add(m17_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, 20));

        m17_no.setBackground(new java.awt.Color(255, 255, 255));
        m17_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m17_no.setForeground(new java.awt.Color(0, 153, 0));
        m17_no.setText("NO");
        m17_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m17_noActionPerformed(evt);
            }
        });
        jPanel1.add(m17_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, -1, 20));

        menu_cat_espec5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec5.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec5.setText("-Cambios");
        jPanel1.add(menu_cat_espec5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 110, 20));

        m18_si.setBackground(new java.awt.Color(255, 255, 255));
        m18_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m18_si.setForeground(new java.awt.Color(0, 153, 0));
        m18_si.setText("SI");
        m18_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m18_siActionPerformed(evt);
            }
        });
        jPanel1.add(m18_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, 20));

        m18_no.setBackground(new java.awt.Color(255, 255, 255));
        m18_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m18_no.setForeground(new java.awt.Color(0, 153, 0));
        m18_no.setText("NO");
        m18_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m18_noActionPerformed(evt);
            }
        });
        jPanel1.add(m18_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, -1, 20));

        menu_cat_espec6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec6.setForeground(new java.awt.Color(0, 0, 102));
        menu_cat_espec6.setText("-Listado fiscal");
        jPanel1.add(menu_cat_espec6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 120, 20));

        m19_si.setBackground(new java.awt.Color(255, 255, 255));
        m19_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m19_si.setForeground(new java.awt.Color(0, 153, 0));
        m19_si.setText("SI");
        m19_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m19_siActionPerformed(evt);
            }
        });
        jPanel1.add(m19_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, 20));

        m19_no.setBackground(new java.awt.Color(255, 255, 255));
        m19_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m19_no.setForeground(new java.awt.Color(0, 153, 0));
        m19_no.setText("NO");
        m19_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m19_noActionPerformed(evt);
            }
        });
        jPanel1.add(m19_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, 20));

        menu_cat_espec7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec7.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec7.setText("-Razón del Producto");
        jPanel1.add(menu_cat_espec7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 150, 20));

        m20_si.setBackground(new java.awt.Color(255, 255, 255));
        m20_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m20_si.setForeground(new java.awt.Color(102, 0, 0));
        m20_si.setText("SI");
        m20_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m20_siActionPerformed(evt);
            }
        });
        jPanel1.add(m20_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, 20));

        m20_no.setBackground(new java.awt.Color(255, 255, 255));
        m20_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m20_no.setForeground(new java.awt.Color(102, 0, 0));
        m20_no.setText("NO");
        m20_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m20_noActionPerformed(evt);
            }
        });
        jPanel1.add(m20_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, -1, 20));

        txt_cod_id.setFocusable(false);
        jPanel1.add(txt_cod_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Consultar");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 100, 30));

        panel_invi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_permisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_permisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_permisosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_permisos);

        panel_invi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        jPanel1.add(panel_invi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 130, 50));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Grupo de usuarios:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 1090, 10));

        menu_cat_espec8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec8.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec8.setText("-Lucro por ventas");
        jPanel1.add(menu_cat_espec8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 110, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 51, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 10, 460));

        jSeparator4.setForeground(new java.awt.Color(0, 51, 102));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 10, 460));

        jSeparator5.setForeground(new java.awt.Color(0, 51, 102));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 10, 460));

        jSeparator6.setForeground(new java.awt.Color(0, 51, 102));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 70, 10, 460));

        jSeparator7.setForeground(new java.awt.Color(0, 51, 102));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 70, 10, 460));

        jSeparator9.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1090, 10));

        menu_cat_espec9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec9.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec9.setText("-Devoluciones");
        jPanel1.add(menu_cat_espec9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 110, 30));

        menu_cat_espec10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec10.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec10.setText("-List. Dto-Categoría");
        jPanel1.add(menu_cat_espec10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 150, 20));

        m21_si.setBackground(new java.awt.Color(255, 255, 255));
        m21_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m21_si.setForeground(new java.awt.Color(102, 0, 0));
        m21_si.setText("SI");
        m21_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m21_siActionPerformed(evt);
            }
        });
        jPanel1.add(m21_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, -1, 20));

        m21_no.setBackground(new java.awt.Color(255, 255, 255));
        m21_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m21_no.setForeground(new java.awt.Color(102, 0, 0));
        m21_no.setText("NO");
        m21_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m21_noActionPerformed(evt);
            }
        });
        jPanel1.add(m21_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, -1, 20));

        menu_cat_espec11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec11.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec11.setText("-List. Físico");
        jPanel1.add(menu_cat_espec11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 150, 20));

        m22_si.setBackground(new java.awt.Color(255, 255, 255));
        m22_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m22_si.setForeground(new java.awt.Color(102, 0, 0));
        m22_si.setText("SI");
        m22_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m22_siActionPerformed(evt);
            }
        });
        jPanel1.add(m22_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, -1, 20));

        m22_no.setBackground(new java.awt.Color(255, 255, 255));
        m22_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m22_no.setForeground(new java.awt.Color(102, 0, 0));
        m22_no.setText("NO");
        m22_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m22_noActionPerformed(evt);
            }
        });
        jPanel1.add(m22_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, -1, 20));

        menu_cat_espec12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec12.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec12.setText("-List. CP de Stock");
        jPanel1.add(menu_cat_espec12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 150, 20));

        m23_si.setBackground(new java.awt.Color(255, 255, 255));
        m23_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m23_si.setForeground(new java.awt.Color(102, 0, 0));
        m23_si.setText("SI");
        m23_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m23_siActionPerformed(evt);
            }
        });
        jPanel1.add(m23_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, -1, 20));

        m23_no.setBackground(new java.awt.Color(255, 255, 255));
        m23_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m23_no.setForeground(new java.awt.Color(102, 0, 0));
        m23_no.setText("NO");
        m23_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m23_noActionPerformed(evt);
            }
        });
        jPanel1.add(m23_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, -1, 20));

        m32_si.setBackground(new java.awt.Color(255, 255, 255));
        m32_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m32_si.setForeground(new java.awt.Color(102, 0, 0));
        m32_si.setText("SI");
        m32_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m32_siActionPerformed(evt);
            }
        });
        jPanel1.add(m32_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 260, -1, 20));

        m32_no.setBackground(new java.awt.Color(255, 255, 255));
        m32_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m32_no.setForeground(new java.awt.Color(102, 0, 0));
        m32_no.setText("NO");
        m32_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m32_noActionPerformed(evt);
            }
        });
        jPanel1.add(m32_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 260, -1, 20));

        menu_cat_espec13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec13.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec13.setText("-Stock");
        jPanel1.add(menu_cat_espec13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 90, 30));

        menu_cat_espec14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec14.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec14.setText("-Extracto de ventas");
        jPanel1.add(menu_cat_espec14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 150, 20));

        m24_si.setBackground(new java.awt.Color(255, 255, 255));
        m24_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m24_si.setForeground(new java.awt.Color(102, 0, 0));
        m24_si.setText("SI");
        m24_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m24_siActionPerformed(evt);
            }
        });
        jPanel1.add(m24_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, -1, 20));

        m24_no.setBackground(new java.awt.Color(255, 255, 255));
        m24_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m24_no.setForeground(new java.awt.Color(102, 0, 0));
        m24_no.setText("NO");
        m24_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m24_noActionPerformed(evt);
            }
        });
        jPanel1.add(m24_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, -1, 20));

        m25_no.setBackground(new java.awt.Color(255, 255, 255));
        m25_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m25_no.setForeground(new java.awt.Color(102, 0, 0));
        m25_no.setText("NO");
        m25_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m25_noActionPerformed(evt);
            }
        });
        jPanel1.add(m25_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, -1, 20));

        m25_si.setBackground(new java.awt.Color(255, 255, 255));
        m25_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m25_si.setForeground(new java.awt.Color(102, 0, 0));
        m25_si.setText("SI");
        m25_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m25_siActionPerformed(evt);
            }
        });
        jPanel1.add(m25_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, -1, 20));

        menu_cat_espec15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec15.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec15.setText("-Listado ventas/Stock");
        jPanel1.add(menu_cat_espec15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 150, 20));

        menu_cat_espec16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec16.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec16.setText("-Listado Lucro/Dep.");
        jPanel1.add(menu_cat_espec16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 150, 20));

        m26_si.setBackground(new java.awt.Color(255, 255, 255));
        m26_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m26_si.setForeground(new java.awt.Color(102, 0, 0));
        m26_si.setText("SI");
        m26_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m26_siActionPerformed(evt);
            }
        });
        jPanel1.add(m26_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, -1, 20));

        m26_no.setBackground(new java.awt.Color(255, 255, 255));
        m26_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m26_no.setForeground(new java.awt.Color(102, 0, 0));
        m26_no.setText("NO");
        m26_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m26_noActionPerformed(evt);
            }
        });
        jPanel1.add(m26_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, -1, 20));

        m27_no.setBackground(new java.awt.Color(255, 255, 255));
        m27_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m27_no.setForeground(new java.awt.Color(102, 0, 0));
        m27_no.setText("NO");
        m27_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m27_noActionPerformed(evt);
            }
        });
        jPanel1.add(m27_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, -1, 20));

        m27_si.setBackground(new java.awt.Color(255, 255, 255));
        m27_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m27_si.setForeground(new java.awt.Color(102, 0, 0));
        m27_si.setText("SI");
        m27_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m27_siActionPerformed(evt);
            }
        });
        jPanel1.add(m27_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, -1, 20));

        menu_cat_espec17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec17.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec17.setText("-List. ventas por Usu.");
        jPanel1.add(menu_cat_espec17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 150, 20));

        menu_cat_espec18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec18.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec18.setText("-List. Lucro");
        jPanel1.add(menu_cat_espec18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 150, 20));

        m28_si.setBackground(new java.awt.Color(255, 255, 255));
        m28_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m28_si.setForeground(new java.awt.Color(102, 0, 0));
        m28_si.setText("SI");
        m28_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m28_siActionPerformed(evt);
            }
        });
        jPanel1.add(m28_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, 20));

        m28_no.setBackground(new java.awt.Color(255, 255, 255));
        m28_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m28_no.setForeground(new java.awt.Color(102, 0, 0));
        m28_no.setText("NO");
        m28_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m28_noActionPerformed(evt);
            }
        });
        jPanel1.add(m28_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, -1, 20));

        m29_no.setBackground(new java.awt.Color(255, 255, 255));
        m29_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m29_no.setForeground(new java.awt.Color(0, 0, 102));
        m29_no.setText("NO");
        m29_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m29_noActionPerformed(evt);
            }
        });
        jPanel1.add(m29_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, 20));

        m29_si.setBackground(new java.awt.Color(255, 255, 255));
        m29_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m29_si.setForeground(new java.awt.Color(0, 0, 102));
        m29_si.setText("SI");
        m29_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m29_siActionPerformed(evt);
            }
        });
        jPanel1.add(m29_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, -1, 20));

        menu_cat_espec19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec19.setForeground(new java.awt.Color(0, 0, 102));
        menu_cat_espec19.setText("-Recibos Fiscales");
        jPanel1.add(menu_cat_espec19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 110, 20));

        menu_cat_espec20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec20.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec20.setText("-Ventas");
        jPanel1.add(menu_cat_espec20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 90, 30));

        menu_cat_espec21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec21.setForeground(new java.awt.Color(0, 0, 102));
        menu_cat_espec21.setText("-Nota Credito");
        jPanel1.add(menu_cat_espec21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 120, 20));

        m30_si.setBackground(new java.awt.Color(255, 255, 255));
        m30_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m30_si.setForeground(new java.awt.Color(102, 0, 0));
        m30_si.setText("SI");
        m30_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m30_siActionPerformed(evt);
            }
        });
        jPanel1.add(m30_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, -1, 20));

        m30_no.setBackground(new java.awt.Color(255, 255, 255));
        m30_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m30_no.setForeground(new java.awt.Color(102, 0, 0));
        m30_no.setText("NO");
        m30_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m30_noActionPerformed(evt);
            }
        });
        jPanel1.add(m30_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, -1, 20));

        menu_cat_espec22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec22.setForeground(new java.awt.Color(0, 0, 102));
        menu_cat_espec22.setText("-Facturacion");
        jPanel1.add(menu_cat_espec22, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 90, 30));

        menu_cat_espec23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec23.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec23.setText("-List. Devoluciones");
        jPanel1.add(menu_cat_espec23, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 150, 20));

        m31_si.setBackground(new java.awt.Color(255, 255, 255));
        m31_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m31_si.setForeground(new java.awt.Color(102, 0, 0));
        m31_si.setText("SI");
        m31_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m31_siActionPerformed(evt);
            }
        });
        jPanel1.add(m31_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, -1, 20));

        m31_no.setBackground(new java.awt.Color(255, 255, 255));
        m31_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m31_no.setForeground(new java.awt.Color(102, 0, 0));
        m31_no.setText("NO");
        m31_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m31_noActionPerformed(evt);
            }
        });
        jPanel1.add(m31_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, -1, 20));

        menu_cat_espec24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec24.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec24.setText("-Bancos");
        jPanel1.add(menu_cat_espec24, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 120, 20));

        m33_si.setBackground(new java.awt.Color(255, 255, 255));
        m33_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m33_si.setForeground(new java.awt.Color(0, 0, 102));
        m33_si.setText("SI");
        m33_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m33_siActionPerformed(evt);
            }
        });
        jPanel1.add(m33_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, -1, 20));

        m33_no.setBackground(new java.awt.Color(255, 255, 255));
        m33_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m33_no.setForeground(new java.awt.Color(0, 0, 102));
        m33_no.setText("NO");
        m33_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m33_noActionPerformed(evt);
            }
        });
        jPanel1.add(m33_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, -1, 20));

        cb_grupo_usu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_grupo_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 350, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 102));
        jLabel23.setText("-Pedidos");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 110, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 102));
        jLabel24.setText("-Egresos");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 110, 20));

        menu_cat_espec25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec25.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec25.setText("-Transf. de C.");
        jPanel1.add(menu_cat_espec25, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 120, 20));

        menu_cat_espec26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec26.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec26.setText("-List. Compras");
        jPanel1.add(menu_cat_espec26, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 150, 20));

        m34_si.setBackground(new java.awt.Color(255, 255, 255));
        m34_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m34_si.setForeground(new java.awt.Color(0, 153, 0));
        m34_si.setText("SI");
        m34_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m34_siActionPerformed(evt);
            }
        });
        jPanel1.add(m34_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, 20));

        m34_no.setBackground(new java.awt.Color(255, 255, 255));
        m34_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m34_no.setForeground(new java.awt.Color(0, 153, 0));
        m34_no.setText("NO");
        m34_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m34_noActionPerformed(evt);
            }
        });
        jPanel1.add(m34_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, 20));

        m35_si.setBackground(new java.awt.Color(255, 255, 255));
        m35_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m35_si.setForeground(new java.awt.Color(0, 51, 102));
        m35_si.setText("SI");
        m35_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m35_siActionPerformed(evt);
            }
        });
        jPanel1.add(m35_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, 20));

        m35_no.setBackground(new java.awt.Color(255, 255, 255));
        m35_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m35_no.setForeground(new java.awt.Color(0, 51, 102));
        m35_no.setText("NO");
        m35_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m35_noActionPerformed(evt);
            }
        });
        jPanel1.add(m35_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, 20));

        m36_no.setBackground(new java.awt.Color(255, 255, 255));
        m36_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m36_no.setForeground(new java.awt.Color(0, 51, 102));
        m36_no.setText("NO");
        m36_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m36_noActionPerformed(evt);
            }
        });
        jPanel1.add(m36_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, 20));

        m36_si.setBackground(new java.awt.Color(255, 255, 255));
        m36_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m36_si.setForeground(new java.awt.Color(0, 51, 102));
        m36_si.setText("SI");
        m36_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m36_siActionPerformed(evt);
            }
        });
        jPanel1.add(m36_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, 20));

        m37_si.setBackground(new java.awt.Color(255, 255, 255));
        m37_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m37_si.setForeground(new java.awt.Color(0, 0, 102));
        m37_si.setText("SI");
        m37_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m37_siActionPerformed(evt);
            }
        });
        jPanel1.add(m37_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, -1, 20));

        m37_no.setBackground(new java.awt.Color(255, 255, 255));
        m37_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m37_no.setForeground(new java.awt.Color(0, 0, 102));
        m37_no.setText("NO");
        m37_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m37_noActionPerformed(evt);
            }
        });
        jPanel1.add(m37_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, -1, 20));

        menu_cat_espec27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec27.setForeground(new java.awt.Color(0, 153, 0));
        menu_cat_espec27.setText("-Surcusales");
        jPanel1.add(menu_cat_espec27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 120, 20));

        m38_si.setBackground(new java.awt.Color(255, 255, 255));
        m38_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m38_si.setForeground(new java.awt.Color(0, 153, 0));
        m38_si.setText("SI");
        m38_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m38_siActionPerformed(evt);
            }
        });
        jPanel1.add(m38_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, 20));

        m38_no.setBackground(new java.awt.Color(255, 255, 255));
        m38_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m38_no.setForeground(new java.awt.Color(0, 153, 0));
        m38_no.setText("NO");
        m38_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m38_noActionPerformed(evt);
            }
        });
        jPanel1.add(m38_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, 20));

        menu_cat_espec28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec28.setForeground(new java.awt.Color(102, 0, 0));
        menu_cat_espec28.setText("-Compras");
        jPanel1.add(menu_cat_espec28, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 90, 30));

        menu_cat_espec29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu_cat_espec29.setForeground(new java.awt.Color(0, 0, 102));
        menu_cat_espec29.setText("-Facturas");
        jPanel1.add(menu_cat_espec29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 120, 20));

        m2_no.setBackground(new java.awt.Color(255, 255, 255));
        m2_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m2_no.setForeground(new java.awt.Color(0, 0, 153));
        m2_no.setText("NO");
        m2_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2_noActionPerformed(evt);
            }
        });
        jPanel1.add(m2_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        m2_si.setBackground(new java.awt.Color(255, 255, 255));
        m2_si.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        m2_si.setForeground(new java.awt.Color(0, 0, 153));
        m2_si.setText("SI");
        m2_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2_siActionPerformed(evt);
            }
        });
        jPanel1.add(m2_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_permisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_permisosMouseClicked

    }//GEN-LAST:event_tb_permisosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String grupo = (String) cb_grupo_usu.getSelectedItem();
        cargar(grupo);
        try {

            int fila = 0;
            if (tb_permisos.getValueAt(fila, 1).toString().equals("S")) {
                m2_si.doClick();
                m2_no.setSelected(false);
            } else {
                m2_si.setSelected(false);
                m2_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 2).toString().equals("S")) {
                m3_si.doClick();
                m3_no.setSelected(false);
            } else {
                m3_si.setSelected(false);
                m3_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 3).toString().equals("S")) {
                m4_si.doClick();
                m4_no.setSelected(false);
            } else {
                m4_si.setSelected(false);
                m4_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 4).toString().equals("S")) {
                m5_si.doClick();
                m5_no.setSelected(false);
            } else {
                m5_si.setSelected(false);
                m5_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 5).toString().equals("S")) {
                m6_si.doClick();
                m6_no.setSelected(false);
            } else {
                m6_si.setSelected(false);
                m6_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 6).toString().equals("S")) {
                m7_si.doClick();
                m7_no.setSelected(false);
            } else {
                m7_si.setSelected(false);
                m7_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 7).toString().equals("S")) {
                m8_si.doClick();
                m8_no.setSelected(false);
            } else {
                m8_si.setSelected(false);
                m8_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 8).toString().equals("S")) {
                m9_si.doClick();
                m9_no.setSelected(false);
            } else {
                m9_si.setSelected(false);
                m9_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 9).toString().equals("S")) {
                m10_si.doClick();
                m10_no.setSelected(false);
            } else {
                m10_si.setSelected(false);
                m10_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 10).toString().equals("S")) {
                m11_si.doClick();
                m11_no.setSelected(false);
            } else {
                m11_si.setSelected(false);
                m11_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 11).toString().equals("S")) {
                m12_si.doClick();
                m12_no.setSelected(false);
            } else {
                m12_si.setSelected(false);
                m12_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 12).toString().equals("S")) {
                m13_si.doClick();
                m13_no.setSelected(false);
            } else {
                m13_si.setSelected(false);
                m13_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 13).toString().equals("S")) {
                m14_si.doClick();
                m14_no.setSelected(false);
            } else {
                m14_si.setSelected(false);
                m14_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 14).toString().equals("S")) {
                m15_si.doClick();
                m15_no.setSelected(false);
            } else {
                m15_si.setSelected(false);
                m15_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 15).toString().equals("S")) {
                m16_si.doClick();
                m16_no.setSelected(false);
            } else {
                m16_si.setSelected(false);
                m16_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 16).toString().equals("S")) {
                m17_si.doClick();
                m17_no.setSelected(false);
            } else {
                m17_si.setSelected(false);
                m17_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 17).toString().equals("S")) {
                m18_si.doClick();
                m18_no.setSelected(false);
            } else {
                m18_si.setSelected(false);
                m18_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 18).toString().equals("S")) {
                m19_si.doClick();
                m19_no.setSelected(false);
            } else {
                m19_si.setSelected(false);
                m19_no.doClick();
            }

            String id = tb_permisos.getValueAt(fila, 19).toString();
            txt_cod_id.setText(id);

            if (tb_permisos.getValueAt(fila, 20).toString().equals("S")) {
                m20_si.doClick();
                m20_no.setSelected(false);
            } else {
                m20_si.setSelected(false);
                m20_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 21).toString().equals("S")) {
                m21_si.doClick();
                m21_no.setSelected(false);
            } else {
                m21_si.setSelected(false);
                m21_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 22).toString().equals("S")) {
                m22_si.doClick();
                m22_no.setSelected(false);
            } else {
                m22_si.setSelected(false);
                m22_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 23).toString().equals("S")) {
                m23_si.doClick();
                m23_no.setSelected(false);
            } else {
                m23_si.setSelected(false);
                m23_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 24).toString().equals("S")) {
                m24_si.doClick();
                m24_no.setSelected(false);
            } else {
                m24_si.setSelected(false);
                m24_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 25).toString().equals("S")) {
                m25_si.doClick();
                m25_no.setSelected(false);
            } else {
                m25_si.setSelected(false);
                m25_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 26).toString().equals("S")) {
                m26_si.doClick();
                m26_no.setSelected(false);
            } else {
                m26_si.setSelected(false);
                m26_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 27).toString().equals("S")) {
                m27_si.doClick();
                m27_no.setSelected(false);
            } else {
                m27_si.setSelected(false);
                m27_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 28).toString().equals("S")) {
                m28_si.doClick();
                m28_no.setSelected(false);
            } else {
                m28_si.setSelected(false);
                m28_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 29).toString().equals("S")) {
                m29_si.doClick();
                m29_no.setSelected(false);
            } else {
                m29_si.setSelected(false);
                m29_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 30).toString().equals("S")) {
                m30_si.doClick();
                m30_no.setSelected(false);
            } else {
                m30_si.setSelected(false);
                m30_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 31).toString().equals("S")) {
                m31_si.doClick();
                m31_no.setSelected(false);
            } else {
                m31_si.setSelected(false);
                m31_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 32).toString().equals("S")) {
                m32_si.doClick();
                m32_no.setSelected(false);
            } else {
                m32_si.setSelected(false);
                m32_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 33).toString().equals("S")) {
                m33_si.doClick();
                m33_no.setSelected(false);
            } else {
                m33_si.setSelected(false);
                m33_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 34).toString().equals("S")) {
                m34_si.doClick();
                m34_no.setSelected(false);
            } else {
                m34_si.setSelected(false);
                m34_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 35).toString().equals("S")) {
                m35_si.doClick();
                m35_no.setSelected(false);
            } else {
                m35_si.setSelected(false);
                m35_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 36).toString().equals("S")) {
                m36_si.doClick();
                m36_no.setSelected(false);
            } else {
                m36_si.setSelected(false);
                m36_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 37).toString().equals("S")) {
                m37_si.doClick();
                m37_no.setSelected(false);
            } else {
                m37_si.setSelected(false);
                m37_no.doClick();
            }
            if (tb_permisos.getValueAt(fila, 38).toString().equals("S")) {
                m38_si.doClick();
                m38_no.setSelected(false);
            } else {
                m38_si.setSelected(false);
                m38_no.doClick();
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void m19_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m19_noActionPerformed
        m19 = "N";
        m19_no.setSelected(true);
        m19_si.setSelected(false);
    }//GEN-LAST:event_m19_noActionPerformed

    private void m19_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m19_siActionPerformed
        m19 = "S";
        m19_no.setSelected(false);
        m19_si.setSelected(true);
    }//GEN-LAST:event_m19_siActionPerformed

    private void m18_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m18_noActionPerformed
        m18 = "N";
        m18_no.setSelected(true);
        m18_si.setSelected(false);
    }//GEN-LAST:event_m18_noActionPerformed

    private void m18_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m18_siActionPerformed
        m18 = "S";
        m18_no.setSelected(false);
        m18_si.setSelected(true);
    }//GEN-LAST:event_m18_siActionPerformed

    private void m17_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m17_noActionPerformed
        m17 = "N";
        m17_no.setSelected(true);
        m17_si.setSelected(false);
    }//GEN-LAST:event_m17_noActionPerformed

    private void m17_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m17_siActionPerformed
        m17 = "S";
        m17_no.setSelected(false);
        m17_si.setSelected(true);
    }//GEN-LAST:event_m17_siActionPerformed

    private void m16_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m16_noActionPerformed
        m16 = "N";
        m16_no.setSelected(true);
        m16_si.setSelected(false);
    }//GEN-LAST:event_m16_noActionPerformed

    private void m16_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m16_siActionPerformed
        m16 = "S";
        m16_no.setSelected(false);
        m16_si.setSelected(true);
    }//GEN-LAST:event_m16_siActionPerformed

    private void m15_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m15_noActionPerformed
        m15 = "N";
        m15_no.setSelected(true);
        m15_si.setSelected(false);
    }//GEN-LAST:event_m15_noActionPerformed

    private void m15_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m15_siActionPerformed
        m15 = "S";
        m15_no.setSelected(false);
        m15_si.setSelected(true);
    }//GEN-LAST:event_m15_siActionPerformed

    private void m9_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m9_noActionPerformed
        m9 = "N";
        m9_no.setSelected(true);
        m9_si.setSelected(false);
    }//GEN-LAST:event_m9_noActionPerformed

    private void m9_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m9_siActionPerformed
        m9 = "S";
        m9_no.setSelected(false);
        m9_si.setSelected(true);
    }//GEN-LAST:event_m9_siActionPerformed

    private void m13_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m13_noActionPerformed
        m13 = "N";
        m13_no.setSelected(true);
        m13_si.setSelected(false);
    }//GEN-LAST:event_m13_noActionPerformed

    private void m13_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m13_siActionPerformed
        m13 = "S";
        m13_no.setSelected(false);
        m13_si.setSelected(true);
    }//GEN-LAST:event_m13_siActionPerformed

    private void m12_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m12_noActionPerformed
        m12 = "N";
        m12_no.setSelected(true);
        m12_si.setSelected(false);
    }//GEN-LAST:event_m12_noActionPerformed

    private void m12_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m12_siActionPerformed
        m12 = "S";
        m12_no.setSelected(false);
        m12_si.setSelected(true);
    }//GEN-LAST:event_m12_siActionPerformed

    private void m11_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m11_noActionPerformed
        m11 = "N";
        m11_no.setSelected(true);
        m11_si.setSelected(false);
    }//GEN-LAST:event_m11_noActionPerformed

    private void m11_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m11_siActionPerformed
        m11 = "S";
        m11_no.setSelected(false);
        m11_si.setSelected(true);
    }//GEN-LAST:event_m11_siActionPerformed

    private void m10_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m10_noActionPerformed
        m10 = "N";
        m10_no.setSelected(true);
        m10_si.setSelected(false);
    }//GEN-LAST:event_m10_noActionPerformed

    private void m10_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m10_siActionPerformed
        m10 = "S";
        m10_no.setSelected(false);
        m10_si.setSelected(true);
    }//GEN-LAST:event_m10_siActionPerformed

    private void m14_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m14_noActionPerformed
        m14 = "N";
        m14_no.setSelected(true);
        m14_si.setSelected(false);
    }//GEN-LAST:event_m14_noActionPerformed

    private void m14_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m14_siActionPerformed
        m14 = "S";
        m14_no.setSelected(false);
        m14_si.setSelected(true);
    }//GEN-LAST:event_m14_siActionPerformed

    private void m8_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m8_noActionPerformed
        m8 = "N";
        m8_no.setSelected(true);
        m8_si.setSelected(false);
    }//GEN-LAST:event_m8_noActionPerformed

    private void m8_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m8_siActionPerformed
        m8 = "S";
        m8_no.setSelected(false);
        m8_si.setSelected(true);
    }//GEN-LAST:event_m8_siActionPerformed

    private void m7_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m7_noActionPerformed
        m7 = "N";
        m7_no.setSelected(true);
        m7_si.setSelected(false);
    }//GEN-LAST:event_m7_noActionPerformed

    private void m7_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m7_siActionPerformed
        m7 = "S";
        m7_no.setSelected(false);
        m7_si.setSelected(true);
    }//GEN-LAST:event_m7_siActionPerformed

    private void m6_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m6_noActionPerformed
        m6 = "N";
        m6_no.setSelected(true);
        m6_si.setSelected(false);
    }//GEN-LAST:event_m6_noActionPerformed

    private void m6_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m6_siActionPerformed
        m6 = "S";
        m6_no.setSelected(false);
        m6_si.setSelected(true);
    }//GEN-LAST:event_m6_siActionPerformed

    private void m5_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m5_noActionPerformed
        m5 = "N";
        m5_no.setSelected(true);
        m5_si.setSelected(false);
    }//GEN-LAST:event_m5_noActionPerformed

    private void m5_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m5_siActionPerformed
        m5 = "S";
        m5_no.setSelected(false);
        m5_si.setSelected(true);
    }//GEN-LAST:event_m5_siActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "UPDATE user_permisos SET m1 = '" + ("N")
                + "',m2 ='" + m2
                + "',m3 ='" + m3
                + "',m4 ='" + m4
                + "',m5 = '" + m5
                + "',m6 = '" + m6
                + "',m7 ='" + m7
                + "',m8 ='" + m8
                + "',m9 ='" + m9
                + "',m10 ='" + m10
                + "',m11 = '" + m11
                + "',m12 = '" + m12
                + "',m13 ='" + m13
                + "',m14 ='" + m14
                + "',m15 ='" + m15
                + "',m16 ='" + m16
                + "',m17 = '" + m17
                + "',m18 = '" + m18
                + "',m19 ='" + m19
                + "',m20 ='" + m20
                + "',m21 ='" + m21
                + "',m22 ='" + m22
                + "',m23 ='" + m23
                + "',m24 ='" + m24
                + "',m25 ='" + m25
                + "',m26 ='" + m26
                + "',m27 ='" + m27
                + "',m28 ='" + m28
                + "',m29 ='" + m29
                + "',m30 ='" + m30
                + "',m31 ='" + m31
                + "',m32 ='" + m32
                + "',m33 ='" + m33
                + "',m34 ='" + m34
                + "',m35 ='" + m35
                + "',m36 ='" + m36
                + "',m37 ='" + m37
                + "',m38 ='" + m38
                + "' WHERE id_perm = '" + txt_cod_id.getText() + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            JOptionPane.showMessageDialog(null, "Actualizado, cerrar sesión e ingresar de nuevo en el sistema");
            this.dispose();

        } catch (SQLException | HeadlessException e) {
            Logger.getLogger(permisos_user.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Confirme todos los accesos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void m4_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m4_noActionPerformed
        m4 = "N";
        m4_no.setSelected(true);
        m4_si.setSelected(false);
    }//GEN-LAST:event_m4_noActionPerformed

    private void m4_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m4_siActionPerformed
        m4 = "S";
        m4_no.setSelected(false);
        m4_si.setSelected(true);
    }//GEN-LAST:event_m4_siActionPerformed

    private void m3_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m3_noActionPerformed
        m3 = "N";
        m3_no.setSelected(true);
        m3_si.setSelected(false);
    }//GEN-LAST:event_m3_noActionPerformed

    private void m3_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m3_siActionPerformed
        m3 = "S";
        m3_no.setSelected(false);
        m3_si.setSelected(true);
    }//GEN-LAST:event_m3_siActionPerformed

    private void m20_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m20_siActionPerformed
        m20 = "S";
        m20_no.setSelected(false);
        m20_si.setSelected(true);
    }//GEN-LAST:event_m20_siActionPerformed

    private void m20_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m20_noActionPerformed
        m20 = "N";
        m20_no.setSelected(true);
        m20_si.setSelected(false);
    }//GEN-LAST:event_m20_noActionPerformed

    private void m21_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m21_siActionPerformed
        m21 = "S";
        m21_no.setSelected(false);
        m21_si.setSelected(true);
    }//GEN-LAST:event_m21_siActionPerformed

    private void m21_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m21_noActionPerformed
        m21 = "N";
        m21_no.setSelected(true);
        m21_si.setSelected(false);
    }//GEN-LAST:event_m21_noActionPerformed

    private void m22_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m22_siActionPerformed
        m22 = "S";
        m22_no.setSelected(false);
        m22_si.setSelected(true);
    }//GEN-LAST:event_m22_siActionPerformed

    private void m22_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m22_noActionPerformed
        m22 = "N";
        m22_no.setSelected(true);
        m22_si.setSelected(false);
    }//GEN-LAST:event_m22_noActionPerformed

    private void m23_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m23_siActionPerformed
        m23 = "S";
        m23_no.setSelected(false);
        m23_si.setSelected(true);
    }//GEN-LAST:event_m23_siActionPerformed

    private void m23_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m23_noActionPerformed
        m23 = "N";
        m23_no.setSelected(true);
        m23_si.setSelected(false);
    }//GEN-LAST:event_m23_noActionPerformed

    private void m24_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m24_siActionPerformed
        m24 = "S";
        m24_no.setSelected(false);
        m24_si.setSelected(true);
    }//GEN-LAST:event_m24_siActionPerformed

    private void m24_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m24_noActionPerformed
        m24 = "N";
        m24_no.setSelected(true);
        m24_si.setSelected(false);
    }//GEN-LAST:event_m24_noActionPerformed

    private void m25_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m25_siActionPerformed
        m25 = "S";
        m25_no.setSelected(false);
        m25_si.setSelected(true);
    }//GEN-LAST:event_m25_siActionPerformed

    private void m25_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m25_noActionPerformed
        m25 = "N";
        m25_no.setSelected(true);
        m25_si.setSelected(false);
    }//GEN-LAST:event_m25_noActionPerformed

    private void m26_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m26_siActionPerformed
        m26 = "S";
        m26_no.setSelected(false);
        m26_si.setSelected(true);
    }//GEN-LAST:event_m26_siActionPerformed

    private void m26_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m26_noActionPerformed
        m26 = "N";
        m26_no.setSelected(true);
        m26_si.setSelected(false);
    }//GEN-LAST:event_m26_noActionPerformed

    private void m27_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m27_siActionPerformed
        m27 = "S";
        m27_no.setSelected(false);
        m27_si.setSelected(true);
    }//GEN-LAST:event_m27_siActionPerformed

    private void m27_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m27_noActionPerformed
        m27 = "N";
        m27_no.setSelected(true);
        m27_si.setSelected(false);
    }//GEN-LAST:event_m27_noActionPerformed

    private void m28_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m28_siActionPerformed
        m28 = "S";
        m28_no.setSelected(false);
        m28_si.setSelected(true);
    }//GEN-LAST:event_m28_siActionPerformed

    private void m28_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m28_noActionPerformed
        m28 = "N";
        m28_no.setSelected(true);
        m28_si.setSelected(false);
    }//GEN-LAST:event_m28_noActionPerformed

    private void m29_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m29_siActionPerformed
        m29 = "S";
        m29_no.setSelected(false);
        m29_si.setSelected(true);
    }//GEN-LAST:event_m29_siActionPerformed

    private void m29_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m29_noActionPerformed
        m29 = "N";
        m29_no.setSelected(true);
        m29_si.setSelected(false);
    }//GEN-LAST:event_m29_noActionPerformed

    private void m30_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m30_siActionPerformed
        m30 = "S";
        m30_no.setSelected(false);
        m30_si.setSelected(true);
    }//GEN-LAST:event_m30_siActionPerformed

    private void m30_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m30_noActionPerformed
        m30 = "N";
        m30_no.setSelected(true);
        m30_si.setSelected(false);
    }//GEN-LAST:event_m30_noActionPerformed

    private void m31_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m31_siActionPerformed
        m31 = "S";
        m31_no.setSelected(false);
        m31_si.setSelected(true);
    }//GEN-LAST:event_m31_siActionPerformed

    private void m31_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m31_noActionPerformed
        m31 = "N";
        m31_no.setSelected(true);
        m31_si.setSelected(false);
    }//GEN-LAST:event_m31_noActionPerformed

    private void m32_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m32_siActionPerformed
        m32 = "S";
        m32_no.setSelected(false);
        m32_si.setSelected(true);
    }//GEN-LAST:event_m32_siActionPerformed

    private void m32_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m32_noActionPerformed
        m32 = "N";
        m32_no.setSelected(true);
        m32_si.setSelected(false);
    }//GEN-LAST:event_m32_noActionPerformed

    private void m33_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m33_siActionPerformed
        m33 = "S";
        m33_no.setSelected(false);
        m33_si.setSelected(true);
    }//GEN-LAST:event_m33_siActionPerformed

    private void m33_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m33_noActionPerformed
        m33 = "N";
        m33_no.setSelected(true);
        m33_si.setSelected(false);
    }//GEN-LAST:event_m33_noActionPerformed

    private void m34_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m34_siActionPerformed
        m34 = "S";
        m34_no.setSelected(false);
        m34_si.setSelected(true);
    }//GEN-LAST:event_m34_siActionPerformed

    private void m34_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m34_noActionPerformed
        m34 = "N";
        m34_no.setSelected(true);
        m34_si.setSelected(false);
    }//GEN-LAST:event_m34_noActionPerformed

    private void m35_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m35_siActionPerformed
        m35 = "S";
        m35_no.setSelected(false);
        m35_si.setSelected(true);
    }//GEN-LAST:event_m35_siActionPerformed

    private void m35_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m35_noActionPerformed
        m35 = "N";
        m35_no.setSelected(true);
        m35_si.setSelected(false);
    }//GEN-LAST:event_m35_noActionPerformed

    private void m36_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m36_noActionPerformed
        m36 = "N";
        m36_no.setSelected(true);
        m36_si.setSelected(false);
    }//GEN-LAST:event_m36_noActionPerformed

    private void m36_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m36_siActionPerformed
        m36 = "S";
        m36_no.setSelected(false);
        m36_si.setSelected(true);
    }//GEN-LAST:event_m36_siActionPerformed

    private void m37_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m37_siActionPerformed
        m37 = "S";
        m37_no.setSelected(false);
        m37_si.setSelected(true);
    }//GEN-LAST:event_m37_siActionPerformed

    private void m37_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m37_noActionPerformed
        m37 = "N";
        m37_no.setSelected(true);
        m37_si.setSelected(false);
    }//GEN-LAST:event_m37_noActionPerformed

    private void m38_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m38_siActionPerformed
        m38 = "S";
        m38_no.setSelected(false);
        m38_si.setSelected(true);
    }//GEN-LAST:event_m38_siActionPerformed

    private void m38_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m38_noActionPerformed
        m38 = "N";
        m38_no.setSelected(true);
        m38_si.setSelected(false);
    }//GEN-LAST:event_m38_noActionPerformed

    private void m2_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2_siActionPerformed
        m2 = "S";
        m2_no.setSelected(false);
        m2_si.setSelected(true);
    }//GEN-LAST:event_m2_siActionPerformed

    private void m2_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2_noActionPerformed
        m2 = "N";
        m2_no.setSelected(true);
        m2_si.setSelected(false);
    }//GEN-LAST:event_m2_noActionPerformed

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
            java.util.logging.Logger.getLogger(permisos_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(permisos_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(permisos_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(permisos_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                permisos_user dialog = new permisos_user(new javax.swing.JDialog(), true);
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
    private org.jdesktop.swingx.JXComboBox cb_grupo_usu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JCheckBox m10_no;
    private javax.swing.JCheckBox m10_si;
    private javax.swing.JCheckBox m11_no;
    private javax.swing.JCheckBox m11_si;
    private javax.swing.JCheckBox m12_no;
    private javax.swing.JCheckBox m12_si;
    private javax.swing.JCheckBox m13_no;
    private javax.swing.JCheckBox m13_si;
    private javax.swing.JCheckBox m14_no;
    private javax.swing.JCheckBox m14_si;
    private javax.swing.JCheckBox m15_no;
    private javax.swing.JCheckBox m15_si;
    private javax.swing.JCheckBox m16_no;
    private javax.swing.JCheckBox m16_si;
    private javax.swing.JCheckBox m17_no;
    private javax.swing.JCheckBox m17_si;
    private javax.swing.JCheckBox m18_no;
    private javax.swing.JCheckBox m18_si;
    private javax.swing.JCheckBox m19_no;
    private javax.swing.JCheckBox m19_si;
    private javax.swing.JCheckBox m20_no;
    private javax.swing.JCheckBox m20_si;
    private javax.swing.JCheckBox m21_no;
    private javax.swing.JCheckBox m21_si;
    private javax.swing.JCheckBox m22_no;
    private javax.swing.JCheckBox m22_si;
    private javax.swing.JCheckBox m23_no;
    private javax.swing.JCheckBox m23_si;
    private javax.swing.JCheckBox m24_no;
    private javax.swing.JCheckBox m24_si;
    private javax.swing.JCheckBox m25_no;
    private javax.swing.JCheckBox m25_si;
    private javax.swing.JCheckBox m26_no;
    private javax.swing.JCheckBox m26_si;
    private javax.swing.JCheckBox m27_no;
    private javax.swing.JCheckBox m27_si;
    private javax.swing.JCheckBox m28_no;
    private javax.swing.JCheckBox m28_si;
    private javax.swing.JCheckBox m29_no;
    private javax.swing.JCheckBox m29_si;
    private javax.swing.JCheckBox m2_no;
    private javax.swing.JCheckBox m2_si;
    private javax.swing.JCheckBox m30_no;
    private javax.swing.JCheckBox m30_si;
    private javax.swing.JCheckBox m31_no;
    private javax.swing.JCheckBox m31_si;
    private javax.swing.JCheckBox m32_no;
    private javax.swing.JCheckBox m32_si;
    private javax.swing.JCheckBox m33_no;
    private javax.swing.JCheckBox m33_si;
    private javax.swing.JCheckBox m34_no;
    private javax.swing.JCheckBox m34_si;
    private javax.swing.JCheckBox m35_no;
    private javax.swing.JCheckBox m35_si;
    private javax.swing.JCheckBox m36_no;
    private javax.swing.JCheckBox m36_si;
    private javax.swing.JCheckBox m37_no;
    private javax.swing.JCheckBox m37_si;
    private javax.swing.JCheckBox m38_no;
    private javax.swing.JCheckBox m38_si;
    private javax.swing.JCheckBox m3_no;
    private javax.swing.JCheckBox m3_si;
    private javax.swing.JCheckBox m4_no;
    private javax.swing.JCheckBox m4_si;
    private javax.swing.JCheckBox m5_no;
    private javax.swing.JCheckBox m5_si;
    private javax.swing.JCheckBox m6_no;
    private javax.swing.JCheckBox m6_si;
    private javax.swing.JCheckBox m7_no;
    private javax.swing.JCheckBox m7_si;
    private javax.swing.JCheckBox m8_no;
    private javax.swing.JCheckBox m8_si;
    private javax.swing.JCheckBox m9_no;
    private javax.swing.JCheckBox m9_si;
    private javax.swing.JLabel menu_cat_espec;
    private javax.swing.JLabel menu_cat_espec1;
    private javax.swing.JLabel menu_cat_espec10;
    private javax.swing.JLabel menu_cat_espec11;
    private javax.swing.JLabel menu_cat_espec12;
    private javax.swing.JLabel menu_cat_espec13;
    private javax.swing.JLabel menu_cat_espec14;
    private javax.swing.JLabel menu_cat_espec15;
    private javax.swing.JLabel menu_cat_espec16;
    private javax.swing.JLabel menu_cat_espec17;
    private javax.swing.JLabel menu_cat_espec18;
    private javax.swing.JLabel menu_cat_espec19;
    private javax.swing.JLabel menu_cat_espec2;
    private javax.swing.JLabel menu_cat_espec20;
    private javax.swing.JLabel menu_cat_espec21;
    private javax.swing.JLabel menu_cat_espec22;
    private javax.swing.JLabel menu_cat_espec23;
    private javax.swing.JLabel menu_cat_espec24;
    private javax.swing.JLabel menu_cat_espec25;
    private javax.swing.JLabel menu_cat_espec26;
    private javax.swing.JLabel menu_cat_espec27;
    private javax.swing.JLabel menu_cat_espec28;
    private javax.swing.JLabel menu_cat_espec29;
    private javax.swing.JLabel menu_cat_espec3;
    private javax.swing.JLabel menu_cat_espec4;
    private javax.swing.JLabel menu_cat_espec5;
    private javax.swing.JLabel menu_cat_espec6;
    private javax.swing.JLabel menu_cat_espec7;
    private javax.swing.JLabel menu_cat_espec8;
    private javax.swing.JLabel menu_cat_espec9;
    private javax.swing.JLabel menu_logistica;
    private javax.swing.JPanel panel_invi;
    private javax.swing.JTable tb_permisos;
    private javax.swing.JTextField txt_cod_id;
    // End of variables declaration//GEN-END:variables

    private String m1;
    private String m2;
    private String m3;
    private String m4;
    private String m5;
    private String m6;
    private String m7;
    private String m8;
    private String m9;
    private String m10;
    private String m11;
    private String m12;
    private String m13;
    private String m14;
    private String m15;
    private String m16;
    private String m17;
    private String m18;
    private String m19;
    private String m20;
    private String m21;
    private String m22;
    private String m23;
    private String m24;
    private String m25;
    private String m26;
    private String m27;
    private String m28;
    private String m29;
    private String m30;
    private String m31;
    private String m32;
    private String m33;
    private String m34;
    private String m35;
    private String m36;
    private String m37;
    private String m38;

    void cargargrupo() {
        String mostrar = "SELECT * FROM user_permisos where id_perm >1 ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_grupo_usu.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
