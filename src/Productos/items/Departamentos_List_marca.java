/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.items;

import Clases.machusculas;
import Conexion_DB.conectar;
import Estadisticas_productos.Listado_marcas_pro;
import Productos.Departamentos;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Departamentos_List_marca extends javax.swing.JDialog {

    DefaultTableModel model;

    public Departamentos_List_marca(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        txt_bus.setDocument(new machusculas());
        txt_bus.requestFocus();
        cargar("");

    }

    public static String cod_act_departamento = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_departamento = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Departamentos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_4/anadir-nuevo-documento.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 60, 40));

        tb_departamento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_departamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_departamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_departamento.setRequestFocusEnabled(false);
        tb_departamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_departamentoMouseClicked(evt);
            }
        });
        tb_departamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_departamentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_departamentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_departamentoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_departamento);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 640, 390));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 370, 30));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 50, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Departamentos dep;
        dep = new Departamentos(new javax.swing.JDialog(), true);
        dep.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_departamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_departamentoMouseClicked
        String nom = "", cod = "";
        int fila = tb_departamento.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            } else {
                cod = (String) tb_departamento.getValueAt(fila, 0);
                nom = (String) tb_departamento.getValueAt(fila, 1);

                Listado_marcas_pro.txt_id_dep_salidas.setText(cod);
                Listado_marcas_pro.txt_nom_dep_salidas.setText(nom);
                // Ventas_venta.txt_dias_plazo.setText(dp);

                this.dispose();
                // Pedidos_pedidos.btn_buscaar_items.doClick();

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tb_departamentoMouseClicked

    private void tb_departamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_departamentoKeyPressed


    }//GEN-LAST:event_tb_departamentoKeyPressed

    private void tb_departamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_departamentoKeyReleased

    }//GEN-LAST:event_tb_departamentoKeyReleased

    private void tb_departamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_departamentoKeyTyped

    }//GEN-LAST:event_tb_departamentoKeyTyped

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

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
            java.util.logging.Logger.getLogger(Departamentos_List_marca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departamentos_List_marca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departamentos_List_marca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departamentos_List_marca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
      
       

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Departamentos_List_marca dialog = new Departamentos_List_marca(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tb_departamento;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Código", "Descripción"};
            String[] registros = new String[5];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from depar_productos WHERE CONCAT (des_dep) LIKE '%" + valor + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);

                model.addRow(registros);
            }
            tb_departamento.setModel(model);
            tb_departamento.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_departamento.getColumnModel().getColumn(1).setPreferredWidth(400);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
