/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author DANIEL
 */
public class Inmobiliaria implements IInmobiliaria
{
    // --------------------------------------------
    // Atributos
    // --------------------------------------------

    /**
     * Contiene los clientes registrados en el sistema
     */
    private Hashtable<String, ICliente> listaClientes;

    /**
     * Contiene los inmuebles registrados
     */
    private Hashtable<String, IInmueble> listaInmuebles;

    // --------------------------------------------
    // Constructor
    // --------------------------------------------
    /**
     * Constructor de la clase
     */
    public Inmobiliaria()
    {
        listaClientes = new Hashtable<String, ICliente>( );
        listaInmuebles = new Hashtable<String, IInmueble>( );
        for(int i=0;i<10;i++){
            IInmueble nuevo = new Inmueble(""+i,"Nombre"+i,"Descripcion"+i, "casa");
            listaInmuebles.put(""+i, nuevo);
        }
        System.out.println(listaInmuebles.size());

    }

    // --------------------------------------------
    // Metodos
    // --------------------------------------------
    /**
     * Genera un reporte indicando como es el balance actual de la empresa
     * financieramente
     */
    public void generarReporteFinanciero( )
    {
        
    }

    /**
     * Genera un reporte indicando que usuarios estan registrados en el sistema
     * y disponibles para negociar
     */
    public void generarReporteInmuebles( String rutaNombre, String nombreArchivo )
    {
        String numeroInmueble = "";
        String referencia = "";
        String nombre = "";
        String descripcion = "";
        String espacio = "";
        String material = "";
        
        Enumeration<IInmueble> listaI;
        IInmueble in;
        try
        {
            PrintWriter escritor = new PrintWriter( new File ( rutaNombre + File.separator + nombreArchivo ) );
            listaI = listaInmuebles.elements();

            in = listaI.nextElement();
            int i = 1;
            while ( in != null )
            {
                escritor.println( "Inmueble " + i );
                escritor.println( "- Referencia: " + in.getReferencia( ));
                escritor.println( "- Nombre: " + in.getNombre( ) );
                escritor.println( "- Descripcion: " + in.getDescripcion( ) );
                if ( in.isInteriorExterior( ))
                {
                    escritor.println( "- Interior/Exterior: Interior" );
                }
                else
                {
                    escritor.println( "- Interior/Exterior: Exterior" );
                }
                escritor.println( "- Material: " + in.getMaterial( ) );
                escritor.println( "- Medidas: " );
                escritor.println( "           + Ancho: " + in.getAncho( ) );
                escritor.println( "           + Alto: " + in.getAlto( ) );
                escritor.println( "           + Profundo: " + in.getProfundidad() );
                escritor.println( "- Peso: " + in.getPeso( ) );
                escritor.println( "- Color: " + in.getColor( ) );
                escritor.println( "- Foto: " + in.getFoto( ) );
                escritor.println( "--------------------------------------------");
                i++;
            }
        }

        catch (Exception e)
        {

        }
    }

    // --------------------------------------------
    // Metodos de Retorno
    // --------------------------------------------
    /**
     * Retorna la tabla que contiene los clientes registrados en el sistemas
     * @return listaClientes
     */
    public Hashtable<String, ICliente> darClientes( )
    {
        return listaClientes;
    }

    /**
     * Retorna la tabla que contiene los inmuebles registrados en el sistemas
     * @return listaInmuebles
     */
    public Hashtable<String, IInmueble> darInmuebles( )
    {
        return listaInmuebles;
    }

    public IInmueble buscarInmuebleReferencia(String referencia){
        IInmueble buscado = null;
        buscado = listaInmuebles.get(referencia);
        return buscado;
    }

}
