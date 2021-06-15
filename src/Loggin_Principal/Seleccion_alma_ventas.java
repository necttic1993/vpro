/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loggin_Principal;

import Clases.machusculas;
import Conexion_DB.conectar;
import Ventas.Principal_ventas;
import Ventas_10.Principal_ventas_10;
import Ventas_11.Principal_ventas_11;
import Ventas_12.Principal_ventas_12;
import Ventas_13.Principal_ventas_13;
import Ventas_14.Principal_ventas_14;
import Ventas_15.Principal_ventas_15;
import Ventas_17.Principal_ventas_17;
import Ventas_18.Principal_ventas_18;
import Ventas_19.Principal_ventas_19;
import Ventas_2.Principal_ventas_2;
import Ventas_20.Principal_ventas_20;
import Ventas_21.Principal_ventas_21;
import Ventas_22.Principal_ventas_22;
import Ventas_23.Principal_ventas_23;
import Ventas_24.Principal_ventas_24;
import Ventas_25.Principal_ventas_25;
import Ventas_26.Principal_ventas_26;
import Ventas_27.Principal_ventas_27;
import Ventas_3.Principal_ventas_3;
import Ventas_4.Principal_ventas_4;
import Ventas_5.Principal_ventas_5;
import Ventas_6.Principal_ventas_6;
import Ventas_7.Principal_ventas_7;
import Ventas_8.Principal_ventas_8;
import Ventas_9.Principal_ventas_9;
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
import ventas_16.Principal_ventas_16;

/**
 *
 * @author user
 */
public class Seleccion_alma_ventas extends javax.swing.JDialog {

    DefaultTableModel model;

    public Seleccion_alma_ventas(javax.swing.JDialog parent, boolean modal) {
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
            try {

                Principal_ventas pv = new Principal_ventas(new javax.swing.JDialog(), true);
                pv.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //2
        if (cod.equals("0000002")) {
            try {
                Principal_ventas_2 pv_2 = new Principal_ventas_2(new javax.swing.JDialog(), true);
                pv_2.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }

        //3
        if (cod.equals("0000003")) {
            try {
                Principal_ventas_3 pv_3 = new Principal_ventas_3(new javax.swing.JDialog(), true);
                pv_3.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //4
        if (cod.equals("0000004")) {
            try {
                Principal_ventas_4 pv_4 = new Principal_ventas_4(new javax.swing.JDialog(), true);
                pv_4.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //5
        if (cod.equals("0000005")) {
            try {
                Principal_ventas_5 pv_5 = new Principal_ventas_5(new javax.swing.JDialog(), true);
                pv_5.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //6
        if (cod.equals("0000006")) {
            try {
                Principal_ventas_6 pv_6 = new Principal_ventas_6(new javax.swing.JDialog(), true);
                pv_6.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (cod.equals("0000007")) {
            try {
                Principal_ventas_7 pv_7 = new Principal_ventas_7(new javax.swing.JDialog(), true);
                pv_7.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cod.equals("0000008")) {
            try {
                Principal_ventas_8 pv_8 = new Principal_ventas_8(new javax.swing.JDialog(), true);
                pv_8.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cod.equals("0000009")) {
            try {
                Principal_ventas_9 pv_9 = new Principal_ventas_9(new javax.swing.JDialog(), true);
                pv_9.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cod.equals("0000010")) {
            try {
                Principal_ventas_10 pv_10 = new Principal_ventas_10(new javax.swing.JDialog(), true);
                pv_10.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //11
        if (cod.equals("0000011")) {
            try {
                Principal_ventas_11 /*pv_20 = null;*/ pv_11 = new Principal_ventas_11(new javax.swing.JDialog(), true);
                pv_11.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cod.equals("0000012")) {
            try {
                Principal_ventas_12 pv_12 = new Principal_ventas_12(new javax.swing.JDialog(), true);
                pv_12.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (cod.equals("0000013")) {
            try {
                Principal_ventas_13 pv_13 = new Principal_ventas_13(new javax.swing.JDialog(), true);
                pv_13.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cod.equals("0000014")) {
            try {
                Principal_ventas_14 pv_14 = new Principal_ventas_14(new javax.swing.JDialog(), true);
                pv_14.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //15
        if (cod.equals("0000015")) {
            try {
                Principal_ventas_15 /*pv_20 = null;*/ pv_15 = new Principal_ventas_15(new javax.swing.JDialog(), true);
                pv_15.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        //16
        if (cod.equals("0000016")) {
            try {
                Principal_ventas_16 pv = new Principal_ventas_16(new javax.swing.JDialog(), true);
                pv.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //17
        if (cod.equals("0000017")) {
            try {
                Principal_ventas_17 pv_17 = new Principal_ventas_17(new javax.swing.JDialog(), true);
                pv_17.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        //18
        if (cod.equals("0000018")) {
            try {
                Principal_ventas_18 /*pv_20 = null;*/ pv_18 = new Principal_ventas_18(new javax.swing.JDialog(), true);
                pv_18.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //19
        if (cod.equals("0000019")) {
            try {
                Principal_ventas_19 /*pv_20 = null;*/ pv_19 = new Principal_ventas_19(new javax.swing.JDialog(), true);
                pv_19.setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        //20
        if (cod.equals("0000020")) {
            try {
                Principal_ventas_20 /*pv_20 = null;*/ pv_20 = new Principal_ventas_20(new javax.swing.JDialog(), true);
                pv_20.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (cod.equals("0000021")) {
            try {
                Principal_ventas_21 pv_21 = new Principal_ventas_21(new javax.swing.JDialog(), true);
                pv_21.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //22
        if (cod.equals("0000022")) {
            try {
                Principal_ventas_22 /*pv_20 = null;*/ pv_22 = new Principal_ventas_22(new javax.swing.JDialog(), true);
                pv_22.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //23
        if (cod.equals("0000023")) {
            try {
                Principal_ventas_23 /*pv_20 = null;*/ pv_23 = new Principal_ventas_23(new javax.swing.JDialog(), true);
                pv_23.setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }

        //24
        if (cod.equals("0000024")) {
            try {
                Principal_ventas_24 /*pv_20 = null;*/ pv_24 = new Principal_ventas_24(new javax.swing.JDialog(), true);
                pv_24.setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        //25
        if (cod.equals("0000025")) {
            try {
                Principal_ventas_25 pv_25 = new Principal_ventas_25(new javax.swing.JDialog(), true);
                pv_25.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (cod.equals("0000026")) {
            try {
                Principal_ventas_26 pv_26 = new Principal_ventas_26(new javax.swing.JDialog(), true);
                pv_26.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (cod.equals("0000027")) {
            try {
                Principal_ventas_27 pv_27 = new Principal_ventas_27(new javax.swing.JDialog(), true);
                pv_27.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

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
            java.util.logging.Logger.getLogger(Seleccion_alma_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccion_alma_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccion_alma_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccion_alma_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Seleccion_alma_ventas dialog = new Seleccion_alma_ventas(new javax.swing.JDialog(), true);
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
