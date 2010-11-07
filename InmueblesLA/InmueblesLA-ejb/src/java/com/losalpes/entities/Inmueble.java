/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name="INMUEBLE")
public class Inmueble implements Serializable
{
    // ---------------------------------------
    // Atributos
    // ---------------------------------------
    /**
     * Contiene el ID del inmueble
     */
    @Id
    @JoinColumn(name = "idinmuebles")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INM")
    @SequenceGenerator(name = "SEQ_INM", allocationSize = 1, sequenceName = "inmuebles_seq")
    private int idInmueble;
    
    /**
     * Contiene el nombre del inmueble
     */
    @Column
    private String nombre;
    
    /**
     * Contiene la descripcion del inmueble
     */
    @Column
    private String descripcion;

    /**
     * tipo del inmueble
     */
    @Column
    private String tipo;

    /**
     * logIn vendedor
     */
    @Column
    private int idvendedor;

    /**
     * losIn comprador
     */
    @Column
    private int idcomprador;

    /**
     * id del dueño
     */
    @JoinColumn
    @ManyToOne(optional=false)
    private Usuario iddueno;

    /**
     * lista de las transacciones asociadas a este inmueble
     */
    @JoinColumn
    @OneToMany(mappedBy = "idinmueble", cascade = {CascadeType.ALL})
    private List<Transacciones> transacciones;

    // ---------------------------------------
    // Constructor
    // ---------------------------------------
    /**
     * Constructor de la clase vacio
     */
    public Inmueble()
    {
        transacciones = new ArrayList<Transacciones>();
        idcomprador = -1;
        idvendedor = -1;
    }

    /**
     * con parametros por defecto
     * @param ref
     * @param nom
     * @param desc
     * @param ntipo
     */
    public Inmueble(int ref, String nom, String desc, String ntipo )
    {
        idInmueble = ref;
        nombre = nom;
        descripcion = desc;
        tipo = ntipo;
        idcomprador = -1;
        idvendedor = -1;

    }

    // ---------------------------------------
    // Metodos
    // ---------------------------------------

    // ---------------------------------------
    // Metodos retorno
    // ---------------------------------------

    /**
     * retorna la descripcion del inmueble
     * @return descripcion
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * modifica la descripcion del inmueble
     * @param descripcion
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * retorna el nombre del inmueble
     * @return nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * modifica el nombre del inmueble
     * @param nombre
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

 

    /**
     * retorna la idInmueble del inmueble
     * @return idInmueble
     */
    public int getidInmueble()
    {
        return idInmueble;
    }

    /**
     * modifica la idInmueble del inmueble
     * @param idInmueble
     */
    public void setidInmueble(int idInmueble)
    {
        this.idInmueble = idInmueble;
    }


    /**
     * obtiene tipo inmueble
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * retorna tipo inmueble
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public int getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(int idcomprador) {
        this.idcomprador = idcomprador;
    }

    public Usuario getIddueno() {
        return iddueno;
    }

    public void setIddueno(Usuario iddueno) {
        this.iddueno = iddueno;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }
}