/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author DANIEL
 */
@Entity
//@Table(name="TRANSACCION")
public class Transacciones implements Serializable
{
    /**
     * idtransaccion
     */
    @Id
    @Column(name = "idtransaccion")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRAN")
    @SequenceGenerator(name = "SEQ_TRAN", allocationSize = 1, sequenceName = "transaccion_seq")
    private int idtransaccion;

    /**
     * idcomprador
     */
    @Column
    @ManyToOne
    private int idcomprador;

    /**
     * idinmueble
     */
    @JoinColumn
    @ManyToOne
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
    public Transacciones()
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
