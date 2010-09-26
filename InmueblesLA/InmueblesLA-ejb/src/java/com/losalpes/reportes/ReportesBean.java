/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import javax.ejb.Stateless;

/**
 *
 * @author andres
 */
@Stateless
public class ReportesBean implements Reportes {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
    private String nombre = new String("Andres");
    private String apellido = new String("Gomez");;
    private String cuenta = new String("9238571");;


    public String generarReporte(String id)
    {
        String rep = new String();

        rep = rep + "Este es el reporte:\n";
        rep = rep + "Cuenta: " + cuenta + "\n";
        rep = rep + "Nombre: " + nombre + "\n";
        rep = rep + "Apellido: " + apellido + "\n";

        return rep;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
