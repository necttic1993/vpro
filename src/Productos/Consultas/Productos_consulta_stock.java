/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos.Consultas;

import Clases.Stock_minimo_pedidos;
import Clases.Stock_minimo_pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import Loggin_Principal.Principal;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto
 */
public class Productos_consulta_stock extends javax.swing.JDialog {

    DefaultTableModel model;

    public Productos_consulta_stock(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (Principal.lbl_mode_dark.getText().equals("oscuro")) {
            panel_stock.setBackground(new java.awt.Color(69, 84, 92));

        }

        txtprod.setDocument(new machusculas());

        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargarCod("");
        }
        if (Principal.lbl_usu_almacen.getText().equals("0000001")) {
            cargarCod("");
        }

    }

    public static String cod_pro_con_sucursales = "";

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
            Logger.getLogger(Productos_consulta_stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargarCod(String valor) {
        try {
            Connection cn = conectar.getInstance().getConnection();

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min.", "En Separación"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%'  AND pro_stock='A' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);

            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                registros[5] = rs.getString(7);
                registros[6] = rs.getString(22);
                registros[7] = rs.getString(23);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            Stock_minimo_pedidos pedido = new Stock_minimo_pedidos(7);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(7).setCellRenderer(pedido);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(250);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbprod_suc.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_2(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_3(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_4(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_5(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //new depositos
    void cargarCod_6(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_7(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_8(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_9(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_10(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_11(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_12(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_13(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_14(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_15(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_16(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_17(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_18(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_19(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_20(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_21(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_22(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_23(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_24(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);
            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_25(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_26(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_27(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_28(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_29(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_30(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
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
                registros[6] = rs.getString(22);

                model.addRow(registros);
            }
            tbprod_suc.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod_suc.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod_suc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod_suc.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod_suc.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod_suc.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod_suc.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod_suc.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_stock = new javax.swing.JPanel();
        txtprod = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbprod_suc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Productos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_stock.setBackground(new java.awt.Color(255, 255, 255));
        panel_stock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtprod.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });
        panel_stock.add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 400, 30));

        tbprod_suc = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbprod_suc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbprod_suc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprod_suc.setRequestFocusEnabled(false);
        tbprod_suc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbprod_sucMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbprod_sucMouseEntered(evt);
            }
        });
        tbprod_suc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbprod_sucKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbprod_sucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbprod_sucKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbprod_suc);

        panel_stock.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1080, 470));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel2.setFocusable(false);
        panel_stock.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_stock, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_stock, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {
            cargarCod(txtprod.getText());

        }

        if (Principal.lbl_usu_almacen.getText().equals("0000001")) {
            cargarCod(txtprod.getText());

        }

    }//GEN-LAST:event_txtprodKeyReleased

    private void tbprod_sucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprod_sucMouseClicked

        int filaModi = Productos_consulta_stock.tbprod_suc.getSelectedRow();
        cod_pro_con_sucursales = (String) Productos_consulta_stock.tbprod_suc.getValueAt(filaModi, 0);

        Consulta_stock dp;
        dp = new Consulta_stock(new javax.swing.JDialog(), true);
        dp.setVisible(true);
    }//GEN-LAST:event_tbprod_sucMouseClicked

    private void tbprod_sucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprod_sucKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            System.out.println("enter");

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {

            this.txtprod.requestFocus();

        }


    }//GEN-LAST:event_tbprod_sucKeyPressed

    private void tbprod_sucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprod_sucKeyReleased

    }//GEN-LAST:event_tbprod_sucKeyReleased

    private void tbprod_sucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprod_sucKeyTyped

    }//GEN-LAST:event_tbprod_sucKeyTyped

    private void txtprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txtprodKeyPressed

    private void tbprod_sucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprod_sucMouseEntered

    }//GEN-LAST:event_tbprod_sucMouseEntered

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        new Thread(new hilo()).start();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Productos_consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos_consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos_consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos_consulta_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_consulta_stock dialog = new Productos_consulta_stock(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.out.println("cerro");
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_stock;
    public static javax.swing.JTable tbprod_suc;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables

}
