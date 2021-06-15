/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loggin_Principal;

import Caja_2.Pago_Plazos.Principal_recibo_fisc;
import static Caja_2.Pago_Plazos.Principal_recibo_fisc.btn_actua_recibo;
import Clases.machusculas;
import Conexion_DB.conectar;
import Ventas.Fact_surc_11.Principal_ventas_surc_11;
import Ventas.Fact_surc_2.Principal_ventas_surc_2;
import Ventas.Fact_surc_22.Principal_ventas_surc_22;
import Ventas.Fact_surc_23.Principal_ventas_facturas_23;
import Ventas.Fact_surc_26.Principal_ventas_facturas_26;
import Ventas.Facturas.Principal_ventas_facturas;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Seleccion_fiscal_recibos extends javax.swing.JDialog {

    DefaultTableModel model;

    public Seleccion_fiscal_recibos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_bus.setDocument(new machusculas());
        txt_bus.requestFocus();
        cargar("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_bus = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_almacen_origen = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Almacenes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 340, 32));

        tb_almacen_origen = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_almacen_origen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_almacen_origen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_almacen_origen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb_almacen_origen.setGridColor(new java.awt.Color(255, 255, 255));
        tb_almacen_origen.setRequestFocusEnabled(false);
        tb_almacen_origen.setRowHeight(22);
        tb_almacen_origen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_almacen_origenMouseClicked(evt);
            }
        });
        tb_almacen_origen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_almacen_origenKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_almacen_origenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_almacen_origenKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_almacen_origen);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 710, 430));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

    private void tb_almacen_origenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_almacen_origenMouseClicked
        String cod = "";
        int fila = tb_almacen_origen.getSelectedRow();
        cod = (String) tb_almacen_origen.getValueAt(fila, 0);
        if (cod.equals("0000001")) {

            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //2
        if (cod.equals("0000002")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }

        //16
        if (cod.equals("0000016")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //18
        if (cod.equals("0000018")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //20
        if (cod.equals("0000020")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //22
        if (cod.equals("0000022")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //19
        if (cod.equals("0000019")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //11
        if (cod.equals("0000011")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //15
        if (cod.equals("0000015")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //3
        if (cod.equals("0000003")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //4
        if (cod.equals("0000004")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //5
        if (cod.equals("0000005")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //23
        if (cod.equals("0000023")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }
        //24
        if (cod.equals("0000024")) {
            Principal_recibo_fisc.lbl_almacen_pedidos.setText(cod);
            btn_actua_recibo.doClick();
        }

        this.dispose();


    }//GEN-LAST:event_tb_almacen_origenMouseClicked

    private void tb_almacen_origenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_almacen_origenKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

        }


    }//GEN-LAST:event_tb_almacen_origenKeyPressed

    private void tb_almacen_origenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_almacen_origenKeyReleased

    }//GEN-LAST:event_tb_almacen_origenKeyReleased

    private void tb_almacen_origenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_almacen_origenKeyTyped

    }//GEN-LAST:event_tb_almacen_origenKeyTyped

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
            java.util.logging.Logger.getLogger(Seleccion_fiscal_recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccion_fiscal_recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccion_fiscal_recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccion_fiscal_recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Seleccion_fiscal_recibos dialog = new Seleccion_fiscal_recibos(new javax.swing.JDialog(), true);
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
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tb_almacen_origen;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {
            String id_us = Principal.lbl_id_user.getText();
            String[] titulos = {"Código", "Almacén"};
            String[] registros = new String[4];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select u.cod_alma,a.alm_nom from usu_almacen as u inner join almacenes as a on a.alm_cod=u.cod_alma WHERE CONCAT (alm_nom) LIKE '%" + valor + "%' and u.cod_usu='" + id_us + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);

                model.addRow(registros);
            }
            tb_almacen_origen.setModel(model);
            tb_almacen_origen.getColumnModel().getColumn(0).setPreferredWidth(92);
            tb_almacen_origen.getColumnModel().getColumn(1).setPreferredWidth(250);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
