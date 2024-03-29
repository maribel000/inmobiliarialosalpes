/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ PersistenceServicesMock.java
 * Universidad de los Andes (Bogot√° - Colombia)
 * Departamento de Ingenier√≠a de Sistemas y Computaci√≥n
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
import com.losalpes.reportes.P;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Persistence;

/**
 * Implementaci√≥n de los servicios de persistencia que se le prestan al sistema.
 * @author Daniel Palacios
 */
@Stateless
@DeclareRoles({"administrador", "vendedor", "cliente"})
public class PersistenceServices implements IPersistenceServices {
    // -----------------------------------------------
    // Constantes
    // -----------------------------------------------
    /**
     * constante para un apartamento
     */
    public final static int APARTAMENTO = 1;
    /**
     * constante para una casa
     */
    public final static int CASA = 2;

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
        inmuebles = new ArrayList<Inmueble>();
        usuarios = new ArrayList<Usuario>();
        transacciones = new ArrayList<Transacciones>();
        p = new P(this);
        llenardatos(32);
    }

    // -----------------------------------------------
    // M√©todos
    // -----------------------------------------------
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(Object obj) throws Exception {
        em.merge(obj);
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj. Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(Object obj) throws Exception {
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
    public void persistirNuevoCliente(Usuario c) {
        String nombre = c.getNombre();
        String apellido = c.getApellido();
        String cedula = c.getDocumentoIdentificacion();
        String email = c.getCorreoElectronico();
        String logIn = c.getLogIn();
        String pass = c.getPassword();
        String tipoUsuario = c.getTipoUsuario();

        createQuery7("INSERT INTO USUARIOS(nombre, apellido, cedula, email, logIn, tipoUsuario) " +
                "VALUES('" + nombre + "','" + apellido + "','" + cedula + "','" + email + "','" + logIn + "','" + pass + "','" + tipoUsuario + "')", c);
    }

    /**
     * Guarda un nuevo IInmueble en la BD
     * @param nuevo
     */
    @RolesAllowed ({"administrador"})
    public void persistirNuevoInmueble(Inmueble nuevo) {
        int referencia = nuevo.getIdInmueble();
        String nombre = nuevo.getNombre();
        String descripcion = nuevo.getDescripcion();
        int tipo = nuevo.getTipo();
        int idVendedor = nuevo.getIdvendedor();
        Inmueble i = new Inmueble(referencia, nombre, "", tipo);
        i.setIdvendedor(idVendedor);

        createQuery6("INSERT INTO INMUEBLE(idinmueble, nombre, descripcion, tipo, logInVendedor) " +
                "VALUES('" + referencia + "','" + nombre + "','" + descripcion + "','" + tipo + "','" + idVendedor + "')", i);
    }

    /**
     * persiste una nueva transaccion
     * @param nueva
     */
    @RolesAllowed ({"vendedor"})
    public void persistirNuevaTransaccion(Transacciones nueva) {
        String estado = nueva.getEstado();
        int idcomprador = nueva.getIdcomprador().getIdusuario();
        int idinmueble = nueva.getIdinmueble().getIdInmueble();
        int idtransaccion = nueva.getIdtransaccion();

        Transacciones t = new Transacciones();
        List<Usuario> l = createQuery2("", idcomprador);
        Usuario u = l.get(0);
        List<Inmueble> in = createQuery("", idinmueble);
        Inmueble i = in.get(0);
        t.setIdcomprador(u);
        t.setEstado(estado);
        t.setIdinmueble(i);
        t.setIdtransaccion(idtransaccion);

        createQuery5("INSERT INTO TRANSACCION(estado, idcomprador, idinmueble, idtransaccion) " +
                "VALUES('" + estado + "','" + idcomprador + "','" + idinmueble + "','" + idtransaccion + "')", t);
    }

    /**
     * busca los inmuebles que tengan por id el del cliente c
     * @param c
     */
    @RolesAllowed ({"administrador"})
    public List consultarInmueblesAsociadosClienteVendedor(Usuario c) {
        int id = c.getIdusuario();
        List temp = new ArrayList();
        String query = "Select K From INMUEBLE Where losInVendedor=" + id + " AS K";

        return createQuery4(query, id);
    }

    /**
     * busca los inmuebles que tengan por id el del cliente c
     * @param c
     */
    @RolesAllowed ({"vendedor"})
    public List consultarInmueblesAsociadosClienteComprador(Usuario c) {
        int id = c.getIdusuario();
        List temp = new ArrayList();
        String query = "Select K From INMUEBLE Where idComprador=" + id + " AS K";
        return createQuery3(query, id);
    }

    /**
     * retorna todos los clientes
     * @param idCliente
     * @return
     */
    @RolesAllowed ({"administrador", "cliente"})
    public List darCliente(int idCliente) {
        String query = "Select K From USUARIOS Where idusuario=" + idCliente + " AS K";
        return createQuery2(query, idCliente);
    }



    /**
     * registra un inmueble a un comprador
     */
    @RolesAllowed ({"vendedor"})
    public void registrarInmuebleComprador(int idcomprador, int idinmueble) {
        createQuery0("INSERT INTO INMUEBLE(idComprador) " +
                "VALUES('" + idcomprador + "')", idcomprador, idinmueble);
    }

    public void createQuery7(String string, Usuario i) {
        usuarios.add(i);
                try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void createQuery6(String string, Inmueble i) {
        inmuebles.add(i);
                try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void createQuery5(String string, Transacciones t) {
        transacciones.add(t);
                try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public List<Inmueble> createQuery4(String s, int idvendedor) {
        List temp = new ArrayList();
        for (int i = 0; i < inmuebles.size(); i++) {
            Inmueble in = inmuebles.get(i);
            if (in.getIdvendedor() == idvendedor) {
                temp.add(in);
            }
        }
                try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public List<Inmueble> createQuery3(String s, int idcomprador) {
        List temp = new ArrayList();
        for (int i = 0; i < inmuebles.size(); i++) {
            Inmueble in = inmuebles.get(i);
            if (in.getIdcomprador() == idcomprador) {
                temp.add(in);
            }
        }
                try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public List<Usuario> createQuery2(String query, int idCliente) {
        List<Usuario> temp = new ArrayList<Usuario>();

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getIdusuario() == idCliente) {
                temp.add(usuario);
                break;
            }
        }
        try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public List<Inmueble> createQuery1(String string, int tipo) {
        List<Inmueble> temp = new ArrayList<Inmueble>();

        for (int i = 0; i < inmuebles.size(); i++) {
            Inmueble inmueble = inmuebles.get(i);

            if (inmueble.getTipo() == tipo) {
                temp.add(inmueble);
            }
        }
        try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public void createQuery0(String string, int idcomprador, int idinmueble) {
        for (int i = 0; i < inmuebles.size(); i++) {
            Inmueble temp = inmuebles.get(i);
            if (temp.getIdcomprador() == -1) {
                inmuebles.remove(temp);
                temp.setIdcomprador(idcomprador);
                inmuebles.add(temp);
            }

        }        try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public List<Inmueble> createQuery(String query, int idinmueble) {
        List<Inmueble> temp = new ArrayList<Inmueble>();

        for (int i = 0; i < inmuebles.size(); i++) {
            Inmueble inmueble = inmuebles.get(i);
            if (inmueble.getIdInmueble() == idinmueble) {
                temp.add(inmueble);
                break;
            }
        }
        try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    private List<Transacciones> transacciones;
    private int id_inmueble;
    private int id_usuario;
    private List<Inmueble> inmuebles;
    private List<Usuario> usuarios;
    private P p;

    public void llenardatos(int a) {
        for (int i = 0; i < a; i++) {
            Usuario usuario = new Usuario();
            usuario.setApellido("usuario apellido" + i);
            usuario.setCc(i + "");
            usuario.setCorreoElectronico("usuario correoElectronico@" + i);
            usuario.setDocumentoIdentificacion(i + "");
            usuario.setEmail("usuario email@" + i);
            usuario.setIdusuario(i);
            usuario.setLogIn("logIn" + i);
            usuario.setNombre("usuario nombre" + i);
            usuario.setPassword("asdf");
            if (i == 0) {
                usuario.setTipoUsuario("Administrador");
            } else if (i % 2 == 0) {
                usuario.setTipoUsuario("Vendedor");
            } else {
                usuario.setTipoUsuario("Cliente");
            }

            usuarios.add(usuario);

            Inmueble inmueble = new Inmueble();
            inmueble.setDescripcion("inmueble descripcion" + i);
            inmueble.setIdInmueble(i);
            inmueble.setIddueno(usuario);
            inmueble.setIdvendedor(i);
            inmueble.setNombre("inmueble nombre");
            if (i % 2 == 0) {
                inmueble.setTipo(APARTAMENTO );
            } else {
                inmueble.setTipo(CASA);
            }
            inmueble.setIdInmueble(i);

            inmuebles.add(inmueble);

            Transacciones t = new Transacciones();
            if (i % 3 == 0) {
                t.setEstado("Pendiente");
            } else {
                t.setEstado("Finalizada");
            }
            t.setIdcomprador(usuario);
            t.setIdinmueble(inmueble);
            t.setIdtransaccion(i);

            transacciones.add(t);
            id_inmueble = i;
            id_usuario = i;
        }
        id_inmueble++;
        id_usuario++;
    }


    // -----------
    // Exp 3
    // -----------
    /**
     * Crea un nuevo inmueble
     */
    public boolean crearInmueble (String descripcion,int iddueno,int idvendedor,String nombre,int tipo)
    {
        boolean registrado = false;
        Inmueble nuevo = new Inmueble( );
        nuevo.setDescripcion(descripcion);
        nuevo.setIdInmueble(id_inmueble);
        Usuario usuario = buscarDuenio( iddueno );
        nuevo.setIddueno(usuario);
        nuevo.setIdvendedor(idvendedor);
        nuevo.setNombre(nombre);
        nuevo.setTipo(tipo);
        registrado = true;
        inmuebles.add(nuevo);
        id_inmueble++;
                try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return registrado;
    }

    /**
     * Crea un nuevo usuario
     */
    public boolean crearUsuario (String apellido,String cc,String correoElectronico,String documentoIdentificacion,String email,String logIn,String nombre,String password,String tipoUsuario)
    {
        boolean registrado = false;
        Usuario nuevo = new Usuario();

        if( !existeUsuarioLOGIN(logIn))
        {
            nuevo.setApellido(apellido);
            nuevo.setCc(cc);
            nuevo.setCorreoElectronico(correoElectronico);
            nuevo.setDocumentoIdentificacion(documentoIdentificacion);
            nuevo.setEmail(email);
            nuevo.setIdusuario(id_usuario);
            nuevo.setLogIn(logIn);
            nuevo.setNombre(nombre);
            nuevo.setPassword(password);
            nuevo.setTipoUsuario(tipoUsuario);
            usuarios.add(nuevo);
            registrado = true;
            id_usuario++;
        }
                try {
            p.generarReporte();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return registrado;
    }

    private Usuario buscarDuenio(int iddueno)
    {
        Usuario usuario = null;
        for (int i = 0; i < usuarios.size() && usuario == null; i++)
        {
            Usuario temp = usuarios.get(i);
            if ( iddueno == temp.getIdusuario() )
            {
                usuario = temp;
            }

        }
        return usuario;
    }

    /**
     * verifica si existe un inmueble
     * @param idInmueble
     * @return
     */
    private boolean existeInmueble(int idInmueble)
    {
        boolean si = false;
        for (int i = 0; i < inmuebles.size() && !si; i++)
        {
            Inmueble temp = inmuebles.get(i);
            if (temp.getIdInmueble() == idInmueble)
            {
                si = true;
            }
        }
        return si;
    }

    /**
     * verifica si existe un usuario
     * @param idUsuario
     * @return
     */
    private boolean existeUsuarioID(int idUsuario)
    {
        boolean si = false;
        for (int i = 0; i < usuarios.size() && !si; i++)
        {
            Usuario temp = usuarios.get(i);
            if (temp.getIdusuario() == idUsuario)
            {
                si = true;
            }
        }
        return si;
    }

    private boolean existeUsuarioLOGIN(String logIn)
    {
        boolean si = false;
        for (int i = 0; i < usuarios.size() && !si; i++)
        {
            Usuario temp = usuarios.get(i);
            if (temp.getLogIn().equalsIgnoreCase(logIn))
            {
                si = true;
            }
        }
        return si;
    }

        /**
     * Retorna los inmuebles dado un tipo
     */

    public List<Inmueble> darInmueblesPorTipo(int tipo) {
        return createQuery1("Select K From INMUEBLE Where TIPO=" + tipo + " AS K", tipo);
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setIdusuario(int id)
    {
        id_usuario = id;
    }

    public void setIdinmueble(int id)
    {
        id_inmueble = id;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    

}