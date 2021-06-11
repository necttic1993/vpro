/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos;

/**
 *
 * @author User
 */
public class lista_gastos {

    String codigo, des, status, monto, fecha, factura;

    public lista_gastos(String codigo, String des, String status, String monto, String fecha, String factura) {
        this.codigo = codigo;
        this.des = des;
        this.status = status;
        this.monto = monto;
        this.fecha = fecha;
        this.factura = factura;
    }

    public String getCodigo() {
        System.out.println(codigo);
        return codigo;

    }

    public void setCodigo(String codigo) {
        System.out.println(codigo);
        this.codigo = codigo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

}
