/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticas_productos;

import CP.Costo;
import Conexion_DB.conectar;
import static Loggin_Principal.NECTTIC.ingreso;
import Loggin_Principal.Principal;
import Loggin_Principal.Seleccion_surcu_cp_stock;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Roberto
 */
public class Productos_CP extends javax.swing.JDialog {

    DefaultTableModel tabla;
    FileInputStream fis;
    int longitudBytes;
    DefaultTableModel model;

    public Productos_CP(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        //AWTUtilities.setWindowShape(this, forma);

        lbl_almacen_cp.setText(Principal.lbl_usu_almacen.getText());

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
            Logger.getLogger(Productos_CP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargar(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_cant > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(5); ///stock 25 alma 2               
                registros[4] = rs.getString(6);
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /////////////////all///////////////////////////
    void cargar_2(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_2 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(25);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_3(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_3 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(26);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_4(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_4 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(27);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_5(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_5 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(28);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_6(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_6 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(29);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_7(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_7 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(30);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_8(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_8 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(31);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_9(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_9 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(32);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_10(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%'AND pro_stock_10 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(33);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_11(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_11 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(34);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_12(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_12 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(35);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_13(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_13 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(36);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_14(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_14 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(37);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_15(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_15 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(38);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_16(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_16 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(39);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_17(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_17 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(40);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_18(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_18 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(41);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_19(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_19 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(42);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_20(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_20 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(43);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_21(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_21 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(44);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_22(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_22 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(45);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_23(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_23 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(46);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_24(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_24 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(47);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_25(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_25 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(48);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_26(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_26 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(49);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_27(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_27 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(50);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_28(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_28 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(51);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_29(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_29 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(52);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    void cargar_30(String valor) {
        try {

            String[] titulos = {"C??digo", "C??d. Barra", "Descripci??n", "Cantidad", "Precio Costo", "Precio Venta", "Total Costo", "Estimado Ventas"};
            String[] registros = new String[23];
            model = new DefaultTableModel(null, titulos);
            Connection cn = conectar.getInstance().getConnection();

            String cons = " select * from tienda_productos WHERE CONCAT (pro_cod,pro_cod_barra,pro_des) LIKE '%" + valor + "%' AND pro_stock_30 > 0 AND pro_stock <> 'P'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(53);
                if (Principal.modelo_cp.getText().equals("1")) {
                    registros[4] = rs.getString(6);
                } else {
                    registros[4] = rs.getString(8);
                }
                registros[5] = rs.getString(7);

                model.addRow(registros);
            }
            tb_prod.setModel(model);

            // Stock_minimo color = new Stock_minimo(6);
            // tbprod.getColumnModel().getColumn(4).setCellRenderer(color);
            tb_prod.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_prod.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb_prod.getColumnModel().getColumn(2).setPreferredWidth(327);
            tb_prod.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_prod.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_prod.getColumnModel().getColumn(7).setPreferredWidth(100);
            conectar.getInstance().closeConnection(cn);

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bus = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_prod = new javax.swing.JTable();
        lblcanpro = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_valor_compras = new javax.swing.JLabel();
        lbl_total_ventas = new javax.swing.JLabel();
        lbl_saldo_totales = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_cant_productos = new javax.swing.JLabel();
        lbl_almacen_cp = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tb_prod = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tb_prod.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tb_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_prod.setRequestFocusEnabled(false);
        tb_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_prodMouseClicked(evt);
            }
        });
        tb_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_prodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_prodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_prodKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_prod);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1080, 430));

        lblcanpro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcanpro.setForeground(new java.awt.Color(204, 0, 0));
        lblcanpro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcanpro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblcanpro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblcanpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 500, 130, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/print.png"))); // NOI18N
        jButton1.setToolTipText("Imprimir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 80, 50));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Total valor ventas:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 130, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Listado de Stock con saldo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        lbl_valor_compras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_valor_compras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_valor_compras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lbl_valor_compras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_valor_compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 230, 30));

        lbl_total_ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_total_ventas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total_ventas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lbl_total_ventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_total_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 230, 30));

        lbl_saldo_totales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_saldo_totales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_saldo_totales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lbl_saldo_totales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_saldo_totales, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 230, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Saldo total de Stock:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 150, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Total valor compras:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 150, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 230, 10));

        lbl_cant_productos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_cant_productos.setForeground(new java.awt.Color(0, 102, 51));
        lbl_cant_productos.setText("0");
        jPanel1.add(lbl_cant_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 100, 30));

        lbl_almacen_cp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_almacen_cp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja_2/iconos/dpto.png"))); // NOI18N
        lbl_almacen_cp.setText("0000000");
        lbl_almacen_cp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_almacen_cp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbl_almacen_cp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_almacen_cpMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_almacen_cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 110, 60));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_4/graphic.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 80, 50));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Total Stock:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 500, 80, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Total de Producto:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed


    }//GEN-LAST:event_busActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tb_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_prodMouseClicked


    }//GEN-LAST:event_tb_prodMouseClicked

    private void tb_prodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prodKeyPressed
        char Tecla = evt.getKeyChar();

        if (Tecla == KeyEvent.VK_ENTER) {

        }

        if (Tecla == KeyEvent.VK_ESCAPE) {

        }
    }//GEN-LAST:event_tb_prodKeyPressed

    private void tb_prodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prodKeyReleased

    }//GEN-LAST:event_tb_prodKeyReleased

    private void tb_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_prodKeyTyped

    }//GEN-LAST:event_tb_prodKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ///
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                Costo cl;// Instaciamos la clase empleado
                List<Costo> lista = new ArrayList<>(); //Creamos una lista de empleados con ArrayList para obtener cada empleado
                for (int i = 0; i < tb_prod.getRowCount(); i++) { // Iterena cada fila de la tabla
                    cl = new Costo(tb_prod.getValueAt(i, 0).toString(), tb_prod.getValueAt(i, 2).toString(), //Tomamos de la tabla el valor de cada columna y creamos un objeto empleado
                            tb_prod.getValueAt(i, 3).toString(), tb_prod.getValueAt(i, 4).toString(), tb_prod.getValueAt(i, 5).toString());
                    lista.add(cl); //Agregamos el objeto empleado a la lista
                }

                try {

                    String cantStock = lblcanpro.getText();
                    String valorventas = lbl_total_ventas.getText();
                    String valorcompras = lbl_valor_compras.getText();
                    String saldo = lbl_saldo_totales.getText();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("cant", cantStock);
                    parametro.put("ventas", valorventas);
                    parametro.put("compras", valorcompras);
                    parametro.put("saldo", saldo);

                    URL in = this.getClass().getResource("/CP/stock_gral_CP.jasper");
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                } catch (JRException ex) {
                    Logger.getLogger(Productos_CP.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbl_almacen_cpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_almacen_cpMouseClicked
        if (Principal.lbl_usu_almacen.getText().equals("TODOS")) {

            Seleccion_surcu_cp_stock sl;
            sl = new Seleccion_surcu_cp_stock(new javax.swing.JDialog(), true);
            sl.setVisible(true);

        }
    }//GEN-LAST:event_lbl_almacen_cpMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (lbl_almacen_cp.getText().equals("TODOS")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Surcusal/Almacen v??lido");
        } else {

            if (lbl_almacen_cp.getText().equals("0000001")) {
                limpiar();
                cargar("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000002")) {
                limpiar();
                cargar_2("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000003")) {
                limpiar();
                cargar_3("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000004")) {
                limpiar();
                cargar_4("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000005")) {
                limpiar();
                cargar_5("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000006")) {
                limpiar();
                cargar_6("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000007")) {
                limpiar();
                cargar_7("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000008")) {
                limpiar();
                cargar_8("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000009")) {
                limpiar();
                cargar_9("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000010")) {
                limpiar();
                cargar_10("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000011")) {
                limpiar();
                cargar_11("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000012")) {
                limpiar();
                cargar_12("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000013")) {
                limpiar();
                cargar_13("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000014")) {
                limpiar();
                cargar_14("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000015")) {
                limpiar();
                cargar_15("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000016")) {
                limpiar();
                cargar_16("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000017")) {
                limpiar();
                cargar_17("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000018")) {
                limpiar();
                cargar_18("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000019")) {
                limpiar();
                cargar_19("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000020")) {
                limpiar();
                cargar_20("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000021")) {
                limpiar();
                cargar_21("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000022")) {
                limpiar();
                cargar_22("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000023")) {
                limpiar();
                cargar_23("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000024")) {
                limpiar();
                cargar_24("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000025")) {
                limpiar();
                cargar_25("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000026")) {
                limpiar();
                cargar_26("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000027")) {
                limpiar();
                cargar_27("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000028")) {
            limpiar();
                cargar_28("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000029")) {
                limpiar();
                cargar_29("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }
            if (lbl_almacen_cp.getText().equals("0000030")) {
                limpiar();
                cargar_30("");
                calcularCantidadPro();
                lista_ventas_totales();
                lista_compras_totales();
                lista_neto_generales();
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Productos_CP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos_CP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos_CP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos_CP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_CP dialog = new Productos_CP(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lbl_almacen_cp;
    private javax.swing.JLabel lbl_cant_productos;
    private javax.swing.JLabel lbl_saldo_totales;
    private javax.swing.JLabel lbl_total_ventas;
    private javax.swing.JLabel lbl_valor_compras;
    private javax.swing.JLabel lblcanpro;
    public static javax.swing.JTable tb_prod;
    // End of variables declaration//GEN-END:variables

    public void calcularCantidadPro() {

        int Acumulador = 0;
        int TF = tb_prod.getRowCount();

        for (int i = 0; i < TF; i++) {
            int CantidadPro = Integer.valueOf(tb_prod.getValueAt(i, 3).toString().replaceAll("\\s", "").replaceAll("[^0-9]", ""));
            Acumulador = Acumulador + CantidadPro;
        }
        //</editor-fold>
        lblcanpro.setText(MaskaraPrecioUnitarioEnteros(String.valueOf(Acumulador)));
        lbl_cant_productos.setText(String.valueOf(TF));

    }

    public String MaskaraPrecioUnitarioEnteros(String ValorGuaranies) {
        DecimalFormat format = new DecimalFormat("###,###.##");
        long NumeroIntacto = 0L;
        String NroFormatado = "";
        String ValorViejo = ValorGuaranies;
        String a = ValorViejo.replace(",", "");
        NumeroIntacto = Long.valueOf(a);
        NroFormatado = format.format(NumeroIntacto);
        String LuzParaMisOjos = NroFormatado;
        return LuzParaMisOjos;
    }

    public void lista_ventas_totales() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_prod.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_prod.getValueAt(i, 5).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_prod.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_prod.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 7);
            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            lbl_total_ventas.setText(total);

        }
    }

    public void lista_compras_totales() {

        String imp = "0", subtotal = "0", iva = "0", total = "0";

        for (int i = 0; i < tb_prod.getRowCount(); i++) {
            BigDecimal PulidoPrec = ingreso.TransformReales(tb_prod.getValueAt(i, 4).toString().replaceAll("\\s", ""));
            BigDecimal PulidoCant = ingreso.TransformReales(tb_prod.getValueAt(i, 3).toString().replaceAll("\\s", ""));

            imp = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(PulidoPrec.multiply(PulidoCant).toString());
            subtotal = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(imp)).toString());

            tb_prod.setValueAt(ingreso.MaskareaRealesDado_String_ExclusiveMonedas(String.valueOf(imp)), i, 6);
            total = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(ingreso.TransformReales(subtotal).add(ingreso.TransformReales(iva)).toString());

            lbl_valor_compras.setText(total);

        }
    }

    public void lista_neto_generales() {
        String net = "0";
        //////////////////////////////////////////segundo calculo
        BigDecimal valor_total = ingreso.TransformReales(lbl_total_ventas.getText());
        BigDecimal valor_ultimo = ingreso.TransformReales(lbl_valor_compras.getText());
        net = ingreso.MaskareaRealesDado_String_ExclusiveMonedas(valor_total.subtract(valor_ultimo).toString());
        lbl_saldo_totales.setText(net);

    }

    public void limpiar() {
        lbl_valor_compras.setText("0");
        lbl_saldo_totales.setText("0");
        lbl_total_ventas.setText("0");
        lblcanpro.setText("0");

    }

}
