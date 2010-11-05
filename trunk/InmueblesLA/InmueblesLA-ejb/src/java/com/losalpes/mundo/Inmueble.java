/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

/**
 *
 * @author DANIEL
 */
public class Inmueble implements IInmueble
{
    // ---------------------------------------
    // Atributos
    // ---------------------------------------
    /**
     * Contiene el ID del inmueble
     */
    private int idInmueble;
    
    /**
     * Contiene el nombre del inmueble
     */
    private String nombre;
    
    /**
     * Contiene la descripcion del inmueble
     */
    private String descripcion;

    /**
     * tipo del inmueble
     */
    private String tipo;

    /**
     * logIn vendedor
     */
    private String logInVendedor;

    /**
     * losIn comprador
     */
    private String comprador;

    // ---------------------------------------
    // Constructor
    // ---------------------------------------
    /**
     * Constructor de la clase vacio
     */
    public Inmueble()
    {
        
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
     * retorna id comprador
     * @return
     */
    public String getComprador() {
        return comprador;
    }

    /**
     * cambia id comprador
     * @param comprador
     */
    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    /**
     * retorna login vendedor
     * @return
     */
    public String getLogInVendedor() {
        return logInVendedor;
    }

    /**
     * modifica id vendedor
     * @param logInVendedor
     */
    public void setLogInVendedor(String logInVendedor) {
        this.logInVendedor = logInVendedor;
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
}