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
    private String documentoIdentificacion;

    /**
     * Contiene el tipo de documento del cliente
     */
    private String tipoDocumento;

    /**
     * Contiene el telefono de residencia del cliente
     */
    private String telefonoResidencia;

    /**
     * Contiene el telefono celular del cliente
     */
    private String telefonoCelular;

    /**
     * Contiene la ciudad de residencia del cliente
     */
    private String ciudadResidencia;

    /**
     * Contiene la direccion del cliente
     */
    private String direccion;

    /**
     * Contiene el pais del cliente
     */
    private String pais;
    /**
     * Contiene la profesion del cliente
     */
    private String profesion;

    /**
     * Contiene el correo electronico del cliente
     */
    private String correoElectronico;

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
     * modifica el ciudadResidencia
     * @return ciudadResidencia
     */
    public String getCiudadResidencia()
    {
        return ciudadResidencia;
    }

    /**
     * modifica el ciudadResidencia actual
     * @param ciudadResidencia
     */
    public void setCiudadResidencia(String ciudadResidencia)
    {
        this.ciudadResidencia = ciudadResidencia;
    }

    /**
     * modifica el correoElectronico
     * @return correoElectronico
     */
    public String getCorreoElectronico()
    {
        return correoElectronico;
    }

    /**
     * modifica el correoElectronico actual
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico)
    {
        this.correoElectronico = correoElectronico;
    }

    /**
     * modifica el direccion
     * @return direccion
     */
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * modifica el direccion actual
     * @param direccion
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    /**
     * modifica el documentoIdentificacion
     * @return documentoIdentificacion
     */
    public String getDocumentoIdentificacion()
    {
        return documentoIdentificacion;
    }

    /**
     * modifica el documentoIdentificacion actual
     * @param documentoIdentificacion
     */
    public void setDocumentoIdentificacion(String documentoIdentificacion)
    {
        this.documentoIdentificacion = documentoIdentificacion;
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

    /**
     * modifica el pais
     * @return pais
     */
    public String getPais()
    {
        return pais;
    }

    /**
     * modifica el pais actual
     * @param pais
     */
    public void setPais(String pais)
    {
        this.pais = pais;
    }

    /**
     * modifica el profesion
     * @return profesion
     */
    public String getProfesion()
    {
        return profesion;
    }

    /**
     * modifica el profesion actual
     * @param profesion
     */
    public void setProfesion(String profesion)
    {
        this.profesion = profesion;
    }

    /**
     * modifica el telefonoCelular
     * @return telefonoCelular
     */
    public String getTelefonoCelular()
    {
        return telefonoCelular;
    }

    /**
     * modifica el telefonoCelular actual
     * @param telefonoCelular
     */
    public void setTelefonoCelular(String telefonoCelular)
    {
        this.telefonoCelular = telefonoCelular;
    }

    /**
     * modifica el telefonoResidencia
     * @return telefonoResidencia
     */
    public String getTelefonoResidencia()
    {
        return telefonoResidencia;
    }

    /**
     * modifica el telefonoResidencia actual
     * @param telefonoResidencia
     */
    public void setTelefonoResidencia(String telefonoResidencia)
    {
        this.telefonoResidencia = telefonoResidencia;
    }

    /**
     * modifica el tipoDocumento
     * @return tipoDocumento
     */
    public String getTipoDocumento()
    {
        return tipoDocumento;
    }

    /**
     * modifica el tipoDocumento actual
     * @param tipoDocumento
     */
    public void setTipoDocumento(String tipoDocumento)
    {
        this.tipoDocumento = tipoDocumento;
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
