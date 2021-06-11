/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrativo.Cuentas_recibir;

/**
 *
 * @author User
 */
public class Recibir_class {

    String codigo, idcli, cliente, valor, pendiente, fecha;

    public Recibir_class(String codigo, String idcli, String cliente, String valor, String pendiente, String fecha) {
        this.codigo = codigo;
        this.idcli = idcli;
        this.cliente = cliente;
        this.valor = valor;
        this.pendiente = pendiente;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdcli() {
        return idcli;
    }

    public void setIdcli(String idcli) {
        this.idcli = idcli;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPendiente() {
        return pendiente;
    }

    public void setPendiente(String pendiente) {
        this.pendiente = pendiente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
}
