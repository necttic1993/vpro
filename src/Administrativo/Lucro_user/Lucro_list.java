/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrativo.Lucro_user;

/**
 *
 * @author User
 */
public class Lucro_list {

    String codigo, fecha, producto, unidad, idpro, costo, valorventas, compraequi, total;

    public Lucro_list(String codigo, String fecha, String producto, String unidad, String idpro, String costo, String valorventas, String compraequi, String total) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.producto = producto;
        this.unidad = unidad;
        this.idpro = idpro;
        this.costo = costo;
        this.valorventas = valorventas;
        this.compraequi = compraequi;
        this.total = total;
    }

    public Lucro_list() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getIdpro() {
        return idpro;
    }

    public void setIdpro(String idpro) {
        this.idpro = idpro;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getValorventas() {
        return valorventas;
    }

    public void setValorventas(String valorventas) {
        this.valorventas = valorventas;
    }

    public String getCompraequi() {
        return compraequi;
    }

    public void setCompraequi(String compraequi) {
        this.compraequi = compraequi;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   

}
