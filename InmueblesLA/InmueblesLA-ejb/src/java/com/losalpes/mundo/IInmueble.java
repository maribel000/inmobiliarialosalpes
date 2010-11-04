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

    public String getTipoInmueble();
    /**
     * retorna el alto del inmueble
     * @return alto
     */
    public int getAlto();

    /**
     * modifica el alto del inmueble
     * @param alto
     */
    public void setAlto(int alto);

    /**
     * retorna el ancho del inmueble
     * @return ancho
     */
    public int getAncho();

    /**
     * modifica el ancho del inmueble
     * @param ancho
     */
    public void setAncho(int ancho);

    /**
     * retorna el color del inmueble
     * @return color
     */
    public String getColor();

    /**
     * modifica el color del inmueble
     * @param color
     */
    public void setColor(String color);

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
     * retorna la foto del inmueble
     * @return foto
     */
    public String getFoto();

    /**
     * modifica la foto del inmueble
     * @param foto
     */
    public void setFoto(String foto);

    /**
     * retorna el interiorExterior del inmueble
     * @return interiorExterior
     */
    public boolean isInteriorExterior();

    /**
     * modifica el interiorExterior del inmueble
     * @param interiorExterior
     */
    public void setInteriorExterior(boolean interiorExterior);

    /**
     * retorna el material del inmueble
     * @return material
     */
    public String getMaterial();

    /**
     * modifica el material del inmueble
     * @param material
     */
    public void setMaterial(String material);

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
     * retorna el peso del inmueble
     * @return peso
     */
    public int getPeso();

    /**
     * modifica el peso del inmueble
     * @param peso
     */
    public void setPeso(int peso);

    /**
     * retorna la profundidad del inmueble
     * @return profundidad
     */
    public int getProfundidad();

    /**
     * modifica la profundidad del inmueble
     * @param profundidad
     */
    public void setProfundidad(int profundidad);

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
}
