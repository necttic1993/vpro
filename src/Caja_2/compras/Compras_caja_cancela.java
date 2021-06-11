/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.compras;

import Caja_2.Caja_caja;
import Clases.ColorearFilas_estaComp;
import Clases.ColorearTipoPago;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Compras_caja_cancela extends javax.swing.JDialog {

    DefaultTableModel model;

    public Compras_caja_cancela(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
        txt_bus.requestFocus();

    }

    public static String cod_pro_caja = "";
    public static String cod_imagen_caja = "";
    public static String cod_pro_mod_caja = "";
    public static String cod_compras_caja_cancela = "";

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_compras_caja = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("COMPRAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_compras_caja = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_compras_caja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_compras_caja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_compras_caja.setGridColor(new java.awt.Color(0, 102, 204));
        tb_compras_caja.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tb_compras_caja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_compras_cajaMouseClicked(evt);
            }
        });
        tb_compras_caja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_compras_cajaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_compras_cajaKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tb_compras_caja);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1220, 510));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bus.setToolTipText("Buscar Registros");
        txt_bus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 370, 32));

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 35));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_compras_cajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_compras_cajaMouseClicked
        try {

            int fila = tb_compras_caja.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tb_compras_caja.getValueAt(fila, 0).toString();
                String desins = ("CANC. DE COMPRA NOTA N°" + tb_compras_caja.getValueAt(fila, 0).toString());
                String preins = tb_compras_caja.getValueAt(fila, 6).toString();

                Caja_caja.txt_nro_docu.setText(codins);
                Caja_caja.txt_des_caja.setText(desins);
                Caja_caja.lbl_total_gs.setText(preins);
                Caja_caja.btn_calcular.doClick();
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_compras_cajaMouseClicked

    private void tb_compras_cajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_compras_cajaKeyReleased

    }//GEN-LAST:event_tb_compras_cajaKeyReleased

    private void tb_compras_cajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_compras_cajaKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();
            txt_bus.setText("");
        }
        if (Tecla == KeyEvent.VK_SPACE) {

            int filaMod = tb_compras_caja.getSelectedRow();
            cod_compras_caja_cancela = (String) tb_compras_caja.getValueAt(filaMod, 0);

            visor_compras_caja visor;
            visor = new visor_compras_caja(new javax.swing.JDialog(), true);
            visor.setVisible(true);
        }
        if (Tecla == KeyEvent.VK_ENTER) {
            try {

                int fila = tb_compras_caja.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_compras_caja.getValueAt(fila, 0).toString();
                    String desins = ("CANC. DE COMPRA NOTA N°" + tb_compras_caja.getValueAt(fila, 0).toString());
                    String preins = tb_compras_caja.getValueAt(fila, 6).toString();

                    Caja_caja.txt_nro_docu.setText(codins);
                    Caja_caja.txt_des_caja.setText(desins);
                    Caja_caja.lbl_total_gs.setText(preins);
                    Caja_caja.btn_calcular.doClick();
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
    }//GEN-LAST:event_tb_compras_cajaKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txt_bus.getText());
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
            java.util.logging.Logger.getLogger(Compras_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras_caja_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Compras_caja_cancela dialog = new Compras_caja_cancela(new javax.swing.JDialog(), true);
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
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tb_compras_caja;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    void cargar(String valor) {
        try {

            String[] titulos = {"Nro Compras", "Cód.Proveedor", "Proveedor", "Nro Nota", "Fecha de Emisión", "Fecha de Entrada", "Valor Total", "Almacén", "Estado"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from compras WHERE CONCAT (nom_prov_comp) LIKE '%" + valor + "%' AND estado_comp='CONFIRMADA' AND pago_comp='CONTADO'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(10);
                registros[7] = rs.getString(6);
                registros[8] = rs.getString(13);

                model.addRow(registros);
            }
            tb_compras_caja.setModel(model);

            //   ColorearFilas color = new ColorearFilas(6);
            //   tbProductos.getColumnModel().getColumn(0).setCellRenderer(color);
            ColorearFilas_estaComp color = new ColorearFilas_estaComp(8);
            tb_compras_caja.getColumnModel().getColumn(0).setCellRenderer(color);

            ColorearTipoPago colorear = new ColorearTipoPago(3);
            tb_compras_caja.getColumnModel().getColumn(3).setCellRenderer(colorear);
            tb_compras_caja.getColumnModel().getColumn(4).setCellRenderer(colorear);

            tb_compras_caja.getColumnModel().getColumn(0).setPreferredWidth(90);
            tb_compras_caja.getColumnModel().getColumn(1).setPreferredWidth(95);
            tb_compras_caja.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_compras_caja.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_compras_caja.getColumnModel().getColumn(4).setPreferredWidth(110);
            tb_compras_caja.getColumnModel().getColumn(5).setPreferredWidth(110);
            tb_compras_caja.getColumnModel().getColumn(6).setPreferredWidth(107);
            tb_compras_caja.getColumnModel().getColumn(7).setPreferredWidth(120);
            tb_compras_caja.getColumnModel().getColumn(8).setPreferredWidth(180);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void actCompras() {
        int filaselect = tb_compras_caja.getSelectedRow();
        String codigo = (String) tb_compras_caja.getValueAt(filaselect, 0);
        String est = "CONFIRMADA";
        String sql = "UPDATE compras SET estado_comp ='" + est + "' WHERE cod_comp = '" + codigo + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            //JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void caja() {
        int i = Compras_caja_cancela.tb_compras_caja.getSelectedRow();

        String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo) VALUES (?,?,?,?,?,?,?,?,?)";
        String descaja = ("EN CONCEPTO DE COMPRA: NOTA N°" + tb_compras_caja.getValueAt(i, 0).toString());
        String total_gs = ("0");
        String his = ("COMPRAS");
        String egreso_gs = tb_compras_caja.getValueAt(i, 6).toString();
        String egreso_rs = ("0");
        String fecha_caja = Principal.lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String moneda = ("Guaraníes");
        String tipo_caja = ("D");
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, descaja);
            pst.setString(2, total_gs);
            pst.setString(3, his);
            pst.setString(4, egreso_gs);
            pst.setString(5, egreso_rs);
            pst.setString(6, fecha_caja);
            pst.setString(7, user);
            pst.setString(8, moneda);
            pst.setString(9, tipo_caja);

            int n = pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Nota Confirmada");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Compras_caja_cancela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ValidaLanza(String exp) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String consul = "SELECT * FROM compras WHERE  cod_comp='" + exp + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Nota ya Lanzado N°:" + exp, "Mensaje", JOptionPane.OK_CANCEL_OPTION);

            } else {

            }

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
