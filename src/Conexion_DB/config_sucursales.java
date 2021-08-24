/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion_DB;

import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.IOException;
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
 * @author user
 */
public class config_sucursales extends javax.swing.JDialog {



    DefaultTableModel model;

    public config_sucursales(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        cargar();

    }

    void cargar() throws IOException {
        String mostrar = "SELECT * FROM almacenes_facturas";


        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_id_config.setText(rs.getString(1));
                //3
                txt_nro_timbra_surc_3.setText(rs.getString(2));
                txt_seq_surc_3.setText(rs.getString(3));
                txt_lote_surc_3.setText(rs.getString(4));
                //4
                txt_nro_timbra_surc_4.setText(rs.getString(5));
                txt_seq_surc_4.setText(rs.getString(6));
                txt_lote_surc_4.setText(rs.getString(7));
                //5
                txt_nro_timbra_surc_5.setText(rs.getString(8));
                txt_seq_surc_5.setText(rs.getString(9));
                txt_lote_surc_5.setText(rs.getString(10));
                //6
                txt_nro_timbra_surc_6.setText(rs.getString(11));
                txt_seq_surc_6.setText(rs.getString(12));
                txt_lote_surc_6.setText(rs.getString(13));
                
                //7
                txt_nro_timbra_surc_7.setText(rs.getString(14));
                txt_seq_surc_7.setText(rs.getString(15));
                txt_lote_surc_7.setText(rs.getString(16));
                //8
                txt_nro_timbra_surc_8.setText(rs.getString(17));
                txt_seq_surc_8.setText(rs.getString(18));
                txt_lote_surc_8.setText(rs.getString(19));
                //9
                txt_nro_timbra_surc_9.setText(rs.getString(20));
                txt_seq_surc_9.setText(rs.getString(21));
                txt_lote_surc_9.setText(rs.getString(22));
                //10
                txt_nro_timbra_surc_10.setText(rs.getString(23));
                txt_seq_surc_10.setText(rs.getString(24));
                txt_lote_surc_10.setText(rs.getString(25));
                //surc_11//
                txt_nro_timbra_surc_11.setText(rs.getString(26));
                txt_seq_surc_11.setText(rs.getString(27));
                txt_lote_surc_11.setText(rs.getString(28));
                //12
                txt_nro_timbra_surc_12.setText(rs.getString(29));
                txt_seq_surc_12.setText(rs.getString(30));
                txt_lote_surc_12.setText(rs.getString(31));
                //13
                txt_nro_timbra_surc_13.setText(rs.getString(32));
                txt_seq_surc_13.setText(rs.getString(33));
                txt_lote_surc_13.setText(rs.getString(34));
                //14
                txt_nro_timbra_surc_14.setText(rs.getString(35));
                txt_seq_surc_14.setText(rs.getString(36));
                txt_lote_surc_14.setText(rs.getString(37));
                //15
                txt_nro_timbra_surc_15.setText(rs.getString(38));
                txt_seq_surc_15.setText(rs.getString(39));
                txt_lote_surc_15.setText(rs.getString(40));
                //16
                txt_nro_timbra_surc_16.setText(rs.getString(41));
                txt_seq_surc_16.setText(rs.getString(42));
                txt_lote_surc_16.setText(rs.getString(43));
                //17
                txt_nro_timbra_surc_17.setText(rs.getString(44));
                txt_seq_surc_17.setText(rs.getString(45));
                txt_lote_surc_17.setText(rs.getString(46));
                //18
                txt_nro_timbra_surc_18.setText(rs.getString(47));
                txt_seq_surc_18.setText(rs.getString(48));
                txt_lote_surc_18.setText(rs.getString(49));
                //19
                txt_nro_timbra_surc_19.setText(rs.getString(50));
                txt_seq_surc_19.setText(rs.getString(51));
                txt_lote_surc_19.setText(rs.getString(52));
                //20
                txt_nro_timbra_surc_20.setText(rs.getString(53));
                txt_seq_surc_20.setText(rs.getString(54));
                txt_lote_surc_20.setText(rs.getString(55));
                //21
                txt_nro_timbra_surc_21.setText(rs.getString(56));
                txt_seq_surc_21.setText(rs.getString(57));
                txt_lote_surc_21.setText(rs.getString(58));
                //surc_22//
                txt_nro_timbra_surc_22.setText(rs.getString(59));
                txt_seq_surc_22.setText(rs.getString(60));
                txt_lote_surc_22.setText(rs.getString(61));
                /////surc_23
                txt_nro_timbra_surc_23.setText(rs.getString(62));
                txt_seq_surc_23.setText(rs.getString(63));
                txt_lote_surc_23.setText(rs.getString(64));
                //24
                txt_nro_timbra_surc_24.setText(rs.getString(65));
                txt_seq_surc_24.setText(rs.getString(66));
                txt_lote_surc_24.setText(rs.getString(67));
                //25
                txt_nro_timbra_surc_25.setText(rs.getString(68));
                txt_seq_surc_25.setText(rs.getString(69));
                txt_lote_surc_25.setText(rs.getString(70));
                //26
                txt_nro_timbra_surc_26.setText(rs.getString(71));
                txt_seq_surc_26.setText(rs.getString(72));
                txt_lote_surc_26.setText(rs.getString(73));
                //27
                txt_nro_timbra_surc_28.setText(rs.getString(74));
                txt_seq_surc_27.setText(rs.getString(75));
                txt_lote_surc_27.setText(rs.getString(76));
                //28
                txt_nro_timbra_surc_28.setText(rs.getString(77));
                txt_seq_surc_28.setText(rs.getString(78));
                txt_lote_surc_28.setText(rs.getString(79));
                //29*
                txt_nro_timbra_surc_29.setText(rs.getString(80));
                txt_seq_surc_29.setText(rs.getString(81));
                txt_lote_surc_29.setText(rs.getString(82));
//30
                txt_nro_timbra_surc_30.setText(rs.getString(83));
                txt_seq_surc_30.setText(rs.getString(84));
                txt_lote_surc_30.setText(rs.getString(85));
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(config_sucursales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lbl_id_config = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_nro_timbra_surc_3 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        txt_seq_surc_3 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        txt_lote_surc_3 = new javax.swing.JTextField();
        bnt_3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txt_nro_timbra_surc_4 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txt_seq_surc_4 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txt_lote_surc_4 = new javax.swing.JTextField();
        bnt_4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txt_nro_timbra_surc_5 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txt_seq_surc_5 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txt_lote_surc_5 = new javax.swing.JTextField();
        bnt_5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_nro_timbra_surc_6 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        txt_seq_surc_6 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        txt_lote_surc_6 = new javax.swing.JTextField();
        bnt_6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_nro_timbra_surc_7 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        txt_seq_surc_7 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        txt_lote_surc_7 = new javax.swing.JTextField();
        bnt_7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_nro_timbra_surc_8 = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        txt_seq_surc_8 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        txt_lote_surc_8 = new javax.swing.JTextField();
        bnt_8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_nro_timbra_surc_9 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        txt_seq_surc_9 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txt_lote_surc_9 = new javax.swing.JTextField();
        bnt_9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_nro_timbra_surc_10 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        txt_seq_surc_10 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        txt_lote_surc_10 = new javax.swing.JTextField();
        bnt_10 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_nro_timbra_surc_11 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txt_seq_surc_11 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txt_lote_surc_11 = new javax.swing.JTextField();
        bnt_11 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_nro_timbra_surc_12 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        txt_seq_surc_12 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        txt_lote_surc_12 = new javax.swing.JTextField();
        bnt_12 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_nro_timbra_surc_13 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        txt_seq_surc_13 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        txt_lote_surc_13 = new javax.swing.JTextField();
        bnt_13 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_nro_timbra_surc_14 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        txt_seq_surc_14 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        txt_lote_surc_14 = new javax.swing.JTextField();
        bnt_14 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_nro_timbra_surc_15 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        txt_seq_surc_15 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        txt_lote_surc_15 = new javax.swing.JTextField();
        bnt_15 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_nro_timbra_surc_16 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        txt_seq_surc_16 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        txt_lote_surc_16 = new javax.swing.JTextField();
        bnt_16 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_nro_timbra_surc_17 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        txt_seq_surc_17 = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        txt_lote_surc_17 = new javax.swing.JTextField();
        bnt_17 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_nro_timbra_surc_18 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        txt_seq_surc_18 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        txt_lote_surc_18 = new javax.swing.JTextField();
        bnt_18 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nro_timbra_surc_19 = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        txt_seq_surc_19 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        txt_lote_surc_19 = new javax.swing.JTextField();
        bnt_19 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nro_timbra_surc_20 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        txt_seq_surc_20 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        txt_lote_surc_20 = new javax.swing.JTextField();
        bnt_20 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        txt_nro_timbra_surc_21 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        txt_seq_surc_21 = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        txt_lote_surc_21 = new javax.swing.JTextField();
        bnt_21 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        txt_nro_timbra_surc_22 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txt_seq_surc_22 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txt_lote_surc_22 = new javax.swing.JTextField();
        bnt_22 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        txt_lote_surc_23 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txt_nro_timbra_surc_23 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txt_seq_surc_23 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        bnt_23 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txt_nro_timbra_surc_24 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        txt_seq_surc_24 = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        txt_lote_surc_24 = new javax.swing.JTextField();
        bnt_24 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        txt_seq_surc_25 = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        txt_nro_timbra_surc_25 = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        txt_lote_surc_25 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        bnt_25 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        txt_seq_surc_26 = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        txt_nro_timbra_surc_26 = new javax.swing.JTextField();
        jLabel156 = new javax.swing.JLabel();
        txt_lote_surc_26 = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        bnt_26 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        txt_seq_surc_27 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        txt_nro_timbra_surc_27 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        txt_lote_surc_27 = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        bnt_27 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        txt_seq_surc_28 = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        txt_nro_timbra_surc_28 = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        txt_lote_surc_28 = new javax.swing.JTextField();
        jLabel171 = new javax.swing.JLabel();
        bnt_28 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        txt_seq_surc_29 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        txt_nro_timbra_surc_29 = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        txt_lote_surc_29 = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        bnt_29 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        txt_seq_surc_30 = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        txt_nro_timbra_surc_30 = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        txt_lote_surc_30 = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        bnt_30 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuentas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTabbedPane1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_id_config.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_id_config.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id_config.setText("0");
        jPanel2.add(lbl_id_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 70, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/note.png"))); // NOI18N
        jLabel19.setText("Configuracion Sucursales/Almacenes");
        jLabel19.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel19.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 810, 440));

        jTabbedPane1.addTab("Conf. sucursales", new javax.swing.ImageIcon(getClass().getResource("/icon_4/abacus.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Configuracion Sucursal Nro 3");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel3.add(txt_nro_timbra_surc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel79.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel79.setText("Timbrado:");
        jPanel3.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel80.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel80.setText("Sequencia:");
        jPanel3.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel3.add(txt_seq_surc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel81.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel81.setText("Lote-Establ.:");
        jPanel3.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel3.add(txt_lote_surc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_3.setBackground(new java.awt.Color(255, 255, 255));
        bnt_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_3ActionPerformed(evt);
            }
        });
        jPanel3.add(bnt_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 3", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel3); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Configuracion Sucursal Nro 4");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel4.add(txt_nro_timbra_surc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel83.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel83.setText("Timbrado:");
        jPanel4.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel84.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel84.setText("Sequencia:");
        jPanel4.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel4.add(txt_seq_surc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel85.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel85.setText("Lote-Establ.:");
        jPanel4.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel4.add(txt_lote_surc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_4.setBackground(new java.awt.Color(255, 255, 255));
        bnt_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_4ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 4", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel4); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Configuracion Sucursal Nro 5");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel5.add(txt_nro_timbra_surc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel87.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel87.setText("Timbrado:");
        jPanel5.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel88.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel88.setText("Sequencia:");
        jPanel5.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel5.add(txt_seq_surc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel89.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel89.setText("Lote-Establ.:");
        jPanel5.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel5.add(txt_lote_surc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_5.setBackground(new java.awt.Color(255, 255, 255));
        bnt_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_5ActionPerformed(evt);
            }
        });
        jPanel5.add(bnt_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 5", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel5); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Configuracion Sucursal Nro 6");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel6.add(txt_nro_timbra_surc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel91.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel91.setText("Timbrado:");
        jPanel6.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel92.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel92.setText("Sequencia:");
        jPanel6.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel6.add(txt_seq_surc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel93.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel93.setText("Lote-Establ.:");
        jPanel6.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel6.add(txt_lote_surc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_6.setBackground(new java.awt.Color(255, 255, 255));
        bnt_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_6ActionPerformed(evt);
            }
        });
        jPanel6.add(bnt_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 6", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel6); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Configuracion Sucursal Nro 7");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel7.add(txt_nro_timbra_surc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel95.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel95.setText("Timbrado:");
        jPanel7.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel96.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel96.setText("Sequencia:");
        jPanel7.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel7.add(txt_seq_surc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel97.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel97.setText("Lote-Establ.:");
        jPanel7.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel7.add(txt_lote_surc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_7.setBackground(new java.awt.Color(255, 255, 255));
        bnt_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_7ActionPerformed(evt);
            }
        });
        jPanel7.add(bnt_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 7", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel7); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Configuracion Sucursal Nro 8");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel8.add(txt_nro_timbra_surc_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel99.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel99.setText("Timbrado:");
        jPanel8.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel100.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel100.setText("Sequencia:");
        jPanel8.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel8.add(txt_seq_surc_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel101.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel101.setText("Lote-Establ.:");
        jPanel8.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel8.add(txt_lote_surc_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_8.setBackground(new java.awt.Color(255, 255, 255));
        bnt_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_8ActionPerformed(evt);
            }
        });
        jPanel8.add(bnt_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 8", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel8); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Configuracion Sucursal Nro 9");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel9.add(txt_nro_timbra_surc_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel103.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel103.setText("Timbrado:");
        jPanel9.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel104.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel104.setText("Sequencia:");
        jPanel9.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel9.add(txt_seq_surc_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel105.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel105.setText("Lote-Establ.:");
        jPanel9.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel9.add(txt_lote_surc_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_9.setBackground(new java.awt.Color(255, 255, 255));
        bnt_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_9ActionPerformed(evt);
            }
        });
        jPanel9.add(bnt_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 9", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel9); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Configuracion Sucursal Nro 10");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel10.add(txt_nro_timbra_surc_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel107.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel107.setText("Timbrado:");
        jPanel10.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel108.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel108.setText("Sequencia:");
        jPanel10.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel10.add(txt_seq_surc_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel109.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel109.setText("Lote-Establ.:");
        jPanel10.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel10.add(txt_lote_surc_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_10.setBackground(new java.awt.Color(255, 255, 255));
        bnt_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_10ActionPerformed(evt);
            }
        });
        jPanel10.add(bnt_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 10", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel10); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel11.setOpaque(false);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Configuracion Sucursal Nro 11");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel11.add(txt_nro_timbra_surc_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel54.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel54.setText("Timbrado:");
        jPanel11.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel55.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel55.setText("Sequencia:");
        jPanel11.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel11.add(txt_seq_surc_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel56.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel56.setText("Lote-Establ.:");
        jPanel11.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel11.add(txt_lote_surc_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_11.setBackground(new java.awt.Color(255, 255, 255));
        bnt_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_11ActionPerformed(evt);
            }
        });
        jPanel11.add(bnt_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 11", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel11); // NOI18N

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Configuracion Sucursal Nro 12");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel12.add(txt_nro_timbra_surc_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel111.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel111.setText("Timbrado:");
        jPanel12.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel112.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel112.setText("Sequencia:");
        jPanel12.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel12.add(txt_seq_surc_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel113.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel113.setText("Lote-Establ.:");
        jPanel12.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel12.add(txt_lote_surc_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_12.setBackground(new java.awt.Color(255, 255, 255));
        bnt_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_12ActionPerformed(evt);
            }
        });
        jPanel12.add(bnt_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 12", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel12); // NOI18N

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Configuracion Sucursal Nro 13");
        jPanel13.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel13.add(txt_nro_timbra_surc_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel115.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel115.setText("Timbrado:");
        jPanel13.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel116.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel116.setText("Sequencia:");
        jPanel13.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel13.add(txt_seq_surc_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel117.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel117.setText("Lote-Establ.:");
        jPanel13.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel13.add(txt_lote_surc_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_13.setBackground(new java.awt.Color(255, 255, 255));
        bnt_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_13ActionPerformed(evt);
            }
        });
        jPanel13.add(bnt_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 13", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel13); // NOI18N

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Configuracion Sucursal Nro 14");
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel14.add(txt_nro_timbra_surc_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel119.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel119.setText("Timbrado:");
        jPanel14.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel120.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel120.setText("Sequencia:");
        jPanel14.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel14.add(txt_seq_surc_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel121.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel121.setText("Lote-Establ.:");
        jPanel14.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel14.add(txt_lote_surc_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_14.setBackground(new java.awt.Color(255, 255, 255));
        bnt_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_14ActionPerformed(evt);
            }
        });
        jPanel14.add(bnt_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 14", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel14); // NOI18N

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Configuracion Sucursal Nro 15");
        jPanel15.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel15.add(txt_nro_timbra_surc_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel123.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel123.setText("Timbrado:");
        jPanel15.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel124.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel124.setText("Sequencia:");
        jPanel15.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel15.add(txt_seq_surc_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel125.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel125.setText("Lote-Establ.:");
        jPanel15.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel15.add(txt_lote_surc_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_15.setBackground(new java.awt.Color(255, 255, 255));
        bnt_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_15ActionPerformed(evt);
            }
        });
        jPanel15.add(bnt_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 15", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel15); // NOI18N

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel16.setOpaque(false);
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Configuracion Sucursal Nro 16");
        jPanel16.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel16.add(txt_nro_timbra_surc_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel127.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel127.setText("Timbrado:");
        jPanel16.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel128.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel128.setText("Sequencia:");
        jPanel16.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel16.add(txt_seq_surc_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel129.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel129.setText("Lote-Establ.:");
        jPanel16.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel16.add(txt_lote_surc_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_16.setBackground(new java.awt.Color(255, 255, 255));
        bnt_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_16ActionPerformed(evt);
            }
        });
        jPanel16.add(bnt_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 16", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel16); // NOI18N

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel17.setOpaque(false);
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Configuracion Sucursal Nro 17");
        jPanel17.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel17.add(txt_nro_timbra_surc_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel131.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel131.setText("Timbrado:");
        jPanel17.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel132.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel132.setText("Sequencia:");
        jPanel17.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel17.add(txt_seq_surc_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel133.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel133.setText("Lote-Establ.:");
        jPanel17.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel17.add(txt_lote_surc_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_17.setBackground(new java.awt.Color(255, 255, 255));
        bnt_17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_17ActionPerformed(evt);
            }
        });
        jPanel17.add(bnt_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 17", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel17); // NOI18N

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel18.setOpaque(false);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Configuracion Sucursal Nro 18");
        jPanel18.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel18.add(txt_nro_timbra_surc_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel135.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel135.setText("Timbrado:");
        jPanel18.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel136.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel136.setText("Sequencia:");
        jPanel18.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel18.add(txt_seq_surc_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel137.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel137.setText("Lote-Establ.:");
        jPanel18.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel18.add(txt_lote_surc_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_18.setBackground(new java.awt.Color(255, 255, 255));
        bnt_18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_18ActionPerformed(evt);
            }
        });
        jPanel18.add(bnt_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 18", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel18); // NOI18N

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel19.setOpaque(false);
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Configuracion Sucursal Nro 19");
        jPanel19.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel19.add(txt_nro_timbra_surc_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel139.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel139.setText("Timbrado:");
        jPanel19.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel140.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel140.setText("Sequencia:");
        jPanel19.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel19.add(txt_seq_surc_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel141.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel141.setText("Lote-Establ.:");
        jPanel19.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel19.add(txt_lote_surc_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_19.setBackground(new java.awt.Color(255, 255, 255));
        bnt_19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_19ActionPerformed(evt);
            }
        });
        jPanel19.add(bnt_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 19", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel19); // NOI18N

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel20.setOpaque(false);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Configuracion Sucursal Nro 20");
        jPanel20.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel20.add(txt_nro_timbra_surc_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel142.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel142.setText("Timbrado:");
        jPanel20.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel143.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel143.setText("Sequencia:");
        jPanel20.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel20.add(txt_seq_surc_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel144.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel144.setText("Lote-Establ.:");
        jPanel20.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel20.add(txt_lote_surc_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_20.setBackground(new java.awt.Color(255, 255, 255));
        bnt_20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_20ActionPerformed(evt);
            }
        });
        jPanel20.add(bnt_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 20", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel20); // NOI18N

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setText("Configuracion Sucursal Nro 21");
        jPanel21.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel21.add(txt_nro_timbra_surc_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel146.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel146.setText("Timbrado:");
        jPanel21.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel147.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel147.setText("Sequencia:");
        jPanel21.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel21.add(txt_seq_surc_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel148.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel148.setText("Lote-Establ.:");
        jPanel21.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel21.add(txt_lote_surc_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_21.setBackground(new java.awt.Color(255, 255, 255));
        bnt_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_21ActionPerformed(evt);
            }
        });
        jPanel21.add(bnt_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 21", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel21); // NOI18N

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel58.setText("Configuracion Sucursal Nro 22");
        jPanel22.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel22.add(txt_nro_timbra_surc_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel62.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel62.setText("Timbrado:");
        jPanel22.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel63.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel63.setText("Sequencia:");
        jPanel22.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel22.add(txt_seq_surc_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel64.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel64.setText("Lote-Establ.:");
        jPanel22.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel22.add(txt_lote_surc_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        bnt_22.setBackground(new java.awt.Color(255, 255, 255));
        bnt_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_22ActionPerformed(evt);
            }
        });
        jPanel22.add(bnt_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 22", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel22); // NOI18N

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel23.add(txt_lote_surc_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, 30));

        jLabel65.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel65.setText("Lote-Establ.:");
        jPanel23.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, 30));
        jPanel23.add(txt_nro_timbra_surc_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, 30));

        jLabel66.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel66.setText("Timbrado:");
        jPanel23.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 30));

        jLabel67.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel67.setText("Sequencia:");
        jPanel23.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 30));

        txt_seq_surc_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_seq_surc_23ActionPerformed(evt);
            }
        });
        jPanel23.add(txt_seq_surc_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 60, 30));

        jLabel75.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel75.setText("Configuracion Sucursal Nro 23");
        jPanel23.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bnt_23.setBackground(new java.awt.Color(255, 255, 255));
        bnt_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_23ActionPerformed(evt);
            }
        });
        jPanel23.add(bnt_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 23", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel23); // NOI18N

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel74.setText("Configuracion Sucursal Nro 24");
        jPanel24.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel76.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel76.setText("Timbrado Nro:");
        jPanel24.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_surc_24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel24.add(txt_nro_timbra_surc_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel151.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel151.setText("Sequencia:");
        jPanel24.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));
        jPanel24.add(txt_seq_surc_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel152.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel152.setText("Lote-Establ.:");
        jPanel24.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel24.add(txt_lote_surc_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        bnt_24.setBackground(new java.awt.Color(255, 255, 255));
        bnt_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_24ActionPerformed(evt);
            }
        });
        jPanel24.add(bnt_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 24", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel24); // NOI18N

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel25.add(txt_seq_surc_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel153.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel153.setText("Sequencia:");
        jPanel25.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel149.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel149.setText("Timbrado Nro:");
        jPanel25.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_surc_25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel25.add(txt_nro_timbra_surc_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel154.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel154.setText("Lote-Establ.:");
        jPanel25.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel25.add(txt_lote_surc_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jLabel77.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel77.setText("Configuracion Sucursal Nro 25");
        jPanel25.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bnt_25.setBackground(new java.awt.Color(255, 255, 255));
        bnt_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_25ActionPerformed(evt);
            }
        });
        jPanel25.add(bnt_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 25", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel25); // NOI18N

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel26.add(txt_seq_surc_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel155.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel155.setText("Sequencia:");
        jPanel26.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel150.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel150.setText("Timbrado Nro:");
        jPanel26.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_surc_26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel26.add(txt_nro_timbra_surc_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel156.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel156.setText("Lote-Establ.:");
        jPanel26.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel26.add(txt_lote_surc_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jLabel169.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel169.setText("Configuracion Sucursal Nro 26");
        jPanel26.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bnt_26.setBackground(new java.awt.Color(255, 255, 255));
        bnt_26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_26ActionPerformed(evt);
            }
        });
        jPanel26.add(bnt_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 26", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel26); // NOI18N

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(txt_seq_surc_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel157.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel157.setText("Sequencia:");
        jPanel27.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel158.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel158.setText("Timbrado Nro:");
        jPanel27.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_surc_27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel27.add(txt_nro_timbra_surc_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel159.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel159.setText("Lote-Establ.:");
        jPanel27.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel27.add(txt_lote_surc_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jLabel170.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel170.setText("Configuracion Sucursal Nro 27");
        jPanel27.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bnt_27.setBackground(new java.awt.Color(255, 255, 255));
        bnt_27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_27ActionPerformed(evt);
            }
        });
        jPanel27.add(bnt_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 27", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel27); // NOI18N

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(txt_seq_surc_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel160.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel160.setText("Sequencia:");
        jPanel28.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel161.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel161.setText("Timbrado Nro:");
        jPanel28.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_surc_28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel28.add(txt_nro_timbra_surc_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel162.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel162.setText("Lote-Establ.:");
        jPanel28.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel28.add(txt_lote_surc_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jLabel171.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel171.setText("Configuracion Sucursal Nro 28");
        jPanel28.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bnt_28.setBackground(new java.awt.Color(255, 255, 255));
        bnt_28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_28ActionPerformed(evt);
            }
        });
        jPanel28.add(bnt_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 28", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel28); // NOI18N

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel29.add(txt_seq_surc_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel163.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel163.setText("Sequencia:");
        jPanel29.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel164.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel164.setText("Timbrado Nro:");
        jPanel29.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_surc_29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel29.add(txt_nro_timbra_surc_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel165.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel165.setText("Lote-Establ.:");
        jPanel29.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel29.add(txt_lote_surc_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jLabel172.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel172.setText("Configuracion Sucursal Nro 29");
        jPanel29.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bnt_29.setBackground(new java.awt.Color(255, 255, 255));
        bnt_29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_29ActionPerformed(evt);
            }
        });
        jPanel29.add(bnt_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 29", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel29); // NOI18N

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel30.add(txt_seq_surc_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel166.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel166.setText("Sequencia:");
        jPanel30.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel167.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel167.setText("Timbrado Nro:");
        jPanel30.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_surc_30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel30.add(txt_nro_timbra_surc_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel168.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel168.setText("Lote-Establ.:");
        jPanel30.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel30.add(txt_lote_surc_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jLabel173.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel173.setText("Configuracion Sucursal Nro 30");
        jPanel30.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bnt_30.setBackground(new java.awt.Color(255, 255, 255));
        bnt_30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/rehacer.png"))); // NOI18N
        bnt_30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_30ActionPerformed(evt);
            }
        });
        jPanel30.add(bnt_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, 50));

        jTabbedPane1.addTab("Surc. 30", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel30); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_seq_surc_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_seq_surc_23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_seq_surc_23ActionPerformed

    private void bnt_30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_30ActionPerformed
     update_empre_30();
    }//GEN-LAST:event_bnt_30ActionPerformed

    private void bnt_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_3ActionPerformed
          update_empre_3();
    }//GEN-LAST:event_bnt_3ActionPerformed

    private void bnt_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_4ActionPerformed
             update_empre_4();
    }//GEN-LAST:event_bnt_4ActionPerformed

    private void bnt_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_5ActionPerformed
             update_empre_5();
    }//GEN-LAST:event_bnt_5ActionPerformed

    private void bnt_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_6ActionPerformed
             update_empre_6();
    }//GEN-LAST:event_bnt_6ActionPerformed

