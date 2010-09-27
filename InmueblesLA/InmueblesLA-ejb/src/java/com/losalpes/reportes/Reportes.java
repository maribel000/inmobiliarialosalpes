/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import com.losalpes.mundo.Inmueble;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author andres
 */
@Remote
public interface Reportes {

    public Inmueble generarReporteInmueble(java.lang.String id);

    public ArrayList generarReporteParametro(java.lang.String parametro);
    
}
