/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.transferencias;

import Clases.Stock_minimo;
import Clases.machusculas;
import Conexion_DB.conectar;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto
 */
public class Productos_transfe extends javax.swing.JDialog {

    DefaultTableModel tabla;
    FileInputStream fis;
    int longitudBytes;
    DefaultTableModel model;

    public Productos_transfe(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000001")) {
            cargar("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000002")) {
            cargar_2("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000003")) {
            cargar_3("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000004")) {
            cargar_4("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000005")) {
            cargar_5("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000006")) {
            cargar_6("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000007")) {
            cargar_7("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000008")) {
            cargar_8("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000009")) {
            cargar_9("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000010")) {
            cargar_10("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000011")) {
            cargar_11("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000012")) {
            cargar_12("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000013")) {
            cargar_13("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000014")) {
            cargar_14("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000015")) {
            cargar_15("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000016")) {
            cargar_16("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000017")) {
            cargar_17("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000018")) {
            cargar_18("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000019")) {
            cargar_19("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000020")) {
            cargar_20("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000021")) {
            cargar_21("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000022")) {
            cargar_22("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000023")) {
            cargar_23("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000024")) {
            cargar_24("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000025")) {
            cargar_25("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000026")) {
            cargar_26("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000027")) {
            cargar_27("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000028")) {
            cargar_28("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000029")) {
            cargar_29("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000030")) {
            cargar_30("");
            lbl_alma_nro.setText(trans_dep_pro.nombre_cuneta_ori.getText());
        }
        txtprod.setDocument(new machusculas());

