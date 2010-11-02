/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ PersistenceServices.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Muebles los Alpes
 * Autor: Camilo Alvarez
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementación de los servicios de persistencia que se le prestan al sistema.
 * @author Daniel Palacios
 */
@Stateless
public class PersistenceServices implements IPersistenceServices {

    // -----------------------------------------------
    // Atributos
    // -----------------------------------------------

    /**
     * Instancia del entity manager provista por el contenedor.
     */
    @PersistenceContext
    private EntityManager em;

    // -----------------------------------------------
    // Constructor
    // -----------------------------------------------

    /**
     * Constructor de la clase.
     */
    public PersistenceServices() {
    }

    public void create(Object obj) {
        em.persist(obj);
    }

    public void update(Object obj) {
        em.merge(obj);
    }

    public void delete(Object obj) {
        em.remove(em.merge(obj));
    }

    public List findAll(Class c) {
        return em.createQuery("select O from " + c.getSimpleName() + " as O").getResultList();
    }

    public Object findById(Class c, Object id) {
        return em.find(c, id);
    }
}
