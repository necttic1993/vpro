/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.Consultas;

import Conexion_DB.conectar;
import static Productos.Consultas.Productos_consulta_stock.cod_pro_con_sucursales;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class Consulta_stock extends javax.swing.JDialog {

    /**
     * Creates new form DetallesProductos
     */
    public Consulta_stock(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BuscarImagen(cod_pro_con_sucursales);
        BuscarProductoDes(cod_pro_con_sucursales);

    }

    void BuscarImagen(String cod) {

    }

    void BuscarProductoDes(String cod) {

        try {

            int minimo = 0;
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                lbl_id_pro.setText(rs.getString(1));
                lbl_des.setText(rs.getString(3));
                ////comparar stock minimo
                int stock_1 = Integer.parseInt(rs.getString(5));
                if (stock_1 > minimo) {
                    lbl_stock_1.setText(rs.getString(5));
                    lbl_stock_1.setForeground(Color.BLUE);
                } else {
                    lbl_stock_1.setText(rs.getString(5));
                }

                int stock_2 = Integer.parseInt(rs.getString(25));
                if (stock_2 > minimo) {
                    lbl_stock_2.setText(rs.getString(25));
                    lbl_stock_2.setForeground(Color.BLUE);
                } else {
                    lbl_stock_2.setText(rs.getString(25));
                }
                
                int stock_3 = Integer.parseInt(rs.getString(26));
                if (stock_3 > minimo) {
                    lbl_stock_3.setText(rs.getString(26));
                    lbl_stock_3.setForeground(Color.BLUE);
                } else {
                    lbl_stock_3.setText(rs.getString(26));
                }
                
                int stock_4 = Integer.parseInt(rs.getString(27));
                if (stock_4 > minimo) {
                    lbl_stock_4.setText(rs.getString(27));
                    lbl_stock_4.setForeground(Color.BLUE);
                } else {
                    lbl_stock_4.setText(rs.getString(27));
                }
                
                int stock_5 = Integer.parseInt(rs.getString(28));
                if (stock_5 > minimo) {
                    lbl_stock_5.setText(rs.getString(28));
                    lbl_stock_5.setForeground(Color.BLUE);
                } else {
                    lbl_stock_5.setText(rs.getString(28));
                }
                
                int stock_6 = Integer.parseInt(rs.getString(29));
                if (stock_6 > minimo) {
                    lbl_stock_6.setText(rs.getString(29));
                    lbl_stock_6.setForeground(Color.BLUE);
                } else {
                    lbl_stock_6.setText(rs.getString(29));
                }
                
                int stock_7 = Integer.parseInt(rs.getString(30));
                if (stock_7 > minimo) {
                    lbl_stock_7.setText(rs.getString(30));
                    lbl_stock_7.setForeground(Color.BLUE);
                } else {
                    lbl_stock_7.setText(rs.getString(30));
                }
                
                int stock_8 = Integer.parseInt(rs.getString(31));
                if (stock_8 > minimo) {
                    lbl_stock_8.setText(rs.getString(31));
                    lbl_stock_8.setForeground(Color.BLUE);
                } else {
                    lbl_stock_8.setText(rs.getString(31));
                }
                
                int stock_9 = Integer.parseInt(rs.getString(32));
                if (stock_9 > minimo) {
                    lbl_stock_9.setText(rs.getString(32));
                    lbl_stock_9.setForeground(Color.BLUE);
                } else {
                    lbl_stock_9.setText(rs.getString(32));
                }
                
                int stock_10 = Integer.parseInt(rs.getString(33));
                if (stock_10 > minimo) {
                    lbl_stock_10.setText(rs.getString(33));
                    lbl_stock_10.setForeground(Color.BLUE);
                } else {
                    lbl_stock_10.setText(rs.getString(33));
                }
                
                int stock_11 = Integer.parseInt(rs.getString(34));
                if (stock_11 > minimo) {
                    lbl_stock_11.setText(rs.getString(34));
                    lbl_stock_11.setForeground(Color.BLUE);
                } else {
                    lbl_stock_11.setText(rs.getString(34));
                }
                
                int stock_12 = Integer.parseInt(rs.getString(35));
                if (stock_12 > minimo) {
                    lbl_stock_12.setText(rs.getString(35));
                    lbl_stock_12.setForeground(Color.BLUE);
                } else {
                    lbl_stock_12.setText(rs.getString(35));
                }
                
                int stock_13 = Integer.parseInt(rs.getString(36));
                if (stock_13 > minimo) {
                    lbl_stock_13.setText(rs.getString(36));
                    lbl_stock_13.setForeground(Color.BLUE);
                } else {
                    lbl_stock_13.setText(rs.getString(36));
                }
                
                int stock_14 = Integer.parseInt(rs.getString(37));
                if (stock_14 > minimo) {
                    lbl_stock_14.setText(rs.getString(37));
                    lbl_stock_14.setForeground(Color.BLUE);
                } else {
                    lbl_stock_14.setText(rs.getString(37));
                }
                
                int stock_15 = Integer.parseInt(rs.getString(38));
                if (stock_15 > minimo) {
                    lbl_stock_15.setText(rs.getString(38));
                    lbl_stock_15.setForeground(Color.BLUE);
                } else {
                    lbl_stock_15.setText(rs.getString(38));
                }
                
                int stock_16 = Integer.parseInt(rs.getString(39));
                if (stock_16 > minimo) {
                    lbl_stock_16.setText(rs.getString(39));
                    lbl_stock_16.setForeground(Color.BLUE);
                } else {
                    lbl_stock_16.setText(rs.getString(39));
                }
                
                int stock_17 = Integer.parseInt(rs.getString(40));
                if (stock_17 > minimo) {
                    lbl_stock_17.setText(rs.getString(40));
                    lbl_stock_17.setForeground(Color.BLUE);
                } else {
                    lbl_stock_17.setText(rs.getString(40));
                }
                
                int stock_18 = Integer.parseInt(rs.getString(41));
                if (stock_18 > minimo) {
                    lbl_stock_18.setText(rs.getString(41));
                    lbl_stock_18.setForeground(Color.BLUE);
                } else {
                    lbl_stock_18.setText(rs.getString(41));
                }
                
                int stock_19 = Integer.parseInt(rs.getString(42));
                if (stock_19 > minimo) {
                    lbl_stock_19.setText(rs.getString(42));
                    lbl_stock_19.setForeground(Color.BLUE);
                } else {
                    lbl_stock_19.setText(rs.getString(42));
                }
                
                int stock_20 = Integer.parseInt(rs.getString(43));
                if (stock_20 > minimo) {
                    lbl_stock_20.setText(rs.getString(43));
                    lbl_stock_20.setForeground(Color.BLUE);
                } else {
                    lbl_stock_20.setText(rs.getString(43));
                }
                
                int stock_21 = Integer.parseInt(rs.getString(44));
                if (stock_21 > minimo) {
                    lbl_stock_21.setText(rs.getString(44));
                    lbl_stock_21.setForeground(Color.BLUE);
                } else {
                    lbl_stock_21.setText(rs.getString(44));
                }
                
                int stock_22 = Integer.parseInt(rs.getString(45));
                if (stock_22 > minimo) {
                    lbl_stock_22.setText(rs.getString(45));
                    lbl_stock_22.setForeground(Color.BLUE);
                } else {
                    lbl_stock_22.setText(rs.getString(45));
                }
                
                int stock_23 = Integer.parseInt(rs.getString(46));
                if (stock_23 > minimo) {
                    lbl_stock_23.setText(rs.getString(46));
                    lbl_stock_23.setForeground(Color.BLUE);
                } else {
                    lbl_stock_23.setText(rs.getString(46));
                }
                
                int stock_24 = Integer.parseInt(rs.getString(47));
                if (stock_24 > minimo) {
                    lbl_stock_24.setText(rs.getString(47));
                    lbl_stock_24.setForeground(Color.BLUE);
                } else {
                    lbl_stock_24.setText(rs.getString(47));
                }
                
                int stock_25 = Integer.parseInt(rs.getString(48));
                if (stock_25 > minimo) {
                    lbl_stock_25.setText(rs.getString(48));
                    lbl_stock_25.setForeground(Color.BLUE);
                } else {
                    lbl_stock_25.setText(rs.getString(48));
                }
                
                int stock_26 = Integer.parseInt(rs.getString(49));
                if (stock_26 > minimo) {
                    lbl_stock_26.setText(rs.getString(49));
                    lbl_stock_26.setForeground(Color.BLUE);
                } else {
                    lbl_stock_26.setText(rs.getString(49));
                }
                int stock_27 = Integer.parseInt(rs.getString(50));
                if (stock_27 > minimo) {
                    lbl_stock_27.setText(rs.getString(50));
                    lbl_stock_27.setForeground(Color.BLUE);
                } else {
                    lbl_stock_27.setText(rs.getString(50));
                }
                int stock_28 = Integer.parseInt(rs.getString(51));
                if (stock_28 > minimo) {
                    lbl_stock_28.setText(rs.getString(51));
                    lbl_stock_28.setForeground(Color.BLUE);
                } else {
                    lbl_stock_28.setText(rs.getString(51));
                }

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void BuscarScursales() {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from almacenes ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {

                lbl_1.setText(rs.getString(2));
                lbl_2.setText(rs.getString(25));
                lbl_3.setText(rs.getString(26));
                lbl_4.setText(rs.getString(27));
                lbl_5.setText(rs.getString(28));
                lbl_6.setText(rs.getString(29));
                lbl_7.setText(rs.getString(30));
                lbl_8.setText(rs.getString(31));
                lbl_9.setText(rs.getString(32));
                lbl_10.setText(rs.getString(33));
                lbl_11.setText(rs.getString(34));
                lbl_12.setText(rs.getString(35));
                lbl_13.setText(rs.getString(36));
                lbl_14.setText(rs.getString(37));
                lbl_15.setText(rs.getString(38));
                lbl_16.setText(rs.getString(39));
                lbl_17.setText(rs.getString(40));
                lbl_18.setText(rs.getString(41));
                lbl_19.setText(rs.getString(42));
                lbl_20.setText(rs.getString(43));
                lbl_21.setText(rs.getString(44));
                lbl_22.setText(rs.getString(45));
                lbl_23.setText(rs.getString(46));
                lbl_24.setText(rs.getString(47));
                lbl_25.setText(rs.getString(48));
                lbl_26.setText(rs.getString(49));
                lbl_27.setText(rs.getString(50));
                lbl_28.setText(rs.getString(51));

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
        lbl_des = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        lbl_9 = new javax.swing.JLabel();
        lbl_1 = new javax.swing.JLabel();
        lbl_10 = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        lbl_11 = new javax.swing.JLabel();
        lbl_4 = new javax.swing.JLabel();
        lbl_12 = new javax.swing.JLabel();
        lbl_5 = new javax.swing.JLabel();
        lbl_13 = new javax.swing.JLabel();
        lbl_17 = new javax.swing.JLabel();
        lbl_18 = new javax.swing.JLabel();
        lbl_19 = new javax.swing.JLabel();
        lbl_20 = new javax.swing.JLabel();
        lbl_21 = new javax.swing.JLabel();
        lbl_6 = new javax.swing.JLabel();
        lbl_14 = new javax.swing.JLabel();
        lbl_22 = new javax.swing.JLabel();
        lbl_7 = new javax.swing.JLabel();
        lbl_15 = new javax.swing.JLabel();
        lbl_23 = new javax.swing.JLabel();
        lbl_8 = new javax.swing.JLabel();
        lbl_16 = new javax.swing.JLabel();
        lbl_24 = new javax.swing.JLabel();
        lbl_25 = new javax.swing.JLabel();
        lbl_26 = new javax.swing.JLabel();
        lbl_27 = new javax.swing.JLabel();
        lbl_28 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lbl_id_pro = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_stock_1 = new javax.swing.JLabel();
        lbl_stock_2 = new javax.swing.JLabel();
        lbl_stock_3 = new javax.swing.JLabel();
        lbl_stock_4 = new javax.swing.JLabel();
        lbl_stock_5 = new javax.swing.JLabel();
        lbl_stock_6 = new javax.swing.JLabel();
        lbl_stock_7 = new javax.swing.JLabel();
        lbl_stock_8 = new javax.swing.JLabel();
        lbl_stock_9 = new javax.swing.JLabel();
        lbl_stock_10 = new javax.swing.JLabel();
        lbl_stock_11 = new javax.swing.JLabel();
        lbl_stock_12 = new javax.swing.JLabel();
        lbl_stock_13 = new javax.swing.JLabel();
        lbl_stock_14 = new javax.swing.JLabel();
        lbl_stock_15 = new javax.swing.JLabel();
        lbl_stock_16 = new javax.swing.JLabel();
        lbl_stock_17 = new javax.swing.JLabel();
        lbl_stock_18 = new javax.swing.JLabel();
        lbl_stock_19 = new javax.swing.JLabel();
        lbl_stock_20 = new javax.swing.JLabel();
        lbl_stock_21 = new javax.swing.JLabel();
        lbl_stock_22 = new javax.swing.JLabel();
        lbl_stock_23 = new javax.swing.JLabel();
        lbl_stock_24 = new javax.swing.JLabel();
        lbl_stock_25 = new javax.swing.JLabel();
        lbl_stock_26 = new javax.swing.JLabel();
        lbl_stock_27 = new javax.swing.JLabel();
        lbl_stock_28 = new javax.swing.JLabel();
        lbl_stock_30 = new javax.swing.JLabel();
        lbl_stock_31 = new javax.swing.JLabel();
        lbl_stock_32 = new javax.swing.JLabel();
        lbl_stock_33 = new javax.swing.JLabel();

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

        lbl_des.setBackground(new java.awt.Color(255, 255, 255));
        lbl_des.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_des.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_des.setToolTipText("");
        lbl_des.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_des.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_des.setOpaque(true);
        jPanel1.add(lbl_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 910, 30));

        lbl_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_2.setText("KYRIOS PTE. FRANCO");
        lbl_2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 60));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1210, 10));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        jLabel14.setText("SUCURSAL PROX");
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 550, 290, 60));

        lbl_9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_9.setText("KYRIOS ENCARNACION");
        lbl_9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 280, 60));

        lbl_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_1.setText("PRINCIPAL");
        lbl_1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 60));

        lbl_10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_10.setText("KYRIOS CAAGUAZU");
        lbl_10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 280, 60));

        lbl_3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_3.setText("KYRIOS PJC");
        lbl_3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 290, 60));

        lbl_11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_11.setText("MARIANO ROQUE ALONSO");
        lbl_11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 280, 60));

        lbl_4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_4.setText("KYRIOS ASUNCION");
        lbl_4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 290, 60));

        lbl_12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_12.setText("KYRIOS HERNANDARIAS");
        lbl_12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 280, 60));

        lbl_5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_5.setText("KYRIOS LAMBARE");
        lbl_5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 290, 60));

        lbl_13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_13.setText("KYRIOS CAACUPE");
        lbl_13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 280, 60));

        lbl_17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_17.setText("KYRIOS SAN LORENZO");
        lbl_17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 290, 60));

        lbl_18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_18.setText("KYRIOS CNEL. OVIEDO");
        lbl_18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 290, 60));

        lbl_19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_19.setText("KYRIOS ITAUGUA");
        lbl_19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 290, 60));

        lbl_20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_20.setText("KYRIOS DON BOSCO CDE");
        lbl_20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 290, 60));

        lbl_21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_21.setText("KYRIOS ÑEMBY");
        lbl_21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 290, 60));

        lbl_6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_6.setText("KYRIOS VILLAMORRA");
        lbl_6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 290, 60));

        lbl_14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_14.setText("KYRIOS SANTA RITA");
        lbl_14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 280, 60));

        lbl_22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_22.setText("KYRIOS SANTANI");
        lbl_22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 290, 60));

        lbl_7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_7.setText("KYRIOS CAPIATA");
        lbl_7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 290, 60));

        lbl_15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_15.setText("KYRIOS SAN JOSE CDE");
        lbl_15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 280, 60));

        lbl_23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_23.setText("KYRIOS MINGA GUAZU");
        lbl_23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 290, 60));

        lbl_8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_8.setText("KYRIOS CONCEPCION");
        lbl_8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 290, 60));

        lbl_16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_16.setText("KYRIOS VILLARRICA");
        lbl_16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 280, 60));

        lbl_24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_24.setText("ECOMMERCE");
        lbl_24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 290, 60));

        lbl_25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_25.setText("KYRIOS GYM LUQUE");
        lbl_25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 290, 60));

        lbl_26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_26.setText("KYRIOS LUQUE");
        lbl_26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, 290, 60));

        lbl_27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_27.setText("KYRIOS SAN BERNARDINO");
        lbl_27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 200, 290, 60));

        lbl_28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        lbl_28.setText("KYRIOS HORQUETA");
        lbl_28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(lbl_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, 290, 60));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        jLabel42.setText("SUCURSAL PROX");
        jLabel42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, 290, 60));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        jLabel43.setText("SUCURSAL PROX");
        jLabel43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 410, 290, 60));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/localizar.png"))); // NOI18N
        jLabel44.setText("SUCURSAL PROX");
        jLabel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 480, 290, 60));

        lbl_id_pro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_id_pro.setForeground(new java.awt.Color(153, 0, 0));
        lbl_id_pro.setText("0");
        jPanel1.add(lbl_id_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 70, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel15.setText("Nombre:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 70, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel16.setText("Código:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        lbl_stock_1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_1.setForeground(new java.awt.Color(153, 0, 51));
        lbl_stock_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_1.setText("0");
        jPanel1.add(lbl_stock_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 50, 40));

        lbl_stock_2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_2.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_2.setText("0");
        jPanel1.add(lbl_stock_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 50, 40));

        lbl_stock_3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_3.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_3.setText("0");
        jPanel1.add(lbl_stock_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 50, 40));

        lbl_stock_4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_4.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_4.setText("0");
        jPanel1.add(lbl_stock_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 50, 40));

        lbl_stock_5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_5.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_5.setText("0");
        jPanel1.add(lbl_stock_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 50, 40));

        lbl_stock_6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_6.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_6.setText("0");
        jPanel1.add(lbl_stock_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 50, 40));

        lbl_stock_7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_7.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_7.setText("0");
        jPanel1.add(lbl_stock_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 50, 40));

        lbl_stock_8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_8.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_8.setText("0");
        jPanel1.add(lbl_stock_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, 50, 40));

        lbl_stock_9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_9.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_9.setText("0");
        jPanel1.add(lbl_stock_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 50, 40));

        lbl_stock_10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_10.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_10.setText("0");
        jPanel1.add(lbl_stock_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 50, 40));

        lbl_stock_11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_11.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_11.setText("0");
        jPanel1.add(lbl_stock_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 50, 40));

        lbl_stock_12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_12.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_12.setText("0");
        jPanel1.add(lbl_stock_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 50, 40));

        lbl_stock_13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_13.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_13.setText("0");
        jPanel1.add(lbl_stock_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 50, 40));

        lbl_stock_14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_14.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_14.setText("0");
        jPanel1.add(lbl_stock_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 50, 40));

        lbl_stock_15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_15.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_15.setText("0");
        jPanel1.add(lbl_stock_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 50, 40));

        lbl_stock_16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_16.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_16.setText("0");
        jPanel1.add(lbl_stock_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 50, 40));

        lbl_stock_17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_17.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_17.setText("0");
        jPanel1.add(lbl_stock_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 50, 40));

        lbl_stock_18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_18.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_18.setText("0");
        jPanel1.add(lbl_stock_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 50, 40));

        lbl_stock_19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_19.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_19.setText("0");
        jPanel1.add(lbl_stock_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 50, 40));

        lbl_stock_20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_20.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_20.setText("0");
        jPanel1.add(lbl_stock_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, 50, 40));

        lbl_stock_21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_21.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_21.setText("0");
        jPanel1.add(lbl_stock_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, 50, 40));

        lbl_stock_22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_22.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_22.setText("0");
        jPanel1.add(lbl_stock_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 420, 50, 40));

        lbl_stock_23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_23.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_23.setText("0");
        jPanel1.add(lbl_stock_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 490, 50, 40));

        lbl_stock_24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_24.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_24.setText("0");
        jPanel1.add(lbl_stock_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 560, 50, 40));

        lbl_stock_25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_25.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_25.setText("0");
        jPanel1.add(lbl_stock_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 70, 50, 40));

        lbl_stock_26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_26.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_26.setText("0");
        jPanel1.add(lbl_stock_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 140, 50, 40));

        lbl_stock_27.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_27.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_27.setText("0");
        jPanel1.add(lbl_stock_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 210, 50, 40));

        lbl_stock_28.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_28.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_28.setText("0");
        jPanel1.add(lbl_stock_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 280, 50, 40));

        lbl_stock_30.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_30.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_30.setText("0");
        jPanel1.add(lbl_stock_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 350, 50, 40));

        lbl_stock_31.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_31.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_31.setText("0");
        jPanel1.add(lbl_stock_31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 420, 50, 40));

        lbl_stock_32.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_32.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_32.setText("0");
        jPanel1.add(lbl_stock_32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 560, 50, 40));

        lbl_stock_33.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_stock_33.setForeground(new java.awt.Color(204, 0, 51));
        lbl_stock_33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stock_33.setText("0");
        jPanel1.add(lbl_stock_33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 490, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 630));

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
            java.util.logging.Logger.getLogger(Consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Consulta_stock dialog = new Consulta_stock(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_10;
    private javax.swing.JLabel lbl_11;
    private javax.swing.JLabel lbl_12;
    private javax.swing.JLabel lbl_13;
    private javax.swing.JLabel lbl_14;
    private javax.swing.JLabel lbl_15;
    private javax.swing.JLabel lbl_16;
    private javax.swing.JLabel lbl_17;
    private javax.swing.JLabel lbl_18;
    private javax.swing.JLabel lbl_19;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_20;
    private javax.swing.JLabel lbl_21;
    private javax.swing.JLabel lbl_22;
    private javax.swing.JLabel lbl_23;
    private javax.swing.JLabel lbl_24;
    private javax.swing.JLabel lbl_25;
    private javax.swing.JLabel lbl_26;
    private javax.swing.JLabel lbl_27;
    private javax.swing.JLabel lbl_28;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JLabel lbl_9;
    private javax.swing.JLabel lbl_des;
    private javax.swing.JLabel lbl_id_pro;
    private javax.swing.JLabel lbl_stock_1;
    private javax.swing.JLabel lbl_stock_10;
    private javax.swing.JLabel lbl_stock_11;
    private javax.swing.JLabel lbl_stock_12;
    private javax.swing.JLabel lbl_stock_13;
    private javax.swing.JLabel lbl_stock_14;
    private javax.swing.JLabel lbl_stock_15;
    private javax.swing.JLabel lbl_stock_16;
    private javax.swing.JLabel lbl_stock_17;
    private javax.swing.JLabel lbl_stock_18;
    private javax.swing.JLabel lbl_stock_19;
    private javax.swing.JLabel lbl_stock_2;
    private javax.swing.JLabel lbl_stock_20;
    private javax.swing.JLabel lbl_stock_21;
    private javax.swing.JLabel lbl_stock_22;
    private javax.swing.JLabel lbl_stock_23;
    private javax.swing.JLabel lbl_stock_24;
    private javax.swing.JLabel lbl_stock_25;
    private javax.swing.JLabel lbl_stock_26;
    private javax.swing.JLabel lbl_stock_27;
    private javax.swing.JLabel lbl_stock_28;
    private javax.swing.JLabel lbl_stock_3;
    private javax.swing.JLabel lbl_stock_30;
    private javax.swing.JLabel lbl_stock_31;
    private javax.swing.JLabel lbl_stock_32;
    private javax.swing.JLabel lbl_stock_33;
    private javax.swing.JLabel lbl_stock_4;
    private javax.swing.JLabel lbl_stock_5;
    private javax.swing.JLabel lbl_stock_6;
    private javax.swing.JLabel lbl_stock_7;
    private javax.swing.JLabel lbl_stock_8;
    private javax.swing.JLabel lbl_stock_9;
    private javax.swing.JTextField txt_focus;
    // End of variables declaration//GEN-END:variables

}
