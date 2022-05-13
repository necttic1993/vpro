/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Modifica_nota;

import Clases.Stock_minimo_pedidos;
import Clases.Stock_minimo_pro;
import Clases.machusculas;
import Conexion_DB.conectar;
import static Loggin_Principal.Principal.lbl_panel_pre_usu;
import Productos.DetallesProductos;
import Ventas.Principal_ventas;
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
public class Productos_ventas_modifica extends javax.swing.JDialog {

    DefaultTableModel tabla;
    FileInputStream fis;
    int longitudBytes;
    DefaultTableModel model;

    public Productos_ventas_modifica(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);

        txtprod.setDocument(new machusculas());
        txtprod.requestFocus();
        lbl_stock_minimo.setVisible(false);
        lbl_surcusal_id.setText(Principal_ventas.lbl_almacen_ventas.getText());

        if (lbl_surcusal_id.getText().equals("TODOS")) {
            cargarCod("");

        }

        if (lbl_surcusal_id.getText().equals("0000001")) {
            cargarCod("");

        }
        if (lbl_surcusal_id.getText().equals("0000002")) {
            cargarCod_2("");

        }
        if (lbl_surcusal_id.getText().equals("0000003")) {
            cargarCod_3("");

        }
        if (lbl_surcusal_id.getText().equals("0000004")) {
            cargarCod_4("");

        }
        if (lbl_surcusal_id.getText().equals("0000005")) {
            cargarCod_5("");

        }

