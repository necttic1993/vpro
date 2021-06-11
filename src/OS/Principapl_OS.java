/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS;

import Clases.ColorearFilas_os;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import net.sf.jasperreports.engine.JRException;
import report.Reportes;

/**
 *
 * @author user
 */
public class Principapl_OS extends javax.swing.JDialog {

    DefaultTableModel model;
    long OL;
    FileInputStream fis;

    public Principapl_OS(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
        OpcionMenu();

        btn_cargar_datos.setVisible(false);
    }
    public static String codPro = "";
    public static String cod_egre_actu = "";
    public static String cod_os_actu = "";
    public static String cod_deta_os = "";

    public void OpcionMenu() {
        JPopupMenu menu_opcion = new JPopupMenu();
        JMenuItem menu_modPro = new JMenuItem("Actualizar Situación", new ImageIcon(getClass().getResource("/icon_4/modificar.png")));
        JMenuItem menu_reimprimir = new JMenuItem("Re-Imprimir Nota", new ImageIcon(getClass().getResource("/icon_4/print.png")));
        JMenuItem menu_lab = new JMenuItem("Laboratorio", new ImageIcon(getClass().getResource("/icon_4/repair.png")));
        JMenuItem menu_entrega = new JMenuItem("Realizar Entrega", new ImageIcon(getClass().getResource("/icon_4/histo.png")));

        menu_modPro.addActionListener((ActionEvent e) -> {

            int filaMod = tb_os.getSelectedRow();
            String note = (String) tb_os.getValueAt(filaMod, 5);
            String et = "ENTREGADO";
            String re = "PAGADO";

            if (et.equals(note) || re.equals(note)) {
                JOptionPane.showMessageDialog(null, "O.S ya procesado o entregado");
                txt_bus.requestFocus();
            } else {

                if (filaMod == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione algun dato");
                } else {
                    int filaModi = tb_os.getSelectedRow();
                    cod_os_actu = (String) tb_os.getValueAt(filaModi, 0);
                    Status_os rp;
                    rp = new Status_os(new javax.swing.JDialog(), true);
                    rp.setVisible(true);
                }
            }
            Principapl_OS.btn_cargar_datos.doClick();

        });

        menu_reimprimir.addActionListener((ActionEvent e) -> {

            int filasel = tb_os.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione algun dato");
            } else {
                int filaMod = tb_os.getSelectedRow();
                String cod_os = (String) tb_os.getValueAt(filaMod, 0);

                Reportes reporte = new Reportes();
                try {
                    reporte.os(cod_os);

                } catch (SQLException | JRException ex) {
                    Logger.getLogger(Principapl_OS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        menu_lab.addActionListener((ActionEvent e) -> {
            int filaMod = tb_os.getSelectedRow();
            String note = (String) tb_os.getValueAt(filaMod, 5);
            String et = "ENTREGADO";
            String re = "PAGADO";

            if (et.equals(note) || re.equals(note)) {
                JOptionPane.showMessageDialog(null, "O.S ya procesado o entregado");
                txt_bus.requestFocus();
            } else {
                int filasel = tb_os.getSelectedRow();
                if (filasel == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione algun dato");
                } else {
                    int filaModi = tb_os.getSelectedRow();
                    cod_os_actu = (String) tb_os.getValueAt(filaModi, 0);
                    Status_Lab osp;
                    osp = new Status_Lab(new javax.swing.JDialog(), true);
                    osp.setVisible(true);
                }
            }
        });

        menu_entrega.addActionListener((ActionEvent e) -> {

            int filaMod = tb_os.getSelectedRow();
            String note = (String) tb_os.getValueAt(filaMod, 5);
            String et = "RECEPCION";
            String re = "TEST";
            String se = "REPARADO";
            String le = "LABORATORIO";
            String sin = "SIN SOLUCION";
            String en = "ENTREGADO";
            if (et.equals(note) || re.equals(note) || se.equals(note) || le.equals(note) || sin.equals(note) || en.equals(note)) {
                JOptionPane.showMessageDialog(null, "O.S no fue procesado en caja o ya fue entegado ");
                txt_bus.requestFocus();
            } else {
                int filasel = tb_os.getSelectedRow();
                if (filasel == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione algun dato");
                } else {
                    String entrega = JOptionPane.showInputDialog("Ingrese detalles del cliente");
                    String cod_os = (String) tb_os.getValueAt(filaMod, 0);
                    String detalle = ("ENTREGADO");
                    String sql = "UPDATE os SET os_status = '" + detalle
                            + "',os_entre ='" + entrega
                            + "' WHERE os_nro = '" + cod_os + "'";

                    try {
                        Connection cn = conectar.getInstance().getConnection();

                        PreparedStatement pst = cn.prepareStatement(sql);
                        pst.executeUpdate();
                        conectar.getInstance().closeConnection(cn);

                        JOptionPane.showMessageDialog(null, "O.S entregado!");

                    } catch (SQLException ex) {
                        Logger.getLogger(Principapl_OS.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            Principapl_OS.btn_cargar_datos.doClick();

        });

        menu_opcion.add(menu_modPro);
        menu_opcion.add(menu_reimprimir);
        menu_opcion.add(menu_lab);
        menu_opcion.add(menu_entrega);
        tb_os.setComponentPopupMenu(menu_opcion);

    }

    void cargar(String valor) {
        try {

            String[] titulos = {"O.S N°", "Serie N° ", "Fecha Entrada", "Cliente", "Producto", "Situación", "Valor Caja", "Entregado a"};
            String[] registros = new String[10];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from os WHERE CONCAT (os_nro,os_serie,os_cli) LIKE '%" + valor + "%'";
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
                registros[7] = rs.getString(21);

                model.addRow(registros);
            }
            tb_os.setModel(model);

            ColorearFilas_os color = new ColorearFilas_os(5);
            tb_os.getColumnModel().getColumn(0).setCellRenderer(color);
            tb_os.getColumnModel().getColumn(5).setCellRenderer(color);

            tb_os.getColumnModel().getColumn(0).setPreferredWidth(83);
            tb_os.getColumnModel().getColumn(1).setPreferredWidth(130);
            tb_os.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_os.getColumnModel().getColumn(3).setPreferredWidth(230);
            tb_os.getColumnModel().getColumn(4).setPreferredWidth(300);
            tb_os.getColumnModel().getColumn(5).setPreferredWidth(160);
            tb_os.getColumnModel().getColumn(6).setPreferredWidth(130);
            tb_os.getColumnModel().getColumn(7).setPreferredWidth(160);
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
        jButton3 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar_datos = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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
        tb_os.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1230, 530));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton3.setText("Agregar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, 120, 40));

        txt_bus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        jPanel1.add(txt_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 17, 360, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 40, 40));

        btn_cargar_datos.setText("cargar");
        btn_cargar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargar_datosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/add.png"))); // NOI18N
        jButton2.setText("Costos");
        jButton2.setAutoscrolls(true);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 130, 40));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/histo.png"))); // NOI18N
        jButton4.setText("Situaciones");
        jButton4.setAutoscrolls(true);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_osMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_osMouseClicked
        /*        int filaMod = tb_gastos.getSelectedRow();
         cod_egre_actu = (String) tb_gastos.getValueAt(filaMod, 0);

         Gastos_actualizar vg;
         vg = new Gastos_actualizar(new javax.swing.JDialog(), true);
         vg.setVisible(true);*/
    }//GEN-LAST:event_tb_osMouseClicked

    private void tb_osKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_osKeyReleased

    }//GEN-LAST:event_tb_osKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Registrar_OS gr;
        gr = new Registrar_OS(new javax.swing.JDialog(), true);
        gr.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb_osKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_osKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_SPACE) {

            int filaMod = tb_os.getSelectedRow();
            cod_deta_os = (String) tb_os.getValueAt(filaMod, 0);

            Visor_OS vos;
            vos = new Visor_OS(new javax.swing.JDialog(), true);
            vos.setVisible(true);

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {
            txt_bus.requestFocus();

        }

        if (Tecla == KeyEvent.VK_ENTER) {

            int filaMod = tb_os.getSelectedRow();
            cod_deta_os = (String) tb_os.getValueAt(filaMod, 0);

            Detalles_OS dos;
            dos = new Detalles_OS(new javax.swing.JDialog(), true);
            dos.setVisible(true);
        }
    }//GEN-LAST:event_tb_osKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        cargar(txt_bus.getText());
    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

    private void btn_cargar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargar_datosActionPerformed
        cargar("");
    }//GEN-LAST:event_btn_cargar_datosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Os_listado_costos olis;
        olis = new Os_listado_costos(new javax.swing.JDialog(), true);
        olis.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        listado_situacios lis;
        lis = new listado_situacios(new javax.swing.JDialog(), true);
        lis.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Principapl_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principapl_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principapl_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principapl_OS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principapl_OS dialog = new Principapl_OS(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_cargar_datos;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tb_os;
    public static javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

}
