/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ PersistenceServicesMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Muebles los Alpes
 * Autor: Camilo Alvarez
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.persistence;

import com.losalpes.entities.Inmueble;
import com.losalpes.entities.Transacciones;
import com.losalpes.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Persistence;

/**
 * Implementación de los servicios de persistencia que se le prestan al sistema.
 * @author Daniel Palacios
 */
@Stateless
public class PersistenceServices implements IPersistenceServices {

    // -----------------------------------------------
    // Atributos
    // -----------------------------------------------

    @PersistenceUnit
    private EntityManagerFactory emf;

    /**
     * atributo de la persistencia
     */
    @PersistenceContext
    private EntityManager em;

    // -----------------------------------------------
    // Constructor
    // -----------------------------------------------
    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public PersistenceServices() {
        emf = Persistence.createEntityManagerFactory("InmueblesLA-ejbPU");
        em = emf.createEntityManager();
    }

    // -----------------------------------------------
    // Métodos
    // -----------------------------------------------
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(Object obj)throws Exception{
        em.merge(obj);
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(Object obj)throws Exception{
        em.remove(em.merge(obj));
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c. Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list. Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    public List findAll(Class c) {
        return em.createQuery("select O from " + c.getSimpleName() + " as O").getResultList();
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c. Clase de la instancia que se quiere buscar.
     * @param id. Identificador unico del objeto.
     * @return obj. Resultado de la consulta.
     */
    public Object findById(Class c, Object id) {
        return em.find(c, id);
    }

    public void update(Object obj) {
        em.merge(obj);
    }

    // --------------------------
    // Persistencia BD
    // --------------------------

    /**
     * Guarda un nuevo ICliente en la BD
     * @param cliente
     */
    public void persistirNuevoCliente(Usuario c)
    {
        String nombre = c.getNombre();
        String apellido = c.getApellido();
        String cedula = c.getDocumentoIdentificacion();
        String email = c.getCorreoElectronico();
        String logIn = c.getLogIn();
        String pass = c.getPassword();
        String tipoUsuario = c.getTipoUsuario();

        em.createQuery("INSERT INTO USUARIOS(nombre, apellido, cedula, email, logIn, tipoUsuario) " +
                "VALUES('"+nombre+"','"+apellido+"','"+cedula+"','"+email+"','"+logIn+"','"+pass+"','"+tipoUsuario+"')");
    }

    /**
     * Guarda un nuevo IInmueble en la BD
     * @param nuevo
     */
    public void persistirNuevoInmueble( Inmueble nuevo )
    {
         int referencia = nuevo.getidInmueble();
         String nombre = nuevo.getNombre();
         String descripcion = nuevo.getDescripcion();
         String tipo = nuevo.getTipo();
         int idVendedor = nuevo.getIdvendedor();


         em.createQuery("INSERT INTO INMUEBLE(idinmueble, nombre, descripcion, tipo, logInVendedor) " +
                    "VALUES('"+referencia+"','"+nombre+"','"+descripcion+"','"+tipo+"','"+idVendedor+"')");
    }

    /**
     * persiste una nueva transaccion
     * @param nueva
     */
    public void persistirNuevaTransaccion(Transacciones nueva)
    {
        String estado = nueva.getEstado();
        int idcomprador = nueva.getIdcomprador().getIdusuario();
        int idinmueble = nueva.getIdinmueble().getIdInmueble();
        int idtransaccion = nueva.getIdtransaccion();

        em.createQuery("INSERT INTO TRANSACCION(estado, idcomprador, idinmueble, idtransaccion) " +
                    "VALUES('"+estado+"','"+idcomprador+"','"+idinmueble+"','"+idtransaccion+"')");
    }

    /**
     * busca los inmuebles que tengan por id el del cliente c
     * @param c
     */
    public List consultarInmueblesAsociadosClienteVendedor ( Usuario c )
    {
        int id = c.getIdusuario();
        List temp = new ArrayList( );
        String query = "Select K From INMUEBLE Where losInVendedor = '"+id+"' AS K";

        temp = em.createQuery(query).getResultList();
        return temp;
    }

        /**
     * busca los inmuebles que tengan por id el del cliente c
     * @param c
     */
    public List consultarInmueblesAsociadosClienteComprador ( Usuario c )
    {
        int id = c.getIdusuario();
        List temp = new ArrayList( );
        String query = "Select K From INMUEBLE Where idComprador = '"+id+"' AS K";

        temp = em.createQuery(query).getResultList();
        return temp;
    }

    /**
     * retorna todos los clientes
     * @param idCliente
     * @return
     */
    public List darCliente ( int idCliente )
    {
        List temp = new ArrayList( );

        String query = "Select K From USUARIOS Where idusuario = '"+idCliente+"' AS K";
        temp = em.createQuery(query).getResultList();

        return temp;
    }

    /**
     * Retorna los inmuebles dado un tipo
     */
    public List darInmueblesPorTipo( int tipo )
    {
        List temp = new ArrayList( );

        String query = "Select K From INMUEBLE Where tipo = '"+tipo+"' AS K";
        temp = em.createQuery(query).getResultList();

        return temp;
    }

    /**
     * registra un inmueble a un comprador
     */
    public void registrarInmuebleComprador(int logInComprador)
    {
         em.createQuery("INSERT INTO INMUEBLE(idComprador) " +
                    "VALUES('"+logInComprador+"')");
    }

}