/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.egresos;

import Caja_2.Caja_caja;
import Clases.ColorearGastos;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class caja_gastos_cancela extends javax.swing.JDialog {

    DefaultTableModel model;
    long OL;
    FileInputStream fis;

    public caja_gastos_cancela(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");

    }
    public static String codPro = "";
    public static String cod_egre_actu = "";
    public static String cod_gastos_caja = "";

    void cargar(String valor
    ) {
        try {

            String[] titulos = {"Egreso N°", "N° Factura", "N° Timbrado", "Concepto", "Proveedor", "Fecha Entrada", "Histórico", "Monto", "Situación"};
            String[] registros = new String[10];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from gastos WHERE CONCAT (gas_num,gas_provee,gas_histo) LIKE '%" + valor + "%' AND gas_situ= 'CONFIRMADA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(8);
                registros[7] = rs.getString(9);
                registros[8] = rs.getString(10);

                model.addRow(registros);
            }
            tb_gastos.setModel(model);

            ColorearGastos color = new ColorearGastos(8);
            tb_gastos.getColumnModel().getColumn(0).setCellRenderer(color);

            tb_gastos.getColumnModel().getColumn(0).setPreferredWidth(110);
            tb_gastos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tb_gastos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_gastos.getColumnModel().getColumn(3).setPreferredWidth(450);
            tb_gastos.getColumnModel().getColumn(4).setPreferredWidth(300);
            tb_gastos.getColumnModel().getColumn(5).setPreferredWidth(130);
            tb_gastos.getColumnModel().getColumn(6).setPreferredWidth(300);
            tb_gastos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tb_gastos.getColumnModel().getColumn(8).setPreferredWidth(150);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_gastos = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Egresos");
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_gastos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_gastos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_gastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_gastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_gastosMouseClicked(evt);
            }
        });
        tb_gastos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_gastosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_gastosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_gastos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1210, 540));

        txtbuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(0, 51, 102));
        txtbuscar.setToolTipText("Buscar Registros");
        txtbuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 380, 32));

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 35));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_gastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_gastosMouseClicked
        try {

            int fila = tb_gastos.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tb_gastos.getValueAt(fila, 0).toString();
                String desins = ("CANC. PAGO A PROVEEDOR POR EGRESO N°" + tb_gastos.getValueAt(fila, 0).toString());
                String preins = tb_gastos.getValueAt(fila, 7).toString();

                Caja_caja.txt_nro_docu.setText(codins);
                Caja_caja.txt_des_caja.setText(desins);
                Caja_caja.lbl_total_gs.setText(preins);
                Caja_caja.btn_calcular.doClick();
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_gastosMouseClicked

    private void tb_gastosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_gastosKeyReleased

    }//GEN-LAST:event_tb_gastosKeyReleased

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

    }//GEN-LAST:event_txtbuscarKeyReleased

    private void tb_gastosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_gastosKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txtbuscar.requestFocus();
        }

        if (Tecla == KeyEvent.VK_ENTER) {

            try {

                int fila = tb_gastos.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_gastos.getValueAt(fila, 0).toString();
                    String desins = ("CANC. PAGO A PROVEEDOR POR EGRESO N°" + tb_gastos.getValueAt(fila, 0).toString());
                    String preins = tb_gastos.getValueAt(fila, 7).toString();

                    Caja_caja.txt_nro_docu.setText(codins);
                    Caja_caja.txt_des_caja.setText(desins);
                    Caja_caja.lbl_total_gs.setText(preins);
                    Caja_caja.btn_calcular.doClick();
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
    }//GEN-LAST:event_tb_gastosKeyPressed

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
            java.util.logging.Logger.getLogger(caja_gastos_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(caja_gastos_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(caja_gastos_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(caja_gastos_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                caja_gastos_cancela dialog = new caja_gastos_cancela(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tb_gastos;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    void actCompras() {
        int filaselect = tb_gastos.getSelectedRow();
        String codigo = (String) tb_gastos.getValueAt(filaselect, 0);
        String est = "CONFIRMADA";
        String sql = "UPDATE gastos SET gas_situ ='" + est + "' WHERE gas_id = '" + codigo + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            // JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void actComprasC() {
        int filaselect = tb_gastos.getSelectedRow();
        String codigo = (String) tb_gastos.getValueAt(filaselect, 0);
        String est = "FINALIZADA";
        String sql = "UPDATE gastos SET gas_situ ='" + est + "' WHERE gas_id = '" + codigo + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            // JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }
}
