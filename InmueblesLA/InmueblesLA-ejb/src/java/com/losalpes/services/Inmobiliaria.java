/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.services;

import com.losalpes.entities.Inmueble;
import com.losalpes.persistence.IPersistenceServices;
import com.losalpes.persistence.PersistenceServices;
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
    private IPersistenceServices persistencia = new PersistenceServices();


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
