/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

/**
 *
 * @author DANIEL
 */
public interface ICliente
{
    public String getApellido();

    /**
     * modifica el apellido actual
     * @param apellido
     */
    public void setApellido(String apellido);

    /**
     * modifica el ciudadResidencia
     * @return ciudadResidencia
     */
    public String getCiudadResidencia();

    /**
     * modifica el ciudadResidencia actual
     * @param ciudadResidencia
     */
    public void setCiudadResidencia(String ciudadResidencia);

    /**
     * modifica el correoElectronico
     * @return correoElectronico
     */
    public String getCorreoElectronico();

    /**
     * modifica el correoElectronico actual
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico);

    /**
     * modifica el direccion
     * @return direccion
     */
    public String getDireccion();

    /**
     * modifica el direccion actual
     * @param direccion
     */
    public void setDireccion(String direccion);

    /**
     * modifica el documentoIdentificacion
     * @return documentoIdentificacion
     */
    public String getDocumentoIdentificacion();

    /**
     * modifica el documentoIdentificacion actual
     * @param documentoIdentificacion
     */
    public void setDocumentoIdentificacion(String documentoIdentificacion);

    /**
     * modifica el nombre
     * @return nombre
     */
    public String getNombre();

    /**
     * modifica el nombre actual
     * @param nombre
     */
    public void setNombre(String nombre);

    /**
     * modifica el pais
     * @return pais
     */
    public String getPais();

    /**
     * modifica el pais actual
     * @param pais
     */
    public void setPais(String pais);

    /**
     * modifica el profesion
     * @return profesion
     */
    public String getProfesion();

    /**
     * modifica el profesion actual
     * @param profesion
     */
    public void setProfesion(String profesion);

    /**
     * modifica el telefonoCelular
     * @return telefonoCelular
     */
    public String getTelefonoCelular();

    /**
     * modifica el telefonoCelular actual
     * @param telefonoCelular
     */
    public void setTelefonoCelular(String telefonoCelular);

    /**
     * modifica el telefonoResidencia
     * @return telefonoResidencia
     */
    public String getTelefonoResidencia();

    /**
     * modifica el telefonoResidencia actual
     * @param telefonoResidencia
     */
    public void setTelefonoResidencia(String telefonoResidencia);

    /**
     * modifica el tipoDocumento
     * @return tipoDocumento
     */
    public String getTipoDocumento();

    /**
     * modifica el tipoDocumento actual
     * @param tipoDocumento
     */
    public void setTipoDocumento(String tipoDocumento);
}