        //new deposito
        if (lbl_surcusal_id.getText().equals("0000006")) {
            cargarCod_6("");

        }
        if (lbl_surcusal_id.getText().equals("0000007")) {
            cargarCod_7("");

        }
        if (lbl_surcusal_id.getText().equals("0000008")) {
            cargarCod_8("");

        }
        if (lbl_surcusal_id.getText().equals("0000009")) {
            cargarCod_9("");

        }
        if (lbl_surcusal_id.getText().equals("0000010")) {
            cargarCod_10("");

        }
        if (lbl_surcusal_id.getText().equals("0000011")) {
            cargarCod_11("");

        }
        if (lbl_surcusal_id.getText().equals("0000012")) {
            cargarCod_12("");

        }
        if (lbl_surcusal_id.getText().equals("0000013")) {
            cargarCod_13("");

        }
        if (lbl_surcusal_id.getText().equals("0000014")) {
            cargarCod_14("");

        }
        if (lbl_surcusal_id.getText().equals("0000015")) {
            cargarCod_15("");

        }
        if (lbl_surcusal_id.getText().equals("0000016")) {
            cargarCod_16("");

        }
        if (lbl_surcusal_id.getText().equals("0000017")) {
            cargarCod_17("");

        }
        if (lbl_surcusal_id.getText().equals("0000018")) {
            cargarCod_18("");

        }
        if (lbl_surcusal_id.getText().equals("0000019")) {
            cargarCod_19("");

        }
        if (lbl_surcusal_id.getText().equals("0000020")) {
            cargarCod_20("");

        }
        if (lbl_surcusal_id.getText().equals("0000021")) {
            cargarCod_21("");

        }
        if (lbl_surcusal_id.getText().equals("0000022")) {
            cargarCod_22("");

        }
        if (lbl_surcusal_id.getText().equals("0000023")) {
            cargarCod_23("");

        }
        if (lbl_surcusal_id.getText().equals("0000024")) {
            cargarCod_24("");

        }
        if (lbl_surcusal_id.getText().equals("0000025")) {
            cargarCod_25("");

        }
        if (lbl_surcusal_id.getText().equals("0000026")) {
            cargarCod_26("");

        }
        if (lbl_surcusal_id.getText().equals("0000027")) {
            cargarCod_27("");

        }
        if (lbl_surcusal_id.getText().equals("0000028")) {
            cargarCod_28("");

        }
        if (lbl_surcusal_id.getText().equals("0000029")) {
            cargarCod_29("");

        }
        if (lbl_surcusal_id.getText().equals("0000030")) {
            cargarCod_30("");

        }

    }

    public static String cod_pro_ventas = "";
    public static String cod_pro_ventas_des = "";

    ////////////////////////////////////////////activar en caso de varios maquinas////////////////////////////////////
  /*    private class hilo implements Runnable {

     @Override
     public void run() {
     while (true) {
     cargarCod("");

     try {
     Thread.sleep(90000);
     } catch (InterruptedException ex) {
     Logger.getLogger(Productos_ventas.class.getName()).log(Level.SEVERE, null, ex);

     }
     }
     }

     }*/
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
            Logger.getLogger(Productos_ventas_modifica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargarCod(String valor) {
        try {

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min.", "En Separación"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%'  AND pro_stock='A' ORDER BY pro_cod DESC LIMIT 100";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);

            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                if (Ventas_venta_modifica.txt_class_cli_ventas.getText().equals("MAYORISTAS")) {
                    registros[5] = rs.getString(8);
                } else {
                    registros[5] = rs.getString(7);
                }

                registros[6] = rs.getString(22);
                registros[7] = rs.getString(23);

                model.addRow(registros);
            }
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            Stock_minimo_pedidos pedido = new Stock_minimo_pedidos(7);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(7).setCellRenderer(pedido);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(250);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbprod.getColumnModel().getColumn(7).setPreferredWidth(100);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //new depositos
    void cargarCod_6(String valor) {
        try {
            Connection cn = conectar.getInstance().getConnection();

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_7(String valor) {
        try {
            Connection cn = conectar.getInstance().getConnection();

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);
            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargarCod_28(String valor) {
        try {
            Connection cn = conectar.getInstance().getConnection();

            String[] titulos = {"Código", "Cód. Barra", "Descripción", "Especificaiones", "Cantidad", "Precio Venta", "Stock Min."};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);

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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
            tbprod.setModel(model);

            Stock_minimo_pro color = new Stock_minimo_pro(4, 6);
            //tbprod.getColumnModel().getColumn(0).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(2).setCellRenderer(color);
            tbprod.getColumnModel().getColumn(4).setCellRenderer(color);

            tbprod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbprod.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbprod.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbprod.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbprod.getColumnModel().getColumn(5).setPreferredWidth(85);
            tbprod.getColumnModel().getColumn(6).setPreferredWidth(80);
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
        tbprod = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbl_stock_minimo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_surcusal_id = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Productos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtprod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });
        jPanel1.add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 390, 30));

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

        tbprod = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbprod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprod.setRequestFocusEnabled(false);
        tbprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbprodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbprodMouseEntered(evt);
            }
        });
        tbprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbprodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbprodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbprodKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbprod);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1080, 470));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 30));

        lbl_stock_minimo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel1.add(lbl_stock_minimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_3/lupa.png"))); // NOI18N
        jLabel2.setFocusable(false);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

        lbl_surcusal_id.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_surcusal_id.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbl_surcusal_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 120, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Stock referente N°:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
        if (lbl_surcusal_id.getText().equals("TODOS")) {
            cargarCod(txtprod.getText());

        }

        if (lbl_surcusal_id.getText().equals("0000001")) {
            cargarCod(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000002")) {
            cargarCod_2(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000003")) {
            cargarCod_3(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000004")) {
            cargarCod_4(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000005")) {
            cargarCod_5(txtprod.getText());

        }

        ///new depositos
        if (lbl_surcusal_id.getText().equals("0000006")) {
            cargarCod_6(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000007")) {
            cargarCod_7(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000008")) {
            cargarCod_8(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000009")) {
            cargarCod_9(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000010")) {
            cargarCod_10(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000011")) {
            cargarCod_11(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000012")) {
            cargarCod_12(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000013")) {
            cargarCod_13(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000014")) {
            cargarCod_14(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000015")) {
            cargarCod_15(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000016")) {
            cargarCod_16(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000017")) {
            cargarCod_17(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000018")) {
            cargarCod_18(txtprod.getText());

        }

        if (lbl_surcusal_id.getText().equals("0000019")) {
            cargarCod_19(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000020")) {
            cargarCod_20(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000021")) {
            cargarCod_21(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000022")) {
            cargarCod_22(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000023")) {
            cargarCod_23(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000024")) {
            cargarCod_24(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000025")) {
            cargarCod_25(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000026")) {
            cargarCod_26(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000027")) {
            cargarCod_27(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000028")) {
            cargarCod_28(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000029")) {
            cargarCod_29(txtprod.getText());

        }
        if (lbl_surcusal_id.getText().equals("0000030")) {
            cargarCod_30(txtprod.getText());

        }
    }//GEN-LAST:event_txtprodKeyReleased

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
        txtprod.requestFocus();
        txtprod.setText("");

    }//GEN-LAST:event_busActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tbprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprodMouseClicked
        /*  try {
         DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta_modifica.tb_factura.getModel();
         String[] dato = new String[5];

         int fila = tbprod.getSelectedRow();

         if (fila == -1) {
         JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
         } else {
         String codins = tbprod.getValueAt(fila, 0).toString();
         String desins = tbprod.getValueAt(fila, 2).toString();
         String preins = tbprod.getValueAt(fila, 5).toString();
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
         for (int i = 0; i < Ventas_venta_modifica.tb_factura.getRowCount(); i++) {
         Object com = Ventas_venta_modifica.tb_factura.getValueAt(i, 0);
         if (codins.equals(com)) {
         j = i;
         Ventas_venta_modifica.tb_factura.setValueAt(cant, i, 3);
         c = c + 1;

         }

         }
         if (c == 0) {

         dato[0] = codins;
         dato[1] = desins;
         dato[2] = preins;
         dato[3] = cant;

         tabladet.addRow(dato);

         Ventas_venta_modifica.tb_factura.setModel(tabladet);
         this.txtprod.requestFocus();

         }
         Ventas_venta_modifica.btncalcular.doClick();
         }

         }

         }
         } catch (HeadlessException | NumberFormatException e) {
         }        */

        if (Ventas_venta_modifica.lbl_cant_produ_modifica.getText().equals("11")) {
            JOptionPane.showMessageDialog(null, "Cantidad de producto excedido");
        } else {
            if (lbl_panel_pre_usu.getText().equals("N")) {
                int filaModi = Productos_ventas_modifica.tbprod.getSelectedRow();
                cod_pro_ventas = (String) Productos_ventas_modifica.tbprod.getValueAt(filaModi, 0);
                Panel_precios_ventas_modifica pp;
                pp = new Panel_precios_ventas_modifica(new javax.swing.JDialog(), true);
                pp.setVisible(true);
            } else {
                int filaModi = Productos_ventas_modifica.tbprod.getSelectedRow();
                cod_pro_ventas = (String) Productos_ventas_modifica.tbprod.getValueAt(filaModi, 0);
                Precio_modelo_dos_modifica ppd;
                ppd = new Precio_modelo_dos_modifica(new javax.swing.JDialog(), true);
                ppd.setVisible(true);

            }

        }
    }//GEN-LAST:event_tbprodMouseClicked

    private void tbprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {
            /*  try {
             DefaultTableModel tabladet = (DefaultTableModel) Ventas_venta_modifica.tb_factura.getModel();
             String[] dato = new String[5];

             int fila = tbprod.getSelectedRow();

             if (fila == -1) {
             JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
             } else {
             String codins = tbprod.getValueAt(fila, 0).toString();
             String desins = tbprod.getValueAt(fila, 2).toString();
             String preins = tbprod.getValueAt(fila, 5).toString();
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
             for (int i = 0; i < Ventas_venta_modifica.tb_factura.getRowCount(); i++) {
             Object com = Ventas_venta_modifica.tb_factura.getValueAt(i, 0);
             if (codins.equals(com)) {
             j = i;
             Ventas_venta_modifica.tb_factura.setValueAt(cant, i, 3);
             c = c + 1;

             }

             }
             if (c == 0) {

             dato[0] = codins;
             dato[1] = desins;
             dato[2] = preins;
             dato[3] = cant;

             tabladet.addRow(dato);

             Ventas_venta_modifica.tb_factura.setModel(tabladet);
             this.txtprod.requestFocus();

             }
             Ventas_venta_modifica.btncalcular.doClick();
             }

             }

             }
             } catch (HeadlessException | NumberFormatException e) {
             }     */    // TODO add your handling code here:
            if (Ventas_venta_modifica.lbl_cant_produ_modifica.getText().equals("11")) {
                JOptionPane.showMessageDialog(null, "Cantidad de producto excedido");
            } else {
                if (lbl_panel_pre_usu.getText().equals("N")) {
                    int filaModi = Productos_ventas_modifica.tbprod.getSelectedRow();
                    cod_pro_ventas = (String) Productos_ventas_modifica.tbprod.getValueAt(filaModi, 0);
                    Panel_precios_ventas_modifica pp;
                    pp = new Panel_precios_ventas_modifica(new javax.swing.JDialog(), true);
                    pp.setVisible(true);
                } else {
                    int filaModi = Productos_ventas_modifica.tbprod.getSelectedRow();
                    cod_pro_ventas = (String) Productos_ventas_modifica.tbprod.getValueAt(filaModi, 0);
                    Precio_modelo_dos_modifica ppd;
                    ppd = new Precio_modelo_dos_modifica(new javax.swing.JDialog(), true);
                    ppd.setVisible(true);

                }
            }
        }

        if (Tecla == KeyEvent.VK_SPACE) {
            int filaModi = Productos_ventas_modifica.tbprod.getSelectedRow();
            cod_pro_ventas_des = (String) Productos_ventas_modifica.tbprod.getValueAt(filaModi, 0);

            DetallesProductos dp;
            dp = new DetallesProductos(new javax.swing.JDialog(), true);
            dp.setVisible(true);
        }

        if (Tecla == KeyEvent.VK_ESCAPE) {

            this.txtprod.requestFocus();

        }

        if (Tecla == KeyEvent.VK_C) {

        }
    }//GEN-LAST:event_tbprodKeyPressed

    private void tbprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyReleased

    }//GEN-LAST:event_tbprodKeyReleased

    private void tbprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbprodKeyTyped

    }//GEN-LAST:event_tbprodKeyTyped

    private void txtprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_txtprodKeyPressed

    private void tbprodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprodMouseEntered

    }//GEN-LAST:event_tbprodMouseEntered

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
            java.util.logging.Logger.getLogger(Productos_ventas_modifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos_ventas_modifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos_ventas_modifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos_ventas_modifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_ventas_modifica dialog = new Productos_ventas_modifica(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_stock_minimo;
    public static javax.swing.JLabel lbl_surcusal_id;
    public static javax.swing.JTable tbprod;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables

}
