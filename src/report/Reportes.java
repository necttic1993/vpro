package report;

import static Administrativo.ventas_anteriores_usuarios.*;
import static Administrativo.ventas_lucro_total.*;
import Conexion_DB.conectar;
import static Estadisticas_productos.Pro_con_stock.txt_id_dep_fisico;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes {

//sin stock
    public void ReporteProductos() throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            // Connection a;
            // a = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?user=system&password=canis");
            String dep = txt_id_dep_fisico.getText();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("dep", dep);

            JasperReport reporte = null;
            URL in = this.getClass().getResource("/Impresiones/stock_gral.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setTitle("Productos");
            ver.setVisible(true);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void ReporteProductosStock() throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            // Connection a;
            // a = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?user=system&password=canis");
            String dep = txt_id_dep_fisico.getText();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("dep", dep);

            JasperReport reporte = null;
            URL in = this.getClass().getResource("/Impresiones/stock_gral_con_stok.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setTitle("Productos");
            ver.setVisible(true);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void ReporteClientes() throws SQLException, JRException {

        try {
            // Connection a;
            // a = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?user=system&password=canis");
            Connection cn = conectar.getInstance().getConnection();

            JasperReport reporte = null;
            URL in = this.getClass().getResource("/Impresiones/listado_clientes.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setTitle("Listado de Clientes");
            ver.setVisible(true);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void ReporteProv() throws SQLException, JRException {

        try {
            // Connection a;
            // a = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?user=system&password=canis");
            Connection cn = conectar.getInstance().getConnection();

            JasperReport reporte = null;
            URL in = this.getClass().getResource("/Impresiones/listado_proveedor.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setTitle("Listado de Proveedores");
            ver.setVisible(true);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    //recibo credito
    public void receb(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Caja_2/Pago_Plazos/recibo_ventas_cred.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void recep(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Impresiones/tickect_ventas.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recepM2(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Impresiones/matricial_tickect_ventas.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    //2
    public void recep_2(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_2/tickect_ventas_2.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }
//nota surcusal 16

    public void recep_16(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/ventas_16/tickect_ventas_16.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 18
    public void recep_18(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_18/tickect_ventas_18.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

////nota surcusal 20
    public void recep_20(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_20/tickect_ventas_20.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 7
    public void recep_7(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_7/tickect_ventas_7.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 8
    public void recep_8(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_8/tickect_ventas_8.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 9
    public void recep_9(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_9/tickect_ventas_9.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 10
    public void recep_10(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_10/tickect_ventas_10.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 11
    public void recep_11(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_11/tickect_ventas_11.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }
    ///nota surcusal 12

    public void recep_12(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_12/tickect_ventas_12.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 12
    public void recep_13(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_13/tickect_ventas_13.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }
    ///nota surcusal 14

    public void recep_14(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_14/tickect_ventas_14.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 21
    public void recep_21(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_21/tickect_ventas_21.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }
    ///nota surcusal 22

    public void recep_22(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_22/tickect_ventas_22.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 19
    public void recep_19(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_19/tickect_ventas_19.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 15
    public void recep_15(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_15/tickect_ventas_15.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 3
    public void recep_3(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_3/tickect_ventas_3.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    ///nota surcusal 3
    public void recep_4(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_4/tickect_ventas_4.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_5(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_5/tickect_ventas_5.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_6(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_6/tickect_ventas_6.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_23(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_23/tickect_ventas_23.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_24(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_24/tickect_ventas_24.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_25(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_25/tickect_ventas_25.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_26(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_26/tickect_ventas_26.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_27(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_27/tickect_ventas_27.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_28(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_28/tickect_ventas_28.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_29(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_29/tickect_ventas_29.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_30(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);

            URL in = this.getClass().getResource("/Ventas_30/tickect_ventas_30.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recep_17(String cod, String Moneda) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Ventas_17/tickect_ventas_17.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void recepRe(String cod, String Moneda) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        //  PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);
            parametro.put("moneda", Moneda);
            URL in = this.getClass().getResource("/Impresiones/tickect_ventas.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
//////////////////////////////////visualizar reporte////////////////////////////
            /*  JasperViewer ver = new JasperViewer(print, false);
             ver.setTitle("Listado de Proveedores");
             ver.setVisible(true);*/
//////////////////////////////////////////////imprime en la impresora default/////////////////////////////////////
            /*    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();       
             jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
             jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService);
             jrprintServiceExporter.exportReport();*/
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void os(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Impresiones/os_nota.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void os_caja(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Impresiones/os_caja_impre.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void presupuesto(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Impresiones/presupuesto.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void presupuesto_surc_2(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Impresiones/presupuesto_surc_2.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void presupuestoRe(String cod) throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("codigo", cod);

                    URL in = this.getClass().getResource("/Impresiones/PresupuestoA4.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }
    }
/////devoluciones comunes///////////////////////////

    public void devoluciones(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/tickect_devoluciones.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_2(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_2/tickect_devoluciones_surc_2.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_3(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_3/tickect_devoluciones_surc_3.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_4(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_4/tickect_devoluciones_surc_4.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_5(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_5/tickect_devoluciones_surc_5.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_6(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_6/tickect_devoluciones_surc_6.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_7(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_7/tickect_devoluciones_surc_7.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_8(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_8/tickect_devoluciones_surc_8.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_9(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_9/tickect_devoluciones_surc_9.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_10(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_10/tickect_devoluciones_surc_10.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_11(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_11/tickect_devoluciones_surc_11.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_12(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_12/tickect_devoluciones_surc_12.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_13(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_13/tickect_devoluciones_surc_13.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_14(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_14/tickect_devoluciones_surc_14.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_15(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_15/tickect_devoluciones_surc_15.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_16(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_16/tickect_devoluciones_surc_16.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_17(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_17/tickect_devoluciones_surc_17.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_18(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_18/tickect_devoluciones_surc_18.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_19(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_19/tickect_devoluciones_surc_19.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_20(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_20/tickect_devoluciones_surc_20.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_21(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_21/tickect_devoluciones_surc_21.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_22(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_22/tickect_devoluciones_surc_22.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_23(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_23/tickect_devoluciones_surc_23.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_24(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_24/tickect_devoluciones_surc_24.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_25(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_25/tickect_devoluciones_surc_25.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_26(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_26/tickect_devoluciones_surc_26.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_27(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_27/tickect_devoluciones_surc_27.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_28(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_28/tickect_devoluciones_surc_28.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_29(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_29/tickect_devoluciones_surc_29.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void devoluciones_surc_30(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Devoluciones/Surc_30/tickect_devoluciones_surc_30.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void Listar_ventas() throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_usu.getDate().getTime());
            java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_usu.getDate().getTime());
            String total = txt_total_gs_usu.getText();
            String user = txt_nom_user.getText();

            Map parametro = new HashMap();
            parametro.clear();

            parametro.put("total", total);
            parametro.put("fechaIni", date1);
            parametro.put("fechaFin", date2);
            parametro.put("user", user);

            URL in = this.getClass().getResource("/Impresiones/Listar_ventas_gral.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setTitle("Estadísticas Ventas");
            ver.setVisible(true);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }//

    }
//////lucro ventas tiendas

    public void Ventas_lucro_totales() throws SQLException, JRException {

    }

    public void Ventas_lucro_2() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_2.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_3() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_3.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_4() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_4.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_5() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_5.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_6() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_6.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_7() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_7.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_8() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_8.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_9() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_9.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_10() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_10.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_11() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_11.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_12() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_12.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_13() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_13.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_14() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_14.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_15() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_15.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_16() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_16.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_17() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_17.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_18() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_18.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_19() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_19.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_20() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_20.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_21() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_21.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_22() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_22.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_23() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_23.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_24() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_24.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_25() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_25.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_26() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_26.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_27() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_27.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_28() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_28.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_29() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_29.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_30() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/impresiones/ventas_lucro_all_30.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    //***********************************
    //////lucro ventas tiendas
    public void Ventas_lucro_totales_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_2_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_2.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_3_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_3.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_4_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_4.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_5_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_5.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_6_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_6.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_7_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_7.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_8_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_8.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_9_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_9.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_10_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_10.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_11_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_11.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_12_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_12.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_13_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_13.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_14_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_14.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_15_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_15.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_16_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_16.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_17_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_17.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_18_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_18.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_19_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_19.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_20_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_20.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_21_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_21.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_22_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_22.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_23_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_23.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_24_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_24.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_25_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_25.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_26_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_26.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_27_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_27.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_28_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_28.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_29_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_29.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    public void Ventas_lucro_30_b() throws SQLException, JRException {
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Connection cn = conectar.getInstance().getConnection();

                    java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_ventas.getDate().getTime());
                    java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_ventas.getDate().getTime());
                    String total_contado = txt_total_ventas.getText();
                    String lucro_compra = txt_lucro_compra.getText();
                    String total_lucro = txt_lucro_ventas.getText();
                    String lucro_amort = ("0");
                    String total_lucro_neto = ("0");
                    String total_egresos = ("0");
                    String devol = ("0");
                    Map parametro = new HashMap();
                    parametro.clear();

                    parametro.put("total_contado", total_contado);
                    parametro.put("lucro_compra", lucro_compra);
                    parametro.put("total_lucro", total_lucro);
                    parametro.put("lucro_amort", lucro_amort);
                    parametro.put("total_lucro_neto", total_lucro_neto);
                    parametro.put("devol", devol);
                    parametro.put("gastos", total_egresos);
                    parametro.put("fecha_ini", date1);
                    parametro.put("fecha_fin", date2);

                    URL in = this.getClass().getResource("/Administrativo/Lucro_dos/ventas_lucro_30.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }

            }
        }

    }

    //***********************************
    public void Listar_ventasP() throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            java.sql.Date date1 = new java.sql.Date(jd_ini_lucro_usu.getDate().getTime());
            java.sql.Date date2 = new java.sql.Date(jd_fin_lucro_usu.getDate().getTime());
            String total = txt_total_gs_usu.getText();
            String user = txt_nom_user.getText();
            String cond = ("CONTADO");

            Map parametro = new HashMap();
            parametro.clear();

            parametro.put("total", total);
            parametro.put("fechaIni", date1);
            parametro.put("fechaFin", date2);
            parametro.put("condi", cond);
            parametro.put("user", user);

            URL in = this.getClass().getResource("/Impresiones/Listar_ventas.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setTitle("Estadísticas CP Productos");
            ver.setVisible(true);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }//

    }

    public void imprimir_extracto_pago(String cod, String cli, String monto) {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();

            parametro.put("cod", cod);
            parametro.put("cliente", cli);
            parametro.put("monto_pagado", monto);

            URL in = this.getClass().getResource("/Impresiones/boleta_cli_pago_plazo.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void imprimir_fact(String cod) throws SQLException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();

            parametro.put("cod", cod);
            URL in = this.getClass().getResource("/Ventas/Facturas/fact_ventas_print.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperViewer ver = new JasperViewer(print, false);
            ver.setTitle("Facturas");
            ver.setVisible(true);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    /////////////////////fiscal ticket/////////////////////////////////////
    public void fact_fiscal(String cod) throws SQLException, JRException {

        try {
            Connection cn = conectar.getInstance().getConnection();

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("codigo", cod);

            URL in = this.getClass().getResource("/Ventas/impresiones/tickect_factura.jasper");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperPrintManager.printPage(print, 0, false);
            conectar.getInstance().closeConnection(cn);

        } catch (JRException ex) {

        }

    }

    public void factTicket(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("nro", cod);
                    //parametro.put("total_gs", gs);
                    //  parametro.put("total_rs", rs);

                    URL in = this.getClass().getResource("/Ventas/Facturas/tickect_factura_epson.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    /////////////////////////////factura necttic/////////////////////////////////
    public void factA4(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("nro", cod);
                    //parametro.put("total_gs", gs);
                    //  parametro.put("total_rs", rs);

                    URL in = this.getClass().getResource("/Ventas/Facturas/facturaA4.jasper");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ///devolucion fiscal central
    public void factDevolFiscal(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Devoluciones/Fiscal_1/Devol_prin_fiscal.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Devoluciones/Fiscal_1/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ///devolucion franco
    public void factDevol(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Devoluciones/Fiscal_2/Devol_prin.jasper");
                    System.out.println(in);
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Devoluciones/Fiscal_2/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }
////////////////////////factura  franco//////////////////////////////////

    public void factPrincipal(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_2/2_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_2/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                  //  jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.TRUE);//
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ////////////////////////factura  franco//////////////////////////////////
    public void factVilla(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_16/16_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_16/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura all you need////////////////////////////
    public void factAll(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Facturas/Fact_prin_model_2.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Facturas/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ///factura all you asuncion 
    public void factAllASu(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_2/0_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_2/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ///////////////////////////exportacion/////////////////////////////////////
    public void factExpo(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Exportacion/exportacion.jasper");

                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura general ////////////////////////////
    public void factPrimero(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Facturas/1_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Facturas/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura kyrios central ////////////////////////////
    public void factKyrios(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Facturas/2_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Facturas/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura gabaon central ////////////////////////////
    public void factGabaon(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Facturas/Fact_gabaon.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Facturas/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura gabaon central 2////////////////////////////
    public void factGabaon_2(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_2/Fact_gabaon_2.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_2/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura gabaon central 3////////////////////////////
    public void factGabaon_3(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_3/Fact_gabaon_3.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_3/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //##################################sucursales#######################################
    public void fact_surc_4(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_4/4_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_4/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_5(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_5/5_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_5/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_6(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_6/6_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_6/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_7(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_7/7_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_7/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_8(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_8/8_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_8/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_9(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_9/9_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_9/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ////////////////////////factura 0000010//////////////////////////////////
    public void fact_surc_10(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_10/10_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_10/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ////////////////////////factura  mariano//////////////////////////////////
    public void fact_surc_11(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_11/11_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_11/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_12(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_12/12_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_12/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_13(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_13/13_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_13/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_14(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_14/14_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_14/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_15(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_15/15_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_15/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_16(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_16/16_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_16/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_17(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_17/17_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_17/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_18(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_18/18_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_18/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ////////////////////////factura  mariano//////////////////////////////////
    public void fact_surc_19(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_19/19_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_19/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_20(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_20/20_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_20/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_21(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_21/21_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_21/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    ////////////////////////factura  santani//////////////////////////////////
    public void fact_surc_22(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_22/22_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_22/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura minga////////////////////////////
    public void fact_surc_23(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_23/23_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_23/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    //////////////////////factura////////////////////////////
    public void fact_surc_24(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_24/24_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_24/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_25(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_25/25_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_25/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_26(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_26/26_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_26/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_27(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_27/27_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_27/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_28(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_28/28_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_28/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_29(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_29/29_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_29/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

    public void fact_surc_30(String cod) throws SQLException, JRException {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccionar  impresora:",
                    "Imprimir ", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {

                try {
                    Connection cn = conectar.getInstance().getConnection();

                    URL in = this.getClass().getResource("/Ventas/Fact_surc_30/30_Fact_prin.jasper");
                    // String gs = facturacion.txttotal.getText();
                    //  String rs = facturacion.lbl_cambio_real.getText();
                    Map parametro = new HashMap();
                    parametro.clear();
                    parametro.put("ide", cod);
                    parametro.put("SUBREPORT_DIR", "Ventas/Fact_surc_30/");

                    JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

                    JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cn);

                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();

                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    // jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    conectar.getInstance().closeConnection(cn);

                } catch (JRException ex) {

                }
            }

        }
    }

}
