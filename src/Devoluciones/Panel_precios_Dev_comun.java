/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devoluciones;

import Conexion_DB.conectar;
import static Devoluciones.Productos_Dev_comun.cod_pro_dev_comun;
import static Loggin_Principal.NECTTIC.ingreso;
import static Loggin_Principal.Principal.lbl_mone_def;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Panel_precios_Dev_comun extends javax.swing.JDialog {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public Panel_precios_Dev_comun(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_porcento.setVisible(false);

        BuscarProductoEditar(cod_pro_dev_comun);


        /*if (lbl_surcusal_id.getText().equals("0000002")) {
         BuscarProductoEditar_2(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000003")) {
         BuscarProductoEditar_3(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000004")) {
         BuscarProductoEditar_4(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000005")) {
         BuscarProductoEditar_5(cod_pro_ventas);

         }

         ///
         if (lbl_surcusal_id.getText().equals("0000006")) {
         BuscarProductoEditar_6(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000007")) {
         BuscarProductoEditar_7(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000008")) {
         BuscarProductoEditar_8(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000009")) {
         BuscarProductoEditar_9(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000010")) {
         BuscarProductoEditar_10(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000011")) {
         BuscarProductoEditar_11(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000012")) {
         BuscarProductoEditar_12(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000013")) {
         BuscarProductoEditar_13(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000014")) {
         BuscarProductoEditar_14(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000015")) {
         BuscarProductoEditar_15(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000016")) {
         BuscarProductoEditar_16(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000017")) {
         BuscarProductoEditar_17(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000018")) {
         BuscarProductoEditar_18(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000019")) {
         BuscarProductoEditar_19(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000020")) {
         BuscarProductoEditar_20(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000021")) {
         BuscarProductoEditar_21(cod_pro_ventas);

         }

         if (lbl_surcusal_id.getText().equals("0000022")) {
         BuscarProductoEditar_22(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000023")) {
         BuscarProductoEditar_23(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000024")) {
         BuscarProductoEditar_24(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000025")) {
         BuscarProductoEditar_25(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000026")) {
         BuscarProductoEditar_26(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000027")) {
         BuscarProductoEditar_27(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000028")) {
         BuscarProductoEditar_28(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000029")) {
         BuscarProductoEditar_29(cod_pro_ventas);

         }
         if (lbl_surcusal_id.getText().equals("0000030")) {
         BuscarProductoEditar_30(cod_pro_ventas);

         }*/
        txt_cod.setDisabledTextColor(Color.blue);
        txt_pro.setDisabledTextColor(Color.blue);

        txt_pre.requestFocus();
        // txt_pre_ata.setVisible(false);
        ///new deposito

    }

    public static String cod_pro = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_pre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_pro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_pre_a = new javax.swing.JLabel();
        txt_pre_ata = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        btn_agregar_item = new javax.swing.JButton();
        lbl_precio_b = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_porcento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        txt_pre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_preKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_preKeyReleased(evt);
            }
        });
        jPanel1.add(txt_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 150, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        txt_pro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pro.setEnabled(false);
        jPanel1.add(txt_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 540, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Mínimo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, 30));

        txt_pre_a.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pre_a.setForeground(new java.awt.Color(153, 0, 51));
        txt_pre_a.setText("0");
        jPanel1.add(txt_pre_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 110, 30));

        txt_pre_ata.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pre_ata.setForeground(new java.awt.Color(153, 0, 51));
        txt_pre_ata.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_pre_ata.setText("0");
        txt_pre_ata.setFocusable(false);
        jPanel1.add(txt_pre_ata, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Código:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        txt_cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cod.setEnabled(false);
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 150, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("P. Unitario:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        txt_cant.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantKeyPressed(evt);
            }
        });
        jPanel1.add(txt_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 90, 30));

        btn_agregar_item.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregar_item.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_agregar_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        btn_agregar_item.setText("Agregar");
        btn_agregar_item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_itemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 120, 50));

        lbl_precio_b.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_precio_b.setForeground(new java.awt.Color(153, 0, 51));
        lbl_precio_b.setText("0");
        jPanel1.add(lbl_precio_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 90, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Precio venta:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Precio B*:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, 30));
        jPanel1.add(txt_porcento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 80, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 220));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_preKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preKeyPressed
        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {

            txt_cant.requestFocus();

        }
    }//GEN-LAST:event_txt_preKeyPressed

    private void txt_cantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantKeyPressed

        char Tecla = evt.getKeyChar();
        if (Tecla == KeyEvent.VK_ENTER) {
            btn_agregar_item.doClick();

        }

    }//GEN-LAST:event_txt_cantKeyPressed

    private void txt_preKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preKeyReleased
        ActivatedYourLife(txt_pre, evt);


    }//GEN-LAST:event_txt_preKeyReleased

    private void btn_agregar_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_itemActionPerformed

        DefaultTableModel tabladet = (DefaultTableModel) Devolucion_Devoluciones.tb_factura_dev.getModel();
        String[] dato = new String[5];
        int c = 0;
        int j = 0;
        String id = txt_cod.getText();
        String des = txt_pro.getText();
        String cant = txt_cant.getText();
        String pre = txt_pre.getText();

        for (int i = 0; i < Devolucion_Devoluciones.tb_factura_dev.getRowCount(); i++) {
            Object com = Devolucion_Devoluciones.tb_factura_dev.getValueAt(i, 0);
            if (id.equals(com)) {
                j = i;
                Devolucion_Devoluciones.tb_factura_dev.setValueAt(cant, i, 3);
                Devolucion_Devoluciones.btncalcular.doClick();
                c = c + 1;

                JOptionPane.showMessageDialog(this, "Item ya agregado, Solo se modificará la cantidad");
                this.dispose();
            }
        }
        if (c == 0) {
            dato[0] = id;
            dato[1] = des;
            dato[2] = pre;
            dato[3] = cant;

            tabladet.addRow(dato);

            Devolucion_Devoluciones.tb_factura_dev.setModel(tabladet);

            Devolucion_Devoluciones.btncalcular.doClick();
            this.dispose();
        }


    }//GEN-LAST:event_btn_agregar_itemActionPerformed

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
            java.util.logging.Logger.getLogger(Panel_precios_Dev_comun.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel_precios_Dev_comun.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel_precios_Dev_comun.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel_precios_Dev_comun.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Panel_precios_Dev_comun dialog = new Panel_precios_Dev_comun(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btn_agregar_item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_precio_b;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JLabel txt_porcento;
    private javax.swing.JTextField txt_pre;
    private javax.swing.JLabel txt_pre_a;
    private javax.swing.JLabel txt_pre_ata;
    private javax.swing.JTextField txt_pro;
    // End of variables declaration//GEN-END:variables

    void BuscarProductoEditar(String cod) {

        try {

            String iva = "", pre_a = "", codi = "", des = "", pre_b = "", stock = "", pre_ataca = "", desc = "";
            Connection cn = conectar.getInstance().getConnection();

            String sql = "select p.pro_cod,p.pro_des,p.pro_iva,p.pro_pre_a,p.pro_pre_b,p.pro_pre_atacado,p.pro_alma, p.pro_cant, d.descto_dep from tienda_productos as p inner join depar_productos as d on p.pro_depa=d.cod_dep where p.pro_cod='" + cod + "'";
            //String cons = "select * from tienda_productos WHERE pro_cod='" + cod + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                des = rs.getString("pro_des");
                codi = rs.getString("pro_cod");
                stock = ("0");
                pre_a = rs.getString("pro_pre_a");
                pre_b = rs.getString("pro_pre_b");
                pre_ataca = rs.getString("pro_pre_atacado");
                iva = rs.getString("pro_iva");

            }
            txt_cod.setText(codi);
            txt_pro.setText(des);
            txt_pre_a.setText(pre_a);
            txt_pre.setText(pre_a);
            txt_pre.setText(pre_a);
            lbl_precio_b.setText(pre_b);
            txt_pre_ata.setVisible(false);
            conectar.getInstance().closeConnection(cn);

            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
                    this.txt_pre.setText(
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
            String Texting = txt_pre.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_pre.setText(Integrated);
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

    public void control_mini_venta() {

        // totalpre = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(pre_venta.add(pre_minimo).toString());
        //  lbl_total_monto_iva.setText(totalsub);
    }

    public void calcular_SaldoO() {

        String totalCuentaD = "0";
        BigDecimal ValorTotal = ingreso.TransformReales(txt_pre.getText());
        BigDecimal ValorGanancia = ingreso.TransformReales(txt_porcento.getText());
        totalCuentaD = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ValorTotal.subtract(ValorGanancia).toString());

        txt_pre.setText(totalCuentaD);

    }

}
