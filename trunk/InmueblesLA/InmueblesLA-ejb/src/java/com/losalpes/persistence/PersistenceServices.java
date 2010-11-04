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
import com.losalpes.mundo.IInmueble;
import com.losalpes.mundo.Vendedor;
import java.util.ArrayList;
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
     * cedula
     * tipoDocumento
     * telefonoResidencia
     * telefonoCelular
     * ciudadResidencia
     * direccion
     * pais
     * profesion
     * email
     * TABLA PARA INMUEBLES_COMPRADOS ó INMUEBLES_INSCRITOS ó INMUEBLES_REGISTRADOS
     * TABLA PARA INMUEBLES_BUSCADOS
     * logIn
     * password
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
            String cedula = c.getDocumentoIdentificacion();
            String tipoDocumento = c.getTipoDocumento();
            String telefonoResidencia = c.getTelefonoResidencia();
            String telefonoCelular = c.getTelefonoCelular();
            String ciudadResidencia = c.getCiudadResidencia();
            String direccion = c.getDireccion();
            String pais = c.getPais();
            String profesion = c.getProfesion();
            String email = c.getCorreoElectronico();
            String logIn = c.getLogIn();

            em.createQuery("INSERT INTO Usuarios(nombre, apellido, cedula, tipoDocumento, telefonoResidencia, TelefonoCelular, " +
                    "ciudadResidencia, direccion, pais, profesion, email, logIn) " +
                    "VALUES("+nombre+","+apellido+","+cedula+","+tipoDocumento+","+telefonoResidencia+","+telefonoCelular+","
                    +ciudadResidencia+","+direccion+","+pais+","+profesion+","+email+","+logIn+")");
        }

        else if (tipo.equals("Vendedor"))
        {
            Vendedor c = (Vendedor) cliente;
            String nombre = c.getNombre();
            String apellido = c.getApellido();
            //String cedula = c.getDocumentoIdentificacion();
            String tipoDocumento = c.getTipoDocumento();
            String telefonoResidencia = c.getTelefonoResidencia();
            String telefonoCelular = c.getTelefonoCelular();
            String ciudadResidencia = c.getCiudadResidencia();
            String direccion = c.getDireccion();
            String pais = c.getPais();
            String profesion = c.getProfesion();
            String email = c.getCorreoElectronico();
            String logIn = c.getLogIn();

            /*em.createQuery("INSERT INTO Clientes(nombre, apellido, cedula, tipoDocumento, telefonoResidencia, TelefonoCelular, " +
                    "ciudadResidencia, direccion, pais, profesion, email, logIn) " +
                    "VALUES("+nombre+","+apellido+","+cedula+","+tipoDocumento+","+telefonoResidencia+","+telefonoCelular+","
                    +ciudadResidencia+","+direccion+","+pais+","+profesion+","+email+","+logIn+")");
             */
        }

        else if (tipo.equals("Administrador"))
        {
            Administrador c = (Administrador) cliente;
            String logIn = c.getLogIn();

            em.createQuery("INSERT INTO Clientes(logIn) " +
                    "VALUES("+logIn+")");
        }
    }

    /**
     * Tabla Inmuebles
     * id
     * nombre
     * descripcion
     * interiorExterior
     * alto
     * ancho
     * profundidad
     * color
     * peso
     * tipo
     */

    /**
     * Guarda un nuevo IInmueble en la BD
     * @param nuevo
     */
    public void persistirNuevoInmueble( IInmueble nuevo )
    {
         //String referencia = nuevo.getidInmueble();
         String nombre = nuevo.getNombre();
         String descripcion = nuevo.getDescripcion();
         boolean interiorExterior = nuevo.isInteriorExterior();
         int alto = nuevo.getAlto();
         int ancho = nuevo.getAncho();
         int profundidad = nuevo.getProfundidad();
         String color = nuevo.getColor();
         int peso = nuevo.getPeso();
         String tipo = nuevo.getTipoInmueble();

         /*
         em.createQuery("INSERT INTO Inmueble(idinmueble, nombre, descripcion, interiorExterior, alto, ancho, " +
                    "profundidad, color, peso, tipo) " +
                    "VALUES("+referencia+","+nombre+","+descripcion+","+interiorExterior+","+alto+","+ancho+","
                    +profundidad+","+color+","+peso+","+tipo+")");
                    */
    }

    /**
     * busca los inmuebles que tengan por id el del cliente c
     * @param c
     */
    public List consultarInmueblesAsociadosCliente ( ICliente c )
    {
        int id = c.getIdcliente();
        List temp = new ArrayList( );
        String query = "Select * From Inmueble Where idcliente = '"+id+"'";

        temp = em.createQuery(query).getResultList();
        return temp;

    }
}
