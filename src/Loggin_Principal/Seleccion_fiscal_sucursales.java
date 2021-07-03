/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loggin_Principal;

import Clases.machusculas;
import Conexion_DB.conectar;
import Ventas.Fact_surc_10.Principal_ventas_surc_10;
import Ventas.Fact_surc_11.Principal_ventas_surc_11;
import Ventas.Fact_surc_14.Principal_ventas_facturas_14;
import Ventas.Fact_surc_16.Principal_ventas_facturas_16;
import Ventas.Fact_surc_18.Principal_ventas_facturas_18;
import Ventas.Fact_surc_19.Principal_ventas_surc_19;
import Ventas.Fact_surc_2.Principal_ventas_surc_2;
import Ventas.Fact_surc_21.Principal_ventas_facturas_21;
import Ventas.Fact_surc_22.Principal_ventas_surc_22;
import Ventas.Fact_surc_23.Principal_ventas_facturas_23;
import Ventas.Fact_surc_24.Principal_ventas_facturas_24;
import Ventas.Fact_surc_26.Principal_ventas_facturas_26;
import Ventas.Fact_surc_27.Principal_ventas_facturas_27;
import Ventas.Fact_surc_28.Principal_ventas_facturas_28;
import Ventas.Fact_surc_3.Principal_ventas_surc_3;
import Ventas.Fact_surc_4.Principal_ventas_facturas_4;
import Ventas.Fact_surc_6.Principal_ventas_facturas_6;
import Ventas.Fact_surc_8.Principal_ventas_facturas_8;
import Ventas.Fact_surc_9.Principal_ventas_facturas_9;
import Ventas.Facturas.Principal_ventas_facturas;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Seleccion_fiscal_sucursales extends javax.swing.JDialog {

    DefaultTableModel model;

    public Seleccion_fiscal_sucursales(javax.swing.JDialog parent, boolean modal) {
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
            Principal_ventas_facturas pvf = new Principal_ventas_facturas(new javax.swing.JDialog(), true);
            pvf.setVisible(true);
            this.dispose();
        }
        //2
        if (cod.equals("0000002")) {
            Principal_ventas_surc_2 pv_2 = new Principal_ventas_surc_2(new javax.swing.JDialog(), true);
            pv_2.setVisible(true);
            this.dispose();

        }

        //16
        if (cod.equals("0000003")) {
            Principal_ventas_surc_3 vf3;
            vf3 = new Principal_ventas_surc_3(new javax.swing.JDialog(), true);
            vf3.setVisible(true);
            this.dispose();
        }

        if (cod.equals("0000004")) {
            Principal_ventas_facturas_4 vf4;
            vf4 = new Principal_ventas_facturas_4(new javax.swing.JDialog(), true);
            vf4.setVisible(true);
            this.dispose();

        }

        if (cod.equals("0000006")) {
            Principal_ventas_facturas_6 vf6;
            vf6 = new Principal_ventas_facturas_6(new javax.swing.JDialog(), true);
            vf6.setVisible(true);
            this.dispose();
        }
        //18
        if (cod.equals("0000008")) {
            Principal_ventas_facturas_8 vf8;
            vf8 = new Principal_ventas_facturas_8(new javax.swing.JDialog(), true);
            vf8.setVisible(true);
            this.dispose();
        }

        if (cod.equals("0000009")) {
            Principal_ventas_facturas_9 vf9;
            vf9 = new Principal_ventas_facturas_9(new javax.swing.JDialog(), true);
            vf9.setVisible(true);
            this.dispose();
        }
        
         if (cod.equals("0000010")) {
            Principal_ventas_surc_10 vf10;
            vf10 = new Principal_ventas_surc_10(new javax.swing.JDialog(), true);
            vf10.setVisible(true);
            this.dispose();
        }
        //20
        if (cod.equals("0000020")) {

        }
        //11
        if (cod.equals("0000011")) {
            Principal_ventas_surc_11 vf11;
            vf11 = new Principal_ventas_surc_11(new javax.swing.JDialog(), true);
            vf11.setVisible(true);
            this.dispose();
        }
        if (cod.equals("0000014")) {
            Principal_ventas_facturas_14 vf14;
            vf14 = new Principal_ventas_facturas_14(new javax.swing.JDialog(), true);
            vf14.setVisible(true);
            this.dispose();
        }

        if (cod.equals("0000016")) {

            Principal_ventas_facturas_16 vf16;
            vf16 = new Principal_ventas_facturas_16(new javax.swing.JDialog(), true);
            vf16.setVisible(true);
            this.dispose();
        }

        if (cod.equals("0000018")) {

            Principal_ventas_facturas_18 vf18;
            vf18 = new Principal_ventas_facturas_18(new javax.swing.JDialog(), true);
            vf18.setVisible(true);
            this.dispose();
        }

        if (cod.equals("0000021")) {
            Principal_ventas_facturas_21 vf21;
            vf21 = new Principal_ventas_facturas_21(new javax.swing.JDialog(), true);
            vf21.setVisible(true);
            this.dispose();
        }
        //22
        if (cod.equals("0000022")) {
            Principal_ventas_surc_22 vf22;
            vf22 = new Principal_ventas_surc_22(new javax.swing.JDialog(), true);
            vf22.setVisible(true);
            this.dispose();
        }

        //22
        if (cod.equals("0000023")) {
            Principal_ventas_facturas_23 vf23;
            vf23 = new Principal_ventas_facturas_23(new javax.swing.JDialog(), true);
            vf23.setVisible(true);
            this.dispose();
        }

        //22
        if (cod.equals("0000026")) {
            Principal_ventas_facturas_26 vf26;
            vf26 = new Principal_ventas_facturas_26(new javax.swing.JDialog(), true);
            vf26.setVisible(true);
            this.dispose();
        }

        if (cod.equals("0000024")) {
            Principal_ventas_facturas_24 vf24;
            vf24 = new Principal_ventas_facturas_24(new javax.swing.JDialog(), true);
            vf24.setVisible(true);
            this.dispose();
        }
        //15
        if (cod.equals("0000019")) {
            Principal_ventas_surc_19 vf19;
            vf19 = new Principal_ventas_surc_19(new javax.swing.JDialog(), true);
            vf19.setVisible(true);
            this.dispose();
        }

        if (cod.equals("0000027")) {
            Principal_ventas_facturas_27 vf27;
            vf27 = new Principal_ventas_facturas_27(new javax.swing.JDialog(), true);
            vf27.setVisible(true);
            this.dispose();
        }
        
         if (cod.equals("0000028")) {
            Principal_ventas_facturas_28 vf28;
            vf28 = new Principal_ventas_facturas_28(new javax.swing.JDialog(), true);
            vf28.setVisible(true);
            this.dispose();
        }


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
            java.util.logging.Logger.getLogger(Seleccion_fiscal_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccion_fiscal_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccion_fiscal_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccion_fiscal_sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Seleccion_fiscal_sucursales dialog = new Seleccion_fiscal_sucursales(new javax.swing.JDialog(), true);
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
