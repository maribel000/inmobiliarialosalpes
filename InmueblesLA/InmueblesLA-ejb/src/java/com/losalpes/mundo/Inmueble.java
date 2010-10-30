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
    private String referencia;
    
    /**
     * Contiene el nombre del inmueble
     */
    private String nombre;
    
    /**
     * Contiene la descripcion del inmueble
     */
    private String descripcion;
    
    /**
     * Contiene si inmueble es interior o exterior
     * interior = true
     * exterior = false
     */
    private boolean interiorExterior;
    
    /**
     * Contiene el material del inmueble
     */
    private String material;
    
    /**
     * Contiene el alto del inmueble
     */
    private int alto;
    
    /**
     * Contiene el ancho del inmueble
     */
    private int ancho;
    
    /**
     * Contiene la profundidad del inmueble
     */
    private int profundidad;
    
    /**
     * Contiene el color del inmueble
     */
    private String color;
    
    /**
     * Contiene el peso del inmueble
     */
    private int peso;
    
    /**
     * Contiene la foto del inmueble
     */
    private String foto;

    /**
     * tipo del inmueble
     */
    private String tipo;

    // ---------------------------------------
    // Constructor
    // ---------------------------------------
    /**
     * Constructor de la clase
     */
    public Inmueble()
    {
        
    }

    public Inmueble(String ref, String nom, String desc, String ntipo )
    {
        referencia = ref;
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
     * retorna el alto del inmueble
     * @return alto
     */
    public int getAlto()
    {
        return alto;
    }

    /**
     * modifica el alto del inmueble
     * @param alto
     */
    public void setAlto(int alto)
    {
        this.alto = alto;
    }

    /**
     * retorna el ancho del inmueble
     * @return ancho
     */
    public int getAncho()
    {
        return ancho;
    }

    /**
     * modifica el ancho del inmueble
     * @param ancho
     */
    public void setAncho(int ancho)
    {
        this.ancho = ancho;
    }

    /**
     * retorna el color del inmueble
     * @return color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * modifica el color del inmueble
     * @param color
     */
    public void setColor(String color)
    {
        this.color = color;
    }

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
     * retorna la foto del inmueble
     * @return foto
     */
    public String getFoto()
    {
        return foto;
    }

    /**
     * modifica la foto del inmueble
     * @param foto
     */
    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    /**
     * retorna el interiorExterior del inmueble
     * @return interiorExterior
     */
    public boolean isInteriorExterior()
    {
        return interiorExterior;
    }

    /**
     * modifica el interiorExterior del inmueble
     * @param interiorExterior
     */
    public void setInteriorExterior(boolean interiorExterior)
    {
        this.interiorExterior = interiorExterior;
    }

    /**
     * retorna el material del inmueble
     * @return material
     */
    public String getMaterial()
    {
        return material;
    }

    /**
     * modifica el material del inmueble
     * @param material
     */
    public void setMaterial(String material)
    {
        this.material = material;
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
     * retorna el peso del inmueble
     * @return peso
     */
    public int getPeso()
    {
        return peso;
    }

    /**
     * modifica el peso del inmueble
     * @param peso
     */
    public void setPeso(int peso)
    {
        this.peso = peso;
    }

    /**
     * retorna la profundidad del inmueble
     * @return profundidad
     */
    public int getProfundidad()
    {
        return profundidad;
    }

    /**
     * modifica la profundidad del inmueble
     * @param profundidad
     */
    public void setProfundidad(int profundidad)
    {
        this.profundidad = profundidad;
    }

    /**
     * retorna la referencia del inmueble
     * @return referencia
     */
    public String getReferencia()
    {
        return referencia;
    }

    /**
     * modifica la referencia del inmueble
     * @param referencia
     */
    public void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }

    public String darTipoInmueble() {
        return tipo;
    }
}