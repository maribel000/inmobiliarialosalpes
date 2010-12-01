/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.webservices;

import com.losalpes.entities.Inmueble;
import com.losalpes.entities.Transacciones;
import com.losalpes.entities.Usuario;
import com.losalpes.persistence.IPersistenceServices;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author andres
 */
@WebService()
@Stateless()
public class CrearInmueble {
    @EJB
    private IPersistenceServices ejbRef;
    // Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"
    
    @WebMethod(operationName = "crearInmueble")
    public boolean crearInmueble(@WebParam(name = "descripcion")
    String descripcion, @WebParam(name = "idInmueble")
    int idInmueble, @WebParam(name = "iddueno")
    int iddueno, @WebParam(name = "idvendedor")
    int idvendedor, @WebParam(name = "nombre")
    String nombre, @WebParam(name = "tipo")
    String tipo) {
        return ejbRef.crearInmueble(descripcion, idInmueble, iddueno, idvendedor, nombre, tipo);
    }

    @WebMethod(operationName = "crearUsuario")
    public boolean crearUsuario(@WebParam(name = "idUsuario")
    int idUsuario, @WebParam(name = "apellido")
    String apellido, @WebParam(name = "cc")
    String cc, @WebParam(name = "correoElectronico")
    String correoElectronico, @WebParam(name = "documentoIdentificacion")
    String documentoIdentificacion, @WebParam(name = "email")
    String email, @WebParam(name = "idusuario")
    int idusuario, @WebParam(name = "logIn")
    String logIn, @WebParam(name = "nombre")
    String nombre, @WebParam(name = "password")
    String password, @WebParam(name = "tipoUsuario")
    String tipoUsuario) {
        return ejbRef.crearUsuario(idUsuario, apellido, cc, correoElectronico, documentoIdentificacion, email, idusuario, logIn, nombre, password, tipoUsuario);
    }

}
