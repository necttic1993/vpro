/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticas_productos;

/**
 *
 * @author User
 */
public class Ventas_Stock_clientes {

    String codigo, nronota, cantidad, des, total, fecha;

    public Ventas_Stock_clientes(String codigo, String nronota, String cantidad, String des, String total, String fecha) {
        this.codigo = codigo;
        this.nronota = nronota;
        this.cantidad = cantidad;
        this.des = des;
        this.total = total;
        this.fecha = fecha;
    }

  

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNronota() {
        return nronota;
    }

    public void setNronota(String nronota) {
        this.nronota = nronota;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    

}
