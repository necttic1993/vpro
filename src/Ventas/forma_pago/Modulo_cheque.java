package Ventas.forma_pago;

import Administrativo.bancos.Lista_bancos;
import Conexion_DB.conectar;
import static Loggin_Principal.Principal.lbl_mone_def;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Modulo_cheque extends javax.swing.JDialog {

    /**
     * Creates new form Departamentos
     */
    public Modulo_cheque(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //txt_entra_efect.requestFocus();

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
        txt_entra_efect = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txt_nro_banco = new javax.swing.JTextField();
        txt_des_banco = new javax.swing.JTextField();
        txt_nro_cheque = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btn_add_banco = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cb_tipo_ch = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_entra_efect.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_entra_efect.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_entra_efect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txt_entra_efect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_entra_efectMouseClicked(evt);
            }
        });
        txt_entra_efect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_entra_efectActionPerformed(evt);
            }
        });
        txt_entra_efect.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_entra_efectKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_entra_efectKeyReleased(evt);
            }
        });
        jPanel1.add(txt_entra_efect, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 200, 30));

        btn_add.setBackground(new java.awt.Color(255, 255, 255));
        btn_add.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/plus.png"))); // NOI18N
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 60, 50));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("Nro Banco:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        txt_nro_banco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_nro_banco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txt_nro_banco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nro_banco.setEnabled(false);
        jPanel1.add(txt_nro_banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 80, 29));

        txt_des_banco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_des_banco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txt_des_banco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_des_banco.setEnabled(false);
        jPanel1.add(txt_des_banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 270, 29));

        txt_nro_cheque.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_nro_cheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nro_cheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.add(txt_nro_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 200, 29));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Nro Cheque:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Clasificación:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));

        btn_add_banco.setBackground(new java.awt.Color(255, 255, 255));
        btn_add_banco.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_add_banco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        btn_add_banco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_add_banco.setBorderPainted(false);
        btn_add_banco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add_banco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_bancoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add_banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 5, 50, 40));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("Monto:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        cb_tipo_ch.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_tipo_ch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL DÍA", "DIFERIDO", "CRUZADO" }));
        jPanel1.add(cb_tipo_ch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        DefaultTableModel tabladet = (DefaultTableModel) Forma_pago_gral.tb_pagos.getModel();
        String[] dato = new String[11];

        String id = txt_nro_cheque.getText();
        String tipo = ("CHEQUE");
        String pago_contexto = txt_des_banco.getText();
        String clasificacion = (String) cb_tipo_ch.getSelectedItem();
        String efec = txt_entra_efect.getText();

        dato[0] = id;
        dato[1] = tipo;
        dato[2] = pago_contexto;
        dato[3] = clasificacion;
        dato[4] = efec;

        tabladet.addRow(dato);

        Forma_pago_gral.tb_pagos.setModel(tabladet);
        Forma_pago_gral.btn_calc.doClick();
        this.dispose();


    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_entra_efectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_entra_efectMouseClicked
        txt_entra_efect.setText("");
    }//GEN-LAST:event_txt_entra_efectMouseClicked

    private void txt_entra_efectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_entra_efectActionPerformed

    }//GEN-LAST:event_txt_entra_efectActionPerformed

    private void txt_entra_efectKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_entra_efectKeyReleased
        ActivatedYourLife_efect(txt_entra_efect, evt);

    }//GEN-LAST:event_txt_entra_efectKeyReleased

    private void txt_entra_efectKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_entra_efectKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            btn_add.doClick();
        }
    }//GEN-LAST:event_txt_entra_efectKeyPressed

    private void btn_add_bancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_bancoActionPerformed
        Lista_bancos lbs;
        lbs = new Lista_bancos(new javax.swing.JDialog(), true);
        lbs.setVisible(true);
    }//GEN-LAST:event_btn_add_bancoActionPerformed

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
            java.util.logging.Logger.getLogger(Modulo_cheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulo_cheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulo_cheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulo_cheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Modulo_cheque dialog = new Modulo_cheque(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add_banco;
    private javax.swing.JComboBox cb_tipo_ch;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txt_des_banco;
    private javax.swing.JTextField txt_entra_efect;
    public static javax.swing.JTextField txt_nro_banco;
    private javax.swing.JTextField txt_nro_cheque;
    // End of variables declaration//GEN-END:variables
 

    public String ActivatedYourLife_efect(JTextField CampoTexto, java.awt.event.KeyEvent evt) {
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
                    this.txt_entra_efect.setText(
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
            String Texting = txt_entra_efect.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_entra_efect.setText(Integrated);
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

}
