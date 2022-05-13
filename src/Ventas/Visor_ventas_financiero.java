/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Ventas.Principal_ventas.cod_ventas;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
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
public class Visor_ventas_financiero extends javax.swing.JDialog {

    DefaultTableModel model;

    public Visor_ventas_financiero(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // visor_recepcion   visor = new visor_recepcion(new javax.swing.JDialog(), true);
        // txtcod.setText(cod);

        cargar(cod_ventas);
        cargarTxt(cod_ventas);
        calcularValorCompras();
        lista_ventas();
        Total_compras();
        TotalVentasMenosCompras();
        cargar_detalle_pago();

    }

    //calcula total valor compras
    public void calcularValorCompras() {

        String imp = "0", subtotal = "0";

        for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_visor_recep.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_visor_recep.getValueAt(i, 3).toString().replaceAll("\\s", ""));
            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());
            tb_visor_recep.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 5);

        }
    }

    //  suma de toal de ventas
    public void lista_ventas() {

        String impv = "0", subtotalv = "0";

        for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_visor_recep.getValueAt(i, 6).toString().replaceAll("\\s", ""));

            impv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalv = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalv).add(ingreso.TransformReales(impv)).toString());

            valot_total.setText(subtotalv);

        }
    }
    //suma total compras

    public void Total_compras() {

        String impc = "0", subtotalc = "0", totalc = "0";

        for (int i = 0; i < tb_visor_recep.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_visor_recep.getValueAt(i, 5).toString().replaceAll("\\s", ""));

            impc = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.toString());
            subtotalc = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotalc).add(ingreso.TransformReales(impc)).toString());

            lbl_total_compras.setText(subtotalc);
        }
    }

    // diferencia ventas - compras
    public void TotalVentasMenosCompras() {

        String totalCuentaDa = "0";
        BigDecimal VentaTotal = ingreso.TransformReales(valot_total.getText());
        BigDecimal ValorCompra = ingreso.TransformReales(lbl_total_compras.getText());
        totalCuentaDa = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(VentaTotal.subtract(ValorCompra).toString());
        lbl_total_lucro.setText(totalCuentaDa);

    }

    void cargar(String valor) {
        String mostrar = "SELECT  d.cod_pro , d.pre_unit ,d.des_pro,d.cant_pro, p.pro_pre_costo,d.pre_venta,v.forma_pag_ventas FROM ventas_detalles AS d INNER JOIN tienda_productos AS p  ON d.cod_pro =p.pro_cod INNER JOIN ventas AS v ON d.num_bol=v.num_bol WHERE v.num_bol='" + valor + "' ORDER BY d.data ASC";
        String[] titulos = {"Id Producto", "Descripción", "Unidad", " Valor Costo", "Valor Venta", "Compra Equival.", "Total Ventas"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                Registros[0] = rs.getString("cod_pro");
                Registros[1] = rs.getString("des_pro");
                Registros[2] = rs.getString("cant_pro");
                Registros[3] = rs.getString("pro_pre_costo");
                Registros[4] = rs.getString("pre_unit");
                Registros[6] = rs.getString("pre_venta");

                model.addRow(Registros);
            }
            tb_visor_recep.setModel(model);

            tb_visor_recep.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_visor_recep.getColumnModel().getColumn(1).setPreferredWidth(350);
            tb_visor_recep.getColumnModel().getColumn(2).setPreferredWidth(80);
            tb_visor_recep.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_visor_recep.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_visor_recep.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_visor_recep.getColumnModel().getColumn(6).setPreferredWidth(100);

            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_ventas_financiero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargarTxt(String valor) {
        String mostrar = "SELECT * FROM ventas as v inner join tienda_clientes as c on v.cod_cli_ventas=c.cli_cod WHERE  num_bol='" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txt_nro_venta.setText(rs.getString(1));
                cliente.setText(rs.getString(3));
                forma_pago.setText(rs.getString(4));
                dias_plazo.setText(rs.getString(5));
                valot_total.setText(rs.getString(6));
                txt_fecha.setText(rs.getString(10));
                txt_usuario.setText(rs.getString(12));
                lbl_sucursal_id.setText(rs.getString(13));
                lbl_des_ventas.setText(rs.getString(20));
                lbl_status_ventas.setText(rs.getString(9));
                lbl_cli_sucursal.setText(rs.getString(35));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Visor_ventas_financiero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //cargar hsitorico 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel28 = new javax.swing.JLabel();
        lbl_status_ventas = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        dias_plazo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_visor_recep = new javax.swing.JTable();
        forma_pago = new javax.swing.JLabel();
        cliente = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        valot_total = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        txt_nro_venta = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_des_ventas = new javax.swing.JLabel();
        lbl_total_compras = new javax.swing.JLabel();
        lbl_sucursal_id = new javax.swing.JLabel();
        txt_salir = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_cli_sucursal = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_total_lucro = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_detalle_pago = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Ventas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("Estado:");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 50, 30));

        lbl_status_ventas.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        getContentPane().add(lbl_status_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Venta Nº:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Usuario:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 30));

        dias_plazo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(dias_plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 70, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Fecha :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 30));

        tb_visor_recep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_visor_recep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_visor_recep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_visor_recepMouseClicked(evt);
            }
        });
        tb_visor_recep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_visor_recepKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_visor_recep);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 890, 210));

        forma_pago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        forma_pago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        forma_pago.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 90, 30));

        cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 380, 30));

        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 190, 30));

        valot_total.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        valot_total.setForeground(new java.awt.Color(0, 102, 51));
        valot_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        valot_total.setText("0");
        valot_total.setToolTipText("");
        jPanel2.add(valot_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 140, 30));

        txt_fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 90, 30));

        txt_nro_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nro_venta.setForeground(new java.awt.Color(204, 51, 0));
        jPanel2.add(txt_nro_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Cond. de  Pago:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 110, 30));

        lbl_des_ventas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_des_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 510, 30));

        lbl_total_compras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_total_compras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total_compras.setText("0");
        jPanel2.add(lbl_total_compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 130, 30));

        lbl_sucursal_id.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_sucursal_id.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(lbl_sucursal_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 100, 30));

        txt_salir.setBorder(null);
        txt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salirActionPerformed(evt);
            }
        });
        txt_salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_salirKeyPressed(evt);
            }
        });
        jPanel2.add(txt_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 190, 0));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("N° Cuotas:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 90, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Almacén-Sucursal:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 140, 30));

        lbl_cli_sucursal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(lbl_cli_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 60, 30));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("Descripción:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 880, 130));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("Cliente:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 30));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Sucursal:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 60, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 130, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Valor Total Costo:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 100, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Lucro Total Ventas:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 110, 30));

        lbl_total_lucro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_total_lucro.setForeground(new java.awt.Color(153, 0, 0));
        lbl_total_lucro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total_lucro.setText("0");
        jPanel2.add(lbl_total_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 130, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Valor Total Ventas:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 110, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 460));

        tb_detalle_pago = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_detalle_pago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_detalle_pago.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(tb_detalle_pago);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 890, 120));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Historial Financiero ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 280, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_salirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_salirKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txt_salirKeyPressed

    private void txt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salirActionPerformed

    private void tb_visor_recepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_visor_recepKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepKeyReleased

    private void tb_visor_recepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_visor_recepMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_visor_recepMouseClicked

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
            java.util.logging.Logger.getLogger(Visor_ventas_financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visor_ventas_financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visor_ventas_financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visor_ventas_financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Visor_ventas_financiero dialog = new Visor_ventas_financiero(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel cliente;
    private javax.swing.JLabel dias_plazo;
    private javax.swing.JLabel forma_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_cli_sucursal;
    private javax.swing.JLabel lbl_des_ventas;
    private javax.swing.JLabel lbl_status_ventas;
    private javax.swing.JLabel lbl_sucursal_id;
    private javax.swing.JLabel lbl_total_compras;
    private javax.swing.JLabel lbl_total_lucro;
    private javax.swing.JTable tb_detalle_pago;
    private javax.swing.JTable tb_visor_recep;
    private javax.swing.JLabel txt_fecha;
    private javax.swing.JLabel txt_nro_venta;
    private javax.swing.JTextField txt_salir;
    private javax.swing.JLabel txt_usuario;
    private javax.swing.JLabel valot_total;
    // End of variables declaration//GEN-END:variables

    public void cargar_detalle_pago() {

        try {
            String valor = txt_nro_venta.getText();
            String almacen = lbl_sucursal_id.getText();

            String[] titulos = {"N° Serie", "Cliente", "Monto Pagado", " Pendiente", "Ult. Pago"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = "select * from pago_credito_comun WHERE  id_venta= '" + valor + "'   and id_surcusal='" + almacen + "' ORDER BY id_pago DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {

                registros[0] = rs.getString(12);
                registros[1] = rs.getString(4);
                registros[2] = rs.getString(5);
                registros[3] = rs.getString(6);
                registros[4] = rs.getString(9);

                model.addRow(registros);
            }
            tb_detalle_pago.setModel(model);

            tb_detalle_pago.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_detalle_pago.getColumnModel().getColumn(1).setPreferredWidth(250);
            tb_detalle_pago.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_detalle_pago.getColumnModel().getColumn(4).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
