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
public class Productos_Marca {

    String codigo, des,  unit,  venta;

    public Productos_Marca(String codigo, String des,  String unit, String venta) {
        this.codigo = codigo;
        this.des = des;
        this.unit = unit;
        this.venta = venta;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

   

}
