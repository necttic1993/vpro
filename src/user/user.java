/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Conexion_DB.conectar;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
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
        
        cargar("");
        OpcionMenu();
        txtcod.setVisible(false);
        
    }
    
    public static String id_user = "";
    
    void cargar(String valor) {
        String[] titulos = {"Id", "Usuario", "Grupo", "Classif.", "Almacén/Surc.", "Cuenta N°", "%", "Precio Bloqueado", "Precio B", "Mínimo", "SS", "CR"};
        String[] registros = new String[12];
        
        String sql = "SELECT * FROM usuarios where usu LIKE '%" + valor + "%'  ";
        
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
    
    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();
        
        JMenuItem menu_eliminar_Pro = new JMenuItem("Modificar Usuario", new ImageIcon(getClass().getResource("/icon_4/modificar.png")));
        
        menu_eliminar_Pro.addActionListener((ActionEvent e) -> {
            
            int filaMod = t_datos.getSelectedRow();
            if (filaMod == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                
                id_user = (String) t_datos.getValueAt(filaMod, 0);
                Update_user update;
                update = new Update_user(new javax.swing.JDialog(), true);
                update.setVisible(true);
                
            }
            
        });
        
        menu_opcion.add(menu_eliminar_Pro);
        
        t_datos.setComponentPopupMenu(menu_opcion);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btn_permisos = new javax.swing.JButton();
        btn_grupos = new javax.swing.JButton();
        lbl_pass_word = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Usuarios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 130, 40));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 980, 430));

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
        jPanel1.add(btn_permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 130, 40));

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
        jPanel1.add(btn_grupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 130, 40));

        lbl_pass_word.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_pass_word.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(lbl_pass_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 210, 20));

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, 370, 24));

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 32));
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 60, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        Add_user add;
        add = new Add_user(new javax.swing.JDialog(), true);
        add.setVisible(true);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
            int filamodificar = t_datos.getSelectedRow();
         if (filamodificar >= 0) {
         txtcod.setText(t_datos.getValueAt(filamodificar, 0).toString());
       
         } else {
         JOptionPane.showMessageDialog(this, "No ha seleccionado ");
         }
 
    }//GEN-LAST:event_t_datosMouseClicked

    private void btn_permisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_permisosActionPerformed
        permisos_user per;
        per = new permisos_user(new javax.swing.JDialog(), true);
        per.setVisible(true);
    }//GEN-LAST:event_btn_permisosActionPerformed

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
    private javax.swing.JButton btn_grupos;
    private javax.swing.JButton btn_permisos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_pass_word;
    private javax.swing.JTable t_datos;
    public static javax.swing.JTextField txt_bus;
    private javax.swing.JTextField txtcod;
    // End of variables declaration//GEN-END:variables

}
