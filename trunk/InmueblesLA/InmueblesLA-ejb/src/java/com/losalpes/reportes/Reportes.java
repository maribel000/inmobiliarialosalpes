/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import javax.ejb.Remote;

/**
 *
 * @author andres
 */
@Remote
public interface Reportes {

    public java.lang.String generarReporteInmueble(java.lang.String id);
    
}
