/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

/**
 *
 * @author DANIEL
 */
public class Transaccion implements ITransaccion
{
    /**
     * idtransaccion
     */
    private int idtransaccion;

    /**
     * idcomprador
     */
    private int idcomprador;

    /**
     * idinmueble
     */
    private int idinmueble;

    /**
     * estado
     */
    private String estado;

    // ------------------------
    // Constructor
    // ------------------------
    /**
     * constructor
     */
    public Transaccion()
    {
        
    }

    // ------------------------
    // Getter + setters
    // ------------------------

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(int idcomprador) {
        this.idcomprador = idcomprador;
    }

    public int getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public int getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(int idtransaccion) {
        this.idtransaccion = idtransaccion;
    }


}
