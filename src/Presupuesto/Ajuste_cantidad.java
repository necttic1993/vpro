/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presupuesto;

import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.lbl_mone_def;
import static Presupuesto.Presupuesto_presupuesto.cant_pro_mod_cant;
import static Presupuesto.Presupuesto_presupuesto.cod_pro_mod_cant;
import static Presupuesto.Presupuesto_presupuesto.des_pro_mod_cant;
import static Presupuesto.Presupuesto_presupuesto.id_pro_mod_cant;
import static Presupuesto.Presupuesto_presupuesto.precio_pro_mod_cant;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Ajuste_cantidad extends javax.swing.JDialog {

    /**
     * Creates new form Departamentos
     */
    public Ajuste_cantidad(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtdes.setDocument(new machusculas());
        lbl_id_pro_mof.setVisible(false);

        txt_id.setText(cod_pro_mod_cant);
        txt_nom.setText(des_pro_mod_cant);
        txtdes.setText(cant_pro_mod_cant);
        txt_precio_venta.setText(precio_pro_mod_cant);

        if (Presupuesto_presupuesto.lbl_perm_edit.getText().equals("1")) {
            lbl_id_pro_mof.setText(id_pro_mod_cant);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtdes = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_precio_venta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        lbl_id_pro_mof = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtdes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtdes.setDisabledTextColor(new java.awt.Color(153, 0, 0));
        txtdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdesKeyReleased(evt);
            }
        });
        jPanel1.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 80, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 130, 50));

        txt_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setEnabled(false);
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 120, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Subtotal:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nom.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom.setEnabled(false);
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 410, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Precio de venta:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 100, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Id Producto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        txt_precio_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_precio_venta.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_precio_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_precio_ventaKeyReleased(evt);
            }
        });
        jPanel1.add(txt_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 170, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Cantidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 30));

        txt_subtotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_subtotal.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txt_subtotal.setEnabled(false);
        jPanel1.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 130, 30));
        jPanel1.add(lbl_id_pro_mof, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 50, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 190));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Presupuesto_presupuesto.lbl_perm_edit.getText().equals("1")) {
            try {
                String id = lbl_id_pro_mof.getText();

                String preventa = txt_precio_venta.getText();
                String cantidad = txtdes.getText();
                String subtotal = txt_subtotal.getText();

                String sql = "UPDATE presupuesto_detalles SET pre_unit = '" + preventa
                        + "',cant_pro ='" + cantidad
                        + "',pre_venta ='" + subtotal
                        + "' WHERE id_pre_det = '" + id + "'";
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.getInstance().closeConnection(cn);

                    JOptionPane.showMessageDialog(null, "OK");
                    Presupuesto_presupuesto.btn_calc_modify.doClick();
                    this.dispose();

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (Exception e) {
            }
        } else {
            String id_pro = txt_id.getText();
            String des_pro = txt_nom.getText();
            String preventa = txt_precio_venta.getText();
            String cantidad = txtdes.getText();

            int c = 0;
            int j = 0;

            for (int i = 0; i < Presupuesto_presupuesto.tb_factura.getRowCount(); i++) {
                Object com = Presupuesto_presupuesto.tb_factura.getValueAt(i, 0);
                if (id_pro.equals(com)) {
                    j = i;
                    Presupuesto_presupuesto.tb_factura.setValueAt(cantidad, i, 3);
                    Presupuesto_presupuesto.tb_factura.setValueAt(preventa, i, 2);
                    Presupuesto_presupuesto.btncalcular.doClick();
                    c = c + 1;

                    JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
                    this.dispose();
                }
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_precio_ventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precio_ventaKeyReleased
        ActivatedYourLife(txt_precio_venta, evt);
        calcularSub();
    }//GEN-LAST:event_txt_precio_ventaKeyReleased

    private void txtdesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyReleased
        // TODO add your handling code here:
        calcularSub();
    }//GEN-LAST:event_txtdesKeyReleased

    private void txtdesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

            txt_precio_venta.requestFocus();

        }
    }//GEN-LAST:event_txtdesKeyPressed

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
            java.util.logging.Logger.getLogger(Ajuste_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajuste_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajuste_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajuste_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ajuste_cantidad dialog = new Ajuste_cantidad(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_id_pro_mof;
    public static javax.swing.JTextField txt_id;
    public static javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_precio_venta;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txtdes;
    // End of variables declaration//GEN-END:variables

    void limpiar() {

        txt_id.setText("");
        txt_nom.setText("");
        txtdes.setText("0");

    }

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
                String Tag = lbl_mone_def.getText().replaceAll("\\s", "").toLowerCase();
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
                    this.txt_precio_venta.setText(
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
            String Texting = txt_precio_venta.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_precio_venta.setText(Integrated);
            }//FIN IF            
            //</editor-fold>            
            //<editor-fold defaultstate="collapsed" desc="ALARMA">

            //</editor-fold>            
        }//FIN ELSE
        //</editor-fold>        
        //</editor-fold>
        return Retorno;
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
        NumeroIntacto = Long.parseLong(Puro);
        NroFormatado = Formato.format(NumeroIntacto);
        String ReadyToExhibit = NroFormatado;
        ReadyToExhibit = ReadyToExhibit.replace(".", ",");
        return ReadyToExhibit;

    }// FIN METODO

    void calcularSub() {

        BigDecimal PulidoPrec = ingreso.TransformReales(txt_precio_venta.getText().replaceAll("\\s", ""));
        BigDecimal PulidoCant = ingreso.TransformReales(txtdes.getText().replaceAll("\\s", ""));
        String imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
        txt_subtotal.setText(imp);
    }
}