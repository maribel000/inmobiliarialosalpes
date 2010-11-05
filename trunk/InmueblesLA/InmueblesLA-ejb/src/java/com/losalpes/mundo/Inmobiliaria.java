/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

import com.losalpes.persistence.IPersistenceServices;
import com.losalpes.persistence.PersistenceServices;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

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

    /**
     * Persistencia
     */
    private IPersistenceServices persistencia;

    /**
     * contiene las transaccion actuales
     */
    private Hashtable<String, ITransaccion> listaTransacciones;

    // --------------------------------------------
    // Constructor
    // --------------------------------------------
    /**
     * Constructor de la clase
     */
    public Inmobiliaria()
    {
        persistencia = new PersistenceServices();
        listaClientes = new Hashtable<String, ICliente>( );
        listaInmuebles = new Hashtable<String, IInmueble>( );
        for(int i=0;i<10;i++){
            IInmueble nuevo = new Inmueble(i,"Nombre"+i,"Descripcion"+i, "casa");
            listaInmuebles.put(""+i, nuevo);
        }
        listaTransacciones = new Hashtable<String, ITransaccion>();
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
                escritor.println( "- Referencia: " + in.getidInmueble());
                escritor.println( "- Nombre: " + in.getNombre( ) );
                escritor.println( "- Descripcion: " + in.getDescripcion( ) );
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

    /**
     * Retorna la lista de transaccion que hay en el sistema
     */
    public Hashtable<String, ITransaccion> darTransacciones( )
    {
        return listaTransacciones;
    }

    /**
     * busca un inmueble
     * @param referencia
     * @return
     */
    public IInmueble buscarInmuebleReferencia(String referencia)
    {
        IInmueble buscado = null;
        buscado = listaInmuebles.get(referencia);
        return buscado;
    }

    /**
     * agrega una nueva transaccion al sistema
     */
    public void agregarTransaccion( String estado,int idcomprador,int idinmueble,int idtransaccion)
    {
        ITransaccion nueva = new Transaccion( );
        nueva.setEstado(estado);
        nueva.setIdcomprador(idcomprador);
        nueva.setIdinmueble(idinmueble);
        nueva.setIdtransaccion(idtransaccion);

        listaTransacciones.put(idtransaccion+"", nueva);
        persistencia.persistirNuevaTransaccion(nueva);
    }

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
    public void agregarCliente(String tipo, int idcliente, ArrayList<ICliente>lista1, ArrayList<IInmueble>lista2 ,String apellido,String cc,String email,String logIn,String nombre,String password)
    {
        ICliente nuevo = null;
        if (tipo.equals("Administrador"))
        {
            Administrador a = new Administrador();
            a.setIdcliente(idcliente);
            a.setListaClientes(lista1);
            a.setListaInmuebles(lista2);
            a.setPassword(password);
            a.setLogIn(logIn);
            nuevo = a;
        }
        else if(tipo.equals("Vendedor"))
        {
            Vendedor v = new Vendedor();
            v.setApellido(apellido);
            v.setCedula(cc);
            v.setCorreoElectronico(email);
            v.setIdcliente(idcliente);
            v.setLogIn(logIn);
            v.setNombre(nombre);
            v.setPassword(password);

            nuevo = v;
        }
        
        else if(tipo.equals("Cliente"))
        {
            Cliente c = new Cliente();
            c.setApellido(apellido);
            c.setDocumentoIdentificacion(cc);
            c.setCorreoElectronico(email);
            c.setIdcliente(idcliente);
            c.setLogIn(logIn);
            c.setNombre(nombre);
            c.setPassword(password);

            nuevo = c;
        }
        listaClientes.put(idcliente+"", nuevo);
        persistencia.persistirNuevoCliente(nuevo);
    }

    /**
     * agrega un nuevo inmueble a la BD
     */
    public void agregaInmueble(int comprador,String descripcion,int logInVendedor,String nombre,String tipo,int idInmueble)
    {
        IInmueble nuevo = new Inmueble();
        nuevo.setComprador(comprador);
        nuevo.setDescripcion(descripcion);
        nuevo.setLogInVendedor(logInVendedor);
        nuevo.setNombre(nombre);
        nuevo.setTipo(tipo);
        nuevo.setidInmueble(idInmueble);

        listaInmuebles.put(idInmueble+"", nuevo);
        persistencia.persistirNuevoInmueble(nuevo);
    }
}
