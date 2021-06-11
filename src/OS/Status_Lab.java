/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS;

import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import static Loggin_Principal.Principal.lbl_mone_def;
import static OS.Principapl_OS.cod_os_actu;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Status_Lab extends javax.swing.JDialog {

    /**
     * Creates new form Departamentos
     */
    public Status_Lab(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_cod.setVisible(false);
        txt_cod.setText(cod_os_actu);
        txt_deta_os.setDocument(new machusculas());
        btncalcular.setVisible(false);
        tb_lab_pro.getColumnModel().getColumn(0).setPreferredWidth(80);
        tb_lab_pro.getColumnModel().getColumn(1).setPreferredWidth(323);
        tb_lab_pro.getColumnModel().getColumn(2).setPreferredWidth(120);
        tb_lab_pro.getColumnModel().getColumn(3).setPreferredWidth(75);
        tb_lab_pro.getColumnModel().getColumn(4).setPreferredWidth(120);
        cargarTxtos(txt_cod.getText());

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
        lbl_monto_referencia = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_cod = new javax.swing.JTextField();
        txt_valor = new javax.swing.JTextField();
        lbl_deta = new javax.swing.JLabel();
        txt_deta_os = new javax.swing.JTextField();
        txt_valor_tec = new javax.swing.JTextField();
        lbl_deta1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_lab_pro = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        txt_valor_lab = new javax.swing.JTextField();
        lbl_deta2 = new javax.swing.JLabel();
        lbl_deta3 = new javax.swing.JLabel();
        txt_id_tec = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txt_nom_tec = new javax.swing.JTextField();
        lbl_monto1 = new javax.swing.JLabel();
        lbl_des_pro_carga = new javax.swing.JLabel();
        lbl_monto3 = new javax.swing.JLabel();
        lbl_monto4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laboratorio OS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_monto_referencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_monto_referencia.setForeground(new java.awt.Color(204, 0, 51));
        lbl_monto_referencia.setText("0");
        jPanel1.add(lbl_monto_referencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 110, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 130, 50));

        txt_cod.setFocusable(false);
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 60, 20));

        txt_valor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_valor.setText("0");
        txt_valor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor.setEnabled(false);
        txt_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valorKeyReleased(evt);
            }
        });
        jPanel1.add(txt_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 140, 30));

        lbl_deta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_deta.setText("VALOR TÉCNICO:");
        jPanel1.add(lbl_deta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 100, 30));

        txt_deta_os.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel1.add(txt_deta_os, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 630, 30));

        txt_valor_tec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_tec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_valor_tec.setText("0");
        txt_valor_tec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valor_tecKeyReleased(evt);
            }
        });
        jPanel1.add(txt_valor_tec, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 150, 30));

        lbl_deta1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_deta1.setText("TÉCNICO  O.S:");
        jPanel1.add(lbl_deta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        tb_lab_pro = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_lab_pro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_lab_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio Unitario", "Unidad", "Precio Total"
            }
        ));
        tb_lab_pro.setGridColor(new java.awt.Color(255, 255, 255));
        tb_lab_pro.setRowHeight(22);
        jScrollPane1.setViewportView(tb_lab_pro);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 850, 370));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/stock.png"))); // NOI18N
        jButton2.setText("Stock");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 110, 50));

        btncalcular.setBackground(new java.awt.Color(255, 255, 255));
        btncalcular.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btncalcular.setMnemonic('c');
        btncalcular.setToolTipText("Calcular ALT+C");
        btncalcular.setBorder(new javax.swing.border.MatteBorder(null));
        btncalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        jPanel1.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 40, 20));

        txt_valor_lab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_valor_lab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_valor_lab.setText("0");
        txt_valor_lab.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_valor_lab.setEnabled(false);
        jPanel1.add(txt_valor_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 150, 30));

        lbl_deta2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_deta2.setText("VALOR STOCK:");
        jPanel1.add(lbl_deta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        lbl_deta3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_deta3.setText("SERVICIO TÉC:");
        jPanel1.add(lbl_deta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        txt_id_tec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_id_tec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_tec.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_id_tec.setEnabled(false);
        jPanel1.add(txt_id_tec, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 30));

        txt_nom_tec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_nom_tec.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_tec.setEnabled(false);
        jPanel1.add(txt_nom_tec, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 320, 30));

        lbl_monto1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_monto1.setText("VALOR O.S:");
        jPanel1.add(lbl_monto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 70, 30));

        lbl_des_pro_carga.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_des_pro_carga.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(lbl_des_pro_carga, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 220, 30));

        lbl_monto3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_monto3.setText("VALOR O.S REFERENCIA:");
        jPanel1.add(lbl_monto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 140, 30));

        lbl_monto4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_monto4.setText("ESTADO DE DETALLES EN O.S:");
        jPanel1.add(lbl_monto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 180, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((txt_deta_os.getText().equals("")) || (txt_valor_tec.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Ingrese detalle, producto o ingrese los valores");
        } else {

            String capcod = "", capcan = "";
            for (int i = 0; i < Status_Lab.tb_lab_pro.getRowCount(); i++) {
                capcod = Status_Lab.tb_lab_pro.getValueAt(i, 0).toString();
                capcan = Status_Lab.tb_lab_pro.getValueAt(i, 3).toString();
                descontarstock(capcod, capcan);

            }
            act_os_lab();
            detalle_os();

            DefaultTableModel modelo = (DefaultTableModel) tb_lab_pro.getModel();
            int a = tb_lab_pro.getRowCount() - 1;
            int i;
            for (i = a; i >= 0; i--) {
                modelo.removeRow(i);
            }
            txt_deta_os.setText("");
            txt_valor_tec.setText("");
            txt_valor.setText("0");
            txt_valor_lab.setText("0");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

    private void txt_valorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorKeyReleased

    }//GEN-LAST:event_txt_valorKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Productos_lab_os osp;
        osp = new Productos_lab_os(new javax.swing.JDialog(), true);
        osp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        calcular();
        calcularDiferencia();
        calcularTotal();
    }//GEN-LAST:event_btncalcularActionPerformed

    private void txt_valor_tecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valor_tecKeyReleased
        ActivatedYourLife(txt_valor_tec, evt);
        calcularLucro();
    }//GEN-LAST:event_txt_valor_tecKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Tecnicos_os ostec;
        ostec = new Tecnicos_os(new javax.swing.JDialog(), true);
        ostec.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Status_Lab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Status_Lab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Status_Lab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Status_Lab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Status_Lab dialog = new Status_Lab(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btncalcular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_des_pro_carga;
    private javax.swing.JLabel lbl_deta;
    private javax.swing.JLabel lbl_deta1;
    private javax.swing.JLabel lbl_deta2;
    private javax.swing.JLabel lbl_deta3;
    private javax.swing.JLabel lbl_monto1;
    private javax.swing.JLabel lbl_monto3;
    private javax.swing.JLabel lbl_monto4;
    private javax.swing.JLabel lbl_monto_referencia;
    public static javax.swing.JTable tb_lab_pro;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_deta_os;
    public static javax.swing.JTextField txt_id_tec;
    public static javax.swing.JTextField txt_nom_tec;
    private javax.swing.JTextField txt_valor;
    private javax.swing.JTextField txt_valor_lab;
    private javax.swing.JTextField txt_valor_tec;
    // End of variables declaration//GEN-END:variables

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
                    this.txt_valor_tec.setText(
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
            String Texting = txt_valor_tec.getText();
            if (Texting.contains(".")) {
                String Entero = Texting.substring(0, Texting.indexOf("."));
                Entero = MaskaraEnteros(Entero);
                String Fraccion = Texting.substring(Texting.indexOf(".") + 1, Texting.length());
                String Integrated = Entero + "." + Fraccion.replaceAll("\\D", "");
                this.txt_valor_tec.setText(Integrated);
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

    public void calcular() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_lab_pro.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_lab_pro.getValueAt(i, 2).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_lab_pro.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_lab_pro.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 4);
            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            txt_valor_lab.setText(total);

        }
    }

    public void calcularLucro() {

        String totalCuentaDa = "0";
        BigDecimal VentaStock = ingreso.TransformReales(txt_valor_lab.getText());
        BigDecimal Valortec = ingreso.TransformReales(txt_valor_tec.getText());
        totalCuentaDa = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(VentaStock.add(Valortec).toString());
        txt_valor.setText(totalCuentaDa);

    }

    public void calcularDiferencia() {

        String totalCuentaDa = "0";
        BigDecimal VentaStock = ingreso.TransformReales(lbl_monto_referencia.getText());
        BigDecimal Valortec = ingreso.TransformReales(txt_valor_lab.getText());
        totalCuentaDa = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(VentaStock.subtract(Valortec).toString());
        txt_valor_tec.setText(totalCuentaDa);

    }

    public void calcularTotal() {

        String totalCuentaDa = "0";
        BigDecimal VentaStock = ingreso.TransformReales(txt_valor_tec.getText());
        BigDecimal Valortec = ingreso.TransformReales(txt_valor_lab.getText());
        totalCuentaDa = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(VentaStock.add(Valortec).toString());
        txt_valor.setText(totalCuentaDa);

    }

    void act_os_lab() {
        try {
            String id = txt_cod.getText();
            String des = ("REPARADO");
            String valor = txt_valor.getText();
            String detalle = txt_deta_os.getText();
            String valor_stock = txt_valor_lab.getText();
            String valor_tec = txt_valor_tec.getText();
            String id_tec = txt_id_tec.getText();
            String des_tec = txt_nom_tec.getText();
            String carga = ("SERVICIOS YA AGREGADOS");

            String sql = "UPDATE os SET os_status = '" + des
                    + "',os_valor ='" + valor
                    + "',os_deta ='" + detalle
                    + "',os_valor_tec ='" + valor_tec
                    + "',os_valor_stock ='" + valor_stock
                    + "',os_id_tec ='" + id_tec
                    + "',os_des_tec ='" + des_tec
                    + "',os_pro_deta ='" + carga
                    + "' WHERE os_nro = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

                JOptionPane.showMessageDialog(null, "Situación actualizado");
                this.dispose();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
        }
        Principapl_OS.btn_cargar_datos.doClick();
    }

    void descontarstock(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM tienda_productos WHERE  pro_cod='" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(5);//pendiente a modificacion
            }
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE tienda_productos SET pro_cant='" + desfinal + "' WHERE pro_cod = '" + codi + "'";
        try {
            Connection cn = conectar.getInstance().getConnection();

            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);

        } catch (Exception e) {
        }
    }

    void detalle_os() {
        for (int i = 0; i < tb_lab_pro.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO detalle_os (num_bol,cod_pro,des_pro,cant_pro,pre_unit,pre_venta,data) VALUES (?,?,?,?,?,?,?)";
            String numbol = txt_cod.getText();
            String codpro = tb_lab_pro.getValueAt(i, 0).toString();
            String despro = tb_lab_pro.getValueAt(i, 1).toString();
            String cantpro = tb_lab_pro.getValueAt(i, 3).toString();
            String preunit = tb_lab_pro.getValueAt(i, 2).toString();
            String importe = tb_lab_pro.getValueAt(i, 4).toString();
            String fecha_det_con = Principal.lbl_fecha_hoy.getText();

            try {
                Connection cn = conectar.getInstance().getConnection();

                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, numbol);
                pst.setString(2, codpro);
                pst.setString(3, despro);
                pst.setString(4, cantpro);
                pst.setString(5, preunit);
                pst.setString(6, importe);
                pst.setString(7, fecha_det_con);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);

            } catch (SQLException ex) {
                Logger.getLogger(Status_Lab.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cargarTxtos(String valor) {
        String mostrar = "SELECT * FROM os WHERE os_nro= '" + valor + "'";

        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                lbl_monto_referencia.setText(rs.getString(19));
                lbl_des_pro_carga.setText(rs.getString(20));

            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Status_Lab.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(valor);
    }

}