        txtprod.requestFocus();

    }

    public static String cod_pro_ventas = "";

    String comparar(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(5);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_2(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(25);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_3(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(26);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_4(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(27);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_5(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(28);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_6(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(29);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_7(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(30);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_8(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(31);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_9(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(32);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_10(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(33);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_11(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(34);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_12(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(35);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_13(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(36);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_14(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(37);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_15(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(38);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_16(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(39);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_17(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(40);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_18(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(41);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_19(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(42);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_20(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(43);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_21(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(44);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_22(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(45);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_23(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(46);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_24(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(47);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_25(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(48);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_26(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(49);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_27(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(50);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_28(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(51);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_29(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(52);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    String comparar_30(String cod) {
        String cant = "";
        try {
            Connection cn = conectar.getInstance().getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tienda_productos WHERE pro_cod='" + cod + "' ");
            while (rs.next()) {
                cant = rs.getString(53);
            }
            conectar.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(Productos_transfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargar(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_2(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(25);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_3(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(26);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_4(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(27);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_5(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(28);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_6(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(29);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_7(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(30);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_8(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(31);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_9(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(32);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_10(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(33);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_11(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(34);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_12(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(35);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_13(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(36);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_14(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(37);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_15(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(38);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_16(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(39);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_17(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(40);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_18(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(41);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_19(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(42);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_20(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(43);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_21(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(44);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_22(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(45);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_23(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(46);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_24(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(47);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_25(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(48);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_26(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(49);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_27(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(50);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_28(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(51);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_29(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(52);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_30(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(53);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod_trans.setModel(model);

            Stock_minimo color = new Stock_minimo(4);
            tb_prod_trans.getColumnModel().getColumn(4).setCellRenderer(color);

            tb_prod_trans.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod_trans.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod_trans.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod_trans.getColumnModel().getColumn(3).setPreferredWidth(330);
            tb_prod_trans.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_prod_trans.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtprod = new javax.swing.JTextField();
        bus = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_prod_trans = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_alma_nro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Productos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtprod.setBorder(null);
        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });
        jPanel1.add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 13, 360, 23));

        bus.setMnemonic('w');
        bus.setText("...");
        bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busActionPerformed(evt);
            }
        });
        jPanel1.add(bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 0, 30));

        btnsalir.setMnemonic('s');
        btnsalir.setText("..");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 0, -1));

        tb_prod_trans = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_prod_trans.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_prod_trans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_prod_trans.setRequestFocusEnabled(false);
        tb_prod_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_prod_transMouseClicked(evt);
            }
        });
        tb_prod_trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_prod_transKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_prod_transKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_prod_transKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_prod_trans);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1100, 470));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 30));

        lbl_alma_nro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_alma_nro.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_alma_nro, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 480, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Stock referente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000001")) {
            cargar(txtprod.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000002")) {
            cargar_2(txtprod.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000003")) {
            cargar_3(txtprod.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000004")) {
            cargar_4(txtprod.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000005")) {
            cargar_5(txtprod.getText());
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000006")) {
            cargar_6(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000007")) {
            cargar_7(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000008")) {
            cargar_8(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000009")) {
            cargar_9(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000010")) {
            cargar_10(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000011")) {
            cargar_11(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000012")) {
            cargar_12(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000013")) {
            cargar_13(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000014")) {
            cargar_14(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000015")) {
            cargar_15(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000016")) {
            cargar_16(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000017")) {
            cargar_17(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000018")) {
            cargar_18(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000019")) {
            cargar_19(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000020")) {
            cargar_20(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000021")) {
            cargar_21(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000022")) {
            cargar_22(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000023")) {
            cargar_23(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000024")) {
            cargar_24(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000025")) {
            cargar_25(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000026")) {
            cargar_26(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000027")) {
            cargar_27(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000028")) {
            cargar_28(txtprod.getText());
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000029")) {
            cargar_29(txtprod.getText());
        }


    }//GEN-LAST:event_txtprodKeyReleased

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
        txtprod.requestFocus();
        txtprod.setText("");

    }//GEN-LAST:event_busActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tb_prod_transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_prod_transMouseClicked
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000001")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000002")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_2(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000003")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_3(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000004")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_4(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000005")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_5(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000006")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_6(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000007")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_7(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000008")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_8(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000009")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_9(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000010")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_10(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000011")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_11(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000012")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_12(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000013")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_13(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000014")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_14(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000015")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_15(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000016")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_16(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }

        if (trans_dep_pro.nro_alma_ori.getText().equals("0000017")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_17(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000018")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_18(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000019")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_19(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000020")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_20(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000021")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_21(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000022")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_22(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000023")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_23(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000024")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_24(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000025")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_25(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000026")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_26(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000027")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_27(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000028")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_28(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000029")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_29(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        if (trans_dep_pro.nro_alma_ori.getText().equals("0000030")) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) trans_dep_pro.tb_trans_stock.getModel();
                String[] dato = new String[5];

                int fila = tb_prod_trans.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
                } else {
                    String codins = tb_prod_trans.getValueAt(fila, 0).toString();
                    String desins = tb_prod_trans.getValueAt(fila, 2).toString();
                    String preins = tb_prod_trans.getValueAt(fila, 5).toString();
                    int c = 0;
                    int j = 0;
                    String cant = JOptionPane.showInputDialog("ingrese cantidad");
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        int canting = Integer.parseInt(cant);
                        int comp = Integer.parseInt(comparar_30(codins));
                        if (canting > comp) {
                            JOptionPane.showMessageDialog(this, "Ud. no cuenta con el stock apropiado");
                        } else {
                            for (int i = 0; i < trans_dep_pro.tb_trans_stock.getRowCount(); i++) {
                                Object com = trans_dep_pro.tb_trans_stock.getValueAt(i, 0);
                                if (codins.equals(com)) {
                                    j = i;
                                    trans_dep_pro.tb_trans_stock.setValueAt(cant, i, 3);
                                    c = c + 1;

                                }

                            }
                            if (c == 0) {

                                dato[0] = codins;
                                dato[1] = desins;
                                dato[2] = preins;
                                dato[3] = cant;

                                tabladet.addRow(dato);

                                trans_dep_pro.tb_trans_stock.setModel(tabladet);

                            }
                        }
                        trans_dep_pro.btncalcular.doClick();

                    }

                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
    }//GEN-LAST:event_tb_prod_transMouseClicked

    private void tb_prod_transKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prod_transKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {

            this.txtprod.requestFocus();

        }
    }//GEN-LAST:event_tb_prod_transKeyPressed

    private void tb_prod_transKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prod_transKeyReleased

    }//GEN-LAST:event_tb_prod_transKeyReleased

    private void tb_prod_transKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prod_transKeyTyped

    }//GEN-LAST:event_tb_prod_transKeyTyped

    private void txtprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txtprodKeyPressed

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
            java.util.logging.Logger.getLogger(Productos_transfe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos_transfe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos_transfe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos_transfe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Productos_transfe dialog = new Productos_transfe(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton bus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_alma_nro;
    public static javax.swing.JTable tb_prod_trans;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables

}
