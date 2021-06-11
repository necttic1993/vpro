/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion_DB;

import Clases.machusculas;
import Productos.excell.Excell_pro;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class config_fiscal_surcu extends javax.swing.JDialog {
    
    FileInputStream fis;
    int longitudBytes;
    
    DefaultTableModel model;
    
    public config_fiscal_surcu(javax.swing.JDialog parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        txtcod.setEnabled(false);
        txtcod.setVisible(false);
        txt_compra_fiscal.setDocument(new machusculas());
        txt_venta_fiscal.setDocument(new machusculas());
        txt_venta_min.setDocument(new machusculas());
        txt_act_vuelto.setDocument(new machusculas());
        txt_panel_pre_usu.setDocument(new machusculas());
        cargar();
        guardar();
        
    }
    
    public static String cod_cuenta_actu = "";
    
    void cargar() throws IOException {
        String mostrar = "SELECT * FROM empresas";
        ImageIcon foto;
        InputStream is;
        
        try {
            Connection cn = conectar.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                txtcod.setText(rs.getString(1));
                txtnom.setText(rs.getString(2));
                txtdes.setText(rs.getString(3));
                is = rs.getBinaryStream(4);
                cb_model_caja.setSelectedItem(rs.getString(5));
                txt_nro_cuentas.setText(rs.getString(6));
                txt_nom_cuenta.setText(rs.getString(7));
                cb_mod_ticket.setSelectedItem(rs.getString(8));
                cb_tipo_lucro.setSelectedItem(rs.getString(9));
                txt_factura.setText(rs.getString(10));
                txt_timbra.setText(rs.getString(11));
                txt_estable.setText(rs.getString(12));
                txt_seque.setText(rs.getString(13));
                txt_compra_fiscal.setText(rs.getString(14));
                txt_venta_fiscal.setText(rs.getString(15));
                txt_serie.setText(rs.getString(16));
                txt_venta_min.setText(rs.getString(17));
                cb_tipo_ventas.setSelectedItem(rs.getString(18));
                
                txt_dir_empre.setText(rs.getString(19));
                cb_id_codigo.setSelectedItem(rs.getString(20));
                txt_fecha_inicial.setText(rs.getString(21));
                txt_fecha_final.setText(rs.getString(22));
                txt_act_vuelto.setText(rs.getString(23));
                cb_moneda.setSelectedItem(rs.getString(24));
                cb_tipo_simbolo.setSelectedItem(rs.getString(25));
                txt_panel_pre_usu.setText(rs.getString(26));

                //surc_2//
                txt_fecha_inicial_2.setText(rs.getString(28));
                txt_fecha_fin_2.setText(rs.getString(29));
                txt_nro_timbra_surc_2.setText(rs.getString(30));
                txt_nro_fact_surc_2.setText(rs.getString(31));
                txt_seq_surc_2.setText(rs.getString(32));
                txt_lote_surc_2.setText(rs.getString(33));

                //surc_11//
                txt_fecha_inicial_11.setText(rs.getString(35));
                txt_fecha_fin_11.setText(rs.getString(36));
                txt_nro_timbra_surc_11.setText(rs.getString(37));
                txt_nro_fact_surc_11.setText(rs.getString(38));
                txt_seq_surc_11.setText(rs.getString(39));
                txt_lote_surc_11.setText(rs.getString(40));

                //surc_22//
                txt_fecha_inicial_22.setText(rs.getString(41));
                txt_fecha_fin_22.setText(rs.getString(42));
                txt_nro_timbra_surc_22.setText(rs.getString(43));
                txt_nro_fact_surc_22.setText(rs.getString(44));
                txt_seq_surc_22.setText(rs.getString(45));
                txt_lote_surc_22.setText(rs.getString(46));
                /////surc_23
                txt_nro_timbra_surc_23.setText(rs.getString(47));
                txt_seq_surc_23.setText(rs.getString(48));
                txt_lote_surc_23.setText(rs.getString(49));
                txt_timbra_devol.setText(rs.getString(50));
                txt_nro_timbra_19.setText(rs.getString(51));
                txt_nro_timbra_24.setText(rs.getString(52));
                
                txt_nro_fact_expo.setText(rs.getString(53));
                txt_nro_timbrado_expo.setText(rs.getString(54));
                txt_nro_seq_expo.setText(rs.getString(55));
                txt_nro_estable_expo.setText(rs.getString(56));
                txt_hab_lote_fact.setText(rs.getString(57));
                
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(240, 160, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                lbl_ima1.setIcon(newicon);
            }
            conectar.getInstance().closeConnection(cn);
            
        } catch (SQLException ex) {
            Logger.getLogger(config_fiscal_surcu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void guardar() {
        if (txtdes.getText().length() != 0) {
            
            btnguardar.setEnabled(false);
        } else {
            btnguardar.setEnabled(true);
            // txtcod.setEnabled(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtdes = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_dir_empre = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();
        lbl_ima1 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_nom_cuenta = new javax.swing.JTextField();
        cb_id_codigo = new javax.swing.JComboBox();
        txt_nro_cuentas = new javax.swing.JTextField();
        txt_act_vuelto = new javax.swing.JTextField();
        cb_moneda = new javax.swing.JComboBox();
        cb_tipo_simbolo = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cb_model_caja = new jcomboper.SComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_fecha_inicial = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_fecha_final = new javax.swing.JFormattedTextField();
        txt_factura = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_timbra = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_seque = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_estable = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_venta_fiscal = new javax.swing.JTextField();
        txt_venta_min = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_serie = new javax.swing.JTextField();
        txt_compra_fiscal = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_panel_pre_usu = new javax.swing.JTextField();
        cb_tipo_ventas = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        cb_mod_ticket = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        txt_timbra_devol = new javax.swing.JTextField();
        cb_tipo_lucro = new javax.swing.JComboBox();
        jPanel31 = new javax.swing.JPanel();
        txt_nro_estable_expo = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txt_nro_fact_expo = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txt_nro_timbrado_expo = new javax.swing.JTextField();
        txt_nro_seq_expo = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel169 = new javax.swing.JLabel();
        txt_hab_lote_fact = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txt_fecha_inicial_2 = new javax.swing.JFormattedTextField();
        txt_nro_timbra_surc_2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txt_seq_surc_2 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txt_lote_surc_2 = new javax.swing.JTextField();
        txt_nro_fact_surc_2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txt_fecha_fin_2 = new javax.swing.JFormattedTextField();
        jLabel69 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_nro_fact_surc_3 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txt_nro_timbra_surc_3 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        txt_seq_surc_3 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        txt_lote_surc_3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txt_nro_fact_surc_4 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txt_nro_timbra_surc_4 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txt_seq_surc_4 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txt_lote_surc_4 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txt_nro_fact_surc_5 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        txt_nro_timbra_surc_5 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txt_seq_surc_5 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txt_lote_surc_5 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_nro_fact_surc_6 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        txt_nro_timbra_surc_6 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        txt_seq_surc_6 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        txt_lote_surc_6 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_nro_fact_surc_7 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        txt_nro_timbra_surc_7 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        txt_seq_surc_7 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        txt_lote_surc_7 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_nro_fact_surc_8 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        txt_nro_timbra_surc_8 = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        txt_seq_surc_8 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        txt_lote_surc_8 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_nro_fact_surc_9 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        txt_nro_timbra_surc_9 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        txt_seq_surc_9 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txt_lote_surc_9 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_nro_fact_surc_10 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        txt_nro_timbra_surc_10 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        txt_seq_surc_10 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        txt_lote_surc_10 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txt_fecha_inicial_11 = new javax.swing.JFormattedTextField();
        txt_fecha_fin_11 = new javax.swing.JFormattedTextField();
        txt_nro_fact_surc_11 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txt_nro_timbra_surc_11 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txt_seq_surc_11 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txt_lote_surc_11 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_nro_fact_surc_12 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        txt_nro_timbra_surc_12 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        txt_seq_surc_12 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        txt_lote_surc_12 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_nro_fact_surc_13 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        txt_nro_timbra_surc_13 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        txt_seq_surc_13 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        txt_lote_surc_13 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_nro_fact_surc_14 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        txt_nro_timbra_surc_14 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        txt_seq_surc_14 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        txt_lote_surc_14 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_nro_fact_surc_15 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        txt_nro_timbra_surc_15 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        txt_seq_surc_15 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        txt_lote_surc_15 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_nro_fact_surc_16 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        txt_nro_timbra_surc_16 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        txt_seq_surc_16 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        txt_lote_surc_16 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_nro_fact_surc_17 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        txt_nro_timbra_surc_17 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        txt_seq_surc_17 = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        txt_lote_surc_17 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_nro_fact_surc_18 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        txt_nro_timbra_surc_18 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        txt_seq_surc_18 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        txt_lote_surc_18 = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nro_fact_surc_19 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        txt_nro_timbra_19 = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        txt_seq_surc_19 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        txt_lote_surc_19 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nro_fact_surc_20 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        txt_nro_timbra_surc_20 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        txt_seq_surc_20 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        txt_lote_surc_20 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        txt_nro_fact_surc_21 = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        txt_nro_timbra_surc_21 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        txt_seq_surc_21 = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        txt_lote_surc_21 = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        txt_nro_fact_surc_22 = new javax.swing.JTextField();
        txt_fecha_fin_22 = new javax.swing.JFormattedTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txt_nro_timbra_surc_22 = new javax.swing.JTextField();
        txt_fecha_inicial_22 = new javax.swing.JFormattedTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txt_seq_surc_22 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txt_lote_surc_22 = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        txt_lote_surc_23 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txt_nro_timbra_surc_23 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txt_seq_surc_23 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txt_nro_timbra_24 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        txt_seq_surc_24 = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        txt_lote_surc_24 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        txt_seq_surc_25 = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        txt_nro_timbra_25 = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        txt_lote_surc_25 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        txt_seq_surc_26 = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        txt_nro_timbra_26 = new javax.swing.JTextField();
        jLabel156 = new javax.swing.JLabel();
        txt_lote_surc_26 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        txt_seq_surc_27 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        txt_nro_timbra_27 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        txt_lote_surc_27 = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        txt_seq_surc_28 = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        txt_nro_timbra_28 = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        txt_lote_surc_28 = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        txt_seq_surc_29 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        txt_nro_timbra_29 = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        txt_lote_surc_29 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        txt_seq_surc_30 = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        txt_nro_timbra_30 = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        txt_lote_surc_30 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuentas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTabbedPane1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Configuracion Sucursal Nro 1");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setText("Empresa:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        txtnom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });
        jPanel1.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 390, 30));

        txtdes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdesKeyTyped(evt);
            }
        });
        jPanel1.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 390, 30));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setText("Descripción:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 30));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel23.setText("Dirección:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 30));

        txt_dir_empre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_dir_empre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 390, 30));

        txtcod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, -1));

        lbl_ima1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(lbl_ima1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 240, 160));

        btnguardar.setBackground(new java.awt.Color(0, 102, 153));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setMnemonic('g');
        btnguardar.setText("Guardar");
        btnguardar.setToolTipText("");
        btnguardar.setActionCommand("");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 130, 40));

        btnactualizar.setBackground(new java.awt.Color(0, 102, 153));
        btnactualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizar.setMnemonic('a');
        btnactualizar.setText("Reset");
        btnactualizar.setToolTipText("");
        btnactualizar.setActionCommand("");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 130, 40));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_6_esp/imagen.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 130, 40));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setText("Stock Física:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 90, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJUSTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 90, 30));

        txt_nom_cuenta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_nom_cuenta.setEnabled(false);
        jPanel1.add(txt_nom_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 330, 30));

        cb_id_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cb_id_codigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        jPanel1.add(cb_id_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 50, 30));

        txt_nro_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nro_cuentasActionPerformed(evt);
            }
        });
        txt_nro_cuentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nro_cuentasKeyPressed(evt);
            }
        });
        jPanel1.add(txt_nro_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 50, 30));

        txt_act_vuelto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_act_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 50, 30));

        cb_moneda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_moneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Guaraníes", "Extranjero" }));
        jPanel1.add(cb_moneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 180, 30));

        cb_tipo_simbolo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_tipo_simbolo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gs", "US$", "RS$" }));
        jPanel1.add(cb_tipo_simbolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 80, 30));

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel25.setText("Modelo de Factura:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 130, 30));

        cb_model_caja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_model_caja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(cb_model_caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 80, -1));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel26.setText("Simbolo:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 90, 30));

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel27.setText("Monedas:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 90, 30));

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel28.setText("Rgimen Tur:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 90, 30));

        jLabel29.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel29.setText("Modelo ID:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, 30));

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel30.setText("Caja Cuenta:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, 30));

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel31.setText("Vigencia desde:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 110, 30));

        try {
            txt_fecha_inicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_inicial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_fecha_inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 90, 30));

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel32.setText("hasta:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 50, 30));

        try {
            txt_fecha_final.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_final.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_fecha_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 100, 30));

        txt_factura.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 100, 30));

        jLabel33.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel33.setText("Nro. Fact.:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 70, 30));

        txt_timbra.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_timbra, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 120, 30));

        jLabel34.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel34.setText("Timbrado:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 90, 30));

        jLabel35.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel35.setText("Sequencia:");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 90, 30));

        txt_seque.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_seque, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 70, 30));

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel36.setText("Lote-Establ.:");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 80, 30));

        txt_estable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jPanel1.add(txt_estable, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 70, 30));

        jLabel37.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel37.setText("Lucro tipo:");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 70, 30));

        jLabel38.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel38.setText("Hora Server");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 90, 30));

        txt_venta_fiscal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_venta_fiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 70, 30));

        txt_venta_min.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_venta_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 50, 30));

        jLabel39.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel39.setText("Venta Mínimo:");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 90, 30));

        txt_serie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 80, 30));

        txt_compra_fiscal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_compra_fiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 40, 30));

        jLabel40.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel40.setText("Mod. Tick:");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 70, 30));

        jLabel41.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel41.setText("Compra Fiscal:");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 110, 30));

        jLabel42.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel42.setText("Lote Factura:");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 90, 30));

        jLabel44.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel44.setText("Timbrado NC:");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 30));

        txt_panel_pre_usu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_panel_pre_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 40, 30));

        cb_tipo_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_tipo_ventas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Normal-barras", "Fiscal", "Fiscal-etiqueta" }));
        jPanel1.add(cb_tipo_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 260, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/agrega.png"))); // NOI18N
        jButton3.setText("AJUSTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 140, 50));

        cb_mod_ticket.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_mod_ticket.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        jPanel1.add(cb_mod_ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 70, 30));

        jLabel68.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel68.setText("Precio Usu:");
        jPanel1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, 30));

        txt_timbra_devol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_timbra_devol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 100, 30));

        cb_tipo_lucro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_tipo_lucro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        jPanel1.add(cb_tipo_lucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 70, 30));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EXPORTACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nro_estable_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_estable_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 60, 30));

        jLabel43.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel43.setText("Establecimiento:");
        jPanel31.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 30));

        jLabel72.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel72.setText("Nro. Fact.:");
        jPanel31.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jLabel73.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel73.setText("Timbrado:");
        jPanel31.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        txt_nro_fact_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_fact_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 160, 30));

        jLabel77.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel77.setText("Sequencia:");
        jPanel31.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        txt_nro_timbrado_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_timbrado_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, 30));

        txt_nro_seq_expo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel31.add(txt_nro_seq_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 60, 30));

        jPanel1.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 360, 130));

        jLabel70.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel70.setText("Mod.Ventas:");
        jPanel1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_5/sobresalir.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 90, -1));

        jLabel169.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel169.setText("Serie Nro:");
        jPanel1.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, 30));

        txt_hab_lote_fact.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_hab_lote_fact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 40, 30));

        jTabbedPane1.addTab("Surc. 1", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Configuracion Sucursal Nro 2");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel45.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel45.setText("Desde:");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 30));

        try {
            txt_fecha_inicial_2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_inicial_2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(txt_fecha_inicial_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 100, 30));
        jPanel2.add(txt_nro_timbra_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel46.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel46.setText("Timbrado:");
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel47.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel47.setText("Sequencia:");
        jPanel2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel2.add(txt_seq_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel48.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel48.setText("Lote-Establ.:");
        jPanel2.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel2.add(txt_lote_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));
        jPanel2.add(txt_nro_fact_surc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel49.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel49.setText("Nro. Fact.:");
        jPanel2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));

        jLabel50.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel50.setText("hasta:");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 40, 30));

        try {
            txt_fecha_fin_2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_fin_2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(txt_fecha_fin_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 100, 30));

        jLabel69.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel69.setText("Timbrado NC:");
        jPanel2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, 30));

        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 160, 30));

        jTabbedPane1.addTab("Surc. 2", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Configuracion Sucursal Nro 3");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel3.add(txt_nro_fact_surc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel78.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel78.setText("Nro. Fact.:");
        jPanel3.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel3.add(txt_nro_timbra_surc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel79.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel79.setText("Timbrado:");
        jPanel3.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel80.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel80.setText("Sequencia:");
        jPanel3.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel3.add(txt_seq_surc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel81.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel81.setText("Lote-Establ.:");
        jPanel3.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel3.add(txt_lote_surc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 3", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel3); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Configuracion Sucursal Nro 4");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel4.add(txt_nro_fact_surc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel82.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel82.setText("Nro. Fact.:");
        jPanel4.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel4.add(txt_nro_timbra_surc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel83.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel83.setText("Timbrado:");
        jPanel4.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel84.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel84.setText("Sequencia:");
        jPanel4.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel4.add(txt_seq_surc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel85.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel85.setText("Lote-Establ.:");
        jPanel4.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel4.add(txt_lote_surc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 4", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel4); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Configuracion Sucursal Nro 5");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel5.add(txt_nro_fact_surc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel86.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel86.setText("Nro. Fact.:");
        jPanel5.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel5.add(txt_nro_timbra_surc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel87.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel87.setText("Timbrado:");
        jPanel5.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel88.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel88.setText("Sequencia:");
        jPanel5.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel5.add(txt_seq_surc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel89.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel89.setText("Lote-Establ.:");
        jPanel5.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel5.add(txt_lote_surc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 5", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel5); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Configuracion Sucursal Nro 6");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel6.add(txt_nro_fact_surc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel90.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel90.setText("Nro. Fact.:");
        jPanel6.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel6.add(txt_nro_timbra_surc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel91.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel91.setText("Timbrado:");
        jPanel6.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel92.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel92.setText("Sequencia:");
        jPanel6.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel6.add(txt_seq_surc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel93.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel93.setText("Lote-Establ.:");
        jPanel6.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel6.add(txt_lote_surc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 6", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel6); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Configuracion Sucursal Nro 7");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel7.add(txt_nro_fact_surc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel94.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel94.setText("Nro. Fact.:");
        jPanel7.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel7.add(txt_nro_timbra_surc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel95.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel95.setText("Timbrado:");
        jPanel7.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel96.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel96.setText("Sequencia:");
        jPanel7.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel7.add(txt_seq_surc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel97.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel97.setText("Lote-Establ.:");
        jPanel7.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel7.add(txt_lote_surc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 7", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel7); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Configuracion Sucursal Nro 8");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel8.add(txt_nro_fact_surc_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel98.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel98.setText("Nro. Fact.:");
        jPanel8.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel8.add(txt_nro_timbra_surc_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel99.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel99.setText("Timbrado:");
        jPanel8.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel100.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel100.setText("Sequencia:");
        jPanel8.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel8.add(txt_seq_surc_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel101.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel101.setText("Lote-Establ.:");
        jPanel8.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel8.add(txt_lote_surc_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 8", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel8); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Configuracion Sucursal Nro 9");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel9.add(txt_nro_fact_surc_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel102.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel102.setText("Nro. Fact.:");
        jPanel9.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel9.add(txt_nro_timbra_surc_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel103.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel103.setText("Timbrado:");
        jPanel9.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel104.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel104.setText("Sequencia:");
        jPanel9.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel9.add(txt_seq_surc_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel105.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel105.setText("Lote-Establ.:");
        jPanel9.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel9.add(txt_lote_surc_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 9", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel9); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Configuracion Sucursal Nro 10");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel10.add(txt_nro_fact_surc_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel106.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel106.setText("Nro. Fact.:");
        jPanel10.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel10.add(txt_nro_timbra_surc_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel107.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel107.setText("Timbrado:");
        jPanel10.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel108.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel108.setText("Sequencia:");
        jPanel10.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel10.add(txt_seq_surc_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel109.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel109.setText("Lote-Establ.:");
        jPanel10.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel10.add(txt_lote_surc_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 10", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel10); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel11.setOpaque(false);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Configuracion Sucursal Nro 11");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel51.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel51.setText("Desde:");
        jPanel11.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 30));

        try {
            txt_fecha_inicial_11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_inicial_11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel11.add(txt_fecha_inicial_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 100, 30));

        try {
            txt_fecha_fin_11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_fin_11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel11.add(txt_fecha_fin_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 100, 30));
        jPanel11.add(txt_nro_fact_surc_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel52.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel52.setText("Nro. Fact.:");
        jPanel11.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));

        jLabel53.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel53.setText("hasta:");
        jPanel11.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 40, 30));
        jPanel11.add(txt_nro_timbra_surc_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel54.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel54.setText("Timbrado:");
        jPanel11.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel55.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel55.setText("Sequencia:");
        jPanel11.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel11.add(txt_seq_surc_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel56.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel56.setText("Lote-Establ.:");
        jPanel11.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel11.add(txt_lote_surc_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 11", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel11); // NOI18N

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Configuracion Sucursal Nro 12");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel12.add(txt_nro_fact_surc_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel110.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel110.setText("Nro. Fact.:");
        jPanel12.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel12.add(txt_nro_timbra_surc_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel111.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel111.setText("Timbrado:");
        jPanel12.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel112.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel112.setText("Sequencia:");
        jPanel12.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel12.add(txt_seq_surc_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel113.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel113.setText("Lote-Establ.:");
        jPanel12.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel12.add(txt_lote_surc_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 12", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel12); // NOI18N

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Configuracion Sucursal Nro 13");
        jPanel13.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel13.add(txt_nro_fact_surc_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel114.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel114.setText("Nro. Fact.:");
        jPanel13.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel13.add(txt_nro_timbra_surc_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel115.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel115.setText("Timbrado:");
        jPanel13.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel116.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel116.setText("Sequencia:");
        jPanel13.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel13.add(txt_seq_surc_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel117.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel117.setText("Lote-Establ.:");
        jPanel13.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel13.add(txt_lote_surc_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 13", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel13); // NOI18N

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Configuracion Sucursal Nro 14");
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel14.add(txt_nro_fact_surc_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel118.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel118.setText("Nro. Fact.:");
        jPanel14.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel14.add(txt_nro_timbra_surc_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel119.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel119.setText("Timbrado:");
        jPanel14.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel120.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel120.setText("Sequencia:");
        jPanel14.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel14.add(txt_seq_surc_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel121.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel121.setText("Lote-Establ.:");
        jPanel14.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel14.add(txt_lote_surc_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 14", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel14); // NOI18N

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Configuracion Sucursal Nro 15");
        jPanel15.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel15.add(txt_nro_fact_surc_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel122.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel122.setText("Nro. Fact.:");
        jPanel15.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel15.add(txt_nro_timbra_surc_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel123.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel123.setText("Timbrado:");
        jPanel15.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel124.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel124.setText("Sequencia:");
        jPanel15.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel15.add(txt_seq_surc_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel125.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel125.setText("Lote-Establ.:");
        jPanel15.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel15.add(txt_lote_surc_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 15", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel15); // NOI18N

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel16.setOpaque(false);
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Configuracion Sucursal Nro 16");
        jPanel16.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel16.add(txt_nro_fact_surc_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel126.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel126.setText("Nro. Fact.:");
        jPanel16.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel16.add(txt_nro_timbra_surc_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel127.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel127.setText("Timbrado:");
        jPanel16.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel128.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel128.setText("Sequencia:");
        jPanel16.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel16.add(txt_seq_surc_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel129.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel129.setText("Lote-Establ.:");
        jPanel16.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel16.add(txt_lote_surc_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 16", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel16); // NOI18N

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel17.setOpaque(false);
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Configuracion Sucursal Nro 17");
        jPanel17.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel17.add(txt_nro_fact_surc_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel130.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel130.setText("Nro. Fact.:");
        jPanel17.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel17.add(txt_nro_timbra_surc_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel131.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel131.setText("Timbrado:");
        jPanel17.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel132.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel132.setText("Sequencia:");
        jPanel17.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel17.add(txt_seq_surc_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel133.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel133.setText("Lote-Establ.:");
        jPanel17.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel17.add(txt_lote_surc_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 17", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel17); // NOI18N

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel18.setOpaque(false);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Configuracion Sucursal Nro 18");
        jPanel18.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel18.add(txt_nro_fact_surc_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel134.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel134.setText("Nro. Fact.:");
        jPanel18.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel18.add(txt_nro_timbra_surc_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel135.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel135.setText("Timbrado:");
        jPanel18.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel136.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel136.setText("Sequencia:");
        jPanel18.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel18.add(txt_seq_surc_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel137.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel137.setText("Lote-Establ.:");
        jPanel18.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel18.add(txt_lote_surc_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 18", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel18); // NOI18N

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel19.setOpaque(false);
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Configuracion Sucursal Nro 19");
        jPanel19.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel19.add(txt_nro_fact_surc_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel138.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel138.setText("Nro. Fact.:");
        jPanel19.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel19.add(txt_nro_timbra_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel139.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel139.setText("Timbrado:");
        jPanel19.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel140.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel140.setText("Sequencia:");
        jPanel19.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel19.add(txt_seq_surc_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel141.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel141.setText("Lote-Establ.:");
        jPanel19.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel19.add(txt_lote_surc_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 19", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel19); // NOI18N

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel20.setOpaque(false);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Configuracion Sucursal Nro 20");
        jPanel20.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel20.add(txt_nro_fact_surc_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel71.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel71.setText("Nro. Fact.:");
        jPanel20.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel20.add(txt_nro_timbra_surc_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel142.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel142.setText("Timbrado:");
        jPanel20.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel143.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel143.setText("Sequencia:");
        jPanel20.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel20.add(txt_seq_surc_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel144.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel144.setText("Lote-Establ.:");
        jPanel20.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel20.add(txt_lote_surc_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 20", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel20); // NOI18N

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setText("Configuracion Sucursal Nro 21");
        jPanel21.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel21.add(txt_nro_fact_surc_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        jLabel145.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel145.setText("Nro. Fact.:");
        jPanel21.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel21.add(txt_nro_timbra_surc_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        jLabel146.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel146.setText("Timbrado:");
        jPanel21.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel147.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel147.setText("Sequencia:");
        jPanel21.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel21.add(txt_seq_surc_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel148.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel148.setText("Lote-Establ.:");
        jPanel21.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel21.add(txt_lote_surc_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 21", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel21); // NOI18N

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel58.setText("Configuracion Sucursal Nro 22");
        jPanel22.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel22.add(txt_nro_fact_surc_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 130, 30));

        try {
            txt_fecha_fin_22.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_fin_22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel22.add(txt_fecha_fin_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 100, 30));

        jLabel59.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel59.setText("hasta:");
        jPanel22.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 40, 30));

        jLabel60.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel60.setText("Nro. Fact.:");
        jPanel22.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, 30));
        jPanel22.add(txt_nro_timbra_surc_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        try {
            txt_fecha_inicial_22.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_inicial_22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel22.add(txt_fecha_inicial_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 100, 30));

        jLabel61.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel61.setText("Desde:");
        jPanel22.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 30));

        jLabel62.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel62.setText("Timbrado:");
        jPanel22.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jLabel63.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel63.setText("Sequencia:");
        jPanel22.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));
        jPanel22.add(txt_seq_surc_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jLabel64.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel64.setText("Lote-Establ.:");
        jPanel22.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));
        jPanel22.add(txt_lote_surc_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 30));

        jTabbedPane1.addTab("Surc. 22", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel22); // NOI18N

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel23.add(txt_lote_surc_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, 30));

        jLabel65.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel65.setText("Lote-Establ.:");
        jPanel23.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, 30));
        jPanel23.add(txt_nro_timbra_surc_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, 30));

        jLabel66.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel66.setText("Timbrado:");
        jPanel23.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 30));

        jLabel67.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel67.setText("Sequencia:");
        jPanel23.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 30));

        txt_seq_surc_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_seq_surc_23ActionPerformed(evt);
            }
        });
        jPanel23.add(txt_seq_surc_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 60, 30));

        jLabel75.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel75.setText("Configuracion Sucursal Nro 22");
        jPanel23.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane1.addTab("Surc. 23", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel23); // NOI18N

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel74.setText("Configuracion Sucursal Nro 24");
        jPanel24.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel76.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel76.setText("Timbrado Nro:");
        jPanel24.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel24.add(txt_nro_timbra_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel151.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel151.setText("Sequencia:");
        jPanel24.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));
        jPanel24.add(txt_seq_surc_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel152.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel152.setText("Lote-Establ.:");
        jPanel24.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel24.add(txt_lote_surc_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jTabbedPane1.addTab("Surc. 24", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel24); // NOI18N

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel25.add(txt_seq_surc_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel153.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel153.setText("Sequencia:");
        jPanel25.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel149.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel149.setText("Timbrado Nro:");
        jPanel25.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel25.add(txt_nro_timbra_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel154.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel154.setText("Lote-Establ.:");
        jPanel25.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel25.add(txt_lote_surc_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jTabbedPane1.addTab("Surc. 25", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel25); // NOI18N

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel26.add(txt_seq_surc_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel155.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel155.setText("Sequencia:");
        jPanel26.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel150.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel150.setText("Timbrado Nro:");
        jPanel26.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel26.add(txt_nro_timbra_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel156.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel156.setText("Lote-Establ.:");
        jPanel26.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel26.add(txt_lote_surc_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jTabbedPane1.addTab("Surc. 26", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel26); // NOI18N

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(txt_seq_surc_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel157.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel157.setText("Sequencia:");
        jPanel27.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel158.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel158.setText("Timbrado Nro:");
        jPanel27.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel27.add(txt_nro_timbra_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel159.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel159.setText("Lote-Establ.:");
        jPanel27.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel27.add(txt_lote_surc_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jTabbedPane1.addTab("Surc. 27", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel27); // NOI18N

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(txt_seq_surc_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel160.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel160.setText("Sequencia:");
        jPanel28.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel161.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel161.setText("Timbrado Nro:");
        jPanel28.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel28.add(txt_nro_timbra_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel162.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel162.setText("Lote-Establ.:");
        jPanel28.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel28.add(txt_lote_surc_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jTabbedPane1.addTab("Surc. 28", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel28); // NOI18N

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel29.add(txt_seq_surc_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel163.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel163.setText("Sequencia:");
        jPanel29.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel164.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel164.setText("Timbrado Nro:");
        jPanel29.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel29.add(txt_nro_timbra_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel165.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel165.setText("Lote-Establ.:");
        jPanel29.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel29.add(txt_lote_surc_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jTabbedPane1.addTab("Surc. 29", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel29); // NOI18N

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel30.add(txt_seq_surc_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 30));

        jLabel166.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel166.setText("Sequencia:");
        jPanel30.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 30));

        jLabel167.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel167.setText("Timbrado Nro:");
        jPanel30.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txt_nro_timbra_30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel30.add(txt_nro_timbra_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel168.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel168.setText("Lote-Establ.:");
        jPanel30.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));
        jPanel30.add(txt_lote_surc_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 60, 30));

        jTabbedPane1.addTab("Surc. 30", new javax.swing.ImageIcon(getClass().getResource("/icon_4/ubicacion.png")), jPanel30); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped

    }//GEN-LAST:event_txtnomKeyTyped

    private void txtdesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyTyped

    }//GEN-LAST:event_txtdesKeyTyped

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodKeyTyped

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtnom.getText().length() != 0) {
            String nom, des;
            String sql = "";
            nom = txtnom.getText();
            des = txtdes.getText();
            
            sql = "INSERT INTO empresas (emp_nom,emp_des,emp_imag) VALUES (?,?,?)";
            try {
                Connection cn = conectar.getInstance().getConnection();
                
                PreparedStatement pst = cn.prepareStatement(sql);
                
                pst.setString(1, nom);
                pst.setString(2, des);
                pst.setBinaryStream(3, fis, longitudBytes);
                
                int n = pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);
                
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                    txtcod.setText("");
                    txtnom.setText("");
                    txtdes.setText("");
                    lbl_ima1.setIcon(null);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(config_fiscal_surcu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verife los campos estan vacios");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        
        try {
            Connection cn = conectar.getInstance().getConnection();
            
            PreparedStatement pst = cn.prepareStatement("DELETE FROM empresas  WHERE id_empre='" + txtcod.getText() + "'");
            
            pst.executeUpdate();
            conectar.getInstance().closeConnection(cn);
            
            lbl_ima1.setIcon(null);
            JOptionPane.showMessageDialog(null, "Reseteado");
        } catch (SQLException | HeadlessException e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lbl_ima1.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbl_ima1.getWidth(), lbl_ima1.getHeight(), Image.SCALE_DEFAULT);
                    lbl_ima1.setIcon(new ImageIcon(icono));
                    lbl_ima1.updateUI();
                    
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ajuste_stock_manual ecv;
        ecv = new Ajuste_stock_manual(new javax.swing.JDialog(), true);
        ecv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nro_cuentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_cuentasKeyPressed
        char Tecla = evt.getKeyChar();
        
        if (Tecla == KeyEvent.VK_ENTER) {
            
            Cuentas_config ccc;
            ccc = new Cuentas_config(new javax.swing.JDialog(), true);
            ccc.setVisible(true);
            
        }
    }//GEN-LAST:event_txt_nro_cuentasKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            
            String id = txtcod.getText();
            String empre = txtnom.getText();
            String des = txtdes.getText();
            String model_fact = (String) cb_model_caja.getSelectedItem();
            String nro_cuenta = txt_nro_cuentas.getText();
            String nom_cuenta = txt_nom_cuenta.getText();
            String cred = (String) cb_mod_ticket.getSelectedItem();
            String debi = (String) cb_tipo_lucro.getSelectedItem();
            String fac = txt_factura.getText();
            String timbra = txt_timbra.getText();
            String esta = txt_estable.getText();
            String seque = txt_seque.getText();
            String comp_fiscal = txt_compra_fiscal.getText();
            String venta_fiscal = txt_venta_fiscal.getText();
            String iva_cant = txt_serie.getText();
            String venta_min = txt_venta_min.getText();
            String tipo_ventas = (String) cb_tipo_ventas.getSelectedItem();
            String direc = txt_dir_empre.getText();
            String backup = (String) cb_id_codigo.getSelectedItem();
            String desde = txt_fecha_inicial.getText();
            String hasta = txt_fecha_final.getText();
            String vuelto = txt_act_vuelto.getText();
            String moneda = (String) cb_moneda.getSelectedItem();
            String simbolo = (String) cb_tipo_simbolo.getSelectedItem();
            String pre_usu = txt_panel_pre_usu.getText();
            ////surc 2//////
            String init_surc_2 = txt_fecha_inicial_2.getText();
            String fin_surc_2 = txt_fecha_fin_2.getText();
            String timbra_surc_2 = txt_nro_timbra_surc_2.getText();
            String nro_fact_surc_2 = txt_nro_fact_surc_2.getText();
            String seq_surc_2 = txt_seq_surc_2.getText();
            String lote_surc_2 = txt_lote_surc_2.getText();

            ////surc 11//////
            String init_surc_11 = txt_fecha_inicial_11.getText();
            String fin_surc_11 = txt_fecha_fin_11.getText();
            String timbra_surc_11 = txt_nro_timbra_surc_11.getText();
            String nro_fact_surc_11 = txt_nro_fact_surc_11.getText();
            String seq_surc_11 = txt_seq_surc_11.getText();
            String lote_surc_11 = txt_lote_surc_11.getText();
            ////surc 22//////
            String init_surc_22 = txt_fecha_inicial_22.getText();
            String fin_surc_22 = txt_fecha_fin_22.getText();
            String timbra_surc_22 = txt_nro_timbra_surc_22.getText();
            String nro_fact_surc_22 = txt_nro_fact_surc_22.getText();
            String seq_surc_22 = txt_seq_surc_22.getText();
            String lote_surc_22 = txt_lote_surc_22.getText();

            ////surc 23///////
            String timbra_surc_23 = txt_nro_timbra_surc_23.getText();
            String seq_surc_23 = txt_seq_surc_23.getText();
            String lote_surc_23 = txt_lote_surc_23.getText();
            //devol central
            String timbra_devol_central = txt_timbra_devol.getText();
            String timbra_19 = txt_nro_timbra_19.getText();
            String timbra_24 = txt_nro_timbra_24.getText();
            
            String nro_fact_expo = txt_nro_fact_expo.getText();
            String nro_timbra_expo = txt_nro_timbrado_expo.getText();
            String nro_seq_expo = txt_nro_seq_expo.getText();
            String nro_estable_expo = txt_nro_estable_expo.getText();
            ///lote
            String hab_lote = txt_hab_lote_fact.getText();
            
            String sql = "UPDATE empresas SET emp_nom = '" + empre
                    + "',emp_des ='" + des
                    + "',caja_ra ='" + model_fact
                    + "',nro_cta ='" + nro_cuenta
                    + "',nom_cta ='" + nom_cuenta
                    + "',tarje_cre ='" + cred
                    + "',tarje_deb ='" + debi
                    + "',nro_fact ='" + fac
                    + "',nro_timbra ='" + timbra
                    + "',nro_estable ='" + esta
                    + "',nro_sequencia ='" + seque
                    + "',compra_fiscal ='" + comp_fiscal
                    + "',venta_fiscal ='" + venta_fiscal
                    + "',iva_por ='" + iva_cant
                    + "',venta_min ='" + venta_min
                    + "',tipo_ventas ='" + tipo_ventas
                    + "',dir_empre ='" + direc
                    + "',dir_backup ='" + backup
                    + "',fecha_desde ='" + desde
                    + "',fecha_hasta ='" + hasta
                    + "',activa_vuelto ='" + vuelto
                    + "',mon_default ='" + moneda
                    + "',mon_tipo ='" + simbolo
                    + "',control_pre_usu ='" + pre_usu
                    //surc_2///
                    + "',fecha_init_surc_2 ='" + init_surc_2
                    + "',fecha_fin_surc_2 ='" + fin_surc_2
                    + "',timbra_surc_2 ='" + timbra_surc_2
                    + "',nro_fact_surc_2 ='" + nro_fact_surc_2
                    + "',seq_surc_2 ='" + seq_surc_2
                    + "',lote_surc_2 ='" + lote_surc_2
                    //surc_11///
                    + "',fecha_init_surc_11 ='" + init_surc_11
                    + "',fecha_fin_surc_11 ='" + fin_surc_11
                    + "',timbra_surc_11 ='" + timbra_surc_11
                    + "',nro_fact_surc_11 ='" + nro_fact_surc_11
                    + "',seq_surc_11 ='" + seq_surc_11
                    + "',lote_surc_11 ='" + lote_surc_11
                    //surc_22///
                    + "',fecha_init_surc_22 ='" + init_surc_22
                    + "',fecha_fin_surc_22 ='" + fin_surc_22
                    + "',timbra_surc_22 ='" + timbra_surc_22
                    + "',nro_fact_surc_22 ='" + nro_fact_surc_22
                    + "',seq_surc_22 ='" + seq_surc_22
                    + "',lote_surc_22 ='" + lote_surc_22
                    ////surc_23/////////
                    + "',timbra_surc_23 ='" + timbra_surc_23
                    + "',seq_surc_23 ='" + seq_surc_23
                    + "',lote_surc_23 ='" + lote_surc_23
                    //central devol
                    + "',timbra_devol_central ='" + timbra_devol_central
                    + "',timbra_19 ='" + timbra_19
                    + "',timbra_24 ='" + timbra_24
                    + "',nro_fact_expo ='" + nro_fact_expo
                    + "',nro_timbrado_expo ='" + nro_timbra_expo
                    + "',nro_seq_expo ='" + nro_seq_expo
                    + "',nro_estable_expo ='" + nro_estable_expo
                    + "',activa_lote ='" + hab_lote
                    + "' WHERE id_empre = '" + id + "'";
            try {
                Connection cn = conectar.getInstance().getConnection();
                
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                conectar.getInstance().closeConnection(cn);
                
                JOptionPane.showMessageDialog(null, "Actualizado nuevos parámetros");
                
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_nro_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nro_cuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nro_cuentasActionPerformed

    private void txt_seq_surc_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_seq_surc_23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_seq_surc_23ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Excell_pro pg;
        pg = new Excell_pro(new javax.swing.JDialog(), true);
        pg.setVisible(true);
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
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(config_fiscal_surcu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    config_fiscal_surcu dialog = new config_fiscal_surcu(new javax.swing.JDialog(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(config_fiscal_surcu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox cb_id_codigo;
    private javax.swing.JComboBox cb_mod_ticket;
    private jcomboper.SComboBox cb_model_caja;
    private javax.swing.JComboBox cb_moneda;
    private javax.swing.JComboBox cb_tipo_lucro;
    private javax.swing.JComboBox cb_tipo_simbolo;
    private javax.swing.JComboBox cb_tipo_ventas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_ima1;
    private javax.swing.JTextField txt_act_vuelto;
    private javax.swing.JTextField txt_compra_fiscal;
    private javax.swing.JTextField txt_dir_empre;
    private javax.swing.JTextField txt_estable;
    private javax.swing.JTextField txt_factura;
    private javax.swing.JFormattedTextField txt_fecha_fin_11;
    private javax.swing.JFormattedTextField txt_fecha_fin_2;
    private javax.swing.JFormattedTextField txt_fecha_fin_22;
    private javax.swing.JFormattedTextField txt_fecha_final;
    private javax.swing.JFormattedTextField txt_fecha_inicial;
    private javax.swing.JFormattedTextField txt_fecha_inicial_11;
    private javax.swing.JFormattedTextField txt_fecha_inicial_2;
    private javax.swing.JFormattedTextField txt_fecha_inicial_22;
    private javax.swing.JTextField txt_hab_lote_fact;
    private javax.swing.JTextField txt_lote_surc_10;
    private javax.swing.JTextField txt_lote_surc_11;
    private javax.swing.JTextField txt_lote_surc_12;
    private javax.swing.JTextField txt_lote_surc_13;
    private javax.swing.JTextField txt_lote_surc_14;
    private javax.swing.JTextField txt_lote_surc_15;
    private javax.swing.JTextField txt_lote_surc_16;
    private javax.swing.JTextField txt_lote_surc_17;
    private javax.swing.JTextField txt_lote_surc_18;
    private javax.swing.JTextField txt_lote_surc_19;
    private javax.swing.JTextField txt_lote_surc_2;
    private javax.swing.JTextField txt_lote_surc_20;
    private javax.swing.JTextField txt_lote_surc_21;
    private javax.swing.JTextField txt_lote_surc_22;
    private javax.swing.JTextField txt_lote_surc_23;
    private javax.swing.JTextField txt_lote_surc_24;
    private javax.swing.JTextField txt_lote_surc_25;
    private javax.swing.JTextField txt_lote_surc_26;
    private javax.swing.JTextField txt_lote_surc_27;
    private javax.swing.JTextField txt_lote_surc_28;
    private javax.swing.JTextField txt_lote_surc_29;
    private javax.swing.JTextField txt_lote_surc_3;
    private javax.swing.JTextField txt_lote_surc_30;
    private javax.swing.JTextField txt_lote_surc_4;
    private javax.swing.JTextField txt_lote_surc_5;
    private javax.swing.JTextField txt_lote_surc_6;
    private javax.swing.JTextField txt_lote_surc_7;
    private javax.swing.JTextField txt_lote_surc_8;
    private javax.swing.JTextField txt_lote_surc_9;
    public static javax.swing.JTextField txt_nom_cuenta;
    public static javax.swing.JTextField txt_nro_cuentas;
    private javax.swing.JTextField txt_nro_estable_expo;
    private javax.swing.JTextField txt_nro_fact_expo;
    private javax.swing.JTextField txt_nro_fact_surc_10;
    private javax.swing.JTextField txt_nro_fact_surc_11;
    private javax.swing.JTextField txt_nro_fact_surc_12;
    private javax.swing.JTextField txt_nro_fact_surc_13;
    private javax.swing.JTextField txt_nro_fact_surc_14;
    private javax.swing.JTextField txt_nro_fact_surc_15;
    private javax.swing.JTextField txt_nro_fact_surc_16;
    private javax.swing.JTextField txt_nro_fact_surc_17;
    private javax.swing.JTextField txt_nro_fact_surc_18;
    private javax.swing.JTextField txt_nro_fact_surc_19;
    private javax.swing.JTextField txt_nro_fact_surc_2;
    private javax.swing.JTextField txt_nro_fact_surc_20;
    private javax.swing.JTextField txt_nro_fact_surc_21;
    private javax.swing.JTextField txt_nro_fact_surc_22;
    private javax.swing.JTextField txt_nro_fact_surc_3;
    private javax.swing.JTextField txt_nro_fact_surc_4;
    private javax.swing.JTextField txt_nro_fact_surc_5;
    private javax.swing.JTextField txt_nro_fact_surc_6;
    private javax.swing.JTextField txt_nro_fact_surc_7;
    private javax.swing.JTextField txt_nro_fact_surc_8;
    private javax.swing.JTextField txt_nro_fact_surc_9;
    private javax.swing.JTextField txt_nro_seq_expo;
    private javax.swing.JTextField txt_nro_timbra_19;
    private javax.swing.JTextField txt_nro_timbra_24;
    private javax.swing.JTextField txt_nro_timbra_25;
    private javax.swing.JTextField txt_nro_timbra_26;
    private javax.swing.JTextField txt_nro_timbra_27;
    private javax.swing.JTextField txt_nro_timbra_28;
    private javax.swing.JTextField txt_nro_timbra_29;
    private javax.swing.JTextField txt_nro_timbra_30;
    private javax.swing.JTextField txt_nro_timbra_surc_10;
    private javax.swing.JTextField txt_nro_timbra_surc_11;
    private javax.swing.JTextField txt_nro_timbra_surc_12;
    private javax.swing.JTextField txt_nro_timbra_surc_13;
    private javax.swing.JTextField txt_nro_timbra_surc_14;
    private javax.swing.JTextField txt_nro_timbra_surc_15;
    private javax.swing.JTextField txt_nro_timbra_surc_16;
    private javax.swing.JTextField txt_nro_timbra_surc_17;
    private javax.swing.JTextField txt_nro_timbra_surc_18;
    private javax.swing.JTextField txt_nro_timbra_surc_2;
    private javax.swing.JTextField txt_nro_timbra_surc_20;
    private javax.swing.JTextField txt_nro_timbra_surc_21;
    private javax.swing.JTextField txt_nro_timbra_surc_22;
    private javax.swing.JTextField txt_nro_timbra_surc_23;
    private javax.swing.JTextField txt_nro_timbra_surc_3;
    private javax.swing.JTextField txt_nro_timbra_surc_4;
    private javax.swing.JTextField txt_nro_timbra_surc_5;
    private javax.swing.JTextField txt_nro_timbra_surc_6;
    private javax.swing.JTextField txt_nro_timbra_surc_7;
    private javax.swing.JTextField txt_nro_timbra_surc_8;
    private javax.swing.JTextField txt_nro_timbra_surc_9;
    private javax.swing.JTextField txt_nro_timbrado_expo;
    private javax.swing.JTextField txt_panel_pre_usu;
    private javax.swing.JTextField txt_seq_surc_10;
    private javax.swing.JTextField txt_seq_surc_11;
    private javax.swing.JTextField txt_seq_surc_12;
    private javax.swing.JTextField txt_seq_surc_13;
    private javax.swing.JTextField txt_seq_surc_14;
    private javax.swing.JTextField txt_seq_surc_15;
    private javax.swing.JTextField txt_seq_surc_16;
    private javax.swing.JTextField txt_seq_surc_17;
    private javax.swing.JTextField txt_seq_surc_18;
    private javax.swing.JTextField txt_seq_surc_19;
    private javax.swing.JTextField txt_seq_surc_2;
    private javax.swing.JTextField txt_seq_surc_20;
    private javax.swing.JTextField txt_seq_surc_21;
    private javax.swing.JTextField txt_seq_surc_22;
    private javax.swing.JTextField txt_seq_surc_23;
    private javax.swing.JTextField txt_seq_surc_24;
    private javax.swing.JTextField txt_seq_surc_25;
    private javax.swing.JTextField txt_seq_surc_26;
    private javax.swing.JTextField txt_seq_surc_27;
    private javax.swing.JTextField txt_seq_surc_28;
    private javax.swing.JTextField txt_seq_surc_29;
    private javax.swing.JTextField txt_seq_surc_3;
    private javax.swing.JTextField txt_seq_surc_30;
    private javax.swing.JTextField txt_seq_surc_4;
    private javax.swing.JTextField txt_seq_surc_5;
    private javax.swing.JTextField txt_seq_surc_6;
    private javax.swing.JTextField txt_seq_surc_7;
    private javax.swing.JTextField txt_seq_surc_8;
    private javax.swing.JTextField txt_seq_surc_9;
    private javax.swing.JTextField txt_seque;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextField txt_timbra;
    private javax.swing.JTextField txt_timbra_devol;
    public static javax.swing.JTextField txt_venta_fiscal;
    private javax.swing.JTextField txt_venta_min;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables

}
