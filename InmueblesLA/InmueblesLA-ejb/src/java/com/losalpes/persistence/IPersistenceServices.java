/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.persistence;

import com.losalpes.entities.Inmueble;
import com.losalpes.entities.Transacciones;
import com.losalpes.entities.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author DANIEL
 */
@Remote
public interface IPersistenceServices {

    // -----------------------------------------------
    // Métodos
    // -----------------------------------------------
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(Object obj)throws Exception;

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(Object obj)throws Exception;

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c. Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list. Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    public List findAll(Class c);

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c. Clase de la instancia que se quiere buscar.
     * @param id. Identificador unico del objeto.
     * @return obj. Resultado de la consulta.
     */
    public Object findById(Class c, Object id);

    public void update(Object obj);

    // --------------------------
    // Persistencia BD
    // --------------------------

    /**
     * Guarda un nuevo ICliente en la BD
     * @param cliente
     */
    public void persistirNuevoCliente(Usuario c);

    /**
     * Guarda un nuevo IInmueble en la BD
     * @param nuevo
     */
    public void persistirNuevoInmueble( Inmueble nuevo );

    /**
     * persiste una nueva transaccion
     * @param nueva
     */
    public void persistirNuevaTransaccion(Transacciones nueva);
    /**
     * busca los inmuebles que tengan por id el del cliente c
     * @param c
     */
    public List consultarInmueblesAsociadosClienteVendedor ( Usuario c );
    /**
     * busca los inmuebles que tengan por id el del cliente c
     * @param c
     */
    public List consultarInmueblesAsociadosClienteComprador ( Usuario c );
    /**
     * retorna todos los clientes
     * @param idCliente
     * @return
     */
    public List darCliente ( int idCliente );
    /**
     * Retorna los inmuebles dado un tipo
     */
    public List<Inmueble> darInmueblesPorTipo( int tipo );
    /**
     * registra un inmueble a un comprador
     */
    public void registrarInmuebleComprador(int idcomprador, int idinmueble);
    public void createQuery7(String string, Usuario i);
    public void createQuery6(String string, Inmueble i);
    public void createQuery5(String string, Transacciones t);
    public List<Inmueble> createQuery4 (String s, int idvendedor);
    public List<Inmueble> createQuery3 (String s, int idcomprador);
    public List<Usuario> createQuery2(String query, int idCliente);
    public List<Inmueble> createQuery1(String string, int tipo);
    public void createQuery0(String string, int idcomprador, int idinmueble);
    public List<Inmueble> createQuery(String query, int idinmueble);

    public void llenardatos(int a);

    // -----------
    // Exp 3
    // -----------
    /**
     * crea un inmueble nuevo
     * @param descripcion
     * @param iddueno
     * @param idvendedor
     * @param nombre
     * @param tipo
     * @return
     */
    public boolean crearInmueble (String descripcion,int iddueno,int idvendedor,String nombre,String tipo);

    /**
     * crea un nuevo usuario
     * @param idUsuario
     * @param apellido
     * @param cc
     * @param correoElectronico
     * @param documentoIdentificacion
     * @param email
     * @param logIn
     * @param nombre
     * @param password
     * @param tipoUsuario
     * @return
     */
    public boolean crearUsuario (String apellido,String cc,String correoElectronico,String documentoIdentificacion,String email,String logIn,String nombre,String password,String tipoUsuario);

}
