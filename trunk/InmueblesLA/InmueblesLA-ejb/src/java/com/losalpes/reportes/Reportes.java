/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import com.losalpes.mundo.Inmueble;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 * Esta es la interfaz del bean que genera reportes. por el momento
 * solo hay reportes de inmuebles
 * @author andres
 */
@Remote
public interface Reportes {

    public Inmueble generarReporteInmueble(java.lang.String id);

    public ArrayList generarReporteParametro(java.lang.String parametro);
    
}
