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
import javax.persistence.Table;

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name="TRANSACCION")
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
    @JoinColumn
    @ManyToOne
    private Usuario idcomprador;

    /**
     * idinmueble
     */
    @JoinColumn
    @ManyToOne
    private Inmueble idinmueble;

    /**
     * estado
     */
    @Column
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

    public Usuario getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(Usuario idcomprador) {
        this.idcomprador = idcomprador;
    }

    public Inmueble getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(Inmueble idinmueble) {
        this.idinmueble = idinmueble;
    }

    public int getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(int idtransaccion) {
        this.idtransaccion = idtransaccion;
    }
}
