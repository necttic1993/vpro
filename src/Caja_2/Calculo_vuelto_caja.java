/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caja_2;

import static Caja_2.Caja_ventas_contado.cod_venta_vuelto;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Calculo_vuelto_caja extends javax.swing.JDialog {

    long OL;
    int KeyCodeGlobal = 0, Consumio = 0;
    public String Rizon = "", BienFormatado2, Preview2 = "";

    public Calculo_vuelto_caja(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbl_moneda.setVisible(false);
        lbl_r.setVisible(false);
        lbl_dolar.setVisible(false);
        txt_vuelto.requestFocus();
        txt_pre_total.setDisabledTextColor(Color.BLUE);
        calcularG();
        calcularMoneda();
        txt_pre_total.setText(cod_venta_vuelto);
    }

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
            Logger.getLogger(Calculo_vuelto_caja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void calcularG() {

        BigDecimal PulidoPrec = ingreso.TransformReales(txt_pre_total.getText().replaceAll("\\s", ""));
        BigDecimal PulidoCant = ingreso.TransformReales(txt_vuelto.getText().replaceAll("\\s", ""));
        BigDecimal imp = (PulidoCant.subtract(PulidoPrec));
        // BigDecimal a = imp.setScale(2, RoundingMode.HALF_DOWN);
        txt_total_vuelto.setText(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)));

    }

    public void calcularMoneda() {

        String real = "0", dolar = "0";

        BigDecimal ValorGuaranies = ingreso.TransformReales(txt_total_vuelto.getText().replaceAll("\\s", ""));
        BigDecimal ValorGuaranies2 = ingreso.TransformReales(txt_total_vuelto.getText().replaceAll("\\s", ""));
        BigDecimal ValorDolar = ingreso.TransformReales(lbl_dolar.getText().replaceAll("\\s", ""));
        BigDecimal ValorReal = ingreso.TransformReales(lbl_r.getText().replaceAll("\\s", ""));

        real = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies.divide(ValorReal, 2, RoundingMode.HALF_UP).toString());

        dolar = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorGuaranies2.divide(ValorDolar, 2, RoundingMode.HALF_UP).toString());
        lbl_vuelto_rs.setText(real);
        lbl_vuelto_ds.setText(dolar);

    }//FIN METODO public vo

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_total_vuelto = new javax.swing.JLabel();
        txt_pre_total = new javax.swing.JTextField();
        txt_vuelto = new javax.swing.JTextField();
        lbl_moneda = new javax.swing.JLabel();
        lbl_r = new javax.swing.JLabel();
        lbl_dolar = new javax.swing.JLabel();
        lbl_vuelto_rs = new javax.swing.JLabel();
        lbl_vuelto_ds = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vuelto");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("En Dolares:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, 30));

        txt_total_vuelto.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txt_total_vuelto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_total_vuelto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/paraguay.png"))); // NOI18N
        txt_total_vuelto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(txt_total_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 200, 30));

        txt_pre_total.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_pre_total.setForeground(new java.awt.Color(0, 102, 102));
        txt_pre_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pre_total.setEnabled(false);
        jPanel1.add(txt_pre_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 300, 40));

        txt_vuelto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_vuelto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_vuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vueltoActionPerformed(evt);
            }
        });
        txt_vuelto.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_vueltoPropertyChange(evt);
            }
        });
        txt_vuelto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vueltoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_vueltoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 300, 40));

        lbl_moneda.setText("Guaraníes");
        jPanel1.add(lbl_moneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, -1));

        lbl_r.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_r.setText("1,365");
        jPanel1.add(lbl_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 40, 20));

        lbl_dolar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        lbl_dolar.setForeground(new java.awt.Color(0, 0, 102));
        lbl_dolar.setText("5,780");
        jPanel1.add(lbl_dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 40, 20));

        lbl_vuelto_rs.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbl_vuelto_rs.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vuelto_rs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/brasil (1).png"))); // NOI18N
        lbl_vuelto_rs.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(lbl_vuelto_rs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 200, 30));

        lbl_vuelto_ds.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbl_vuelto_ds.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vuelto_ds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_1/estados-unidos.png"))); // NOI18N
        lbl_vuelto_ds.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(lbl_vuelto_ds, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 200, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 300, 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Valor Entregado:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Valor a pagar:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("En Guaraníes:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("En Realess:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_vueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vueltoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vueltoActionPerformed

    private void txt_vueltoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vueltoKeyReleased
        ActivatedYourLife(txt_vuelto, evt);
        calcularG();
        calcularMoneda();
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txt_vueltoKeyReleased

    private void txt_vueltoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_vueltoPropertyChange

    }//GEN-LAST:event_txt_vueltoPropertyChange

    private void txt_vueltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vueltoKeyPressed
        calcularG();
        calcularMoneda();
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txt_vueltoKeyPressed

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
            java.util.logging.Logger.getLogger(Calculo_vuelto_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculo_vuelto_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculo_vuelto_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculo_vuelto_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Calculo_vuelto_caja dialog = new Calculo_vuelto_caja(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_dolar;
    private javax.swing.JLabel lbl_moneda;
    private javax.swing.JLabel lbl_r;
    private javax.swing.JLabel lbl_vuelto_ds;
    private javax.swing.JLabel lbl_vuelto_rs;
    private javax.swing.JTextField txt_pre_total;
    private javax.swing.JLabel txt_total_vuelto;
    private javax.swing.JTextField txt_vuelto;
    // End of variables declaration//GEN-END:variables

//<editor-fold defaultstate="collapsed" desc="ZONA DE METODOS GENERICOS DE LA CLASE">
    //<editor-fold defaultstate="collapsed" desc="EL ORO CU´I">

    public void ValidarCampoTexto_NoEspacioNoNumeroNoLetra(java.awt.event.KeyEvent Evento, int Signal) {
        //<editor-fold defaultstate="collapsed" desc=" ZONA DE VAR LOCAL ">        
        Character TeclaPresionada = Evento.getKeyChar();
        //</editor-fold>        
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (TeclaPresionada.toString().equals(".")) {
            //NOTHING...
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="NODO">
            if (Signal == 1) {
                //<editor-fold defaultstate="collapsed" desc=" DENEGA ACCESO DE NUMEROS Y ESPACIO EN BLANCO">
                //|| TeclaPresionada.isSpaceChar( TeclaPresionada )
                if (Character.isDigit(TeclaPresionada)) {
                    Evento.consume();
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            else {
                //<editor-fold defaultstate="collapsed" desc=" DENEGA ACCESO DE ESPACIO EN BLANCO Y DELETE BUTTON ">
                if ((Character.isSpaceChar(TeclaPresionada)
                        || TeclaPresionada == Evento.VK_DELETE
                        || Character.isLetter(TeclaPresionada))
                        && Signal != 7) {
                    Evento.consume();
                }// FIN IF
                //</editor-fold>
            }// FIN ELSE
            if (Signal == 7 && Character.isSpaceChar(TeclaPresionada)) {
                //<editor-fold defaultstate="collapsed" desc=" DENEGA ESPACIO EN BLANCO ">
                Evento.consume();
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
        }// FIN ELSE
        //</editor-fold>        
    }// FIN METODO        

    public BigDecimal TransformReales(String NumeroBruto) {
        //SEGURIDAD.-
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (NumeroBruto.replaceAll("\\s", "").isEmpty()) {
            NumeroBruto = "0";
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="IF">
        NumeroBruto = NumeroBruto.replaceAll("\\s", "");
        BigDecimal Convertido = new BigDecimal("0");
        if (NumeroBruto.contains(".")) {
            String ParteEntero = NumeroBruto.substring(0, NumeroBruto.indexOf("."));
            String ParteFracciones = NumeroBruto.substring(NumeroBruto.indexOf(".") + 1, NumeroBruto.length());
            //DETERMINAR CANTIDAD DE DECIMAS.-
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ParteFracciones.length() > 3) {
                ParteFracciones = ParteFracciones.substring(0, 3);
            }// FIN IF
            //</editor-fold>
            ParteEntero = ParteEntero.replaceAll("\\s", "").replaceAll("[^0-9]", "");
            String Unity = ParteEntero + "." + ParteFracciones;
            Convertido = new BigDecimal(Unity);
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            Convertido = new BigDecimal(NumeroBruto.replaceAll("[^0-9]", ""));
        }// FIN ELSE
        //</editor-fold>
        return Convertido;
    }// FIN 1º METODO    

    public String MaskareaRealesDado_String_Hibrid_MedidasMonedas(String ValorBruto) {
        String ReadyMasketed = "0";
        ValorBruto = ValorBruto.replaceAll("\\s", "");
        int Tot = ValorBruto.length();
        //<editor-fold defaultstate="collapsed" desc="IF">
        if ( //<editor-fold defaultstate="collapsed" desc="AVOIDING ZERO">
                (Tot == 0
                && ValorBruto.equals("0"))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING ,(COMA)">
                (Tot == 0
                && ValorBruto.equals(","))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING .(DECIMAL POINT, INCEPTION)">
                (Tot == 0
                && ValorBruto.equals(".")) //</editor-fold>        
                ) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ValorBruto.replaceAll("\\s", "").isEmpty() || ValorBruto.replaceAll("\\s", "").equals("-")) {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (ValorBruto.replaceAll("\\s", "").equals("-")) {
                    return "-";
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (!ValorBruto.replaceAll("\\s", "").contains(".")) {
                    ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
                }// FIN IF
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="ELSE">
                else {
                    String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                    String WholePartFormated = MaskaraEnteros(WholePart);
                    String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (FractionalPart.length() > 3) {
                        FractionalPart = FractionalPart.substring(0, 3);
                    }// FIN IF
                    //</editor-fold>
                    ReadyMasketed = WholePartFormated + "." + FractionalPart;
                }// FIN ELSE
                //</editor-fold>                    
            }// FIN ELSE
            //</editor-fold>        
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO     

    public String MaskareaRealesDado_String_ExclusiveMonedas(String ValorBruto) {
        String ReadyMasketed = "0";
        ValorBruto = ValorBruto.replaceAll("\\s", "");
        int Tot = ValorBruto.length();
        //<editor-fold defaultstate="collapsed" desc="IF">
        if ( //<editor-fold defaultstate="collapsed" desc="AVOIDING ZERO">
                (Tot == 0
                && ValorBruto.equals("0"))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING ,(COMA)">
                (Tot == 0
                && ValorBruto.equals(","))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING .(DECIMAL POINT, INCEPTION)">
                (Tot == 0
                && ValorBruto.equals(".")) //</editor-fold>        
                ) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ValorBruto.replaceAll("\\s", "").isEmpty() || ValorBruto.replaceAll("\\s", "").equals("-")) {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (ValorBruto.replaceAll("\\s", "").equals("-")) {
                    return "-";
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (!ValorBruto.replaceAll("\\s", "").contains(".")) {
                    ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
                }// FIN IF
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="ELSE">
                else {
                    String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                    String WholePartFormated = MaskaraEnteros(WholePart);
                    String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (FractionalPart.length() > 2) {
                        FractionalPart = FractionalPart.substring(0, 2);
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    String PrimerDecimal = FractionalPart.substring(0, 1).replaceAll("\\s", "");
                    if (PrimerDecimal.equals("0")) {
                        ReadyMasketed = WholePartFormated;
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="ELSE">
                    else {
                        ReadyMasketed = WholePartFormated + "." + FractionalPart;
                    }// FIN ELSE
                    //</editor-fold>  
                }// FIN ELSE
                //</editor-fold>                    
            }// FIN ELSE
            //</editor-fold>        
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO          

    public String MaskareaRealesDado_String_ExclusiveMedidas(String ValorBruto) {
        String ReadyMasketed = "0";
        ValorBruto = ValorBruto.replaceAll("\\s", "");
        int Tot = ValorBruto.length();
        //<editor-fold defaultstate="collapsed" desc="IF">
        if ( //<editor-fold defaultstate="collapsed" desc="AVOIDING ZERO">
                (Tot == 0
                && ValorBruto.equals("0"))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING ,(COMA)">
                (Tot == 0
                && ValorBruto.equals(","))
                //</editor-fold>
                || //<editor-fold defaultstate="collapsed" desc="AVOIDING .(DECIMAL POINT, INCEPTION)">
                (Tot == 0
                && ValorBruto.equals(".")) //</editor-fold>        
                ) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (ValorBruto.replaceAll("\\s", "").isEmpty() || ValorBruto.replaceAll("\\s", "").equals("-")) {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (ValorBruto.replaceAll("\\s", "").equals("-")) {
                    return "-";
                }// FIN IF
                //</editor-fold>
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (!ValorBruto.replaceAll("\\s", "").contains(".")) {
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (ValorBruto.contains("E")) {
                        ReadyMasketed = "0";
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="ELSE">
                    else {
                        ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
                    }// FIN ELSE
                    //</editor-fold>                    
                }// FIN IF
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="ELSE">
                else {
                    String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                    String WholePartFormated = MaskaraEnteros(WholePart);
                    String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (FractionalPart.length() > 3) {
                        FractionalPart = FractionalPart.substring(0, 3);
                    }// FIN IF
                    //</editor-fold>
                    // DOS DECIMAL EXTRACT.-
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    int TotaDecimals = FractionalPart.length();
                    String PrimerDecimal = FractionalPart.substring(0, 1).replaceAll("\\s", "");
                    String SegDecimal = "";
                    if (TotaDecimals > 1 && TotaDecimals < 3) {
                        SegDecimal = FractionalPart.substring(1, 2).replaceAll("\\s", "");
                        //<editor-fold defaultstate="collapsed" desc="IF">
                        if (PrimerDecimal.equals("0")
                                && SegDecimal.equals("0")) {
                            ReadyMasketed = WholePartFormated;
                        }// FINIF 
                        //</editor-fold>                                
                        //<editor-fold defaultstate="collapsed" desc="ELSE">
                        else {
                            ReadyMasketed = WholePartFormated + "." + FractionalPart;
                        }// FIN ELSE
                        //</editor-fold>                                                 
                    }// FIN IF
                    //</editor-fold>                         
                    // UN DECIMAL EXTRACT.-
                    //<editor-fold defaultstate="collapsed" desc="IF">
                    if (PrimerDecimal.equals("0")
                            && TotaDecimals < 2) {
                        ReadyMasketed = WholePartFormated;
                    }// FINIF 
                    //</editor-fold>                                
                    //<editor-fold defaultstate="collapsed" desc="ELSE">
                    else {
                        ReadyMasketed = WholePartFormated + "." + FractionalPart;
                    }// FIN ELSE
                    //</editor-fold>                       
                }// FIN ELSE
                //</editor-fold>                    
            }// FIN ELSE
            //</editor-fold>        
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO          

    public String MaskareaRealesDado_BigDecimal(BigDecimal ValorBruto) {
        String ReadyMasketed = "0";
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (ValorBruto.toString().replaceAll("\\s", "").length() == 1 && (ValorBruto.equals(".") || ValorBruto.equals(","))) {
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (!ValorBruto.toString().replaceAll("\\s", "").contains(".")) {
                ReadyMasketed = MaskaraEnteros(ValorBruto.toString().replaceAll("\\s", ""));
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                String WholePart = ValorBruto.toString().replaceAll("\\s", "").substring(0, ValorBruto.toString().replaceAll("\\s", "").indexOf("."));
                String WholePartFormated = MaskaraEnteros(WholePart);
                String FractionalPart = ValorBruto.toString().replaceAll("\\s", "").substring(ValorBruto.toString().replaceAll("\\s", "").indexOf(".") + 1, ValorBruto.toString().replaceAll("\\s", "").length());
                //<editor-fold defaultstate="collapsed" desc="IF">
                if (FractionalPart.length() > 3) {
                    FractionalPart = FractionalPart.substring(0, 3);
                }// FIN IF
                //</editor-fold>
                ReadyMasketed = WholePartFormated + "." + FractionalPart;
            }// FIN ELSE
            //</editor-fold>            
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO    

    public String MaskareaRealesDadoCampoTexto(JFormattedTextField CampoSelected, java.awt.event.KeyEvent evt) {
        String DigitedText = CampoSelected.getText().replaceAll("\\s", "");
        String ReadyMasketed = "";
        //<editor-fold defaultstate="collapsed" desc="IF">
        if (!DigitedText.contains(".")) {
            CampoSelected.setText(MaskaraEnteros(DigitedText));
            ReadyMasketed = MaskaraEnteros(DigitedText);
            CampoSelected.setCaretPosition(CampoSelected.getText().length());
        }// FIN IF
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ELSE">
        else {
            String WholePart = DigitedText.substring(0, DigitedText.indexOf("."));
            String WholePartFormated = MaskaraEnteros(WholePart);
            String FractionalPart = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
            //<editor-fold defaultstate="collapsed" desc="IF">
            if (FractionalPart.length() > 3) {
                FractionalPart = FractionalPart.substring(0, 3);
            }// FIN IF
            //</editor-fold>
            CampoSelected.setText(WholePartFormated + "." + FractionalPart);
            ReadyMasketed = WholePartFormated + "." + FractionalPart;
            CampoSelected.setCaretPosition(CampoSelected.getText().length());
        }// FIN ELSE
        //</editor-fold>
        return ReadyMasketed;
    }// FIN 1º METODO

    public String MaskaraEnteros(String ValorGuaranies) {
        //<editor-fold defaultstate="collapsed" desc="IF">        
        ValorGuaranies = ValorGuaranies.replaceAll("\\s", "").replaceAll("\\D", "");
        if (ValorGuaranies.contains(".")) {
            BigDecimal Rounder = new BigDecimal(ValorGuaranies);
            Rounder = Rounder.setScale(0, BigDecimal.ROUND_HALF_UP);
            ValorGuaranies = Rounder.toString();
            if (ValorGuaranies.contains(".")) {
                ValorGuaranies = ValorGuaranies.substring(0, ValorGuaranies.indexOf("."));
            }
        }// FIN IF
        //</editor-fold>        
        DecimalFormat Formato = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String Puro = ValorViejo.replace(",", "");
        NumeroIntacto = Long.valueOf(Puro).longValue();
        NroFormatado = Formato.format(NumeroIntacto);
        String ReadyToExhibit = NroFormatado;
        ReadyToExhibit = ReadyToExhibit.replace(".", ",");
        return ReadyToExhibit;
    }// FIN METODO

    public String ActivatedYourLife(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
        String Retorno = "";
        //<editor-fold defaultstate="collapsed" desc="ACTIONS">
        //<editor-fold defaultstate="collapsed" desc="CLOSER EYES">  
        int KeyCode = evt.getKeyCode();
        if ( //<editor-fold defaultstate="collapsed" desc="PARAMS">
                (KeyCode >= 48 // 48  = VK_0
                && KeyCode <= 57 // 57  = VK_9                
                )
                || (KeyCode >= 96 // 96  = VK_NUMPAD0
                && KeyCode <= 105// 105 = VK_NUMPAD9
                )
                || KeyCode == 8 // 8   = VK_BACK_SPACE
                || KeyCode == 46 // 46  = PUNTO DECIMAL
                //</editor-fold>                        
                ) {
            //<editor-fold defaultstate="collapsed" desc="ACTIONS">
            //<editor-fold defaultstate="collapsed" desc="SECURE ALPHA">
            //<editor-fold defaultstate="collapsed" desc="IF">
            String DigitedText = CampoTexto.getText().replaceAll("\\s", "");
            if (DigitedText.isEmpty()
                    || KeyCode == 44) {
                // NO HACE NADA.-
            }// FIN IF
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ELSE">
            else {
                //<editor-fold defaultstate="collapsed" desc="MSK">            
                String Tag = this.lbl_moneda.getText().replaceAll("\\s", "").toLowerCase();
                if (!Tag.equals("guaraníes")) {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS CON NROS ENTEROS Y QUE TAMBIEN TENGA PARTE FRACCIONARIA">
                    /*
                     POR EJEMPLO REAL BRASILERO O DOLAR 
                     QUE SI POSEE APARTE DEL ENTERO, TAMBIEN LA PARTE FRACCIONARIA.-
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     2,000.99 $
                     O
                     5.25 R$
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-                
                     */
                    //<editor-fold defaultstate="collapsed" desc="CUENTA CUANTOS PUNTOS DECIMALES INGRESO EL USER">
                    int PointCounter = 0, i = 0;
                    while (i < DigitedText.length()) {
                        Object CharacterByCharacter = DigitedText.charAt(i);
                        if (CharacterByCharacter.toString().equals(".")) {
                            PointCounter = PointCounter + 1;
                            if (PointCounter == 2) {
                                i = i + DigitedText.length();
                            }//FIN IF
                        }//FIN IF                    
                        i++;
                    }// FIN WHILE
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="CASO INGRESE DOS PUNTOS DE SEGUIDO">
                    if (PointCounter == 2) {
                        String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                        Entera = Entera.replaceAll("\\s", "");
                        if (Entera.isEmpty() && KeyCode != 46) {
                            CampoTexto.setCaretPosition(Entera.length());
                        }//FIN IF
                        else {
                            if (Entera.isEmpty() && KeyCode == 46) {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                String ReIntegrated = "." + Fraccion;
                                CampoTexto.setText(ReIntegrated);
                                int Lenght = ReIntegrated.substring(0, ReIntegrated.indexOf(".")).length();
                                CampoTexto.setCaretPosition(Lenght);
                                //</editor-fold>
                            }//FIN IF
                            else {
                                //<editor-fold defaultstate="collapsed" desc="ACTIONS">
                                String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                                if (Fraccion.isEmpty()) {
                                    Fraccion = "00";
                                }//FIN IF
                                if (Fraccion.length() >= 3) {
                                    Fraccion = Fraccion.substring(0, 2);
                                }//FIN IF                                   
                                String ReIntegrated = Entera + ".";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(ReIntegrated.length());
                                //</editor-fold>
                            }//FIN ELSE
                        }//FIN ELSE
                    }// FIN IF
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="INGRESO DE PUNTOS DECIMALES - DOS CASOS">
                    else {
                        //<editor-fold defaultstate="collapsed" desc="CASO 1 - INGRESO PRIMERA VEZ EL PUNTO DECIMAL">
                        if (PointCounter == 1 && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                            String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                            String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                            Entera = MaskaraEnteros(Entera);
                            Fraccion = Fraccion.replace(".", "").replaceAll("\\s", "");
                            if (Fraccion.length() >= 3) {
                                Fraccion = Fraccion.substring(0, 2);
                            }//FIN IF
                            String ReIntegrated = Entera + "." + Fraccion;
                            CampoTexto.setText(ReIntegrated);
                            if (Fraccion.length() == 2) {
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF
                            else {
                                if (Fraccion.length() != 2) {
                                    CampoTexto.setCaretPosition(ReIntegrated.length());
                                }//FIN IF                            
                            }//FIN ELSE
                        }//FIN IF
                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc="CASO 2">
                        else {
                            //<editor-fold defaultstate="collapsed" desc="PRESIONO BACK_SPACE Y YA HAY UN PUNTO DECIMAL">
                            if (PointCounter == 1
                                    && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                if (DigitedText.contains(".")) {
                                    String Entera = DigitedText.substring(0, DigitedText.indexOf("."));
                                    Entera = MaskaraEnteros(Entera);
                                    String Fraccion = DigitedText.substring(DigitedText.indexOf(".") + 1, DigitedText.length());
                                    if (Fraccion.length() >= 3) {
                                        Fraccion = Fraccion.substring(0, 2);
                                    }//FIN IF
                                    String ReIntegrated = Entera + "." + Fraccion;
                                    CampoTexto.setText(ReIntegrated);
                                    if (Fraccion.length() == 2) {
                                        CampoTexto.setCaretPosition(Entera.length());
                                    }//FIN IF
                                    else {
                                        if (Fraccion.length() != 2) {
                                            CampoTexto.setCaretPosition(ReIntegrated.length());
                                        }//FIN IF                            
                                    }//FIN ELSE                                
                                }//FIN IF                                    
                            }// FIN IF
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="CASO 2 - INGRESO SOLO NRO ENTERO NADA DE PUNTO DECIMAL AUN">
                            if (PointCounter == 0) {
                                String Entera = DigitedText.substring(0, DigitedText.length());
                                Entera = MaskaraEnteros(Entera);
                                String ReIntegrated = Entera + ".00";
                                CampoTexto.setText(ReIntegrated);
                                CampoTexto.setCaretPosition(Entera.length());
                            }//FIN IF                    
                            //</editor-fold>                        
                        }// FIN ELSE
                        //</editor-fold>
                        //</editor-fold>
                    }// FIN ELSE
                    //</editor-fold>
                }//FIN IF
                else {
                    //<editor-fold defaultstate="collapsed" desc="PARA MONEDAS QUE SOLO POSEA NROS ENTEROS">
                    /*
                     POR EJEMPLO NUESTRO ESTIMADO GUARANI SOLO POSEE PARTE ENTERA NO TIENE FRACCIONES.- 
                     VALGA LA REDUNDANCIA EJEMPLO: 
                     10,000 Gs
                     O
                     1,500 Gs
                     RECUERDE MY FRIEND DEPENDE DEL CONOCIMIENTO DEL OBSERVADOR LA INTERPRETACION DE LOS SIGNOS, 
                     UNA INTERPRETACION VALIDA SERIA QUE LA COMA " , " FUNCIONARIA COMO SEPARADOR DE MILES
                     Y EL PUNTO " . " COMO DELIMITADOR DE LA PARTE ENTERA DE LA PARTE FRACCIONARIA.-
                     */
                    this.txt_vuelto.setText(
                            MaskaraEnteros(DigitedText)
                    );
                    //</editor-fold>
                }//FIN ELSE        
                //</editor-fold>    
            }// FIN ELSE
            //</editor-fold>    
            //</editor-fold>
            //</editor-fold>
        }//FIN IF
        else {
            //<editor-fold defaultstate="collapsed" desc="OBTIENE PARTE ENTERA Y FRACCIONES">
            String Texting = txt_vuelto.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_vuelto.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
    }// FIN 1º METODO
    //</editor-fold>   
    //</editor-fold>
}//FIN CLASE
