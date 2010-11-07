/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.services;

import com.losalpes.entities.Inmueble;
import javax.ejb.Local;

/**
 *
 * @author DANIEL
 */
@Local
public interface IInmobiliaria 
{
    // --------------------------------------------
    // Metodos
    // --------------------------------------------
    
    public Inmueble buscarInmuebleReferencia(String id);
 
    // --------------------------------------------
    // Metodos de Retorno
    // --------------------------------------------

}