    private void bnt_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_7ActionPerformed
            update_empre_7();
    }//GEN-LAST:event_bnt_7ActionPerformed

    private void bnt_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_8ActionPerformed
            update_empre_8();
    }//GEN-LAST:event_bnt_8ActionPerformed

    private void bnt_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_9ActionPerformed
             update_empre_9();
    }//GEN-LAST:event_bnt_9ActionPerformed

    private void bnt_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_10ActionPerformed
       update_empre_10();
    }//GEN-LAST:event_bnt_10ActionPerformed

    private void bnt_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_11ActionPerformed
            update_empre_11();
    }//GEN-LAST:event_bnt_11ActionPerformed

    private void bnt_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_12ActionPerformed
           update_empre_12();
    }//GEN-LAST:event_bnt_12ActionPerformed

    private void bnt_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_13ActionPerformed
             update_empre_13();
    }//GEN-LAST:event_bnt_13ActionPerformed

    private void bnt_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_14ActionPerformed
             update_empre_14();
    }//GEN-LAST:event_bnt_14ActionPerformed

    private void bnt_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_15ActionPerformed
         update_empre_15();
    }//GEN-LAST:event_bnt_15ActionPerformed

    private void bnt_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_16ActionPerformed
            update_empre_16();
    }//GEN-LAST:event_bnt_16ActionPerformed

    private void bnt_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_17ActionPerformed
           update_empre_17();
    }//GEN-LAST:event_bnt_17ActionPerformed

    private void bnt_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_18ActionPerformed
          update_empre_18();
    }//GEN-LAST:event_bnt_18ActionPerformed

    private void bnt_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_19ActionPerformed
            update_empre_19();
    }//GEN-LAST:event_bnt_19ActionPerformed

    private void bnt_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_20ActionPerformed
            update_empre_20();
    }//GEN-LAST:event_bnt_20ActionPerformed

    private void bnt_21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_21ActionPerformed
            update_empre_21();
    }//GEN-LAST:event_bnt_21ActionPerformed

    private void bnt_22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_22ActionPerformed
             update_empre_22();
    }//GEN-LAST:event_bnt_22ActionPerformed

    private void bnt_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_23ActionPerformed
         update_empre_23();
    }//GEN-LAST:event_bnt_23ActionPerformed

    private void bnt_24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_24ActionPerformed
            update_empre_24();
    }//GEN-LAST:event_bnt_24ActionPerformed

    private void bnt_25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_25ActionPerformed
           update_empre_25();
    }//GEN-LAST:event_bnt_25ActionPerformed

    private void bnt_26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_26ActionPerformed
            update_empre_26();
    }//GEN-LAST:event_bnt_26ActionPerformed

    private void bnt_27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_27ActionPerformed
            update_empre_27();
    }//GEN-LAST:event_bnt_27ActionPerformed

    private void bnt_28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_28ActionPerformed
             update_empre_28();
    }//GEN-LAST:event_bnt_28ActionPerformed

    private void bnt_29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_29ActionPerformed
            update_empre_29();
    }//GEN-LAST:event_bnt_29ActionPerformed

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
            java.util.logging.Logger.getLogger(config_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(config_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(config_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(config_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                try {
                    config_sucursales dialog = new config_sucursales(new javax.swing.JDialog(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(config_sucursales.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_10;
    private javax.swing.JButton bnt_11;
    private javax.swing.JButton bnt_12;
    private javax.swing.JButton bnt_13;
    private javax.swing.JButton bnt_14;
    private javax.swing.JButton bnt_15;
    private javax.swing.JButton bnt_16;
    private javax.swing.JButton bnt_17;
    private javax.swing.JButton bnt_18;
    private javax.swing.JButton bnt_19;
    private javax.swing.JButton bnt_20;
    private javax.swing.JButton bnt_21;
    private javax.swing.JButton bnt_22;
    private javax.swing.JButton bnt_23;
    private javax.swing.JButton bnt_24;
    private javax.swing.JButton bnt_25;
    private javax.swing.JButton bnt_26;
    private javax.swing.JButton bnt_27;
    private javax.swing.JButton bnt_28;
    private javax.swing.JButton bnt_29;
    private javax.swing.JButton bnt_3;
    private javax.swing.JButton bnt_30;
    private javax.swing.JButton bnt_4;
    private javax.swing.JButton bnt_5;
    private javax.swing.JButton bnt_6;
    private javax.swing.JButton bnt_7;
    private javax.swing.JButton bnt_8;
    private javax.swing.JButton bnt_9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_id_config;
    private javax.swing.JTextField txt_lote_surc_10;
    private javax.swing.JTextField txt_lote_surc_11;
    private javax.swing.JTextField txt_lote_surc_12;
    private javax.swing.JTextField txt_lote_surc_13;
    private javax.swing.JTextField txt_lote_surc_14;
    private javax.swing.JTextField txt_lote_surc_15;
    private javax.swing.JTextField txt_lote_surc_16;
    private javax.swing.JTextField txt_lote_surc_17;
    private javax.swing.JTextField txt_lote_surc_18;
    private javax.swing.JTextField txt_lote_surc_19;
    private javax.swing.JTextField txt_lote_surc_20;
    private javax.swing.JTextField txt_lote_surc_21;
    private javax.swing.JTextField txt_lote_surc_22;
    private javax.swing.JTextField txt_lote_surc_23;
    private javax.swing.JTextField txt_lote_surc_24;
    private javax.swing.JTextField txt_lote_surc_25;
    private javax.swing.JTextField txt_lote_surc_26;
    private javax.swing.JTextField txt_lote_surc_27;
    private javax.swing.JTextField txt_lote_surc_28;
    private javax.swing.JTextField txt_lote_surc_29;
    private javax.swing.JTextField txt_lote_surc_3;
    private javax.swing.JTextField txt_lote_surc_30;
    private javax.swing.JTextField txt_lote_surc_4;
    private javax.swing.JTextField txt_lote_surc_5;
    private javax.swing.JTextField txt_lote_surc_6;
    private javax.swing.JTextField txt_lote_surc_7;
    private javax.swing.JTextField txt_lote_surc_8;
    private javax.swing.JTextField txt_lote_surc_9;
    private javax.swing.JTextField txt_nro_timbra_surc_10;
    private javax.swing.JTextField txt_nro_timbra_surc_11;
    private javax.swing.JTextField txt_nro_timbra_surc_12;
    private javax.swing.JTextField txt_nro_timbra_surc_13;
    private javax.swing.JTextField txt_nro_timbra_surc_14;
    private javax.swing.JTextField txt_nro_timbra_surc_15;
    private javax.swing.JTextField txt_nro_timbra_surc_16;
    private javax.swing.JTextField txt_nro_timbra_surc_17;
    private javax.swing.JTextField txt_nro_timbra_surc_18;
    private javax.swing.JTextField txt_nro_timbra_surc_19;
    private javax.swing.JTextField txt_nro_timbra_surc_20;
    private javax.swing.JTextField txt_nro_timbra_surc_21;
    private javax.swing.JTextField txt_nro_timbra_surc_22;
    private javax.swing.JTextField txt_nro_timbra_surc_23;
    private javax.swing.JTextField txt_nro_timbra_surc_24;
    private javax.swing.JTextField txt_nro_timbra_surc_25;
    private javax.swing.JTextField txt_nro_timbra_surc_26;
    private javax.swing.JTextField txt_nro_timbra_surc_27;
    private javax.swing.JTextField txt_nro_timbra_surc_28;
    private javax.swing.JTextField txt_nro_timbra_surc_29;
    private javax.swing.JTextField txt_nro_timbra_surc_3;
    private javax.swing.JTextField txt_nro_timbra_surc_30;
    private javax.swing.JTextField txt_nro_timbra_surc_4;
    private javax.swing.JTextField txt_nro_timbra_surc_5;
    private javax.swing.JTextField txt_nro_timbra_surc_6;
    private javax.swing.JTextField txt_nro_timbra_surc_7;
    private javax.swing.JTextField txt_nro_timbra_surc_8;
    private javax.swing.JTextField txt_nro_timbra_surc_9;
    private javax.swing.JTextField txt_seq_surc_10;
    private javax.swing.JTextField txt_seq_surc_11;
    private javax.swing.JTextField txt_seq_surc_12;
    private javax.swing.JTextField txt_seq_surc_13;
    private javax.swing.JTextField txt_seq_surc_14;
    private javax.swing.JTextField txt_seq_surc_15;
    private javax.swing.JTextField txt_seq_surc_16;
    private javax.swing.JTextField txt_seq_surc_17;
    private javax.swing.JTextField txt_seq_surc_18;
    private javax.swing.JTextField txt_seq_surc_19;
    private javax.swing.JTextField txt_seq_surc_20;
    private javax.swing.JTextField txt_seq_surc_21;
    private javax.swing.JTextField txt_seq_surc_22;
    private javax.swing.JTextField txt_seq_surc_23;
    private javax.swing.JTextField txt_seq_surc_24;
    private javax.swing.JTextField txt_seq_surc_25;
    private javax.swing.JTextField txt_seq_surc_26;
    private javax.swing.JTextField txt_seq_surc_27;
    private javax.swing.JTextField txt_seq_surc_28;
    private javax.swing.JTextField txt_seq_surc_29;
    private javax.swing.JTextField txt_seq_surc_3;
    private javax.swing.JTextField txt_seq_surc_30;
    private javax.swing.JTextField txt_seq_surc_4;
    private javax.swing.JTextField txt_seq_surc_5;
    private javax.swing.JTextField txt_seq_surc_6;
    private javax.swing.JTextField txt_seq_surc_7;
    private javax.swing.JTextField txt_seq_surc_8;
    private javax.swing.JTextField txt_seq_surc_9;
    // End of variables declaration//GEN-END:variables

    void update_empre_3() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_3 = txt_nro_timbra_surc_3.getText();
            String seq_surc_3 = txt_seq_surc_3.getText();
            String lote_surc_3 = txt_lote_surc_3.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_3 = '" + timbra_surc_3
                    + "',nro_esta_3 ='" + seq_surc_3
                    + "',nro_seq_3 ='" + lote_surc_3
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_4() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_4 = txt_nro_timbra_surc_4.getText();
            String seq_surc_4 = txt_seq_surc_4.getText();
            String lote_surc_4 = txt_lote_surc_4.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_4 = '" + timbra_surc_4
                    + "',nro_esta_4 ='" + seq_surc_4
                    + "',nro_seq_4 ='" + lote_surc_4
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_5() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_5 = txt_nro_timbra_surc_5.getText();
            String seq_surc_5 = txt_seq_surc_5.getText();
            String lote_surc_5 = txt_lote_surc_5.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_5 = '" + timbra_surc_5
                    + "',nro_esta_5 ='" + seq_surc_5
                    + "',nro_seq_5 ='" + lote_surc_5
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_6() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_6 = txt_nro_timbra_surc_6.getText();
            String seq_surc_6 = txt_seq_surc_6.getText();
            String lote_surc_6 = txt_lote_surc_6.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_6 = '" + timbra_surc_6
                    + "',nro_esta_6 ='" + seq_surc_6
                    + "',nro_seq_6 ='" + lote_surc_6
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_7() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_7 = txt_nro_timbra_surc_7.getText();
            String seq_surc_7 = txt_seq_surc_7.getText();
            String lote_surc_7 = txt_lote_surc_7.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_7 = '" + timbra_surc_7
                    + "',nro_esta_7 ='" + seq_surc_7
                    + "',nro_seq_7 ='" + lote_surc_7
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_8() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_8 = txt_nro_timbra_surc_8.getText();
            String seq_surc_8 = txt_seq_surc_8.getText();
            String lote_surc_8 = txt_lote_surc_8.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_8 = '" + timbra_surc_8
                    + "',nro_esta_8 ='" + seq_surc_8
                    + "',nro_seq_8 ='" + lote_surc_8
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_9() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_9 = txt_nro_timbra_surc_9.getText();
            String seq_surc_9 = txt_seq_surc_9.getText();
            String lote_surc_9 = txt_lote_surc_9.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_9 = '" + timbra_surc_9
                    + "',nro_esta_9 ='" + seq_surc_9
                    + "',nro_seq_9 ='" + lote_surc_9
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_10() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_10 = txt_nro_timbra_surc_10.getText();
            String seq_surc_10 = txt_seq_surc_10.getText();
            String lote_surc_10 = txt_lote_surc_10.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_10 = '" + timbra_surc_10
                    + "',nro_esta_10 ='" + seq_surc_10
                    + "',nro_seq_10 ='" + lote_surc_10
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_11() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_11 = txt_nro_timbra_surc_11.getText();
            String seq_surc_11 = txt_seq_surc_11.getText();
            String lote_surc_11 = txt_lote_surc_11.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_11 = '" + timbra_surc_11
                    + "',nro_esta_11 ='" + seq_surc_11
                    + "',nro_seq_11='" + lote_surc_11
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_12() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_12 = txt_nro_timbra_surc_12.getText();
            String seq_surc_12 = txt_seq_surc_12.getText();
            String lote_surc_12 = txt_lote_surc_12.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_12 = '" + timbra_surc_12
                    + "',nro_esta_12 ='" + seq_surc_12
                    + "',nro_seq_12 ='" + lote_surc_12
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_13() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_13 = txt_nro_timbra_surc_13.getText();
            String seq_surc_13 = txt_seq_surc_13.getText();
            String lote_surc_13 = txt_lote_surc_13.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_13 = '" + timbra_surc_13
                    + "',nro_esta_13 ='" + seq_surc_13
                    + "',nro_seq_13 ='" + lote_surc_13
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_14() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_14 = txt_nro_timbra_surc_14.getText();
            String seq_surc_14 = txt_seq_surc_14.getText();
            String lote_surc_14 = txt_lote_surc_14.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_14 = '" + timbra_surc_14
                    + "',nro_esta_14 ='" + seq_surc_14
                    + "',nro_seq_14 ='" + lote_surc_14
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_15() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_15 = txt_nro_timbra_surc_15.getText();
            String seq_surc_15 = txt_seq_surc_15.getText();
            String lote_surc_15 = txt_lote_surc_15.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_15 = '" + timbra_surc_15
                    + "',nro_esta_15 ='" + seq_surc_15
                    + "',nro_seq_15 ='" + lote_surc_15
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_16() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_16 = txt_nro_timbra_surc_16.getText();
            String seq_surc_16 = txt_seq_surc_16.getText();
            String lote_surc_16 = txt_lote_surc_16.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_16 = '" + timbra_surc_16
                    + "',nro_esta_16 ='" + seq_surc_16
                    + "',nro_seq_16='" + lote_surc_16
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_17() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_17 = txt_nro_timbra_surc_17.getText();
            String seq_surc_17 = txt_seq_surc_17.getText();
            String lote_surc_17 = txt_lote_surc_17.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_17 = '" + timbra_surc_17
                    + "',nro_esta_17 ='" + seq_surc_17
                    + "',nro_seq_17 ='" + lote_surc_17
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_18() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_18 = txt_nro_timbra_surc_18.getText();
            String seq_surc_18 = txt_seq_surc_18.getText();
            String lote_surc_18 = txt_lote_surc_18.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_18 = '" + timbra_surc_18
                    + "',nro_esta_18 ='" + seq_surc_18
                    + "',nro_seq_18 ='" + lote_surc_18
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_19() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_19 = txt_nro_timbra_surc_19.getText();
            String seq_surc_19 = txt_seq_surc_19.getText();
            String lote_surc_19 = txt_lote_surc_19.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_19 = '" + timbra_surc_19
                    + "',nro_esta_19 ='" + seq_surc_19
                    + "',nro_seq_19 ='" + lote_surc_19
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_20() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_20 = txt_nro_timbra_surc_20.getText();
            String seq_surc_20 = txt_seq_surc_20.getText();
            String lote_surc_20 = txt_lote_surc_20.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_20 = '" + timbra_surc_20
                    + "',nro_esta_20 ='" + seq_surc_20
                    + "',nro_seq_20 ='" + lote_surc_20
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_21() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_21 = txt_nro_timbra_surc_21.getText();
            String seq_surc_21 = txt_seq_surc_21.getText();
            String lote_surc_21 = txt_lote_surc_21.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_21 = '" + timbra_surc_21
                    + "',nro_esta_21 ='" + seq_surc_21
                    + "',nro_seq_21 ='" + lote_surc_21
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_22() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_22 = txt_nro_timbra_surc_22.getText();
            String seq_surc_22 = txt_seq_surc_22.getText();
            String lote_surc_22 = txt_lote_surc_22.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_22 = '" + timbra_surc_22
                    + "',nro_esta_22 ='" + seq_surc_22
                    + "',nro_seq_22 ='" + lote_surc_22
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_23() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_23 = txt_nro_timbra_surc_23.getText();
            String seq_surc_23 = txt_seq_surc_23.getText();
            String lote_surc_23 = txt_lote_surc_23.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_23 = '" + timbra_surc_23
                    + "',nro_esta_23 ='" + seq_surc_23
                    + "',nro_seq_23 ='" + lote_surc_23
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_24() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_24 = txt_nro_timbra_surc_24.getText();
            String seq_surc_24 = txt_seq_surc_24.getText();
            String lote_surc_24 = txt_lote_surc_24.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_24 = '" + timbra_surc_24
                    + "',nro_esta_24 ='" + seq_surc_24
                    + "',nro_seq_24 ='" + lote_surc_24
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_25() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_25 = txt_nro_timbra_surc_25.getText();
            String seq_surc_25 = txt_seq_surc_25.getText();
            String lote_surc_25 = txt_lote_surc_25.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_25 = '" + timbra_surc_25
                    + "',nro_esta_25 ='" + seq_surc_25
                    + "',nro_seq_25 ='" + lote_surc_25
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_26() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_26 = txt_nro_timbra_surc_26.getText();
            String seq_surc_26 = txt_seq_surc_26.getText();
            String lote_surc_26 = txt_lote_surc_26.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_26 = '" + timbra_surc_26
                    + "',nro_esta_26 ='" + seq_surc_26
                    + "',nro_seq_26 ='" + lote_surc_26
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_27() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_27 = txt_nro_timbra_surc_27.getText();
            String seq_surc_27 = txt_seq_surc_27.getText();
            String lote_surc_27 = txt_lote_surc_27.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_27 = '" + timbra_surc_27
                    + "',nro_esta_27 ='" + seq_surc_27
                    + "',nro_seq_27 ='" + lote_surc_27
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_28() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_28 = txt_nro_timbra_surc_28.getText();
            String seq_surc_28 = txt_seq_surc_28.getText();
            String lote_surc_28 = txt_lote_surc_28.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_28 = '" + timbra_surc_28
                    + "',nro_esta_28 ='" + seq_surc_28
                    + "',nro_seq_28 ='" + lote_surc_28
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_29() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_29 = txt_nro_timbra_surc_29.getText();
            String seq_surc_29 = txt_seq_surc_29.getText();
            String lote_surc_29 = txt_lote_surc_29.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_29 = '" + timbra_surc_29
                    + "',nro_esta_29 ='" + seq_surc_29
                    + "',nro_seq_29 ='" + lote_surc_29
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

    void update_empre_30() {

        try {

            String id = lbl_id_config.getText();
            //3//
            String timbra_surc_30 = txt_nro_timbra_surc_30.getText();
            String seq_surc_30 = txt_seq_surc_30.getText();
            String lote_surc_30 = txt_lote_surc_30.getText();

            String sql = "UPDATE almacenes_facturas SET nro_timbra_30 = '" + timbra_surc_30
                    + "',nro_esta_30 ='" + seq_surc_30
                    + "',nro_seq_30 ='" + lote_surc_30
                    + "' WHERE id_def = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }

    }

}
