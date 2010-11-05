/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author DANIEL
 */
public interface IInmobiliaria
{
    // --------------------------------------------
    // Metodos
    // --------------------------------------------

    /**
     * Genera un reporte indicando como es el balance actual de la empresa
     * financieramente
     */
    public void generarReporteFinanciero();

    /**
     * Genera un reporte indicando que usuarios estan registrados en el sistema
     * y disponibles para negociar
     */
    public void generarReporteInmuebles(String rutaNombre, String nombreArchivo);

    // --------------------------------------------
    // Metodos de Retorno
    // --------------------------------------------
    /**
     * Retorna la tabla que contiene los clientes registrados en el sistemas
     * @return listaClientes
     */
    public Hashtable<String, ICliente> darClientes();

    /**
     * Retorna la tabla que contiene los inmuebles registrados en el sistemas
     * @return listaInmuebles
     */
    public Hashtable<String, IInmueble> darInmuebles();

    /**
     * Retorna la lista de transaccion que hay en el sistema
     */
    public Hashtable<String, ITransaccion> darTransacciones();

    /**
     * busca un inmueble
     * @param referencia
     * @return
     */
    public IInmueble buscarInmuebleReferencia(String referencia);

    /**
     * agrega una nueva transaccion al sistema
     */
    public void agregarTransaccion(String estado, int idcomprador, int idinmueble, int idtransaccion);

    /**
     *
     * @param tipo
     * @param idcliente
     * @param lista1
     * @param lista2
     * @param apellido
     * @param cc
     * @param ciuRes
     * @param email
     * @param dir
     * @param logIn
     * @param nombre
     * @param pais
     * @param password
     * @param profesion
     * @param telefonoCelular
     * @param telefonoResidencia
     * @param tipoDocumento
     */
    public void agregarCliente(String tipo, int idcliente, ArrayList<ICliente> lista1, ArrayList<IInmueble> lista2, String apellido, String cc, String ciuRes, String email, String dir, String logIn, String nombre, String pais, String password, String profesion, String telefonoCelular, String telefonoResidencia, String tipoDocumento);
}
