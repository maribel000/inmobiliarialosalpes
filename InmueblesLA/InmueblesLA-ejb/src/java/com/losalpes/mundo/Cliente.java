/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

import java.util.ArrayList;

/**
 *
 * @author DANIEL
 */
public class Cliente implements ICliente
{
    // -----------------------------------------
    // Atributos
    // -----------------------------------------
    /**
     * ID del cliente
     */
    private int idcliente;

    /**
     * Contiene el nombre del cliente
     */
    private String nombre;

    /**
     * Contiene el apellido del cliente
     */
    private String apellido;

    /**
     * Contiene el documento de identificacion del cliente
     */
    private String cc;

    /**
     * Contiene el correo electronico del cliente
     */
    private String email;

    private ArrayList<IInmueble> inmueblesComprado;

    private ArrayList<IInmueble> inmueblesBuscado;

    private String logIn;

    private String password;

    // -----------------------------------------
    // Constructor
    // -----------------------------------------
    public Cliente()
    {
        inmueblesBuscado = new ArrayList<IInmueble>();
        inmueblesComprado = new ArrayList<IInmueble>();
    }

    // -----------------------------------------
    // Metodos
    // -----------------------------------------

    /**
     * agrega un inmueble a la lista de comprados
     */
    public void agregarInmuebleComprado( IInmueble nuevo )
    {
        inmueblesComprado.add(nuevo);
    }

    /**
     * agrega un nuevo inmueble que le interesa al usuario
     */
    public void agregarInmuebleInteresado( IInmueble nuevo )
    {
        inmueblesBuscado.add(nuevo);
    }

    /**
     * compra un inmueble
     */
    public void comprarInmueble( IInmueble nuevo )
    {
        if (inmueblesBuscado.contains(nuevo))
        {
            inmueblesBuscado.remove(nuevo);
            inmueblesComprado.add(nuevo);
        }
        else
        {
            inmueblesComprado.add(nuevo);
        }
    }

    // -----------------------------------------
    // Metodos Getters and Setters
    // -----------------------------------------

    /**
     * modifica el apellido
     * @return apellido
     */
    public String getApellido()
    {
        return apellido;
    }

    /**
     * modifica el apellido actual
     * @param apellido
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    /**
     * modifica el correoElectronico
     * @return correoElectronico
     */
    public String getCorreoElectronico()
    {
        return email;
    }

    /**
     * modifica el correoElectronico actual
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico)
    {
        this.email = correoElectronico;
    }

    /**
     * modifica el documentoIdentificacion
     * @return documentoIdentificacion
     */
    public String getDocumentoIdentificacion()
    {
        return cc;
    }

    /**
     * modifica el documentoIdentificacion actual
     * @param documentoIdentificacion
     */
    public void setDocumentoIdentificacion(String documentoIdentificacion)
    {
        this.cc = documentoIdentificacion;
    }

    /**
     * modifica el nombre
     * @return nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * modifica el nombre actual
     * @param nombre
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String darTipoCliente() {
        return "Cliente";
    }
}
