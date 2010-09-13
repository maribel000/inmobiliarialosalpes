/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

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
    public void generarReporteFinanciero( );

    /**
     * Genera un reporte indicando que usuarios estan registrados en el sistema
     * y disponibles para negociar
     */
    public void generarReporteInmuebles( String rutaNombre, String nombreArchivo );

    // --------------------------------------------
    // Metodos de Retorno
    // --------------------------------------------
    /**
     * Retorna la tabla que contiene los clientes registrados en el sistemas
     * @return listaClientes
     */
    public Hashtable<String, ICliente> darClientes( );

    /**
     * Retorna la tabla que contiene los inmuebles registrados en el sistemas
     * @return listaInmuebles
     */
    public Hashtable<String, IInmueble> darInmuebles( );
}
