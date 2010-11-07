/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.entities;

/**
 *
 * @author df.palacios30
 */
public class PautasPrublicitarias {

    private String idPauta;

    private String nombreEmpresa;

    private String descripcion;

    private int telefono;

    private String email;

    public PautasPrublicitarias()
    {
        
    }



    public String getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(String idPauta) {
        this.idPauta = idPauta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
