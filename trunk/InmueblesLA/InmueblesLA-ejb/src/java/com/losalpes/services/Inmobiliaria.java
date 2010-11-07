/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.services;

import com.losalpes.entities.Inmueble;
import com.losalpes.persistence.IPersistence;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DANIEL
 */
@Stateless
public class Inmobiliaria implements IInmobiliaria
{
    // --------------------------------------------
    // Atributos
    // --------------------------------------------

    /**
     * Persistencia
     */
    @EJB
    private IPersistence persistencia;


    // --------------------------------------------
    // Metodos
    // --------------------------------------------
    
    public Inmueble buscarInmuebleReferencia(String id) {
        return new Inmueble();
    }
 
    // --------------------------------------------
    // Metodos de Retorno
    // --------------------------------------------

}
