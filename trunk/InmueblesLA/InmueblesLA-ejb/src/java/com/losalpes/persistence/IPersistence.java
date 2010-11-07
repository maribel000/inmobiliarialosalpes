/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.persistence;

import javax.ejb.Local;

/**
 *
 * @author DANIEL
 */
@Local
public interface IPersistence {

    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(java.lang.Object obj)throws Exception;

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    public void update(java.lang.Object obj);

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(java.lang.Object obj)throws Exception;

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c. Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list. Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    public java.util.List findAll(java.lang.Class c);

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c. Clase de la instancia que se quiere buscar.
     * @param id. Identificador unico del objeto.
     * @return obj. Resultado de la consulta.
     */
    public java.lang.Object findById(java.lang.Class c, java.lang.Object id);

}
