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
public class Administrador implements ICliente
{
    // -----------------------------------------
    // Atributos
    // -----------------------------------------
    /**
     * Contiene el nombre del cliente
     */
    private String LogIn;

    /**
     * lista de todos los clientes registrados
     */
    private ArrayList<ICliente> listaClientes;

    /**
     * lista de todos los inmuebles registrados
     */
    private ArrayList<IInmueble> listaInmuebles;

    // -----------------------------------------
    // Constructor
    // -----------------------------------------
    public Administrador()
    {
        listaClientes = new ArrayList<ICliente>();
        listaInmuebles = new ArrayList<IInmueble>();
    }


    // -----------------------------------------
    // Metodos
    // -----------------------------------------
    /**
     * retorna los clientes filtrados por parametro
     */
    public ArrayList<IInmueble> getListaInmuebles(String tipo)
    {
        ArrayList<IInmueble> lista = new ArrayList<IInmueble>();

        for (int i = 0; i < listaInmuebles.size(); i++)
        {
            IInmueble temp = listaInmuebles.get(i);
            if (temp.darTipoInmueble().equals(tipo))
            {
                lista.add(temp);
            }
        }
        return lista;
    }

    /**
     * retorna la lista de clientes
     * @return
     */
    public ArrayList<IInmueble> getListaInmuebles() {
        return listaInmuebles;
    }
    /**
     * retorna los clientes filtrados por parametro
     */
    public ArrayList<ICliente> getListaClientes(String tipo)
    {
        ArrayList<ICliente> lista = new ArrayList<ICliente>();

        for (int i = 0; i < listaClientes.size(); i++)
        {
            ICliente temp = listaClientes.get(i);
            if (temp.darTipoCliente().equals(tipo))
            {
                lista.add(temp);
            }
        }
        return lista;
    }

    /**
     * retorna la lista de clientes
     * @return
     */
    public ArrayList<ICliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * retorna el tipo de cliente
     * @return
     */
    public String darTipoCliente()
    {
        return "Administrador";
    }
    
}
