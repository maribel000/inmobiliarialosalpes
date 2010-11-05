/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

/**
 *
 * @author DANIEL
 */
public interface IInmueble
{
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
    public String getDescripcion();

    /**
     * modifica la descripcion del inmueble
     * @param descripcion
     */
    public void setDescripcion(String descripcion);

    /**
     * retorna el nombre del inmueble
     * @return nombre
     */
    public String getNombre();

    /**
     * modifica el nombre del inmueble
     * @param nombre
     */
    public void setNombre(String nombre);

    /**
     * retorna la idInmueble del inmueble
     * @return idInmueble
     */
    public int getidInmueble();

    /**
     * modifica la idInmueble del inmueble
     * @param idInmueble
     */
    public void setidInmueble(int idInmueble);

/**
     * retorna id comprador
     * @return
     */
    public int getComprador();

    /**
     * cambia id comprador
     * @param comprador
     */
    public void setComprador(int comprador);

    /**
     * retorna login vendedor
     * @return
     */
    public int getLogInVendedor();

    /**
     * modifica id vendedor
     * @param logInVendedor
     */
    public void setLogInVendedor(int logInVendedor);

    /**
     * obtiene tipo inmueble
     * @return
     */
    public String getTipo();

    /**
     * retorna tipo inmueble
     * @param tipo
     */
    public void setTipo(String tipo);
}
