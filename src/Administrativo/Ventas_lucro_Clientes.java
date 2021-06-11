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
public class Ventas_lucro_Clientes {

    String codigo,  id_pro, nom_pro, unidad, valor_costo, valor_ventas;

    public Ventas_lucro_Clientes(String codigo, String id_pro, String nom_pro, String unidad, String valor_costo, String valor_ventas) {
        this.codigo = codigo;
        this.id_pro = id_pro;
        this.nom_pro = nom_pro;
        this.unidad = unidad;
        this.valor_costo = valor_costo;
        this.valor_ventas = valor_ventas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getId_pro() {
        return id_pro;
    }

    public void setId_pro(String id_pro) {
        this.id_pro = id_pro;
    }

    public String getNom_pro() {
        return nom_pro;
    }

    public void setNom_pro(String nom_pro) {
        this.nom_pro = nom_pro;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getValor_costo() {
        return valor_costo;
    }

    public void setValor_costo(String valor_costo) {
        this.valor_costo = valor_costo;
    }

    public String getValor_ventas() {
        return valor_ventas;
    }

    public void setValor_ventas(String valor_ventas) {
        this.valor_ventas = valor_ventas;
    }

    
    
    
}
