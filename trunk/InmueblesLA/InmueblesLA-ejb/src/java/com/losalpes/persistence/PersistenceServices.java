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

import com.losalpes.mundo.Administrador;
import com.losalpes.mundo.Cliente;
import com.losalpes.mundo.ICliente;
import com.losalpes.mundo.Vendedor;
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

    // --------------------------
    // Persistencia BD
    // --------------------------

    /**
     * Tabla Clientes
     * nombre
     * apellido
     * documentoIdentificacion
     * tipoDocumento
     * telefonoResidencia
     * telefonoCelular
     * ciudadResidencia
     * direccion
     * pais
     * profesion
     * correoElectronico
     * TABLA PARA INMUEBLES_COMPRADOS ó INMUEBLES_INSCRITOS ó INMUEBLES_REGISTRADOS
     * TABLA PARA INMUEBLES_BUSCADOS
     * logIn
     */

    /**
     * Guarda un nuevo ICliente en la BD
     * @param cliente
     */
    public void persistirNuevoCliente(ICliente cliente)
    {
        String tipo = cliente.darTipoCliente();
        if (tipo.equals("Cliente"))
        {
            Cliente c = (Cliente) cliente;
            String nombre = c.getNombre();
            String apellido = c.getApellido();
            String documentoIdentificacion = c.getDocumentoIdentificacion();
            String tipoDocumento = c.getTipoDocumento();
            String telefonoResidencia = c.getTelefonoResidencia();
            String telefonoCelular = c.getTelefonoCelular();
            String ciudadResidencia = c.getCiudadResidencia();
            String direccion = c.getDireccion();
            String pais = c.getPais();
            String profesion = c.getProfesion();
            String correoElectronico = c.getCorreoElectronico();
            String logIn = c.getLogIn();

            em.createQuery("INSERT INTO Clientes(nombre, apellido, documentoIdentificacion, tipoDocumento, telefonoResidencia, TelefonoCelular, " +
                    "ciudadResidencia, direccion, pais, profesion, correoElectronico, logIn) " +
                    "VALUES("+nombre+","+apellido+","+documentoIdentificacion+","+tipoDocumento+","+telefonoResidencia+","+telefonoCelular+","
                    +ciudadResidencia+","+direccion+","+pais+","+profesion+","+correoElectronico+","+logIn+")");
        }

        else if (tipo.equals("Vendedor"))
        {
            Vendedor c = (Vendedor) cliente;
            String nombre = c.getNombre();
            String apellido = c.getApellido();
            String documentoIdentificacion = c.getDocumentoIdentificacion();
            String tipoDocumento = c.getTipoDocumento();
            String telefonoResidencia = c.getTelefonoResidencia();
            String telefonoCelular = c.getTelefonoCelular();
            String ciudadResidencia = c.getCiudadResidencia();
            String direccion = c.getDireccion();
            String pais = c.getPais();
            String profesion = c.getProfesion();
            String correoElectronico = c.getCorreoElectronico();
            String logIn = c.getLogIn();

            em.createQuery("INSERT INTO Clientes(nombre, apellido, documentoIdentificacion, tipoDocumento, telefonoResidencia, TelefonoCelular, " +
                    "ciudadResidencia, direccion, pais, profesion, correoElectronico, logIn) " +
                    "VALUES("+nombre+","+apellido+","+documentoIdentificacion+","+tipoDocumento+","+telefonoResidencia+","+telefonoCelular+","
                    +ciudadResidencia+","+direccion+","+pais+","+profesion+","+correoElectronico+","+logIn+")");
        }

        else if (tipo.equals("Administrador"))
        {
            Administrador c = (Administrador) cliente;
            String logIn = c.getLogIn();

            em.createQuery("INSERT INTO Clientes(logIn) " +
                    "VALUES("+logIn+")");
        }
    }
}
