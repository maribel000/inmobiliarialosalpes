/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name="USUARIOS")
public class Usuarios implements Serializable
{
    // -----------------------------------------
    // Atributos
    // -----------------------------------------
    /**
     * ID del usuario
     */
    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USU")
    @SequenceGenerator(name = "SEQ_USU", allocationSize = 1, sequenceName = "usuarios_seq")
    private int idusuario;

    /**
     * Contiene el nombre del usuario
     */
    private String nombre;

    /**
     * Contiene el apellido del usuario
     */
    private String apellido;

    /**
     * Contiene el documento de identificacion del usuario
     */
    private String cc;

    /**
     * Contiene el correo electronico del usuario
     */
    private String email;

    /**
     * lista de todos los inmuebles asociados al usuario
     */
    @OneToMany(mappedBy = "iddueno", cascade = {CascadeType.ALL})
    private List<Inmueble> inmuebles;

    /**
     * login del usuario
     */
    private String logIn;

    /**
     * clave del usuario
     */
    private String password;

    /**
     * lista de todos los usuarios registrados
     */
    private List<Usuarios> usuarios;

    /**
     * tipo del usuario
     */
    @ManyToOne(optional=false)
    private String tipoUsuario;

    /**
     * Lista de transacciones que tiene
     */
    @JoinColumn
    @OneToMany(mappedBy = "idcomprador", cascade = {CascadeType.ALL})
    List<Transacciones> transacciones;

    
    // -----------------------------------------
    // Constructor
    // -----------------------------------------
    /**
     *
     */
    public Usuarios()
    {
        usuarios = new ArrayList<Usuarios>();
        inmuebles = new ArrayList<Inmueble>();
        transacciones = new ArrayList<Transacciones>();
    }

    // -----------------------------------------
    // Metodos
    // -----------------------------------------

    /**
     * agrega un inmueble a la lista de comprados
     */
    public void agregarInmueble( Inmueble nuevo )
    {
        inmuebles.add(nuevo);
    }

    // -----------------------------------------
    // Metodos Getters and Setters
    // -----------------------------------------

    /**
     * modifica el apellido
     * @return apellido
     */
    public String getApellido()
    {
        return apellido;
    }

    /**
     * modifica el apellido actual
     * @param apellido
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    /**
     * modifica el correoElectronico
     * @return correoElectronico
     */
    public String getCorreoElectronico()
    {
        return email;
    }

    /**
     * modifica el correoElectronico actual
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico)
    {
        this.email = correoElectronico;
    }

    /**
     * modifica el documentoIdentificacion
     * @return documentoIdentificacion
     */
    public String getDocumentoIdentificacion()
    {
        return cc;
    }

    /**
     * modifica el documentoIdentificacion actual
     * @param documentoIdentificacion
     */
    public void setDocumentoIdentificacion(String documentoIdentificacion)
    {
        this.cc = documentoIdentificacion;
    }

    /**
     * modifica el nombre
     * @return nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * modifica el nombre actual
     * @param nombre
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
