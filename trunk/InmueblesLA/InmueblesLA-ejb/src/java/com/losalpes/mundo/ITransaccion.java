/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.mundo;

/**
 *
 * @author DANIEL
 */
public interface ITransaccion
{

    // ------------------------
    // Getter + setters
    // ------------------------

    public String getEstado();

    public void setEstado(String estado);

    public int getIdcomprador();

    public void setIdcomprador(int idcomprador);

    public int getIdinmueble();

    public void setIdinmueble(int idinmueble);

    public int getIdtransaccion() ;

    public void setIdtransaccion(int idtransaccion);
}
