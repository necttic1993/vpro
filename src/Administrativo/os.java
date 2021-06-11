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
public class os {

    String nro, tecnico, valorS, valorT, valorOS, fecha;

    public os(String nro, String tecnico, String valorS, String valorT, String valorOS, String fecha) {
        this.nro = nro;
        this.tecnico = tecnico;
        this.valorS = valorS;
        this.valorT = valorT;
        this.valorOS = valorOS;
        this.fecha = fecha;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getValorS() {
        return valorS;
    }

    public void setValorS(String valorS) {
        this.valorS = valorS;
    }

    public String getValorT() {
        return valorT;
    }

    public void setValorT(String valorT) {
        this.valorT = valorT;
    }

    public String getValorOS() {
        return valorOS;
    }

    public void setValorOS(String valorOS) {
        this.valorOS = valorOS;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
