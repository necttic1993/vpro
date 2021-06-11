/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Clases.machusculas;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
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
 * @author Roberto
 */
public class user extends javax.swing.JDialog {

    DefaultTableModel model;

    Statement sent;

    public user(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtcod.setVisible(false);
        cargar("");
        cargargrupo();
        //  Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        // AWTUtilities.setWindowShape(this, forma);
        txt_usu.setDocument(new machusculas());
        txt_pass.setDocument(new machusculas());
        txt_pre_a.setDocument(new machusculas());
        txt_pre_b.setDocument(new machusculas());
        txt_pre_c.setDocument(new machusculas());
        txt_vende_sin.setDocument(new machusculas());
        btn_borrar.setEnabled(false);
        btnactualizar.setEnabled(false);
    }

    void cargar(String valor) {
        String[] titulos = {"Id", "Usuario", "Grupo", "Classificación", "Almacén/Surc.", "Cuenta N°", "%", "Precio Bloqueado", "Precio B", "Mínimo", "SS", "CR"};
        String[] registros = new String[12];

        String sql = "SELECT * FROM usuarios where usu LIKE '%" + valor + "%' AND usu_cod >1 ";

        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("usu_cod");
                registros[1] = rs.getString("usu");
                registros[2] = rs.getString("tipo_usu");
                registros[3] = rs.getString("class");
                registros[4] = rs.getString("alma_surc");
                registros[5] = rs.getString("usu_cuenta");
                registros[6] = rs.getString("por_ventas");
                registros[7] = rs.getString("pre_a");
                registros[8] = rs.getString("pre_b");
                registros[9] = rs.getString("pre_c");
                registros[10] = rs.getString("pre_post");
                registros[11] = rs.getString("caja_rap");

                model.addRow(registros);

            }
            t_datos.setModel(model);
            t_datos.getColumnModel().getColumn(0).setPreferredWidth(73);
            t_datos.getColumnModel().getColumn(1).setPreferredWidth(180);
            t_datos.getColumnModel().getColumn(2).setPreferredWidth(150);
            t_datos.getColumnModel().getColumn(3).setPreferredWidth(90);
            t_datos.getColumnModel().getColumn(4).setPreferredWidth(120);
            t_datos.getColumnModel().getColumn(5).setPreferredWidth(100);
            t_datos.getColumnModel().getColumn(6).setPreferredWidth(50);
            t_datos.getColumnModel().getColumn(7).setPreferredWidth(100);
            t_datos.getColumnModel().getColumn(8).setPreferredWidth(80);
            t_datos.getColumnModel().getColumn(9).setPreferredWidth(80);
            t_datos.getColumnModel().getColumn(10).setPreferredWidth(80);
            t_datos.getColumnModel().getColumn(10).setPreferredWidth(50);
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void limpiar() {
        txt_por_venta.setText("");
        txt_usu.setText("");
        txt_pass.setText("");
        txt_pre_a.setText("");
        txt_pre_b.setText("");
        txt_pre_c.setText("");
        txt_vende_sin.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_usu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        txtcod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_permisos = new javax.swing.JButton();
        cb_tipo = new org.jdesktop.swingx.JXComboBox();
        cb_cat = new org.jdesktop.swingx.JXComboBox();
        cb_almacen = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cb_caja_usu = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txt_por_venta = new javax.swing.JTextField();
        btn_grupos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_pre_c = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_pre_a = new javax.swing.JTextField();
        txt_pre_b = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_vende_sin = new javax.swing.JTextField();
        cb_caja = new jcomboper.SComboBox();
        lbl_pass_word = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Usuarios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_usu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuActionPerformed(evt);
            }
        });
        jPanel1.add(txt_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 420, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Grupo :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 30));

        btn_agregar.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_agregar.setMnemonic('a');
        btn_agregar.setText("Agregar");
        btn_agregar.setToolTipText("Agregar");
        btn_agregar.setBorderPainted(false);
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 130, 40));

        btn_borrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_borrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/eliminar.png"))); // NOI18N
        btn_borrar.setMnemonic('a');
        btn_borrar.setText("Eliminar");
        btn_borrar.setToolTipText("Eliminar");
        btn_borrar.setBorderPainted(false);
        btn_borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 130, 40));

        t_datos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        t_datos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        t_datos.setGridColor(new java.awt.Color(255, 255, 255));
        t_datos.setRowHeight(19);
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        t_datos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_datosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 980, 290));

        btnactualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnactualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/modificar.png"))); // NOI18N
        btnactualizar.setMnemonic('a');
        btnactualizar.setText("Actualizar");
        btnactualizar.setBorderPainted(false);
        btnactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 130, 40));
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 60, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("(%):");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, 30));

        txt_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 220, 30));

        btn_permisos.setBackground(new java.awt.Color(255, 255, 255));
        btn_permisos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_permisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/shield.png"))); // NOI18N
        btn_permisos.setText("Permisos");
        btn_permisos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_permisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_permisosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 130, 40));

        cb_tipo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 220, 30));

        cb_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cb_cat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(cb_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 100, 30));

        cb_almacen.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cb_almacen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "0000001", "0000002", "0000003", "0000004", "0000005", "0000006", "0000007", "0000008", "0000009", "0000010", "0000011", "0000012", "0000013", "0000014", "0000015", "0000016", "0000017", "0000018", "0000019", "0000020", "0000021", "0000022", "0000023", "0000024", "0000025", "0000026", "0000027", "0000028", "0000029", "0000030" }));
        jPanel1.add(cb_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 100, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Almacén/Surc:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, 30));

        cb_caja_usu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cb_caja_usu.setMaximumRowCount(10);
        cb_caja_usu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        jPanel1.add(cb_caja_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 140, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Sin Stock:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, -1, 30));

        txt_por_venta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_por_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_por_ventaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_por_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 50, 30));

        btn_grupos.setBackground(new java.awt.Color(255, 255, 255));
        btn_grupos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_grupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/gear.png"))); // NOI18N
        btn_grupos.setText("Grupos");
        btn_grupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_grupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gruposActionPerformed(evt);
            }
        });
        jPanel1.add(btn_grupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Clasificación:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, 30));

        txt_pre_c.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 40, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Caja:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Panel de precio bloq:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Precio B:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, -1, 30));

        txt_pre_a.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 40, 30));

        txt_pre_b.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_pre_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 40, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Minimo:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, -1, 30));

        txt_vende_sin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txt_vende_sin, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 40, 30));

        cb_caja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "SI" }));
        cb_caja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(cb_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 80, -1));

        lbl_pass_word.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_pass_word.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(lbl_pass_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 140, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Caja Rápida:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 90, 30));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(null);
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 115, 370, 24));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 430, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuActionPerformed
        // TODO add your handling code here:
        txt_usu.transferFocus();
    }//GEN-LAST:event_txt_usuActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        if (txt_pass.getText().length() != 0) {
            String usu, pass, tipo, clas, alma, caja, por, a, b, c, ss, venta_rap;
            String sql = "";

            usu = txt_usu.getText();
            pass = txt_pass.getText();
            tipo = cb_tipo.getSelectedItem().toString();
            clas = cb_cat.getSelectedItem().toString();
            alma = cb_almacen.getSelectedItem().toString();
            caja = cb_caja_usu.getSelectedItem().toString();
            por = txt_por_venta.getText();
            a = txt_pre_a.getText();
            b = txt_pre_b.getText();
            c = txt_pre_c.getText();
            ss = txt_vende_sin.getText();
            venta_rap = cb_caja.getSelectedItem().toString();

            sql = "INSERT INTO usuarios (usu,password,tipo_usu,class,alma_surc,usu_cuenta,por_ventas,pre_a,pre_b,pre_c,pre_post,caja_rap) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1, usu);
                pst.setString(2, pass);
                pst.setString(3, tipo);
                pst.setString(4, clas);
                pst.setString(5, alma);
                pst.setString(6, caja);
                pst.setString(7, por);
                pst.setString(8, a);
                pst.setString(9, b);
                pst.setString(10, c);
                pst.setString(11, ss);
                pst.setString(12, venta_rap);

                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario Guardado con Exito ");
                    limpiar();
                    cargar("");
                }

            } catch (SQLException ex) {

                if (ex.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "¡El usuario ya existe!", "Verificar Codigo",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos ");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        try {
            // TODO add your handling code here:
            
            int fila = t_datos.getSelectedRow();
            String sql = "delete from usuarios where usu_cod=" + t_datos.getValueAt(fila, 0);
            
            Connection cn = conectar.getInstance().getConnection();
            
            sent = cn.createStatement();
            
            int n = 0;
            
            n = sent.executeUpdate(sql);
            conectar.getInstance().closeConnection(cn);
            
            if (n > 0) {
                
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                cargar("");
                limpiar();
                btn_borrar.setEnabled(false);
                btnactualizar.setEnabled(false);
                btn_agregar.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        if (txt_pass.getText().length() != 0) {
            String sql = "UPDATE usuarios SET usu ='" + txt_usu.getText()
                    + "',password ='" + txt_pass.getText()
                    + "',tipo_usu ='" + cb_tipo.getSelectedItem()
                    + "',class ='" + cb_cat.getSelectedItem()
                    + "',alma_surc ='" + cb_almacen.getSelectedItem()
                    + "',usu_cuenta ='" + cb_caja_usu.getSelectedItem()
                    + "',por_ventas ='" + txt_por_venta.getText()
                    + "',pre_a ='" + txt_pre_a.getText()
                    + "',pre_b ='" + txt_pre_b.getText()
                    + "',pre_c ='" + txt_pre_c.getText()
                    + "',pre_post ='" + txt_vende_sin.getText()
                    + "',caja_rap ='" + cb_caja.getSelectedItem()
                    + "' WHERE usu_cod = '" + txtcod.getText() + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Actualizado");
                cargar("");
                limpiar();
                btn_borrar.setEnabled(false);
                btnactualizar.setEnabled(false);
                btn_agregar.setEnabled(true);
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Confirme Contraseña ");
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        int filamodificar = t_datos.getSelectedRow();
        if (filamodificar >= 0) {
            txtcod.setText(t_datos.getValueAt(filamodificar, 0).toString());
            txt_usu.setText(t_datos.getValueAt(filamodificar, 1).toString());
            cb_tipo.setSelectedItem(t_datos.getValueAt(filamodificar, 2).toString());
            cb_cat.setSelectedItem(t_datos.getValueAt(filamodificar, 3).toString());
            cb_almacen.setSelectedItem(t_datos.getValueAt(filamodificar, 4).toString());
            cb_caja_usu.setSelectedItem(t_datos.getValueAt(filamodificar, 5).toString());
            txt_por_venta.setText(t_datos.getValueAt(filamodificar, 6).toString());
            txt_pre_a.setText(t_datos.getValueAt(filamodificar, 7).toString());
            txt_pre_b.setText(t_datos.getValueAt(filamodificar, 8).toString());
            txt_pre_c.setText(t_datos.getValueAt(filamodificar, 9).toString());
            txt_vende_sin.setText(t_datos.getValueAt(filamodificar, 10).toString());

            btn_borrar.setEnabled(true);
            btnactualizar.setEnabled(true);
            btn_agregar.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ");
        }
    }//GEN-LAST:event_t_datosMouseClicked

    private void btn_permisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_permisosActionPerformed
        permisos_user per;
        per = new permisos_user(new javax.swing.JDialog(), true);
        per.setVisible(true);
    }//GEN-LAST:event_btn_permisosActionPerformed

    private void txt_por_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_por_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_por_ventaActionPerformed

    private void btn_gruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gruposActionPerformed
        grupos_Principal pg;
        pg = new grupos_Principal(new javax.swing.JDialog(), true);
        pg.setVisible(true);
    }//GEN-LAST:event_btn_gruposActionPerformed

    private void t_datosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_datosKeyPressed

        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_SPACE) {

            String verificar = txtcod.getText();
            String mostrar = "SELECT * FROM usuarios WHERE  usu_cod='" + verificar + "'";

            try {
                Connection cn = conectar.getInstance().getConnection();

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(mostrar);
                while (rs.next()) {
                    lbl_pass_word.setText(rs.getString(3));

                }
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (Tecla == KeyEvent.VK_ESCAPE) {
            lbl_pass_word.setText("");
        }
    }//GEN-LAST:event_t_datosKeyPressed

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1KeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }


    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyReleased

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                user dialog = new user(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_grupos;
    private javax.swing.JButton btn_permisos;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JComboBox cb_almacen;
    private jcomboper.SComboBox cb_caja;
    private javax.swing.JComboBox cb_caja_usu;
    private org.jdesktop.swingx.JXComboBox cb_cat;
    private org.jdesktop.swingx.JXComboBox cb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_pass_word;
    private javax.swing.JTable t_datos;
    public static javax.swing.JTextField txt_bus;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_por_venta;
    private javax.swing.JTextField txt_pre_a;
    private javax.swing.JTextField txt_pre_b;
    private javax.swing.JTextField txt_pre_c;
    private javax.swing.JTextField txt_usu;
    private javax.swing.JTextField txt_vende_sin;
    private javax.swing.JTextField txtcod;
    // End of variables declaration//GEN-END:variables

    void cargargrupo() {
        String mostrar = "SELECT * FROM user_permisos where id_perm >1 ";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                cb_tipo.addItem(rs.getString(2));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
