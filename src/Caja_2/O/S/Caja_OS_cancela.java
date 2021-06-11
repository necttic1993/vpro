/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2.O.S;

import Caja_2.Caja_caja;
import Clases.ColorearFilas_os;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_usu_nom;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Caja_OS_cancela extends javax.swing.JDialog {

    DefaultTableModel model;
    long OL;
    FileInputStream fis;

    public Caja_OS_cancela(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
     
    }
    public static String codPro = "";
    public static String cod_egre_actu = "";
    public static String cod_os_actu = "";
    public static String cod_deta_os = "";

    void cargar(String valor) {
        try {

            String[] titulos = {"O.S N°", "Serie N° ", "Fecha Entrada", "Cliente", "Producto", "Situación", "Valor O.S"};
            String[] registros = new String[10];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from os WHERE CONCAT (os_nro,os_serie,os_cli) LIKE '%" + valor + "%' AND os_status= 'ENTREGADO'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(5);
                registros[4] = rs.getString(7);
                registros[5] = rs.getString(8);
                registros[6] = rs.getString(9);

                model.addRow(registros);
            }
            tb_os.setModel(model);

            ColorearFilas_os color = new ColorearFilas_os(5);
            tb_os.getColumnModel().getColumn(0).setCellRenderer(color);
            tb_os.getColumnModel().getColumn(5).setCellRenderer(color);

            tb_os.getColumnModel().getColumn(0).setPreferredWidth(83);
            tb_os.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_os.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_os.getColumnModel().getColumn(3).setPreferredWidth(250);
            tb_os.getColumnModel().getColumn(4).setPreferredWidth(300);
            tb_os.getColumnModel().getColumn(5).setPreferredWidth(160);
            tb_os.getColumnModel().getColumn(6).setPreferredWidth(130);
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
        tb_os = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asistencia OS");
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_os = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_os.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tb_os.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_os.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_osMouseClicked(evt);
            }
        });
        tb_os.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_osKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_osKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_os);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1180, 540));

        txtbuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 410, 32));

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 35));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_osMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_osMouseClicked
        try {

            int fila = tb_os.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
            } else {
                String codins = tb_os.getValueAt(fila, 0).toString();
                String desins = ("CANC. DE O.S NOTA N°" + tb_os.getValueAt(fila, 0).toString());
                String preins = tb_os.getValueAt(fila, 6).toString();

                Caja_caja.txt_nro_docu.setText(codins);
                Caja_caja.txt_des_caja.setText(desins);
                Caja_caja.lbl_total_gs.setText(preins);
                Caja_caja.btn_calcular.doClick();
                this.dispose();

            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_tb_osMouseClicked

    private void tb_osKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_osKeyReleased

    }//GEN-LAST:event_tb_osKeyReleased

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

    }//GEN-LAST:event_txtbuscarKeyReleased

    private void tb_osKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_osKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

            try {

                int fila = tb_os.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_os.getValueAt(fila, 0).toString();
                    String desins = ("CANC. DE O.S NOTA N°" + tb_os.getValueAt(fila, 0).toString());
                    String preins = tb_os.getValueAt(fila, 6).toString();

                    Caja_caja.txt_nro_docu.setText(codins);
                    Caja_caja.txt_des_caja.setText(desins);
                    Caja_caja.lbl_total_gs.setText(preins);
                    Caja_caja.btn_calcular.doClick();
                    this.dispose();

                }
            } catch (HeadlessException | NumberFormatException e) {
            }

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txtbuscar.requestFocus();

        }


    }//GEN-LAST:event_tb_osKeyPressed

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
            java.util.logging.Logger.getLogger(Caja_OS_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja_OS_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja_OS_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja_OS_cancela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Caja_OS_cancela dialog = new Caja_OS_cancela(new javax.swing.JDialog(), true);
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
    public static javax.swing.JTable tb_os;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    void actualGastos() {
        int filasel = tb_os.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                String nro = (String) tb_os.getValueAt(filasel, 0);
                String timbrado = (String) tb_os.getValueAt(filasel, 1);
                String fecha_emi = (String) tb_os.getValueAt(filasel, 2);
                String concep = (String) tb_os.getValueAt(filasel, 3);
                String prov = (String) tb_os.getValueAt(filasel, 4);
                String fecha_entra = (String) tb_os.getValueAt(filasel, 5);
                String hist = (String) tb_os.getValueAt(filasel, 6);
                String monto = (String) tb_os.getValueAt(filasel, 7);

                String sql = "UPDATE gastos SET gas_timbra = '" + timbrado
                        + "',gas_fecha_emi ='" + fecha_emi
                        + "',gas_des ='" + concep
                        + "',gas_provee ='" + prov
                        + "',gas_fecha_entra = '" + fecha_entra
                        + "',gas_histo = '" + hist
                        + "',gas_monto ='" + monto
                        + "' WHERE gas_num = '" + nro + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    JOptionPane.showMessageDialog(null, "Actualizado");
                    cargar("");

                    txtbuscar.requestFocus();
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }

    }

    void borrarGastos() {

        int filasel = tb_os.getSelectedRow();
        try {
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                String cod = (String) tb_os.getValueAt(filasel, 0);
                String eliminarSQL = "DELETE FROM gastos WHERE gas_id = '" + cod + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    JOptionPane.showMessageDialog(null, "Borrado");
                    cargar("");

                    txtbuscar.requestFocus();
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
        }

    }

    void caja() {
        int i = tb_os.getSelectedRow();

        String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo) VALUES (?,?,?,?,?,?,?,?,?)";
        String descaja = ("EN CONCEPTO DE GASTOS N°" + tb_os.getValueAt(i, 0).toString());
        String total_gs = ("0");
        String his = ("PAGO A PROVEEDORES");
        String egreso_gs = tb_os.getValueAt(i, 8).toString();
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
            Logger.getLogger(Caja_OS_cancela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void cajaC() {
        int i = tb_os.getSelectedRow();

        String InsertarSQL = "INSERT INTO caja(des_caja,moneda1_caja_in,moneda2_caja_in,moneda1_caja_eg,moneda2_caja_eg,fecha_caja,user,caja_mon_cambio,caja_tipo) VALUES (?,?,?,?,?,?,?,?,?)";
        String descaja = ("Cancelamiento de Nota N°" + tb_os.getValueAt(i, 0).toString());
        String total_gs = tb_os.getValueAt(i, 8).toString();
        String his = ("CANC. PAGO A PROVEEDORES");
        String egreso_gs = ("0");
        String egreso_rs = ("0");
        String fecha_caja = Principal.lbl_fecha_hoy.getText();
        String user = lbl_usu_nom.getText();
        String moneda = ("Guaraníes");
        String tipo_caja = ("C");
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
                JOptionPane.showMessageDialog(null, "Nota Cancelada");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Caja_OS_cancela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void actCompras() {
        int filaselect = tb_os.getSelectedRow();
        String codigo = (String) tb_os.getValueAt(filaselect, 0);
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
        int filaselect = tb_os.getSelectedRow();
        String codigo = (String) tb_os.getValueAt(filaselect, 0);
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
