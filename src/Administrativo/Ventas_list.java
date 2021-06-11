/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrativo;

/**
 *
 * @author User
 */
public class Ventas_list {
    
    String codigo,cliente, forma, total, fecha, user;

    public Ventas_list(String codigo, String cliente, String forma, String total, String fecha, String user) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.forma = forma;
        this.total = total;
        this.fecha = fecha;
        this.user = user;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

   
}
