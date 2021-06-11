/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class costos_monedas_vistas extends javax.swing.JDialog {

    /**
     * Creates new form costos_monedas
     */
    public costos_monedas_vistas(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BuscarProductoEditar(Productos.cod_pro);
        cargar();
        calcularPreA();
        calcularPreB();
        calcularPreMInimo();
    }

    void BuscarProductoEditar(String cod) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            String pre_a = "", pre_b = "", pre_ataca = "";
            String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {

                pre_a = rs.getString(7);
                pre_b = rs.getString(8);
                pre_ataca = rs.getString(9);

            }

            txt_pre_a.setText(pre_a);
            txt_pre_ata.setText(pre_b);
            txt_pre_b.setText(pre_ataca);
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_pre_a = new javax.swing.JLabel();
        txt_pre_ata = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_pre_b = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pre_minimo_dolar = new javax.swing.JLabel();
        lbl_r = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_dolar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pre_a_dolar = new javax.swing.JLabel();
        pre_b_dolar = new javax.swing.JLabel();
        pre_a_reales = new javax.swing.JLabel();
        pre_b_reales = new javax.swing.JLabel();
        pre_minimo_reales = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_pre_a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_pre_a.setText("pre_a");
        jPanel1.add(txt_pre_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 120, 30));

        txt_pre_ata.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_pre_ata.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_pre_ata.setText("pre_b");
        txt_pre_ata.setFocusable(false);
        jPanel1.add(txt_pre_ata, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 120, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Valores del cambio del día:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        txt_pre_b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_pre_b.setText("pre_atacado");
        jPanel1.add(txt_pre_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"))); // NOI18N
        jLabel5.setText("Reales");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Precio B*:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Precio A:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/paraguay.png"))); // NOI18N
        jLabel8.setText("Guaraníes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"))); // NOI18N
        jLabel9.setText("Dólares");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, 30));

        pre_minimo_dolar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pre_minimo_dolar.setForeground(new java.awt.Color(0, 0, 153));
        pre_minimo_dolar.setText("pre_minimo");
        jPanel1.add(pre_minimo_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 160, 30));

        lbl_r.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_r.setForeground(new java.awt.Color(204, 0, 0));
        lbl_r.setText("1,365");
        jPanel1.add(lbl_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 70, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Dólares:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, 30));

        lbl_dolar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_dolar.setForeground(new java.awt.Color(204, 0, 0));
        lbl_dolar.setText("5,780");
        jPanel1.add(lbl_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 80, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Mínimo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Reales:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, 30));

        pre_a_dolar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pre_a_dolar.setForeground(new java.awt.Color(0, 0, 153));
        pre_a_dolar.setText("pre_a");
        jPanel1.add(pre_a_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 160, 30));

        pre_b_dolar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pre_b_dolar.setForeground(new java.awt.Color(0, 0, 153));
        pre_b_dolar.setText("pre_b");
        jPanel1.add(pre_b_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 160, 30));

        pre_a_reales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pre_a_reales.setForeground(new java.awt.Color(0, 102, 51));
        pre_a_reales.setText("pre_a");
        jPanel1.add(pre_a_reales, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 130, 30));

        pre_b_reales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pre_b_reales.setForeground(new java.awt.Color(0, 102, 51));
        pre_b_reales.setText("pre_b");
        jPanel1.add(pre_b_reales, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 140, 30));

        pre_minimo_reales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pre_minimo_reales.setForeground(new java.awt.Color(0, 102, 51));
        pre_minimo_reales.setText("pre_minimo");
        jPanel1.add(pre_minimo_reales, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 130, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 550, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 550, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 550, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(costos_monedas_vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(costos_monedas_vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(costos_monedas_vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(costos_monedas_vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                costos_monedas_vistas dialog = new costos_monedas_vistas(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_dolar;
    private javax.swing.JLabel lbl_r;
    private javax.swing.JLabel pre_a_dolar;
    private javax.swing.JLabel pre_a_reales;
    private javax.swing.JLabel pre_b_dolar;
    private javax.swing.JLabel pre_b_reales;
    private javax.swing.JLabel pre_minimo_dolar;
    private javax.swing.JLabel pre_minimo_reales;
    private javax.swing.JLabel txt_pre_a;
    private javax.swing.JLabel txt_pre_ata;
    private javax.swing.JLabel txt_pre_b;
    // End of variables declaration//GEN-END:variables

    void cargar() {
        String mostrar = "SELECT * FROM cotizaciones ORDER BY cot_fecha ASC";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {

                lbl_r.setText(rs.getString(3));
                lbl_dolar.setText(rs.getString(5));
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(costos_monedas_vistas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularPreA() {

        String real = "0", dolar = "0";

        BigDecimal ValorGuaranies = ingreso.TransformReales(txt_pre_a.getText().replaceAll("\\s", ""));
        BigDecimal ValorGuaranies2 = ingreso.TransformReales(txt_pre_a.getText().replaceAll("\\s", ""));

        BigDecimal ValorDolar = ingreso.TransformReales(lbl_dolar.getText().replaceAll("\\s", ""));
        BigDecimal ValorReal = ingreso.TransformReales(lbl_r.getText().replaceAll("\\s", ""));

        real = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies.divide(ValorReal, 2, RoundingMode.HALF_UP).toString());

        dolar = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies2.divide(ValorDolar, 2, RoundingMode.HALF_UP).toString());
        pre_a_reales.setText(real);
        pre_a_dolar.setText(dolar);

    }

    public void calcularPreB() {

        String real = "0", dolar = "0";

        BigDecimal ValorGuaranies = ingreso.TransformReales(txt_pre_b.getText().replaceAll("\\s", ""));
        BigDecimal ValorGuaranies2 = ingreso.TransformReales(txt_pre_b.getText().replaceAll("\\s", ""));

        BigDecimal ValorDolar = ingreso.TransformReales(lbl_dolar.getText().replaceAll("\\s", ""));
        BigDecimal ValorReal = ingreso.TransformReales(lbl_r.getText().replaceAll("\\s", ""));

        real = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies.divide(ValorReal, 2, RoundingMode.HALF_UP).toString());

        dolar = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies2.divide(ValorDolar, 2, RoundingMode.HALF_UP).toString());
        pre_b_dolar.setText(real);
        pre_b_reales.setText(dolar);

    }

    public void calcularPreMInimo() {

        String real = "0", dolar = "0";

        BigDecimal ValorGuaranies = ingreso.TransformReales(txt_pre_ata.getText().replaceAll("\\s", ""));
        BigDecimal ValorGuaranies2 = ingreso.TransformReales(txt_pre_ata.getText().replaceAll("\\s", ""));

        BigDecimal ValorDolar = ingreso.TransformReales(lbl_dolar.getText().replaceAll("\\s", ""));
        BigDecimal ValorReal = ingreso.TransformReales(lbl_r.getText().replaceAll("\\s", ""));

        real = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies.divide(ValorReal, 2, RoundingMode.HALF_UP).toString());

        dolar = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies2.divide(ValorDolar, 2, RoundingMode.HALF_UP).toString());
        pre_minimo_dolar.setText(real);
        pre_minimo_reales.setText(dolar);

    }

}
