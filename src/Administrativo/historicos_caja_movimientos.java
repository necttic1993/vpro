//<editor-fold defaultstate="collapsed" desc="ZONA DE PAQUETES">
package Administrativo;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ZONA DE IMPORTACIONES">

import Caja_2.*;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//</editor-fold>

public class historicos_caja_movimientos extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="ZONA DE VAR GLOBALES">
    DefaultTableModel model;
    long OL;
    FileInputStream fis;
    int Consumio = 0, longitudBytes;
    String BienFormatado2, Preview2 = "", ruta = null;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ZONA DE CONSTRUCTOR">    
    public historicos_caja_movimientos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
          if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargar("");
        } else {
            cargar_espec("");
        }
        txtbus.requestFocus();

    }// FIN CONSTRUCTOR
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbhis = new javax.swing.JTable();
        txtbus = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Históricos");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbhis = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbhis.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbhis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbhis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhisMouseClicked(evt);
            }
        });
        tbhis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbhisKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbhisKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbhis);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 710, 420));

        txtbus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtbus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusActionPerformed(evt);
            }
        });
        txtbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbusKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusKeyReleased(evt);
            }
        });
        jPanel3.add(txtbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 370, 30));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setFocusable(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel2.setFocusable(false);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbhisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhisMouseClicked
        String tipo = "", des = "", id = "", ruc = "", nac = "";
        int fila = tbhis.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            } else {
                id = (String) tbhis.getValueAt(fila, 0);
                des = (String) tbhis.getValueAt(fila, 1);
                tipo = (String) tbhis.getValueAt(fila, 2);

                mov_geral_espe.txt_id_his_mov.setText(id);
                mov_geral_espe.txt_his_caja_mov.setText(des);

                this.dispose();
                //  Caja_caja.txt_des.requestFocus();

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbhisMouseClicked

    private void tbhisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbhisKeyReleased

    }//GEN-LAST:event_tbhisKeyReleased

    private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusActionPerformed

    private void txtbusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txtbusKeyPressed

    private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
        // TODO add your handling code here:
        cargar(txtbus.getText());
    }//GEN-LAST:event_txtbusKeyReleased

    private void tbhisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbhisKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            String tipo = "", des = "", id = "", ruc = "", nac = "";
            int fila = tbhis.getSelectedRow();
            try {
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

                } else {
                    id = (String) tbhis.getValueAt(fila, 0);
                    des = (String) tbhis.getValueAt(fila, 1);
                    tipo = (String) tbhis.getValueAt(fila, 2);

                    mov_geral_espe.txt_id_his_mov.setText(id);
                    mov_geral_espe.txt_his_caja_mov.setText(des);

                    this.dispose();
                    // Caja_caja.txt_des.requestFocus();

                }
            } catch (Exception e) {
            }
        }
        if (Tecla == KeyEvent.VK_ESCAPE) {
            txtbus.requestFocus();
        }

    }//GEN-LAST:event_tbhisKeyPressed
    //<editor-fold defaultstate="collapsed" desc="METODOS PRINCIPAL">

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
            java.util.logging.Logger.getLogger(historicos_caja_movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(historicos_caja_movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(historicos_caja_movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historicos_caja_movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                historicos_caja_movimientos dialog = new historicos_caja_movimientos(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }// FIN METODO PRINCIPAL
    //</editor-fold>   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbhis;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">

   void cargar_espec(String valor) {
        try {
            String almacen = Principal.lbl_usu_almacen.getText();
            String[] titulos = {"Código", "Descripción", "Tipo", "Almacén"};
            String[] registros = new String[5];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from historicos_surc WHERE CONCAT (des_his) LIKE '%" + valor + "%' and surc_his='" + almacen + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);

                model.addRow(registros);
            }
            tbhis.setModel(model);
            tbhis.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbhis.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbhis.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbhis.getColumnModel().getColumn(3).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar(String valor) {
        try {

            String[] titulos = {"Código", "Descripción", "Tipo", "Almacén"};
            String[] registros = new String[5];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from historicos_surc WHERE CONCAT (des_his) LIKE '%" + valor + "%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);

                model.addRow(registros);
            }
            tbhis.setModel(model);
            tbhis.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbhis.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbhis.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbhis.getColumnModel().getColumn(3).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //</editor-fold>
}//FIN CLASE
